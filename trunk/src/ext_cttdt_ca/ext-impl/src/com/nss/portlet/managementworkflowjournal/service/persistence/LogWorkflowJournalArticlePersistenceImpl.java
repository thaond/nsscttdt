package com.nss.portlet.managementworkflowjournal.service.persistence;

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

import com.nss.portlet.managementworkflowjournal.NoSuchLogWorkflowJournalArticleException;
import com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.model.impl.LogWorkflowJournalArticleImpl;
import com.nss.portlet.managementworkflowjournal.model.impl.LogWorkflowJournalArticleModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LogWorkflowJournalArticlePersistenceImpl
    extends BasePersistenceImpl implements LogWorkflowJournalArticlePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = LogWorkflowJournalArticleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_RESOURCEPRIMKEY = new FinderPath(LogWorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            LogWorkflowJournalArticleModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByResourcePrimkey",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_RESOURCEPRIMKEY = new FinderPath(LogWorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            LogWorkflowJournalArticleModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByResourcePrimkey",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_RESOURCEPRIMKEY = new FinderPath(LogWorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            LogWorkflowJournalArticleModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByResourcePrimkey",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LogWorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            LogWorkflowJournalArticleModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LogWorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            LogWorkflowJournalArticleModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(LogWorkflowJournalArticlePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.ManagementWorkflowJournalPersistence.impl")
    protected com.nss.portlet.managementworkflowjournal.service.persistence.ManagementWorkflowJournalPersistence managementWorkflowJournalPersistence;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticlePersistence.impl")
    protected com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticlePersistence workflowJournalArticlePersistence;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.LogWorkflowJournalArticlePersistence.impl")
    protected com.nss.portlet.managementworkflowjournal.service.persistence.LogWorkflowJournalArticlePersistence logWorkflowJournalArticlePersistence;

    public void cacheResult(LogWorkflowJournalArticle logWorkflowJournalArticle) {
        EntityCacheUtil.putResult(LogWorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            LogWorkflowJournalArticleImpl.class,
            logWorkflowJournalArticle.getPrimaryKey(), logWorkflowJournalArticle);
    }

    public void cacheResult(
        List<LogWorkflowJournalArticle> logWorkflowJournalArticles) {
        for (LogWorkflowJournalArticle logWorkflowJournalArticle : logWorkflowJournalArticles) {
            if (EntityCacheUtil.getResult(
                        LogWorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
                        LogWorkflowJournalArticleImpl.class,
                        logWorkflowJournalArticle.getPrimaryKey(), this) == null) {
                cacheResult(logWorkflowJournalArticle);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(LogWorkflowJournalArticleImpl.class.getName());
        EntityCacheUtil.clearCache(LogWorkflowJournalArticleImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public LogWorkflowJournalArticle create(long logWorkflowJournalArticleId) {
        LogWorkflowJournalArticle logWorkflowJournalArticle = new LogWorkflowJournalArticleImpl();

        logWorkflowJournalArticle.setNew(true);
        logWorkflowJournalArticle.setPrimaryKey(logWorkflowJournalArticleId);

        return logWorkflowJournalArticle;
    }

    public LogWorkflowJournalArticle remove(long logWorkflowJournalArticleId)
        throws NoSuchLogWorkflowJournalArticleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LogWorkflowJournalArticle logWorkflowJournalArticle = (LogWorkflowJournalArticle) session.get(LogWorkflowJournalArticleImpl.class,
                    new Long(logWorkflowJournalArticleId));

            if (logWorkflowJournalArticle == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No LogWorkflowJournalArticle exists with the primary key " +
                        logWorkflowJournalArticleId);
                }

                throw new NoSuchLogWorkflowJournalArticleException(
                    "No LogWorkflowJournalArticle exists with the primary key " +
                    logWorkflowJournalArticleId);
            }

            return remove(logWorkflowJournalArticle);
        } catch (NoSuchLogWorkflowJournalArticleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public LogWorkflowJournalArticle remove(
        LogWorkflowJournalArticle logWorkflowJournalArticle)
        throws SystemException {
        for (ModelListener<LogWorkflowJournalArticle> listener : listeners) {
            listener.onBeforeRemove(logWorkflowJournalArticle);
        }

        logWorkflowJournalArticle = removeImpl(logWorkflowJournalArticle);

        for (ModelListener<LogWorkflowJournalArticle> listener : listeners) {
            listener.onAfterRemove(logWorkflowJournalArticle);
        }

        return logWorkflowJournalArticle;
    }

    protected LogWorkflowJournalArticle removeImpl(
        LogWorkflowJournalArticle logWorkflowJournalArticle)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (logWorkflowJournalArticle.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(LogWorkflowJournalArticleImpl.class,
                        logWorkflowJournalArticle.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(logWorkflowJournalArticle);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(LogWorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            LogWorkflowJournalArticleImpl.class,
            logWorkflowJournalArticle.getPrimaryKey());

        return logWorkflowJournalArticle;
    }

    /**
     * @deprecated Use <code>update(LogWorkflowJournalArticle logWorkflowJournalArticle, boolean merge)</code>.
     */
    public LogWorkflowJournalArticle update(
        LogWorkflowJournalArticle logWorkflowJournalArticle)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(LogWorkflowJournalArticle logWorkflowJournalArticle) method. Use update(LogWorkflowJournalArticle logWorkflowJournalArticle, boolean merge) instead.");
        }

        return update(logWorkflowJournalArticle, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                logWorkflowJournalArticle the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when logWorkflowJournalArticle is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public LogWorkflowJournalArticle update(
        LogWorkflowJournalArticle logWorkflowJournalArticle, boolean merge)
        throws SystemException {
        boolean isNew = logWorkflowJournalArticle.isNew();

        for (ModelListener<LogWorkflowJournalArticle> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(logWorkflowJournalArticle);
            } else {
                listener.onBeforeUpdate(logWorkflowJournalArticle);
            }
        }

        logWorkflowJournalArticle = updateImpl(logWorkflowJournalArticle, merge);

        for (ModelListener<LogWorkflowJournalArticle> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(logWorkflowJournalArticle);
            } else {
                listener.onAfterUpdate(logWorkflowJournalArticle);
            }
        }

        return logWorkflowJournalArticle;
    }

    public LogWorkflowJournalArticle updateImpl(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, logWorkflowJournalArticle, merge);

            logWorkflowJournalArticle.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(LogWorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            LogWorkflowJournalArticleImpl.class,
            logWorkflowJournalArticle.getPrimaryKey(), logWorkflowJournalArticle);

        return logWorkflowJournalArticle;
    }

    public LogWorkflowJournalArticle findByPrimaryKey(
        long logWorkflowJournalArticleId)
        throws NoSuchLogWorkflowJournalArticleException, SystemException {
        LogWorkflowJournalArticle logWorkflowJournalArticle = fetchByPrimaryKey(logWorkflowJournalArticleId);

        if (logWorkflowJournalArticle == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No LogWorkflowJournalArticle exists with the primary key " +
                    logWorkflowJournalArticleId);
            }

            throw new NoSuchLogWorkflowJournalArticleException(
                "No LogWorkflowJournalArticle exists with the primary key " +
                logWorkflowJournalArticleId);
        }

        return logWorkflowJournalArticle;
    }

    public LogWorkflowJournalArticle fetchByPrimaryKey(
        long logWorkflowJournalArticleId) throws SystemException {
        LogWorkflowJournalArticle logWorkflowJournalArticle = (LogWorkflowJournalArticle) EntityCacheUtil.getResult(LogWorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
                LogWorkflowJournalArticleImpl.class,
                logWorkflowJournalArticleId, this);

        if (logWorkflowJournalArticle == null) {
            Session session = null;

            try {
                session = openSession();

                logWorkflowJournalArticle = (LogWorkflowJournalArticle) session.get(LogWorkflowJournalArticleImpl.class,
                        new Long(logWorkflowJournalArticleId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (logWorkflowJournalArticle != null) {
                    cacheResult(logWorkflowJournalArticle);
                }

                closeSession(session);
            }
        }

        return logWorkflowJournalArticle;
    }

    public List<LogWorkflowJournalArticle> findByResourcePrimkey(
        long resourcePrimkey) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(resourcePrimkey) };

        List<LogWorkflowJournalArticle> list = (List<LogWorkflowJournalArticle>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_RESOURCEPRIMKEY,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle WHERE ");

                query.append("resourcePrimkey = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("resourcePrimkey ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(resourcePrimkey);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LogWorkflowJournalArticle>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_RESOURCEPRIMKEY,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<LogWorkflowJournalArticle> findByResourcePrimkey(
        long resourcePrimkey, int start, int end) throws SystemException {
        return findByResourcePrimkey(resourcePrimkey, start, end, null);
    }

    public List<LogWorkflowJournalArticle> findByResourcePrimkey(
        long resourcePrimkey, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(resourcePrimkey),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LogWorkflowJournalArticle> list = (List<LogWorkflowJournalArticle>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_RESOURCEPRIMKEY,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle WHERE ");

                query.append("resourcePrimkey = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("resourcePrimkey ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(resourcePrimkey);

                list = (List<LogWorkflowJournalArticle>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LogWorkflowJournalArticle>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_RESOURCEPRIMKEY,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public LogWorkflowJournalArticle findByResourcePrimkey_First(
        long resourcePrimkey, OrderByComparator obc)
        throws NoSuchLogWorkflowJournalArticleException, SystemException {
        List<LogWorkflowJournalArticle> list = findByResourcePrimkey(resourcePrimkey,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LogWorkflowJournalArticle exists with the key {");

            msg.append("resourcePrimkey=" + resourcePrimkey);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLogWorkflowJournalArticleException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LogWorkflowJournalArticle findByResourcePrimkey_Last(
        long resourcePrimkey, OrderByComparator obc)
        throws NoSuchLogWorkflowJournalArticleException, SystemException {
        int count = countByResourcePrimkey(resourcePrimkey);

        List<LogWorkflowJournalArticle> list = findByResourcePrimkey(resourcePrimkey,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LogWorkflowJournalArticle exists with the key {");

            msg.append("resourcePrimkey=" + resourcePrimkey);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLogWorkflowJournalArticleException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LogWorkflowJournalArticle[] findByResourcePrimkey_PrevAndNext(
        long logWorkflowJournalArticleId, long resourcePrimkey,
        OrderByComparator obc)
        throws NoSuchLogWorkflowJournalArticleException, SystemException {
        LogWorkflowJournalArticle logWorkflowJournalArticle = findByPrimaryKey(logWorkflowJournalArticleId);

        int count = countByResourcePrimkey(resourcePrimkey);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle WHERE ");

            query.append("resourcePrimkey = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("resourcePrimkey ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(resourcePrimkey);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    logWorkflowJournalArticle);

            LogWorkflowJournalArticle[] array = new LogWorkflowJournalArticleImpl[3];

            array[0] = (LogWorkflowJournalArticle) objArray[0];
            array[1] = (LogWorkflowJournalArticle) objArray[1];
            array[2] = (LogWorkflowJournalArticle) objArray[2];

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

    public List<LogWorkflowJournalArticle> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<LogWorkflowJournalArticle> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<LogWorkflowJournalArticle> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LogWorkflowJournalArticle> list = (List<LogWorkflowJournalArticle>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("resourcePrimkey ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<LogWorkflowJournalArticle>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LogWorkflowJournalArticle>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LogWorkflowJournalArticle>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByResourcePrimkey(long resourcePrimkey)
        throws SystemException {
        for (LogWorkflowJournalArticle logWorkflowJournalArticle : findByResourcePrimkey(
                resourcePrimkey)) {
            remove(logWorkflowJournalArticle);
        }
    }

    public void removeAll() throws SystemException {
        for (LogWorkflowJournalArticle logWorkflowJournalArticle : findAll()) {
            remove(logWorkflowJournalArticle);
        }
    }

    public int countByResourcePrimkey(long resourcePrimkey)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(resourcePrimkey) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RESOURCEPRIMKEY,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle WHERE ");

                query.append("resourcePrimkey = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(resourcePrimkey);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RESOURCEPRIMKEY,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle");

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
                        "value.object.listener.com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LogWorkflowJournalArticle>> listenersList = new ArrayList<ModelListener<LogWorkflowJournalArticle>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LogWorkflowJournalArticle>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
