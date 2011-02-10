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

import com.sgs.portlet.document.receipt.NoSuchPmlFileStatusStateProcessException;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.model.impl.PmlFileStatusStateProcessImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlFileStatusStateProcessModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlFileStatusStateProcessPersistenceImpl
    extends BasePersistenceImpl implements PmlFileStatusStateProcessPersistence {
    private static Log _log = LogFactory.getLog(PmlFileStatusStateProcessPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlFileStatusStateProcess create(long id) {
        PmlFileStatusStateProcess pmlFileStatusStateProcess = new PmlFileStatusStateProcessImpl();

        pmlFileStatusStateProcess.setNew(true);
        pmlFileStatusStateProcess.setPrimaryKey(id);

        return pmlFileStatusStateProcess;
    }

    public PmlFileStatusStateProcess remove(long id)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileStatusStateProcess pmlFileStatusStateProcess = (PmlFileStatusStateProcess) session.get(PmlFileStatusStateProcessImpl.class,
                    new Long(id));

            if (pmlFileStatusStateProcess == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlFileStatusStateProcess exists with the primary key " +
                        id);
                }

                throw new NoSuchPmlFileStatusStateProcessException(
                    "No PmlFileStatusStateProcess exists with the primary key " +
                    id);
            }

            return remove(pmlFileStatusStateProcess);
        } catch (NoSuchPmlFileStatusStateProcessException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileStatusStateProcess remove(
        PmlFileStatusStateProcess pmlFileStatusStateProcess)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlFileStatusStateProcess);
            }
        }

        pmlFileStatusStateProcess = removeImpl(pmlFileStatusStateProcess);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlFileStatusStateProcess);
            }
        }

        return pmlFileStatusStateProcess;
    }

    protected PmlFileStatusStateProcess removeImpl(
        PmlFileStatusStateProcess pmlFileStatusStateProcess)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlFileStatusStateProcess);

            session.flush();

            return pmlFileStatusStateProcess;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileStatusStateProcess.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlFileStatusStateProcess pmlFileStatusStateProcess, boolean merge)</code>.
     */
    public PmlFileStatusStateProcess update(
        PmlFileStatusStateProcess pmlFileStatusStateProcess)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileStatusStateProcess pmlFileStatusStateProcess) method. Use update(PmlFileStatusStateProcess pmlFileStatusStateProcess, boolean merge) instead.");
        }

        return update(pmlFileStatusStateProcess, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileStatusStateProcess the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileStatusStateProcess is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileStatusStateProcess update(
        PmlFileStatusStateProcess pmlFileStatusStateProcess, boolean merge)
        throws SystemException {
        boolean isNew = pmlFileStatusStateProcess.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlFileStatusStateProcess);
                } else {
                    listener.onBeforeUpdate(pmlFileStatusStateProcess);
                }
            }
        }

        pmlFileStatusStateProcess = updateImpl(pmlFileStatusStateProcess, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlFileStatusStateProcess);
                } else {
                    listener.onAfterUpdate(pmlFileStatusStateProcess);
                }
            }
        }

        return pmlFileStatusStateProcess;
    }

    public PmlFileStatusStateProcess updateImpl(
        com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess pmlFileStatusStateProcess,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlFileStatusStateProcess);
            } else {
                if (pmlFileStatusStateProcess.isNew()) {
                    session.save(pmlFileStatusStateProcess);
                }
            }

            session.flush();

            pmlFileStatusStateProcess.setNew(false);

            return pmlFileStatusStateProcess;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileStatusStateProcess.class.getName());
        }
    }

    public PmlFileStatusStateProcess findByPrimaryKey(long id)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        PmlFileStatusStateProcess pmlFileStatusStateProcess = fetchByPrimaryKey(id);

        if (pmlFileStatusStateProcess == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlFileStatusStateProcess exists with the primary key " +
                    id);
            }

            throw new NoSuchPmlFileStatusStateProcessException(
                "No PmlFileStatusStateProcess exists with the primary key " +
                id);
        }

        return pmlFileStatusStateProcess;
    }

    public PmlFileStatusStateProcess fetchByPrimaryKey(long id)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlFileStatusStateProcess) session.get(PmlFileStatusStateProcessImpl.class,
                new Long(id));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileStatusStateProcess> findByFileStatusId(long fileStatusId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatusStateProcess.class.getName();
        String finderMethodName = "findByFileStatusId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(fileStatusId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                List<PmlFileStatusStateProcess> list = q.list();

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
            return (List<PmlFileStatusStateProcess>) result;
        }
    }

    public List<PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end) throws SystemException {
        return findByFileStatusId(fileStatusId, start, end, null);
    }

    public List<PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatusStateProcess.class.getName();
        String finderMethodName = "findByFileStatusId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(fileStatusId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                List<PmlFileStatusStateProcess> list = (List<PmlFileStatusStateProcess>) QueryUtil.list(q,
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
            return (List<PmlFileStatusStateProcess>) result;
        }
    }

    public PmlFileStatusStateProcess findByFileStatusId_First(
        long fileStatusId, OrderByComparator obc)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        List<PmlFileStatusStateProcess> list = findByFileStatusId(fileStatusId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatusStateProcess exists with the key {");

            msg.append("fileStatusId=" + fileStatusId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatusStateProcess findByFileStatusId_Last(
        long fileStatusId, OrderByComparator obc)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        int count = countByFileStatusId(fileStatusId);

        List<PmlFileStatusStateProcess> list = findByFileStatusId(fileStatusId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatusStateProcess exists with the key {");

            msg.append("fileStatusId=" + fileStatusId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatusStateProcess[] findByFileStatusId_PrevAndNext(long id,
        long fileStatusId, OrderByComparator obc)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        PmlFileStatusStateProcess pmlFileStatusStateProcess = findByPrimaryKey(id);

        int count = countByFileStatusId(fileStatusId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess WHERE ");

            query.append("filestatusid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(fileStatusId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatusStateProcess);

            PmlFileStatusStateProcess[] array = new PmlFileStatusStateProcessImpl[3];

            array[0] = (PmlFileStatusStateProcess) objArray[0];
            array[1] = (PmlFileStatusStateProcess) objArray[1];
            array[2] = (PmlFileStatusStateProcess) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatusStateProcess.class.getName();
        String finderMethodName = "findByStateProcessId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess WHERE ");

                query.append("stateprocessid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessId);

                List<PmlFileStatusStateProcess> list = q.list();

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
            return (List<PmlFileStatusStateProcess>) result;
        }
    }

    public List<PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId, int start, int end) throws SystemException {
        return findByStateProcessId(stateProcessId, start, end, null);
    }

    public List<PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatusStateProcess.class.getName();
        String finderMethodName = "findByStateProcessId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(stateProcessId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess WHERE ");

                query.append("stateprocessid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessId);

                List<PmlFileStatusStateProcess> list = (List<PmlFileStatusStateProcess>) QueryUtil.list(q,
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
            return (List<PmlFileStatusStateProcess>) result;
        }
    }

    public PmlFileStatusStateProcess findByStateProcessId_First(
        long stateProcessId, OrderByComparator obc)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        List<PmlFileStatusStateProcess> list = findByStateProcessId(stateProcessId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatusStateProcess exists with the key {");

            msg.append("stateProcessId=" + stateProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatusStateProcess findByStateProcessId_Last(
        long stateProcessId, OrderByComparator obc)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        int count = countByStateProcessId(stateProcessId);

        List<PmlFileStatusStateProcess> list = findByStateProcessId(stateProcessId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatusStateProcess exists with the key {");

            msg.append("stateProcessId=" + stateProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatusStateProcess[] findByStateProcessId_PrevAndNext(
        long id, long stateProcessId, OrderByComparator obc)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        PmlFileStatusStateProcess pmlFileStatusStateProcess = findByPrimaryKey(id);

        int count = countByStateProcessId(stateProcessId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess WHERE ");

            query.append("stateprocessid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatusStateProcess);

            PmlFileStatusStateProcess[] array = new PmlFileStatusStateProcessImpl[3];

            array[0] = (PmlFileStatusStateProcess) objArray[0];
            array[1] = (PmlFileStatusStateProcess) objArray[1];
            array[2] = (PmlFileStatusStateProcess) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatusStateProcess.class.getName();
        String finderMethodName = "findByFileStatus_StateProcess";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(fileStatusId), new Long(stateProcessId)
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" AND ");

                query.append("stateprocessid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                qPos.add(stateProcessId);

                List<PmlFileStatusStateProcess> list = q.list();

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
            return (List<PmlFileStatusStateProcess>) result;
        }
    }

    public List<PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessId, int start, int end)
        throws SystemException {
        return findByFileStatus_StateProcess(fileStatusId, stateProcessId,
            start, end, null);
    }

    public List<PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatusStateProcess.class.getName();
        String finderMethodName = "findByFileStatus_StateProcess";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(fileStatusId), new Long(stateProcessId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" AND ");

                query.append("stateprocessid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                qPos.add(stateProcessId);

                List<PmlFileStatusStateProcess> list = (List<PmlFileStatusStateProcess>) QueryUtil.list(q,
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
            return (List<PmlFileStatusStateProcess>) result;
        }
    }

    public PmlFileStatusStateProcess findByFileStatus_StateProcess_First(
        long fileStatusId, long stateProcessId, OrderByComparator obc)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        List<PmlFileStatusStateProcess> list = findByFileStatus_StateProcess(fileStatusId,
                stateProcessId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatusStateProcess exists with the key {");

            msg.append("fileStatusId=" + fileStatusId);

            msg.append(", ");
            msg.append("stateProcessId=" + stateProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatusStateProcess findByFileStatus_StateProcess_Last(
        long fileStatusId, long stateProcessId, OrderByComparator obc)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        int count = countByFileStatus_StateProcess(fileStatusId, stateProcessId);

        List<PmlFileStatusStateProcess> list = findByFileStatus_StateProcess(fileStatusId,
                stateProcessId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatusStateProcess exists with the key {");

            msg.append("fileStatusId=" + fileStatusId);

            msg.append(", ");
            msg.append("stateProcessId=" + stateProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatusStateProcess[] findByFileStatus_StateProcess_PrevAndNext(
        long id, long fileStatusId, long stateProcessId, OrderByComparator obc)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        PmlFileStatusStateProcess pmlFileStatusStateProcess = findByPrimaryKey(id);

        int count = countByFileStatus_StateProcess(fileStatusId, stateProcessId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess WHERE ");

            query.append("filestatusid = ?");

            query.append(" AND ");

            query.append("stateprocessid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(fileStatusId);

            qPos.add(stateProcessId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatusStateProcess);

            PmlFileStatusStateProcess[] array = new PmlFileStatusStateProcessImpl[3];

            array[0] = (PmlFileStatusStateProcess) objArray[0];
            array[1] = (PmlFileStatusStateProcess) objArray[1];
            array[2] = (PmlFileStatusStateProcess) objArray[2];

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

    public List<PmlFileStatusStateProcess> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileStatusStateProcess> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileStatusStateProcess> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatusStateProcess.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlFileStatusStateProcess> list = (List<PmlFileStatusStateProcess>) QueryUtil.list(q,
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
            return (List<PmlFileStatusStateProcess>) result;
        }
    }

    public void removeByFileStatusId(long fileStatusId)
        throws SystemException {
        for (PmlFileStatusStateProcess pmlFileStatusStateProcess : findByFileStatusId(
                fileStatusId)) {
            remove(pmlFileStatusStateProcess);
        }
    }

    public void removeByStateProcessId(long stateProcessId)
        throws SystemException {
        for (PmlFileStatusStateProcess pmlFileStatusStateProcess : findByStateProcessId(
                stateProcessId)) {
            remove(pmlFileStatusStateProcess);
        }
    }

    public void removeByFileStatus_StateProcess(long fileStatusId,
        long stateProcessId) throws SystemException {
        for (PmlFileStatusStateProcess pmlFileStatusStateProcess : findByFileStatus_StateProcess(
                fileStatusId, stateProcessId)) {
            remove(pmlFileStatusStateProcess);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFileStatusStateProcess pmlFileStatusStateProcess : findAll()) {
            remove(pmlFileStatusStateProcess);
        }
    }

    public int countByFileStatusId(long fileStatusId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatusStateProcess.class.getName();
        String finderMethodName = "countByFileStatusId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(fileStatusId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

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

    public int countByStateProcessId(long stateProcessId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatusStateProcess.class.getName();
        String finderMethodName = "countByStateProcessId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess WHERE ");

                query.append("stateprocessid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessId);

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

    public int countByFileStatus_StateProcess(long fileStatusId,
        long stateProcessId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatusStateProcess.class.getName();
        String finderMethodName = "countByFileStatus_StateProcess";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(fileStatusId), new Long(stateProcessId)
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" AND ");

                query.append("stateprocessid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                qPos.add(stateProcessId);

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
        boolean finderClassNameCacheEnabled = PmlFileStatusStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatusStateProcess.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess")));

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
