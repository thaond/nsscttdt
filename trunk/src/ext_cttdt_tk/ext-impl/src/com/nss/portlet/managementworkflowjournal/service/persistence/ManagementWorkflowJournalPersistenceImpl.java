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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.managementworkflowjournal.NoSuchManagementWorkflowJournalException;
import com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal;
import com.nss.portlet.managementworkflowjournal.model.impl.ManagementWorkflowJournalImpl;
import com.nss.portlet.managementworkflowjournal.model.impl.ManagementWorkflowJournalModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ManagementWorkflowJournalPersistenceImpl
    extends BasePersistenceImpl implements ManagementWorkflowJournalPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = ManagementWorkflowJournalImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FETCH_BY_WORKFLOWNAME_VERSION = new FinderPath(ManagementWorkflowJournalModelImpl.ENTITY_CACHE_ENABLED,
            ManagementWorkflowJournalModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_ENTITY, "fetchByWorkflowname_Version",
            new String[] { String.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_COUNT_BY_WORKFLOWNAME_VERSION = new FinderPath(ManagementWorkflowJournalModelImpl.ENTITY_CACHE_ENABLED,
            ManagementWorkflowJournalModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByWorkflowname_Version",
            new String[] { String.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ManagementWorkflowJournalModelImpl.ENTITY_CACHE_ENABLED,
            ManagementWorkflowJournalModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ManagementWorkflowJournalModelImpl.ENTITY_CACHE_ENABLED,
            ManagementWorkflowJournalModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(ManagementWorkflowJournalPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.ManagementWorkflowJournalPersistence.impl")
    protected com.nss.portlet.managementworkflowjournal.service.persistence.ManagementWorkflowJournalPersistence managementWorkflowJournalPersistence;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticlePersistence.impl")
    protected com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticlePersistence workflowJournalArticlePersistence;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.LogWorkflowJournalArticlePersistence.impl")
    protected com.nss.portlet.managementworkflowjournal.service.persistence.LogWorkflowJournalArticlePersistence logWorkflowJournalArticlePersistence;

    public void cacheResult(ManagementWorkflowJournal managementWorkflowJournal) {
        EntityCacheUtil.putResult(ManagementWorkflowJournalModelImpl.ENTITY_CACHE_ENABLED,
            ManagementWorkflowJournalImpl.class,
            managementWorkflowJournal.getPrimaryKey(), managementWorkflowJournal);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORKFLOWNAME_VERSION,
            new Object[] {
                managementWorkflowJournal.getWorkflowname(),
                new Integer(managementWorkflowJournal.getVersion_())
            }, managementWorkflowJournal);
    }

    public void cacheResult(
        List<ManagementWorkflowJournal> managementWorkflowJournals) {
        for (ManagementWorkflowJournal managementWorkflowJournal : managementWorkflowJournals) {
            if (EntityCacheUtil.getResult(
                        ManagementWorkflowJournalModelImpl.ENTITY_CACHE_ENABLED,
                        ManagementWorkflowJournalImpl.class,
                        managementWorkflowJournal.getPrimaryKey(), this) == null) {
                cacheResult(managementWorkflowJournal);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(ManagementWorkflowJournalImpl.class.getName());
        EntityCacheUtil.clearCache(ManagementWorkflowJournalImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public ManagementWorkflowJournal create(long managementWorkflowJournalId) {
        ManagementWorkflowJournal managementWorkflowJournal = new ManagementWorkflowJournalImpl();

        managementWorkflowJournal.setNew(true);
        managementWorkflowJournal.setPrimaryKey(managementWorkflowJournalId);

        return managementWorkflowJournal;
    }

    public ManagementWorkflowJournal remove(long managementWorkflowJournalId)
        throws NoSuchManagementWorkflowJournalException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ManagementWorkflowJournal managementWorkflowJournal = (ManagementWorkflowJournal) session.get(ManagementWorkflowJournalImpl.class,
                    new Long(managementWorkflowJournalId));

            if (managementWorkflowJournal == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No ManagementWorkflowJournal exists with the primary key " +
                        managementWorkflowJournalId);
                }

                throw new NoSuchManagementWorkflowJournalException(
                    "No ManagementWorkflowJournal exists with the primary key " +
                    managementWorkflowJournalId);
            }

            return remove(managementWorkflowJournal);
        } catch (NoSuchManagementWorkflowJournalException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public ManagementWorkflowJournal remove(
        ManagementWorkflowJournal managementWorkflowJournal)
        throws SystemException {
        for (ModelListener<ManagementWorkflowJournal> listener : listeners) {
            listener.onBeforeRemove(managementWorkflowJournal);
        }

        managementWorkflowJournal = removeImpl(managementWorkflowJournal);

        for (ModelListener<ManagementWorkflowJournal> listener : listeners) {
            listener.onAfterRemove(managementWorkflowJournal);
        }

        return managementWorkflowJournal;
    }

    protected ManagementWorkflowJournal removeImpl(
        ManagementWorkflowJournal managementWorkflowJournal)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (managementWorkflowJournal.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(ManagementWorkflowJournalImpl.class,
                        managementWorkflowJournal.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(managementWorkflowJournal);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        ManagementWorkflowJournalModelImpl managementWorkflowJournalModelImpl = (ManagementWorkflowJournalModelImpl) managementWorkflowJournal;

        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORKFLOWNAME_VERSION,
            new Object[] {
                managementWorkflowJournalModelImpl.getOriginalWorkflowname(),
                new Integer(managementWorkflowJournalModelImpl.getOriginalVersion_())
            });

        EntityCacheUtil.removeResult(ManagementWorkflowJournalModelImpl.ENTITY_CACHE_ENABLED,
            ManagementWorkflowJournalImpl.class,
            managementWorkflowJournal.getPrimaryKey());

        return managementWorkflowJournal;
    }

    /**
     * @deprecated Use <code>update(ManagementWorkflowJournal managementWorkflowJournal, boolean merge)</code>.
     */
    public ManagementWorkflowJournal update(
        ManagementWorkflowJournal managementWorkflowJournal)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(ManagementWorkflowJournal managementWorkflowJournal) method. Use update(ManagementWorkflowJournal managementWorkflowJournal, boolean merge) instead.");
        }

        return update(managementWorkflowJournal, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                managementWorkflowJournal the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when managementWorkflowJournal is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public ManagementWorkflowJournal update(
        ManagementWorkflowJournal managementWorkflowJournal, boolean merge)
        throws SystemException {
        boolean isNew = managementWorkflowJournal.isNew();

        for (ModelListener<ManagementWorkflowJournal> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(managementWorkflowJournal);
            } else {
                listener.onBeforeUpdate(managementWorkflowJournal);
            }
        }

        managementWorkflowJournal = updateImpl(managementWorkflowJournal, merge);

        for (ModelListener<ManagementWorkflowJournal> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(managementWorkflowJournal);
            } else {
                listener.onAfterUpdate(managementWorkflowJournal);
            }
        }

        return managementWorkflowJournal;
    }

    public ManagementWorkflowJournal updateImpl(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal,
        boolean merge) throws SystemException {
        boolean isNew = managementWorkflowJournal.isNew();

        ManagementWorkflowJournalModelImpl managementWorkflowJournalModelImpl = (ManagementWorkflowJournalModelImpl) managementWorkflowJournal;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, managementWorkflowJournal, merge);

            managementWorkflowJournal.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(ManagementWorkflowJournalModelImpl.ENTITY_CACHE_ENABLED,
            ManagementWorkflowJournalImpl.class,
            managementWorkflowJournal.getPrimaryKey(), managementWorkflowJournal);

        if (!isNew &&
                (!Validator.equals(
                    managementWorkflowJournal.getWorkflowname(),
                    managementWorkflowJournalModelImpl.getOriginalWorkflowname()) ||
                (managementWorkflowJournal.getVersion_() != managementWorkflowJournalModelImpl.getOriginalVersion_()))) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_WORKFLOWNAME_VERSION,
                new Object[] {
                    managementWorkflowJournalModelImpl.getOriginalWorkflowname(),
                    new Integer(managementWorkflowJournalModelImpl.getOriginalVersion_())
                });
        }

        if (isNew ||
                (!Validator.equals(
                    managementWorkflowJournal.getWorkflowname(),
                    managementWorkflowJournalModelImpl.getOriginalWorkflowname()) ||
                (managementWorkflowJournal.getVersion_() != managementWorkflowJournalModelImpl.getOriginalVersion_()))) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORKFLOWNAME_VERSION,
                new Object[] {
                    managementWorkflowJournal.getWorkflowname(),
                    new Integer(managementWorkflowJournal.getVersion_())
                }, managementWorkflowJournal);
        }

        return managementWorkflowJournal;
    }

    public ManagementWorkflowJournal findByPrimaryKey(
        long managementWorkflowJournalId)
        throws NoSuchManagementWorkflowJournalException, SystemException {
        ManagementWorkflowJournal managementWorkflowJournal = fetchByPrimaryKey(managementWorkflowJournalId);

        if (managementWorkflowJournal == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No ManagementWorkflowJournal exists with the primary key " +
                    managementWorkflowJournalId);
            }

            throw new NoSuchManagementWorkflowJournalException(
                "No ManagementWorkflowJournal exists with the primary key " +
                managementWorkflowJournalId);
        }

        return managementWorkflowJournal;
    }

    public ManagementWorkflowJournal fetchByPrimaryKey(
        long managementWorkflowJournalId) throws SystemException {
        ManagementWorkflowJournal managementWorkflowJournal = (ManagementWorkflowJournal) EntityCacheUtil.getResult(ManagementWorkflowJournalModelImpl.ENTITY_CACHE_ENABLED,
                ManagementWorkflowJournalImpl.class,
                managementWorkflowJournalId, this);

        if (managementWorkflowJournal == null) {
            Session session = null;

            try {
                session = openSession();

                managementWorkflowJournal = (ManagementWorkflowJournal) session.get(ManagementWorkflowJournalImpl.class,
                        new Long(managementWorkflowJournalId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (managementWorkflowJournal != null) {
                    cacheResult(managementWorkflowJournal);
                }

                closeSession(session);
            }
        }

        return managementWorkflowJournal;
    }

    public ManagementWorkflowJournal findByWorkflowname_Version(
        String workflowname, int version_)
        throws NoSuchManagementWorkflowJournalException, SystemException {
        ManagementWorkflowJournal managementWorkflowJournal = fetchByWorkflowname_Version(workflowname,
                version_);

        if (managementWorkflowJournal == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ManagementWorkflowJournal exists with the key {");

            msg.append("workflowname=" + workflowname);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchManagementWorkflowJournalException(msg.toString());
        }

        return managementWorkflowJournal;
    }

    public ManagementWorkflowJournal fetchByWorkflowname_Version(
        String workflowname, int version_) throws SystemException {
        return fetchByWorkflowname_Version(workflowname, version_, true);
    }

    public ManagementWorkflowJournal fetchByWorkflowname_Version(
        String workflowname, int version_, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { workflowname, new Integer(version_) };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_WORKFLOWNAME_VERSION,
                    finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal WHERE ");

                if (workflowname == null) {
                    query.append("workflowname LIKE null");
                } else {
                    query.append("workflowname LIKE ?");
                }

                query.append(" AND ");

                query.append("version_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("version_ ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflowname != null) {
                    qPos.add(workflowname);
                }

                qPos.add(version_);

                List<ManagementWorkflowJournal> list = q.list();

                result = list;

                ManagementWorkflowJournal managementWorkflowJournal = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORKFLOWNAME_VERSION,
                        finderArgs, list);
                } else {
                    managementWorkflowJournal = list.get(0);

                    cacheResult(managementWorkflowJournal);

                    if ((managementWorkflowJournal.getWorkflowname() == null) ||
                            !managementWorkflowJournal.getWorkflowname()
                                                          .equals(workflowname) ||
                            (managementWorkflowJournal.getVersion_() != version_)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORKFLOWNAME_VERSION,
                            finderArgs, managementWorkflowJournal);
                    }
                }

                return managementWorkflowJournal;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_WORKFLOWNAME_VERSION,
                        finderArgs, new ArrayList<ManagementWorkflowJournal>());
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List) {
                return null;
            } else {
                return (ManagementWorkflowJournal) result;
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

    public List<ManagementWorkflowJournal> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<ManagementWorkflowJournal> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<ManagementWorkflowJournal> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<ManagementWorkflowJournal> list = (List<ManagementWorkflowJournal>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("version_ ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<ManagementWorkflowJournal>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ManagementWorkflowJournal>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ManagementWorkflowJournal>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByWorkflowname_Version(String workflowname, int version_)
        throws NoSuchManagementWorkflowJournalException, SystemException {
        ManagementWorkflowJournal managementWorkflowJournal = findByWorkflowname_Version(workflowname,
                version_);

        remove(managementWorkflowJournal);
    }

    public void removeAll() throws SystemException {
        for (ManagementWorkflowJournal managementWorkflowJournal : findAll()) {
            remove(managementWorkflowJournal);
        }
    }

    public int countByWorkflowname_Version(String workflowname, int version_)
        throws SystemException {
        Object[] finderArgs = new Object[] { workflowname, new Integer(version_) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WORKFLOWNAME_VERSION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal WHERE ");

                if (workflowname == null) {
                    query.append("workflowname LIKE null");
                } else {
                    query.append("workflowname LIKE ?");
                }

                query.append(" AND ");

                query.append("version_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflowname != null) {
                    qPos.add(workflowname);
                }

                qPos.add(version_);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WORKFLOWNAME_VERSION,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal");

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
                        "value.object.listener.com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ManagementWorkflowJournal>> listenersList = new ArrayList<ModelListener<ManagementWorkflowJournal>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ManagementWorkflowJournal>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
