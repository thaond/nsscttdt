/**
 * 
 */

package com.nss.portlet.thong_ke_tin.service.persistence;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.tags.model.TagsAsset;
import com.liferay.portlet.tags.model.impl.TagsAssetImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.nss.portlet.journal.model.JournalArticle;
import com.nss.portlet.journal.model.impl.JournalArticleImpl;
import com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.model.impl.WorkflowJournalArticleImpl;

/**
 * @author Tu
 */
public class NSSTagsAssetFinderImpl extends BasePersistenceImpl
	implements NSSTagsAssetFinder {

	public static String GET_ALL_TAGSASSET_BY_U_G_C =
		NSSTagsAssetFinder.class.getName() + ".GET_ALL_TAGSASSET_BY_U_G_C";

	public static String GET_ALL_TAGSASSET_BY_VOCABULARY =
		NSSTagsAssetFinder.class.getName() + ".GET_ALL_TAGSASSET_BY_VOCABULARY";
	public static String COUNT_ARTICLE_BY_VOCABULARY =
		NSSTagsAssetFinder.class.getName() + ".COUNT_ARTICLE_BY_VOCABULARY";
	public static String COUNT_ARTICLE_APPROVED_BY_VOCABULARY =
		NSSTagsAssetFinder.class.getName() +
			".COUNT_ARTICLE_APPROVED_BY_VOCABULARY";
	public static String GET_NSS_WORKFLOW_BY_VOCABULARY =
		NSSTagsAssetFinder.class.getName() + ".GET_NSS_WORKFLOW_BY_VOCABULARY";

	public static String GET_ARTICLE_BY_VOCABULARY =
		NSSTagsAssetFinder.class.getName() + ".GET_ARTICLE_BY_VOCABULARY";

	public static String GET_ARTICLE_INNER_JOIN_NSS_WORKFLOW =
		NSSTagsAssetFinder.class.getName() +
			".GET_ARTICLE_INNER_JOIN_NSS_WORKFLOW";

	public static String GET_NSS_WORKFLOW_INNER_JOIN_ARTICLE =
		NSSTagsAssetFinder.class.getName() +
			".GET_NSS_WORKFLOW_INNER_JOIN_ARTICLE";

	public static String COUNT_ARTICLE_BY_USERID_AND_DATE =
		NSSTagsAssetFinder.class.getName() +
			".COUNT_ARTICLE_BY_USERID_AND_DATE";

	public static String COUNT_ARTICLE_APPROVED_BY_USERID_AND_DATE =
		NSSTagsAssetFinder.class.getName() +
			".COUNT_ARTICLE_APPROVED_BY_USERID_AND_DATE";

	public int countArticle(
		long userId, Date createdateF, Date createdateT, Date approveddateF,
		Date approveddateT, Date displaydateF, Date displaydateT,
		Date expirationdateF, Date expirationdateT)
		throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_ARTICLE_BY_USERID_AND_DATE);

			if ((createdateF == null) || (createdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.createdate BETWEEN ? AND ?)", "");
			}
			if ((approveddateF == null) || (approveddateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.approveddate BETWEEN ? AND ?)", "");
			}
			if ((displaydateF == null) || (displaydateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.displaydate BETWEEN ? AND ?)", "");
			}
			if ((expirationdateF == null) || (expirationdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.expirationdate BETWEEN ? AND ?)",
						"");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(userId);
			Timestamp timestamp = null;
			if ((createdateF != null) && (createdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(createdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(createdateT);
				qpos.add(timestamp);
			}
			if ((approveddateF != null) && (approveddateT != null)) {
				timestamp = CalendarUtil.getTimestamp(approveddateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(approveddateT);
				qpos.add(timestamp);
			}
			if ((displaydateF != null) && (displaydateT != null)) {
				timestamp = CalendarUtil.getTimestamp(displaydateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(displaydateT);
				qpos.add(timestamp);
			}
			if ((expirationdateF != null) && (expirationdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(expirationdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(expirationdateT);
				qpos.add(timestamp);
			}

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public int countArticleApproved(
		long userId, boolean approved, Date createdateF, Date createdateT,
		Date approveddateF, Date approveddateT, Date displaydateF,
		Date displaydateT, Date expirationdateF, Date expirationdateT)
		throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql =
				CustomSQLUtil.get(COUNT_ARTICLE_APPROVED_BY_USERID_AND_DATE);

			if ((createdateF == null) || (createdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.createdate BETWEEN ? AND ?)", "");
			}
			if ((approveddateF == null) || (approveddateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.approveddate BETWEEN ? AND ?)", "");
			}
			if ((displaydateF == null) || (displaydateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.displaydate BETWEEN ? AND ?)", "");
			}
			if ((expirationdateF == null) || (expirationdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.expirationdate BETWEEN ? AND ?)",
						"");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(userId);
			qpos.add(approved);

			Timestamp timestamp = null;
			if ((createdateF != null) && (createdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(createdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(createdateT);
				qpos.add(timestamp);
			}
			if ((approveddateF != null) && (approveddateT != null)) {
				timestamp = CalendarUtil.getTimestamp(approveddateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(approveddateT);
				qpos.add(timestamp);
			}
			if ((displaydateF != null) && (displaydateT != null)) {
				timestamp = CalendarUtil.getTimestamp(displaydateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(displaydateT);
				qpos.add(timestamp);
			}
			if ((expirationdateF != null) && (expirationdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(expirationdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(expirationdateT);
				qpos.add(timestamp);
			}

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public int countArticleApprovedByVocabulary(
		long vocabularyId, boolean approved, Date createdateF,
		Date createdateT, Date approveddateF, Date approveddateT,
		Date displaydateF, Date displaydateT, Date expirationdateF,
		Date expirationdateT)
		throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql =
				CustomSQLUtil.get(COUNT_ARTICLE_APPROVED_BY_VOCABULARY);

			if ((createdateF == null) || (createdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.createdate BETWEEN ? AND ?)", "");
			}
			if ((approveddateF == null) || (approveddateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.approveddate BETWEEN ? AND ?)", "");
			}
			if ((displaydateF == null) || (displaydateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.displaydate BETWEEN ? AND ?)", "");
			}
			if ((expirationdateF == null) || (expirationdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.expirationdate BETWEEN ? AND ?)",
						"");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(vocabularyId);
			qpos.add(approved);
			Timestamp timestamp = null;
			if ((createdateF != null) && (createdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(createdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(createdateT);
				qpos.add(timestamp);
			}
			if ((approveddateF != null) && (approveddateT != null)) {
				timestamp = CalendarUtil.getTimestamp(approveddateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(approveddateT);
				qpos.add(timestamp);
			}
			if ((displaydateF != null) && (displaydateT != null)) {
				timestamp = CalendarUtil.getTimestamp(displaydateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(displaydateT);
				qpos.add(timestamp);
			}
			if ((expirationdateF != null) && (expirationdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(expirationdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(expirationdateT);
				qpos.add(timestamp);
			}

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public int countArticleByVocabulary(
		long vocabularyId, Date createdateF, Date createdateT,
		Date approveddateF, Date approveddateT, Date displaydateF,
		Date displaydateT, Date expirationdateF, Date expirationdateT)
		throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_ARTICLE_BY_VOCABULARY);

			if ((createdateF == null) || (createdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.createdate BETWEEN ? AND ?)", "");
			}
			if ((approveddateF == null) || (approveddateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.approveddate BETWEEN ? AND ?)", "");
			}
			if ((displaydateF == null) || (displaydateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.displaydate BETWEEN ? AND ?)", "");
			}
			if ((expirationdateF == null) || (expirationdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.expirationdate BETWEEN ? AND ?)",
						"");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(vocabularyId);
			Timestamp timestamp = null;
			if ((createdateF != null) && (createdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(createdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(createdateT);
				qpos.add(timestamp);
			}
			if ((approveddateF != null) && (approveddateT != null)) {
				timestamp = CalendarUtil.getTimestamp(approveddateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(approveddateT);
				qpos.add(timestamp);
			}
			if ((displaydateF != null) && (displaydateT != null)) {
				timestamp = CalendarUtil.getTimestamp(displaydateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(displaydateT);
				qpos.add(timestamp);
			}
			if ((expirationdateF != null) && (expirationdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(expirationdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(expirationdateT);
				qpos.add(timestamp);
			}

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public int countImageByVocabulary(
		long vocabularyId, Date createdateF, Date createdateT,
		Date approveddateF, Date approveddateT, Date displaydateF,
		Date displaydateT, Date expirationdateF, Date expirationdateT)
		throws SystemException {

		int count = 0;
		List<WorkflowJournalArticle> workflowJournalArticles =
			getNSSWorkflowByVoccabulary(
				vocabularyId, createdateF, createdateT, approveddateF,
				approveddateT, displaydateF, displaydateT, expirationdateF,
				expirationdateT);
		for (WorkflowJournalArticle workflowJournalArticle : workflowJournalArticles) {
			count += workflowJournalArticle.getCountImageOfArticle();
		}
		return count;
	}

	public List<JournalArticle> getArticle(
		long userId, Date createdateF, Date createdateT, Date approveddateF,
		Date approveddateT, Date displaydateF, Date displaydateT,
		Date expirationdateF, Date expirationdateT)
		throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ARTICLE_INNER_JOIN_NSS_WORKFLOW);
			if ((createdateF == null) || (createdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.createdate BETWEEN ? AND ?)", "");
			}
			if ((approveddateF == null) || (approveddateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.approveddate BETWEEN ? AND ?)", "");
			}
			if ((displaydateF == null) || (displaydateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.displaydate BETWEEN ? AND ?)", "");
			}
			if ((expirationdateF == null) || (expirationdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.expirationdate BETWEEN ? AND ?)",
						"");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("journalarticle", JournalArticleImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(userId);
			Timestamp timestamp = null;
			if ((createdateF != null) && (createdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(createdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(createdateT);
				qpos.add(timestamp);
			}
			if ((approveddateF != null) && (approveddateT != null)) {
				timestamp = CalendarUtil.getTimestamp(approveddateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(approveddateT);
				qpos.add(timestamp);
			}
			if ((displaydateF != null) && (displaydateT != null)) {
				timestamp = CalendarUtil.getTimestamp(displaydateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(displaydateT);
				qpos.add(timestamp);
			}
			if ((expirationdateF != null) && (expirationdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(expirationdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(expirationdateT);
				qpos.add(timestamp);
			}

			return (List<JournalArticle>) QueryUtil.list(
				q, getDialect(), -1, -1);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<JournalArticle> getArticleByVoccabulary(
		long vocabularyId, Date createdateF, Date createdateT,
		Date approveddateF, Date approveddateT, Date displaydateF,
		Date displaydateT, Date expirationdateF, Date expirationdateT)
		throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ARTICLE_BY_VOCABULARY);
			if ((createdateF == null) || (createdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.createdate BETWEEN ? AND ?)", "");
			}
			if ((approveddateF == null) || (approveddateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.approveddate BETWEEN ? AND ?)", "");
			}
			if ((displaydateF == null) || (displaydateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.displaydate BETWEEN ? AND ?)", "");
			}
			if ((expirationdateF == null) || (expirationdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.expirationdate BETWEEN ? AND ?)",
						"");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("journalarticle", JournalArticleImpl.class);

			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(vocabularyId);
			Timestamp timestamp = null;
			if ((createdateF != null) && (createdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(createdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(createdateT);
				qpos.add(timestamp);
			}
			if ((approveddateF != null) && (approveddateT != null)) {
				timestamp = CalendarUtil.getTimestamp(approveddateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(approveddateT);
				qpos.add(timestamp);
			}
			if ((displaydateF != null) && (displaydateT != null)) {
				timestamp = CalendarUtil.getTimestamp(displaydateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(displaydateT);
				qpos.add(timestamp);
			}
			if ((expirationdateF != null) && (expirationdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(expirationdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(expirationdateT);
				qpos.add(timestamp);
			}

			return (List<JournalArticle>) QueryUtil.list(
				q, getDialect(), -1, -1);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<WorkflowJournalArticle> getNSSWorkflow(
		long userId, Date createdateF, Date createdateT, Date approveddateF,
		Date approveddateT, Date displaydateF, Date displaydateT,
		Date expirationdateF, Date expirationdateT)
		throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_NSS_WORKFLOW_INNER_JOIN_ARTICLE);
			if ((createdateF == null) || (createdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.createdate BETWEEN ? AND ?)", "");
			}
			if ((approveddateF == null) || (approveddateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.approveddate BETWEEN ? AND ?)", "");
			}
			if ((displaydateF == null) || (displaydateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.displaydate BETWEEN ? AND ?)", "");
			}
			if ((expirationdateF == null) || (expirationdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.expirationdate BETWEEN ? AND ?)",
						"");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity(
				"nss_workflow_journal_article",
				WorkflowJournalArticleImpl.class);

			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(userId);
			Timestamp timestamp = null;
			if ((createdateF != null) && (createdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(createdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(createdateT);
				qpos.add(timestamp);
			}
			if ((approveddateF != null) && (approveddateT != null)) {
				timestamp = CalendarUtil.getTimestamp(approveddateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(approveddateT);
				qpos.add(timestamp);
			}
			if ((displaydateF != null) && (displaydateT != null)) {
				timestamp = CalendarUtil.getTimestamp(displaydateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(displaydateT);
				qpos.add(timestamp);
			}
			if ((expirationdateF != null) && (expirationdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(expirationdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(expirationdateT);
				qpos.add(timestamp);
			}

			return (List<WorkflowJournalArticle>) QueryUtil.list(
				q, getDialect(), -1, -1);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<WorkflowJournalArticle> getNSSWorkflowByVoccabulary(
		long vocabularyId, Date createdateF, Date createdateT,
		Date approveddateF, Date approveddateT, Date displaydateF,
		Date displaydateT, Date expirationdateF, Date expirationdateT)
		throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_NSS_WORKFLOW_BY_VOCABULARY);
			if ((createdateF == null) || (createdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.createdate BETWEEN ? AND ?)", "");
			}
			if ((approveddateF == null) || (approveddateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.approveddate BETWEEN ? AND ?)", "");
			}
			if ((displaydateF == null) || (displaydateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.displaydate BETWEEN ? AND ?)", "");
			}
			if ((expirationdateF == null) || (expirationdateT == null)) {
				sql =
					sql.replace(
						"AND (journalarticle.expirationdate BETWEEN ? AND ?)",
						"");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity(
				"nss_workflow_journal_article",
				WorkflowJournalArticleImpl.class);

			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(vocabularyId);
			Timestamp timestamp = null;
			if ((createdateF != null) && (createdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(createdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(createdateT);
				qpos.add(timestamp);
			}
			if ((approveddateF != null) && (approveddateT != null)) {
				timestamp = CalendarUtil.getTimestamp(approveddateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(approveddateT);
				qpos.add(timestamp);
			}
			if ((displaydateF != null) && (displaydateT != null)) {
				timestamp = CalendarUtil.getTimestamp(displaydateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(displaydateT);
				qpos.add(timestamp);
			}
			if ((expirationdateF != null) && (expirationdateT != null)) {
				timestamp = CalendarUtil.getTimestamp(expirationdateF);
				qpos.add(timestamp);
				timestamp = CalendarUtil.getTimestamp(expirationdateT);
				qpos.add(timestamp);
			}

			return (List<WorkflowJournalArticle>) QueryUtil.list(
				q, getDialect(), -1, -1);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<TagsAsset> getTagsAsset(long userId, String articleIds)
		throws SystemException {

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_ALL_TAGSASSET_BY_U_G_C);
			if (articleIds.trim().equals("") || (articleIds == null)) {
				sql = sql.replace("(tagsasset.classpk in ?)", "");
			}
			else {
				sql =
					sql.replace(
						"(tagsasset.classpk in ?)", "(tagsasset.classpk in (" +
							articleIds + "))");
			}
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("tagsasset", TagsAssetImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(userId);

			return (List<TagsAsset>) QueryUtil.list(query, getDialect(), -1, -1);
		}
		catch (Exception e) {
			throw new SystemException();
		}
		finally {
			closeSession(session);
		}
	}

}
