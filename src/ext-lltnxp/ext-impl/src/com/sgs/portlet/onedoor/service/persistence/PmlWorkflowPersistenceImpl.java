package com.sgs.portlet.onedoor.service.persistence;

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

import com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;
import com.sgs.portlet.onedoor.model.PmlWorkflow;
import com.sgs.portlet.onedoor.model.impl.PmlWorkflowImpl;
import com.sgs.portlet.onedoor.model.impl.PmlWorkflowModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlWorkflowPersistenceImpl extends BasePersistenceImpl
    implements PmlWorkflowPersistence {
    private static Log _log = LogFactory.getLog(PmlWorkflowPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlWorkflow create(long workflowId) {
        PmlWorkflow pmlWorkflow = new PmlWorkflowImpl();

        pmlWorkflow.setNew(true);
        pmlWorkflow.setPrimaryKey(workflowId);

        return pmlWorkflow;
    }

    public PmlWorkflow remove(long workflowId)
        throws NoSuchPmlWorkflowException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlWorkflow pmlWorkflow = (PmlWorkflow) session.get(PmlWorkflowImpl.class,
                    new Long(workflowId));

            if (pmlWorkflow == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlWorkflow exists with the primary key " +
                        workflowId);
                }

                throw new NoSuchPmlWorkflowException(
                    "No PmlWorkflow exists with the primary key " + workflowId);
            }

            return remove(pmlWorkflow);
        } catch (NoSuchPmlWorkflowException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlWorkflow remove(PmlWorkflow pmlWorkflow)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlWorkflow);
            }
        }

        pmlWorkflow = removeImpl(pmlWorkflow);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlWorkflow);
            }
        }

        return pmlWorkflow;
    }

    protected PmlWorkflow removeImpl(PmlWorkflow pmlWorkflow)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlWorkflow);

            session.flush();

            return pmlWorkflow;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlWorkflow.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlWorkflow pmlWorkflow, boolean merge)</code>.
     */
    public PmlWorkflow update(PmlWorkflow pmlWorkflow)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlWorkflow pmlWorkflow) method. Use update(PmlWorkflow pmlWorkflow, boolean merge) instead.");
        }

        return update(pmlWorkflow, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlWorkflow the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlWorkflow is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlWorkflow update(PmlWorkflow pmlWorkflow, boolean merge)
        throws SystemException {
        boolean isNew = pmlWorkflow.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlWorkflow);
                } else {
                    listener.onBeforeUpdate(pmlWorkflow);
                }
            }
        }

        pmlWorkflow = updateImpl(pmlWorkflow, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlWorkflow);
                } else {
                    listener.onAfterUpdate(pmlWorkflow);
                }
            }
        }

        return pmlWorkflow;
    }

    public PmlWorkflow updateImpl(
        com.sgs.portlet.onedoor.model.PmlWorkflow pmlWorkflow, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlWorkflow);
            } else {
                if (pmlWorkflow.isNew()) {
                    session.save(pmlWorkflow);
                }
            }

            session.flush();

            pmlWorkflow.setNew(false);

            return pmlWorkflow;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlWorkflow.class.getName());
        }
    }

    public PmlWorkflow findByPrimaryKey(long workflowId)
        throws NoSuchPmlWorkflowException, SystemException {
        PmlWorkflow pmlWorkflow = fetchByPrimaryKey(workflowId);

        if (pmlWorkflow == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlWorkflow exists with the primary key " +
                    workflowId);
            }

            throw new NoSuchPmlWorkflowException(
                "No PmlWorkflow exists with the primary key " + workflowId);
        }

        return pmlWorkflow;
    }

    public PmlWorkflow fetchByPrimaryKey(long workflowId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlWorkflow) session.get(PmlWorkflowImpl.class,
                new Long(workflowId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlWorkflow> findByFileTypeId(String fileTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
        String finderMethodName = "findByFileTypeId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileTypeId };

        Object result = null;

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
                    "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("workflowId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlWorkflow> list = q.list();

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
            return (List<PmlWorkflow>) result;
        }
    }

    public List<PmlWorkflow> findByFileTypeId(String fileTypeId, int start,
        int end) throws SystemException {
        return findByFileTypeId(fileTypeId, start, end, null);
    }

    public List<PmlWorkflow> findByFileTypeId(String fileTypeId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
        String finderMethodName = "findByFileTypeId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("workflowId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlWorkflow> list = (List<PmlWorkflow>) QueryUtil.list(q,
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
            return (List<PmlWorkflow>) result;
        }
    }

    public PmlWorkflow findByFileTypeId_First(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        List<PmlWorkflow> list = findByFileTypeId(fileTypeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWorkflow exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWorkflowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWorkflow findByFileTypeId_Last(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        int count = countByFileTypeId(fileTypeId);

        List<PmlWorkflow> list = findByFileTypeId(fileTypeId, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWorkflow exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWorkflowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWorkflow[] findByFileTypeId_PrevAndNext(long workflowId,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        PmlWorkflow pmlWorkflow = findByPrimaryKey(workflowId);

        int count = countByFileTypeId(fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

            if (fileTypeId == null) {
                query.append("fileTypeId LIKE null");
            } else {
                query.append("fileTypeId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("workflowId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlWorkflow);

            PmlWorkflow[] array = new PmlWorkflowImpl[3];

            array[0] = (PmlWorkflow) objArray[0];
            array[1] = (PmlWorkflow) objArray[1];
            array[2] = (PmlWorkflow) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlWorkflow> findByFileTypeId_StartDate(String fileTypeId,
        Date startDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
        String finderMethodName = "findByFileTypeId_StartDate";
        String[] finderParams = new String[] {
                String.class.getName(), Date.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, startDate };

        Object result = null;

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
                    "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startDate <= null");
                } else {
                    query.append("startDate <= ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("workflowId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                List<PmlWorkflow> list = q.list();

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
            return (List<PmlWorkflow>) result;
        }
    }

    public List<PmlWorkflow> findByFileTypeId_StartDate(String fileTypeId,
        Date startDate, int start, int end) throws SystemException {
        return findByFileTypeId_StartDate(fileTypeId, startDate, start, end,
            null);
    }

    public List<PmlWorkflow> findByFileTypeId_StartDate(String fileTypeId,
        Date startDate, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
        String finderMethodName = "findByFileTypeId_StartDate";
        String[] finderParams = new String[] {
                String.class.getName(), Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                startDate,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startDate <= null");
                } else {
                    query.append("startDate <= ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("workflowId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                List<PmlWorkflow> list = (List<PmlWorkflow>) QueryUtil.list(q,
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
            return (List<PmlWorkflow>) result;
        }
    }

    public PmlWorkflow findByFileTypeId_StartDate_First(String fileTypeId,
        Date startDate, OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        List<PmlWorkflow> list = findByFileTypeId_StartDate(fileTypeId,
                startDate, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWorkflow exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("startDate=" + startDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWorkflowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWorkflow findByFileTypeId_StartDate_Last(String fileTypeId,
        Date startDate, OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        int count = countByFileTypeId_StartDate(fileTypeId, startDate);

        List<PmlWorkflow> list = findByFileTypeId_StartDate(fileTypeId,
                startDate, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWorkflow exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("startDate=" + startDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWorkflowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWorkflow[] findByFileTypeId_StartDate_PrevAndNext(
        long workflowId, String fileTypeId, Date startDate,
        OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        PmlWorkflow pmlWorkflow = findByPrimaryKey(workflowId);

        int count = countByFileTypeId_StartDate(fileTypeId, startDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

            if (fileTypeId == null) {
                query.append("fileTypeId LIKE null");
            } else {
                query.append("fileTypeId LIKE ?");
            }

            query.append(" AND ");

            if (startDate == null) {
                query.append("startDate <= null");
            } else {
                query.append("startDate <= ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("workflowId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            if (startDate != null) {
                qPos.add(CalendarUtil.getTimestamp(startDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlWorkflow);

            PmlWorkflow[] array = new PmlWorkflowImpl[3];

            array[0] = (PmlWorkflow) objArray[0];
            array[1] = (PmlWorkflow) objArray[1];
            array[2] = (PmlWorkflow) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlWorkflow> findByWorkFlow_Version(String workflow,
        int version_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
        String finderMethodName = "findByWorkFlow_Version";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { workflow, new Integer(version_) };

        Object result = null;

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
                    "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

                if (workflow == null) {
                    query.append("workflow IS NULL");
                } else {
                    query.append("workflow = ?");
                }

                query.append(" AND ");

                query.append("version_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("workflowId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflow != null) {
                    qPos.add(workflow);
                }

                qPos.add(version_);

                List<PmlWorkflow> list = q.list();

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
            return (List<PmlWorkflow>) result;
        }
    }

    public List<PmlWorkflow> findByWorkFlow_Version(String workflow,
        int version_, int start, int end) throws SystemException {
        return findByWorkFlow_Version(workflow, version_, start, end, null);
    }

    public List<PmlWorkflow> findByWorkFlow_Version(String workflow,
        int version_, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
        String finderMethodName = "findByWorkFlow_Version";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                workflow, new Integer(version_),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

                if (workflow == null) {
                    query.append("workflow IS NULL");
                } else {
                    query.append("workflow = ?");
                }

                query.append(" AND ");

                query.append("version_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("workflowId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflow != null) {
                    qPos.add(workflow);
                }

                qPos.add(version_);

                List<PmlWorkflow> list = (List<PmlWorkflow>) QueryUtil.list(q,
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
            return (List<PmlWorkflow>) result;
        }
    }

    public PmlWorkflow findByWorkFlow_Version_First(String workflow,
        int version_, OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        List<PmlWorkflow> list = findByWorkFlow_Version(workflow, version_, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWorkflow exists with the key {");

            msg.append("workflow=" + workflow);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWorkflowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWorkflow findByWorkFlow_Version_Last(String workflow,
        int version_, OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        int count = countByWorkFlow_Version(workflow, version_);

        List<PmlWorkflow> list = findByWorkFlow_Version(workflow, version_,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWorkflow exists with the key {");

            msg.append("workflow=" + workflow);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWorkflowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWorkflow[] findByWorkFlow_Version_PrevAndNext(long workflowId,
        String workflow, int version_, OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        PmlWorkflow pmlWorkflow = findByPrimaryKey(workflowId);

        int count = countByWorkFlow_Version(workflow, version_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

            if (workflow == null) {
                query.append("workflow IS NULL");
            } else {
                query.append("workflow = ?");
            }

            query.append(" AND ");

            query.append("version_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("workflowId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (workflow != null) {
                qPos.add(workflow);
            }

            qPos.add(version_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlWorkflow);

            PmlWorkflow[] array = new PmlWorkflowImpl[3];

            array[0] = (PmlWorkflow) objArray[0];
            array[1] = (PmlWorkflow) objArray[1];
            array[2] = (PmlWorkflow) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlWorkflow> findByFileTypeId_Version(String fileTypeId,
        int version_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
        String finderMethodName = "findByFileTypeId_Version";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, new Integer(version_) };

        Object result = null;

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
                    "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                query.append("version_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("workflowId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                qPos.add(version_);

                List<PmlWorkflow> list = q.list();

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
            return (List<PmlWorkflow>) result;
        }
    }

    public List<PmlWorkflow> findByFileTypeId_Version(String fileTypeId,
        int version_, int start, int end) throws SystemException {
        return findByFileTypeId_Version(fileTypeId, version_, start, end, null);
    }

    public List<PmlWorkflow> findByFileTypeId_Version(String fileTypeId,
        int version_, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
        String finderMethodName = "findByFileTypeId_Version";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileTypeId, new Integer(version_),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                query.append("version_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("workflowId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                qPos.add(version_);

                List<PmlWorkflow> list = (List<PmlWorkflow>) QueryUtil.list(q,
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
            return (List<PmlWorkflow>) result;
        }
    }

    public PmlWorkflow findByFileTypeId_Version_First(String fileTypeId,
        int version_, OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        List<PmlWorkflow> list = findByFileTypeId_Version(fileTypeId, version_,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWorkflow exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWorkflowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWorkflow findByFileTypeId_Version_Last(String fileTypeId,
        int version_, OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        int count = countByFileTypeId_Version(fileTypeId, version_);

        List<PmlWorkflow> list = findByFileTypeId_Version(fileTypeId, version_,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWorkflow exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWorkflowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWorkflow[] findByFileTypeId_Version_PrevAndNext(long workflowId,
        String fileTypeId, int version_, OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        PmlWorkflow pmlWorkflow = findByPrimaryKey(workflowId);

        int count = countByFileTypeId_Version(fileTypeId, version_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

            if (fileTypeId == null) {
                query.append("fileTypeId LIKE null");
            } else {
                query.append("fileTypeId LIKE ?");
            }

            query.append(" AND ");

            query.append("version_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("workflowId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            qPos.add(version_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlWorkflow);

            PmlWorkflow[] array = new PmlWorkflowImpl[3];

            array[0] = (PmlWorkflow) objArray[0];
            array[1] = (PmlWorkflow) objArray[1];
            array[2] = (PmlWorkflow) objArray[2];

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

    public List<PmlWorkflow> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlWorkflow> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlWorkflow> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
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

                query.append("FROM com.sgs.portlet.onedoor.model.PmlWorkflow ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("workflowId DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlWorkflow> list = (List<PmlWorkflow>) QueryUtil.list(q,
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
            return (List<PmlWorkflow>) result;
        }
    }

    public void removeByFileTypeId(String fileTypeId) throws SystemException {
        for (PmlWorkflow pmlWorkflow : findByFileTypeId(fileTypeId)) {
            remove(pmlWorkflow);
        }
    }

    public void removeByFileTypeId_StartDate(String fileTypeId, Date startDate)
        throws SystemException {
        for (PmlWorkflow pmlWorkflow : findByFileTypeId_StartDate(fileTypeId,
                startDate)) {
            remove(pmlWorkflow);
        }
    }

    public void removeByWorkFlow_Version(String workflow, int version_)
        throws SystemException {
        for (PmlWorkflow pmlWorkflow : findByWorkFlow_Version(workflow, version_)) {
            remove(pmlWorkflow);
        }
    }

    public void removeByFileTypeId_Version(String fileTypeId, int version_)
        throws SystemException {
        for (PmlWorkflow pmlWorkflow : findByFileTypeId_Version(fileTypeId,
                version_)) {
            remove(pmlWorkflow);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlWorkflow pmlWorkflow : findAll()) {
            remove(pmlWorkflow);
        }
    }

    public int countByFileTypeId(String fileTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
        String finderMethodName = "countByFileTypeId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileTypeId };

        Object result = null;

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
                    "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
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

    public int countByFileTypeId_StartDate(String fileTypeId, Date startDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
        String finderMethodName = "countByFileTypeId_StartDate";
        String[] finderParams = new String[] {
                String.class.getName(), Date.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, startDate };

        Object result = null;

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
                    "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startDate <= null");
                } else {
                    query.append("startDate <= ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
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

    public int countByWorkFlow_Version(String workflow, int version_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
        String finderMethodName = "countByWorkFlow_Version";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { workflow, new Integer(version_) };

        Object result = null;

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
                    "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

                if (workflow == null) {
                    query.append("workflow IS NULL");
                } else {
                    query.append("workflow = ?");
                }

                query.append(" AND ");

                query.append("version_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflow != null) {
                    qPos.add(workflow);
                }

                qPos.add(version_);

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

    public int countByFileTypeId_Version(String fileTypeId, int version_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
        String finderMethodName = "countByFileTypeId_Version";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, new Integer(version_) };

        Object result = null;

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
                    "FROM com.sgs.portlet.onedoor.model.PmlWorkflow WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                query.append("version_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                qPos.add(version_);

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
        boolean finderClassNameCacheEnabled = PmlWorkflowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlWorkflow.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoor.model.PmlWorkflow");

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
                        "value.object.listener.com.sgs.portlet.onedoor.model.PmlWorkflow")));

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
