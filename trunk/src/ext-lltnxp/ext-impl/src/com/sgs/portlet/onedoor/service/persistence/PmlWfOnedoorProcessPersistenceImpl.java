package com.sgs.portlet.onedoor.service.persistence;

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

import com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException;
import com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess;
import com.sgs.portlet.onedoor.model.impl.PmlWfOnedoorProcessImpl;
import com.sgs.portlet.onedoor.model.impl.PmlWfOnedoorProcessModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlWfOnedoorProcessPersistenceImpl extends BasePersistenceImpl
    implements PmlWfOnedoorProcessPersistence {
    private static Log _log = LogFactory.getLog(PmlWfOnedoorProcessPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlWfOnedoorProcess create(String fileId) {
        PmlWfOnedoorProcess pmlWfOnedoorProcess = new PmlWfOnedoorProcessImpl();

        pmlWfOnedoorProcess.setNew(true);
        pmlWfOnedoorProcess.setPrimaryKey(fileId);

        return pmlWfOnedoorProcess;
    }

    public PmlWfOnedoorProcess remove(String fileId)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlWfOnedoorProcess pmlWfOnedoorProcess = (PmlWfOnedoorProcess) session.get(PmlWfOnedoorProcessImpl.class,
                    fileId);

            if (pmlWfOnedoorProcess == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlWfOnedoorProcess exists with the primary key " +
                        fileId);
                }

                throw new NoSuchPmlWfOnedoorProcessException(
                    "No PmlWfOnedoorProcess exists with the primary key " +
                    fileId);
            }

            return remove(pmlWfOnedoorProcess);
        } catch (NoSuchPmlWfOnedoorProcessException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlWfOnedoorProcess remove(PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlWfOnedoorProcess);
            }
        }

        pmlWfOnedoorProcess = removeImpl(pmlWfOnedoorProcess);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlWfOnedoorProcess);
            }
        }

        return pmlWfOnedoorProcess;
    }

    protected PmlWfOnedoorProcess removeImpl(
        PmlWfOnedoorProcess pmlWfOnedoorProcess) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlWfOnedoorProcess);

            session.flush();

            return pmlWfOnedoorProcess;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlWfOnedoorProcess.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlWfOnedoorProcess pmlWfOnedoorProcess, boolean merge)</code>.
     */
    public PmlWfOnedoorProcess update(PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlWfOnedoorProcess pmlWfOnedoorProcess) method. Use update(PmlWfOnedoorProcess pmlWfOnedoorProcess, boolean merge) instead.");
        }

        return update(pmlWfOnedoorProcess, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlWfOnedoorProcess the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlWfOnedoorProcess is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlWfOnedoorProcess update(PmlWfOnedoorProcess pmlWfOnedoorProcess,
        boolean merge) throws SystemException {
        boolean isNew = pmlWfOnedoorProcess.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlWfOnedoorProcess);
                } else {
                    listener.onBeforeUpdate(pmlWfOnedoorProcess);
                }
            }
        }

        pmlWfOnedoorProcess = updateImpl(pmlWfOnedoorProcess, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlWfOnedoorProcess);
                } else {
                    listener.onAfterUpdate(pmlWfOnedoorProcess);
                }
            }
        }

        return pmlWfOnedoorProcess;
    }

    public PmlWfOnedoorProcess updateImpl(
        com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlWfOnedoorProcess);
            } else {
                if (pmlWfOnedoorProcess.isNew()) {
                    session.save(pmlWfOnedoorProcess);
                }
            }

            session.flush();

            pmlWfOnedoorProcess.setNew(false);

            return pmlWfOnedoorProcess;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlWfOnedoorProcess.class.getName());
        }
    }

    public PmlWfOnedoorProcess findByPrimaryKey(String fileId)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        PmlWfOnedoorProcess pmlWfOnedoorProcess = fetchByPrimaryKey(fileId);

        if (pmlWfOnedoorProcess == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlWfOnedoorProcess exists with the primary key " +
                    fileId);
            }

            throw new NoSuchPmlWfOnedoorProcessException(
                "No PmlWfOnedoorProcess exists with the primary key " + fileId);
        }

        return pmlWfOnedoorProcess;
    }

    public PmlWfOnedoorProcess fetchByPrimaryKey(String fileId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlWfOnedoorProcess) session.get(PmlWfOnedoorProcessImpl.class,
                fileId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlWfOnedoorProcess> findByNodeId(long nodeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWfOnedoorProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWfOnedoorProcess.class.getName();
        String finderMethodName = "findByNodeId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(nodeId) };

        Object result = null;

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
                    "FROM com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess WHERE ");

                query.append("nodeId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(nodeId);

                List<PmlWfOnedoorProcess> list = q.list();

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
            return (List<PmlWfOnedoorProcess>) result;
        }
    }

    public List<PmlWfOnedoorProcess> findByNodeId(long nodeId, int start,
        int end) throws SystemException {
        return findByNodeId(nodeId, start, end, null);
    }

    public List<PmlWfOnedoorProcess> findByNodeId(long nodeId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWfOnedoorProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWfOnedoorProcess.class.getName();
        String finderMethodName = "findByNodeId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(nodeId),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess WHERE ");

                query.append("nodeId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(nodeId);

                List<PmlWfOnedoorProcess> list = (List<PmlWfOnedoorProcess>) QueryUtil.list(q,
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
            return (List<PmlWfOnedoorProcess>) result;
        }
    }

    public PmlWfOnedoorProcess findByNodeId_First(long nodeId,
        OrderByComparator obc)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        List<PmlWfOnedoorProcess> list = findByNodeId(nodeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWfOnedoorProcess exists with the key {");

            msg.append("nodeId=" + nodeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWfOnedoorProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWfOnedoorProcess findByNodeId_Last(long nodeId,
        OrderByComparator obc)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        int count = countByNodeId(nodeId);

        List<PmlWfOnedoorProcess> list = findByNodeId(nodeId, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWfOnedoorProcess exists with the key {");

            msg.append("nodeId=" + nodeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWfOnedoorProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWfOnedoorProcess[] findByNodeId_PrevAndNext(String fileId,
        long nodeId, OrderByComparator obc)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        PmlWfOnedoorProcess pmlWfOnedoorProcess = findByPrimaryKey(fileId);

        int count = countByNodeId(nodeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess WHERE ");

            query.append("nodeId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(nodeId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlWfOnedoorProcess);

            PmlWfOnedoorProcess[] array = new PmlWfOnedoorProcessImpl[3];

            array[0] = (PmlWfOnedoorProcess) objArray[0];
            array[1] = (PmlWfOnedoorProcess) objArray[1];
            array[2] = (PmlWfOnedoorProcess) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlWfOnedoorProcess> findByProcessId(long processId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWfOnedoorProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWfOnedoorProcess.class.getName();
        String finderMethodName = "findByProcessId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(processId) };

        Object result = null;

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
                    "FROM com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess WHERE ");

                query.append("processId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId);

                List<PmlWfOnedoorProcess> list = q.list();

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
            return (List<PmlWfOnedoorProcess>) result;
        }
    }

    public List<PmlWfOnedoorProcess> findByProcessId(long processId, int start,
        int end) throws SystemException {
        return findByProcessId(processId, start, end, null);
    }

    public List<PmlWfOnedoorProcess> findByProcessId(long processId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWfOnedoorProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWfOnedoorProcess.class.getName();
        String finderMethodName = "findByProcessId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(processId),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess WHERE ");

                query.append("processId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId);

                List<PmlWfOnedoorProcess> list = (List<PmlWfOnedoorProcess>) QueryUtil.list(q,
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
            return (List<PmlWfOnedoorProcess>) result;
        }
    }

    public PmlWfOnedoorProcess findByProcessId_First(long processId,
        OrderByComparator obc)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        List<PmlWfOnedoorProcess> list = findByProcessId(processId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWfOnedoorProcess exists with the key {");

            msg.append("processId=" + processId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWfOnedoorProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWfOnedoorProcess findByProcessId_Last(long processId,
        OrderByComparator obc)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        int count = countByProcessId(processId);

        List<PmlWfOnedoorProcess> list = findByProcessId(processId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWfOnedoorProcess exists with the key {");

            msg.append("processId=" + processId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWfOnedoorProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWfOnedoorProcess[] findByProcessId_PrevAndNext(String fileId,
        long processId, OrderByComparator obc)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        PmlWfOnedoorProcess pmlWfOnedoorProcess = findByPrimaryKey(fileId);

        int count = countByProcessId(processId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess WHERE ");

            query.append("processId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlWfOnedoorProcess);

            PmlWfOnedoorProcess[] array = new PmlWfOnedoorProcessImpl[3];

            array[0] = (PmlWfOnedoorProcess) objArray[0];
            array[1] = (PmlWfOnedoorProcess) objArray[1];
            array[2] = (PmlWfOnedoorProcess) objArray[2];

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

    public List<PmlWfOnedoorProcess> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlWfOnedoorProcess> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlWfOnedoorProcess> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWfOnedoorProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWfOnedoorProcess.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlWfOnedoorProcess> list = (List<PmlWfOnedoorProcess>) QueryUtil.list(q,
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
            return (List<PmlWfOnedoorProcess>) result;
        }
    }

    public void removeByNodeId(long nodeId) throws SystemException {
        for (PmlWfOnedoorProcess pmlWfOnedoorProcess : findByNodeId(nodeId)) {
            remove(pmlWfOnedoorProcess);
        }
    }

    public void removeByProcessId(long processId) throws SystemException {
        for (PmlWfOnedoorProcess pmlWfOnedoorProcess : findByProcessId(
                processId)) {
            remove(pmlWfOnedoorProcess);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlWfOnedoorProcess pmlWfOnedoorProcess : findAll()) {
            remove(pmlWfOnedoorProcess);
        }
    }

    public int countByNodeId(long nodeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWfOnedoorProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWfOnedoorProcess.class.getName();
        String finderMethodName = "countByNodeId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(nodeId) };

        Object result = null;

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
                    "FROM com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess WHERE ");

                query.append("nodeId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(nodeId);

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

    public int countByProcessId(long processId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWfOnedoorProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWfOnedoorProcess.class.getName();
        String finderMethodName = "countByProcessId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(processId) };

        Object result = null;

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
                    "FROM com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess WHERE ");

                query.append("processId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId);

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
        boolean finderClassNameCacheEnabled = PmlWfOnedoorProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWfOnedoorProcess.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess");

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
                        "value.object.listener.com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess")));

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
