package com.ext.portlet.meetingcalendar.service.persistence;

import com.ext.portlet.meetingcalendar.NoSuchPmlScreenCalendarHeightException;
import com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight;
import com.ext.portlet.meetingcalendar.model.impl.PmlScreenCalendarHeightImpl;
import com.ext.portlet.meetingcalendar.model.impl.PmlScreenCalendarHeightModelImpl;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlScreenCalendarHeightPersistenceImpl extends BasePersistenceImpl
    implements PmlScreenCalendarHeightPersistence {
    private static Log _log = LogFactory.getLog(PmlScreenCalendarHeightPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlScreenCalendarHeight create(long screenCalendarHeightId) {
        PmlScreenCalendarHeight pmlScreenCalendarHeight = new PmlScreenCalendarHeightImpl();

        pmlScreenCalendarHeight.setNew(true);
        pmlScreenCalendarHeight.setPrimaryKey(screenCalendarHeightId);

        return pmlScreenCalendarHeight;
    }

    public PmlScreenCalendarHeight remove(long screenCalendarHeightId)
        throws NoSuchPmlScreenCalendarHeightException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlScreenCalendarHeight pmlScreenCalendarHeight = (PmlScreenCalendarHeight) session.get(PmlScreenCalendarHeightImpl.class,
                    new Long(screenCalendarHeightId));

            if (pmlScreenCalendarHeight == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlScreenCalendarHeight exists with the primary key " +
                        screenCalendarHeightId);
                }

                throw new NoSuchPmlScreenCalendarHeightException(
                    "No PmlScreenCalendarHeight exists with the primary key " +
                    screenCalendarHeightId);
            }

            return remove(pmlScreenCalendarHeight);
        } catch (NoSuchPmlScreenCalendarHeightException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlScreenCalendarHeight remove(
        PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlScreenCalendarHeight);
            }
        }

        pmlScreenCalendarHeight = removeImpl(pmlScreenCalendarHeight);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlScreenCalendarHeight);
            }
        }

        return pmlScreenCalendarHeight;
    }

    protected PmlScreenCalendarHeight removeImpl(
        PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlScreenCalendarHeight);

            session.flush();

            return pmlScreenCalendarHeight;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlScreenCalendarHeight.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlScreenCalendarHeight pmlScreenCalendarHeight, boolean merge)</code>.
     */
    public PmlScreenCalendarHeight update(
        PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlScreenCalendarHeight pmlScreenCalendarHeight) method. Use update(PmlScreenCalendarHeight pmlScreenCalendarHeight, boolean merge) instead.");
        }

        return update(pmlScreenCalendarHeight, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlScreenCalendarHeight the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlScreenCalendarHeight is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlScreenCalendarHeight update(
        PmlScreenCalendarHeight pmlScreenCalendarHeight, boolean merge)
        throws SystemException {
        boolean isNew = pmlScreenCalendarHeight.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlScreenCalendarHeight);
                } else {
                    listener.onBeforeUpdate(pmlScreenCalendarHeight);
                }
            }
        }

        pmlScreenCalendarHeight = updateImpl(pmlScreenCalendarHeight, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlScreenCalendarHeight);
                } else {
                    listener.onAfterUpdate(pmlScreenCalendarHeight);
                }
            }
        }

        return pmlScreenCalendarHeight;
    }

    public PmlScreenCalendarHeight updateImpl(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlScreenCalendarHeight);
            } else {
                if (pmlScreenCalendarHeight.isNew()) {
                    session.save(pmlScreenCalendarHeight);
                }
            }

            session.flush();

            pmlScreenCalendarHeight.setNew(false);

            return pmlScreenCalendarHeight;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlScreenCalendarHeight.class.getName());
        }
    }

    public PmlScreenCalendarHeight findByPrimaryKey(long screenCalendarHeightId)
        throws NoSuchPmlScreenCalendarHeightException, SystemException {
        PmlScreenCalendarHeight pmlScreenCalendarHeight = fetchByPrimaryKey(screenCalendarHeightId);

        if (pmlScreenCalendarHeight == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlScreenCalendarHeight exists with the primary key " +
                    screenCalendarHeightId);
            }

            throw new NoSuchPmlScreenCalendarHeightException(
                "No PmlScreenCalendarHeight exists with the primary key " +
                screenCalendarHeightId);
        }

        return pmlScreenCalendarHeight;
    }

    public PmlScreenCalendarHeight fetchByPrimaryKey(
        long screenCalendarHeightId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlScreenCalendarHeight) session.get(PmlScreenCalendarHeightImpl.class,
                new Long(screenCalendarHeightId));
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

    public List<PmlScreenCalendarHeight> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlScreenCalendarHeight> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlScreenCalendarHeight> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlScreenCalendarHeightModelImpl.CACHE_ENABLED;
        String finderClassName = PmlScreenCalendarHeight.class.getName();
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
                    "FROM com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlScreenCalendarHeight> list = (List<PmlScreenCalendarHeight>) QueryUtil.list(q,
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
            return (List<PmlScreenCalendarHeight>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (PmlScreenCalendarHeight pmlScreenCalendarHeight : findAll()) {
            remove(pmlScreenCalendarHeight);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = PmlScreenCalendarHeightModelImpl.CACHE_ENABLED;
        String finderClassName = PmlScreenCalendarHeight.class.getName();
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
                        "SELECT COUNT(*) FROM com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight");

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
                        "value.object.listener.com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight")));

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
