package com.sgs.portlet.workflow_admin.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.model.PmlStateWorkFlow;
import com.sgs.portlet.document.service.PmlStateWorkFlowLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlStateWorkFlowUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;
import com.sgs.portlet.onedoor.PmlWorkflowCanNotDeleteException;
import com.sgs.portlet.onedoor.model.PmlWorkflow;
import com.sgs.portlet.onedoor.service.PmlWorkflowLocalServiceUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlWorkflowUtil;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessLiferayWorkflowService;
import com.sgs.portlet.onedoor.workflow.OneDoorProcessPortletAction;
import com.sgs.portlet.onedoorpccc.model.PmlTransition;
import com.sgs.portlet.onedoorpccc.service.PmlTransitionLocalServiceUtil;
import com.sgs.portlet.onedoorpccc.service.persistence.PmlTransitionUtil;

public class ViewAction extends OneDoorProcessPortletAction {
	// yenlt 28082010
	private static Log _log = LogFactory.getLog(OneDoorProcessPortletAction.class);
	protected OneDoorProcessLiferayWorkflowService onedoorWF = new OneDoorProcessLiferayWorkflowService();
	//end yenlt 28082010
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	
	@Override
	public void processStrutsAction(ActionMapping mapping, ActionForm form, PortletConfig config,
				ActionRequest req, ActionResponse res)	throws Exception {

		String cmd = ParamUtil.getString(req, Constants.CMD);
		try {
			if (cmd.equals(Constants.ADD)){
				addProcess(form, req, res);
				
			} else if (cmd.equals(Constants.DELETE)) {
				// yenlt update 28082010
			//delete(form, req, res);
				boolean delete = delete(req, res);
				if (!delete) {
					throw new PmlWorkflowCanNotDeleteException();
				}
			} if (Validator.isNotNull(cmd)) {
				String redirect = ParamUtil.getString(req, "redirect");
				sendRedirect(req, res, redirect);
			}
			//sendRedirect(req, res);
				
		} catch (Exception e) {
			if (e instanceof PmlWorkflowCanNotDeleteException) {
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
		// END yenlt 28082010
	
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form, PortletConfig config, 
				RenderRequest req, RenderResponse res) throws Exception {
		
		List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
		
		try {
			pmlFileTypeList = PmlFileTypeUtil.findAll();
		} catch (Exception e) {
			
		}
		req.setAttribute("pmlFileTypeList", pmlFileTypeList);		
		
		return mapping.findForward("portlet.sgs.workflow_admin.view");
	}
	

	private void addProcess(ActionForm form, ActionRequest req, ActionResponse res) {
		try {
			// get file Type param from request
			String fileType = ParamUtil.getString(req, "_fileTypeId");			
			String nameFile  = ParamUtil.getString(req,"nameFile");
			// get definition stream
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
			File myFile = uploadRequest.getFile("theFile");
			InputStream is = new FileInputStream(myFile);
			InputStream isCopy = new FileInputStream(myFile);
			PmlFileType pmlFileType =  PmlFileTypeUtil.findByPrimaryKey(fileType);
			OneDoorProcessLiferayWorkflowService doorProcessLiferayWorkflowService = (OneDoorProcessLiferayWorkflowService) getLiferayWorkflowService();
			int totalTime = doorProcessLiferayWorkflowService.totalTime(is);
			
			if (Integer.parseInt(pmlFileType.getProcessTime()) >= totalTime) {
				req.setAttribute("deployFlag", "true");
				doorProcessLiferayWorkflowService.deloyProcessSupport(fileType, isCopy, nameFile, 1);
			}
			else {
				req.setAttribute("deployFlag", "false");
			}
			
		} catch(Exception e) {
		}
	}

	// yenlt update 28082010
	private boolean delete(ActionRequest req, ActionResponse res){
		boolean flag = true;
		String processName = "";
		int version = 0;
		ProcessDefinition processDefinition = null;
		long workflowID = ParamUtil.getLong(req, "_workflowId");
		PmlWorkflow pmlWorkflow = null;
		try {
			pmlWorkflow = PmlWorkflowUtil.findByPrimaryKey(workflowID);
			processName = pmlWorkflow.getWorkflow();
			version = pmlWorkflow.getVersion_();
		} catch (NoSuchPmlWorkflowException e) {
			_log.error(e.getMessage());
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		
		processDefinition = onedoorWF.getProcessDefinitionByNameAndVersion(processName, version);
		if (null != processDefinition) {
			flag = onedoorWF.checkProcessInstanceAllEndFromProcessDefinition(processDefinition.getId());
			if (flag) {
				getLiferayWorkflowService().deleteWorkflow(pmlWorkflow.getWorkflow(), pmlWorkflow.getVersion_());
				String fileTypeId = pmlWorkflow.getFileTypeId();
				if (fileTypeId != null && version != 0) {
					List<PmlTransition> listPmlTransition = new ArrayList<PmlTransition>();
					List<PmlStateWorkFlow> listPmlStateWorkFlow = new ArrayList<PmlStateWorkFlow>();
					try {
						listPmlTransition = PmlTransitionUtil.findByFileTypeId_Version(fileTypeId, String.valueOf(version));
						for (PmlTransition item : listPmlTransition) {
							PmlTransitionLocalServiceUtil.deletePmlTransition(item);
						}
						listPmlStateWorkFlow = PmlStateWorkFlowUtil.findByWorkFlow_Version(pmlWorkflow.getWorkflow(), version);
						for (PmlStateWorkFlow pmlStateWorkFlow : listPmlStateWorkFlow) {
							PmlStateWorkFlowLocalServiceUtil.deletePmlStateWorkFlow(pmlStateWorkFlow);
						}
						PmlWorkflowLocalServiceUtil.deletePmlWorkflow(workflowID);	
						flag = true;
					} catch (Exception e) {
						flag = false;
						_log.error(e.getMessage());
					}
				}
			}
		} else {
			flag = true;
		}
		return flag;
	}
	// end yenlt 28082010
	
	/* yenlt close start 28082010
	private void delete(ActionForm form, ActionRequest req, ActionResponse res)	throws Exception {
		try {
			long workflowID = ParamUtil.getLong(req, "_workflowId");
			PmlWorkflow pmlWorkflow = PmlWorkflowUtil.findByPrimaryKey(workflowID);
			getLiferayWorkflowService().deleteWorkflow(pmlWorkflow.getWorkflow(), pmlWorkflow.getVersion_());
			
			// delete data in pml_transition table
			String fileTypeId = pmlWorkflow.getFileTypeId();
			int version = pmlWorkflow.getVersion_();
			if (fileTypeId != null && version != 0) {
				List<PmlTransition> listPmlTransition = PmlTransitionUtil.findByFileTypeId_Version(fileTypeId, String.valueOf(version));
				for (PmlTransition item : listPmlTransition) {
					PmlTransitionLocalServiceUtil.deletePmlTransition(item);
				}
				
				//delete data in pml_state_wf
				List<PmlStateWorkFlow> listPmlStateWorkFlow = PmlStateWorkFlowUtil.findByWorkFlow_Version(pmlWorkflow.getWorkflow(), version);
				for (PmlStateWorkFlow pmlStateWorkFlow : listPmlStateWorkFlow) {
					PmlStateWorkFlowLocalServiceUtil.deletePmlStateWorkFlow(pmlStateWorkFlow);
				}
				
			}
			PmlWorkflowLocalServiceUtil.deletePmlWorkflow(workflowID);	
		}
		catch (Exception e) {
		}
	}
 	yenlt close start 28082010 */

}
