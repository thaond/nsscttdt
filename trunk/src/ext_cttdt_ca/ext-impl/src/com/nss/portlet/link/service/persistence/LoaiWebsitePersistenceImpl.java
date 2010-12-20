package com.nss.portlet.link.service.persistence;

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

import com.nss.portlet.link.NoSuchLoaiWebsiteException;
import com.nss.portlet.link.model.LoaiWebsite;
import com.nss.portlet.link.model.impl.LoaiWebsiteImpl;
import com.nss.portlet.link.model.impl.LoaiWebsiteModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LoaiWebsitePersistenceImpl extends BasePersistenceImpl
    implements LoaiWebsitePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = LoaiWebsiteImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(LoaiWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LoaiWebsiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(LoaiWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LoaiWebsiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(LoaiWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LoaiWebsiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByActive", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LoaiWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LoaiWebsiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LoaiWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LoaiWebsiteModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(LoaiWebsitePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.link.service.persistence.LienKetWebsitePersistence.impl")
    protected com.nss.portlet.link.service.persistence.LienKetWebsitePersistence lienKetWebsitePersistence;
    @BeanReference(name = "com.nss.portlet.link.service.persistence.LoaiWebsitePersistence.impl")
    protected com.nss.portlet.link.service.persistence.LoaiWebsitePersistence loaiWebsitePersistence;

    public void cacheResult(LoaiWebsite loaiWebsite) {
        EntityCacheUtil.putResult(LoaiWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LoaiWebsiteImpl.class, loaiWebsite.getPrimaryKey(), loaiWebsite);
    }

    public void cacheResult(List<LoaiWebsite> loaiWebsites) {
        for (LoaiWebsite loaiWebsite : loaiWebsites) {
            if (EntityCacheUtil.getResult(
                        LoaiWebsiteModelImpl.ENTITY_CACHE_ENABLED,
                        LoaiWebsiteImpl.class, loaiWebsite.getPrimaryKey(), this) == null) {
                cacheResult(loaiWebsite);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(LoaiWebsiteImpl.class.getName());
        EntityCacheUtil.clearCache(LoaiWebsiteImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public LoaiWebsite create(long maLoaiWebsite) {
        LoaiWebsite loaiWebsite = new LoaiWebsiteImpl();

        loaiWebsite.setNew(true);
        loaiWebsite.setPrimaryKey(maLoaiWebsite);

        return loaiWebsite;
    }

    public LoaiWebsite remove(long maLoaiWebsite)
        throws NoSuchLoaiWebsiteException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LoaiWebsite loaiWebsite = (LoaiWebsite) session.get(LoaiWebsiteImpl.class,
                    new Long(maLoaiWebsite));

            if (loaiWebsite == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No LoaiWebsite exists with the primary key " +
                        maLoaiWebsite);
                }

                throw new NoSuchLoaiWebsiteException(
                    "No LoaiWebsite exists with the primary key " +
                    maLoaiWebsite);
            }

            return remove(loaiWebsite);
        } catch (NoSuchLoaiWebsiteException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public LoaiWebsite remove(LoaiWebsite loaiWebsite)
        throws SystemException {
        for (ModelListener<LoaiWebsite> listener : listeners) {
            listener.onBeforeRemove(loaiWebsite);
        }

        loaiWebsite = removeImpl(loaiWebsite);

        for (ModelListener<LoaiWebsite> listener : listeners) {
            listener.onAfterRemove(loaiWebsite);
        }

        return loaiWebsite;
    }

    protected LoaiWebsite removeImpl(LoaiWebsite loaiWebsite)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (loaiWebsite.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(LoaiWebsiteImpl.class,
                        loaiWebsite.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(loaiWebsite);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(LoaiWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LoaiWebsiteImpl.class, loaiWebsite.getPrimaryKey());

        return loaiWebsite;
    }

    /**
     * @deprecated Use <code>update(LoaiWebsite loaiWebsite, boolean merge)</code>.
     */
    public LoaiWebsite update(LoaiWebsite loaiWebsite)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(LoaiWebsite loaiWebsite) method. Use update(LoaiWebsite loaiWebsite, boolean merge) instead.");
        }

        return update(loaiWebsite, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiWebsite the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiWebsite is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public LoaiWebsite update(LoaiWebsite loaiWebsite, boolean merge)
        throws SystemException {
        boolean isNew = loaiWebsite.isNew();

        for (ModelListener<LoaiWebsite> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(loaiWebsite);
            } else {
                listener.onBeforeUpdate(loaiWebsite);
            }
        }

        loaiWebsite = updateImpl(loaiWebsite, merge);

        for (ModelListener<LoaiWebsite> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(loaiWebsite);
            } else {
                listener.onAfterUpdate(loaiWebsite);
            }
        }

        return loaiWebsite;
    }

    public LoaiWebsite updateImpl(
        com.nss.portlet.link.model.LoaiWebsite loaiWebsite, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, loaiWebsite, merge);

            loaiWebsite.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(LoaiWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LoaiWebsiteImpl.class, loaiWebsite.getPrimaryKey(), loaiWebsite);

        return loaiWebsite;
    }

    public LoaiWebsite findByPrimaryKey(long maLoaiWebsite)
        throws NoSuchLoaiWebsiteException, SystemException {
        LoaiWebsite loaiWebsite = fetchByPrimaryKey(maLoaiWebsite);

        if (loaiWebsite == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No LoaiWebsite exists with the primary key " +
                    maLoaiWebsite);
            }

            throw new NoSuchLoaiWebsiteException(
                "No LoaiWebsite exists with the primary key " + maLoaiWebsite);
        }

        return loaiWebsite;
    }

    public LoaiWebsite fetchByPrimaryKey(long maLoaiWebsite)
        throws SystemException {
        LoaiWebsite loaiWebsite = (LoaiWebsite) EntityCacheUtil.getResult(LoaiWebsiteModelImpl.ENTITY_CACHE_ENABLED,
                LoaiWebsiteImpl.class, maLoaiWebsite, this);

        if (loaiWebsite == null) {
            Session session = null;

            try {
                session = openSession();

                loaiWebsite = (LoaiWebsite) session.get(LoaiWebsiteImpl.class,
                        new Long(maLoaiWebsite));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (loaiWebsite != null) {
                    cacheResult(loaiWebsite);
                }

                closeSession(session);
            }
        }

        return loaiWebsite;
    }

    public List<LoaiWebsite> findByActive(int active) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<LoaiWebsite> list = (List<LoaiWebsite>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.link.model.LoaiWebsite WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ten_loai_website ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LoaiWebsite>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<LoaiWebsite> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<LoaiWebsite> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LoaiWebsite> list = (List<LoaiWebsite>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.link.model.LoaiWebsite WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_loai_website ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<LoaiWebsite>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LoaiWebsite>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public LoaiWebsite findByActive_First(int active, OrderByComparator obc)
        throws NoSuchLoaiWebsiteException, SystemException {
        List<LoaiWebsite> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LoaiWebsite exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLoaiWebsiteException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LoaiWebsite findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchLoaiWebsiteException, SystemException {
        int count = countByActive(active);

        List<LoaiWebsite> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LoaiWebsite exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLoaiWebsiteException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LoaiWebsite[] findByActive_PrevAndNext(long maLoaiWebsite,
        int active, OrderByComparator obc)
        throws NoSuchLoaiWebsiteException, SystemException {
        LoaiWebsite loaiWebsite = findByPrimaryKey(maLoaiWebsite);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.nss.portlet.link.model.LoaiWebsite WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ten_loai_website ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    loaiWebsite);

            LoaiWebsite[] array = new LoaiWebsiteImpl[3];

            array[0] = (LoaiWebsite) objArray[0];
            array[1] = (LoaiWebsite) objArray[1];
            array[2] = (LoaiWebsite) objArray[2];

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

    public List<LoaiWebsite> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<LoaiWebsite> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<LoaiWebsite> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LoaiWebsite> list = (List<LoaiWebsite>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.link.model.LoaiWebsite ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_loai_website ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<LoaiWebsite>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LoaiWebsite>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LoaiWebsite>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (LoaiWebsite loaiWebsite : findByActive(active)) {
            remove(loaiWebsite);
        }
    }

    public void removeAll() throws SystemException {
        for (LoaiWebsite loaiWebsite : findAll()) {
            remove(loaiWebsite);
        }
    }

    public int countByActive(int active) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ACTIVE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.link.model.LoaiWebsite WHERE ");

                query.append("active = ?");

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
                        "SELECT COUNT(*) FROM com.nss.portlet.link.model.LoaiWebsite");

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
                        "value.object.listener.com.nss.portlet.link.model.LoaiWebsite")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LoaiWebsite>> listenersList = new ArrayList<ModelListener<LoaiWebsite>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LoaiWebsite>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
