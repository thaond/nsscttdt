
package com.sgs.portlet.permissonuserbyfile.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.persistence.UserUtil;
import com.liferay.portal.struts.PortletAction;
import com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType;
import com.sgs.portlet.country.pmluserfiletype.model.impl.PmlUserFileTypeImpl;
import com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeLocalServiceUtil;
import com.sgs.portlet.country.pmluserfiletype.service.persistence.PmlUserFileTypeUtil;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.permissonuserbyfile.dto.PermissionUserByFileDTO;
import com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil;

public class ViewAction extends PortletAction {
	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;
	
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}	
	@Override
	public void processAction(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		ActionRequest req, ActionResponse res)
		throws Exception {

		// yenlt update 20101019
		// dong bo user
		
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
					pmlUserFileType = PmlUserFileTypeUtil.findByUserId(userPortal.getUserId());
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
		/* start yenlt close 20101019 
		String message = "";

		try {

			List<PmlUserFileType> pmlUserFileTypeList =
				PmlUserFileTypeUtil.findAll();

			// lay ra tat ca cac user tu userId co trong bang pmlUserFileType
			Collection<User> userSet = new HashSet<User>();
			for (PmlUserFileType pmlUserFileType : pmlUserFileTypeList) {
				try {
					userSet.add(UserUtil.findByPrimaryKey(pmlUserFileType.getUserId()));
				}
				catch (NoSuchUserException nsue) {
					// remove hang nay tu bang sau do tiep tuc chay chuong trinh
					PmlUserFileTypeLocalServiceUtil.deletePmlUserFileType(pmlUserFileType);
					continue;
				}
			}

			// lay ra tat ca cac user tu he thong
			Collection<User> userList = UserUtil.findAll();

			// Lay ra nhung user co trong he thong nhung khong co trong bang
			userList.removeAll(userSet);

			// Add cac user co trong he thong ma khong co trong bang
			for (User user : userList) {
				PmlUserFileType pmlUserFileType = new PmlUserFileTypeImpl();
				pmlUserFileType.setUserId(user.getUserId());
				pmlUserFileType.setFileTypeId("");
				pmlUserFileType.setDescription("");

				PmlUserFileTypeLocalServiceUtil.addPmlUserFileType(pmlUserFileType);
			}

			message = "true";
		}
		catch (Exception e) {
			message = "false";
		}

		req.setAttribute("message", message);
		end yenlt close 20101019 */
	}

	@Override
	public ActionForward render(
		ActionMapping mapping, ActionForm form, PortletConfig config,
		RenderRequest req, RenderResponse res)
		throws Exception {
		/* start yenlt close 20101019 
		List<PermissionUserByFileDTO> permissionUserByFileDTOList =
			new ArrayList<PermissionUserByFileDTO>();

		// Lay tat ca user tu bang pmlUserFileType
		List<PmlUserFileType> userFileTypeList = PmlUserFileTypeUtil.findAll();

		Collection<User> userSet = new HashSet<User>();

		for (PmlUserFileType pmlUserFileType : userFileTypeList) {
			try {
				userSet.add(UserUtil.findByPrimaryKey(pmlUserFileType.getUserId()));
			}
			catch (NoSuchUserException nsue) {
				// continue khi userId co trong bang nhung ko co user tuong ung
				// trong he thong
				continue;
			}
		}

		for (User user : userSet) {
			PermissionUserByFileDTO dto = new PermissionUserByFileDTO();

			dto.setUserId(user.getUserId());
			dto.setAccount(user.getEmailAddress());
			dto.setUserName(PmlUserLocalServiceUtil.getFullName(user.getUserId()));

			// get list user_file with userId
			List<PmlUserFileType> pmlUserFileTypeList =
				PmlUserFileTypeUtil.findByUserId(user.getUserId());
			List<PmlFileType> pmlFileTypeList = new ArrayList<PmlFileType>();
			String description = "";
			if (pmlUserFileTypeList != null && pmlUserFileTypeList.size() != 0) {
				description = pmlUserFileTypeList.get(0).getDescription();
			}
			
			for (PmlUserFileType pmlUserFileType : pmlUserFileTypeList) {
				// get list file
				String s = pmlUserFileType.getFileTypeId();
				if (!"".equals(s)) {
					pmlFileTypeList.add(PmlFileTypeUtil.findByPrimaryKey(s));
				}
			}

			dto.setPmlFileTypeList(pmlFileTypeList);
			dto.setDescriptionList(description);
			permissionUserByFileDTOList.add(dto);
		}

		req.setAttribute(
			"permissionUserByFileDTOList", permissionUserByFileDTOList);

		end yenlt close 20101019 */
		if (getForward(req) != null && !getForward(req).equals("")) {
			return mapping.findForward(getForward(req)); // Use forward set in
															// processAction if
															// available
		}
		else {
			return mapping.findForward("portlet.sgs.permissonuserbyfile.view");
		}
	}

}
