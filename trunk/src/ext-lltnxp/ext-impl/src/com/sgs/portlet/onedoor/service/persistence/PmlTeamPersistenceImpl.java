package com.sgs.portlet.onedoor.service.persistence;

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

import com.sgs.portlet.onedoor.NoSuchPmlTeamException;
import com.sgs.portlet.onedoor.model.PmlTeam;
import com.sgs.portlet.onedoor.model.impl.PmlTeamImpl;
import com.sgs.portlet.onedoor.model.impl.PmlTeamModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlTeamPersistenceImpl extends BasePersistenceImpl
    implements PmlTeamPersistence {
    private static Log _log = LogFactory.getLog(PmlTeamPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlTeam create(long teamId) {
        PmlTeam pmlTeam = new PmlTeamImpl();

        pmlTeam.setNew(true);
        pmlTeam.setPrimaryKey(teamId);

        return pmlTeam;
    }

    public PmlTeam remove(long teamId)
        throws NoSuchPmlTeamException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlTeam pmlTeam = (PmlTeam) session.get(PmlTeamImpl.class,
                    new Long(teamId));

            if (pmlTeam == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlTeam exists with the primary key " +
                        teamId);
                }

                throw new NoSuchPmlTeamException(
                    "No PmlTeam exists with the primary key " + teamId);
            }

            return remove(pmlTeam);
        } catch (NoSuchPmlTeamException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlTeam remove(PmlTeam pmlTeam) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlTeam);
            }
        }

        pmlTeam = removeImpl(pmlTeam);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlTeam);
            }
        }

        return pmlTeam;
    }

    protected PmlTeam removeImpl(PmlTeam pmlTeam) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlTeam);

            session.flush();

            return pmlTeam;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlTeam.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlTeam pmlTeam, boolean merge)</code>.
     */
    public PmlTeam update(PmlTeam pmlTeam) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlTeam pmlTeam) method. Use update(PmlTeam pmlTeam, boolean merge) instead.");
        }

        return update(pmlTeam, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTeam the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTeam is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlTeam update(PmlTeam pmlTeam, boolean merge)
        throws SystemException {
        boolean isNew = pmlTeam.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlTeam);
                } else {
                    listener.onBeforeUpdate(pmlTeam);
                }
            }
        }

        pmlTeam = updateImpl(pmlTeam, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlTeam);
                } else {
                    listener.onAfterUpdate(pmlTeam);
                }
            }
        }

        return pmlTeam;
    }

    public PmlTeam updateImpl(com.sgs.portlet.onedoor.model.PmlTeam pmlTeam,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlTeam);
            } else {
                if (pmlTeam.isNew()) {
                    session.save(pmlTeam);
                }
            }

            session.flush();

            pmlTeam.setNew(false);

            return pmlTeam;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlTeam.class.getName());
        }
    }

    public PmlTeam findByPrimaryKey(long teamId)
        throws NoSuchPmlTeamException, SystemException {
        PmlTeam pmlTeam = fetchByPrimaryKey(teamId);

        if (pmlTeam == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlTeam exists with the primary key " + teamId);
            }

            throw new NoSuchPmlTeamException(
                "No PmlTeam exists with the primary key " + teamId);
        }

        return pmlTeam;
    }

    public PmlTeam fetchByPrimaryKey(long teamId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlTeam) session.get(PmlTeamImpl.class, new Long(teamId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTeam> findByDepartmentId_TeamCode(String departmentId,
        String teamCode) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "findByDepartmentId_TeamCode";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { departmentId, teamCode };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                if (departmentId == null) {
                    query.append("departmentid IS NULL");
                } else {
                    query.append("departmentid = ?");
                }

                query.append(" AND ");

                if (teamCode == null) {
                    query.append("teamcode IS NULL");
                } else {
                    query.append("teamcode = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("teamname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentId != null) {
                    qPos.add(departmentId);
                }

                if (teamCode != null) {
                    qPos.add(teamCode);
                }

                List<PmlTeam> list = q.list();

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
            return (List<PmlTeam>) result;
        }
    }

    public List<PmlTeam> findByDepartmentId_TeamCode(String departmentId,
        String teamCode, int start, int end) throws SystemException {
        return findByDepartmentId_TeamCode(departmentId, teamCode, start, end,
            null);
    }

    public List<PmlTeam> findByDepartmentId_TeamCode(String departmentId,
        String teamCode, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "findByDepartmentId_TeamCode";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentId,
                
                teamCode,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                if (departmentId == null) {
                    query.append("departmentid IS NULL");
                } else {
                    query.append("departmentid = ?");
                }

                query.append(" AND ");

                if (teamCode == null) {
                    query.append("teamcode IS NULL");
                } else {
                    query.append("teamcode = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("teamname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentId != null) {
                    qPos.add(departmentId);
                }

                if (teamCode != null) {
                    qPos.add(teamCode);
                }

                List<PmlTeam> list = (List<PmlTeam>) QueryUtil.list(q,
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
            return (List<PmlTeam>) result;
        }
    }

    public PmlTeam findByDepartmentId_TeamCode_First(String departmentId,
        String teamCode, OrderByComparator obc)
        throws NoSuchPmlTeamException, SystemException {
        List<PmlTeam> list = findByDepartmentId_TeamCode(departmentId,
                teamCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeam exists with the key {");

            msg.append("departmentId=" + departmentId);

            msg.append(", ");
            msg.append("teamCode=" + teamCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeam findByDepartmentId_TeamCode_Last(String departmentId,
        String teamCode, OrderByComparator obc)
        throws NoSuchPmlTeamException, SystemException {
        int count = countByDepartmentId_TeamCode(departmentId, teamCode);

        List<PmlTeam> list = findByDepartmentId_TeamCode(departmentId,
                teamCode, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeam exists with the key {");

            msg.append("departmentId=" + departmentId);

            msg.append(", ");
            msg.append("teamCode=" + teamCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeam[] findByDepartmentId_TeamCode_PrevAndNext(long teamId,
        String departmentId, String teamCode, OrderByComparator obc)
        throws NoSuchPmlTeamException, SystemException {
        PmlTeam pmlTeam = findByPrimaryKey(teamId);

        int count = countByDepartmentId_TeamCode(departmentId, teamCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

            if (departmentId == null) {
                query.append("departmentid IS NULL");
            } else {
                query.append("departmentid = ?");
            }

            query.append(" AND ");

            if (teamCode == null) {
                query.append("teamcode IS NULL");
            } else {
                query.append("teamcode = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("teamname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentId != null) {
                qPos.add(departmentId);
            }

            if (teamCode != null) {
                qPos.add(teamCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlTeam);

            PmlTeam[] array = new PmlTeamImpl[3];

            array[0] = (PmlTeam) objArray[0];
            array[1] = (PmlTeam) objArray[1];
            array[2] = (PmlTeam) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTeam> findByDepartmentId(String departmentId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "findByDepartmentId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentId };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                if (departmentId == null) {
                    query.append("departmentid LIKE null");
                } else {
                    query.append("departmentid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("teamname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentId != null) {
                    qPos.add(departmentId);
                }

                List<PmlTeam> list = q.list();

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
            return (List<PmlTeam>) result;
        }
    }

    public List<PmlTeam> findByDepartmentId(String departmentId, int start,
        int end) throws SystemException {
        return findByDepartmentId(departmentId, start, end, null);
    }

    public List<PmlTeam> findByDepartmentId(String departmentId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "findByDepartmentId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentId,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                if (departmentId == null) {
                    query.append("departmentid LIKE null");
                } else {
                    query.append("departmentid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("teamname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentId != null) {
                    qPos.add(departmentId);
                }

                List<PmlTeam> list = (List<PmlTeam>) QueryUtil.list(q,
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
            return (List<PmlTeam>) result;
        }
    }

    public PmlTeam findByDepartmentId_First(String departmentId,
        OrderByComparator obc) throws NoSuchPmlTeamException, SystemException {
        List<PmlTeam> list = findByDepartmentId(departmentId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeam exists with the key {");

            msg.append("departmentId=" + departmentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeam findByDepartmentId_Last(String departmentId,
        OrderByComparator obc) throws NoSuchPmlTeamException, SystemException {
        int count = countByDepartmentId(departmentId);

        List<PmlTeam> list = findByDepartmentId(departmentId, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeam exists with the key {");

            msg.append("departmentId=" + departmentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeam[] findByDepartmentId_PrevAndNext(long teamId,
        String departmentId, OrderByComparator obc)
        throws NoSuchPmlTeamException, SystemException {
        PmlTeam pmlTeam = findByPrimaryKey(teamId);

        int count = countByDepartmentId(departmentId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

            if (departmentId == null) {
                query.append("departmentid LIKE null");
            } else {
                query.append("departmentid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("teamname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentId != null) {
                qPos.add(departmentId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlTeam);

            PmlTeam[] array = new PmlTeamImpl[3];

            array[0] = (PmlTeam) objArray[0];
            array[1] = (PmlTeam) objArray[1];
            array[2] = (PmlTeam) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTeam> findByTeamCode(String teamCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "findByTeamCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { teamCode };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                if (teamCode == null) {
                    query.append("teamcode LIKE null");
                } else {
                    query.append("teamcode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("teamname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (teamCode != null) {
                    qPos.add(teamCode);
                }

                List<PmlTeam> list = q.list();

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
            return (List<PmlTeam>) result;
        }
    }

    public List<PmlTeam> findByTeamCode(String teamCode, int start, int end)
        throws SystemException {
        return findByTeamCode(teamCode, start, end, null);
    }

    public List<PmlTeam> findByTeamCode(String teamCode, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "findByTeamCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                teamCode,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                if (teamCode == null) {
                    query.append("teamcode LIKE null");
                } else {
                    query.append("teamcode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("teamname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (teamCode != null) {
                    qPos.add(teamCode);
                }

                List<PmlTeam> list = (List<PmlTeam>) QueryUtil.list(q,
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
            return (List<PmlTeam>) result;
        }
    }

    public PmlTeam findByTeamCode_First(String teamCode, OrderByComparator obc)
        throws NoSuchPmlTeamException, SystemException {
        List<PmlTeam> list = findByTeamCode(teamCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeam exists with the key {");

            msg.append("teamCode=" + teamCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeam findByTeamCode_Last(String teamCode, OrderByComparator obc)
        throws NoSuchPmlTeamException, SystemException {
        int count = countByTeamCode(teamCode);

        List<PmlTeam> list = findByTeamCode(teamCode, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeam exists with the key {");

            msg.append("teamCode=" + teamCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeam[] findByTeamCode_PrevAndNext(long teamId, String teamCode,
        OrderByComparator obc) throws NoSuchPmlTeamException, SystemException {
        PmlTeam pmlTeam = findByPrimaryKey(teamId);

        int count = countByTeamCode(teamCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

            if (teamCode == null) {
                query.append("teamcode LIKE null");
            } else {
                query.append("teamcode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("teamname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (teamCode != null) {
                qPos.add(teamCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlTeam);

            PmlTeam[] array = new PmlTeamImpl[3];

            array[0] = (PmlTeam) objArray[0];
            array[1] = (PmlTeam) objArray[1];
            array[2] = (PmlTeam) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTeam> findByTeamName(String teamName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "findByTeamName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { teamName };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                if (teamName == null) {
                    query.append("teamname LIKE null");
                } else {
                    query.append("teamname LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("teamname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (teamName != null) {
                    qPos.add(teamName);
                }

                List<PmlTeam> list = q.list();

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
            return (List<PmlTeam>) result;
        }
    }

    public List<PmlTeam> findByTeamName(String teamName, int start, int end)
        throws SystemException {
        return findByTeamName(teamName, start, end, null);
    }

    public List<PmlTeam> findByTeamName(String teamName, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "findByTeamName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                teamName,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                if (teamName == null) {
                    query.append("teamname LIKE null");
                } else {
                    query.append("teamname LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("teamname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (teamName != null) {
                    qPos.add(teamName);
                }

                List<PmlTeam> list = (List<PmlTeam>) QueryUtil.list(q,
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
            return (List<PmlTeam>) result;
        }
    }

    public PmlTeam findByTeamName_First(String teamName, OrderByComparator obc)
        throws NoSuchPmlTeamException, SystemException {
        List<PmlTeam> list = findByTeamName(teamName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeam exists with the key {");

            msg.append("teamName=" + teamName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeam findByTeamName_Last(String teamName, OrderByComparator obc)
        throws NoSuchPmlTeamException, SystemException {
        int count = countByTeamName(teamName);

        List<PmlTeam> list = findByTeamName(teamName, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeam exists with the key {");

            msg.append("teamName=" + teamName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeam[] findByTeamName_PrevAndNext(long teamId, String teamName,
        OrderByComparator obc) throws NoSuchPmlTeamException, SystemException {
        PmlTeam pmlTeam = findByPrimaryKey(teamId);

        int count = countByTeamName(teamName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

            if (teamName == null) {
                query.append("teamname LIKE null");
            } else {
                query.append("teamname LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("teamname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (teamName != null) {
                qPos.add(teamName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlTeam);

            PmlTeam[] array = new PmlTeamImpl[3];

            array[0] = (PmlTeam) objArray[0];
            array[1] = (PmlTeam) objArray[1];
            array[2] = (PmlTeam) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTeam> findByOrganizationId(long organizationId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "findByOrganizationId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(organizationId) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                query.append("organizationid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("teamname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(organizationId);

                List<PmlTeam> list = q.list();

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
            return (List<PmlTeam>) result;
        }
    }

    public List<PmlTeam> findByOrganizationId(long organizationId, int start,
        int end) throws SystemException {
        return findByOrganizationId(organizationId, start, end, null);
    }

    public List<PmlTeam> findByOrganizationId(long organizationId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "findByOrganizationId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(organizationId),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                query.append("organizationid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("teamname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(organizationId);

                List<PmlTeam> list = (List<PmlTeam>) QueryUtil.list(q,
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
            return (List<PmlTeam>) result;
        }
    }

    public PmlTeam findByOrganizationId_First(long organizationId,
        OrderByComparator obc) throws NoSuchPmlTeamException, SystemException {
        List<PmlTeam> list = findByOrganizationId(organizationId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeam exists with the key {");

            msg.append("organizationId=" + organizationId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeam findByOrganizationId_Last(long organizationId,
        OrderByComparator obc) throws NoSuchPmlTeamException, SystemException {
        int count = countByOrganizationId(organizationId);

        List<PmlTeam> list = findByOrganizationId(organizationId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeam exists with the key {");

            msg.append("organizationId=" + organizationId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeam[] findByOrganizationId_PrevAndNext(long teamId,
        long organizationId, OrderByComparator obc)
        throws NoSuchPmlTeamException, SystemException {
        PmlTeam pmlTeam = findByPrimaryKey(teamId);

        int count = countByOrganizationId(organizationId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

            query.append("organizationid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("teamname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(organizationId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlTeam);

            PmlTeam[] array = new PmlTeamImpl[3];

            array[0] = (PmlTeam) objArray[0];
            array[1] = (PmlTeam) objArray[1];
            array[2] = (PmlTeam) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTeam> findByCompanyId(long companyId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "findByCompanyId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(companyId) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                query.append("companyid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("teamname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                List<PmlTeam> list = q.list();

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
            return (List<PmlTeam>) result;
        }
    }

    public List<PmlTeam> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    public List<PmlTeam> findByCompanyId(long companyId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "findByCompanyId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(companyId),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                query.append("companyid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("teamname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                List<PmlTeam> list = (List<PmlTeam>) QueryUtil.list(q,
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
            return (List<PmlTeam>) result;
        }
    }

    public PmlTeam findByCompanyId_First(long companyId, OrderByComparator obc)
        throws NoSuchPmlTeamException, SystemException {
        List<PmlTeam> list = findByCompanyId(companyId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeam exists with the key {");

            msg.append("companyId=" + companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeam findByCompanyId_Last(long companyId, OrderByComparator obc)
        throws NoSuchPmlTeamException, SystemException {
        int count = countByCompanyId(companyId);

        List<PmlTeam> list = findByCompanyId(companyId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeam exists with the key {");

            msg.append("companyId=" + companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeam[] findByCompanyId_PrevAndNext(long teamId, long companyId,
        OrderByComparator obc) throws NoSuchPmlTeamException, SystemException {
        PmlTeam pmlTeam = findByPrimaryKey(teamId);

        int count = countByCompanyId(companyId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

            query.append("companyid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("teamname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(companyId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlTeam);

            PmlTeam[] array = new PmlTeamImpl[3];

            array[0] = (PmlTeam) objArray[0];
            array[1] = (PmlTeam) objArray[1];
            array[2] = (PmlTeam) objArray[2];

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

    public List<PmlTeam> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlTeam> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlTeam> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
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

                query.append("FROM com.sgs.portlet.onedoor.model.PmlTeam ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("teamname ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlTeam> list = (List<PmlTeam>) QueryUtil.list(q,
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
            return (List<PmlTeam>) result;
        }
    }

    public void removeByDepartmentId_TeamCode(String departmentId,
        String teamCode) throws SystemException {
        for (PmlTeam pmlTeam : findByDepartmentId_TeamCode(departmentId,
                teamCode)) {
            remove(pmlTeam);
        }
    }

    public void removeByDepartmentId(String departmentId)
        throws SystemException {
        for (PmlTeam pmlTeam : findByDepartmentId(departmentId)) {
            remove(pmlTeam);
        }
    }

    public void removeByTeamCode(String teamCode) throws SystemException {
        for (PmlTeam pmlTeam : findByTeamCode(teamCode)) {
            remove(pmlTeam);
        }
    }

    public void removeByTeamName(String teamName) throws SystemException {
        for (PmlTeam pmlTeam : findByTeamName(teamName)) {
            remove(pmlTeam);
        }
    }

    public void removeByOrganizationId(long organizationId)
        throws SystemException {
        for (PmlTeam pmlTeam : findByOrganizationId(organizationId)) {
            remove(pmlTeam);
        }
    }

    public void removeByCompanyId(long companyId) throws SystemException {
        for (PmlTeam pmlTeam : findByCompanyId(companyId)) {
            remove(pmlTeam);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlTeam pmlTeam : findAll()) {
            remove(pmlTeam);
        }
    }

    public int countByDepartmentId_TeamCode(String departmentId, String teamCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "countByDepartmentId_TeamCode";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { departmentId, teamCode };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                if (departmentId == null) {
                    query.append("departmentid IS NULL");
                } else {
                    query.append("departmentid = ?");
                }

                query.append(" AND ");

                if (teamCode == null) {
                    query.append("teamcode IS NULL");
                } else {
                    query.append("teamcode = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentId != null) {
                    qPos.add(departmentId);
                }

                if (teamCode != null) {
                    qPos.add(teamCode);
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

    public int countByDepartmentId(String departmentId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "countByDepartmentId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentId };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                if (departmentId == null) {
                    query.append("departmentid LIKE null");
                } else {
                    query.append("departmentid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentId != null) {
                    qPos.add(departmentId);
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

    public int countByTeamCode(String teamCode) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "countByTeamCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { teamCode };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                if (teamCode == null) {
                    query.append("teamcode LIKE null");
                } else {
                    query.append("teamcode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (teamCode != null) {
                    qPos.add(teamCode);
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

    public int countByTeamName(String teamName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "countByTeamName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { teamName };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                if (teamName == null) {
                    query.append("teamname LIKE null");
                } else {
                    query.append("teamname LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (teamName != null) {
                    qPos.add(teamName);
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

    public int countByOrganizationId(long organizationId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "countByOrganizationId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(organizationId) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                query.append("organizationid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(organizationId);

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

    public int countByCompanyId(long companyId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
        String finderMethodName = "countByCompanyId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(companyId) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlTeam WHERE ");

                query.append("companyid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

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
        boolean finderClassNameCacheEnabled = PmlTeamModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeam.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoor.model.PmlTeam");

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
                        "value.object.listener.com.sgs.portlet.onedoor.model.PmlTeam")));

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
