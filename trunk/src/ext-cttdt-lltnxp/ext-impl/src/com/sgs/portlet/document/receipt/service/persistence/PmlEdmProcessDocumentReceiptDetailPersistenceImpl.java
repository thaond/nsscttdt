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

import com.sgs.portlet.document.receipt.NoSuchPmlEdmProcessDocumentReceiptDetailException;
import com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmProcessDocumentReceiptDetailImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmProcessDocumentReceiptDetailModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmProcessDocumentReceiptDetailPersistenceImpl
    extends BasePersistenceImpl
    implements PmlEdmProcessDocumentReceiptDetailPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmProcessDocumentReceiptDetailPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmProcessDocumentReceiptDetail create(long id) {
        PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail = new PmlEdmProcessDocumentReceiptDetailImpl();

        pmlEdmProcessDocumentReceiptDetail.setNew(true);
        pmlEdmProcessDocumentReceiptDetail.setPrimaryKey(id);

        return pmlEdmProcessDocumentReceiptDetail;
    }

    public PmlEdmProcessDocumentReceiptDetail remove(long id)
        throws NoSuchPmlEdmProcessDocumentReceiptDetailException,
            SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail =
                (PmlEdmProcessDocumentReceiptDetail) session.get(PmlEdmProcessDocumentReceiptDetailImpl.class,
                    new Long(id));

            if (pmlEdmProcessDocumentReceiptDetail == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmProcessDocumentReceiptDetail exists with the primary key " +
                        id);
                }

                throw new NoSuchPmlEdmProcessDocumentReceiptDetailException(
                    "No PmlEdmProcessDocumentReceiptDetail exists with the primary key " +
                    id);
            }

            return remove(pmlEdmProcessDocumentReceiptDetail);
        } catch (NoSuchPmlEdmProcessDocumentReceiptDetailException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmProcessDocumentReceiptDetail remove(
        PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmProcessDocumentReceiptDetail);
            }
        }

        pmlEdmProcessDocumentReceiptDetail = removeImpl(pmlEdmProcessDocumentReceiptDetail);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmProcessDocumentReceiptDetail);
            }
        }

        return pmlEdmProcessDocumentReceiptDetail;
    }

    protected PmlEdmProcessDocumentReceiptDetail removeImpl(
        PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmProcessDocumentReceiptDetail);

            session.flush();

            return pmlEdmProcessDocumentReceiptDetail;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmProcessDocumentReceiptDetail.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail, boolean merge)</code>.
     */
    public PmlEdmProcessDocumentReceiptDetail update(
        PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail) method. Use update(PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail, boolean merge) instead.");
        }

        return update(pmlEdmProcessDocumentReceiptDetail, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmProcessDocumentReceiptDetail the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmProcessDocumentReceiptDetail is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmProcessDocumentReceiptDetail update(
        PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail,
        boolean merge) throws SystemException {
        boolean isNew = pmlEdmProcessDocumentReceiptDetail.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmProcessDocumentReceiptDetail);
                } else {
                    listener.onBeforeUpdate(pmlEdmProcessDocumentReceiptDetail);
                }
            }
        }

        pmlEdmProcessDocumentReceiptDetail = updateImpl(pmlEdmProcessDocumentReceiptDetail,
                merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmProcessDocumentReceiptDetail);
                } else {
                    listener.onAfterUpdate(pmlEdmProcessDocumentReceiptDetail);
                }
            }
        }

        return pmlEdmProcessDocumentReceiptDetail;
    }

    public PmlEdmProcessDocumentReceiptDetail updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmProcessDocumentReceiptDetail);
            } else {
                if (pmlEdmProcessDocumentReceiptDetail.isNew()) {
                    session.save(pmlEdmProcessDocumentReceiptDetail);
                }
            }

            session.flush();

            pmlEdmProcessDocumentReceiptDetail.setNew(false);

            return pmlEdmProcessDocumentReceiptDetail;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmProcessDocumentReceiptDetail.class.getName());
        }
    }

    public PmlEdmProcessDocumentReceiptDetail findByPrimaryKey(long id)
        throws NoSuchPmlEdmProcessDocumentReceiptDetailException,
            SystemException {
        PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail = fetchByPrimaryKey(id);

        if (pmlEdmProcessDocumentReceiptDetail == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmProcessDocumentReceiptDetail exists with the primary key " +
                    id);
            }

            throw new NoSuchPmlEdmProcessDocumentReceiptDetailException(
                "No PmlEdmProcessDocumentReceiptDetail exists with the primary key " +
                id);
        }

        return pmlEdmProcessDocumentReceiptDetail;
    }

    public PmlEdmProcessDocumentReceiptDetail fetchByPrimaryKey(long id)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmProcessDocumentReceiptDetail) session.get(PmlEdmProcessDocumentReceiptDetailImpl.class,
                new Long(id));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmProcessDocumentReceiptDetail> findByDocumentReceiptId(
        long documentReceiptId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmProcessDocumentReceiptDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmProcessDocumentReceiptDetail.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlEdmProcessDocumentReceiptDetail> list = q.list();

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
            return (List<PmlEdmProcessDocumentReceiptDetail>) result;
        }
    }

    public List<PmlEdmProcessDocumentReceiptDetail> findByDocumentReceiptId(
        long documentReceiptId, int start, int end) throws SystemException {
        return findByDocumentReceiptId(documentReceiptId, start, end, null);
    }

    public List<PmlEdmProcessDocumentReceiptDetail> findByDocumentReceiptId(
        long documentReceiptId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmProcessDocumentReceiptDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmProcessDocumentReceiptDetail.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlEdmProcessDocumentReceiptDetail> list = (List<PmlEdmProcessDocumentReceiptDetail>) QueryUtil.list(q,
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
            return (List<PmlEdmProcessDocumentReceiptDetail>) result;
        }
    }

    public PmlEdmProcessDocumentReceiptDetail findByDocumentReceiptId_First(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchPmlEdmProcessDocumentReceiptDetailException,
            SystemException {
        List<PmlEdmProcessDocumentReceiptDetail> list = findByDocumentReceiptId(documentReceiptId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append(
                "No PmlEdmProcessDocumentReceiptDetail exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmProcessDocumentReceiptDetailException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmProcessDocumentReceiptDetail findByDocumentReceiptId_Last(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchPmlEdmProcessDocumentReceiptDetailException,
            SystemException {
        int count = countByDocumentReceiptId(documentReceiptId);

        List<PmlEdmProcessDocumentReceiptDetail> list = findByDocumentReceiptId(documentReceiptId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append(
                "No PmlEdmProcessDocumentReceiptDetail exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmProcessDocumentReceiptDetailException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmProcessDocumentReceiptDetail[] findByDocumentReceiptId_PrevAndNext(
        long id, long documentReceiptId, OrderByComparator obc)
        throws NoSuchPmlEdmProcessDocumentReceiptDetailException,
            SystemException {
        PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail = findByPrimaryKey(id);

        int count = countByDocumentReceiptId(documentReceiptId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmProcessDocumentReceiptDetail);

            PmlEdmProcessDocumentReceiptDetail[] array = new PmlEdmProcessDocumentReceiptDetailImpl[3];

            array[0] = (PmlEdmProcessDocumentReceiptDetail) objArray[0];
            array[1] = (PmlEdmProcessDocumentReceiptDetail) objArray[1];
            array[2] = (PmlEdmProcessDocumentReceiptDetail) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmProcessDocumentReceiptDetail> findByUserId(long userId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmProcessDocumentReceiptDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmProcessDocumentReceiptDetail.class.getName();
        String finderMethodName = "findByUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(userId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail WHERE ");

                query.append("userid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<PmlEdmProcessDocumentReceiptDetail> list = q.list();

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
            return (List<PmlEdmProcessDocumentReceiptDetail>) result;
        }
    }

    public List<PmlEdmProcessDocumentReceiptDetail> findByUserId(long userId,
        int start, int end) throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    public List<PmlEdmProcessDocumentReceiptDetail> findByUserId(long userId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmProcessDocumentReceiptDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmProcessDocumentReceiptDetail.class.getName();
        String finderMethodName = "findByUserId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(userId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail WHERE ");

                query.append("userid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<PmlEdmProcessDocumentReceiptDetail> list = (List<PmlEdmProcessDocumentReceiptDetail>) QueryUtil.list(q,
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
            return (List<PmlEdmProcessDocumentReceiptDetail>) result;
        }
    }

    public PmlEdmProcessDocumentReceiptDetail findByUserId_First(long userId,
        OrderByComparator obc)
        throws NoSuchPmlEdmProcessDocumentReceiptDetailException,
            SystemException {
        List<PmlEdmProcessDocumentReceiptDetail> list = findByUserId(userId, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append(
                "No PmlEdmProcessDocumentReceiptDetail exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmProcessDocumentReceiptDetailException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmProcessDocumentReceiptDetail findByUserId_Last(long userId,
        OrderByComparator obc)
        throws NoSuchPmlEdmProcessDocumentReceiptDetailException,
            SystemException {
        int count = countByUserId(userId);

        List<PmlEdmProcessDocumentReceiptDetail> list = findByUserId(userId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append(
                "No PmlEdmProcessDocumentReceiptDetail exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmProcessDocumentReceiptDetailException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmProcessDocumentReceiptDetail[] findByUserId_PrevAndNext(
        long id, long userId, OrderByComparator obc)
        throws NoSuchPmlEdmProcessDocumentReceiptDetailException,
            SystemException {
        PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail = findByPrimaryKey(id);

        int count = countByUserId(userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail WHERE ");

            query.append("userid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmProcessDocumentReceiptDetail);

            PmlEdmProcessDocumentReceiptDetail[] array = new PmlEdmProcessDocumentReceiptDetailImpl[3];

            array[0] = (PmlEdmProcessDocumentReceiptDetail) objArray[0];
            array[1] = (PmlEdmProcessDocumentReceiptDetail) objArray[1];
            array[2] = (PmlEdmProcessDocumentReceiptDetail) objArray[2];

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

    public List<PmlEdmProcessDocumentReceiptDetail> findAll()
        throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmProcessDocumentReceiptDetail> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmProcessDocumentReceiptDetail> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmProcessDocumentReceiptDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmProcessDocumentReceiptDetail.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmProcessDocumentReceiptDetail> list = (List<PmlEdmProcessDocumentReceiptDetail>) QueryUtil.list(q,
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
            return (List<PmlEdmProcessDocumentReceiptDetail>) result;
        }
    }

    public void removeByDocumentReceiptId(long documentReceiptId)
        throws SystemException {
        for (PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail : findByDocumentReceiptId(
                documentReceiptId)) {
            remove(pmlEdmProcessDocumentReceiptDetail);
        }
    }

    public void removeByUserId(long userId) throws SystemException {
        for (PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail : findByUserId(
                userId)) {
            remove(pmlEdmProcessDocumentReceiptDetail);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmProcessDocumentReceiptDetail pmlEdmProcessDocumentReceiptDetail : findAll()) {
            remove(pmlEdmProcessDocumentReceiptDetail);
        }
    }

    public int countByDocumentReceiptId(long documentReceiptId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmProcessDocumentReceiptDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmProcessDocumentReceiptDetail.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail WHERE ");

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

    public int countByUserId(long userId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmProcessDocumentReceiptDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmProcessDocumentReceiptDetail.class.getName();
        String finderMethodName = "countByUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(userId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail WHERE ");

                query.append("userid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

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
        boolean finderClassNameCacheEnabled = PmlEdmProcessDocumentReceiptDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmProcessDocumentReceiptDetail.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmProcessDocumentReceiptDetail")));

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
