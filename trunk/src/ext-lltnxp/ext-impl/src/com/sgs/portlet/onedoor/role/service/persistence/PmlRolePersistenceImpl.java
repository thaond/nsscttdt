package com.sgs.portlet.onedoor.role.service.persistence;

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

import com.sgs.portlet.onedoor.role.NoSuchPmlRoleException;
import com.sgs.portlet.onedoor.role.model.PmlRole;
import com.sgs.portlet.onedoor.role.model.impl.PmlRoleImpl;
import com.sgs.portlet.onedoor.role.model.impl.PmlRoleModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlRolePersistenceImpl extends BasePersistenceImpl
    implements PmlRolePersistence {
    private static Log _log = LogFactory.getLog(PmlRolePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlRole create(String roleId) {
        PmlRole pmlRole = new PmlRoleImpl();

        pmlRole.setNew(true);
        pmlRole.setPrimaryKey(roleId);

        return pmlRole;
    }

    public PmlRole remove(String roleId)
        throws NoSuchPmlRoleException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlRole pmlRole = (PmlRole) session.get(PmlRoleImpl.class, roleId);

            if (pmlRole == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlRole exists with the primary key " +
                        roleId);
                }

                throw new NoSuchPmlRoleException(
                    "No PmlRole exists with the primary key " + roleId);
            }

            return remove(pmlRole);
        } catch (NoSuchPmlRoleException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlRole remove(PmlRole pmlRole) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlRole);
            }
        }

        pmlRole = removeImpl(pmlRole);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlRole);
            }
        }

        return pmlRole;
    }

    protected PmlRole removeImpl(PmlRole pmlRole) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlRole);

            session.flush();

            return pmlRole;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlRole.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlRole pmlRole, boolean merge)</code>.
     */
    public PmlRole update(PmlRole pmlRole) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlRole pmlRole) method. Use update(PmlRole pmlRole, boolean merge) instead.");
        }

        return update(pmlRole, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlRole the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlRole is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlRole update(PmlRole pmlRole, boolean merge)
        throws SystemException {
        boolean isNew = pmlRole.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlRole);
                } else {
                    listener.onBeforeUpdate(pmlRole);
                }
            }
        }

        pmlRole = updateImpl(pmlRole, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlRole);
                } else {
                    listener.onAfterUpdate(pmlRole);
                }
            }
        }

        return pmlRole;
    }

    public PmlRole updateImpl(
        com.sgs.portlet.onedoor.role.model.PmlRole pmlRole, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlRole);
            } else {
                if (pmlRole.isNew()) {
                    session.save(pmlRole);
                }
            }

            session.flush();

            pmlRole.setNew(false);

            return pmlRole;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlRole.class.getName());
        }
    }

    public PmlRole findByPrimaryKey(String roleId)
        throws NoSuchPmlRoleException, SystemException {
        PmlRole pmlRole = fetchByPrimaryKey(roleId);

        if (pmlRole == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlRole exists with the primary key " + roleId);
            }

            throw new NoSuchPmlRoleException(
                "No PmlRole exists with the primary key " + roleId);
        }

        return pmlRole;
    }

    public PmlRole fetchByPrimaryKey(String roleId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlRole) session.get(PmlRoleImpl.class, roleId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlRole> findByRoleCode(String roleCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
        String finderMethodName = "findByRoleCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { roleCode };

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
                    "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

                if (roleCode == null) {
                    query.append("rolecode LIKE null");
                } else {
                    query.append("rolecode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("rolename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roleCode != null) {
                    qPos.add(roleCode);
                }

                List<PmlRole> list = q.list();

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
            return (List<PmlRole>) result;
        }
    }

    public List<PmlRole> findByRoleCode(String roleCode, int start, int end)
        throws SystemException {
        return findByRoleCode(roleCode, start, end, null);
    }

    public List<PmlRole> findByRoleCode(String roleCode, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
        String finderMethodName = "findByRoleCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                roleCode,
                
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
                    "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

                if (roleCode == null) {
                    query.append("rolecode LIKE null");
                } else {
                    query.append("rolecode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("rolename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roleCode != null) {
                    qPos.add(roleCode);
                }

                List<PmlRole> list = (List<PmlRole>) QueryUtil.list(q,
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
            return (List<PmlRole>) result;
        }
    }

    public PmlRole findByRoleCode_First(String roleCode, OrderByComparator obc)
        throws NoSuchPmlRoleException, SystemException {
        List<PmlRole> list = findByRoleCode(roleCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlRole exists with the key {");

            msg.append("roleCode=" + roleCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlRoleException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlRole findByRoleCode_Last(String roleCode, OrderByComparator obc)
        throws NoSuchPmlRoleException, SystemException {
        int count = countByRoleCode(roleCode);

        List<PmlRole> list = findByRoleCode(roleCode, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlRole exists with the key {");

            msg.append("roleCode=" + roleCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlRoleException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlRole[] findByRoleCode_PrevAndNext(String roleId, String roleCode,
        OrderByComparator obc) throws NoSuchPmlRoleException, SystemException {
        PmlRole pmlRole = findByPrimaryKey(roleId);

        int count = countByRoleCode(roleCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

            if (roleCode == null) {
                query.append("rolecode LIKE null");
            } else {
                query.append("rolecode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("rolename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (roleCode != null) {
                qPos.add(roleCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlRole);

            PmlRole[] array = new PmlRoleImpl[3];

            array[0] = (PmlRole) objArray[0];
            array[1] = (PmlRole) objArray[1];
            array[2] = (PmlRole) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlRole> findByRoleName(String roleName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
        String finderMethodName = "findByRoleName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { roleName };

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
                    "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

                if (roleName == null) {
                    query.append("rolename LIKE null");
                } else {
                    query.append("rolename LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("rolename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roleName != null) {
                    qPos.add(roleName);
                }

                List<PmlRole> list = q.list();

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
            return (List<PmlRole>) result;
        }
    }

    public List<PmlRole> findByRoleName(String roleName, int start, int end)
        throws SystemException {
        return findByRoleName(roleName, start, end, null);
    }

    public List<PmlRole> findByRoleName(String roleName, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
        String finderMethodName = "findByRoleName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                roleName,
                
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
                    "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

                if (roleName == null) {
                    query.append("rolename LIKE null");
                } else {
                    query.append("rolename LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("rolename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roleName != null) {
                    qPos.add(roleName);
                }

                List<PmlRole> list = (List<PmlRole>) QueryUtil.list(q,
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
            return (List<PmlRole>) result;
        }
    }

    public PmlRole findByRoleName_First(String roleName, OrderByComparator obc)
        throws NoSuchPmlRoleException, SystemException {
        List<PmlRole> list = findByRoleName(roleName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlRole exists with the key {");

            msg.append("roleName=" + roleName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlRoleException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlRole findByRoleName_Last(String roleName, OrderByComparator obc)
        throws NoSuchPmlRoleException, SystemException {
        int count = countByRoleName(roleName);

        List<PmlRole> list = findByRoleName(roleName, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlRole exists with the key {");

            msg.append("roleName=" + roleName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlRoleException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlRole[] findByRoleName_PrevAndNext(String roleId, String roleName,
        OrderByComparator obc) throws NoSuchPmlRoleException, SystemException {
        PmlRole pmlRole = findByPrimaryKey(roleId);

        int count = countByRoleName(roleName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

            if (roleName == null) {
                query.append("rolename LIKE null");
            } else {
                query.append("rolename LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("rolename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (roleName != null) {
                qPos.add(roleName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlRole);

            PmlRole[] array = new PmlRoleImpl[3];

            array[0] = (PmlRole) objArray[0];
            array[1] = (PmlRole) objArray[1];
            array[2] = (PmlRole) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlRole> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("rolename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<PmlRole> list = q.list();

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
            return (List<PmlRole>) result;
        }
    }

    public List<PmlRole> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<PmlRole> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

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

                    query.append("rolename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<PmlRole> list = (List<PmlRole>) QueryUtil.list(q,
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
            return (List<PmlRole>) result;
        }
    }

    public PmlRole findByDescription_First(String description,
        OrderByComparator obc) throws NoSuchPmlRoleException, SystemException {
        List<PmlRole> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlRole exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlRoleException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlRole findByDescription_Last(String description,
        OrderByComparator obc) throws NoSuchPmlRoleException, SystemException {
        int count = countByDescription(description);

        List<PmlRole> list = findByDescription(description, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlRole exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlRoleException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlRole[] findByDescription_PrevAndNext(String roleId,
        String description, OrderByComparator obc)
        throws NoSuchPmlRoleException, SystemException {
        PmlRole pmlRole = findByPrimaryKey(roleId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

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

                query.append("rolename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlRole);

            PmlRole[] array = new PmlRoleImpl[3];

            array[0] = (PmlRole) objArray[0];
            array[1] = (PmlRole) objArray[1];
            array[2] = (PmlRole) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlRole> findByC_N_D(String roleCode, String roleName,
        String description) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { roleCode, roleName, description };

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
                    "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

                if (roleCode == null) {
                    query.append("rolecode LIKE null");
                } else {
                    query.append("rolecode LIKE ?");
                }

                query.append(" AND ");

                if (roleName == null) {
                    query.append("rolename LIKE null");
                } else {
                    query.append("rolename LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("rolename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roleCode != null) {
                    qPos.add(roleCode);
                }

                if (roleName != null) {
                    qPos.add(roleName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<PmlRole> list = q.list();

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
            return (List<PmlRole>) result;
        }
    }

    public List<PmlRole> findByC_N_D(String roleCode, String roleName,
        String description, int start, int end) throws SystemException {
        return findByC_N_D(roleCode, roleName, description, start, end, null);
    }

    public List<PmlRole> findByC_N_D(String roleCode, String roleName,
        String description, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                roleCode,
                
                roleName,
                
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
                    "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

                if (roleCode == null) {
                    query.append("rolecode LIKE null");
                } else {
                    query.append("rolecode LIKE ?");
                }

                query.append(" AND ");

                if (roleName == null) {
                    query.append("rolename LIKE null");
                } else {
                    query.append("rolename LIKE ?");
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

                    query.append("rolename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roleCode != null) {
                    qPos.add(roleCode);
                }

                if (roleName != null) {
                    qPos.add(roleName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<PmlRole> list = (List<PmlRole>) QueryUtil.list(q,
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
            return (List<PmlRole>) result;
        }
    }

    public PmlRole findByC_N_D_First(String roleCode, String roleName,
        String description, OrderByComparator obc)
        throws NoSuchPmlRoleException, SystemException {
        List<PmlRole> list = findByC_N_D(roleCode, roleName, description, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlRole exists with the key {");

            msg.append("roleCode=" + roleCode);

            msg.append(", ");
            msg.append("roleName=" + roleName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlRoleException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlRole findByC_N_D_Last(String roleCode, String roleName,
        String description, OrderByComparator obc)
        throws NoSuchPmlRoleException, SystemException {
        int count = countByC_N_D(roleCode, roleName, description);

        List<PmlRole> list = findByC_N_D(roleCode, roleName, description,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlRole exists with the key {");

            msg.append("roleCode=" + roleCode);

            msg.append(", ");
            msg.append("roleName=" + roleName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlRoleException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlRole[] findByC_N_D_PrevAndNext(String roleId, String roleCode,
        String roleName, String description, OrderByComparator obc)
        throws NoSuchPmlRoleException, SystemException {
        PmlRole pmlRole = findByPrimaryKey(roleId);

        int count = countByC_N_D(roleCode, roleName, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

            if (roleCode == null) {
                query.append("rolecode LIKE null");
            } else {
                query.append("rolecode LIKE ?");
            }

            query.append(" AND ");

            if (roleName == null) {
                query.append("rolename LIKE null");
            } else {
                query.append("rolename LIKE ?");
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

                query.append("rolename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (roleCode != null) {
                qPos.add(roleCode);
            }

            if (roleName != null) {
                qPos.add(roleName);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlRole);

            PmlRole[] array = new PmlRoleImpl[3];

            array[0] = (PmlRole) objArray[0];
            array[1] = (PmlRole) objArray[1];
            array[2] = (PmlRole) objArray[2];

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

    public List<PmlRole> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlRole> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlRole> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
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

                query.append("FROM com.sgs.portlet.onedoor.role.model.PmlRole ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("rolename ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlRole> list = (List<PmlRole>) QueryUtil.list(q,
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
            return (List<PmlRole>) result;
        }
    }

    public void removeByRoleCode(String roleCode) throws SystemException {
        for (PmlRole pmlRole : findByRoleCode(roleCode)) {
            remove(pmlRole);
        }
    }

    public void removeByRoleName(String roleName) throws SystemException {
        for (PmlRole pmlRole : findByRoleName(roleName)) {
            remove(pmlRole);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (PmlRole pmlRole : findByDescription(description)) {
            remove(pmlRole);
        }
    }

    public void removeByC_N_D(String roleCode, String roleName,
        String description) throws SystemException {
        for (PmlRole pmlRole : findByC_N_D(roleCode, roleName, description)) {
            remove(pmlRole);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlRole pmlRole : findAll()) {
            remove(pmlRole);
        }
    }

    public int countByRoleCode(String roleCode) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
        String finderMethodName = "countByRoleCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { roleCode };

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
                    "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

                if (roleCode == null) {
                    query.append("rolecode LIKE null");
                } else {
                    query.append("rolecode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roleCode != null) {
                    qPos.add(roleCode);
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

    public int countByRoleName(String roleName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
        String finderMethodName = "countByRoleName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { roleName };

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
                    "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

                if (roleName == null) {
                    query.append("rolename LIKE null");
                } else {
                    query.append("rolename LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roleName != null) {
                    qPos.add(roleName);
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
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

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

    public int countByC_N_D(String roleCode, String roleName, String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
        String finderMethodName = "countByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { roleCode, roleName, description };

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
                    "FROM com.sgs.portlet.onedoor.role.model.PmlRole WHERE ");

                if (roleCode == null) {
                    query.append("rolecode LIKE null");
                } else {
                    query.append("rolecode LIKE ?");
                }

                query.append(" AND ");

                if (roleName == null) {
                    query.append("rolename LIKE null");
                } else {
                    query.append("rolename LIKE ?");
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

                if (roleCode != null) {
                    qPos.add(roleCode);
                }

                if (roleName != null) {
                    qPos.add(roleName);
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
        boolean finderClassNameCacheEnabled = PmlRoleModelImpl.CACHE_ENABLED;
        String finderClassName = PmlRole.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoor.role.model.PmlRole");

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
                        "value.object.listener.com.sgs.portlet.onedoor.role.model.PmlRole")));

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
