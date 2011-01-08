package com.liferay.portlet.messageboards.service.persistence;

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

import com.liferay.portlet.messageboards.NoSuchDiscussionException;
import com.liferay.portlet.messageboards.model.MBDiscussion;
import com.liferay.portlet.messageboards.model.impl.MBDiscussionImpl;
import com.liferay.portlet.messageboards.model.impl.MBDiscussionModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MBDiscussionPersistenceImpl extends BasePersistenceImpl
    implements MBDiscussionPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = MBDiscussionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_CLASSNAMEID = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
            MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByClassNameId", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_CLASSNAMEID = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
            MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByClassNameId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEID = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
            MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByClassNameId", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_THREADID = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
            MBDiscussionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_ENTITY, "fetchByThreadId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_COUNT_BY_THREADID = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
            MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByThreadId", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_C_C = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
            MBDiscussionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_ENTITY, "fetchByC_C",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_COUNT_BY_C_C = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
            MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByC_C",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
            MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
            MBDiscussionModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(MBDiscussionPersistenceImpl.class);
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBCategoryPersistence.impl")
    protected com.liferay.portlet.messageboards.service.persistence.MBCategoryPersistence mbCategoryPersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBMailingListPersistence.impl")
    protected com.liferay.portlet.messageboards.service.persistence.MBMailingListPersistence mbMailingListPersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence.impl")
    protected com.liferay.portlet.messageboards.service.persistence.MBMessagePersistence mbMessagePersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBThreadPersistence.impl")
    protected com.liferay.portlet.messageboards.service.persistence.MBThreadPersistence mbThreadPersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBBanPersistence.impl")
    protected com.liferay.portlet.messageboards.service.persistence.MBBanPersistence mbBanPersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBDiscussionPersistence.impl")
    protected com.liferay.portlet.messageboards.service.persistence.MBDiscussionPersistence mbDiscussionPersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBMessageFlagPersistence.impl")
    protected com.liferay.portlet.messageboards.service.persistence.MBMessageFlagPersistence mbMessageFlagPersistence;
    @BeanReference(name = "com.liferay.portlet.messageboards.service.persistence.MBStatsUserPersistence.impl")
    protected com.liferay.portlet.messageboards.service.persistence.MBStatsUserPersistence mbStatsUserPersistence;

    public void cacheResult(MBDiscussion mbDiscussion) {
        EntityCacheUtil.putResult(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
            MBDiscussionImpl.class, mbDiscussion.getPrimaryKey(), mbDiscussion);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THREADID,
            new Object[] { new Long(mbDiscussion.getThreadId()) }, mbDiscussion);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
            new Object[] {
                new Long(mbDiscussion.getClassNameId()),
                new Long(mbDiscussion.getClassPK())
            }, mbDiscussion);
    }

    public void cacheResult(List<MBDiscussion> mbDiscussions) {
        for (MBDiscussion mbDiscussion : mbDiscussions) {
            if (EntityCacheUtil.getResult(
                        MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
                        MBDiscussionImpl.class, mbDiscussion.getPrimaryKey(),
                        this) == null) {
                cacheResult(mbDiscussion);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(MBDiscussionImpl.class.getName());
        EntityCacheUtil.clearCache(MBDiscussionImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public MBDiscussion create(long discussionId) {
        MBDiscussion mbDiscussion = new MBDiscussionImpl();

        mbDiscussion.setNew(true);
        mbDiscussion.setPrimaryKey(discussionId);

        return mbDiscussion;
    }

    public MBDiscussion remove(long discussionId)
        throws NoSuchDiscussionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            MBDiscussion mbDiscussion = (MBDiscussion) session.get(MBDiscussionImpl.class,
                    new Long(discussionId));

            if (mbDiscussion == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No MBDiscussion exists with the primary key " +
                        discussionId);
                }

                throw new NoSuchDiscussionException(
                    "No MBDiscussion exists with the primary key " +
                    discussionId);
            }

            return remove(mbDiscussion);
        } catch (NoSuchDiscussionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public MBDiscussion remove(MBDiscussion mbDiscussion)
        throws SystemException {
        for (ModelListener<MBDiscussion> listener : listeners) {
            listener.onBeforeRemove(mbDiscussion);
        }

        mbDiscussion = removeImpl(mbDiscussion);

        for (ModelListener<MBDiscussion> listener : listeners) {
            listener.onAfterRemove(mbDiscussion);
        }

        return mbDiscussion;
    }

    protected MBDiscussion removeImpl(MBDiscussion mbDiscussion)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (mbDiscussion.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(MBDiscussionImpl.class,
                        mbDiscussion.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(mbDiscussion);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        MBDiscussionModelImpl mbDiscussionModelImpl = (MBDiscussionModelImpl) mbDiscussion;

        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_THREADID,
            new Object[] { new Long(mbDiscussionModelImpl.getOriginalThreadId()) });

        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C,
            new Object[] {
                new Long(mbDiscussionModelImpl.getOriginalClassNameId()),
                new Long(mbDiscussionModelImpl.getOriginalClassPK())
            });

        EntityCacheUtil.removeResult(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
            MBDiscussionImpl.class, mbDiscussion.getPrimaryKey());

        return mbDiscussion;
    }

    /**
     * @deprecated Use <code>update(MBDiscussion mbDiscussion, boolean merge)</code>.
     */
    public MBDiscussion update(MBDiscussion mbDiscussion)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(MBDiscussion mbDiscussion) method. Use update(MBDiscussion mbDiscussion, boolean merge) instead.");
        }

        return update(mbDiscussion, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mbDiscussion the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mbDiscussion is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public MBDiscussion update(MBDiscussion mbDiscussion, boolean merge)
        throws SystemException {
        boolean isNew = mbDiscussion.isNew();

        for (ModelListener<MBDiscussion> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(mbDiscussion);
            } else {
                listener.onBeforeUpdate(mbDiscussion);
            }
        }

        mbDiscussion = updateImpl(mbDiscussion, merge);

        for (ModelListener<MBDiscussion> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(mbDiscussion);
            } else {
                listener.onAfterUpdate(mbDiscussion);
            }
        }

        return mbDiscussion;
    }

    public MBDiscussion updateImpl(
        com.liferay.portlet.messageboards.model.MBDiscussion mbDiscussion,
        boolean merge) throws SystemException {
        boolean isNew = mbDiscussion.isNew();

        MBDiscussionModelImpl mbDiscussionModelImpl = (MBDiscussionModelImpl) mbDiscussion;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, mbDiscussion, merge);

            mbDiscussion.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
            MBDiscussionImpl.class, mbDiscussion.getPrimaryKey(), mbDiscussion);

        if (!isNew &&
                (mbDiscussion.getThreadId() != mbDiscussionModelImpl.getOriginalThreadId())) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_THREADID,
                new Object[] {
                    new Long(mbDiscussionModelImpl.getOriginalThreadId())
                });
        }

        if (isNew ||
                (mbDiscussion.getThreadId() != mbDiscussionModelImpl.getOriginalThreadId())) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THREADID,
                new Object[] { new Long(mbDiscussion.getThreadId()) },
                mbDiscussion);
        }

        if (!isNew &&
                ((mbDiscussion.getClassNameId() != mbDiscussionModelImpl.getOriginalClassNameId()) ||
                (mbDiscussion.getClassPK() != mbDiscussionModelImpl.getOriginalClassPK()))) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_C,
                new Object[] {
                    new Long(mbDiscussionModelImpl.getOriginalClassNameId()),
                    new Long(mbDiscussionModelImpl.getOriginalClassPK())
                });
        }

        if (isNew ||
                ((mbDiscussion.getClassNameId() != mbDiscussionModelImpl.getOriginalClassNameId()) ||
                (mbDiscussion.getClassPK() != mbDiscussionModelImpl.getOriginalClassPK()))) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
                new Object[] {
                    new Long(mbDiscussion.getClassNameId()),
                    new Long(mbDiscussion.getClassPK())
                }, mbDiscussion);
        }

        return mbDiscussion;
    }

    public MBDiscussion findByPrimaryKey(long discussionId)
        throws NoSuchDiscussionException, SystemException {
        MBDiscussion mbDiscussion = fetchByPrimaryKey(discussionId);

        if (mbDiscussion == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No MBDiscussion exists with the primary key " +
                    discussionId);
            }

            throw new NoSuchDiscussionException(
                "No MBDiscussion exists with the primary key " + discussionId);
        }

        return mbDiscussion;
    }

    public MBDiscussion fetchByPrimaryKey(long discussionId)
        throws SystemException {
        MBDiscussion mbDiscussion = (MBDiscussion) EntityCacheUtil.getResult(MBDiscussionModelImpl.ENTITY_CACHE_ENABLED,
                MBDiscussionImpl.class, discussionId, this);

        if (mbDiscussion == null) {
            Session session = null;

            try {
                session = openSession();

                mbDiscussion = (MBDiscussion) session.get(MBDiscussionImpl.class,
                        new Long(discussionId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (mbDiscussion != null) {
                    cacheResult(mbDiscussion);
                }

                closeSession(session);
            }
        }

        return mbDiscussion;
    }

    public List<MBDiscussion> findByClassNameId(long classNameId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(classNameId) };

        List<MBDiscussion> list = (List<MBDiscussion>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CLASSNAMEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.liferay.portlet.messageboards.model.MBDiscussion WHERE ");

                query.append("classNameId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MBDiscussion>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CLASSNAMEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<MBDiscussion> findByClassNameId(long classNameId, int start,
        int end) throws SystemException {
        return findByClassNameId(classNameId, start, end, null);
    }

    public List<MBDiscussion> findByClassNameId(long classNameId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(classNameId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MBDiscussion> list = (List<MBDiscussion>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CLASSNAMEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.liferay.portlet.messageboards.model.MBDiscussion WHERE ");

                query.append("classNameId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                list = (List<MBDiscussion>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MBDiscussion>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CLASSNAMEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public MBDiscussion findByClassNameId_First(long classNameId,
        OrderByComparator obc)
        throws NoSuchDiscussionException, SystemException {
        List<MBDiscussion> list = findByClassNameId(classNameId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MBDiscussion exists with the key {");

            msg.append("classNameId=" + classNameId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDiscussionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MBDiscussion findByClassNameId_Last(long classNameId,
        OrderByComparator obc)
        throws NoSuchDiscussionException, SystemException {
        int count = countByClassNameId(classNameId);

        List<MBDiscussion> list = findByClassNameId(classNameId, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MBDiscussion exists with the key {");

            msg.append("classNameId=" + classNameId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDiscussionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MBDiscussion[] findByClassNameId_PrevAndNext(long discussionId,
        long classNameId, OrderByComparator obc)
        throws NoSuchDiscussionException, SystemException {
        MBDiscussion mbDiscussion = findByPrimaryKey(discussionId);

        int count = countByClassNameId(classNameId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.liferay.portlet.messageboards.model.MBDiscussion WHERE ");

            query.append("classNameId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(classNameId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    mbDiscussion);

            MBDiscussion[] array = new MBDiscussionImpl[3];

            array[0] = (MBDiscussion) objArray[0];
            array[1] = (MBDiscussion) objArray[1];
            array[2] = (MBDiscussion) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public MBDiscussion findByThreadId(long threadId)
        throws NoSuchDiscussionException, SystemException {
        MBDiscussion mbDiscussion = fetchByThreadId(threadId);

        if (mbDiscussion == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MBDiscussion exists with the key {");

            msg.append("threadId=" + threadId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchDiscussionException(msg.toString());
        }

        return mbDiscussion;
    }

    public MBDiscussion fetchByThreadId(long threadId)
        throws SystemException {
        return fetchByThreadId(threadId, true);
    }

    public MBDiscussion fetchByThreadId(long threadId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(threadId) };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_THREADID,
                    finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.liferay.portlet.messageboards.model.MBDiscussion WHERE ");

                query.append("threadId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(threadId);

                List<MBDiscussion> list = q.list();

                result = list;

                MBDiscussion mbDiscussion = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THREADID,
                        finderArgs, list);
                } else {
                    mbDiscussion = list.get(0);

                    cacheResult(mbDiscussion);

                    if ((mbDiscussion.getThreadId() != threadId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THREADID,
                            finderArgs, mbDiscussion);
                    }
                }

                return mbDiscussion;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_THREADID,
                        finderArgs, new ArrayList<MBDiscussion>());
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List) {
                return null;
            } else {
                return (MBDiscussion) result;
            }
        }
    }

    public MBDiscussion findByC_C(long classNameId, long classPK)
        throws NoSuchDiscussionException, SystemException {
        MBDiscussion mbDiscussion = fetchByC_C(classNameId, classPK);

        if (mbDiscussion == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MBDiscussion exists with the key {");

            msg.append("classNameId=" + classNameId);

            msg.append(", ");
            msg.append("classPK=" + classPK);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchDiscussionException(msg.toString());
        }

        return mbDiscussion;
    }

    public MBDiscussion fetchByC_C(long classNameId, long classPK)
        throws SystemException {
        return fetchByC_C(classNameId, classPK, true);
    }

    public MBDiscussion fetchByC_C(long classNameId, long classPK,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(classNameId), new Long(classPK)
            };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_C,
                    finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.liferay.portlet.messageboards.model.MBDiscussion WHERE ");

                query.append("classNameId = ?");

                query.append(" AND ");

                query.append("classPK = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                qPos.add(classPK);

                List<MBDiscussion> list = q.list();

                result = list;

                MBDiscussion mbDiscussion = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
                        finderArgs, list);
                } else {
                    mbDiscussion = list.get(0);

                    cacheResult(mbDiscussion);

                    if ((mbDiscussion.getClassNameId() != classNameId) ||
                            (mbDiscussion.getClassPK() != classPK)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
                            finderArgs, mbDiscussion);
                    }
                }

                return mbDiscussion;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_C,
                        finderArgs, new ArrayList<MBDiscussion>());
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List) {
                return null;
            } else {
                return (MBDiscussion) result;
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

    public List<MBDiscussion> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<MBDiscussion> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<MBDiscussion> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MBDiscussion> list = (List<MBDiscussion>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.liferay.portlet.messageboards.model.MBDiscussion ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<MBDiscussion>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<MBDiscussion>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MBDiscussion>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByClassNameId(long classNameId) throws SystemException {
        for (MBDiscussion mbDiscussion : findByClassNameId(classNameId)) {
            remove(mbDiscussion);
        }
    }

    public void removeByThreadId(long threadId)
        throws NoSuchDiscussionException, SystemException {
        MBDiscussion mbDiscussion = findByThreadId(threadId);

        remove(mbDiscussion);
    }

    public void removeByC_C(long classNameId, long classPK)
        throws NoSuchDiscussionException, SystemException {
        MBDiscussion mbDiscussion = findByC_C(classNameId, classPK);

        remove(mbDiscussion);
    }

    public void removeAll() throws SystemException {
        for (MBDiscussion mbDiscussion : findAll()) {
            remove(mbDiscussion);
        }
    }

    public int countByClassNameId(long classNameId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(classNameId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CLASSNAMEID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.liferay.portlet.messageboards.model.MBDiscussion WHERE ");

                query.append("classNameId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLASSNAMEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByThreadId(long threadId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(threadId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_THREADID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.liferay.portlet.messageboards.model.MBDiscussion WHERE ");

                query.append("threadId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(threadId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_THREADID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByC_C(long classNameId, long classPK)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(classNameId), new Long(classPK)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_C,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.liferay.portlet.messageboards.model.MBDiscussion WHERE ");

                query.append("classNameId = ?");

                query.append(" AND ");

                query.append("classPK = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(classNameId);

                qPos.add(classPK);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C, finderArgs,
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
                        "SELECT COUNT(*) FROM com.liferay.portlet.messageboards.model.MBDiscussion");

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
                        "value.object.listener.com.liferay.portlet.messageboards.model.MBDiscussion")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<MBDiscussion>> listenersList = new ArrayList<ModelListener<MBDiscussion>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<MBDiscussion>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}