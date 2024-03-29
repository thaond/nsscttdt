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

package com.nss.portlet.journal.service.impl;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.nss.portlet.journal.model.JournalArticleResource;
import com.nss.portlet.journal.service.base.JournalArticleResourceLocalServiceBaseImpl;

import java.util.List;

/**
 * <a href="JournalArticleResourceLocalServiceImpl.java.html"><b><i>View Source
 * </i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class JournalArticleResourceLocalServiceImpl
	extends JournalArticleResourceLocalServiceBaseImpl {

	public void deleteArticleResource(long groupId, String articleId)
		throws PortalException, SystemException {

		journalArticleResourcePersistence.removeByG_A(groupId, articleId);
	}

	public JournalArticleResource getArticleResource(
			long articleResourcePrimKey)
		throws PortalException, SystemException {

		return journalArticleResourcePersistence.findByPrimaryKey(
			articleResourcePrimKey);
	}

	public long getArticleResourcePrimKey(long groupId, String articleId)
		throws SystemException {

		JournalArticleResource articleResource =
			journalArticleResourcePersistence.fetchByG_A(groupId, articleId);

		if (articleResource == null) {
			long articleResourcePrimKey = counterLocalService.increment();

			articleResource = journalArticleResourcePersistence.create(
				articleResourcePrimKey);

			articleResource.setGroupId(groupId);
			articleResource.setArticleId(articleId);

			journalArticleResourcePersistence.update(articleResource, false);
		}

		return articleResource.getResourcePrimKey();
	}

	public List<JournalArticleResource> getArticleResources(long groupId)
		throws SystemException {

		return journalArticleResourcePersistence.findByGroupId(groupId);
	}

}