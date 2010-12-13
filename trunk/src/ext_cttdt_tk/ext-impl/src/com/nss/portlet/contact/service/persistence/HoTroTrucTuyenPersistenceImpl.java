package com.nss.portlet.contact.service.persistence;

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

import com.nss.portlet.contact.NoSuchHoTroTrucTuyenException;
import com.nss.portlet.contact.model.HoTroTrucTuyen;
import com.nss.portlet.contact.model.impl.HoTroTrucTuyenImpl;
import com.nss.portlet.contact.model.impl.HoTroTrucTuyenModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HoTroTrucTuyenPersistenceImpl extends BasePersistenceImpl
    implements HoTroTrucTuyenPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = HoTroTrucTuyenImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(HoTroTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
            HoTroTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(HoTroTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
            HoTroTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(HoTroTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
            HoTroTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByActive",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(HoTroTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
            HoTroTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(HoTroTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
            HoTroTrucTuyenModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(HoTroTrucTuyenPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.contact.service.persistence.HoTroTrucTuyenPersistence.impl")
    protected com.nss.portlet.contact.service.persistence.HoTroTrucTuyenPersistence hoTroTrucTuyenPersistence;

    public void cacheResult(HoTroTrucTuyen hoTroTrucTuyen) {
        EntityCacheUtil.putResult(HoTroTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
            HoTroTrucTuyenImpl.class, hoTroTrucTuyen.getPrimaryKey(),
            hoTroTrucTuyen);
    }

    public void cacheResult(List<HoTroTrucTuyen> hoTroTrucTuyens) {
        for (HoTroTrucTuyen hoTroTrucTuyen : hoTroTrucTuyens) {
            if (EntityCacheUtil.getResult(
                        HoTroTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
                        HoTroTrucTuyenImpl.class,
                        hoTroTrucTuyen.getPrimaryKey(), this) == null) {
                cacheResult(hoTroTrucTuyen);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(HoTroTrucTuyenImpl.class.getName());
        EntityCacheUtil.clearCache(HoTroTrucTuyenImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public HoTroTrucTuyen create(int maHoTroTrucTuyen) {
        HoTroTrucTuyen hoTroTrucTuyen = new HoTroTrucTuyenImpl();

        hoTroTrucTuyen.setNew(true);
        hoTroTrucTuyen.setPrimaryKey(maHoTroTrucTuyen);

        return hoTroTrucTuyen;
    }

    public HoTroTrucTuyen remove(int maHoTroTrucTuyen)
        throws NoSuchHoTroTrucTuyenException, SystemException {
        Session session = null;

        try {
            session = openSession();

            HoTroTrucTuyen hoTroTrucTuyen = (HoTroTrucTuyen) session.get(HoTroTrucTuyenImpl.class,
                    new Integer(maHoTroTrucTuyen));

            if (hoTroTrucTuyen == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No HoTroTrucTuyen exists with the primary key " +
                        maHoTroTrucTuyen);
                }

                throw new NoSuchHoTroTrucTuyenException(
                    "No HoTroTrucTuyen exists with the primary key " +
                    maHoTroTrucTuyen);
            }

            return remove(hoTroTrucTuyen);
        } catch (NoSuchHoTroTrucTuyenException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public HoTroTrucTuyen remove(HoTroTrucTuyen hoTroTrucTuyen)
        throws SystemException {
        for (ModelListener<HoTroTrucTuyen> listener : listeners) {
            listener.onBeforeRemove(hoTroTrucTuyen);
        }

        hoTroTrucTuyen = removeImpl(hoTroTrucTuyen);

        for (ModelListener<HoTroTrucTuyen> listener : listeners) {
            listener.onAfterRemove(hoTroTrucTuyen);
        }

        return hoTroTrucTuyen;
    }

    protected HoTroTrucTuyen removeImpl(HoTroTrucTuyen hoTroTrucTuyen)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (hoTroTrucTuyen.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(HoTroTrucTuyenImpl.class,
                        hoTroTrucTuyen.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(hoTroTrucTuyen);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(HoTroTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
            HoTroTrucTuyenImpl.class, hoTroTrucTuyen.getPrimaryKey());

        return hoTroTrucTuyen;
    }

    /**
     * @deprecated Use <code>update(HoTroTrucTuyen hoTroTrucTuyen, boolean merge)</code>.
     */
    public HoTroTrucTuyen update(HoTroTrucTuyen hoTroTrucTuyen)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(HoTroTrucTuyen hoTroTrucTuyen) method. Use update(HoTroTrucTuyen hoTroTrucTuyen, boolean merge) instead.");
        }

        return update(hoTroTrucTuyen, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                hoTroTrucTuyen the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when hoTroTrucTuyen is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public HoTroTrucTuyen update(HoTroTrucTuyen hoTroTrucTuyen, boolean merge)
        throws SystemException {
        boolean isNew = hoTroTrucTuyen.isNew();

        for (ModelListener<HoTroTrucTuyen> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(hoTroTrucTuyen);
            } else {
                listener.onBeforeUpdate(hoTroTrucTuyen);
            }
        }

        hoTroTrucTuyen = updateImpl(hoTroTrucTuyen, merge);

        for (ModelListener<HoTroTrucTuyen> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(hoTroTrucTuyen);
            } else {
                listener.onAfterUpdate(hoTroTrucTuyen);
            }
        }

        return hoTroTrucTuyen;
    }

    public HoTroTrucTuyen updateImpl(
        com.nss.portlet.contact.model.HoTroTrucTuyen hoTroTrucTuyen,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, hoTroTrucTuyen, merge);

            hoTroTrucTuyen.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(HoTroTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
            HoTroTrucTuyenImpl.class, hoTroTrucTuyen.getPrimaryKey(),
            hoTroTrucTuyen);

        return hoTroTrucTuyen;
    }

    public HoTroTrucTuyen findByPrimaryKey(int maHoTroTrucTuyen)
        throws NoSuchHoTroTrucTuyenException, SystemException {
        HoTroTrucTuyen hoTroTrucTuyen = fetchByPrimaryKey(maHoTroTrucTuyen);

        if (hoTroTrucTuyen == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No HoTroTrucTuyen exists with the primary key " +
                    maHoTroTrucTuyen);
            }

            throw new NoSuchHoTroTrucTuyenException(
                "No HoTroTrucTuyen exists with the primary key " +
                maHoTroTrucTuyen);
        }

        return hoTroTrucTuyen;
    }

    public HoTroTrucTuyen fetchByPrimaryKey(int maHoTroTrucTuyen)
        throws SystemException {
        HoTroTrucTuyen hoTroTrucTuyen = (HoTroTrucTuyen) EntityCacheUtil.getResult(HoTroTrucTuyenModelImpl.ENTITY_CACHE_ENABLED,
                HoTroTrucTuyenImpl.class, maHoTroTrucTuyen, this);

        if (hoTroTrucTuyen == null) {
            Session session = null;

            try {
                session = openSession();

                hoTroTrucTuyen = (HoTroTrucTuyen) session.get(HoTroTrucTuyenImpl.class,
                        new Integer(maHoTroTrucTuyen));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (hoTroTrucTuyen != null) {
                    cacheResult(hoTroTrucTuyen);
                }

                closeSession(session);
            }
        }

        return hoTroTrucTuyen;
    }

    public List<HoTroTrucTuyen> findByActive(int active)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<HoTroTrucTuyen> list = (List<HoTroTrucTuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.contact.model.HoTroTrucTuyen WHERE ");

                query.append("active = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("order_ ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<HoTroTrucTuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<HoTroTrucTuyen> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<HoTroTrucTuyen> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<HoTroTrucTuyen> list = (List<HoTroTrucTuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.contact.model.HoTroTrucTuyen WHERE ");

                query.append("active = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("order_ ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<HoTroTrucTuyen>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<HoTroTrucTuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public HoTroTrucTuyen findByActive_First(int active, OrderByComparator obc)
        throws NoSuchHoTroTrucTuyenException, SystemException {
        List<HoTroTrucTuyen> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No HoTroTrucTuyen exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchHoTroTrucTuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public HoTroTrucTuyen findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchHoTroTrucTuyenException, SystemException {
        int count = countByActive(active);

        List<HoTroTrucTuyen> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No HoTroTrucTuyen exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchHoTroTrucTuyenException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public HoTroTrucTuyen[] findByActive_PrevAndNext(int maHoTroTrucTuyen,
        int active, OrderByComparator obc)
        throws NoSuchHoTroTrucTuyenException, SystemException {
        HoTroTrucTuyen hoTroTrucTuyen = findByPrimaryKey(maHoTroTrucTuyen);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.contact.model.HoTroTrucTuyen WHERE ");

            query.append("active = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("order_ ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    hoTroTrucTuyen);

            HoTroTrucTuyen[] array = new HoTroTrucTuyenImpl[3];

            array[0] = (HoTroTrucTuyen) objArray[0];
            array[1] = (HoTroTrucTuyen) objArray[1];
            array[2] = (HoTroTrucTuyen) objArray[2];

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

    public List<HoTroTrucTuyen> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<HoTroTrucTuyen> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<HoTroTrucTuyen> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<HoTroTrucTuyen> list = (List<HoTroTrucTuyen>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.contact.model.HoTroTrucTuyen ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("order_ ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<HoTroTrucTuyen>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<HoTroTrucTuyen>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<HoTroTrucTuyen>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (HoTroTrucTuyen hoTroTrucTuyen : findByActive(active)) {
            remove(hoTroTrucTuyen);
        }
    }

    public void removeAll() throws SystemException {
        for (HoTroTrucTuyen hoTroTrucTuyen : findAll()) {
            remove(hoTroTrucTuyen);
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
                    "FROM com.nss.portlet.contact.model.HoTroTrucTuyen WHERE ");

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
                        "SELECT COUNT(*) FROM com.nss.portlet.contact.model.HoTroTrucTuyen");

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
                        "value.object.listener.com.nss.portlet.contact.model.HoTroTrucTuyen")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<HoTroTrucTuyen>> listenersList = new ArrayList<ModelListener<HoTroTrucTuyen>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<HoTroTrucTuyen>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
