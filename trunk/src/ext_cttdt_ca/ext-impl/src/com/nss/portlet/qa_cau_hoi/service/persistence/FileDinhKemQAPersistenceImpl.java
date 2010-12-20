package com.nss.portlet.qa_cau_hoi.service.persistence;

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

import com.nss.portlet.qa_cau_hoi.NoSuchFileDinhKemQAException;
import com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA;
import com.nss.portlet.qa_cau_hoi.model.impl.FileDinhKemQAImpl;
import com.nss.portlet.qa_cau_hoi.model.impl.FileDinhKemQAModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileDinhKemQAPersistenceImpl extends BasePersistenceImpl
    implements FileDinhKemQAPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = FileDinhKemQAImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_MACAUHOI = new FinderPath(FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemQAModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaCauHoi",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MACAUHOI = new FinderPath(FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemQAModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaCauHoi",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MACAUHOI = new FinderPath(FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemQAModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByMaCauHoi",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MACAUTRALOI = new FinderPath(FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemQAModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaCauTraLoi",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MACAUTRALOI = new FinderPath(FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemQAModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMaCauTraLoi",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MACAUTRALOI = new FinderPath(FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemQAModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByMaCauTraLoi",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemQAModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemQAModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(FileDinhKemQAPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.qa_cau_hoi.service.persistence.CauHoiQAPersistence.impl")
    protected com.nss.portlet.qa_cau_hoi.service.persistence.CauHoiQAPersistence cauHoiQAPersistence;
    @BeanReference(name = "com.nss.portlet.qa_cau_hoi.service.persistence.FileDinhKemQAPersistence.impl")
    protected com.nss.portlet.qa_cau_hoi.service.persistence.FileDinhKemQAPersistence fileDinhKemQAPersistence;

    public void cacheResult(FileDinhKemQA fileDinhKemQA) {
        EntityCacheUtil.putResult(FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemQAImpl.class, fileDinhKemQA.getPrimaryKey(),
            fileDinhKemQA);
    }

    public void cacheResult(List<FileDinhKemQA> fileDinhKemQAs) {
        for (FileDinhKemQA fileDinhKemQA : fileDinhKemQAs) {
            if (EntityCacheUtil.getResult(
                        FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
                        FileDinhKemQAImpl.class, fileDinhKemQA.getPrimaryKey(),
                        this) == null) {
                cacheResult(fileDinhKemQA);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(FileDinhKemQAImpl.class.getName());
        EntityCacheUtil.clearCache(FileDinhKemQAImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public FileDinhKemQA create(long maFileDinhKemQA) {
        FileDinhKemQA fileDinhKemQA = new FileDinhKemQAImpl();

        fileDinhKemQA.setNew(true);
        fileDinhKemQA.setPrimaryKey(maFileDinhKemQA);

        return fileDinhKemQA;
    }

    public FileDinhKemQA remove(long maFileDinhKemQA)
        throws NoSuchFileDinhKemQAException, SystemException {
        Session session = null;

        try {
            session = openSession();

            FileDinhKemQA fileDinhKemQA = (FileDinhKemQA) session.get(FileDinhKemQAImpl.class,
                    new Long(maFileDinhKemQA));

            if (fileDinhKemQA == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No FileDinhKemQA exists with the primary key " +
                        maFileDinhKemQA);
                }

                throw new NoSuchFileDinhKemQAException(
                    "No FileDinhKemQA exists with the primary key " +
                    maFileDinhKemQA);
            }

            return remove(fileDinhKemQA);
        } catch (NoSuchFileDinhKemQAException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public FileDinhKemQA remove(FileDinhKemQA fileDinhKemQA)
        throws SystemException {
        for (ModelListener<FileDinhKemQA> listener : listeners) {
            listener.onBeforeRemove(fileDinhKemQA);
        }

        fileDinhKemQA = removeImpl(fileDinhKemQA);

        for (ModelListener<FileDinhKemQA> listener : listeners) {
            listener.onAfterRemove(fileDinhKemQA);
        }

        return fileDinhKemQA;
    }

    protected FileDinhKemQA removeImpl(FileDinhKemQA fileDinhKemQA)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (fileDinhKemQA.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(FileDinhKemQAImpl.class,
                        fileDinhKemQA.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(fileDinhKemQA);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemQAImpl.class, fileDinhKemQA.getPrimaryKey());

        return fileDinhKemQA;
    }

    /**
     * @deprecated Use <code>update(FileDinhKemQA fileDinhKemQA, boolean merge)</code>.
     */
    public FileDinhKemQA update(FileDinhKemQA fileDinhKemQA)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(FileDinhKemQA fileDinhKemQA) method. Use update(FileDinhKemQA fileDinhKemQA, boolean merge) instead.");
        }

        return update(fileDinhKemQA, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                fileDinhKemQA the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when fileDinhKemQA is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public FileDinhKemQA update(FileDinhKemQA fileDinhKemQA, boolean merge)
        throws SystemException {
        boolean isNew = fileDinhKemQA.isNew();

        for (ModelListener<FileDinhKemQA> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(fileDinhKemQA);
            } else {
                listener.onBeforeUpdate(fileDinhKemQA);
            }
        }

        fileDinhKemQA = updateImpl(fileDinhKemQA, merge);

        for (ModelListener<FileDinhKemQA> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(fileDinhKemQA);
            } else {
                listener.onAfterUpdate(fileDinhKemQA);
            }
        }

        return fileDinhKemQA;
    }

    public FileDinhKemQA updateImpl(
        com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA fileDinhKemQA,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, fileDinhKemQA, merge);

            fileDinhKemQA.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
            FileDinhKemQAImpl.class, fileDinhKemQA.getPrimaryKey(),
            fileDinhKemQA);

        return fileDinhKemQA;
    }

    public FileDinhKemQA findByPrimaryKey(long maFileDinhKemQA)
        throws NoSuchFileDinhKemQAException, SystemException {
        FileDinhKemQA fileDinhKemQA = fetchByPrimaryKey(maFileDinhKemQA);

        if (fileDinhKemQA == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No FileDinhKemQA exists with the primary key " +
                    maFileDinhKemQA);
            }

            throw new NoSuchFileDinhKemQAException(
                "No FileDinhKemQA exists with the primary key " +
                maFileDinhKemQA);
        }

        return fileDinhKemQA;
    }

    public FileDinhKemQA fetchByPrimaryKey(long maFileDinhKemQA)
        throws SystemException {
        FileDinhKemQA fileDinhKemQA = (FileDinhKemQA) EntityCacheUtil.getResult(FileDinhKemQAModelImpl.ENTITY_CACHE_ENABLED,
                FileDinhKemQAImpl.class, maFileDinhKemQA, this);

        if (fileDinhKemQA == null) {
            Session session = null;

            try {
                session = openSession();

                fileDinhKemQA = (FileDinhKemQA) session.get(FileDinhKemQAImpl.class,
                        new Long(maFileDinhKemQA));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (fileDinhKemQA != null) {
                    cacheResult(fileDinhKemQA);
                }

                closeSession(session);
            }
        }

        return fileDinhKemQA;
    }

    public List<FileDinhKemQA> findByMaCauHoi(long maCauHoi)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maCauHoi) };

        List<FileDinhKemQA> list = (List<FileDinhKemQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MACAUHOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA WHERE ");

                query.append("maCauHoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCauHoi);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKemQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MACAUHOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<FileDinhKemQA> findByMaCauHoi(long maCauHoi, int start, int end)
        throws SystemException {
        return findByMaCauHoi(maCauHoi, start, end, null);
    }

    public List<FileDinhKemQA> findByMaCauHoi(long maCauHoi, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maCauHoi),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<FileDinhKemQA> list = (List<FileDinhKemQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MACAUHOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA WHERE ");

                query.append("maCauHoi = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCauHoi);

                list = (List<FileDinhKemQA>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKemQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MACAUHOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public FileDinhKemQA findByMaCauHoi_First(long maCauHoi,
        OrderByComparator obc)
        throws NoSuchFileDinhKemQAException, SystemException {
        List<FileDinhKemQA> list = findByMaCauHoi(maCauHoi, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No FileDinhKemQA exists with the key {");

            msg.append("maCauHoi=" + maCauHoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchFileDinhKemQAException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public FileDinhKemQA findByMaCauHoi_Last(long maCauHoi,
        OrderByComparator obc)
        throws NoSuchFileDinhKemQAException, SystemException {
        int count = countByMaCauHoi(maCauHoi);

        List<FileDinhKemQA> list = findByMaCauHoi(maCauHoi, count - 1, count,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No FileDinhKemQA exists with the key {");

            msg.append("maCauHoi=" + maCauHoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchFileDinhKemQAException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public FileDinhKemQA[] findByMaCauHoi_PrevAndNext(long maFileDinhKemQA,
        long maCauHoi, OrderByComparator obc)
        throws NoSuchFileDinhKemQAException, SystemException {
        FileDinhKemQA fileDinhKemQA = findByPrimaryKey(maFileDinhKemQA);

        int count = countByMaCauHoi(maCauHoi);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA WHERE ");

            query.append("maCauHoi = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maCauHoi);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    fileDinhKemQA);

            FileDinhKemQA[] array = new FileDinhKemQAImpl[3];

            array[0] = (FileDinhKemQA) objArray[0];
            array[1] = (FileDinhKemQA) objArray[1];
            array[2] = (FileDinhKemQA) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<FileDinhKemQA> findByMaCauTraLoi(long maCauTraLoi)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maCauTraLoi) };

        List<FileDinhKemQA> list = (List<FileDinhKemQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MACAUTRALOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA WHERE ");

                query.append("maCauTraLoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCauTraLoi);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKemQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MACAUTRALOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<FileDinhKemQA> findByMaCauTraLoi(long maCauTraLoi, int start,
        int end) throws SystemException {
        return findByMaCauTraLoi(maCauTraLoi, start, end, null);
    }

    public List<FileDinhKemQA> findByMaCauTraLoi(long maCauTraLoi, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maCauTraLoi),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<FileDinhKemQA> list = (List<FileDinhKemQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MACAUTRALOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA WHERE ");

                query.append("maCauTraLoi = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCauTraLoi);

                list = (List<FileDinhKemQA>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKemQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MACAUTRALOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public FileDinhKemQA findByMaCauTraLoi_First(long maCauTraLoi,
        OrderByComparator obc)
        throws NoSuchFileDinhKemQAException, SystemException {
        List<FileDinhKemQA> list = findByMaCauTraLoi(maCauTraLoi, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No FileDinhKemQA exists with the key {");

            msg.append("maCauTraLoi=" + maCauTraLoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchFileDinhKemQAException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public FileDinhKemQA findByMaCauTraLoi_Last(long maCauTraLoi,
        OrderByComparator obc)
        throws NoSuchFileDinhKemQAException, SystemException {
        int count = countByMaCauTraLoi(maCauTraLoi);

        List<FileDinhKemQA> list = findByMaCauTraLoi(maCauTraLoi, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No FileDinhKemQA exists with the key {");

            msg.append("maCauTraLoi=" + maCauTraLoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchFileDinhKemQAException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public FileDinhKemQA[] findByMaCauTraLoi_PrevAndNext(long maFileDinhKemQA,
        long maCauTraLoi, OrderByComparator obc)
        throws NoSuchFileDinhKemQAException, SystemException {
        FileDinhKemQA fileDinhKemQA = findByPrimaryKey(maFileDinhKemQA);

        int count = countByMaCauTraLoi(maCauTraLoi);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA WHERE ");

            query.append("maCauTraLoi = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maCauTraLoi);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    fileDinhKemQA);

            FileDinhKemQA[] array = new FileDinhKemQAImpl[3];

            array[0] = (FileDinhKemQA) objArray[0];
            array[1] = (FileDinhKemQA) objArray[1];
            array[2] = (FileDinhKemQA) objArray[2];

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

    public List<FileDinhKemQA> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<FileDinhKemQA> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<FileDinhKemQA> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<FileDinhKemQA> list = (List<FileDinhKemQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<FileDinhKemQA>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<FileDinhKemQA>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<FileDinhKemQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByMaCauHoi(long maCauHoi) throws SystemException {
        for (FileDinhKemQA fileDinhKemQA : findByMaCauHoi(maCauHoi)) {
            remove(fileDinhKemQA);
        }
    }

    public void removeByMaCauTraLoi(long maCauTraLoi) throws SystemException {
        for (FileDinhKemQA fileDinhKemQA : findByMaCauTraLoi(maCauTraLoi)) {
            remove(fileDinhKemQA);
        }
    }

    public void removeAll() throws SystemException {
        for (FileDinhKemQA fileDinhKemQA : findAll()) {
            remove(fileDinhKemQA);
        }
    }

    public int countByMaCauHoi(long maCauHoi) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maCauHoi) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MACAUHOI,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA WHERE ");

                query.append("maCauHoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCauHoi);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MACAUHOI,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMaCauTraLoi(long maCauTraLoi) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maCauTraLoi) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MACAUTRALOI,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA WHERE ");

                query.append("maCauTraLoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCauTraLoi);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MACAUTRALOI,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA");

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
                        "value.object.listener.com.nss.portlet.qa_cau_hoi.model.FileDinhKemQA")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<FileDinhKemQA>> listenersList = new ArrayList<ModelListener<FileDinhKemQA>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<FileDinhKemQA>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
