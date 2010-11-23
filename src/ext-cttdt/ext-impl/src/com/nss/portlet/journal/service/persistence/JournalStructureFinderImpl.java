/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.nss.portlet.journal.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.model.impl.JournalStructureImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.Iterator;
import java.util.List;

/**
 * <a href="JournalStructureFinderImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class JournalStructureFinderImpl
	extends BasePersistenceImpl implements JournalStructureFinder {

	public static String COUNT_BY_C_G_S_N_D =
		JournalStructureFinder.class.getName() + ".countByC_G_S_N_D";

	public static String FIND_BY_C_G_S_N_D =
		JournalStructureFinder.class.getName() + ".findByC_G_S_N_D";

	public int countByKeywords(long companyId, long groupId, String keywords)
		throws SystemException {

		String[] structureIds = null;
		String[] names = null;
		String[] descriptions = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			structureIds = CustomSQLUtil.keywords(keywords, false);
			names = CustomSQLUtil.keywords(keywords);
			descriptions = CustomSQLUtil.keywords(keywords);
		}
		else {
			andOperator = true;
		}

		return countByC_G_S_N_D(
			companyId, groupId, structureIds, names, descriptions, andOperator);
	}

	public int countByC_G_S_N_D(
			long companyId, long groupId, String structureId, String name,
			String description, boolean andOperator)
		throws SystemException {

		return countByC_G_S_N_D(
			companyId, groupId, new String[] {structureId}, new String[] {name},
			new String[] {description}, andOperator);
	}

	public int countByC_G_S_N_D(
			long companyId, long groupId, String[] structureIds, String[] names,
			String[] descriptions, boolean andOperator)
		throws SystemException {

		structureIds = CustomSQLUtil.keywords(structureIds, false);
		names = CustomSQLUtil.keywords(names);
		descriptions = CustomSQLUtil.keywords(descriptions);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_C_G_S_N_D);

			if (groupId <= 0) {
				sql = StringUtil.replace(sql, "(groupId = ?) AND", "");
			}

			sql = CustomSQLUtil.replaceKeywords(
				sql, "structureId", StringPool.LIKE, false, structureIds);
			sql = CustomSQLUtil.replaceKeywords(
				sql, "lower(name)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(
				sql, "lower(description)", StringPool.LIKE, true, descriptions);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			if (groupId > 0) {
				qPos.add(groupId);
			}

			qPos.add(structureIds, 2);
			qPos.add(names, 2);
			qPos.add(descriptions, 2);

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

	public List<JournalStructure> findByKeywords(
			long companyId, long groupId, String keywords, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		String[] structureIds = null;
		String[] names = null;
		String[] descriptions = null;
		boolean andOperator = false;

		if (Validator.isNotNull(keywords)) {
			structureIds = CustomSQLUtil.keywords(keywords, false);
			names = CustomSQLUtil.keywords(keywords);
			descriptions = CustomSQLUtil.keywords(keywords);
		}
		else {
			andOperator = true;
		}

		return findByC_G_S_N_D(
			companyId, groupId, structureIds, names, descriptions, andOperator,
			start, end, obc);
	}

	public List<JournalStructure> findByC_G_S_N_D(
			long companyId, long groupId, String structureId, String name,
			String description, boolean andOperator, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		return findByC_G_S_N_D(
			companyId, groupId, new String[] {structureId}, new String[] {name},
			new String[] {description}, andOperator, start, end, obc);
	}

	public List<JournalStructure> findByC_G_S_N_D(
			long companyId, long groupId, String[] structureIds, String[] names,
			String[] descriptions, boolean andOperator, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		structureIds = CustomSQLUtil.keywords(structureIds, false);
		names = CustomSQLUtil.keywords(names);
		descriptions = CustomSQLUtil.keywords(descriptions);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_C_G_S_N_D);

			if (groupId <= 0) {
				sql = StringUtil.replace(sql, "(groupId = ?) AND", "");
			}

			sql = CustomSQLUtil.replaceKeywords(
				sql, "structureId", StringPool.LIKE, false, structureIds);
			sql = CustomSQLUtil.replaceKeywords(
				sql, "lower(name)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(
				sql, "lower(description)", StringPool.LIKE, true, descriptions);

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("JournalStructure", JournalStructureImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(companyId);

			if (groupId > 0) {
				qPos.add(groupId);
			}

			qPos.add(structureIds, 2);
			qPos.add(names, 2);
			qPos.add(descriptions, 2);

			return (List<JournalStructure>)QueryUtil.list(
				q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

}