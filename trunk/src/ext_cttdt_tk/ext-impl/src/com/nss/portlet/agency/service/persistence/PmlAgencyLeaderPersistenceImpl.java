package com.nss.portlet.agency.service.persistence;

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

import com.nss.portlet.agency.NoSuchPmlAgencyLeaderException;
import com.nss.portlet.agency.model.PmlAgencyLeader;
import com.nss.portlet.agency.model.impl.PmlAgencyLeaderImpl;
import com.nss.portlet.agency.model.impl.PmlAgencyLeaderModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlAgencyLeaderPersistenceImpl extends BasePersistenceImpl
    implements PmlAgencyLeaderPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlAgencyLeaderImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(PmlAgencyLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlAgencyLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByUserId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(PmlAgencyLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlAgencyLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByUserId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(PmlAgencyLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlAgencyLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByUserId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlAgencyLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlAgencyLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlAgencyLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlAgencyLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlAgencyLeaderPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.agency.service.persistence.AgencyPersistence.impl")
    protected com.nss.portlet.agency.service.persistence.AgencyPersistence agencyPersistence;
    @BeanReference(name = "com.nss.portlet.agency.service.persistence.PmlAgencyLeaderPersistence.impl")
    protected com.nss.portlet.agency.service.persistence.PmlAgencyLeaderPersistence pmlAgencyLeaderPersistence;

    public void cacheResult(PmlAgencyLeader pmlAgencyLeader) {
        EntityCacheUtil.putResult(PmlAgencyLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlAgencyLeaderImpl.class, pmlAgencyLeader.getPrimaryKey(),
            pmlAgencyLeader);
    }

    public void cacheResult(List<PmlAgencyLeader> pmlAgencyLeaders) {
        for (PmlAgencyLeader pmlAgencyLeader : pmlAgencyLeaders) {
            if (EntityCacheUtil.getResult(
                        PmlAgencyLeaderModelImpl.ENTITY_CACHE_ENABLED,
                        PmlAgencyLeaderImpl.class,
                        pmlAgencyLeader.getPrimaryKey(), this) == null) {
                cacheResult(pmlAgencyLeader);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlAgencyLeaderImpl.class.getName());
        EntityCacheUtil.clearCache(PmlAgencyLeaderImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlAgencyLeader create(String agencyId) {
        PmlAgencyLeader pmlAgencyLeader = new PmlAgencyLeaderImpl();

        pmlAgencyLeader.setNew(true);
        pmlAgencyLeader.setPrimaryKey(agencyId);

        return pmlAgencyLeader;
    }

    public PmlAgencyLeader remove(String agencyId)
        throws NoSuchPmlAgencyLeaderException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlAgencyLeader pmlAgencyLeader = (PmlAgencyLeader) session.get(PmlAgencyLeaderImpl.class,
                    agencyId);

            if (pmlAgencyLeader == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlAgencyLeader exists with the primary key " +
                        agencyId);
                }

                throw new NoSuchPmlAgencyLeaderException(
                    "No PmlAgencyLeader exists with the primary key " +
                    agencyId);
            }

            return remove(pmlAgencyLeader);
        } catch (NoSuchPmlAgencyLeaderException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlAgencyLeader remove(PmlAgencyLeader pmlAgencyLeader)
        throws SystemException {
        for (ModelListener<PmlAgencyLeader> listener : listeners) {
            listener.onBeforeRemove(pmlAgencyLeader);
        }

        pmlAgencyLeader = removeImpl(pmlAgencyLeader);

        for (ModelListener<PmlAgencyLeader> listener : listeners) {
            listener.onAfterRemove(pmlAgencyLeader);
        }

        return pmlAgencyLeader;
    }

    protected PmlAgencyLeader removeImpl(PmlAgencyLeader pmlAgencyLeader)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlAgencyLeader.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlAgencyLeaderImpl.class,
                        pmlAgencyLeader.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlAgencyLeader);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlAgencyLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlAgencyLeaderImpl.class, pmlAgencyLeader.getPrimaryKey());

        return pmlAgencyLeader;
    }

    /**
     * @deprecated Use <code>update(PmlAgencyLeader pmlAgencyLeader, boolean merge)</code>.
     */
    public PmlAgencyLeader update(PmlAgencyLeader pmlAgencyLeader)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlAgencyLeader pmlAgencyLeader) method. Use update(PmlAgencyLeader pmlAgencyLeader, boolean merge) instead.");
        }

        return update(pmlAgencyLeader, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlAgencyLeader the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlAgencyLeader is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlAgencyLeader update(PmlAgencyLeader pmlAgencyLeader, boolean merge)
        throws SystemException {
        boolean isNew = pmlAgencyLeader.isNew();

        for (ModelListener<PmlAgencyLeader> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlAgencyLeader);
            } else {
                listener.onBeforeUpdate(pmlAgencyLeader);
            }
        }

        pmlAgencyLeader = updateImpl(pmlAgencyLeader, merge);

        for (ModelListener<PmlAgencyLeader> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlAgencyLeader);
            } else {
                listener.onAfterUpdate(pmlAgencyLeader);
            }
        }

        return pmlAgencyLeader;
    }

    public PmlAgencyLeader updateImpl(
        com.nss.portlet.agency.model.PmlAgencyLeader pmlAgencyLeader,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlAgencyLeader, merge);

            pmlAgencyLeader.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlAgencyLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlAgencyLeaderImpl.class, pmlAgencyLeader.getPrimaryKey(),
            pmlAgencyLeader);

        return pmlAgencyLeader;
    }

    public PmlAgencyLeader findByPrimaryKey(String agencyId)
        throws NoSuchPmlAgencyLeaderException, SystemException {
        PmlAgencyLeader pmlAgencyLeader = fetchByPrimaryKey(agencyId);

        if (pmlAgencyLeader == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlAgencyLeader exists with the primary key " +
                    agencyId);
            }

            throw new NoSuchPmlAgencyLeaderException(
                "No PmlAgencyLeader exists with the primary key " + agencyId);
        }

        return pmlAgencyLeader;
    }

    public PmlAgencyLeader fetchByPrimaryKey(String agencyId)
        throws SystemException {
        PmlAgencyLeader pmlAgencyLeader = (PmlAgencyLeader) EntityCacheUtil.getResult(PmlAgencyLeaderModelImpl.ENTITY_CACHE_ENABLED,
                PmlAgencyLeaderImpl.class, agencyId, this);

        if (pmlAgencyLeader == null) {
            Session session = null;

            try {
                session = openSession();

                pmlAgencyLeader = (PmlAgencyLeader) session.get(PmlAgencyLeaderImpl.class,
                        agencyId);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlAgencyLeader != null) {
                    cacheResult(pmlAgencyLeader);
                }

                closeSession(session);
            }
        }

        return pmlAgencyLeader;
    }

    public List<PmlAgencyLeader> findByUserId(long userId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(userId) };

        List<PmlAgencyLeader> list = (List<PmlAgencyLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.agency.model.PmlAgencyLeader WHERE ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlAgencyLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlAgencyLeader> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    public List<PmlAgencyLeader> findByUserId(long userId, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(userId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlAgencyLeader> list = (List<PmlAgencyLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.agency.model.PmlAgencyLeader WHERE ");

                query.append("userId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                list = (List<PmlAgencyLeader>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlAgencyLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlAgencyLeader findByUserId_First(long userId, OrderByComparator obc)
        throws NoSuchPmlAgencyLeaderException, SystemException {
        List<PmlAgencyLeader> list = findByUserId(userId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlAgencyLeader exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlAgencyLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlAgencyLeader findByUserId_Last(long userId, OrderByComparator obc)
        throws NoSuchPmlAgencyLeaderException, SystemException {
        int count = countByUserId(userId);

        List<PmlAgencyLeader> list = findByUserId(userId, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlAgencyLeader exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlAgencyLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlAgencyLeader[] findByUserId_PrevAndNext(String agencyId,
        long userId, OrderByComparator obc)
        throws NoSuchPmlAgencyLeaderException, SystemException {
        PmlAgencyLeader pmlAgencyLeader = findByPrimaryKey(agencyId);

        int count = countByUserId(userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.agency.model.PmlAgencyLeader WHERE ");

            query.append("userId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlAgencyLeader);

            PmlAgencyLeader[] array = new PmlAgencyLeaderImpl[3];

            array[0] = (PmlAgencyLeader) objArray[0];
            array[1] = (PmlAgencyLeader) objArray[1];
            array[2] = (PmlAgencyLeader) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
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

    public List<PmlAgencyLeader> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlAgencyLeader> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlAgencyLeader> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlAgencyLeader> list = (List<PmlAgencyLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.agency.model.PmlAgencyLeader ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlAgencyLeader>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlAgencyLeader>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlAgencyLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByUserId(long userId) throws SystemException {
        for (PmlAgencyLeader pmlAgencyLeader : findByUserId(userId)) {
            remove(pmlAgencyLeader);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlAgencyLeader pmlAgencyLeader : findAll()) {
            remove(pmlAgencyLeader);
        }
    }

    public int countByUserId(long userId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(userId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.agency.model.PmlAgencyLeader WHERE ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
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
                        "SELECT COUNT(*) FROM com.nss.portlet.agency.model.PmlAgencyLeader");

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
                        "value.object.listener.com.nss.portlet.agency.model.PmlAgencyLeader")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlAgencyLeader>> listenersList = new ArrayList<ModelListener<PmlAgencyLeader>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlAgencyLeader>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
