package com.sgs.portlet.report_registry_work.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.report_registry_work.model.ReportRegistry;
import com.sgs.portlet.report_registry_work.model.impl.ReportRegistryImpl;

public class ReportRegistryFinderImpl extends BasePersistenceImpl implements ReportRegistryFinder{
	public static String COUNT_REPORT_REGISTRY_BOOK = ReportRegistryFinder.class.getName()+ ".COUNT_REPORT_REGISTRY_BOOK";
	public static String FIND_REPORT_REGISTRY_BOOK = ReportRegistryFinder.class.getName()+ ".FIND_REPORT_REGISTRY_BOOK";
	
	public int countByKeywords(String keywords) throws SystemException {
		String[] reportRegistryCodes = null;
		String[] resultWorks = null;
		String[] programWorks = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			reportRegistryCodes = CustomSQLUtil.keywords(keywords);
			resultWorks = CustomSQLUtil.keywords(keywords);
			programWorks = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return count_report_registry(reportRegistryCodes, resultWorks, programWorks, andOperator);

	}

	public int count_report_registry(String reportRegistryCodes, String resultWorks, String programWorks, boolean andOperator) throws SystemException {
		return count_report_registry(new String[] { reportRegistryCodes }, new String[] { resultWorks }, new String[] { programWorks }, andOperator);

	}

	public int count_report_registry(String[] reportRegistryCodes, String[] resultWorks, String[] programWorks, boolean andOperator) throws SystemException {
		reportRegistryCodes = CustomSQLUtil.keywords(reportRegistryCodes);
		resultWorks = CustomSQLUtil.keywords(resultWorks);
		programWorks = CustomSQLUtil.keywords(programWorks);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_REPORT_REGISTRY_BOOK);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(reportRegistryCode)", StringPool.LIKE, false, reportRegistryCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(resultWork)", StringPool.LIKE, false, resultWorks);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(programWork)", StringPool.LIKE, true, programWorks);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(reportRegistryCodes, 2);
			qpos.add(resultWorks, 2);
			qpos.add(programWorks, 2);

			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

	}

	public List<ReportRegistry> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException {
		String[] reportRegistryCodes = null;
		String[] resultWorks = null;
		String[] programWorks = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			reportRegistryCodes = CustomSQLUtil.keywords(keywords, true);
			resultWorks = CustomSQLUtil.keywords(keywords, true);
			programWorks = CustomSQLUtil.keywords(keywords, true);
		} else {
			andOperator = true;
		}

		return find_report_registry(reportRegistryCodes, resultWorks, programWorks, andOperator, start, end, obc);
	}

	public List<ReportRegistry> find_report_registry(String reportRegistryCodes, String resultWorks, String programWorks, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException {
		return find_report_registry(new String[] { reportRegistryCodes }, new String[] { resultWorks }, new String[] { programWorks },
				andOperator, start, end, obc);
	}

	public List<ReportRegistry> find_report_registry(String[] reportRegistryCodes, String[] resultWorks, String[] programWorks, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		reportRegistryCodes = CustomSQLUtil.keywords(reportRegistryCodes);
		resultWorks = CustomSQLUtil.keywords(resultWorks);
		programWorks = CustomSQLUtil.keywords(programWorks);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_REPORT_REGISTRY_BOOK);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(reportRegistryCode)", StringPool.LIKE, false, reportRegistryCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(resultWork)", StringPool.LIKE, false, resultWorks);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(programWork)", StringPool.LIKE, true, programWorks);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("report_registry_work", ReportRegistryImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(reportRegistryCodes, 2);
			qpos.add(resultWorks, 2);
			qpos.add(programWorks, 2);
			return (List<ReportRegistry>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}
}
