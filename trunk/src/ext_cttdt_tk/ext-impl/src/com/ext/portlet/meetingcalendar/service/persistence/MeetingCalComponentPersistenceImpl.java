package com.ext.portlet.meetingcalendar.service.persistence;

import com.ext.portlet.meetingcalendar.NoSuchComponentException;
import com.ext.portlet.meetingcalendar.model.MeetingCalComponent;
import com.ext.portlet.meetingcalendar.model.impl.MeetingCalComponentImpl;
import com.ext.portlet.meetingcalendar.model.impl.MeetingCalComponentModelImpl;

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


public class MeetingCalComponentPersistenceImpl extends BasePersistenceImpl
    implements MeetingCalComponentPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = MeetingCalComponentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FETCH_BY_MCALID = new FinderPath(MeetingCalComponentModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalComponentModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_ENTITY, "fetchBymcalId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_COUNT_BY_MCALID = new FinderPath(MeetingCalComponentModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalComponentModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countBymcalId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(MeetingCalComponentModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalComponentModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MeetingCalComponentModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalComponentModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(MeetingCalComponentPersistenceImpl.class);
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

    public void cacheResult(MeetingCalComponent meetingCalComponent) {
        EntityCacheUtil.putResult(MeetingCalComponentModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalComponentImpl.class, meetingCalComponent.getPrimaryKey(),
            meetingCalComponent);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MCALID,
            new Object[] { new Long(meetingCalComponent.getMcalId()) },
            meetingCalComponent);
    }

    public void cacheResult(List<MeetingCalComponent> meetingCalComponents) {
        for (MeetingCalComponent meetingCalComponent : meetingCalComponents) {
            if (EntityCacheUtil.getResult(
                        MeetingCalComponentModelImpl.ENTITY_CACHE_ENABLED,
                        MeetingCalComponentImpl.class,
                        meetingCalComponent.getPrimaryKey(), this) == null) {
                cacheResult(meetingCalComponent);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(MeetingCalComponentImpl.class.getName());
        EntityCacheUtil.clearCache(MeetingCalComponentImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

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
        for (ModelListener<MeetingCalComponent> listener : listeners) {
            listener.onBeforeRemove(meetingCalComponent);
        }

        meetingCalComponent = removeImpl(meetingCalComponent);

        for (ModelListener<MeetingCalComponent> listener : listeners) {
            listener.onAfterRemove(meetingCalComponent);
        }

        return meetingCalComponent;
    }

    protected MeetingCalComponent removeImpl(
        MeetingCalComponent meetingCalComponent) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (meetingCalComponent.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(MeetingCalComponentImpl.class,
                        meetingCalComponent.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(meetingCalComponent);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        MeetingCalComponentModelImpl meetingCalComponentModelImpl = (MeetingCalComponentModelImpl) meetingCalComponent;

        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MCALID,
            new Object[] {
                new Long(meetingCalComponentModelImpl.getOriginalMcalId())
            });

        EntityCacheUtil.removeResult(MeetingCalComponentModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalComponentImpl.class, meetingCalComponent.getPrimaryKey());

        return meetingCalComponent;
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

        for (ModelListener<MeetingCalComponent> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(meetingCalComponent);
            } else {
                listener.onBeforeUpdate(meetingCalComponent);
            }
        }

        meetingCalComponent = updateImpl(meetingCalComponent, merge);

        for (ModelListener<MeetingCalComponent> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(meetingCalComponent);
            } else {
                listener.onAfterUpdate(meetingCalComponent);
            }
        }

        return meetingCalComponent;
    }

    public MeetingCalComponent updateImpl(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent,
        boolean merge) throws SystemException {
        boolean isNew = meetingCalComponent.isNew();

        MeetingCalComponentModelImpl meetingCalComponentModelImpl = (MeetingCalComponentModelImpl) meetingCalComponent;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, meetingCalComponent, merge);

            meetingCalComponent.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(MeetingCalComponentModelImpl.ENTITY_CACHE_ENABLED,
            MeetingCalComponentImpl.class, meetingCalComponent.getPrimaryKey(),
            meetingCalComponent);

        if (!isNew &&
                (meetingCalComponent.getMcalId() != meetingCalComponentModelImpl.getOriginalMcalId())) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_MCALID,
                new Object[] {
                    new Long(meetingCalComponentModelImpl.getOriginalMcalId())
                });
        }

        if (isNew ||
                (meetingCalComponent.getMcalId() != meetingCalComponentModelImpl.getOriginalMcalId())) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MCALID,
                new Object[] { new Long(meetingCalComponent.getMcalId()) },
                meetingCalComponent);
        }

        return meetingCalComponent;
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
        MeetingCalComponent meetingCalComponent = (MeetingCalComponent) EntityCacheUtil.getResult(MeetingCalComponentModelImpl.ENTITY_CACHE_ENABLED,
                MeetingCalComponentImpl.class, mcalId, this);

        if (meetingCalComponent == null) {
            Session session = null;

            try {
                session = openSession();

                meetingCalComponent = (MeetingCalComponent) session.get(MeetingCalComponentImpl.class,
                        new Long(mcalId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (meetingCalComponent != null) {
                    cacheResult(meetingCalComponent);
                }

                closeSession(session);
            }
        }

        return meetingCalComponent;
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
        return fetchBymcalId(mcalId, true);
    }

    public MeetingCalComponent fetchBymcalId(long mcalId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(mcalId) };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_MCALID,
                    finderArgs, this);
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

                result = list;

                MeetingCalComponent meetingCalComponent = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MCALID,
                        finderArgs, list);
                } else {
                    meetingCalComponent = list.get(0);

                    cacheResult(meetingCalComponent);

                    if ((meetingCalComponent.getMcalId() != mcalId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MCALID,
                            finderArgs, meetingCalComponent);
                    }
                }

                return meetingCalComponent;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_MCALID,
                        finderArgs, new ArrayList<MeetingCalComponent>());
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List) {
                return null;
            } else {
                return (MeetingCalComponent) result;
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
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MeetingCalComponent> list = (List<MeetingCalComponent>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
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

                if (obc == null) {
                    list = (List<MeetingCalComponent>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<MeetingCalComponent>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MeetingCalComponent>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] { new Long(mcalId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MCALID,
                finderArgs, this);

        if (count == null) {
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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MCALID,
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
                        "SELECT COUNT(*) FROM com.ext.portlet.meetingcalendar.model.MeetingCalComponent");

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
                        "value.object.listener.com.ext.portlet.meetingcalendar.model.MeetingCalComponent")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<MeetingCalComponent>> listenersList = new ArrayList<ModelListener<MeetingCalComponent>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<MeetingCalComponent>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
