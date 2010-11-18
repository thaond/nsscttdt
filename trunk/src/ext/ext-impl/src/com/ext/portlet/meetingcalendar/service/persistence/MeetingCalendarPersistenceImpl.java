package com.ext.portlet.meetingcalendar.service.persistence;

import com.ext.portlet.meetingcalendar.NoSuchendarException;
import com.ext.portlet.meetingcalendar.model.MeetingCalendar;
import com.ext.portlet.meetingcalendar.model.impl.MeetingCalendarImpl;
import com.ext.portlet.meetingcalendar.model.impl.MeetingCalendarModelImpl;

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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MeetingCalendarPersistenceImpl extends BasePersistenceImpl
    implements MeetingCalendarPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = MeetingCalendarImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_UUID = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByUuid",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_UUID = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByUuid",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByUuid",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_GROUPID = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByGroupId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_GROUPID = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByGroupId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByGroupId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_G_STATE = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByG_State",
            new String[] { Long.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_G_STATE = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByG_State",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_G_STATE = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByG_State",
            new String[] { Long.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(MeetingCalendarPersistenceImpl.class);
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingCalendarPersistence.impl")
    protected com.ext.portlet.meetingcalendar.service.persistence.MeetingCalendarPersistence meetingCalendarPersistence;
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingCalComponentPersistence.impl")
    protected com.ext.portlet.meetingcalendar.service.persistence.MeetingCalComponentPersistence meetingCalComponentPersistence;
    @BeanReference(name = "com.ext.portlet.meetingcalendar.service.persistence.MeetingDetailWeekPersistence.impl")
    protected com.ext.portlet.meetingcalendar.service.persistence.MeetingDetailWeekPersistence meetingDetailWeekPersistence;
    @BeanReference(name = "com.liferay.portal.service.persistence.CompanyPersistence.impl")
    protected com.liferay.portal.service.persistence.CompanyPersistence companyPersistence;
    @BeanReference(name = "com.liferay.portal.service.persistence.PortletPreferencesPersistence.impl")
    protected com.liferay.portal.service.persistence.PortletPreferencesPersistence portletPreferencesPersistence;
    @BeanReference(name = "com.liferay.portal.service.persistence.ResourcePersistence.impl")
    protected com.liferay.portal.service.persistence.ResourcePersistence resourcePersistence;
    @BeanReference(name = "com.liferay.portlet.social.service.persistence.SocialActivityPersistence.impl")
    protected com.liferay.portlet.social.service.persistence.SocialActivityPersistence socialActivityPersistence;
    @BeanReference(name = "com.liferay.portal.service.persistence.UserPersistence.impl")
    protected com.liferay.portal.service.persistence.UserPersistence userPersistence;
    @BeanReference(name = "com.liferay.portlet.calendar.service.persistence.CalEventPersistence.impl")
    protected com.liferay.portlet.calendar.service.persistence.CalEventPersistence calEventPersistence;

    public void cacheResult(MeetingCalendar meetingCalendar) {
        EntityCacheUtil.putResult(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarImpl.class, meetingCalendar.getPrimaryKey(),
            meetingCalendar);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] {
                meetingCalendar.getUuid(),
                new Long(meetingCalendar.getGroupId())
            }, meetingCalendar);
    }

    public void cacheResult(List<MeetingCalendar> meetingCalendars) {
        for (MeetingCalendar meetingCalendar : meetingCalendars) {
            if (EntityCacheUtil.getResult(
                        MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
                        MeetingCalendarImpl.class,
                        meetingCalendar.getPrimaryKey(), this) == null) {
                cacheResult(meetingCalendar);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(MeetingCalendarImpl.class.getName());
        EntityCacheUtil.clearCache(MeetingCalendarImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

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
        for (ModelListener<MeetingCalendar> listener : listeners) {
            listener.onBeforeRemove(meetingCalendar);
        }

        meetingCalendar = removeImpl(meetingCalendar);

        for (ModelListener<MeetingCalendar> listener : listeners) {
            listener.onAfterRemove(meetingCalendar);
        }

        return meetingCalendar;
    }

    protected MeetingCalendar removeImpl(MeetingCalendar meetingCalendar)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (meetingCalendar.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(MeetingCalendarImpl.class,
                        meetingCalendar.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(meetingCalendar);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        MeetingCalendarModelImpl meetingCalendarModelImpl = (MeetingCalendarModelImpl) meetingCalendar;

        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] {
                meetingCalendarModelImpl.getOriginalUuid(),
                new Long(meetingCalendarModelImpl.getOriginalGroupId())
            });

        EntityCacheUtil.removeResult(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarImpl.class, meetingCalendar.getPrimaryKey());

        return meetingCalendar;
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

        for (ModelListener<MeetingCalendar> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(meetingCalendar);
            } else {
                listener.onBeforeUpdate(meetingCalendar);
            }
        }

        meetingCalendar = updateImpl(meetingCalendar, merge);

        for (ModelListener<MeetingCalendar> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(meetingCalendar);
            } else {
                listener.onAfterUpdate(meetingCalendar);
            }
        }

        return meetingCalendar;
    }

    public MeetingCalendar updateImpl(
        com.ext.portlet.meetingcalendar.model.MeetingCalendar meetingCalendar,
        boolean merge) throws SystemException {
        boolean isNew = meetingCalendar.isNew();

        MeetingCalendarModelImpl meetingCalendarModelImpl = (MeetingCalendarModelImpl) meetingCalendar;

        if (Validator.isNull(meetingCalendar.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            meetingCalendar.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, meetingCalendar, merge);

            meetingCalendar.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalendarImpl.class, meetingCalendar.getPrimaryKey(),
            meetingCalendar);

        if (!isNew &&
                (!Validator.equals(meetingCalendar.getUuid(),
                    meetingCalendarModelImpl.getOriginalUuid()) ||
                (meetingCalendar.getGroupId() != meetingCalendarModelImpl.getOriginalGroupId()))) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                new Object[] {
                    meetingCalendarModelImpl.getOriginalUuid(),
                    new Long(meetingCalendarModelImpl.getOriginalGroupId())
                });
        }

        if (isNew ||
                (!Validator.equals(meetingCalendar.getUuid(),
                    meetingCalendarModelImpl.getOriginalUuid()) ||
                (meetingCalendar.getGroupId() != meetingCalendarModelImpl.getOriginalGroupId()))) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                new Object[] {
                    meetingCalendar.getUuid(),
                    new Long(meetingCalendar.getGroupId())
                }, meetingCalendar);
        }

        return meetingCalendar;
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
        MeetingCalendar meetingCalendar = (MeetingCalendar) EntityCacheUtil.getResult(MeetingCalendarModelImpl.ENTITY_CACHE_ENABLED,
                MeetingCalendarImpl.class, mcalId, this);

        if (meetingCalendar == null) {
            Session session = null;

            try {
                session = openSession();

                meetingCalendar = (MeetingCalendar) session.get(MeetingCalendarImpl.class,
                        new Long(mcalId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (meetingCalendar != null) {
                    cacheResult(meetingCalendar);
                }

                closeSession(session);
            }
        }

        return meetingCalendar;
    }

    public List<MeetingCalendar> findByUuid(String uuid)
        throws SystemException {
        Object[] finderArgs = new Object[] { uuid };

        List<MeetingCalendar> list = (List<MeetingCalendar>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_UUID,
                finderArgs, this);

        if (list == null) {
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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MeetingCalendar>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_UUID, finderArgs,
                    list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<MeetingCalendar> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
    }

    public List<MeetingCalendar> findByUuid(String uuid, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                uuid,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MeetingCalendar> list = (List<MeetingCalendar>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_UUID,
                finderArgs, this);

        if (list == null) {
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

                list = (List<MeetingCalendar>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MeetingCalendar>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_UUID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public MeetingCalendar findByUuid_First(String uuid, OrderByComparator obc)
        throws NoSuchendarException, SystemException {
        List<MeetingCalendar> list = findByUuid(uuid, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
        return fetchByUUID_G(uuid, groupId, true);
    }

    public MeetingCalendar fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, new Long(groupId) };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
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

                result = list;

                MeetingCalendar meetingCalendar = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    meetingCalendar = list.get(0);

                    cacheResult(meetingCalendar);

                    if ((meetingCalendar.getUuid() == null) ||
                            !meetingCalendar.getUuid().equals(uuid) ||
                            (meetingCalendar.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, meetingCalendar);
                    }
                }

                return meetingCalendar;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, new ArrayList<MeetingCalendar>());
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List) {
                return null;
            } else {
                return (MeetingCalendar) result;
            }
        }
    }

    public List<MeetingCalendar> findByGroupId(long groupId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(groupId) };

        List<MeetingCalendar> list = (List<MeetingCalendar>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_GROUPID,
                finderArgs, this);

        if (list == null) {
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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MeetingCalendar>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_GROUPID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<MeetingCalendar> findByGroupId(long groupId, int start, int end)
        throws SystemException {
        return findByGroupId(groupId, start, end, null);
    }

    public List<MeetingCalendar> findByGroupId(long groupId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(groupId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MeetingCalendar> list = (List<MeetingCalendar>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_GROUPID,
                finderArgs, this);

        if (list == null) {
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

                list = (List<MeetingCalendar>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MeetingCalendar>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_GROUPID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public MeetingCalendar findByGroupId_First(long groupId,
        OrderByComparator obc) throws NoSuchendarException, SystemException {
        List<MeetingCalendar> list = findByGroupId(groupId, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
        Object[] finderArgs = new Object[] { new Long(groupId), new Integer(state) };

        List<MeetingCalendar> list = (List<MeetingCalendar>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_G_STATE,
                finderArgs, this);

        if (list == null) {
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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MeetingCalendar>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_G_STATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<MeetingCalendar> findByG_State(long groupId, int state,
        int start, int end) throws SystemException {
        return findByG_State(groupId, state, start, end, null);
    }

    public List<MeetingCalendar> findByG_State(long groupId, int state,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(groupId), new Integer(state),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MeetingCalendar> list = (List<MeetingCalendar>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_G_STATE,
                finderArgs, this);

        if (list == null) {
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

                list = (List<MeetingCalendar>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MeetingCalendar>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_G_STATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public MeetingCalendar findByG_State_First(long groupId, int state,
        OrderByComparator obc) throws NoSuchendarException, SystemException {
        List<MeetingCalendar> list = findByG_State(groupId, state, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MeetingCalendar> list = (List<MeetingCalendar>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
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

                if (obc == null) {
                    list = (List<MeetingCalendar>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<MeetingCalendar>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MeetingCalendar>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
                finderArgs, this);

        if (count == null) {
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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        Object[] finderArgs = new Object[] { uuid, new Long(groupId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
                finderArgs, this);

        if (count == null) {
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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByGroupId(long groupId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(groupId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_GROUPID,
                finderArgs, this);

        if (count == null) {
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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GROUPID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByG_State(long groupId, int state)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(groupId), new Integer(state) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_G_STATE,
                finderArgs, this);

        if (count == null) {
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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_G_STATE,
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
                        "SELECT COUNT(*) FROM com.ext.portlet.meetingcalendar.model.MeetingCalendar");

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
                        "value.object.listener.com.ext.portlet.meetingcalendar.model.MeetingCalendar")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<MeetingCalendar>> listenersList = new ArrayList<ModelListener<MeetingCalendar>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<MeetingCalendar>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
