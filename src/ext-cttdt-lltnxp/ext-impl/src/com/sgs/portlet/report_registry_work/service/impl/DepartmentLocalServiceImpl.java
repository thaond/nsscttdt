package com.sgs.portlet.report_registry_work.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.report_registry_work.model.Department;
import com.sgs.portlet.report_registry_work.model.ReportRegistry;
import com.sgs.portlet.report_registry_work.service.base.DepartmentLocalServiceBaseImpl;


public class DepartmentLocalServiceImpl extends DepartmentLocalServiceBaseImpl {
	
	public List<ReportRegistry> getReportRegistries(long departmentId) throws SystemException{
		return departmentPersistence.getReportRegistries(departmentId);
	}
	public int countByKeyword(String keywords) throws SystemException{
		return departmentFinder.countByKeywords(keywords);
	}
	public List<Department> findByKeyword(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return departmentFinder.findByKeywords(keywords, start, end, obc);
	}
	public int countDepartment(String departmentCodes, String departmentNames, String departmentDescriptions, boolean andOperator) throws SystemException{
		return departmentFinder.count_department(departmentCodes, departmentNames, departmentDescriptions, andOperator);
	}
	public List<Department> findDepartment(String departmentCodes, String departmentNames, String departmentDescriptions, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
		return departmentFinder.find_department(departmentCodes, departmentNames, departmentDescriptions, start, end, andOperator, obc);
	}
}
