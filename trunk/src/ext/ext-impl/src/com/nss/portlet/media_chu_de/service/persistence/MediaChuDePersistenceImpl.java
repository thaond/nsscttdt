package com.nss.portlet.media_chu_de.service.persistence;

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

import com.nss.portlet.media_chu_de.NoSuchMediaChuDeException;
import com.nss.portlet.media_chu_de.model.MediaChuDe;
import com.nss.portlet.media_chu_de.model.impl.MediaChuDeImpl;
import com.nss.portlet.media_chu_de.model.impl.MediaChuDeModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MediaChuDePersistenceImpl extends BasePersistenceImpl
    implements MediaChuDePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = MediaChuDeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(MediaChuDeModelImpl.ENTITY_CACHE_ENABLED,
            MediaChuDeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive", new String[] { Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(MediaChuDeModelImpl.ENTITY_CACHE_ENABLED,
            MediaChuDeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive",
            new String[] {
                Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(MediaChuDeModelImpl.ENTITY_CACHE_ENABLED,
            MediaChuDeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByActive", new String[] { Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(MediaChuDeModelImpl.ENTITY_CACHE_ENABLED,
            MediaChuDeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MediaChuDeModelImpl.ENTITY_CACHE_ENABLED,
            MediaChuDeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(MediaChuDePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.media_chu_de.service.persistence.MediaChuDePersistence.impl")
    protected com.nss.portlet.media_chu_de.service.persistence.MediaChuDePersistence mediaChuDePersistence;

    public void cacheResult(MediaChuDe mediaChuDe) {
        EntityCacheUtil.putResult(MediaChuDeModelImpl.ENTITY_CACHE_ENABLED,
            MediaChuDeImpl.class, mediaChuDe.getPrimaryKey(), mediaChuDe);
    }

    public void cacheResult(List<MediaChuDe> mediaChuDes) {
        for (MediaChuDe mediaChuDe : mediaChuDes) {
            if (EntityCacheUtil.getResult(
                        MediaChuDeModelImpl.ENTITY_CACHE_ENABLED,
                        MediaChuDeImpl.class, mediaChuDe.getPrimaryKey(), this) == null) {
                cacheResult(mediaChuDe);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(MediaChuDeImpl.class.getName());
        EntityCacheUtil.clearCache(MediaChuDeImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public MediaChuDe create(long maMediaChuDe) {
        MediaChuDe mediaChuDe = new MediaChuDeImpl();

        mediaChuDe.setNew(true);
        mediaChuDe.setPrimaryKey(maMediaChuDe);

        return mediaChuDe;
    }

    public MediaChuDe remove(long maMediaChuDe)
        throws NoSuchMediaChuDeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            MediaChuDe mediaChuDe = (MediaChuDe) session.get(MediaChuDeImpl.class,
                    new Long(maMediaChuDe));

            if (mediaChuDe == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No MediaChuDe exists with the primary key " +
                        maMediaChuDe);
                }

                throw new NoSuchMediaChuDeException(
                    "No MediaChuDe exists with the primary key " +
                    maMediaChuDe);
            }

            return remove(mediaChuDe);
        } catch (NoSuchMediaChuDeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public MediaChuDe remove(MediaChuDe mediaChuDe) throws SystemException {
        for (ModelListener<MediaChuDe> listener : listeners) {
            listener.onBeforeRemove(mediaChuDe);
        }

        mediaChuDe = removeImpl(mediaChuDe);

        for (ModelListener<MediaChuDe> listener : listeners) {
            listener.onAfterRemove(mediaChuDe);
        }

        return mediaChuDe;
    }

    protected MediaChuDe removeImpl(MediaChuDe mediaChuDe)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (mediaChuDe.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(MediaChuDeImpl.class,
                        mediaChuDe.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(mediaChuDe);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(MediaChuDeModelImpl.ENTITY_CACHE_ENABLED,
            MediaChuDeImpl.class, mediaChuDe.getPrimaryKey());

        return mediaChuDe;
    }

    /**
     * @deprecated Use <code>update(MediaChuDe mediaChuDe, boolean merge)</code>.
     */
    public MediaChuDe update(MediaChuDe mediaChuDe) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(MediaChuDe mediaChuDe) method. Use update(MediaChuDe mediaChuDe, boolean merge) instead.");
        }

        return update(mediaChuDe, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mediaChuDe the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mediaChuDe is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public MediaChuDe update(MediaChuDe mediaChuDe, boolean merge)
        throws SystemException {
        boolean isNew = mediaChuDe.isNew();

        for (ModelListener<MediaChuDe> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(mediaChuDe);
            } else {
                listener.onBeforeUpdate(mediaChuDe);
            }
        }

        mediaChuDe = updateImpl(mediaChuDe, merge);

        for (ModelListener<MediaChuDe> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(mediaChuDe);
            } else {
                listener.onAfterUpdate(mediaChuDe);
            }
        }

        return mediaChuDe;
    }

    public MediaChuDe updateImpl(
        com.nss.portlet.media_chu_de.model.MediaChuDe mediaChuDe, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, mediaChuDe, merge);

            mediaChuDe.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(MediaChuDeModelImpl.ENTITY_CACHE_ENABLED,
            MediaChuDeImpl.class, mediaChuDe.getPrimaryKey(), mediaChuDe);

        return mediaChuDe;
    }

    public MediaChuDe findByPrimaryKey(long maMediaChuDe)
        throws NoSuchMediaChuDeException, SystemException {
        MediaChuDe mediaChuDe = fetchByPrimaryKey(maMediaChuDe);

        if (mediaChuDe == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No MediaChuDe exists with the primary key " +
                    maMediaChuDe);
            }

            throw new NoSuchMediaChuDeException(
                "No MediaChuDe exists with the primary key " + maMediaChuDe);
        }

        return mediaChuDe;
    }

    public MediaChuDe fetchByPrimaryKey(long maMediaChuDe)
        throws SystemException {
        MediaChuDe mediaChuDe = (MediaChuDe) EntityCacheUtil.getResult(MediaChuDeModelImpl.ENTITY_CACHE_ENABLED,
                MediaChuDeImpl.class, maMediaChuDe, this);

        if (mediaChuDe == null) {
            Session session = null;

            try {
                session = openSession();

                mediaChuDe = (MediaChuDe) session.get(MediaChuDeImpl.class,
                        new Long(maMediaChuDe));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (mediaChuDe != null) {
                    cacheResult(mediaChuDe);
                }

                closeSession(session);
            }
        }

        return mediaChuDe;
    }

    public List<MediaChuDe> findByActive(boolean active)
        throws SystemException {
        Object[] finderArgs = new Object[] { Boolean.valueOf(active) };

        List<MediaChuDe> list = (List<MediaChuDe>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.media_chu_de.model.MediaChuDe WHERE ");

                query.append("active_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tenMediaChuDe ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MediaChuDe>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<MediaChuDe> findByActive(boolean active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<MediaChuDe> findByActive(boolean active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                Boolean.valueOf(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MediaChuDe> list = (List<MediaChuDe>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.media_chu_de.model.MediaChuDe WHERE ");

                query.append("active_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenMediaChuDe ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<MediaChuDe>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MediaChuDe>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public MediaChuDe findByActive_First(boolean active, OrderByComparator obc)
        throws NoSuchMediaChuDeException, SystemException {
        List<MediaChuDe> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MediaChuDe exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMediaChuDeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MediaChuDe findByActive_Last(boolean active, OrderByComparator obc)
        throws NoSuchMediaChuDeException, SystemException {
        int count = countByActive(active);

        List<MediaChuDe> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No MediaChuDe exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchMediaChuDeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public MediaChuDe[] findByActive_PrevAndNext(long maMediaChuDe,
        boolean active, OrderByComparator obc)
        throws NoSuchMediaChuDeException, SystemException {
        MediaChuDe mediaChuDe = findByPrimaryKey(maMediaChuDe);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.media_chu_de.model.MediaChuDe WHERE ");

            query.append("active_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tenMediaChuDe ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    mediaChuDe);

            MediaChuDe[] array = new MediaChuDeImpl[3];

            array[0] = (MediaChuDe) objArray[0];
            array[1] = (MediaChuDe) objArray[1];
            array[2] = (MediaChuDe) objArray[2];

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

    public List<MediaChuDe> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<MediaChuDe> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<MediaChuDe> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<MediaChuDe> list = (List<MediaChuDe>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.media_chu_de.model.MediaChuDe ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenMediaChuDe ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<MediaChuDe>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<MediaChuDe>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<MediaChuDe>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(boolean active) throws SystemException {
        for (MediaChuDe mediaChuDe : findByActive(active)) {
            remove(mediaChuDe);
        }
    }

    public void removeAll() throws SystemException {
        for (MediaChuDe mediaChuDe : findAll()) {
            remove(mediaChuDe);
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
                    "FROM com.nss.portlet.media_chu_de.model.MediaChuDe WHERE ");

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

    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.nss.portlet.media_chu_de.model.MediaChuDe");

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
                        "value.object.listener.com.nss.portlet.media_chu_de.model.MediaChuDe")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<MediaChuDe>> listenersList = new ArrayList<ModelListener<MediaChuDe>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<MediaChuDe>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
