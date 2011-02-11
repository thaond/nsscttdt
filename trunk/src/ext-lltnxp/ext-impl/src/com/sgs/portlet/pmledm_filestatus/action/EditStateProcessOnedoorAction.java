package com.sgs.portlet.pmledm_filestatus.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.document.receipt.PmlFileStatusStateProcessCanNotDeleteException;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.service.PmlFileStatusStateProcessLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil;

public class EditStateProcessOnedoorAction extends PortletAction{
private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	
	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		// yenlt update 24082010
		try {
			if(cmd.equals(Constants.UPDATE)){
				updateFileStatusStateProcess(actionRequest,actionResponse);
			}
			if(cmd.equals(Constants.DELETE)){
				deleteFileStatusStateProcess(actionRequest,actionResponse);
			}
			if(cmd.equals(Constants.ADD)){
				addStatusProcess(actionRequest,actionResponse);
			}
			if (Validator.isNotNull(cmd)) {
				String ondoorStateURL = ParamUtil.getString(actionRequest, "ondoorStateURL");
				sendRedirect(actionRequest, actionResponse, ondoorStateURL);
			}
		} catch (Exception e) {
			if (e instanceof PmlFileStatusStateProcessCanNotDeleteException){
				SessionErrors.add(actionRequest,e.getClass().getName());
			}
			else {
				throw e;
			}
		}
		// end yenlt 24082010
	}
	
	
	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {
		
		String tabs = ParamUtil.getString(renderRequest, "tabs"); 
		String redirect = ParamUtil.getString(renderRequest, "redirect"); 
		
		long filestatusId = ParamUtil.getLong(renderRequest, "fileStatusId");
		List<PmlFileStatusStateProcess>  filestatus_stateprocess_list = new ArrayList<PmlFileStatusStateProcess>();
		
		filestatus_stateprocess_list = PmlFileStatusStateProcessUtil.findByFileStatusId(filestatusId);
		
		renderRequest.setAttribute("tabs",tabs );		
		renderRequest.setAttribute("redirect",redirect );		
		renderRequest.setAttribute("fileStatusId",filestatusId );		
		renderRequest.setAttribute("listFileStatusStateProcess", filestatus_stateprocess_list);
		
		return mapping.findForward("portlet.sgs.pmledm_filestatus.display_stateprocess_onedoor");

	}
	
	public void updateFileStatusStateProcess(ActionRequest req, ActionResponse res){
		long statusId = ParamUtil.getLong(req, "statusId");
		long stateprocessidchoice = ParamUtil.getLong(req, "stateprocessidchoice");
		String description = ParamUtil.getString(req, "description");
		
		PmlFileStatusStateProcess fileStatusStateProcess = null;
		
		try {
			fileStatusStateProcess = PmlFileStatusStateProcessUtil.findByPrimaryKey(statusId);
		} catch (Exception e1) {
		}
			
		if(fileStatusStateProcess != null){
			fileStatusStateProcess.setStateProcessId(stateprocessidchoice);
			fileStatusStateProcess.setDescription(description);
		}
		try {
			PmlFileStatusStateProcessLocalServiceUtil.updatePmlFileStatusStateProcess(fileStatusStateProcess);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
	// yenlt update 24082010
	public void deleteFileStatusStateProcess(ActionRequest req, ActionResponse res) throws Exception{
		long filestatusStateprocessId = ParamUtil.getLong(req, "statusId");
		PmlFileStatusStateProcessLocalServiceUtil.removeFileStatusStateProcess(filestatusStateprocessId);
		// tim theo filestatusId nua
//		 cho ca 3 list lun
//		try {
//			fileStatusStateProcessList = PmlFileStatusStateProcessUtil.findByFileStatusId(statusId);
//		} catch (SystemException e) {
//			e.printStackTrace();
//		}
//		
//		if (fileStatusStateProcessList.size() >0) {
//			req.setAttribute("flag", false);
//		} else {
//			try {
//				PmlFileStatusStateProcessLocalServiceUtil.deletePmlFileStatusStateProcess(statusId);
//				req.setAttribute("flag", true);
//			} catch (Exception e1) {
//				
//			}
//		}
	}
	// end yenlt
	
	private void addStatusProcess(ActionRequest req, ActionResponse res) {
		long fileStatusId = ParamUtil.getLong(req, "fileStatusId");		
		long stateProcessId = ParamUtil.getLong(req, "state_process_id");
		String description = ParamUtil.getString(req, "description", "");
		
		long id = 0;
		try {
			id = CounterLocalServiceUtil.increment();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		PmlFileStatusStateProcess fileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.createPmlFileStatusStateProcess(id);
		fileStatusStateProcess.setFileStatusId(fileStatusId);
		fileStatusStateProcess.setStateProcessId(stateProcessId);
		fileStatusStateProcess.setDescription(description);
		try {
			PmlFileStatusStateProcessLocalServiceUtil.updatePmlFileStatusStateProcess(fileStatusStateProcess);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}
}