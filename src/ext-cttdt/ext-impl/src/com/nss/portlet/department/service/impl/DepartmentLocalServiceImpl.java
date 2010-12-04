package com.nss.portlet.department.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.nss.portlet.department.DepartmentCanNotDeleteException;
import com.nss.portlet.department.DepartmentCodeSameCodeException;
import com.nss.portlet.department.model.Department;
import com.nss.portlet.department.model.PmlDepartmentsLeader;
import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.service.PmlDepartmentsLeaderLocalServiceUtil;
import com.nss.portlet.department.service.PmlUserLocalServiceUtil;
import com.nss.portlet.department.service.base.DepartmentLocalServiceBaseImpl;
import com.nss.portlet.documentfield.model.PmlField;
import com.nss.portlet.documentfield.service.PmlFieldLocalServiceUtil;
import com.nss.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil;


public class DepartmentLocalServiceImpl extends DepartmentLocalServiceBaseImpl {
	public List<Department> findDepartmentsByDepartmentParentId() throws SystemException{
		return departmentFinder.findDepartmentsByDepartmentParentId();
	}
	
	public List<Department> findByAgencyId(String agencyId) throws SystemException{
		return departmentPersistence.findByAgencyId(agencyId);
	}
	
	public int searchCount(String keywords) throws SystemException{
		return departmentFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String pmlDepartmentCode, String pmlDepartmentName, String pmlDepartmentAbbreviateName, boolean andOperator) throws SystemException{
		return departmentFinder.countByPmlDepartment(pmlDepartmentCode, pmlDepartmentName, pmlDepartmentAbbreviateName, andOperator);
	}
	
	public List<Department> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return departmentFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<Department> search(String pmlDepartmentCode, String pmlDepartmentName, String pmlDepartmentAbbreviateName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return departmentFinder.findByPmlDepartment(pmlDepartmentCode, pmlDepartmentName, pmlDepartmentAbbreviateName, andOperator, start, end, obc);
	}
	
	public Department addDepartment(String departmentsCode, String departmentsName, String description, 
			String active, String agencyId, String abbreviateName,
			String departmentsParentId) throws SystemException, PortalException {

			validateForAdd(departmentsCode);
			
			String departmentId = "";
			departmentId = IdTemplateLocalServiceUtil.generatedId(Department.class);
			
			Department department = departmentPersistence.create(departmentId);
			
			department.setDepartmentsCode(departmentsCode);
			department.setDepartmentsName(departmentsName);
			department.setDescription(description);
			department.setActive(active);
			department.setActive(active);
			department.setAgencyId(agencyId);
			department.setAbbreviateName(abbreviateName);
			department.setDepartmentsParentId(departmentsParentId);
			
			departmentPersistence.update(department, false);
			
			return department;
	}
	
	protected void validateForAdd(String departmentsCode) throws PortalException, SystemException {
		
		if (Validator.isNull(departmentsCode)) {
			throw new DepartmentCodeSameCodeException();
		}
		
		List<Department> list = departmentFinder.findDepartmentsByCodeForValidate(departmentsCode);
		if (!list.isEmpty()) {
			departmentsCode = departmentsCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (departmentsCode.equalsIgnoreCase(list.get(idx).getDepartmentsCode().trim())) {
					throw new DepartmentCodeSameCodeException();
				}
			}
		}
	}
	
	public void removeDepartment(String departmentId) throws SystemException, PortalException {
		List<PmlDepartmentsLeader> departmentLeaderList = new ArrayList<PmlDepartmentsLeader>();
		List<PmlField> fieldList = new ArrayList<PmlField>();
		List<PmlUser> pmlUserList = new ArrayList<PmlUser>();
		try {
			departmentLeaderList = PmlDepartmentsLeaderLocalServiceUtil.findByDepartmentsId(departmentId);
			fieldList = PmlFieldLocalServiceUtil.findByDepartmentsId(departmentId);
			pmlUserList = PmlUserLocalServiceUtil.findByDepartmentsId(departmentId);
		} catch (Exception e) {
			
		}
		validateDepartment(departmentLeaderList.size(), fieldList.size(), pmlUserList.size());
		departmentPersistence.remove(departmentId);
	}
	
	protected void validateDepartment(int departmentLeaderSize, int fieldSize, int pmlUserSize)
	throws PortalException, SystemException {
	
		if (departmentLeaderSize != 0) {
			throw new DepartmentCanNotDeleteException();
		} 
		if (fieldSize != 0) {
			throw new DepartmentCanNotDeleteException();
		} 
		if (pmlUserSize != 0) {
			throw new DepartmentCanNotDeleteException();
		} 
	}
}
