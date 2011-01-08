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

import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmDocumentReceiptPersistenceImpl extends BasePersistenceImpl
    implements PmlEdmDocumentReceiptPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmDocumentReceiptPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmDocumentReceipt create(long documentReceiptId) {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = new PmlEdmDocumentReceiptImpl();

        pmlEdmDocumentReceipt.setNew(true);
        pmlEdmDocumentReceipt.setPrimaryKey(documentReceiptId);

        return pmlEdmDocumentReceipt;
    }

    public PmlEdmDocumentReceipt remove(long documentReceiptId)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmDocumentReceipt pmlEdmDocumentReceipt = (PmlEdmDocumentReceipt) session.get(PmlEdmDocumentReceiptImpl.class,
                    new Long(documentReceiptId));

            if (pmlEdmDocumentReceipt == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmDocumentReceipt exists with the primary key " +
                        documentReceiptId);
                }

                throw new NoSuchPmlEdmDocumentReceiptException(
                    "No PmlEdmDocumentReceipt exists with the primary key " +
                    documentReceiptId);
            }

            return remove(pmlEdmDocumentReceipt);
        } catch (NoSuchPmlEdmDocumentReceiptException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentReceipt remove(
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmDocumentReceipt);
            }
        }

        pmlEdmDocumentReceipt = removeImpl(pmlEdmDocumentReceipt);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmDocumentReceipt);
            }
        }

        return pmlEdmDocumentReceipt;
    }

    protected PmlEdmDocumentReceipt removeImpl(
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmDocumentReceipt);

            session.flush();

            return pmlEdmDocumentReceipt;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentReceipt.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentReceipt pmlEdmDocumentReceipt, boolean merge)</code>.
     */
    public PmlEdmDocumentReceipt update(
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmDocumentReceipt pmlEdmDocumentReceipt) method. Use update(PmlEdmDocumentReceipt pmlEdmDocumentReceipt, boolean merge) instead.");
        }

        return update(pmlEdmDocumentReceipt, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentReceipt the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentReceipt is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmDocumentReceipt update(
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmDocumentReceipt.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmDocumentReceipt);
                } else {
                    listener.onBeforeUpdate(pmlEdmDocumentReceipt);
                }
            }
        }

        pmlEdmDocumentReceipt = updateImpl(pmlEdmDocumentReceipt, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmDocumentReceipt);
                } else {
                    listener.onAfterUpdate(pmlEdmDocumentReceipt);
                }
            }
        }

        return pmlEdmDocumentReceipt;
    }

    public PmlEdmDocumentReceipt updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt pmlEdmDocumentReceipt,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmDocumentReceipt);
            } else {
                if (pmlEdmDocumentReceipt.isNew()) {
                    session.save(pmlEdmDocumentReceipt);
                }
            }

            session.flush();

            pmlEdmDocumentReceipt.setNew(false);

            return pmlEdmDocumentReceipt;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentReceipt.class.getName());
        }
    }

    public PmlEdmDocumentReceipt findByPrimaryKey(long documentReceiptId)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = fetchByPrimaryKey(documentReceiptId);

        if (pmlEdmDocumentReceipt == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmDocumentReceipt exists with the primary key " +
                    documentReceiptId);
            }

            throw new NoSuchPmlEdmDocumentReceiptException(
                "No PmlEdmDocumentReceipt exists with the primary key " +
                documentReceiptId);
        }

        return pmlEdmDocumentReceipt;
    }

    public PmlEdmDocumentReceipt fetchByPrimaryKey(long documentReceiptId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmDocumentReceipt) session.get(PmlEdmDocumentReceiptImpl.class,
                new Long(documentReceiptId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceipt> findByDocumentType(String documentType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByDocumentType";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentType };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (documentType == null) {
                    query.append("documenttype IS NULL");
                } else {
                    query.append("documenttype = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentType != null) {
                    qPos.add(documentType);
                }

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByDocumentType(String documentType,
        int start, int end) throws SystemException {
        return findByDocumentType(documentType, start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findByDocumentType(String documentType,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByDocumentType";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                documentType,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (documentType == null) {
                    query.append("documenttype IS NULL");
                } else {
                    query.append("documenttype = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentType != null) {
                    qPos.add(documentType);
                }

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByDocumentType_First(String documentType,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByDocumentType(documentType, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("documentType=" + documentType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByDocumentType_Last(String documentType,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByDocumentType(documentType);

        List<PmlEdmDocumentReceipt> list = findByDocumentType(documentType,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("documentType=" + documentType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByDocumentType_PrevAndNext(
        long documentReceiptId, String documentType, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByDocumentType(documentType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            if (documentType == null) {
                query.append("documenttype IS NULL");
            } else {
                query.append("documenttype = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (documentType != null) {
                qPos.add(documentType);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceipt> findByLevelSendId(int levelSendId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByLevelSendId";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(levelSendId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("levelsendid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(levelSendId);

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByLevelSendId(int levelSendId,
        int start, int end) throws SystemException {
        return findByLevelSendId(levelSendId, start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findByLevelSendId(int levelSendId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByLevelSendId";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(levelSendId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("levelsendid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(levelSendId);

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByLevelSendId_First(int levelSendId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByLevelSendId(levelSendId, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("levelSendId=" + levelSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByLevelSendId_Last(int levelSendId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByLevelSendId(levelSendId);

        List<PmlEdmDocumentReceipt> list = findByLevelSendId(levelSendId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("levelSendId=" + levelSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByLevelSendId_PrevAndNext(
        long documentReceiptId, int levelSendId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByLevelSendId(levelSendId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            query.append("levelsendid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(levelSendId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceipt> findByDocumentTypeId(long documentTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByDocumentTypeId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentTypeId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("documenttypeid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentTypeId);

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByDocumentTypeId(
        long documentTypeId, int start, int end) throws SystemException {
        return findByDocumentTypeId(documentTypeId, start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findByDocumentTypeId(
        long documentTypeId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByDocumentTypeId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentTypeId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("documenttypeid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentTypeId);

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByDocumentTypeId_First(
        long documentTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByDocumentTypeId(documentTypeId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("documentTypeId=" + documentTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByDocumentTypeId_Last(
        long documentTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByDocumentTypeId(documentTypeId);

        List<PmlEdmDocumentReceipt> list = findByDocumentTypeId(documentTypeId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("documentTypeId=" + documentTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByDocumentTypeId_PrevAndNext(
        long documentReceiptId, long documentTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByDocumentTypeId(documentTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            query.append("documenttypeid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentTypeId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceipt> findByIssuingPlaceId(
        String issuingPlaceId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByIssuingPlaceId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { issuingPlaceId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (issuingPlaceId == null) {
                    query.append("issuingplaceid LIKE null");
                } else {
                    query.append("issuingplaceid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceId != null) {
                    qPos.add(issuingPlaceId);
                }

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByIssuingPlaceId(
        String issuingPlaceId, int start, int end) throws SystemException {
        return findByIssuingPlaceId(issuingPlaceId, start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findByIssuingPlaceId(
        String issuingPlaceId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByIssuingPlaceId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                issuingPlaceId,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (issuingPlaceId == null) {
                    query.append("issuingplaceid LIKE null");
                } else {
                    query.append("issuingplaceid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceId != null) {
                    qPos.add(issuingPlaceId);
                }

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByIssuingPlaceId_First(
        String issuingPlaceId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByIssuingPlaceId(issuingPlaceId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("issuingPlaceId=" + issuingPlaceId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByIssuingPlaceId_Last(
        String issuingPlaceId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByIssuingPlaceId(issuingPlaceId);

        List<PmlEdmDocumentReceipt> list = findByIssuingPlaceId(issuingPlaceId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("issuingPlaceId=" + issuingPlaceId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByIssuingPlaceId_PrevAndNext(
        long documentReceiptId, String issuingPlaceId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByIssuingPlaceId(issuingPlaceId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            if (issuingPlaceId == null) {
                query.append("issuingplaceid LIKE null");
            } else {
                query.append("issuingplaceid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (issuingPlaceId != null) {
                qPos.add(issuingPlaceId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceipt> findByPrivilegeLevelId(
        String privilegeLevelId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByPrivilegeLevelId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { privilegeLevelId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (privilegeLevelId == null) {
                    query.append("privilegelevelid LIKE null");
                } else {
                    query.append("privilegelevelid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (privilegeLevelId != null) {
                    qPos.add(privilegeLevelId);
                }

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByPrivilegeLevelId(
        String privilegeLevelId, int start, int end) throws SystemException {
        return findByPrivilegeLevelId(privilegeLevelId, start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findByPrivilegeLevelId(
        String privilegeLevelId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByPrivilegeLevelId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                privilegeLevelId,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (privilegeLevelId == null) {
                    query.append("privilegelevelid LIKE null");
                } else {
                    query.append("privilegelevelid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (privilegeLevelId != null) {
                    qPos.add(privilegeLevelId);
                }

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByPrivilegeLevelId_First(
        String privilegeLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByPrivilegeLevelId(privilegeLevelId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("privilegeLevelId=" + privilegeLevelId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByPrivilegeLevelId_Last(
        String privilegeLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByPrivilegeLevelId(privilegeLevelId);

        List<PmlEdmDocumentReceipt> list = findByPrivilegeLevelId(privilegeLevelId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("privilegeLevelId=" + privilegeLevelId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByPrivilegeLevelId_PrevAndNext(
        long documentReceiptId, String privilegeLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByPrivilegeLevelId(privilegeLevelId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            if (privilegeLevelId == null) {
                query.append("privilegelevelid LIKE null");
            } else {
                query.append("privilegelevelid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (privilegeLevelId != null) {
                qPos.add(privilegeLevelId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceipt> findByConfidentialLevelId(
        String confidentialLevelId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByConfidentialLevelId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { confidentialLevelId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (confidentialLevelId == null) {
                    query.append("confidentiallevelid LIKE null");
                } else {
                    query.append("confidentiallevelid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (confidentialLevelId != null) {
                    qPos.add(confidentialLevelId);
                }

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByConfidentialLevelId(
        String confidentialLevelId, int start, int end)
        throws SystemException {
        return findByConfidentialLevelId(confidentialLevelId, start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findByConfidentialLevelId(
        String confidentialLevelId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByConfidentialLevelId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                confidentialLevelId,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (confidentialLevelId == null) {
                    query.append("confidentiallevelid LIKE null");
                } else {
                    query.append("confidentiallevelid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (confidentialLevelId != null) {
                    qPos.add(confidentialLevelId);
                }

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByConfidentialLevelId_First(
        String confidentialLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByConfidentialLevelId(confidentialLevelId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("confidentialLevelId=" + confidentialLevelId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByConfidentialLevelId_Last(
        String confidentialLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByConfidentialLevelId(confidentialLevelId);

        List<PmlEdmDocumentReceipt> list = findByConfidentialLevelId(confidentialLevelId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("confidentialLevelId=" + confidentialLevelId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByConfidentialLevelId_PrevAndNext(
        long documentReceiptId, String confidentialLevelId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByConfidentialLevelId(confidentialLevelId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            if (confidentialLevelId == null) {
                query.append("confidentiallevelid LIKE null");
            } else {
                query.append("confidentiallevelid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (confidentialLevelId != null) {
                qPos.add(confidentialLevelId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceipt> findByNumberLocalDocumentReceipt(
        String numberLocalDocumentReceipt) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByNumberLocalDocumentReceipt";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { numberLocalDocumentReceipt };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (numberLocalDocumentReceipt == null) {
                    query.append("numberlocaldocumentreceipt LIKE null");
                } else {
                    query.append("numberlocaldocumentreceipt LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberLocalDocumentReceipt != null) {
                    qPos.add(numberLocalDocumentReceipt);
                }

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByNumberLocalDocumentReceipt(
        String numberLocalDocumentReceipt, int start, int end)
        throws SystemException {
        return findByNumberLocalDocumentReceipt(numberLocalDocumentReceipt,
            start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findByNumberLocalDocumentReceipt(
        String numberLocalDocumentReceipt, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByNumberLocalDocumentReceipt";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                numberLocalDocumentReceipt,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (numberLocalDocumentReceipt == null) {
                    query.append("numberlocaldocumentreceipt LIKE null");
                } else {
                    query.append("numberlocaldocumentreceipt LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberLocalDocumentReceipt != null) {
                    qPos.add(numberLocalDocumentReceipt);
                }

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByNumberLocalDocumentReceipt_First(
        String numberLocalDocumentReceipt, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByNumberLocalDocumentReceipt(numberLocalDocumentReceipt,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("numberLocalDocumentReceipt=" +
                numberLocalDocumentReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByNumberLocalDocumentReceipt_Last(
        String numberLocalDocumentReceipt, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByNumberLocalDocumentReceipt(numberLocalDocumentReceipt);

        List<PmlEdmDocumentReceipt> list = findByNumberLocalDocumentReceipt(numberLocalDocumentReceipt,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("numberLocalDocumentReceipt=" +
                numberLocalDocumentReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByNumberLocalDocumentReceipt_PrevAndNext(
        long documentReceiptId, String numberLocalDocumentReceipt,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByNumberLocalDocumentReceipt(numberLocalDocumentReceipt);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            if (numberLocalDocumentReceipt == null) {
                query.append("numberlocaldocumentreceipt LIKE null");
            } else {
                query.append("numberlocaldocumentreceipt LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (numberLocalDocumentReceipt != null) {
                qPos.add(numberLocalDocumentReceipt);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceipt> findByStatusId(long statusId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByStatusId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(statusId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("statusid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(statusId);

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByStatusId(long statusId, int start,
        int end) throws SystemException {
        return findByStatusId(statusId, start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findByStatusId(long statusId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByStatusId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(statusId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("statusid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(statusId);

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByStatusId_First(long statusId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByStatusId(statusId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("statusId=" + statusId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByStatusId_Last(long statusId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByStatusId(statusId);

        List<PmlEdmDocumentReceipt> list = findByStatusId(statusId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("statusId=" + statusId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByStatusId_PrevAndNext(
        long documentReceiptId, long statusId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByStatusId(statusId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            query.append("statusid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(statusId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentReceipt findBySoCongCanDiPhucDap(
        String socongvandiphucdap)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = fetchBySoCongCanDiPhucDap(socongvandiphucdap);

        if (pmlEdmDocumentReceipt == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("socongvandiphucdap=" + socongvandiphucdap);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        }

        return pmlEdmDocumentReceipt;
    }

    public PmlEdmDocumentReceipt fetchBySoCongCanDiPhucDap(
        String socongvandiphucdap) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "fetchBySoCongCanDiPhucDap";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { socongvandiphucdap };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (socongvandiphucdap == null) {
                    query.append("socongvandiphucdap LIKE null");
                } else {
                    query.append("socongvandiphucdap LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (socongvandiphucdap != null) {
                    qPos.add(socongvandiphucdap);
                }

                List<PmlEdmDocumentReceipt> list = q.list();

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                if (list.size() == 0) {
                    return null;
                } else {
                    return list.get(0);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public List<PmlEdmDocumentReceipt> findByMainDepartmentProcessId(
        String mainDepartmentProcessId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByMainDepartmentProcessId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { mainDepartmentProcessId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (mainDepartmentProcessId == null) {
                    query.append("maindepartmentprocessid LIKE null");
                } else {
                    query.append("maindepartmentprocessid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (mainDepartmentProcessId != null) {
                    qPos.add(mainDepartmentProcessId);
                }

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByMainDepartmentProcessId(
        String mainDepartmentProcessId, int start, int end)
        throws SystemException {
        return findByMainDepartmentProcessId(mainDepartmentProcessId, start,
            end, null);
    }

    public List<PmlEdmDocumentReceipt> findByMainDepartmentProcessId(
        String mainDepartmentProcessId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByMainDepartmentProcessId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                mainDepartmentProcessId,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (mainDepartmentProcessId == null) {
                    query.append("maindepartmentprocessid LIKE null");
                } else {
                    query.append("maindepartmentprocessid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (mainDepartmentProcessId != null) {
                    qPos.add(mainDepartmentProcessId);
                }

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByMainDepartmentProcessId_First(
        String mainDepartmentProcessId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByMainDepartmentProcessId(mainDepartmentProcessId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("mainDepartmentProcessId=" + mainDepartmentProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByMainDepartmentProcessId_Last(
        String mainDepartmentProcessId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByMainDepartmentProcessId(mainDepartmentProcessId);

        List<PmlEdmDocumentReceipt> list = findByMainDepartmentProcessId(mainDepartmentProcessId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("mainDepartmentProcessId=" + mainDepartmentProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByMainDepartmentProcessId_PrevAndNext(
        long documentReceiptId, String mainDepartmentProcessId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByMainDepartmentProcessId(mainDepartmentProcessId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            if (mainDepartmentProcessId == null) {
                query.append("maindepartmentprocessid LIKE null");
            } else {
                query.append("maindepartmentprocessid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (mainDepartmentProcessId != null) {
                qPos.add(mainDepartmentProcessId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceipt> findByMainUserProcessId(
        long mainUserProcessId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByMainUserProcessId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(mainUserProcessId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("mainuserprocessid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mainUserProcessId);

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByMainUserProcessId(
        long mainUserProcessId, int start, int end) throws SystemException {
        return findByMainUserProcessId(mainUserProcessId, start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findByMainUserProcessId(
        long mainUserProcessId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByMainUserProcessId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(mainUserProcessId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("mainuserprocessid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mainUserProcessId);

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByMainUserProcessId_First(
        long mainUserProcessId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByMainUserProcessId(mainUserProcessId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("mainUserProcessId=" + mainUserProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByMainUserProcessId_Last(
        long mainUserProcessId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByMainUserProcessId(mainUserProcessId);

        List<PmlEdmDocumentReceipt> list = findByMainUserProcessId(mainUserProcessId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("mainUserProcessId=" + mainUserProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByMainUserProcessId_PrevAndNext(
        long documentReceiptId, long mainUserProcessId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByMainUserProcessId(mainUserProcessId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            query.append("mainuserprocessid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(mainUserProcessId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceipt> findByOrgExternalId(long orgExternalId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByOrgExternalId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(orgExternalId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("orgexternalid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgExternalId);

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByOrgExternalId(long orgExternalId,
        int start, int end) throws SystemException {
        return findByOrgExternalId(orgExternalId, start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findByOrgExternalId(long orgExternalId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByOrgExternalId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(orgExternalId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("orgexternalid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgExternalId);

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByOrgExternalId_First(long orgExternalId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByOrgExternalId(orgExternalId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("orgExternalId=" + orgExternalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByOrgExternalId_Last(long orgExternalId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByOrgExternalId(orgExternalId);

        List<PmlEdmDocumentReceipt> list = findByOrgExternalId(orgExternalId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("orgExternalId=" + orgExternalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByOrgExternalId_PrevAndNext(
        long documentReceiptId, long orgExternalId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByOrgExternalId(orgExternalId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            query.append("orgexternalid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(orgExternalId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceipt> findByDocReceiptTempId_OrgExternalId(
        long docReceiptTempId, long orgExternalId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByDocReceiptTempId_OrgExternalId";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(docReceiptTempId), new Long(orgExternalId)
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("docreceipttempid = ?");

                query.append(" AND ");

                query.append("orgexternalid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docReceiptTempId);

                qPos.add(orgExternalId);

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByDocReceiptTempId_OrgExternalId(
        long docReceiptTempId, long orgExternalId, int start, int end)
        throws SystemException {
        return findByDocReceiptTempId_OrgExternalId(docReceiptTempId,
            orgExternalId, start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findByDocReceiptTempId_OrgExternalId(
        long docReceiptTempId, long orgExternalId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByDocReceiptTempId_OrgExternalId";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(docReceiptTempId), new Long(orgExternalId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("docreceipttempid = ?");

                query.append(" AND ");

                query.append("orgexternalid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docReceiptTempId);

                qPos.add(orgExternalId);

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByDocReceiptTempId_OrgExternalId_First(
        long docReceiptTempId, long orgExternalId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByDocReceiptTempId_OrgExternalId(docReceiptTempId,
                orgExternalId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("docReceiptTempId=" + docReceiptTempId);

            msg.append(", ");
            msg.append("orgExternalId=" + orgExternalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByDocReceiptTempId_OrgExternalId_Last(
        long docReceiptTempId, long orgExternalId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByDocReceiptTempId_OrgExternalId(docReceiptTempId,
                orgExternalId);

        List<PmlEdmDocumentReceipt> list = findByDocReceiptTempId_OrgExternalId(docReceiptTempId,
                orgExternalId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("docReceiptTempId=" + docReceiptTempId);

            msg.append(", ");
            msg.append("orgExternalId=" + orgExternalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByDocReceiptTempId_OrgExternalId_PrevAndNext(
        long documentReceiptId, long docReceiptTempId, long orgExternalId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByDocReceiptTempId_OrgExternalId(docReceiptTempId,
                orgExternalId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            query.append("docreceipttempid = ?");

            query.append(" AND ");

            query.append("orgexternalid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(docReceiptTempId);

            qPos.add(orgExternalId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceipt> findByDocReceiptTempId(
        long docReceiptTempId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByDocReceiptTempId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(docReceiptTempId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("docreceipttempid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docReceiptTempId);

                List<PmlEdmDocumentReceipt> list = q.list();

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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public List<PmlEdmDocumentReceipt> findByDocReceiptTempId(
        long docReceiptTempId, int start, int end) throws SystemException {
        return findByDocReceiptTempId(docReceiptTempId, start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findByDocReceiptTempId(
        long docReceiptTempId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "findByDocReceiptTempId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(docReceiptTempId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("docreceipttempid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docReceiptTempId);

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public PmlEdmDocumentReceipt findByDocReceiptTempId_First(
        long docReceiptTempId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        List<PmlEdmDocumentReceipt> list = findByDocReceiptTempId(docReceiptTempId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("docReceiptTempId=" + docReceiptTempId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt findByDocReceiptTempId_Last(
        long docReceiptTempId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        int count = countByDocReceiptTempId(docReceiptTempId);

        List<PmlEdmDocumentReceipt> list = findByDocReceiptTempId(docReceiptTempId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceipt exists with the key {");

            msg.append("docReceiptTempId=" + docReceiptTempId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceipt[] findByDocReceiptTempId_PrevAndNext(
        long documentReceiptId, long docReceiptTempId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findByPrimaryKey(documentReceiptId);

        int count = countByDocReceiptTempId(docReceiptTempId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

            query.append("docreceipttempid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(docReceiptTempId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceipt);

            PmlEdmDocumentReceipt[] array = new PmlEdmDocumentReceiptImpl[3];

            array[0] = (PmlEdmDocumentReceipt) objArray[0];
            array[1] = (PmlEdmDocumentReceipt) objArray[1];
            array[2] = (PmlEdmDocumentReceipt) objArray[2];

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

    public List<PmlEdmDocumentReceipt> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmDocumentReceipt> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmDocumentReceipt> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmDocumentReceipt> list = (List<PmlEdmDocumentReceipt>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceipt>) result;
        }
    }

    public void removeByDocumentType(String documentType)
        throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByDocumentType(
                documentType)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeByLevelSendId(int levelSendId) throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByLevelSendId(
                levelSendId)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeByDocumentTypeId(long documentTypeId)
        throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByDocumentTypeId(
                documentTypeId)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeByIssuingPlaceId(String issuingPlaceId)
        throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByIssuingPlaceId(
                issuingPlaceId)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeByPrivilegeLevelId(String privilegeLevelId)
        throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByPrivilegeLevelId(
                privilegeLevelId)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeByConfidentialLevelId(String confidentialLevelId)
        throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByConfidentialLevelId(
                confidentialLevelId)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeByNumberLocalDocumentReceipt(
        String numberLocalDocumentReceipt) throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByNumberLocalDocumentReceipt(
                numberLocalDocumentReceipt)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeByStatusId(long statusId) throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByStatusId(
                statusId)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeBySoCongCanDiPhucDap(String socongvandiphucdap)
        throws NoSuchPmlEdmDocumentReceiptException, SystemException {
        PmlEdmDocumentReceipt pmlEdmDocumentReceipt = findBySoCongCanDiPhucDap(socongvandiphucdap);

        remove(pmlEdmDocumentReceipt);
    }

    public void removeByMainDepartmentProcessId(String mainDepartmentProcessId)
        throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByMainDepartmentProcessId(
                mainDepartmentProcessId)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeByMainUserProcessId(long mainUserProcessId)
        throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByMainUserProcessId(
                mainUserProcessId)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeByOrgExternalId(long orgExternalId)
        throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByOrgExternalId(
                orgExternalId)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeByDocReceiptTempId_OrgExternalId(long docReceiptTempId,
        long orgExternalId) throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByDocReceiptTempId_OrgExternalId(
                docReceiptTempId, orgExternalId)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeByDocReceiptTempId(long docReceiptTempId)
        throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findByDocReceiptTempId(
                docReceiptTempId)) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : findAll()) {
            remove(pmlEdmDocumentReceipt);
        }
    }

    public int countByDocumentType(String documentType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByDocumentType";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentType };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (documentType == null) {
                    query.append("documenttype IS NULL");
                } else {
                    query.append("documenttype = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentType != null) {
                    qPos.add(documentType);
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

    public int countByLevelSendId(int levelSendId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByLevelSendId";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(levelSendId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("levelsendid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(levelSendId);

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

    public int countByDocumentTypeId(long documentTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByDocumentTypeId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentTypeId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("documenttypeid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentTypeId);

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

    public int countByIssuingPlaceId(String issuingPlaceId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByIssuingPlaceId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { issuingPlaceId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (issuingPlaceId == null) {
                    query.append("issuingplaceid LIKE null");
                } else {
                    query.append("issuingplaceid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceId != null) {
                    qPos.add(issuingPlaceId);
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

    public int countByPrivilegeLevelId(String privilegeLevelId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByPrivilegeLevelId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { privilegeLevelId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (privilegeLevelId == null) {
                    query.append("privilegelevelid LIKE null");
                } else {
                    query.append("privilegelevelid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (privilegeLevelId != null) {
                    qPos.add(privilegeLevelId);
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

    public int countByConfidentialLevelId(String confidentialLevelId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByConfidentialLevelId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { confidentialLevelId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (confidentialLevelId == null) {
                    query.append("confidentiallevelid LIKE null");
                } else {
                    query.append("confidentiallevelid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (confidentialLevelId != null) {
                    qPos.add(confidentialLevelId);
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

    public int countByNumberLocalDocumentReceipt(
        String numberLocalDocumentReceipt) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByNumberLocalDocumentReceipt";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { numberLocalDocumentReceipt };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (numberLocalDocumentReceipt == null) {
                    query.append("numberlocaldocumentreceipt LIKE null");
                } else {
                    query.append("numberlocaldocumentreceipt LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberLocalDocumentReceipt != null) {
                    qPos.add(numberLocalDocumentReceipt);
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

    public int countByStatusId(long statusId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByStatusId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(statusId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("statusid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(statusId);

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

    public int countBySoCongCanDiPhucDap(String socongvandiphucdap)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countBySoCongCanDiPhucDap";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { socongvandiphucdap };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (socongvandiphucdap == null) {
                    query.append("socongvandiphucdap LIKE null");
                } else {
                    query.append("socongvandiphucdap LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (socongvandiphucdap != null) {
                    qPos.add(socongvandiphucdap);
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

    public int countByMainDepartmentProcessId(String mainDepartmentProcessId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByMainDepartmentProcessId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { mainDepartmentProcessId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                if (mainDepartmentProcessId == null) {
                    query.append("maindepartmentprocessid LIKE null");
                } else {
                    query.append("maindepartmentprocessid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (mainDepartmentProcessId != null) {
                    qPos.add(mainDepartmentProcessId);
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

    public int countByMainUserProcessId(long mainUserProcessId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByMainUserProcessId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(mainUserProcessId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("mainuserprocessid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mainUserProcessId);

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

    public int countByOrgExternalId(long orgExternalId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByOrgExternalId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(orgExternalId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("orgexternalid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgExternalId);

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

    public int countByDocReceiptTempId_OrgExternalId(long docReceiptTempId,
        long orgExternalId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByDocReceiptTempId_OrgExternalId";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(docReceiptTempId), new Long(orgExternalId)
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("docreceipttempid = ?");

                query.append(" AND ");

                query.append("orgexternalid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docReceiptTempId);

                qPos.add(orgExternalId);

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

    public int countByDocReceiptTempId(long docReceiptTempId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
        String finderMethodName = "countByDocReceiptTempId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(docReceiptTempId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt WHERE ");

                query.append("docreceipttempid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docReceiptTempId);

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceipt.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt")));

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
