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

import com.sgs.portlet.report_registry_work.NoSuchDepartmentException;
import com.sgs.portlet.report_registry_work.model.Department;
import com.sgs.portlet.report_registry_work.model.impl.DepartmentImpl;
import com.sgs.portlet.report_registry_work.model.impl.DepartmentModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class DepartmentPersistenceImpl extends BasePersistenceImpl
    implements DepartmentPersistence {
    private static final String _SQL_GETREPORTREGISTRIES = "SELECT {report_registry_work.*} FROM report_registry_work INNER JOIN department ON (department.departmentId = report_registry_work.departmentId) WHERE (department.departmentId = ?)";
    private static final String _SQL_GETREPORTREGISTRIESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM report_registry_work WHERE departmentId = ?";
    private static final String _SQL_CONTAINSREPORTREGISTRY = "SELECT COUNT(*) AS COUNT_VALUE FROM report_registry_work WHERE departmentId = ? AND reportRegistryId = ?";
    private static Log _log = LogFactory.getLog(DepartmentPersistenceImpl.class);
    protected ContainsReportRegistry containsReportRegistry;
    private ModelListener[] _listeners = new ModelListener[0];

    public Department create(long departmentId) {
        Department department = new DepartmentImpl();

        department.setNew(true);
        department.setPrimaryKey(departmentId);

        return department;
    }

    public Department remove(long departmentId)
        throws NoSuchDepartmentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Department department = (Department) session.get(DepartmentImpl.class,
                    new Long(departmentId));

            if (department == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Department exists with the primary key " +
                        departmentId);
                }

                throw new NoSuchDepartmentException(
                    "No Department exists with the primary key " +
                    departmentId);
            }

            return remove(department);
        } catch (NoSuchDepartmentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Department remove(Department department) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(department);
            }
        }

        department = removeImpl(department);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(department);
            }
        }

        return department;
    }

    protected Department removeImpl(Department department)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(department);

            session.flush();

            return department;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Department.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(Department department, boolean merge)</code>.
     */
    public Department update(Department department) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Department department) method. Use update(Department department, boolean merge) instead.");
        }

        return update(department, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                department the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when department is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Department update(Department department, boolean merge)
        throws SystemException {
        boolean isNew = department.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(department);
                } else {
                    listener.onBeforeUpdate(department);
                }
            }
        }

        department = updateImpl(department, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(department);
                } else {
                    listener.onAfterUpdate(department);
                }
            }
        }

        return department;
    }

    public Department updateImpl(
        com.sgs.portlet.report_registry_work.model.Department department,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(department);
            } else {
                if (department.isNew()) {
                    session.save(department);
                }
            }

            session.flush();

            department.setNew(false);

            return department;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Department.class.getName());
        }
    }

    public Department findByPrimaryKey(long departmentId)
        throws NoSuchDepartmentException, SystemException {
        Department department = fetchByPrimaryKey(departmentId);

        if (department == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Department exists with the primary key " +
                    departmentId);
            }

            throw new NoSuchDepartmentException(
                "No Department exists with the primary key " + departmentId);
        }

        return department;
    }

    public Department fetchByPrimaryKey(long departmentId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (Department) session.get(DepartmentImpl.class,
                new Long(departmentId));
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

    public List<Department> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Department> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<Department> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
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
                    "FROM com.sgs.portlet.report_registry_work.model.Department ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<Department> list = (List<Department>) QueryUtil.list(q,
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
            return (List<Department>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (Department department : findAll()) {
            remove(department);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.report_registry_work.model.Department");

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

    public List<com.sgs.portlet.report_registry_work.model.ReportRegistry> getReportRegistries(
        long pk) throws SystemException {
        return getReportRegistries(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    public List<com.sgs.portlet.report_registry_work.model.ReportRegistry> getReportRegistries(
        long pk, int start, int end) throws SystemException {
        return getReportRegistries(pk, start, end, null);
    }

    public List<com.sgs.portlet.report_registry_work.model.ReportRegistry> getReportRegistries(
        long pk, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.report_registry_work.model.impl.ReportRegistryModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.report_registry_work.model.ReportRegistry.class.getName();

        String finderMethodName = "getReportRegistries";
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

                sb.append(_SQL_GETREPORTREGISTRIES);

                if (obc != null) {
                    sb.append("ORDER BY ");
                    sb.append(obc.getOrderBy());
                }

                String sql = sb.toString();

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("report_registry_work",
                    com.sgs.portlet.report_registry_work.model.impl.ReportRegistryImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                List<com.sgs.portlet.report_registry_work.model.ReportRegistry> list =
                    (List<com.sgs.portlet.report_registry_work.model.ReportRegistry>) QueryUtil.list(q,
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
            return (List<com.sgs.portlet.report_registry_work.model.ReportRegistry>) result;
        }
    }

    public int getReportRegistriesSize(long pk) throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.report_registry_work.model.impl.ReportRegistryModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.report_registry_work.model.ReportRegistry.class.getName();

        String finderMethodName = "getReportRegistriesSize";
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

                SQLQuery q = session.createSQLQuery(_SQL_GETREPORTREGISTRIESSIZE);

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

    public boolean containsReportRegistry(long pk, long reportRegistryPK)
        throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.report_registry_work.model.impl.ReportRegistryModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.report_registry_work.model.ReportRegistry.class.getName();

        String finderMethodName = "containsReportRegistries";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(pk),
                
                new Long(reportRegistryPK)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            try {
                Boolean value = Boolean.valueOf(containsReportRegistry.contains(
                            pk, reportRegistryPK));

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

    public boolean containsReportRegistries(long pk) throws SystemException {
        if (getReportRegistriesSize(pk) > 0) {
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
                        "value.object.listener.com.sgs.portlet.report_registry_work.model.Department")));

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

        containsReportRegistry = new ContainsReportRegistry(this);
    }

    protected class ContainsReportRegistry {
        private MappingSqlQuery _mappingSqlQuery;

        protected ContainsReportRegistry(
            DepartmentPersistenceImpl persistenceImpl) {
            super();

            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSREPORTREGISTRY,
                    new int[] { Types.BIGINT, Types.BIGINT }, RowMapper.COUNT);
        }

        protected boolean contains(long departmentId, long reportRegistryId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(departmentId), new Long(reportRegistryId)
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
