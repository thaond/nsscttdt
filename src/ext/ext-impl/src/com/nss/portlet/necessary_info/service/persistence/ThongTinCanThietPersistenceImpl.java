package com.nss.portlet.necessary_info.service.persistence;

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

import com.nss.portlet.necessary_info.NoSuchThongTinCanThietException;
import com.nss.portlet.necessary_info.model.ThongTinCanThiet;
import com.nss.portlet.necessary_info.model.impl.ThongTinCanThietImpl;
import com.nss.portlet.necessary_info.model.impl.ThongTinCanThietModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ThongTinCanThietPersistenceImpl extends BasePersistenceImpl
    implements ThongTinCanThietPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = ThongTinCanThietImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(ThongTinCanThietModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinCanThietModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(ThongTinCanThietModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinCanThietModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(ThongTinCanThietModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinCanThietModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ThongTinCanThietModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinCanThietModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThongTinCanThietModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinCanThietModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(ThongTinCanThietPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.necessary_info.service.persistence.ThongTinCanThietPersistence.impl")
    protected com.nss.portlet.necessary_info.service.persistence.ThongTinCanThietPersistence thongTinCanThietPersistence;

    public void cacheResult(ThongTinCanThiet thongTinCanThiet) {
        EntityCacheUtil.putResult(ThongTinCanThietModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinCanThietImpl.class, thongTinCanThiet.getPrimaryKey(),
            thongTinCanThiet);
    }

    public void cacheResult(List<ThongTinCanThiet> thongTinCanThiets) {
        for (ThongTinCanThiet thongTinCanThiet : thongTinCanThiets) {
            if (EntityCacheUtil.getResult(
                        ThongTinCanThietModelImpl.ENTITY_CACHE_ENABLED,
                        ThongTinCanThietImpl.class,
                        thongTinCanThiet.getPrimaryKey(), this) == null) {
                cacheResult(thongTinCanThiet);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(ThongTinCanThietImpl.class.getName());
        EntityCacheUtil.clearCache(ThongTinCanThietImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public ThongTinCanThiet create(long maThongTinCanThiet) {
        ThongTinCanThiet thongTinCanThiet = new ThongTinCanThietImpl();

        thongTinCanThiet.setNew(true);
        thongTinCanThiet.setPrimaryKey(maThongTinCanThiet);

        return thongTinCanThiet;
    }

    public ThongTinCanThiet remove(long maThongTinCanThiet)
        throws NoSuchThongTinCanThietException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ThongTinCanThiet thongTinCanThiet = (ThongTinCanThiet) session.get(ThongTinCanThietImpl.class,
                    new Long(maThongTinCanThiet));

            if (thongTinCanThiet == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No ThongTinCanThiet exists with the primary key " +
                        maThongTinCanThiet);
                }

                throw new NoSuchThongTinCanThietException(
                    "No ThongTinCanThiet exists with the primary key " +
                    maThongTinCanThiet);
            }

            return remove(thongTinCanThiet);
        } catch (NoSuchThongTinCanThietException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public ThongTinCanThiet remove(ThongTinCanThiet thongTinCanThiet)
        throws SystemException {
        for (ModelListener<ThongTinCanThiet> listener : listeners) {
            listener.onBeforeRemove(thongTinCanThiet);
        }

        thongTinCanThiet = removeImpl(thongTinCanThiet);

        for (ModelListener<ThongTinCanThiet> listener : listeners) {
            listener.onAfterRemove(thongTinCanThiet);
        }

        return thongTinCanThiet;
    }

    protected ThongTinCanThiet removeImpl(ThongTinCanThiet thongTinCanThiet)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (thongTinCanThiet.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(ThongTinCanThietImpl.class,
                        thongTinCanThiet.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(thongTinCanThiet);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(ThongTinCanThietModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinCanThietImpl.class, thongTinCanThiet.getPrimaryKey());

        return thongTinCanThiet;
    }

    /**
     * @deprecated Use <code>update(ThongTinCanThiet thongTinCanThiet, boolean merge)</code>.
     */
    public ThongTinCanThiet update(ThongTinCanThiet thongTinCanThiet)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(ThongTinCanThiet thongTinCanThiet) method. Use update(ThongTinCanThiet thongTinCanThiet, boolean merge) instead.");
        }

        return update(thongTinCanThiet, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                thongTinCanThiet the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when thongTinCanThiet is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public ThongTinCanThiet update(ThongTinCanThiet thongTinCanThiet,
        boolean merge) throws SystemException {
        boolean isNew = thongTinCanThiet.isNew();

        for (ModelListener<ThongTinCanThiet> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(thongTinCanThiet);
            } else {
                listener.onBeforeUpdate(thongTinCanThiet);
            }
        }

        thongTinCanThiet = updateImpl(thongTinCanThiet, merge);

        for (ModelListener<ThongTinCanThiet> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(thongTinCanThiet);
            } else {
                listener.onAfterUpdate(thongTinCanThiet);
            }
        }

        return thongTinCanThiet;
    }

    public ThongTinCanThiet updateImpl(
        com.nss.portlet.necessary_info.model.ThongTinCanThiet thongTinCanThiet,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, thongTinCanThiet, merge);

            thongTinCanThiet.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(ThongTinCanThietModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinCanThietImpl.class, thongTinCanThiet.getPrimaryKey(),
            thongTinCanThiet);

        return thongTinCanThiet;
    }

    public ThongTinCanThiet findByPrimaryKey(long maThongTinCanThiet)
        throws NoSuchThongTinCanThietException, SystemException {
        ThongTinCanThiet thongTinCanThiet = fetchByPrimaryKey(maThongTinCanThiet);

        if (thongTinCanThiet == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No ThongTinCanThiet exists with the primary key " +
                    maThongTinCanThiet);
            }

            throw new NoSuchThongTinCanThietException(
                "No ThongTinCanThiet exists with the primary key " +
                maThongTinCanThiet);
        }

        return thongTinCanThiet;
    }

    public ThongTinCanThiet fetchByPrimaryKey(long maThongTinCanThiet)
        throws SystemException {
        ThongTinCanThiet thongTinCanThiet = (ThongTinCanThiet) EntityCacheUtil.getResult(ThongTinCanThietModelImpl.ENTITY_CACHE_ENABLED,
                ThongTinCanThietImpl.class, maThongTinCanThiet, this);

        if (thongTinCanThiet == null) {
            Session session = null;

            try {
                session = openSession();

                thongTinCanThiet = (ThongTinCanThiet) session.get(ThongTinCanThietImpl.class,
                        new Long(maThongTinCanThiet));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (thongTinCanThiet != null) {
                    cacheResult(thongTinCanThiet);
                }

                closeSession(session);
            }
        }

        return thongTinCanThiet;
    }

    public List<ThongTinCanThiet> findByActive(int active)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<ThongTinCanThiet> list = (List<ThongTinCanThiet>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.necessary_info.model.ThongTinCanThiet WHERE ");

                query.append("active_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("thuTuThongTin ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThongTinCanThiet>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<ThongTinCanThiet> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<ThongTinCanThiet> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<ThongTinCanThiet> list = (List<ThongTinCanThiet>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.necessary_info.model.ThongTinCanThiet WHERE ");

                query.append("active_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("thuTuThongTin ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<ThongTinCanThiet>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThongTinCanThiet>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public ThongTinCanThiet findByActive_First(int active, OrderByComparator obc)
        throws NoSuchThongTinCanThietException, SystemException {
        List<ThongTinCanThiet> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ThongTinCanThiet exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchThongTinCanThietException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ThongTinCanThiet findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchThongTinCanThietException, SystemException {
        int count = countByActive(active);

        List<ThongTinCanThiet> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ThongTinCanThiet exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchThongTinCanThietException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ThongTinCanThiet[] findByActive_PrevAndNext(
        long maThongTinCanThiet, int active, OrderByComparator obc)
        throws NoSuchThongTinCanThietException, SystemException {
        ThongTinCanThiet thongTinCanThiet = findByPrimaryKey(maThongTinCanThiet);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.necessary_info.model.ThongTinCanThiet WHERE ");

            query.append("active_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("thuTuThongTin ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    thongTinCanThiet);

            ThongTinCanThiet[] array = new ThongTinCanThietImpl[3];

            array[0] = (ThongTinCanThiet) objArray[0];
            array[1] = (ThongTinCanThiet) objArray[1];
            array[2] = (ThongTinCanThiet) objArray[2];

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

    public List<ThongTinCanThiet> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<ThongTinCanThiet> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<ThongTinCanThiet> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<ThongTinCanThiet> list = (List<ThongTinCanThiet>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.necessary_info.model.ThongTinCanThiet ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("thuTuThongTin ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<ThongTinCanThiet>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ThongTinCanThiet>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThongTinCanThiet>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (ThongTinCanThiet thongTinCanThiet : findByActive(active)) {
            remove(thongTinCanThiet);
        }
    }

    public void removeAll() throws SystemException {
        for (ThongTinCanThiet thongTinCanThiet : findAll()) {
            remove(thongTinCanThiet);
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
                    "FROM com.nss.portlet.necessary_info.model.ThongTinCanThiet WHERE ");

                query.append("active_ = ?");

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
                        "SELECT COUNT(*) FROM com.nss.portlet.necessary_info.model.ThongTinCanThiet");

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
                        "value.object.listener.com.nss.portlet.necessary_info.model.ThongTinCanThiet")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ThongTinCanThiet>> listenersList = new ArrayList<ModelListener<ThongTinCanThiet>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ThongTinCanThiet>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
