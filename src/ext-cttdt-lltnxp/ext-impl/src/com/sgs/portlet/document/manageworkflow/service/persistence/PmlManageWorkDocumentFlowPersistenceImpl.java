package com.sgs.portlet.document.manageworkflow.service.persistence;

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

import com.sgs.portlet.document.manageworkflow.NoSuchException;
import com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow;
import com.sgs.portlet.document.manageworkflow.model.impl.PmlManageWorkDocumentFlowImpl;
import com.sgs.portlet.document.manageworkflow.model.impl.PmlManageWorkDocumentFlowModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlManageWorkDocumentFlowPersistenceImpl
    extends BasePersistenceImpl implements PmlManageWorkDocumentFlowPersistence {
    private static Log _log = LogFactory.getLog(PmlManageWorkDocumentFlowPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlManageWorkDocumentFlow create(long manageDocumentWorkFlowId) {
        PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow = new PmlManageWorkDocumentFlowImpl();

        pmlManageWorkDocumentFlow.setNew(true);
        pmlManageWorkDocumentFlow.setPrimaryKey(manageDocumentWorkFlowId);

        return pmlManageWorkDocumentFlow;
    }

    public PmlManageWorkDocumentFlow remove(long manageDocumentWorkFlowId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow = (PmlManageWorkDocumentFlow) session.get(PmlManageWorkDocumentFlowImpl.class,
                    new Long(manageDocumentWorkFlowId));

            if (pmlManageWorkDocumentFlow == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlManageWorkDocumentFlow exists with the primary key " +
                        manageDocumentWorkFlowId);
                }

                throw new NoSuchException(
                    "No PmlManageWorkDocumentFlow exists with the primary key " +
                    manageDocumentWorkFlowId);
            }

            return remove(pmlManageWorkDocumentFlow);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlManageWorkDocumentFlow remove(
        PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlManageWorkDocumentFlow);
            }
        }

        pmlManageWorkDocumentFlow = removeImpl(pmlManageWorkDocumentFlow);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlManageWorkDocumentFlow);
            }
        }

        return pmlManageWorkDocumentFlow;
    }

    protected PmlManageWorkDocumentFlow removeImpl(
        PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlManageWorkDocumentFlow);

            session.flush();

            return pmlManageWorkDocumentFlow;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlManageWorkDocumentFlow.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow, boolean merge)</code>.
     */
    public PmlManageWorkDocumentFlow update(
        PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow) method. Use update(PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow, boolean merge) instead.");
        }

        return update(pmlManageWorkDocumentFlow, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlManageWorkDocumentFlow the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlManageWorkDocumentFlow is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlManageWorkDocumentFlow update(
        PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow, boolean merge)
        throws SystemException {
        boolean isNew = pmlManageWorkDocumentFlow.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlManageWorkDocumentFlow);
                } else {
                    listener.onBeforeUpdate(pmlManageWorkDocumentFlow);
                }
            }
        }

        pmlManageWorkDocumentFlow = updateImpl(pmlManageWorkDocumentFlow, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlManageWorkDocumentFlow);
                } else {
                    listener.onAfterUpdate(pmlManageWorkDocumentFlow);
                }
            }
        }

        return pmlManageWorkDocumentFlow;
    }

    public PmlManageWorkDocumentFlow updateImpl(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlManageWorkDocumentFlow);
            } else {
                if (pmlManageWorkDocumentFlow.isNew()) {
                    session.save(pmlManageWorkDocumentFlow);
                }
            }

            session.flush();

            pmlManageWorkDocumentFlow.setNew(false);

            return pmlManageWorkDocumentFlow;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlManageWorkDocumentFlow.class.getName());
        }
    }

    public PmlManageWorkDocumentFlow findByPrimaryKey(
        long manageDocumentWorkFlowId) throws NoSuchException, SystemException {
        PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow = fetchByPrimaryKey(manageDocumentWorkFlowId);

        if (pmlManageWorkDocumentFlow == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlManageWorkDocumentFlow exists with the primary key " +
                    manageDocumentWorkFlowId);
            }

            throw new NoSuchException(
                "No PmlManageWorkDocumentFlow exists with the primary key " +
                manageDocumentWorkFlowId);
        }

        return pmlManageWorkDocumentFlow;
    }

    public PmlManageWorkDocumentFlow fetchByPrimaryKey(
        long manageDocumentWorkFlowId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlManageWorkDocumentFlow) session.get(PmlManageWorkDocumentFlowImpl.class,
                new Long(manageDocumentWorkFlowId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlManageWorkDocumentFlow> findByWorkFlowName(
        String workFlowName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlManageWorkDocumentFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlManageWorkDocumentFlow.class.getName();
        String finderMethodName = "findByWorkFlowName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { workFlowName };

        Object result = null;

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
                    "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow WHERE ");

                if (workFlowName == null) {
                    query.append("workflowname LIKE null");
                } else {
                    query.append("workflowname LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("managedocumentworkflowid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workFlowName != null) {
                    qPos.add(workFlowName);
                }

                List<PmlManageWorkDocumentFlow> list = q.list();

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
            return (List<PmlManageWorkDocumentFlow>) result;
        }
    }

    public List<PmlManageWorkDocumentFlow> findByWorkFlowName(
        String workFlowName, int start, int end) throws SystemException {
        return findByWorkFlowName(workFlowName, start, end, null);
    }

    public List<PmlManageWorkDocumentFlow> findByWorkFlowName(
        String workFlowName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlManageWorkDocumentFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlManageWorkDocumentFlow.class.getName();
        String finderMethodName = "findByWorkFlowName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                workFlowName,
                
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
                    "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow WHERE ");

                if (workFlowName == null) {
                    query.append("workflowname LIKE null");
                } else {
                    query.append("workflowname LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("managedocumentworkflowid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workFlowName != null) {
                    qPos.add(workFlowName);
                }

                List<PmlManageWorkDocumentFlow> list = (List<PmlManageWorkDocumentFlow>) QueryUtil.list(q,
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
            return (List<PmlManageWorkDocumentFlow>) result;
        }
    }

    public PmlManageWorkDocumentFlow findByWorkFlowName_First(
        String workFlowName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<PmlManageWorkDocumentFlow> list = findByWorkFlowName(workFlowName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlManageWorkDocumentFlow exists with the key {");

            msg.append("workFlowName=" + workFlowName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlManageWorkDocumentFlow findByWorkFlowName_Last(
        String workFlowName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByWorkFlowName(workFlowName);

        List<PmlManageWorkDocumentFlow> list = findByWorkFlowName(workFlowName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlManageWorkDocumentFlow exists with the key {");

            msg.append("workFlowName=" + workFlowName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlManageWorkDocumentFlow[] findByWorkFlowName_PrevAndNext(
        long manageDocumentWorkFlowId, String workFlowName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow = findByPrimaryKey(manageDocumentWorkFlowId);

        int count = countByWorkFlowName(workFlowName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow WHERE ");

            if (workFlowName == null) {
                query.append("workflowname LIKE null");
            } else {
                query.append("workflowname LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("managedocumentworkflowid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (workFlowName != null) {
                qPos.add(workFlowName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlManageWorkDocumentFlow);

            PmlManageWorkDocumentFlow[] array = new PmlManageWorkDocumentFlowImpl[3];

            array[0] = (PmlManageWorkDocumentFlow) objArray[0];
            array[1] = (PmlManageWorkDocumentFlow) objArray[1];
            array[2] = (PmlManageWorkDocumentFlow) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlManageWorkDocumentFlow> findByversion(int version)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlManageWorkDocumentFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlManageWorkDocumentFlow.class.getName();
        String finderMethodName = "findByversion";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(version) };

        Object result = null;

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
                    "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow WHERE ");

                query.append("version_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("managedocumentworkflowid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(version);

                List<PmlManageWorkDocumentFlow> list = q.list();

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
            return (List<PmlManageWorkDocumentFlow>) result;
        }
    }

    public List<PmlManageWorkDocumentFlow> findByversion(int version,
        int start, int end) throws SystemException {
        return findByversion(version, start, end, null);
    }

    public List<PmlManageWorkDocumentFlow> findByversion(int version,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlManageWorkDocumentFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlManageWorkDocumentFlow.class.getName();
        String finderMethodName = "findByversion";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(version),
                
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
                    "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow WHERE ");

                query.append("version_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("managedocumentworkflowid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(version);

                List<PmlManageWorkDocumentFlow> list = (List<PmlManageWorkDocumentFlow>) QueryUtil.list(q,
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
            return (List<PmlManageWorkDocumentFlow>) result;
        }
    }

    public PmlManageWorkDocumentFlow findByversion_First(int version,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlManageWorkDocumentFlow> list = findByversion(version, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlManageWorkDocumentFlow exists with the key {");

            msg.append("version=" + version);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlManageWorkDocumentFlow findByversion_Last(int version,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByversion(version);

        List<PmlManageWorkDocumentFlow> list = findByversion(version,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlManageWorkDocumentFlow exists with the key {");

            msg.append("version=" + version);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlManageWorkDocumentFlow[] findByversion_PrevAndNext(
        long manageDocumentWorkFlowId, int version, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow = findByPrimaryKey(manageDocumentWorkFlowId);

        int count = countByversion(version);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow WHERE ");

            query.append("version_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("managedocumentworkflowid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(version);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlManageWorkDocumentFlow);

            PmlManageWorkDocumentFlow[] array = new PmlManageWorkDocumentFlowImpl[3];

            array[0] = (PmlManageWorkDocumentFlow) objArray[0];
            array[1] = (PmlManageWorkDocumentFlow) objArray[1];
            array[2] = (PmlManageWorkDocumentFlow) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlManageWorkDocumentFlow> findBytype(int type)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlManageWorkDocumentFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlManageWorkDocumentFlow.class.getName();
        String finderMethodName = "findBytype";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(type) };

        Object result = null;

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
                    "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow WHERE ");

                query.append("type_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("managedocumentworkflowid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(type);

                List<PmlManageWorkDocumentFlow> list = q.list();

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
            return (List<PmlManageWorkDocumentFlow>) result;
        }
    }

    public List<PmlManageWorkDocumentFlow> findBytype(int type, int start,
        int end) throws SystemException {
        return findBytype(type, start, end, null);
    }

    public List<PmlManageWorkDocumentFlow> findBytype(int type, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlManageWorkDocumentFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlManageWorkDocumentFlow.class.getName();
        String finderMethodName = "findBytype";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(type),
                
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
                    "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow WHERE ");

                query.append("type_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("managedocumentworkflowid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(type);

                List<PmlManageWorkDocumentFlow> list = (List<PmlManageWorkDocumentFlow>) QueryUtil.list(q,
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
            return (List<PmlManageWorkDocumentFlow>) result;
        }
    }

    public PmlManageWorkDocumentFlow findBytype_First(int type,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlManageWorkDocumentFlow> list = findBytype(type, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlManageWorkDocumentFlow exists with the key {");

            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlManageWorkDocumentFlow findBytype_Last(int type,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countBytype(type);

        List<PmlManageWorkDocumentFlow> list = findBytype(type, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlManageWorkDocumentFlow exists with the key {");

            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlManageWorkDocumentFlow[] findBytype_PrevAndNext(
        long manageDocumentWorkFlowId, int type, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow = findByPrimaryKey(manageDocumentWorkFlowId);

        int count = countBytype(type);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow WHERE ");

            query.append("type_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("managedocumentworkflowid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(type);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlManageWorkDocumentFlow);

            PmlManageWorkDocumentFlow[] array = new PmlManageWorkDocumentFlowImpl[3];

            array[0] = (PmlManageWorkDocumentFlow) objArray[0];
            array[1] = (PmlManageWorkDocumentFlow) objArray[1];
            array[2] = (PmlManageWorkDocumentFlow) objArray[2];

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

    public List<PmlManageWorkDocumentFlow> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlManageWorkDocumentFlow> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlManageWorkDocumentFlow> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlManageWorkDocumentFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlManageWorkDocumentFlow.class.getName();
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
                    "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("managedocumentworkflowid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlManageWorkDocumentFlow> list = (List<PmlManageWorkDocumentFlow>) QueryUtil.list(q,
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
            return (List<PmlManageWorkDocumentFlow>) result;
        }
    }

    public void removeByWorkFlowName(String workFlowName)
        throws SystemException {
        for (PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow : findByWorkFlowName(
                workFlowName)) {
            remove(pmlManageWorkDocumentFlow);
        }
    }

    public void removeByversion(int version) throws SystemException {
        for (PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow : findByversion(
                version)) {
            remove(pmlManageWorkDocumentFlow);
        }
    }

    public void removeBytype(int type) throws SystemException {
        for (PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow : findBytype(
                type)) {
            remove(pmlManageWorkDocumentFlow);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow : findAll()) {
            remove(pmlManageWorkDocumentFlow);
        }
    }

    public int countByWorkFlowName(String workFlowName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlManageWorkDocumentFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlManageWorkDocumentFlow.class.getName();
        String finderMethodName = "countByWorkFlowName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { workFlowName };

        Object result = null;

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
                    "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow WHERE ");

                if (workFlowName == null) {
                    query.append("workflowname LIKE null");
                } else {
                    query.append("workflowname LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (workFlowName != null) {
                    qPos.add(workFlowName);
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

    public int countByversion(int version) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlManageWorkDocumentFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlManageWorkDocumentFlow.class.getName();
        String finderMethodName = "countByversion";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(version) };

        Object result = null;

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
                    "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow WHERE ");

                query.append("version_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(version);

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

    public int countBytype(int type) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlManageWorkDocumentFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlManageWorkDocumentFlow.class.getName();
        String finderMethodName = "countBytype";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(type) };

        Object result = null;

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
                    "FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow WHERE ");

                query.append("type_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(type);

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
        boolean finderClassNameCacheEnabled = PmlManageWorkDocumentFlowModelImpl.CACHE_ENABLED;
        String finderClassName = PmlManageWorkDocumentFlow.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow");

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
                        "value.object.listener.com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow")));

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
