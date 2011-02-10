package com.ext.portlet.meetingcalendar.service.persistence;

import com.ext.portlet.meetingcalendar.NoSuchComponentException;
import com.ext.portlet.meetingcalendar.model.MeetingCalComponent;
import com.ext.portlet.meetingcalendar.model.impl.MeetingCalComponentImpl;
import com.ext.portlet.meetingcalendar.model.impl.MeetingCalComponentModelImpl;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class MeetingCalComponentPersistenceImpl extends BasePersistenceImpl
    implements MeetingCalComponentPersistence {
    private static Log _log = LogFactory.getLog(MeetingCalComponentPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public MeetingCalComponent create(long mcalId) {
        MeetingCalComponent meetingCalComponent = new MeetingCalComponentImpl();

        meetingCalComponent.setNew(true);
        meetingCalComponent.setPrimaryKey(mcalId);

        return meetingCalComponent;
    }

    public MeetingCalComponent remove(long mcalId)
        throws NoSuchComponentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            MeetingCalComponent meetingCalComponent = (MeetingCalComponent) session.get(MeetingCalComponentImpl.class,
                    new Long(mcalId));

            if (meetingCalComponent == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No MeetingCalComponent exists with the primary key " +
                        mcalId);
                }

                throw new NoSuchComponentException(
                    "No MeetingCalComponent exists with the primary key " +
                    mcalId);
            }

            return remove(meetingCalComponent);
        } catch (NoSuchComponentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public MeetingCalComponent remove(MeetingCalComponent meetingCalComponent)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(meetingCalComponent);
            }
        }

        meetingCalComponent = removeImpl(meetingCalComponent);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(meetingCalComponent);
            }
        }

        return meetingCalComponent;
    }

    protected MeetingCalComponent removeImpl(
        MeetingCalComponent meetingCalComponent) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(meetingCalComponent);

            session.flush();

            return meetingCalComponent;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(MeetingCalComponent.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(MeetingCalComponent meetingCalComponent, boolean merge)</code>.
     */
    public MeetingCalComponent update(MeetingCalComponent meetingCalComponent)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(MeetingCalComponent meetingCalComponent) method. Use update(MeetingCalComponent meetingCalComponent, boolean merge) instead.");
        }

        return update(meetingCalComponent, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                meetingCalComponent the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when meetingCalComponent is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public MeetingCalComponent update(MeetingCalComponent meetingCalComponent,
        boolean merge) throws SystemException {
        boolean isNew = meetingCalComponent.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(meetingCalComponent);
                } else {
                    listener.onBeforeUpdate(meetingCalComponent);
                }
            }
        }

        meetingCalComponent = updateImpl(meetingCalComponent, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(meetingCalComponent);
                } else {
                    listener.onAfterUpdate(meetingCalComponent);
                }
            }
        }

        return meetingCalComponent;
    }

    public MeetingCalComponent updateImpl(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(meetingCalComponent);
            } else {
                if (meetingCalComponent.isNew()) {
                    session.save(meetingCalComponent);
                }
            }

            session.flush();

            meetingCalComponent.setNew(false);

            return meetingCalComponent;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(MeetingCalComponent.class.getName());
        }
    }

    public MeetingCalComponent findByPrimaryKey(long mcalId)
        throws NoSuchComponentException, SystemException {
        MeetingCalComponent meetingCalComponent = fetchByPrimaryKey(mcalId);

        if (meetingCalComponent == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No MeetingCalComponent exists with the primary key " +
                    mcalId);
            }

            throw new NoSuchComponentException(
                "No MeetingCalComponent exists with the primary key " + mcalId);
        }

        return meetingCalComponent;
    }

    public MeetingCalComponent fetchByPrimaryKey(long mcalId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (MeetingCalComponent) session.get(MeetingCalComponentImpl.class,
                new Long(mcalId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public MeetingCalComponent findBymcalId(long mcalId)
        throws NoSuchComponentException, SystemException {
        MeetingCalComponent meetingCalComponent = fetchBymcalId(mcalId);

        if (meetingCalComponent == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MeetingCalComponent exists with the key {");

            msg.append("mcalId=" + mcalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchComponentException(msg.toString());
        }

        return meetingCalComponent;
    }

    public MeetingCalComponent fetchBymcalId(long mcalId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalComponentModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalComponent.class.getName();
        String finderMethodName = "fetchBymcalId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(mcalId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalComponent WHERE ");

                query.append("mcalId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mcalId);

                List<MeetingCalComponent> list = q.list();

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                if (list.size() == 0) {
                    return null;
                } else {
                    return list.get(0);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            List<MeetingCalComponent> list = (List<MeetingCalComponent>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
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

    public List<MeetingCalComponent> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<MeetingCalComponent> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<MeetingCalComponent> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalComponentModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalComponent.class.getName();
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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalComponent ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<MeetingCalComponent> list = (List<MeetingCalComponent>) QueryUtil.list(q,
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
            return (List<MeetingCalComponent>) result;
        }
    }

    public void removeBymcalId(long mcalId)
        throws NoSuchComponentException, SystemException {
        MeetingCalComponent meetingCalComponent = findBymcalId(mcalId);

        remove(meetingCalComponent);
    }

    public void removeAll() throws SystemException {
        for (MeetingCalComponent meetingCalComponent : findAll()) {
            remove(meetingCalComponent);
        }
    }

    public int countBymcalId(long mcalId) throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalComponentModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalComponent.class.getName();
        String finderMethodName = "countBymcalId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(mcalId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalComponent WHERE ");

                query.append("mcalId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mcalId);

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
        boolean finderClassNameCacheEnabled = MeetingCalComponentModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalComponent.class.getName();
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
                        "SELECT COUNT(*) FROM com.ext.portlet.meetingcalendar.model.MeetingCalComponent");

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
                        "value.object.listener.com.ext.portlet.meetingcalendar.model.MeetingCalComponent")));

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
