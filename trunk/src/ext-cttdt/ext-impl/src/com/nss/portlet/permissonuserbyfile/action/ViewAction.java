package com.nss.portlet.permissonuserbyfile.action;

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

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.nss.portlet.permissonuserbyfile.model.PmlUserFileType;
import com.nss.portlet.permissonuserbyfile.model.impl.PmlUserFileTypeImpl;
import com.nss.portlet.permissonuserbyfile.service.PmlUserFileTypeLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}	
	
	public void processAction(ActionMapping mapping, ActionForm form,
			PortletConfig config, ActionRequest req, ActionResponse res)
			throws Exception {
		String message = "";
		List<PmlUserFileType> pmlUserFileTypeList =	PmlUserFileTypeLocalServiceUtil.getPmlUserFileTypes(-1, -1);
		List<PmlUserFileType> removeList = new ArrayList<PmlUserFileType>();
		User user = null;
		for (PmlUserFileType pmlUserFileType : pmlUserFileTypeList) {
			try {
				user = UserLocalServiceUtil.getUser(pmlUserFileType.getUserId());
			} catch (Exception e) {
				user = null;
			}
			if (null == user) {
				removeList.add(pmlUserFileType);
			}
		}
		try {
			// xoa nhung dong ma ko ton tai user trong bang user_
			for (PmlUserFileType userFileRemove : removeList) {
				PmlUserFileTypeLocalServiceUtil.deletePmlUserFileType(userFileRemove);
			}
			
			// add nhung user trong bang user_ vao bang pml_user_file_type
			List<Long> userIdList = new ArrayList<Long>();
			List<User> userList = UserLocalServiceUtil.getUsers(-1, -1);
			for (User userPortal : userList) {
				List<PmlUserFileType> pmlUserFileType = new ArrayList<PmlUserFileType>();
				try {
					pmlUserFileType = PmlUserFileTypeLocalServiceUtil.findByUserId(userPortal.getUserId());
				} catch (Exception e) {
					pmlUserFileType = new ArrayList<PmlUserFileType>();
				}
				if (pmlUserFileType.isEmpty()) {
					userIdList.add(userPortal.getUserId());
				}
			}
			for (long userId : userIdList) {
				PmlUserFileType userFileType = new PmlUserFileTypeImpl();
				userFileType.setUserId(userId);
				userFileType.setFileTypeId("");
				userFileType.setDescription("");
				userFileType = PmlUserFileTypeLocalServiceUtil.addPmlUserFileType(userFileType);
			}
			message = "true";
		} catch (Exception e) {
			message = "false";
		}
		req.setAttribute("message", message);
	}

	
	
	public ActionForward render(ActionMapping mapping, ActionForm form,
			PortletConfig config, RenderRequest req, RenderResponse res)
			throws Exception {
			if (getForward(req) != null && !getForward(req).equals("")) {
				return mapping.findForward(getForward(req)); // Use forward set in processAction if available
			} else {
				return mapping.findForward("portlet.nss.permissonuserbyfile.view");
			}
	}

}
