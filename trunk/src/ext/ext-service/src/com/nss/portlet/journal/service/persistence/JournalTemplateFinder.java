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

/**
 * <a href="JournalTemplateFinder.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public interface JournalTemplateFinder {
	public int countByKeywords(long companyId, long groupId,
		java.lang.String keywords, java.lang.String structureId,
		java.lang.String structureIdComparator)
		throws com.liferay.portal.SystemException;

	public int countByC_G_T_S_N_D(long companyId, long groupId,
		java.lang.String templateId, java.lang.String structureId,
		java.lang.String structureIdComparator, java.lang.String name,
		java.lang.String description, boolean andOperator)
		throws com.liferay.portal.SystemException;

	public int countByC_G_T_S_N_D(long companyId, long groupId,
		java.lang.String[] templateIds, java.lang.String structureId,
		java.lang.String structureIdComparator, java.lang.String[] names,
		java.lang.String[] descriptions, boolean andOperator)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.journal.model.JournalTemplate> findByKeywords(
		long companyId, long groupId, java.lang.String keywords,
		java.lang.String structureId, java.lang.String structureIdComparator,
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.journal.model.JournalTemplate> findByC_G_T_S_N_D(
		long companyId, long groupId, java.lang.String templateId,
		java.lang.String structureId, java.lang.String structureIdComparator,
		java.lang.String name, java.lang.String description,
		boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.liferay.portlet.journal.model.JournalTemplate> findByC_G_T_S_N_D(
		long companyId, long groupId, java.lang.String[] templateIds,
		java.lang.String structureId, java.lang.String structureIdComparator,
		java.lang.String[] names, java.lang.String[] descriptions,
		boolean andOperator, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;
}