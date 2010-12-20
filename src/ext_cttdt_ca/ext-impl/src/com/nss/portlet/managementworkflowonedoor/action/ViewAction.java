package com.nss.portlet.managementworkflowonedoor.action;

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
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.nss.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.nss.portlet.onedoor.NoSuchPmlWorkflowException;
import com.nss.portlet.onedoor.PmlWorkflowCanNotDeleteException;
import com.nss.portlet.onedoor.model.PmlStateWorkFlow;
import com.nss.portlet.onedoor.model.PmlTransition;
import com.nss.portlet.onedoor.model.PmlWorkflow;
import com.nss.portlet.onedoor.service.PmlStateWorkFlowLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlTransitionLocalServiceUtil;
import com.nss.portlet.onedoor.service.PmlWorkflowLocalServiceUtil;
import com.nss.portlet.onedoor.service.persistence.PmlStateWorkFlowUtil;
import com.nss.portlet.onedoor.service.persistence.PmlTransitionUtil;
import com.nss.portlet.onedoor.service.persistence.PmlWorkflowUtil;
import com.nss.workflowonedoor.OneDoorProcessLiferayWorkflowService;
import com.nss.workflowonedoor.OneDoorProcessPortletAction;

public class ViewAction extends OneDoorProcessPortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	protected OneDoorProcessLiferayWorkflowService onedoorWF = new OneDoorProcessLiferayWorkflowService();
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
	}

	@Override
	public ActionForward renderStruts(ActionMapping mapping, ActionForm form, PortletConfig config, 
				RenderRequest req, RenderResponse res) throws Exception {
		
		List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
		
		try {
			pmlFileTypeList = PmlFileTypeLocalServiceUtil.findAll();
		} catch (Exception e) {
			
		}
		req.setAttribute("pmlFileTypeList", pmlFileTypeList);		
		
		return mapping.findForward("portlet.nss.managementworkflowonedoor.view");
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
}
		
