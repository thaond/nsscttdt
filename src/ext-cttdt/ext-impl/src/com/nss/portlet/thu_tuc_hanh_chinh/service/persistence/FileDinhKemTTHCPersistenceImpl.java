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

import com.nss.portlet.thu_tuc_hanh_chinh.NoSuchFileDinhKemTTHCException;
import com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC;
import com.nss.portlet.thu_tuc_hanh_chinh.model.impl.FileDinhKemTTHCImpl;
import com.nss.portlet.thu_tuc_hanh_chinh.model.impl.FileDinhKemTTHCModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileDinhKemTTHCPersistenceImpl extends BasePersistenceImpl
    implements FileDinhKemTTHCPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = FileDinhKemTTHCImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_MATHUTUCHANHCHINH = new FinderPath(FileDinhKemTTHCModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemTTHCModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaThuTucHanhChinh",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MATHUTUCHANHCHINH = new FinderPath(FileDinhKemTTHCModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemTTHCModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaThuTucHanhChinh",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MATHUTUCHANHCHINH = new FinderPath(FileDinhKemTTHCModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemTTHCModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByMaThuTucHanhChinh",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(FileDinhKemTTHCModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemTTHCModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FileDinhKemTTHCModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemTTHCModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(FileDinhKemTTHCPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.ThuTucHanhChinhPersistence.impl")
    protected com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.ThuTucHanhChinhPersistence thuTucHanhChinhPersistence;
    @BeanReference(name = "com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.FileDinhKemTTHCPersistence.impl")
    protected com.nss.portlet.thu_tuc_hanh_chinh.service.persistence.FileDinhKemTTHCPersistence fileDinhKemTTHCPersistence;

    public void cacheResult(FileDinhKemTTHC fileDinhKemTTHC) {
        EntityCacheUtil.putResult(FileDinhKemTTHCModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemTTHCImpl.class, fileDinhKemTTHC.getPrimaryKey(),
            fileDinhKemTTHC);
    }

    public void cacheResult(List<FileDinhKemTTHC> fileDinhKemTTHCs) {
        for (FileDinhKemTTHC fileDinhKemTTHC : fileDinhKemTTHCs) {
            if (EntityCacheUtil.getResult(
                        FileDinhKemTTHCModelImpl.ENTITY_CACHE_ENABLED,
                        FileDinhKemTTHCImpl.class,
                        fileDinhKemTTHC.getPrimaryKey(), this) == null) {
                cacheResult(fileDinhKemTTHC);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(FileDinhKemTTHCImpl.class.getName());
        EntityCacheUtil.clearCache(FileDinhKemTTHCImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public FileDinhKemTTHC create(long maFileDinhKemTTHC) {
        FileDinhKemTTHC fileDinhKemTTHC = new FileDinhKemTTHCImpl();

        fileDinhKemTTHC.setNew(true);
        fileDinhKemTTHC.setPrimaryKey(maFileDinhKemTTHC);

        return fileDinhKemTTHC;
    }

    public FileDinhKemTTHC remove(long maFileDinhKemTTHC)
        throws NoSuchFileDinhKemTTHCException, SystemException {
        Session session = null;

        try {
            session = openSession();

            FileDinhKemTTHC fileDinhKemTTHC = (FileDinhKemTTHC) session.get(FileDinhKemTTHCImpl.class,
                    new Long(maFileDinhKemTTHC));

            if (fileDinhKemTTHC == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No FileDinhKemTTHC exists with the primary key " +
                        maFileDinhKemTTHC);
                }

                throw new NoSuchFileDinhKemTTHCException(
                    "No FileDinhKemTTHC exists with the primary key " +
                    maFileDinhKemTTHC);
            }

            return remove(fileDinhKemTTHC);
        } catch (NoSuchFileDinhKemTTHCException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public FileDinhKemTTHC remove(FileDinhKemTTHC fileDinhKemTTHC)
        throws SystemException {
        for (ModelListener<FileDinhKemTTHC> listener : listeners) {
            listener.onBeforeRemove(fileDinhKemTTHC);
        }

        fileDinhKemTTHC = removeImpl(fileDinhKemTTHC);

        for (ModelListener<FileDinhKemTTHC> listener : listeners) {
            listener.onAfterRemove(fileDinhKemTTHC);
        }

        return fileDinhKemTTHC;
    }

    protected FileDinhKemTTHC removeImpl(FileDinhKemTTHC fileDinhKemTTHC)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (fileDinhKemTTHC.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(FileDinhKemTTHCImpl.class,
                        fileDinhKemTTHC.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(fileDinhKemTTHC);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(FileDinhKemTTHCModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemTTHCImpl.class, fileDinhKemTTHC.getPrimaryKey());

        return fileDinhKemTTHC;
    }

    /**
     * @deprecated Use <code>update(FileDinhKemTTHC fileDinhKemTTHC, boolean merge)</code>.
     */
    public FileDinhKemTTHC update(FileDinhKemTTHC fileDinhKemTTHC)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(FileDinhKemTTHC fileDinhKemTTHC) method. Use update(FileDinhKemTTHC fileDinhKemTTHC, boolean merge) instead.");
        }

        return update(fileDinhKemTTHC, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                fileDinhKemTTHC the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when fileDinhKemTTHC is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public FileDinhKemTTHC update(FileDinhKemTTHC fileDinhKemTTHC, boolean merge)
        throws SystemException {
        boolean isNew = fileDinhKemTTHC.isNew();

        for (ModelListener<FileDinhKemTTHC> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(fileDinhKemTTHC);
            } else {
                listener.onBeforeUpdate(fileDinhKemTTHC);
            }
        }

        fileDinhKemTTHC = updateImpl(fileDinhKemTTHC, merge);

        for (ModelListener<FileDinhKemTTHC> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(fileDinhKemTTHC);
            } else {
                listener.onAfterUpdate(fileDinhKemTTHC);
            }
        }

        return fileDinhKemTTHC;
    }

    public FileDinhKemTTHC updateImpl(
        com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC fileDinhKemTTHC,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, fileDinhKemTTHC, merge);

            fileDinhKemTTHC.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(FileDinhKemTTHCModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemTTHCImpl.class, fileDinhKemTTHC.getPrimaryKey(),
            fileDinhKemTTHC);

        return fileDinhKemTTHC;
    }

    public FileDinhKemTTHC findByPrimaryKey(long maFileDinhKemTTHC)
        throws NoSuchFileDinhKemTTHCException, SystemException {
        FileDinhKemTTHC fileDinhKemTTHC = fetchByPrimaryKey(maFileDinhKemTTHC);

        if (fileDinhKemTTHC == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No FileDinhKemTTHC exists with the primary key " +
                    maFileDinhKemTTHC);
            }

            throw new NoSuchFileDinhKemTTHCException(
                "No FileDinhKemTTHC exists with the primary key " +
                maFileDinhKemTTHC);
        }

        return fileDinhKemTTHC;
    }

    public FileDinhKemTTHC fetchByPrimaryKey(long maFileDinhKemTTHC)
        throws SystemException {
        FileDinhKemTTHC fileDinhKemTTHC = (FileDinhKemTTHC) EntityCacheUtil.getResult(FileDinhKemTTHCModelImpl.ENTITY_CACHE_ENABLED,
                FileDinhKemTTHCImpl.class, maFileDinhKemTTHC, this);

        if (fileDinhKemTTHC == null) {
            Session session = null;

            try {
                session = openSession();

                fileDinhKemTTHC = (FileDinhKemTTHC) session.get(FileDinhKemTTHCImpl.class,
                        new Long(maFileDinhKemTTHC));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (fileDinhKemTTHC != null) {
                    cacheResult(fileDinhKemTTHC);
                }

                closeSession(session);
            }
        }

        return fileDinhKemTTHC;
    }

    public List<FileDinhKemTTHC> findByMaThuTucHanhChinh(long maThuTucHanhChinh)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maThuTucHanhChinh) };

        List<FileDinhKemTTHC> list = (List<FileDinhKemTTHC>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MATHUTUCHANHCHINH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC WHERE ");

                query.append("maThuTucHanhChinh = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("maFileDinhKemTTHC ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maThuTucHanhChinh);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKemTTHC>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MATHUTUCHANHCHINH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<FileDinhKemTTHC> findByMaThuTucHanhChinh(
        long maThuTucHanhChinh, int start, int end) throws SystemException {
        return findByMaThuTucHanhChinh(maThuTucHanhChinh, start, end, null);
    }

    public List<FileDinhKemTTHC> findByMaThuTucHanhChinh(
        long maThuTucHanhChinh, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maThuTucHanhChinh),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<FileDinhKemTTHC> list = (List<FileDinhKemTTHC>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MATHUTUCHANHCHINH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC WHERE ");

                query.append("maThuTucHanhChinh = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("maFileDinhKemTTHC ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maThuTucHanhChinh);

                list = (List<FileDinhKemTTHC>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKemTTHC>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MATHUTUCHANHCHINH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public FileDinhKemTTHC findByMaThuTucHanhChinh_First(
        long maThuTucHanhChinh, OrderByComparator obc)
        throws NoSuchFileDinhKemTTHCException, SystemException {
        List<FileDinhKemTTHC> list = findByMaThuTucHanhChinh(maThuTucHanhChinh,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No FileDinhKemTTHC exists with the key {");

            msg.append("maThuTucHanhChinh=" + maThuTucHanhChinh);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchFileDinhKemTTHCException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public FileDinhKemTTHC findByMaThuTucHanhChinh_Last(
        long maThuTucHanhChinh, OrderByComparator obc)
        throws NoSuchFileDinhKemTTHCException, SystemException {
        int count = countByMaThuTucHanhChinh(maThuTucHanhChinh);

        List<FileDinhKemTTHC> list = findByMaThuTucHanhChinh(maThuTucHanhChinh,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No FileDinhKemTTHC exists with the key {");

            msg.append("maThuTucHanhChinh=" + maThuTucHanhChinh);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchFileDinhKemTTHCException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public FileDinhKemTTHC[] findByMaThuTucHanhChinh_PrevAndNext(
        long maFileDinhKemTTHC, long maThuTucHanhChinh, OrderByComparator obc)
        throws NoSuchFileDinhKemTTHCException, SystemException {
        FileDinhKemTTHC fileDinhKemTTHC = findByPrimaryKey(maFileDinhKemTTHC);

        int count = countByMaThuTucHanhChinh(maThuTucHanhChinh);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC WHERE ");

            query.append("maThuTucHanhChinh = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("maFileDinhKemTTHC ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maThuTucHanhChinh);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    fileDinhKemTTHC);

            FileDinhKemTTHC[] array = new FileDinhKemTTHCImpl[3];

            array[0] = (FileDinhKemTTHC) objArray[0];
            array[1] = (FileDinhKemTTHC) objArray[1];
            array[2] = (FileDinhKemTTHC) objArray[2];

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

    public List<FileDinhKemTTHC> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<FileDinhKemTTHC> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<FileDinhKemTTHC> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<FileDinhKemTTHC> list = (List<FileDinhKemTTHC>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("maFileDinhKemTTHC ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<FileDinhKemTTHC>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<FileDinhKemTTHC>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKemTTHC>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByMaThuTucHanhChinh(long maThuTucHanhChinh)
        throws SystemException {
        for (FileDinhKemTTHC fileDinhKemTTHC : findByMaThuTucHanhChinh(
                maThuTucHanhChinh)) {
            remove(fileDinhKemTTHC);
        }
    }

    public void removeAll() throws SystemException {
        for (FileDinhKemTTHC fileDinhKemTTHC : findAll()) {
            remove(fileDinhKemTTHC);
        }
    }

    public int countByMaThuTucHanhChinh(long maThuTucHanhChinh)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maThuTucHanhChinh) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MATHUTUCHANHCHINH,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC WHERE ");

                query.append("maThuTucHanhChinh = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maThuTucHanhChinh);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MATHUTUCHANHCHINH,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC");

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
                        "value.object.listener.com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<FileDinhKemTTHC>> listenersList = new ArrayList<ModelListener<FileDinhKemTTHC>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<FileDinhKemTTHC>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
