package com.nss.portlet.digitalsignature.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
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


public class SignaturePersistenceImpl extends BasePersistenceImpl
    implements SignaturePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = SignatureImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(SignatureModelImpl.ENTITY_CACHE_ENABLED,
            SignatureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SignatureModelImpl.ENTITY_CACHE_ENABLED,
            SignatureModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(SignaturePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.digitalsignature.service.persistence.SignaturePersistence.impl")
    protected com.nss.portlet.digitalsignature.service.persistence.SignaturePersistence signaturePersistence;
    @BeanReference(name = "com.nss.portlet.digitalsignature.service.persistence.CertificatePersistence.impl")
    protected com.nss.portlet.digitalsignature.service.persistence.CertificatePersistence certificatePersistence;

    public void cacheResult(Signature signature) {
        EntityCacheUtil.putResult(SignatureModelImpl.ENTITY_CACHE_ENABLED,
            SignatureImpl.class, signature.getPrimaryKey(), signature);
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

            Signature signature = (Signature) session.get(SignatureImpl.class,
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
        } catch (NoSuchSignatureException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
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
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(SignatureModelImpl.ENTITY_CACHE_ENABLED,
            SignatureImpl.class, signature.getPrimaryKey());

        return signature;
    }

    /**
     * @deprecated Use <code>update(Signature signature, boolean merge)</code>.
     */
    public Signature update(Signature signature) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Signature signature) method. Use update(Signature signature, boolean merge) instead.");
        }

        return update(signature, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                signature the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when signature is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Signature update(Signature signature, boolean merge)
        throws SystemException {
        boolean isNew = signature.isNew();

        for (ModelListener<Signature> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(signature);
            } else {
                listener.onBeforeUpdate(signature);
            }
        }

        signature = updateImpl(signature, merge);

        for (ModelListener<Signature> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(signature);
            } else {
                listener.onAfterUpdate(signature);
            }
        }

        return signature;
    }

    public Signature updateImpl(
        com.nss.portlet.digitalsignature.model.Signature signature,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, signature, merge);

            signature.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(SignatureModelImpl.ENTITY_CACHE_ENABLED,
            SignatureImpl.class, signature.getPrimaryKey(), signature);

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
        Signature signature = (Signature) EntityCacheUtil.getResult(SignatureModelImpl.ENTITY_CACHE_ENABLED,
                SignatureImpl.class, signatureId, this);

        if (signature == null) {
            Session session = null;

            try {
                session = openSession();

                signature = (Signature) session.get(SignatureImpl.class,
                        new Long(signatureId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (signature != null) {
                    cacheResult(signature);
                }

                closeSession(session);
            }
        }

        return signature;
    }

    public List<Object> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            dynamicQuery.compile(session);

            return dynamicQuery.list();
        } catch (Exception e) {
            throw processException(e);
        } finally {
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
        } catch (Exception e) {
            throw processException(e);
        } finally {
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

        List<Signature> list = (List<Signature>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<Signature>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Signature>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
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

    public void removeAll() throws SystemException {
        for (Signature signature : findAll()) {
            remove(signature);
        }
    }

    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.nss.portlet.digitalsignature.model.Signature");

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
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
                    com.liferay.portal.util.PropsUtil.get(
                        "value.object.listener.com.nss.portlet.digitalsignature.model.Signature")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Signature>> listenersList = new ArrayList<ModelListener<Signature>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Signature>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
