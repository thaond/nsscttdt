package com.nss.portlet.department.service.impl;

import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
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
	
	public String getFullName(long userId) {
		User user = null;
		String fullName = "";
		try {
			user = UserLocalServiceUtil.getDefaultUser(userId);
			fullName = user.getLastName() + " " + user.getMiddleName() + " " + user.getFirstName();
		} catch (PortalException e) {
			fullName = "";
		} catch (SystemException e) {
			fullName = "";
		}
		return fullName;
	}
	
	public List<User> listUserTheoDoiHoSo(int start, int end, OrderByComparator obc) throws SystemException {
		return pmlUserFinder.listUserTheoDoiHoSo(start, end, obc);
	}
	
	public int countUserTheoDoiHoSo() throws SystemException {
		return pmlUserFinder.countUserTheoDoiHoSo();
	}
}
