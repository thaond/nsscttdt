
package com.sgs.portlet.attachedfile.action;

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

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.sgs.portlet.attachedfile.AttachedFileCanNotDeleteException;
import com.sgs.portlet.attachedfile.AttachedFileCodeSameCodeException;
import com.sgs.portlet.attachedfile.model.AttachedFile;
import com.sgs.portlet.attachedfile.service.AttachedFileLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static Log _log = LogFactory.getLog(ViewAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	
	@Override
	public void processAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {
		
		String cmd = ParamUtil.getString(req, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateAttachedFile(req, res);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteAttachedFile(req, res);
			}
//			else if (cmd.equals(Constants.UPDATE)) {
//				updateAttachedFile(req, res);
//			}
			else if (cmd.equals(Constants.LOCK)) {
				updateActiveAttachedFile(req, res);
			}
			if (Validator.isNotNull(cmd)) {
				String attachedFileURL = ParamUtil.getString(req, "attachedFileURL");
				sendRedirect(req, res, attachedFileURL);
			}
		} catch (Exception e) {
			if (e instanceof AttachedFileCanNotDeleteException){
				SessionErrors.add(req,e.getClass().getName());
			}
			else if (e instanceof AttachedFileCodeSameCodeException) {
				req.setAttribute("attachedFileFlag", "fail");
				setForward(req, "portlet.sgs.attachedfile.add");
				SessionErrors.add(req, e.getClass().getName());
			}
			else {
				throw e;
			}
		}
			
	}

	@Override
	public ActionForward render(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {

		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); 
		}
		else {
			String cmd = ParamUtil.getString(req, Constants.CMD);
			if (cmd.equals(Constants.EDIT)) {
				editAttachedFile(req, res);
			}
			return mapping.findForward("portlet.sgs.attachedfile.view");
		}
	}

	private AttachedFile updateAttachedFile(ActionRequest req, ActionResponse res) throws PortalException, SystemException {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(req);
		
		String cmd = ParamUtil.getString(uploadRequest, Constants.CMD);
		
		String attachedFileId = ParamUtil.getString(uploadRequest, "attachedFileId");
		String attachedFileCode = ParamUtil.getString(uploadRequest, "attachedFileCode");
		String attachedFileName = ParamUtil.getString(uploadRequest, "attachedFileName");
		String description = ParamUtil.getString(uploadRequest, "description");
		Boolean active = ParamUtil.getBoolean(uploadRequest, "active");
		
		AttachedFile attachedFile = null;
		
		if (cmd.equals(Constants.ADD)) {
			if (active) {
				attachedFile = AttachedFileLocalServiceUtil.addAttachedFile(attachedFileCode, attachedFileName, description, "1");
			}
			else {
				attachedFile = AttachedFileLocalServiceUtil.addAttachedFile(attachedFileCode, attachedFileName, description, "0");
			}
		}
		else if (cmd.equals(Constants.UPDATE)) {
			if (active) {
				attachedFile = AttachedFileLocalServiceUtil.updateAttachedFile(attachedFileId, attachedFileCode, attachedFileName, description, "1");
			}
			else {
				attachedFile = AttachedFileLocalServiceUtil.updateAttachedFile(attachedFileId, attachedFileCode, attachedFileName, description, "0");
			}
		}
		return attachedFile;
	}
	// yenlt update 24082010
	private void deleteAttachedFile(ActionRequest req, ActionResponse res) throws Exception {
		String attachedFileId = ParamUtil.getString(req, "attachedFileId");
		 AttachedFileLocalServiceUtil.removeAttachedFile(attachedFileId);
	}
	// end yenlt update 24082010
	/* yenlt close 24082010
	private void deleteAttachedFile(ActionRequest req, ActionResponse res) {

		String attachedFileId = ParamUtil.getString(req, "attachedFileId");
		
		List<PmlFileTypeAttachedFile> pmlFileTypeAttachedFileList = new ArrayList<PmlFileTypeAttachedFile>();
		
		try {
			pmlFileTypeAttachedFileList = PmlFileTypeAttachedFileUtil.findByAttachedFileId(attachedFileId);
		} catch (Exception e) {
			
		}
		
		
		List<PmlFileAttachedFile> pmlFileAttachedFileList = new ArrayList<PmlFileAttachedFile>();
		try {
			pmlFileAttachedFileList = PmlFileAttachedFileUtil.findByAttachedFileId(attachedFileId);
		} catch (Exception e) {
			_log.error(e);
		}
		
		try {
			
			if (pmlFileTypeAttachedFileList.size() > 0 || pmlFileAttachedFileList.size() > 0) {
				req.setAttribute("delete", false);
			}
			else {
				AttachedFile attachedFile =	null;
				try {
					attachedFile = AttachedFileLocalServiceUtil.getAttachedFile(attachedFileId);
					AttachedFileLocalServiceUtil.deleteAttachedFile(attachedFile);
					req.setAttribute("delete", true);
					
				} catch (Exception e) {
					_log.error(e);
				}
			}
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	*/

	private void editAttachedFile(RenderRequest req, RenderResponse res) {

		String attachedFileId = ParamUtil.getString(req, "attachedFileId");
		req.setAttribute("attachedFileId", attachedFileId);
//		try {
//			AttachedFile attachedFile = AttachedFileLocalServiceUtil.getAttachedFile(attachedFileId);
//			req.setAttribute("attachedFile", attachedFile);
//		}
//		catch (Exception e) {
//			_log.error(e);
//		}
	}

	/*
	private void createAttachedFile(ActionRequest req, ActionResponse res) {

			String attachedFileId = "";
			String attachedFileCode =
				ParamUtil.getString(req, "attachedFileCode");
			String attachedFileName =
				ParamUtil.getString(req, "attachedFileName");
			String description = ParamUtil.getString(req, "description");
			Boolean active = ParamUtil.getBoolean(req, "active");
			try {
				attachedFileId = IdTemplateServiceUtil.generatedId(AttachedFile.class);
			} catch (Exception e) {
				
			} 
			try {
				AttachedFile attachedFile = new AttachedFileImpl();
				attachedFile.setAttachedFileId(attachedFileId);
				attachedFile.setAttachedFileCode(attachedFileCode);
				attachedFile.setAttachedFileName(attachedFileName);
				attachedFile.setDescription(description);
				if (active) {
					attachedFile.setActive("1");
				}
				else {
					attachedFile.setActive("0");
				}
				
		
				attachedFile = AttachedFileLocalServiceUtil.addAttachedFile(attachedFile);
			} catch (Exception e) {
				_log.error(e);
			}

	}*/

	private void updateActiveAttachedFile(ActionRequest req, ActionResponse res) {

		String attachedFileId = ParamUtil.getString(req, "attachedFileId");

		try {
			AttachedFile attachedFile =	AttachedFileLocalServiceUtil.getAttachedFile(attachedFileId);
			if ("1".equals(attachedFile.getActive())) {
				attachedFile.setActive("0");
			}
			else {
				attachedFile.setActive("1");
			}

			attachedFile = AttachedFileLocalServiceUtil.updateAttachedFile(attachedFile);
		}
		catch (Exception e) {
			_log.error(e);
		}

	}

}
