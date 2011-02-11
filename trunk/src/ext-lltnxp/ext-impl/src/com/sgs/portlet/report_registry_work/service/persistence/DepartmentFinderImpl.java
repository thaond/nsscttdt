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
import com.sgs.portlet.report_registry_work.model.Department;
import com.sgs.portlet.report_registry_work.model.impl.DepartmentImpl;

public class DepartmentFinderImpl extends BasePersistenceImpl implements DepartmentFinder{
	public static String COUNT_DEPARTMENT_BOOK = DepartmentFinder.class.getName()+ ".COUNT_DEPARTMENT_BOOK";
	public static String FIND_DEPARTMENT_BOOK = DepartmentFinder.class.getName()+ ".FIND_DEPARTMENT_BOOK";
	
	public int countByKeywords(String keywords) throws SystemException {
		String[] departmentCodes = null;
		String[] departmentNames = null;
		String[] departmentDescriptions = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			departmentCodes = CustomSQLUtil.keywords(keywords);
			departmentNames = CustomSQLUtil.keywords(keywords);
			departmentDescriptions = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return count_department(departmentCodes, departmentNames, departmentDescriptions, andOperator);

	}

	public int count_department(String departmentCodes, String departmentNames, String departmentDescriptions, boolean andOperator) throws SystemException {
		return count_department(new String[] { departmentCodes }, new String[] { departmentNames }, new String[] { departmentDescriptions }, andOperator);

	}

	public int count_department(String[] departmentCodes, String[] departmentNames, String[] departmentDescriptions, boolean andOperator) throws SystemException {
		departmentCodes = CustomSQLUtil.keywords(departmentCodes);
		departmentNames = CustomSQLUtil.keywords(departmentNames);
		departmentDescriptions = CustomSQLUtil.keywords(departmentDescriptions);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_DEPARTMENT_BOOK);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(departmentCode)", StringPool.LIKE, false, departmentCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(departmentName)", StringPool.LIKE, false, departmentNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(departmentDescription)", StringPool.LIKE, true, departmentDescriptions);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(departmentCodes, 2);
			qpos.add(departmentNames, 2);
			qpos.add(departmentDescriptions, 2);

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

	public List<Department> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException {
		String[] departmentCodes = null;
		String[] departmentNames = null;
		String[] departmentDescriptions = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			departmentCodes = CustomSQLUtil.keywords(keywords, true);
			departmentNames = CustomSQLUtil.keywords(keywords, true);
			departmentDescriptions = CustomSQLUtil.keywords(keywords, true);
		} else {
			andOperator = true;
		}

		return find_department(departmentCodes, departmentNames, departmentDescriptions, andOperator, start, end, obc);
	}

	public List<Department> find_department(String departmentCodes, String departmentNames, String departmentDescriptions, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException {
		return find_department(new String[] { departmentCodes }, new String[] { departmentNames }, new String[] { departmentDescriptions },
				andOperator, start, end, obc);
	}

	public List<Department> find_department(String[] departmentCodes, String[] departmentNames, String[] departmentDescriptions, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		departmentCodes = CustomSQLUtil.keywords(departmentCodes);
		departmentNames = CustomSQLUtil.keywords(departmentNames);
		departmentDescriptions = CustomSQLUtil.keywords(departmentDescriptions);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_DEPARTMENT_BOOK);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(departmentCode)", StringPool.LIKE, false, departmentCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(departmentName)", StringPool.LIKE, false, departmentNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(departmentDescription)", StringPool.LIKE, true, departmentDescriptions);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("department", DepartmentImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(departmentCodes, 2);
			qpos.add(departmentNames, 2);
			qpos.add(departmentDescriptions, 2);
			return (List<Department>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}
}
