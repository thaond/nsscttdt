package com.ext.portlet.meetingcalendar.service.persistence;

import com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException;
import com.ext.portlet.meetingcalendar.model.MeetingDetailWeek;
import com.ext.portlet.meetingcalendar.model.impl.MeetingDetailWeekImpl;
import com.ext.portlet.meetingcalendar.model.impl.MeetingDetailWeekModelImpl;

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


public class MeetingDetailWeekPersistenceImpl extends BasePersistenceImpl
    implements MeetingDetailWeekPersistence {
    private static Log _log = LogFactory.getLog(MeetingDetailWeekPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public MeetingDetailWeek create(long mdweekId) {
        MeetingDetailWeek meetingDetailWeek = new MeetingDetailWeekImpl();

        meetingDetailWeek.setNew(true);
        meetingDetailWeek.setPrimaryKey(mdweekId);

        return meetingDetailWeek;
    }

    public MeetingDetailWeek remove(long mdweekId)
        throws NoSuchMeetingDetailWeekException, SystemException {
        Session session = null;

        try {
            session = openSession();

            MeetingDetailWeek meetingDetailWeek = (MeetingDetailWeek) session.get(MeetingDetailWeekImpl.class,
                    new Long(mdweekId));

            if (meetingDetailWeek == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No MeetingDetailWeek exists with the primary key " +
                        mdweekId);
                }

                throw new NoSuchMeetingDetailWeekException(
                    "No MeetingDetailWeek exists with the primary key " +
                    mdweekId);
            }

            return remove(meetingDetailWeek);
        } catch (NoSuchMeetingDetailWeekException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public MeetingDetailWeek remove(MeetingDetailWeek meetingDetailWeek)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(meetingDetailWeek);
            }
        }

        meetingDetailWeek = removeImpl(meetingDetailWeek);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(meetingDetailWeek);
            }
        }

        return meetingDetailWeek;
    }

    protected MeetingDetailWeek removeImpl(MeetingDetailWeek meetingDetailWeek)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(meetingDetailWeek);

            session.flush();

            return meetingDetailWeek;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(MeetingDetailWeek.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(MeetingDetailWeek meetingDetailWeek, boolean merge)</code>.
     */
    public MeetingDetailWeek update(MeetingDetailWeek meetingDetailWeek)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(MeetingDetailWeek meetingDetailWeek) method. Use update(MeetingDetailWeek meetingDetailWeek, boolean merge) instead.");
        }

        return update(meetingDetailWeek, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                meetingDetailWeek the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when meetingDetailWeek is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public MeetingDetailWeek update(MeetingDetailWeek meetingDetailWeek,
        boolean merge) throws SystemException {
        boolean isNew = meetingDetailWeek.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(meetingDetailWeek);
                } else {
                    listener.onBeforeUpdate(meetingDetailWeek);
                }
            }
        }

        meetingDetailWeek = updateImpl(meetingDetailWeek, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(meetingDetailWeek);
                } else {
                    listener.onAfterUpdate(meetingDetailWeek);
                }
            }
        }

        return meetingDetailWeek;
    }

    public MeetingDetailWeek updateImpl(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(meetingDetailWeek);
            } else {
                if (meetingDetailWeek.isNew()) {
                    session.save(meetingDetailWeek);
                }
            }

            session.flush();

            meetingDetailWeek.setNew(false);

            return meetingDetailWeek;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(MeetingDetailWeek.class.getName());
        }
    }

    public MeetingDetailWeek findByPrimaryKey(long mdweekId)
        throws NoSuchMeetingDetailWeekException, SystemException {
        MeetingDetailWeek meetingDetailWeek = fetchByPrimaryKey(mdweekId);

        if (meetingDetailWeek == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No MeetingDetailWeek exists with the primary key " +
                    mdweekId);
            }

            throw new NoSuchMeetingDetailWeekException(
                "No MeetingDetailWeek exists with the primary key " + mdweekId);
        }

        return meetingDetailWeek;
    }

    public MeetingDetailWeek fetchByPrimaryKey(long mdweekId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (MeetingDetailWeek) session.get(MeetingDetailWeekImpl.class,
                new Long(mdweekId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public MeetingDetailWeek findBymdweekId(long mdweekId)
        throws NoSuchMeetingDetailWeekException, SystemException {
        MeetingDetailWeek meetingDetailWeek = fetchBymdweekId(mdweekId);

        if (meetingDetailWeek == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MeetingDetailWeek exists with the key {");

            msg.append("mdweekId=" + mdweekId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchMeetingDetailWeekException(msg.toString());
        }

        return meetingDetailWeek;
    }

    public MeetingDetailWeek fetchBymdweekId(long mdweekId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingDetailWeekModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingDetailWeek.class.getName();
        String finderMethodName = "fetchBymdweekId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(mdweekId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingDetailWeek WHERE ");

                query.append("mdweekId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mdweekId);

                List<MeetingDetailWeek> list = q.list();

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
            List<MeetingDetailWeek> list = (List<MeetingDetailWeek>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public MeetingDetailWeek findByW_Y(int week, int year)
        throws NoSuchMeetingDetailWeekException, SystemException {
        MeetingDetailWeek meetingDetailWeek = fetchByW_Y(week, year);

        if (meetingDetailWeek == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MeetingDetailWeek exists with the key {");

            msg.append("week=" + week);

            msg.append(", ");
            msg.append("year=" + year);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchMeetingDetailWeekException(msg.toString());
        }

        return meetingDetailWeek;
    }

    public MeetingDetailWeek fetchByW_Y(int week, int year)
        throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingDetailWeekModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingDetailWeek.class.getName();
        String finderMethodName = "fetchByW_Y";
        String[] finderParams = new String[] {
                Integer.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { new Integer(week), new Integer(year) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingDetailWeek WHERE ");

                query.append("week = ?");

                query.append(" AND ");

                query.append("year = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(week);

                qPos.add(year);

                List<MeetingDetailWeek> list = q.list();

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
            List<MeetingDetailWeek> list = (List<MeetingDetailWeek>) result;

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

    public List<MeetingDetailWeek> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<MeetingDetailWeek> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<MeetingDetailWeek> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingDetailWeekModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingDetailWeek.class.getName();
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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingDetailWeek ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<MeetingDetailWeek> list = (List<MeetingDetailWeek>) QueryUtil.list(q,
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
            return (List<MeetingDetailWeek>) result;
        }
    }

    public void removeBymdweekId(long mdweekId)
        throws NoSuchMeetingDetailWeekException, SystemException {
        MeetingDetailWeek meetingDetailWeek = findBymdweekId(mdweekId);

        remove(meetingDetailWeek);
    }

    public void removeByW_Y(int week, int year)
        throws NoSuchMeetingDetailWeekException, SystemException {
        MeetingDetailWeek meetingDetailWeek = findByW_Y(week, year);

        remove(meetingDetailWeek);
    }

    public void removeAll() throws SystemException {
        for (MeetingDetailWeek meetingDetailWeek : findAll()) {
            remove(meetingDetailWeek);
        }
    }

    public int countBymdweekId(long mdweekId) throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingDetailWeekModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingDetailWeek.class.getName();
        String finderMethodName = "countBymdweekId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(mdweekId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingDetailWeek WHERE ");

                query.append("mdweekId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mdweekId);

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

    public int countByW_Y(int week, int year) throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingDetailWeekModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingDetailWeek.class.getName();
        String finderMethodName = "countByW_Y";
        String[] finderParams = new String[] {
                Integer.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { new Integer(week), new Integer(year) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingDetailWeek WHERE ");

                query.append("week = ?");

                query.append(" AND ");

                query.append("year = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(week);

                qPos.add(year);

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
        boolean finderClassNameCacheEnabled = MeetingDetailWeekModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingDetailWeek.class.getName();
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
                        "SELECT COUNT(*) FROM com.ext.portlet.meetingcalendar.model.MeetingDetailWeek");

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
                        "value.object.listener.com.ext.portlet.meetingcalendar.model.MeetingDetailWeek")));

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
