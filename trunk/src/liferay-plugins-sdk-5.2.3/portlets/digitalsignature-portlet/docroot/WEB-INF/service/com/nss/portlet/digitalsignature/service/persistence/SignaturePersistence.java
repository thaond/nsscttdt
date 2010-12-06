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

package com.nss.portlet.digitalsignature.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * <a href="SignaturePersistence.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public interface SignaturePersistence extends BasePersistence {
	public void cacheResult(
		com.nss.portlet.digitalsignature.model.Signature signature);

	public void cacheResult(
		java.util.List<com.nss.portlet.digitalsignature.model.Signature> signatures);

	public void clearCache();

	public com.nss.portlet.digitalsignature.model.Signature create(
		long signatureId);

	public com.nss.portlet.digitalsignature.model.Signature remove(
		long signatureId)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException;

	public com.nss.portlet.digitalsignature.model.Signature remove(
		com.nss.portlet.digitalsignature.model.Signature signature)
		throws com.liferay.portal.SystemException;

	public com.nss.portlet.digitalsignature.model.Signature update(
		com.nss.portlet.digitalsignature.model.Signature signature)
		throws com.liferay.portal.SystemException;

	public com.nss.portlet.digitalsignature.model.Signature update(
		com.nss.portlet.digitalsignature.model.Signature signature,
		boolean merge) throws com.liferay.portal.SystemException;

	public com.nss.portlet.digitalsignature.model.Signature updateImpl(
		com.nss.portlet.digitalsignature.model.Signature signature,
		boolean merge) throws com.liferay.portal.SystemException;

	public com.nss.portlet.digitalsignature.model.Signature findByPrimaryKey(
		long signatureId)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException;

	public com.nss.portlet.digitalsignature.model.Signature fetchByPrimaryKey(
		long signatureId) throws com.liferay.portal.SystemException;

	public com.nss.portlet.digitalsignature.model.Signature findByAPK_U(
		long articlePrimKey, long userId)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException;

	public com.nss.portlet.digitalsignature.model.Signature fetchByAPK_U(
		long articlePrimKey, long userId)
		throws com.liferay.portal.SystemException;

	public com.nss.portlet.digitalsignature.model.Signature fetchByAPK_U(
		long articlePrimKey, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticleId(
		java.lang.String articleId) throws com.liferay.portal.SystemException;

	public java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticleId(
		java.lang.String articleId, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticleId(
		java.lang.String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.nss.portlet.digitalsignature.model.Signature findByArticleId_First(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException;

	public com.nss.portlet.digitalsignature.model.Signature findByArticleId_Last(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException;

	public com.nss.portlet.digitalsignature.model.Signature[] findByArticleId_PrevAndNext(
		long signatureId, java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException;

	public java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticlePrimKey(
		long articlePrimKey) throws com.liferay.portal.SystemException;

	public java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticlePrimKey(
		long articlePrimKey, int start, int end)
		throws com.liferay.portal.SystemException;

	public java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticlePrimKey(
		long articlePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public com.nss.portlet.digitalsignature.model.Signature findByArticlePrimKey_First(
		long articlePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException;

	public com.nss.portlet.digitalsignature.model.Signature findByArticlePrimKey_Last(
		long articlePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException;

	public com.nss.portlet.digitalsignature.model.Signature[] findByArticlePrimKey_PrevAndNext(
		long signatureId, long articlePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException;

	public java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException;

	public java.util.List<com.nss.portlet.digitalsignature.model.Signature> findAll()
		throws com.liferay.portal.SystemException;

	public java.util.List<com.nss.portlet.digitalsignature.model.Signature> findAll(
		int start, int end) throws com.liferay.portal.SystemException;

	public java.util.List<com.nss.portlet.digitalsignature.model.Signature> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException;

	public void removeByAPK_U(long articlePrimKey, long userId)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException;

	public void removeByArticleId(java.lang.String articleId)
		throws com.liferay.portal.SystemException;

	public void removeByArticlePrimKey(long articlePrimKey)
		throws com.liferay.portal.SystemException;

	public void removeAll() throws com.liferay.portal.SystemException;

	public int countByAPK_U(long articlePrimKey, long userId)
		throws com.liferay.portal.SystemException;

	public int countByArticleId(java.lang.String articleId)
		throws com.liferay.portal.SystemException;

	public int countByArticlePrimKey(long articlePrimKey)
		throws com.liferay.portal.SystemException;

	public int countAll() throws com.liferay.portal.SystemException;
}