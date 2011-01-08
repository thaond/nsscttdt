package com.sgs.portlet.onedoor.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;
import com.sgs.portlet.onedoor.service.base.PmlDepartmentsLeaderLocalServiceBaseImpl;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil;


public class PmlDepartmentsLeaderLocalServiceImpl
    extends PmlDepartmentsLeaderLocalServiceBaseImpl {
	// yenlt update 27082010
	public boolean checkUserIsLeader(String userIdString) {
		long userId = Long.parseLong(userIdString);
		boolean flag = false;
		List<PmlDepartmentsLeader> departmentsLeaderList = new ArrayList<PmlDepartmentsLeader>();
		try {
			departmentsLeaderList = PmlDepartmentsLeaderUtil.findByUserId(userId);
		} catch (Exception e) {
			departmentsLeaderList = new ArrayList<PmlDepartmentsLeader>();
//			_log.error(e.getMessage());
		}
		
		if (departmentsLeaderList.size()>0) {
			flag = true;
		}
		return flag;
	}
	// end yenlt update 27082010
}
