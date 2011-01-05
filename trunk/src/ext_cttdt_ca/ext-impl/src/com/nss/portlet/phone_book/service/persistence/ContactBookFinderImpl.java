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
import com.nss.portlet.phone_book.model.ContactBook;
import com.nss.portlet.phone_book.model.impl.ContactBookImpl;

public class ContactBookFinderImpl extends BasePersistenceImpl implements ContactBookFinder{
	
	public static String COUNT_CONTACT_BOOK = ContactBookFinder.class.getName()+ ".COUNT_CONTACT_BOOK";
	public static String FIND_CONTACT_BOOK = ContactBookFinder.class.getName()+ ".FIND_CONTACT_BOOK";
	
	public int countByKeywords(String keywords) throws SystemException {
		String[] contactBookCodes = null;
		String[] contactBookNames = null;
		String[] contactBookDescriptions = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			contactBookCodes = CustomSQLUtil.keywords(keywords);
			contactBookNames = CustomSQLUtil.keywords(keywords);
			contactBookDescriptions = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return count_Contact_Book(contactBookCodes, contactBookNames, contactBookDescriptions, andOperator);

	}

	public int count_Contact_Book(String contactBookCodes, String contactBookNames, String contactBookDescriptions, boolean andOperator) throws SystemException {
		return count_Contact_Book(new String[] { contactBookCodes }, new String[] { contactBookNames }, new String[] { contactBookDescriptions }, andOperator);

	}

	public int count_Contact_Book(String[] contactBookCodes, String[] contactBookNames, String[] contactBookDescriptions, boolean andOperator) throws SystemException {
		contactBookCodes = CustomSQLUtil.keywords(contactBookCodes);
		contactBookNames = CustomSQLUtil.keywords(contactBookNames);
		contactBookDescriptions = CustomSQLUtil.keywords(contactBookDescriptions);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_CONTACT_BOOK);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(contactBookCode)", StringPool.LIKE, false, contactBookCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(contactBookName)", StringPool.LIKE, false, contactBookNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(contactDescription)", StringPool.LIKE, true, contactBookDescriptions);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(contactBookCodes, 2);
			qpos.add(contactBookNames, 2);
			qpos.add(contactBookDescriptions, 2);

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

	public List<ContactBook> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException {
		String[] contactBookCodes = null;
		String[] contactBookNames = null;
		String[] contactBookDescriptions = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			contactBookCodes = CustomSQLUtil.keywords(keywords, true);
			contactBookNames = CustomSQLUtil.keywords(keywords, true);
			contactBookDescriptions = CustomSQLUtil.keywords(keywords, true);
		} else {
			andOperator = true;
		}

		return find_contact_book(contactBookCodes, contactBookNames, contactBookDescriptions, andOperator, start, end, obc);
	}

	public List<ContactBook> find_contact_book(String contactBookCodes, String contactBookNames, String contactBookDescriptions, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException {
		return find_contact_book(new String[] { contactBookCodes }, new String[] { contactBookNames }, new String[] { contactBookDescriptions },
				andOperator, start, end, obc);
	}

	public List<ContactBook> find_contact_book(String[] contactBookCodes, String[] contactBookNames, String[] contactBookDescriptions, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		contactBookCodes = CustomSQLUtil.keywords(contactBookCodes);
		contactBookNames = CustomSQLUtil.keywords(contactBookNames);
		contactBookDescriptions = CustomSQLUtil.keywords(contactBookDescriptions);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_CONTACT_BOOK);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(contactBookCode)", StringPool.LIKE, false, contactBookCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(contactBookName)", StringPool.LIKE, false, contactBookNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(contactDescription)", StringPool.LIKE, true, contactBookDescriptions);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("nss_contact_book", ContactBookImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(contactBookCodes, 2);
			qpos.add(contactBookNames, 2);
			qpos.add(contactBookDescriptions, 2);
			return (List<ContactBook>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}
}
