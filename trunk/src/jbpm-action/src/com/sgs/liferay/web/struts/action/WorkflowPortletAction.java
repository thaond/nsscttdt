/**
 * 
 */
package com.sgs.liferay.web.struts.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.liferay.jbpm.command.CommandResultProcessor;
import com.sgs.liferay.jbpm.command.LiferayWorkflowCommand;
import com.sgs.liferay.jbpm.command.StrutsActionCommandResultProcessor;
import com.sgs.liferay.jbpm.component.StrutsTaskAction;
import com.sgs.liferay.jbpm.component.TaskAction;
import com.sgs.liferay.jbpm.factory.CommandResultProcessorFactory;
import com.sgs.liferay.jbpm.factory.WorkflowCommandSimpleFactory;
import com.sgs.liferay.jbpm.invoker.WorkflowInvoker;
import com.sgs.liferay.jbpm.param.WorkflowParam;
import com.sgs.liferay.jbpm.service.LiferayWorkflowService;
import com.sgs.liferay.jbpm.util.Constants;
import com.sgs.liferay.web.struts.support.TaskNameDispatcher;

/**
 * @author hieuvh
 * 
 */
public abstract class WorkflowPortletAction extends PortletAction {
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.liferay.portal.struts.PortletAction#processAction(org.apache.struts
	 * .action.ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.portlet.PortletConfig, javax.portlet.ActionRequest,
	 * javax.portlet.ActionResponse)
	 */
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		boolean jbpmAction = ParamUtil.getBoolean(actionRequest,
				Constants.WORKFLOW_ACTION, false);
		
		processStrutsAction(mapping, form, portletConfig, actionRequest,
				actionResponse);
		if (jbpmAction) {
			processWorkflowAction(mapping, form, portletConfig, actionRequest,
					actionResponse);
		}
	}

	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param portletConfig
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */

	public abstract void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception;
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param portletConfig
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void processWorkflowAction(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		String workflowActionName = ParamUtil.getString(actionRequest,
				Constants.WORKFLOW_ACTION_NAME, null);
		if (workflowActionName == null) {
			return;
		}

		//create LiferayWorkflowCommand form properties file
		LiferayWorkflowCommand command = (LiferayWorkflowCommand) WorkflowCommandSimpleFactory.getInstance()
				.createWorkflowCommand(workflowActionName);
		
		// exit workflow process if no command object created
		if (command == null) {
			return;
		}
		
		//set concrete LiferayWorkflowService into LiferayWorkflowCommand
		command.setLiferayWorkflowService(getLiferayWorkflowService());
		
		//set concrete WorkflowParameters into LiferayWorkflowCommand
		command.setWorkflowParams(getWorkflowParameters(actionRequest, actionResponse));
		
		//create a WorkflowInvoker 
		WorkflowInvoker invoker = WorkflowInvoker.getInstance();
		
		//set LiferayWorkflowCommand into WorkflowInvoker 
		invoker.setWorkflowCommand(command);
		Object result = invoker.invoke();
		
		// process result of command
		if (result != null) {
			CommandResultProcessor processor = CommandResultProcessorFactory.getInstance().createCommandResultProcessor(command);
			
			if (processor != null) {
				((StrutsActionCommandResultProcessor) processor).setRequestResponse(actionRequest, actionResponse);
				processor.processResult(result);
			}
		}
	}
	
	
	
	/**
	 * get all parameters with template: "<portlet:namespace/>:wf_{name}:{persistence|transient}"
	 * 
	 * @param actionRequest
	 * @return
	 */
	protected List<WorkflowParam> getWorkflowParameters(ActionRequest actionRequest,
			ActionResponse actionResponse) {
		List<WorkflowParam> results = new ArrayList<WorkflowParam>();
		Enumeration<String> names = actionRequest.getParameterNames();
		
		while (names.hasMoreElements()) {
			
			String name = names.nextElement();
			
			String prefix = Constants.WORKFLOW_PARAM_PREFIX;
			String newName = name;

			if (newName.indexOf(prefix) != -1) {
				newName = newName.substring(prefix.length(), newName.length());
			} else {
				continue;
			}

			String suffix = WorkflowParam.TRANSIENT;
			int suffixIndex = newName.lastIndexOf("_");
			if (suffixIndex != -1) {
				suffix = newName.substring(suffixIndex, newName.length());
				if (WorkflowParam.TRANSIENT.equals(suffix)
						|| WorkflowParam.PERSISTENCE.equals(suffix)) {
					newName = newName.substring(0, suffixIndex);
				} else {
					suffix = WorkflowParam.TRANSIENT;
				}
			}

			results.add(new WorkflowParam(suffix, newName, actionRequest
					.getParameter(name)));
		}
		List<WorkflowParam> workflowParamsFromStrutsProcess = (List)
				actionRequest.getAttribute("workflowParamsFromStrutsProcess");
		
		if (workflowParamsFromStrutsProcess != null) {
			results.addAll(workflowParamsFromStrutsProcess);
		}
		
		return results;
	}

	protected void addWorkflowParameter(PortletRequest req, String name, String transactionType, String value) {
		WorkflowParam param = new WorkflowParam(transactionType, name, value);
		List<WorkflowParam> workflowParamsFromStrutsProcess = (List)
				req.getAttribute("workflowParamsFromStrutsProcess");
		
		if (workflowParamsFromStrutsProcess == null) {
			workflowParamsFromStrutsProcess = new ArrayList<WorkflowParam>();
		}
		
		workflowParamsFromStrutsProcess.add(param);
		req.setAttribute("workflowParamsFromStrutsProcess", workflowParamsFromStrutsProcess);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.liferay.portal.struts.PortletAction#render(org.apache.struts.action
	 * .ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.portlet.PortletConfig, javax.portlet.RenderRequest,
	 * javax.portlet.RenderResponse)
	 */
	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		boolean jbpmRender = ParamUtil.getBoolean(renderRequest,
				Constants.WORKFLOW_RENDER, false);
		
		if (jbpmRender) {
			return renderWorkflow(mapping, form, portletConfig, renderRequest,
					renderResponse);
		}
		return renderStruts(mapping, form, portletConfig, renderRequest,
				renderResponse);
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param portletConfig
	 * @param renderRequest
	 * @param renderResponse
	 * @return
	 * @throws Exception
	 */
	public abstract ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception;
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param portletConfig
	 * @param renderRequest
	 * @param renderResponse
	 * @return
	 * @throws Exception
	 */

	public ActionForward renderWorkflow(ActionMapping mapping, ActionForm form,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {

		long processId = getProcessInstanceId(renderRequest);		
		long taskId = getTaskInstanceId(renderRequest);		
		if (processId == -1 && taskId ==-1) {
			return renderStruts(mapping, form, portletConfig, renderRequest,
					renderResponse);
		}

		// render list task actions
		if (taskId == -1) {
			List<TaskAction> taskActions = getLiferayWorkflowService().getTaskActions(processId);
			List<TaskAction> strutsTaskActions = new ArrayList<TaskAction>();
			
			for (Iterator iterator = taskActions.iterator(); iterator.hasNext();) {
				TaskAction taskAction = (TaskAction) iterator.next();
				StrutsTaskAction strutsTaskAction = new StrutsTaskAction();
				
				strutsTaskAction.setForm(taskAction.getForm());
				strutsTaskAction.setTaskActionName(taskAction.getTaskActionName());
				strutsTaskAction.setTaskInstanceId(taskAction.getTaskInstanceId());
				strutsTaskAction.setTransition(taskAction.getTransition());
				
				String strutsAction = "";
				if (! TaskAction.NONE_FORM.equals(taskAction.getForm())) {
					strutsAction = getTaskNameDispatcher().dispatchToView(taskAction.getForm(), mapping, renderRequest, renderResponse);
				} else {
					strutsAction = getTaskNameDispatcher().dispatchToAction(taskAction.getTaskActionName(), mapping, renderRequest, renderResponse);
				}
				
				strutsTaskAction.setStrutsAction(strutsAction);
				strutsTaskActions.add(strutsTaskAction);
			}

			renderRequest.setAttribute(Constants.WORKFLOW_TASK_ACTIONS, strutsTaskActions);
			System.out.println("0000000000000000000000000000000000000000000000");
			return renderStruts(mapping, form, portletConfig, renderRequest, renderResponse);
		}
		
		// render a task action.
		TaskAction taskAction = getLiferayWorkflowService().getTaskAction(taskId);
		String forwardForm = taskAction.getForm();
		
		String strutsAction = getTaskNameDispatcher().dispatchToAction(forwardForm, mapping, renderRequest, renderResponse);
		
		StrutsTaskAction strutsTaskAction = new StrutsTaskAction();
		strutsTaskAction.setForm(taskAction.getForm());
		strutsTaskAction.setTaskActionName(taskAction.getTaskActionName());
		strutsTaskAction.setTaskInstanceId(taskAction.getTaskInstanceId());
		strutsTaskAction.setTransition(taskAction.getTransition());
		strutsTaskAction.setStrutsAction(strutsAction);
		
		renderRequest.setAttribute(Constants.WORKFLOW_TASK_ACTION, strutsTaskAction);
	
		return renderStruts(mapping, form, portletConfig, renderRequest, renderResponse);
	}

	/**
	 * 
	 * @return
	 */
	protected abstract LiferayWorkflowService getLiferayWorkflowService();

	/**
	 * 
	 * @param renderRequest
	 * @return -1 if don't have a process Instance information in request 
	 */

	protected abstract long getProcessInstanceId(PortletRequest renderRequest);

	/**
	 * 
	 * @param renderRequest
	 * @return -1 if don't have a task Instance information in request
	 */
	protected abstract long getTaskInstanceId(PortletRequest renderRequest);

	/**
	 * Get Dispatcher object. Dispatch a task name into another string. The
	 * result string maybe used to forward.
	 * 
	 * @return
	 */
	protected abstract TaskNameDispatcher getTaskNameDispatcher();

	
}