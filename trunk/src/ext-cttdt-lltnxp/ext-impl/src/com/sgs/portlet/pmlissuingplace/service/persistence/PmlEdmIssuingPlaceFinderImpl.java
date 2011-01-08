/**
 * Dinh nghia cac ham de tuong tac hibernate
 * 
 * @author XUAN CONG
 */

package com.sgs.portlet.pmlissuingplace.service.persistence;

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
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.model.impl.PmlEdmIssuingPlaceImpl;

@SuppressWarnings("unchecked")
public class PmlEdmIssuingPlaceFinderImpl extends BasePersistenceImpl
	implements PmlEdmIssuingPlaceFinder {

	public static String FIND_BY_MA_TEN =
		PmlEdmIssuingPlaceFinder.class.getName() + ".findBy_MA_TEN";
	public static String COUNT_BY_MA_TEN =
		PmlEdmIssuingPlaceFinder.class.getName() + ".countBy_MA_TEN";

	public int countByKeywords(String keywords)
		throws SystemException {

		String[] codes = null;
		String[] names = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			codes = CustomSQLUtil.keywords(keywords, true);
			names = CustomSQLUtil.keywords(keywords, true);
		}
		else {
			andOperator = true;
		}
		return countIssuingPlace(codes, names, andOperator);
	}

	public int countIssuingPlace(String codes, String names, boolean andOperator)
		throws SystemException {

		return countIssuingPlace(new String[] {
			codes
		}, new String[] {
			names
		}, andOperator);
	}

	public int countIssuingPlace(
		String[] codes, String[] names, boolean andOperator)
		throws SystemException {

		codes = CustomSQLUtil.keywords(codes, true);
		names = CustomSQLUtil.keywords(names, true);

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_MA_TEN);

			sql =
				CustomSQLUtil.replaceKeywords(
					sql, "lower(pml_edm_issuingplace.issuingplacecode)",
					StringPool.LIKE, false, codes);
			sql =
				CustomSQLUtil.replaceKeywords(
					sql, "lower(pml_edm_issuingplace.issuingplacename)",
					StringPool.LIKE, true, names);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(codes, 2);
			qpos.add(names, 2);

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

	public List<PmlEdmIssuingPlace> findByIssuingPlaceIds(
		List<String> issuingPlaceIds)
		throws Exception {

		Session session = null;

		try {
			session = openSession();

			String sql = "SELECT DISTINCT(ip.*) ";
			sql += "FROM pml_edm_issuingplace ip ";
			sql += "WHERE 1 = 0 ";

			// Doc issuingPlaceIds de parse dieu kien loc du lieu
			for (String issuingPlaceId : issuingPlaceIds) {
				sql += " OR issuingplaceid = '" + issuingPlaceId + "' ";
			}

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmIssuingPlace", PmlEdmIssuingPlaceImpl.class);

			return (List<PmlEdmIssuingPlace>) QueryUtil.list(
				q, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<PmlEdmIssuingPlace> findByKeywords(
		String keywords, int start, int end, OrderByComparator obc)
		throws SystemException {

		String[] codes = null;
		String[] names = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			codes = CustomSQLUtil.keywords(keywords, true);
			names = CustomSQLUtil.keywords(keywords, true);
		}
		else {
			andOperator = true;
		}
		return findIssuingPlace(codes, names, andOperator, start, end, obc);
	}

	/**
	 * Phương thức tìm kiếm chính xác theo cụm từ, phục vụ cho autocomplete
	 * 
	 * @param keywords
	 * @return
	 * @throws SystemException
	 */
	public List<PmlEdmIssuingPlace> findByKeywords2(String keywords)
		throws SystemException {

		String[] codes = null;
		String[] names = null;

		boolean andOperator = false;

		if ((keywords != null) && ((keywords = keywords.trim()).length() > 0)) {
			codes = new String[] {
				keywords
			};
			names = new String[] {
				keywords
			};
		}
		else {
			andOperator = true;

		}
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_MA_TEN);

			sql =
				CustomSQLUtil.replaceKeywords(
					sql, "lower(pml_edm_issuingplace.issuingplacecode)",
					StringPool.LIKE, false, codes);
			sql =
				CustomSQLUtil.replaceKeywords(
					sql, "lower(pml_edm_issuingplace.issuingplacename)",
					StringPool.LIKE, true, names);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("pml_edm_issuingplace", PmlEdmIssuingPlaceImpl.class);

			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(codes, 2);
			qpos.add(names, 2);

			return (List<PmlEdmIssuingPlace>) QueryUtil.list(
				q, getDialect(), 0, 100);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<PmlEdmIssuingPlace> findIssuingPlace(
		String codes, String names, boolean andOperator, int start, int end,
		OrderByComparator obc)
		throws SystemException {

		return findIssuingPlace(new String[] {
			codes
		}, new String[] {
			names
		}, andOperator, start, end, obc);
	}

	public List<PmlEdmIssuingPlace> findIssuingPlace(
		String[] codes, String[] names, boolean andOperator, int start,
		int end, OrderByComparator obc)
		throws SystemException {

		codes = CustomSQLUtil.keywords(codes, true);
		names = CustomSQLUtil.keywords(names, true);

		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_MA_TEN);

			sql =
				CustomSQLUtil.replaceKeywords(
					sql, "lower(pml_edm_issuingplace.issuingplacecode)",
					StringPool.LIKE, false, codes);
			sql =
				CustomSQLUtil.replaceKeywords(
					sql, "lower(pml_edm_issuingplace.issuingplacename)",
					StringPool.LIKE, true, names);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("pml_edm_issuingplace", PmlEdmIssuingPlaceImpl.class);

			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(codes, 2);
			qpos.add(names, 2);

			return (List<PmlEdmIssuingPlace>) QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * phmphuc get 10/07/2010 - chuyen ham lay noi phat hanh theo cap goi ve cau
	 * // sql de sort theo ten hien thi
	 */
	public List<PmlEdmIssuingPlace> getPmlEdmIssuingPlacesWithPmlEdmLevelSend(
		int levelSendId)
		throws Exception {

		Session session = null;

		try {
			session = openSession();

			String sql =
				"SELECT iss.* FROM pml_edm_levelsenddetail detail, pml_edm_issuingplace iss";
			sql += " WHERE detail.levelsendid = " + levelSendId;
			sql += " AND detail.issuingplaceid = iss.issuingplaceid";
			sql += " ORDER BY iss.issuingplacename";

			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("PmlEdmIssuingPlace", PmlEdmIssuingPlaceImpl.class);

			return (List<PmlEdmIssuingPlace>) QueryUtil.list(
				q, getDialect(), -1, -1);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}
