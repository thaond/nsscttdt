package com.nss.portlet.thu_tuc_hanh_chinh.service.persistence;

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

import com.nss.portlet.thu_tuc_hanh_chinh.NoSuchThuTucHanhChinhException;
import com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh;
import com.nss.portlet.thu_tuc_hanh_chinh.model.impl.ThuTucHanhChinhImpl;
import com.nss.portlet.thu_tuc_hanh_chinh.model.impl.ThuTucHanhChinhModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ThuTucHanhChinhPersistenceImpl extends BasePersistenceImpl
    implements ThuTucHanhChinhPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = ThuTucHanhChinhImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MALINHVUCTHUTUCHANHCHINH = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaLinhVucThuTucHanhChinh",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MALINHVUCTHUTUCHANHCHINH =
        new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaLinhVucThuTucHanhChinh",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MALINHVUCTHUTUCHANHCHINH =
        new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByMaLinhVucThuTucHanhChinh",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MADONVITHUTUCHANHCHINH = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaDonViThuTucHanhChinh",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MADONVITHUTUCHANHCHINH =
        new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaDonViThuTucHanhChinh",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MADONVITHUTUCHANHCHINH = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByMaDonViThuTucHanhChinh",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(ThuTucHanhChinhPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.ThuTucHanhChinhPersistence.impl")
    protected com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.ThuTucHanhChinhPersistence thuTucHanhChinhPersistence;
    @BeanReference(name = "com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.FileDinhKemTTHCPersistence.impl")
    protected com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.FileDinhKemTTHCPersistence fileDinhKemTTHCPersistence;

    public void cacheResult(ThuTucHanhChinh thuTucHanhChinh) {
        EntityCacheUtil.putResult(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhImpl.class, thuTucHanhChinh.getPrimaryKey(),
            thuTucHanhChinh);
    }

    public void cacheResult(List<ThuTucHanhChinh> thuTucHanhChinhs) {
        for (ThuTucHanhChinh thuTucHanhChinh : thuTucHanhChinhs) {
            if (EntityCacheUtil.getResult(
                        ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
                        ThuTucHanhChinhImpl.class,
                        thuTucHanhChinh.getPrimaryKey(), this) == null) {
                cacheResult(thuTucHanhChinh);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(ThuTucHanhChinhImpl.class.getName());
        EntityCacheUtil.clearCache(ThuTucHanhChinhImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public ThuTucHanhChinh create(long maThuTucHanhChinh) {
        ThuTucHanhChinh thuTucHanhChinh = new ThuTucHanhChinhImpl();

        thuTucHanhChinh.setNew(true);
        thuTucHanhChinh.setPrimaryKey(maThuTucHanhChinh);

        return thuTucHanhChinh;
    }

    public ThuTucHanhChinh remove(long maThuTucHanhChinh)
        throws NoSuchThuTucHanhChinhException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ThuTucHanhChinh thuTucHanhChinh = (ThuTucHanhChinh) session.get(ThuTucHanhChinhImpl.class,
                    new Long(maThuTucHanhChinh));

            if (thuTucHanhChinh == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No ThuTucHanhChinh exists with the primary key " +
                        maThuTucHanhChinh);
                }

                throw new NoSuchThuTucHanhChinhException(
                    "No ThuTucHanhChinh exists with the primary key " +
                    maThuTucHanhChinh);
            }

            return remove(thuTucHanhChinh);
        } catch (NoSuchThuTucHanhChinhException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public ThuTucHanhChinh remove(ThuTucHanhChinh thuTucHanhChinh)
        throws SystemException {
        for (ModelListener<ThuTucHanhChinh> listener : listeners) {
            listener.onBeforeRemove(thuTucHanhChinh);
        }

        thuTucHanhChinh = removeImpl(thuTucHanhChinh);

        for (ModelListener<ThuTucHanhChinh> listener : listeners) {
            listener.onAfterRemove(thuTucHanhChinh);
        }

        return thuTucHanhChinh;
    }

    protected ThuTucHanhChinh removeImpl(ThuTucHanhChinh thuTucHanhChinh)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (thuTucHanhChinh.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(ThuTucHanhChinhImpl.class,
                        thuTucHanhChinh.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(thuTucHanhChinh);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhImpl.class, thuTucHanhChinh.getPrimaryKey());

        return thuTucHanhChinh;
    }

    /**
     * @deprecated Use <code>update(ThuTucHanhChinh thuTucHanhChinh, boolean merge)</code>.
     */
    public ThuTucHanhChinh update(ThuTucHanhChinh thuTucHanhChinh)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(ThuTucHanhChinh thuTucHanhChinh) method. Use update(ThuTucHanhChinh thuTucHanhChinh, boolean merge) instead.");
        }

        return update(thuTucHanhChinh, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                thuTucHanhChinh the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when thuTucHanhChinh is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public ThuTucHanhChinh update(ThuTucHanhChinh thuTucHanhChinh, boolean merge)
        throws SystemException {
        boolean isNew = thuTucHanhChinh.isNew();

        for (ModelListener<ThuTucHanhChinh> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(thuTucHanhChinh);
            } else {
                listener.onBeforeUpdate(thuTucHanhChinh);
            }
        }

        thuTucHanhChinh = updateImpl(thuTucHanhChinh, merge);

        for (ModelListener<ThuTucHanhChinh> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(thuTucHanhChinh);
            } else {
                listener.onAfterUpdate(thuTucHanhChinh);
            }
        }

        return thuTucHanhChinh;
    }

    public ThuTucHanhChinh updateImpl(
        com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh thuTucHanhChinh,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, thuTucHanhChinh, merge);

            thuTucHanhChinh.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            ThuTucHanhChinhImpl.class, thuTucHanhChinh.getPrimaryKey(),
            thuTucHanhChinh);

        return thuTucHanhChinh;
    }

    public ThuTucHanhChinh findByPrimaryKey(long maThuTucHanhChinh)
        throws NoSuchThuTucHanhChinhException, SystemException {
        ThuTucHanhChinh thuTucHanhChinh = fetchByPrimaryKey(maThuTucHanhChinh);

        if (thuTucHanhChinh == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No ThuTucHanhChinh exists with the primary key " +
                    maThuTucHanhChinh);
            }

            throw new NoSuchThuTucHanhChinhException(
                "No ThuTucHanhChinh exists with the primary key " +
                maThuTucHanhChinh);
        }

        return thuTucHanhChinh;
    }

    public ThuTucHanhChinh fetchByPrimaryKey(long maThuTucHanhChinh)
        throws SystemException {
        ThuTucHanhChinh thuTucHanhChinh = (ThuTucHanhChinh) EntityCacheUtil.getResult(ThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
                ThuTucHanhChinhImpl.class, maThuTucHanhChinh, this);

        if (thuTucHanhChinh == null) {
            Session session = null;

            try {
                session = openSession();

                thuTucHanhChinh = (ThuTucHanhChinh) session.get(ThuTucHanhChinhImpl.class,
                        new Long(maThuTucHanhChinh));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (thuTucHanhChinh != null) {
                    cacheResult(thuTucHanhChinh);
                }

                closeSession(session);
            }
        }

        return thuTucHanhChinh;
    }

    public List<ThuTucHanhChinh> findByActive(int active)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<ThuTucHanhChinh> list = (List<ThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tenThuTucHanhChinh ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<ThuTucHanhChinh> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<ThuTucHanhChinh> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<ThuTucHanhChinh> list = (List<ThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenThuTucHanhChinh ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<ThuTucHanhChinh>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public ThuTucHanhChinh findByActive_First(int active, OrderByComparator obc)
        throws NoSuchThuTucHanhChinhException, SystemException {
        List<ThuTucHanhChinh> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ThuTucHanhChinh exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchThuTucHanhChinhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ThuTucHanhChinh findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchThuTucHanhChinhException, SystemException {
        int count = countByActive(active);

        List<ThuTucHanhChinh> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ThuTucHanhChinh exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchThuTucHanhChinhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ThuTucHanhChinh[] findByActive_PrevAndNext(long maThuTucHanhChinh,
        int active, OrderByComparator obc)
        throws NoSuchThuTucHanhChinhException, SystemException {
        ThuTucHanhChinh thuTucHanhChinh = findByPrimaryKey(maThuTucHanhChinh);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tenThuTucHanhChinh ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    thuTucHanhChinh);

            ThuTucHanhChinh[] array = new ThuTucHanhChinhImpl[3];

            array[0] = (ThuTucHanhChinh) objArray[0];
            array[1] = (ThuTucHanhChinh) objArray[1];
            array[2] = (ThuTucHanhChinh) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<ThuTucHanhChinh> findByMaLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maLinhVucThuTucHanhChinh) };

        List<ThuTucHanhChinh> list = (List<ThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MALINHVUCTHUTUCHANHCHINH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh WHERE ");

                query.append("maLinhVucThuTucHanhChinh = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tenThuTucHanhChinh ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maLinhVucThuTucHanhChinh);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MALINHVUCTHUTUCHANHCHINH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<ThuTucHanhChinh> findByMaLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh, int start, int end)
        throws SystemException {
        return findByMaLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh, start,
            end, null);
    }

    public List<ThuTucHanhChinh> findByMaLinhVucThuTucHanhChinh(
        long maLinhVucThuTucHanhChinh, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maLinhVucThuTucHanhChinh),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<ThuTucHanhChinh> list = (List<ThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MALINHVUCTHUTUCHANHCHINH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh WHERE ");

                query.append("maLinhVucThuTucHanhChinh = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenThuTucHanhChinh ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maLinhVucThuTucHanhChinh);

                list = (List<ThuTucHanhChinh>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MALINHVUCTHUTUCHANHCHINH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public ThuTucHanhChinh findByMaLinhVucThuTucHanhChinh_First(
        long maLinhVucThuTucHanhChinh, OrderByComparator obc)
        throws NoSuchThuTucHanhChinhException, SystemException {
        List<ThuTucHanhChinh> list = findByMaLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ThuTucHanhChinh exists with the key {");

            msg.append("maLinhVucThuTucHanhChinh=" + maLinhVucThuTucHanhChinh);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchThuTucHanhChinhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ThuTucHanhChinh findByMaLinhVucThuTucHanhChinh_Last(
        long maLinhVucThuTucHanhChinh, OrderByComparator obc)
        throws NoSuchThuTucHanhChinhException, SystemException {
        int count = countByMaLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);

        List<ThuTucHanhChinh> list = findByMaLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ThuTucHanhChinh exists with the key {");

            msg.append("maLinhVucThuTucHanhChinh=" + maLinhVucThuTucHanhChinh);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchThuTucHanhChinhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ThuTucHanhChinh[] findByMaLinhVucThuTucHanhChinh_PrevAndNext(
        long maThuTucHanhChinh, long maLinhVucThuTucHanhChinh,
        OrderByComparator obc)
        throws NoSuchThuTucHanhChinhException, SystemException {
        ThuTucHanhChinh thuTucHanhChinh = findByPrimaryKey(maThuTucHanhChinh);

        int count = countByMaLinhVucThuTucHanhChinh(maLinhVucThuTucHanhChinh);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh WHERE ");

            query.append("maLinhVucThuTucHanhChinh = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tenThuTucHanhChinh ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maLinhVucThuTucHanhChinh);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    thuTucHanhChinh);

            ThuTucHanhChinh[] array = new ThuTucHanhChinhImpl[3];

            array[0] = (ThuTucHanhChinh) objArray[0];
            array[1] = (ThuTucHanhChinh) objArray[1];
            array[2] = (ThuTucHanhChinh) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<ThuTucHanhChinh> findByMaDonViThuTucHanhChinh(
        long maDonViThuTucHanhChinh) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maDonViThuTucHanhChinh) };

        List<ThuTucHanhChinh> list = (List<ThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MADONVITHUTUCHANHCHINH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh WHERE ");

                query.append("maDonViThuTucHanhChinh = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tenThuTucHanhChinh ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maDonViThuTucHanhChinh);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MADONVITHUTUCHANHCHINH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<ThuTucHanhChinh> findByMaDonViThuTucHanhChinh(
        long maDonViThuTucHanhChinh, int start, int end)
        throws SystemException {
        return findByMaDonViThuTucHanhChinh(maDonViThuTucHanhChinh, start, end,
            null);
    }

    public List<ThuTucHanhChinh> findByMaDonViThuTucHanhChinh(
        long maDonViThuTucHanhChinh, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maDonViThuTucHanhChinh),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<ThuTucHanhChinh> list = (List<ThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MADONVITHUTUCHANHCHINH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh WHERE ");

                query.append("maDonViThuTucHanhChinh = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenThuTucHanhChinh ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maDonViThuTucHanhChinh);

                list = (List<ThuTucHanhChinh>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MADONVITHUTUCHANHCHINH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public ThuTucHanhChinh findByMaDonViThuTucHanhChinh_First(
        long maDonViThuTucHanhChinh, OrderByComparator obc)
        throws NoSuchThuTucHanhChinhException, SystemException {
        List<ThuTucHanhChinh> list = findByMaDonViThuTucHanhChinh(maDonViThuTucHanhChinh,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ThuTucHanhChinh exists with the key {");

            msg.append("maDonViThuTucHanhChinh=" + maDonViThuTucHanhChinh);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchThuTucHanhChinhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ThuTucHanhChinh findByMaDonViThuTucHanhChinh_Last(
        long maDonViThuTucHanhChinh, OrderByComparator obc)
        throws NoSuchThuTucHanhChinhException, SystemException {
        int count = countByMaDonViThuTucHanhChinh(maDonViThuTucHanhChinh);

        List<ThuTucHanhChinh> list = findByMaDonViThuTucHanhChinh(maDonViThuTucHanhChinh,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ThuTucHanhChinh exists with the key {");

            msg.append("maDonViThuTucHanhChinh=" + maDonViThuTucHanhChinh);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchThuTucHanhChinhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ThuTucHanhChinh[] findByMaDonViThuTucHanhChinh_PrevAndNext(
        long maThuTucHanhChinh, long maDonViThuTucHanhChinh,
        OrderByComparator obc)
        throws NoSuchThuTucHanhChinhException, SystemException {
        ThuTucHanhChinh thuTucHanhChinh = findByPrimaryKey(maThuTucHanhChinh);

        int count = countByMaDonViThuTucHanhChinh(maDonViThuTucHanhChinh);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh WHERE ");

            query.append("maDonViThuTucHanhChinh = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tenThuTucHanhChinh ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maDonViThuTucHanhChinh);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    thuTucHanhChinh);

            ThuTucHanhChinh[] array = new ThuTucHanhChinhImpl[3];

            array[0] = (ThuTucHanhChinh) objArray[0];
            array[1] = (ThuTucHanhChinh) objArray[1];
            array[2] = (ThuTucHanhChinh) objArray[2];

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

    public List<ThuTucHanhChinh> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<ThuTucHanhChinh> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<ThuTucHanhChinh> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<ThuTucHanhChinh> list = (List<ThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenThuTucHanhChinh ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<ThuTucHanhChinh>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ThuTucHanhChinh>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (ThuTucHanhChinh thuTucHanhChinh : findByActive(active)) {
            remove(thuTucHanhChinh);
        }
    }

    public void removeByMaLinhVucThuTucHanhChinh(long maLinhVucThuTucHanhChinh)
        throws SystemException {
        for (ThuTucHanhChinh thuTucHanhChinh : findByMaLinhVucThuTucHanhChinh(
                maLinhVucThuTucHanhChinh)) {
            remove(thuTucHanhChinh);
        }
    }

    public void removeByMaDonViThuTucHanhChinh(long maDonViThuTucHanhChinh)
        throws SystemException {
        for (ThuTucHanhChinh thuTucHanhChinh : findByMaDonViThuTucHanhChinh(
                maDonViThuTucHanhChinh)) {
            remove(thuTucHanhChinh);
        }
    }

    public void removeAll() throws SystemException {
        for (ThuTucHanhChinh thuTucHanhChinh : findAll()) {
            remove(thuTucHanhChinh);
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
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh WHERE ");

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

    public int countByMaLinhVucThuTucHanhChinh(long maLinhVucThuTucHanhChinh)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maLinhVucThuTucHanhChinh) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MALINHVUCTHUTUCHANHCHINH,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh WHERE ");

                query.append("maLinhVucThuTucHanhChinh = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maLinhVucThuTucHanhChinh);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MALINHVUCTHUTUCHANHCHINH,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMaDonViThuTucHanhChinh(long maDonViThuTucHanhChinh)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maDonViThuTucHanhChinh) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MADONVITHUTUCHANHCHINH,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh WHERE ");

                query.append("maDonViThuTucHanhChinh = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maDonViThuTucHanhChinh);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MADONVITHUTUCHANHCHINH,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh");

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
                        "value.object.listener.com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ThuTucHanhChinh>> listenersList = new ArrayList<ModelListener<ThuTucHanhChinh>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ThuTucHanhChinh>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
