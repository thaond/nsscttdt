package com.sgs.portlet.report_registry_work.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.report_registry_work.NoSuchReportRegistryException;
import com.sgs.portlet.report_registry_work.model.ReportRegistry;
import com.sgs.portlet.report_registry_work.model.impl.ReportRegistryImpl;
import com.sgs.portlet.report_registry_work.model.impl.ReportRegistryModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class ReportRegistryPersistenceImpl extends BasePersistenceImpl
    implements ReportRegistryPersistence {
    private static Log _log = LogFactory.getLog(ReportRegistryPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public ReportRegistry create(long reportRegistryId) {
        ReportRegistry reportRegistry = new ReportRegistryImpl();

        reportRegistry.setNew(true);
        reportRegistry.setPrimaryKey(reportRegistryId);

        return reportRegistry;
    }

    public ReportRegistry remove(long reportRegistryId)
        throws NoSuchReportRegistryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ReportRegistry reportRegistry = (ReportRegistry) session.get(ReportRegistryImpl.class,
                    new Long(reportRegistryId));

            if (reportRegistry == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No ReportRegistry exists with the primary key " +
                        reportRegistryId);
                }

                throw new NoSuchReportRegistryException(
                    "No ReportRegistry exists with the primary key " +
                    reportRegistryId);
            }

            return remove(reportRegistry);
        } catch (NoSuchReportRegistryException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public ReportRegistry remove(ReportRegistry reportRegistry)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(reportRegistry);
            }
        }

        reportRegistry = removeImpl(reportRegistry);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(reportRegistry);
            }
        }

        return reportRegistry;
    }

    protected ReportRegistry removeImpl(ReportRegistry reportRegistry)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(reportRegistry);

            session.flush();

            return reportRegistry;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(ReportRegistry.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(ReportRegistry reportRegistry, boolean merge)</code>.
     */
    public ReportRegistry update(ReportRegistry reportRegistry)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(ReportRegistry reportRegistry) method. Use update(ReportRegistry reportRegistry, boolean merge) instead.");
        }

        return update(reportRegistry, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                reportRegistry the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when reportRegistry is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public ReportRegistry update(ReportRegistry reportRegistry, boolean merge)
        throws SystemException {
        boolean isNew = reportRegistry.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(reportRegistry);
                } else {
                    listener.onBeforeUpdate(reportRegistry);
                }
            }
        }

        reportRegistry = updateImpl(reportRegistry, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(reportRegistry);
                } else {
                    listener.onAfterUpdate(reportRegistry);
                }
            }
        }

        return reportRegistry;
    }

    public ReportRegistry updateImpl(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(reportRegistry);
            } else {
                if (reportRegistry.isNew()) {
                    session.save(reportRegistry);
                }
            }

            session.flush();

            reportRegistry.setNew(false);

            return reportRegistry;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(ReportRegistry.class.getName());
        }
    }

    public ReportRegistry findByPrimaryKey(long reportRegistryId)
        throws NoSuchReportRegistryException, SystemException {
        ReportRegistry reportRegistry = fetchByPrimaryKey(reportRegistryId);

        if (reportRegistry == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No ReportRegistry exists with the primary key " +
                    reportRegistryId);
            }

            throw new NoSuchReportRegistryException(
                "No ReportRegistry exists with the primary key " +
                reportRegistryId);
        }

        return reportRegistry;
    }

    public ReportRegistry fetchByPrimaryKey(long reportRegistryId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (ReportRegistry) session.get(ReportRegistryImpl.class,
                new Long(reportRegistryId));
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

    public List<ReportRegistry> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<ReportRegistry> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<ReportRegistry> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = ReportRegistryModelImpl.CACHE_ENABLED;
        String finderClassName = ReportRegistry.class.getName();
        String finderMethodName = "findAll";
        String[] finderParams = new String[] {
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.sgs.portlet.report_registry_work.model.ReportRegistry ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<ReportRegistry> list = (List<ReportRegistry>) QueryUtil.list(q,
                        getDialect(), start, end);

                if (obc == null) {
                    Collections.sort(list);
                }

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                return list;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return (List<ReportRegistry>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (ReportRegistry reportRegistry : findAll()) {
            remove(reportRegistry);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = ReportRegistryModelImpl.CACHE_ENABLED;
        String finderClassName = ReportRegistry.class.getName();
        String finderMethodName = "countAll";
        String[] finderParams = new String[] {  };
        Object[] finderArgs = new Object[] {  };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.sgs.portlet.report_registry_work.model.ReportRegistry");

                Long count = null;

                Iterator<Long> itr = q.list().iterator();

                if (itr.hasNext()) {
                    count = itr.next();
                }

                if (count == null) {
                    count = new Long(0);
                }

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, count);

                return count.intValue();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return ((Long) result).intValue();
        }
    }

    public void registerListener(ModelListener listener) {
        List<ModelListener> listeners = ListUtil.fromArray(_listeners);

        listeners.add(listener);

        _listeners = listeners.toArray(new ModelListener[listeners.size()]);
    }

    public void unregisterListener(ModelListener listener) {
        List<ModelListener> listeners = ListUtil.fromArray(_listeners);

        listeners.remove(listener);

        _listeners = listeners.toArray(new ModelListener[listeners.size()]);
    }

    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.portal.util.PropsUtil.get(
                        "value.object.listener.com.sgs.portlet.report_registry_work.model.ReportRegistry")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener> listeners = new ArrayList<ModelListener>();

                for (String listenerClassName : listenerClassNames) {
                    listeners.add((ModelListener) Class.forName(
                            listenerClassName).newInstance());
                }

                _listeners = listeners.toArray(new ModelListener[listeners.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
