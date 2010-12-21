package com.nss.portlet.phone_book.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.phone_book.NoSuchContactBookException;
import com.nss.portlet.phone_book.model.ContactBook;
import com.nss.portlet.phone_book.model.impl.ContactBookImpl;
import com.nss.portlet.phone_book.model.impl.ContactBookModelImpl;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ContactBookPersistenceImpl extends BasePersistenceImpl
    implements ContactBookPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = ContactBookImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(ContactBookModelImpl.ENTITY_CACHE_ENABLED,
            ContactBookModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCompanyid", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_COMPANYID = new FinderPath(ContactBookModelImpl.ENTITY_CACHE_ENABLED,
            ContactBookModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCompanyid",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ContactBookModelImpl.ENTITY_CACHE_ENABLED,
            ContactBookModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByCompanyid", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ContactBookModelImpl.ENTITY_CACHE_ENABLED,
            ContactBookModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactBookModelImpl.ENTITY_CACHE_ENABLED,
            ContactBookModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_GET_DETAILBOOKS = new FinderPath(com.nss.portlet.phone_book.model.impl.DetailBookModelImpl.ENTITY_CACHE_ENABLED,
            com.nss.portlet.phone_book.model.impl.DetailBookModelImpl.FINDER_CACHE_ENABLED,
            com.nss.portlet.phone_book.service.persistence.DetailBookPersistenceImpl.FINDER_CLASS_NAME_LIST,
            "getDetailBooks",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_GET_DETAILBOOKS_SIZE = new FinderPath(com.nss.portlet.phone_book.model.impl.DetailBookModelImpl.ENTITY_CACHE_ENABLED,
            com.nss.portlet.phone_book.model.impl.DetailBookModelImpl.FINDER_CACHE_ENABLED,
            com.nss.portlet.phone_book.service.persistence.DetailBookPersistenceImpl.FINDER_CLASS_NAME_LIST,
            "getDetailBooksSize", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_CONTAINS_DETAILBOOK = new FinderPath(com.nss.portlet.phone_book.model.impl.DetailBookModelImpl.ENTITY_CACHE_ENABLED,
            com.nss.portlet.phone_book.model.impl.DetailBookModelImpl.FINDER_CACHE_ENABLED,
            com.nss.portlet.phone_book.service.persistence.DetailBookPersistenceImpl.FINDER_CLASS_NAME_LIST,
            "containsDetailBook",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _SQL_GETDETAILBOOKS = "SELECT {nss_detail_book.*} FROM nss_detail_book INNER JOIN nss_contact_book ON (nss_contact_book.contactBookId = nss_detail_book.contactBookId) WHERE (nss_contact_book.contactBookId = ?)";
    private static final String _SQL_GETDETAILBOOKSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM nss_detail_book WHERE contactBookId = ?";
    private static final String _SQL_CONTAINSDETAILBOOK = "SELECT COUNT(*) AS COUNT_VALUE FROM nss_detail_book WHERE contactBookId = ? AND detailBookId = ?";
    private static Log _log = LogFactoryUtil.getLog(ContactBookPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.phone_book.service.persistence.ContactBookPersistence.impl")
    protected com.nss.portlet.phone_book.service.persistence.ContactBookPersistence contactBookPersistence;
    @BeanReference(name = "com.nss.portlet.phone_book.service.persistence.DetailBookPersistence.impl")
    protected com.nss.portlet.phone_book.service.persistence.DetailBookPersistence detailBookPersistence;
    protected ContainsDetailBook containsDetailBook;

    public void cacheResult(ContactBook contactBook) {
        EntityCacheUtil.putResult(ContactBookModelImpl.ENTITY_CACHE_ENABLED,
            ContactBookImpl.class, contactBook.getPrimaryKey(), contactBook);
    }

    public void cacheResult(List<ContactBook> contactBooks) {
        for (ContactBook contactBook : contactBooks) {
            if (EntityCacheUtil.getResult(
                        ContactBookModelImpl.ENTITY_CACHE_ENABLED,
                        ContactBookImpl.class, contactBook.getPrimaryKey(), this) == null) {
                cacheResult(contactBook);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(ContactBookImpl.class.getName());
        EntityCacheUtil.clearCache(ContactBookImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public ContactBook create(long contactBookId) {
        ContactBook contactBook = new ContactBookImpl();

        contactBook.setNew(true);
        contactBook.setPrimaryKey(contactBookId);

        return contactBook;
    }

    public ContactBook remove(long contactBookId)
        throws NoSuchContactBookException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ContactBook contactBook = (ContactBook) session.get(ContactBookImpl.class,
                    new Long(contactBookId));

            if (contactBook == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No ContactBook exists with the primary key " +
                        contactBookId);
                }

                throw new NoSuchContactBookException(
                    "No ContactBook exists with the primary key " +
                    contactBookId);
            }

            return remove(contactBook);
        } catch (NoSuchContactBookException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public ContactBook remove(ContactBook contactBook)
        throws SystemException {
        for (ModelListener<ContactBook> listener : listeners) {
            listener.onBeforeRemove(contactBook);
        }

        contactBook = removeImpl(contactBook);

        for (ModelListener<ContactBook> listener : listeners) {
            listener.onAfterRemove(contactBook);
        }

        return contactBook;
    }

    protected ContactBook removeImpl(ContactBook contactBook)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (contactBook.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(ContactBookImpl.class,
                        contactBook.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(contactBook);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(ContactBookModelImpl.ENTITY_CACHE_ENABLED,
            ContactBookImpl.class, contactBook.getPrimaryKey());

        return contactBook;
    }

    /**
     * @deprecated Use <code>update(ContactBook contactBook, boolean merge)</code>.
     */
    public ContactBook update(ContactBook contactBook)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(ContactBook contactBook) method. Use update(ContactBook contactBook, boolean merge) instead.");
        }

        return update(contactBook, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                contactBook the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when contactBook is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public ContactBook update(ContactBook contactBook, boolean merge)
        throws SystemException {
        boolean isNew = contactBook.isNew();

        for (ModelListener<ContactBook> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(contactBook);
            } else {
                listener.onBeforeUpdate(contactBook);
            }
        }

        contactBook = updateImpl(contactBook, merge);

        for (ModelListener<ContactBook> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(contactBook);
            } else {
                listener.onAfterUpdate(contactBook);
            }
        }

        return contactBook;
    }

    public ContactBook updateImpl(
        com.nss.portlet.phone_book.model.ContactBook contactBook, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, contactBook, merge);

            contactBook.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(ContactBookModelImpl.ENTITY_CACHE_ENABLED,
            ContactBookImpl.class, contactBook.getPrimaryKey(), contactBook);

        return contactBook;
    }

    public ContactBook findByPrimaryKey(long contactBookId)
        throws NoSuchContactBookException, SystemException {
        ContactBook contactBook = fetchByPrimaryKey(contactBookId);

        if (contactBook == null) {
            if (_log.isWarnEnabled()) {
                //_log.warn("No ContactBook exists with the primary key " + contactBookId);
            }

            throw new NoSuchContactBookException(
                "No ContactBook exists with the primary key " + contactBookId);
        }

        return contactBook;
    }

    public ContactBook fetchByPrimaryKey(long contactBookId)
        throws SystemException {
        ContactBook contactBook = (ContactBook) EntityCacheUtil.getResult(ContactBookModelImpl.ENTITY_CACHE_ENABLED,
                ContactBookImpl.class, contactBookId, this);

        if (contactBook == null) {
            Session session = null;

            try {
                session = openSession();

                contactBook = (ContactBook) session.get(ContactBookImpl.class,
                        new Long(contactBookId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (contactBook != null) {
                    cacheResult(contactBook);
                }

                closeSession(session);
            }
        }

        return contactBook;
    }

    public List<ContactBook> findByCompanyid(long companyid)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(companyid) };

        List<ContactBook> list = (List<ContactBook>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.phone_book.model.ContactBook WHERE ");

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
                    list = new ArrayList<ContactBook>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<ContactBook> findByCompanyid(long companyid, int start, int end)
        throws SystemException {
        return findByCompanyid(companyid, start, end, null);
    }

    public List<ContactBook> findByCompanyid(long companyid, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(companyid),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<ContactBook> list = (List<ContactBook>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_COMPANYID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.phone_book.model.ContactBook WHERE ");

                query.append("companyid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyid);

                list = (List<ContactBook>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ContactBook>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_COMPANYID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public ContactBook findByCompanyid_First(long companyid,
        OrderByComparator obc)
        throws NoSuchContactBookException, SystemException {
        List<ContactBook> list = findByCompanyid(companyid, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ContactBook exists with the key {");

            msg.append("companyid=" + companyid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchContactBookException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ContactBook findByCompanyid_Last(long companyid,
        OrderByComparator obc)
        throws NoSuchContactBookException, SystemException {
        int count = countByCompanyid(companyid);

        List<ContactBook> list = findByCompanyid(companyid, count - 1, count,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ContactBook exists with the key {");

            msg.append("companyid=" + companyid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchContactBookException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ContactBook[] findByCompanyid_PrevAndNext(long contactBookId,
        long companyid, OrderByComparator obc)
        throws NoSuchContactBookException, SystemException {
        ContactBook contactBook = findByPrimaryKey(contactBookId);

        int count = countByCompanyid(companyid);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.phone_book.model.ContactBook WHERE ");

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
                    contactBook);

            ContactBook[] array = new ContactBookImpl[3];

            array[0] = (ContactBook) objArray[0];
            array[1] = (ContactBook) objArray[1];
            array[2] = (ContactBook) objArray[2];

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

    public List<ContactBook> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<ContactBook> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<ContactBook> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<ContactBook> list = (List<ContactBook>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.phone_book.model.ContactBook ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<ContactBook>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<ContactBook>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<ContactBook>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByCompanyid(long companyid) throws SystemException {
        for (ContactBook contactBook : findByCompanyid(companyid)) {
            remove(contactBook);
        }
    }

    public void removeAll() throws SystemException {
        for (ContactBook contactBook : findAll()) {
            remove(contactBook);
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
                    "FROM com.nss.portlet.phone_book.model.ContactBook WHERE ");

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
                        "SELECT COUNT(*) FROM com.nss.portlet.phone_book.model.ContactBook");

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

    public List<com.nss.portlet.phone_book.model.DetailBook> getDetailBooks(
        long pk) throws SystemException {
        return getDetailBooks(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    public List<com.nss.portlet.phone_book.model.DetailBook> getDetailBooks(
        long pk, int start, int end) throws SystemException {
        return getDetailBooks(pk, start, end, null);
    }

    public List<com.nss.portlet.phone_book.model.DetailBook> getDetailBooks(
        long pk, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(pk), String.valueOf(start), String.valueOf(end),
                String.valueOf(obc)
            };

        List<com.nss.portlet.phone_book.model.DetailBook> list = (List<com.nss.portlet.phone_book.model.DetailBook>) FinderCacheUtil.getResult(FINDER_PATH_GET_DETAILBOOKS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder sb = new StringBuilder();

                sb.append(_SQL_GETDETAILBOOKS);

                if (obc != null) {
                    sb.append("ORDER BY ");
                    sb.append(obc.getOrderBy());
                }

                String sql = sb.toString();

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("nss_detail_book",
                    com.nss.portlet.phone_book.model.impl.DetailBookImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<com.nss.portlet.phone_book.model.DetailBook>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<com.nss.portlet.phone_book.model.DetailBook>();
                }

                detailBookPersistence.cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_GET_DETAILBOOKS,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public int getDetailBooksSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(pk) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_DETAILBOOKS_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETDETAILBOOKSSIZE);

                q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_GET_DETAILBOOKS_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public boolean containsDetailBook(long pk, long detailBookPK)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(pk), new Long(detailBookPK) };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_DETAILBOOK,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsDetailBook.contains(pk,
                            detailBookPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_DETAILBOOK,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    public boolean containsDetailBooks(long pk) throws SystemException {
        if (getDetailBooksSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.portal.util.PropsUtil.get(
                        "value.object.listener.com.nss.portlet.phone_book.model.ContactBook")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<ContactBook>> listenersList = new ArrayList<ModelListener<ContactBook>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<ContactBook>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        containsDetailBook = new ContainsDetailBook(this);
    }

    protected class ContainsDetailBook {
        private MappingSqlQuery _mappingSqlQuery;

        protected ContainsDetailBook(ContactBookPersistenceImpl persistenceImpl) {
            super();

            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSDETAILBOOK,
                    new int[] { Types.BIGINT, Types.BIGINT }, RowMapper.COUNT);
        }

        protected boolean contains(long contactBookId, long detailBookId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(contactBookId), new Long(detailBookId)
                    });

            if (results.size() > 0) {
                Integer count = results.get(0);

                if (count.intValue() > 0) {
                    return true;
                }
            }

            return false;
        }
    }
}
