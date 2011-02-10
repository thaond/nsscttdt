package com.sgs.portlet.department.service.persistence;

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

import com.sgs.portlet.department.NoSuchDepartmentException;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.model.impl.DepartmentImpl;
import com.sgs.portlet.department.model.impl.DepartmentModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class DepartmentPersistenceImpl extends BasePersistenceImpl
    implements DepartmentPersistence {
    private static Log _log = LogFactory.getLog(DepartmentPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public Department create(String departmentsId) {
        Department department = new DepartmentImpl();

        department.setNew(true);
        department.setPrimaryKey(departmentsId);

        return department;
    }

    public Department remove(String departmentsId)
        throws NoSuchDepartmentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Department department = (Department) session.get(DepartmentImpl.class,
                    departmentsId);

            if (department == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Department exists with the primary key " +
                        departmentsId);
                }

                throw new NoSuchDepartmentException(
                    "No Department exists with the primary key " +
                    departmentsId);
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
        com.sgs.portlet.department.model.Department department, boolean merge)
        throws SystemException {
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

    public Department findByPrimaryKey(String departmentsId)
        throws NoSuchDepartmentException, SystemException {
        Department department = fetchByPrimaryKey(departmentsId);

        if (department == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Department exists with the primary key " +
                    departmentsId);
            }

            throw new NoSuchDepartmentException(
                "No Department exists with the primary key " + departmentsId);
        }

        return department;
    }

    public Department fetchByPrimaryKey(String departmentsId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (Department) session.get(DepartmentImpl.class, departmentsId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Department> findByActive(String active)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByActive";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { active };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (active == null) {
                    query.append("active IS NULL");
                } else {
                    query.append("active = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("departmentsname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (active != null) {
                    qPos.add(active);
                }

                List<Department> list = q.list();

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

    public List<Department> findByActive(String active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<Department> findByActive(String active, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByActive";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                active,
                
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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (active == null) {
                    query.append("active IS NULL");
                } else {
                    query.append("active = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (active != null) {
                    qPos.add(active);
                }

                List<Department> list = (List<Department>) QueryUtil.list(q,
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
            return (List<Department>) result;
        }
    }

    public Department findByActive_First(String active, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByActive(active, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department findByActive_Last(String active, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        int count = countByActive(active);

        List<Department> list = findByActive(active, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department[] findByActive_PrevAndNext(String departmentsId,
        String active, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        Department department = findByPrimaryKey(departmentsId);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.department.model.Department WHERE ");

            if (active == null) {
                query.append("active IS NULL");
            } else {
                query.append("active = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("departmentsname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (active != null) {
                qPos.add(active);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    department);

            Department[] array = new DepartmentImpl[3];

            array[0] = (Department) objArray[0];
            array[1] = (Department) objArray[1];
            array[2] = (Department) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Department> findByDepartmentsParentId(
        String departmentsParentId) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByDepartmentsParentId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsParentId };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsParentId == null) {
                    query.append("departmentsparentid LIKE null");
                } else {
                    query.append("departmentsparentid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("departmentsname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsParentId != null) {
                    qPos.add(departmentsParentId);
                }

                List<Department> list = q.list();

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

    public List<Department> findByDepartmentsParentId(
        String departmentsParentId, int start, int end)
        throws SystemException {
        return findByDepartmentsParentId(departmentsParentId, start, end, null);
    }

    public List<Department> findByDepartmentsParentId(
        String departmentsParentId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByDepartmentsParentId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentsParentId,
                
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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsParentId == null) {
                    query.append("departmentsparentid LIKE null");
                } else {
                    query.append("departmentsparentid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsParentId != null) {
                    qPos.add(departmentsParentId);
                }

                List<Department> list = (List<Department>) QueryUtil.list(q,
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
            return (List<Department>) result;
        }
    }

    public Department findByDepartmentsParentId_First(
        String departmentsParentId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByDepartmentsParentId(departmentsParentId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("departmentsParentId=" + departmentsParentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department findByDepartmentsParentId_Last(
        String departmentsParentId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        int count = countByDepartmentsParentId(departmentsParentId);

        List<Department> list = findByDepartmentsParentId(departmentsParentId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("departmentsParentId=" + departmentsParentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department[] findByDepartmentsParentId_PrevAndNext(
        String departmentsId, String departmentsParentId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        Department department = findByPrimaryKey(departmentsId);

        int count = countByDepartmentsParentId(departmentsParentId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.department.model.Department WHERE ");

            if (departmentsParentId == null) {
                query.append("departmentsparentid LIKE null");
            } else {
                query.append("departmentsparentid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("departmentsname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsParentId != null) {
                qPos.add(departmentsParentId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    department);

            Department[] array = new DepartmentImpl[3];

            array[0] = (Department) objArray[0];
            array[1] = (Department) objArray[1];
            array[2] = (Department) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Department> findByDepartmentsCode_AgencyId(
        String departmentsCode, String agencyId) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByDepartmentsCode_AgencyId";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { departmentsCode, agencyId };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsCode == null) {
                    query.append("departmentscode LIKE null");
                } else {
                    query.append("departmentscode LIKE ?");
                }

                query.append(" AND ");

                if (agencyId == null) {
                    query.append("agencyid LIKE null");
                } else {
                    query.append("agencyid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("departmentsname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsCode != null) {
                    qPos.add(departmentsCode);
                }

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                List<Department> list = q.list();

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

    public List<Department> findByDepartmentsCode_AgencyId(
        String departmentsCode, String agencyId, int start, int end)
        throws SystemException {
        return findByDepartmentsCode_AgencyId(departmentsCode, agencyId, start,
            end, null);
    }

    public List<Department> findByDepartmentsCode_AgencyId(
        String departmentsCode, String agencyId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByDepartmentsCode_AgencyId";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentsCode,
                
                agencyId,
                
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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsCode == null) {
                    query.append("departmentscode LIKE null");
                } else {
                    query.append("departmentscode LIKE ?");
                }

                query.append(" AND ");

                if (agencyId == null) {
                    query.append("agencyid LIKE null");
                } else {
                    query.append("agencyid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsCode != null) {
                    qPos.add(departmentsCode);
                }

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                List<Department> list = (List<Department>) QueryUtil.list(q,
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
            return (List<Department>) result;
        }
    }

    public Department findByDepartmentsCode_AgencyId_First(
        String departmentsCode, String agencyId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByDepartmentsCode_AgencyId(departmentsCode,
                agencyId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("departmentsCode=" + departmentsCode);

            msg.append(", ");
            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department findByDepartmentsCode_AgencyId_Last(
        String departmentsCode, String agencyId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        int count = countByDepartmentsCode_AgencyId(departmentsCode, agencyId);

        List<Department> list = findByDepartmentsCode_AgencyId(departmentsCode,
                agencyId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("departmentsCode=" + departmentsCode);

            msg.append(", ");
            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department[] findByDepartmentsCode_AgencyId_PrevAndNext(
        String departmentsId, String departmentsCode, String agencyId,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        Department department = findByPrimaryKey(departmentsId);

        int count = countByDepartmentsCode_AgencyId(departmentsCode, agencyId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.department.model.Department WHERE ");

            if (departmentsCode == null) {
                query.append("departmentscode LIKE null");
            } else {
                query.append("departmentscode LIKE ?");
            }

            query.append(" AND ");

            if (agencyId == null) {
                query.append("agencyid LIKE null");
            } else {
                query.append("agencyid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("departmentsname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsCode != null) {
                qPos.add(departmentsCode);
            }

            if (agencyId != null) {
                qPos.add(agencyId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    department);

            Department[] array = new DepartmentImpl[3];

            array[0] = (Department) objArray[0];
            array[1] = (Department) objArray[1];
            array[2] = (Department) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Department> findByDepartmentsCode(String departmentsCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByDepartmentsCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsCode };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsCode == null) {
                    query.append("departmentscode LIKE null");
                } else {
                    query.append("departmentscode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("departmentsname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsCode != null) {
                    qPos.add(departmentsCode);
                }

                List<Department> list = q.list();

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

    public List<Department> findByDepartmentsCode(String departmentsCode,
        int start, int end) throws SystemException {
        return findByDepartmentsCode(departmentsCode, start, end, null);
    }

    public List<Department> findByDepartmentsCode(String departmentsCode,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByDepartmentsCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentsCode,
                
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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsCode == null) {
                    query.append("departmentscode LIKE null");
                } else {
                    query.append("departmentscode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsCode != null) {
                    qPos.add(departmentsCode);
                }

                List<Department> list = (List<Department>) QueryUtil.list(q,
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
            return (List<Department>) result;
        }
    }

    public Department findByDepartmentsCode_First(String departmentsCode,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByDepartmentsCode(departmentsCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("departmentsCode=" + departmentsCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department findByDepartmentsCode_Last(String departmentsCode,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        int count = countByDepartmentsCode(departmentsCode);

        List<Department> list = findByDepartmentsCode(departmentsCode,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("departmentsCode=" + departmentsCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department[] findByDepartmentsCode_PrevAndNext(
        String departmentsId, String departmentsCode, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        Department department = findByPrimaryKey(departmentsId);

        int count = countByDepartmentsCode(departmentsCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.department.model.Department WHERE ");

            if (departmentsCode == null) {
                query.append("departmentscode LIKE null");
            } else {
                query.append("departmentscode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("departmentsname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsCode != null) {
                qPos.add(departmentsCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    department);

            Department[] array = new DepartmentImpl[3];

            array[0] = (Department) objArray[0];
            array[1] = (Department) objArray[1];
            array[2] = (Department) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Department> findByRoleId(long roleId) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByRoleId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(roleId) };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                query.append("roleid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("departmentsname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(roleId);

                List<Department> list = q.list();

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

    public List<Department> findByRoleId(long roleId, int start, int end)
        throws SystemException {
        return findByRoleId(roleId, start, end, null);
    }

    public List<Department> findByRoleId(long roleId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByRoleId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(roleId),
                
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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                query.append("roleid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(roleId);

                List<Department> list = (List<Department>) QueryUtil.list(q,
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
            return (List<Department>) result;
        }
    }

    public Department findByRoleId_First(long roleId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByRoleId(roleId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("roleId=" + roleId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department findByRoleId_Last(long roleId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        int count = countByRoleId(roleId);

        List<Department> list = findByRoleId(roleId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("roleId=" + roleId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department[] findByRoleId_PrevAndNext(String departmentsId,
        long roleId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        Department department = findByPrimaryKey(departmentsId);

        int count = countByRoleId(roleId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.department.model.Department WHERE ");

            query.append("roleid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("departmentsname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(roleId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    department);

            Department[] array = new DepartmentImpl[3];

            array[0] = (Department) objArray[0];
            array[1] = (Department) objArray[1];
            array[2] = (Department) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Department> findByDepartmentsName(String departmentsName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByDepartmentsName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsName };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsName == null) {
                    query.append("departmentsname LIKE null");
                } else {
                    query.append("departmentsname LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("departmentsname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsName != null) {
                    qPos.add(departmentsName);
                }

                List<Department> list = q.list();

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

    public List<Department> findByDepartmentsName(String departmentsName,
        int start, int end) throws SystemException {
        return findByDepartmentsName(departmentsName, start, end, null);
    }

    public List<Department> findByDepartmentsName(String departmentsName,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByDepartmentsName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentsName,
                
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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsName == null) {
                    query.append("departmentsname LIKE null");
                } else {
                    query.append("departmentsname LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsName != null) {
                    qPos.add(departmentsName);
                }

                List<Department> list = (List<Department>) QueryUtil.list(q,
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
            return (List<Department>) result;
        }
    }

    public Department findByDepartmentsName_First(String departmentsName,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByDepartmentsName(departmentsName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("departmentsName=" + departmentsName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department findByDepartmentsName_Last(String departmentsName,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        int count = countByDepartmentsName(departmentsName);

        List<Department> list = findByDepartmentsName(departmentsName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("departmentsName=" + departmentsName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department[] findByDepartmentsName_PrevAndNext(
        String departmentsId, String departmentsName, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        Department department = findByPrimaryKey(departmentsId);

        int count = countByDepartmentsName(departmentsName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.department.model.Department WHERE ");

            if (departmentsName == null) {
                query.append("departmentsname LIKE null");
            } else {
                query.append("departmentsname LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("departmentsname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsName != null) {
                qPos.add(departmentsName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    department);

            Department[] array = new DepartmentImpl[3];

            array[0] = (Department) objArray[0];
            array[1] = (Department) objArray[1];
            array[2] = (Department) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Department> findByAbbreviateName(String abbreviateName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByAbbreviateName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { abbreviateName };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (abbreviateName == null) {
                    query.append("abbreviatename LIKE null");
                } else {
                    query.append("abbreviatename LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("departmentsname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (abbreviateName != null) {
                    qPos.add(abbreviateName);
                }

                List<Department> list = q.list();

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

    public List<Department> findByAbbreviateName(String abbreviateName,
        int start, int end) throws SystemException {
        return findByAbbreviateName(abbreviateName, start, end, null);
    }

    public List<Department> findByAbbreviateName(String abbreviateName,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByAbbreviateName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                abbreviateName,
                
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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (abbreviateName == null) {
                    query.append("abbreviatename LIKE null");
                } else {
                    query.append("abbreviatename LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (abbreviateName != null) {
                    qPos.add(abbreviateName);
                }

                List<Department> list = (List<Department>) QueryUtil.list(q,
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
            return (List<Department>) result;
        }
    }

    public Department findByAbbreviateName_First(String abbreviateName,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByAbbreviateName(abbreviateName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("abbreviateName=" + abbreviateName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department findByAbbreviateName_Last(String abbreviateName,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        int count = countByAbbreviateName(abbreviateName);

        List<Department> list = findByAbbreviateName(abbreviateName, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("abbreviateName=" + abbreviateName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department[] findByAbbreviateName_PrevAndNext(String departmentsId,
        String abbreviateName, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        Department department = findByPrimaryKey(departmentsId);

        int count = countByAbbreviateName(abbreviateName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.department.model.Department WHERE ");

            if (abbreviateName == null) {
                query.append("abbreviatename LIKE null");
            } else {
                query.append("abbreviatename LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("departmentsname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (abbreviateName != null) {
                qPos.add(abbreviateName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    department);

            Department[] array = new DepartmentImpl[3];

            array[0] = (Department) objArray[0];
            array[1] = (Department) objArray[1];
            array[2] = (Department) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Department> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByDescription";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { description };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("departmentsname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Department> list = q.list();

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

    public List<Department> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<Department> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByDescription";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                description,
                
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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<Department> list = (List<Department>) QueryUtil.list(q,
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
            return (List<Department>) result;
        }
    }

    public Department findByDescription_First(String description,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department findByDescription_Last(String description,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        int count = countByDescription(description);

        List<Department> list = findByDescription(description, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department[] findByDescription_PrevAndNext(String departmentsId,
        String description, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        Department department = findByPrimaryKey(departmentsId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.department.model.Department WHERE ");

            if (description == null) {
                query.append("description LIKE null");
            } else {
                query.append("description LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("departmentsname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    department);

            Department[] array = new DepartmentImpl[3];

            array[0] = (Department) objArray[0];
            array[1] = (Department) objArray[1];
            array[2] = (Department) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Department> findByAgencyId(String agencyId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByAgencyId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { agencyId };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (agencyId == null) {
                    query.append("agencyid LIKE null");
                } else {
                    query.append("agencyid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("departmentsname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                List<Department> list = q.list();

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

    public List<Department> findByAgencyId(String agencyId, int start, int end)
        throws SystemException {
        return findByAgencyId(agencyId, start, end, null);
    }

    public List<Department> findByAgencyId(String agencyId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByAgencyId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                agencyId,
                
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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (agencyId == null) {
                    query.append("agencyid LIKE null");
                } else {
                    query.append("agencyid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                List<Department> list = (List<Department>) QueryUtil.list(q,
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
            return (List<Department>) result;
        }
    }

    public Department findByAgencyId_First(String agencyId,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByAgencyId(agencyId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department findByAgencyId_Last(String agencyId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        int count = countByAgencyId(agencyId);

        List<Department> list = findByAgencyId(agencyId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department[] findByAgencyId_PrevAndNext(String departmentsId,
        String agencyId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        Department department = findByPrimaryKey(departmentsId);

        int count = countByAgencyId(agencyId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.department.model.Department WHERE ");

            if (agencyId == null) {
                query.append("agencyid LIKE null");
            } else {
                query.append("agencyid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("departmentsname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (agencyId != null) {
                qPos.add(agencyId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    department);

            Department[] array = new DepartmentImpl[3];

            array[0] = (Department) objArray[0];
            array[1] = (Department) objArray[1];
            array[2] = (Department) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Department> findByHasTeam(String hasTeam)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByHasTeam";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { hasTeam };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (hasTeam == null) {
                    query.append("hasteam LIKE null");
                } else {
                    query.append("hasteam LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("departmentsname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (hasTeam != null) {
                    qPos.add(hasTeam);
                }

                List<Department> list = q.list();

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

    public List<Department> findByHasTeam(String hasTeam, int start, int end)
        throws SystemException {
        return findByHasTeam(hasTeam, start, end, null);
    }

    public List<Department> findByHasTeam(String hasTeam, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByHasTeam";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                hasTeam,
                
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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (hasTeam == null) {
                    query.append("hasteam LIKE null");
                } else {
                    query.append("hasteam LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (hasTeam != null) {
                    qPos.add(hasTeam);
                }

                List<Department> list = (List<Department>) QueryUtil.list(q,
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
            return (List<Department>) result;
        }
    }

    public Department findByHasTeam_First(String hasTeam, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByHasTeam(hasTeam, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("hasTeam=" + hasTeam);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department findByHasTeam_Last(String hasTeam, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        int count = countByHasTeam(hasTeam);

        List<Department> list = findByHasTeam(hasTeam, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("hasTeam=" + hasTeam);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department[] findByHasTeam_PrevAndNext(String departmentsId,
        String hasTeam, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        Department department = findByPrimaryKey(departmentsId);

        int count = countByHasTeam(hasTeam);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.department.model.Department WHERE ");

            if (hasTeam == null) {
                query.append("hasteam LIKE null");
            } else {
                query.append("hasteam LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("departmentsname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (hasTeam != null) {
                qPos.add(hasTeam);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    department);

            Department[] array = new DepartmentImpl[3];

            array[0] = (Department) objArray[0];
            array[1] = (Department) objArray[1];
            array[2] = (Department) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Department> findByC_N_D(String departmentsCode,
        String departmentsName, String abbreviateName, String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                departmentsCode,
                
                departmentsName,
                
                abbreviateName,
                
                description
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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsCode == null) {
                    query.append("departmentscode LIKE null");
                } else {
                    query.append("departmentscode LIKE ?");
                }

                query.append(" AND ");

                if (departmentsName == null) {
                    query.append("departmentsname LIKE null");
                } else {
                    query.append("departmentsname LIKE ?");
                }

                query.append(" AND ");

                if (abbreviateName == null) {
                    query.append("abbreviatename LIKE null");
                } else {
                    query.append("abbreviatename LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("departmentsname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsCode != null) {
                    qPos.add(departmentsCode);
                }

                if (departmentsName != null) {
                    qPos.add(departmentsName);
                }

                if (abbreviateName != null) {
                    qPos.add(abbreviateName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Department> list = q.list();

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

    public List<Department> findByC_N_D(String departmentsCode,
        String departmentsName, String abbreviateName, String description,
        int start, int end) throws SystemException {
        return findByC_N_D(departmentsCode, departmentsName, abbreviateName,
            description, start, end, null);
    }

    public List<Department> findByC_N_D(String departmentsCode,
        String departmentsName, String abbreviateName, String description,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentsCode,
                
                departmentsName,
                
                abbreviateName,
                
                description,
                
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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsCode == null) {
                    query.append("departmentscode LIKE null");
                } else {
                    query.append("departmentscode LIKE ?");
                }

                query.append(" AND ");

                if (departmentsName == null) {
                    query.append("departmentsname LIKE null");
                } else {
                    query.append("departmentsname LIKE ?");
                }

                query.append(" AND ");

                if (abbreviateName == null) {
                    query.append("abbreviatename LIKE null");
                } else {
                    query.append("abbreviatename LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsCode != null) {
                    qPos.add(departmentsCode);
                }

                if (departmentsName != null) {
                    qPos.add(departmentsName);
                }

                if (abbreviateName != null) {
                    qPos.add(abbreviateName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<Department> list = (List<Department>) QueryUtil.list(q,
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
            return (List<Department>) result;
        }
    }

    public Department findByC_N_D_First(String departmentsCode,
        String departmentsName, String abbreviateName, String description,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByC_N_D(departmentsCode, departmentsName,
                abbreviateName, description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("departmentsCode=" + departmentsCode);

            msg.append(", ");
            msg.append("departmentsName=" + departmentsName);

            msg.append(", ");
            msg.append("abbreviateName=" + abbreviateName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department findByC_N_D_Last(String departmentsCode,
        String departmentsName, String abbreviateName, String description,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        int count = countByC_N_D(departmentsCode, departmentsName,
                abbreviateName, description);

        List<Department> list = findByC_N_D(departmentsCode, departmentsName,
                abbreviateName, description, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Department exists with the key {");

            msg.append("departmentsCode=" + departmentsCode);

            msg.append(", ");
            msg.append("departmentsName=" + departmentsName);

            msg.append(", ");
            msg.append("abbreviateName=" + abbreviateName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Department[] findByC_N_D_PrevAndNext(String departmentsId,
        String departmentsCode, String departmentsName, String abbreviateName,
        String description, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        Department department = findByPrimaryKey(departmentsId);

        int count = countByC_N_D(departmentsCode, departmentsName,
                abbreviateName, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.department.model.Department WHERE ");

            if (departmentsCode == null) {
                query.append("departmentscode LIKE null");
            } else {
                query.append("departmentscode LIKE ?");
            }

            query.append(" AND ");

            if (departmentsName == null) {
                query.append("departmentsname LIKE null");
            } else {
                query.append("departmentsname LIKE ?");
            }

            query.append(" AND ");

            if (abbreviateName == null) {
                query.append("abbreviatename LIKE null");
            } else {
                query.append("abbreviatename LIKE ?");
            }

            query.append(" AND ");

            if (description == null) {
                query.append("description LIKE null");
            } else {
                query.append("description LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("departmentsname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsCode != null) {
                qPos.add(departmentsCode);
            }

            if (departmentsName != null) {
                qPos.add(departmentsName);
            }

            if (abbreviateName != null) {
                qPos.add(abbreviateName);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    department);

            Department[] array = new DepartmentImpl[3];

            array[0] = (Department) objArray[0];
            array[1] = (Department) objArray[1];
            array[2] = (Department) objArray[2];

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
                    "FROM com.sgs.portlet.department.model.Department ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
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

    public void removeByActive(String active) throws SystemException {
        for (Department department : findByActive(active)) {
            remove(department);
        }
    }

    public void removeByDepartmentsParentId(String departmentsParentId)
        throws SystemException {
        for (Department department : findByDepartmentsParentId(
                departmentsParentId)) {
            remove(department);
        }
    }

    public void removeByDepartmentsCode_AgencyId(String departmentsCode,
        String agencyId) throws SystemException {
        for (Department department : findByDepartmentsCode_AgencyId(
                departmentsCode, agencyId)) {
            remove(department);
        }
    }

    public void removeByDepartmentsCode(String departmentsCode)
        throws SystemException {
        for (Department department : findByDepartmentsCode(departmentsCode)) {
            remove(department);
        }
    }

    public void removeByRoleId(long roleId) throws SystemException {
        for (Department department : findByRoleId(roleId)) {
            remove(department);
        }
    }

    public void removeByDepartmentsName(String departmentsName)
        throws SystemException {
        for (Department department : findByDepartmentsName(departmentsName)) {
            remove(department);
        }
    }

    public void removeByAbbreviateName(String abbreviateName)
        throws SystemException {
        for (Department department : findByAbbreviateName(abbreviateName)) {
            remove(department);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (Department department : findByDescription(description)) {
            remove(department);
        }
    }

    public void removeByAgencyId(String agencyId) throws SystemException {
        for (Department department : findByAgencyId(agencyId)) {
            remove(department);
        }
    }

    public void removeByHasTeam(String hasTeam) throws SystemException {
        for (Department department : findByHasTeam(hasTeam)) {
            remove(department);
        }
    }

    public void removeByC_N_D(String departmentsCode, String departmentsName,
        String abbreviateName, String description) throws SystemException {
        for (Department department : findByC_N_D(departmentsCode,
                departmentsName, abbreviateName, description)) {
            remove(department);
        }
    }

    public void removeAll() throws SystemException {
        for (Department department : findAll()) {
            remove(department);
        }
    }

    public int countByActive(String active) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "countByActive";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { active };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (active == null) {
                    query.append("active IS NULL");
                } else {
                    query.append("active = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (active != null) {
                    qPos.add(active);
                }

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

    public int countByDepartmentsParentId(String departmentsParentId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "countByDepartmentsParentId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsParentId };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsParentId == null) {
                    query.append("departmentsparentid LIKE null");
                } else {
                    query.append("departmentsparentid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsParentId != null) {
                    qPos.add(departmentsParentId);
                }

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

    public int countByDepartmentsCode_AgencyId(String departmentsCode,
        String agencyId) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "countByDepartmentsCode_AgencyId";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { departmentsCode, agencyId };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsCode == null) {
                    query.append("departmentscode LIKE null");
                } else {
                    query.append("departmentscode LIKE ?");
                }

                query.append(" AND ");

                if (agencyId == null) {
                    query.append("agencyid LIKE null");
                } else {
                    query.append("agencyid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsCode != null) {
                    qPos.add(departmentsCode);
                }

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

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

    public int countByDepartmentsCode(String departmentsCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "countByDepartmentsCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsCode };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsCode == null) {
                    query.append("departmentscode LIKE null");
                } else {
                    query.append("departmentscode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsCode != null) {
                    qPos.add(departmentsCode);
                }

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

    public int countByRoleId(long roleId) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "countByRoleId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(roleId) };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                query.append("roleid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(roleId);

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

    public int countByDepartmentsName(String departmentsName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "countByDepartmentsName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsName };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsName == null) {
                    query.append("departmentsname LIKE null");
                } else {
                    query.append("departmentsname LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsName != null) {
                    qPos.add(departmentsName);
                }

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

    public int countByAbbreviateName(String abbreviateName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "countByAbbreviateName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { abbreviateName };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (abbreviateName == null) {
                    query.append("abbreviatename LIKE null");
                } else {
                    query.append("abbreviatename LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (abbreviateName != null) {
                    qPos.add(abbreviateName);
                }

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

    public int countByDescription(String description) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "countByDescription";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { description };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

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

    public int countByAgencyId(String agencyId) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "countByAgencyId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { agencyId };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (agencyId == null) {
                    query.append("agencyid LIKE null");
                } else {
                    query.append("agencyid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

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

    public int countByHasTeam(String hasTeam) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "countByHasTeam";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { hasTeam };

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
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (hasTeam == null) {
                    query.append("hasteam LIKE null");
                } else {
                    query.append("hasteam LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (hasTeam != null) {
                    qPos.add(hasTeam);
                }

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

    public int countByC_N_D(String departmentsCode, String departmentsName,
        String abbreviateName, String description) throws SystemException {
        boolean finderClassNameCacheEnabled = DepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = Department.class.getName();
        String finderMethodName = "countByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                departmentsCode,
                
                departmentsName,
                
                abbreviateName,
                
                description
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

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.department.model.Department WHERE ");

                if (departmentsCode == null) {
                    query.append("departmentscode LIKE null");
                } else {
                    query.append("departmentscode LIKE ?");
                }

                query.append(" AND ");

                if (departmentsName == null) {
                    query.append("departmentsname LIKE null");
                } else {
                    query.append("departmentsname LIKE ?");
                }

                query.append(" AND ");

                if (abbreviateName == null) {
                    query.append("abbreviatename LIKE null");
                } else {
                    query.append("abbreviatename LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsCode != null) {
                    qPos.add(departmentsCode);
                }

                if (departmentsName != null) {
                    qPos.add(departmentsName);
                }

                if (abbreviateName != null) {
                    qPos.add(abbreviateName);
                }

                if (description != null) {
                    qPos.add(description);
                }

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
                        "SELECT COUNT(*) FROM com.sgs.portlet.department.model.Department");

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
                        "value.object.listener.com.sgs.portlet.department.model.Department")));

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
