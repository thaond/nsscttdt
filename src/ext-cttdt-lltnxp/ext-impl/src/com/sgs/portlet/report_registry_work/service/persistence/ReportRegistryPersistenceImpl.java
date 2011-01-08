package com.sgs.portlet.report_registry_work.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
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

    public ReportRegistry create(ReportRegistryPK reportRegistryPK) {
        ReportRegistry reportRegistry = new ReportRegistryImpl();

        reportRegistry.setNew(true);
        reportRegistry.setPrimaryKey(reportRegistryPK);

        return reportRegistry;
    }

    public ReportRegistry remove(ReportRegistryPK reportRegistryPK)
        throws NoSuchReportRegistryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ReportRegistry reportRegistry = (ReportRegistry) session.get(ReportRegistryImpl.class,
                    reportRegistryPK);

            if (reportRegistry == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No ReportRegistry exists with the primary key " +
                        reportRegistryPK);
                }

                throw new NoSuchReportRegistryException(
                    "No ReportRegistry exists with the primary key " +
                    reportRegistryPK);
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

    public ReportRegistry findByPrimaryKey(ReportRegistryPK reportRegistryPK)
        throws NoSuchReportRegistryException, SystemException {
        ReportRegistry reportRegistry = fetchByPrimaryKey(reportRegistryPK);

        if (reportRegistry == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No ReportRegistry exists with the primary key " +
                    reportRegistryPK);
            }

            throw new NoSuchReportRegistryException(
                "No ReportRegistry exists with the primary key " +
                reportRegistryPK);
        }

        return reportRegistry;
    }

    public ReportRegistry fetchByPrimaryKey(ReportRegistryPK reportRegistryPK)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (ReportRegistry) session.get(ReportRegistryImpl.class,
                reportRegistryPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<ReportRegistry> findByReportRegistryId(long reportRegistryId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReportRegistryModelImpl.CACHE_ENABLED;
        String finderClassName = ReportRegistry.class.getName();
        String finderMethodName = "findByReportRegistryId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(reportRegistryId) };

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
                    "FROM com.sgs.portlet.report_registry_work.model.ReportRegistry WHERE ");

                query.append("reportRegistryId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(reportRegistryId);

                List<ReportRegistry> list = q.list();

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

    public List<ReportRegistry> findByReportRegistryId(long reportRegistryId,
        int start, int end) throws SystemException {
        return findByReportRegistryId(reportRegistryId, start, end, null);
    }

    public List<ReportRegistry> findByReportRegistryId(long reportRegistryId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = ReportRegistryModelImpl.CACHE_ENABLED;
        String finderClassName = ReportRegistry.class.getName();
        String finderMethodName = "findByReportRegistryId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(reportRegistryId),
                
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
                    "FROM com.sgs.portlet.report_registry_work.model.ReportRegistry WHERE ");

                query.append("reportRegistryId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(reportRegistryId);

                List<ReportRegistry> list = (List<ReportRegistry>) QueryUtil.list(q,
                        getDialect(), start, end);

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

    public ReportRegistry findByReportRegistryId_First(long reportRegistryId,
        OrderByComparator obc)
        throws NoSuchReportRegistryException, SystemException {
        List<ReportRegistry> list = findByReportRegistryId(reportRegistryId, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReportRegistry exists with the key {");

            msg.append("reportRegistryId=" + reportRegistryId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReportRegistryException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReportRegistry findByReportRegistryId_Last(long reportRegistryId,
        OrderByComparator obc)
        throws NoSuchReportRegistryException, SystemException {
        int count = countByReportRegistryId(reportRegistryId);

        List<ReportRegistry> list = findByReportRegistryId(reportRegistryId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReportRegistry exists with the key {");

            msg.append("reportRegistryId=" + reportRegistryId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReportRegistryException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReportRegistry[] findByReportRegistryId_PrevAndNext(
        ReportRegistryPK reportRegistryPK, long reportRegistryId,
        OrderByComparator obc)
        throws NoSuchReportRegistryException, SystemException {
        ReportRegistry reportRegistry = findByPrimaryKey(reportRegistryPK);

        int count = countByReportRegistryId(reportRegistryId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.report_registry_work.model.ReportRegistry WHERE ");

            query.append("reportRegistryId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(reportRegistryId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    reportRegistry);

            ReportRegistry[] array = new ReportRegistryImpl[3];

            array[0] = (ReportRegistry) objArray[0];
            array[1] = (ReportRegistry) objArray[1];
            array[2] = (ReportRegistry) objArray[2];

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

    public void removeByReportRegistryId(long reportRegistryId)
        throws SystemException {
        for (ReportRegistry reportRegistry : findByReportRegistryId(
                reportRegistryId)) {
            remove(reportRegistry);
        }
    }

    public void removeAll() throws SystemException {
        for (ReportRegistry reportRegistry : findAll()) {
            remove(reportRegistry);
        }
    }

    public int countByReportRegistryId(long reportRegistryId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReportRegistryModelImpl.CACHE_ENABLED;
        String finderClassName = ReportRegistry.class.getName();
        String finderMethodName = "countByReportRegistryId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(reportRegistryId) };

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

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.report_registry_work.model.ReportRegistry WHERE ");

                query.append("reportRegistryId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(reportRegistryId);

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
