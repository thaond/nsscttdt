package com.nss.portlet.loai_thu_tuc.service.persistence;

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

import com.nss.portlet.loai_thu_tuc.NoSuchLoaiThuTucHanhChinhException;
import com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh;
import com.nss.portlet.loai_thu_tuc.model.impl.LoaiThuTucHanhChinhImpl;
import com.nss.portlet.loai_thu_tuc.model.impl.LoaiThuTucHanhChinhModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LoaiThuTucHanhChinhPersistenceImpl extends BasePersistenceImpl
    implements LoaiThuTucHanhChinhPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = LoaiThuTucHanhChinhImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(LoaiThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LoaiThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(LoaiThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LoaiThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(LoaiThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LoaiThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(LoaiThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LoaiThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LoaiThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LoaiThuTucHanhChinhModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(LoaiThuTucHanhChinhPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.loai_thu_tuc.service.persistence.LoaiThuTucHanhChinhPersistence.impl")
    protected com.nss.portlet.loai_thu_tuc.service.persistence.LoaiThuTucHanhChinhPersistence loaiThuTucHanhChinhPersistence;

    public void cacheResult(LoaiThuTucHanhChinh loaiThuTucHanhChinh) {
        EntityCacheUtil.putResult(LoaiThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LoaiThuTucHanhChinhImpl.class, loaiThuTucHanhChinh.getPrimaryKey(),
            loaiThuTucHanhChinh);
    }

    public void cacheResult(List<LoaiThuTucHanhChinh> loaiThuTucHanhChinhs) {
        for (LoaiThuTucHanhChinh loaiThuTucHanhChinh : loaiThuTucHanhChinhs) {
            if (EntityCacheUtil.getResult(
                        LoaiThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
                        LoaiThuTucHanhChinhImpl.class,
                        loaiThuTucHanhChinh.getPrimaryKey(), this) == null) {
                cacheResult(loaiThuTucHanhChinh);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(LoaiThuTucHanhChinhImpl.class.getName());
        EntityCacheUtil.clearCache(LoaiThuTucHanhChinhImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public LoaiThuTucHanhChinh create(long maLoaiThuTucHanhChinh) {
        LoaiThuTucHanhChinh loaiThuTucHanhChinh = new LoaiThuTucHanhChinhImpl();

        loaiThuTucHanhChinh.setNew(true);
        loaiThuTucHanhChinh.setPrimaryKey(maLoaiThuTucHanhChinh);

        return loaiThuTucHanhChinh;
    }

    public LoaiThuTucHanhChinh remove(long maLoaiThuTucHanhChinh)
        throws NoSuchLoaiThuTucHanhChinhException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LoaiThuTucHanhChinh loaiThuTucHanhChinh = (LoaiThuTucHanhChinh) session.get(LoaiThuTucHanhChinhImpl.class,
                    new Long(maLoaiThuTucHanhChinh));

            if (loaiThuTucHanhChinh == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No LoaiThuTucHanhChinh exists with the primary key " +
                        maLoaiThuTucHanhChinh);
                }

                throw new NoSuchLoaiThuTucHanhChinhException(
                    "No LoaiThuTucHanhChinh exists with the primary key " +
                    maLoaiThuTucHanhChinh);
            }

            return remove(loaiThuTucHanhChinh);
        } catch (NoSuchLoaiThuTucHanhChinhException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public LoaiThuTucHanhChinh remove(LoaiThuTucHanhChinh loaiThuTucHanhChinh)
        throws SystemException {
        for (ModelListener<LoaiThuTucHanhChinh> listener : listeners) {
            listener.onBeforeRemove(loaiThuTucHanhChinh);
        }

        loaiThuTucHanhChinh = removeImpl(loaiThuTucHanhChinh);

        for (ModelListener<LoaiThuTucHanhChinh> listener : listeners) {
            listener.onAfterRemove(loaiThuTucHanhChinh);
        }

        return loaiThuTucHanhChinh;
    }

    protected LoaiThuTucHanhChinh removeImpl(
        LoaiThuTucHanhChinh loaiThuTucHanhChinh) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (loaiThuTucHanhChinh.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(LoaiThuTucHanhChinhImpl.class,
                        loaiThuTucHanhChinh.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(loaiThuTucHanhChinh);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(LoaiThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LoaiThuTucHanhChinhImpl.class, loaiThuTucHanhChinh.getPrimaryKey());

        return loaiThuTucHanhChinh;
    }

    /**
     * @deprecated Use <code>update(LoaiThuTucHanhChinh loaiThuTucHanhChinh, boolean merge)</code>.
     */
    public LoaiThuTucHanhChinh update(LoaiThuTucHanhChinh loaiThuTucHanhChinh)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(LoaiThuTucHanhChinh loaiThuTucHanhChinh) method. Use update(LoaiThuTucHanhChinh loaiThuTucHanhChinh, boolean merge) instead.");
        }

        return update(loaiThuTucHanhChinh, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiThuTucHanhChinh the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiThuTucHanhChinh is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public LoaiThuTucHanhChinh update(LoaiThuTucHanhChinh loaiThuTucHanhChinh,
        boolean merge) throws SystemException {
        boolean isNew = loaiThuTucHanhChinh.isNew();

        for (ModelListener<LoaiThuTucHanhChinh> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(loaiThuTucHanhChinh);
            } else {
                listener.onBeforeUpdate(loaiThuTucHanhChinh);
            }
        }

        loaiThuTucHanhChinh = updateImpl(loaiThuTucHanhChinh, merge);

        for (ModelListener<LoaiThuTucHanhChinh> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(loaiThuTucHanhChinh);
            } else {
                listener.onAfterUpdate(loaiThuTucHanhChinh);
            }
        }

        return loaiThuTucHanhChinh;
    }

    public LoaiThuTucHanhChinh updateImpl(
        com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh loaiThuTucHanhChinh,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, loaiThuTucHanhChinh, merge);

            loaiThuTucHanhChinh.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(LoaiThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
            LoaiThuTucHanhChinhImpl.class, loaiThuTucHanhChinh.getPrimaryKey(),
            loaiThuTucHanhChinh);

        return loaiThuTucHanhChinh;
    }

    public LoaiThuTucHanhChinh findByPrimaryKey(long maLoaiThuTucHanhChinh)
        throws NoSuchLoaiThuTucHanhChinhException, SystemException {
        LoaiThuTucHanhChinh loaiThuTucHanhChinh = fetchByPrimaryKey(maLoaiThuTucHanhChinh);

        if (loaiThuTucHanhChinh == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No LoaiThuTucHanhChinh exists with the primary key " +
                    maLoaiThuTucHanhChinh);
            }

            throw new NoSuchLoaiThuTucHanhChinhException(
                "No LoaiThuTucHanhChinh exists with the primary key " +
                maLoaiThuTucHanhChinh);
        }

        return loaiThuTucHanhChinh;
    }

    public LoaiThuTucHanhChinh fetchByPrimaryKey(long maLoaiThuTucHanhChinh)
        throws SystemException {
        LoaiThuTucHanhChinh loaiThuTucHanhChinh = (LoaiThuTucHanhChinh) EntityCacheUtil.getResult(LoaiThuTucHanhChinhModelImpl.ENTITY_CACHE_ENABLED,
                LoaiThuTucHanhChinhImpl.class, maLoaiThuTucHanhChinh, this);

        if (loaiThuTucHanhChinh == null) {
            Session session = null;

            try {
                session = openSession();

                loaiThuTucHanhChinh = (LoaiThuTucHanhChinh) session.get(LoaiThuTucHanhChinhImpl.class,
                        new Long(maLoaiThuTucHanhChinh));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (loaiThuTucHanhChinh != null) {
                    cacheResult(loaiThuTucHanhChinh);
                }

                closeSession(session);
            }
        }

        return loaiThuTucHanhChinh;
    }

    public List<LoaiThuTucHanhChinh> findByActive(int active)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<LoaiThuTucHanhChinh> list = (List<LoaiThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tenLoaiThuTucHanhChinh ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LoaiThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<LoaiThuTucHanhChinh> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<LoaiThuTucHanhChinh> findByActive(int active, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LoaiThuTucHanhChinh> list = (List<LoaiThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenLoaiThuTucHanhChinh ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<LoaiThuTucHanhChinh>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LoaiThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public LoaiThuTucHanhChinh findByActive_First(int active,
        OrderByComparator obc)
        throws NoSuchLoaiThuTucHanhChinhException, SystemException {
        List<LoaiThuTucHanhChinh> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LoaiThuTucHanhChinh exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLoaiThuTucHanhChinhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LoaiThuTucHanhChinh findByActive_Last(int active,
        OrderByComparator obc)
        throws NoSuchLoaiThuTucHanhChinhException, SystemException {
        int count = countByActive(active);

        List<LoaiThuTucHanhChinh> list = findByActive(active, count - 1, count,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No LoaiThuTucHanhChinh exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchLoaiThuTucHanhChinhException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public LoaiThuTucHanhChinh[] findByActive_PrevAndNext(
        long maLoaiThuTucHanhChinh, int active, OrderByComparator obc)
        throws NoSuchLoaiThuTucHanhChinhException, SystemException {
        LoaiThuTucHanhChinh loaiThuTucHanhChinh = findByPrimaryKey(maLoaiThuTucHanhChinh);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tenLoaiThuTucHanhChinh ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    loaiThuTucHanhChinh);

            LoaiThuTucHanhChinh[] array = new LoaiThuTucHanhChinhImpl[3];

            array[0] = (LoaiThuTucHanhChinh) objArray[0];
            array[1] = (LoaiThuTucHanhChinh) objArray[1];
            array[2] = (LoaiThuTucHanhChinh) objArray[2];

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

    public List<LoaiThuTucHanhChinh> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<LoaiThuTucHanhChinh> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<LoaiThuTucHanhChinh> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<LoaiThuTucHanhChinh> list = (List<LoaiThuTucHanhChinh>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tenLoaiThuTucHanhChinh ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<LoaiThuTucHanhChinh>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<LoaiThuTucHanhChinh>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<LoaiThuTucHanhChinh>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (LoaiThuTucHanhChinh loaiThuTucHanhChinh : findByActive(active)) {
            remove(loaiThuTucHanhChinh);
        }
    }

    public void removeAll() throws SystemException {
        for (LoaiThuTucHanhChinh loaiThuTucHanhChinh : findAll()) {
            remove(loaiThuTucHanhChinh);
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
                    "FROM com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh WHERE ");

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
                        "SELECT COUNT(*) FROM com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh");

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
                        "value.object.listener.com.nss.portlet.loai_thu_tuc.model.LoaiThuTucHanhChinh")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<LoaiThuTucHanhChinh>> listenersList = new ArrayList<ModelListener<LoaiThuTucHanhChinh>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<LoaiThuTucHanhChinh>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
