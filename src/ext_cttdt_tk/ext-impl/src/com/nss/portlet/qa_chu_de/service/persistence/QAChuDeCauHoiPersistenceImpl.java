package com.nss.portlet.qa_chu_de.service.persistence;

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

import com.nss.portlet.qa_chu_de.NoSuchQAChuDeCauHoiException;
import com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi;
import com.nss.portlet.qa_chu_de.model.impl.QAChuDeCauHoiImpl;
import com.nss.portlet.qa_chu_de.model.impl.QAChuDeCauHoiModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QAChuDeCauHoiPersistenceImpl extends BasePersistenceImpl
    implements QAChuDeCauHoiPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = QAChuDeCauHoiImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(QAChuDeCauHoiModelImpl.ENTITY_CACHE_ENABLED,
            QAChuDeCauHoiModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(QAChuDeCauHoiModelImpl.ENTITY_CACHE_ENABLED,
            QAChuDeCauHoiModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(QAChuDeCauHoiModelImpl.ENTITY_CACHE_ENABLED,
            QAChuDeCauHoiModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(QAChuDeCauHoiModelImpl.ENTITY_CACHE_ENABLED,
            QAChuDeCauHoiModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QAChuDeCauHoiModelImpl.ENTITY_CACHE_ENABLED,
            QAChuDeCauHoiModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(QAChuDeCauHoiPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.qa_chu_de.service.persistence.QAChuDeCauHoiPersistence.impl")
    protected com.nss.portlet.qa_chu_de.service.persistence.QAChuDeCauHoiPersistence qaChuDeCauHoiPersistence;

    public void cacheResult(QAChuDeCauHoi qaChuDeCauHoi) {
        EntityCacheUtil.putResult(QAChuDeCauHoiModelImpl.ENTITY_CACHE_ENABLED,
            QAChuDeCauHoiImpl.class, qaChuDeCauHoi.getPrimaryKey(),
            qaChuDeCauHoi);
    }

    public void cacheResult(List<QAChuDeCauHoi> qaChuDeCauHois) {
        for (QAChuDeCauHoi qaChuDeCauHoi : qaChuDeCauHois) {
            if (EntityCacheUtil.getResult(
                        QAChuDeCauHoiModelImpl.ENTITY_CACHE_ENABLED,
                        QAChuDeCauHoiImpl.class, qaChuDeCauHoi.getPrimaryKey(),
                        this) == null) {
                cacheResult(qaChuDeCauHoi);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(QAChuDeCauHoiImpl.class.getName());
        EntityCacheUtil.clearCache(QAChuDeCauHoiImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public QAChuDeCauHoi create(long maChuDeCauHoi) {
        QAChuDeCauHoi qaChuDeCauHoi = new QAChuDeCauHoiImpl();

        qaChuDeCauHoi.setNew(true);
        qaChuDeCauHoi.setPrimaryKey(maChuDeCauHoi);

        return qaChuDeCauHoi;
    }

    public QAChuDeCauHoi remove(long maChuDeCauHoi)
        throws NoSuchQAChuDeCauHoiException, SystemException {
        Session session = null;

        try {
            session = openSession();

            QAChuDeCauHoi qaChuDeCauHoi = (QAChuDeCauHoi) session.get(QAChuDeCauHoiImpl.class,
                    new Long(maChuDeCauHoi));

            if (qaChuDeCauHoi == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No QAChuDeCauHoi exists with the primary key " +
                        maChuDeCauHoi);
                }

                throw new NoSuchQAChuDeCauHoiException(
                    "No QAChuDeCauHoi exists with the primary key " +
                    maChuDeCauHoi);
            }

            return remove(qaChuDeCauHoi);
        } catch (NoSuchQAChuDeCauHoiException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public QAChuDeCauHoi remove(QAChuDeCauHoi qaChuDeCauHoi)
        throws SystemException {
        for (ModelListener<QAChuDeCauHoi> listener : listeners) {
            listener.onBeforeRemove(qaChuDeCauHoi);
        }

        qaChuDeCauHoi = removeImpl(qaChuDeCauHoi);

        for (ModelListener<QAChuDeCauHoi> listener : listeners) {
            listener.onAfterRemove(qaChuDeCauHoi);
        }

        return qaChuDeCauHoi;
    }

    protected QAChuDeCauHoi removeImpl(QAChuDeCauHoi qaChuDeCauHoi)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (qaChuDeCauHoi.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(QAChuDeCauHoiImpl.class,
                        qaChuDeCauHoi.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(qaChuDeCauHoi);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(QAChuDeCauHoiModelImpl.ENTITY_CACHE_ENABLED,
            QAChuDeCauHoiImpl.class, qaChuDeCauHoi.getPrimaryKey());

        return qaChuDeCauHoi;
    }

    /**
     * @deprecated Use <code>update(QAChuDeCauHoi qaChuDeCauHoi, boolean merge)</code>.
     */
    public QAChuDeCauHoi update(QAChuDeCauHoi qaChuDeCauHoi)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(QAChuDeCauHoi qaChuDeCauHoi) method. Use update(QAChuDeCauHoi qaChuDeCauHoi, boolean merge) instead.");
        }

        return update(qaChuDeCauHoi, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                qaChuDeCauHoi the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when qaChuDeCauHoi is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public QAChuDeCauHoi update(QAChuDeCauHoi qaChuDeCauHoi, boolean merge)
        throws SystemException {
        boolean isNew = qaChuDeCauHoi.isNew();

        for (ModelListener<QAChuDeCauHoi> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(qaChuDeCauHoi);
            } else {
                listener.onBeforeUpdate(qaChuDeCauHoi);
            }
        }

        qaChuDeCauHoi = updateImpl(qaChuDeCauHoi, merge);

        for (ModelListener<QAChuDeCauHoi> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(qaChuDeCauHoi);
            } else {
                listener.onAfterUpdate(qaChuDeCauHoi);
            }
        }

        return qaChuDeCauHoi;
    }

    public QAChuDeCauHoi updateImpl(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, qaChuDeCauHoi, merge);

            qaChuDeCauHoi.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(QAChuDeCauHoiModelImpl.ENTITY_CACHE_ENABLED,
            QAChuDeCauHoiImpl.class, qaChuDeCauHoi.getPrimaryKey(),
            qaChuDeCauHoi);

        return qaChuDeCauHoi;
    }

    public QAChuDeCauHoi findByPrimaryKey(long maChuDeCauHoi)
        throws NoSuchQAChuDeCauHoiException, SystemException {
        QAChuDeCauHoi qaChuDeCauHoi = fetchByPrimaryKey(maChuDeCauHoi);

        if (qaChuDeCauHoi == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No QAChuDeCauHoi exists with the primary key " +
                    maChuDeCauHoi);
            }

            throw new NoSuchQAChuDeCauHoiException(
                "No QAChuDeCauHoi exists with the primary key " +
                maChuDeCauHoi);
        }

        return qaChuDeCauHoi;
    }

    public QAChuDeCauHoi fetchByPrimaryKey(long maChuDeCauHoi)
        throws SystemException {
        QAChuDeCauHoi qaChuDeCauHoi = (QAChuDeCauHoi) EntityCacheUtil.getResult(QAChuDeCauHoiModelImpl.ENTITY_CACHE_ENABLED,
                QAChuDeCauHoiImpl.class, maChuDeCauHoi, this);

        if (qaChuDeCauHoi == null) {
            Session session = null;

            try {
                session = openSession();

                qaChuDeCauHoi = (QAChuDeCauHoi) session.get(QAChuDeCauHoiImpl.class,
                        new Long(maChuDeCauHoi));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (qaChuDeCauHoi != null) {
                    cacheResult(qaChuDeCauHoi);
                }

                closeSession(session);
            }
        }

        return qaChuDeCauHoi;
    }

    public List<QAChuDeCauHoi> findByActive(int active)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<QAChuDeCauHoi> list = (List<QAChuDeCauHoi>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tenChuDeCauHoi ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAChuDeCauHoi>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<QAChuDeCauHoi> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<QAChuDeCauHoi> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<QAChuDeCauHoi> list = (List<QAChuDeCauHoi>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenChuDeCauHoi ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<QAChuDeCauHoi>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAChuDeCauHoi>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public QAChuDeCauHoi findByActive_First(int active, OrderByComparator obc)
        throws NoSuchQAChuDeCauHoiException, SystemException {
        List<QAChuDeCauHoi> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAChuDeCauHoi exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAChuDeCauHoiException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAChuDeCauHoi findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchQAChuDeCauHoiException, SystemException {
        int count = countByActive(active);

        List<QAChuDeCauHoi> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QAChuDeCauHoi exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQAChuDeCauHoiException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QAChuDeCauHoi[] findByActive_PrevAndNext(long maChuDeCauHoi,
        int active, OrderByComparator obc)
        throws NoSuchQAChuDeCauHoiException, SystemException {
        QAChuDeCauHoi qaChuDeCauHoi = findByPrimaryKey(maChuDeCauHoi);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tenChuDeCauHoi ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    qaChuDeCauHoi);

            QAChuDeCauHoi[] array = new QAChuDeCauHoiImpl[3];

            array[0] = (QAChuDeCauHoi) objArray[0];
            array[1] = (QAChuDeCauHoi) objArray[1];
            array[2] = (QAChuDeCauHoi) objArray[2];

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

    public List<QAChuDeCauHoi> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<QAChuDeCauHoi> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<QAChuDeCauHoi> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<QAChuDeCauHoi> list = (List<QAChuDeCauHoi>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenChuDeCauHoi ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<QAChuDeCauHoi>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<QAChuDeCauHoi>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QAChuDeCauHoi>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (QAChuDeCauHoi qaChuDeCauHoi : findByActive(active)) {
            remove(qaChuDeCauHoi);
        }
    }

    public void removeAll() throws SystemException {
        for (QAChuDeCauHoi qaChuDeCauHoi : findAll()) {
            remove(qaChuDeCauHoi);
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
                    "FROM com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi WHERE ");

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
                        "SELECT COUNT(*) FROM com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi");

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
                        "value.object.listener.com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<QAChuDeCauHoi>> listenersList = new ArrayList<ModelListener<QAChuDeCauHoi>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<QAChuDeCauHoi>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
