package com.sgs.portlet.pmledm_filestatus.action;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.document.PmlFileStatusCanNotDeleteException;
import com.sgs.portlet.document.PmlFileStatusCodeSameCodeException;
import com.sgs.portlet.document.model.PmlFileStatus;
import com.sgs.portlet.document.service.PmlFileStatusLocalServiceUtil;

public class EditFileStatusOnedoorAction extends PortletAction{
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
			if (cmd.equals(Constants.UPDATE)) {
				updateFileStatus(actionRequest);
				setForward(actionRequest, "portlet.sgs.pmledm_filestatus.view");
			}
			else if (cmd.equals(Constants.DELETE)) {				
				deleteFileStatus(actionRequest);
			}
			if (Validator.isNotNull(cmd)) {
				String ondoorStatusURL = ParamUtil.getString(actionRequest, "ondoorStatusURL");
				sendRedirect(actionRequest, actionResponse, ondoorStatusURL);
			}
		} catch (Exception e) {
			if (e instanceof PmlFileStatusCanNotDeleteException){
				SessionErrors.add(actionRequest,e.getClass().getName());
			}
			else if (e instanceof PmlFileStatusCodeSameCodeException) {
				setForward(actionRequest, "portlet.sgs.pmledm_filestatus.edit_filestatus_onedoor");
				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
	}
	
	
	/** yenlt update 24082010
	 * ext-btdkt
	 * com.sgs.portlet.pmledm_filestatus.action
	 * void
	 * @throws SystemException 
	 * @throws PortalException 
	 */

	private void deleteFileStatus(ActionRequest actionRequest) throws Exception {
		long fileStatusId = ParamUtil.getLong(actionRequest, "fileStatusId");
		PmlFileStatusLocalServiceUtil.removeFileStatus(fileStatusId);
	}


	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {
		
		String tabs = ParamUtil.getString(renderRequest, "tabs", "mot-cua" );
		renderRequest.setAttribute("tabs", tabs);
		
		if (getForward(renderRequest) != null && !getForward(renderRequest).equals("")) {
			return mapping.findForward(getForward(renderRequest)); // Use forward set in processAction if available
		} else {
			long fileStatusId = ParamUtil.getLong(renderRequest, "fileStatusId", 0);
			renderRequest.setAttribute("fileStatusId", fileStatusId);
			
		
			//return mapping.findForward("portlet.sgs.pmledm_filestatus.view");
			return mapping.findForward("portlet.sgs.pmledm_filestatus.edit_filestatus_onedoor");
		}
	}
	
	
	public PmlFileStatus updateFileStatus(ActionRequest req) throws PortalException, SystemException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		long fileStatusId = ParamUtil.getLong(uploadRequest, "fileStatusId");
		String code = ParamUtil.getString(uploadRequest, "pml_edm_file_status_code");
		String name = ParamUtil.getString(uploadRequest, "pml_edm_file_status_name");
		String description = ParamUtil.getString(uploadRequest, "pml_edm_file_status_description");
		Boolean active = ParamUtil.getBoolean(uploadRequest, "pml_edm_file_status_active");
		String type = ParamUtil.getString(uploadRequest, "pml_edm_file_state_type");
		
		PmlFileStatus fileStatus = null;
		
		if (active) {
			fileStatus = PmlFileStatusLocalServiceUtil.updateFileStatus(fileStatusId, code, name, description, "1", type);
		}
		else {
			fileStatus = PmlFileStatusLocalServiceUtil.updateFileStatus(fileStatusId, code, name, description, "0", type);
		}
		
		return fileStatus;
	}
}
