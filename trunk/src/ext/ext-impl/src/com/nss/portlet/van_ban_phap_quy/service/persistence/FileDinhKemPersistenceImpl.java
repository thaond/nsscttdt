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

import com.nss.portlet.van_ban_phap_quy.NoSuchFileDinhKemException;
import com.nss.portlet.van_ban_phap_quy.model.FileDinhKem;
import com.nss.portlet.van_ban_phap_quy.model.impl.FileDinhKemImpl;
import com.nss.portlet.van_ban_phap_quy.model.impl.FileDinhKemModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileDinhKemPersistenceImpl extends BasePersistenceImpl
    implements FileDinhKemPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = FileDinhKemImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_MAVANBANPHAPQUY_PHIENBAN = new FinderPath(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findBymaVanBanPhapQuy_PhienBan",
            new String[] { Long.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MAVANBANPHAPQUY_PHIENBAN =
        new FinderPath(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findBymaVanBanPhapQuy_PhienBan",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MAVANBANPHAPQUY_PHIENBAN =
        new FinderPath(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countBymaVanBanPhapQuy_PhienBan",
            new String[] { Long.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MAVANBANPHAPQUY = new FinderPath(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findBymaVanBanPhapQuy", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MAVANBANPHAPQUY = new FinderPath(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findBymaVanBanPhapQuy",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MAVANBANPHAPQUY = new FinderPath(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countBymaVanBanPhapQuy", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(FileDinhKemPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.van_ban_phap_quy.service.persistence.VanBanPhapQuyPersistence.impl")
    protected com.nss.portlet.van_ban_phap_quy.service.persistence.VanBanPhapQuyPersistence vanBanPhapQuyPersistence;
    @BeanReference(name = "com.nss.portlet.van_ban_phap_quy.service.persistence.FileDinhKemPersistence.impl")
    protected com.nss.portlet.van_ban_phap_quy.service.persistence.FileDinhKemPersistence fileDinhKemPersistence;

    public void cacheResult(FileDinhKem fileDinhKem) {
        EntityCacheUtil.putResult(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemImpl.class, fileDinhKem.getPrimaryKey(), fileDinhKem);
    }

    public void cacheResult(List<FileDinhKem> fileDinhKems) {
        for (FileDinhKem fileDinhKem : fileDinhKems) {
            if (EntityCacheUtil.getResult(
                        FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
                        FileDinhKemImpl.class, fileDinhKem.getPrimaryKey(), this) == null) {
                cacheResult(fileDinhKem);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(FileDinhKemImpl.class.getName());
        EntityCacheUtil.clearCache(FileDinhKemImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public FileDinhKem create(long maFileDinhKem) {
        FileDinhKem fileDinhKem = new FileDinhKemImpl();

        fileDinhKem.setNew(true);
        fileDinhKem.setPrimaryKey(maFileDinhKem);

        return fileDinhKem;
    }

    public FileDinhKem remove(long maFileDinhKem)
        throws NoSuchFileDinhKemException, SystemException {
        Session session = null;

        try {
            session = openSession();

            FileDinhKem fileDinhKem = (FileDinhKem) session.get(FileDinhKemImpl.class,
                    new Long(maFileDinhKem));

            if (fileDinhKem == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No FileDinhKem exists with the primary key " +
                        maFileDinhKem);
                }

                throw new NoSuchFileDinhKemException(
                    "No FileDinhKem exists with the primary key " +
                    maFileDinhKem);
            }

            return remove(fileDinhKem);
        } catch (NoSuchFileDinhKemException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public FileDinhKem remove(FileDinhKem fileDinhKem)
        throws SystemException {
        for (ModelListener<FileDinhKem> listener : listeners) {
            listener.onBeforeRemove(fileDinhKem);
        }

        fileDinhKem = removeImpl(fileDinhKem);

        for (ModelListener<FileDinhKem> listener : listeners) {
            listener.onAfterRemove(fileDinhKem);
        }

        return fileDinhKem;
    }

    protected FileDinhKem removeImpl(FileDinhKem fileDinhKem)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (fileDinhKem.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(FileDinhKemImpl.class,
                        fileDinhKem.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(fileDinhKem);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemImpl.class, fileDinhKem.getPrimaryKey());

        return fileDinhKem;
    }

    /**
     * @deprecated Use <code>update(FileDinhKem fileDinhKem, boolean merge)</code>.
     */
    public FileDinhKem update(FileDinhKem fileDinhKem)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(FileDinhKem fileDinhKem) method. Use update(FileDinhKem fileDinhKem, boolean merge) instead.");
        }

        return update(fileDinhKem, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                fileDinhKem the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when fileDinhKem is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public FileDinhKem update(FileDinhKem fileDinhKem, boolean merge)
        throws SystemException {
        boolean isNew = fileDinhKem.isNew();

        for (ModelListener<FileDinhKem> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(fileDinhKem);
            } else {
                listener.onBeforeUpdate(fileDinhKem);
            }
        }

        fileDinhKem = updateImpl(fileDinhKem, merge);

        for (ModelListener<FileDinhKem> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(fileDinhKem);
            } else {
                listener.onAfterUpdate(fileDinhKem);
            }
        }

        return fileDinhKem;
    }

    public FileDinhKem updateImpl(
        com.nss.portlet.van_ban_phap_quy.model.FileDinhKem fileDinhKem,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, fileDinhKem, merge);

            fileDinhKem.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemImpl.class, fileDinhKem.getPrimaryKey(), fileDinhKem);

        return fileDinhKem;
    }

    public FileDinhKem findByPrimaryKey(long maFileDinhKem)
        throws NoSuchFileDinhKemException, SystemException {
        FileDinhKem fileDinhKem = fetchByPrimaryKey(maFileDinhKem);

        if (fileDinhKem == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No FileDinhKem exists with the primary key " +
                    maFileDinhKem);
            }

            throw new NoSuchFileDinhKemException(
                "No FileDinhKem exists with the primary key " + maFileDinhKem);
        }

        return fileDinhKem;
    }

    public FileDinhKem fetchByPrimaryKey(long maFileDinhKem)
        throws SystemException {
        FileDinhKem fileDinhKem = (FileDinhKem) EntityCacheUtil.getResult(FileDinhKemModelImpl.ENTITY_CACHE_ENABLED,
                FileDinhKemImpl.class, maFileDinhKem, this);

        if (fileDinhKem == null) {
            Session session = null;

            try {
                session = openSession();

                fileDinhKem = (FileDinhKem) session.get(FileDinhKemImpl.class,
                        new Long(maFileDinhKem));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (fileDinhKem != null) {
                    cacheResult(fileDinhKem);
                }

                closeSession(session);
            }
        }

        return fileDinhKem;
    }

    public List<FileDinhKem> findBymaVanBanPhapQuy_PhienBan(
        long maVanBanPhapQuy, int phienBan) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maVanBanPhapQuy), new Integer(phienBan)
            };

        List<FileDinhKem> list = (List<FileDinhKem>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MAVANBANPHAPQUY_PHIENBAN,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.FileDinhKem WHERE ");

                query.append("ma_van_ban_phap_quy = ?");

                query.append(" AND ");

                query.append("phien_ban = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ma_file_dinh_kem ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maVanBanPhapQuy);

                qPos.add(phienBan);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKem>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MAVANBANPHAPQUY_PHIENBAN,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<FileDinhKem> findBymaVanBanPhapQuy_PhienBan(
        long maVanBanPhapQuy, int phienBan, int start, int end)
        throws SystemException {
        return findBymaVanBanPhapQuy_PhienBan(maVanBanPhapQuy, phienBan, start,
            end, null);
    }

    public List<FileDinhKem> findBymaVanBanPhapQuy_PhienBan(
        long maVanBanPhapQuy, int phienBan, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maVanBanPhapQuy), new Integer(phienBan),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<FileDinhKem> list = (List<FileDinhKem>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MAVANBANPHAPQUY_PHIENBAN,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.FileDinhKem WHERE ");

                query.append("ma_van_ban_phap_quy = ?");

                query.append(" AND ");

                query.append("phien_ban = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ma_file_dinh_kem ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maVanBanPhapQuy);

                qPos.add(phienBan);

                list = (List<FileDinhKem>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKem>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MAVANBANPHAPQUY_PHIENBAN,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public FileDinhKem findBymaVanBanPhapQuy_PhienBan_First(
        long maVanBanPhapQuy, int phienBan, OrderByComparator obc)
        throws NoSuchFileDinhKemException, SystemException {
        List<FileDinhKem> list = findBymaVanBanPhapQuy_PhienBan(maVanBanPhapQuy,
                phienBan, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No FileDinhKem exists with the key {");

            msg.append("maVanBanPhapQuy=" + maVanBanPhapQuy);

            msg.append(", ");
            msg.append("phienBan=" + phienBan);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchFileDinhKemException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public FileDinhKem findBymaVanBanPhapQuy_PhienBan_Last(
        long maVanBanPhapQuy, int phienBan, OrderByComparator obc)
        throws NoSuchFileDinhKemException, SystemException {
        int count = countBymaVanBanPhapQuy_PhienBan(maVanBanPhapQuy, phienBan);

        List<FileDinhKem> list = findBymaVanBanPhapQuy_PhienBan(maVanBanPhapQuy,
                phienBan, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No FileDinhKem exists with the key {");

            msg.append("maVanBanPhapQuy=" + maVanBanPhapQuy);

            msg.append(", ");
            msg.append("phienBan=" + phienBan);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchFileDinhKemException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public FileDinhKem[] findBymaVanBanPhapQuy_PhienBan_PrevAndNext(
        long maFileDinhKem, long maVanBanPhapQuy, int phienBan,
        OrderByComparator obc)
        throws NoSuchFileDinhKemException, SystemException {
        FileDinhKem fileDinhKem = findByPrimaryKey(maFileDinhKem);

        int count = countBymaVanBanPhapQuy_PhienBan(maVanBanPhapQuy, phienBan);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.van_ban_phap_quy.model.FileDinhKem WHERE ");

            query.append("ma_van_ban_phap_quy = ?");

            query.append(" AND ");

            query.append("phien_ban = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ma_file_dinh_kem ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maVanBanPhapQuy);

            qPos.add(phienBan);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    fileDinhKem);

            FileDinhKem[] array = new FileDinhKemImpl[3];

            array[0] = (FileDinhKem) objArray[0];
            array[1] = (FileDinhKem) objArray[1];
            array[2] = (FileDinhKem) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<FileDinhKem> findBymaVanBanPhapQuy(long maVanBanPhapQuy)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maVanBanPhapQuy) };

        List<FileDinhKem> list = (List<FileDinhKem>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MAVANBANPHAPQUY,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.FileDinhKem WHERE ");

                query.append("ma_van_ban_phap_quy = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ma_file_dinh_kem ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maVanBanPhapQuy);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKem>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MAVANBANPHAPQUY,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<FileDinhKem> findBymaVanBanPhapQuy(long maVanBanPhapQuy,
        int start, int end) throws SystemException {
        return findBymaVanBanPhapQuy(maVanBanPhapQuy, start, end, null);
    }

    public List<FileDinhKem> findBymaVanBanPhapQuy(long maVanBanPhapQuy,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maVanBanPhapQuy),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<FileDinhKem> list = (List<FileDinhKem>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MAVANBANPHAPQUY,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.FileDinhKem WHERE ");

                query.append("ma_van_ban_phap_quy = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ma_file_dinh_kem ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maVanBanPhapQuy);

                list = (List<FileDinhKem>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKem>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MAVANBANPHAPQUY,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public FileDinhKem findBymaVanBanPhapQuy_First(long maVanBanPhapQuy,
        OrderByComparator obc)
        throws NoSuchFileDinhKemException, SystemException {
        List<FileDinhKem> list = findBymaVanBanPhapQuy(maVanBanPhapQuy, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No FileDinhKem exists with the key {");

            msg.append("maVanBanPhapQuy=" + maVanBanPhapQuy);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchFileDinhKemException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public FileDinhKem findBymaVanBanPhapQuy_Last(long maVanBanPhapQuy,
        OrderByComparator obc)
        throws NoSuchFileDinhKemException, SystemException {
        int count = countBymaVanBanPhapQuy(maVanBanPhapQuy);

        List<FileDinhKem> list = findBymaVanBanPhapQuy(maVanBanPhapQuy,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No FileDinhKem exists with the key {");

            msg.append("maVanBanPhapQuy=" + maVanBanPhapQuy);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchFileDinhKemException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public FileDinhKem[] findBymaVanBanPhapQuy_PrevAndNext(long maFileDinhKem,
        long maVanBanPhapQuy, OrderByComparator obc)
        throws NoSuchFileDinhKemException, SystemException {
        FileDinhKem fileDinhKem = findByPrimaryKey(maFileDinhKem);

        int count = countBymaVanBanPhapQuy(maVanBanPhapQuy);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.van_ban_phap_quy.model.FileDinhKem WHERE ");

            query.append("ma_van_ban_phap_quy = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ma_file_dinh_kem ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maVanBanPhapQuy);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    fileDinhKem);

            FileDinhKem[] array = new FileDinhKemImpl[3];

            array[0] = (FileDinhKem) objArray[0];
            array[1] = (FileDinhKem) objArray[1];
            array[2] = (FileDinhKem) objArray[2];

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

    public List<FileDinhKem> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<FileDinhKem> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<FileDinhKem> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<FileDinhKem> list = (List<FileDinhKem>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.FileDinhKem ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ma_file_dinh_kem ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<FileDinhKem>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<FileDinhKem>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKem>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeBymaVanBanPhapQuy_PhienBan(long maVanBanPhapQuy,
        int phienBan) throws SystemException {
        for (FileDinhKem fileDinhKem : findBymaVanBanPhapQuy_PhienBan(
                maVanBanPhapQuy, phienBan)) {
            remove(fileDinhKem);
        }
    }

    public void removeBymaVanBanPhapQuy(long maVanBanPhapQuy)
        throws SystemException {
        for (FileDinhKem fileDinhKem : findBymaVanBanPhapQuy(maVanBanPhapQuy)) {
            remove(fileDinhKem);
        }
    }

    public void removeAll() throws SystemException {
        for (FileDinhKem fileDinhKem : findAll()) {
            remove(fileDinhKem);
        }
    }

    public int countBymaVanBanPhapQuy_PhienBan(long maVanBanPhapQuy,
        int phienBan) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maVanBanPhapQuy), new Integer(phienBan)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MAVANBANPHAPQUY_PHIENBAN,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.FileDinhKem WHERE ");

                query.append("ma_van_ban_phap_quy = ?");

                query.append(" AND ");

                query.append("phien_ban = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maVanBanPhapQuy);

                qPos.add(phienBan);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAVANBANPHAPQUY_PHIENBAN,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countBymaVanBanPhapQuy(long maVanBanPhapQuy)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maVanBanPhapQuy) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MAVANBANPHAPQUY,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.van_ban_phap_quy.model.FileDinhKem WHERE ");

                query.append("ma_van_ban_phap_quy = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maVanBanPhapQuy);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAVANBANPHAPQUY,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.van_ban_phap_quy.model.FileDinhKem");

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
                        "value.object.listener.com.nss.portlet.van_ban_phap_quy.model.FileDinhKem")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<FileDinhKem>> listenersList = new ArrayList<ModelListener<FileDinhKem>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<FileDinhKem>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
