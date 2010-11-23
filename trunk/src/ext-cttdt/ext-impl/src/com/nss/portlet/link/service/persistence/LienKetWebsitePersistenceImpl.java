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

import com.nss.portlet.link.NoSuchLienKetWebsiteException;
import com.nss.portlet.link.model.LienKetWebsite;
import com.nss.portlet.link.model.impl.LienKetWebsiteImpl;
import com.nss.portlet.link.model.impl.LienKetWebsiteModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LienKetWebsitePersistenceImpl extends BasePersistenceImpl
    implements LienKetWebsitePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = LienKetWebsiteImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_LOAIWEBSITEID = new FinderPath(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByLoaiWebsiteId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_LOAIWEBSITEID = new FinderPath(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByLoaiWebsiteId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_LOAIWEBSITEID = new FinderPath(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByLoaiWebsiteId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_LOAIWEBSITEID_ACTIVE = new FinderPath(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByLoaiWebsiteId_Active",
            new String[] { Long.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_LOAIWEBSITEID_ACTIVE = new FinderPath(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByLoaiWebsiteId_Active",
            new String[] {
                Long.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_LOAIWEBSITEID_ACTIVE = new FinderPath(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByLoaiWebsiteId_Active",
            new String[] { Long.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(LienKetWebsitePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.link.service.persistence.LienKetWebsitePersistence.impl")
    protected com.nss.portlet.link.service.persistence.LienKetWebsitePersistence lienKetWebsitePersistence;
    @BeanReference(name = "com.nss.portlet.link.service.persistence.LoaiWebsitePersistence.impl")
    protected com.nss.portlet.link.service.persistence.LoaiWebsitePersistence loaiWebsitePersistence;

    public void cacheResult(LienKetWebsite lienKetWebsite) {
        EntityCacheUtil.putResult(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteImpl.class, lienKetWebsite.getPrimaryKey(),
            lienKetWebsite);
    }

    public void cacheResult(List<LienKetWebsite> lienKetWebsites) {
        for (LienKetWebsite lienKetWebsite : lienKetWebsites) {
            if (EntityCacheUtil.getResult(
                        LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
                        LienKetWebsiteImpl.class,
                        lienKetWebsite.getPrimaryKey(), this) == null) {
                cacheResult(lienKetWebsite);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(LienKetWebsiteImpl.class.getName());
        EntityCacheUtil.clearCache(LienKetWebsiteImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public LienKetWebsite create(long maWebsite) {
        LienKetWebsite lienKetWebsite = new LienKetWebsiteImpl();

        lienKetWebsite.setNew(true);
        lienKetWebsite.setPrimaryKey(maWebsite);

        return lienKetWebsite;
    }

    public LienKetWebsite remove(long maWebsite)
        throws NoSuchLienKetWebsiteException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LienKetWebsite lienKetWebsite = (LienKetWebsite) session.get(LienKetWebsiteImpl.class,
                    new Long(maWebsite));

            if (lienKetWebsite == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No LienKetWebsite exists with the primary key " +
                        maWebsite);
                }

                throw new NoSuchLienKetWebsiteException(
                    "No LienKetWebsite exists with the primary key " +
                    maWebsite);
            }

            return remove(lienKetWebsite);
        } catch (NoSuchLienKetWebsiteException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public LienKetWebsite remove(LienKetWebsite lienKetWebsite)
        throws SystemException {
        for (ModelListener<LienKetWebsite> listener : listeners) {
            listener.onBeforeRemove(lienKetWebsite);
        }

        lienKetWebsite = removeImpl(lienKetWebsite);

        for (ModelListener<LienKetWebsite> listener : listeners) {
            listener.onAfterRemove(lienKetWebsite);
        }

        return lienKetWebsite;
    }

    protected LienKetWebsite removeImpl(LienKetWebsite lienKetWebsite)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (lienKetWebsite.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(LienKetWebsiteImpl.class,
                        lienKetWebsite.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(lienKetWebsite);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteImpl.class, lienKetWebsite.getPrimaryKey());

        return lienKetWebsite;
    }

    /**
     * @deprecated Use <code>update(LienKetWebsite lienKetWebsite, boolean merge)</code>.
     */
    public LienKetWebsite update(LienKetWebsite lienKetWebsite)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(LienKetWebsite lienKetWebsite) method. Use update(LienKetWebsite lienKetWebsite, boolean merge) instead.");
        }

        return update(lienKetWebsite, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                lienKetWebsite the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when lienKetWebsite is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public LienKetWebsite update(LienKetWebsite lienKetWebsite, boolean merge)
        throws SystemException {
        boolean isNew = lienKetWebsite.isNew();

        for (ModelListener<LienKetWebsite> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(lienKetWebsite);
            } else {
                listener.onBeforeUpdate(lienKetWebsite);
            }
        }

        lienKetWebsite = updateImpl(lienKetWebsite, merge);

        for (ModelListener<LienKetWebsite> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(lienKetWebsite);
            } else {
                listener.onAfterUpdate(lienKetWebsite);
            }
        }

        return lienKetWebsite;
    }

    public LienKetWebsite updateImpl(
        com.nss.portlet.link.model.LienKetWebsite lienKetWebsite, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, lienKetWebsite, merge);

            lienKetWebsite.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
            LienKetWebsiteImpl.class, lienKetWebsite.getPrimaryKey(),
            lienKetWebsite);

        return lienKetWebsite;
    }

    public LienKetWebsite findByPrimaryKey(long maWebsite)
        throws NoSuchLienKetWebsiteException, SystemException {
        LienKetWebsite lienKetWebsite = fetchByPrimaryKey(maWebsite);

        if (lienKetWebsite == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No LienKetWebsite exists with the primary key " +
                    maWebsite);
            }

            throw new NoSuchLienKetWebsiteException(
                "No LienKetWebsite exists with the primary key " + maWebsite);
        }

        return lienKetWebsite;
    }

    public LienKetWebsite fetchByPrimaryKey(long maWebsite)
        throws SystemException {
        LienKetWebsite lienKetWebsite = (LienKetWebsite) EntityCacheUtil.getResult(LienKetWebsiteModelImpl.ENTITY_CACHE_ENABLED,
                LienKetWebsiteImpl.class, maWebsite, this);

        if (lienKetWebsite == null) {
            Session session = null;

            try {
                session = openSession();

                lienKetWebsite = (LienKetWebsite) session.get(LienKetWebsiteImpl.class,
                        new Long(maWebsite));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (lienKetWebsite != null) {
                    cacheResult(lienKetWebsite);
                }

                closeSession(session);
            }
        }

        return lienKetWebsite;
    }

    public List<LienKetWebsite> findByLoaiWebsiteId(long loaiWebsite)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(loaiWebsite) };

        List<LienKetWebsite> list = (List<LienKetWebsite>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LOAIWEBSITEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.link.model.LienKetWebsite WHERE ");

                query.append("loai_website = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("thu_tu_website ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(loaiWebsite);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LienKetWebsite>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LOAIWEBSITEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<LienKetWebsite> findByLoaiWebsiteId(long loaiWebsite,
        int start, int end) throws SystemException {
        return findByLoaiWebsiteId(loaiWebsite, start, end, null);
    }

    public List<LienKetWebsite> findByLoaiWebsiteId(long loaiWebsite,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(loaiWebsite),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LienKetWebsite> list = (List<LienKetWebsite>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_LOAIWEBSITEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.link.model.LienKetWebsite WHERE ");

                query.append("loai_website = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("thu_tu_website ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(loaiWebsite);

                list = (List<LienKetWebsite>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LienKetWebsite>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_LOAIWEBSITEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public LienKetWebsite findByLoaiWebsiteId_First(long loaiWebsite,
        OrderByComparator obc)
        throws NoSuchLienKetWebsiteException, SystemException {
        List<LienKetWebsite> list = findByLoaiWebsiteId(loaiWebsite, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LienKetWebsite exists with the key {");

            msg.append("loaiWebsite=" + loaiWebsite);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLienKetWebsiteException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LienKetWebsite findByLoaiWebsiteId_Last(long loaiWebsite,
        OrderByComparator obc)
        throws NoSuchLienKetWebsiteException, SystemException {
        int count = countByLoaiWebsiteId(loaiWebsite);

        List<LienKetWebsite> list = findByLoaiWebsiteId(loaiWebsite, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LienKetWebsite exists with the key {");

            msg.append("loaiWebsite=" + loaiWebsite);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLienKetWebsiteException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LienKetWebsite[] findByLoaiWebsiteId_PrevAndNext(long maWebsite,
        long loaiWebsite, OrderByComparator obc)
        throws NoSuchLienKetWebsiteException, SystemException {
        LienKetWebsite lienKetWebsite = findByPrimaryKey(maWebsite);

        int count = countByLoaiWebsiteId(loaiWebsite);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.link.model.LienKetWebsite WHERE ");

            query.append("loai_website = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("thu_tu_website ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(loaiWebsite);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    lienKetWebsite);

            LienKetWebsite[] array = new LienKetWebsiteImpl[3];

            array[0] = (LienKetWebsite) objArray[0];
            array[1] = (LienKetWebsite) objArray[1];
            array[2] = (LienKetWebsite) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<LienKetWebsite> findByActive(int active)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<LienKetWebsite> list = (List<LienKetWebsite>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.link.model.LienKetWebsite WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("thu_tu_website ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LienKetWebsite>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<LienKetWebsite> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<LienKetWebsite> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LienKetWebsite> list = (List<LienKetWebsite>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.link.model.LienKetWebsite WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("thu_tu_website ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<LienKetWebsite>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LienKetWebsite>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public LienKetWebsite findByActive_First(int active, OrderByComparator obc)
        throws NoSuchLienKetWebsiteException, SystemException {
        List<LienKetWebsite> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LienKetWebsite exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLienKetWebsiteException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LienKetWebsite findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchLienKetWebsiteException, SystemException {
        int count = countByActive(active);

        List<LienKetWebsite> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LienKetWebsite exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLienKetWebsiteException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LienKetWebsite[] findByActive_PrevAndNext(long maWebsite,
        int active, OrderByComparator obc)
        throws NoSuchLienKetWebsiteException, SystemException {
        LienKetWebsite lienKetWebsite = findByPrimaryKey(maWebsite);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.link.model.LienKetWebsite WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("thu_tu_website ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    lienKetWebsite);

            LienKetWebsite[] array = new LienKetWebsiteImpl[3];

            array[0] = (LienKetWebsite) objArray[0];
            array[1] = (LienKetWebsite) objArray[1];
            array[2] = (LienKetWebsite) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<LienKetWebsite> findByLoaiWebsiteId_Active(long loaiWebsite,
        int active) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(loaiWebsite), new Integer(active)
            };

        List<LienKetWebsite> list = (List<LienKetWebsite>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LOAIWEBSITEID_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.link.model.LienKetWebsite WHERE ");

                query.append("loai_website = ?");

                query.append(" AND ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("thu_tu_website ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(loaiWebsite);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LienKetWebsite>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LOAIWEBSITEID_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<LienKetWebsite> findByLoaiWebsiteId_Active(long loaiWebsite,
        int active, int start, int end) throws SystemException {
        return findByLoaiWebsiteId_Active(loaiWebsite, active, start, end, null);
    }

    public List<LienKetWebsite> findByLoaiWebsiteId_Active(long loaiWebsite,
        int active, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(loaiWebsite), new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LienKetWebsite> list = (List<LienKetWebsite>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_LOAIWEBSITEID_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.link.model.LienKetWebsite WHERE ");

                query.append("loai_website = ?");

                query.append(" AND ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("thu_tu_website ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(loaiWebsite);

                qPos.add(active);

                list = (List<LienKetWebsite>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LienKetWebsite>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_LOAIWEBSITEID_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public LienKetWebsite findByLoaiWebsiteId_Active_First(long loaiWebsite,
        int active, OrderByComparator obc)
        throws NoSuchLienKetWebsiteException, SystemException {
        List<LienKetWebsite> list = findByLoaiWebsiteId_Active(loaiWebsite,
                active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LienKetWebsite exists with the key {");

            msg.append("loaiWebsite=" + loaiWebsite);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLienKetWebsiteException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LienKetWebsite findByLoaiWebsiteId_Active_Last(long loaiWebsite,
        int active, OrderByComparator obc)
        throws NoSuchLienKetWebsiteException, SystemException {
        int count = countByLoaiWebsiteId_Active(loaiWebsite, active);

        List<LienKetWebsite> list = findByLoaiWebsiteId_Active(loaiWebsite,
                active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LienKetWebsite exists with the key {");

            msg.append("loaiWebsite=" + loaiWebsite);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLienKetWebsiteException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LienKetWebsite[] findByLoaiWebsiteId_Active_PrevAndNext(
        long maWebsite, long loaiWebsite, int active, OrderByComparator obc)
        throws NoSuchLienKetWebsiteException, SystemException {
        LienKetWebsite lienKetWebsite = findByPrimaryKey(maWebsite);

        int count = countByLoaiWebsiteId_Active(loaiWebsite, active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.link.model.LienKetWebsite WHERE ");

            query.append("loai_website = ?");

            query.append(" AND ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("thu_tu_website ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(loaiWebsite);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    lienKetWebsite);

            LienKetWebsite[] array = new LienKetWebsiteImpl[3];

            array[0] = (LienKetWebsite) objArray[0];
            array[1] = (LienKetWebsite) objArray[1];
            array[2] = (LienKetWebsite) objArray[2];

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

    public List<LienKetWebsite> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<LienKetWebsite> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<LienKetWebsite> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LienKetWebsite> list = (List<LienKetWebsite>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.link.model.LienKetWebsite ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("thu_tu_website ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<LienKetWebsite>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LienKetWebsite>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LienKetWebsite>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByLoaiWebsiteId(long loaiWebsite)
        throws SystemException {
        for (LienKetWebsite lienKetWebsite : findByLoaiWebsiteId(loaiWebsite)) {
            remove(lienKetWebsite);
        }
    }

    public void removeByActive(int active) throws SystemException {
        for (LienKetWebsite lienKetWebsite : findByActive(active)) {
            remove(lienKetWebsite);
        }
    }

    public void removeByLoaiWebsiteId_Active(long loaiWebsite, int active)
        throws SystemException {
        for (LienKetWebsite lienKetWebsite : findByLoaiWebsiteId_Active(
                loaiWebsite, active)) {
            remove(lienKetWebsite);
        }
    }

    public void removeAll() throws SystemException {
        for (LienKetWebsite lienKetWebsite : findAll()) {
            remove(lienKetWebsite);
        }
    }

    public int countByLoaiWebsiteId(long loaiWebsite) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(loaiWebsite) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOAIWEBSITEID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.link.model.LienKetWebsite WHERE ");

                query.append("loai_website = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(loaiWebsite);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOAIWEBSITEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
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
                    "FROM com.nss.portlet.link.model.LienKetWebsite WHERE ");

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

    public int countByLoaiWebsiteId_Active(long loaiWebsite, int active)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(loaiWebsite), new Integer(active)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOAIWEBSITEID_ACTIVE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.link.model.LienKetWebsite WHERE ");

                query.append("loai_website = ?");

                query.append(" AND ");

                query.append("active = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(loaiWebsite);

                qPos.add(active);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOAIWEBSITEID_ACTIVE,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.link.model.LienKetWebsite");

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
                        "value.object.listener.com.nss.portlet.link.model.LienKetWebsite")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LienKetWebsite>> listenersList = new ArrayList<ModelListener<LienKetWebsite>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LienKetWebsite>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
