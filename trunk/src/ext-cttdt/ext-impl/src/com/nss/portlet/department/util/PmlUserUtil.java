package com.nss.portlet.department.util;

import java.util.List;

import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.service.PmlUserLocalServiceUtil;


public class PmlUserUtil {
public static List<PmlUser> getPmlUserByDepartmentId(String departmentsId) {
		
		List<PmlUser> retVal = null;
		try {
			if (departmentsId.trim().length() == 0) {
				retVal = PmlUserLocalServiceUtil.getPmlUsers(-1, -1);
			}
			else {
				retVal = PmlUserLocalServiceUtil.findByDepartmentsId(departmentsId);
			}
		}
		catch (Exception ex) {
			retVal = null;
			System.out.println("Co loi khi goi ham getPmlUserByDepartmentId.");
		}
		return retVal;
	}
}
