/**
 * 
 */

package com.sgs.portlet.recievergroup.service.persistence;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.UserImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * @author canhminh
 */
public class RecieverFinderImpl extends BasePersistenceImpl
	implements RecieverFinder {

	public static final String FIND_USERS_BY_FULLNAME_SCREENNAME =
		RecieverFinder.class.getName() + ".findUsersByFullname_ScreenName";

	public List<User> findUserByFullName(long companyId, String name)
		throws SystemException {

		boolean andOperator = false;
		String[] names = null;
		if ((name != null) && ((name = name.trim()).length() > 0)) {
			names = new String[] {
				name
			};
		}
		else {
			andOperator = true;
		}
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_USERS_BY_FULLNAME_SCREENNAME);

			if (companyId < 1) {
				sql = StringUtil.replace(sql, "(User_.companyId = ?) AND", "");
			}

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("User", UserImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			if (companyId > 0) {
				qPos.add(companyId);
			}
			qPos.add(false);
			qPos.add(names, 4);
			qPos.add(true);

			return (List<User>) QueryUtil.list(q, getDialect(), 0, 100);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}
