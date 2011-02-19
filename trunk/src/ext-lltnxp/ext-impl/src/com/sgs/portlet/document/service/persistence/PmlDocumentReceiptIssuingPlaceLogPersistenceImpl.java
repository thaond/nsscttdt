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

import com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException;
import com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog;
import com.sgs.portlet.document.model.impl.PmlDocumentReceiptIssuingPlaceLogImpl;
import com.sgs.portlet.document.model.impl.PmlDocumentReceiptIssuingPlaceLogModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlDocumentReceiptIssuingPlaceLogPersistenceImpl
    extends BasePersistenceImpl
    implements PmlDocumentReceiptIssuingPlaceLogPersistence {
    private static Log _log = LogFactory.getLog(PmlDocumentReceiptIssuingPlaceLogPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlDocumentReceiptIssuingPlaceLog create(
        long documentReceiptIssuingPlaceLogId) {
        PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog = new PmlDocumentReceiptIssuingPlaceLogImpl();

        pmlDocumentReceiptIssuingPlaceLog.setNew(true);
        pmlDocumentReceiptIssuingPlaceLog.setPrimaryKey(documentReceiptIssuingPlaceLogId);

        return pmlDocumentReceiptIssuingPlaceLog;
    }

    public PmlDocumentReceiptIssuingPlaceLog remove(
        long documentReceiptIssuingPlaceLogId)
        throws NoSuchReceiptIssuingPlaceLogException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog = (PmlDocumentReceiptIssuingPlaceLog) session.get(PmlDocumentReceiptIssuingPlaceLogImpl.class,
                    new Long(documentReceiptIssuingPlaceLogId));

            if (pmlDocumentReceiptIssuingPlaceLog == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlDocumentReceiptIssuingPlaceLog exists with the primary key " +
                        documentReceiptIssuingPlaceLogId);
                }

                throw new NoSuchReceiptIssuingPlaceLogException(
                    "No PmlDocumentReceiptIssuingPlaceLog exists with the primary key " +
                    documentReceiptIssuingPlaceLogId);
            }

            return remove(pmlDocumentReceiptIssuingPlaceLog);
        } catch (NoSuchReceiptIssuingPlaceLogException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlDocumentReceiptIssuingPlaceLog remove(
        PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlDocumentReceiptIssuingPlaceLog);
            }
        }

        pmlDocumentReceiptIssuingPlaceLog = removeImpl(pmlDocumentReceiptIssuingPlaceLog);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlDocumentReceiptIssuingPlaceLog);
            }
        }

        return pmlDocumentReceiptIssuingPlaceLog;
    }

    protected PmlDocumentReceiptIssuingPlaceLog removeImpl(
        PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlDocumentReceiptIssuingPlaceLog);

            session.flush();

            return pmlDocumentReceiptIssuingPlaceLog;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDocumentReceiptIssuingPlaceLog.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog, boolean merge)</code>.
     */
    public PmlDocumentReceiptIssuingPlaceLog update(
        PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog) method. Use update(PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog, boolean merge) instead.");
        }

        return update(pmlDocumentReceiptIssuingPlaceLog, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentReceiptIssuingPlaceLog the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentReceiptIssuingPlaceLog is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlDocumentReceiptIssuingPlaceLog update(
        PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog,
        boolean merge) throws SystemException {
        boolean isNew = pmlDocumentReceiptIssuingPlaceLog.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlDocumentReceiptIssuingPlaceLog);
                } else {
                    listener.onBeforeUpdate(pmlDocumentReceiptIssuingPlaceLog);
                }
            }
        }

        pmlDocumentReceiptIssuingPlaceLog = updateImpl(pmlDocumentReceiptIssuingPlaceLog,
                merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlDocumentReceiptIssuingPlaceLog);
                } else {
                    listener.onAfterUpdate(pmlDocumentReceiptIssuingPlaceLog);
                }
            }
        }

        return pmlDocumentReceiptIssuingPlaceLog;
    }

    public PmlDocumentReceiptIssuingPlaceLog updateImpl(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlDocumentReceiptIssuingPlaceLog);
            } else {
                if (pmlDocumentReceiptIssuingPlaceLog.isNew()) {
                    session.save(pmlDocumentReceiptIssuingPlaceLog);
                }
            }

            session.flush();

            pmlDocumentReceiptIssuingPlaceLog.setNew(false);

            return pmlDocumentReceiptIssuingPlaceLog;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDocumentReceiptIssuingPlaceLog.class.getName());
        }
    }

    public PmlDocumentReceiptIssuingPlaceLog findByPrimaryKey(
        long documentReceiptIssuingPlaceLogId)
        throws NoSuchReceiptIssuingPlaceLogException, SystemException {
        PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog = fetchByPrimaryKey(documentReceiptIssuingPlaceLogId);

        if (pmlDocumentReceiptIssuingPlaceLog == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlDocumentReceiptIssuingPlaceLog exists with the primary key " +
                    documentReceiptIssuingPlaceLogId);
            }

            throw new NoSuchReceiptIssuingPlaceLogException(
                "No PmlDocumentReceiptIssuingPlaceLog exists with the primary key " +
                documentReceiptIssuingPlaceLogId);
        }

        return pmlDocumentReceiptIssuingPlaceLog;
    }

    public PmlDocumentReceiptIssuingPlaceLog fetchByPrimaryKey(
        long documentReceiptIssuingPlaceLogId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlDocumentReceiptIssuingPlaceLog) session.get(PmlDocumentReceiptIssuingPlaceLogImpl.class,
                new Long(documentReceiptIssuingPlaceLogId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptIssuingPlaceLog> findByDoc_Proc_Step(
        long documentReceiptId, long processor, int step)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptIssuingPlaceLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptIssuingPlaceLog.class.getName();
        String finderMethodName = "findByDoc_Proc_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processor),
                new Integer(step)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog WHERE ");

                query.append("documentReceiptId = ?");

                query.append(" AND ");

                query.append("processor = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processor);

                qPos.add(step);

                List<PmlDocumentReceiptIssuingPlaceLog> list = q.list();

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
            return (List<PmlDocumentReceiptIssuingPlaceLog>) result;
        }
    }

    public List<PmlDocumentReceiptIssuingPlaceLog> findByDoc_Proc_Step(
        long documentReceiptId, long processor, int step, int start, int end)
        throws SystemException {
        return findByDoc_Proc_Step(documentReceiptId, processor, step, start,
            end, null);
    }

    public List<PmlDocumentReceiptIssuingPlaceLog> findByDoc_Proc_Step(
        long documentReceiptId, long processor, int step, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptIssuingPlaceLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptIssuingPlaceLog.class.getName();
        String finderMethodName = "findByDoc_Proc_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processor),
                new Integer(step),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog WHERE ");

                query.append("documentReceiptId = ?");

                query.append(" AND ");

                query.append("processor = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processor);

                qPos.add(step);

                List<PmlDocumentReceiptIssuingPlaceLog> list = (List<PmlDocumentReceiptIssuingPlaceLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptIssuingPlaceLog>) result;
        }
    }

    public PmlDocumentReceiptIssuingPlaceLog findByDoc_Proc_Step_First(
        long documentReceiptId, long processor, int step, OrderByComparator obc)
        throws NoSuchReceiptIssuingPlaceLogException, SystemException {
        List<PmlDocumentReceiptIssuingPlaceLog> list = findByDoc_Proc_Step(documentReceiptId,
                processor, step, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append(
                "No PmlDocumentReceiptIssuingPlaceLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("processor=" + processor);

            msg.append(", ");
            msg.append("step=" + step);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptIssuingPlaceLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptIssuingPlaceLog findByDoc_Proc_Step_Last(
        long documentReceiptId, long processor, int step, OrderByComparator obc)
        throws NoSuchReceiptIssuingPlaceLogException, SystemException {
        int count = countByDoc_Proc_Step(documentReceiptId, processor, step);

        List<PmlDocumentReceiptIssuingPlaceLog> list = findByDoc_Proc_Step(documentReceiptId,
                processor, step, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append(
                "No PmlDocumentReceiptIssuingPlaceLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("processor=" + processor);

            msg.append(", ");
            msg.append("step=" + step);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptIssuingPlaceLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptIssuingPlaceLog[] findByDoc_Proc_Step_PrevAndNext(
        long documentReceiptIssuingPlaceLogId, long documentReceiptId,
        long processor, int step, OrderByComparator obc)
        throws NoSuchReceiptIssuingPlaceLogException, SystemException {
        PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog = findByPrimaryKey(documentReceiptIssuingPlaceLogId);

        int count = countByDoc_Proc_Step(documentReceiptId, processor, step);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog WHERE ");

            query.append("documentReceiptId = ?");

            query.append(" AND ");

            query.append("processor = ?");

            query.append(" AND ");

            query.append("step = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(processor);

            qPos.add(step);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptIssuingPlaceLog);

            PmlDocumentReceiptIssuingPlaceLog[] array = new PmlDocumentReceiptIssuingPlaceLogImpl[3];

            array[0] = (PmlDocumentReceiptIssuingPlaceLog) objArray[0];
            array[1] = (PmlDocumentReceiptIssuingPlaceLog) objArray[1];
            array[2] = (PmlDocumentReceiptIssuingPlaceLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptIssuingPlaceLog> findByDoc_Step(
        long documentReceiptId, int step) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptIssuingPlaceLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptIssuingPlaceLog.class.getName();
        String finderMethodName = "findByDoc_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Integer(step)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog WHERE ");

                query.append("documentReceiptId = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(step);

                List<PmlDocumentReceiptIssuingPlaceLog> list = q.list();

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
            return (List<PmlDocumentReceiptIssuingPlaceLog>) result;
        }
    }

    public List<PmlDocumentReceiptIssuingPlaceLog> findByDoc_Step(
        long documentReceiptId, int step, int start, int end)
        throws SystemException {
        return findByDoc_Step(documentReceiptId, step, start, end, null);
    }

    public List<PmlDocumentReceiptIssuingPlaceLog> findByDoc_Step(
        long documentReceiptId, int step, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptIssuingPlaceLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptIssuingPlaceLog.class.getName();
        String finderMethodName = "findByDoc_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Integer(step),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog WHERE ");

                query.append("documentReceiptId = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(step);

                List<PmlDocumentReceiptIssuingPlaceLog> list = (List<PmlDocumentReceiptIssuingPlaceLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptIssuingPlaceLog>) result;
        }
    }

    public PmlDocumentReceiptIssuingPlaceLog findByDoc_Step_First(
        long documentReceiptId, int step, OrderByComparator obc)
        throws NoSuchReceiptIssuingPlaceLogException, SystemException {
        List<PmlDocumentReceiptIssuingPlaceLog> list = findByDoc_Step(documentReceiptId,
                step, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append(
                "No PmlDocumentReceiptIssuingPlaceLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("step=" + step);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptIssuingPlaceLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptIssuingPlaceLog findByDoc_Step_Last(
        long documentReceiptId, int step, OrderByComparator obc)
        throws NoSuchReceiptIssuingPlaceLogException, SystemException {
        int count = countByDoc_Step(documentReceiptId, step);

        List<PmlDocumentReceiptIssuingPlaceLog> list = findByDoc_Step(documentReceiptId,
                step, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append(
                "No PmlDocumentReceiptIssuingPlaceLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("step=" + step);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptIssuingPlaceLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptIssuingPlaceLog[] findByDoc_Step_PrevAndNext(
        long documentReceiptIssuingPlaceLogId, long documentReceiptId,
        int step, OrderByComparator obc)
        throws NoSuchReceiptIssuingPlaceLogException, SystemException {
        PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog = findByPrimaryKey(documentReceiptIssuingPlaceLogId);

        int count = countByDoc_Step(documentReceiptId, step);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog WHERE ");

            query.append("documentReceiptId = ?");

            query.append(" AND ");

            query.append("step = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(step);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptIssuingPlaceLog);

            PmlDocumentReceiptIssuingPlaceLog[] array = new PmlDocumentReceiptIssuingPlaceLogImpl[3];

            array[0] = (PmlDocumentReceiptIssuingPlaceLog) objArray[0];
            array[1] = (PmlDocumentReceiptIssuingPlaceLog) objArray[1];
            array[2] = (PmlDocumentReceiptIssuingPlaceLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptIssuingPlaceLog> findByDocId(
        long documentReceiptId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptIssuingPlaceLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptIssuingPlaceLog.class.getName();
        String finderMethodName = "findByDocId";
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog WHERE ");

                query.append("documentReceiptId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlDocumentReceiptIssuingPlaceLog> list = q.list();

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
            return (List<PmlDocumentReceiptIssuingPlaceLog>) result;
        }
    }

    public List<PmlDocumentReceiptIssuingPlaceLog> findByDocId(
        long documentReceiptId, int start, int end) throws SystemException {
        return findByDocId(documentReceiptId, start, end, null);
    }

    public List<PmlDocumentReceiptIssuingPlaceLog> findByDocId(
        long documentReceiptId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptIssuingPlaceLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptIssuingPlaceLog.class.getName();
        String finderMethodName = "findByDocId";
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog WHERE ");

                query.append("documentReceiptId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlDocumentReceiptIssuingPlaceLog> list = (List<PmlDocumentReceiptIssuingPlaceLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptIssuingPlaceLog>) result;
        }
    }

    public PmlDocumentReceiptIssuingPlaceLog findByDocId_First(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchReceiptIssuingPlaceLogException, SystemException {
        List<PmlDocumentReceiptIssuingPlaceLog> list = findByDocId(documentReceiptId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append(
                "No PmlDocumentReceiptIssuingPlaceLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptIssuingPlaceLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptIssuingPlaceLog findByDocId_Last(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchReceiptIssuingPlaceLogException, SystemException {
        int count = countByDocId(documentReceiptId);

        List<PmlDocumentReceiptIssuingPlaceLog> list = findByDocId(documentReceiptId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append(
                "No PmlDocumentReceiptIssuingPlaceLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptIssuingPlaceLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptIssuingPlaceLog[] findByDocId_PrevAndNext(
        long documentReceiptIssuingPlaceLogId, long documentReceiptId,
        OrderByComparator obc)
        throws NoSuchReceiptIssuingPlaceLogException, SystemException {
        PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog = findByPrimaryKey(documentReceiptIssuingPlaceLogId);

        int count = countByDocId(documentReceiptId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog WHERE ");

            query.append("documentReceiptId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptIssuingPlaceLog);

            PmlDocumentReceiptIssuingPlaceLog[] array = new PmlDocumentReceiptIssuingPlaceLogImpl[3];

            array[0] = (PmlDocumentReceiptIssuingPlaceLog) objArray[0];
            array[1] = (PmlDocumentReceiptIssuingPlaceLog) objArray[1];
            array[2] = (PmlDocumentReceiptIssuingPlaceLog) objArray[2];

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

    public List<PmlDocumentReceiptIssuingPlaceLog> findAll()
        throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlDocumentReceiptIssuingPlaceLog> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlDocumentReceiptIssuingPlaceLog> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptIssuingPlaceLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptIssuingPlaceLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlDocumentReceiptIssuingPlaceLog> list = (List<PmlDocumentReceiptIssuingPlaceLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptIssuingPlaceLog>) result;
        }
    }

    public void removeByDoc_Proc_Step(long documentReceiptId, long processor,
        int step) throws SystemException {
        for (PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog : findByDoc_Proc_Step(
                documentReceiptId, processor, step)) {
            remove(pmlDocumentReceiptIssuingPlaceLog);
        }
    }

    public void removeByDoc_Step(long documentReceiptId, int step)
        throws SystemException {
        for (PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog : findByDoc_Step(
                documentReceiptId, step)) {
            remove(pmlDocumentReceiptIssuingPlaceLog);
        }
    }

    public void removeByDocId(long documentReceiptId) throws SystemException {
        for (PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog : findByDocId(
                documentReceiptId)) {
            remove(pmlDocumentReceiptIssuingPlaceLog);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog : findAll()) {
            remove(pmlDocumentReceiptIssuingPlaceLog);
        }
    }

    public int countByDoc_Proc_Step(long documentReceiptId, long processor,
        int step) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptIssuingPlaceLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptIssuingPlaceLog.class.getName();
        String finderMethodName = "countByDoc_Proc_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processor),
                new Integer(step)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog WHERE ");

                query.append("documentReceiptId = ?");

                query.append(" AND ");

                query.append("processor = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processor);

                qPos.add(step);

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

    public int countByDoc_Step(long documentReceiptId, int step)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptIssuingPlaceLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptIssuingPlaceLog.class.getName();
        String finderMethodName = "countByDoc_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Integer(step)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog WHERE ");

                query.append("documentReceiptId = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(step);

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

    public int countByDocId(long documentReceiptId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptIssuingPlaceLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptIssuingPlaceLog.class.getName();
        String finderMethodName = "countByDocId";
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog WHERE ");

                query.append("documentReceiptId = ?");

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
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptIssuingPlaceLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptIssuingPlaceLog.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog");

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
                        "value.object.listener.com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog")));

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
