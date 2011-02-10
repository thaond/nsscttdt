package com.sgs.portlet.document.send.service.persistence;

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

import com.sgs.portlet.document.send.NoSuchPmlEdmAnswerDetailException;
import com.sgs.portlet.document.send.model.PmlEdmAnswerDetail;
import com.sgs.portlet.document.send.model.impl.PmlEdmAnswerDetailImpl;
import com.sgs.portlet.document.send.model.impl.PmlEdmAnswerDetailModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmAnswerDetailPersistenceImpl extends BasePersistenceImpl
    implements PmlEdmAnswerDetailPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmAnswerDetailPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmAnswerDetail create(long documentReceiptId) {
        PmlEdmAnswerDetail pmlEdmAnswerDetail = new PmlEdmAnswerDetailImpl();

        pmlEdmAnswerDetail.setNew(true);
        pmlEdmAnswerDetail.setPrimaryKey(documentReceiptId);

        return pmlEdmAnswerDetail;
    }

    public PmlEdmAnswerDetail remove(long documentReceiptId)
        throws NoSuchPmlEdmAnswerDetailException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmAnswerDetail pmlEdmAnswerDetail = (PmlEdmAnswerDetail) session.get(PmlEdmAnswerDetailImpl.class,
                    new Long(documentReceiptId));

            if (pmlEdmAnswerDetail == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmAnswerDetail exists with the primary key " +
                        documentReceiptId);
                }

                throw new NoSuchPmlEdmAnswerDetailException(
                    "No PmlEdmAnswerDetail exists with the primary key " +
                    documentReceiptId);
            }

            return remove(pmlEdmAnswerDetail);
        } catch (NoSuchPmlEdmAnswerDetailException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmAnswerDetail remove(PmlEdmAnswerDetail pmlEdmAnswerDetail)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmAnswerDetail);
            }
        }

        pmlEdmAnswerDetail = removeImpl(pmlEdmAnswerDetail);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmAnswerDetail);
            }
        }

        return pmlEdmAnswerDetail;
    }

    protected PmlEdmAnswerDetail removeImpl(
        PmlEdmAnswerDetail pmlEdmAnswerDetail) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmAnswerDetail);

            session.flush();

            return pmlEdmAnswerDetail;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmAnswerDetail.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmAnswerDetail pmlEdmAnswerDetail, boolean merge)</code>.
     */
    public PmlEdmAnswerDetail update(PmlEdmAnswerDetail pmlEdmAnswerDetail)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmAnswerDetail pmlEdmAnswerDetail) method. Use update(PmlEdmAnswerDetail pmlEdmAnswerDetail, boolean merge) instead.");
        }

        return update(pmlEdmAnswerDetail, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmAnswerDetail the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmAnswerDetail is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmAnswerDetail update(PmlEdmAnswerDetail pmlEdmAnswerDetail,
        boolean merge) throws SystemException {
        boolean isNew = pmlEdmAnswerDetail.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmAnswerDetail);
                } else {
                    listener.onBeforeUpdate(pmlEdmAnswerDetail);
                }
            }
        }

        pmlEdmAnswerDetail = updateImpl(pmlEdmAnswerDetail, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmAnswerDetail);
                } else {
                    listener.onAfterUpdate(pmlEdmAnswerDetail);
                }
            }
        }

        return pmlEdmAnswerDetail;
    }

    public PmlEdmAnswerDetail updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmAnswerDetail pmlEdmAnswerDetail,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmAnswerDetail);
            } else {
                if (pmlEdmAnswerDetail.isNew()) {
                    session.save(pmlEdmAnswerDetail);
                }
            }

            session.flush();

            pmlEdmAnswerDetail.setNew(false);

            return pmlEdmAnswerDetail;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmAnswerDetail.class.getName());
        }
    }

    public PmlEdmAnswerDetail findByPrimaryKey(long documentReceiptId)
        throws NoSuchPmlEdmAnswerDetailException, SystemException {
        PmlEdmAnswerDetail pmlEdmAnswerDetail = fetchByPrimaryKey(documentReceiptId);

        if (pmlEdmAnswerDetail == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlEdmAnswerDetail exists with the primary key " +
                    documentReceiptId);
            }

            throw new NoSuchPmlEdmAnswerDetailException(
                "No PmlEdmAnswerDetail exists with the primary key " +
                documentReceiptId);
        }

        return pmlEdmAnswerDetail;
    }

    public PmlEdmAnswerDetail fetchByPrimaryKey(long documentReceiptId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmAnswerDetail) session.get(PmlEdmAnswerDetailImpl.class,
                new Long(documentReceiptId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmAnswerDetail> findByDocumentSendId(long documentSendId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAnswerDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAnswerDetail.class.getName();
        String finderMethodName = "findByDocumentSendId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentSendId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmAnswerDetail WHERE ");

                query.append("documentsendid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                List<PmlEdmAnswerDetail> list = q.list();

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
            return (List<PmlEdmAnswerDetail>) result;
        }
    }

    public List<PmlEdmAnswerDetail> findByDocumentSendId(long documentSendId,
        int start, int end) throws SystemException {
        return findByDocumentSendId(documentSendId, start, end, null);
    }

    public List<PmlEdmAnswerDetail> findByDocumentSendId(long documentSendId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAnswerDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAnswerDetail.class.getName();
        String finderMethodName = "findByDocumentSendId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmAnswerDetail WHERE ");

                query.append("documentsendid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                List<PmlEdmAnswerDetail> list = (List<PmlEdmAnswerDetail>) QueryUtil.list(q,
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
            return (List<PmlEdmAnswerDetail>) result;
        }
    }

    public PmlEdmAnswerDetail findByDocumentSendId_First(long documentSendId,
        OrderByComparator obc)
        throws NoSuchPmlEdmAnswerDetailException, SystemException {
        List<PmlEdmAnswerDetail> list = findByDocumentSendId(documentSendId, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAnswerDetail exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAnswerDetailException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAnswerDetail findByDocumentSendId_Last(long documentSendId,
        OrderByComparator obc)
        throws NoSuchPmlEdmAnswerDetailException, SystemException {
        int count = countByDocumentSendId(documentSendId);

        List<PmlEdmAnswerDetail> list = findByDocumentSendId(documentSendId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAnswerDetail exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAnswerDetailException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAnswerDetail[] findByDocumentSendId_PrevAndNext(
        long documentReceiptId, long documentSendId, OrderByComparator obc)
        throws NoSuchPmlEdmAnswerDetailException, SystemException {
        PmlEdmAnswerDetail pmlEdmAnswerDetail = findByPrimaryKey(documentReceiptId);

        int count = countByDocumentSendId(documentSendId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmAnswerDetail WHERE ");

            query.append("documentsendid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentSendId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmAnswerDetail);

            PmlEdmAnswerDetail[] array = new PmlEdmAnswerDetailImpl[3];

            array[0] = (PmlEdmAnswerDetail) objArray[0];
            array[1] = (PmlEdmAnswerDetail) objArray[1];
            array[2] = (PmlEdmAnswerDetail) objArray[2];

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

    public List<PmlEdmAnswerDetail> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmAnswerDetail> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmAnswerDetail> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAnswerDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAnswerDetail.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmAnswerDetail ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmAnswerDetail> list = (List<PmlEdmAnswerDetail>) QueryUtil.list(q,
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
            return (List<PmlEdmAnswerDetail>) result;
        }
    }

    public void removeByDocumentSendId(long documentSendId)
        throws SystemException {
        for (PmlEdmAnswerDetail pmlEdmAnswerDetail : findByDocumentSendId(
                documentSendId)) {
            remove(pmlEdmAnswerDetail);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmAnswerDetail pmlEdmAnswerDetail : findAll()) {
            remove(pmlEdmAnswerDetail);
        }
    }

    public int countByDocumentSendId(long documentSendId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAnswerDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAnswerDetail.class.getName();
        String finderMethodName = "countByDocumentSendId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentSendId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmAnswerDetail WHERE ");

                query.append("documentsendid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

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
        boolean finderClassNameCacheEnabled = PmlEdmAnswerDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAnswerDetail.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.send.model.PmlEdmAnswerDetail");

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
                        "value.object.listener.com.sgs.portlet.document.send.model.PmlEdmAnswerDetail")));

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
