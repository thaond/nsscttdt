package com.nss.portlet.department.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.department.model.PmlDepartmentsLeader;
import com.nss.portlet.department.service.base.PmlDepartmentsLeaderLocalServiceBaseImpl;


public class PmlDepartmentsLeaderLocalServiceImpl
    extends PmlDepartmentsLeaderLocalServiceBaseImpl {
	public List<PmlDepartmentsLeader> findByDepartmentsId_UserId(String departmentsId, long userId) {
		List<PmlDepartmentsLeader> list = new ArrayList<PmlDepartmentsLeader>();
		try {
			list = pmlDepartmentsLeaderPersistence.findByDepartmentsId_UserId(departmentsId, userId);
		} catch (SystemException e) {
			System.out.println("CAN NOT FIND PMLDEPARTMENTLEADER WITH DEPARTMENTSID: "+ departmentsId + " , AND USERID: " + userId);
			list = new ArrayList<PmlDepartmentsLeader>();
		}
		
		return list;
	}
	
	public List<PmlDepartmentsLeader> findByDepartmentsId(String departmentsId) throws SystemException {
		return pmlDepartmentsLeaderPersistence.findByDepartmentsId(departmentsId);
	}
	
}
