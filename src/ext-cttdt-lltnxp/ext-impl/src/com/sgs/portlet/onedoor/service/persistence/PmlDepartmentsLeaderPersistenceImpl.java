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

import com.sgs.portlet.onedoor.NoSuchPmlDepartmentsLeaderException;
import com.sgs.portlet.onedoor.model.PmlDepartmentsLeader;
import com.sgs.portlet.onedoor.model.impl.PmlDepartmentsLeaderImpl;
import com.sgs.portlet.onedoor.model.impl.PmlDepartmentsLeaderModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlDepartmentsLeaderPersistenceImpl extends BasePersistenceImpl
    implements PmlDepartmentsLeaderPersistence {
    private static Log _log = LogFactory.getLog(PmlDepartmentsLeaderPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlDepartmentsLeader create(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK) {
        PmlDepartmentsLeader pmlDepartmentsLeader = new PmlDepartmentsLeaderImpl();

        pmlDepartmentsLeader.setNew(true);
        pmlDepartmentsLeader.setPrimaryKey(pmlDepartmentsLeaderPK);

        return pmlDepartmentsLeader;
    }

    public PmlDepartmentsLeader remove(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlDepartmentsLeader pmlDepartmentsLeader = (PmlDepartmentsLeader) session.get(PmlDepartmentsLeaderImpl.class,
                    pmlDepartmentsLeaderPK);

            if (pmlDepartmentsLeader == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlDepartmentsLeader exists with the primary key " +
                        pmlDepartmentsLeaderPK);
                }

                throw new NoSuchPmlDepartmentsLeaderException(
                    "No PmlDepartmentsLeader exists with the primary key " +
                    pmlDepartmentsLeaderPK);
            }

            return remove(pmlDepartmentsLeader);
        } catch (NoSuchPmlDepartmentsLeaderException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlDepartmentsLeader remove(
        PmlDepartmentsLeader pmlDepartmentsLeader) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlDepartmentsLeader);
            }
        }

        pmlDepartmentsLeader = removeImpl(pmlDepartmentsLeader);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlDepartmentsLeader);
            }
        }

        return pmlDepartmentsLeader;
    }

    protected PmlDepartmentsLeader removeImpl(
        PmlDepartmentsLeader pmlDepartmentsLeader) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlDepartmentsLeader);

            session.flush();

            return pmlDepartmentsLeader;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDepartmentsLeader.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlDepartmentsLeader pmlDepartmentsLeader, boolean merge)</code>.
     */
    public PmlDepartmentsLeader update(
        PmlDepartmentsLeader pmlDepartmentsLeader) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlDepartmentsLeader pmlDepartmentsLeader) method. Use update(PmlDepartmentsLeader pmlDepartmentsLeader, boolean merge) instead.");
        }

        return update(pmlDepartmentsLeader, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDepartmentsLeader the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDepartmentsLeader is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlDepartmentsLeader update(
        PmlDepartmentsLeader pmlDepartmentsLeader, boolean merge)
        throws SystemException {
        boolean isNew = pmlDepartmentsLeader.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlDepartmentsLeader);
                } else {
                    listener.onBeforeUpdate(pmlDepartmentsLeader);
                }
            }
        }

        pmlDepartmentsLeader = updateImpl(pmlDepartmentsLeader, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlDepartmentsLeader);
                } else {
                    listener.onAfterUpdate(pmlDepartmentsLeader);
                }
            }
        }

        return pmlDepartmentsLeader;
    }

    public PmlDepartmentsLeader updateImpl(
        com.sgs.portlet.onedoor.model.PmlDepartmentsLeader pmlDepartmentsLeader,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlDepartmentsLeader);
            } else {
                if (pmlDepartmentsLeader.isNew()) {
                    session.save(pmlDepartmentsLeader);
                }
            }

            session.flush();

            pmlDepartmentsLeader.setNew(false);

            return pmlDepartmentsLeader;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDepartmentsLeader.class.getName());
        }
    }

    public PmlDepartmentsLeader findByPrimaryKey(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = fetchByPrimaryKey(pmlDepartmentsLeaderPK);

        if (pmlDepartmentsLeader == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlDepartmentsLeader exists with the primary key " +
                    pmlDepartmentsLeaderPK);
            }

            throw new NoSuchPmlDepartmentsLeaderException(
                "No PmlDepartmentsLeader exists with the primary key " +
                pmlDepartmentsLeaderPK);
        }

        return pmlDepartmentsLeader;
    }

    public PmlDepartmentsLeader fetchByPrimaryKey(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlDepartmentsLeader) session.get(PmlDepartmentsLeaderImpl.class,
                pmlDepartmentsLeaderPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId(String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlDepartmentsLeader> list = q.list();

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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId(
        String departmentsId, int start, int end) throws SystemException {
        return findByDepartmentsId(departmentsId, start, end, null);
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId(
        String departmentsId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public PmlDepartmentsLeader findByDepartmentsId_First(
        String departmentsId, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        List<PmlDepartmentsLeader> list = findByDepartmentsId(departmentsId, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader findByDepartmentsId_Last(String departmentsId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        int count = countByDepartmentsId(departmentsId);

        List<PmlDepartmentsLeader> list = findByDepartmentsId(departmentsId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader[] findByDepartmentsId_PrevAndNext(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK, String departmentsId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = findByPrimaryKey(pmlDepartmentsLeaderPK);

        int count = countByDepartmentsId(departmentsId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

            if (departmentsId == null) {
                query.append("departmentsId IS NULL");
            } else {
                query.append("departmentsId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDepartmentsLeader);

            PmlDepartmentsLeader[] array = new PmlDepartmentsLeaderImpl[3];

            array[0] = (PmlDepartmentsLeader) objArray[0];
            array[1] = (PmlDepartmentsLeader) objArray[1];
            array[2] = (PmlDepartmentsLeader) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDepartmentsLeader> findByUserId(long userId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "findByUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(userId) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<PmlDepartmentsLeader> list = q.list();

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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public List<PmlDepartmentsLeader> findByUserId(long userId, int start,
        int end) throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    public List<PmlDepartmentsLeader> findByUserId(long userId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "findByUserId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(userId),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                query.append("userId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public PmlDepartmentsLeader findByUserId_First(long userId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        List<PmlDepartmentsLeader> list = findByUserId(userId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader findByUserId_Last(long userId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        int count = countByUserId(userId);

        List<PmlDepartmentsLeader> list = findByUserId(userId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader[] findByUserId_PrevAndNext(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK, long userId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = findByPrimaryKey(pmlDepartmentsLeaderPK);

        int count = countByUserId(userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

            query.append("userId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDepartmentsLeader);

            PmlDepartmentsLeader[] array = new PmlDepartmentsLeaderImpl[3];

            array[0] = (PmlDepartmentsLeader) objArray[0];
            array[1] = (PmlDepartmentsLeader) objArray[1];
            array[2] = (PmlDepartmentsLeader) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId_UserId(
        String departmentsId, long userId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "findByDepartmentsId_UserId";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { departmentsId, new Long(userId) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" AND ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(userId);

                List<PmlDepartmentsLeader> list = q.list();

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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId_UserId(
        String departmentsId, long userId, int start, int end)
        throws SystemException {
        return findByDepartmentsId_UserId(departmentsId, userId, start, end,
            null);
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId_UserId(
        String departmentsId, long userId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "findByDepartmentsId_UserId";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentsId, new Long(userId),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" AND ");

                query.append("userId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(userId);

                List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public PmlDepartmentsLeader findByDepartmentsId_UserId_First(
        String departmentsId, long userId, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        List<PmlDepartmentsLeader> list = findByDepartmentsId_UserId(departmentsId,
                userId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader findByDepartmentsId_UserId_Last(
        String departmentsId, long userId, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        int count = countByDepartmentsId_UserId(departmentsId, userId);

        List<PmlDepartmentsLeader> list = findByDepartmentsId_UserId(departmentsId,
                userId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader[] findByDepartmentsId_UserId_PrevAndNext(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK, String departmentsId,
        long userId, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = findByPrimaryKey(pmlDepartmentsLeaderPK);

        int count = countByDepartmentsId_UserId(departmentsId, userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

            if (departmentsId == null) {
                query.append("departmentsId IS NULL");
            } else {
                query.append("departmentsId = ?");
            }

            query.append(" AND ");

            query.append("userId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            qPos.add(userId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDepartmentsLeader);

            PmlDepartmentsLeader[] array = new PmlDepartmentsLeaderImpl[3];

            array[0] = (PmlDepartmentsLeader) objArray[0];
            array[1] = (PmlDepartmentsLeader) objArray[1];
            array[2] = (PmlDepartmentsLeader) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDepartmentsLeader> findByClericalId(long clericalId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "findByClericalId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(clericalId) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                query.append("clericalid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(clericalId);

                List<PmlDepartmentsLeader> list = q.list();

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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public List<PmlDepartmentsLeader> findByClericalId(long clericalId,
        int start, int end) throws SystemException {
        return findByClericalId(clericalId, start, end, null);
    }

    public List<PmlDepartmentsLeader> findByClericalId(long clericalId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "findByClericalId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(clericalId),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                query.append("clericalid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(clericalId);

                List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public PmlDepartmentsLeader findByClericalId_First(long clericalId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        List<PmlDepartmentsLeader> list = findByClericalId(clericalId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("clericalId=" + clericalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader findByClericalId_Last(long clericalId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        int count = countByClericalId(clericalId);

        List<PmlDepartmentsLeader> list = findByClericalId(clericalId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("clericalId=" + clericalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader[] findByClericalId_PrevAndNext(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK, long clericalId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = findByPrimaryKey(pmlDepartmentsLeaderPK);

        int count = countByClericalId(clericalId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

            query.append("clericalid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(clericalId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDepartmentsLeader);

            PmlDepartmentsLeader[] array = new PmlDepartmentsLeaderImpl[3];

            array[0] = (PmlDepartmentsLeader) objArray[0];
            array[1] = (PmlDepartmentsLeader) objArray[1];
            array[2] = (PmlDepartmentsLeader) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId_Main(
        String departmentsId, boolean main) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "findByDepartmentsId_Main";
        String[] finderParams = new String[] {
                String.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] { departmentsId, Boolean.valueOf(main) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" AND ");

                query.append("main = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(main);

                List<PmlDepartmentsLeader> list = q.list();

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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId_Main(
        String departmentsId, boolean main, int start, int end)
        throws SystemException {
        return findByDepartmentsId_Main(departmentsId, main, start, end, null);
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId_Main(
        String departmentsId, boolean main, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "findByDepartmentsId_Main";
        String[] finderParams = new String[] {
                String.class.getName(), Boolean.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentsId, Boolean.valueOf(main),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" AND ");

                query.append("main = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(main);

                List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public PmlDepartmentsLeader findByDepartmentsId_Main_First(
        String departmentsId, boolean main, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        List<PmlDepartmentsLeader> list = findByDepartmentsId_Main(departmentsId,
                main, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("main=" + main);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader findByDepartmentsId_Main_Last(
        String departmentsId, boolean main, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        int count = countByDepartmentsId_Main(departmentsId, main);

        List<PmlDepartmentsLeader> list = findByDepartmentsId_Main(departmentsId,
                main, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("main=" + main);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader[] findByDepartmentsId_Main_PrevAndNext(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK, String departmentsId,
        boolean main, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = findByPrimaryKey(pmlDepartmentsLeaderPK);

        int count = countByDepartmentsId_Main(departmentsId, main);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

            if (departmentsId == null) {
                query.append("departmentsId IS NULL");
            } else {
                query.append("departmentsId = ?");
            }

            query.append(" AND ");

            query.append("main = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            qPos.add(main);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDepartmentsLeader);

            PmlDepartmentsLeader[] array = new PmlDepartmentsLeaderImpl[3];

            array[0] = (PmlDepartmentsLeader) objArray[0];
            array[1] = (PmlDepartmentsLeader) objArray[1];
            array[2] = (PmlDepartmentsLeader) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDepartmentsLeader> findByMain(boolean main)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "findByMain";
        String[] finderParams = new String[] { Boolean.class.getName() };
        Object[] finderArgs = new Object[] { Boolean.valueOf(main) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                query.append("main = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(main);

                List<PmlDepartmentsLeader> list = q.list();

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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public List<PmlDepartmentsLeader> findByMain(boolean main, int start,
        int end) throws SystemException {
        return findByMain(main, start, end, null);
    }

    public List<PmlDepartmentsLeader> findByMain(boolean main, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "findByMain";
        String[] finderParams = new String[] {
                Boolean.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                Boolean.valueOf(main),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                query.append("main = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(main);

                List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public PmlDepartmentsLeader findByMain_First(boolean main,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        List<PmlDepartmentsLeader> list = findByMain(main, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("main=" + main);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader findByMain_Last(boolean main,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        int count = countByMain(main);

        List<PmlDepartmentsLeader> list = findByMain(main, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("main=" + main);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader[] findByMain_PrevAndNext(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK, boolean main,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = findByPrimaryKey(pmlDepartmentsLeaderPK);

        int count = countByMain(main);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

            query.append("main = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(main);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDepartmentsLeader);

            PmlDepartmentsLeader[] array = new PmlDepartmentsLeaderImpl[3];

            array[0] = (PmlDepartmentsLeader) objArray[0];
            array[1] = (PmlDepartmentsLeader) objArray[1];
            array[2] = (PmlDepartmentsLeader) objArray[2];

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

    public List<PmlDepartmentsLeader> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlDepartmentsLeader> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlDepartmentsLeader> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
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
            return (List<PmlDepartmentsLeader>) result;
        }
    }

    public void removeByDepartmentsId(String departmentsId)
        throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findByDepartmentsId(
                departmentsId)) {
            remove(pmlDepartmentsLeader);
        }
    }

    public void removeByUserId(long userId) throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findByUserId(userId)) {
            remove(pmlDepartmentsLeader);
        }
    }

    public void removeByDepartmentsId_UserId(String departmentsId, long userId)
        throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findByDepartmentsId_UserId(
                departmentsId, userId)) {
            remove(pmlDepartmentsLeader);
        }
    }

    public void removeByClericalId(long clericalId) throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findByClericalId(
                clericalId)) {
            remove(pmlDepartmentsLeader);
        }
    }

    public void removeByDepartmentsId_Main(String departmentsId, boolean main)
        throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findByDepartmentsId_Main(
                departmentsId, main)) {
            remove(pmlDepartmentsLeader);
        }
    }

    public void removeByMain(boolean main) throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findByMain(main)) {
            remove(pmlDepartmentsLeader);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findAll()) {
            remove(pmlDepartmentsLeader);
        }
    }

    public int countByDepartmentsId(String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
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

    public int countByUserId(long userId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "countByUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(userId) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

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

    public int countByDepartmentsId_UserId(String departmentsId, long userId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "countByDepartmentsId_UserId";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { departmentsId, new Long(userId) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" AND ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(userId);

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

    public int countByClericalId(long clericalId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "countByClericalId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(clericalId) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                query.append("clericalid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(clericalId);

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

    public int countByDepartmentsId_Main(String departmentsId, boolean main)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "countByDepartmentsId_Main";
        String[] finderParams = new String[] {
                String.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] { departmentsId, Boolean.valueOf(main) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" AND ");

                query.append("main = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(main);

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

    public int countByMain(boolean main) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
        String finderMethodName = "countByMain";
        String[] finderParams = new String[] { Boolean.class.getName() };
        Object[] finderArgs = new Object[] { Boolean.valueOf(main) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader WHERE ");

                query.append("main = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(main);

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
        boolean finderClassNameCacheEnabled = PmlDepartmentsLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentsLeader.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoor.model.PmlDepartmentsLeader");

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
                        "value.object.listener.com.sgs.portlet.onedoor.model.PmlDepartmentsLeader")));

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
