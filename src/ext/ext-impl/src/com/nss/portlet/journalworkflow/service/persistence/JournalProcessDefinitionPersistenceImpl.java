package com.nss.portlet.journalworkflow.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.journalworkflow.NoSuchJournalProcessDefinitionException;
import com.nss.portlet.journalworkflow.model.JournalProcessDefinition;
import com.nss.portlet.journalworkflow.model.impl.JournalProcessDefinitionImpl;
import com.nss.portlet.journalworkflow.model.impl.JournalProcessDefinitionModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class JournalProcessDefinitionPersistenceImpl extends BasePersistenceImpl
    implements JournalProcessDefinitionPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = JournalProcessDefinitionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(JournalProcessDefinitionModelImpl.ENTITY_CACHE_ENABLED,
            JournalProcessDefinitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(JournalProcessDefinitionModelImpl.ENTITY_CACHE_ENABLED,
            JournalProcessDefinitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(JournalProcessDefinitionPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.journalworkflow.service.persistence.JournalProcessDefinitionPersistence.impl")
    protected com.nss.portlet.journalworkflow.service.persistence.JournalProcessDefinitionPersistence journalProcessDefinitionPersistence;
    @BeanReference(name = "com.nss.portlet.journalworkflow.service.persistence.InstanceBeanPersistence.impl")
    protected com.nss.portlet.journalworkflow.service.persistence.InstanceBeanPersistence instanceBeanPersistence;

    public void cacheResult(JournalProcessDefinition journalProcessDefinition) {
        EntityCacheUtil.putResult(JournalProcessDefinitionModelImpl.ENTITY_CACHE_ENABLED,
            JournalProcessDefinitionImpl.class,
            journalProcessDefinition.getPrimaryKey(), journalProcessDefinition);
    }

    public void cacheResult(
        List<JournalProcessDefinition> journalProcessDefinitions) {
        for (JournalProcessDefinition journalProcessDefinition : journalProcessDefinitions) {
            if (EntityCacheUtil.getResult(
                        JournalProcessDefinitionModelImpl.ENTITY_CACHE_ENABLED,
                        JournalProcessDefinitionImpl.class,
                        journalProcessDefinition.getPrimaryKey(), this) == null) {
                cacheResult(journalProcessDefinition);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(JournalProcessDefinitionImpl.class.getName());
        EntityCacheUtil.clearCache(JournalProcessDefinitionImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public JournalProcessDefinition create(long journalProcessDefinitionId) {
        JournalProcessDefinition journalProcessDefinition = new JournalProcessDefinitionImpl();

        journalProcessDefinition.setNew(true);
        journalProcessDefinition.setPrimaryKey(journalProcessDefinitionId);

        return journalProcessDefinition;
    }

    public JournalProcessDefinition remove(long journalProcessDefinitionId)
        throws NoSuchJournalProcessDefinitionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            JournalProcessDefinition journalProcessDefinition = (JournalProcessDefinition) session.get(JournalProcessDefinitionImpl.class,
                    new Long(journalProcessDefinitionId));

            if (journalProcessDefinition == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No JournalProcessDefinition exists with the primary key " +
                        journalProcessDefinitionId);
                }

                throw new NoSuchJournalProcessDefinitionException(
                    "No JournalProcessDefinition exists with the primary key " +
                    journalProcessDefinitionId);
            }

            return remove(journalProcessDefinition);
        } catch (NoSuchJournalProcessDefinitionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public JournalProcessDefinition remove(
        JournalProcessDefinition journalProcessDefinition)
        throws SystemException {
        for (ModelListener<JournalProcessDefinition> listener : listeners) {
            listener.onBeforeRemove(journalProcessDefinition);
        }

        journalProcessDefinition = removeImpl(journalProcessDefinition);

        for (ModelListener<JournalProcessDefinition> listener : listeners) {
            listener.onAfterRemove(journalProcessDefinition);
        }

        return journalProcessDefinition;
    }

    protected JournalProcessDefinition removeImpl(
        JournalProcessDefinition journalProcessDefinition)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (journalProcessDefinition.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(JournalProcessDefinitionImpl.class,
                        journalProcessDefinition.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(journalProcessDefinition);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(JournalProcessDefinitionModelImpl.ENTITY_CACHE_ENABLED,
            JournalProcessDefinitionImpl.class,
            journalProcessDefinition.getPrimaryKey());

        return journalProcessDefinition;
    }

    /**
     * @deprecated Use <code>update(JournalProcessDefinition journalProcessDefinition, boolean merge)</code>.
     */
    public JournalProcessDefinition update(
        JournalProcessDefinition journalProcessDefinition)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(JournalProcessDefinition journalProcessDefinition) method. Use update(JournalProcessDefinition journalProcessDefinition, boolean merge) instead.");
        }

        return update(journalProcessDefinition, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                journalProcessDefinition the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when journalProcessDefinition is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public JournalProcessDefinition update(
        JournalProcessDefinition journalProcessDefinition, boolean merge)
        throws SystemException {
        boolean isNew = journalProcessDefinition.isNew();

        for (ModelListener<JournalProcessDefinition> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(journalProcessDefinition);
            } else {
                listener.onBeforeUpdate(journalProcessDefinition);
            }
        }

        journalProcessDefinition = updateImpl(journalProcessDefinition, merge);

        for (ModelListener<JournalProcessDefinition> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(journalProcessDefinition);
            } else {
                listener.onAfterUpdate(journalProcessDefinition);
            }
        }

        return journalProcessDefinition;
    }

    public JournalProcessDefinition updateImpl(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, journalProcessDefinition, merge);

            journalProcessDefinition.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(JournalProcessDefinitionModelImpl.ENTITY_CACHE_ENABLED,
            JournalProcessDefinitionImpl.class,
            journalProcessDefinition.getPrimaryKey(), journalProcessDefinition);

        return journalProcessDefinition;
    }

    public JournalProcessDefinition findByPrimaryKey(
        long journalProcessDefinitionId)
        throws NoSuchJournalProcessDefinitionException, SystemException {
        JournalProcessDefinition journalProcessDefinition = fetchByPrimaryKey(journalProcessDefinitionId);

        if (journalProcessDefinition == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No JournalProcessDefinition exists with the primary key " +
                    journalProcessDefinitionId);
            }

            throw new NoSuchJournalProcessDefinitionException(
                "No JournalProcessDefinition exists with the primary key " +
                journalProcessDefinitionId);
        }

        return journalProcessDefinition;
    }

    public JournalProcessDefinition fetchByPrimaryKey(
        long journalProcessDefinitionId) throws SystemException {
        JournalProcessDefinition journalProcessDefinition = (JournalProcessDefinition) EntityCacheUtil.getResult(JournalProcessDefinitionModelImpl.ENTITY_CACHE_ENABLED,
                JournalProcessDefinitionImpl.class, journalProcessDefinitionId,
                this);

        if (journalProcessDefinition == null) {
            Session session = null;

            try {
                session = openSession();

                journalProcessDefinition = (JournalProcessDefinition) session.get(JournalProcessDefinitionImpl.class,
                        new Long(journalProcessDefinitionId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (journalProcessDefinition != null) {
                    cacheResult(journalProcessDefinition);
                }

                closeSession(session);
            }
        }

        return journalProcessDefinition;
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

    public List<JournalProcessDefinition> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<JournalProcessDefinition> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<JournalProcessDefinition> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<JournalProcessDefinition> list = (List<JournalProcessDefinition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.JournalProcessDefinition ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("name ASC, ");
                    query.append("version ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<JournalProcessDefinition>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<JournalProcessDefinition>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<JournalProcessDefinition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeAll() throws SystemException {
        for (JournalProcessDefinition journalProcessDefinition : findAll()) {
            remove(journalProcessDefinition);
        }
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
                        "SELECT COUNT(*) FROM com.nss.portlet.journalworkflow.model.JournalProcessDefinition");

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
                        "value.object.listener.com.nss.portlet.journalworkflow.model.JournalProcessDefinition")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<JournalProcessDefinition>> listenersList = new ArrayList<ModelListener<JournalProcessDefinition>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<JournalProcessDefinition>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
