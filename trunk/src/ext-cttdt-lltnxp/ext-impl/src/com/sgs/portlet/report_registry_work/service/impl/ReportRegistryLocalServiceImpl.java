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
	public int countByKeyword(String keywords) throws SystemException{
		return reportRegistryFinder.countByKeywords(keywords);
	}
	public List<ReportRegistry> findByKeyword(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return reportRegistryFinder.findByKeywords(keywords, start, end, obc);
	}
	public int countReportRegistry(String reportRegistryCodes, String resultWorks, String programWorks, boolean andOperator) throws SystemException{
		return reportRegistryFinder.count_report_registry(reportRegistryCodes, resultWorks, programWorks, andOperator);
	}
	public List<ReportRegistry> findReportRegistry(String reportRegistryCodes, String resultWorks, String programWorks, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
		return reportRegistryFinder.find_report_registry(reportRegistryCodes, resultWorks, programWorks, start, end, andOperator, obc);
	}
}
