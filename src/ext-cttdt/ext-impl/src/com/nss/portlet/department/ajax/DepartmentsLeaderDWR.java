package com.nss.portlet.department.ajax;

import com.nss.portlet.department.service.PmlDepartmentsLeaderLocalServiceUtil;

public class DepartmentsLeaderDWR {
	public boolean checkUserIsLeader(String userId) {
		return PmlDepartmentsLeaderLocalServiceUtil.checkUserIsLeader(userId);
	}

}
