package com.sgs.portlet.vanbannoibo.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.vanbannoibo.NoSuchLogVanBanNoiBoException;
import com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo;
import com.sgs.portlet.vanbannoibo.model.impl.LogVanBanNoiBoImpl;
import com.sgs.portlet.vanbannoibo.model.impl.LogVanBanNoiBoModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class LogVanBanNoiBoPersistenceImpl extends BasePersistenceImpl
    implements LogVanBanNoiBoPersistence {
    private static Log _log = LogFactory.getLog(LogVanBanNoiBoPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public LogVanBanNoiBo create(long logVanBanNoiBoId) {
        LogVanBanNoiBo logVanBanNoiBo = new LogVanBanNoiBoImpl();

        logVanBanNoiBo.setNew(true);
        logVanBanNoiBo.setPrimaryKey(logVanBanNoiBoId);

        return logVanBanNoiBo;
    }

    public LogVanBanNoiBo remove(long logVanBanNoiBoId)
        throws NoSuchLogVanBanNoiBoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LogVanBanNoiBo logVanBanNoiBo = (LogVanBanNoiBo) session.get(LogVanBanNoiBoImpl.class,
                    new Long(logVanBanNoiBoId));

            if (logVanBanNoiBo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No LogVanBanNoiBo exists with the primary key " +
                        logVanBanNoiBoId);
                }

                throw new NoSuchLogVanBanNoiBoException(
                    "No LogVanBanNoiBo exists with the primary key " +
                    logVanBanNoiBoId);
            }

            return remove(logVanBanNoiBo);
        } catch (NoSuchLogVanBanNoiBoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public LogVanBanNoiBo remove(LogVanBanNoiBo logVanBanNoiBo)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(logVanBanNoiBo);
            }
        }

        logVanBanNoiBo = removeImpl(logVanBanNoiBo);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(logVanBanNoiBo);
            }
        }

        return logVanBanNoiBo;
    }

    protected LogVanBanNoiBo removeImpl(LogVanBanNoiBo logVanBanNoiBo)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(logVanBanNoiBo);

            session.flush();

            return logVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(LogVanBanNoiBo.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(LogVanBanNoiBo logVanBanNoiBo, boolean merge)</code>.
     */
    public LogVanBanNoiBo update(LogVanBanNoiBo logVanBanNoiBo)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(LogVanBanNoiBo logVanBanNoiBo) method. Use update(LogVanBanNoiBo logVanBanNoiBo, boolean merge) instead.");
        }

        return update(logVanBanNoiBo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                logVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when logVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public LogVanBanNoiBo update(LogVanBanNoiBo logVanBanNoiBo, boolean merge)
        throws SystemException {
        boolean isNew = logVanBanNoiBo.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(logVanBanNoiBo);
                } else {
                    listener.onBeforeUpdate(logVanBanNoiBo);
                }
            }
        }

        logVanBanNoiBo = updateImpl(logVanBanNoiBo, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(logVanBanNoiBo);
                } else {
                    listener.onAfterUpdate(logVanBanNoiBo);
                }
            }
        }

        return logVanBanNoiBo;
    }

    public LogVanBanNoiBo updateImpl(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(logVanBanNoiBo);
            } else {
                if (logVanBanNoiBo.isNew()) {
                    session.save(logVanBanNoiBo);
                }
            }

            session.flush();

            logVanBanNoiBo.setNew(false);

            return logVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(LogVanBanNoiBo.class.getName());
        }
    }

    public LogVanBanNoiBo findByPrimaryKey(long logVanBanNoiBoId)
        throws NoSuchLogVanBanNoiBoException, SystemException {
        LogVanBanNoiBo logVanBanNoiBo = fetchByPrimaryKey(logVanBanNoiBoId);

        if (logVanBanNoiBo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No LogVanBanNoiBo exists with the primary key " +
                    logVanBanNoiBoId);
            }

            throw new NoSuchLogVanBanNoiBoException(
                "No LogVanBanNoiBo exists with the primary key " +
                logVanBanNoiBoId);
        }

        return logVanBanNoiBo;
    }

    public LogVanBanNoiBo fetchByPrimaryKey(long logVanBanNoiBoId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (LogVanBanNoiBo) session.get(LogVanBanNoiBoImpl.class,
                new Long(logVanBanNoiBoId));
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

    public List<LogVanBanNoiBo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<LogVanBanNoiBo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<LogVanBanNoiBo> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = LogVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = LogVanBanNoiBo.class.getName();
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
                    "FROM com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<LogVanBanNoiBo> list = (List<LogVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<LogVanBanNoiBo>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (LogVanBanNoiBo logVanBanNoiBo : findAll()) {
            remove(logVanBanNoiBo);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = LogVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = LogVanBanNoiBo.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo");

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
                        "value.object.listener.com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo")));

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
