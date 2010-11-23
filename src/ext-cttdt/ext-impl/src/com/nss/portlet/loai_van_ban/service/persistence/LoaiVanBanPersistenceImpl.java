package com.nss.portlet.loai_van_ban.service.persistence;

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

import com.nss.portlet.loai_van_ban.NoSuchLoaiVanBanException;
import com.nss.portlet.loai_van_ban.model.LoaiVanBan;
import com.nss.portlet.loai_van_ban.model.impl.LoaiVanBanImpl;
import com.nss.portlet.loai_van_ban.model.impl.LoaiVanBanModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LoaiVanBanPersistenceImpl extends BasePersistenceImpl
    implements LoaiVanBanPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = LoaiVanBanImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByActive", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LoaiVanBanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(LoaiVanBanPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.loai_van_ban.service.persistence.LoaiVanBanPersistence.impl")
    protected com.nss.portlet.loai_van_ban.service.persistence.LoaiVanBanPersistence loaiVanBanPersistence;

    public void cacheResult(LoaiVanBan loaiVanBan) {
        EntityCacheUtil.putResult(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LoaiVanBanImpl.class, loaiVanBan.getPrimaryKey(), loaiVanBan);
    }

    public void cacheResult(List<LoaiVanBan> loaiVanBans) {
        for (LoaiVanBan loaiVanBan : loaiVanBans) {
            if (EntityCacheUtil.getResult(
                        LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
                        LoaiVanBanImpl.class, loaiVanBan.getPrimaryKey(), this) == null) {
                cacheResult(loaiVanBan);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(LoaiVanBanImpl.class.getName());
        EntityCacheUtil.clearCache(LoaiVanBanImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public LoaiVanBan create(long maLoaiVanBan) {
        LoaiVanBan loaiVanBan = new LoaiVanBanImpl();

        loaiVanBan.setNew(true);
        loaiVanBan.setPrimaryKey(maLoaiVanBan);

        return loaiVanBan;
    }

    public LoaiVanBan remove(long maLoaiVanBan)
        throws NoSuchLoaiVanBanException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LoaiVanBan loaiVanBan = (LoaiVanBan) session.get(LoaiVanBanImpl.class,
                    new Long(maLoaiVanBan));

            if (loaiVanBan == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No LoaiVanBan exists with the primary key " +
                        maLoaiVanBan);
                }

                throw new NoSuchLoaiVanBanException(
                    "No LoaiVanBan exists with the primary key " +
                    maLoaiVanBan);
            }

            return remove(loaiVanBan);
        } catch (NoSuchLoaiVanBanException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public LoaiVanBan remove(LoaiVanBan loaiVanBan) throws SystemException {
        for (ModelListener<LoaiVanBan> listener : listeners) {
            listener.onBeforeRemove(loaiVanBan);
        }

        loaiVanBan = removeImpl(loaiVanBan);

        for (ModelListener<LoaiVanBan> listener : listeners) {
            listener.onAfterRemove(loaiVanBan);
        }

        return loaiVanBan;
    }

    protected LoaiVanBan removeImpl(LoaiVanBan loaiVanBan)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (loaiVanBan.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(LoaiVanBanImpl.class,
                        loaiVanBan.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(loaiVanBan);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LoaiVanBanImpl.class, loaiVanBan.getPrimaryKey());

        return loaiVanBan;
    }

    /**
     * @deprecated Use <code>update(LoaiVanBan loaiVanBan, boolean merge)</code>.
     */
    public LoaiVanBan update(LoaiVanBan loaiVanBan) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(LoaiVanBan loaiVanBan) method. Use update(LoaiVanBan loaiVanBan, boolean merge) instead.");
        }

        return update(loaiVanBan, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiVanBan the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiVanBan is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public LoaiVanBan update(LoaiVanBan loaiVanBan, boolean merge)
        throws SystemException {
        boolean isNew = loaiVanBan.isNew();

        for (ModelListener<LoaiVanBan> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(loaiVanBan);
            } else {
                listener.onBeforeUpdate(loaiVanBan);
            }
        }

        loaiVanBan = updateImpl(loaiVanBan, merge);

        for (ModelListener<LoaiVanBan> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(loaiVanBan);
            } else {
                listener.onAfterUpdate(loaiVanBan);
            }
        }

        return loaiVanBan;
    }

    public LoaiVanBan updateImpl(
        com.nss.portlet.loai_van_ban.model.LoaiVanBan loaiVanBan, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, loaiVanBan, merge);

            loaiVanBan.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LoaiVanBanImpl.class, loaiVanBan.getPrimaryKey(), loaiVanBan);

        return loaiVanBan;
    }

    public LoaiVanBan findByPrimaryKey(long maLoaiVanBan)
        throws NoSuchLoaiVanBanException, SystemException {
        LoaiVanBan loaiVanBan = fetchByPrimaryKey(maLoaiVanBan);

        if (loaiVanBan == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No LoaiVanBan exists with the primary key " +
                    maLoaiVanBan);
            }

            throw new NoSuchLoaiVanBanException(
                "No LoaiVanBan exists with the primary key " + maLoaiVanBan);
        }

        return loaiVanBan;
    }

    public LoaiVanBan fetchByPrimaryKey(long maLoaiVanBan)
        throws SystemException {
        LoaiVanBan loaiVanBan = (LoaiVanBan) EntityCacheUtil.getResult(LoaiVanBanModelImpl.ENTITY_CACHE_ENABLED,
                LoaiVanBanImpl.class, maLoaiVanBan, this);

        if (loaiVanBan == null) {
            Session session = null;

            try {
                session = openSession();

                loaiVanBan = (LoaiVanBan) session.get(LoaiVanBanImpl.class,
                        new Long(maLoaiVanBan));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (loaiVanBan != null) {
                    cacheResult(loaiVanBan);
                }

                closeSession(session);
            }
        }

        return loaiVanBan;
    }

    public List<LoaiVanBan> findByActive(int active) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<LoaiVanBan> list = (List<LoaiVanBan>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.loai_van_ban.model.LoaiVanBan WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ten_loai_van_ban ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LoaiVanBan>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<LoaiVanBan> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<LoaiVanBan> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LoaiVanBan> list = (List<LoaiVanBan>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.loai_van_ban.model.LoaiVanBan WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_loai_van_ban ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<LoaiVanBan>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LoaiVanBan>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public LoaiVanBan findByActive_First(int active, OrderByComparator obc)
        throws NoSuchLoaiVanBanException, SystemException {
        List<LoaiVanBan> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LoaiVanBan exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLoaiVanBanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LoaiVanBan findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchLoaiVanBanException, SystemException {
        int count = countByActive(active);

        List<LoaiVanBan> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LoaiVanBan exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLoaiVanBanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LoaiVanBan[] findByActive_PrevAndNext(long maLoaiVanBan, int active,
        OrderByComparator obc)
        throws NoSuchLoaiVanBanException, SystemException {
        LoaiVanBan loaiVanBan = findByPrimaryKey(maLoaiVanBan);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.loai_van_ban.model.LoaiVanBan WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ten_loai_van_ban ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    loaiVanBan);

            LoaiVanBan[] array = new LoaiVanBanImpl[3];

            array[0] = (LoaiVanBan) objArray[0];
            array[1] = (LoaiVanBan) objArray[1];
            array[2] = (LoaiVanBan) objArray[2];

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

    public List<LoaiVanBan> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<LoaiVanBan> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<LoaiVanBan> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LoaiVanBan> list = (List<LoaiVanBan>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.loai_van_ban.model.LoaiVanBan ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_loai_van_ban ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<LoaiVanBan>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LoaiVanBan>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LoaiVanBan>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (LoaiVanBan loaiVanBan : findByActive(active)) {
            remove(loaiVanBan);
        }
    }

    public void removeAll() throws SystemException {
        for (LoaiVanBan loaiVanBan : findAll()) {
            remove(loaiVanBan);
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
                    "FROM com.nss.portlet.loai_van_ban.model.LoaiVanBan WHERE ");

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
                        "SELECT COUNT(*) FROM com.nss.portlet.loai_van_ban.model.LoaiVanBan");

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
                        "value.object.listener.com.nss.portlet.loai_van_ban.model.LoaiVanBan")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LoaiVanBan>> listenersList = new ArrayList<ModelListener<LoaiVanBan>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LoaiVanBan>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
