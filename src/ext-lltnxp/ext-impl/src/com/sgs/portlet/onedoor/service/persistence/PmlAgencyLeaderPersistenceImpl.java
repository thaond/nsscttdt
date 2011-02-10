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

import com.sgs.portlet.onedoor.NoSuchPmlAgencyLeaderException;
import com.sgs.portlet.onedoor.model.PmlAgencyLeader;
import com.sgs.portlet.onedoor.model.impl.PmlAgencyLeaderImpl;
import com.sgs.portlet.onedoor.model.impl.PmlAgencyLeaderModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlAgencyLeaderPersistenceImpl extends BasePersistenceImpl
    implements PmlAgencyLeaderPersistence {
    private static Log _log = LogFactory.getLog(PmlAgencyLeaderPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlAgencyLeader create(String agencyId) {
        PmlAgencyLeader pmlAgencyLeader = new PmlAgencyLeaderImpl();

        pmlAgencyLeader.setNew(true);
        pmlAgencyLeader.setPrimaryKey(agencyId);

        return pmlAgencyLeader;
    }

    public PmlAgencyLeader remove(String agencyId)
        throws NoSuchPmlAgencyLeaderException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlAgencyLeader pmlAgencyLeader = (PmlAgencyLeader) session.get(PmlAgencyLeaderImpl.class,
                    agencyId);

            if (pmlAgencyLeader == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlAgencyLeader exists with the primary key " +
                        agencyId);
                }

                throw new NoSuchPmlAgencyLeaderException(
                    "No PmlAgencyLeader exists with the primary key " +
                    agencyId);
            }

            return remove(pmlAgencyLeader);
        } catch (NoSuchPmlAgencyLeaderException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlAgencyLeader remove(PmlAgencyLeader pmlAgencyLeader)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlAgencyLeader);
            }
        }

        pmlAgencyLeader = removeImpl(pmlAgencyLeader);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlAgencyLeader);
            }
        }

        return pmlAgencyLeader;
    }

    protected PmlAgencyLeader removeImpl(PmlAgencyLeader pmlAgencyLeader)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlAgencyLeader);

            session.flush();

            return pmlAgencyLeader;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlAgencyLeader.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlAgencyLeader pmlAgencyLeader, boolean merge)</code>.
     */
    public PmlAgencyLeader update(PmlAgencyLeader pmlAgencyLeader)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlAgencyLeader pmlAgencyLeader) method. Use update(PmlAgencyLeader pmlAgencyLeader, boolean merge) instead.");
        }

        return update(pmlAgencyLeader, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlAgencyLeader the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlAgencyLeader is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlAgencyLeader update(PmlAgencyLeader pmlAgencyLeader, boolean merge)
        throws SystemException {
        boolean isNew = pmlAgencyLeader.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlAgencyLeader);
                } else {
                    listener.onBeforeUpdate(pmlAgencyLeader);
                }
            }
        }

        pmlAgencyLeader = updateImpl(pmlAgencyLeader, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlAgencyLeader);
                } else {
                    listener.onAfterUpdate(pmlAgencyLeader);
                }
            }
        }

        return pmlAgencyLeader;
    }

    public PmlAgencyLeader updateImpl(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlAgencyLeader);
            } else {
                if (pmlAgencyLeader.isNew()) {
                    session.save(pmlAgencyLeader);
                }
            }

            session.flush();

            pmlAgencyLeader.setNew(false);

            return pmlAgencyLeader;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlAgencyLeader.class.getName());
        }
    }

    public PmlAgencyLeader findByPrimaryKey(String agencyId)
        throws NoSuchPmlAgencyLeaderException, SystemException {
        PmlAgencyLeader pmlAgencyLeader = fetchByPrimaryKey(agencyId);

        if (pmlAgencyLeader == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlAgencyLeader exists with the primary key " +
                    agencyId);
            }

            throw new NoSuchPmlAgencyLeaderException(
                "No PmlAgencyLeader exists with the primary key " + agencyId);
        }

        return pmlAgencyLeader;
    }

    public PmlAgencyLeader fetchByPrimaryKey(String agencyId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlAgencyLeader) session.get(PmlAgencyLeaderImpl.class,
                agencyId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlAgencyLeader> findByUserId(long userId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlAgencyLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlAgencyLeader.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlAgencyLeader WHERE ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<PmlAgencyLeader> list = q.list();

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
            return (List<PmlAgencyLeader>) result;
        }
    }

    public List<PmlAgencyLeader> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    public List<PmlAgencyLeader> findByUserId(long userId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlAgencyLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlAgencyLeader.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlAgencyLeader WHERE ");

                query.append("userId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<PmlAgencyLeader> list = (List<PmlAgencyLeader>) QueryUtil.list(q,
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
            return (List<PmlAgencyLeader>) result;
        }
    }

    public PmlAgencyLeader findByUserId_First(long userId, OrderByComparator obc)
        throws NoSuchPmlAgencyLeaderException, SystemException {
        List<PmlAgencyLeader> list = findByUserId(userId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlAgencyLeader exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlAgencyLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlAgencyLeader findByUserId_Last(long userId, OrderByComparator obc)
        throws NoSuchPmlAgencyLeaderException, SystemException {
        int count = countByUserId(userId);

        List<PmlAgencyLeader> list = findByUserId(userId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlAgencyLeader exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlAgencyLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlAgencyLeader[] findByUserId_PrevAndNext(String agencyId,
        long userId, OrderByComparator obc)
        throws NoSuchPmlAgencyLeaderException, SystemException {
        PmlAgencyLeader pmlAgencyLeader = findByPrimaryKey(agencyId);

        int count = countByUserId(userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlAgencyLeader WHERE ");

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
                    pmlAgencyLeader);

            PmlAgencyLeader[] array = new PmlAgencyLeaderImpl[3];

            array[0] = (PmlAgencyLeader) objArray[0];
            array[1] = (PmlAgencyLeader) objArray[1];
            array[2] = (PmlAgencyLeader) objArray[2];

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

    public List<PmlAgencyLeader> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlAgencyLeader> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlAgencyLeader> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlAgencyLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlAgencyLeader.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlAgencyLeader ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlAgencyLeader> list = (List<PmlAgencyLeader>) QueryUtil.list(q,
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
            return (List<PmlAgencyLeader>) result;
        }
    }

    public void removeByUserId(long userId) throws SystemException {
        for (PmlAgencyLeader pmlAgencyLeader : findByUserId(userId)) {
            remove(pmlAgencyLeader);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlAgencyLeader pmlAgencyLeader : findAll()) {
            remove(pmlAgencyLeader);
        }
    }

    public int countByUserId(long userId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlAgencyLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlAgencyLeader.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlAgencyLeader WHERE ");

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

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = PmlAgencyLeaderModelImpl.CACHE_ENABLED;
        String finderClassName = PmlAgencyLeader.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoor.model.PmlAgencyLeader");

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
                        "value.object.listener.com.sgs.portlet.onedoor.model.PmlAgencyLeader")));

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
