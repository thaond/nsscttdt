package com.nss.portlet.thong_tin_lien_quan.service.persistence;

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

import com.nss.portlet.thong_tin_lien_quan.NoSuchThongTinLienQuanException;
import com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan;
import com.nss.portlet.thong_tin_lien_quan.model.impl.ThongTinLienQuanImpl;
import com.nss.portlet.thong_tin_lien_quan.model.impl.ThongTinLienQuanModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ThongTinLienQuanPersistenceImpl extends BasePersistenceImpl
    implements ThongTinLienQuanPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = ThongTinLienQuanImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(ThongTinLienQuanModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinLienQuanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(ThongTinLienQuanModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinLienQuanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(ThongTinLienQuanModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinLienQuanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ThongTinLienQuanModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinLienQuanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThongTinLienQuanModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinLienQuanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(ThongTinLienQuanPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.thong_tin_lien_quan.service.persistence.ThongTinLienQuanPersistence.impl")
    protected com.nss.portlet.thong_tin_lien_quan.service.persistence.ThongTinLienQuanPersistence thongTinLienQuanPersistence;

    public void cacheResult(ThongTinLienQuan thongTinLienQuan) {
        EntityCacheUtil.putResult(ThongTinLienQuanModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinLienQuanImpl.class, thongTinLienQuan.getPrimaryKey(),
            thongTinLienQuan);
    }

    public void cacheResult(List<ThongTinLienQuan> thongTinLienQuans) {
        for (ThongTinLienQuan thongTinLienQuan : thongTinLienQuans) {
            if (EntityCacheUtil.getResult(
                        ThongTinLienQuanModelImpl.ENTITY_CACHE_ENABLED,
                        ThongTinLienQuanImpl.class,
                        thongTinLienQuan.getPrimaryKey(), this) == null) {
                cacheResult(thongTinLienQuan);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(ThongTinLienQuanImpl.class.getName());
        EntityCacheUtil.clearCache(ThongTinLienQuanImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public ThongTinLienQuan create(long maThongTinLienQuan) {
        ThongTinLienQuan thongTinLienQuan = new ThongTinLienQuanImpl();

        thongTinLienQuan.setNew(true);
        thongTinLienQuan.setPrimaryKey(maThongTinLienQuan);

        return thongTinLienQuan;
    }

    public ThongTinLienQuan remove(long maThongTinLienQuan)
        throws NoSuchThongTinLienQuanException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ThongTinLienQuan thongTinLienQuan = (ThongTinLienQuan) session.get(ThongTinLienQuanImpl.class,
                    new Long(maThongTinLienQuan));

            if (thongTinLienQuan == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No ThongTinLienQuan exists with the primary key " +
                        maThongTinLienQuan);
                }

                throw new NoSuchThongTinLienQuanException(
                    "No ThongTinLienQuan exists with the primary key " +
                    maThongTinLienQuan);
            }

            return remove(thongTinLienQuan);
        } catch (NoSuchThongTinLienQuanException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public ThongTinLienQuan remove(ThongTinLienQuan thongTinLienQuan)
        throws SystemException {
        for (ModelListener<ThongTinLienQuan> listener : listeners) {
            listener.onBeforeRemove(thongTinLienQuan);
        }

        thongTinLienQuan = removeImpl(thongTinLienQuan);

        for (ModelListener<ThongTinLienQuan> listener : listeners) {
            listener.onAfterRemove(thongTinLienQuan);
        }

        return thongTinLienQuan;
    }

    protected ThongTinLienQuan removeImpl(ThongTinLienQuan thongTinLienQuan)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (thongTinLienQuan.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(ThongTinLienQuanImpl.class,
                        thongTinLienQuan.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(thongTinLienQuan);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(ThongTinLienQuanModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinLienQuanImpl.class, thongTinLienQuan.getPrimaryKey());

        return thongTinLienQuan;
    }

    /**
     * @deprecated Use <code>update(ThongTinLienQuan thongTinLienQuan, boolean merge)</code>.
     */
    public ThongTinLienQuan update(ThongTinLienQuan thongTinLienQuan)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(ThongTinLienQuan thongTinLienQuan) method. Use update(ThongTinLienQuan thongTinLienQuan, boolean merge) instead.");
        }

        return update(thongTinLienQuan, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                thongTinLienQuan the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when thongTinLienQuan is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public ThongTinLienQuan update(ThongTinLienQuan thongTinLienQuan,
        boolean merge) throws SystemException {
        boolean isNew = thongTinLienQuan.isNew();

        for (ModelListener<ThongTinLienQuan> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(thongTinLienQuan);
            } else {
                listener.onBeforeUpdate(thongTinLienQuan);
            }
        }

        thongTinLienQuan = updateImpl(thongTinLienQuan, merge);

        for (ModelListener<ThongTinLienQuan> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(thongTinLienQuan);
            } else {
                listener.onAfterUpdate(thongTinLienQuan);
            }
        }

        return thongTinLienQuan;
    }

    public ThongTinLienQuan updateImpl(
        com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan thongTinLienQuan,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, thongTinLienQuan, merge);

            thongTinLienQuan.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(ThongTinLienQuanModelImpl.ENTITY_CACHE_ENABLED,
            ThongTinLienQuanImpl.class, thongTinLienQuan.getPrimaryKey(),
            thongTinLienQuan);

        return thongTinLienQuan;
    }

    public ThongTinLienQuan findByPrimaryKey(long maThongTinLienQuan)
        throws NoSuchThongTinLienQuanException, SystemException {
        ThongTinLienQuan thongTinLienQuan = fetchByPrimaryKey(maThongTinLienQuan);

        if (thongTinLienQuan == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No ThongTinLienQuan exists with the primary key " +
                    maThongTinLienQuan);
            }

            throw new NoSuchThongTinLienQuanException(
                "No ThongTinLienQuan exists with the primary key " +
                maThongTinLienQuan);
        }

        return thongTinLienQuan;
    }

    public ThongTinLienQuan fetchByPrimaryKey(long maThongTinLienQuan)
        throws SystemException {
        ThongTinLienQuan thongTinLienQuan = (ThongTinLienQuan) EntityCacheUtil.getResult(ThongTinLienQuanModelImpl.ENTITY_CACHE_ENABLED,
                ThongTinLienQuanImpl.class, maThongTinLienQuan, this);

        if (thongTinLienQuan == null) {
            Session session = null;

            try {
                session = openSession();

                thongTinLienQuan = (ThongTinLienQuan) session.get(ThongTinLienQuanImpl.class,
                        new Long(maThongTinLienQuan));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (thongTinLienQuan != null) {
                    cacheResult(thongTinLienQuan);
                }

                closeSession(session);
            }
        }

        return thongTinLienQuan;
    }

    public List<ThongTinLienQuan> findByActive(int active)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<ThongTinLienQuan> list = (List<ThongTinLienQuan>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("thu_tu_thong_tin ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThongTinLienQuan>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<ThongTinLienQuan> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<ThongTinLienQuan> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<ThongTinLienQuan> list = (List<ThongTinLienQuan>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("thu_tu_thong_tin ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<ThongTinLienQuan>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThongTinLienQuan>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public ThongTinLienQuan findByActive_First(int active, OrderByComparator obc)
        throws NoSuchThongTinLienQuanException, SystemException {
        List<ThongTinLienQuan> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ThongTinLienQuan exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchThongTinLienQuanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ThongTinLienQuan findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchThongTinLienQuanException, SystemException {
        int count = countByActive(active);

        List<ThongTinLienQuan> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ThongTinLienQuan exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchThongTinLienQuanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ThongTinLienQuan[] findByActive_PrevAndNext(
        long maThongTinLienQuan, int active, OrderByComparator obc)
        throws NoSuchThongTinLienQuanException, SystemException {
        ThongTinLienQuan thongTinLienQuan = findByPrimaryKey(maThongTinLienQuan);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("thu_tu_thong_tin ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    thongTinLienQuan);

            ThongTinLienQuan[] array = new ThongTinLienQuanImpl[3];

            array[0] = (ThongTinLienQuan) objArray[0];
            array[1] = (ThongTinLienQuan) objArray[1];
            array[2] = (ThongTinLienQuan) objArray[2];

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

    public List<ThongTinLienQuan> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<ThongTinLienQuan> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<ThongTinLienQuan> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<ThongTinLienQuan> list = (List<ThongTinLienQuan>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("thu_tu_thong_tin ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<ThongTinLienQuan>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ThongTinLienQuan>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThongTinLienQuan>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (ThongTinLienQuan thongTinLienQuan : findByActive(active)) {
            remove(thongTinLienQuan);
        }
    }

    public void removeAll() throws SystemException {
        for (ThongTinLienQuan thongTinLienQuan : findAll()) {
            remove(thongTinLienQuan);
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
                    "FROM com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan WHERE ");

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
                        "SELECT COUNT(*) FROM com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan");

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
                        "value.object.listener.com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ThongTinLienQuan>> listenersList = new ArrayList<ModelListener<ThongTinLienQuan>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ThongTinLienQuan>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
