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

import com.sgs.portlet.document.NoSuchPmlStateWorkFlowException;
import com.sgs.portlet.document.model.PmlStateWorkFlow;
import com.sgs.portlet.document.model.impl.PmlStateWorkFlowImpl;
import com.sgs.portlet.document.model.impl.PmlStateWorkFlowModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlStateWorkFlowPersistenceImpl extends BasePersistenceImpl
    implements PmlStateWorkFlowPersistence {
    private static Log _log = LogFactory.getLog(PmlStateWorkFlowPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlStateWorkFlow create(long stateWfId) {
        PmlStateWorkFlow pmlStateWorkFlow = new PmlStateWorkFlowImpl();

        pmlStateWorkFlow.setNew(true);
        pmlStateWorkFlow.setPrimaryKey(stateWfId);

        return pmlStateWorkFlow;
    }

    public PmlStateWorkFlow remove(long stateWfId)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlStateWorkFlow pmlStateWorkFlow = (PmlStateWorkFlow) session.get(PmlStateWorkFlowImpl.class,
                    new Long(stateWfId));

            if (pmlStateWorkFlow == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlStateWorkFlow exists with the primary key " +
                        stateWfId);
                }

                throw new NoSuchPmlStateWorkFlowException(
                    "No PmlStateWorkFlow exists with the primary key " +
                    stateWfId);
            }

            return remove(pmlStateWorkFlow);
        } catch (NoSuchPmlStateWorkFlowException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlStateWorkFlow remove(PmlStateWorkFlow pmlStateWorkFlow)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlStateWorkFlow);
            }
        }

        pmlStateWorkFlow = removeImpl(pmlStateWorkFlow);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlStateWorkFlow);
            }
        }

        return pmlStateWorkFlow;
    }

    protected PmlStateWorkFlow removeImpl(PmlStateWorkFlow pmlStateWorkFlow)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlStateWorkFlow);

            session.flush();

            return pmlStateWorkFlow;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlStateWorkFlow.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlStateWorkFlow pmlStateWorkFlow, boolean merge)</code>.
     */
    public PmlStateWorkFlow update(PmlStateWorkFlow pmlStateWorkFlow)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlStateWorkFlow pmlStateWorkFlow) method. Use update(PmlStateWorkFlow pmlStateWorkFlow, boolean merge) instead.");
        }

        return update(pmlStateWorkFlow, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlStateWorkFlow the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlStateWorkFlow is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlStateWorkFlow update(PmlStateWorkFlow pmlStateWorkFlow,
        boolean merge) throws SystemException {
        boolean isNew = pmlStateWorkFlow.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlStateWorkFlow);
                } else {
                    listener.onBeforeUpdate(pmlStateWorkFlow);
                }
            }
        }

        pmlStateWorkFlow = updateImpl(pmlStateWorkFlow, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlStateWorkFlow);
                } else {
                    listener.onAfterUpdate(pmlStateWorkFlow);
                }
            }
        }

        return pmlStateWorkFlow;
    }

    public PmlStateWorkFlow updateImpl(
        com.sgs.portlet.document.model.PmlStateWorkFlow pmlStateWorkFlow,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlStateWorkFlow);
            } else {
                if (pmlStateWorkFlow.isNew()) {
                    session.save(pmlStateWorkFlow);
                }
            }

            session.flush();

            pmlStateWorkFlow.setNew(false);

            return pmlStateWorkFlow;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlStateWorkFlow.class.getName());
        }
    }

    public PmlStateWorkFlow findByPrimaryKey(long stateWfId)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        PmlStateWorkFlow pmlStateWorkFlow = fetchByPrimaryKey(stateWfId);

        if (pmlStateWorkFlow == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlStateWorkFlow exists with the primary key " +
                    stateWfId);
            }

            throw new NoSuchPmlStateWorkFlowException(
                "No PmlStateWorkFlow exists with the primary key " + stateWfId);
        }

        return pmlStateWorkFlow;
    }

    public PmlStateWorkFlow fetchByPrimaryKey(long stateWfId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlStateWorkFlow) session.get(PmlStateWorkFlowImpl.class,
                new Long(stateWfId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(
        String workflow, long stateProcessId, int version_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
        String finderMethodName = "findByWorkFlow_StateProcessId_Version";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                workflow, new Long(stateProcessId), new Integer(version_)
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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                if (workflow == null) {
                    query.append("workflow LIKE null");
                } else {
                    query.append("workflow LIKE ?");
                }

                query.append(" AND ");

                query.append("stateprocessid = ?");

                query.append(" AND ");

                query.append("version_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("statewfid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflow != null) {
                    qPos.add(workflow);
                }

                qPos.add(stateProcessId);

                qPos.add(version_);

                List<PmlStateWorkFlow> list = q.list();

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
            return (List<PmlStateWorkFlow>) result;
        }
    }

    public List<PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(
        String workflow, long stateProcessId, int version_, int start, int end)
        throws SystemException {
        return findByWorkFlow_StateProcessId_Version(workflow, stateProcessId,
            version_, start, end, null);
    }

    public List<PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(
        String workflow, long stateProcessId, int version_, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
        String finderMethodName = "findByWorkFlow_StateProcessId_Version";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                workflow, new Long(stateProcessId), new Integer(version_),
                
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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                if (workflow == null) {
                    query.append("workflow LIKE null");
                } else {
                    query.append("workflow LIKE ?");
                }

                query.append(" AND ");

                query.append("stateprocessid = ?");

                query.append(" AND ");

                query.append("version_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("statewfid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflow != null) {
                    qPos.add(workflow);
                }

                qPos.add(stateProcessId);

                qPos.add(version_);

                List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) QueryUtil.list(q,
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
            return (List<PmlStateWorkFlow>) result;
        }
    }

    public PmlStateWorkFlow findByWorkFlow_StateProcessId_Version_First(
        String workflow, long stateProcessId, int version_,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        List<PmlStateWorkFlow> list = findByWorkFlow_StateProcessId_Version(workflow,
                stateProcessId, version_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateWorkFlow exists with the key {");

            msg.append("workflow=" + workflow);

            msg.append(", ");
            msg.append("stateProcessId=" + stateProcessId);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateWorkFlowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateWorkFlow findByWorkFlow_StateProcessId_Version_Last(
        String workflow, long stateProcessId, int version_,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        int count = countByWorkFlow_StateProcessId_Version(workflow,
                stateProcessId, version_);

        List<PmlStateWorkFlow> list = findByWorkFlow_StateProcessId_Version(workflow,
                stateProcessId, version_, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateWorkFlow exists with the key {");

            msg.append("workflow=" + workflow);

            msg.append(", ");
            msg.append("stateProcessId=" + stateProcessId);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateWorkFlowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateWorkFlow[] findByWorkFlow_StateProcessId_Version_PrevAndNext(
        long stateWfId, String workflow, long stateProcessId, int version_,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        PmlStateWorkFlow pmlStateWorkFlow = findByPrimaryKey(stateWfId);

        int count = countByWorkFlow_StateProcessId_Version(workflow,
                stateProcessId, version_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

            if (workflow == null) {
                query.append("workflow LIKE null");
            } else {
                query.append("workflow LIKE ?");
            }

            query.append(" AND ");

            query.append("stateprocessid = ?");

            query.append(" AND ");

            query.append("version_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("statewfid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (workflow != null) {
                qPos.add(workflow);
            }

            qPos.add(stateProcessId);

            qPos.add(version_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateWorkFlow);

            PmlStateWorkFlow[] array = new PmlStateWorkFlowImpl[3];

            array[0] = (PmlStateWorkFlow) objArray[0];
            array[1] = (PmlStateWorkFlow) objArray[1];
            array[2] = (PmlStateWorkFlow) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateWorkFlow> findBySolvingTime(int solvingTime)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
        String finderMethodName = "findBySolvingTime";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(solvingTime) };

        Object result = null;

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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                query.append("solvingtime = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("statewfid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(solvingTime);

                List<PmlStateWorkFlow> list = q.list();

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
            return (List<PmlStateWorkFlow>) result;
        }
    }

    public List<PmlStateWorkFlow> findBySolvingTime(int solvingTime, int start,
        int end) throws SystemException {
        return findBySolvingTime(solvingTime, start, end, null);
    }

    public List<PmlStateWorkFlow> findBySolvingTime(int solvingTime, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
        String finderMethodName = "findBySolvingTime";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(solvingTime),
                
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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                query.append("solvingtime = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("statewfid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(solvingTime);

                List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) QueryUtil.list(q,
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
            return (List<PmlStateWorkFlow>) result;
        }
    }

    public PmlStateWorkFlow findBySolvingTime_First(int solvingTime,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        List<PmlStateWorkFlow> list = findBySolvingTime(solvingTime, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateWorkFlow exists with the key {");

            msg.append("solvingTime=" + solvingTime);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateWorkFlowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateWorkFlow findBySolvingTime_Last(int solvingTime,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        int count = countBySolvingTime(solvingTime);

        List<PmlStateWorkFlow> list = findBySolvingTime(solvingTime, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateWorkFlow exists with the key {");

            msg.append("solvingTime=" + solvingTime);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateWorkFlowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateWorkFlow[] findBySolvingTime_PrevAndNext(long stateWfId,
        int solvingTime, OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        PmlStateWorkFlow pmlStateWorkFlow = findByPrimaryKey(stateWfId);

        int count = countBySolvingTime(solvingTime);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

            query.append("solvingtime = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("statewfid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(solvingTime);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateWorkFlow);

            PmlStateWorkFlow[] array = new PmlStateWorkFlowImpl[3];

            array[0] = (PmlStateWorkFlow) objArray[0];
            array[1] = (PmlStateWorkFlow) objArray[1];
            array[2] = (PmlStateWorkFlow) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateWorkFlow> findByWorkflow(String workflow)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
        String finderMethodName = "findByWorkflow";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { workflow };

        Object result = null;

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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                if (workflow == null) {
                    query.append("workflow IS NULL");
                } else {
                    query.append("workflow = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("statewfid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflow != null) {
                    qPos.add(workflow);
                }

                List<PmlStateWorkFlow> list = q.list();

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
            return (List<PmlStateWorkFlow>) result;
        }
    }

    public List<PmlStateWorkFlow> findByWorkflow(String workflow, int start,
        int end) throws SystemException {
        return findByWorkflow(workflow, start, end, null);
    }

    public List<PmlStateWorkFlow> findByWorkflow(String workflow, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
        String finderMethodName = "findByWorkflow";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                workflow,
                
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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                if (workflow == null) {
                    query.append("workflow IS NULL");
                } else {
                    query.append("workflow = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("statewfid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflow != null) {
                    qPos.add(workflow);
                }

                List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) QueryUtil.list(q,
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
            return (List<PmlStateWorkFlow>) result;
        }
    }

    public PmlStateWorkFlow findByWorkflow_First(String workflow,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        List<PmlStateWorkFlow> list = findByWorkflow(workflow, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateWorkFlow exists with the key {");

            msg.append("workflow=" + workflow);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateWorkFlowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateWorkFlow findByWorkflow_Last(String workflow,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        int count = countByWorkflow(workflow);

        List<PmlStateWorkFlow> list = findByWorkflow(workflow, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateWorkFlow exists with the key {");

            msg.append("workflow=" + workflow);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateWorkFlowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateWorkFlow[] findByWorkflow_PrevAndNext(long stateWfId,
        String workflow, OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        PmlStateWorkFlow pmlStateWorkFlow = findByPrimaryKey(stateWfId);

        int count = countByWorkflow(workflow);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

            if (workflow == null) {
                query.append("workflow IS NULL");
            } else {
                query.append("workflow = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("statewfid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (workflow != null) {
                qPos.add(workflow);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateWorkFlow);

            PmlStateWorkFlow[] array = new PmlStateWorkFlowImpl[3];

            array[0] = (PmlStateWorkFlow) objArray[0];
            array[1] = (PmlStateWorkFlow) objArray[1];
            array[2] = (PmlStateWorkFlow) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateWorkFlow> findByStateProcessId(long stateProcessId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                query.append("stateprocessid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("statewfid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessId);

                List<PmlStateWorkFlow> list = q.list();

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
            return (List<PmlStateWorkFlow>) result;
        }
    }

    public List<PmlStateWorkFlow> findByStateProcessId(long stateProcessId,
        int start, int end) throws SystemException {
        return findByStateProcessId(stateProcessId, start, end, null);
    }

    public List<PmlStateWorkFlow> findByStateProcessId(long stateProcessId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                query.append("stateprocessid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("statewfid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessId);

                List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) QueryUtil.list(q,
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
            return (List<PmlStateWorkFlow>) result;
        }
    }

    public PmlStateWorkFlow findByStateProcessId_First(long stateProcessId,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        List<PmlStateWorkFlow> list = findByStateProcessId(stateProcessId, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateWorkFlow exists with the key {");

            msg.append("stateProcessId=" + stateProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateWorkFlowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateWorkFlow findByStateProcessId_Last(long stateProcessId,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        int count = countByStateProcessId(stateProcessId);

        List<PmlStateWorkFlow> list = findByStateProcessId(stateProcessId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateWorkFlow exists with the key {");

            msg.append("stateProcessId=" + stateProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateWorkFlowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateWorkFlow[] findByStateProcessId_PrevAndNext(long stateWfId,
        long stateProcessId, OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        PmlStateWorkFlow pmlStateWorkFlow = findByPrimaryKey(stateWfId);

        int count = countByStateProcessId(stateProcessId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

            query.append("stateprocessid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("statewfid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateWorkFlow);

            PmlStateWorkFlow[] array = new PmlStateWorkFlowImpl[3];

            array[0] = (PmlStateWorkFlow) objArray[0];
            array[1] = (PmlStateWorkFlow) objArray[1];
            array[2] = (PmlStateWorkFlow) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateWorkFlow> findByWorkFlow_Version(String workflow,
        int version_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                if (workflow == null) {
                    query.append("workflow LIKE null");
                } else {
                    query.append("workflow LIKE ?");
                }

                query.append(" AND ");

                query.append("version_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("statewfid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflow != null) {
                    qPos.add(workflow);
                }

                qPos.add(version_);

                List<PmlStateWorkFlow> list = q.list();

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
            return (List<PmlStateWorkFlow>) result;
        }
    }

    public List<PmlStateWorkFlow> findByWorkFlow_Version(String workflow,
        int version_, int start, int end) throws SystemException {
        return findByWorkFlow_Version(workflow, version_, start, end, null);
    }

    public List<PmlStateWorkFlow> findByWorkFlow_Version(String workflow,
        int version_, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                if (workflow == null) {
                    query.append("workflow LIKE null");
                } else {
                    query.append("workflow LIKE ?");
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

                    query.append("statewfid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflow != null) {
                    qPos.add(workflow);
                }

                qPos.add(version_);

                List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) QueryUtil.list(q,
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
            return (List<PmlStateWorkFlow>) result;
        }
    }

    public PmlStateWorkFlow findByWorkFlow_Version_First(String workflow,
        int version_, OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        List<PmlStateWorkFlow> list = findByWorkFlow_Version(workflow,
                version_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateWorkFlow exists with the key {");

            msg.append("workflow=" + workflow);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateWorkFlowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateWorkFlow findByWorkFlow_Version_Last(String workflow,
        int version_, OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        int count = countByWorkFlow_Version(workflow, version_);

        List<PmlStateWorkFlow> list = findByWorkFlow_Version(workflow,
                version_, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateWorkFlow exists with the key {");

            msg.append("workflow=" + workflow);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateWorkFlowException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateWorkFlow[] findByWorkFlow_Version_PrevAndNext(
        long stateWfId, String workflow, int version_, OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        PmlStateWorkFlow pmlStateWorkFlow = findByPrimaryKey(stateWfId);

        int count = countByWorkFlow_Version(workflow, version_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

            if (workflow == null) {
                query.append("workflow LIKE null");
            } else {
                query.append("workflow LIKE ?");
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

                query.append("statewfid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (workflow != null) {
                qPos.add(workflow);
            }

            qPos.add(version_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateWorkFlow);

            PmlStateWorkFlow[] array = new PmlStateWorkFlowImpl[3];

            array[0] = (PmlStateWorkFlow) objArray[0];
            array[1] = (PmlStateWorkFlow) objArray[1];
            array[2] = (PmlStateWorkFlow) objArray[2];

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

    public List<PmlStateWorkFlow> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlStateWorkFlow> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlStateWorkFlow> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("statewfid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) QueryUtil.list(q,
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
            return (List<PmlStateWorkFlow>) result;
        }
    }

    public void removeByWorkFlow_StateProcessId_Version(String workflow,
        long stateProcessId, int version_) throws SystemException {
        for (PmlStateWorkFlow pmlStateWorkFlow : findByWorkFlow_StateProcessId_Version(
                workflow, stateProcessId, version_)) {
            remove(pmlStateWorkFlow);
        }
    }

    public void removeBySolvingTime(int solvingTime) throws SystemException {
        for (PmlStateWorkFlow pmlStateWorkFlow : findBySolvingTime(solvingTime)) {
            remove(pmlStateWorkFlow);
        }
    }

    public void removeByWorkflow(String workflow) throws SystemException {
        for (PmlStateWorkFlow pmlStateWorkFlow : findByWorkflow(workflow)) {
            remove(pmlStateWorkFlow);
        }
    }

    public void removeByStateProcessId(long stateProcessId)
        throws SystemException {
        for (PmlStateWorkFlow pmlStateWorkFlow : findByStateProcessId(
                stateProcessId)) {
            remove(pmlStateWorkFlow);
        }
    }

    public void removeByWorkFlow_Version(String workflow, int version_)
        throws SystemException {
        for (PmlStateWorkFlow pmlStateWorkFlow : findByWorkFlow_Version(
                workflow, version_)) {
            remove(pmlStateWorkFlow);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlStateWorkFlow pmlStateWorkFlow : findAll()) {
            remove(pmlStateWorkFlow);
        }
    }

    public int countByWorkFlow_StateProcessId_Version(String workflow,
        long stateProcessId, int version_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
        String finderMethodName = "countByWorkFlow_StateProcessId_Version";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                workflow, new Long(stateProcessId), new Integer(version_)
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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                if (workflow == null) {
                    query.append("workflow LIKE null");
                } else {
                    query.append("workflow LIKE ?");
                }

                query.append(" AND ");

                query.append("stateprocessid = ?");

                query.append(" AND ");

                query.append("version_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflow != null) {
                    qPos.add(workflow);
                }

                qPos.add(stateProcessId);

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

    public int countBySolvingTime(int solvingTime) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
        String finderMethodName = "countBySolvingTime";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(solvingTime) };

        Object result = null;

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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                query.append("solvingtime = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(solvingTime);

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

    public int countByWorkflow(String workflow) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
        String finderMethodName = "countByWorkflow";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { workflow };

        Object result = null;

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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                if (workflow == null) {
                    query.append("workflow IS NULL");
                } else {
                    query.append("workflow = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workflow != null) {
                    qPos.add(workflow);
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

    public int countByStateProcessId(long stateProcessId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

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

    public int countByWorkFlow_Version(String workflow, int version_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlStateWorkFlow WHERE ");

                if (workflow == null) {
                    query.append("workflow LIKE null");
                } else {
                    query.append("workflow LIKE ?");
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

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateWorkFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateWorkFlow.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.model.PmlStateWorkFlow");

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
                        "value.object.listener.com.sgs.portlet.document.model.PmlStateWorkFlow")));

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
