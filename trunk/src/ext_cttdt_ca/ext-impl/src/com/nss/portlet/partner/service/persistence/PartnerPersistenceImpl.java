package com.nss.portlet.partner.service.persistence;

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

import com.nss.portlet.partner.NoSuchPartnerException;
import com.nss.portlet.partner.model.Partner;
import com.nss.portlet.partner.model.impl.PartnerImpl;
import com.nss.portlet.partner.model.impl.PartnerModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PartnerPersistenceImpl extends BasePersistenceImpl
    implements PartnerPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PartnerImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PartnerModelImpl.ENTITY_CACHE_ENABLED,
            PartnerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PartnerModelImpl.ENTITY_CACHE_ENABLED,
            PartnerModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PartnerPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.partner.service.persistence.PartnerPersistence.impl")
    protected com.nss.portlet.partner.service.persistence.PartnerPersistence partnerPersistence;

    public void cacheResult(Partner partner) {
        EntityCacheUtil.putResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
            PartnerImpl.class, partner.getPrimaryKey(), partner);
    }

    public void cacheResult(List<Partner> partners) {
        for (Partner partner : partners) {
            if (EntityCacheUtil.getResult(
                        PartnerModelImpl.ENTITY_CACHE_ENABLED,
                        PartnerImpl.class, partner.getPrimaryKey(), this) == null) {
                cacheResult(partner);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PartnerImpl.class.getName());
        EntityCacheUtil.clearCache(PartnerImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public Partner create(long maPartner) {
        Partner partner = new PartnerImpl();

        partner.setNew(true);
        partner.setPrimaryKey(maPartner);

        return partner;
    }

    public Partner remove(long maPartner)
        throws NoSuchPartnerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Partner partner = (Partner) session.get(PartnerImpl.class,
                    new Long(maPartner));

            if (partner == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Partner exists with the primary key " +
                        maPartner);
                }

                throw new NoSuchPartnerException(
                    "No Partner exists with the primary key " + maPartner);
            }

            return remove(partner);
        } catch (NoSuchPartnerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Partner remove(Partner partner) throws SystemException {
        for (ModelListener<Partner> listener : listeners) {
            listener.onBeforeRemove(partner);
        }

        partner = removeImpl(partner);

        for (ModelListener<Partner> listener : listeners) {
            listener.onAfterRemove(partner);
        }

        return partner;
    }

    protected Partner removeImpl(Partner partner) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (partner.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PartnerImpl.class,
                        partner.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(partner);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
            PartnerImpl.class, partner.getPrimaryKey());

        return partner;
    }

    /**
     * @deprecated Use <code>update(Partner partner, boolean merge)</code>.
     */
    public Partner update(Partner partner) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Partner partner) method. Use update(Partner partner, boolean merge) instead.");
        }

        return update(partner, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                partner the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when partner is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Partner update(Partner partner, boolean merge)
        throws SystemException {
        boolean isNew = partner.isNew();

        for (ModelListener<Partner> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(partner);
            } else {
                listener.onBeforeUpdate(partner);
            }
        }

        partner = updateImpl(partner, merge);

        for (ModelListener<Partner> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(partner);
            } else {
                listener.onAfterUpdate(partner);
            }
        }

        return partner;
    }

    public Partner updateImpl(com.nss.portlet.partner.model.Partner partner,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, partner, merge);

            partner.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
            PartnerImpl.class, partner.getPrimaryKey(), partner);

        return partner;
    }

    public Partner findByPrimaryKey(long maPartner)
        throws NoSuchPartnerException, SystemException {
        Partner partner = fetchByPrimaryKey(maPartner);

        if (partner == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Partner exists with the primary key " +
                    maPartner);
            }

            throw new NoSuchPartnerException(
                "No Partner exists with the primary key " + maPartner);
        }

        return partner;
    }

    public Partner fetchByPrimaryKey(long maPartner) throws SystemException {
        Partner partner = (Partner) EntityCacheUtil.getResult(PartnerModelImpl.ENTITY_CACHE_ENABLED,
                PartnerImpl.class, maPartner, this);

        if (partner == null) {
            Session session = null;

            try {
                session = openSession();

                partner = (Partner) session.get(PartnerImpl.class,
                        new Long(maPartner));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (partner != null) {
                    cacheResult(partner);
                }

                closeSession(session);
            }
        }

        return partner;
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

    public List<Partner> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Partner> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<Partner> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Partner> list = (List<Partner>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.partner.model.Partner ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("thu_tu_partner ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<Partner>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Partner>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Partner>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeAll() throws SystemException {
        for (Partner partner : findAll()) {
            remove(partner);
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
                        "SELECT COUNT(*) FROM com.nss.portlet.partner.model.Partner");

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
                        "value.object.listener.com.nss.portlet.partner.model.Partner")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Partner>> listenersList = new ArrayList<ModelListener<Partner>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Partner>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
