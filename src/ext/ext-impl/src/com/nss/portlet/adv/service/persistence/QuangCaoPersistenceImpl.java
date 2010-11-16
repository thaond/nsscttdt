package com.nss.portlet.adv.service.persistence;

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

import com.nss.portlet.adv.NoSuchQuangCaoException;
import com.nss.portlet.adv.model.QuangCao;
import com.nss.portlet.adv.model.impl.QuangCaoImpl;
import com.nss.portlet.adv.model.impl.QuangCaoModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class QuangCaoPersistenceImpl extends BasePersistenceImpl
    implements QuangCaoPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = QuangCaoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ACTIVE = new FinderPath(QuangCaoModelImpl.ENTITY_CACHE_ENABLED,
            QuangCaoModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ACTIVE = new FinderPath(QuangCaoModelImpl.ENTITY_CACHE_ENABLED,
            QuangCaoModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByActive",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ACTIVE = new FinderPath(QuangCaoModelImpl.ENTITY_CACHE_ENABLED,
            QuangCaoModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByActive", new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(QuangCaoModelImpl.ENTITY_CACHE_ENABLED,
            QuangCaoModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(QuangCaoModelImpl.ENTITY_CACHE_ENABLED,
            QuangCaoModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(QuangCaoPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.adv.service.persistence.QuangCaoPersistence.impl")
    protected com.nss.portlet.adv.service.persistence.QuangCaoPersistence quangCaoPersistence;

    public void cacheResult(QuangCao quangCao) {
        EntityCacheUtil.putResult(QuangCaoModelImpl.ENTITY_CACHE_ENABLED,
            QuangCaoImpl.class, quangCao.getPrimaryKey(), quangCao);
    }

    public void cacheResult(List<QuangCao> quangCaos) {
        for (QuangCao quangCao : quangCaos) {
            if (EntityCacheUtil.getResult(
                        QuangCaoModelImpl.ENTITY_CACHE_ENABLED,
                        QuangCaoImpl.class, quangCao.getPrimaryKey(), this) == null) {
                cacheResult(quangCao);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(QuangCaoImpl.class.getName());
        EntityCacheUtil.clearCache(QuangCaoImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public QuangCao create(long maQuangCao) {
        QuangCao quangCao = new QuangCaoImpl();

        quangCao.setNew(true);
        quangCao.setPrimaryKey(maQuangCao);

        return quangCao;
    }

    public QuangCao remove(long maQuangCao)
        throws NoSuchQuangCaoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            QuangCao quangCao = (QuangCao) session.get(QuangCaoImpl.class,
                    new Long(maQuangCao));

            if (quangCao == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No QuangCao exists with the primary key " +
                        maQuangCao);
                }

                throw new NoSuchQuangCaoException(
                    "No QuangCao exists with the primary key " + maQuangCao);
            }

            return remove(quangCao);
        } catch (NoSuchQuangCaoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public QuangCao remove(QuangCao quangCao) throws SystemException {
        for (ModelListener<QuangCao> listener : listeners) {
            listener.onBeforeRemove(quangCao);
        }

        quangCao = removeImpl(quangCao);

        for (ModelListener<QuangCao> listener : listeners) {
            listener.onAfterRemove(quangCao);
        }

        return quangCao;
    }

    protected QuangCao removeImpl(QuangCao quangCao) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (quangCao.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(QuangCaoImpl.class,
                        quangCao.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(quangCao);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(QuangCaoModelImpl.ENTITY_CACHE_ENABLED,
            QuangCaoImpl.class, quangCao.getPrimaryKey());

        return quangCao;
    }

    /**
     * @deprecated Use <code>update(QuangCao quangCao, boolean merge)</code>.
     */
    public QuangCao update(QuangCao quangCao) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(QuangCao quangCao) method. Use update(QuangCao quangCao, boolean merge) instead.");
        }

        return update(quangCao, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                quangCao the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when quangCao is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public QuangCao update(QuangCao quangCao, boolean merge)
        throws SystemException {
        boolean isNew = quangCao.isNew();

        for (ModelListener<QuangCao> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(quangCao);
            } else {
                listener.onBeforeUpdate(quangCao);
            }
        }

        quangCao = updateImpl(quangCao, merge);

        for (ModelListener<QuangCao> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(quangCao);
            } else {
                listener.onAfterUpdate(quangCao);
            }
        }

        return quangCao;
    }

    public QuangCao updateImpl(com.nss.portlet.adv.model.QuangCao quangCao,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, quangCao, merge);

            quangCao.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(QuangCaoModelImpl.ENTITY_CACHE_ENABLED,
            QuangCaoImpl.class, quangCao.getPrimaryKey(), quangCao);

        return quangCao;
    }

    public QuangCao findByPrimaryKey(long maQuangCao)
        throws NoSuchQuangCaoException, SystemException {
        QuangCao quangCao = fetchByPrimaryKey(maQuangCao);

        if (quangCao == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No QuangCao exists with the primary key " +
                    maQuangCao);
            }

            throw new NoSuchQuangCaoException(
                "No QuangCao exists with the primary key " + maQuangCao);
        }

        return quangCao;
    }

    public QuangCao fetchByPrimaryKey(long maQuangCao)
        throws SystemException {
        QuangCao quangCao = (QuangCao) EntityCacheUtil.getResult(QuangCaoModelImpl.ENTITY_CACHE_ENABLED,
                QuangCaoImpl.class, maQuangCao, this);

        if (quangCao == null) {
            Session session = null;

            try {
                session = openSession();

                quangCao = (QuangCao) session.get(QuangCaoImpl.class,
                        new Long(maQuangCao));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (quangCao != null) {
                    cacheResult(quangCao);
                }

                closeSession(session);
            }
        }

        return quangCao;
    }

    public List<QuangCao> findByActive(int active) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(active) };

        List<QuangCao> list = (List<QuangCao>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.adv.model.QuangCao WHERE ");

                query.append("active_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("thuTuQuangCao ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QuangCao>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<QuangCao> findByActive(int active, int start, int end)
        throws SystemException {
        return findByActive(active, start, end, null);
    }

    public List<QuangCao> findByActive(int active, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(active),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<QuangCao> list = (List<QuangCao>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.adv.model.QuangCao WHERE ");

                query.append("active_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("thuTuQuangCao ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(active);

                list = (List<QuangCao>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QuangCao>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public QuangCao findByActive_First(int active, OrderByComparator obc)
        throws NoSuchQuangCaoException, SystemException {
        List<QuangCao> list = findByActive(active, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QuangCao exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQuangCaoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QuangCao findByActive_Last(int active, OrderByComparator obc)
        throws NoSuchQuangCaoException, SystemException {
        int count = countByActive(active);

        List<QuangCao> list = findByActive(active, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No QuangCao exists with the key {");

            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchQuangCaoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public QuangCao[] findByActive_PrevAndNext(long maQuangCao, int active,
        OrderByComparator obc) throws NoSuchQuangCaoException, SystemException {
        QuangCao quangCao = findByPrimaryKey(maQuangCao);

        int count = countByActive(active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.nss.portlet.adv.model.QuangCao WHERE ");

            query.append("active_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("thuTuQuangCao ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, quangCao);

            QuangCao[] array = new QuangCaoImpl[3];

            array[0] = (QuangCao) objArray[0];
            array[1] = (QuangCao) objArray[1];
            array[2] = (QuangCao) objArray[2];

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

    public List<QuangCao> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<QuangCao> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<QuangCao> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<QuangCao> list = (List<QuangCao>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.adv.model.QuangCao ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("thuTuQuangCao ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<QuangCao>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<QuangCao>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<QuangCao>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByActive(int active) throws SystemException {
        for (QuangCao quangCao : findByActive(active)) {
            remove(quangCao);
        }
    }

    public void removeAll() throws SystemException {
        for (QuangCao quangCao : findAll()) {
            remove(quangCao);
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
                query.append("FROM com.nss.portlet.adv.model.QuangCao WHERE ");

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
                        "SELECT COUNT(*) FROM com.nss.portlet.adv.model.QuangCao");

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
                        "value.object.listener.com.nss.portlet.adv.model.QuangCao")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<QuangCao>> listenersList = new ArrayList<ModelListener<QuangCao>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<QuangCao>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
