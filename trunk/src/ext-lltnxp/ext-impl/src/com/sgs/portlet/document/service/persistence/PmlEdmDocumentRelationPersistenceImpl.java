package com.sgs.portlet.document.service.persistence;

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

import com.sgs.portlet.document.NoSuchPmlEdmDocumentRelationException;
import com.sgs.portlet.document.model.PmlEdmDocumentRelation;
import com.sgs.portlet.document.model.impl.PmlEdmDocumentRelationImpl;
import com.sgs.portlet.document.model.impl.PmlEdmDocumentRelationModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmDocumentRelationPersistenceImpl extends BasePersistenceImpl
    implements PmlEdmDocumentRelationPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmDocumentRelationPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmDocumentRelation create(long documentRelationId) {
        PmlEdmDocumentRelation pmlEdmDocumentRelation = new PmlEdmDocumentRelationImpl();

        pmlEdmDocumentRelation.setNew(true);
        pmlEdmDocumentRelation.setPrimaryKey(documentRelationId);

        return pmlEdmDocumentRelation;
    }

    public PmlEdmDocumentRelation remove(long documentRelationId)
        throws NoSuchPmlEdmDocumentRelationException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmDocumentRelation pmlEdmDocumentRelation = (PmlEdmDocumentRelation) session.get(PmlEdmDocumentRelationImpl.class,
                    new Long(documentRelationId));

            if (pmlEdmDocumentRelation == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmDocumentRelation exists with the primary key " +
                        documentRelationId);
                }

                throw new NoSuchPmlEdmDocumentRelationException(
                    "No PmlEdmDocumentRelation exists with the primary key " +
                    documentRelationId);
            }

            return remove(pmlEdmDocumentRelation);
        } catch (NoSuchPmlEdmDocumentRelationException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentRelation remove(
        PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmDocumentRelation);
            }
        }

        pmlEdmDocumentRelation = removeImpl(pmlEdmDocumentRelation);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmDocumentRelation);
            }
        }

        return pmlEdmDocumentRelation;
    }

    protected PmlEdmDocumentRelation removeImpl(
        PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmDocumentRelation);

            session.flush();

            return pmlEdmDocumentRelation;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentRelation.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentRelation pmlEdmDocumentRelation, boolean merge)</code>.
     */
    public PmlEdmDocumentRelation update(
        PmlEdmDocumentRelation pmlEdmDocumentRelation)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmDocumentRelation pmlEdmDocumentRelation) method. Use update(PmlEdmDocumentRelation pmlEdmDocumentRelation, boolean merge) instead.");
        }

        return update(pmlEdmDocumentRelation, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentRelation the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentRelation is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmDocumentRelation update(
        PmlEdmDocumentRelation pmlEdmDocumentRelation, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmDocumentRelation.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmDocumentRelation);
                } else {
                    listener.onBeforeUpdate(pmlEdmDocumentRelation);
                }
            }
        }

        pmlEdmDocumentRelation = updateImpl(pmlEdmDocumentRelation, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmDocumentRelation);
                } else {
                    listener.onAfterUpdate(pmlEdmDocumentRelation);
                }
            }
        }

        return pmlEdmDocumentRelation;
    }

    public PmlEdmDocumentRelation updateImpl(
        com.sgs.portlet.document.model.PmlEdmDocumentRelation pmlEdmDocumentRelation,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmDocumentRelation);
            } else {
                if (pmlEdmDocumentRelation.isNew()) {
                    session.save(pmlEdmDocumentRelation);
                }
            }

            session.flush();

            pmlEdmDocumentRelation.setNew(false);

            return pmlEdmDocumentRelation;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentRelation.class.getName());
        }
    }

    public PmlEdmDocumentRelation findByPrimaryKey(long documentRelationId)
        throws NoSuchPmlEdmDocumentRelationException, SystemException {
        PmlEdmDocumentRelation pmlEdmDocumentRelation = fetchByPrimaryKey(documentRelationId);

        if (pmlEdmDocumentRelation == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmDocumentRelation exists with the primary key " +
                    documentRelationId);
            }

            throw new NoSuchPmlEdmDocumentRelationException(
                "No PmlEdmDocumentRelation exists with the primary key " +
                documentRelationId);
        }

        return pmlEdmDocumentRelation;
    }

    public PmlEdmDocumentRelation fetchByPrimaryKey(long documentRelationId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmDocumentRelation) session.get(PmlEdmDocumentRelationImpl.class,
                new Long(documentRelationId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRelation> findByDocLeftId_LeftIsReceipt(
        long docLeftId, boolean leftIsReceipt) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRelationModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRelation.class.getName();
        String finderMethodName = "findByDocLeftId_LeftIsReceipt";
        String[] finderParams = new String[] {
                Long.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(docLeftId), Boolean.valueOf(leftIsReceipt)
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
                    "FROM com.sgs.portlet.document.model.PmlEdmDocumentRelation WHERE ");

                query.append("docleftid = ?");

                query.append(" AND ");

                query.append("leftisreceipt = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docLeftId);

                qPos.add(leftIsReceipt);

                List<PmlEdmDocumentRelation> list = q.list();

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
            return (List<PmlEdmDocumentRelation>) result;
        }
    }

    public List<PmlEdmDocumentRelation> findByDocLeftId_LeftIsReceipt(
        long docLeftId, boolean leftIsReceipt, int start, int end)
        throws SystemException {
        return findByDocLeftId_LeftIsReceipt(docLeftId, leftIsReceipt, start,
            end, null);
    }

    public List<PmlEdmDocumentRelation> findByDocLeftId_LeftIsReceipt(
        long docLeftId, boolean leftIsReceipt, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRelationModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRelation.class.getName();
        String finderMethodName = "findByDocLeftId_LeftIsReceipt";
        String[] finderParams = new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(docLeftId), Boolean.valueOf(leftIsReceipt),
                
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
                    "FROM com.sgs.portlet.document.model.PmlEdmDocumentRelation WHERE ");

                query.append("docleftid = ?");

                query.append(" AND ");

                query.append("leftisreceipt = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docLeftId);

                qPos.add(leftIsReceipt);

                List<PmlEdmDocumentRelation> list = (List<PmlEdmDocumentRelation>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRelation>) result;
        }
    }

    public PmlEdmDocumentRelation findByDocLeftId_LeftIsReceipt_First(
        long docLeftId, boolean leftIsReceipt, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRelationException, SystemException {
        List<PmlEdmDocumentRelation> list = findByDocLeftId_LeftIsReceipt(docLeftId,
                leftIsReceipt, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRelation exists with the key {");

            msg.append("docLeftId=" + docLeftId);

            msg.append(", ");
            msg.append("leftIsReceipt=" + leftIsReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRelationException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRelation findByDocLeftId_LeftIsReceipt_Last(
        long docLeftId, boolean leftIsReceipt, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRelationException, SystemException {
        int count = countByDocLeftId_LeftIsReceipt(docLeftId, leftIsReceipt);

        List<PmlEdmDocumentRelation> list = findByDocLeftId_LeftIsReceipt(docLeftId,
                leftIsReceipt, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRelation exists with the key {");

            msg.append("docLeftId=" + docLeftId);

            msg.append(", ");
            msg.append("leftIsReceipt=" + leftIsReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRelationException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRelation[] findByDocLeftId_LeftIsReceipt_PrevAndNext(
        long documentRelationId, long docLeftId, boolean leftIsReceipt,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRelationException, SystemException {
        PmlEdmDocumentRelation pmlEdmDocumentRelation = findByPrimaryKey(documentRelationId);

        int count = countByDocLeftId_LeftIsReceipt(docLeftId, leftIsReceipt);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlEdmDocumentRelation WHERE ");

            query.append("docleftid = ?");

            query.append(" AND ");

            query.append("leftisreceipt = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(docLeftId);

            qPos.add(leftIsReceipt);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRelation);

            PmlEdmDocumentRelation[] array = new PmlEdmDocumentRelationImpl[3];

            array[0] = (PmlEdmDocumentRelation) objArray[0];
            array[1] = (PmlEdmDocumentRelation) objArray[1];
            array[2] = (PmlEdmDocumentRelation) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRelation> findByDocRightId_RightIsReceipt(
        long docRightId, boolean rightIsReceipt) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRelationModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRelation.class.getName();
        String finderMethodName = "findByDocRightId_RightIsReceipt";
        String[] finderParams = new String[] {
                Long.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(docRightId), Boolean.valueOf(rightIsReceipt)
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
                    "FROM com.sgs.portlet.document.model.PmlEdmDocumentRelation WHERE ");

                query.append("docrightid = ?");

                query.append(" AND ");

                query.append("rightisreceipt = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docRightId);

                qPos.add(rightIsReceipt);

                List<PmlEdmDocumentRelation> list = q.list();

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
            return (List<PmlEdmDocumentRelation>) result;
        }
    }

    public List<PmlEdmDocumentRelation> findByDocRightId_RightIsReceipt(
        long docRightId, boolean rightIsReceipt, int start, int end)
        throws SystemException {
        return findByDocRightId_RightIsReceipt(docRightId, rightIsReceipt,
            start, end, null);
    }

    public List<PmlEdmDocumentRelation> findByDocRightId_RightIsReceipt(
        long docRightId, boolean rightIsReceipt, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRelationModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRelation.class.getName();
        String finderMethodName = "findByDocRightId_RightIsReceipt";
        String[] finderParams = new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(docRightId), Boolean.valueOf(rightIsReceipt),
                
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
                    "FROM com.sgs.portlet.document.model.PmlEdmDocumentRelation WHERE ");

                query.append("docrightid = ?");

                query.append(" AND ");

                query.append("rightisreceipt = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docRightId);

                qPos.add(rightIsReceipt);

                List<PmlEdmDocumentRelation> list = (List<PmlEdmDocumentRelation>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRelation>) result;
        }
    }

    public PmlEdmDocumentRelation findByDocRightId_RightIsReceipt_First(
        long docRightId, boolean rightIsReceipt, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRelationException, SystemException {
        List<PmlEdmDocumentRelation> list = findByDocRightId_RightIsReceipt(docRightId,
                rightIsReceipt, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRelation exists with the key {");

            msg.append("docRightId=" + docRightId);

            msg.append(", ");
            msg.append("rightIsReceipt=" + rightIsReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRelationException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRelation findByDocRightId_RightIsReceipt_Last(
        long docRightId, boolean rightIsReceipt, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRelationException, SystemException {
        int count = countByDocRightId_RightIsReceipt(docRightId, rightIsReceipt);

        List<PmlEdmDocumentRelation> list = findByDocRightId_RightIsReceipt(docRightId,
                rightIsReceipt, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRelation exists with the key {");

            msg.append("docRightId=" + docRightId);

            msg.append(", ");
            msg.append("rightIsReceipt=" + rightIsReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRelationException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRelation[] findByDocRightId_RightIsReceipt_PrevAndNext(
        long documentRelationId, long docRightId, boolean rightIsReceipt,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRelationException, SystemException {
        PmlEdmDocumentRelation pmlEdmDocumentRelation = findByPrimaryKey(documentRelationId);

        int count = countByDocRightId_RightIsReceipt(docRightId, rightIsReceipt);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlEdmDocumentRelation WHERE ");

            query.append("docrightid = ?");

            query.append(" AND ");

            query.append("rightisreceipt = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(docRightId);

            qPos.add(rightIsReceipt);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRelation);

            PmlEdmDocumentRelation[] array = new PmlEdmDocumentRelationImpl[3];

            array[0] = (PmlEdmDocumentRelation) objArray[0];
            array[1] = (PmlEdmDocumentRelation) objArray[1];
            array[2] = (PmlEdmDocumentRelation) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentRelation findByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt)
        throws NoSuchPmlEdmDocumentRelationException, SystemException {
        PmlEdmDocumentRelation pmlEdmDocumentRelation = fetchByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(docLeftId,
                docRightId, leftIsReceipt, rightIsReceipt);

        if (pmlEdmDocumentRelation == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRelation exists with the key {");

            msg.append("docLeftId=" + docLeftId);

            msg.append(", ");
            msg.append("docRightId=" + docRightId);

            msg.append(", ");
            msg.append("leftIsReceipt=" + leftIsReceipt);

            msg.append(", ");
            msg.append("rightIsReceipt=" + rightIsReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPmlEdmDocumentRelationException(msg.toString());
        }

        return pmlEdmDocumentRelation;
    }

    public PmlEdmDocumentRelation fetchByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRelationModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRelation.class.getName();
        String finderMethodName = "fetchByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Boolean.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(docLeftId), new Long(docRightId),
                Boolean.valueOf(leftIsReceipt), Boolean.valueOf(rightIsReceipt)
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
                    "FROM com.sgs.portlet.document.model.PmlEdmDocumentRelation WHERE ");

                query.append("docleftid = ?");

                query.append(" AND ");

                query.append("docrightid = ?");

                query.append(" AND ");

                query.append("leftisreceipt = ?");

                query.append(" AND ");

                query.append("rightisreceipt = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docLeftId);

                qPos.add(docRightId);

                qPos.add(leftIsReceipt);

                qPos.add(rightIsReceipt);

                List<PmlEdmDocumentRelation> list = q.list();

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
            List<PmlEdmDocumentRelation> list = (List<PmlEdmDocumentRelation>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
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

    public List<PmlEdmDocumentRelation> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmDocumentRelation> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmDocumentRelation> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRelationModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRelation.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlEdmDocumentRelation ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmDocumentRelation> list = (List<PmlEdmDocumentRelation>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRelation>) result;
        }
    }

    public void removeByDocLeftId_LeftIsReceipt(long docLeftId,
        boolean leftIsReceipt) throws SystemException {
        for (PmlEdmDocumentRelation pmlEdmDocumentRelation : findByDocLeftId_LeftIsReceipt(
                docLeftId, leftIsReceipt)) {
            remove(pmlEdmDocumentRelation);
        }
    }

    public void removeByDocRightId_RightIsReceipt(long docRightId,
        boolean rightIsReceipt) throws SystemException {
        for (PmlEdmDocumentRelation pmlEdmDocumentRelation : findByDocRightId_RightIsReceipt(
                docRightId, rightIsReceipt)) {
            remove(pmlEdmDocumentRelation);
        }
    }

    public void removeByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt)
        throws NoSuchPmlEdmDocumentRelationException, SystemException {
        PmlEdmDocumentRelation pmlEdmDocumentRelation = findByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(docLeftId,
                docRightId, leftIsReceipt, rightIsReceipt);

        remove(pmlEdmDocumentRelation);
    }

    public void removeAll() throws SystemException {
        for (PmlEdmDocumentRelation pmlEdmDocumentRelation : findAll()) {
            remove(pmlEdmDocumentRelation);
        }
    }

    public int countByDocLeftId_LeftIsReceipt(long docLeftId,
        boolean leftIsReceipt) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRelationModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRelation.class.getName();
        String finderMethodName = "countByDocLeftId_LeftIsReceipt";
        String[] finderParams = new String[] {
                Long.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(docLeftId), Boolean.valueOf(leftIsReceipt)
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
                    "FROM com.sgs.portlet.document.model.PmlEdmDocumentRelation WHERE ");

                query.append("docleftid = ?");

                query.append(" AND ");

                query.append("leftisreceipt = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docLeftId);

                qPos.add(leftIsReceipt);

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

    public int countByDocRightId_RightIsReceipt(long docRightId,
        boolean rightIsReceipt) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRelationModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRelation.class.getName();
        String finderMethodName = "countByDocRightId_RightIsReceipt";
        String[] finderParams = new String[] {
                Long.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(docRightId), Boolean.valueOf(rightIsReceipt)
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
                    "FROM com.sgs.portlet.document.model.PmlEdmDocumentRelation WHERE ");

                query.append("docrightid = ?");

                query.append(" AND ");

                query.append("rightisreceipt = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docRightId);

                qPos.add(rightIsReceipt);

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

    public int countByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt(
        long docLeftId, long docRightId, boolean leftIsReceipt,
        boolean rightIsReceipt) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRelationModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRelation.class.getName();
        String finderMethodName = "countByDocLeftId_DocRightId_LeftIsReceipt_RightIsReceipt";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Boolean.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(docLeftId), new Long(docRightId),
                Boolean.valueOf(leftIsReceipt), Boolean.valueOf(rightIsReceipt)
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
                    "FROM com.sgs.portlet.document.model.PmlEdmDocumentRelation WHERE ");

                query.append("docleftid = ?");

                query.append(" AND ");

                query.append("docrightid = ?");

                query.append(" AND ");

                query.append("leftisreceipt = ?");

                query.append(" AND ");

                query.append("rightisreceipt = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docLeftId);

                qPos.add(docRightId);

                qPos.add(leftIsReceipt);

                qPos.add(rightIsReceipt);

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRelationModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRelation.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.model.PmlEdmDocumentRelation");

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
                        "value.object.listener.com.sgs.portlet.document.model.PmlEdmDocumentRelation")));

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
