package com.nss.portlet.department.service.persistence;

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

import com.nss.portlet.department.NoSuchDepartmentException;
import com.nss.portlet.department.model.Department;
import com.nss.portlet.department.model.impl.DepartmentImpl;
import com.nss.portlet.department.model.impl.DepartmentModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DepartmentPersistenceImpl extends BasePersistenceImpl
    implements DepartmentPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = DepartmentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByActive", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DEPARTMENTSPARENTID = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsParentId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DEPARTMENTSPARENTID = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsParentId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTSPARENTID = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDepartmentsParentId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DEPARTMENTSCODE_AGENCYID = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsCode_AgencyId",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DEPARTMENTSCODE_AGENCYID =
        new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsCode_AgencyId",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTSCODE_AGENCYID =
        new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDepartmentsCode_AgencyId",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DEPARTMENTSCODE = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsCode", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DEPARTMENTSCODE = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsCode",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTSCODE = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDepartmentsCode", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ROLEID = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByRoleId", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ROLEID = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByRoleId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ROLEID = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByRoleId", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DEPARTMENTSNAME = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DEPARTMENTSNAME = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTSNAME = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDepartmentsName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ABBREVIATENAME = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAbbreviateName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ABBREVIATENAME = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAbbreviateName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ABBREVIATENAME = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByAbbreviateName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DESCRIPTION = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DESCRIPTION = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_AGENCYID = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAgencyId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_AGENCYID = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAgencyId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_AGENCYID = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByAgencyId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_HASTEAM = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByHasTeam", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_HASTEAM = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByHasTeam",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_HASTEAM = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByHasTeam", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_C_N_D = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByC_N_D",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_C_N_D = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByC_N_D",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_C_N_D = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByC_N_D",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(), String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(DepartmentPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.department.service.persistence.DepartmentPersistence.impl")
    protected com.nss.portlet.department.service.persistence.DepartmentPersistence departmentPersistence;
    @BeanReference(name = "com.nss.portlet.department.service.persistence.PmlUserPersistence.impl")
    protected com.nss.portlet.department.service.persistence.PmlUserPersistence pmlUserPersistence;
    @BeanReference(name = "com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPersistence.impl")
    protected com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPersistence pmlDepartmentsLeaderPersistence;

    public void cacheResult(Department department) {
        EntityCacheUtil.putResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentImpl.class, department.getPrimaryKey(), department);
    }

    public void cacheResult(List<Department> departments) {
        for (Department department : departments) {
            if (EntityCacheUtil.getResult(
                        DepartmentModelImpl.ENTITY_CACHE_ENABLED,
                        DepartmentImpl.class, department.getPrimaryKey(), this) == null) {
                cacheResult(department);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(DepartmentImpl.class.getName());
        EntityCacheUtil.clearCache(DepartmentImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

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
        for (ModelListener<Department> listener : listeners) {
            listener.onBeforeRemove(department);
        }

        department = removeImpl(department);

        for (ModelListener<Department> listener : listeners) {
            listener.onAfterRemove(department);
        }

        return department;
    }

    protected Department removeImpl(Department department)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (department.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(DepartmentImpl.class,
                        department.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(department);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentImpl.class, department.getPrimaryKey());

        return department;
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

        for (ModelListener<Department> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(department);
            } else {
                listener.onBeforeUpdate(department);
            }
        }

        department = updateImpl(department, merge);

        for (ModelListener<Department> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(department);
            } else {
                listener.onAfterUpdate(department);
            }
        }

        return department;
    }

    public Department updateImpl(
        com.nss.portlet.department.model.Department department, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, department, merge);

            department.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
            DepartmentImpl.class, department.getPrimaryKey(), department);

        return department;
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
        Department department = (Department) EntityCacheUtil.getResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
                DepartmentImpl.class, departmentsId, this);

        if (department == null) {
            Session session = null;

            try {
                session = openSession();

                department = (Department) session.get(DepartmentImpl.class,
                        departmentsId);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (department != null) {
                    cacheResult(department);
                }

                closeSession(session);
            }
        }

        return department;
    }

    public List<Department> findByActive(String active)
        throws SystemException {
        Object[] finderArgs = new Object[] { active };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Department> findByActive(String active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<Department> findByActive(String active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                active,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = (List<Department>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Department findByActive_First(String active, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.department.model.Department WHERE ");

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
        Object[] finderArgs = new Object[] { departmentsParentId };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DEPARTMENTSPARENTID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DEPARTMENTSPARENTID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Department> findByDepartmentsParentId(
        String departmentsParentId, int start, int end)
        throws SystemException {
        return findByDepartmentsParentId(departmentsParentId, start, end, null);
    }

    public List<Department> findByDepartmentsParentId(
        String departmentsParentId, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                departmentsParentId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSPARENTID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = (List<Department>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSPARENTID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Department findByDepartmentsParentId_First(
        String departmentsParentId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByDepartmentsParentId(departmentsParentId,
                0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.department.model.Department WHERE ");

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
        Object[] finderArgs = new Object[] { departmentsCode, agencyId };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DEPARTMENTSCODE_AGENCYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DEPARTMENTSCODE_AGENCYID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] {
                departmentsCode,
                
                agencyId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSCODE_AGENCYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = (List<Department>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSCODE_AGENCYID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Department findByDepartmentsCode_AgencyId_First(
        String departmentsCode, String agencyId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByDepartmentsCode_AgencyId(departmentsCode,
                agencyId, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.department.model.Department WHERE ");

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
        Object[] finderArgs = new Object[] { departmentsCode };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DEPARTMENTSCODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DEPARTMENTSCODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Department> findByDepartmentsCode(String departmentsCode,
        int start, int end) throws SystemException {
        return findByDepartmentsCode(departmentsCode, start, end, null);
    }

    public List<Department> findByDepartmentsCode(String departmentsCode,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                departmentsCode,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSCODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = (List<Department>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSCODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Department findByDepartmentsCode_First(String departmentsCode,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByDepartmentsCode(departmentsCode, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.department.model.Department WHERE ");

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
        Object[] finderArgs = new Object[] { new Long(roleId) };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROLEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

                query.append("roleid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("departmentsname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(roleId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROLEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Department> findByRoleId(long roleId, int start, int end)
        throws SystemException {
        return findByRoleId(roleId, start, end, null);
    }

    public List<Department> findByRoleId(long roleId, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(roleId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ROLEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = (List<Department>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ROLEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Department findByRoleId_First(long roleId, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByRoleId(roleId, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.department.model.Department WHERE ");

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
        Object[] finderArgs = new Object[] { departmentsName };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DEPARTMENTSNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DEPARTMENTSNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Department> findByDepartmentsName(String departmentsName,
        int start, int end) throws SystemException {
        return findByDepartmentsName(departmentsName, start, end, null);
    }

    public List<Department> findByDepartmentsName(String departmentsName,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                departmentsName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = (List<Department>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Department findByDepartmentsName_First(String departmentsName,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByDepartmentsName(departmentsName, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.department.model.Department WHERE ");

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
        Object[] finderArgs = new Object[] { abbreviateName };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ABBREVIATENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ABBREVIATENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Department> findByAbbreviateName(String abbreviateName,
        int start, int end) throws SystemException {
        return findByAbbreviateName(abbreviateName, start, end, null);
    }

    public List<Department> findByAbbreviateName(String abbreviateName,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                abbreviateName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ABBREVIATENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = (List<Department>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ABBREVIATENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Department findByAbbreviateName_First(String abbreviateName,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByAbbreviateName(abbreviateName, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.department.model.Department WHERE ");

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
        Object[] finderArgs = new Object[] { description };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Department> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<Department> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = (List<Department>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Department findByDescription_First(String description,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByDescription(description, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.department.model.Department WHERE ");

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
        Object[] finderArgs = new Object[] { agencyId };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_AGENCYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_AGENCYID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Department> findByAgencyId(String agencyId, int start, int end)
        throws SystemException {
        return findByAgencyId(agencyId, start, end, null);
    }

    public List<Department> findByAgencyId(String agencyId, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                agencyId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_AGENCYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = (List<Department>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_AGENCYID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Department findByAgencyId_First(String agencyId,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByAgencyId(agencyId, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.department.model.Department WHERE ");

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
        Object[] finderArgs = new Object[] { hasTeam };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_HASTEAM,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_HASTEAM,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<Department> findByHasTeam(String hasTeam, int start, int end)
        throws SystemException {
        return findByHasTeam(hasTeam, start, end, null);
    }

    public List<Department> findByHasTeam(String hasTeam, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                hasTeam,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_HASTEAM,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = (List<Department>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_HASTEAM,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Department findByHasTeam_First(String hasTeam, OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByHasTeam(hasTeam, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.department.model.Department WHERE ");

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
        Object[] finderArgs = new Object[] {
                departmentsCode,
                
                departmentsName,
                
                abbreviateName,
                
                description
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_C_N_D,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_C_N_D,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] {
                departmentsCode,
                
                departmentsName,
                
                abbreviateName,
                
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_C_N_D,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                list = (List<Department>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_C_N_D,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public Department findByC_N_D_First(String departmentsCode,
        String departmentsName, String abbreviateName, String description,
        OrderByComparator obc)
        throws NoSuchDepartmentException, SystemException {
        List<Department> list = findByC_N_D(departmentsCode, departmentsName,
                abbreviateName, description, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.department.model.Department WHERE ");

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
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<Department> list = (List<Department>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.Department ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("departmentsname ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<Department>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Department>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<Department>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] { active };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

    public int countByDepartmentsParentId(String departmentsParentId)
        throws SystemException {
        Object[] finderArgs = new Object[] { departmentsParentId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTSPARENTID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTSPARENTID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDepartmentsCode_AgencyId(String departmentsCode,
        String agencyId) throws SystemException {
        Object[] finderArgs = new Object[] { departmentsCode, agencyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTSCODE_AGENCYID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTSCODE_AGENCYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDepartmentsCode(String departmentsCode)
        throws SystemException {
        Object[] finderArgs = new Object[] { departmentsCode };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTSCODE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTSCODE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByRoleId(long roleId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(roleId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROLEID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

                query.append("roleid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(roleId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROLEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDepartmentsName(String departmentsName)
        throws SystemException {
        Object[] finderArgs = new Object[] { departmentsName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTSNAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTSNAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByAbbreviateName(String abbreviateName)
        throws SystemException {
        Object[] finderArgs = new Object[] { abbreviateName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ABBREVIATENAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ABBREVIATENAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDescription(String description) throws SystemException {
        Object[] finderArgs = new Object[] { description };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByAgencyId(String agencyId) throws SystemException {
        Object[] finderArgs = new Object[] { agencyId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AGENCYID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AGENCYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByHasTeam(String hasTeam) throws SystemException {
        Object[] finderArgs = new Object[] { hasTeam };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_HASTEAM,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HASTEAM,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByC_N_D(String departmentsCode, String departmentsName,
        String abbreviateName, String description) throws SystemException {
        Object[] finderArgs = new Object[] {
                departmentsCode,
                
                departmentsName,
                
                abbreviateName,
                
                description
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_N_D,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.Department WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_N_D,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.department.model.Department");

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
                        "value.object.listener.com.nss.portlet.department.model.Department")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Department>> listenersList = new ArrayList<ModelListener<Department>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Department>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
