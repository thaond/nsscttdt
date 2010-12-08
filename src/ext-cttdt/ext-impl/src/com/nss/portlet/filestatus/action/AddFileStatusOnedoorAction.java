package com.nss.portlet.filestatus.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.nss.portlet.onedoor.PmlFileStatusCodeSameCodeException;
import com.nss.portlet.onedoor.model.PmlFileStatus;
import com.nss.portlet.onedoor.service.PmlFileStatusLocalServiceUtil;

public class AddFileStatusOnedoorAction extends PortletAction{
private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	
	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
		
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
//			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
//				updateFileStatus(actionRequest);
//			}
			if (cmd.equals(Constants.ADD)) {
				createFileStatus(actionRequest);
			}
			sendRedirect(actionRequest, actionResponse);
		} catch (Exception e) {
			if (e instanceof PmlFileStatusCodeSameCodeException) {
				actionRequest.setAttribute("filestatusFlag", "fail");
				setForward(actionRequest, "portlet.nss.filestatus.add_filestatus_onedoor");
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}
	
	
	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {		
		
		return mapping.findForward("portlet.nss.filestatus.add_filestatus_onedoor");
	}
	
	
	
	public PmlFileStatus createFileStatus(ActionRequest req) throws PortalException, SystemException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String code = ParamUtil.getString(uploadRequest, "pml_edm_file_status_code");
		String name = ParamUtil.getString(uploadRequest, "pml_edm_file_status_name");
		String description = ParamUtil.getString(uploadRequest, "pml_edm_file_status_description");
		Boolean active = ParamUtil.getBoolean(uploadRequest, "pml_edm_file_status_active");
		String type = ParamUtil.getString(uploadRequest, "pml_edm_file_state_type");
		
		PmlFileStatus fileStatus = null;
		
		if (active) {
			fileStatus = PmlFileStatusLocalServiceUtil.addFileStatus(code, name, description, "1", type);
		}
		else {
			fileStatus = PmlFileStatusLocalServiceUtil.addFileStatus(code, name, description, "0", type);
		}
		
		return fileStatus;
	}
}
