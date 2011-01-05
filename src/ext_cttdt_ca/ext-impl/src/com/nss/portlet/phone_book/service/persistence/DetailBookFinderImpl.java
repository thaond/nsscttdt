package com.nss.portlet.phone_book.service.persistence;

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
import com.nss.portlet.phone_book.model.DetailBook;
import com.nss.portlet.phone_book.model.impl.DetailBookImpl;

public class DetailBookFinderImpl extends BasePersistenceImpl implements DetailBookFinder{
	
	public static String COUNT_DETAIL_BOOK = DetailBookFinder.class.getName()+ ".COUNT_DETAIL_BOOK";
	public static String FIND_DETAIL_BOOK = DetailBookFinder.class.getName()+ ".FIND_DETAIL_BOOK";
	
	public int countByKeywords(String keywords) throws SystemException {
		String[] detailBookCodes = null;
		String[] detailBookNames = null;
		String[] detailBookDescriptions = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			detailBookCodes = CustomSQLUtil.keywords(keywords);
			detailBookNames = CustomSQLUtil.keywords(keywords);
			detailBookDescriptions = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return count_detail_Book(detailBookCodes, detailBookNames, detailBookDescriptions, andOperator);

	}

	public int count_detail_Book(String detailBookCodes, String detailBookNames, String detailBookDescriptions, boolean andOperator) throws SystemException {
		return count_detail_Book(new String[] { detailBookCodes }, new String[] { detailBookNames }, new String[] { detailBookDescriptions }, andOperator);

	}

	public int count_detail_Book(String[] detailBookCodes, String[] detailBookNames, String[] detailBookDescriptions, boolean andOperator) throws SystemException {
		detailBookCodes = CustomSQLUtil.keywords(detailBookCodes);
		detailBookNames = CustomSQLUtil.keywords(detailBookNames);
		detailBookDescriptions = CustomSQLUtil.keywords(detailBookDescriptions);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_DETAIL_BOOK);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(detailBookCode)", StringPool.LIKE, false, detailBookCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(detailBookName)", StringPool.LIKE, false, detailBookNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(detailDescription)", StringPool.LIKE, true, detailBookDescriptions);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(detailBookCodes, 2);
			qpos.add(detailBookNames, 2);
			qpos.add(detailBookDescriptions, 2);

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

	public List<DetailBook> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException {
		String[] detailBookCodes = null;
		String[] detailBookNames = null;
		String[] detailBookDescriptions = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			detailBookCodes = CustomSQLUtil.keywords(keywords, true);
			detailBookNames = CustomSQLUtil.keywords(keywords, true);
			detailBookDescriptions = CustomSQLUtil.keywords(keywords, true);
		} else {
			andOperator = true;
		}

		return find_detail_book(detailBookCodes, detailBookNames, detailBookDescriptions, andOperator, start, end, obc);
	}

	public List<DetailBook> find_detail_book(String detailBookCodes, String detailBookNames, String detailBookDescriptions, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException {
		return find_detail_book(new String[] { detailBookCodes }, new String[] { detailBookNames }, new String[] { detailBookDescriptions },
				andOperator, start, end, obc);
	}

	public List<DetailBook> find_detail_book(String[] detailBookCodes, String[] detailBookNames, String[] detailBookDescriptions, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		detailBookCodes = CustomSQLUtil.keywords(detailBookCodes);
		detailBookNames = CustomSQLUtil.keywords(detailBookNames);
		detailBookDescriptions = CustomSQLUtil.keywords(detailBookDescriptions);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_DETAIL_BOOK);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(detailBookCode)", StringPool.LIKE, false, detailBookCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(detailBookName)", StringPool.LIKE, false, detailBookNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(detailDescription)", StringPool.LIKE, true, detailBookDescriptions);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("nss_detail_book", DetailBookImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(detailBookCodes, 2);
			qpos.add(detailBookNames, 2);
			qpos.add(detailBookDescriptions, 2);
			return (List<DetailBook>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}
}
