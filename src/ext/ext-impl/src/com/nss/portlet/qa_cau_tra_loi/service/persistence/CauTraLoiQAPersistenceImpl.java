package com.nss.portlet.qa_cau_tra_loi.service.persistence;

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

import com.nss.portlet.qa_cau_tra_loi.NoSuchCauTraLoiQAException;
import com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA;
import com.nss.portlet.qa_cau_tra_loi.model.impl.CauTraLoiQAImpl;
import com.nss.portlet.qa_cau_tra_loi.model.impl.CauTraLoiQAModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CauTraLoiQAPersistenceImpl extends BasePersistenceImpl
    implements CauTraLoiQAPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = CauTraLoiQAImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_MACAUHOIQA = new FinderPath(CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauTraLoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaCauHoiQA", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MACAUHOIQA = new FinderPath(CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauTraLoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaCauHoiQA",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MACAUHOIQA = new FinderPath(CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauTraLoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByMaCauHoiQA", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MACAUHOIQA_PUBLISH = new FinderPath(CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauTraLoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaCauHoiQA_Publish",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MACAUHOIQA_PUBLISH = new FinderPath(CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauTraLoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaCauHoiQA_Publish",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MACAUHOIQA_PUBLISH = new FinderPath(CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauTraLoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByMaCauHoiQA_Publish",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauTraLoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauTraLoiQAModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(CauTraLoiQAPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.qa_cau_tra_loi.service.persistence.CauTraLoiQAPersistence.impl")
    protected com.nss.portlet.qa_cau_tra_loi.service.persistence.CauTraLoiQAPersistence cauTraLoiQAPersistence;

    public void cacheResult(CauTraLoiQA cauTraLoiQA) {
        EntityCacheUtil.putResult(CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauTraLoiQAImpl.class, cauTraLoiQA.getPrimaryKey(), cauTraLoiQA);
    }

    public void cacheResult(List<CauTraLoiQA> cauTraLoiQAs) {
        for (CauTraLoiQA cauTraLoiQA : cauTraLoiQAs) {
            if (EntityCacheUtil.getResult(
                        CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
                        CauTraLoiQAImpl.class, cauTraLoiQA.getPrimaryKey(), this) == null) {
                cacheResult(cauTraLoiQA);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(CauTraLoiQAImpl.class.getName());
        EntityCacheUtil.clearCache(CauTraLoiQAImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public CauTraLoiQA create(long maCauTraLoiQA) {
        CauTraLoiQA cauTraLoiQA = new CauTraLoiQAImpl();

        cauTraLoiQA.setNew(true);
        cauTraLoiQA.setPrimaryKey(maCauTraLoiQA);

        return cauTraLoiQA;
    }

    public CauTraLoiQA remove(long maCauTraLoiQA)
        throws NoSuchCauTraLoiQAException, SystemException {
        Session session = null;

        try {
            session = openSession();

            CauTraLoiQA cauTraLoiQA = (CauTraLoiQA) session.get(CauTraLoiQAImpl.class,
                    new Long(maCauTraLoiQA));

            if (cauTraLoiQA == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No CauTraLoiQA exists with the primary key " +
                        maCauTraLoiQA);
                }

                throw new NoSuchCauTraLoiQAException(
                    "No CauTraLoiQA exists with the primary key " +
                    maCauTraLoiQA);
            }

            return remove(cauTraLoiQA);
        } catch (NoSuchCauTraLoiQAException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public CauTraLoiQA remove(CauTraLoiQA cauTraLoiQA)
        throws SystemException {
        for (ModelListener<CauTraLoiQA> listener : listeners) {
            listener.onBeforeRemove(cauTraLoiQA);
        }

        cauTraLoiQA = removeImpl(cauTraLoiQA);

        for (ModelListener<CauTraLoiQA> listener : listeners) {
            listener.onAfterRemove(cauTraLoiQA);
        }

        return cauTraLoiQA;
    }

    protected CauTraLoiQA removeImpl(CauTraLoiQA cauTraLoiQA)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (cauTraLoiQA.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(CauTraLoiQAImpl.class,
                        cauTraLoiQA.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(cauTraLoiQA);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauTraLoiQAImpl.class, cauTraLoiQA.getPrimaryKey());

        return cauTraLoiQA;
    }

    /**
     * @deprecated Use <code>update(CauTraLoiQA cauTraLoiQA, boolean merge)</code>.
     */
    public CauTraLoiQA update(CauTraLoiQA cauTraLoiQA)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(CauTraLoiQA cauTraLoiQA) method. Use update(CauTraLoiQA cauTraLoiQA, boolean merge) instead.");
        }

        return update(cauTraLoiQA, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                cauTraLoiQA the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when cauTraLoiQA is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public CauTraLoiQA update(CauTraLoiQA cauTraLoiQA, boolean merge)
        throws SystemException {
        boolean isNew = cauTraLoiQA.isNew();

        for (ModelListener<CauTraLoiQA> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(cauTraLoiQA);
            } else {
                listener.onBeforeUpdate(cauTraLoiQA);
            }
        }

        cauTraLoiQA = updateImpl(cauTraLoiQA, merge);

        for (ModelListener<CauTraLoiQA> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(cauTraLoiQA);
            } else {
                listener.onAfterUpdate(cauTraLoiQA);
            }
        }

        return cauTraLoiQA;
    }

    public CauTraLoiQA updateImpl(
        com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA cauTraLoiQA,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, cauTraLoiQA, merge);

            cauTraLoiQA.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
            CauTraLoiQAImpl.class, cauTraLoiQA.getPrimaryKey(), cauTraLoiQA);

        return cauTraLoiQA;
    }

    public CauTraLoiQA findByPrimaryKey(long maCauTraLoiQA)
        throws NoSuchCauTraLoiQAException, SystemException {
        CauTraLoiQA cauTraLoiQA = fetchByPrimaryKey(maCauTraLoiQA);

        if (cauTraLoiQA == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No CauTraLoiQA exists with the primary key " +
                    maCauTraLoiQA);
            }

            throw new NoSuchCauTraLoiQAException(
                "No CauTraLoiQA exists with the primary key " + maCauTraLoiQA);
        }

        return cauTraLoiQA;
    }

    public CauTraLoiQA fetchByPrimaryKey(long maCauTraLoiQA)
        throws SystemException {
        CauTraLoiQA cauTraLoiQA = (CauTraLoiQA) EntityCacheUtil.getResult(CauTraLoiQAModelImpl.ENTITY_CACHE_ENABLED,
                CauTraLoiQAImpl.class, maCauTraLoiQA, this);

        if (cauTraLoiQA == null) {
            Session session = null;

            try {
                session = openSession();

                cauTraLoiQA = (CauTraLoiQA) session.get(CauTraLoiQAImpl.class,
                        new Long(maCauTraLoiQA));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (cauTraLoiQA != null) {
                    cacheResult(cauTraLoiQA);
                }

                closeSession(session);
            }
        }

        return cauTraLoiQA;
    }

    public List<CauTraLoiQA> findByMaCauHoiQA(long maCauHoiQA)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maCauHoiQA) };

        List<CauTraLoiQA> list = (List<CauTraLoiQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MACAUHOIQA,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA WHERE ");

                query.append("maCauHoiQA = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCauHoiQA);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CauTraLoiQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MACAUHOIQA,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<CauTraLoiQA> findByMaCauHoiQA(long maCauHoiQA, int start,
        int end) throws SystemException {
        return findByMaCauHoiQA(maCauHoiQA, start, end, null);
    }

    public List<CauTraLoiQA> findByMaCauHoiQA(long maCauHoiQA, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maCauHoiQA),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<CauTraLoiQA> list = (List<CauTraLoiQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MACAUHOIQA,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA WHERE ");

                query.append("maCauHoiQA = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCauHoiQA);

                list = (List<CauTraLoiQA>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CauTraLoiQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MACAUHOIQA,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public CauTraLoiQA findByMaCauHoiQA_First(long maCauHoiQA,
        OrderByComparator obc)
        throws NoSuchCauTraLoiQAException, SystemException {
        List<CauTraLoiQA> list = findByMaCauHoiQA(maCauHoiQA, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CauTraLoiQA exists with the key {");

            msg.append("maCauHoiQA=" + maCauHoiQA);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCauTraLoiQAException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public CauTraLoiQA findByMaCauHoiQA_Last(long maCauHoiQA,
        OrderByComparator obc)
        throws NoSuchCauTraLoiQAException, SystemException {
        int count = countByMaCauHoiQA(maCauHoiQA);

        List<CauTraLoiQA> list = findByMaCauHoiQA(maCauHoiQA, count - 1, count,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CauTraLoiQA exists with the key {");

            msg.append("maCauHoiQA=" + maCauHoiQA);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCauTraLoiQAException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public CauTraLoiQA[] findByMaCauHoiQA_PrevAndNext(long maCauTraLoiQA,
        long maCauHoiQA, OrderByComparator obc)
        throws NoSuchCauTraLoiQAException, SystemException {
        CauTraLoiQA cauTraLoiQA = findByPrimaryKey(maCauTraLoiQA);

        int count = countByMaCauHoiQA(maCauHoiQA);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA WHERE ");

            query.append("maCauHoiQA = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maCauHoiQA);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    cauTraLoiQA);

            CauTraLoiQA[] array = new CauTraLoiQAImpl[3];

            array[0] = (CauTraLoiQA) objArray[0];
            array[1] = (CauTraLoiQA) objArray[1];
            array[2] = (CauTraLoiQA) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<CauTraLoiQA> findByMaCauHoiQA_Publish(long maCauHoiQA,
        boolean publish) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maCauHoiQA), Boolean.valueOf(publish)
            };

        List<CauTraLoiQA> list = (List<CauTraLoiQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MACAUHOIQA_PUBLISH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA WHERE ");

                query.append("maCauHoiQA = ?");

                query.append(" AND ");

                query.append("publish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCauHoiQA);

                qPos.add(publish);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CauTraLoiQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MACAUHOIQA_PUBLISH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<CauTraLoiQA> findByMaCauHoiQA_Publish(long maCauHoiQA,
        boolean publish, int start, int end) throws SystemException {
        return findByMaCauHoiQA_Publish(maCauHoiQA, publish, start, end, null);
    }

    public List<CauTraLoiQA> findByMaCauHoiQA_Publish(long maCauHoiQA,
        boolean publish, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maCauHoiQA), Boolean.valueOf(publish),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<CauTraLoiQA> list = (List<CauTraLoiQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MACAUHOIQA_PUBLISH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA WHERE ");

                query.append("maCauHoiQA = ?");

                query.append(" AND ");

                query.append("publish = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCauHoiQA);

                qPos.add(publish);

                list = (List<CauTraLoiQA>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CauTraLoiQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MACAUHOIQA_PUBLISH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public CauTraLoiQA findByMaCauHoiQA_Publish_First(long maCauHoiQA,
        boolean publish, OrderByComparator obc)
        throws NoSuchCauTraLoiQAException, SystemException {
        List<CauTraLoiQA> list = findByMaCauHoiQA_Publish(maCauHoiQA, publish,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CauTraLoiQA exists with the key {");

            msg.append("maCauHoiQA=" + maCauHoiQA);

            msg.append(", ");
            msg.append("publish=" + publish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCauTraLoiQAException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public CauTraLoiQA findByMaCauHoiQA_Publish_Last(long maCauHoiQA,
        boolean publish, OrderByComparator obc)
        throws NoSuchCauTraLoiQAException, SystemException {
        int count = countByMaCauHoiQA_Publish(maCauHoiQA, publish);

        List<CauTraLoiQA> list = findByMaCauHoiQA_Publish(maCauHoiQA, publish,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CauTraLoiQA exists with the key {");

            msg.append("maCauHoiQA=" + maCauHoiQA);

            msg.append(", ");
            msg.append("publish=" + publish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCauTraLoiQAException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public CauTraLoiQA[] findByMaCauHoiQA_Publish_PrevAndNext(
        long maCauTraLoiQA, long maCauHoiQA, boolean publish,
        OrderByComparator obc)
        throws NoSuchCauTraLoiQAException, SystemException {
        CauTraLoiQA cauTraLoiQA = findByPrimaryKey(maCauTraLoiQA);

        int count = countByMaCauHoiQA_Publish(maCauHoiQA, publish);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA WHERE ");

            query.append("maCauHoiQA = ?");

            query.append(" AND ");

            query.append("publish = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maCauHoiQA);

            qPos.add(publish);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    cauTraLoiQA);

            CauTraLoiQA[] array = new CauTraLoiQAImpl[3];

            array[0] = (CauTraLoiQA) objArray[0];
            array[1] = (CauTraLoiQA) objArray[1];
            array[2] = (CauTraLoiQA) objArray[2];

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

    public List<CauTraLoiQA> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<CauTraLoiQA> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<CauTraLoiQA> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<CauTraLoiQA> list = (List<CauTraLoiQA>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<CauTraLoiQA>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<CauTraLoiQA>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<CauTraLoiQA>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByMaCauHoiQA(long maCauHoiQA) throws SystemException {
        for (CauTraLoiQA cauTraLoiQA : findByMaCauHoiQA(maCauHoiQA)) {
            remove(cauTraLoiQA);
        }
    }

    public void removeByMaCauHoiQA_Publish(long maCauHoiQA, boolean publish)
        throws SystemException {
        for (CauTraLoiQA cauTraLoiQA : findByMaCauHoiQA_Publish(maCauHoiQA,
                publish)) {
            remove(cauTraLoiQA);
        }
    }

    public void removeAll() throws SystemException {
        for (CauTraLoiQA cauTraLoiQA : findAll()) {
            remove(cauTraLoiQA);
        }
    }

    public int countByMaCauHoiQA(long maCauHoiQA) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(maCauHoiQA) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MACAUHOIQA,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA WHERE ");

                query.append("maCauHoiQA = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCauHoiQA);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MACAUHOIQA,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMaCauHoiQA_Publish(long maCauHoiQA, boolean publish)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maCauHoiQA), Boolean.valueOf(publish)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MACAUHOIQA_PUBLISH,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA WHERE ");

                query.append("maCauHoiQA = ?");

                query.append(" AND ");

                query.append("publish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maCauHoiQA);

                qPos.add(publish);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MACAUHOIQA_PUBLISH,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA");

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
                        "value.object.listener.com.nss.portlet.qa_cau_tra_loi.model.CauTraLoiQA")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<CauTraLoiQA>> listenersList = new ArrayList<ModelListener<CauTraLoiQA>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<CauTraLoiQA>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
