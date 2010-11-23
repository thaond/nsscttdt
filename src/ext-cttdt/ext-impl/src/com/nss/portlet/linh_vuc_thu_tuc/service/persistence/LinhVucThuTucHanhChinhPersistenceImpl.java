package com.nss.portlet.linh_vuc_thu_tuc.service.persistence;

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

import com.nss.portlet.linh_vuc_thu_tuc.NoSuchLinhVucThuTucHanhChinhException;
import com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh;
import com.nss.portlet.linh_vuc_thu_tuc.model.impl.LinhVucThuTucHanhChinhImpl;
import com.nss.portlet.linh_vuc_thu_tuc.model.impl.LinhVucThuTucHanhChinhModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LinhVucThuTucHanhChinhPersistenceImpl extends BasePersistenceImpl
    implements LinhVucThuTucHanhChinhPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = LinhVucThuTucHanhChinhImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MALOAITHUTUCHANHCHINH = new FinderPath(LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaLoaiThuTucHanhChinh",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MALOAITHUTUCHANHCHINH =
        new FinderPath(LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaLoaiThuTucHanhChinh",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MALOAITHUTUCHANHCHINH = new FinderPath(LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByMaLoaiThuTucHanhChinh",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(LinhVucThuTucHanhChinhPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.linh_vuc_thu_tuc.service.persistence.LinhVucThuTucHanhChinhPersistence.impl")
    protected com.nss.portlet.linh_vuc_thu_tuc.service.persistence.LinhVucThuTucHanhChinhPersistence linhVucThuTucHanhChinhPersistence;

    public void cacheResult(LinhVucThuTucHanhChinh linhVucThuTucHanhChinh) {
        EntityCacheUtil.putResult(LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucThuTucHanhChinhImpl.class,
            linhVucThuTucHanhChinh.getPrimaryKey(), linhVucThuTucHanhChinh);
    }

    public void cacheResult(
        List<LinhVucThuTucHanhChinh> linhVucThuTucHanhChinhs) {
        for (LinhVucThuTucHanhChinh linhVucThuTucHanhChinh : linhVucThuTucHanhChinhs) {
            if (EntityCacheUtil.getResult(
                        LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
                        LinhVucThuTucHanhChinhImpl.class,
                        linhVucThuTucHanhChinh.getPrimaryKey(), this) == null) {
                cacheResult(linhVucThuTucHanhChinh);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(LinhVucThuTucHanhChinhImpl.class.getName());
        EntityCacheUtil.clearCache(LinhVucThuTucHanhChinhImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public LinhVucThuTucHanhChinh create(long maLinhVucThuTucHanhChinh) {
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh = new LinhVucThuTucHanhChinhImpl();

        linhVucThuTucHanhChinh.setNew(true);
        linhVucThuTucHanhChinh.setPrimaryKey(maLinhVucThuTucHanhChinh);

        return linhVucThuTucHanhChinh;
    }

    public LinhVucThuTucHanhChinh remove(long maLinhVucThuTucHanhChinh)
        throws NoSuchLinhVucThuTucHanhChinhException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LinhVucThuTucHanhChinh linhVucThuTucHanhChinh = (LinhVucThuTucHanhChinh) session.get(LinhVucThuTucHanhChinhImpl.class,
                    new Long(maLinhVucThuTucHanhChinh));

            if (linhVucThuTucHanhChinh == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No LinhVucThuTucHanhChinh exists with the primary key " +
                        maLinhVucThuTucHanhChinh);
                }

                throw new NoSuchLinhVucThuTucHanhChinhException(
                    "No LinhVucThuTucHanhChinh exists with the primary key " +
                    maLinhVucThuTucHanhChinh);
            }

            return remove(linhVucThuTucHanhChinh);
        } catch (NoSuchLinhVucThuTucHanhChinhException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public LinhVucThuTucHanhChinh remove(
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws SystemException {
        for (ModelListener<LinhVucThuTucHanhChinh> listener : listeners) {
            listener.onBeforeRemove(linhVucThuTucHanhChinh);
        }

        linhVucThuTucHanhChinh = removeImpl(linhVucThuTucHanhChinh);

        for (ModelListener<LinhVucThuTucHanhChinh> listener : listeners) {
            listener.onAfterRemove(linhVucThuTucHanhChinh);
        }

        return linhVucThuTucHanhChinh;
    }

    protected LinhVucThuTucHanhChinh removeImpl(
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (linhVucThuTucHanhChinh.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(LinhVucThuTucHanhChinhImpl.class,
                        linhVucThuTucHanhChinh.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(linhVucThuTucHanhChinh);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucThuTucHanhChinhImpl.class,
            linhVucThuTucHanhChinh.getPrimaryKey());

        return linhVucThuTucHanhChinh;
    }

    /**
     * @deprecated Use <code>update(LinhVucThuTucHanhChinh linhVucThuTucHanhChinh, boolean merge)</code>.
     */
    public LinhVucThuTucHanhChinh update(
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(LinhVucThuTucHanhChinh linhVucThuTucHanhChinh) method. Use update(LinhVucThuTucHanhChinh linhVucThuTucHanhChinh, boolean merge) instead.");
        }

        return update(linhVucThuTucHanhChinh, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                linhVucThuTucHanhChinh the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when linhVucThuTucHanhChinh is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public LinhVucThuTucHanhChinh update(
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh, boolean merge)
        throws SystemException {
        boolean isNew = linhVucThuTucHanhChinh.isNew();

        for (ModelListener<LinhVucThuTucHanhChinh> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(linhVucThuTucHanhChinh);
            } else {
                listener.onBeforeUpdate(linhVucThuTucHanhChinh);
            }
        }

        linhVucThuTucHanhChinh = updateImpl(linhVucThuTucHanhChinh, merge);

        for (ModelListener<LinhVucThuTucHanhChinh> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(linhVucThuTucHanhChinh);
            } else {
                listener.onAfterUpdate(linhVucThuTucHanhChinh);
            }
        }

        return linhVucThuTucHanhChinh;
    }

    public LinhVucThuTucHanhChinh updateImpl(
        com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh linhVucThuTucHanhChinh,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, linhVucThuTucHanhChinh, merge);

            linhVucThuTucHanhChinh.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LinhVucThuTucHanhChinhImpl.class,
            linhVucThuTucHanhChinh.getPrimaryKey(), linhVucThuTucHanhChinh);

        return linhVucThuTucHanhChinh;
    }

    public LinhVucThuTucHanhChinh findByPrimaryKey(
        long maLinhVucThuTucHanhChinh)
        throws NoSuchLinhVucThuTucHanhChinhException, SystemException {
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh = fetchByPrimaryKey(maLinhVucThuTucHanhChinh);

        if (linhVucThuTucHanhChinh == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No LinhVucThuTucHanhChinh exists with the primary key " +
                    maLinhVucThuTucHanhChinh);
            }

            throw new NoSuchLinhVucThuTucHanhChinhException(
                "No LinhVucThuTucHanhChinh exists with the primary key " +
                maLinhVucThuTucHanhChinh);
        }

        return linhVucThuTucHanhChinh;
    }

    public LinhVucThuTucHanhChinh fetchByPrimaryKey(
        long maLinhVucThuTucHanhChinh) throws SystemException {
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh = (LinhVucThuTucHanhChinh) EntityCacheUtil.getResult(LinhVucThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
                LinhVucThuTucHanhChinhImpl.class, maLinhVucThuTucHanhChinh, this);

        if (linhVucThuTucHanhChinh == null) {
            Session session = null;

            try {
                session = openSession();

                linhVucThuTucHanhChinh = (LinhVucThuTucHanhChinh) session.get(LinhVucThuTucHanhChinhImpl.class,
                        new Long(maLinhVucThuTucHanhChinh));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (linhVucThuTucHanhChinh != null) {
                    cacheResult(linhVucThuTucHanhChinh);
                }

                closeSession(session);
            }
        }

        return linhVucThuTucHanhChinh;
    }

    public List<LinhVucThuTucHanhChinh> findByActive(int active)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<LinhVucThuTucHanhChinh> list = (List<LinhVucThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tenLinhVucThuTucHanhChinh ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LinhVucThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<LinhVucThuTucHanhChinh> findByActive(int active, int start,
        int end) throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<LinhVucThuTucHanhChinh> findByActive(int active, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LinhVucThuTucHanhChinh> list = (List<LinhVucThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenLinhVucThuTucHanhChinh ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<LinhVucThuTucHanhChinh>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LinhVucThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public LinhVucThuTucHanhChinh findByActive_First(int active,
        OrderByComparator obc)
        throws NoSuchLinhVucThuTucHanhChinhException, SystemException {
        List<LinhVucThuTucHanhChinh> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LinhVucThuTucHanhChinh exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLinhVucThuTucHanhChinhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LinhVucThuTucHanhChinh findByActive_Last(int active,
        OrderByComparator obc)
        throws NoSuchLinhVucThuTucHanhChinhException, SystemException {
        int count = countByActive(active);

        List<LinhVucThuTucHanhChinh> list = findByActive(active, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LinhVucThuTucHanhChinh exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLinhVucThuTucHanhChinhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LinhVucThuTucHanhChinh[] findByActive_PrevAndNext(
        long maLinhVucThuTucHanhChinh, int active, OrderByComparator obc)
        throws NoSuchLinhVucThuTucHanhChinhException, SystemException {
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh = findByPrimaryKey(maLinhVucThuTucHanhChinh);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tenLinhVucThuTucHanhChinh ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    linhVucThuTucHanhChinh);

            LinhVucThuTucHanhChinh[] array = new LinhVucThuTucHanhChinhImpl[3];

            array[0] = (LinhVucThuTucHanhChinh) objArray[0];
            array[1] = (LinhVucThuTucHanhChinh) objArray[1];
            array[2] = (LinhVucThuTucHanhChinh) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<LinhVucThuTucHanhChinh> findByMaLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maLoaiThuTucHanhChinh) };

        List<LinhVucThuTucHanhChinh> list = (List<LinhVucThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MALOAITHUTUCHANHCHINH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh WHERE ");

                query.append("maLoaiThuTucHanhChinh = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tenLinhVucThuTucHanhChinh ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maLoaiThuTucHanhChinh);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LinhVucThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MALOAITHUTUCHANHCHINH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<LinhVucThuTucHanhChinh> findByMaLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh, int start, int end)
        throws SystemException {
        return findByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh, start, end,
            null);
    }

    public List<LinhVucThuTucHanhChinh> findByMaLoaiThuTucHanhChinh(
        long maLoaiThuTucHanhChinh, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maLoaiThuTucHanhChinh),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LinhVucThuTucHanhChinh> list = (List<LinhVucThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MALOAITHUTUCHANHCHINH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh WHERE ");

                query.append("maLoaiThuTucHanhChinh = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenLinhVucThuTucHanhChinh ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maLoaiThuTucHanhChinh);

                list = (List<LinhVucThuTucHanhChinh>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LinhVucThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MALOAITHUTUCHANHCHINH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public LinhVucThuTucHanhChinh findByMaLoaiThuTucHanhChinh_First(
        long maLoaiThuTucHanhChinh, OrderByComparator obc)
        throws NoSuchLinhVucThuTucHanhChinhException, SystemException {
        List<LinhVucThuTucHanhChinh> list = findByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LinhVucThuTucHanhChinh exists with the key {");

            msg.append("maLoaiThuTucHanhChinh=" + maLoaiThuTucHanhChinh);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLinhVucThuTucHanhChinhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LinhVucThuTucHanhChinh findByMaLoaiThuTucHanhChinh_Last(
        long maLoaiThuTucHanhChinh, OrderByComparator obc)
        throws NoSuchLinhVucThuTucHanhChinhException, SystemException {
        int count = countByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);

        List<LinhVucThuTucHanhChinh> list = findByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LinhVucThuTucHanhChinh exists with the key {");

            msg.append("maLoaiThuTucHanhChinh=" + maLoaiThuTucHanhChinh);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLinhVucThuTucHanhChinhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LinhVucThuTucHanhChinh[] findByMaLoaiThuTucHanhChinh_PrevAndNext(
        long maLinhVucThuTucHanhChinh, long maLoaiThuTucHanhChinh,
        OrderByComparator obc)
        throws NoSuchLinhVucThuTucHanhChinhException, SystemException {
        LinhVucThuTucHanhChinh linhVucThuTucHanhChinh = findByPrimaryKey(maLinhVucThuTucHanhChinh);

        int count = countByMaLoaiThuTucHanhChinh(maLoaiThuTucHanhChinh);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh WHERE ");

            query.append("maLoaiThuTucHanhChinh = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tenLinhVucThuTucHanhChinh ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maLoaiThuTucHanhChinh);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    linhVucThuTucHanhChinh);

            LinhVucThuTucHanhChinh[] array = new LinhVucThuTucHanhChinhImpl[3];

            array[0] = (LinhVucThuTucHanhChinh) objArray[0];
            array[1] = (LinhVucThuTucHanhChinh) objArray[1];
            array[2] = (LinhVucThuTucHanhChinh) objArray[2];

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

    public List<LinhVucThuTucHanhChinh> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<LinhVucThuTucHanhChinh> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<LinhVucThuTucHanhChinh> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LinhVucThuTucHanhChinh> list = (List<LinhVucThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenLinhVucThuTucHanhChinh ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<LinhVucThuTucHanhChinh>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LinhVucThuTucHanhChinh>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LinhVucThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (LinhVucThuTucHanhChinh linhVucThuTucHanhChinh : findByActive(
                active)) {
            remove(linhVucThuTucHanhChinh);
        }
    }

    public void removeByMaLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh)
        throws SystemException {
        for (LinhVucThuTucHanhChinh linhVucThuTucHanhChinh : findByMaLoaiThuTucHanhChinh(
                maLoaiThuTucHanhChinh)) {
            remove(linhVucThuTucHanhChinh);
        }
    }

    public void removeAll() throws SystemException {
        for (LinhVucThuTucHanhChinh linhVucThuTucHanhChinh : findAll()) {
            remove(linhVucThuTucHanhChinh);
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
                    "FROM com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh WHERE ");

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

    public int countByMaLoaiThuTucHanhChinh(long maLoaiThuTucHanhChinh)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maLoaiThuTucHanhChinh) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MALOAITHUTUCHANHCHINH,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh WHERE ");

                query.append("maLoaiThuTucHanhChinh = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maLoaiThuTucHanhChinh);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MALOAITHUTUCHANHCHINH,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh");

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
                        "value.object.listener.com.nss.portlet.linh_vuc_thu_tuc.model.LinhVucThuTucHanhChinh")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LinhVucThuTucHanhChinh>> listenersList = new ArrayList<ModelListener<LinhVucThuTucHanhChinh>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LinhVucThuTucHanhChinh>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
