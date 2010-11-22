package com.nss.portlet.image_signer.service.persistence;

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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.UserImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class ImageSignerFinderImpl extends BasePersistenceImpl implements
		ImageSignerFinder {
	public static String FIND_BY_NAME = ImageSignerFinder.class.getName()
			+ ".FIND_BY_NAME";
	public static String COUNT_BY_NAME = ImageSignerFinder.class.getName()
			+ ".COUNT_BY_NAME";
	public static String COUNT_USER_IMAGE = ImageSignerFinder.class.getName()
			+ ".COUNT_USER_IMAGE";
	public static String FIND_USER_IMAGE = ImageSignerFinder.class.getName()
			+ ".FIND_USER_IMAGE";


	public int countByName(String name) throws SystemException {
		name = StringUtil.lowerCase(name);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_NAME);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(name);
			qPos.add(name);
			Iterator<Long> it = q.list().iterator();
			if (it.hasNext()) {
				Long count = it.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}

	}

	public List<User> findBy(String name, int start, int end,
			OrderByComparator obc) throws SystemException {
		name = StringUtil.lowerCase(name);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_NAME);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("user_", UserImpl.class);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(name);
			qPos.add(name);
			List<User> products = (List<User>) QueryUtil.list(q,
					getDialect(), start, end);
			return products;
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}

	// --------------------------------------------------------
	public int count_User_Image(String firstnames, String middlenames,
			String lastnames, boolean andOperator) throws SystemException {
		return count_User_Image(new String[] { firstnames },
				new String[] { middlenames }, new String[] { lastnames },
				andOperator);

	}
	
	public int count_User_Image(String[] firstnames, String[] middlenames,
			String[] lastnames, boolean andOperator) throws SystemException {
		firstnames = CustomSQLUtil.keywords(firstnames);
		middlenames = CustomSQLUtil.keywords(middlenames);
		lastnames = CustomSQLUtil.keywords(lastnames);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_USER_IMAGE);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(firstname)",
					StringPool.LIKE, false, firstnames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(middlename)",
					StringPool.LIKE, false, middlenames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(lastname)",
					StringPool.LIKE, true, lastnames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(firstnames, 2);
			qpos.add(middlenames, 2);
			qpos.add(lastnames, 2);

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

	public List<User> find_user_Image(String firstnames, String middlenames,
			String lastnames, int start, int end, boolean andOperator,
			OrderByComparator obc) throws SystemException {
		return find_user_Image(new String[] { firstnames },
				new String[] { middlenames }, new String[] { lastnames },
				andOperator, start, end, obc);
	}

	public List<User> find_user_Image(String[] firstnames,
			String[] middlenames, String[] lastnames, boolean andOperator,
			int start, int end, OrderByComparator obc) throws SystemException {
		firstnames = CustomSQLUtil.keywords(firstnames);
		middlenames = CustomSQLUtil.keywords(middlenames);
		lastnames = CustomSQLUtil.keywords(lastnames);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_USER_IMAGE);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(firstname)",
					StringPool.LIKE, false, firstnames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(middlename)",
					StringPool.LIKE, false, middlenames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(lastname)",
					StringPool.LIKE, true, lastnames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("user_", UserImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(firstnames, 2);
			qpos.add(middlenames, 2);
			qpos.add(lastnames, 2);
			return (List<User>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}

}
