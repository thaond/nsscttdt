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

package com.nss.portlet.journal.model;


/**
 * <a href="JournalArticle.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface is a model that represents the <code>JournalArticle</code> table
 * in the database.
 * </p>
 *
 * <p>
 * Customize <code>com.liferay.portlet.journal.model.impl.JournalArticleImpl</code>
 * and rerun the ServiceBuilder to generate the new methods.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.journal.model.JournalArticleModel
 * @see com.liferay.portlet.journal.model.impl.JournalArticleImpl
 * @see com.liferay.portlet.journal.model.impl.JournalArticleModelImpl
 *
 */
public interface JournalArticle extends JournalArticleModel {
	public java.lang.String getApprovedByUserUuid()
		throws com.liferay.portal.SystemException;

	public java.lang.String[] getAvailableLocales();

	public java.lang.String getContentByLocale(java.lang.String languageId);

	public java.lang.String getDefaultLocale();

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge();

	public java.lang.String getSmallImageType()
		throws com.liferay.portal.PortalException,
			com.liferay.portal.SystemException;

	public java.lang.String getUserUuid()
		throws com.liferay.portal.SystemException;

	public boolean isTemplateDriven();

	public void setApprovedByUserUuid(java.lang.String approvedByUserUuid);

	public void setSmallImageType(java.lang.String smallImageType);

	public void setUserUuid(java.lang.String userUuid);
}