package com.nss.portlet.co_quan_ban_hanh.service.persistence;

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

import com.nss.portlet.co_quan_ban_hanh.NoSuchCoQuanBanHanhException;
import com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh;
import com.nss.portlet.co_quan_ban_hanh.model.impl.CoQuanBanHanhImpl;
import com.nss.portlet.co_quan_ban_hanh.model.impl.CoQuanBanHanhModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CoQuanBanHanhPersistenceImpl extends BasePersistenceImpl
    implements CoQuanBanHanhPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = CoQuanBanHanhImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(CoQuanBanHanhModelImpl.ENTITY_CACHE_ENABLED,
            CoQuanBanHanhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(CoQuanBanHanhModelImpl.ENTITY_CACHE_ENABLED,
            CoQuanBanHanhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(CoQuanBanHanhModelImpl.ENTITY_CACHE_ENABLED,
            CoQuanBanHanhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CoQuanBanHanhModelImpl.ENTITY_CACHE_ENABLED,
            CoQuanBanHanhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CoQuanBanHanhModelImpl.ENTITY_CACHE_ENABLED,
            CoQuanBanHanhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(CoQuanBanHanhPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.co_quan_ban_hanh.service.persistence.CoQuanBanHanhPersistence.impl")
    protected com.nss.portlet.co_quan_ban_hanh.service.persistence.CoQuanBanHanhPersistence coQuanBanHanhPersistence;

    public void cacheResult(CoQuanBanHanh coQuanBanHanh) {
        EntityCacheUtil.putResult(CoQuanBanHanhModelImpl.ENTITY_CACHE_ENABLED,
            CoQuanBanHanhImpl.class, coQuanBanHanh.getPrimaryKey(),
            coQuanBanHanh);
    }

    public void cacheResult(List<CoQuanBanHanh> coQuanBanHanhs) {
        for (CoQuanBanHanh coQuanBanHanh : coQuanBanHanhs) {
            if (EntityCacheUtil.getResult(
                        CoQuanBanHanhModelImpl.ENTITY_CACHE_ENABLED,
                        CoQuanBanHanhImpl.class, coQuanBanHanh.getPrimaryKey(),
                        this) == null) {
                cacheResult(coQuanBanHanh);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(CoQuanBanHanhImpl.class.getName());
        EntityCacheUtil.clearCache(CoQuanBanHanhImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public CoQuanBanHanh create(long maCoQuanBanHanh) {
        CoQuanBanHanh coQuanBanHanh = new CoQuanBanHanhImpl();

        coQuanBanHanh.setNew(true);
        coQuanBanHanh.setPrimaryKey(maCoQuanBanHanh);

        return coQuanBanHanh;
    }

    public CoQuanBanHanh remove(long maCoQuanBanHanh)
        throws NoSuchCoQuanBanHanhException, SystemException {
        Session session = null;

        try {
            session = openSession();

            CoQuanBanHanh coQuanBanHanh = (CoQuanBanHanh) session.get(CoQuanBanHanhImpl.class,
                    new Long(maCoQuanBanHanh));

            if (coQuanBanHanh == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No CoQuanBanHanh exists with the primary key " +
                        maCoQuanBanHanh);
                }

                throw new NoSuchCoQuanBanHanhException(
                    "No CoQuanBanHanh exists with the primary key " +
                    maCoQuanBanHanh);
            }

            return remove(coQuanBanHanh);
        } catch (NoSuchCoQuanBanHanhException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public CoQuanBanHanh remove(CoQuanBanHanh coQuanBanHanh)
        throws SystemException {
        for (ModelListener<CoQuanBanHanh> listener : listeners) {
            listener.onBeforeRemove(coQuanBanHanh);
        }

        coQuanBanHanh = removeImpl(coQuanBanHanh);

        for (ModelListener<CoQuanBanHanh> listener : listeners) {
            listener.onAfterRemove(coQuanBanHanh);
        }

        return coQuanBanHanh;
    }

    protected CoQuanBanHanh removeImpl(CoQuanBanHanh coQuanBanHanh)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (coQuanBanHanh.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(CoQuanBanHanhImpl.class,
                        coQuanBanHanh.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(coQuanBanHanh);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(CoQuanBanHanhModelImpl.ENTITY_CACHE_ENABLED,
            CoQuanBanHanhImpl.class, coQuanBanHanh.getPrimaryKey());

        return coQuanBanHanh;
    }

    /**
     * @deprecated Use <code>update(CoQuanBanHanh coQuanBanHanh, boolean merge)</code>.
     */
    public CoQuanBanHanh update(CoQuanBanHanh coQuanBanHanh)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(CoQuanBanHanh coQuanBanHanh) method. Use update(CoQuanBanHanh coQuanBanHanh, boolean merge) instead.");
        }

        return update(coQuanBanHanh, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                coQuanBanHanh the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when coQuanBanHanh is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public CoQuanBanHanh update(CoQuanBanHanh coQuanBanHanh, boolean merge)
        throws SystemException {
        boolean isNew = coQuanBanHanh.isNew();

        for (ModelListener<CoQuanBanHanh> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(coQuanBanHanh);
            } else {
                listener.onBeforeUpdate(coQuanBanHanh);
            }
        }

        coQuanBanHanh = updateImpl(coQuanBanHanh, merge);

        for (ModelListener<CoQuanBanHanh> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(coQuanBanHanh);
            } else {
                listener.onAfterUpdate(coQuanBanHanh);
            }
        }

        return coQuanBanHanh;
    }

    public CoQuanBanHanh updateImpl(
        com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh coQuanBanHanh,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, coQuanBanHanh, merge);

            coQuanBanHanh.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(CoQuanBanHanhModelImpl.ENTITY_CACHE_ENABLED,
            CoQuanBanHanhImpl.class, coQuanBanHanh.getPrimaryKey(),
            coQuanBanHanh);

        return coQuanBanHanh;
    }

    public CoQuanBanHanh findByPrimaryKey(long maCoQuanBanHanh)
        throws NoSuchCoQuanBanHanhException, SystemException {
        CoQuanBanHanh coQuanBanHanh = fetchByPrimaryKey(maCoQuanBanHanh);

        if (coQuanBanHanh == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No CoQuanBanHanh exists with the primary key " +
                    maCoQuanBanHanh);
            }

            throw new NoSuchCoQuanBanHanhException(
                "No CoQuanBanHanh exists with the primary key " +
                maCoQuanBanHanh);
        }

        return coQuanBanHanh;
    }

    public CoQuanBanHanh fetchByPrimaryKey(long maCoQuanBanHanh)
        throws SystemException {
        CoQuanBanHanh coQuanBanHanh = (CoQuanBanHanh) EntityCacheUtil.getResult(CoQuanBanHanhModelImpl.ENTITY_CACHE_ENABLED,
                CoQuanBanHanhImpl.class, maCoQuanBanHanh, this);

        if (coQuanBanHanh == null) {
            Session session = null;

            try {
                session = openSession();

                coQuanBanHanh = (CoQuanBanHanh) session.get(CoQuanBanHanhImpl.class,
                        new Long(maCoQuanBanHanh));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (coQuanBanHanh != null) {
                    cacheResult(coQuanBanHanh);
                }

                closeSession(session);
            }
        }

        return coQuanBanHanh;
    }

    public List<CoQuanBanHanh> findByActive(int active)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<CoQuanBanHanh> list = (List<CoQuanBanHanh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ten_co_quan_ban_hanh ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CoQuanBanHanh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<CoQuanBanHanh> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<CoQuanBanHanh> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<CoQuanBanHanh> list = (List<CoQuanBanHanh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_co_quan_ban_hanh ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<CoQuanBanHanh>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CoQuanBanHanh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public CoQuanBanHanh findByActive_First(int active, OrderByComparator obc)
        throws NoSuchCoQuanBanHanhException, SystemException {
        List<CoQuanBanHanh> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CoQuanBanHanh exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCoQuanBanHanhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public CoQuanBanHanh findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchCoQuanBanHanhException, SystemException {
        int count = countByActive(active);

        List<CoQuanBanHanh> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CoQuanBanHanh exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCoQuanBanHanhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public CoQuanBanHanh[] findByActive_PrevAndNext(long maCoQuanBanHanh,
        int active, OrderByComparator obc)
        throws NoSuchCoQuanBanHanhException, SystemException {
        CoQuanBanHanh coQuanBanHanh = findByPrimaryKey(maCoQuanBanHanh);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ten_co_quan_ban_hanh ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    coQuanBanHanh);

            CoQuanBanHanh[] array = new CoQuanBanHanhImpl[3];

            array[0] = (CoQuanBanHanh) objArray[0];
            array[1] = (CoQuanBanHanh) objArray[1];
            array[2] = (CoQuanBanHanh) objArray[2];

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

    public List<CoQuanBanHanh> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<CoQuanBanHanh> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<CoQuanBanHanh> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<CoQuanBanHanh> list = (List<CoQuanBanHanh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_co_quan_ban_hanh ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<CoQuanBanHanh>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<CoQuanBanHanh>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CoQuanBanHanh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (CoQuanBanHanh coQuanBanHanh : findByActive(active)) {
            remove(coQuanBanHanh);
        }
    }

    public void removeAll() throws SystemException {
        for (CoQuanBanHanh coQuanBanHanh : findAll()) {
            remove(coQuanBanHanh);
        }
    }

    public int countByActive(int active) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh WHERE ");

                query.append("active = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVE,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh");

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
                        "value.object.listener.com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<CoQuanBanHanh>> listenersList = new ArrayList<ModelListener<CoQuanBanHanh>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<CoQuanBanHanh>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
