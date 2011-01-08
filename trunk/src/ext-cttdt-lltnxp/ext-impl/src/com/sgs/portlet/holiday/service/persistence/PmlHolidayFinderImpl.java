package com.sgs.portlet.holiday.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.sgs.portlet.holiday.model.PmlHoliday;
import com.sgs.portlet.holiday.model.impl.PmlHolidayImpl;

public class PmlHolidayFinderImpl extends BasePersistenceImpl implements PmlHolidayFinder {
	
	/**
	 * phmphuc 31/05/2010
	 * lay danh sach ngay le cho search-container 
	 */
	public List<PmlHoliday> findListPmlHoliday(int start, int end) throws SystemException{
		
		Session session = null;

		try {
			session = openSession();

			String sql = " SELECT *";
			
			sql += " FROM pml_holiday";
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlHoliday", PmlHolidayImpl.class);

			return (List<PmlHoliday>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public int countListPmlHoliday() throws Exception {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT COUNT(DISTINCT(holidayid)) AS COUNT_VALUE";
			
			sql += " FROM pml_holiday";
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			Long count = null;

			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				count = itr.next();
			}

			if (count == null) {
				count = new Long(0);
			}

			return count.intValue();
		} catch (Exception e) {
			throw processException(e);
		} finally {
			closeSession(session);
		}
	}

}
