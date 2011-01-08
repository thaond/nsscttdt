package com.sgs.portlet.document.receipt.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.document.receipt.NoSuchPmlEdmBookDocumentRecordToException;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmBookDocumentRecordToImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmBookDocumentRecordToModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlEdmBookDocumentRecordToPersistenceImpl
    extends BasePersistenceImpl implements PmlEdmBookDocumentRecordToPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmBookDocumentRecordToPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmBookDocumentRecordTo create(
        PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK) {
        PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo = new PmlEdmBookDocumentRecordToImpl();

        pmlEdmBookDocumentRecordTo.setNew(true);
        pmlEdmBookDocumentRecordTo.setPrimaryKey(pmlEdmBookDocumentRecordToPK);

        return pmlEdmBookDocumentRecordTo;
    }

    public PmlEdmBookDocumentRecordTo remove(
        PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo = (PmlEdmBookDocumentRecordTo) session.get(PmlEdmBookDocumentRecordToImpl.class,
                    pmlEdmBookDocumentRecordToPK);

            if (pmlEdmBookDocumentRecordTo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmBookDocumentRecordTo exists with the primary key " +
                        pmlEdmBookDocumentRecordToPK);
                }

                throw new NoSuchPmlEdmBookDocumentRecordToException(
                    "No PmlEdmBookDocumentRecordTo exists with the primary key " +
                    pmlEdmBookDocumentRecordToPK);
            }

            return remove(pmlEdmBookDocumentRecordTo);
        } catch (NoSuchPmlEdmBookDocumentRecordToException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmBookDocumentRecordTo remove(
        PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmBookDocumentRecordTo);
            }
        }

        pmlEdmBookDocumentRecordTo = removeImpl(pmlEdmBookDocumentRecordTo);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmBookDocumentRecordTo);
            }
        }

        return pmlEdmBookDocumentRecordTo;
    }

    protected PmlEdmBookDocumentRecordTo removeImpl(
        PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmBookDocumentRecordTo);

            session.flush();

            return pmlEdmBookDocumentRecordTo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmBookDocumentRecordTo.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo, boolean merge)</code>.
     */
    public PmlEdmBookDocumentRecordTo update(
        PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo) method. Use update(PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo, boolean merge) instead.");
        }

        return update(pmlEdmBookDocumentRecordTo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmBookDocumentRecordTo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmBookDocumentRecordTo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmBookDocumentRecordTo update(
        PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmBookDocumentRecordTo.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmBookDocumentRecordTo);
                } else {
                    listener.onBeforeUpdate(pmlEdmBookDocumentRecordTo);
                }
            }
        }

        pmlEdmBookDocumentRecordTo = updateImpl(pmlEdmBookDocumentRecordTo,
                merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmBookDocumentRecordTo);
                } else {
                    listener.onAfterUpdate(pmlEdmBookDocumentRecordTo);
                }
            }
        }

        return pmlEdmBookDocumentRecordTo;
    }

    public PmlEdmBookDocumentRecordTo updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmBookDocumentRecordTo);
            } else {
                if (pmlEdmBookDocumentRecordTo.isNew()) {
                    session.save(pmlEdmBookDocumentRecordTo);
                }
            }

            session.flush();

            pmlEdmBookDocumentRecordTo.setNew(false);

            return pmlEdmBookDocumentRecordTo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmBookDocumentRecordTo.class.getName());
        }
    }

    public PmlEdmBookDocumentRecordTo findByPrimaryKey(
        PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo = fetchByPrimaryKey(pmlEdmBookDocumentRecordToPK);

        if (pmlEdmBookDocumentRecordTo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmBookDocumentRecordTo exists with the primary key " +
                    pmlEdmBookDocumentRecordToPK);
            }

            throw new NoSuchPmlEdmBookDocumentRecordToException(
                "No PmlEdmBookDocumentRecordTo exists with the primary key " +
                pmlEdmBookDocumentRecordToPK);
        }

        return pmlEdmBookDocumentRecordTo;
    }

    public PmlEdmBookDocumentRecordTo fetchByPrimaryKey(
        PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmBookDocumentRecordTo) session.get(PmlEdmBookDocumentRecordToImpl.class,
                pmlEdmBookDocumentRecordToPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentRecordTo> findByDocumentReceiptId(
        long documentReceiptId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlEdmBookDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmBookDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmBookDocumentRecordTo> findByDocumentReceiptId(
        long documentReceiptId, int start, int end) throws SystemException {
        return findByDocumentReceiptId(documentReceiptId, start, end, null);
    }

    public List<PmlEdmBookDocumentRecordTo> findByDocumentReceiptId(
        long documentReceiptId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlEdmBookDocumentRecordTo> list = (List<PmlEdmBookDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentRecordTo>) result;
        }
    }

    public PmlEdmBookDocumentRecordTo findByDocumentReceiptId_First(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        List<PmlEdmBookDocumentRecordTo> list = findByDocumentReceiptId(documentReceiptId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentRecordTo exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentRecordTo findByDocumentReceiptId_Last(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        int count = countByDocumentReceiptId(documentReceiptId);

        List<PmlEdmBookDocumentRecordTo> list = findByDocumentReceiptId(documentReceiptId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentRecordTo exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentRecordTo[] findByDocumentReceiptId_PrevAndNext(
        PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo = findByPrimaryKey(pmlEdmBookDocumentRecordToPK);

        int count = countByDocumentReceiptId(documentReceiptId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentRecordTo);

            PmlEdmBookDocumentRecordTo[] array = new PmlEdmBookDocumentRecordToImpl[3];

            array[0] = (PmlEdmBookDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmBookDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmBookDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentRecordTo> findByDocumentRecordToId(
        long documentRecordToId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
        String finderMethodName = "findByDocumentRecordToId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentRecordToId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                query.append("documentrecordtoid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordToId);

                List<PmlEdmBookDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmBookDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmBookDocumentRecordTo> findByDocumentRecordToId(
        long documentRecordToId, int start, int end) throws SystemException {
        return findByDocumentRecordToId(documentRecordToId, start, end, null);
    }

    public List<PmlEdmBookDocumentRecordTo> findByDocumentRecordToId(
        long documentRecordToId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
        String finderMethodName = "findByDocumentRecordToId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentRecordToId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                query.append("documentrecordtoid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordToId);

                List<PmlEdmBookDocumentRecordTo> list = (List<PmlEdmBookDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentRecordTo>) result;
        }
    }

    public PmlEdmBookDocumentRecordTo findByDocumentRecordToId_First(
        long documentRecordToId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        List<PmlEdmBookDocumentRecordTo> list = findByDocumentRecordToId(documentRecordToId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentRecordTo exists with the key {");

            msg.append("documentRecordToId=" + documentRecordToId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentRecordTo findByDocumentRecordToId_Last(
        long documentRecordToId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        int count = countByDocumentRecordToId(documentRecordToId);

        List<PmlEdmBookDocumentRecordTo> list = findByDocumentRecordToId(documentRecordToId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentRecordTo exists with the key {");

            msg.append("documentRecordToId=" + documentRecordToId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentRecordTo[] findByDocumentRecordToId_PrevAndNext(
        PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        long documentRecordToId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo = findByPrimaryKey(pmlEdmBookDocumentRecordToPK);

        int count = countByDocumentRecordToId(documentRecordToId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

            query.append("documentrecordtoid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentRecordToId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentRecordTo);

            PmlEdmBookDocumentRecordTo[] array = new PmlEdmBookDocumentRecordToImpl[3];

            array[0] = (PmlEdmBookDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmBookDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmBookDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentRecordTo> findByDateComplete(
        Date dateComplete) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
        String finderMethodName = "findByDateComplete";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateComplete };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                if (dateComplete == null) {
                    query.append("datecomplete IS NULL");
                } else {
                    query.append("datecomplete = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateComplete != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateComplete));
                }

                List<PmlEdmBookDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmBookDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmBookDocumentRecordTo> findByDateComplete(
        Date dateComplete, int start, int end) throws SystemException {
        return findByDateComplete(dateComplete, start, end, null);
    }

    public List<PmlEdmBookDocumentRecordTo> findByDateComplete(
        Date dateComplete, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
        String finderMethodName = "findByDateComplete";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                dateComplete,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                if (dateComplete == null) {
                    query.append("datecomplete IS NULL");
                } else {
                    query.append("datecomplete = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateComplete != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateComplete));
                }

                List<PmlEdmBookDocumentRecordTo> list = (List<PmlEdmBookDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentRecordTo>) result;
        }
    }

    public PmlEdmBookDocumentRecordTo findByDateComplete_First(
        Date dateComplete, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        List<PmlEdmBookDocumentRecordTo> list = findByDateComplete(dateComplete,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentRecordTo exists with the key {");

            msg.append("dateComplete=" + dateComplete);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentRecordTo findByDateComplete_Last(
        Date dateComplete, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        int count = countByDateComplete(dateComplete);

        List<PmlEdmBookDocumentRecordTo> list = findByDateComplete(dateComplete,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentRecordTo exists with the key {");

            msg.append("dateComplete=" + dateComplete);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentRecordTo[] findByDateComplete_PrevAndNext(
        PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        Date dateComplete, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo = findByPrimaryKey(pmlEdmBookDocumentRecordToPK);

        int count = countByDateComplete(dateComplete);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

            if (dateComplete == null) {
                query.append("datecomplete IS NULL");
            } else {
                query.append("datecomplete = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateComplete != null) {
                qPos.add(CalendarUtil.getTimestamp(dateComplete));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentRecordTo);

            PmlEdmBookDocumentRecordTo[] array = new PmlEdmBookDocumentRecordToImpl[3];

            array[0] = (PmlEdmBookDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmBookDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmBookDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentRecordTo> findByDateCreate(Date dateCreate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
        String finderMethodName = "findByDateCreate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateCreate };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                if (dateCreate == null) {
                    query.append("datecreate IS NULL");
                } else {
                    query.append("datecreate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreate != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreate));
                }

                List<PmlEdmBookDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmBookDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmBookDocumentRecordTo> findByDateCreate(Date dateCreate,
        int start, int end) throws SystemException {
        return findByDateCreate(dateCreate, start, end, null);
    }

    public List<PmlEdmBookDocumentRecordTo> findByDateCreate(Date dateCreate,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
        String finderMethodName = "findByDateCreate";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                dateCreate,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                if (dateCreate == null) {
                    query.append("datecreate IS NULL");
                } else {
                    query.append("datecreate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreate != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreate));
                }

                List<PmlEdmBookDocumentRecordTo> list = (List<PmlEdmBookDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentRecordTo>) result;
        }
    }

    public PmlEdmBookDocumentRecordTo findByDateCreate_First(Date dateCreate,
        OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        List<PmlEdmBookDocumentRecordTo> list = findByDateCreate(dateCreate, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentRecordTo exists with the key {");

            msg.append("dateCreate=" + dateCreate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentRecordTo findByDateCreate_Last(Date dateCreate,
        OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        int count = countByDateCreate(dateCreate);

        List<PmlEdmBookDocumentRecordTo> list = findByDateCreate(dateCreate,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentRecordTo exists with the key {");

            msg.append("dateCreate=" + dateCreate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentRecordTo[] findByDateCreate_PrevAndNext(
        PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        Date dateCreate, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo = findByPrimaryKey(pmlEdmBookDocumentRecordToPK);

        int count = countByDateCreate(dateCreate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

            if (dateCreate == null) {
                query.append("datecreate IS NULL");
            } else {
                query.append("datecreate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateCreate != null) {
                qPos.add(CalendarUtil.getTimestamp(dateCreate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentRecordTo);

            PmlEdmBookDocumentRecordTo[] array = new PmlEdmBookDocumentRecordToImpl[3];

            array[0] = (PmlEdmBookDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmBookDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmBookDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentRecordTo> findByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
        String finderMethodName = "findByDocumentReceiptId_DocumentRecordToId";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(documentRecordToId)
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("documentrecordtoid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(documentRecordToId);

                List<PmlEdmBookDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmBookDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmBookDocumentRecordTo> findByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId, int start, int end)
        throws SystemException {
        return findByDocumentReceiptId_DocumentRecordToId(documentReceiptId,
            documentRecordToId, start, end, null);
    }

    public List<PmlEdmBookDocumentRecordTo> findByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
        String finderMethodName = "findByDocumentReceiptId_DocumentRecordToId";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(documentRecordToId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("documentrecordtoid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(documentRecordToId);

                List<PmlEdmBookDocumentRecordTo> list = (List<PmlEdmBookDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentRecordTo>) result;
        }
    }

    public PmlEdmBookDocumentRecordTo findByDocumentReceiptId_DocumentRecordToId_First(
        long documentReceiptId, long documentRecordToId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        List<PmlEdmBookDocumentRecordTo> list = findByDocumentReceiptId_DocumentRecordToId(documentReceiptId,
                documentRecordToId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentRecordTo exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("documentRecordToId=" + documentRecordToId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentRecordTo findByDocumentReceiptId_DocumentRecordToId_Last(
        long documentReceiptId, long documentRecordToId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        int count = countByDocumentReceiptId_DocumentRecordToId(documentReceiptId,
                documentRecordToId);

        List<PmlEdmBookDocumentRecordTo> list = findByDocumentReceiptId_DocumentRecordToId(documentReceiptId,
                documentRecordToId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentRecordTo exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("documentRecordToId=" + documentRecordToId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentRecordTo[] findByDocumentReceiptId_DocumentRecordToId_PrevAndNext(
        PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK,
        long documentReceiptId, long documentRecordToId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentRecordToException, SystemException {
        PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo = findByPrimaryKey(pmlEdmBookDocumentRecordToPK);

        int count = countByDocumentReceiptId_DocumentRecordToId(documentReceiptId,
                documentRecordToId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("documentrecordtoid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(documentRecordToId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentRecordTo);

            PmlEdmBookDocumentRecordTo[] array = new PmlEdmBookDocumentRecordToImpl[3];

            array[0] = (PmlEdmBookDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmBookDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmBookDocumentRecordTo) objArray[2];

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

    public List<PmlEdmBookDocumentRecordTo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmBookDocumentRecordTo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmBookDocumentRecordTo> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmBookDocumentRecordTo> list = (List<PmlEdmBookDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentRecordTo>) result;
        }
    }

    public void removeByDocumentReceiptId(long documentReceiptId)
        throws SystemException {
        for (PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo : findByDocumentReceiptId(
                documentReceiptId)) {
            remove(pmlEdmBookDocumentRecordTo);
        }
    }

    public void removeByDocumentRecordToId(long documentRecordToId)
        throws SystemException {
        for (PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo : findByDocumentRecordToId(
                documentRecordToId)) {
            remove(pmlEdmBookDocumentRecordTo);
        }
    }

    public void removeByDateComplete(Date dateComplete)
        throws SystemException {
        for (PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo : findByDateComplete(
                dateComplete)) {
            remove(pmlEdmBookDocumentRecordTo);
        }
    }

    public void removeByDateCreate(Date dateCreate) throws SystemException {
        for (PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo : findByDateCreate(
                dateCreate)) {
            remove(pmlEdmBookDocumentRecordTo);
        }
    }

    public void removeByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId)
        throws SystemException {
        for (PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo : findByDocumentReceiptId_DocumentRecordToId(
                documentReceiptId, documentRecordToId)) {
            remove(pmlEdmBookDocumentRecordTo);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo : findAll()) {
            remove(pmlEdmBookDocumentRecordTo);
        }
    }

    public int countByDocumentReceiptId(long documentReceiptId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

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

    public int countByDocumentRecordToId(long documentRecordToId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
        String finderMethodName = "countByDocumentRecordToId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentRecordToId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                query.append("documentrecordtoid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordToId);

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

    public int countByDateComplete(Date dateComplete) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
        String finderMethodName = "countByDateComplete";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateComplete };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                if (dateComplete == null) {
                    query.append("datecomplete IS NULL");
                } else {
                    query.append("datecomplete = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateComplete != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateComplete));
                }

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

    public int countByDateCreate(Date dateCreate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
        String finderMethodName = "countByDateCreate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateCreate };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                if (dateCreate == null) {
                    query.append("datecreate IS NULL");
                } else {
                    query.append("datecreate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreate != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreate));
                }

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

    public int countByDocumentReceiptId_DocumentRecordToId(
        long documentReceiptId, long documentRecordToId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
        String finderMethodName = "countByDocumentReceiptId_DocumentRecordToId";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(documentRecordToId)
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

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("documentrecordtoid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(documentRecordToId);

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
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentRecordTo.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo")));

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
