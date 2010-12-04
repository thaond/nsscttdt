
package com.nss.portlet.managementworkflowjournal.service.impl;

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

	public LogWorkflowJournalArticle getLogByResourceTrainsition(
		long resourcePrimkey)
		throws SystemException {

		return logWorkflowJournalArticleFinder.getLogBy_R_T(resourcePrimkey);
	}
}
