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

import com.nss.portlet.qa_cau_hoi.NoSuchCauHoiQAException;
import com.nss.portlet.qa_cau_hoi.model.CauHoiQA;
import com.nss.portlet.qa_cau_hoi.model.impl.CauHoiQAImpl;
import com.nss.portlet.qa_cau_hoi.model.impl.CauHoiQAModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CauHoiQAPersistenceImpl extends BasePersistenceImpl
    implements CauHoiQAPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = CauHoiQAImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_MACHUDECAUHOI = new FinderPath(CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauHoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaChuDeCauHoi", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MACHUDECAUHOI = new FinderPath(CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauHoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaChuDeCauHoi",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MACHUDECAUHOI = new FinderPath(CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauHoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByMaChuDeCauHoi", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MACHUDECAUHOI_PUBLISH = new FinderPath(CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauHoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaChuDeCauHoi_Publish",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MACHUDECAUHOI_PUBLISH =
        new FinderPath(CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauHoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaChuDeCauHoi_Publish",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MACHUDECAUHOI_PUBLISH = new FinderPath(CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauHoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByMaChuDeCauHoi_Publish",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauHoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauHoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(CauHoiQAPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.qa_cau_hoi.service.persistence.CauHoiQAPersistence.impl")
    protected com.nss.portlet.qa_cau_hoi.service.persistence.CauHoiQAPersistence cauHoiQAPersistence;
    @BeanReference(name = "com.nss.portlet.qa_cau_hoi.service.persistence.FileDinhKemQAPersistence.impl")
    protected com.nss.portlet.qa_cau_hoi.service.persistence.FileDinhKemQAPersistence fileDinhKemQAPersistence;

    public void cacheResult(CauHoiQA cauHoiQA) {
        EntityCacheUtil.putResult(CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauHoiQAImpl.class, cauHoiQA.getPrimaryKey(), cauHoiQA);
    }

    public void cacheResult(List<CauHoiQA> cauHoiQAs) {
        for (CauHoiQA cauHoiQA : cauHoiQAs) {
            if (EntityCacheUtil.getResult(
                        CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
                        CauHoiQAImpl.class, cauHoiQA.getPrimaryKey(), this) == null) {
                cacheResult(cauHoiQA);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(CauHoiQAImpl.class.getName());
        EntityCacheUtil.clearCache(CauHoiQAImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public CauHoiQA create(long maCauHoiQA) {
        CauHoiQA cauHoiQA = new CauHoiQAImpl();

        cauHoiQA.setNew(true);
        cauHoiQA.setPrimaryKey(maCauHoiQA);

        return cauHoiQA;
    }

    public CauHoiQA remove(long maCauHoiQA)
        throws NoSuchCauHoiQAException, SystemException {
        Session session = null;

        try {
            session = openSession();

            CauHoiQA cauHoiQA = (CauHoiQA) session.get(CauHoiQAImpl.class,
                    new Long(maCauHoiQA));

            if (cauHoiQA == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No CauHoiQA exists with the primary key " +
                        maCauHoiQA);
                }

                throw new NoSuchCauHoiQAException(
                    "No CauHoiQA exists with the primary key " + maCauHoiQA);
            }

            return remove(cauHoiQA);
        } catch (NoSuchCauHoiQAException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public CauHoiQA remove(CauHoiQA cauHoiQA) throws SystemException {
        for (ModelListener<CauHoiQA> listener : listeners) {
            listener.onBeforeRemove(cauHoiQA);
        }

        cauHoiQA = removeImpl(cauHoiQA);

        for (ModelListener<CauHoiQA> listener : listeners) {
            listener.onAfterRemove(cauHoiQA);
        }

        return cauHoiQA;
    }

    protected CauHoiQA removeImpl(CauHoiQA cauHoiQA) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (cauHoiQA.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(CauHoiQAImpl.class,
                        cauHoiQA.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(cauHoiQA);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauHoiQAImpl.class, cauHoiQA.getPrimaryKey());

        return cauHoiQA;
    }

    /**
     * @deprecated Use <code>update(CauHoiQA cauHoiQA, boolean merge)</code>.
     */
    public CauHoiQA update(CauHoiQA cauHoiQA) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(CauHoiQA cauHoiQA) method. Use update(CauHoiQA cauHoiQA, boolean merge) instead.");
        }

        return update(cauHoiQA, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                cauHoiQA the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when cauHoiQA is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public CauHoiQA update(CauHoiQA cauHoiQA, boolean merge)
        throws SystemException {
        boolean isNew = cauHoiQA.isNew();

        for (ModelListener<CauHoiQA> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(cauHoiQA);
            } else {
                listener.onBeforeUpdate(cauHoiQA);
            }
        }

        cauHoiQA = updateImpl(cauHoiQA, merge);

        for (ModelListener<CauHoiQA> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(cauHoiQA);
            } else {
                listener.onAfterUpdate(cauHoiQA);
            }
        }

        return cauHoiQA;
    }

    public CauHoiQA updateImpl(
        com.nss.portlet.qa_cau_hoi.model.CauHoiQA cauHoiQA, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, cauHoiQA, merge);

            cauHoiQA.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauHoiQAImpl.class, cauHoiQA.getPrimaryKey(), cauHoiQA);

        return cauHoiQA;
    }

    public CauHoiQA findByPrimaryKey(long maCauHoiQA)
        throws NoSuchCauHoiQAException, SystemException {
        CauHoiQA cauHoiQA = fetchByPrimaryKey(maCauHoiQA);

        if (cauHoiQA == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No CauHoiQA exists with the primary key " +
                    maCauHoiQA);
            }

            throw new NoSuchCauHoiQAException(
                "No CauHoiQA exists with the primary key " + maCauHoiQA);
        }

        return cauHoiQA;
    }

    public CauHoiQA fetchByPrimaryKey(long maCauHoiQA)
        throws SystemException {
        CauHoiQA cauHoiQA = (CauHoiQA) EntityCacheUtil.getResult(CauHoiQAModelImpl.ENTITY_CACHE_ENABLED,
                CauHoiQAImpl.class, maCauHoiQA, this);

        if (cauHoiQA == null) {
            Session session = null;

            try {
                session = openSession();

                cauHoiQA = (CauHoiQA) session.get(CauHoiQAImpl.class,
                        new Long(maCauHoiQA));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (cauHoiQA != null) {
                    cacheResult(cauHoiQA);
                }

                closeSession(session);
            }
        }

        return cauHoiQA;
    }

    public List<CauHoiQA> findByMaChuDeCauHoi(long maChuDeCauHoi)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maChuDeCauHoi) };

        List<CauHoiQA> list = (List<CauHoiQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MACHUDECAUHOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.CauHoiQA WHERE ");

                query.append("maChuDeCauHoi = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tieuDe ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maChuDeCauHoi);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CauHoiQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MACHUDECAUHOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<CauHoiQA> findByMaChuDeCauHoi(long maChuDeCauHoi, int start,
        int end) throws SystemException {
        return findByMaChuDeCauHoi(maChuDeCauHoi, start, end, null);
    }

    public List<CauHoiQA> findByMaChuDeCauHoi(long maChuDeCauHoi, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maChuDeCauHoi),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<CauHoiQA> list = (List<CauHoiQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MACHUDECAUHOI,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.CauHoiQA WHERE ");

                query.append("maChuDeCauHoi = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tieuDe ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maChuDeCauHoi);

                list = (List<CauHoiQA>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CauHoiQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MACHUDECAUHOI,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public CauHoiQA findByMaChuDeCauHoi_First(long maChuDeCauHoi,
        OrderByComparator obc) throws NoSuchCauHoiQAException, SystemException {
        List<CauHoiQA> list = findByMaChuDeCauHoi(maChuDeCauHoi, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CauHoiQA exists with the key {");

            msg.append("maChuDeCauHoi=" + maChuDeCauHoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCauHoiQAException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public CauHoiQA findByMaChuDeCauHoi_Last(long maChuDeCauHoi,
        OrderByComparator obc) throws NoSuchCauHoiQAException, SystemException {
        int count = countByMaChuDeCauHoi(maChuDeCauHoi);

        List<CauHoiQA> list = findByMaChuDeCauHoi(maChuDeCauHoi, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CauHoiQA exists with the key {");

            msg.append("maChuDeCauHoi=" + maChuDeCauHoi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCauHoiQAException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public CauHoiQA[] findByMaChuDeCauHoi_PrevAndNext(long maCauHoiQA,
        long maChuDeCauHoi, OrderByComparator obc)
        throws NoSuchCauHoiQAException, SystemException {
        CauHoiQA cauHoiQA = findByPrimaryKey(maCauHoiQA);

        int count = countByMaChuDeCauHoi(maChuDeCauHoi);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_cau_hoi.model.CauHoiQA WHERE ");

            query.append("maChuDeCauHoi = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tieuDe ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maChuDeCauHoi);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, cauHoiQA);

            CauHoiQA[] array = new CauHoiQAImpl[3];

            array[0] = (CauHoiQA) objArray[0];
            array[1] = (CauHoiQA) objArray[1];
            array[2] = (CauHoiQA) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<CauHoiQA> findByMaChuDeCauHoi_Publish(long maChuDeCauHoi,
        boolean publish) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maChuDeCauHoi), Boolean.valueOf(publish)
            };

        List<CauHoiQA> list = (List<CauHoiQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MACHUDECAUHOI_PUBLISH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.CauHoiQA WHERE ");

                query.append("maChuDeCauHoi = ?");

                query.append(" AND ");

                query.append("publish = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tieuDe ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maChuDeCauHoi);

                qPos.add(publish);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CauHoiQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MACHUDECAUHOI_PUBLISH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<CauHoiQA> findByMaChuDeCauHoi_Publish(long maChuDeCauHoi,
        boolean publish, int start, int end) throws SystemException {
        return findByMaChuDeCauHoi_Publish(maChuDeCauHoi, publish, start, end,
            null);
    }

    public List<CauHoiQA> findByMaChuDeCauHoi_Publish(long maChuDeCauHoi,
        boolean publish, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maChuDeCauHoi), Boolean.valueOf(publish),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<CauHoiQA> list = (List<CauHoiQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MACHUDECAUHOI_PUBLISH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.CauHoiQA WHERE ");

                query.append("maChuDeCauHoi = ?");

                query.append(" AND ");

                query.append("publish = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tieuDe ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maChuDeCauHoi);

                qPos.add(publish);

                list = (List<CauHoiQA>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CauHoiQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MACHUDECAUHOI_PUBLISH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public CauHoiQA findByMaChuDeCauHoi_Publish_First(long maChuDeCauHoi,
        boolean publish, OrderByComparator obc)
        throws NoSuchCauHoiQAException, SystemException {
        List<CauHoiQA> list = findByMaChuDeCauHoi_Publish(maChuDeCauHoi,
                publish, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CauHoiQA exists with the key {");

            msg.append("maChuDeCauHoi=" + maChuDeCauHoi);

            msg.append(", ");
            msg.append("publish=" + publish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCauHoiQAException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public CauHoiQA findByMaChuDeCauHoi_Publish_Last(long maChuDeCauHoi,
        boolean publish, OrderByComparator obc)
        throws NoSuchCauHoiQAException, SystemException {
        int count = countByMaChuDeCauHoi_Publish(maChuDeCauHoi, publish);

        List<CauHoiQA> list = findByMaChuDeCauHoi_Publish(maChuDeCauHoi,
                publish, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CauHoiQA exists with the key {");

            msg.append("maChuDeCauHoi=" + maChuDeCauHoi);

            msg.append(", ");
            msg.append("publish=" + publish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCauHoiQAException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public CauHoiQA[] findByMaChuDeCauHoi_Publish_PrevAndNext(long maCauHoiQA,
        long maChuDeCauHoi, boolean publish, OrderByComparator obc)
        throws NoSuchCauHoiQAException, SystemException {
        CauHoiQA cauHoiQA = findByPrimaryKey(maCauHoiQA);

        int count = countByMaChuDeCauHoi_Publish(maChuDeCauHoi, publish);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_cau_hoi.model.CauHoiQA WHERE ");

            query.append("maChuDeCauHoi = ?");

            query.append(" AND ");

            query.append("publish = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tieuDe ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maChuDeCauHoi);

            qPos.add(publish);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, cauHoiQA);

            CauHoiQA[] array = new CauHoiQAImpl[3];

            array[0] = (CauHoiQA) objArray[0];
            array[1] = (CauHoiQA) objArray[1];
            array[2] = (CauHoiQA) objArray[2];

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

    public List<CauHoiQA> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<CauHoiQA> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<CauHoiQA> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<CauHoiQA> list = (List<CauHoiQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.qa_cau_hoi.model.CauHoiQA ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tieuDe ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<CauHoiQA>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<CauHoiQA>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CauHoiQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByMaChuDeCauHoi(long maChuDeCauHoi)
        throws SystemException {
        for (CauHoiQA cauHoiQA : findByMaChuDeCauHoi(maChuDeCauHoi)) {
            remove(cauHoiQA);
        }
    }

    public void removeByMaChuDeCauHoi_Publish(long maChuDeCauHoi,
        boolean publish) throws SystemException {
        for (CauHoiQA cauHoiQA : findByMaChuDeCauHoi_Publish(maChuDeCauHoi,
                publish)) {
            remove(cauHoiQA);
        }
    }

    public void removeAll() throws SystemException {
        for (CauHoiQA cauHoiQA : findAll()) {
            remove(cauHoiQA);
        }
    }

    public int countByMaChuDeCauHoi(long maChuDeCauHoi)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maChuDeCauHoi) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MACHUDECAUHOI,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.CauHoiQA WHERE ");

                query.append("maChuDeCauHoi = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maChuDeCauHoi);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MACHUDECAUHOI,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMaChuDeCauHoi_Publish(long maChuDeCauHoi, boolean publish)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maChuDeCauHoi), Boolean.valueOf(publish)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MACHUDECAUHOI_PUBLISH,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_cau_hoi.model.CauHoiQA WHERE ");

                query.append("maChuDeCauHoi = ?");

                query.append(" AND ");

                query.append("publish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maChuDeCauHoi);

                qPos.add(publish);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MACHUDECAUHOI_PUBLISH,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.qa_cau_hoi.model.CauHoiQA");

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
                        "value.object.listener.com.nss.portlet.qa_cau_hoi.model.CauHoiQA")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<CauHoiQA>> listenersList = new ArrayList<ModelListener<CauHoiQA>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<CauHoiQA>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
