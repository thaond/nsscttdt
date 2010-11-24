package com.nss.portlet.van_ban_phap_quy.service.persistence;

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

import com.nss.portlet.van_ban_phap_quy.NoSuchVanBanPhapQuyException;
import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;
import com.nss.portlet.van_ban_phap_quy.model.impl.VanBanPhapQuyImpl;
import com.nss.portlet.van_ban_phap_quy.model.impl.VanBanPhapQuyModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class VanBanPhapQuyPersistenceImpl extends BasePersistenceImpl
    implements VanBanPhapQuyPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = VanBanPhapQuyImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MALOAIVANBAN = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaLoaiVanBan",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MALOAIVANBAN = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaLoaiVanBan",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MALOAIVANBAN = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByMaLoaiVanBan",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MALINHVUCVANBAN = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaLinhVucVanBan",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MALINHVUCVANBAN = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaLinhVucVanBan",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MALINHVUCVANBAN = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByMaLinhVucVanBan",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MACOQUANBANHANH = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaCoQuanBanHanh",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MACOQUANBANHANH = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaCoQuanBanHanh",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MACOQUANBANHANH = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByMaCoQuanBanHanh",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByCompanyid",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_COMPANYID = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByCompanyid",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByCompanyid",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(VanBanPhapQuyPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.van_ban_phap_quy.service.persistence.VanBanPhapQuyPersistence.impl")
    protected com.nss.portlet.van_ban_phap_quy.service.persistence.VanBanPhapQuyPersistence vanBanPhapQuyPersistence;
    @BeanReference(name = "com.nss.portlet.van_ban_phap_quy.service.persistence.FileDinhKemPersistence.impl")
    protected com.nss.portlet.van_ban_phap_quy.service.persistence.FileDinhKemPersistence fileDinhKemPersistence;

    public void cacheResult(VanBanPhapQuy vanBanPhapQuy) {
        EntityCacheUtil.putResult(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyImpl.class, vanBanPhapQuy.getPrimaryKey(),
            vanBanPhapQuy);
    }

    public void cacheResult(List<VanBanPhapQuy> vanBanPhapQuies) {
        for (VanBanPhapQuy vanBanPhapQuy : vanBanPhapQuies) {
            if (EntityCacheUtil.getResult(
                        VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
                        VanBanPhapQuyImpl.class, vanBanPhapQuy.getPrimaryKey(),
                        this) == null) {
                cacheResult(vanBanPhapQuy);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(VanBanPhapQuyImpl.class.getName());
        EntityCacheUtil.clearCache(VanBanPhapQuyImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public VanBanPhapQuy create(long maVanBanPhapQuy) {
        VanBanPhapQuy vanBanPhapQuy = new VanBanPhapQuyImpl();

        vanBanPhapQuy.setNew(true);
        vanBanPhapQuy.setPrimaryKey(maVanBanPhapQuy);

        return vanBanPhapQuy;
    }

    public VanBanPhapQuy remove(long maVanBanPhapQuy)
        throws NoSuchVanBanPhapQuyException, SystemException {
        Session session = null;

        try {
            session = openSession();

            VanBanPhapQuy vanBanPhapQuy = (VanBanPhapQuy) session.get(VanBanPhapQuyImpl.class,
                    new Long(maVanBanPhapQuy));

            if (vanBanPhapQuy == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No VanBanPhapQuy exists with the primary key " +
                        maVanBanPhapQuy);
                }

                throw new NoSuchVanBanPhapQuyException(
                    "No VanBanPhapQuy exists with the primary key " +
                    maVanBanPhapQuy);
            }

            return remove(vanBanPhapQuy);
        } catch (NoSuchVanBanPhapQuyException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public VanBanPhapQuy remove(VanBanPhapQuy vanBanPhapQuy)
        throws SystemException {
        for (ModelListener<VanBanPhapQuy> listener : listeners) {
            listener.onBeforeRemove(vanBanPhapQuy);
        }

        vanBanPhapQuy = removeImpl(vanBanPhapQuy);

        for (ModelListener<VanBanPhapQuy> listener : listeners) {
            listener.onAfterRemove(vanBanPhapQuy);
        }

        return vanBanPhapQuy;
    }

    protected VanBanPhapQuy removeImpl(VanBanPhapQuy vanBanPhapQuy)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (vanBanPhapQuy.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(VanBanPhapQuyImpl.class,
                        vanBanPhapQuy.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(vanBanPhapQuy);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyImpl.class, vanBanPhapQuy.getPrimaryKey());

        return vanBanPhapQuy;
    }

    /**
     * @deprecated Use <code>update(VanBanPhapQuy vanBanPhapQuy, boolean merge)</code>.
     */
    public VanBanPhapQuy update(VanBanPhapQuy vanBanPhapQuy)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(VanBanPhapQuy vanBanPhapQuy) method. Use update(VanBanPhapQuy vanBanPhapQuy, boolean merge) instead.");
        }

        return update(vanBanPhapQuy, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                vanBanPhapQuy the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when vanBanPhapQuy is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public VanBanPhapQuy update(VanBanPhapQuy vanBanPhapQuy, boolean merge)
        throws SystemException {
        boolean isNew = vanBanPhapQuy.isNew();

        for (ModelListener<VanBanPhapQuy> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(vanBanPhapQuy);
            } else {
                listener.onBeforeUpdate(vanBanPhapQuy);
            }
        }

        vanBanPhapQuy = updateImpl(vanBanPhapQuy, merge);

        for (ModelListener<VanBanPhapQuy> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(vanBanPhapQuy);
            } else {
                listener.onAfterUpdate(vanBanPhapQuy);
            }
        }

        return vanBanPhapQuy;
    }

    public VanBanPhapQuy updateImpl(
        com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy vanBanPhapQuy,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, vanBanPhapQuy, merge);

            vanBanPhapQuy.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
            VanBanPhapQuyImpl.class, vanBanPhapQuy.getPrimaryKey(),
            vanBanPhapQuy);

        return vanBanPhapQuy;
    }

    public VanBanPhapQuy findByPrimaryKey(long maVanBanPhapQuy)
        throws NoSuchVanBanPhapQuyException, SystemException {
        VanBanPhapQuy vanBanPhapQuy = fetchByPrimaryKey(maVanBanPhapQuy);

        if (vanBanPhapQuy == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No VanBanPhapQuy exists with the primary key " +
                    maVanBanPhapQuy);
            }

            throw new NoSuchVanBanPhapQuyException(
                "No VanBanPhapQuy exists with the primary key " +
                maVanBanPhapQuy);
        }

        return vanBanPhapQuy;
    }

    public VanBanPhapQuy fetchByPrimaryKey(long maVanBanPhapQuy)
        throws SystemException {
        VanBanPhapQuy vanBanPhapQuy = (VanBanPhapQuy) EntityCacheUtil.getResult(VanBanPhapQuyModelImpl.ENTITY_CACHE_ENABLED,
                VanBanPhapQuyImpl.class, maVanBanPhapQuy, this);

        if (vanBanPhapQuy == null) {
            Session session = null;

            try {
                session = openSession();

                vanBanPhapQuy = (VanBanPhapQuy) session.get(VanBanPhapQuyImpl.class,
                        new Long(maVanBanPhapQuy));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (vanBanPhapQuy != null) {
                    cacheResult(vanBanPhapQuy);
                }

                closeSession(session);
            }
        }

        return vanBanPhapQuy;
    }

    public List<VanBanPhapQuy> findByActive(int active)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<VanBanPhapQuy> list = (List<VanBanPhapQuy>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ky_hieu_van_ban ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<VanBanPhapQuy>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<VanBanPhapQuy> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<VanBanPhapQuy> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<VanBanPhapQuy> list = (List<VanBanPhapQuy>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ky_hieu_van_ban ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<VanBanPhapQuy>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<VanBanPhapQuy>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public VanBanPhapQuy findByActive_First(int active, OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        List<VanBanPhapQuy> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No VanBanPhapQuy exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchVanBanPhapQuyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public VanBanPhapQuy findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        int count = countByActive(active);

        List<VanBanPhapQuy> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No VanBanPhapQuy exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchVanBanPhapQuyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public VanBanPhapQuy[] findByActive_PrevAndNext(long maVanBanPhapQuy,
        int active, OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        VanBanPhapQuy vanBanPhapQuy = findByPrimaryKey(maVanBanPhapQuy);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ky_hieu_van_ban ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    vanBanPhapQuy);

            VanBanPhapQuy[] array = new VanBanPhapQuyImpl[3];

            array[0] = (VanBanPhapQuy) objArray[0];
            array[1] = (VanBanPhapQuy) objArray[1];
            array[2] = (VanBanPhapQuy) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<VanBanPhapQuy> findByMaLoaiVanBan(long maLoaiVanBan)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maLoaiVanBan) };

        List<VanBanPhapQuy> list = (List<VanBanPhapQuy>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MALOAIVANBAN,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("ma_loai_van_ban = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ky_hieu_van_ban ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maLoaiVanBan);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<VanBanPhapQuy>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MALOAIVANBAN,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<VanBanPhapQuy> findByMaLoaiVanBan(long maLoaiVanBan, int start,
        int end) throws SystemException {
        return findByMaLoaiVanBan(maLoaiVanBan, start, end, null);
    }

    public List<VanBanPhapQuy> findByMaLoaiVanBan(long maLoaiVanBan, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maLoaiVanBan),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<VanBanPhapQuy> list = (List<VanBanPhapQuy>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MALOAIVANBAN,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("ma_loai_van_ban = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ky_hieu_van_ban ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maLoaiVanBan);

                list = (List<VanBanPhapQuy>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<VanBanPhapQuy>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MALOAIVANBAN,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public VanBanPhapQuy findByMaLoaiVanBan_First(long maLoaiVanBan,
        OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        List<VanBanPhapQuy> list = findByMaLoaiVanBan(maLoaiVanBan, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No VanBanPhapQuy exists with the key {");

            msg.append("maLoaiVanBan=" + maLoaiVanBan);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchVanBanPhapQuyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public VanBanPhapQuy findByMaLoaiVanBan_Last(long maLoaiVanBan,
        OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        int count = countByMaLoaiVanBan(maLoaiVanBan);

        List<VanBanPhapQuy> list = findByMaLoaiVanBan(maLoaiVanBan, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No VanBanPhapQuy exists with the key {");

            msg.append("maLoaiVanBan=" + maLoaiVanBan);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchVanBanPhapQuyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public VanBanPhapQuy[] findByMaLoaiVanBan_PrevAndNext(
        long maVanBanPhapQuy, long maLoaiVanBan, OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        VanBanPhapQuy vanBanPhapQuy = findByPrimaryKey(maVanBanPhapQuy);

        int count = countByMaLoaiVanBan(maLoaiVanBan);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

            query.append("ma_loai_van_ban = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ky_hieu_van_ban ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maLoaiVanBan);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    vanBanPhapQuy);

            VanBanPhapQuy[] array = new VanBanPhapQuyImpl[3];

            array[0] = (VanBanPhapQuy) objArray[0];
            array[1] = (VanBanPhapQuy) objArray[1];
            array[2] = (VanBanPhapQuy) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<VanBanPhapQuy> findByMaLinhVucVanBan(long maLinhVucVanBan)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maLinhVucVanBan) };

        List<VanBanPhapQuy> list = (List<VanBanPhapQuy>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MALINHVUCVANBAN,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("ma_linh_vuc_van_ban = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ky_hieu_van_ban ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maLinhVucVanBan);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<VanBanPhapQuy>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MALINHVUCVANBAN,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<VanBanPhapQuy> findByMaLinhVucVanBan(long maLinhVucVanBan,
        int start, int end) throws SystemException {
        return findByMaLinhVucVanBan(maLinhVucVanBan, start, end, null);
    }

    public List<VanBanPhapQuy> findByMaLinhVucVanBan(long maLinhVucVanBan,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maLinhVucVanBan),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<VanBanPhapQuy> list = (List<VanBanPhapQuy>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MALINHVUCVANBAN,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("ma_linh_vuc_van_ban = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ky_hieu_van_ban ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maLinhVucVanBan);

                list = (List<VanBanPhapQuy>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<VanBanPhapQuy>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MALINHVUCVANBAN,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public VanBanPhapQuy findByMaLinhVucVanBan_First(long maLinhVucVanBan,
        OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        List<VanBanPhapQuy> list = findByMaLinhVucVanBan(maLinhVucVanBan, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No VanBanPhapQuy exists with the key {");

            msg.append("maLinhVucVanBan=" + maLinhVucVanBan);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchVanBanPhapQuyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public VanBanPhapQuy findByMaLinhVucVanBan_Last(long maLinhVucVanBan,
        OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        int count = countByMaLinhVucVanBan(maLinhVucVanBan);

        List<VanBanPhapQuy> list = findByMaLinhVucVanBan(maLinhVucVanBan,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No VanBanPhapQuy exists with the key {");

            msg.append("maLinhVucVanBan=" + maLinhVucVanBan);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchVanBanPhapQuyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public VanBanPhapQuy[] findByMaLinhVucVanBan_PrevAndNext(
        long maVanBanPhapQuy, long maLinhVucVanBan, OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        VanBanPhapQuy vanBanPhapQuy = findByPrimaryKey(maVanBanPhapQuy);

        int count = countByMaLinhVucVanBan(maLinhVucVanBan);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

            query.append("ma_linh_vuc_van_ban = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ky_hieu_van_ban ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maLinhVucVanBan);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    vanBanPhapQuy);

            VanBanPhapQuy[] array = new VanBanPhapQuyImpl[3];

            array[0] = (VanBanPhapQuy) objArray[0];
            array[1] = (VanBanPhapQuy) objArray[1];
            array[2] = (VanBanPhapQuy) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<VanBanPhapQuy> findByMaCoQuanBanHanh(long maCoQuanBanHanh)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maCoQuanBanHanh) };

        List<VanBanPhapQuy> list = (List<VanBanPhapQuy>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MACOQUANBANHANH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("ma_co_quan_ban_hanh = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ky_hieu_van_ban ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCoQuanBanHanh);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<VanBanPhapQuy>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MACOQUANBANHANH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<VanBanPhapQuy> findByMaCoQuanBanHanh(long maCoQuanBanHanh,
        int start, int end) throws SystemException {
        return findByMaCoQuanBanHanh(maCoQuanBanHanh, start, end, null);
    }

    public List<VanBanPhapQuy> findByMaCoQuanBanHanh(long maCoQuanBanHanh,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maCoQuanBanHanh),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<VanBanPhapQuy> list = (List<VanBanPhapQuy>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MACOQUANBANHANH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("ma_co_quan_ban_hanh = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ky_hieu_van_ban ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCoQuanBanHanh);

                list = (List<VanBanPhapQuy>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<VanBanPhapQuy>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MACOQUANBANHANH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public VanBanPhapQuy findByMaCoQuanBanHanh_First(long maCoQuanBanHanh,
        OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        List<VanBanPhapQuy> list = findByMaCoQuanBanHanh(maCoQuanBanHanh, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No VanBanPhapQuy exists with the key {");

            msg.append("maCoQuanBanHanh=" + maCoQuanBanHanh);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchVanBanPhapQuyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public VanBanPhapQuy findByMaCoQuanBanHanh_Last(long maCoQuanBanHanh,
        OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        int count = countByMaCoQuanBanHanh(maCoQuanBanHanh);

        List<VanBanPhapQuy> list = findByMaCoQuanBanHanh(maCoQuanBanHanh,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No VanBanPhapQuy exists with the key {");

            msg.append("maCoQuanBanHanh=" + maCoQuanBanHanh);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchVanBanPhapQuyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public VanBanPhapQuy[] findByMaCoQuanBanHanh_PrevAndNext(
        long maVanBanPhapQuy, long maCoQuanBanHanh, OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        VanBanPhapQuy vanBanPhapQuy = findByPrimaryKey(maVanBanPhapQuy);

        int count = countByMaCoQuanBanHanh(maCoQuanBanHanh);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

            query.append("ma_co_quan_ban_hanh = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ky_hieu_van_ban ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maCoQuanBanHanh);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    vanBanPhapQuy);

            VanBanPhapQuy[] array = new VanBanPhapQuyImpl[3];

            array[0] = (VanBanPhapQuy) objArray[0];
            array[1] = (VanBanPhapQuy) objArray[1];
            array[2] = (VanBanPhapQuy) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<VanBanPhapQuy> findByCompanyid(long companyid)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(companyid) };

        List<VanBanPhapQuy> list = (List<VanBanPhapQuy>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("companyid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ky_hieu_van_ban ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyid);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<VanBanPhapQuy>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<VanBanPhapQuy> findByCompanyid(long companyid, int start,
        int end) throws SystemException {
        return findByCompanyid(companyid, start, end, null);
    }

    public List<VanBanPhapQuy> findByCompanyid(long companyid, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(companyid),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<VanBanPhapQuy> list = (List<VanBanPhapQuy>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_COMPANYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("companyid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ky_hieu_van_ban ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyid);

                list = (List<VanBanPhapQuy>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<VanBanPhapQuy>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_COMPANYID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public VanBanPhapQuy findByCompanyid_First(long companyid,
        OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        List<VanBanPhapQuy> list = findByCompanyid(companyid, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No VanBanPhapQuy exists with the key {");

            msg.append("companyid=" + companyid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchVanBanPhapQuyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public VanBanPhapQuy findByCompanyid_Last(long companyid,
        OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        int count = countByCompanyid(companyid);

        List<VanBanPhapQuy> list = findByCompanyid(companyid, count - 1, count,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No VanBanPhapQuy exists with the key {");

            msg.append("companyid=" + companyid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchVanBanPhapQuyException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public VanBanPhapQuy[] findByCompanyid_PrevAndNext(long maVanBanPhapQuy,
        long companyid, OrderByComparator obc)
        throws NoSuchVanBanPhapQuyException, SystemException {
        VanBanPhapQuy vanBanPhapQuy = findByPrimaryKey(maVanBanPhapQuy);

        int count = countByCompanyid(companyid);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

            query.append("companyid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ky_hieu_van_ban ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(companyid);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    vanBanPhapQuy);

            VanBanPhapQuy[] array = new VanBanPhapQuyImpl[3];

            array[0] = (VanBanPhapQuy) objArray[0];
            array[1] = (VanBanPhapQuy) objArray[1];
            array[2] = (VanBanPhapQuy) objArray[2];

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

    public List<VanBanPhapQuy> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<VanBanPhapQuy> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<VanBanPhapQuy> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<VanBanPhapQuy> list = (List<VanBanPhapQuy>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ky_hieu_van_ban ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<VanBanPhapQuy>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<VanBanPhapQuy>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<VanBanPhapQuy>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (VanBanPhapQuy vanBanPhapQuy : findByActive(active)) {
            remove(vanBanPhapQuy);
        }
    }

    public void removeByMaLoaiVanBan(long maLoaiVanBan)
        throws SystemException {
        for (VanBanPhapQuy vanBanPhapQuy : findByMaLoaiVanBan(maLoaiVanBan)) {
            remove(vanBanPhapQuy);
        }
    }

    public void removeByMaLinhVucVanBan(long maLinhVucVanBan)
        throws SystemException {
        for (VanBanPhapQuy vanBanPhapQuy : findByMaLinhVucVanBan(
                maLinhVucVanBan)) {
            remove(vanBanPhapQuy);
        }
    }

    public void removeByMaCoQuanBanHanh(long maCoQuanBanHanh)
        throws SystemException {
        for (VanBanPhapQuy vanBanPhapQuy : findByMaCoQuanBanHanh(
                maCoQuanBanHanh)) {
            remove(vanBanPhapQuy);
        }
    }

    public void removeByCompanyid(long companyid) throws SystemException {
        for (VanBanPhapQuy vanBanPhapQuy : findByCompanyid(companyid)) {
            remove(vanBanPhapQuy);
        }
    }

    public void removeAll() throws SystemException {
        for (VanBanPhapQuy vanBanPhapQuy : findAll()) {
            remove(vanBanPhapQuy);
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
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

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

    public int countByMaLoaiVanBan(long maLoaiVanBan) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maLoaiVanBan) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MALOAIVANBAN,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("ma_loai_van_ban = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maLoaiVanBan);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MALOAIVANBAN,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMaLinhVucVanBan(long maLinhVucVanBan)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maLinhVucVanBan) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MALINHVUCVANBAN,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("ma_linh_vuc_van_ban = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maLinhVucVanBan);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MALINHVUCVANBAN,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMaCoQuanBanHanh(long maCoQuanBanHanh)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maCoQuanBanHanh) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MACOQUANBANHANH,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("ma_co_quan_ban_hanh = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCoQuanBanHanh);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MACOQUANBANHANH,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByCompanyid(long companyid) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(companyid) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy WHERE ");

                query.append("companyid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyid);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy");

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
                        "value.object.listener.com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<VanBanPhapQuy>> listenersList = new ArrayList<ModelListener<VanBanPhapQuy>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<VanBanPhapQuy>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
