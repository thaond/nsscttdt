package com.sgs.portlet.holiday_calendar.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.holiday_calendar.NoSuchException;
import com.sgs.portlet.holiday_calendar.model.HolidayCalendar;
import com.sgs.portlet.holiday_calendar.model.impl.HolidayCalendarImpl;
import com.sgs.portlet.holiday_calendar.model.impl.HolidayCalendarModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class HolidayCalendarPersistenceImpl extends BasePersistenceImpl
    implements HolidayCalendarPersistence {
    private static final String _SQL_GETATTACTFILEHOLIDAIES = "SELECT {attact_file_holiday.*} FROM attact_file_holiday INNER JOIN holiday_calendar ON (holiday_calendar.holidayCalendarId = attact_file_holiday.holidayCalendarId) WHERE (holiday_calendar.holidayCalendarId = ?)";
    private static final String _SQL_GETATTACTFILEHOLIDAIESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM attact_file_holiday WHERE holidayCalendarId = ?";
    private static final String _SQL_CONTAINSATTACTFILEHOLIDAY = "SELECT COUNT(*) AS COUNT_VALUE FROM attact_file_holiday WHERE holidayCalendarId = ? AND attactFileHolidayId = ?";
    private static Log _log = LogFactory.getLog(HolidayCalendarPersistenceImpl.class);
    protected ContainsAttactFileHoliday containsAttactFileHoliday;
    private ModelListener[] _listeners = new ModelListener[0];

    public HolidayCalendar create(long holidayCalendarId) {
        HolidayCalendar holidayCalendar = new HolidayCalendarImpl();

        holidayCalendar.setNew(true);
        holidayCalendar.setPrimaryKey(holidayCalendarId);

        return holidayCalendar;
    }

    public HolidayCalendar remove(long holidayCalendarId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            HolidayCalendar holidayCalendar = (HolidayCalendar) session.get(HolidayCalendarImpl.class,
                    new Long(holidayCalendarId));

            if (holidayCalendar == null) {
                if (_log.isWarnEnabled()) {
//                    _log.warn("No HolidayCalendar exists with the primary key " + holidayCalendarId);
                }

                throw new NoSuchException(
                    "No HolidayCalendar exists with the primary key " +
                    holidayCalendarId);
            }

            return remove(holidayCalendar);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public HolidayCalendar remove(HolidayCalendar holidayCalendar)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(holidayCalendar);
            }
        }

        holidayCalendar = removeImpl(holidayCalendar);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(holidayCalendar);
            }
        }

        return holidayCalendar;
    }

    protected HolidayCalendar removeImpl(HolidayCalendar holidayCalendar)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(holidayCalendar);

            session.flush();

            return holidayCalendar;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(HolidayCalendar.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(HolidayCalendar holidayCalendar, boolean merge)</code>.
     */
    public HolidayCalendar update(HolidayCalendar holidayCalendar)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(HolidayCalendar holidayCalendar) method. Use update(HolidayCalendar holidayCalendar, boolean merge) instead.");
        }

        return update(holidayCalendar, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                holidayCalendar the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when holidayCalendar is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public HolidayCalendar update(HolidayCalendar holidayCalendar, boolean merge)
        throws SystemException {
        boolean isNew = holidayCalendar.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(holidayCalendar);
                } else {
                    listener.onBeforeUpdate(holidayCalendar);
                }
            }
        }

        holidayCalendar = updateImpl(holidayCalendar, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(holidayCalendar);
                } else {
                    listener.onAfterUpdate(holidayCalendar);
                }
            }
        }

        return holidayCalendar;
    }

    public HolidayCalendar updateImpl(
        com.sgs.portlet.holiday_calendar.model.HolidayCalendar holidayCalendar,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(holidayCalendar);
            } else {
                if (holidayCalendar.isNew()) {
                    session.save(holidayCalendar);
                }
            }

            session.flush();

            holidayCalendar.setNew(false);

            return holidayCalendar;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(HolidayCalendar.class.getName());
        }
    }

    public HolidayCalendar findByPrimaryKey(long holidayCalendarId)
        throws NoSuchException, SystemException {
        HolidayCalendar holidayCalendar = fetchByPrimaryKey(holidayCalendarId);

        if (holidayCalendar == null) {
            if (_log.isWarnEnabled()) {
//                _log.warn("No HolidayCalendar exists with the primary key " + holidayCalendarId);
            }

            throw new NoSuchException(
                "No HolidayCalendar exists with the primary key " +
                holidayCalendarId);
        }

        return holidayCalendar;
    }

    public HolidayCalendar fetchByPrimaryKey(long holidayCalendarId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (HolidayCalendar) session.get(HolidayCalendarImpl.class,
                new Long(holidayCalendarId));
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

    public List<HolidayCalendar> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<HolidayCalendar> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<HolidayCalendar> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = HolidayCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = HolidayCalendar.class.getName();
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
                    "FROM com.sgs.portlet.holiday_calendar.model.HolidayCalendar ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<HolidayCalendar> list = (List<HolidayCalendar>) QueryUtil.list(q,
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
            return (List<HolidayCalendar>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (HolidayCalendar holidayCalendar : findAll()) {
            remove(holidayCalendar);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = HolidayCalendarModelImpl.CACHE_ENABLED;
        String finderClassName = HolidayCalendar.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.holiday_calendar.model.HolidayCalendar");

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

    public List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidaies(
        long pk) throws SystemException {
        return getAttactFileHolidaies(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    public List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidaies(
        long pk, int start, int end) throws SystemException {
        return getAttactFileHolidaies(pk, start, end, null);
    }

    public List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidaies(
        long pk, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.holiday_calendar.model.impl.AttactFileHolidayModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.holiday_calendar.model.AttactFileHoliday.class.getName();

        String finderMethodName = "getAttactFileHolidaies";
        String[] finderParams = new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(pk), String.valueOf(start), String.valueOf(end),
                String.valueOf(obc)
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

                StringBuilder sb = new StringBuilder();

                sb.append(_SQL_GETATTACTFILEHOLIDAIES);

                if (obc != null) {
                    sb.append("ORDER BY ");
                    sb.append(obc.getOrderBy());
                }

                String sql = sb.toString();

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("attact_file_holiday",
                    com.sgs.portlet.holiday_calendar.model.impl.AttactFileHolidayImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> list =
                    (List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday>) QueryUtil.list(q,
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
            return (List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday>) result;
        }
    }

    public int getAttactFileHolidaiesSize(long pk) throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.holiday_calendar.model.impl.AttactFileHolidayModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.holiday_calendar.model.AttactFileHoliday.class.getName();

        String finderMethodName = "getAttactFileHolidaiesSize";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(pk) };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETATTACTFILEHOLIDAIESSIZE);

                q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

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

    public boolean containsAttactFileHoliday(long pk, long attactFileHolidayPK)
        throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.holiday_calendar.model.impl.AttactFileHolidayModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.holiday_calendar.model.AttactFileHoliday.class.getName();

        String finderMethodName = "containsAttactFileHolidaies";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(pk),
                
                new Long(attactFileHolidayPK)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            try {
                Boolean value = Boolean.valueOf(containsAttactFileHoliday.contains(
                            pk, attactFileHolidayPK));

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, value);

                return value.booleanValue();
            } catch (Exception e) {
                throw processException(e);
            }
        } else {
            return ((Boolean) result).booleanValue();
        }
    }

    public boolean containsAttactFileHolidaies(long pk)
        throws SystemException {
        if (getAttactFileHolidaiesSize(pk) > 0) {
            return true;
        } else {
            return false;
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
                        "value.object.listener.com.sgs.portlet.holiday_calendar.model.HolidayCalendar")));

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

        containsAttactFileHoliday = new ContainsAttactFileHoliday(this);
    }

    protected class ContainsAttactFileHoliday {
        private MappingSqlQuery _mappingSqlQuery;

        protected ContainsAttactFileHoliday(
            HolidayCalendarPersistenceImpl persistenceImpl) {
            super();

            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSATTACTFILEHOLIDAY,
                    new int[] { Types.BIGINT, Types.BIGINT }, RowMapper.COUNT);
        }

        protected boolean contains(long holidayCalendarId,
            long attactFileHolidayId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(holidayCalendarId),
                        new Long(attactFileHolidayId)
                    });

            if (results.size() > 0) {
                Integer count = results.get(0);

                if (count.intValue() > 0) {
                    return true;
                }
            }

            return false;
        }
    }
}
