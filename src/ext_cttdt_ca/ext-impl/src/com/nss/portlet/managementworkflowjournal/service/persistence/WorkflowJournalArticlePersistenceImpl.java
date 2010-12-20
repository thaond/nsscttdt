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

import com.nss.portlet.managementworkflowjournal.NoSuchWorkflowJournalArticleException;
import com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.model.impl.WorkflowJournalArticleImpl;
import com.nss.portlet.managementworkflowjournal.model.impl.WorkflowJournalArticleModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class WorkflowJournalArticlePersistenceImpl extends BasePersistenceImpl
    implements WorkflowJournalArticlePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = WorkflowJournalArticleImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FETCH_BY_RESOURCEPRIMKEY = new FinderPath(WorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            WorkflowJournalArticleModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_ENTITY, "fetchByResourcePrimkey",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_COUNT_BY_RESOURCEPRIMKEY = new FinderPath(WorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            WorkflowJournalArticleModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByResourcePrimkey",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_PROCESSINSTANCEID = new FinderPath(WorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            WorkflowJournalArticleModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_ENTITY, "fetchByProcessInstanceId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSINSTANCEID = new FinderPath(WorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            WorkflowJournalArticleModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByProcessInstanceId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(WorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            WorkflowJournalArticleModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            WorkflowJournalArticleModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(WorkflowJournalArticlePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.ManagementWorkflowJournalPersistence.impl")
    protected com.nss.portlet.managementworkflowjournal.service.persistence.ManagementWorkflowJournalPersistence managementWorkflowJournalPersistence;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticlePersistence.impl")
    protected com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticlePersistence workflowJournalArticlePersistence;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.LogWorkflowJournalArticlePersistence.impl")
    protected com.nss.portlet.managementworkflowjournal.service.persistence.LogWorkflowJournalArticlePersistence logWorkflowJournalArticlePersistence;

    public void cacheResult(WorkflowJournalArticle workflowJournalArticle) {
        EntityCacheUtil.putResult(WorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            WorkflowJournalArticleImpl.class,
            workflowJournalArticle.getPrimaryKey(), workflowJournalArticle);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESOURCEPRIMKEY,
            new Object[] { new Long(workflowJournalArticle.getResourcePrimkey()) },
            workflowJournalArticle);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSINSTANCEID,
            new Object[] { new Long(workflowJournalArticle.getProcessInstanceId()) },
            workflowJournalArticle);
    }

    public void cacheResult(
        List<WorkflowJournalArticle> workflowJournalArticles) {
        for (WorkflowJournalArticle workflowJournalArticle : workflowJournalArticles) {
            if (EntityCacheUtil.getResult(
                        WorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
                        WorkflowJournalArticleImpl.class,
                        workflowJournalArticle.getPrimaryKey(), this) == null) {
                cacheResult(workflowJournalArticle);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(WorkflowJournalArticleImpl.class.getName());
        EntityCacheUtil.clearCache(WorkflowJournalArticleImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public WorkflowJournalArticle create(long workflowJournalArticleId) {
        WorkflowJournalArticle workflowJournalArticle = new WorkflowJournalArticleImpl();

        workflowJournalArticle.setNew(true);
        workflowJournalArticle.setPrimaryKey(workflowJournalArticleId);

        return workflowJournalArticle;
    }

    public WorkflowJournalArticle remove(long workflowJournalArticleId)
        throws NoSuchWorkflowJournalArticleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            WorkflowJournalArticle workflowJournalArticle = (WorkflowJournalArticle) session.get(WorkflowJournalArticleImpl.class,
                    new Long(workflowJournalArticleId));

            if (workflowJournalArticle == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No WorkflowJournalArticle exists with the primary key " +
                        workflowJournalArticleId);
                }

                throw new NoSuchWorkflowJournalArticleException(
                    "No WorkflowJournalArticle exists with the primary key " +
                    workflowJournalArticleId);
            }

            return remove(workflowJournalArticle);
        } catch (NoSuchWorkflowJournalArticleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public WorkflowJournalArticle remove(
        WorkflowJournalArticle workflowJournalArticle)
        throws SystemException {
        for (ModelListener<WorkflowJournalArticle> listener : listeners) {
            listener.onBeforeRemove(workflowJournalArticle);
        }

        workflowJournalArticle = removeImpl(workflowJournalArticle);

        for (ModelListener<WorkflowJournalArticle> listener : listeners) {
            listener.onAfterRemove(workflowJournalArticle);
        }

        return workflowJournalArticle;
    }

    protected WorkflowJournalArticle removeImpl(
        WorkflowJournalArticle workflowJournalArticle)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (workflowJournalArticle.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(WorkflowJournalArticleImpl.class,
                        workflowJournalArticle.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(workflowJournalArticle);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        WorkflowJournalArticleModelImpl workflowJournalArticleModelImpl = (WorkflowJournalArticleModelImpl) workflowJournalArticle;

        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESOURCEPRIMKEY,
            new Object[] {
                new Long(workflowJournalArticleModelImpl.getOriginalResourcePrimkey())
            });

        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSINSTANCEID,
            new Object[] {
                new Long(workflowJournalArticleModelImpl.getOriginalProcessInstanceId())
            });

        EntityCacheUtil.removeResult(WorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            WorkflowJournalArticleImpl.class,
            workflowJournalArticle.getPrimaryKey());

        return workflowJournalArticle;
    }

    /**
     * @deprecated Use <code>update(WorkflowJournalArticle workflowJournalArticle, boolean merge)</code>.
     */
    public WorkflowJournalArticle update(
        WorkflowJournalArticle workflowJournalArticle)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(WorkflowJournalArticle workflowJournalArticle) method. Use update(WorkflowJournalArticle workflowJournalArticle, boolean merge) instead.");
        }

        return update(workflowJournalArticle, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                workflowJournalArticle the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when workflowJournalArticle is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public WorkflowJournalArticle update(
        WorkflowJournalArticle workflowJournalArticle, boolean merge)
        throws SystemException {
        boolean isNew = workflowJournalArticle.isNew();

        for (ModelListener<WorkflowJournalArticle> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(workflowJournalArticle);
            } else {
                listener.onBeforeUpdate(workflowJournalArticle);
            }
        }

        workflowJournalArticle = updateImpl(workflowJournalArticle, merge);

        for (ModelListener<WorkflowJournalArticle> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(workflowJournalArticle);
            } else {
                listener.onAfterUpdate(workflowJournalArticle);
            }
        }

        return workflowJournalArticle;
    }

    public WorkflowJournalArticle updateImpl(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle,
        boolean merge) throws SystemException {
        boolean isNew = workflowJournalArticle.isNew();

        WorkflowJournalArticleModelImpl workflowJournalArticleModelImpl = (WorkflowJournalArticleModelImpl) workflowJournalArticle;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, workflowJournalArticle, merge);

            workflowJournalArticle.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(WorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
            WorkflowJournalArticleImpl.class,
            workflowJournalArticle.getPrimaryKey(), workflowJournalArticle);

        if (!isNew &&
                (workflowJournalArticle.getResourcePrimkey() != workflowJournalArticleModelImpl.getOriginalResourcePrimkey())) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RESOURCEPRIMKEY,
                new Object[] {
                    new Long(workflowJournalArticleModelImpl.getOriginalResourcePrimkey())
                });
        }

        if (isNew ||
                (workflowJournalArticle.getResourcePrimkey() != workflowJournalArticleModelImpl.getOriginalResourcePrimkey())) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESOURCEPRIMKEY,
                new Object[] {
                    new Long(workflowJournalArticle.getResourcePrimkey())
                }, workflowJournalArticle);
        }

        if (!isNew &&
                (workflowJournalArticle.getProcessInstanceId() != workflowJournalArticleModelImpl.getOriginalProcessInstanceId())) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_PROCESSINSTANCEID,
                new Object[] {
                    new Long(workflowJournalArticleModelImpl.getOriginalProcessInstanceId())
                });
        }

        if (isNew ||
                (workflowJournalArticle.getProcessInstanceId() != workflowJournalArticleModelImpl.getOriginalProcessInstanceId())) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSINSTANCEID,
                new Object[] {
                    new Long(workflowJournalArticle.getProcessInstanceId())
                }, workflowJournalArticle);
        }

        return workflowJournalArticle;
    }

    public WorkflowJournalArticle findByPrimaryKey(
        long workflowJournalArticleId)
        throws NoSuchWorkflowJournalArticleException, SystemException {
        WorkflowJournalArticle workflowJournalArticle = fetchByPrimaryKey(workflowJournalArticleId);

        if (workflowJournalArticle == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No WorkflowJournalArticle exists with the primary key " +
                    workflowJournalArticleId);
            }

            throw new NoSuchWorkflowJournalArticleException(
                "No WorkflowJournalArticle exists with the primary key " +
                workflowJournalArticleId);
        }

        return workflowJournalArticle;
    }

    public WorkflowJournalArticle fetchByPrimaryKey(
        long workflowJournalArticleId) throws SystemException {
        WorkflowJournalArticle workflowJournalArticle = (WorkflowJournalArticle) EntityCacheUtil.getResult(WorkflowJournalArticleModelImpl.ENTITY_CACHE_ENABLED,
                WorkflowJournalArticleImpl.class, workflowJournalArticleId, this);

        if (workflowJournalArticle == null) {
            Session session = null;

            try {
                session = openSession();

                workflowJournalArticle = (WorkflowJournalArticle) session.get(WorkflowJournalArticleImpl.class,
                        new Long(workflowJournalArticleId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (workflowJournalArticle != null) {
                    cacheResult(workflowJournalArticle);
                }

                closeSession(session);
            }
        }

        return workflowJournalArticle;
    }

    public WorkflowJournalArticle findByResourcePrimkey(long resourcePrimkey)
        throws NoSuchWorkflowJournalArticleException, SystemException {
        WorkflowJournalArticle workflowJournalArticle = fetchByResourcePrimkey(resourcePrimkey);

        if (workflowJournalArticle == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No WorkflowJournalArticle exists with the key {");

            msg.append("resourcePrimkey=" + resourcePrimkey);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchWorkflowJournalArticleException(msg.toString());
        }

        return workflowJournalArticle;
    }

    public WorkflowJournalArticle fetchByResourcePrimkey(long resourcePrimkey)
        throws SystemException {
        return fetchByResourcePrimkey(resourcePrimkey, true);
    }

    public WorkflowJournalArticle fetchByResourcePrimkey(long resourcePrimkey,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(resourcePrimkey) };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RESOURCEPRIMKEY,
                    finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle WHERE ");

                query.append("resourcePrimkey = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("resourcePrimkey ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(resourcePrimkey);

                List<WorkflowJournalArticle> list = q.list();

                result = list;

                WorkflowJournalArticle workflowJournalArticle = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESOURCEPRIMKEY,
                        finderArgs, list);
                } else {
                    workflowJournalArticle = list.get(0);

                    cacheResult(workflowJournalArticle);

                    if ((workflowJournalArticle.getResourcePrimkey() != resourcePrimkey)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESOURCEPRIMKEY,
                            finderArgs, workflowJournalArticle);
                    }
                }

                return workflowJournalArticle;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RESOURCEPRIMKEY,
                        finderArgs, new ArrayList<WorkflowJournalArticle>());
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List) {
                return null;
            } else {
                return (WorkflowJournalArticle) result;
            }
        }
    }

    public WorkflowJournalArticle findByProcessInstanceId(
        long processInstanceId)
        throws NoSuchWorkflowJournalArticleException, SystemException {
        WorkflowJournalArticle workflowJournalArticle = fetchByProcessInstanceId(processInstanceId);

        if (workflowJournalArticle == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No WorkflowJournalArticle exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchWorkflowJournalArticleException(msg.toString());
        }

        return workflowJournalArticle;
    }

    public WorkflowJournalArticle fetchByProcessInstanceId(
        long processInstanceId) throws SystemException {
        return fetchByProcessInstanceId(processInstanceId, true);
    }

    public WorkflowJournalArticle fetchByProcessInstanceId(
        long processInstanceId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(processInstanceId) };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_PROCESSINSTANCEID,
                    finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle WHERE ");

                query.append("processInstanceId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("resourcePrimkey ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                List<WorkflowJournalArticle> list = q.list();

                result = list;

                WorkflowJournalArticle workflowJournalArticle = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSINSTANCEID,
                        finderArgs, list);
                } else {
                    workflowJournalArticle = list.get(0);

                    cacheResult(workflowJournalArticle);

                    if ((workflowJournalArticle.getProcessInstanceId() != processInstanceId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSINSTANCEID,
                            finderArgs, workflowJournalArticle);
                    }
                }

                return workflowJournalArticle;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_PROCESSINSTANCEID,
                        finderArgs, new ArrayList<WorkflowJournalArticle>());
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List) {
                return null;
            } else {
                return (WorkflowJournalArticle) result;
            }
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

    public List<WorkflowJournalArticle> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<WorkflowJournalArticle> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<WorkflowJournalArticle> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<WorkflowJournalArticle> list = (List<WorkflowJournalArticle>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle ");

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
                    list = (List<WorkflowJournalArticle>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<WorkflowJournalArticle>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<WorkflowJournalArticle>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByResourcePrimkey(long resourcePrimkey)
        throws NoSuchWorkflowJournalArticleException, SystemException {
        WorkflowJournalArticle workflowJournalArticle = findByResourcePrimkey(resourcePrimkey);

        remove(workflowJournalArticle);
    }

    public void removeByProcessInstanceId(long processInstanceId)
        throws NoSuchWorkflowJournalArticleException, SystemException {
        WorkflowJournalArticle workflowJournalArticle = findByProcessInstanceId(processInstanceId);

        remove(workflowJournalArticle);
    }

    public void removeAll() throws SystemException {
        for (WorkflowJournalArticle workflowJournalArticle : findAll()) {
            remove(workflowJournalArticle);
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
                    "FROM com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle WHERE ");

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

    public int countByProcessInstanceId(long processInstanceId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(processInstanceId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROCESSINSTANCEID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle WHERE ");

                query.append("processInstanceId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSINSTANCEID,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle");

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
                        "value.object.listener.com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<WorkflowJournalArticle>> listenersList = new ArrayList<ModelListener<WorkflowJournalArticle>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<WorkflowJournalArticle>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
