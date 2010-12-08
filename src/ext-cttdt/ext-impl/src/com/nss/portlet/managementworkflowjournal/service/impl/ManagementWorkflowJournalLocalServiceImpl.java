package com.nss.portlet.managementworkflowjournal.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal;
import com.nss.portlet.managementworkflowjournal.service.base.ManagementWorkflowJournalLocalServiceBaseImpl;

public class ManagementWorkflowJournalLocalServiceImpl extends
		ManagementWorkflowJournalLocalServiceBaseImpl {

	public ManagementWorkflowJournal getDateFromBetweenDateTo(Timestamp now)
			throws SystemException {
		ManagementWorkflowJournal managementWorkflowJournal = null;
		List<ManagementWorkflowJournal> res = managementWorkflowJournalFinder.getDateFromBetweenDateTo(now);
		if (res != null && res.size() > 0) {
			ManagementWorkflowJournal workflowJournal = null;
			for(int i=0;i<res.size();i++){
				workflowJournal = res.get(i);
				if(workflowJournal.getDateTo() == null){
					managementWorkflowJournal = workflowJournal;
				}else if(workflowJournal.getDateTo().getTime() >= now.getTime()){
					managementWorkflowJournal = workflowJournal;
				}
			}
			if(managementWorkflowJournal == null){
				managementWorkflowJournal = res.get(res.size()-1);
			}
		}
		return managementWorkflowJournal;
	}

	public int searchCount(String keywords) throws SystemException {
		return managementWorkflowJournalFinder.countByKeywords(keywords);
	}

	public List<ManagementWorkflowJournal> search(String keywords, int start,
			int end, OrderByComparator obc) throws SystemException {
		return managementWorkflowJournalFinder.findByKeywords(keywords, start,
				end, obc);
	}

	public int searchCount(String workflowName, int version, boolean andOperator)
			throws SystemException {
		return managementWorkflowJournalFinder.countManagementWorkflowJournal(
				workflowName, version, andOperator);
	}

	public List<ManagementWorkflowJournal> search(String workflowName,
			int version, boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		return managementWorkflowJournalFinder.findManagementWorkflowJournal(
				workflowName, version, start, end, andOperator, obc);
	}

}
