package com.sgs.portlet.document.service.persistence;

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

import com.sgs.portlet.document.NoSuchReceiptLogException;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.model.impl.PmlDocumentReceiptLogImpl;
import com.sgs.portlet.document.model.impl.PmlDocumentReceiptLogModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlDocumentReceiptLogPersistenceImpl extends BasePersistenceImpl
    implements PmlDocumentReceiptLogPersistence {
    private static Log _log = LogFactory.getLog(PmlDocumentReceiptLogPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlDocumentReceiptLog create(long documentReceiptLogId) {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = new PmlDocumentReceiptLogImpl();

        pmlDocumentReceiptLog.setNew(true);
        pmlDocumentReceiptLog.setPrimaryKey(documentReceiptLogId);

        return pmlDocumentReceiptLog;
    }

    public PmlDocumentReceiptLog remove(long documentReceiptLogId)
        throws NoSuchReceiptLogException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlDocumentReceiptLog pmlDocumentReceiptLog = (PmlDocumentReceiptLog) session.get(PmlDocumentReceiptLogImpl.class,
                    new Long(documentReceiptLogId));

            if (pmlDocumentReceiptLog == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlDocumentReceiptLog exists with the primary key " +
                        documentReceiptLogId);
                }

                throw new NoSuchReceiptLogException(
                    "No PmlDocumentReceiptLog exists with the primary key " +
                    documentReceiptLogId);
            }

            return remove(pmlDocumentReceiptLog);
        } catch (NoSuchReceiptLogException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlDocumentReceiptLog remove(
        PmlDocumentReceiptLog pmlDocumentReceiptLog) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlDocumentReceiptLog);
            }
        }

        pmlDocumentReceiptLog = removeImpl(pmlDocumentReceiptLog);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlDocumentReceiptLog);
            }
        }

        return pmlDocumentReceiptLog;
    }

    protected PmlDocumentReceiptLog removeImpl(
        PmlDocumentReceiptLog pmlDocumentReceiptLog) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlDocumentReceiptLog);

            session.flush();

            return pmlDocumentReceiptLog;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDocumentReceiptLog.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlDocumentReceiptLog pmlDocumentReceiptLog, boolean merge)</code>.
     */
    public PmlDocumentReceiptLog update(
        PmlDocumentReceiptLog pmlDocumentReceiptLog) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlDocumentReceiptLog pmlDocumentReceiptLog) method. Use update(PmlDocumentReceiptLog pmlDocumentReceiptLog, boolean merge) instead.");
        }

        return update(pmlDocumentReceiptLog, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentReceiptLog the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentReceiptLog is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlDocumentReceiptLog update(
        PmlDocumentReceiptLog pmlDocumentReceiptLog, boolean merge)
        throws SystemException {
        boolean isNew = pmlDocumentReceiptLog.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlDocumentReceiptLog);
                } else {
                    listener.onBeforeUpdate(pmlDocumentReceiptLog);
                }
            }
        }

        pmlDocumentReceiptLog = updateImpl(pmlDocumentReceiptLog, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlDocumentReceiptLog);
                } else {
                    listener.onAfterUpdate(pmlDocumentReceiptLog);
                }
            }
        }

        return pmlDocumentReceiptLog;
    }

    public PmlDocumentReceiptLog updateImpl(
        com.sgs.portlet.document.model.PmlDocumentReceiptLog pmlDocumentReceiptLog,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlDocumentReceiptLog);
            } else {
                if (pmlDocumentReceiptLog.isNew()) {
                    session.save(pmlDocumentReceiptLog);
                }
            }

            session.flush();

            pmlDocumentReceiptLog.setNew(false);

            return pmlDocumentReceiptLog;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDocumentReceiptLog.class.getName());
        }
    }

    public PmlDocumentReceiptLog findByPrimaryKey(long documentReceiptLogId)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = fetchByPrimaryKey(documentReceiptLogId);

        if (pmlDocumentReceiptLog == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlDocumentReceiptLog exists with the primary key " +
                    documentReceiptLogId);
            }

            throw new NoSuchReceiptLogException(
                "No PmlDocumentReceiptLog exists with the primary key " +
                documentReceiptLogId);
        }

        return pmlDocumentReceiptLog;
    }

    public PmlDocumentReceiptLog fetchByPrimaryKey(long documentReceiptLogId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlDocumentReceiptLog) session.get(PmlDocumentReceiptLogImpl.class,
                new Long(documentReceiptLogId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByProcessInstanceId_StateProcessIdBefore_DateProcess";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(processInstanceId), new Long(stateProcessIdBefore),
                
                dateProcess
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processinstanceid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" AND ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(stateProcessIdBefore);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess,
        int start, int end) throws SystemException {
        return findByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
            stateProcessIdBefore, dateProcess, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByProcessInstanceId_StateProcessIdBefore_DateProcess";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(processInstanceId), new Long(stateProcessIdBefore),
                
                dateProcess,
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processinstanceid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" AND ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(stateProcessIdBefore);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByProcessInstanceId_StateProcessIdBefore_DateProcess_First(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
                stateProcessIdBefore, dateProcess, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(", ");
            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByProcessInstanceId_StateProcessIdBefore_DateProcess_Last(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
                stateProcessIdBefore, dateProcess);

        List<PmlDocumentReceiptLog> list = findByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
                stateProcessIdBefore, dateProcess, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(", ");
            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByProcessInstanceId_StateProcessIdBefore_DateProcess_PrevAndNext(
        long documentReceiptLogId, long processInstanceId,
        long stateProcessIdBefore, Date dateProcess, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
                stateProcessIdBefore, dateProcess);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("processinstanceid = ?");

            query.append(" AND ");

            query.append("stateprocessidbefore = ?");

            query.append(" AND ");

            if (dateProcess == null) {
                query.append("dateprocess IS NULL");
            } else {
                query.append("dateprocess = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processInstanceId);

            qPos.add(stateProcessIdBefore);

            if (dateProcess != null) {
                qPos.add(CalendarUtil.getTimestamp(dateProcess));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByProcessInstanceId_StateProcessIdAfter_DateProcess";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(processInstanceId), new Long(stateProcessIdAfter),
                
                dateProcess
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processinstanceid = ?");

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" AND ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(stateProcessIdAfter);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess,
        int start, int end) throws SystemException {
        return findByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
            stateProcessIdAfter, dateProcess, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByProcessInstanceId_StateProcessIdAfter_DateProcess";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(processInstanceId), new Long(stateProcessIdAfter),
                
                dateProcess,
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processinstanceid = ?");

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" AND ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(stateProcessIdAfter);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByProcessInstanceId_StateProcessIdAfter_DateProcess_First(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
                stateProcessIdAfter, dateProcess, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(", ");
            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByProcessInstanceId_StateProcessIdAfter_DateProcess_Last(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
                stateProcessIdAfter, dateProcess);

        List<PmlDocumentReceiptLog> list = findByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
                stateProcessIdAfter, dateProcess, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(", ");
            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByProcessInstanceId_StateProcessIdAfter_DateProcess_PrevAndNext(
        long documentReceiptLogId, long processInstanceId,
        long stateProcessIdAfter, Date dateProcess, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
                stateProcessIdAfter, dateProcess);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("processinstanceid = ?");

            query.append(" AND ");

            query.append("stateprocessidafter = ?");

            query.append(" AND ");

            if (dateProcess == null) {
                query.append("dateprocess IS NULL");
            } else {
                query.append("dateprocess = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processInstanceId);

            qPos.add(stateProcessIdAfter);

            if (dateProcess != null) {
                qPos.add(CalendarUtil.getTimestamp(dateProcess));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByNumDateProcess(int numDateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByNumDateProcess";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(numDateProcess) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("numdateprocess = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(numDateProcess);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByNumDateProcess(
        int numDateProcess, int start, int end) throws SystemException {
        return findByNumDateProcess(numDateProcess, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByNumDateProcess(
        int numDateProcess, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByNumDateProcess";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(numDateProcess),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("numdateprocess = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(numDateProcess);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByNumDateProcess_First(
        int numDateProcess, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByNumDateProcess(numDateProcess,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("numDateProcess=" + numDateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByNumDateProcess_Last(int numDateProcess,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByNumDateProcess(numDateProcess);

        List<PmlDocumentReceiptLog> list = findByNumDateProcess(numDateProcess,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("numDateProcess=" + numDateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByNumDateProcess_PrevAndNext(
        long documentReceiptLogId, int numDateProcess, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByNumDateProcess(numDateProcess);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("numdateprocess = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(numDateProcess);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByExpiredDate(Date expiredDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByExpiredDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { expiredDate };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (expiredDate == null) {
                    query.append("expireddate IS NULL");
                } else {
                    query.append("expireddate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (expiredDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(expiredDate));
                }

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByExpiredDate(Date expiredDate,
        int start, int end) throws SystemException {
        return findByExpiredDate(expiredDate, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByExpiredDate(Date expiredDate,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByExpiredDate";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                expiredDate,
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (expiredDate == null) {
                    query.append("expireddate IS NULL");
                } else {
                    query.append("expireddate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (expiredDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(expiredDate));
                }

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByExpiredDate_First(Date expiredDate,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByExpiredDate(expiredDate, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("expiredDate=" + expiredDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByExpiredDate_Last(Date expiredDate,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByExpiredDate(expiredDate);

        List<PmlDocumentReceiptLog> list = findByExpiredDate(expiredDate,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("expiredDate=" + expiredDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByExpiredDate_PrevAndNext(
        long documentReceiptLogId, Date expiredDate, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByExpiredDate(expiredDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            if (expiredDate == null) {
                query.append("expireddate IS NULL");
            } else {
                query.append("expireddate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (expiredDate != null) {
                qPos.add(CalendarUtil.getTimestamp(expiredDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Transition(
        long documentReceiptId, int transition_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Transition";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Integer(transition_)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("transition_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(transition_);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Transition(
        long documentReceiptId, int transition_, int start, int end)
        throws SystemException {
        return findByDocumentReceiptId_Transition(documentReceiptId,
            transition_, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Transition(
        long documentReceiptId, int transition_, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Transition";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Integer(transition_),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("transition_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(transition_);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Transition_First(
        long documentReceiptId, int transition_, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Transition(documentReceiptId,
                transition_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Transition_Last(
        long documentReceiptId, int transition_, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId_Transition(documentReceiptId,
                transition_);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Transition(documentReceiptId,
                transition_, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_Transition_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, int transition_,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId_Transition(documentReceiptId,
                transition_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("transition_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(transition_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Step(
        long documentReceiptId, int step) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Step";
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(step);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Step(
        long documentReceiptId, int step, int start, int end)
        throws SystemException {
        return findByDocumentReceiptId_Step(documentReceiptId, step, start,
            end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Step(
        long documentReceiptId, int step, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Step";
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(step);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Step_First(
        long documentReceiptId, int step, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Step(documentReceiptId,
                step, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("step=" + step);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Step_Last(
        long documentReceiptId, int step, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId_Step(documentReceiptId, step);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Step(documentReceiptId,
                step, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("step=" + step);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_Step_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, int step,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId_Step(documentReceiptId, step);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("step = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(step);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Type(
        long documentReceiptId, int type_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Integer(type_)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(type_);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Type(
        long documentReceiptId, int type_, int start, int end)
        throws SystemException {
        return findByDocumentReceiptId_Type(documentReceiptId, type_, start,
            end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Type(
        long documentReceiptId, int type_, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Integer(type_),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(type_);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Type_First(
        long documentReceiptId, int type_, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Type(documentReceiptId,
                type_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("type_=" + type_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Type_Last(
        long documentReceiptId, int type_, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId_Type(documentReceiptId, type_);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Type(documentReceiptId,
                type_, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("type_=" + type_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_Type_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, int type_,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId_Type(documentReceiptId, type_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("type_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(type_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_StateProcessIdBefore";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(stateProcessIdBefore)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(stateProcessIdBefore);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore, int start, int end)
        throws SystemException {
        return findByDocumentReceiptId_StateProcessIdBefore(documentReceiptId,
            stateProcessIdBefore, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_StateProcessIdBefore";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(stateProcessIdBefore),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(stateProcessIdBefore);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_First(
        long documentReceiptId, long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_StateProcessIdBefore(documentReceiptId,
                stateProcessIdBefore, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Last(
        long documentReceiptId, long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId_StateProcessIdBefore(documentReceiptId,
                stateProcessIdBefore);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_StateProcessIdBefore(documentReceiptId,
                stateProcessIdBefore, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_StateProcessIdBefore_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId,
        long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId_StateProcessIdBefore(documentReceiptId,
                stateProcessIdBefore);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("stateprocessidbefore = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(stateProcessIdBefore);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByProcesser(long processer)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByProcesser";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(processer) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processer = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processer);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByProcesser(long processer,
        int start, int end) throws SystemException {
        return findByProcesser(processer, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByProcesser(long processer,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByProcesser";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(processer),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processer = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processer);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByProcesser_First(long processer,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByProcesser(processer, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByProcesser_Last(long processer,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByProcesser(processer);

        List<PmlDocumentReceiptLog> list = findByProcesser(processer,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByProcesser_PrevAndNext(
        long documentReceiptLogId, long processer, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByProcesser(processer);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("processer = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processer);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDateProcess(Date dateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDateProcess";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateProcess };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDateProcess(Date dateProcess,
        int start, int end) throws SystemException {
        return findByDateProcess(dateProcess, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDateProcess(Date dateProcess,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDateProcess";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                dateProcess,
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDateProcess_First(Date dateProcess,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDateProcess(dateProcess, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDateProcess_Last(Date dateProcess,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDateProcess(dateProcess);

        List<PmlDocumentReceiptLog> list = findByDateProcess(dateProcess,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDateProcess_PrevAndNext(
        long documentReceiptLogId, Date dateProcess, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDateProcess(dateProcess);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            if (dateProcess == null) {
                query.append("dateprocess IS NULL");
            } else {
                query.append("dateprocess = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateProcess != null) {
                qPos.add(CalendarUtil.getTimestamp(dateProcess));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByReceiver(long receiver)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByReceiver";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(receiver) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByReceiver(long receiver, int start,
        int end) throws SystemException {
        return findByReceiver(receiver, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByReceiver(long receiver, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByReceiver";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByReceiver_First(long receiver,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByReceiver(receiver, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByReceiver_Last(long receiver,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByReceiver(receiver);

        List<PmlDocumentReceiptLog> list = findByReceiver(receiver, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByReceiver_PrevAndNext(
        long documentReceiptLogId, long receiver, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByReceiver(receiver);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("receiver = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(receiver);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByReceiveDate(Date receiveDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByReceiveDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { receiveDate };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (receiveDate == null) {
                    query.append("receivedate IS NULL");
                } else {
                    query.append("receivedate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByReceiveDate(Date receiveDate,
        int start, int end) throws SystemException {
        return findByReceiveDate(receiveDate, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByReceiveDate(Date receiveDate,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByReceiveDate";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                receiveDate,
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (receiveDate == null) {
                    query.append("receivedate IS NULL");
                } else {
                    query.append("receivedate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByReceiveDate_First(Date receiveDate,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByReceiveDate(receiveDate, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("receiveDate=" + receiveDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByReceiveDate_Last(Date receiveDate,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByReceiveDate(receiveDate);

        List<PmlDocumentReceiptLog> list = findByReceiveDate(receiveDate,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("receiveDate=" + receiveDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByReceiveDate_PrevAndNext(
        long documentReceiptLogId, Date receiveDate, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByReceiveDate(receiveDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            if (receiveDate == null) {
                query.append("receivedate IS NULL");
            } else {
                query.append("receivedate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (receiveDate != null) {
                qPos.add(CalendarUtil.getTimestamp(receiveDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByStateProcessIdBefore(
        long stateProcessIdBefore) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByStateProcessIdBefore";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessIdBefore) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdBefore);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end)
        throws SystemException {
        return findByStateProcessIdBefore(stateProcessIdBefore, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByStateProcessIdBefore";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(stateProcessIdBefore),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdBefore);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByStateProcessIdBefore_First(
        long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByStateProcessIdBefore(stateProcessIdBefore,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByStateProcessIdBefore_Last(
        long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByStateProcessIdBefore(stateProcessIdBefore);

        List<PmlDocumentReceiptLog> list = findByStateProcessIdBefore(stateProcessIdBefore,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByStateProcessIdBefore_PrevAndNext(
        long documentReceiptLogId, long stateProcessIdBefore,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByStateProcessIdBefore(stateProcessIdBefore);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("stateprocessidbefore = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessIdBefore);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByStateProcessIdAfter(
        long stateProcessIdAfter) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByStateProcessIdAfter";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessIdAfter) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdAfter);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end) throws SystemException {
        return findByStateProcessIdAfter(stateProcessIdAfter, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByStateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(stateProcessIdAfter),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdAfter);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByStateProcessIdAfter_First(
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByStateProcessIdAfter(stateProcessIdAfter,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByStateProcessIdAfter_Last(
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByStateProcessIdAfter(stateProcessIdAfter);

        List<PmlDocumentReceiptLog> list = findByStateProcessIdAfter(stateProcessIdAfter,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByStateProcessIdAfter_PrevAndNext(
        long documentReceiptLogId, long stateProcessIdAfter,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByStateProcessIdAfter(stateProcessIdAfter);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("stateprocessidafter = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessIdAfter);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByType(int type_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByType";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(type_) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("type_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(type_);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByType(int type_, int start, int end)
        throws SystemException {
        return findByType(type_, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByType(int type_, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByType";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(type_),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("type_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(type_);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByType_First(int type_,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByType(type_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("type_=" + type_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByType_Last(int type_,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByType(type_);

        List<PmlDocumentReceiptLog> list = findByType(type_, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("type_=" + type_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByType_PrevAndNext(
        long documentReceiptLogId, int type_, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByType(type_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("type_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(type_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId(
        long documentReceiptId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId(
        long documentReceiptId, int start, int end) throws SystemException {
        return findByDocumentReceiptId(documentReceiptId, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId(
        long documentReceiptId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_First(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId(documentReceiptId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Last(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId(documentReceiptId);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId(documentReceiptId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId(documentReceiptId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_StateProcessIdBefore_Receiver";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(stateProcessIdBefore),
                new Long(receiver)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(stateProcessIdBefore);

                qPos.add(receiver);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver,
        int start, int end) throws SystemException {
        return findByDocumentReceiptId_StateProcessIdBefore_Receiver(documentReceiptId,
            stateProcessIdBefore, receiver, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_StateProcessIdBefore_Receiver";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(stateProcessIdBefore),
                new Long(receiver),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(stateProcessIdBefore);

                qPos.add(receiver);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Receiver_First(
        long documentReceiptId, long stateProcessIdBefore, long receiver,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_StateProcessIdBefore_Receiver(documentReceiptId,
                stateProcessIdBefore, receiver, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Receiver_Last(
        long documentReceiptId, long stateProcessIdBefore, long receiver,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId_StateProcessIdBefore_Receiver(documentReceiptId,
                stateProcessIdBefore, receiver);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_StateProcessIdBefore_Receiver(documentReceiptId,
                stateProcessIdBefore, receiver, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_StateProcessIdBefore_Receiver_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId,
        long stateProcessIdBefore, long receiver, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId_StateProcessIdBefore_Receiver(documentReceiptId,
                stateProcessIdBefore, receiver);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("stateprocessidbefore = ?");

            query.append(" AND ");

            query.append("receiver = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(stateProcessIdBefore);

            qPos.add(receiver);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_StateProcessIdBefore_Processor";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(stateProcessIdBefore),
                new Long(processer)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(stateProcessIdBefore);

                qPos.add(processer);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer,
        int start, int end) throws SystemException {
        return findByDocumentReceiptId_StateProcessIdBefore_Processor(documentReceiptId,
            stateProcessIdBefore, processer, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_StateProcessIdBefore_Processor";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(stateProcessIdBefore),
                new Long(processer),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(stateProcessIdBefore);

                qPos.add(processer);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Processor_First(
        long documentReceiptId, long stateProcessIdBefore, long processer,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_StateProcessIdBefore_Processor(documentReceiptId,
                stateProcessIdBefore, processer, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Processor_Last(
        long documentReceiptId, long stateProcessIdBefore, long processer,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId_StateProcessIdBefore_Processor(documentReceiptId,
                stateProcessIdBefore, processer);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_StateProcessIdBefore_Processor(documentReceiptId,
                stateProcessIdBefore, processer, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_StateProcessIdBefore_Processor_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId,
        long stateProcessIdBefore, long processer, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId_StateProcessIdBefore_Processor(documentReceiptId,
                stateProcessIdBefore, processer);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("stateprocessidbefore = ?");

            query.append(" AND ");

            query.append("processer = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(stateProcessIdBefore);

            qPos.add(processer);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findBymainDepartmentProcessId(
        String mainDepartmentProcessId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findBymainDepartmentProcessId";
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (mainDepartmentProcessId == null) {
                    query.append("maindepartmentprocessid IS NULL");
                } else {
                    query.append("maindepartmentprocessid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (mainDepartmentProcessId != null) {
                    qPos.add(mainDepartmentProcessId);
                }

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findBymainDepartmentProcessId(
        String mainDepartmentProcessId, int start, int end)
        throws SystemException {
        return findBymainDepartmentProcessId(mainDepartmentProcessId, start,
            end, null);
    }

    public List<PmlDocumentReceiptLog> findBymainDepartmentProcessId(
        String mainDepartmentProcessId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findBymainDepartmentProcessId";
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (mainDepartmentProcessId == null) {
                    query.append("maindepartmentprocessid IS NULL");
                } else {
                    query.append("maindepartmentprocessid = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (mainDepartmentProcessId != null) {
                    qPos.add(mainDepartmentProcessId);
                }

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findBymainDepartmentProcessId_First(
        String mainDepartmentProcessId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findBymainDepartmentProcessId(mainDepartmentProcessId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("mainDepartmentProcessId=" + mainDepartmentProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findBymainDepartmentProcessId_Last(
        String mainDepartmentProcessId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countBymainDepartmentProcessId(mainDepartmentProcessId);

        List<PmlDocumentReceiptLog> list = findBymainDepartmentProcessId(mainDepartmentProcessId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("mainDepartmentProcessId=" + mainDepartmentProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findBymainDepartmentProcessId_PrevAndNext(
        long documentReceiptLogId, String mainDepartmentProcessId,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countBymainDepartmentProcessId(mainDepartmentProcessId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            if (mainDepartmentProcessId == null) {
                query.append("maindepartmentprocessid IS NULL");
            } else {
                query.append("maindepartmentprocessid = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (mainDepartmentProcessId != null) {
                qPos.add(mainDepartmentProcessId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findBymainUserProcessId(
        long mainUserProcessId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findBymainUserProcessId";
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("mainuserprocessid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mainUserProcessId);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findBymainUserProcessId(
        long mainUserProcessId, int start, int end) throws SystemException {
        return findBymainUserProcessId(mainUserProcessId, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findBymainUserProcessId(
        long mainUserProcessId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findBymainUserProcessId";
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("mainuserprocessid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mainUserProcessId);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findBymainUserProcessId_First(
        long mainUserProcessId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findBymainUserProcessId(mainUserProcessId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("mainUserProcessId=" + mainUserProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findBymainUserProcessId_Last(
        long mainUserProcessId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countBymainUserProcessId(mainUserProcessId);

        List<PmlDocumentReceiptLog> list = findBymainUserProcessId(mainUserProcessId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("mainUserProcessId=" + mainUserProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findBymainUserProcessId_PrevAndNext(
        long documentReceiptLogId, long mainUserProcessId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countBymainUserProcessId(mainUserProcessId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("mainuserprocessid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(mainUserProcessId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, Date receiveDate,
        long stateProcessIdAfter) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processer),
                
                receiveDate, new Long(stateProcessIdAfter)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                if (receiveDate == null) {
                    query.append("receivedate IS NULL");
                } else {
                    query.append("receivedate = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processer);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                qPos.add(stateProcessIdAfter);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, Date receiveDate,
        long stateProcessIdAfter, int start, int end) throws SystemException {
        return findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(documentReceiptId,
            processer, receiveDate, stateProcessIdAfter, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, Date receiveDate,
        long stateProcessIdAfter, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processer),
                
                receiveDate, new Long(stateProcessIdAfter),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                if (receiveDate == null) {
                    query.append("receivedate IS NULL");
                } else {
                    query.append("receivedate = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processer);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                qPos.add(stateProcessIdAfter);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter_First(
        long documentReceiptId, long processer, Date receiveDate,
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(documentReceiptId,
                processer, receiveDate, stateProcessIdAfter, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(", ");
            msg.append("receiveDate=" + receiveDate);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter_Last(
        long documentReceiptId, long processer, Date receiveDate,
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(documentReceiptId,
                processer, receiveDate, stateProcessIdAfter);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(documentReceiptId,
                processer, receiveDate, stateProcessIdAfter, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(", ");
            msg.append("receiveDate=" + receiveDate);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long processer,
        Date receiveDate, long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(documentReceiptId,
                processer, receiveDate, stateProcessIdAfter);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("processer = ?");

            query.append(" AND ");

            if (receiveDate == null) {
                query.append("receivedate IS NULL");
            } else {
                query.append("receivedate = ?");
            }

            query.append(" AND ");

            query.append("stateprocessidafter = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(processer);

            if (receiveDate != null) {
                qPos.add(CalendarUtil.getTimestamp(receiveDate));
            }

            qPos.add(stateProcessIdAfter);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Processor_StateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processer),
                new Long(stateProcessIdAfter)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processer);

                qPos.add(stateProcessIdAfter);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter,
        int start, int end) throws SystemException {
        return findByDocumentReceiptId_Processor_StateProcessIdAfter(documentReceiptId,
            processer, stateProcessIdAfter, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Processor_StateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processer),
                new Long(stateProcessIdAfter),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processer);

                qPos.add(stateProcessIdAfter);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Processor_StateProcessIdAfter_First(
        long documentReceiptId, long processer, long stateProcessIdAfter,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Processor_StateProcessIdAfter(documentReceiptId,
                processer, stateProcessIdAfter, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Processor_StateProcessIdAfter_Last(
        long documentReceiptId, long processer, long stateProcessIdAfter,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId_Processor_StateProcessIdAfter(documentReceiptId,
                processer, stateProcessIdAfter);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Processor_StateProcessIdAfter(documentReceiptId,
                processer, stateProcessIdAfter, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_Processor_StateProcessIdAfter_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long processer,
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId_Processor_StateProcessIdAfter(documentReceiptId,
                processer, stateProcessIdAfter);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("processer = ?");

            query.append(" AND ");

            query.append("stateprocessidafter = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(processer);

            qPos.add(stateProcessIdAfter);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Processor(
        long documentReceiptId, long processer) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Processor";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processer)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processer);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Processor(
        long documentReceiptId, long processer, int start, int end)
        throws SystemException {
        return findByDocumentReceiptId_Processor(documentReceiptId, processer,
            start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Processor(
        long documentReceiptId, long processer, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Processor";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processer),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processer);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Processor_First(
        long documentReceiptId, long processer, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Processor(documentReceiptId,
                processer, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Last(
        long documentReceiptId, long processer, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId_Processor(documentReceiptId,
                processer);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Processor(documentReceiptId,
                processer, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_Processor_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long processer,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId_Processor(documentReceiptId,
                processer);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("processer = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(processer);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Processor_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processer),
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processer);

                qPos.add(step);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step, int start, int end)
        throws SystemException {
        return findByDocumentReceiptId_Processor_Step(documentReceiptId,
            processer, step, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Processor_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processer),
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processer);

                qPos.add(step);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Step_First(
        long documentReceiptId, long processer, int step, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Processor_Step(documentReceiptId,
                processer, step, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(", ");
            msg.append("step=" + step);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Step_Last(
        long documentReceiptId, long processer, int step, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId_Processor_Step(documentReceiptId,
                processer, step);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Processor_Step(documentReceiptId,
                processer, step, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(", ");
            msg.append("step=" + step);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_Processor_Step_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long processer,
        int step, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId_Processor_Step(documentReceiptId,
                processer, step);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("processer = ?");

            query.append(" AND ");

            query.append("step = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(processer);

            qPos.add(step);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver(
        long documentReceiptId, long receiver) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Receiver";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(receiver)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(receiver);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver(
        long documentReceiptId, long receiver, int start, int end)
        throws SystemException {
        return findByDocumentReceiptId_Receiver(documentReceiptId, receiver,
            start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver(
        long documentReceiptId, long receiver, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Receiver";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(receiver),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(receiver);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Receiver_First(
        long documentReceiptId, long receiver, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Receiver(documentReceiptId,
                receiver, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Receiver_Last(
        long documentReceiptId, long receiver, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId_Receiver(documentReceiptId,
                receiver);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Receiver(documentReceiptId,
                receiver, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_Receiver_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long receiver,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId_Receiver(documentReceiptId,
                receiver);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("receiver = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(receiver);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(receiver),
                new Long(stateProcessIdAfter), new Integer(transition_)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" AND ");

                query.append("transition_ < ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(receiver);

                qPos.add(stateProcessIdAfter);

                qPos.add(transition_);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_, int start, int end) throws SystemException {
        return findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(documentReceiptId,
            receiver, stateProcessIdAfter, transition_, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(receiver),
                new Long(stateProcessIdAfter), new Integer(transition_),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" AND ");

                query.append("transition_ < ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(receiver);

                qPos.add(stateProcessIdAfter);

                qPos.add(transition_);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition_First(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(documentReceiptId,
                receiver, stateProcessIdAfter, transition_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(", ");
            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition_Last(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(documentReceiptId,
                receiver, stateProcessIdAfter, transition_);

        List<PmlDocumentReceiptLog> list = findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(documentReceiptId,
                receiver, stateProcessIdAfter, transition_, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(", ");
            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long receiver,
        long stateProcessIdAfter, int transition_, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(documentReceiptId,
                receiver, stateProcessIdAfter, transition_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            query.append("receiver = ?");

            query.append(" AND ");

            query.append("stateprocessidafter = ?");

            query.append(" AND ");

            query.append("transition_ < ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            qPos.add(receiver);

            qPos.add(stateProcessIdAfter);

            qPos.add(transition_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findBySendDateBefore(Date sendDateBefore)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findBySendDateBefore";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { sendDateBefore };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (sendDateBefore == null) {
                    query.append("senddatebefore IS NULL");
                } else {
                    query.append("senddatebefore = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDateBefore != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDateBefore));
                }

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findBySendDateBefore(
        Date sendDateBefore, int start, int end) throws SystemException {
        return findBySendDateBefore(sendDateBefore, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findBySendDateBefore(
        Date sendDateBefore, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findBySendDateBefore";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                sendDateBefore,
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (sendDateBefore == null) {
                    query.append("senddatebefore IS NULL");
                } else {
                    query.append("senddatebefore = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDateBefore != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDateBefore));
                }

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findBySendDateBefore_First(
        Date sendDateBefore, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findBySendDateBefore(sendDateBefore,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("sendDateBefore=" + sendDateBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findBySendDateBefore_Last(
        Date sendDateBefore, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countBySendDateBefore(sendDateBefore);

        List<PmlDocumentReceiptLog> list = findBySendDateBefore(sendDateBefore,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("sendDateBefore=" + sendDateBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findBySendDateBefore_PrevAndNext(
        long documentReceiptLogId, Date sendDateBefore, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countBySendDateBefore(sendDateBefore);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            if (sendDateBefore == null) {
                query.append("senddatebefore IS NULL");
            } else {
                query.append("senddatebefore = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (sendDateBefore != null) {
                qPos.add(CalendarUtil.getTimestamp(sendDateBefore));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDepartmentReceiveId(
        String departmentReceiveId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDepartmentReceiveId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentReceiveId };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (departmentReceiveId == null) {
                    query.append("departmentreceiveid IS NULL");
                } else {
                    query.append("departmentreceiveid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentReceiveId != null) {
                    qPos.add(departmentReceiveId);
                }

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDepartmentReceiveId(
        String departmentReceiveId, int start, int end)
        throws SystemException {
        return findByDepartmentReceiveId(departmentReceiveId, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDepartmentReceiveId(
        String departmentReceiveId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDepartmentReceiveId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentReceiveId,
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (departmentReceiveId == null) {
                    query.append("departmentreceiveid IS NULL");
                } else {
                    query.append("departmentreceiveid = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentReceiveId != null) {
                    qPos.add(departmentReceiveId);
                }

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDepartmentReceiveId_First(
        String departmentReceiveId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDepartmentReceiveId(departmentReceiveId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("departmentReceiveId=" + departmentReceiveId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDepartmentReceiveId_Last(
        String departmentReceiveId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDepartmentReceiveId(departmentReceiveId);

        List<PmlDocumentReceiptLog> list = findByDepartmentReceiveId(departmentReceiveId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("departmentReceiveId=" + departmentReceiveId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDepartmentReceiveId_PrevAndNext(
        long documentReceiptLogId, String departmentReceiveId,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDepartmentReceiveId(departmentReceiveId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            if (departmentReceiveId == null) {
                query.append("departmentreceiveid IS NULL");
            } else {
                query.append("departmentreceiveid = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentReceiveId != null) {
                qPos.add(departmentReceiveId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByDepartmentProcessId(
        String departmentProcessId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDepartmentProcessId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentProcessId };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (departmentProcessId == null) {
                    query.append("departmentprocessid IS NULL");
                } else {
                    query.append("departmentprocessid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentProcessId != null) {
                    qPos.add(departmentProcessId);
                }

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByDepartmentProcessId(
        String departmentProcessId, int start, int end)
        throws SystemException {
        return findByDepartmentProcessId(departmentProcessId, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByDepartmentProcessId(
        String departmentProcessId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByDepartmentProcessId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentProcessId,
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (departmentProcessId == null) {
                    query.append("departmentprocessid IS NULL");
                } else {
                    query.append("departmentprocessid = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentProcessId != null) {
                    qPos.add(departmentProcessId);
                }

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByDepartmentProcessId_First(
        String departmentProcessId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByDepartmentProcessId(departmentProcessId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("departmentProcessId=" + departmentProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByDepartmentProcessId_Last(
        String departmentProcessId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByDepartmentProcessId(departmentProcessId);

        List<PmlDocumentReceiptLog> list = findByDepartmentProcessId(departmentProcessId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("departmentProcessId=" + departmentProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByDepartmentProcessId_PrevAndNext(
        long documentReceiptLogId, String departmentProcessId,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByDepartmentProcessId(departmentProcessId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            if (departmentProcessId == null) {
                query.append("departmentprocessid IS NULL");
            } else {
                query.append("departmentprocessid = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentProcessId != null) {
                qPos.add(departmentProcessId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByProcessInstanceId_Type(
        long processInstanceId, int type_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByProcessInstanceId_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(processInstanceId), new Integer(type_)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processinstanceid = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(type_);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByProcessInstanceId_Type(
        long processInstanceId, int type_, int start, int end)
        throws SystemException {
        return findByProcessInstanceId_Type(processInstanceId, type_, start,
            end, null);
    }

    public List<PmlDocumentReceiptLog> findByProcessInstanceId_Type(
        long processInstanceId, int type_, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByProcessInstanceId_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(processInstanceId), new Integer(type_),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processinstanceid = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(type_);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByProcessInstanceId_Type_First(
        long processInstanceId, int type_, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByProcessInstanceId_Type(processInstanceId,
                type_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(", ");
            msg.append("type_=" + type_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByProcessInstanceId_Type_Last(
        long processInstanceId, int type_, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByProcessInstanceId_Type(processInstanceId, type_);

        List<PmlDocumentReceiptLog> list = findByProcessInstanceId_Type(processInstanceId,
                type_, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(", ");
            msg.append("type_=" + type_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByProcessInstanceId_Type_PrevAndNext(
        long documentReceiptLogId, long processInstanceId, int type_,
        OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByProcessInstanceId_Type(processInstanceId, type_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("processinstanceid = ?");

            query.append(" AND ");

            query.append("type_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processInstanceId);

            qPos.add(type_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptLog> findByProcessInstanceId(
        long processInstanceId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByProcessInstanceId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(processInstanceId) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processinstanceid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                List<PmlDocumentReceiptLog> list = q.list();

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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public List<PmlDocumentReceiptLog> findByProcessInstanceId(
        long processInstanceId, int start, int end) throws SystemException {
        return findByProcessInstanceId(processInstanceId, start, end, null);
    }

    public List<PmlDocumentReceiptLog> findByProcessInstanceId(
        long processInstanceId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "findByProcessInstanceId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(processInstanceId),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processinstanceid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public PmlDocumentReceiptLog findByProcessInstanceId_First(
        long processInstanceId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        List<PmlDocumentReceiptLog> list = findByProcessInstanceId(processInstanceId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog findByProcessInstanceId_Last(
        long processInstanceId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        int count = countByProcessInstanceId(processInstanceId);

        List<PmlDocumentReceiptLog> list = findByProcessInstanceId(processInstanceId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptLog exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptLog[] findByProcessInstanceId_PrevAndNext(
        long documentReceiptLogId, long processInstanceId, OrderByComparator obc)
        throws NoSuchReceiptLogException, SystemException {
        PmlDocumentReceiptLog pmlDocumentReceiptLog = findByPrimaryKey(documentReceiptLogId);

        int count = countByProcessInstanceId(processInstanceId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

            query.append("processinstanceid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentreceiptlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processInstanceId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptLog);

            PmlDocumentReceiptLog[] array = new PmlDocumentReceiptLogImpl[3];

            array[0] = (PmlDocumentReceiptLog) objArray[0];
            array[1] = (PmlDocumentReceiptLog) objArray[1];
            array[2] = (PmlDocumentReceiptLog) objArray[2];

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

    public List<PmlDocumentReceiptLog> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlDocumentReceiptLog> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlDocumentReceiptLog> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentreceiptlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlDocumentReceiptLog> list = (List<PmlDocumentReceiptLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptLog>) result;
        }
    }

    public void removeByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByProcessInstanceId_StateProcessIdBefore_DateProcess(
                processInstanceId, stateProcessIdBefore, dateProcess)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByProcessInstanceId_StateProcessIdAfter_DateProcess(
                processInstanceId, stateProcessIdAfter, dateProcess)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByNumDateProcess(int numDateProcess)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByNumDateProcess(
                numDateProcess)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByExpiredDate(Date expiredDate) throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByExpiredDate(
                expiredDate)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId_Transition(long documentReceiptId,
        int transition_) throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId_Transition(
                documentReceiptId, transition_)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId_Step(long documentReceiptId, int step)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId_Step(
                documentReceiptId, step)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId_Type(long documentReceiptId, int type_)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId_Type(
                documentReceiptId, type_)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId_StateProcessIdBefore(
                documentReceiptId, stateProcessIdBefore)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByProcesser(long processer) throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByProcesser(
                processer)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDateProcess(Date dateProcess) throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDateProcess(
                dateProcess)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByReceiver(long receiver) throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByReceiver(
                receiver)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByReceiveDate(Date receiveDate) throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByReceiveDate(
                receiveDate)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByStateProcessIdBefore(long stateProcessIdBefore)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByStateProcessIdBefore(
                stateProcessIdBefore)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByStateProcessIdAfter(long stateProcessIdAfter)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByStateProcessIdAfter(
                stateProcessIdAfter)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByType(int type_) throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByType(type_)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId(long documentReceiptId)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId(
                documentReceiptId)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId_StateProcessIdBefore_Receiver(
                documentReceiptId, stateProcessIdBefore, receiver)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId_StateProcessIdBefore_Processor(
                documentReceiptId, stateProcessIdBefore, processer)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeBymainDepartmentProcessId(String mainDepartmentProcessId)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findBymainDepartmentProcessId(
                mainDepartmentProcessId)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeBymainUserProcessId(long mainUserProcessId)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findBymainUserProcessId(
                mainUserProcessId)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, Date receiveDate,
        long stateProcessIdAfter) throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
                documentReceiptId, processer, receiveDate, stateProcessIdAfter)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId_Processor_StateProcessIdAfter(
                documentReceiptId, processer, stateProcessIdAfter)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId_Processor(long documentReceiptId,
        long processer) throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId_Processor(
                documentReceiptId, processer)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId_Processor_Step(
                documentReceiptId, processer, step)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId_Receiver(long documentReceiptId,
        long receiver) throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId_Receiver(
                documentReceiptId, receiver)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_) throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
                documentReceiptId, receiver, stateProcessIdAfter, transition_)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeBySendDateBefore(Date sendDateBefore)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findBySendDateBefore(
                sendDateBefore)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDepartmentReceiveId(String departmentReceiveId)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDepartmentReceiveId(
                departmentReceiveId)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByDepartmentProcessId(String departmentProcessId)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByDepartmentProcessId(
                departmentProcessId)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByProcessInstanceId_Type(long processInstanceId, int type_)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByProcessInstanceId_Type(
                processInstanceId, type_)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeByProcessInstanceId(long processInstanceId)
        throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findByProcessInstanceId(
                processInstanceId)) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlDocumentReceiptLog pmlDocumentReceiptLog : findAll()) {
            remove(pmlDocumentReceiptLog);
        }
    }

    public int countByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByProcessInstanceId_StateProcessIdBefore_DateProcess";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(processInstanceId), new Long(stateProcessIdBefore),
                
                dateProcess
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processinstanceid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" AND ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(stateProcessIdBefore);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
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

    public int countByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByProcessInstanceId_StateProcessIdAfter_DateProcess";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(processInstanceId), new Long(stateProcessIdAfter),
                
                dateProcess
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processinstanceid = ?");

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" AND ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(stateProcessIdAfter);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
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

    public int countByNumDateProcess(int numDateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByNumDateProcess";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(numDateProcess) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("numdateprocess = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(numDateProcess);

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

    public int countByExpiredDate(Date expiredDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByExpiredDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { expiredDate };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (expiredDate == null) {
                    query.append("expireddate IS NULL");
                } else {
                    query.append("expireddate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (expiredDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(expiredDate));
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

    public int countByDocumentReceiptId_Transition(long documentReceiptId,
        int transition_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDocumentReceiptId_Transition";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Integer(transition_)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("transition_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(transition_);

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

    public int countByDocumentReceiptId_Step(long documentReceiptId, int step)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDocumentReceiptId_Step";
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

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

    public int countByDocumentReceiptId_Type(long documentReceiptId, int type_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDocumentReceiptId_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Integer(type_)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(type_);

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

    public int countByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDocumentReceiptId_StateProcessIdBefore";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(stateProcessIdBefore)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(stateProcessIdBefore);

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

    public int countByProcesser(long processer) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByProcesser";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(processer) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processer = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processer);

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

    public int countByDateProcess(Date dateProcess) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDateProcess";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateProcess };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
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

    public int countByReceiver(long receiver) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByReceiver";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(receiver) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

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

    public int countByReceiveDate(Date receiveDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByReceiveDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { receiveDate };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (receiveDate == null) {
                    query.append("receivedate IS NULL");
                } else {
                    query.append("receivedate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
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

    public int countByStateProcessIdBefore(long stateProcessIdBefore)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByStateProcessIdBefore";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessIdBefore) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdBefore);

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

    public int countByStateProcessIdAfter(long stateProcessIdAfter)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByStateProcessIdAfter";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessIdAfter) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdAfter);

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

    public int countByType(int type_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByType";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(type_) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("type_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(type_);

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

    public int countByDocumentReceiptId(long documentReceiptId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

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

    public int countByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDocumentReceiptId_StateProcessIdBefore_Receiver";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(stateProcessIdBefore),
                new Long(receiver)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(stateProcessIdBefore);

                qPos.add(receiver);

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

    public int countByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDocumentReceiptId_StateProcessIdBefore_Processor";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(stateProcessIdBefore),
                new Long(processer)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(stateProcessIdBefore);

                qPos.add(processer);

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

    public int countBymainDepartmentProcessId(String mainDepartmentProcessId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countBymainDepartmentProcessId";
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (mainDepartmentProcessId == null) {
                    query.append("maindepartmentprocessid IS NULL");
                } else {
                    query.append("maindepartmentprocessid = ?");
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

    public int countBymainUserProcessId(long mainUserProcessId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countBymainUserProcessId";
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

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

    public int countByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, Date receiveDate,
        long stateProcessIdAfter) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processer),
                
                receiveDate, new Long(stateProcessIdAfter)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                if (receiveDate == null) {
                    query.append("receivedate IS NULL");
                } else {
                    query.append("receivedate = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processer);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                qPos.add(stateProcessIdAfter);

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

    public int countByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDocumentReceiptId_Processor_StateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processer),
                new Long(stateProcessIdAfter)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processer);

                qPos.add(stateProcessIdAfter);

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

    public int countByDocumentReceiptId_Processor(long documentReceiptId,
        long processer) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDocumentReceiptId_Processor";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processer)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processer);

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

    public int countByDocumentReceiptId_Processor_Step(long documentReceiptId,
        long processer, int step) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDocumentReceiptId_Processor_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(processer),
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(processer);

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

    public int countByDocumentReceiptId_Receiver(long documentReceiptId,
        long receiver) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDocumentReceiptId_Receiver";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(receiver)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(receiver);

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

    public int countByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId), new Long(receiver),
                new Long(stateProcessIdAfter), new Integer(transition_)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" AND ");

                query.append("transition_ < ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                qPos.add(receiver);

                qPos.add(stateProcessIdAfter);

                qPos.add(transition_);

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

    public int countBySendDateBefore(Date sendDateBefore)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countBySendDateBefore";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { sendDateBefore };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (sendDateBefore == null) {
                    query.append("senddatebefore IS NULL");
                } else {
                    query.append("senddatebefore = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDateBefore != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDateBefore));
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

    public int countByDepartmentReceiveId(String departmentReceiveId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDepartmentReceiveId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentReceiveId };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (departmentReceiveId == null) {
                    query.append("departmentreceiveid IS NULL");
                } else {
                    query.append("departmentreceiveid = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentReceiveId != null) {
                    qPos.add(departmentReceiveId);
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

    public int countByDepartmentProcessId(String departmentProcessId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByDepartmentProcessId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentProcessId };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                if (departmentProcessId == null) {
                    query.append("departmentprocessid IS NULL");
                } else {
                    query.append("departmentprocessid = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentProcessId != null) {
                    qPos.add(departmentProcessId);
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

    public int countByProcessInstanceId_Type(long processInstanceId, int type_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByProcessInstanceId_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(processInstanceId), new Integer(type_)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processinstanceid = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(type_);

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

    public int countByProcessInstanceId(long processInstanceId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
        String finderMethodName = "countByProcessInstanceId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(processInstanceId) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog WHERE ");

                query.append("processinstanceid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

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
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptLog.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.model.PmlDocumentReceiptLog");

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
                        "value.object.listener.com.sgs.portlet.document.model.PmlDocumentReceiptLog")));

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
