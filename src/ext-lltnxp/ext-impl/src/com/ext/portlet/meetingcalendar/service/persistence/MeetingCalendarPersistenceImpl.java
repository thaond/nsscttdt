package com.ext.portlet.meetingcalendar.service.persistence;

import com.ext.portlet.meetingcalendar.NoSuchendarException;
import com.ext.portlet.meetingcalendar.model.MeetingCalendar;
import com.ext.portlet.meetingcalendar.model.impl.MeetingCalendarImpl;
import com.ext.portlet.meetingcalendar.model.impl.MeetingCalendarModelImpl;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class MeetingCalendarPersistenceImpl extends BasePersistenceImpl
    implements MeetingCalendarPersistence {
    private static Log _log = LogFactory.getLog(MeetingCalendarPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public MeetingCalendar create(long mcalId) {
        MeetingCalendar meetingCalendar = new MeetingCalendarImpl();

        meetingCalendar.setNew(true);
        meetingCalendar.setPrimaryKey(mcalId);

        String uuid = PortalUUIDUtil.generate();

        meetingCalendar.setUuid(uuid);

        return meetingCalendar;
    }

    public MeetingCalendar remove(long mcalId)
        throws NoSuchendarException, SystemException {
        Session session = null;

        try {
            session = openSession();

            MeetingCalendar meetingCalendar = (MeetingCalendar) session.get(MeetingCalendarImpl.class,
                    new Long(mcalId));

            if (meetingCalendar == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No MeetingCalendar exists with the primary key " +
                        mcalId);
                }

                throw new NoSuchendarException(
                    "No MeetingCalendar exists with the primary key " + mcalId);
            }

            return remove(meetingCalendar);
        } catch (NoSuchendarException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public MeetingCalendar remove(MeetingCalendar meetingCalendar)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(meetingCalendar);
            }
        }

        meetingCalendar = removeImpl(meetingCalendar);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(meetingCalendar);
            }
        }

        return meetingCalendar;
    }

    protected MeetingCalendar removeImpl(MeetingCalendar meetingCalendar)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(meetingCalendar);

            session.flush();

            return meetingCalendar;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(MeetingCalendar.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(MeetingCalendar meetingCalendar, boolean merge)</code>.
     */
    public MeetingCalendar update(MeetingCalendar meetingCalendar)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(MeetingCalendar meetingCalendar) method. Use update(MeetingCalendar meetingCalendar, boolean merge) instead.");
        }

        return update(meetingCalendar, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                meetingCalendar the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when meetingCalendar is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public MeetingCalendar update(MeetingCalendar meetingCalendar, boolean merge)
        throws SystemException {
        boolean isNew = meetingCalendar.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(meetingCalendar);
                } else {
                    listener.onBeforeUpdate(meetingCalendar);
                }
            }
        }

        meetingCalendar = updateImpl(meetingCalendar, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(meetingCalendar);
                } else {
                    listener.onAfterUpdate(meetingCalendar);
                }
            }
        }

        return meetingCalendar;
    }

    public MeetingCalendar updateImpl(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar,
        boolean merge) throws SystemException {
        if (Validator.isNull(meetingCalendar.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            meetingCalendar.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(meetingCalendar);
            } else {
                if (meetingCalendar.isNew()) {
                    session.save(meetingCalendar);
                }
            }

            session.flush();

            meetingCalendar.setNew(false);

            return meetingCalendar;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(MeetingCalendar.class.getName());
        }
    }

    public MeetingCalendar findByPrimaryKey(long mcalId)
        throws NoSuchendarException, SystemException {
        MeetingCalendar meetingCalendar = fetchByPrimaryKey(mcalId);

        if (meetingCalendar == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No MeetingCalendar exists with the primary key " +
                    mcalId);
            }

            throw new NoSuchendarException(
                "No MeetingCalendar exists with the primary key " + mcalId);
        }

        return meetingCalendar;
    }

    public MeetingCalendar fetchByPrimaryKey(long mcalId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (MeetingCalendar) session.get(MeetingCalendarImpl.class,
                new Long(mcalId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<MeetingCalendar> findByUuid(String uuid)
        throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
        String finderMethodName = "findByUuid";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { uuid };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

                if (uuid == null) {
                    query.append("uuid_ IS NULL");
                } else {
                    query.append("uuid_ = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("mcalId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                List<MeetingCalendar> list = q.list();

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
            return (List<MeetingCalendar>) result;
        }
    }

    public List<MeetingCalendar> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    public List<MeetingCalendar> findByUuid(String uuid, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
        String finderMethodName = "findByUuid";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                uuid,
                
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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

                if (uuid == null) {
                    query.append("uuid_ IS NULL");
                } else {
                    query.append("uuid_ = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("mcalId ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                List<MeetingCalendar> list = (List<MeetingCalendar>) QueryUtil.list(q,
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
            return (List<MeetingCalendar>) result;
        }
    }

    public MeetingCalendar findByUuid_First(String uuid, OrderByComparator obc)
        throws NoSuchendarException, SystemException {
        List<MeetingCalendar> list = findByUuid(uuid, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MeetingCalendar exists with the key {");

            msg.append("uuid=" + uuid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchendarException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MeetingCalendar findByUuid_Last(String uuid, OrderByComparator obc)
        throws NoSuchendarException, SystemException {
        int count = countByUuid(uuid);

        List<MeetingCalendar> list = findByUuid(uuid, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MeetingCalendar exists with the key {");

            msg.append("uuid=" + uuid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchendarException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MeetingCalendar[] findByUuid_PrevAndNext(long mcalId, String uuid,
        OrderByComparator obc) throws NoSuchendarException, SystemException {
        MeetingCalendar meetingCalendar = findByPrimaryKey(mcalId);

        int count = countByUuid(uuid);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

            if (uuid == null) {
                query.append("uuid_ IS NULL");
            } else {
                query.append("uuid_ = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("mcalId ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (uuid != null) {
                qPos.add(uuid);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    meetingCalendar);

            MeetingCalendar[] array = new MeetingCalendarImpl[3];

            array[0] = (MeetingCalendar) objArray[0];
            array[1] = (MeetingCalendar) objArray[1];
            array[2] = (MeetingCalendar) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public MeetingCalendar findByUUID_G(String uuid, long groupId)
        throws NoSuchendarException, SystemException {
        MeetingCalendar meetingCalendar = fetchByUUID_G(uuid, groupId);

        if (meetingCalendar == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MeetingCalendar exists with the key {");

            msg.append("uuid=" + uuid);

            msg.append(", ");
            msg.append("groupId=" + groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchendarException(msg.toString());
        }

        return meetingCalendar;
    }

    public MeetingCalendar fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
        String finderMethodName = "fetchByUUID_G";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { uuid, new Long(groupId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

                if (uuid == null) {
                    query.append("uuid_ IS NULL");
                } else {
                    query.append("uuid_ = ?");
                }

                query.append(" AND ");

                query.append("groupId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("mcalId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<MeetingCalendar> list = q.list();

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
            List<MeetingCalendar> list = (List<MeetingCalendar>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public List<MeetingCalendar> findByGroupId(long groupId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
        String finderMethodName = "findByGroupId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(groupId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

                query.append("groupId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("mcalId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                List<MeetingCalendar> list = q.list();

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
            return (List<MeetingCalendar>) result;
        }
    }

    public List<MeetingCalendar> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    public List<MeetingCalendar> findByGroupId(long groupId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
        String finderMethodName = "findByGroupId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(groupId),
                
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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

                query.append("groupId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("mcalId ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                List<MeetingCalendar> list = (List<MeetingCalendar>) QueryUtil.list(q,
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
            return (List<MeetingCalendar>) result;
        }
    }

    public MeetingCalendar findByGroupId_First(long groupId,
        OrderByComparator obc) throws NoSuchendarException, SystemException {
        List<MeetingCalendar> list = findByGroupId(groupId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MeetingCalendar exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchendarException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MeetingCalendar findByGroupId_Last(long groupId,
        OrderByComparator obc) throws NoSuchendarException, SystemException {
        int count = countByGroupId(groupId);

        List<MeetingCalendar> list = findByGroupId(groupId, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MeetingCalendar exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchendarException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MeetingCalendar[] findByGroupId_PrevAndNext(long mcalId,
        long groupId, OrderByComparator obc)
        throws NoSuchendarException, SystemException {
        MeetingCalendar meetingCalendar = findByPrimaryKey(mcalId);

        int count = countByGroupId(groupId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

            query.append("groupId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("mcalId ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    meetingCalendar);

            MeetingCalendar[] array = new MeetingCalendarImpl[3];

            array[0] = (MeetingCalendar) objArray[0];
            array[1] = (MeetingCalendar) objArray[1];
            array[2] = (MeetingCalendar) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<MeetingCalendar> findByG_State(long groupId, int state)
        throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
        String finderMethodName = "findByG_State";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(groupId), new Integer(state) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                query.append("state = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("mcalId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(state);

                List<MeetingCalendar> list = q.list();

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
            return (List<MeetingCalendar>) result;
        }
    }

    public List<MeetingCalendar> findByG_State(long groupId, int state,
        int start, int end) throws SystemException {
        return findByG_State(groupId, state, start, end, null);
    }

    public List<MeetingCalendar> findByG_State(long groupId, int state,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
        String finderMethodName = "findByG_State";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(groupId), new Integer(state),
                
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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                query.append("state = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("mcalId ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(state);

                List<MeetingCalendar> list = (List<MeetingCalendar>) QueryUtil.list(q,
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
            return (List<MeetingCalendar>) result;
        }
    }

    public MeetingCalendar findByG_State_First(long groupId, int state,
        OrderByComparator obc) throws NoSuchendarException, SystemException {
        List<MeetingCalendar> list = findByG_State(groupId, state, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MeetingCalendar exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(", ");
            msg.append("state=" + state);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchendarException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MeetingCalendar findByG_State_Last(long groupId, int state,
        OrderByComparator obc) throws NoSuchendarException, SystemException {
        int count = countByG_State(groupId, state);

        List<MeetingCalendar> list = findByG_State(groupId, state, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MeetingCalendar exists with the key {");

            msg.append("groupId=" + groupId);

            msg.append(", ");
            msg.append("state=" + state);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchendarException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MeetingCalendar[] findByG_State_PrevAndNext(long mcalId,
        long groupId, int state, OrderByComparator obc)
        throws NoSuchendarException, SystemException {
        MeetingCalendar meetingCalendar = findByPrimaryKey(mcalId);

        int count = countByG_State(groupId, state);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

            query.append("groupId = ?");

            query.append(" AND ");

            query.append("state = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("mcalId ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(groupId);

            qPos.add(state);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    meetingCalendar);

            MeetingCalendar[] array = new MeetingCalendarImpl[3];

            array[0] = (MeetingCalendar) objArray[0];
            array[1] = (MeetingCalendar) objArray[1];
            array[2] = (MeetingCalendar) objArray[2];

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

    public List<MeetingCalendar> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<MeetingCalendar> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<MeetingCalendar> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("mcalId ASC");
                }

                Query q = session.createQuery(query.toString());

                List<MeetingCalendar> list = (List<MeetingCalendar>) QueryUtil.list(q,
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
            return (List<MeetingCalendar>) result;
        }
    }

    public void removeByUuid(String uuid) throws SystemException {
        for (MeetingCalendar meetingCalendar : findByUuid(uuid)) {
            remove(meetingCalendar);
        }
    }

    public void removeByUUID_G(String uuid, long groupId)
        throws NoSuchendarException, SystemException {
        MeetingCalendar meetingCalendar = findByUUID_G(uuid, groupId);

        remove(meetingCalendar);
    }

    public void removeByGroupId(long groupId) throws SystemException {
        for (MeetingCalendar meetingCalendar : findByGroupId(groupId)) {
            remove(meetingCalendar);
        }
    }

    public void removeByG_State(long groupId, int state)
        throws SystemException {
        for (MeetingCalendar meetingCalendar : findByG_State(groupId, state)) {
            remove(meetingCalendar);
        }
    }

    public void removeAll() throws SystemException {
        for (MeetingCalendar meetingCalendar : findAll()) {
            remove(meetingCalendar);
        }
    }

    public int countByUuid(String uuid) throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
        String finderMethodName = "countByUuid";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { uuid };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

                if (uuid == null) {
                    query.append("uuid_ IS NULL");
                } else {
                    query.append("uuid_ = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
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

    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
        String finderMethodName = "countByUUID_G";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { uuid, new Long(groupId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

                if (uuid == null) {
                    query.append("uuid_ IS NULL");
                } else {
                    query.append("uuid_ = ?");
                }

                query.append(" AND ");

                query.append("groupId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

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

    public int countByGroupId(long groupId) throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
        String finderMethodName = "countByGroupId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(groupId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

                query.append("groupId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

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

    public int countByG_State(long groupId, int state)
        throws SystemException {
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
        String finderMethodName = "countByG_State";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(groupId), new Integer(state) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar WHERE ");

                query.append("groupId = ?");

                query.append(" AND ");

                query.append("state = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(groupId);

                qPos.add(state);

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
        boolean finderClassNameCacheEnabled = MeetingCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = MeetingCalendar.class.getName();
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
                        "SELECT COUNT(*) FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar");

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
                        "value.object.listener.com.ext.portlet.meetingcalendar.model.MeetingCalendar")));

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
