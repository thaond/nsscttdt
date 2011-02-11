package com.sgs.portlet.report_registry_work.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.report_registry_work.model.ReportRegistry;
import com.sgs.portlet.report_registry_work.model.ResultProgram;
import com.sgs.portlet.report_registry_work.service.base.ReportRegistryLocalServiceBaseImpl;


public class ReportRegistryLocalServiceImpl extends ReportRegistryLocalServiceBaseImpl {
	
	public List<ResultProgram> getResultPrograms(long reportRegistryId) throws SystemException{
		return reportRegistryPersistence.getResultPrograms(reportRegistryId);
	}
	
	public int countReportRegistry(String reportRegistryCodes, String userCreates, String resultWorks, String programWorks, Long departmentId, boolean andOperator) throws SystemException{
		return reportRegistryFinder.count_report_registry(reportRegistryCodes, userCreates, resultWorks, programWorks, departmentId, andOperator);
	}
	
	public List<ReportRegistry> findReportRegistry(String reportRegistryCodes, String userCreates, String resultWorks, String programWorks, Long departmentId, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
		return reportRegistryFinder.find_report_registry(reportRegistryCodes, userCreates, resultWorks, programWorks, departmentId, start, end, andOperator, obc);
	}
	
	public int countReportRegistryTest(String reportRegistryCodes, String userCreates, String resultWorks, String programWorks, long departmentId, String dateFrom, String dateTo, boolean andOperator) throws SystemException{
		return reportRegistryFinder.count_report_registry_test(reportRegistryCodes, userCreates, resultWorks, programWorks, departmentId, dateFrom, dateTo, andOperator);
	}
	
	public List<ReportRegistry> findReportRegistryTest(String reportRegistryCodes, String userCreates, String resultWorks, String programWorks, long departmentId, String dateFrom, String dateTo, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
		return reportRegistryFinder.find_report_registry_test(reportRegistryCodes, userCreates, resultWorks, programWorks, departmentId, dateFrom, dateTo, start, end, andOperator, obc);
	}
}
