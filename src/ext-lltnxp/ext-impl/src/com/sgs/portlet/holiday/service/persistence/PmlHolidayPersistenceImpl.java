package com.sgs.portlet.holiday.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.holiday.NoSuchException;
import com.sgs.portlet.holiday.model.PmlHoliday;
import com.sgs.portlet.holiday.model.impl.PmlHolidayImpl;
import com.sgs.portlet.holiday.model.impl.PmlHolidayModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlHolidayPersistenceImpl extends BasePersistenceImpl
    implements PmlHolidayPersistence {
    private static Log _log = LogFactory.getLog(PmlHolidayPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlHoliday create(long holidayId) {
        PmlHoliday pmlHoliday = new PmlHolidayImpl();

        pmlHoliday.setNew(true);
        pmlHoliday.setPrimaryKey(holidayId);

        return pmlHoliday;
    }

    public PmlHoliday remove(long holidayId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlHoliday pmlHoliday = (PmlHoliday) session.get(PmlHolidayImpl.class,
                    new Long(holidayId));

            if (pmlHoliday == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlHoliday exists with the primary key " +
                        holidayId);
                }

                throw new NoSuchException(
                    "No PmlHoliday exists with the primary key " + holidayId);
            }

            return remove(pmlHoliday);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlHoliday remove(PmlHoliday pmlHoliday) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlHoliday);
            }
        }

        pmlHoliday = removeImpl(pmlHoliday);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlHoliday);
            }
        }

        return pmlHoliday;
    }

    protected PmlHoliday removeImpl(PmlHoliday pmlHoliday)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlHoliday);

            session.flush();

            return pmlHoliday;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlHoliday.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlHoliday pmlHoliday, boolean merge)</code>.
     */
    public PmlHoliday update(PmlHoliday pmlHoliday) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlHoliday pmlHoliday) method. Use update(PmlHoliday pmlHoliday, boolean merge) instead.");
        }

        return update(pmlHoliday, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlHoliday the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlHoliday is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlHoliday update(PmlHoliday pmlHoliday, boolean merge)
        throws SystemException {
        boolean isNew = pmlHoliday.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlHoliday);
                } else {
                    listener.onBeforeUpdate(pmlHoliday);
                }
            }
        }

        pmlHoliday = updateImpl(pmlHoliday, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlHoliday);
                } else {
                    listener.onAfterUpdate(pmlHoliday);
                }
            }
        }

        return pmlHoliday;
    }

    public PmlHoliday updateImpl(
        com.sgs.portlet.holiday.model.PmlHoliday pmlHoliday, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlHoliday);
            } else {
                if (pmlHoliday.isNew()) {
                    session.save(pmlHoliday);
                }
            }

            session.flush();

            pmlHoliday.setNew(false);

            return pmlHoliday;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlHoliday.class.getName());
        }
    }

    public PmlHoliday findByPrimaryKey(long holidayId)
        throws NoSuchException, SystemException {
        PmlHoliday pmlHoliday = fetchByPrimaryKey(holidayId);

        if (pmlHoliday == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlHoliday exists with the primary key " +
                    holidayId);
            }

            throw new NoSuchException(
                "No PmlHoliday exists with the primary key " + holidayId);
        }

        return pmlHoliday;
    }

    public PmlHoliday fetchByPrimaryKey(long holidayId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlHoliday) session.get(PmlHolidayImpl.class,
                new Long(holidayId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoliday> findByHoliday_Type(String holiday_type)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "findByHoliday_Type";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { holiday_type };

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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (holiday_type == null) {
                    query.append("holiday_type LIKE null");
                } else {
                    query.append("holiday_type LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("holidayid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (holiday_type != null) {
                    qPos.add(holiday_type);
                }

                List<PmlHoliday> list = q.list();

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
            return (List<PmlHoliday>) result;
        }
    }

    public List<PmlHoliday> findByHoliday_Type(String holiday_type, int start,
        int end) throws SystemException {
        return findByHoliday_Type(holiday_type, start, end, null);
    }

    public List<PmlHoliday> findByHoliday_Type(String holiday_type, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "findByHoliday_Type";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                holiday_type,
                
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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (holiday_type == null) {
                    query.append("holiday_type LIKE null");
                } else {
                    query.append("holiday_type LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("holidayid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (holiday_type != null) {
                    qPos.add(holiday_type);
                }

                List<PmlHoliday> list = (List<PmlHoliday>) QueryUtil.list(q,
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
            return (List<PmlHoliday>) result;
        }
    }

    public PmlHoliday findByHoliday_Type_First(String holiday_type,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlHoliday> list = findByHoliday_Type(holiday_type, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("holiday_type=" + holiday_type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday findByHoliday_Type_Last(String holiday_type,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByHoliday_Type(holiday_type);

        List<PmlHoliday> list = findByHoliday_Type(holiday_type, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("holiday_type=" + holiday_type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday[] findByHoliday_Type_PrevAndNext(long holidayId,
        String holiday_type, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlHoliday pmlHoliday = findByPrimaryKey(holidayId);

        int count = countByHoliday_Type(holiday_type);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

            if (holiday_type == null) {
                query.append("holiday_type LIKE null");
            } else {
                query.append("holiday_type LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("holidayid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (holiday_type != null) {
                qPos.add(holiday_type);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoliday);

            PmlHoliday[] array = new PmlHolidayImpl[3];

            array[0] = (PmlHoliday) objArray[0];
            array[1] = (PmlHoliday) objArray[1];
            array[2] = (PmlHoliday) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoliday> findByHoliday_Value(String holiday_value)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "findByHoliday_Value";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { holiday_value };

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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (holiday_value == null) {
                    query.append("holiday_value LIKE null");
                } else {
                    query.append("holiday_value LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("holidayid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (holiday_value != null) {
                    qPos.add(holiday_value);
                }

                List<PmlHoliday> list = q.list();

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
            return (List<PmlHoliday>) result;
        }
    }

    public List<PmlHoliday> findByHoliday_Value(String holiday_value,
        int start, int end) throws SystemException {
        return findByHoliday_Value(holiday_value, start, end, null);
    }

    public List<PmlHoliday> findByHoliday_Value(String holiday_value,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "findByHoliday_Value";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                holiday_value,
                
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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (holiday_value == null) {
                    query.append("holiday_value LIKE null");
                } else {
                    query.append("holiday_value LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("holidayid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (holiday_value != null) {
                    qPos.add(holiday_value);
                }

                List<PmlHoliday> list = (List<PmlHoliday>) QueryUtil.list(q,
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
            return (List<PmlHoliday>) result;
        }
    }

    public PmlHoliday findByHoliday_Value_First(String holiday_value,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlHoliday> list = findByHoliday_Value(holiday_value, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("holiday_value=" + holiday_value);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday findByHoliday_Value_Last(String holiday_value,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByHoliday_Value(holiday_value);

        List<PmlHoliday> list = findByHoliday_Value(holiday_value, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("holiday_value=" + holiday_value);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday[] findByHoliday_Value_PrevAndNext(long holidayId,
        String holiday_value, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlHoliday pmlHoliday = findByPrimaryKey(holidayId);

        int count = countByHoliday_Value(holiday_value);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

            if (holiday_value == null) {
                query.append("holiday_value LIKE null");
            } else {
                query.append("holiday_value LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("holidayid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (holiday_value != null) {
                qPos.add(holiday_value);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoliday);

            PmlHoliday[] array = new PmlHolidayImpl[3];

            array[0] = (PmlHoliday) objArray[0];
            array[1] = (PmlHoliday) objArray[1];
            array[2] = (PmlHoliday) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoliday> findByFrom_Date(Date from_date)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "findByFrom_Date";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { from_date };

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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (from_date == null) {
                    query.append("from_date IS NULL");
                } else {
                    query.append("from_date = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("holidayid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (from_date != null) {
                    qPos.add(CalendarUtil.getTimestamp(from_date));
                }

                List<PmlHoliday> list = q.list();

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
            return (List<PmlHoliday>) result;
        }
    }

    public List<PmlHoliday> findByFrom_Date(Date from_date, int start, int end)
        throws SystemException {
        return findByFrom_Date(from_date, start, end, null);
    }

    public List<PmlHoliday> findByFrom_Date(Date from_date, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "findByFrom_Date";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                from_date,
                
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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (from_date == null) {
                    query.append("from_date IS NULL");
                } else {
                    query.append("from_date = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("holidayid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (from_date != null) {
                    qPos.add(CalendarUtil.getTimestamp(from_date));
                }

                List<PmlHoliday> list = (List<PmlHoliday>) QueryUtil.list(q,
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
            return (List<PmlHoliday>) result;
        }
    }

    public PmlHoliday findByFrom_Date_First(Date from_date,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlHoliday> list = findByFrom_Date(from_date, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("from_date=" + from_date);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday findByFrom_Date_Last(Date from_date, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByFrom_Date(from_date);

        List<PmlHoliday> list = findByFrom_Date(from_date, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("from_date=" + from_date);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday[] findByFrom_Date_PrevAndNext(long holidayId,
        Date from_date, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlHoliday pmlHoliday = findByPrimaryKey(holidayId);

        int count = countByFrom_Date(from_date);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

            if (from_date == null) {
                query.append("from_date IS NULL");
            } else {
                query.append("from_date = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("holidayid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (from_date != null) {
                qPos.add(CalendarUtil.getTimestamp(from_date));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoliday);

            PmlHoliday[] array = new PmlHolidayImpl[3];

            array[0] = (PmlHoliday) objArray[0];
            array[1] = (PmlHoliday) objArray[1];
            array[2] = (PmlHoliday) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoliday> findByTo_Date(Date to_date)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "findByTo_Date";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { to_date };

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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (to_date == null) {
                    query.append("to_date IS NULL");
                } else {
                    query.append("to_date = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("holidayid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (to_date != null) {
                    qPos.add(CalendarUtil.getTimestamp(to_date));
                }

                List<PmlHoliday> list = q.list();

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
            return (List<PmlHoliday>) result;
        }
    }

    public List<PmlHoliday> findByTo_Date(Date to_date, int start, int end)
        throws SystemException {
        return findByTo_Date(to_date, start, end, null);
    }

    public List<PmlHoliday> findByTo_Date(Date to_date, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "findByTo_Date";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                to_date,
                
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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (to_date == null) {
                    query.append("to_date IS NULL");
                } else {
                    query.append("to_date = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("holidayid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (to_date != null) {
                    qPos.add(CalendarUtil.getTimestamp(to_date));
                }

                List<PmlHoliday> list = (List<PmlHoliday>) QueryUtil.list(q,
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
            return (List<PmlHoliday>) result;
        }
    }

    public PmlHoliday findByTo_Date_First(Date to_date, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<PmlHoliday> list = findByTo_Date(to_date, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("to_date=" + to_date);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday findByTo_Date_Last(Date to_date, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByTo_Date(to_date);

        List<PmlHoliday> list = findByTo_Date(to_date, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("to_date=" + to_date);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday[] findByTo_Date_PrevAndNext(long holidayId, Date to_date,
        OrderByComparator obc) throws NoSuchException, SystemException {
        PmlHoliday pmlHoliday = findByPrimaryKey(holidayId);

        int count = countByTo_Date(to_date);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

            if (to_date == null) {
                query.append("to_date IS NULL");
            } else {
                query.append("to_date = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("holidayid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (to_date != null) {
                qPos.add(CalendarUtil.getTimestamp(to_date));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoliday);

            PmlHoliday[] array = new PmlHolidayImpl[3];

            array[0] = (PmlHoliday) objArray[0];
            array[1] = (PmlHoliday) objArray[1];
            array[2] = (PmlHoliday) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoliday> findByFromDate_ToDate(Date from_date, Date to_date)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "findByFromDate_ToDate";
        String[] finderParams = new String[] {
                Date.class.getName(), Date.class.getName()
            };
        Object[] finderArgs = new Object[] { from_date, to_date };

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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (from_date == null) {
                    query.append("from_date IS NULL");
                } else {
                    query.append("from_date = ?");
                }

                query.append(" AND ");

                if (to_date == null) {
                    query.append("to_date IS NULL");
                } else {
                    query.append("to_date = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("holidayid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (from_date != null) {
                    qPos.add(CalendarUtil.getTimestamp(from_date));
                }

                if (to_date != null) {
                    qPos.add(CalendarUtil.getTimestamp(to_date));
                }

                List<PmlHoliday> list = q.list();

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
            return (List<PmlHoliday>) result;
        }
    }

    public List<PmlHoliday> findByFromDate_ToDate(Date from_date, Date to_date,
        int start, int end) throws SystemException {
        return findByFromDate_ToDate(from_date, to_date, start, end, null);
    }

    public List<PmlHoliday> findByFromDate_ToDate(Date from_date, Date to_date,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "findByFromDate_ToDate";
        String[] finderParams = new String[] {
                Date.class.getName(), Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                from_date,
                
                to_date,
                
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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (from_date == null) {
                    query.append("from_date IS NULL");
                } else {
                    query.append("from_date = ?");
                }

                query.append(" AND ");

                if (to_date == null) {
                    query.append("to_date IS NULL");
                } else {
                    query.append("to_date = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("holidayid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (from_date != null) {
                    qPos.add(CalendarUtil.getTimestamp(from_date));
                }

                if (to_date != null) {
                    qPos.add(CalendarUtil.getTimestamp(to_date));
                }

                List<PmlHoliday> list = (List<PmlHoliday>) QueryUtil.list(q,
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
            return (List<PmlHoliday>) result;
        }
    }

    public PmlHoliday findByFromDate_ToDate_First(Date from_date, Date to_date,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlHoliday> list = findByFromDate_ToDate(from_date, to_date, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("from_date=" + from_date);

            msg.append(", ");
            msg.append("to_date=" + to_date);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday findByFromDate_ToDate_Last(Date from_date, Date to_date,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByFromDate_ToDate(from_date, to_date);

        List<PmlHoliday> list = findByFromDate_ToDate(from_date, to_date,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("from_date=" + from_date);

            msg.append(", ");
            msg.append("to_date=" + to_date);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday[] findByFromDate_ToDate_PrevAndNext(long holidayId,
        Date from_date, Date to_date, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlHoliday pmlHoliday = findByPrimaryKey(holidayId);

        int count = countByFromDate_ToDate(from_date, to_date);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

            if (from_date == null) {
                query.append("from_date IS NULL");
            } else {
                query.append("from_date = ?");
            }

            query.append(" AND ");

            if (to_date == null) {
                query.append("to_date IS NULL");
            } else {
                query.append("to_date = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("holidayid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (from_date != null) {
                qPos.add(CalendarUtil.getTimestamp(from_date));
            }

            if (to_date != null) {
                qPos.add(CalendarUtil.getTimestamp(to_date));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoliday);

            PmlHoliday[] array = new PmlHolidayImpl[3];

            array[0] = (PmlHoliday) objArray[0];
            array[1] = (PmlHoliday) objArray[1];
            array[2] = (PmlHoliday) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoliday> findByHolidayType_HolidayValue(
        String holiday_type, String holiday_value) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "findByHolidayType_HolidayValue";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { holiday_type, holiday_value };

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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (holiday_type == null) {
                    query.append("holiday_type LIKE null");
                } else {
                    query.append("holiday_type LIKE ?");
                }

                query.append(" AND ");

                if (holiday_value == null) {
                    query.append("holiday_value LIKE null");
                } else {
                    query.append("holiday_value LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("holidayid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (holiday_type != null) {
                    qPos.add(holiday_type);
                }

                if (holiday_value != null) {
                    qPos.add(holiday_value);
                }

                List<PmlHoliday> list = q.list();

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
            return (List<PmlHoliday>) result;
        }
    }

    public List<PmlHoliday> findByHolidayType_HolidayValue(
        String holiday_type, String holiday_value, int start, int end)
        throws SystemException {
        return findByHolidayType_HolidayValue(holiday_type, holiday_value,
            start, end, null);
    }

    public List<PmlHoliday> findByHolidayType_HolidayValue(
        String holiday_type, String holiday_value, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "findByHolidayType_HolidayValue";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                holiday_type,
                
                holiday_value,
                
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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (holiday_type == null) {
                    query.append("holiday_type LIKE null");
                } else {
                    query.append("holiday_type LIKE ?");
                }

                query.append(" AND ");

                if (holiday_value == null) {
                    query.append("holiday_value LIKE null");
                } else {
                    query.append("holiday_value LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("holidayid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (holiday_type != null) {
                    qPos.add(holiday_type);
                }

                if (holiday_value != null) {
                    qPos.add(holiday_value);
                }

                List<PmlHoliday> list = (List<PmlHoliday>) QueryUtil.list(q,
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
            return (List<PmlHoliday>) result;
        }
    }

    public PmlHoliday findByHolidayType_HolidayValue_First(
        String holiday_type, String holiday_value, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<PmlHoliday> list = findByHolidayType_HolidayValue(holiday_type,
                holiday_value, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("holiday_type=" + holiday_type);

            msg.append(", ");
            msg.append("holiday_value=" + holiday_value);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday findByHolidayType_HolidayValue_Last(String holiday_type,
        String holiday_value, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByHolidayType_HolidayValue(holiday_type, holiday_value);

        List<PmlHoliday> list = findByHolidayType_HolidayValue(holiday_type,
                holiday_value, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("holiday_type=" + holiday_type);

            msg.append(", ");
            msg.append("holiday_value=" + holiday_value);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday[] findByHolidayType_HolidayValue_PrevAndNext(
        long holidayId, String holiday_type, String holiday_value,
        OrderByComparator obc) throws NoSuchException, SystemException {
        PmlHoliday pmlHoliday = findByPrimaryKey(holidayId);

        int count = countByHolidayType_HolidayValue(holiday_type, holiday_value);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

            if (holiday_type == null) {
                query.append("holiday_type LIKE null");
            } else {
                query.append("holiday_type LIKE ?");
            }

            query.append(" AND ");

            if (holiday_value == null) {
                query.append("holiday_value LIKE null");
            } else {
                query.append("holiday_value LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("holidayid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (holiday_type != null) {
                qPos.add(holiday_type);
            }

            if (holiday_value != null) {
                qPos.add(holiday_value);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoliday);

            PmlHoliday[] array = new PmlHolidayImpl[3];

            array[0] = (PmlHoliday) objArray[0];
            array[1] = (PmlHoliday) objArray[1];
            array[2] = (PmlHoliday) objArray[2];

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

    public List<PmlHoliday> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlHoliday> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlHoliday> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
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

                query.append("FROM com.sgs.portlet.holiday.model.PmlHoliday ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("holidayid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlHoliday> list = (List<PmlHoliday>) QueryUtil.list(q,
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
            return (List<PmlHoliday>) result;
        }
    }

    public void removeByHoliday_Type(String holiday_type)
        throws SystemException {
        for (PmlHoliday pmlHoliday : findByHoliday_Type(holiday_type)) {
            remove(pmlHoliday);
        }
    }

    public void removeByHoliday_Value(String holiday_value)
        throws SystemException {
        for (PmlHoliday pmlHoliday : findByHoliday_Value(holiday_value)) {
            remove(pmlHoliday);
        }
    }

    public void removeByFrom_Date(Date from_date) throws SystemException {
        for (PmlHoliday pmlHoliday : findByFrom_Date(from_date)) {
            remove(pmlHoliday);
        }
    }

    public void removeByTo_Date(Date to_date) throws SystemException {
        for (PmlHoliday pmlHoliday : findByTo_Date(to_date)) {
            remove(pmlHoliday);
        }
    }

    public void removeByFromDate_ToDate(Date from_date, Date to_date)
        throws SystemException {
        for (PmlHoliday pmlHoliday : findByFromDate_ToDate(from_date, to_date)) {
            remove(pmlHoliday);
        }
    }

    public void removeByHolidayType_HolidayValue(String holiday_type,
        String holiday_value) throws SystemException {
        for (PmlHoliday pmlHoliday : findByHolidayType_HolidayValue(
                holiday_type, holiday_value)) {
            remove(pmlHoliday);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlHoliday pmlHoliday : findAll()) {
            remove(pmlHoliday);
        }
    }

    public int countByHoliday_Type(String holiday_type)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "countByHoliday_Type";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { holiday_type };

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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (holiday_type == null) {
                    query.append("holiday_type LIKE null");
                } else {
                    query.append("holiday_type LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (holiday_type != null) {
                    qPos.add(holiday_type);
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

    public int countByHoliday_Value(String holiday_value)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "countByHoliday_Value";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { holiday_value };

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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (holiday_value == null) {
                    query.append("holiday_value LIKE null");
                } else {
                    query.append("holiday_value LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (holiday_value != null) {
                    qPos.add(holiday_value);
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

    public int countByFrom_Date(Date from_date) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "countByFrom_Date";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { from_date };

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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (from_date == null) {
                    query.append("from_date IS NULL");
                } else {
                    query.append("from_date = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (from_date != null) {
                    qPos.add(CalendarUtil.getTimestamp(from_date));
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

    public int countByTo_Date(Date to_date) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "countByTo_Date";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { to_date };

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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (to_date == null) {
                    query.append("to_date IS NULL");
                } else {
                    query.append("to_date = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (to_date != null) {
                    qPos.add(CalendarUtil.getTimestamp(to_date));
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

    public int countByFromDate_ToDate(Date from_date, Date to_date)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "countByFromDate_ToDate";
        String[] finderParams = new String[] {
                Date.class.getName(), Date.class.getName()
            };
        Object[] finderArgs = new Object[] { from_date, to_date };

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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (from_date == null) {
                    query.append("from_date IS NULL");
                } else {
                    query.append("from_date = ?");
                }

                query.append(" AND ");

                if (to_date == null) {
                    query.append("to_date IS NULL");
                } else {
                    query.append("to_date = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (from_date != null) {
                    qPos.add(CalendarUtil.getTimestamp(from_date));
                }

                if (to_date != null) {
                    qPos.add(CalendarUtil.getTimestamp(to_date));
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

    public int countByHolidayType_HolidayValue(String holiday_type,
        String holiday_value) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
        String finderMethodName = "countByHolidayType_HolidayValue";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { holiday_type, holiday_value };

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
                    "FROM com.sgs.portlet.holiday.model.PmlHoliday WHERE ");

                if (holiday_type == null) {
                    query.append("holiday_type LIKE null");
                } else {
                    query.append("holiday_type LIKE ?");
                }

                query.append(" AND ");

                if (holiday_value == null) {
                    query.append("holiday_value LIKE null");
                } else {
                    query.append("holiday_value LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (holiday_type != null) {
                    qPos.add(holiday_type);
                }

                if (holiday_value != null) {
                    qPos.add(holiday_value);
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

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoliday.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.holiday.model.PmlHoliday");

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
                        "value.object.listener.com.sgs.portlet.holiday.model.PmlHoliday")));

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
