package com.sgs.portlet.documentprocessmanagement.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.jbpm.graph.def.ProcessDefinition;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.manageworkflow.NoSuchException;
import com.sgs.portlet.document.manageworkflow.PmlManageWorkDocumentFlowCanNotDeleteException;
import com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow;
import com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowLocalServiceUtil;
import com.sgs.portlet.document.manageworkflow.service.persistence.PmlManageWorkDocumentFlowUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentReceiptPortletAction;

public class ViewAction extends DocumentReceiptPortletAction {
	private static Log _log = LogFactory.getLog(DocumentReceiptPortletAction.class);
	protected DocumentReceiptLiferayWorkflowService documentReceiptLWS = new DocumentReceiptLiferayWorkflowService();// yenlt update 26082010
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		// deploy process definition
		String cmd = ParamUtil.getString(req, Constants.CMD);
//		if (!Validator.isNull(cmd)) {
//			addProcessDefinition(req);
//		}
		try {
			if (cmd.equals(Constants.ADD)){
				addProcessDefinition(req);
				
			} else if (cmd.equals(Constants.DELETE)) {
				// YENLT UPDATE 26082010
	//			deleteProcess(req);
				boolean flag = deleteProcess(req);
				if (!flag) {
					throw new PmlManageWorkDocumentFlowCanNotDeleteException();
				}
			}
			if (Validator.isNotNull(cmd)) {
				String redirect = ParamUtil.getString(req, "redirect");

				sendRedirect(req, res, redirect);
			}
			//sendRedirect(req, res);
		} catch (Exception e) {
			if (e instanceof PmlManageWorkDocumentFlowCanNotDeleteException) {
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
		// END 26082010
	}
	
	/**
	 * add process definition into database
	 * @param req
	 * void
	 *
	 */
	private void addProcessDefinition(ActionRequest req) {
		// get param value 
		String nameWorkflow = ParamUtil.getString(req, "nameWorkflow","");
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		File fileWorkflow = uploadRequest.getFile("fileWorkflow");
		int type = ParamUtil.getInteger(req, "type",-1);
		String description = ParamUtil.getString(req, "description","");
		
		try {
			if (fileWorkflow != null) {
				InputStream is = new FileInputStream(fileWorkflow);				
				DocumentReceiptLiferayWorkflowService documentReceiptLiferayWorkflowService = (DocumentReceiptLiferayWorkflowService) getLiferayWorkflowService();
				documentReceiptLiferayWorkflowService.deloyProcessSupport(is, nameWorkflow, type, description);
				req.setAttribute("deloy", "success");
			}
		} catch (Exception e) {
			req.setAttribute("deloy", "fail");
			e.printStackTrace();
		}
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			
			// if have action delete
//			String cmd = ParamUtil.getString(req, "cmd","");
//			if (!Validator.isNull(cmd)) {
//				if (cmd.equals("delete")) deleteProcess(req);
//			}
			
			// prepare data for display in view page
//			List<PmlManageWorkDocumentFlow> pmlManageWorkDocumentFlowList = PmlManageWorkDocumentFlowUtil.findAll();
//			req.setAttribute("pmlManageWorkDocumentFlowList", pmlManageWorkDocumentFlowList);
			
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.sgs.documentprocessmanagement.view");
			}
	}

	/**
	 * delete process definition throw away database
	 * @param req
	 * void
	 *
	 */
	// YENLT UPDATE 26082010
	private boolean deleteProcess(ActionRequest req) {
		boolean flag = true;
		long manageDocumentWorkflowId = ParamUtil.getLong(req, "manageDocumentWorkflowId");
		PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow = null;
		String processName = "";
		int version = 0;
		ProcessDefinition processDefinition = null;
		try {
			pmlManageWorkDocumentFlow = PmlManageWorkDocumentFlowUtil.findByPrimaryKey(manageDocumentWorkflowId);
			processName = pmlManageWorkDocumentFlow.getWorkFlowName();
			version = pmlManageWorkDocumentFlow.getVersion();
		} catch (NoSuchException e) {
			_log.error(e.getMessage());
		} catch (SystemException e) {
			_log.error(e.getMessage());
		}
		// get process definition 
		processDefinition = documentReceiptLWS.getProcessDefinitionByNameAndVersion(processName, version);
		if (null != processDefinition) {
			flag = documentReceiptLWS.checkProcessInstanceAllEndFromProcessDefinition(processDefinition.getId());
			if (flag) {
				try {
					// delete process definition in jbpm database
					getLiferayWorkflowService().deleteWorkflow(processName, version);
					// delete in lportal database
					PmlManageWorkDocumentFlowLocalServiceUtil.deletePmlManageWorkDocumentFlow(manageDocumentWorkflowId);
					flag = true;
				} catch (Exception e) {
					flag = false;
					_log.error(e.getMessage());
				}
			}
		} else {
			flag = true;
		}
		
		return flag;
	}
	/* yenlt close 26082010
	private void deleteProcess(ActionRequest req) {
		long manageDocumentWorkflowId = ParamUtil.getLong(req, "manageDocumentWorkflowId");
		PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow = null;
		try {
			pmlManageWorkDocumentFlow = PmlManageWorkDocumentFlowUtil.findByPrimaryKey(manageDocumentWorkflowId);
		} catch (NoSuchException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		// delete process definition in jbpm database
		getLiferayWorkflowService().deleteWorkflow(pmlManageWorkDocumentFlow.getWorkFlowName(), pmlManageWorkDocumentFlow.getVersion());
		
		// delete in lportal database
		try {
			PmlManageWorkDocumentFlowLocalServiceUtil.deletePmlManageWorkDocumentFlow(manageDocumentWorkflowId);
			req.setAttribute("delete", "suncess");
		} catch (PortalException e) {
			req.setAttribute("delete", "fail");
			e.printStackTrace();
		} catch (SystemException e) {
			req.setAttribute("delete", "fail");
			e.printStackTrace();
		}
	}
	*/
	
}
