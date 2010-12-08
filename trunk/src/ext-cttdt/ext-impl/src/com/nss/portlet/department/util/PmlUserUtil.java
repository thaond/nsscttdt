package com.nss.portlet.department.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.service.PmlUserLocalServiceUtil;


public class PmlUserUtil {
	public static List<PmlUserDTO> getPmlUserByDepartmentId(String departmentsId) {
		
		List<PmlUser> pmlUserList = null;
		List<PmlUserDTO> retVal = new ArrayList<PmlUserDTO>();
		try {
			if (departmentsId.trim().length() == 0) {
				pmlUserList = PmlUserLocalServiceUtil.getPmlUsers(-1, -1);
			}
			else {
				pmlUserList = PmlUserLocalServiceUtil.findByDepartmentsId(departmentsId);
			}
			User user = null;
			PmlUserDTO userDTO = null;
			for (PmlUser pmlUser : pmlUserList) {
				try {
					user = UserLocalServiceUtil.getUser(pmlUser.getUserId());
					userDTO = new PmlUserDTO();
					userDTO.setUserId(user.getUserId());
					userDTO.setScreenName(user.getScreenName());
					userDTO.setLastName(user.getLastName());
					userDTO.setMiddleName(user.getMiddleName());
					userDTO.setFirstName(user.getFirstName());
					retVal.add(userDTO);
				} catch (Exception e) {
					
				}
			}
		}
		catch (Exception ex) {
			retVal = null;
			System.out.println("Co loi khi goi ham getPmlUserByDepartmentId.");
		}
		return retVal;
	}
}
