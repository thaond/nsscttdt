package com.nss.portlet.holidaymanagement.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.holidaymanagement.NoSuchPmlHolidayException;
import com.nss.portlet.holidaymanagement.model.PmlHoliday;
import com.nss.portlet.holidaymanagement.model.impl.PmlHolidayImpl;
import com.nss.portlet.holidaymanagement.model.impl.PmlHolidayModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class PmlHolidayPersistenceImpl extends BasePersistenceImpl
    implements PmlHolidayPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlHolidayImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_HOLIDAY_TYPE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByHoliday_Type", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_HOLIDAY_TYPE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByHoliday_Type",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_HOLIDAY_TYPE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByHoliday_Type", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_HOLIDAY_VALUE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByHoliday_Value", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_HOLIDAY_VALUE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByHoliday_Value",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_HOLIDAY_VALUE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByHoliday_Value", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FROM_DATE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFrom_Date", new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FROM_DATE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFrom_Date",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FROM_DATE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFrom_Date", new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_TO_DATE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByTo_Date", new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_TO_DATE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByTo_Date",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_TO_DATE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByTo_Date", new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FROMDATE_TODATE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFromDate_ToDate",
            new String[] { Date.class.getName(), Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FROMDATE_TODATE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFromDate_ToDate",
            new String[] {
                Date.class.getName(), Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FROMDATE_TODATE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFromDate_ToDate",
            new String[] { Date.class.getName(), Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_HOLIDAYTYPE_HOLIDAYVALUE = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByHolidayType_HolidayValue",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_HOLIDAYTYPE_HOLIDAYVALUE =
        new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByHolidayType_HolidayValue",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_HOLIDAYTYPE_HOLIDAYVALUE =
        new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByHolidayType_HolidayValue",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlHolidayPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.holidaymanagement.service.persistence.PmlHolidayPersistence.impl")
    protected com.nss.portlet.holidaymanagement.service.persistence.PmlHolidayPersistence pmlHolidayPersistence;

    public void cacheResult(PmlHoliday pmlHoliday) {
        EntityCacheUtil.putResult(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayImpl.class, pmlHoliday.getPrimaryKey(), pmlHoliday);
    }

    public void cacheResult(List<PmlHoliday> pmlHolidaies) {
        for (PmlHoliday pmlHoliday : pmlHolidaies) {
            if (EntityCacheUtil.getResult(
                        PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
                        PmlHolidayImpl.class, pmlHoliday.getPrimaryKey(), this) == null) {
                cacheResult(pmlHoliday);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlHolidayImpl.class.getName());
        EntityCacheUtil.clearCache(PmlHolidayImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlHoliday create(long holidayId) {
        PmlHoliday pmlHoliday = new PmlHolidayImpl();

        pmlHoliday.setNew(true);
        pmlHoliday.setPrimaryKey(holidayId);

        return pmlHoliday;
    }

    public PmlHoliday remove(long holidayId)
        throws NoSuchPmlHolidayException, SystemException {
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

                throw new NoSuchPmlHolidayException(
                    "No PmlHoliday exists with the primary key " + holidayId);
            }

            return remove(pmlHoliday);
        } catch (NoSuchPmlHolidayException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlHoliday remove(PmlHoliday pmlHoliday) throws SystemException {
        for (ModelListener<PmlHoliday> listener : listeners) {
            listener.onBeforeRemove(pmlHoliday);
        }

        pmlHoliday = removeImpl(pmlHoliday);

        for (ModelListener<PmlHoliday> listener : listeners) {
            listener.onAfterRemove(pmlHoliday);
        }

        return pmlHoliday;
    }

    protected PmlHoliday removeImpl(PmlHoliday pmlHoliday)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlHoliday.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlHolidayImpl.class,
                        pmlHoliday.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlHoliday);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayImpl.class, pmlHoliday.getPrimaryKey());

        return pmlHoliday;
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

        for (ModelListener<PmlHoliday> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlHoliday);
            } else {
                listener.onBeforeUpdate(pmlHoliday);
            }
        }

        pmlHoliday = updateImpl(pmlHoliday, merge);

        for (ModelListener<PmlHoliday> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlHoliday);
            } else {
                listener.onAfterUpdate(pmlHoliday);
            }
        }

        return pmlHoliday;
    }

    public PmlHoliday updateImpl(
        com.nss.portlet.holidaymanagement.model.PmlHoliday pmlHoliday,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlHoliday, merge);

            pmlHoliday.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
            PmlHolidayImpl.class, pmlHoliday.getPrimaryKey(), pmlHoliday);

        return pmlHoliday;
    }

    public PmlHoliday findByPrimaryKey(long holidayId)
        throws NoSuchPmlHolidayException, SystemException {
        PmlHoliday pmlHoliday = fetchByPrimaryKey(holidayId);

        if (pmlHoliday == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlHoliday exists with the primary key " +
                    holidayId);
            }

            throw new NoSuchPmlHolidayException(
                "No PmlHoliday exists with the primary key " + holidayId);
        }

        return pmlHoliday;
    }

    public PmlHoliday fetchByPrimaryKey(long holidayId)
        throws SystemException {
        PmlHoliday pmlHoliday = (PmlHoliday) EntityCacheUtil.getResult(PmlHolidayModelImpl.ENTITY_CACHE_ENABLED,
                PmlHolidayImpl.class, holidayId, this);

        if (pmlHoliday == null) {
            Session session = null;

            try {
                session = openSession();

                pmlHoliday = (PmlHoliday) session.get(PmlHolidayImpl.class,
                        new Long(holidayId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlHoliday != null) {
                    cacheResult(pmlHoliday);
                }

                closeSession(session);
            }
        }

        return pmlHoliday;
    }

    public List<PmlHoliday> findByHoliday_Type(String holiday_type)
        throws SystemException {
        Object[] finderArgs = new Object[] { holiday_type };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_HOLIDAY_TYPE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_HOLIDAY_TYPE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlHoliday> findByHoliday_Type(String holiday_type, int start,
        int end) throws SystemException {
        return findByHoliday_Type(holiday_type, start, end, null);
    }

    public List<PmlHoliday> findByHoliday_Type(String holiday_type, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                holiday_type,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_HOLIDAY_TYPE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                list = (List<PmlHoliday>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_HOLIDAY_TYPE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlHoliday findByHoliday_Type_First(String holiday_type,
        OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        List<PmlHoliday> list = findByHoliday_Type(holiday_type, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("holiday_type=" + holiday_type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHolidayException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday findByHoliday_Type_Last(String holiday_type,
        OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        int count = countByHoliday_Type(holiday_type);

        List<PmlHoliday> list = findByHoliday_Type(holiday_type, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("holiday_type=" + holiday_type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHolidayException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday[] findByHoliday_Type_PrevAndNext(long holidayId,
        String holiday_type, OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        PmlHoliday pmlHoliday = findByPrimaryKey(holidayId);

        int count = countByHoliday_Type(holiday_type);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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
        Object[] finderArgs = new Object[] { holiday_value };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_HOLIDAY_VALUE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_HOLIDAY_VALUE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlHoliday> findByHoliday_Value(String holiday_value,
        int start, int end) throws SystemException {
        return findByHoliday_Value(holiday_value, start, end, null);
    }

    public List<PmlHoliday> findByHoliday_Value(String holiday_value,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                holiday_value,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_HOLIDAY_VALUE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                list = (List<PmlHoliday>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_HOLIDAY_VALUE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlHoliday findByHoliday_Value_First(String holiday_value,
        OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        List<PmlHoliday> list = findByHoliday_Value(holiday_value, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("holiday_value=" + holiday_value);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHolidayException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday findByHoliday_Value_Last(String holiday_value,
        OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        int count = countByHoliday_Value(holiday_value);

        List<PmlHoliday> list = findByHoliday_Value(holiday_value, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("holiday_value=" + holiday_value);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHolidayException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday[] findByHoliday_Value_PrevAndNext(long holidayId,
        String holiday_value, OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        PmlHoliday pmlHoliday = findByPrimaryKey(holidayId);

        int count = countByHoliday_Value(holiday_value);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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
        Object[] finderArgs = new Object[] { from_date };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FROM_DATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FROM_DATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlHoliday> findByFrom_Date(Date from_date, int start, int end)
        throws SystemException {
        return findByFrom_Date(from_date, start, end, null);
    }

    public List<PmlHoliday> findByFrom_Date(Date from_date, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                from_date,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FROM_DATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                list = (List<PmlHoliday>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FROM_DATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlHoliday findByFrom_Date_First(Date from_date,
        OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        List<PmlHoliday> list = findByFrom_Date(from_date, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("from_date=" + from_date);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHolidayException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday findByFrom_Date_Last(Date from_date, OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        int count = countByFrom_Date(from_date);

        List<PmlHoliday> list = findByFrom_Date(from_date, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("from_date=" + from_date);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHolidayException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday[] findByFrom_Date_PrevAndNext(long holidayId,
        Date from_date, OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        PmlHoliday pmlHoliday = findByPrimaryKey(holidayId);

        int count = countByFrom_Date(from_date);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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
        Object[] finderArgs = new Object[] { to_date };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TO_DATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TO_DATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlHoliday> findByTo_Date(Date to_date, int start, int end)
        throws SystemException {
        return findByTo_Date(to_date, start, end, null);
    }

    public List<PmlHoliday> findByTo_Date(Date to_date, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                to_date,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_TO_DATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                list = (List<PmlHoliday>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_TO_DATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlHoliday findByTo_Date_First(Date to_date, OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        List<PmlHoliday> list = findByTo_Date(to_date, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("to_date=" + to_date);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHolidayException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday findByTo_Date_Last(Date to_date, OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        int count = countByTo_Date(to_date);

        List<PmlHoliday> list = findByTo_Date(to_date, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("to_date=" + to_date);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHolidayException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday[] findByTo_Date_PrevAndNext(long holidayId, Date to_date,
        OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        PmlHoliday pmlHoliday = findByPrimaryKey(holidayId);

        int count = countByTo_Date(to_date);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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
        Object[] finderArgs = new Object[] { from_date, to_date };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FROMDATE_TODATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FROMDATE_TODATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlHoliday> findByFromDate_ToDate(Date from_date, Date to_date,
        int start, int end) throws SystemException {
        return findByFromDate_ToDate(from_date, to_date, start, end, null);
    }

    public List<PmlHoliday> findByFromDate_ToDate(Date from_date, Date to_date,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                from_date,
                
                to_date,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FROMDATE_TODATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                list = (List<PmlHoliday>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FROMDATE_TODATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlHoliday findByFromDate_ToDate_First(Date from_date, Date to_date,
        OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        List<PmlHoliday> list = findByFromDate_ToDate(from_date, to_date, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("from_date=" + from_date);

            msg.append(", ");
            msg.append("to_date=" + to_date);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHolidayException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday findByFromDate_ToDate_Last(Date from_date, Date to_date,
        OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        int count = countByFromDate_ToDate(from_date, to_date);

        List<PmlHoliday> list = findByFromDate_ToDate(from_date, to_date,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("from_date=" + from_date);

            msg.append(", ");
            msg.append("to_date=" + to_date);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHolidayException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday[] findByFromDate_ToDate_PrevAndNext(long holidayId,
        Date from_date, Date to_date, OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        PmlHoliday pmlHoliday = findByPrimaryKey(holidayId);

        int count = countByFromDate_ToDate(from_date, to_date);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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
        Object[] finderArgs = new Object[] { holiday_type, holiday_value };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_HOLIDAYTYPE_HOLIDAYVALUE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_HOLIDAYTYPE_HOLIDAYVALUE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] {
                holiday_type,
                
                holiday_value,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_HOLIDAYTYPE_HOLIDAYVALUE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                list = (List<PmlHoliday>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_HOLIDAYTYPE_HOLIDAYVALUE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlHoliday findByHolidayType_HolidayValue_First(
        String holiday_type, String holiday_value, OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        List<PmlHoliday> list = findByHolidayType_HolidayValue(holiday_type,
                holiday_value, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("holiday_type=" + holiday_type);

            msg.append(", ");
            msg.append("holiday_value=" + holiday_value);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHolidayException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday findByHolidayType_HolidayValue_Last(String holiday_type,
        String holiday_value, OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        int count = countByHolidayType_HolidayValue(holiday_type, holiday_value);

        List<PmlHoliday> list = findByHolidayType_HolidayValue(holiday_type,
                holiday_value, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoliday exists with the key {");

            msg.append("holiday_type=" + holiday_type);

            msg.append(", ");
            msg.append("holiday_value=" + holiday_value);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHolidayException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoliday[] findByHolidayType_HolidayValue_PrevAndNext(
        long holidayId, String holiday_type, String holiday_value,
        OrderByComparator obc)
        throws NoSuchPmlHolidayException, SystemException {
        PmlHoliday pmlHoliday = findByPrimaryKey(holidayId);

        int count = countByHolidayType_HolidayValue(holiday_type, holiday_value);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlHoliday> list = (List<PmlHoliday>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("holidayid DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlHoliday>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlHoliday>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlHoliday>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] { holiday_type };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_HOLIDAY_TYPE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HOLIDAY_TYPE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByHoliday_Value(String holiday_value)
        throws SystemException {
        Object[] finderArgs = new Object[] { holiday_value };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_HOLIDAY_VALUE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HOLIDAY_VALUE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFrom_Date(Date from_date) throws SystemException {
        Object[] finderArgs = new Object[] { from_date };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FROM_DATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FROM_DATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByTo_Date(Date to_date) throws SystemException {
        Object[] finderArgs = new Object[] { to_date };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TO_DATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TO_DATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFromDate_ToDate(Date from_date, Date to_date)
        throws SystemException {
        Object[] finderArgs = new Object[] { from_date, to_date };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FROMDATE_TODATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FROMDATE_TODATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByHolidayType_HolidayValue(String holiday_type,
        String holiday_value) throws SystemException {
        Object[] finderArgs = new Object[] { holiday_type, holiday_value };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_HOLIDAYTYPE_HOLIDAYVALUE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.holidaymanagement.model.PmlHoliday WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_HOLIDAYTYPE_HOLIDAYVALUE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.nss.portlet.holidaymanagement.model.PmlHoliday");

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.portal.util.PropsUtil.get(
                        "value.object.listener.com.nss.portlet.holidaymanagement.model.PmlHoliday")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlHoliday>> listenersList = new ArrayList<ModelListener<PmlHoliday>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlHoliday>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
