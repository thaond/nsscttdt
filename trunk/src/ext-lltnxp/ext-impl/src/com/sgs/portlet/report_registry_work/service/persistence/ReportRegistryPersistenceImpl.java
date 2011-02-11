package com.sgs.portlet.report_registry_work.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
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

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class ReportRegistryPersistenceImpl extends BasePersistenceImpl
    implements ReportRegistryPersistence {
    private static final String _SQL_GETRESULTPROGRAMS = "SELECT {result_program_file.*} FROM result_program_file INNER JOIN report_registry_work ON (report_registry_work.reportRegistryId = result_program_file.reportRegistryId) WHERE (report_registry_work.reportRegistryId = ?)";
    private static final String _SQL_GETRESULTPROGRAMSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM result_program_file WHERE reportRegistryId = ?";
    private static final String _SQL_CONTAINSRESULTPROGRAM = "SELECT COUNT(*) AS COUNT_VALUE FROM result_program_file WHERE reportRegistryId = ? AND resultProgramId = ?";
    private static Log _log = LogFactory.getLog(ReportRegistryPersistenceImpl.class);
    protected ContainsResultProgram containsResultProgram;
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
//                    _log.warn("No ReportRegistry exists with the primary key " + reportRegistryId);
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
//                _log.warn("No ReportRegistry exists with the primary key " + reportRegistryId);
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

    public List<com.sgs.portlet.report_registry_work.model.ResultProgram> getResultPrograms(
        long pk) throws SystemException {
        return getResultPrograms(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    public List<com.sgs.portlet.report_registry_work.model.ResultProgram> getResultPrograms(
        long pk, int start, int end) throws SystemException {
        return getResultPrograms(pk, start, end, null);
    }

    public List<com.sgs.portlet.report_registry_work.model.ResultProgram> getResultPrograms(
        long pk, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.report_registry_work.model.impl.ResultProgramModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.report_registry_work.model.ResultProgram.class.getName();

        String finderMethodName = "getResultPrograms";
        String[] finderParams = new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(pk), String.valueOf(start), String.valueOf(end),
                String.valueOf(obc)
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

                StringBuilder sb = new StringBuilder();

                sb.append(_SQL_GETRESULTPROGRAMS);

                if (obc != null) {
                    sb.append("ORDER BY ");
                    sb.append(obc.getOrderBy());
                }

                String sql = sb.toString();

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("result_program_file",
                    com.sgs.portlet.report_registry_work.model.impl.ResultProgramImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                List<com.sgs.portlet.report_registry_work.model.ResultProgram> list =
                    (List<com.sgs.portlet.report_registry_work.model.ResultProgram>) QueryUtil.list(q,
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
            return (List<com.sgs.portlet.report_registry_work.model.ResultProgram>) result;
        }
    }

    public int getResultProgramsSize(long pk) throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.report_registry_work.model.impl.ResultProgramModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.report_registry_work.model.ResultProgram.class.getName();

        String finderMethodName = "getResultProgramsSize";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(pk) };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETRESULTPROGRAMSSIZE);

                q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

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

    public boolean containsResultProgram(long pk, long resultProgramPK)
        throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.report_registry_work.model.impl.ResultProgramModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.report_registry_work.model.ResultProgram.class.getName();

        String finderMethodName = "containsResultPrograms";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(pk),
                
                new Long(resultProgramPK)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            try {
                Boolean value = Boolean.valueOf(containsResultProgram.contains(
                            pk, resultProgramPK));

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, value);

                return value.booleanValue();
            } catch (Exception e) {
                throw processException(e);
            }
        } else {
            return ((Boolean) result).booleanValue();
        }
    }

    public boolean containsResultPrograms(long pk) throws SystemException {
        if (getResultProgramsSize(pk) > 0) {
            return true;
        } else {
            return false;
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

        containsResultProgram = new ContainsResultProgram(this);
    }

    protected class ContainsResultProgram {
        private MappingSqlQuery _mappingSqlQuery;

        protected ContainsResultProgram(
            ReportRegistryPersistenceImpl persistenceImpl) {
            super();

            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSRESULTPROGRAM,
                    new int[] { Types.BIGINT, Types.BIGINT }, RowMapper.COUNT);
        }

        protected boolean contains(long reportRegistryId, long resultProgramId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(reportRegistryId), new Long(resultProgramId)
                    });

            if (results.size() > 0) {
                Integer count = results.get(0);

                if (count.intValue() > 0) {
                    return true;
                }
            }

            return false;
        }
    }
}
