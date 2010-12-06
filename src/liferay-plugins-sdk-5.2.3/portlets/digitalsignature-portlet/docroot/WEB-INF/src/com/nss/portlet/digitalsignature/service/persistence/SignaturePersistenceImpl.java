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

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.digitalsignature.NoSuchSignatureException;
import com.nss.portlet.digitalsignature.model.Signature;
import com.nss.portlet.digitalsignature.model.impl.SignatureImpl;
import com.nss.portlet.digitalsignature.model.impl.SignatureModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="SignaturePersistenceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author canhminh
 *
 */
public class SignaturePersistenceImpl extends BasePersistenceImpl
	implements SignaturePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = SignatureImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FETCH_BY_APK_U = new FinderPath(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_ENTITY,
			"fetchByAPK_U",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_APK_U = new FinderPath(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByAPK_U",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ARTICLEID = new FinderPath(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByArticleId", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLEID = new FinderPath(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByArticleId",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEID = new FinderPath(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByArticleId", new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ARTICLEPRIMKEY = new FinderPath(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByArticlePrimKey", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLEPRIMKEY = new FinderPath(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByArticlePrimKey",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEPRIMKEY = new FinderPath(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByArticlePrimKey", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	public void cacheResult(Signature signature) {
		EntityCacheUtil.putResult(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureImpl.class, signature.getPrimaryKey(), signature);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APK_U,
			new Object[] {
				new Long(signature.getArticlePrimKey()),
				new Long(signature.getUserId())
			}, signature);
	}

	public void cacheResult(List<Signature> signatures) {
		for (Signature signature : signatures) {
			if (EntityCacheUtil.getResult(
						SignatureModelImpl.ENTITY_CACHE_ENABLED,
						SignatureImpl.class, signature.getPrimaryKey(), this) == null) {
				cacheResult(signature);
			}
		}
	}

	public void clearCache() {
		CacheRegistry.clear(SignatureImpl.class.getName());
		EntityCacheUtil.clearCache(SignatureImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	public Signature create(long signatureId) {
		Signature signature = new SignatureImpl();

		signature.setNew(true);
		signature.setPrimaryKey(signatureId);

		return signature;
	}

	public Signature remove(long signatureId)
		throws NoSuchSignatureException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Signature signature = (Signature)session.get(SignatureImpl.class,
					new Long(signatureId));

			if (signature == null) {
				if (_log.isWarnEnabled()) {
					_log.warn("No Signature exists with the primary key " +
						signatureId);
				}

				throw new NoSuchSignatureException(
					"No Signature exists with the primary key " + signatureId);
			}

			return remove(signature);
		}
		catch (NoSuchSignatureException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public Signature remove(Signature signature) throws SystemException {
		for (ModelListener<Signature> listener : listeners) {
			listener.onBeforeRemove(signature);
		}

		signature = removeImpl(signature);

		for (ModelListener<Signature> listener : listeners) {
			listener.onAfterRemove(signature);
		}

		return signature;
	}

	protected Signature removeImpl(Signature signature)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			if (signature.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(SignatureImpl.class,
						signature.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(signature);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		SignatureModelImpl signatureModelImpl = (SignatureModelImpl)signature;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_APK_U,
			new Object[] {
				new Long(signatureModelImpl.getOriginalArticlePrimKey()),
				new Long(signatureModelImpl.getOriginalUserId())
			});

		EntityCacheUtil.removeResult(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureImpl.class, signature.getPrimaryKey());

		return signature;
	}

	public Signature update(Signature signature) throws SystemException {
		if (_log.isWarnEnabled()) {
			_log.warn(
				"Using the deprecated update(Signature signature) method. Use update(Signature signature, boolean merge) instead.");
		}

		return update(signature, false);
	}

	public Signature update(Signature signature, boolean merge)
		throws SystemException {
		boolean isNew = signature.isNew();

		for (ModelListener<Signature> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(signature);
			}
			else {
				listener.onBeforeUpdate(signature);
			}
		}

		signature = updateImpl(signature, merge);

		for (ModelListener<Signature> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(signature);
			}
			else {
				listener.onAfterUpdate(signature);
			}
		}

		return signature;
	}

	public Signature updateImpl(
		com.nss.portlet.digitalsignature.model.Signature signature,
		boolean merge) throws SystemException {
		boolean isNew = signature.isNew();

		SignatureModelImpl signatureModelImpl = (SignatureModelImpl)signature;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, signature, merge);

			signature.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(SignatureModelImpl.ENTITY_CACHE_ENABLED,
			SignatureImpl.class, signature.getPrimaryKey(), signature);

		if (!isNew &&
				((signature.getArticlePrimKey() != signatureModelImpl.getOriginalArticlePrimKey()) ||
				(signature.getUserId() != signatureModelImpl.getOriginalUserId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_APK_U,
				new Object[] {
					new Long(signatureModelImpl.getOriginalArticlePrimKey()),
					new Long(signatureModelImpl.getOriginalUserId())
				});
		}

		if (isNew ||
				((signature.getArticlePrimKey() != signatureModelImpl.getOriginalArticlePrimKey()) ||
				(signature.getUserId() != signatureModelImpl.getOriginalUserId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APK_U,
				new Object[] {
					new Long(signature.getArticlePrimKey()),
					new Long(signature.getUserId())
				}, signature);
		}

		return signature;
	}

	public Signature findByPrimaryKey(long signatureId)
		throws NoSuchSignatureException, SystemException {
		Signature signature = fetchByPrimaryKey(signatureId);

		if (signature == null) {
			if (_log.isWarnEnabled()) {
				_log.warn("No Signature exists with the primary key " +
					signatureId);
			}

			throw new NoSuchSignatureException(
				"No Signature exists with the primary key " + signatureId);
		}

		return signature;
	}

	public Signature fetchByPrimaryKey(long signatureId)
		throws SystemException {
		Signature signature = (Signature)EntityCacheUtil.getResult(SignatureModelImpl.ENTITY_CACHE_ENABLED,
				SignatureImpl.class, signatureId, this);

		if (signature == null) {
			Session session = null;

			try {
				session = openSession();

				signature = (Signature)session.get(SignatureImpl.class,
						new Long(signatureId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (signature != null) {
					cacheResult(signature);
				}

				closeSession(session);
			}
		}

		return signature;
	}

	public Signature findByAPK_U(long articlePrimKey, long userId)
		throws NoSuchSignatureException, SystemException {
		Signature signature = fetchByAPK_U(articlePrimKey, userId);

		if (signature == null) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Signature exists with the key {");

			msg.append("articlePrimKey=" + articlePrimKey);

			msg.append(", ");
			msg.append("userId=" + userId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSignatureException(msg.toString());
		}

		return signature;
	}

	public Signature fetchByAPK_U(long articlePrimKey, long userId)
		throws SystemException {
		return fetchByAPK_U(articlePrimKey, userId, true);
	}

	public Signature fetchByAPK_U(long articlePrimKey, long userId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(articlePrimKey), new Long(userId)
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_APK_U,
					finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.nss.portlet.digitalsignature.model.Signature WHERE ");

				query.append("articlePrimKey = ?");

				query.append(" AND ");

				query.append("userId = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("createDate ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articlePrimKey);

				qPos.add(userId);

				List<Signature> list = q.list();

				result = list;

				Signature signature = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APK_U,
						finderArgs, list);
				}
				else {
					signature = list.get(0);

					cacheResult(signature);

					if ((signature.getArticlePrimKey() != articlePrimKey) ||
							(signature.getUserId() != userId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APK_U,
							finderArgs, signature);
					}
				}

				return signature;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_APK_U,
						finderArgs, new ArrayList<Signature>());
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List) {
				return null;
			}
			else {
				return (Signature)result;
			}
		}
	}

	public List<Signature> findByArticleId(String articleId)
		throws SystemException {
		Object[] finderArgs = new Object[] { articleId };

		List<Signature> list = (List<Signature>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.nss.portlet.digitalsignature.model.Signature WHERE ");

				if (articleId == null) {
					query.append("articleId IS NULL");
				}
				else {
					query.append("articleId = ?");
				}

				query.append(" ");

				query.append("ORDER BY ");

				query.append("createDate ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (articleId != null) {
					qPos.add(articleId);
				}

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Signature>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Signature> findByArticleId(String articleId, int start, int end)
		throws SystemException {
		return findByArticleId(articleId, start, end, null);
	}

	public List<Signature> findByArticleId(String articleId, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				articleId,
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Signature> list = (List<Signature>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLEID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.nss.portlet.digitalsignature.model.Signature WHERE ");

				if (articleId == null) {
					query.append("articleId IS NULL");
				}
				else {
					query.append("articleId = ?");
				}

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("createDate ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (articleId != null) {
					qPos.add(articleId);
				}

				list = (List<Signature>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Signature>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Signature findByArticleId_First(String articleId,
		OrderByComparator obc) throws NoSuchSignatureException, SystemException {
		List<Signature> list = findByArticleId(articleId, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Signature exists with the key {");

			msg.append("articleId=" + articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSignatureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Signature findByArticleId_Last(String articleId,
		OrderByComparator obc) throws NoSuchSignatureException, SystemException {
		int count = countByArticleId(articleId);

		List<Signature> list = findByArticleId(articleId, count - 1, count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Signature exists with the key {");

			msg.append("articleId=" + articleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSignatureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Signature[] findByArticleId_PrevAndNext(long signatureId,
		String articleId, OrderByComparator obc)
		throws NoSuchSignatureException, SystemException {
		Signature signature = findByPrimaryKey(signatureId);

		int count = countByArticleId(articleId);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM com.nss.portlet.digitalsignature.model.Signature WHERE ");

			if (articleId == null) {
				query.append("articleId IS NULL");
			}
			else {
				query.append("articleId = ?");
			}

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("createDate ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			if (articleId != null) {
				qPos.add(articleId);
			}

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					signature);

			Signature[] array = new SignatureImpl[3];

			array[0] = (Signature)objArray[0];
			array[1] = (Signature)objArray[1];
			array[2] = (Signature)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Signature> findByArticlePrimKey(long articlePrimKey)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Long(articlePrimKey) };

		List<Signature> list = (List<Signature>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLEPRIMKEY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.nss.portlet.digitalsignature.model.Signature WHERE ");

				query.append("articlePrimKey = ?");

				query.append(" ");

				query.append("ORDER BY ");

				query.append("createDate ASC");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articlePrimKey);

				list = q.list();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Signature>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLEPRIMKEY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public List<Signature> findByArticlePrimKey(long articlePrimKey, int start,
		int end) throws SystemException {
		return findByArticlePrimKey(articlePrimKey, start, end, null);
	}

	public List<Signature> findByArticlePrimKey(long articlePrimKey, int start,
		int end, OrderByComparator obc) throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(articlePrimKey),
				
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Signature> list = (List<Signature>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLEPRIMKEY,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.nss.portlet.digitalsignature.model.Signature WHERE ");

				query.append("articlePrimKey = ?");

				query.append(" ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("createDate ASC");
				}

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articlePrimKey);

				list = (List<Signature>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Signature>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLEPRIMKEY,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public Signature findByArticlePrimKey_First(long articlePrimKey,
		OrderByComparator obc) throws NoSuchSignatureException, SystemException {
		List<Signature> list = findByArticlePrimKey(articlePrimKey, 0, 1, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Signature exists with the key {");

			msg.append("articlePrimKey=" + articlePrimKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSignatureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Signature findByArticlePrimKey_Last(long articlePrimKey,
		OrderByComparator obc) throws NoSuchSignatureException, SystemException {
		int count = countByArticlePrimKey(articlePrimKey);

		List<Signature> list = findByArticlePrimKey(articlePrimKey, count - 1,
				count, obc);

		if (list.isEmpty()) {
			StringBuilder msg = new StringBuilder();

			msg.append("No Signature exists with the key {");

			msg.append("articlePrimKey=" + articlePrimKey);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchSignatureException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	public Signature[] findByArticlePrimKey_PrevAndNext(long signatureId,
		long articlePrimKey, OrderByComparator obc)
		throws NoSuchSignatureException, SystemException {
		Signature signature = findByPrimaryKey(signatureId);

		int count = countByArticlePrimKey(articlePrimKey);

		Session session = null;

		try {
			session = openSession();

			StringBuilder query = new StringBuilder();

			query.append(
				"FROM com.nss.portlet.digitalsignature.model.Signature WHERE ");

			query.append("articlePrimKey = ?");

			query.append(" ");

			if (obc != null) {
				query.append("ORDER BY ");
				query.append(obc.getOrderBy());
			}

			else {
				query.append("ORDER BY ");

				query.append("createDate ASC");
			}

			Query q = session.createQuery(query.toString());

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(articlePrimKey);

			Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
					signature);

			Signature[] array = new SignatureImpl[3];

			array[0] = (Signature)objArray[0];
			array[1] = (Signature)objArray[1];
			array[2] = (Signature)objArray[2];

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		Session session = null;

		try {
			session = openSession();

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		Session session = null;

		try {
			session = openSession();

			dynamicQuery.setLimit(start, end);

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	public List<Signature> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	public List<Signature> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	public List<Signature> findAll(int start, int end, OrderByComparator obc)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end), String.valueOf(obc)
			};

		List<Signature> list = (List<Signature>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append(
					"FROM com.nss.portlet.digitalsignature.model.Signature ");

				if (obc != null) {
					query.append("ORDER BY ");
					query.append(obc.getOrderBy());
				}

				else {
					query.append("ORDER BY ");

					query.append("createDate ASC");
				}

				Query q = session.createQuery(query.toString());

				if (obc == null) {
					list = (List<Signature>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Signature>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Signature>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	public void removeByAPK_U(long articlePrimKey, long userId)
		throws NoSuchSignatureException, SystemException {
		Signature signature = findByAPK_U(articlePrimKey, userId);

		remove(signature);
	}

	public void removeByArticleId(String articleId) throws SystemException {
		for (Signature signature : findByArticleId(articleId)) {
			remove(signature);
		}
	}

	public void removeByArticlePrimKey(long articlePrimKey)
		throws SystemException {
		for (Signature signature : findByArticlePrimKey(articlePrimKey)) {
			remove(signature);
		}
	}

	public void removeAll() throws SystemException {
		for (Signature signature : findAll()) {
			remove(signature);
		}
	}

	public int countByAPK_U(long articlePrimKey, long userId)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				new Long(articlePrimKey), new Long(userId)
			};

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APK_U,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM com.nss.portlet.digitalsignature.model.Signature WHERE ");

				query.append("articlePrimKey = ?");

				query.append(" AND ");

				query.append("userId = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articlePrimKey);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APK_U,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByArticleId(String articleId) throws SystemException {
		Object[] finderArgs = new Object[] { articleId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM com.nss.portlet.digitalsignature.model.Signature WHERE ");

				if (articleId == null) {
					query.append("articleId IS NULL");
				}
				else {
					query.append("articleId = ?");
				}

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				if (articleId != null) {
					qPos.add(articleId);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countByArticlePrimKey(long articlePrimKey)
		throws SystemException {
		Object[] finderArgs = new Object[] { new Long(articlePrimKey) };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLEPRIMKEY,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBuilder query = new StringBuilder();

				query.append("SELECT COUNT(*) ");
				query.append(
					"FROM com.nss.portlet.digitalsignature.model.Signature WHERE ");

				query.append("articlePrimKey = ?");

				query.append(" ");

				Query q = session.createQuery(query.toString());

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(articlePrimKey);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLEPRIMKEY,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(
						"SELECT COUNT(*) FROM com.nss.portlet.digitalsignature.model.Signature");

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.nss.portlet.digitalsignature.model.Signature")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Signature>> listenersList = new ArrayList<ModelListener<Signature>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Signature>)Class.forName(
							listenerClassName).newInstance());
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(name = "com.nss.portlet.digitalsignature.service.persistence.SignaturePersistence.impl")
	protected com.nss.portlet.digitalsignature.service.persistence.SignaturePersistence signaturePersistence;
	@BeanReference(name = "com.nss.portlet.digitalsignature.service.persistence.CertificatePersistence.impl")
	protected com.nss.portlet.digitalsignature.service.persistence.CertificatePersistence certificatePersistence;
	private static Log _log = LogFactoryUtil.getLog(SignaturePersistenceImpl.class);
}