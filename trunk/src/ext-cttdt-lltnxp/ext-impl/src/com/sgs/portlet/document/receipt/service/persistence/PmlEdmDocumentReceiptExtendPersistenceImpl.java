package com.sgs.portlet.document.receipt.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptExtendException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptExtendImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptExtendModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmDocumentReceiptExtendPersistenceImpl
    extends BasePersistenceImpl
    implements PmlEdmDocumentReceiptExtendPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmDocumentReceiptExtendPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmDocumentReceiptExtend create(long documentReceiptExtendId) {
        PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend = new PmlEdmDocumentReceiptExtendImpl();

        pmlEdmDocumentReceiptExtend.setNew(true);
        pmlEdmDocumentReceiptExtend.setPrimaryKey(documentReceiptExtendId);

        return pmlEdmDocumentReceiptExtend;
    }

    public PmlEdmDocumentReceiptExtend remove(long documentReceiptExtendId)
        throws NoSuchPmlEdmDocumentReceiptExtendException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend = (PmlEdmDocumentReceiptExtend) session.get(PmlEdmDocumentReceiptExtendImpl.class,
                    new Long(documentReceiptExtendId));

            if (pmlEdmDocumentReceiptExtend == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmDocumentReceiptExtend exists with the primary key " +
                        documentReceiptExtendId);
                }

                throw new NoSuchPmlEdmDocumentReceiptExtendException(
                    "No PmlEdmDocumentReceiptExtend exists with the primary key " +
                    documentReceiptExtendId);
            }

            return remove(pmlEdmDocumentReceiptExtend);
        } catch (NoSuchPmlEdmDocumentReceiptExtendException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentReceiptExtend remove(
        PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmDocumentReceiptExtend);
            }
        }

        pmlEdmDocumentReceiptExtend = removeImpl(pmlEdmDocumentReceiptExtend);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmDocumentReceiptExtend);
            }
        }

        return pmlEdmDocumentReceiptExtend;
    }

    protected PmlEdmDocumentReceiptExtend removeImpl(
        PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmDocumentReceiptExtend);

            session.flush();

            return pmlEdmDocumentReceiptExtend;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentReceiptExtend.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend, boolean merge)</code>.
     */
    public PmlEdmDocumentReceiptExtend update(
        PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend) method. Use update(PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend, boolean merge) instead.");
        }

        return update(pmlEdmDocumentReceiptExtend, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentReceiptExtend the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentReceiptExtend is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmDocumentReceiptExtend update(
        PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmDocumentReceiptExtend.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmDocumentReceiptExtend);
                } else {
                    listener.onBeforeUpdate(pmlEdmDocumentReceiptExtend);
                }
            }
        }

        pmlEdmDocumentReceiptExtend = updateImpl(pmlEdmDocumentReceiptExtend,
                merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmDocumentReceiptExtend);
                } else {
                    listener.onAfterUpdate(pmlEdmDocumentReceiptExtend);
                }
            }
        }

        return pmlEdmDocumentReceiptExtend;
    }

    public PmlEdmDocumentReceiptExtend updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmDocumentReceiptExtend);
            } else {
                if (pmlEdmDocumentReceiptExtend.isNew()) {
                    session.save(pmlEdmDocumentReceiptExtend);
                }
            }

            session.flush();

            pmlEdmDocumentReceiptExtend.setNew(false);

            return pmlEdmDocumentReceiptExtend;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentReceiptExtend.class.getName());
        }
    }

    public PmlEdmDocumentReceiptExtend findByPrimaryKey(
        long documentReceiptExtendId)
        throws NoSuchPmlEdmDocumentReceiptExtendException, SystemException {
        PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend = fetchByPrimaryKey(documentReceiptExtendId);

        if (pmlEdmDocumentReceiptExtend == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmDocumentReceiptExtend exists with the primary key " +
                    documentReceiptExtendId);
            }

            throw new NoSuchPmlEdmDocumentReceiptExtendException(
                "No PmlEdmDocumentReceiptExtend exists with the primary key " +
                documentReceiptExtendId);
        }

        return pmlEdmDocumentReceiptExtend;
    }

    public PmlEdmDocumentReceiptExtend fetchByPrimaryKey(
        long documentReceiptExtendId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmDocumentReceiptExtend) session.get(PmlEdmDocumentReceiptExtendImpl.class,
                new Long(documentReceiptExtendId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptExtend> findByDocumentReceiptId(
        long documentReceiptId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptExtendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptExtend.class.getName();
        String finderMethodName = "findByDocumentReceiptId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentReceiptId) };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("extendorderno ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlEdmDocumentReceiptExtend> list = q.list();

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                return list;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return (List<PmlEdmDocumentReceiptExtend>) result;
        }
    }

    public List<PmlEdmDocumentReceiptExtend> findByDocumentReceiptId(
        long documentReceiptId, int start, int end) throws SystemException {
        return findByDocumentReceiptId(documentReceiptId, start, end, null);
    }

    public List<PmlEdmDocumentReceiptExtend> findByDocumentReceiptId(
        long documentReceiptId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptExtendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptExtend.class.getName();
        String finderMethodName = "findByDocumentReceiptId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("extendorderno ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlEdmDocumentReceiptExtend> list = (List<PmlEdmDocumentReceiptExtend>) QueryUtil.list(q,
                        getDialect(), start, end);

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                return list;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return (List<PmlEdmDocumentReceiptExtend>) result;
        }
    }

    public PmlEdmDocumentReceiptExtend findByDocumentReceiptId_First(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptExtendException, SystemException {
        List<PmlEdmDocumentReceiptExtend> list = findByDocumentReceiptId(documentReceiptId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptExtend exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptExtendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptExtend findByDocumentReceiptId_Last(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptExtendException, SystemException {
        int count = countByDocumentReceiptId(documentReceiptId);

        List<PmlEdmDocumentReceiptExtend> list = findByDocumentReceiptId(documentReceiptId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptExtend exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptExtendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptExtend[] findByDocumentReceiptId_PrevAndNext(
        long documentReceiptExtendId, long documentReceiptId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptExtendException, SystemException {
        PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend = findByPrimaryKey(documentReceiptExtendId);

        int count = countByDocumentReceiptId(documentReceiptId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("extendorderno ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptExtend);

            PmlEdmDocumentReceiptExtend[] array = new PmlEdmDocumentReceiptExtendImpl[3];

            array[0] = (PmlEdmDocumentReceiptExtend) objArray[0];
            array[1] = (PmlEdmDocumentReceiptExtend) objArray[1];
            array[2] = (PmlEdmDocumentReceiptExtend) objArray[2];

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

    public List<PmlEdmDocumentReceiptExtend> findAll()
        throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmDocumentReceiptExtend> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmDocumentReceiptExtend> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptExtendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptExtend.class.getName();
        String finderMethodName = "findAll";
        String[] finderParams = new String[] {
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("extendorderno ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmDocumentReceiptExtend> list = (List<PmlEdmDocumentReceiptExtend>) QueryUtil.list(q,
                        getDialect(), start, end);

                if (obc == null) {
                    Collections.sort(list);
                }

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                return list;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return (List<PmlEdmDocumentReceiptExtend>) result;
        }
    }

    public void removeByDocumentReceiptId(long documentReceiptId)
        throws SystemException {
        for (PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend : findByDocumentReceiptId(
                documentReceiptId)) {
            remove(pmlEdmDocumentReceiptExtend);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend : findAll()) {
            remove(pmlEdmDocumentReceiptExtend);
        }
    }

    public int countByDocumentReceiptId(long documentReceiptId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptExtendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptExtend.class.getName();
        String finderMethodName = "countByDocumentReceiptId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentReceiptId) };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                Long count = null;

                Iterator<Long> itr = q.list().iterator();

                if (itr.hasNext()) {
                    count = itr.next();
                }

                if (count == null) {
                    count = new Long(0);
                }

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, count);

                return count.intValue();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return ((Long) result).intValue();
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptExtendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptExtend.class.getName();
        String finderMethodName = "countAll";
        String[] finderParams = new String[] {  };
        Object[] finderArgs = new Object[] {  };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend");

                Long count = null;

                Iterator<Long> itr = q.list().iterator();

                if (itr.hasNext()) {
                    count = itr.next();
                }

                if (count == null) {
                    count = new Long(0);
                }

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, count);

                return count.intValue();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return ((Long) result).intValue();
        }
    }

    public void registerListener(ModelListener listener) {
        List<ModelListener> listeners = ListUtil.fromArray(_listeners);

        listeners.add(listener);

        _listeners = listeners.toArray(new ModelListener[listeners.size()]);
    }

    public void unregisterListener(ModelListener listener) {
        List<ModelListener> listeners = ListUtil.fromArray(_listeners);

        listeners.remove(listener);

        _listeners = listeners.toArray(new ModelListener[listeners.size()]);
    }

    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.portal.util.PropsUtil.get(
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener> listeners = new ArrayList<ModelListener>();

                for (String listenerClassName : listenerClassNames) {
                    listeners.add((ModelListener) Class.forName(
                            listenerClassName).newInstance());
                }

                _listeners = listeners.toArray(new ModelListener[listeners.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
