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

/**
 * <a href="SignatureUtil.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public class SignatureUtil {
	public static void cacheResult(
		com.nss.portlet.digitalsignature.model.Signature signature) {
		getPersistence().cacheResult(signature);
	}

	public static void cacheResult(
		java.util.List<com.nss.portlet.digitalsignature.model.Signature> signatures) {
		getPersistence().cacheResult(signatures);
	}

	public static void clearCache() {
		getPersistence().clearCache();
	}

	public static com.nss.portlet.digitalsignature.model.Signature create(
		long signatureId) {
		return getPersistence().create(signatureId);
	}

	public static com.nss.portlet.digitalsignature.model.Signature remove(
		long signatureId)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException {
		return getPersistence().remove(signatureId);
	}

	public static com.nss.portlet.digitalsignature.model.Signature remove(
		com.nss.portlet.digitalsignature.model.Signature signature)
		throws com.liferay.portal.SystemException {
		return getPersistence().remove(signature);
	}

	public static com.nss.portlet.digitalsignature.model.Signature update(
		com.nss.portlet.digitalsignature.model.Signature signature)
		throws com.liferay.portal.SystemException {
		return getPersistence().update(signature);
	}

	public static com.nss.portlet.digitalsignature.model.Signature update(
		com.nss.portlet.digitalsignature.model.Signature signature,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().update(signature, merge);
	}

	public static com.nss.portlet.digitalsignature.model.Signature updateImpl(
		com.nss.portlet.digitalsignature.model.Signature signature,
		boolean merge) throws com.liferay.portal.SystemException {
		return getPersistence().updateImpl(signature, merge);
	}

	public static com.nss.portlet.digitalsignature.model.Signature findByPrimaryKey(
		long signatureId)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException {
		return getPersistence().findByPrimaryKey(signatureId);
	}

	public static com.nss.portlet.digitalsignature.model.Signature fetchByPrimaryKey(
		long signatureId) throws com.liferay.portal.SystemException {
		return getPersistence().fetchByPrimaryKey(signatureId);
	}

	public static com.nss.portlet.digitalsignature.model.Signature findByAPK_U(
		long articlePrimKey, long userId)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException {
		return getPersistence().findByAPK_U(articlePrimKey, userId);
	}

	public static com.nss.portlet.digitalsignature.model.Signature fetchByAPK_U(
		long articlePrimKey, long userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().fetchByAPK_U(articlePrimKey, userId);
	}

	public static com.nss.portlet.digitalsignature.model.Signature fetchByAPK_U(
		long articlePrimKey, long userId, boolean retrieveFromCache)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .fetchByAPK_U(articlePrimKey, userId, retrieveFromCache);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticleId(
		java.lang.String articleId) throws com.liferay.portal.SystemException {
		return getPersistence().findByArticleId(articleId);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticleId(
		java.lang.String articleId, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByArticleId(articleId, start, end);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticleId(
		java.lang.String articleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByArticleId(articleId, start, end, obc);
	}

	public static com.nss.portlet.digitalsignature.model.Signature findByArticleId_First(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException {
		return getPersistence().findByArticleId_First(articleId, obc);
	}

	public static com.nss.portlet.digitalsignature.model.Signature findByArticleId_Last(
		java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException {
		return getPersistence().findByArticleId_Last(articleId, obc);
	}

	public static com.nss.portlet.digitalsignature.model.Signature[] findByArticleId_PrevAndNext(
		long signatureId, java.lang.String articleId,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException {
		return getPersistence()
				   .findByArticleId_PrevAndNext(signatureId, articleId, obc);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticlePrimKey(
		long articlePrimKey) throws com.liferay.portal.SystemException {
		return getPersistence().findByArticlePrimKey(articlePrimKey);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticlePrimKey(
		long articlePrimKey, int start, int end)
		throws com.liferay.portal.SystemException {
		return getPersistence().findByArticlePrimKey(articlePrimKey, start, end);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findByArticlePrimKey(
		long articlePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence()
				   .findByArticlePrimKey(articlePrimKey, start, end, obc);
	}

	public static com.nss.portlet.digitalsignature.model.Signature findByArticlePrimKey_First(
		long articlePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException {
		return getPersistence().findByArticlePrimKey_First(articlePrimKey, obc);
	}

	public static com.nss.portlet.digitalsignature.model.Signature findByArticlePrimKey_Last(
		long articlePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException {
		return getPersistence().findByArticlePrimKey_Last(articlePrimKey, obc);
	}

	public static com.nss.portlet.digitalsignature.model.Signature[] findByArticlePrimKey_PrevAndNext(
		long signatureId, long articlePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException {
		return getPersistence()
				   .findByArticlePrimKey_PrevAndNext(signatureId,
			articlePrimKey, obc);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	public static java.util.List<Object> findWithDynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findAll()
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll();
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findAll(
		int start, int end) throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end);
	}

	public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findAll(
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.SystemException {
		return getPersistence().findAll(start, end, obc);
	}

	public static void removeByAPK_U(long articlePrimKey, long userId)
		throws com.liferay.portal.SystemException,
			com.nss.portlet.digitalsignature.NoSuchSignatureException {
		getPersistence().removeByAPK_U(articlePrimKey, userId);
	}

	public static void removeByArticleId(java.lang.String articleId)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByArticleId(articleId);
	}

	public static void removeByArticlePrimKey(long articlePrimKey)
		throws com.liferay.portal.SystemException {
		getPersistence().removeByArticlePrimKey(articlePrimKey);
	}

	public static void removeAll() throws com.liferay.portal.SystemException {
		getPersistence().removeAll();
	}

	public static int countByAPK_U(long articlePrimKey, long userId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByAPK_U(articlePrimKey, userId);
	}

	public static int countByArticleId(java.lang.String articleId)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByArticleId(articleId);
	}

	public static int countByArticlePrimKey(long articlePrimKey)
		throws com.liferay.portal.SystemException {
		return getPersistence().countByArticlePrimKey(articlePrimKey);
	}

	public static int countAll() throws com.liferay.portal.SystemException {
		return getPersistence().countAll();
	}

	public static SignaturePersistence getPersistence() {
		return _persistence;
	}

	public void setPersistence(SignaturePersistence persistence) {
		_persistence = persistence;
	}

	private static SignaturePersistence _persistence;
}