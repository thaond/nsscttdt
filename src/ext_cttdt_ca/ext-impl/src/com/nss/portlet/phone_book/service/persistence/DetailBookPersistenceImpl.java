package com.nss.portlet.phone_book.service.persistence;

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

import com.nss.portlet.phone_book.NoSuchDetailBookException;
import com.nss.portlet.phone_book.model.DetailBook;
import com.nss.portlet.phone_book.model.impl.DetailBookImpl;
import com.nss.portlet.phone_book.model.impl.DetailBookModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DetailBookPersistenceImpl extends BasePersistenceImpl
    implements DetailBookPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = DetailBookImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(DetailBookModelImpl.ENTITY_CACHE_ENABLED,
            DetailBookModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCompanyid", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_COMPANYID = new FinderPath(DetailBookModelImpl.ENTITY_CACHE_ENABLED,
            DetailBookModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCompanyid",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(DetailBookModelImpl.ENTITY_CACHE_ENABLED,
            DetailBookModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByCompanyid", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(DetailBookModelImpl.ENTITY_CACHE_ENABLED,
            DetailBookModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DetailBookModelImpl.ENTITY_CACHE_ENABLED,
            DetailBookModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(DetailBookPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.phone_book.service.persistence.ContactBookPersistence.impl")
    protected com.nss.portlet.phone_book.service.persistence.ContactBookPersistence contactBookPersistence;
    @BeanReference(name = "com.nss.portlet.phone_book.service.persistence.DetailBookPersistence.impl")
    protected com.nss.portlet.phone_book.service.persistence.DetailBookPersistence detailBookPersistence;

    public void cacheResult(DetailBook detailBook) {
        EntityCacheUtil.putResult(DetailBookModelImpl.ENTITY_CACHE_ENABLED,
            DetailBookImpl.class, detailBook.getPrimaryKey(), detailBook);
    }

    public void cacheResult(List<DetailBook> detailBooks) {
        for (DetailBook detailBook : detailBooks) {
            if (EntityCacheUtil.getResult(
                        DetailBookModelImpl.ENTITY_CACHE_ENABLED,
                        DetailBookImpl.class, detailBook.getPrimaryKey(), this) == null) {
                cacheResult(detailBook);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(DetailBookImpl.class.getName());
        EntityCacheUtil.clearCache(DetailBookImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public DetailBook create(long detailBookId) {
        DetailBook detailBook = new DetailBookImpl();

        detailBook.setNew(true);
        detailBook.setPrimaryKey(detailBookId);

        return detailBook;
    }

    public DetailBook remove(long detailBookId)
        throws NoSuchDetailBookException, SystemException {
        Session session = null;

        try {
            session = openSession();

            DetailBook detailBook = (DetailBook) session.get(DetailBookImpl.class,
                    new Long(detailBookId));

            if (detailBook == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No DetailBook exists with the primary key " +
                        detailBookId);
                }

                throw new NoSuchDetailBookException(
                    "No DetailBook exists with the primary key " +
                    detailBookId);
            }

            return remove(detailBook);
        } catch (NoSuchDetailBookException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public DetailBook remove(DetailBook detailBook) throws SystemException {
        for (ModelListener<DetailBook> listener : listeners) {
            listener.onBeforeRemove(detailBook);
        }

        detailBook = removeImpl(detailBook);

        for (ModelListener<DetailBook> listener : listeners) {
            listener.onAfterRemove(detailBook);
        }

        return detailBook;
    }

    protected DetailBook removeImpl(DetailBook detailBook)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (detailBook.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(DetailBookImpl.class,
                        detailBook.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(detailBook);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(DetailBookModelImpl.ENTITY_CACHE_ENABLED,
            DetailBookImpl.class, detailBook.getPrimaryKey());

        return detailBook;
    }

    /**
     * @deprecated Use <code>update(DetailBook detailBook, boolean merge)</code>.
     */
    public DetailBook update(DetailBook detailBook) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(DetailBook detailBook) method. Use update(DetailBook detailBook, boolean merge) instead.");
        }

        return update(detailBook, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                detailBook the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when detailBook is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public DetailBook update(DetailBook detailBook, boolean merge)
        throws SystemException {
        boolean isNew = detailBook.isNew();

        for (ModelListener<DetailBook> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(detailBook);
            } else {
                listener.onBeforeUpdate(detailBook);
            }
        }

        detailBook = updateImpl(detailBook, merge);

        for (ModelListener<DetailBook> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(detailBook);
            } else {
                listener.onAfterUpdate(detailBook);
            }
        }

        return detailBook;
    }

    public DetailBook updateImpl(
        com.nss.portlet.phone_book.model.DetailBook detailBook, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, detailBook, merge);

            detailBook.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(DetailBookModelImpl.ENTITY_CACHE_ENABLED,
            DetailBookImpl.class, detailBook.getPrimaryKey(), detailBook);

        return detailBook;
    }

    public DetailBook findByPrimaryKey(long detailBookId)
        throws NoSuchDetailBookException, SystemException {
        DetailBook detailBook = fetchByPrimaryKey(detailBookId);

        if (detailBook == null) {
            if (_log.isWarnEnabled()) {
                //_log.warn("No DetailBook exists with the primary key " + detailBookId);
            }

            throw new NoSuchDetailBookException(
                "No DetailBook exists with the primary key " + detailBookId);
        }

        return detailBook;
    }

    public DetailBook fetchByPrimaryKey(long detailBookId)
        throws SystemException {
        DetailBook detailBook = (DetailBook) EntityCacheUtil.getResult(DetailBookModelImpl.ENTITY_CACHE_ENABLED,
                DetailBookImpl.class, detailBookId, this);

        if (detailBook == null) {
            Session session = null;

            try {
                session = openSession();

                detailBook = (DetailBook) session.get(DetailBookImpl.class,
                        new Long(detailBookId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (detailBook != null) {
                    cacheResult(detailBook);
                }

                closeSession(session);
            }
        }

        return detailBook;
    }

    public List<DetailBook> findByCompanyid(long companyid)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(companyid) };

        List<DetailBook> list = (List<DetailBook>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.phone_book.model.DetailBook WHERE ");

                query.append("companyid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyid);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<DetailBook>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<DetailBook> findByCompanyid(long companyid, int start, int end)
        throws SystemException {
        return findByCompanyid(companyid, start, end, null);
    }

    public List<DetailBook> findByCompanyid(long companyid, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(companyid),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<DetailBook> list = (List<DetailBook>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_COMPANYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.phone_book.model.DetailBook WHERE ");

                query.append("companyid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyid);

                list = (List<DetailBook>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<DetailBook>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_COMPANYID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public DetailBook findByCompanyid_First(long companyid,
        OrderByComparator obc)
        throws NoSuchDetailBookException, SystemException {
        List<DetailBook> list = findByCompanyid(companyid, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No DetailBook exists with the key {");

            msg.append("companyid=" + companyid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDetailBookException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public DetailBook findByCompanyid_Last(long companyid, OrderByComparator obc)
        throws NoSuchDetailBookException, SystemException {
        int count = countByCompanyid(companyid);

        List<DetailBook> list = findByCompanyid(companyid, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No DetailBook exists with the key {");

            msg.append("companyid=" + companyid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchDetailBookException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public DetailBook[] findByCompanyid_PrevAndNext(long detailBookId,
        long companyid, OrderByComparator obc)
        throws NoSuchDetailBookException, SystemException {
        DetailBook detailBook = findByPrimaryKey(detailBookId);

        int count = countByCompanyid(companyid);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.phone_book.model.DetailBook WHERE ");

            query.append("companyid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(companyid);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    detailBook);

            DetailBook[] array = new DetailBookImpl[3];

            array[0] = (DetailBook) objArray[0];
            array[1] = (DetailBook) objArray[1];
            array[2] = (DetailBook) objArray[2];

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

    public List<DetailBook> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<DetailBook> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<DetailBook> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<DetailBook> list = (List<DetailBook>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.phone_book.model.DetailBook ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<DetailBook>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<DetailBook>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<DetailBook>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByCompanyid(long companyid) throws SystemException {
        for (DetailBook detailBook : findByCompanyid(companyid)) {
            remove(detailBook);
        }
    }

    public void removeAll() throws SystemException {
        for (DetailBook detailBook : findAll()) {
            remove(detailBook);
        }
    }

    public int countByCompanyid(long companyid) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(companyid) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.phone_book.model.DetailBook WHERE ");

                query.append("companyid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyid);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.phone_book.model.DetailBook");

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
                        "value.object.listener.com.nss.portlet.phone_book.model.DetailBook")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<DetailBook>> listenersList = new ArrayList<ModelListener<DetailBook>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<DetailBook>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
