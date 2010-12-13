package com.nss.portlet.onedoorprocess.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.service.PmlUserLocalServiceUtil;


public class PhieuChuyenDWR {
	private static Log _log = LogFactory.getLog(PhieuChuyenDWR.class);
	public String getDepartmentId(long receiverId){
		String departmentId = "";
		PmlUser receiver = null;
		try {
			receiver = PmlUserLocalServiceUtil.getPmlUser(receiverId);
			departmentId = receiver.getDepartmentsId();
		} catch (Exception e) {
			_log.error("CAN NOT GET USER");
			_log.error(e);
		}
		return departmentId;
			
	}

}
