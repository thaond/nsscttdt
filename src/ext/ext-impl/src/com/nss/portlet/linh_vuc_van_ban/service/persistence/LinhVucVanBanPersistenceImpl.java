package com.nss.portlet.linh_vuc_van_ban.service.persistence;

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

import com.nss.portlet.linh_vuc_van_ban.NoSuchLinhVucVanBanException;
import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan;
import com.nss.portlet.linh_vuc_van_ban.model.impl.LinhVucVanBanImpl;
import com.nss.portlet.linh_vuc_van_ban.model.impl.LinhVucVanBanModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LinhVucVanBanPersistenceImpl extends BasePersistenceImpl
    implements LinhVucVanBanPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = LinhVucVanBanImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_PARENTID = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByParentId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_PARENTID = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByParentId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByParentId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucVanBanModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(LinhVucVanBanPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.linh_vuc_van_ban.service.persistence.LinhVucVanBanPersistence.impl")
    protected com.nss.portlet.linh_vuc_van_ban.service.persistence.LinhVucVanBanPersistence linhVucVanBanPersistence;

    public void cacheResult(LinhVucVanBan linhVucVanBan) {
        EntityCacheUtil.putResult(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucVanBanImpl.class, linhVucVanBan.getPrimaryKey(),
            linhVucVanBan);
    }

    public void cacheResult(List<LinhVucVanBan> linhVucVanBans) {
        for (LinhVucVanBan linhVucVanBan : linhVucVanBans) {
            if (EntityCacheUtil.getResult(
                        LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
                        LinhVucVanBanImpl.class, linhVucVanBan.getPrimaryKey(),
                        this) == null) {
                cacheResult(linhVucVanBan);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(LinhVucVanBanImpl.class.getName());
        EntityCacheUtil.clearCache(LinhVucVanBanImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public LinhVucVanBan create(long maLinhVucVanBan) {
        LinhVucVanBan linhVucVanBan = new LinhVucVanBanImpl();

        linhVucVanBan.setNew(true);
        linhVucVanBan.setPrimaryKey(maLinhVucVanBan);

        return linhVucVanBan;
    }

    public LinhVucVanBan remove(long maLinhVucVanBan)
        throws NoSuchLinhVucVanBanException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LinhVucVanBan linhVucVanBan = (LinhVucVanBan) session.get(LinhVucVanBanImpl.class,
                    new Long(maLinhVucVanBan));

            if (linhVucVanBan == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No LinhVucVanBan exists with the primary key " +
                        maLinhVucVanBan);
                }

                throw new NoSuchLinhVucVanBanException(
                    "No LinhVucVanBan exists with the primary key " +
                    maLinhVucVanBan);
            }

            return remove(linhVucVanBan);
        } catch (NoSuchLinhVucVanBanException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public LinhVucVanBan remove(LinhVucVanBan linhVucVanBan)
        throws SystemException {
        for (ModelListener<LinhVucVanBan> listener : listeners) {
            listener.onBeforeRemove(linhVucVanBan);
        }

        linhVucVanBan = removeImpl(linhVucVanBan);

        for (ModelListener<LinhVucVanBan> listener : listeners) {
            listener.onAfterRemove(linhVucVanBan);
        }

        return linhVucVanBan;
    }

    protected LinhVucVanBan removeImpl(LinhVucVanBan linhVucVanBan)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (linhVucVanBan.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(LinhVucVanBanImpl.class,
                        linhVucVanBan.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(linhVucVanBan);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucVanBanImpl.class, linhVucVanBan.getPrimaryKey());

        return linhVucVanBan;
    }

    /**
     * @deprecated Use <code>update(LinhVucVanBan linhVucVanBan, boolean merge)</code>.
     */
    public LinhVucVanBan update(LinhVucVanBan linhVucVanBan)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(LinhVucVanBan linhVucVanBan) method. Use update(LinhVucVanBan linhVucVanBan, boolean merge) instead.");
        }

        return update(linhVucVanBan, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                linhVucVanBan the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when linhVucVanBan is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public LinhVucVanBan update(LinhVucVanBan linhVucVanBan, boolean merge)
        throws SystemException {
        boolean isNew = linhVucVanBan.isNew();

        for (ModelListener<LinhVucVanBan> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(linhVucVanBan);
            } else {
                listener.onBeforeUpdate(linhVucVanBan);
            }
        }

        linhVucVanBan = updateImpl(linhVucVanBan, merge);

        for (ModelListener<LinhVucVanBan> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(linhVucVanBan);
            } else {
                listener.onAfterUpdate(linhVucVanBan);
            }
        }

        return linhVucVanBan;
    }

    public LinhVucVanBan updateImpl(
        com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan linhVucVanBan,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, linhVucVanBan, merge);

            linhVucVanBan.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucVanBanImpl.class, linhVucVanBan.getPrimaryKey(),
            linhVucVanBan);

        return linhVucVanBan;
    }

    public LinhVucVanBan findByPrimaryKey(long maLinhVucVanBan)
        throws NoSuchLinhVucVanBanException, SystemException {
        LinhVucVanBan linhVucVanBan = fetchByPrimaryKey(maLinhVucVanBan);

        if (linhVucVanBan == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No LinhVucVanBan exists with the primary key " +
                    maLinhVucVanBan);
            }

            throw new NoSuchLinhVucVanBanException(
                "No LinhVucVanBan exists with the primary key " +
                maLinhVucVanBan);
        }

        return linhVucVanBan;
    }

    public LinhVucVanBan fetchByPrimaryKey(long maLinhVucVanBan)
        throws SystemException {
        LinhVucVanBan linhVucVanBan = (LinhVucVanBan) EntityCacheUtil.getResult(LinhVucVanBanModelImpl.ENTITY_CACHE_ENABLED,
                LinhVucVanBanImpl.class, maLinhVucVanBan, this);

        if (linhVucVanBan == null) {
            Session session = null;

            try {
                session = openSession();

                linhVucVanBan = (LinhVucVanBan) session.get(LinhVucVanBanImpl.class,
                        new Long(maLinhVucVanBan));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (linhVucVanBan != null) {
                    cacheResult(linhVucVanBan);
                }

                closeSession(session);
            }
        }

        return linhVucVanBan;
    }

    public List<LinhVucVanBan> findByParentId(long parentid)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(parentid) };

        List<LinhVucVanBan> list = (List<LinhVucVanBan>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PARENTID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan WHERE ");

                query.append("parentid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ten_linh_vuc_van_ban ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(parentid);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LinhVucVanBan>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PARENTID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<LinhVucVanBan> findByParentId(long parentid, int start, int end)
        throws SystemException {
        return findByParentId(parentid, start, end, null);
    }

    public List<LinhVucVanBan> findByParentId(long parentid, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(parentid),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LinhVucVanBan> list = (List<LinhVucVanBan>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PARENTID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan WHERE ");

                query.append("parentid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_linh_vuc_van_ban ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(parentid);

                list = (List<LinhVucVanBan>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LinhVucVanBan>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PARENTID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public LinhVucVanBan findByParentId_First(long parentid,
        OrderByComparator obc)
        throws NoSuchLinhVucVanBanException, SystemException {
        List<LinhVucVanBan> list = findByParentId(parentid, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LinhVucVanBan exists with the key {");

            msg.append("parentid=" + parentid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLinhVucVanBanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LinhVucVanBan findByParentId_Last(long parentid,
        OrderByComparator obc)
        throws NoSuchLinhVucVanBanException, SystemException {
        int count = countByParentId(parentid);

        List<LinhVucVanBan> list = findByParentId(parentid, count - 1, count,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LinhVucVanBan exists with the key {");

            msg.append("parentid=" + parentid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLinhVucVanBanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LinhVucVanBan[] findByParentId_PrevAndNext(long maLinhVucVanBan,
        long parentid, OrderByComparator obc)
        throws NoSuchLinhVucVanBanException, SystemException {
        LinhVucVanBan linhVucVanBan = findByPrimaryKey(maLinhVucVanBan);

        int count = countByParentId(parentid);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan WHERE ");

            query.append("parentid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ten_linh_vuc_van_ban ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(parentid);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    linhVucVanBan);

            LinhVucVanBan[] array = new LinhVucVanBanImpl[3];

            array[0] = (LinhVucVanBan) objArray[0];
            array[1] = (LinhVucVanBan) objArray[1];
            array[2] = (LinhVucVanBan) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<LinhVucVanBan> findByActive(int active)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<LinhVucVanBan> list = (List<LinhVucVanBan>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ten_linh_vuc_van_ban ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LinhVucVanBan>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<LinhVucVanBan> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<LinhVucVanBan> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LinhVucVanBan> list = (List<LinhVucVanBan>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_linh_vuc_van_ban ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<LinhVucVanBan>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LinhVucVanBan>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public LinhVucVanBan findByActive_First(int active, OrderByComparator obc)
        throws NoSuchLinhVucVanBanException, SystemException {
        List<LinhVucVanBan> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LinhVucVanBan exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLinhVucVanBanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LinhVucVanBan findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchLinhVucVanBanException, SystemException {
        int count = countByActive(active);

        List<LinhVucVanBan> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LinhVucVanBan exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLinhVucVanBanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LinhVucVanBan[] findByActive_PrevAndNext(long maLinhVucVanBan,
        int active, OrderByComparator obc)
        throws NoSuchLinhVucVanBanException, SystemException {
        LinhVucVanBan linhVucVanBan = findByPrimaryKey(maLinhVucVanBan);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ten_linh_vuc_van_ban ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    linhVucVanBan);

            LinhVucVanBan[] array = new LinhVucVanBanImpl[3];

            array[0] = (LinhVucVanBan) objArray[0];
            array[1] = (LinhVucVanBan) objArray[1];
            array[2] = (LinhVucVanBan) objArray[2];

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

    public List<LinhVucVanBan> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<LinhVucVanBan> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<LinhVucVanBan> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LinhVucVanBan> list = (List<LinhVucVanBan>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_linh_vuc_van_ban ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<LinhVucVanBan>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LinhVucVanBan>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LinhVucVanBan>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByParentId(long parentid) throws SystemException {
        for (LinhVucVanBan linhVucVanBan : findByParentId(parentid)) {
            remove(linhVucVanBan);
        }
    }

    public void removeByActive(int active) throws SystemException {
        for (LinhVucVanBan linhVucVanBan : findByActive(active)) {
            remove(linhVucVanBan);
        }
    }

    public void removeAll() throws SystemException {
        for (LinhVucVanBan linhVucVanBan : findAll()) {
            remove(linhVucVanBan);
        }
    }

    public int countByParentId(long parentid) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(parentid) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan WHERE ");

                query.append("parentid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(parentid);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
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
                    "FROM com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan WHERE ");

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
                        "SELECT COUNT(*) FROM com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan");

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
                        "value.object.listener.com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LinhVucVanBan>> listenersList = new ArrayList<ModelListener<LinhVucVanBan>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LinhVucVanBan>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
