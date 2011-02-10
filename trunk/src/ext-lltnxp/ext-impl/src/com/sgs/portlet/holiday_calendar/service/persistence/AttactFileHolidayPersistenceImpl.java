package com.sgs.portlet.holiday_calendar.service.persistence;

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

import com.sgs.portlet.holiday_calendar.NoSuchAttactFileHolidayException;
import com.sgs.portlet.holiday_calendar.model.AttactFileHoliday;
import com.sgs.portlet.holiday_calendar.model.impl.AttactFileHolidayImpl;
import com.sgs.portlet.holiday_calendar.model.impl.AttactFileHolidayModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class AttactFileHolidayPersistenceImpl extends BasePersistenceImpl
    implements AttactFileHolidayPersistence {
    private static Log _log = LogFactory.getLog(AttactFileHolidayPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public AttactFileHoliday create(long attactFileHolidayId) {
        AttactFileHoliday attactFileHoliday = new AttactFileHolidayImpl();

        attactFileHoliday.setNew(true);
        attactFileHoliday.setPrimaryKey(attactFileHolidayId);

        return attactFileHoliday;
    }

    public AttactFileHoliday remove(long attactFileHolidayId)
        throws NoSuchAttactFileHolidayException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AttactFileHoliday attactFileHoliday = (AttactFileHoliday) session.get(AttactFileHolidayImpl.class,
                    new Long(attactFileHolidayId));

            if (attactFileHoliday == null) {
                if (_log.isWarnEnabled()) {
//                    _log.warn("No AttactFileHoliday exists with the primary key " + attactFileHolidayId);
                }

                throw new NoSuchAttactFileHolidayException(
                    "No AttactFileHoliday exists with the primary key " +
                    attactFileHolidayId);
            }

            return remove(attactFileHoliday);
        } catch (NoSuchAttactFileHolidayException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public AttactFileHoliday remove(AttactFileHoliday attactFileHoliday)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(attactFileHoliday);
            }
        }

        attactFileHoliday = removeImpl(attactFileHoliday);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(attactFileHoliday);
            }
        }

        return attactFileHoliday;
    }

    protected AttactFileHoliday removeImpl(AttactFileHoliday attactFileHoliday)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(attactFileHoliday);

            session.flush();

            return attactFileHoliday;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(AttactFileHoliday.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(AttactFileHoliday attactFileHoliday, boolean merge)</code>.
     */
    public AttactFileHoliday update(AttactFileHoliday attactFileHoliday)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(AttactFileHoliday attactFileHoliday) method. Use update(AttactFileHoliday attactFileHoliday, boolean merge) instead.");
        }

        return update(attactFileHoliday, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                attactFileHoliday the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when attactFileHoliday is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public AttactFileHoliday update(AttactFileHoliday attactFileHoliday,
        boolean merge) throws SystemException {
        boolean isNew = attactFileHoliday.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(attactFileHoliday);
                } else {
                    listener.onBeforeUpdate(attactFileHoliday);
                }
            }
        }

        attactFileHoliday = updateImpl(attactFileHoliday, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(attactFileHoliday);
                } else {
                    listener.onAfterUpdate(attactFileHoliday);
                }
            }
        }

        return attactFileHoliday;
    }

    public AttactFileHoliday updateImpl(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(attactFileHoliday);
            } else {
                if (attactFileHoliday.isNew()) {
                    session.save(attactFileHoliday);
                }
            }

            session.flush();

            attactFileHoliday.setNew(false);

            return attactFileHoliday;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(AttactFileHoliday.class.getName());
        }
    }

    public AttactFileHoliday findByPrimaryKey(long attactFileHolidayId)
        throws NoSuchAttactFileHolidayException, SystemException {
        AttactFileHoliday attactFileHoliday = fetchByPrimaryKey(attactFileHolidayId);

        if (attactFileHoliday == null) {
            if (_log.isWarnEnabled()) {
//                _log.warn("No AttactFileHoliday exists with the primary key " + attactFileHolidayId);
            }

            throw new NoSuchAttactFileHolidayException(
                "No AttactFileHoliday exists with the primary key " +
                attactFileHolidayId);
        }

        return attactFileHoliday;
    }

    public AttactFileHoliday fetchByPrimaryKey(long attactFileHolidayId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (AttactFileHoliday) session.get(AttactFileHolidayImpl.class,
                new Long(attactFileHolidayId));
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

    public List<AttactFileHoliday> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<AttactFileHoliday> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<AttactFileHoliday> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = AttactFileHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = AttactFileHoliday.class.getName();
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
                    "FROM com.sgs.portlet.holiday_calendar.model.AttactFileHoliday ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<AttactFileHoliday> list = (List<AttactFileHoliday>) QueryUtil.list(q,
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
            return (List<AttactFileHoliday>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (AttactFileHoliday attactFileHoliday : findAll()) {
            remove(attactFileHoliday);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = AttactFileHolidayModelImpl.CACHE_ENABLED;
        String finderClassName = AttactFileHoliday.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.holiday_calendar.model.AttactFileHoliday");

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
                        "value.object.listener.com.sgs.portlet.holiday_calendar.model.AttactFileHoliday")));

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
