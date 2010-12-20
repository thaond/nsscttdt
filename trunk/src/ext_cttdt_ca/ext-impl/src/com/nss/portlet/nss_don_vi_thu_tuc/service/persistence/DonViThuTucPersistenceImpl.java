package com.nss.portlet.nss_don_vi_thu_tuc.service.persistence;

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

import com.nss.portlet.nss_don_vi_thu_tuc.NoSuchDonViThuTucException;
import com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc;
import com.nss.portlet.nss_don_vi_thu_tuc.model.impl.DonViThuTucImpl;
import com.nss.portlet.nss_don_vi_thu_tuc.model.impl.DonViThuTucModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DonViThuTucPersistenceImpl extends BasePersistenceImpl
    implements DonViThuTucPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = DonViThuTucImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByActive", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_CAPDONVI = new FinderPath(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCapDonVi", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_CAPDONVI = new FinderPath(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCapDonVi",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_CAPDONVI = new FinderPath(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByCapDonVi", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_CAPDONVI_ACTIVE = new FinderPath(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCapDonVi_Active",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_CAPDONVI_ACTIVE = new FinderPath(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCapDonVi_Active",
            new String[] {
                Integer.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_CAPDONVI_ACTIVE = new FinderPath(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByCapDonVi_Active",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(DonViThuTucPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.nss_don_vi_thu_tuc.service.persistence.DonViThuTucPersistence.impl")
    protected com.nss.portlet.nss_don_vi_thu_tuc.service.persistence.DonViThuTucPersistence donViThuTucPersistence;

    public void cacheResult(DonViThuTuc donViThuTuc) {
        EntityCacheUtil.putResult(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucImpl.class, donViThuTuc.getPrimaryKey(), donViThuTuc);
    }

    public void cacheResult(List<DonViThuTuc> donViThuTucs) {
        for (DonViThuTuc donViThuTuc : donViThuTucs) {
            if (EntityCacheUtil.getResult(
                        DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
                        DonViThuTucImpl.class, donViThuTuc.getPrimaryKey(), this) == null) {
                cacheResult(donViThuTuc);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(DonViThuTucImpl.class.getName());
        EntityCacheUtil.clearCache(DonViThuTucImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public DonViThuTuc create(long maDonViThuTuc) {
        DonViThuTuc donViThuTuc = new DonViThuTucImpl();

        donViThuTuc.setNew(true);
        donViThuTuc.setPrimaryKey(maDonViThuTuc);

        return donViThuTuc;
    }

    public DonViThuTuc remove(long maDonViThuTuc)
        throws NoSuchDonViThuTucException, SystemException {
        Session session = null;

        try {
            session = openSession();

            DonViThuTuc donViThuTuc = (DonViThuTuc) session.get(DonViThuTucImpl.class,
                    new Long(maDonViThuTuc));

            if (donViThuTuc == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No DonViThuTuc exists with the primary key " +
                        maDonViThuTuc);
                }

                throw new NoSuchDonViThuTucException(
                    "No DonViThuTuc exists with the primary key " +
                    maDonViThuTuc);
            }

            return remove(donViThuTuc);
        } catch (NoSuchDonViThuTucException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public DonViThuTuc remove(DonViThuTuc donViThuTuc)
        throws SystemException {
        for (ModelListener<DonViThuTuc> listener : listeners) {
            listener.onBeforeRemove(donViThuTuc);
        }

        donViThuTuc = removeImpl(donViThuTuc);

        for (ModelListener<DonViThuTuc> listener : listeners) {
            listener.onAfterRemove(donViThuTuc);
        }

        return donViThuTuc;
    }

    protected DonViThuTuc removeImpl(DonViThuTuc donViThuTuc)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (donViThuTuc.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(DonViThuTucImpl.class,
                        donViThuTuc.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(donViThuTuc);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucImpl.class, donViThuTuc.getPrimaryKey());

        return donViThuTuc;
    }

    /**
     * @deprecated Use <code>update(DonViThuTuc donViThuTuc, boolean merge)</code>.
     */
    public DonViThuTuc update(DonViThuTuc donViThuTuc)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(DonViThuTuc donViThuTuc) method. Use update(DonViThuTuc donViThuTuc, boolean merge) instead.");
        }

        return update(donViThuTuc, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                donViThuTuc the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when donViThuTuc is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public DonViThuTuc update(DonViThuTuc donViThuTuc, boolean merge)
        throws SystemException {
        boolean isNew = donViThuTuc.isNew();

        for (ModelListener<DonViThuTuc> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(donViThuTuc);
            } else {
                listener.onBeforeUpdate(donViThuTuc);
            }
        }

        donViThuTuc = updateImpl(donViThuTuc, merge);

        for (ModelListener<DonViThuTuc> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(donViThuTuc);
            } else {
                listener.onAfterUpdate(donViThuTuc);
            }
        }

        return donViThuTuc;
    }

    public DonViThuTuc updateImpl(
        com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc donViThuTuc,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, donViThuTuc, merge);

            donViThuTuc.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
            DonViThuTucImpl.class, donViThuTuc.getPrimaryKey(), donViThuTuc);

        return donViThuTuc;
    }

    public DonViThuTuc findByPrimaryKey(long maDonViThuTuc)
        throws NoSuchDonViThuTucException, SystemException {
        DonViThuTuc donViThuTuc = fetchByPrimaryKey(maDonViThuTuc);

        if (donViThuTuc == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No DonViThuTuc exists with the primary key " +
                    maDonViThuTuc);
            }

            throw new NoSuchDonViThuTucException(
                "No DonViThuTuc exists with the primary key " + maDonViThuTuc);
        }

        return donViThuTuc;
    }

    public DonViThuTuc fetchByPrimaryKey(long maDonViThuTuc)
        throws SystemException {
        DonViThuTuc donViThuTuc = (DonViThuTuc) EntityCacheUtil.getResult(DonViThuTucModelImpl.ENTITY_CACHE_ENABLED,
                DonViThuTucImpl.class, maDonViThuTuc, this);

        if (donViThuTuc == null) {
            Session session = null;

            try {
                session = openSession();

                donViThuTuc = (DonViThuTuc) session.get(DonViThuTucImpl.class,
                        new Long(maDonViThuTuc));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (donViThuTuc != null) {
                    cacheResult(donViThuTuc);
                }

                closeSession(session);
            }
        }

        return donViThuTuc;
    }

    public List<DonViThuTuc> findByActive(int active) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<DonViThuTuc> list = (List<DonViThuTuc>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ten_don_vi_thu_tuc ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<DonViThuTuc>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<DonViThuTuc> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<DonViThuTuc> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<DonViThuTuc> list = (List<DonViThuTuc>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_don_vi_thu_tuc ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<DonViThuTuc>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<DonViThuTuc>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public DonViThuTuc findByActive_First(int active, OrderByComparator obc)
        throws NoSuchDonViThuTucException, SystemException {
        List<DonViThuTuc> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No DonViThuTuc exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDonViThuTucException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public DonViThuTuc findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchDonViThuTucException, SystemException {
        int count = countByActive(active);

        List<DonViThuTuc> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No DonViThuTuc exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDonViThuTucException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public DonViThuTuc[] findByActive_PrevAndNext(long maDonViThuTuc,
        int active, OrderByComparator obc)
        throws NoSuchDonViThuTucException, SystemException {
        DonViThuTuc donViThuTuc = findByPrimaryKey(maDonViThuTuc);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ten_don_vi_thu_tuc ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    donViThuTuc);

            DonViThuTuc[] array = new DonViThuTucImpl[3];

            array[0] = (DonViThuTuc) objArray[0];
            array[1] = (DonViThuTuc) objArray[1];
            array[2] = (DonViThuTuc) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<DonViThuTuc> findByCapDonVi(int capDonVi)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(capDonVi) };

        List<DonViThuTuc> list = (List<DonViThuTuc>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CAPDONVI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc WHERE ");

                query.append("capDonVi = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ten_don_vi_thu_tuc ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(capDonVi);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<DonViThuTuc>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CAPDONVI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<DonViThuTuc> findByCapDonVi(int capDonVi, int start, int end)
        throws SystemException {
        return findByCapDonVi(capDonVi, start, end, null);
    }

    public List<DonViThuTuc> findByCapDonVi(int capDonVi, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(capDonVi),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<DonViThuTuc> list = (List<DonViThuTuc>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CAPDONVI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc WHERE ");

                query.append("capDonVi = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_don_vi_thu_tuc ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(capDonVi);

                list = (List<DonViThuTuc>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<DonViThuTuc>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CAPDONVI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public DonViThuTuc findByCapDonVi_First(int capDonVi, OrderByComparator obc)
        throws NoSuchDonViThuTucException, SystemException {
        List<DonViThuTuc> list = findByCapDonVi(capDonVi, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No DonViThuTuc exists with the key {");

            msg.append("capDonVi=" + capDonVi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDonViThuTucException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public DonViThuTuc findByCapDonVi_Last(int capDonVi, OrderByComparator obc)
        throws NoSuchDonViThuTucException, SystemException {
        int count = countByCapDonVi(capDonVi);

        List<DonViThuTuc> list = findByCapDonVi(capDonVi, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No DonViThuTuc exists with the key {");

            msg.append("capDonVi=" + capDonVi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDonViThuTucException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public DonViThuTuc[] findByCapDonVi_PrevAndNext(long maDonViThuTuc,
        int capDonVi, OrderByComparator obc)
        throws NoSuchDonViThuTucException, SystemException {
        DonViThuTuc donViThuTuc = findByPrimaryKey(maDonViThuTuc);

        int count = countByCapDonVi(capDonVi);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc WHERE ");

            query.append("capDonVi = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ten_don_vi_thu_tuc ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(capDonVi);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    donViThuTuc);

            DonViThuTuc[] array = new DonViThuTucImpl[3];

            array[0] = (DonViThuTuc) objArray[0];
            array[1] = (DonViThuTuc) objArray[1];
            array[2] = (DonViThuTuc) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<DonViThuTuc> findByCapDonVi_Active(int capDonVi, int active)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(capDonVi), new Integer(active)
            };

        List<DonViThuTuc> list = (List<DonViThuTuc>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CAPDONVI_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc WHERE ");

                query.append("capDonVi = ?");

                query.append(" AND ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ten_don_vi_thu_tuc ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(capDonVi);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<DonViThuTuc>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CAPDONVI_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<DonViThuTuc> findByCapDonVi_Active(int capDonVi, int active,
        int start, int end) throws SystemException {
        return findByCapDonVi_Active(capDonVi, active, start, end, null);
    }

    public List<DonViThuTuc> findByCapDonVi_Active(int capDonVi, int active,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(capDonVi), new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<DonViThuTuc> list = (List<DonViThuTuc>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CAPDONVI_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc WHERE ");

                query.append("capDonVi = ?");

                query.append(" AND ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_don_vi_thu_tuc ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(capDonVi);

                qPos.add(active);

                list = (List<DonViThuTuc>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<DonViThuTuc>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CAPDONVI_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public DonViThuTuc findByCapDonVi_Active_First(int capDonVi, int active,
        OrderByComparator obc)
        throws NoSuchDonViThuTucException, SystemException {
        List<DonViThuTuc> list = findByCapDonVi_Active(capDonVi, active, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No DonViThuTuc exists with the key {");

            msg.append("capDonVi=" + capDonVi);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDonViThuTucException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public DonViThuTuc findByCapDonVi_Active_Last(int capDonVi, int active,
        OrderByComparator obc)
        throws NoSuchDonViThuTucException, SystemException {
        int count = countByCapDonVi_Active(capDonVi, active);

        List<DonViThuTuc> list = findByCapDonVi_Active(capDonVi, active,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No DonViThuTuc exists with the key {");

            msg.append("capDonVi=" + capDonVi);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDonViThuTucException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public DonViThuTuc[] findByCapDonVi_Active_PrevAndNext(long maDonViThuTuc,
        int capDonVi, int active, OrderByComparator obc)
        throws NoSuchDonViThuTucException, SystemException {
        DonViThuTuc donViThuTuc = findByPrimaryKey(maDonViThuTuc);

        int count = countByCapDonVi_Active(capDonVi, active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc WHERE ");

            query.append("capDonVi = ?");

            query.append(" AND ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ten_don_vi_thu_tuc ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(capDonVi);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    donViThuTuc);

            DonViThuTuc[] array = new DonViThuTucImpl[3];

            array[0] = (DonViThuTuc) objArray[0];
            array[1] = (DonViThuTuc) objArray[1];
            array[2] = (DonViThuTuc) objArray[2];

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

    public List<DonViThuTuc> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<DonViThuTuc> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<DonViThuTuc> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<DonViThuTuc> list = (List<DonViThuTuc>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_don_vi_thu_tuc ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<DonViThuTuc>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<DonViThuTuc>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<DonViThuTuc>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (DonViThuTuc donViThuTuc : findByActive(active)) {
            remove(donViThuTuc);
        }
    }

    public void removeByCapDonVi(int capDonVi) throws SystemException {
        for (DonViThuTuc donViThuTuc : findByCapDonVi(capDonVi)) {
            remove(donViThuTuc);
        }
    }

    public void removeByCapDonVi_Active(int capDonVi, int active)
        throws SystemException {
        for (DonViThuTuc donViThuTuc : findByCapDonVi_Active(capDonVi, active)) {
            remove(donViThuTuc);
        }
    }

    public void removeAll() throws SystemException {
        for (DonViThuTuc donViThuTuc : findAll()) {
            remove(donViThuTuc);
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
                    "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc WHERE ");

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

    public int countByCapDonVi(int capDonVi) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(capDonVi) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAPDONVI,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc WHERE ");

                query.append("capDonVi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(capDonVi);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAPDONVI,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByCapDonVi_Active(int capDonVi, int active)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(capDonVi), new Integer(active)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CAPDONVI_ACTIVE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc WHERE ");

                query.append("capDonVi = ?");

                query.append(" AND ");

                query.append("active = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(capDonVi);

                qPos.add(active);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CAPDONVI_ACTIVE,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc");

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
                        "value.object.listener.com.nss.portlet.nss_don_vi_thu_tuc.model.DonViThuTuc")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<DonViThuTuc>> listenersList = new ArrayList<ModelListener<DonViThuTuc>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<DonViThuTuc>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
