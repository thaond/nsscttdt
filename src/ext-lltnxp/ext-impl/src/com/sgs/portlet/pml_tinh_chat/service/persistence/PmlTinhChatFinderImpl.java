package com.sgs.portlet.pml_tinh_chat.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
//import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
//import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
//import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
//import com.ext.portlet.odmodule.service.persistence.ODTypeFinder;
import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat;
import com.sgs.portlet.pml_tinh_chat.model.impl.PmlTinhChatImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

//import java.sql.Timestamp;

//import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * <a href="PmlTinhChatFinderImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Hai Trieu
 *
 */
public class PmlTinhChatFinderImpl
	extends BasePersistenceImpl implements PmlTinhChatFinder {

	public static String COUNT_BY_C_G =
		PmlTinhChatFinder.class.getName() + ".countByC_G";

	public static String FIND_BY_C_G =
		PmlTinhChatFinder.class.getName() + ".findByC_G";

	public int countByC_G(boolean andOperator)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_C_G);
/*
			if (groupId <= 0) {
				sql = StringUtil.replace(sql, "(groupId = ?) AND", "");
			}
*/
			// Replace sql operator
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			// Transfer variable value
/*			
			qPos.add(companyId);

			if (groupId > 0) {
				qPos.add(groupId);
			}
*/
			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

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

	public List<PmlTinhChat> findByC_G(boolean andOperator, 
			int start, int end, OrderByComparator obc)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_C_G);
/*
			if (groupId <= 0) {
				sql = StringUtil.replace(sql, "(groupId = ?) AND", "");
			}
*/
			// Replace sql operator
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			if (obc != null) {
				sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			}

			SQLQuery q = session.createSQLQuery(sql);

			//q.addEntity("PmlTinhChat", PmlTinhChatImpl.class);
			
			q.addEntity("pml_tinh_chat", PmlTinhChatImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			// Transfer variable value
/*			
			qPos.add(companyId);

			if (groupId > 0) {
				qPos.add(groupId);
			}
*/
			return (List<PmlTinhChat>) QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}