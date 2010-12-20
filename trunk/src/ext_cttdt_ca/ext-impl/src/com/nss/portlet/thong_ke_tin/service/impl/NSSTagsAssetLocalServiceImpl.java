
package com.nss.portlet.thong_ke_tin.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portlet.tags.model.TagsAsset;
import com.nss.portlet.journal.model.JournalArticle;
import com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle;
import com.nss.portlet.thong_ke_tin.service.base.NSSTagsAssetLocalServiceBaseImpl;

public class NSSTagsAssetLocalServiceImpl
	extends NSSTagsAssetLocalServiceBaseImpl {

	public int countArticle(
		long userId, Date createdateF, Date createdateT, Date approveddateF,
		Date approveddateT, Date displaydateF, Date displaydateT,
		Date expirationdateF, Date expirationdateT)
		throws SystemException {

		return nssTagsAssetFinder.countArticle(
			userId, createdateF, createdateT, approveddateF, approveddateT,
			displaydateF, displaydateT, expirationdateF, expirationdateT);
	}

	public int countArticleApproved(
		long userId, boolean approved, Date createdateF, Date createdateT,
		Date approveddateF, Date approveddateT, Date displaydateF,
		Date displaydateT, Date expirationdateF, Date expirationdateT)
		throws SystemException {

		return nssTagsAssetFinder.countArticleApproved(
			userId, approved, createdateF, createdateT, approveddateF,
			approveddateT, displaydateF, displaydateT, expirationdateF,
			expirationdateT);
	}

	public int countArticleApprovedByVocabulary(
		long vocabularyId, boolean approved, Date createdateF,
		Date createdateT, Date approveddateF, Date approveddateT,
		Date displaydateF, Date displaydateT, Date expirationdateF,
		Date expirationdateT)
		throws SystemException {

		return nssTagsAssetFinder.countArticleApprovedByVocabulary(
			vocabularyId, approved, createdateF, createdateT, approveddateF,
			approveddateT, displaydateF, displaydateT, expirationdateF,
			expirationdateT);
	}

	public int countArticleByVocabulary(
		long vocabularyId, Date createdateF, Date createdateT,
		Date approveddateF, Date approveddateT, Date displaydateF,
		Date displaydateT, Date expirationdateF, Date expirationdateT)
		throws SystemException {

		return nssTagsAssetFinder.countArticleByVocabulary(
			vocabularyId, createdateF, createdateT, approveddateF,
			approveddateT, displaydateF, displaydateT, expirationdateF,
			expirationdateT);
	}

	public int countArticleImage(
		long userId, Date createdateF, Date createdateT, Date approveddateF,
		Date approveddateT, Date displaydateF, Date displaydateT,
		Date expirationdateF, Date expirationdateT)
		throws SystemException {

		int count = 0;
		List<WorkflowJournalArticle> workflowJournalArticles =
			getNSSWorkflow(
				userId, createdateF, createdateT, approveddateF, approveddateT,
				displaydateF, displaydateT, expirationdateF, expirationdateT);
		for (WorkflowJournalArticle journalArticle : workflowJournalArticles) {
			count += journalArticle.getCountImageOfArticle();
		}
		return count;
	}

	public int countImageByVocabulary(
		long vocabularyId, Date createdateF, Date createdateT,
		Date approveddateF, Date approveddateT, Date displaydateF,
		Date displaydateT, Date expirationdateF, Date expirationdateT)
		throws SystemException {

		return nssTagsAssetFinder.countImageByVocabulary(
			vocabularyId, createdateF, createdateT, approveddateF,
			approveddateT, displaydateF, displaydateT, expirationdateF,
			expirationdateT);
	}

	public List<JournalArticle> getAllArticleByVocabulary(
		long vocabularyId, Date createdateF, Date createdateT,
		Date approveddateF, Date approveddateT, Date displaydateF,
		Date displaydateT, Date expirationdateF, Date expirationdateT)
		throws SystemException {

		return nssTagsAssetFinder.getArticleByVoccabulary(
			vocabularyId, createdateF, createdateT, approveddateF,
			approveddateT, displaydateF, displaydateT, expirationdateF,
			expirationdateT);
	}

	public List<JournalArticle> getArticle(
		long userId, Date createdateF, Date createdateT, Date approveddateF,
		Date approveddateT, Date displaydateF, Date displaydateT,
		Date expirationdateF, Date expirationdateT)
		throws SystemException {

		return nssTagsAssetFinder.getArticle(
			userId, createdateF, createdateT, approveddateF, approveddateT,
			displaydateF, displaydateT, expirationdateF, expirationdateT);
	}

	public List<WorkflowJournalArticle> getNSSWorkflow(
		long userId, Date createdateF, Date createdateT, Date approveddateF,
		Date approveddateT, Date displaydateF, Date displaydateT,
		Date expirationdateF, Date expirationdateT)
		throws SystemException {

		return nssTagsAssetFinder.getNSSWorkflow(
			userId, createdateF, createdateT, approveddateF, approveddateT,
			displaydateF, displaydateT, expirationdateF, expirationdateT);
	}

	public List<WorkflowJournalArticle> getNSSWorkflowByVoccabulary(
		long vocabularyId, Date createdateF, Date createdateT,
		Date approveddateF, Date approveddateT, Date displaydateF,
		Date displaydateT, Date expirationdateF, Date expirationdateT)
		throws SystemException {

		return nssTagsAssetFinder.getNSSWorkflowByVoccabulary(
			vocabularyId, createdateF, createdateT, approveddateF,
			approveddateT, displaydateF, displaydateT, expirationdateF,
			expirationdateT);
	}

	public List<TagsAsset> getTagsAsset(long userId, String articleIds)
		throws SystemException {

		return nssTagsAssetFinder.getTagsAsset(userId, articleIds);
	}
}
