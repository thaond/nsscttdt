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

import com.sgs.portlet.document.NoSuchSendLogException;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.model.impl.PmlDocumentSendLogImpl;
import com.sgs.portlet.document.model.impl.PmlDocumentSendLogModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlDocumentSendLogPersistenceImpl extends BasePersistenceImpl
    implements PmlDocumentSendLogPersistence {
    private static Log _log = LogFactory.getLog(PmlDocumentSendLogPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlDocumentSendLog create(long documentSendLogId) {
        PmlDocumentSendLog pmlDocumentSendLog = new PmlDocumentSendLogImpl();

        pmlDocumentSendLog.setNew(true);
        pmlDocumentSendLog.setPrimaryKey(documentSendLogId);

        return pmlDocumentSendLog;
    }

    public PmlDocumentSendLog remove(long documentSendLogId)
        throws NoSuchSendLogException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlDocumentSendLog pmlDocumentSendLog = (PmlDocumentSendLog) session.get(PmlDocumentSendLogImpl.class,
                    new Long(documentSendLogId));

            if (pmlDocumentSendLog == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlDocumentSendLog exists with the primary key " +
                        documentSendLogId);
                }

                throw new NoSuchSendLogException(
                    "No PmlDocumentSendLog exists with the primary key " +
                    documentSendLogId);
            }

            return remove(pmlDocumentSendLog);
        } catch (NoSuchSendLogException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlDocumentSendLog remove(PmlDocumentSendLog pmlDocumentSendLog)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlDocumentSendLog);
            }
        }

        pmlDocumentSendLog = removeImpl(pmlDocumentSendLog);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlDocumentSendLog);
            }
        }

        return pmlDocumentSendLog;
    }

    protected PmlDocumentSendLog removeImpl(
        PmlDocumentSendLog pmlDocumentSendLog) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlDocumentSendLog);

            session.flush();

            return pmlDocumentSendLog;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDocumentSendLog.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlDocumentSendLog pmlDocumentSendLog, boolean merge)</code>.
     */
    public PmlDocumentSendLog update(PmlDocumentSendLog pmlDocumentSendLog)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlDocumentSendLog pmlDocumentSendLog) method. Use update(PmlDocumentSendLog pmlDocumentSendLog, boolean merge) instead.");
        }

        return update(pmlDocumentSendLog, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentSendLog the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentSendLog is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlDocumentSendLog update(PmlDocumentSendLog pmlDocumentSendLog,
        boolean merge) throws SystemException {
        boolean isNew = pmlDocumentSendLog.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlDocumentSendLog);
                } else {
                    listener.onBeforeUpdate(pmlDocumentSendLog);
                }
            }
        }

        pmlDocumentSendLog = updateImpl(pmlDocumentSendLog, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlDocumentSendLog);
                } else {
                    listener.onAfterUpdate(pmlDocumentSendLog);
                }
            }
        }

        return pmlDocumentSendLog;
    }

    public PmlDocumentSendLog updateImpl(
        com.sgs.portlet.document.model.PmlDocumentSendLog pmlDocumentSendLog,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlDocumentSendLog);
            } else {
                if (pmlDocumentSendLog.isNew()) {
                    session.save(pmlDocumentSendLog);
                }
            }

            session.flush();

            pmlDocumentSendLog.setNew(false);

            return pmlDocumentSendLog;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDocumentSendLog.class.getName());
        }
    }

    public PmlDocumentSendLog findByPrimaryKey(long documentSendLogId)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = fetchByPrimaryKey(documentSendLogId);

        if (pmlDocumentSendLog == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlDocumentSendLog exists with the primary key " +
                    documentSendLogId);
            }

            throw new NoSuchSendLogException(
                "No PmlDocumentSendLog exists with the primary key " +
                documentSendLogId);
        }

        return pmlDocumentSendLog;
    }

    public PmlDocumentSendLog fetchByPrimaryKey(long documentSendLogId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlDocumentSendLog) session.get(PmlDocumentSendLogImpl.class,
                new Long(documentSendLogId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(stateProcessIdBefore);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess,
        int start, int end) throws SystemException {
        return findByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
            stateProcessIdBefore, dateProcess, start, end, null);
    }

    public List<PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(stateProcessIdBefore);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByProcessInstanceId_StateProcessIdBefore_DateProcess_First(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
                stateProcessIdBefore, dateProcess, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(", ");
            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByProcessInstanceId_StateProcessIdBefore_DateProcess_Last(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        int count = countByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
                stateProcessIdBefore, dateProcess);

        List<PmlDocumentSendLog> list = findByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
                stateProcessIdBefore, dateProcess, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(", ");
            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByProcessInstanceId_StateProcessIdBefore_DateProcess_PrevAndNext(
        long documentSendLogId, long processInstanceId,
        long stateProcessIdBefore, Date dateProcess, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
                stateProcessIdBefore, dateProcess);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processInstanceId);

            qPos.add(stateProcessIdBefore);

            if (dateProcess != null) {
                qPos.add(CalendarUtil.getTimestamp(dateProcess));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(stateProcessIdAfter);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess,
        int start, int end) throws SystemException {
        return findByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
            stateProcessIdAfter, dateProcess, start, end, null);
    }

    public List<PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processInstanceId);

                qPos.add(stateProcessIdAfter);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByProcessInstanceId_StateProcessIdAfter_DateProcess_First(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
                stateProcessIdAfter, dateProcess, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(", ");
            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByProcessInstanceId_StateProcessIdAfter_DateProcess_Last(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        int count = countByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
                stateProcessIdAfter, dateProcess);

        List<PmlDocumentSendLog> list = findByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
                stateProcessIdAfter, dateProcess, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("processInstanceId=" + processInstanceId);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(", ");
            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByProcessInstanceId_StateProcessIdAfter_DateProcess_PrevAndNext(
        long documentSendLogId, long processInstanceId,
        long stateProcessIdAfter, Date dateProcess, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
                stateProcessIdAfter, dateProcess);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processInstanceId);

            qPos.add(stateProcessIdAfter);

            if (dateProcess != null) {
                qPos.add(CalendarUtil.getTimestamp(dateProcess));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByNumDateProcess(int numDateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("numdateprocess = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(numDateProcess);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByNumDateProcess(int numDateProcess,
        int start, int end) throws SystemException {
        return findByNumDateProcess(numDateProcess, start, end, null);
    }

    public List<PmlDocumentSendLog> findByNumDateProcess(int numDateProcess,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("numdateprocess = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(numDateProcess);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByNumDateProcess_First(int numDateProcess,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByNumDateProcess(numDateProcess, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("numDateProcess=" + numDateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByNumDateProcess_Last(int numDateProcess,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        int count = countByNumDateProcess(numDateProcess);

        List<PmlDocumentSendLog> list = findByNumDateProcess(numDateProcess,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("numDateProcess=" + numDateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByNumDateProcess_PrevAndNext(
        long documentSendLogId, int numDateProcess, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByNumDateProcess(numDateProcess);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("numdateprocess = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(numDateProcess);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByExpiredDate(Date expiredDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                if (expiredDate == null) {
                    query.append("expireddate IS NULL");
                } else {
                    query.append("expireddate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (expiredDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(expiredDate));
                }

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByExpiredDate(Date expiredDate,
        int start, int end) throws SystemException {
        return findByExpiredDate(expiredDate, start, end, null);
    }

    public List<PmlDocumentSendLog> findByExpiredDate(Date expiredDate,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (expiredDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(expiredDate));
                }

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByExpiredDate_First(Date expiredDate,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByExpiredDate(expiredDate, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("expiredDate=" + expiredDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByExpiredDate_Last(Date expiredDate,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        int count = countByExpiredDate(expiredDate);

        List<PmlDocumentSendLog> list = findByExpiredDate(expiredDate,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("expiredDate=" + expiredDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByExpiredDate_PrevAndNext(
        long documentSendLogId, Date expiredDate, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByExpiredDate(expiredDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (expiredDate != null) {
                qPos.add(CalendarUtil.getTimestamp(expiredDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Transition(
        long documentSendId, int transition_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Transition";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Integer(transition_)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("transition_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(transition_);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Transition(
        long documentSendId, int transition_, int start, int end)
        throws SystemException {
        return findByDocumentSendId_Transition(documentSendId, transition_,
            start, end, null);
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Transition(
        long documentSendId, int transition_, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Transition";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Integer(transition_),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("transition_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(transition_);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Transition_First(
        long documentSendId, int transition_, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDocumentSendId_Transition(documentSendId,
                transition_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Transition_Last(
        long documentSendId, int transition_, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        int count = countByDocumentSendId_Transition(documentSendId, transition_);

        List<PmlDocumentSendLog> list = findByDocumentSendId_Transition(documentSendId,
                transition_, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDocumentSendId_Transition_PrevAndNext(
        long documentSendLogId, long documentSendId, int transition_,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDocumentSendId_Transition(documentSendId, transition_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("documentsendid = ?");

            query.append(" AND ");

            query.append("transition_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentSendId);

            qPos.add(transition_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_StateProcessIdBefore";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(stateProcessIdBefore)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(stateProcessIdBefore);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore, int start, int end)
        throws SystemException {
        return findByDocumentSendId_StateProcessIdBefore(documentSendId,
            stateProcessIdBefore, start, end, null);
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_StateProcessIdBefore";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(stateProcessIdBefore),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(stateProcessIdBefore);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_StateProcessIdBefore_First(
        long documentSendId, long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDocumentSendId_StateProcessIdBefore(documentSendId,
                stateProcessIdBefore, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_StateProcessIdBefore_Last(
        long documentSendId, long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        int count = countByDocumentSendId_StateProcessIdBefore(documentSendId,
                stateProcessIdBefore);

        List<PmlDocumentSendLog> list = findByDocumentSendId_StateProcessIdBefore(documentSendId,
                stateProcessIdBefore, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDocumentSendId_StateProcessIdBefore_PrevAndNext(
        long documentSendLogId, long documentSendId, long stateProcessIdBefore,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDocumentSendId_StateProcessIdBefore(documentSendId,
                stateProcessIdBefore);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("documentsendid = ?");

            query.append(" AND ");

            query.append("stateprocessidbefore = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentSendId);

            qPos.add(stateProcessIdBefore);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByProcesser(long processer)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("processer = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processer);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByProcesser(long processer, int start,
        int end) throws SystemException {
        return findByProcesser(processer, start, end, null);
    }

    public List<PmlDocumentSendLog> findByProcesser(long processer, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("processer = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processer);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByProcesser_First(long processer,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByProcesser(processer, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByProcesser_Last(long processer,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        int count = countByProcesser(processer);

        List<PmlDocumentSendLog> list = findByProcesser(processer, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByProcesser_PrevAndNext(
        long documentSendLogId, long processer, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByProcesser(processer);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("processer = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processer);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDateProcess(Date dateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDateProcess(Date dateProcess,
        int start, int end) throws SystemException {
        return findByDateProcess(dateProcess, start, end, null);
    }

    public List<PmlDocumentSendLog> findByDateProcess(Date dateProcess,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDateProcess_First(Date dateProcess,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDateProcess(dateProcess, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDateProcess_Last(Date dateProcess,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        int count = countByDateProcess(dateProcess);

        List<PmlDocumentSendLog> list = findByDateProcess(dateProcess,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDateProcess_PrevAndNext(
        long documentSendLogId, Date dateProcess, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDateProcess(dateProcess);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateProcess != null) {
                qPos.add(CalendarUtil.getTimestamp(dateProcess));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByReceiver(long receiver)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByReceiver(long receiver, int start,
        int end) throws SystemException {
        return findByReceiver(receiver, start, end, null);
    }

    public List<PmlDocumentSendLog> findByReceiver(long receiver, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByReceiver_First(long receiver,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByReceiver(receiver, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByReceiver_Last(long receiver,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        int count = countByReceiver(receiver);

        List<PmlDocumentSendLog> list = findByReceiver(receiver, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByReceiver_PrevAndNext(
        long documentSendLogId, long receiver, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByReceiver(receiver);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("receiver = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(receiver);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByReceiveDate(Date receiveDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                if (receiveDate == null) {
                    query.append("receivedate IS NULL");
                } else {
                    query.append("receivedate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByReceiveDate(Date receiveDate,
        int start, int end) throws SystemException {
        return findByReceiveDate(receiveDate, start, end, null);
    }

    public List<PmlDocumentSendLog> findByReceiveDate(Date receiveDate,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByReceiveDate_First(Date receiveDate,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByReceiveDate(receiveDate, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("receiveDate=" + receiveDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByReceiveDate_Last(Date receiveDate,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        int count = countByReceiveDate(receiveDate);

        List<PmlDocumentSendLog> list = findByReceiveDate(receiveDate,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("receiveDate=" + receiveDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByReceiveDate_PrevAndNext(
        long documentSendLogId, Date receiveDate, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByReceiveDate(receiveDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (receiveDate != null) {
                qPos.add(CalendarUtil.getTimestamp(receiveDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByStateProcessIdBefore(
        long stateProcessIdBefore) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdBefore);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end)
        throws SystemException {
        return findByStateProcessIdBefore(stateProcessIdBefore, start, end, null);
    }

    public List<PmlDocumentSendLog> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdBefore);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByStateProcessIdBefore_First(
        long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByStateProcessIdBefore(stateProcessIdBefore,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByStateProcessIdBefore_Last(
        long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        int count = countByStateProcessIdBefore(stateProcessIdBefore);

        List<PmlDocumentSendLog> list = findByStateProcessIdBefore(stateProcessIdBefore,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByStateProcessIdBefore_PrevAndNext(
        long documentSendLogId, long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByStateProcessIdBefore(stateProcessIdBefore);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("stateprocessidbefore = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessIdBefore);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByStateProcessIdAfter(
        long stateProcessIdAfter) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdAfter);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end) throws SystemException {
        return findByStateProcessIdAfter(stateProcessIdAfter, start, end, null);
    }

    public List<PmlDocumentSendLog> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdAfter);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByStateProcessIdAfter_First(
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByStateProcessIdAfter(stateProcessIdAfter,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByStateProcessIdAfter_Last(
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        int count = countByStateProcessIdAfter(stateProcessIdAfter);

        List<PmlDocumentSendLog> list = findByStateProcessIdAfter(stateProcessIdAfter,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByStateProcessIdAfter_PrevAndNext(
        long documentSendLogId, long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByStateProcessIdAfter(stateProcessIdAfter);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("stateprocessidafter = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessIdAfter);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId(long documentSendId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId(long documentSendId,
        int start, int end) throws SystemException {
        return findByDocumentSendId(documentSendId, start, end, null);
    }

    public List<PmlDocumentSendLog> findByDocumentSendId(long documentSendId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_First(long documentSendId,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDocumentSendId(documentSendId, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Last(long documentSendId,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        int count = countByDocumentSendId(documentSendId);

        List<PmlDocumentSendLog> list = findByDocumentSendId(documentSendId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDocumentSendId_PrevAndNext(
        long documentSendLogId, long documentSendId, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDocumentSendId(documentSendId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("documentsendid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentSendId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_StateProcessIdBefore_Receiver";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(stateProcessIdBefore),
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(stateProcessIdBefore);

                qPos.add(receiver);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver,
        int start, int end) throws SystemException {
        return findByDocumentSendId_StateProcessIdBefore_Receiver(documentSendId,
            stateProcessIdBefore, receiver, start, end, null);
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_StateProcessIdBefore_Receiver";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(stateProcessIdBefore),
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

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

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(stateProcessIdBefore);

                qPos.add(receiver);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_StateProcessIdBefore_Receiver_First(
        long documentSendId, long stateProcessIdBefore, long receiver,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDocumentSendId_StateProcessIdBefore_Receiver(documentSendId,
                stateProcessIdBefore, receiver, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_StateProcessIdBefore_Receiver_Last(
        long documentSendId, long stateProcessIdBefore, long receiver,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        int count = countByDocumentSendId_StateProcessIdBefore_Receiver(documentSendId,
                stateProcessIdBefore, receiver);

        List<PmlDocumentSendLog> list = findByDocumentSendId_StateProcessIdBefore_Receiver(documentSendId,
                stateProcessIdBefore, receiver, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDocumentSendId_StateProcessIdBefore_Receiver_PrevAndNext(
        long documentSendLogId, long documentSendId, long stateProcessIdBefore,
        long receiver, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDocumentSendId_StateProcessIdBefore_Receiver(documentSendId,
                stateProcessIdBefore, receiver);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("documentsendid = ?");

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

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentSendId);

            qPos.add(stateProcessIdBefore);

            qPos.add(receiver);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Receiver(
        long documentSendId, long receiver) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Receiver";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(receiver)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(receiver);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Receiver(
        long documentSendId, long receiver, int start, int end)
        throws SystemException {
        return findByDocumentSendId_Receiver(documentSendId, receiver, start,
            end, null);
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Receiver(
        long documentSendId, long receiver, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Receiver";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(receiver),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(receiver);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Receiver_First(
        long documentSendId, long receiver, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDocumentSendId_Receiver(documentSendId,
                receiver, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Receiver_Last(
        long documentSendId, long receiver, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        int count = countByDocumentSendId_Receiver(documentSendId, receiver);

        List<PmlDocumentSendLog> list = findByDocumentSendId_Receiver(documentSendId,
                receiver, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDocumentSendId_Receiver_PrevAndNext(
        long documentSendLogId, long documentSendId, long receiver,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDocumentSendId_Receiver(documentSendId, receiver);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("documentsendid = ?");

            query.append(" AND ");

            query.append("receiver = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentSendId);

            qPos.add(receiver);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, Date receiveDate,
        long stateProcessIdAfter) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(processer),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

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

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(processer);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                qPos.add(stateProcessIdAfter);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, Date receiveDate,
        long stateProcessIdAfter, int start, int end) throws SystemException {
        return findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(documentSendId,
            processer, receiveDate, stateProcessIdAfter, start, end, null);
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, Date receiveDate,
        long stateProcessIdAfter, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(processer),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

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

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(processer);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                qPos.add(stateProcessIdAfter);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter_First(
        long documentSendId, long processer, Date receiveDate,
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(documentSendId,
                processer, receiveDate, stateProcessIdAfter, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(", ");
            msg.append("receiveDate=" + receiveDate);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter_Last(
        long documentSendId, long processer, Date receiveDate,
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        int count = countByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(documentSendId,
                processer, receiveDate, stateProcessIdAfter);

        List<PmlDocumentSendLog> list = findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(documentSendId,
                processer, receiveDate, stateProcessIdAfter, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(", ");
            msg.append("receiveDate=" + receiveDate);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter_PrevAndNext(
        long documentSendLogId, long documentSendId, long processer,
        Date receiveDate, long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(documentSendId,
                processer, receiveDate, stateProcessIdAfter);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("documentsendid = ?");

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

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentSendId);

            qPos.add(processer);

            if (receiveDate != null) {
                qPos.add(CalendarUtil.getTimestamp(receiveDate));
            }

            qPos.add(stateProcessIdAfter);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Processor_StateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(processer),
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(processer);

                qPos.add(stateProcessIdAfter);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter,
        int start, int end) throws SystemException {
        return findByDocumentSendId_Processor_StateProcessIdAfter(documentSendId,
            processer, stateProcessIdAfter, start, end, null);
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Processor_StateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(processer),
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

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

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(processer);

                qPos.add(stateProcessIdAfter);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Processor_StateProcessIdAfter_First(
        long documentSendId, long processer, long stateProcessIdAfter,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDocumentSendId_Processor_StateProcessIdAfter(documentSendId,
                processer, stateProcessIdAfter, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Processor_StateProcessIdAfter_Last(
        long documentSendId, long processer, long stateProcessIdAfter,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        int count = countByDocumentSendId_Processor_StateProcessIdAfter(documentSendId,
                processer, stateProcessIdAfter);

        List<PmlDocumentSendLog> list = findByDocumentSendId_Processor_StateProcessIdAfter(documentSendId,
                processer, stateProcessIdAfter, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDocumentSendId_Processor_StateProcessIdAfter_PrevAndNext(
        long documentSendLogId, long documentSendId, long processer,
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDocumentSendId_Processor_StateProcessIdAfter(documentSendId,
                processer, stateProcessIdAfter);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("documentsendid = ?");

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

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentSendId);

            qPos.add(processer);

            qPos.add(stateProcessIdAfter);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Processor(
        long documentSendId, long processer) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Processor";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(processer)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(processer);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Processor(
        long documentSendId, long processer, int start, int end)
        throws SystemException {
        return findByDocumentSendId_Processor(documentSendId, processer, start,
            end, null);
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Processor(
        long documentSendId, long processer, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Processor";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(processer),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(processer);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Processor_First(
        long documentSendId, long processer, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDocumentSendId_Processor(documentSendId,
                processer, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Processor_Last(
        long documentSendId, long processer, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        int count = countByDocumentSendId_Processor(documentSendId, processer);

        List<PmlDocumentSendLog> list = findByDocumentSendId_Processor(documentSendId,
                processer, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDocumentSendId_Processor_PrevAndNext(
        long documentSendLogId, long documentSendId, long processer,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDocumentSendId_Processor(documentSendId, processer);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("documentsendid = ?");

            query.append(" AND ");

            query.append("processer = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentSendId);

            qPos.add(processer);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Processor_Step(
        long documentSendId, long processer, int step)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Processor_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(processer), new Integer(step)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(processer);

                qPos.add(step);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Processor_Step(
        long documentSendId, long processer, int step, int start, int end)
        throws SystemException {
        return findByDocumentSendId_Processor_Step(documentSendId, processer,
            step, start, end, null);
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Processor_Step(
        long documentSendId, long processer, int step, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Processor_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(processer), new Integer(step),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

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

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(processer);

                qPos.add(step);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Processor_Step_First(
        long documentSendId, long processer, int step, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDocumentSendId_Processor_Step(documentSendId,
                processer, step, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(", ");
            msg.append("step=" + step);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Processor_Step_Last(
        long documentSendId, long processer, int step, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        int count = countByDocumentSendId_Processor_Step(documentSendId,
                processer, step);

        List<PmlDocumentSendLog> list = findByDocumentSendId_Processor_Step(documentSendId,
                processer, step, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("processer=" + processer);

            msg.append(", ");
            msg.append("step=" + step);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDocumentSendId_Processor_Step_PrevAndNext(
        long documentSendLogId, long documentSendId, long processer, int step,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDocumentSendId_Processor_Step(documentSendId,
                processer, step);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("documentsendid = ?");

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

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentSendId);

            qPos.add(processer);

            qPos.add(step);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findBySendDateBefore(Date sendDateBefore)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                if (sendDateBefore == null) {
                    query.append("senddatebefore IS NULL");
                } else {
                    query.append("senddatebefore = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDateBefore != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDateBefore));
                }

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findBySendDateBefore(Date sendDateBefore,
        int start, int end) throws SystemException {
        return findBySendDateBefore(sendDateBefore, start, end, null);
    }

    public List<PmlDocumentSendLog> findBySendDateBefore(Date sendDateBefore,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDateBefore != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDateBefore));
                }

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findBySendDateBefore_First(Date sendDateBefore,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findBySendDateBefore(sendDateBefore, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("sendDateBefore=" + sendDateBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findBySendDateBefore_Last(Date sendDateBefore,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        int count = countBySendDateBefore(sendDateBefore);

        List<PmlDocumentSendLog> list = findBySendDateBefore(sendDateBefore,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("sendDateBefore=" + sendDateBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findBySendDateBefore_PrevAndNext(
        long documentSendLogId, Date sendDateBefore, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countBySendDateBefore(sendDateBefore);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (sendDateBefore != null) {
                qPos.add(CalendarUtil.getTimestamp(sendDateBefore));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDepartmentReceiveId(
        String departmentReceiveId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                if (departmentReceiveId == null) {
                    query.append("departmentreceiveid IS NULL");
                } else {
                    query.append("departmentreceiveid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentReceiveId != null) {
                    qPos.add(departmentReceiveId);
                }

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDepartmentReceiveId(
        String departmentReceiveId, int start, int end)
        throws SystemException {
        return findByDepartmentReceiveId(departmentReceiveId, start, end, null);
    }

    public List<PmlDocumentSendLog> findByDepartmentReceiveId(
        String departmentReceiveId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentReceiveId != null) {
                    qPos.add(departmentReceiveId);
                }

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDepartmentReceiveId_First(
        String departmentReceiveId, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDepartmentReceiveId(departmentReceiveId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("departmentReceiveId=" + departmentReceiveId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDepartmentReceiveId_Last(
        String departmentReceiveId, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        int count = countByDepartmentReceiveId(departmentReceiveId);

        List<PmlDocumentSendLog> list = findByDepartmentReceiveId(departmentReceiveId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("departmentReceiveId=" + departmentReceiveId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDepartmentReceiveId_PrevAndNext(
        long documentSendLogId, String departmentReceiveId,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDepartmentReceiveId(departmentReceiveId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentReceiveId != null) {
                qPos.add(departmentReceiveId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDepartmentProcessId(
        String departmentProcessId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                if (departmentProcessId == null) {
                    query.append("departmentprocessid IS NULL");
                } else {
                    query.append("departmentprocessid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentProcessId != null) {
                    qPos.add(departmentProcessId);
                }

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDepartmentProcessId(
        String departmentProcessId, int start, int end)
        throws SystemException {
        return findByDepartmentProcessId(departmentProcessId, start, end, null);
    }

    public List<PmlDocumentSendLog> findByDepartmentProcessId(
        String departmentProcessId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentProcessId != null) {
                    qPos.add(departmentProcessId);
                }

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDepartmentProcessId_First(
        String departmentProcessId, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDepartmentProcessId(departmentProcessId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("departmentProcessId=" + departmentProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDepartmentProcessId_Last(
        String departmentProcessId, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        int count = countByDepartmentProcessId(departmentProcessId);

        List<PmlDocumentSendLog> list = findByDepartmentProcessId(departmentProcessId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("departmentProcessId=" + departmentProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDepartmentProcessId_PrevAndNext(
        long documentSendLogId, String departmentProcessId,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDepartmentProcessId(departmentProcessId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentProcessId != null) {
                qPos.add(departmentProcessId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Step(
        long documentSendId, int step) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Integer(step)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(step);

                List<PmlDocumentSendLog> list = q.list();

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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Step(
        long documentSendId, int step, int start, int end)
        throws SystemException {
        return findByDocumentSendId_Step(documentSendId, step, start, end, null);
    }

    public List<PmlDocumentSendLog> findByDocumentSendId_Step(
        long documentSendId, int step, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "findByDocumentSendId_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Integer(step),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                qPos.add(step);

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Step_First(
        long documentSendId, int step, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        List<PmlDocumentSendLog> list = findByDocumentSendId_Step(documentSendId,
                step, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("step=" + step);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog findByDocumentSendId_Step_Last(
        long documentSendId, int step, OrderByComparator obc)
        throws NoSuchSendLogException, SystemException {
        int count = countByDocumentSendId_Step(documentSendId, step);

        List<PmlDocumentSendLog> list = findByDocumentSendId_Step(documentSendId,
                step, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendLog exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(", ");
            msg.append("step=" + step);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendLogException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendLog[] findByDocumentSendId_Step_PrevAndNext(
        long documentSendLogId, long documentSendId, int step,
        OrderByComparator obc) throws NoSuchSendLogException, SystemException {
        PmlDocumentSendLog pmlDocumentSendLog = findByPrimaryKey(documentSendLogId);

        int count = countByDocumentSendId_Step(documentSendId, step);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

            query.append("documentsendid = ?");

            query.append(" AND ");

            query.append("step = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendlogid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentSendId);

            qPos.add(step);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendLog);

            PmlDocumentSendLog[] array = new PmlDocumentSendLogImpl[3];

            array[0] = (PmlDocumentSendLog) objArray[0];
            array[1] = (PmlDocumentSendLog) objArray[1];
            array[2] = (PmlDocumentSendLog) objArray[2];

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

    public List<PmlDocumentSendLog> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlDocumentSendLog> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlDocumentSendLog> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendlogid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlDocumentSendLog> list = (List<PmlDocumentSendLog>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendLog>) result;
        }
    }

    public void removeByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByProcessInstanceId_StateProcessIdBefore_DateProcess(
                processInstanceId, stateProcessIdBefore, dateProcess)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter, Date dateProcess)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByProcessInstanceId_StateProcessIdAfter_DateProcess(
                processInstanceId, stateProcessIdAfter, dateProcess)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByNumDateProcess(int numDateProcess)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByNumDateProcess(
                numDateProcess)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByExpiredDate(Date expiredDate) throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByExpiredDate(
                expiredDate)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDocumentSendId_Transition(long documentSendId,
        int transition_) throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDocumentSendId_Transition(
                documentSendId, transition_)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDocumentSendId_StateProcessIdBefore(
                documentSendId, stateProcessIdBefore)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByProcesser(long processer) throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByProcesser(processer)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDateProcess(Date dateProcess) throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDateProcess(
                dateProcess)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByReceiver(long receiver) throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByReceiver(receiver)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByReceiveDate(Date receiveDate) throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByReceiveDate(
                receiveDate)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByStateProcessIdBefore(long stateProcessIdBefore)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByStateProcessIdBefore(
                stateProcessIdBefore)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByStateProcessIdAfter(long stateProcessIdAfter)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByStateProcessIdAfter(
                stateProcessIdAfter)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDocumentSendId(long documentSendId)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDocumentSendId(
                documentSendId)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDocumentSendId_StateProcessIdBefore_Receiver(
                documentSendId, stateProcessIdBefore, receiver)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDocumentSendId_Receiver(long documentSendId,
        long receiver) throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDocumentSendId_Receiver(
                documentSendId, receiver)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, Date receiveDate,
        long stateProcessIdAfter) throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
                documentSendId, processer, receiveDate, stateProcessIdAfter)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDocumentSendId_Processor_StateProcessIdAfter(
                documentSendId, processer, stateProcessIdAfter)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDocumentSendId_Processor(long documentSendId,
        long processer) throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDocumentSendId_Processor(
                documentSendId, processer)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDocumentSendId_Processor_Step(long documentSendId,
        long processer, int step) throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDocumentSendId_Processor_Step(
                documentSendId, processer, step)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeBySendDateBefore(Date sendDateBefore)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findBySendDateBefore(
                sendDateBefore)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDepartmentReceiveId(String departmentReceiveId)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDepartmentReceiveId(
                departmentReceiveId)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDepartmentProcessId(String departmentProcessId)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDepartmentProcessId(
                departmentProcessId)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeByDocumentSendId_Step(long documentSendId, int step)
        throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findByDocumentSendId_Step(
                documentSendId, step)) {
            remove(pmlDocumentSendLog);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlDocumentSendLog pmlDocumentSendLog : findAll()) {
            remove(pmlDocumentSendLog);
        }
    }

    public int countByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore, Date dateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

    public int countByDocumentSendId_Transition(long documentSendId,
        int transition_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "countByDocumentSendId_Transition";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Integer(transition_)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("transition_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

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

    public int countByDocumentSendId_StateProcessIdBefore(long documentSendId,
        long stateProcessIdBefore) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "countByDocumentSendId_StateProcessIdBefore";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(stateProcessIdBefore)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

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
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

    public int countByDocumentSendId(long documentSendId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

    public int countByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "countByDocumentSendId_StateProcessIdBefore_Receiver";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(stateProcessIdBefore),
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

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

    public int countByDocumentSendId_Receiver(long documentSendId, long receiver)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "countByDocumentSendId_Receiver";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(receiver)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

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

    public int countByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, Date receiveDate,
        long stateProcessIdAfter) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "countByDocumentSendId_Processor_Receivedate_StateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(processer),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

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

                qPos.add(documentSendId);

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

    public int countByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "countByDocumentSendId_Processor_StateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(processer),
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

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

    public int countByDocumentSendId_Processor(long documentSendId,
        long processer) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "countByDocumentSendId_Processor";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(processer)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

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

    public int countByDocumentSendId_Processor_Step(long documentSendId,
        long processer, int step) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "countByDocumentSendId_Processor_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Long(processer), new Integer(step)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("processer = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

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

    public int countBySendDateBefore(Date sendDateBefore)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

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

    public int countByDocumentSendId_Step(long documentSendId, int step)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
        String finderMethodName = "countByDocumentSendId_Step";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId), new Integer(step)
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendLog WHERE ");

                query.append("documentsendid = ?");

                query.append(" AND ");

                query.append("step = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

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

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendLogModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendLog.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.model.PmlDocumentSendLog");

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
                        "value.object.listener.com.sgs.portlet.document.model.PmlDocumentSendLog")));

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
