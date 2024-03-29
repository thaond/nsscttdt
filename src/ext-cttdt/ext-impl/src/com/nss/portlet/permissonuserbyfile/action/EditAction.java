package com.nss.portlet.permissonuserbyfile.action;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.struts.PortletAction;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.nss.portlet.permissonuserbyfile.model.PmlUserFileType;
import com.nss.portlet.permissonuserbyfile.model.impl.PmlUserFileTypeImpl;
import com.nss.portlet.permissonuserbyfile.service.PmlUserFileTypeLocalServiceUtil;

public class EditAction extends PortletAction {
	private static Log _log = LogFactory.getLog(EditAction.class);
	
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}
	@Override
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String cmd = ParamUtil.getString(req, Constants.CMD, "");
		String multiUserIds = ParamUtil.getString(req, "multiUserIds");
		String redirect = req.getParameter("redirect");
		long userId = ParamUtil.getLong(req, "userId", 0);
		String description = ParamUtil.getString(req, "description");
		String[] fileTypeId = req.getParameterValues("fileTypes");
		
		if (Validator.isNotNull(cmd) && "ASSIGN".equals(cmd)) {
			String[] multiUsers = StringUtil.split(multiUserIds);
			for (int i = 0; i < multiUsers.length; i++) {
				long userIdMulti = Long.parseLong(multiUsers[i]);
				updatePmlUserFileType(fileTypeId, userIdMulti, description);
			}
		} else {
			updatePmlUserFileType(fileTypeId, userId, description);
		}
		PortletSession session = req.getPortletSession();
		session.setAttribute("editPermission", "success", PortletSession.APPLICATION_SCOPE);
		
		res.sendRedirect(redirect);
		
		
	}

	@Override
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			String cmd = ParamUtil.getString(req, Constants.CMD, "");
			long userId = ParamUtil.getLong(req, "userId", 0);
			List<PmlUserFileType> listOldFileType = new ArrayList<PmlUserFileType>();
			if (Validator.isNotNull(cmd) && "ASSIGN".equals(cmd)) {
				long[] multiUsers = StringUtil.split(ParamUtil.getString(req, "multiUsers"), 0L);
				String multiUserIds = "";
				for (int i = 0; i < multiUsers.length; i++) {
					if (i == multiUsers.length-1) {
						multiUserIds += multiUsers[i];
					} else {
						multiUserIds += multiUsers[i] + ",";
					}
				}
				req.setAttribute("multiUserIds", multiUserIds);
			} else {
				listOldFileType = PmlUserFileTypeLocalServiceUtil.findByUserId(userId);
			}
			List<PmlFileType> listfiletype= PmlFileTypeLocalServiceUtil.findAll();
			String description = "";
			if (listOldFileType != null && listOldFileType.size() != 0) {
				description = listOldFileType.get(0).getDescription();
			}
			req.setAttribute("description", description);
			req.setAttribute("listfiletype",listfiletype);
			req.setAttribute("userId", userId);
			req.setAttribute("listOldFileType", listOldFileType);
		
			return mapping.findForward("portlet.nss.permissonuserbyfile.edit");
		
	}
	
	public void updatePmlUserFileType(String[] fileTypeId, long userId, String description) {
		List<PmlUserFileType> listOldFileType = new ArrayList<PmlUserFileType>();
		listOldFileType = PmlUserFileTypeLocalServiceUtil.findByUserId(userId);
		listOldFileType = new ArrayList<PmlUserFileType>();
		
		for (PmlUserFileType pmlUserFileType : listOldFileType) {
			try {
				PmlUserFileTypeLocalServiceUtil.deletePmlUserFileType(pmlUserFileType);
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
		}
		
		if (fileTypeId != null) {
			for (int i = 0; i < fileTypeId.length; i++) {
				try {
					PmlUserFileType userFileType = new PmlUserFileTypeImpl();
					userFileType.setFileTypeId(fileTypeId[i]);
					userFileType.setUserId(userId);
					userFileType.setDescription(description);
				
					PmlUserFileTypeLocalServiceUtil.addPmlUserFileType(userFileType);
				} catch (SystemException e) {
					_log.error(e.getMessage());
				}
			}
		}
		else {
			try {
				PmlUserFileType userFileType = new PmlUserFileTypeImpl();
				userFileType.setFileTypeId("");
				userFileType.setUserId(userId);
				userFileType.setDescription(description);
			
				PmlUserFileTypeLocalServiceUtil.addPmlUserFileType(userFileType);
			} catch (SystemException e) {
				_log.error(e.getMessage());
			}
		}
		
	}

}
