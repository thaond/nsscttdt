package com.ext.portlet.meetingcalendar.service.persistence;

import com.ext.portlet.meetingcalendar.NoSuchMeetingDetailWeekException;
import com.ext.portlet.meetingcalendar.model.MeetingDetailWeek;
import com.ext.portlet.meetingcalendar.model.impl.MeetingDetailWeekImpl;
import com.ext.portlet.meetingcalendar.model.impl.MeetingDetailWeekModelImpl;

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
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MeetingDetailWeekPersistenceImpl extends BasePersistenceImpl
    implements MeetingDetailWeekPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = MeetingDetailWeekImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FETCH_BY_MDWEEKID = new FinderPath(MeetingDetailWeekModelImpl.ENTITY_CACHE_ENABLED,
            MeetingDetailWeekModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_ENTITY, "fetchBymdweekId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_COUNT_BY_MDWEEKID = new FinderPath(MeetingDetailWeekModelImpl.ENTITY_CACHE_ENABLED,
            MeetingDetailWeekModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countBymdweekId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_W_Y = new FinderPath(MeetingDetailWeekModelImpl.ENTITY_CACHE_ENABLED,
            MeetingDetailWeekModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_ENTITY, "fetchByW_Y",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_COUNT_BY_W_Y = new FinderPath(MeetingDetailWeekModelImpl.ENTITY_CACHE_ENABLED,
            MeetingDetailWeekModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByW_Y",
            new String[] { Integer.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(MeetingDetailWeekModelImpl.ENTITY_CACHE_ENABLED,
            MeetingDetailWeekModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MeetingDetailWeekModelImpl.ENTITY_CACHE_ENABLED,
            MeetingDetailWeekModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(MeetingDetailWeekPersistenceImpl.class);
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
    @BeanReference(name = "com.liferay.portal.service.persistence.OrganizationPersistence.impl")
    protected com.liferay.portal.service.persistence.OrganizationPersistence organizationPersistence;

    public void cacheResult(MeetingDetailWeek meetingDetailWeek) {
        EntityCacheUtil.putResult(MeetingDetailWeekModelImpl.ENTITY_CACHE_ENABLED,
            MeetingDetailWeekImpl.class, meetingDetailWeek.getPrimaryKey(),
            meetingDetailWeek);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MDWEEKID,
            new Object[] { new Long(meetingDetailWeek.getMdweekId()) },
            meetingDetailWeek);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_W_Y,
            new Object[] {
                new Integer(meetingDetailWeek.getWeek()),
                new Integer(meetingDetailWeek.getYear())
            }, meetingDetailWeek);
    }

    public void cacheResult(List<MeetingDetailWeek> meetingDetailWeeks) {
        for (MeetingDetailWeek meetingDetailWeek : meetingDetailWeeks) {
            if (EntityCacheUtil.getResult(
                        MeetingDetailWeekModelImpl.ENTITY_CACHE_ENABLED,
                        MeetingDetailWeekImpl.class,
                        meetingDetailWeek.getPrimaryKey(), this) == null) {
                cacheResult(meetingDetailWeek);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(MeetingDetailWeekImpl.class.getName());
        EntityCacheUtil.clearCache(MeetingDetailWeekImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

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
        for (ModelListener<MeetingDetailWeek> listener : listeners) {
            listener.onBeforeRemove(meetingDetailWeek);
        }

        meetingDetailWeek = removeImpl(meetingDetailWeek);

        for (ModelListener<MeetingDetailWeek> listener : listeners) {
            listener.onAfterRemove(meetingDetailWeek);
        }

        return meetingDetailWeek;
    }

    protected MeetingDetailWeek removeImpl(MeetingDetailWeek meetingDetailWeek)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (meetingDetailWeek.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(MeetingDetailWeekImpl.class,
                        meetingDetailWeek.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(meetingDetailWeek);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        MeetingDetailWeekModelImpl meetingDetailWeekModelImpl = (MeetingDetailWeekModelImpl) meetingDetailWeek;

        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MDWEEKID,
            new Object[] {
                new Long(meetingDetailWeekModelImpl.getOriginalMdweekId())
            });

        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_W_Y,
            new Object[] {
                new Integer(meetingDetailWeekModelImpl.getOriginalWeek()),
                new Integer(meetingDetailWeekModelImpl.getOriginalYear())
            });

        EntityCacheUtil.removeResult(MeetingDetailWeekModelImpl.ENTITY_CACHE_ENABLED,
            MeetingDetailWeekImpl.class, meetingDetailWeek.getPrimaryKey());

        return meetingDetailWeek;
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

        for (ModelListener<MeetingDetailWeek> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(meetingDetailWeek);
            } else {
                listener.onBeforeUpdate(meetingDetailWeek);
            }
        }

        meetingDetailWeek = updateImpl(meetingDetailWeek, merge);

        for (ModelListener<MeetingDetailWeek> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(meetingDetailWeek);
            } else {
                listener.onAfterUpdate(meetingDetailWeek);
            }
        }

        return meetingDetailWeek;
    }

    public MeetingDetailWeek updateImpl(
        com.ext.portlet.meetingcalendar.model.MeetingDetailWeek meetingDetailWeek,
        boolean merge) throws SystemException {
        boolean isNew = meetingDetailWeek.isNew();

        MeetingDetailWeekModelImpl meetingDetailWeekModelImpl = (MeetingDetailWeekModelImpl) meetingDetailWeek;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, meetingDetailWeek, merge);

            meetingDetailWeek.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(MeetingDetailWeekModelImpl.ENTITY_CACHE_ENABLED,
            MeetingDetailWeekImpl.class, meetingDetailWeek.getPrimaryKey(),
            meetingDetailWeek);

        if (!isNew &&
                (meetingDetailWeek.getMdweekId() != meetingDetailWeekModelImpl.getOriginalMdweekId())) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MDWEEKID,
                new Object[] {
                    new Long(meetingDetailWeekModelImpl.getOriginalMdweekId())
                });
        }

        if (isNew ||
                (meetingDetailWeek.getMdweekId() != meetingDetailWeekModelImpl.getOriginalMdweekId())) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MDWEEKID,
                new Object[] { new Long(meetingDetailWeek.getMdweekId()) },
                meetingDetailWeek);
        }

        if (!isNew &&
                ((meetingDetailWeek.getWeek() != meetingDetailWeekModelImpl.getOriginalWeek()) ||
                (meetingDetailWeek.getYear() != meetingDetailWeekModelImpl.getOriginalYear()))) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_W_Y,
                new Object[] {
                    new Integer(meetingDetailWeekModelImpl.getOriginalWeek()),
                    new Integer(meetingDetailWeekModelImpl.getOriginalYear())
                });
        }

        if (isNew ||
                ((meetingDetailWeek.getWeek() != meetingDetailWeekModelImpl.getOriginalWeek()) ||
                (meetingDetailWeek.getYear() != meetingDetailWeekModelImpl.getOriginalYear()))) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_W_Y,
                new Object[] {
                    new Integer(meetingDetailWeek.getWeek()),
                    new Integer(meetingDetailWeek.getYear())
                }, meetingDetailWeek);
        }

        return meetingDetailWeek;
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
        MeetingDetailWeek meetingDetailWeek = (MeetingDetailWeek) EntityCacheUtil.getResult(MeetingDetailWeekModelImpl.ENTITY_CACHE_ENABLED,
                MeetingDetailWeekImpl.class, mdweekId, this);

        if (meetingDetailWeek == null) {
            Session session = null;

            try {
                session = openSession();

                meetingDetailWeek = (MeetingDetailWeek) session.get(MeetingDetailWeekImpl.class,
                        new Long(mdweekId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (meetingDetailWeek != null) {
                    cacheResult(meetingDetailWeek);
                }

                closeSession(session);
            }
        }

        return meetingDetailWeek;
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
        return fetchBymdweekId(mdweekId, true);
    }

    public MeetingDetailWeek fetchBymdweekId(long mdweekId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(mdweekId) };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MDWEEKID,
                    finderArgs, this);
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

                result = list;

                MeetingDetailWeek meetingDetailWeek = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MDWEEKID,
                        finderArgs, list);
                } else {
                    meetingDetailWeek = list.get(0);

                    cacheResult(meetingDetailWeek);

                    if ((meetingDetailWeek.getMdweekId() != mdweekId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MDWEEKID,
                            finderArgs, meetingDetailWeek);
                    }
                }

                return meetingDetailWeek;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MDWEEKID,
                        finderArgs, new ArrayList<MeetingDetailWeek>());
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List) {
                return null;
            } else {
                return (MeetingDetailWeek) result;
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
        return fetchByW_Y(week, year, true);
    }

    public MeetingDetailWeek fetchByW_Y(int week, int year,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(week), new Integer(year) };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_W_Y,
                    finderArgs, this);
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

                result = list;

                MeetingDetailWeek meetingDetailWeek = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_W_Y,
                        finderArgs, list);
                } else {
                    meetingDetailWeek = list.get(0);

                    cacheResult(meetingDetailWeek);

                    if ((meetingDetailWeek.getWeek() != week) ||
                            (meetingDetailWeek.getYear() != year)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_W_Y,
                            finderArgs, meetingDetailWeek);
                    }
                }

                return meetingDetailWeek;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_W_Y,
                        finderArgs, new ArrayList<MeetingDetailWeek>());
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List) {
                return null;
            } else {
                return (MeetingDetailWeek) result;
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
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MeetingDetailWeek> list = (List<MeetingDetailWeek>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
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

                if (obc == null) {
                    list = (List<MeetingDetailWeek>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<MeetingDetailWeek>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MeetingDetailWeek>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] { new Long(mdweekId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MDWEEKID,
                finderArgs, this);

        if (count == null) {
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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MDWEEKID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByW_Y(int week, int year) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(week), new Integer(year) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_W_Y,
                finderArgs, this);

        if (count == null) {
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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_W_Y, finderArgs,
                    count);

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
                        "SELECT COUNT(*) FROM com.ext.portlet.meetingcalendar.model.MeetingDetailWeek");

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
                        "value.object.listener.com.ext.portlet.meetingcalendar.model.MeetingDetailWeek")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<MeetingDetailWeek>> listenersList = new ArrayList<ModelListener<MeetingDetailWeek>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<MeetingDetailWeek>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
