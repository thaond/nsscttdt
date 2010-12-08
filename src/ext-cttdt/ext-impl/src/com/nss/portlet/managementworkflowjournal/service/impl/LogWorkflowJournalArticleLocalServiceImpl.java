
package com.nss.portlet.managementworkflowjournal.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.service.base.LogWorkflowJournalArticleLocalServiceBaseImpl;
import com.nss.portlet.managementworkflowjournal.service.persistence.LogWorkflowJournalArticleUtil;

public class LogWorkflowJournalArticleLocalServiceImpl
	extends LogWorkflowJournalArticleLocalServiceBaseImpl {

	public int countLogWorkflowJournalArticle(long resourcePrimkey) {

		int res = 0;
		try {
			res =
				LogWorkflowJournalArticleUtil.findByResourcePrimkey(
					resourcePrimkey).size();
		}
		catch (SystemException e) {
			res = 0;
		}
		return res;
	}

	public List<LogWorkflowJournalArticle> getAllLog(long resourcePrimkey)
		throws SystemException {

		return logWorkflowJournalArticleFinder.getAllLog(resourcePrimkey);
	}

	public LogWorkflowJournalArticle getLogByResourceTrainsition(
		long resourcePrimkey)
		throws SystemException {

		return logWorkflowJournalArticleFinder.getLogBy_R_T(resourcePrimkey);
	}
}
