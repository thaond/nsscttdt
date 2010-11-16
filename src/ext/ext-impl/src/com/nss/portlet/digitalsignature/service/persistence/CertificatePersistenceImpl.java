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

import com.nss.portlet.digitalsignature.NoSuchCertificateException;
import com.nss.portlet.digitalsignature.model.Certificate;
import com.nss.portlet.digitalsignature.model.impl.CertificateImpl;
import com.nss.portlet.digitalsignature.model.impl.CertificateModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CertificatePersistenceImpl extends BasePersistenceImpl
    implements CertificatePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = CertificateImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
            CertificateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
            CertificateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(CertificatePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.digitalsignature.service.persistence.SignaturePersistence.impl")
    protected com.nss.portlet.digitalsignature.service.persistence.SignaturePersistence signaturePersistence;
    @BeanReference(name = "com.nss.portlet.digitalsignature.service.persistence.CertificatePersistence.impl")
    protected com.nss.portlet.digitalsignature.service.persistence.CertificatePersistence certificatePersistence;

    public void cacheResult(Certificate certificate) {
        EntityCacheUtil.putResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
            CertificateImpl.class, certificate.getPrimaryKey(), certificate);
    }

    public void cacheResult(List<Certificate> certificates) {
        for (Certificate certificate : certificates) {
            if (EntityCacheUtil.getResult(
                        CertificateModelImpl.ENTITY_CACHE_ENABLED,
                        CertificateImpl.class, certificate.getPrimaryKey(), this) == null) {
                cacheResult(certificate);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(CertificateImpl.class.getName());
        EntityCacheUtil.clearCache(CertificateImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public Certificate create(long userId) {
        Certificate certificate = new CertificateImpl();

        certificate.setNew(true);
        certificate.setPrimaryKey(userId);

        return certificate;
    }

    public Certificate remove(long userId)
        throws NoSuchCertificateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Certificate certificate = (Certificate) session.get(CertificateImpl.class,
                    new Long(userId));

            if (certificate == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Certificate exists with the primary key " +
                        userId);
                }

                throw new NoSuchCertificateException(
                    "No Certificate exists with the primary key " + userId);
            }

            return remove(certificate);
        } catch (NoSuchCertificateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Certificate remove(Certificate certificate)
        throws SystemException {
        for (ModelListener<Certificate> listener : listeners) {
            listener.onBeforeRemove(certificate);
        }

        certificate = removeImpl(certificate);

        for (ModelListener<Certificate> listener : listeners) {
            listener.onAfterRemove(certificate);
        }

        return certificate;
    }

    protected Certificate removeImpl(Certificate certificate)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (certificate.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(CertificateImpl.class,
                        certificate.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(certificate);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
            CertificateImpl.class, certificate.getPrimaryKey());

        return certificate;
    }

    /**
     * @deprecated Use <code>update(Certificate certificate, boolean merge)</code>.
     */
    public Certificate update(Certificate certificate)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Certificate certificate) method. Use update(Certificate certificate, boolean merge) instead.");
        }

        return update(certificate, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                certificate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when certificate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Certificate update(Certificate certificate, boolean merge)
        throws SystemException {
        boolean isNew = certificate.isNew();

        for (ModelListener<Certificate> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(certificate);
            } else {
                listener.onBeforeUpdate(certificate);
            }
        }

        certificate = updateImpl(certificate, merge);

        for (ModelListener<Certificate> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(certificate);
            } else {
                listener.onAfterUpdate(certificate);
            }
        }

        return certificate;
    }

    public Certificate updateImpl(
        com.nss.portlet.digitalsignature.model.Certificate certificate,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, certificate, merge);

            certificate.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
            CertificateImpl.class, certificate.getPrimaryKey(), certificate);

        return certificate;
    }

    public Certificate findByPrimaryKey(long userId)
        throws NoSuchCertificateException, SystemException {
        Certificate certificate = fetchByPrimaryKey(userId);

        if (certificate == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Certificate exists with the primary key " +
                    userId);
            }

            throw new NoSuchCertificateException(
                "No Certificate exists with the primary key " + userId);
        }

        return certificate;
    }

    public Certificate fetchByPrimaryKey(long userId) throws SystemException {
        Certificate certificate = (Certificate) EntityCacheUtil.getResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
                CertificateImpl.class, userId, this);

        if (certificate == null) {
            Session session = null;

            try {
                session = openSession();

                certificate = (Certificate) session.get(CertificateImpl.class,
                        new Long(userId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (certificate != null) {
                    cacheResult(certificate);
                }

                closeSession(session);
            }
        }

        return certificate;
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

    public List<Certificate> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Certificate> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<Certificate> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Certificate> list = (List<Certificate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.digitalsignature.model.Certificate ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<Certificate>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Certificate>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Certificate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeAll() throws SystemException {
        for (Certificate certificate : findAll()) {
            remove(certificate);
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
                        "SELECT COUNT(*) FROM com.nss.portlet.digitalsignature.model.Certificate");

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
                        "value.object.listener.com.nss.portlet.digitalsignature.model.Certificate")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Certificate>> listenersList = new ArrayList<ModelListener<Certificate>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Certificate>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
