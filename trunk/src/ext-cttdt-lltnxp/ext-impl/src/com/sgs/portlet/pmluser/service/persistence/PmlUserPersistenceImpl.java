package com.sgs.portlet.pmluser.service.persistence;

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

import com.sgs.portlet.pmluser.NoSuchPmlUserException;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.model.impl.PmlUserImpl;
import com.sgs.portlet.pmluser.model.impl.PmlUserModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlUserPersistenceImpl extends BasePersistenceImpl
    implements PmlUserPersistence {
    private static Log _log = LogFactory.getLog(PmlUserPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlUser create(long userId) {
        PmlUser pmlUser = new PmlUserImpl();

        pmlUser.setNew(true);
        pmlUser.setPrimaryKey(userId);

        return pmlUser;
    }

    public PmlUser remove(long userId)
        throws NoSuchPmlUserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlUser pmlUser = (PmlUser) session.get(PmlUserImpl.class,
                    new Long(userId));

            if (pmlUser == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlUser exists with the primary key " +
                        userId);
                }

                throw new NoSuchPmlUserException(
                    "No PmlUser exists with the primary key " + userId);
            }

            return remove(pmlUser);
        } catch (NoSuchPmlUserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlUser remove(PmlUser pmlUser) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlUser);
            }
        }

        pmlUser = removeImpl(pmlUser);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlUser);
            }
        }

        return pmlUser;
    }

    protected PmlUser removeImpl(PmlUser pmlUser) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlUser);

            session.flush();

            return pmlUser;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlUser.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlUser pmlUser, boolean merge)</code>.
     */
    public PmlUser update(PmlUser pmlUser) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlUser pmlUser) method. Use update(PmlUser pmlUser, boolean merge) instead.");
        }

        return update(pmlUser, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlUser the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlUser is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlUser update(PmlUser pmlUser, boolean merge)
        throws SystemException {
        boolean isNew = pmlUser.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlUser);
                } else {
                    listener.onBeforeUpdate(pmlUser);
                }
            }
        }

        pmlUser = updateImpl(pmlUser, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlUser);
                } else {
                    listener.onAfterUpdate(pmlUser);
                }
            }
        }

        return pmlUser;
    }

    public PmlUser updateImpl(com.sgs.portlet.pmluser.model.PmlUser pmlUser,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlUser);
            } else {
                if (pmlUser.isNew()) {
                    session.save(pmlUser);
                }
            }

            session.flush();

            pmlUser.setNew(false);

            return pmlUser;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlUser.class.getName());
        }
    }

    public PmlUser findByPrimaryKey(long userId)
        throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = fetchByPrimaryKey(userId);

        if (pmlUser == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlUser exists with the primary key " + userId);
            }

            throw new NoSuchPmlUserException(
                "No PmlUser exists with the primary key " + userId);
        }

        return pmlUser;
    }

    public PmlUser fetchByPrimaryKey(long userId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlUser) session.get(PmlUserImpl.class, new Long(userId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUser> findByPositionId(String positionId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByPositionId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { positionId };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (positionId == null) {
                    query.append("positionId LIKE null");
                } else {
                    query.append("positionId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionId != null) {
                    qPos.add(positionId);
                }

                List<PmlUser> list = q.list();

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
            return (List<PmlUser>) result;
        }
    }

    public List<PmlUser> findByPositionId(String positionId, int start, int end)
        throws SystemException {
        return findByPositionId(positionId, start, end, null);
    }

    public List<PmlUser> findByPositionId(String positionId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByPositionId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                positionId,
                
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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (positionId == null) {
                    query.append("positionId LIKE null");
                } else {
                    query.append("positionId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("firstname ASC, ");
                    query.append("lastname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionId != null) {
                    qPos.add(positionId);
                }

                List<PmlUser> list = (List<PmlUser>) QueryUtil.list(q,
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
            return (List<PmlUser>) result;
        }
    }

    public PmlUser findByPositionId_First(String positionId,
        OrderByComparator obc) throws NoSuchPmlUserException, SystemException {
        List<PmlUser> list = findByPositionId(positionId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("positionId=" + positionId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser findByPositionId_Last(String positionId,
        OrderByComparator obc) throws NoSuchPmlUserException, SystemException {
        int count = countByPositionId(positionId);

        List<PmlUser> list = findByPositionId(positionId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("positionId=" + positionId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser[] findByPositionId_PrevAndNext(long userId,
        String positionId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = findByPrimaryKey(userId);

        int count = countByPositionId(positionId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

            if (positionId == null) {
                query.append("positionId LIKE null");
            } else {
                query.append("positionId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (positionId != null) {
                qPos.add(positionId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlUser);

            PmlUser[] array = new PmlUserImpl[3];

            array[0] = (PmlUser) objArray[0];
            array[1] = (PmlUser) objArray[1];
            array[2] = (PmlUser) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUser> findByTeamId(long teamId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByTeamId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(teamId) };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                query.append("teamid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(teamId);

                List<PmlUser> list = q.list();

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
            return (List<PmlUser>) result;
        }
    }

    public List<PmlUser> findByTeamId(long teamId, int start, int end)
        throws SystemException {
        return findByTeamId(teamId, start, end, null);
    }

    public List<PmlUser> findByTeamId(long teamId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByTeamId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(teamId),
                
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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                query.append("teamid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("firstname ASC, ");
                    query.append("lastname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(teamId);

                List<PmlUser> list = (List<PmlUser>) QueryUtil.list(q,
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
            return (List<PmlUser>) result;
        }
    }

    public PmlUser findByTeamId_First(long teamId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        List<PmlUser> list = findByTeamId(teamId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("teamId=" + teamId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser findByTeamId_Last(long teamId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        int count = countByTeamId(teamId);

        List<PmlUser> list = findByTeamId(teamId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("teamId=" + teamId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser[] findByTeamId_PrevAndNext(long userId, long teamId,
        OrderByComparator obc) throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = findByPrimaryKey(userId);

        int count = countByTeamId(teamId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

            query.append("teamid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(teamId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlUser);

            PmlUser[] array = new PmlUserImpl[3];

            array[0] = (PmlUser) objArray[0];
            array[1] = (PmlUser) objArray[1];
            array[2] = (PmlUser) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUser> findByDepartmentsId(String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByDepartmentsId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsId };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlUser> list = q.list();

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
            return (List<PmlUser>) result;
        }
    }

    public List<PmlUser> findByDepartmentsId(String departmentsId, int start,
        int end) throws SystemException {
        return findByDepartmentsId(departmentsId, start, end, null);
    }

    public List<PmlUser> findByDepartmentsId(String departmentsId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByDepartmentsId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentsId,
                
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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("firstname ASC, ");
                    query.append("lastname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlUser> list = (List<PmlUser>) QueryUtil.list(q,
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
            return (List<PmlUser>) result;
        }
    }

    public PmlUser findByDepartmentsId_First(String departmentsId,
        OrderByComparator obc) throws NoSuchPmlUserException, SystemException {
        List<PmlUser> list = findByDepartmentsId(departmentsId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser findByDepartmentsId_Last(String departmentsId,
        OrderByComparator obc) throws NoSuchPmlUserException, SystemException {
        int count = countByDepartmentsId(departmentsId);

        List<PmlUser> list = findByDepartmentsId(departmentsId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser[] findByDepartmentsId_PrevAndNext(long userId,
        String departmentsId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = findByPrimaryKey(userId);

        int count = countByDepartmentsId(departmentsId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

            if (departmentsId == null) {
                query.append("departmentsId LIKE null");
            } else {
                query.append("departmentsId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlUser);

            PmlUser[] array = new PmlUserImpl[3];

            array[0] = (PmlUser) objArray[0];
            array[1] = (PmlUser) objArray[1];
            array[2] = (PmlUser) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUser> findByRoleId(String roleId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByRoleId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { roleId };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (roleId == null) {
                    query.append("roleId LIKE null");
                } else {
                    query.append("roleId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roleId != null) {
                    qPos.add(roleId);
                }

                List<PmlUser> list = q.list();

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
            return (List<PmlUser>) result;
        }
    }

    public List<PmlUser> findByRoleId(String roleId, int start, int end)
        throws SystemException {
        return findByRoleId(roleId, start, end, null);
    }

    public List<PmlUser> findByRoleId(String roleId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByRoleId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                roleId,
                
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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (roleId == null) {
                    query.append("roleId LIKE null");
                } else {
                    query.append("roleId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("firstname ASC, ");
                    query.append("lastname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roleId != null) {
                    qPos.add(roleId);
                }

                List<PmlUser> list = (List<PmlUser>) QueryUtil.list(q,
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
            return (List<PmlUser>) result;
        }
    }

    public PmlUser findByRoleId_First(String roleId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        List<PmlUser> list = findByRoleId(roleId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("roleId=" + roleId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser findByRoleId_Last(String roleId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        int count = countByRoleId(roleId);

        List<PmlUser> list = findByRoleId(roleId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("roleId=" + roleId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser[] findByRoleId_PrevAndNext(long userId, String roleId,
        OrderByComparator obc) throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = findByPrimaryKey(userId);

        int count = countByRoleId(roleId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

            if (roleId == null) {
                query.append("roleId LIKE null");
            } else {
                query.append("roleId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (roleId != null) {
                qPos.add(roleId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlUser);

            PmlUser[] array = new PmlUserImpl[3];

            array[0] = (PmlUser) objArray[0];
            array[1] = (PmlUser) objArray[1];
            array[2] = (PmlUser) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUser> findByHandPhone(String handPhone)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByHandPhone";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { handPhone };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (handPhone == null) {
                    query.append("handphone LIKE null");
                } else {
                    query.append("handphone LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (handPhone != null) {
                    qPos.add(handPhone);
                }

                List<PmlUser> list = q.list();

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
            return (List<PmlUser>) result;
        }
    }

    public List<PmlUser> findByHandPhone(String handPhone, int start, int end)
        throws SystemException {
        return findByHandPhone(handPhone, start, end, null);
    }

    public List<PmlUser> findByHandPhone(String handPhone, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByHandPhone";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                handPhone,
                
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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (handPhone == null) {
                    query.append("handphone LIKE null");
                } else {
                    query.append("handphone LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("firstname ASC, ");
                    query.append("lastname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (handPhone != null) {
                    qPos.add(handPhone);
                }

                List<PmlUser> list = (List<PmlUser>) QueryUtil.list(q,
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
            return (List<PmlUser>) result;
        }
    }

    public PmlUser findByHandPhone_First(String handPhone, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        List<PmlUser> list = findByHandPhone(handPhone, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("handPhone=" + handPhone);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser findByHandPhone_Last(String handPhone, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        int count = countByHandPhone(handPhone);

        List<PmlUser> list = findByHandPhone(handPhone, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("handPhone=" + handPhone);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser[] findByHandPhone_PrevAndNext(long userId, String handPhone,
        OrderByComparator obc) throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = findByPrimaryKey(userId);

        int count = countByHandPhone(handPhone);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

            if (handPhone == null) {
                query.append("handphone LIKE null");
            } else {
                query.append("handphone LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (handPhone != null) {
                qPos.add(handPhone);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlUser);

            PmlUser[] array = new PmlUserImpl[3];

            array[0] = (PmlUser) objArray[0];
            array[1] = (PmlUser) objArray[1];
            array[2] = (PmlUser) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUser> findByNote(String note) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByNote";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { note };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("note LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                List<PmlUser> list = q.list();

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
            return (List<PmlUser>) result;
        }
    }

    public List<PmlUser> findByNote(String note, int start, int end)
        throws SystemException {
        return findByNote(note, start, end, null);
    }

    public List<PmlUser> findByNote(String note, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByNote";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                note,
                
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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("note LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("firstname ASC, ");
                    query.append("lastname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                List<PmlUser> list = (List<PmlUser>) QueryUtil.list(q,
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
            return (List<PmlUser>) result;
        }
    }

    public PmlUser findByNote_First(String note, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        List<PmlUser> list = findByNote(note, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser findByNote_Last(String note, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        int count = countByNote(note);

        List<PmlUser> list = findByNote(note, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser[] findByNote_PrevAndNext(long userId, String note,
        OrderByComparator obc) throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = findByPrimaryKey(userId);

        int count = countByNote(note);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

            if (note == null) {
                query.append("note LIKE null");
            } else {
                query.append("note LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (note != null) {
                qPos.add(note);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlUser);

            PmlUser[] array = new PmlUserImpl[3];

            array[0] = (PmlUser) objArray[0];
            array[1] = (PmlUser) objArray[1];
            array[2] = (PmlUser) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUser> findByP_D_R(String positionId, String departmentsId,
        String roleId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByP_D_R";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { positionId, departmentsId, roleId };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (positionId == null) {
                    query.append("positionId LIKE null");
                } else {
                    query.append("positionId LIKE ?");
                }

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" AND ");

                if (roleId == null) {
                    query.append("roleId LIKE null");
                } else {
                    query.append("roleId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionId != null) {
                    qPos.add(positionId);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                if (roleId != null) {
                    qPos.add(roleId);
                }

                List<PmlUser> list = q.list();

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
            return (List<PmlUser>) result;
        }
    }

    public List<PmlUser> findByP_D_R(String positionId, String departmentsId,
        String roleId, int start, int end) throws SystemException {
        return findByP_D_R(positionId, departmentsId, roleId, start, end, null);
    }

    public List<PmlUser> findByP_D_R(String positionId, String departmentsId,
        String roleId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByP_D_R";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                positionId,
                
                departmentsId,
                
                roleId,
                
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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (positionId == null) {
                    query.append("positionId LIKE null");
                } else {
                    query.append("positionId LIKE ?");
                }

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" AND ");

                if (roleId == null) {
                    query.append("roleId LIKE null");
                } else {
                    query.append("roleId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("firstname ASC, ");
                    query.append("lastname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionId != null) {
                    qPos.add(positionId);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                if (roleId != null) {
                    qPos.add(roleId);
                }

                List<PmlUser> list = (List<PmlUser>) QueryUtil.list(q,
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
            return (List<PmlUser>) result;
        }
    }

    public PmlUser findByP_D_R_First(String positionId, String departmentsId,
        String roleId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        List<PmlUser> list = findByP_D_R(positionId, departmentsId, roleId, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("positionId=" + positionId);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("roleId=" + roleId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser findByP_D_R_Last(String positionId, String departmentsId,
        String roleId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        int count = countByP_D_R(positionId, departmentsId, roleId);

        List<PmlUser> list = findByP_D_R(positionId, departmentsId, roleId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("positionId=" + positionId);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("roleId=" + roleId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser[] findByP_D_R_PrevAndNext(long userId, String positionId,
        String departmentsId, String roleId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = findByPrimaryKey(userId);

        int count = countByP_D_R(positionId, departmentsId, roleId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

            if (positionId == null) {
                query.append("positionId LIKE null");
            } else {
                query.append("positionId LIKE ?");
            }

            query.append(" AND ");

            if (departmentsId == null) {
                query.append("departmentsId LIKE null");
            } else {
                query.append("departmentsId LIKE ?");
            }

            query.append(" AND ");

            if (roleId == null) {
                query.append("roleId LIKE null");
            } else {
                query.append("roleId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (positionId != null) {
                qPos.add(positionId);
            }

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            if (roleId != null) {
                qPos.add(roleId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlUser);

            PmlUser[] array = new PmlUserImpl[3];

            array[0] = (PmlUser) objArray[0];
            array[1] = (PmlUser) objArray[1];
            array[2] = (PmlUser) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUser> findByDepartmentsId_Active(String departmentsId,
        boolean active) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByDepartmentsId_Active";
        String[] finderParams = new String[] {
                String.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                departmentsId, Boolean.valueOf(active)
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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" AND ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(active);

                List<PmlUser> list = q.list();

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
            return (List<PmlUser>) result;
        }
    }

    public List<PmlUser> findByDepartmentsId_Active(String departmentsId,
        boolean active, int start, int end) throws SystemException {
        return findByDepartmentsId_Active(departmentsId, active, start, end,
            null);
    }

    public List<PmlUser> findByDepartmentsId_Active(String departmentsId,
        boolean active, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "findByDepartmentsId_Active";
        String[] finderParams = new String[] {
                String.class.getName(), Boolean.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentsId, Boolean.valueOf(active),
                
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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" AND ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("firstname ASC, ");
                    query.append("lastname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(active);

                List<PmlUser> list = (List<PmlUser>) QueryUtil.list(q,
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
            return (List<PmlUser>) result;
        }
    }

    public PmlUser findByDepartmentsId_Active_First(String departmentsId,
        boolean active, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        List<PmlUser> list = findByDepartmentsId_Active(departmentsId, active,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser findByDepartmentsId_Active_Last(String departmentsId,
        boolean active, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        int count = countByDepartmentsId_Active(departmentsId, active);

        List<PmlUser> list = findByDepartmentsId_Active(departmentsId, active,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser[] findByDepartmentsId_Active_PrevAndNext(long userId,
        String departmentsId, boolean active, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = findByPrimaryKey(userId);

        int count = countByDepartmentsId_Active(departmentsId, active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

            if (departmentsId == null) {
                query.append("departmentsId LIKE null");
            } else {
                query.append("departmentsId LIKE ?");
            }

            query.append(" AND ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("firstname ASC, ");
                query.append("lastname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlUser);

            PmlUser[] array = new PmlUserImpl[3];

            array[0] = (PmlUser) objArray[0];
            array[1] = (PmlUser) objArray[1];
            array[2] = (PmlUser) objArray[2];

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

    public List<PmlUser> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlUser> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlUser> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
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

                query.append("FROM com.sgs.portlet.pmluser.model.PmlUser ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("firstname ASC, ");
                    query.append("lastname ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlUser> list = (List<PmlUser>) QueryUtil.list(q,
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
            return (List<PmlUser>) result;
        }
    }

    public void removeByPositionId(String positionId) throws SystemException {
        for (PmlUser pmlUser : findByPositionId(positionId)) {
            remove(pmlUser);
        }
    }

    public void removeByTeamId(long teamId) throws SystemException {
        for (PmlUser pmlUser : findByTeamId(teamId)) {
            remove(pmlUser);
        }
    }

    public void removeByDepartmentsId(String departmentsId)
        throws SystemException {
        for (PmlUser pmlUser : findByDepartmentsId(departmentsId)) {
            remove(pmlUser);
        }
    }

    public void removeByRoleId(String roleId) throws SystemException {
        for (PmlUser pmlUser : findByRoleId(roleId)) {
            remove(pmlUser);
        }
    }

    public void removeByHandPhone(String handPhone) throws SystemException {
        for (PmlUser pmlUser : findByHandPhone(handPhone)) {
            remove(pmlUser);
        }
    }

    public void removeByNote(String note) throws SystemException {
        for (PmlUser pmlUser : findByNote(note)) {
            remove(pmlUser);
        }
    }

    public void removeByP_D_R(String positionId, String departmentsId,
        String roleId) throws SystemException {
        for (PmlUser pmlUser : findByP_D_R(positionId, departmentsId, roleId)) {
            remove(pmlUser);
        }
    }

    public void removeByDepartmentsId_Active(String departmentsId,
        boolean active) throws SystemException {
        for (PmlUser pmlUser : findByDepartmentsId_Active(departmentsId, active)) {
            remove(pmlUser);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlUser pmlUser : findAll()) {
            remove(pmlUser);
        }
    }

    public int countByPositionId(String positionId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "countByPositionId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { positionId };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (positionId == null) {
                    query.append("positionId LIKE null");
                } else {
                    query.append("positionId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionId != null) {
                    qPos.add(positionId);
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

    public int countByTeamId(long teamId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "countByTeamId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(teamId) };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                query.append("teamid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(teamId);

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

    public int countByDepartmentsId(String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "countByDepartmentsId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsId };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
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

    public int countByRoleId(String roleId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "countByRoleId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { roleId };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (roleId == null) {
                    query.append("roleId LIKE null");
                } else {
                    query.append("roleId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roleId != null) {
                    qPos.add(roleId);
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

    public int countByHandPhone(String handPhone) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "countByHandPhone";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { handPhone };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (handPhone == null) {
                    query.append("handphone LIKE null");
                } else {
                    query.append("handphone LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (handPhone != null) {
                    qPos.add(handPhone);
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

    public int countByNote(String note) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "countByNote";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { note };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("note LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
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

    public int countByP_D_R(String positionId, String departmentsId,
        String roleId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "countByP_D_R";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] { positionId, departmentsId, roleId };

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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (positionId == null) {
                    query.append("positionId LIKE null");
                } else {
                    query.append("positionId LIKE ?");
                }

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" AND ");

                if (roleId == null) {
                    query.append("roleId LIKE null");
                } else {
                    query.append("roleId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionId != null) {
                    qPos.add(positionId);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                if (roleId != null) {
                    qPos.add(roleId);
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

    public int countByDepartmentsId_Active(String departmentsId, boolean active)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
        String finderMethodName = "countByDepartmentsId_Active";
        String[] finderParams = new String[] {
                String.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                departmentsId, Boolean.valueOf(active)
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
                    "FROM com.sgs.portlet.pmluser.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" AND ");

                query.append("active = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(active);

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
        boolean finderClassNameCacheEnabled = PmlUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUser.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.pmluser.model.PmlUser");

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
                        "value.object.listener.com.sgs.portlet.pmluser.model.PmlUser")));

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
