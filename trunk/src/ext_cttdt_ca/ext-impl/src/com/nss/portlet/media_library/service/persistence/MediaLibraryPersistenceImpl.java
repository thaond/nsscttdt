package com.nss.portlet.media_library.service.persistence;

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

import com.nss.portlet.media_library.NoSuchMediaLibraryException;
import com.nss.portlet.media_library.model.MediaLibrary;
import com.nss.portlet.media_library.model.impl.MediaLibraryImpl;
import com.nss.portlet.media_library.model.impl.MediaLibraryModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MediaLibraryPersistenceImpl extends BasePersistenceImpl
    implements MediaLibraryPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = MediaLibraryImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
            MediaLibraryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive", new String[] { Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
            MediaLibraryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive",
            new String[] {
                Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
            MediaLibraryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByActive", new String[] { Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MAMEDIACHUDE_ACTIVE = new FinderPath(MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
            MediaLibraryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaMediaChuDe_Active",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MAMEDIACHUDE_ACTIVE = new FinderPath(MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
            MediaLibraryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByMaMediaChuDe_Active",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MAMEDIACHUDE_ACTIVE = new FinderPath(MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
            MediaLibraryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByMaMediaChuDe_Active",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
            MediaLibraryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
            MediaLibraryModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(MediaLibraryPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.media_library.service.persistence.MediaLibraryPersistence.impl")
    protected com.nss.portlet.media_library.service.persistence.MediaLibraryPersistence mediaLibraryPersistence;

    public void cacheResult(MediaLibrary mediaLibrary) {
        EntityCacheUtil.putResult(MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
            MediaLibraryImpl.class, mediaLibrary.getPrimaryKey(), mediaLibrary);
    }

    public void cacheResult(List<MediaLibrary> mediaLibraries) {
        for (MediaLibrary mediaLibrary : mediaLibraries) {
            if (EntityCacheUtil.getResult(
                        MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
                        MediaLibraryImpl.class, mediaLibrary.getPrimaryKey(),
                        this) == null) {
                cacheResult(mediaLibrary);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(MediaLibraryImpl.class.getName());
        EntityCacheUtil.clearCache(MediaLibraryImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public MediaLibrary create(long maMediaLibrary) {
        MediaLibrary mediaLibrary = new MediaLibraryImpl();

        mediaLibrary.setNew(true);
        mediaLibrary.setPrimaryKey(maMediaLibrary);

        return mediaLibrary;
    }

    public MediaLibrary remove(long maMediaLibrary)
        throws NoSuchMediaLibraryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            MediaLibrary mediaLibrary = (MediaLibrary) session.get(MediaLibraryImpl.class,
                    new Long(maMediaLibrary));

            if (mediaLibrary == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No MediaLibrary exists with the primary key " +
                        maMediaLibrary);
                }

                throw new NoSuchMediaLibraryException(
                    "No MediaLibrary exists with the primary key " +
                    maMediaLibrary);
            }

            return remove(mediaLibrary);
        } catch (NoSuchMediaLibraryException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public MediaLibrary remove(MediaLibrary mediaLibrary)
        throws SystemException {
        for (ModelListener<MediaLibrary> listener : listeners) {
            listener.onBeforeRemove(mediaLibrary);
        }

        mediaLibrary = removeImpl(mediaLibrary);

        for (ModelListener<MediaLibrary> listener : listeners) {
            listener.onAfterRemove(mediaLibrary);
        }

        return mediaLibrary;
    }

    protected MediaLibrary removeImpl(MediaLibrary mediaLibrary)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (mediaLibrary.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(MediaLibraryImpl.class,
                        mediaLibrary.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(mediaLibrary);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
            MediaLibraryImpl.class, mediaLibrary.getPrimaryKey());

        return mediaLibrary;
    }

    /**
     * @deprecated Use <code>update(MediaLibrary mediaLibrary, boolean merge)</code>.
     */
    public MediaLibrary update(MediaLibrary mediaLibrary)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(MediaLibrary mediaLibrary) method. Use update(MediaLibrary mediaLibrary, boolean merge) instead.");
        }

        return update(mediaLibrary, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mediaLibrary the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mediaLibrary is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public MediaLibrary update(MediaLibrary mediaLibrary, boolean merge)
        throws SystemException {
        boolean isNew = mediaLibrary.isNew();

        for (ModelListener<MediaLibrary> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(mediaLibrary);
            } else {
                listener.onBeforeUpdate(mediaLibrary);
            }
        }

        mediaLibrary = updateImpl(mediaLibrary, merge);

        for (ModelListener<MediaLibrary> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(mediaLibrary);
            } else {
                listener.onAfterUpdate(mediaLibrary);
            }
        }

        return mediaLibrary;
    }

    public MediaLibrary updateImpl(
        com.nss.portlet.media_library.model.MediaLibrary mediaLibrary,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, mediaLibrary, merge);

            mediaLibrary.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
            MediaLibraryImpl.class, mediaLibrary.getPrimaryKey(), mediaLibrary);

        return mediaLibrary;
    }

    public MediaLibrary findByPrimaryKey(long maMediaLibrary)
        throws NoSuchMediaLibraryException, SystemException {
        MediaLibrary mediaLibrary = fetchByPrimaryKey(maMediaLibrary);

        if (mediaLibrary == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No MediaLibrary exists with the primary key " +
                    maMediaLibrary);
            }

            throw new NoSuchMediaLibraryException(
                "No MediaLibrary exists with the primary key " +
                maMediaLibrary);
        }

        return mediaLibrary;
    }

    public MediaLibrary fetchByPrimaryKey(long maMediaLibrary)
        throws SystemException {
        MediaLibrary mediaLibrary = (MediaLibrary) EntityCacheUtil.getResult(MediaLibraryModelImpl.ENTITY_CACHE_ENABLED,
                MediaLibraryImpl.class, maMediaLibrary, this);

        if (mediaLibrary == null) {
            Session session = null;

            try {
                session = openSession();

                mediaLibrary = (MediaLibrary) session.get(MediaLibraryImpl.class,
                        new Long(maMediaLibrary));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (mediaLibrary != null) {
                    cacheResult(mediaLibrary);
                }

                closeSession(session);
            }
        }

        return mediaLibrary;
    }

    public List<MediaLibrary> findByActive(boolean active)
        throws SystemException {
        Object[] finderArgs = new Object[] { Boolean.valueOf(active) };

        List<MediaLibrary> list = (List<MediaLibrary>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.media_library.model.MediaLibrary WHERE ");

                query.append("active_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("maMediaChuDe ASC, ");
                query.append("tieuDeMediaLibrary ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MediaLibrary>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<MediaLibrary> findByActive(boolean active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<MediaLibrary> findByActive(boolean active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                Boolean.valueOf(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MediaLibrary> list = (List<MediaLibrary>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.media_library.model.MediaLibrary WHERE ");

                query.append("active_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("maMediaChuDe ASC, ");
                    query.append("tieuDeMediaLibrary ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<MediaLibrary>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MediaLibrary>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public MediaLibrary findByActive_First(boolean active, OrderByComparator obc)
        throws NoSuchMediaLibraryException, SystemException {
        List<MediaLibrary> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MediaLibrary exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMediaLibraryException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MediaLibrary findByActive_Last(boolean active, OrderByComparator obc)
        throws NoSuchMediaLibraryException, SystemException {
        int count = countByActive(active);

        List<MediaLibrary> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MediaLibrary exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMediaLibraryException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MediaLibrary[] findByActive_PrevAndNext(long maMediaLibrary,
        boolean active, OrderByComparator obc)
        throws NoSuchMediaLibraryException, SystemException {
        MediaLibrary mediaLibrary = findByPrimaryKey(maMediaLibrary);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.media_library.model.MediaLibrary WHERE ");

            query.append("active_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("maMediaChuDe ASC, ");
                query.append("tieuDeMediaLibrary ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    mediaLibrary);

            MediaLibrary[] array = new MediaLibraryImpl[3];

            array[0] = (MediaLibrary) objArray[0];
            array[1] = (MediaLibrary) objArray[1];
            array[2] = (MediaLibrary) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<MediaLibrary> findByMaMediaChuDe_Active(long maMediaChuDe,
        boolean active) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maMediaChuDe), Boolean.valueOf(active)
            };

        List<MediaLibrary> list = (List<MediaLibrary>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MAMEDIACHUDE_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.media_library.model.MediaLibrary WHERE ");

                query.append("maMediaChuDe = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("maMediaChuDe ASC, ");
                query.append("tieuDeMediaLibrary ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maMediaChuDe);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MediaLibrary>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MAMEDIACHUDE_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<MediaLibrary> findByMaMediaChuDe_Active(long maMediaChuDe,
        boolean active, int start, int end) throws SystemException {
        return findByMaMediaChuDe_Active(maMediaChuDe, active, start, end, null);
    }

    public List<MediaLibrary> findByMaMediaChuDe_Active(long maMediaChuDe,
        boolean active, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maMediaChuDe), Boolean.valueOf(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MediaLibrary> list = (List<MediaLibrary>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MAMEDIACHUDE_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.media_library.model.MediaLibrary WHERE ");

                query.append("maMediaChuDe = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("maMediaChuDe ASC, ");
                    query.append("tieuDeMediaLibrary ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maMediaChuDe);

                qPos.add(active);

                list = (List<MediaLibrary>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MediaLibrary>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MAMEDIACHUDE_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public MediaLibrary findByMaMediaChuDe_Active_First(long maMediaChuDe,
        boolean active, OrderByComparator obc)
        throws NoSuchMediaLibraryException, SystemException {
        List<MediaLibrary> list = findByMaMediaChuDe_Active(maMediaChuDe,
                active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MediaLibrary exists with the key {");

            msg.append("maMediaChuDe=" + maMediaChuDe);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMediaLibraryException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MediaLibrary findByMaMediaChuDe_Active_Last(long maMediaChuDe,
        boolean active, OrderByComparator obc)
        throws NoSuchMediaLibraryException, SystemException {
        int count = countByMaMediaChuDe_Active(maMediaChuDe, active);

        List<MediaLibrary> list = findByMaMediaChuDe_Active(maMediaChuDe,
                active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MediaLibrary exists with the key {");

            msg.append("maMediaChuDe=" + maMediaChuDe);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMediaLibraryException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MediaLibrary[] findByMaMediaChuDe_Active_PrevAndNext(
        long maMediaLibrary, long maMediaChuDe, boolean active,
        OrderByComparator obc)
        throws NoSuchMediaLibraryException, SystemException {
        MediaLibrary mediaLibrary = findByPrimaryKey(maMediaLibrary);

        int count = countByMaMediaChuDe_Active(maMediaChuDe, active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.media_library.model.MediaLibrary WHERE ");

            query.append("maMediaChuDe = ?");

            query.append(" AND ");

            query.append("active_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("maMediaChuDe ASC, ");
                query.append("tieuDeMediaLibrary ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(maMediaChuDe);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    mediaLibrary);

            MediaLibrary[] array = new MediaLibraryImpl[3];

            array[0] = (MediaLibrary) objArray[0];
            array[1] = (MediaLibrary) objArray[1];
            array[2] = (MediaLibrary) objArray[2];

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

    public List<MediaLibrary> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<MediaLibrary> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<MediaLibrary> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MediaLibrary> list = (List<MediaLibrary>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.media_library.model.MediaLibrary ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("maMediaChuDe ASC, ");
                    query.append("tieuDeMediaLibrary ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<MediaLibrary>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<MediaLibrary>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MediaLibrary>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(boolean active) throws SystemException {
        for (MediaLibrary mediaLibrary : findByActive(active)) {
            remove(mediaLibrary);
        }
    }

    public void removeByMaMediaChuDe_Active(long maMediaChuDe, boolean active)
        throws SystemException {
        for (MediaLibrary mediaLibrary : findByMaMediaChuDe_Active(
                maMediaChuDe, active)) {
            remove(mediaLibrary);
        }
    }

    public void removeAll() throws SystemException {
        for (MediaLibrary mediaLibrary : findAll()) {
            remove(mediaLibrary);
        }
    }

    public int countByActive(boolean active) throws SystemException {
        Object[] finderArgs = new Object[] { Boolean.valueOf(active) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.media_library.model.MediaLibrary WHERE ");

                query.append("active_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ACTIVE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMaMediaChuDe_Active(long maMediaChuDe, boolean active)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(maMediaChuDe), Boolean.valueOf(active)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MAMEDIACHUDE_ACTIVE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.media_library.model.MediaLibrary WHERE ");

                query.append("maMediaChuDe = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(maMediaChuDe);

                qPos.add(active);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAMEDIACHUDE_ACTIVE,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.media_library.model.MediaLibrary");

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
                        "value.object.listener.com.nss.portlet.media_library.model.MediaLibrary")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<MediaLibrary>> listenersList = new ArrayList<ModelListener<MediaLibrary>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<MediaLibrary>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
