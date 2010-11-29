package com.nss.portlet.managementworkflowjournal.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal;
import com.nss.portlet.managementworkflowjournal.service.base.ManagementWorkflowJournalLocalServiceBaseImpl;


public class ManagementWorkflowJournalLocalServiceImpl
    extends ManagementWorkflowJournalLocalServiceBaseImpl {
	
	public ManagementWorkflowJournal getDateFromBetweenDateTo(Timestamp now ) throws SystemException{
		 List<ManagementWorkflowJournal> res = managementWorkflowJournalFinder.getDateFromBetweenDateTo(now);
		 if (res != null && res.size() > 0) {
			 return res.get(0);
		 }
		return null;
	}
	
	public int searchCount(String keywords) throws SystemException{
		return managementWorkflowJournalFinder.countByKeywords(keywords);
	}
	
	public List<ManagementWorkflowJournal> search(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return managementWorkflowJournalFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public int searchCount(String workflowName,int version , boolean andOperator) throws SystemException {
		return managementWorkflowJournalFinder.countManagementWorkflowJournal(workflowName, version, andOperator);
	}
	
	public List<ManagementWorkflowJournal> search(String workflowName,int version, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return managementWorkflowJournalFinder.findManagementWorkflowJournal(workflowName, version, start, end, andOperator, obc);
	}
	
	
}
