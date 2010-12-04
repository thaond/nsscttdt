package com.nss.portlet.department.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.service.base.PmlUserLocalServiceBaseImpl;


public class PmlUserLocalServiceImpl extends PmlUserLocalServiceBaseImpl {
	public List<PmlUser> findByPositionId(String positionId) throws SystemException {
		return pmlUserPersistence.findByPositionId(positionId);
	}
	
	public List<PmlUser> findUserListByDepartment(String departmentsId, int start, int end) throws SystemException{
		return pmlUserFinder.findUserListByDepartment(departmentsId, start, end);
	}
	
	public int countUserListByDepartment(String departmentsId) throws Exception {
		return pmlUserFinder.countUserListByDepartment(departmentsId);
	}
	
	public List<PmlUser> findByDepartmentsId_Active(String departmentsId, boolean active) throws SystemException {
		return pmlUserPersistence.findByDepartmentsId_Active(departmentsId, active);
	}
	
	public List<PmlUser> findByDepartmentsId(String departmentsId) throws SystemException {
		return pmlUserPersistence.findByDepartmentsId(departmentsId);
	}
	
	
}
