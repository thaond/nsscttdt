package com.nss.portlet.onedoor.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistry;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;
import com.nss.portlet.onedoor.model.PmlStateWorkFlow;
import com.nss.portlet.onedoor.model.impl.PmlStateWorkFlowImpl;
import com.nss.portlet.onedoor.model.impl.PmlStateWorkFlowModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlStateWorkFlowPersistenceImpl extends BasePersistenceImpl
    implements PmlStateWorkFlowPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlStateWorkFlowImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_WORKFLOW_STATEPROCESSID_VERSION =
        new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByWorkFlow_StateProcessId_Version",
            new String[] {
                String.class.getName(), Long.class.getName(),
                Integer.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_WORKFLOW_STATEPROCESSID_VERSION =
        new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByWorkFlow_StateProcessId_Version",
            new String[] {
                String.class.getName(), Long.class.getName(),
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_WORKFLOW_STATEPROCESSID_VERSION =
        new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByWorkFlow_StateProcessId_Version",
            new String[] {
                String.class.getName(), Long.class.getName(),
                Integer.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_SOLVINGTIME = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findBySolvingTime",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_SOLVINGTIME = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findBySolvingTime",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_SOLVINGTIME = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countBySolvingTime",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_WORKFLOW = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByWorkflow",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_WORKFLOW = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByWorkflow",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_WORKFLOW = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByWorkflow",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_STATEPROCESSID = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATEPROCESSID = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_STATEPROCESSID = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByStateProcessId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_WORKFLOW_VERSION = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByWorkFlow_Version",
            new String[] { String.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_WORKFLOW_VERSION = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByWorkFlow_Version",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_WORKFLOW_VERSION = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByWorkFlow_Version",
            new String[] { String.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlStateWorkFlowPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlOneDoorReceiveFilePersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlOneDoorReceiveFilePersistence pmlOneDoorReceiveFilePersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlWfOnedoorProcessPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlWfOnedoorProcessPersistence pmlWfOnedoorProcessPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlWorkflowPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlWorkflowPersistence pmlWorkflowPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlStateProcessPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlStateProcessPersistence pmlStateProcessPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlProcessDisposePersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlProcessDisposePersistence pmlProcessDisposePersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlStateWorkFlowPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlStateWorkFlowPersistence pmlStateWorkFlowPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlTransitionPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlTransitionPersistence pmlTransitionPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFilePCCCPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlFilePCCCPersistence pmlFilePCCCPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFilePCCCAttachedFilePersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlFilePCCCAttachedFilePersistence pmlFilePCCCAttachedFilePersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFileReturningInfoPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlFileReturningInfoPersistence pmlFileReturningInfoPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFileStatusPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlFileStatusPersistence pmlFileStatusPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlFileStatusStateProcessPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlFileStatusStateProcessPersistence pmlFileStatusStateProcessPersistence;
    @BeanReference(name = "com.nss.portlet.onedoor.service.persistence.PmlPaintDocumentPersistence.impl")
    protected com.nss.portlet.onedoor.service.persistence.PmlPaintDocumentPersistence pmlPaintDocumentPersistence;

    public void cacheResult(PmlStateWorkFlow pmlStateWorkFlow) {
        EntityCacheUtil.putResult(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowImpl.class, pmlStateWorkFlow.getPrimaryKey(),
            pmlStateWorkFlow);
    }

    public void cacheResult(List<PmlStateWorkFlow> pmlStateWorkFlows) {
        for (PmlStateWorkFlow pmlStateWorkFlow : pmlStateWorkFlows) {
            if (EntityCacheUtil.getResult(
                        PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
                        PmlStateWorkFlowImpl.class,
                        pmlStateWorkFlow.getPrimaryKey(), this) == null) {
                cacheResult(pmlStateWorkFlow);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlStateWorkFlowImpl.class.getName());
        EntityCacheUtil.clearCache(PmlStateWorkFlowImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

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
        for (ModelListener<PmlStateWorkFlow> listener : listeners) {
            listener.onBeforeRemove(pmlStateWorkFlow);
        }

        pmlStateWorkFlow = removeImpl(pmlStateWorkFlow);

        for (ModelListener<PmlStateWorkFlow> listener : listeners) {
            listener.onAfterRemove(pmlStateWorkFlow);
        }

        return pmlStateWorkFlow;
    }

    protected PmlStateWorkFlow removeImpl(PmlStateWorkFlow pmlStateWorkFlow)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlStateWorkFlow.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlStateWorkFlowImpl.class,
                        pmlStateWorkFlow.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlStateWorkFlow);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowImpl.class, pmlStateWorkFlow.getPrimaryKey());

        return pmlStateWorkFlow;
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

        for (ModelListener<PmlStateWorkFlow> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlStateWorkFlow);
            } else {
                listener.onBeforeUpdate(pmlStateWorkFlow);
            }
        }

        pmlStateWorkFlow = updateImpl(pmlStateWorkFlow, merge);

        for (ModelListener<PmlStateWorkFlow> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlStateWorkFlow);
            } else {
                listener.onAfterUpdate(pmlStateWorkFlow);
            }
        }

        return pmlStateWorkFlow;
    }

    public PmlStateWorkFlow updateImpl(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlStateWorkFlow, merge);

            pmlStateWorkFlow.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateWorkFlowImpl.class, pmlStateWorkFlow.getPrimaryKey(),
            pmlStateWorkFlow);

        return pmlStateWorkFlow;
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
        PmlStateWorkFlow pmlStateWorkFlow = (PmlStateWorkFlow) EntityCacheUtil.getResult(PmlStateWorkFlowModelImpl.ENTITY_CACHE_ENABLED,
                PmlStateWorkFlowImpl.class, stateWfId, this);

        if (pmlStateWorkFlow == null) {
            Session session = null;

            try {
                session = openSession();

                pmlStateWorkFlow = (PmlStateWorkFlow) session.get(PmlStateWorkFlowImpl.class,
                        new Long(stateWfId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlStateWorkFlow != null) {
                    cacheResult(pmlStateWorkFlow);
                }

                closeSession(session);
            }
        }

        return pmlStateWorkFlow;
    }

    public List<PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(
        String workflow, long stateProcessId, int version_)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                workflow, new Long(stateProcessId), new Integer(version_)
            };

        List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_WORKFLOW_STATEPROCESSID_VERSION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateWorkFlow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_WORKFLOW_STATEPROCESSID_VERSION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] {
                workflow, new Long(stateProcessId), new Integer(version_),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_WORKFLOW_STATEPROCESSID_VERSION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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

                list = (List<PmlStateWorkFlow>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateWorkFlow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_WORKFLOW_STATEPROCESSID_VERSION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlStateWorkFlow findByWorkFlow_StateProcessId_Version_First(
        String workflow, long stateProcessId, int version_,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        List<PmlStateWorkFlow> list = findByWorkFlow_StateProcessId_Version(workflow,
                stateProcessId, version_, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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
        Object[] finderArgs = new Object[] { new Integer(solvingTime) };

        List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SOLVINGTIME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

                query.append("solvingtime = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("statewfid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(solvingTime);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateWorkFlow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SOLVINGTIME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlStateWorkFlow> findBySolvingTime(int solvingTime, int start,
        int end) throws SystemException {
        return findBySolvingTime(solvingTime, start, end, null);
    }

    public List<PmlStateWorkFlow> findBySolvingTime(int solvingTime, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(solvingTime),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_SOLVINGTIME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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

                list = (List<PmlStateWorkFlow>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateWorkFlow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_SOLVINGTIME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlStateWorkFlow findBySolvingTime_First(int solvingTime,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        List<PmlStateWorkFlow> list = findBySolvingTime(solvingTime, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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
        Object[] finderArgs = new Object[] { workflow };

        List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_WORKFLOW,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateWorkFlow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_WORKFLOW,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlStateWorkFlow> findByWorkflow(String workflow, int start,
        int end) throws SystemException {
        return findByWorkflow(workflow, start, end, null);
    }

    public List<PmlStateWorkFlow> findByWorkflow(String workflow, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                workflow,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_WORKFLOW,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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

                list = (List<PmlStateWorkFlow>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateWorkFlow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_WORKFLOW,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlStateWorkFlow findByWorkflow_First(String workflow,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        List<PmlStateWorkFlow> list = findByWorkflow(workflow, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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
        Object[] finderArgs = new Object[] { new Long(stateProcessId) };

        List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATEPROCESSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

                query.append("stateprocessid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("statewfid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateWorkFlow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATEPROCESSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlStateWorkFlow> findByStateProcessId(long stateProcessId,
        int start, int end) throws SystemException {
        return findByStateProcessId(stateProcessId, start, end, null);
    }

    public List<PmlStateWorkFlow> findByStateProcessId(long stateProcessId,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(stateProcessId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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

                list = (List<PmlStateWorkFlow>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateWorkFlow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlStateWorkFlow findByStateProcessId_First(long stateProcessId,
        OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        List<PmlStateWorkFlow> list = findByStateProcessId(stateProcessId, 0,
                1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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
        Object[] finderArgs = new Object[] { workflow, new Integer(version_) };

        List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_WORKFLOW_VERSION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateWorkFlow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_WORKFLOW_VERSION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlStateWorkFlow> findByWorkFlow_Version(String workflow,
        int version_, int start, int end) throws SystemException {
        return findByWorkFlow_Version(workflow, version_, start, end, null);
    }

    public List<PmlStateWorkFlow> findByWorkFlow_Version(String workflow,
        int version_, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                workflow, new Integer(version_),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_WORKFLOW_VERSION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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

                list = (List<PmlStateWorkFlow>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateWorkFlow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_WORKFLOW_VERSION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlStateWorkFlow findByWorkFlow_Version_First(String workflow,
        int version_, OrderByComparator obc)
        throws NoSuchPmlStateWorkFlowException, SystemException {
        List<PmlStateWorkFlow> list = findByWorkFlow_Version(workflow,
                version_, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlStateWorkFlow> list = (List<PmlStateWorkFlow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("statewfid DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlStateWorkFlow>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlStateWorkFlow>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateWorkFlow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] {
                workflow, new Long(stateProcessId), new Integer(version_)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WORKFLOW_STATEPROCESSID_VERSION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WORKFLOW_STATEPROCESSID_VERSION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countBySolvingTime(int solvingTime) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(solvingTime) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SOLVINGTIME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

                query.append("solvingtime = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(solvingTime);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SOLVINGTIME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByWorkflow(String workflow) throws SystemException {
        Object[] finderArgs = new Object[] { workflow };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WORKFLOW,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WORKFLOW,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByStateProcessId(long stateProcessId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(stateProcessId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATEPROCESSID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

                query.append("stateprocessid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATEPROCESSID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByWorkFlow_Version(String workflow, int version_)
        throws SystemException {
        Object[] finderArgs = new Object[] { workflow, new Integer(version_) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_WORKFLOW_VERSION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_WORKFLOW_VERSION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlStateWorkFlow");

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
                    count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.portal.util.PropsUtil.get(
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlStateWorkFlow")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlStateWorkFlow>> listenersList = new ArrayList<ModelListener<PmlStateWorkFlow>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlStateWorkFlow>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
