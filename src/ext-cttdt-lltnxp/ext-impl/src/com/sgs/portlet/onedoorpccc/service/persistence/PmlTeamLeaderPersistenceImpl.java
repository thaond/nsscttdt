package com.sgs.portlet.onedoorpccc.service.persistence;

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

import com.sgs.portlet.onedoorpccc.NoSuchPmlTeamLeaderException;
import com.sgs.portlet.onedoorpccc.model.PmlTeamLeader;
import com.sgs.portlet.onedoorpccc.model.impl.PmlTeamLeaderImpl;
import com.sgs.portlet.onedoorpccc.model.impl.PmlTeamLeaderModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlTeamLeaderPersistenceImpl extends BasePersistenceImpl
    implements PmlTeamLeaderPersistence {
    private static Log _log = LogFactory.getLog(PmlTeamLeaderPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlTeamLeader create(long teamId) {
        PmlTeamLeader pmlTeamLeader = new PmlTeamLeaderImpl();

        pmlTeamLeader.setNew(true);
        pmlTeamLeader.setPrimaryKey(teamId);

        return pmlTeamLeader;
    }

    public PmlTeamLeader remove(long teamId)
        throws NoSuchPmlTeamLeaderException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlTeamLeader pmlTeamLeader = (PmlTeamLeader) session.get(PmlTeamLeaderImpl.class,
                    new Long(teamId));

            if (pmlTeamLeader == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlTeamLeader exists with the primary key " +
                        teamId);
                }

                throw new NoSuchPmlTeamLeaderException(
                    "No PmlTeamLeader exists with the primary key " + teamId);
            }

            return remove(pmlTeamLeader);
        } catch (NoSuchPmlTeamLeaderException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlTeamLeader remove(PmlTeamLeader pmlTeamLeader)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlTeamLeader);
            }
        }

        pmlTeamLeader = removeImpl(pmlTeamLeader);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlTeamLeader);
            }
        }

        return pmlTeamLeader;
    }

    protected PmlTeamLeader removeImpl(PmlTeamLeader pmlTeamLeader)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlTeamLeader);

            session.flush();

            return pmlTeamLeader;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlTeamLeader.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlTeamLeader pmlTeamLeader, boolean merge)</code>.
     */
    public PmlTeamLeader update(PmlTeamLeader pmlTeamLeader)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlTeamLeader pmlTeamLeader) method. Use update(PmlTeamLeader pmlTeamLeader, boolean merge) instead.");
        }

        return update(pmlTeamLeader, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTeamLeader the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTeamLeader is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlTeamLeader update(PmlTeamLeader pmlTeamLeader, boolean merge)
        throws SystemException {
        boolean isNew = pmlTeamLeader.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlTeamLeader);
                } else {
                    listener.onBeforeUpdate(pmlTeamLeader);
                }
            }
        }

        pmlTeamLeader = updateImpl(pmlTeamLeader, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlTeamLeader);
                } else {
                    listener.onAfterUpdate(pmlTeamLeader);
                }
            }
        }

        return pmlTeamLeader;
    }

    public PmlTeamLeader updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlTeamLeader pmlTeamLeader,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlTeamLeader);
            } else {
                if (pmlTeamLeader.isNew()) {
                    session.save(pmlTeamLeader);
                }
            }

            session.flush();

            pmlTeamLeader.setNew(false);

            return pmlTeamLeader;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlTeamLeader.class.getName());
        }
    }

    public PmlTeamLeader findByPrimaryKey(long teamId)
        throws NoSuchPmlTeamLeaderException, SystemException {
        PmlTeamLeader pmlTeamLeader = fetchByPrimaryKey(teamId);

        if (pmlTeamLeader == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlTeamLeader exists with the primary key " +
                    teamId);
            }

            throw new NoSuchPmlTeamLeaderException(
                "No PmlTeamLeader exists with the primary key " + teamId);
        }

        return pmlTeamLeader;
    }

    public PmlTeamLeader fetchByPrimaryKey(long teamId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlTeamLeader) session.get(PmlTeamLeaderImpl.class,
                new Long(teamId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTeamLeader> findByUserId(long userId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeamLeader.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTeamLeader WHERE ");

                query.append("userid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("teamid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<PmlTeamLeader> list = q.list();

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
            return (List<PmlTeamLeader>) result;
        }
    }

    public List<PmlTeamLeader> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    public List<PmlTeamLeader> findByUserId(long userId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeamLeader.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTeamLeader WHERE ");

                query.append("userid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("teamid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<PmlTeamLeader> list = (List<PmlTeamLeader>) QueryUtil.list(q,
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
            return (List<PmlTeamLeader>) result;
        }
    }

    public PmlTeamLeader findByUserId_First(long userId, OrderByComparator obc)
        throws NoSuchPmlTeamLeaderException, SystemException {
        List<PmlTeamLeader> list = findByUserId(userId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeamLeader exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeamLeader findByUserId_Last(long userId, OrderByComparator obc)
        throws NoSuchPmlTeamLeaderException, SystemException {
        int count = countByUserId(userId);

        List<PmlTeamLeader> list = findByUserId(userId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTeamLeader exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTeamLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTeamLeader[] findByUserId_PrevAndNext(long teamId, long userId,
        OrderByComparator obc)
        throws NoSuchPmlTeamLeaderException, SystemException {
        PmlTeamLeader pmlTeamLeader = findByPrimaryKey(teamId);

        int count = countByUserId(userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlTeamLeader WHERE ");

            query.append("userid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("teamid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTeamLeader);

            PmlTeamLeader[] array = new PmlTeamLeaderImpl[3];

            array[0] = (PmlTeamLeader) objArray[0];
            array[1] = (PmlTeamLeader) objArray[1];
            array[2] = (PmlTeamLeader) objArray[2];

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

    public List<PmlTeamLeader> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlTeamLeader> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlTeamLeader> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeamLeader.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTeamLeader ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("teamid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlTeamLeader> list = (List<PmlTeamLeader>) QueryUtil.list(q,
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
            return (List<PmlTeamLeader>) result;
        }
    }

    public void removeByUserId(long userId) throws SystemException {
        for (PmlTeamLeader pmlTeamLeader : findByUserId(userId)) {
            remove(pmlTeamLeader);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlTeamLeader pmlTeamLeader : findAll()) {
            remove(pmlTeamLeader);
        }
    }

    public int countByUserId(long userId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeamLeader.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTeamLeader WHERE ");

                query.append("userid = ?");

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

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTeamLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTeamLeader.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoorpccc.model.PmlTeamLeader");

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
                        "value.object.listener.com.sgs.portlet.onedoorpccc.model.PmlTeamLeader")));

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
