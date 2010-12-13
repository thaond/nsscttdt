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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.onedoor.NoSuchPmlWorkflowException;
import com.nss.portlet.onedoor.model.PmlWorkflow;
import com.nss.portlet.onedoor.model.impl.PmlWorkflowImpl;
import com.nss.portlet.onedoor.model.impl.PmlWorkflowModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class PmlWorkflowPersistenceImpl extends BasePersistenceImpl
    implements PmlWorkflowPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlWorkflowImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPEID = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileTypeId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPEID = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileTypeId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPEID = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFileTypeId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPEID_STARTDATE = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileTypeId_StartDate",
            new String[] { String.class.getName(), Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPEID_STARTDATE = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileTypeId_StartDate",
            new String[] {
                String.class.getName(), Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPEID_STARTDATE = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFileTypeId_StartDate",
            new String[] { String.class.getName(), Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_WORKFLOW_VERSION = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByWorkFlow_Version",
            new String[] { String.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_WORKFLOW_VERSION = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByWorkFlow_Version",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_WORKFLOW_VERSION = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByWorkFlow_Version",
            new String[] { String.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPEID_VERSION = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileTypeId_Version",
            new String[] { String.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPEID_VERSION = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileTypeId_Version",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPEID_VERSION = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFileTypeId_Version",
            new String[] { String.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlWorkflowPersistenceImpl.class);
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

    public void cacheResult(PmlWorkflow pmlWorkflow) {
        EntityCacheUtil.putResult(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowImpl.class, pmlWorkflow.getPrimaryKey(), pmlWorkflow);
    }

    public void cacheResult(List<PmlWorkflow> pmlWorkflows) {
        for (PmlWorkflow pmlWorkflow : pmlWorkflows) {
            if (EntityCacheUtil.getResult(
                        PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
                        PmlWorkflowImpl.class, pmlWorkflow.getPrimaryKey(), this) == null) {
                cacheResult(pmlWorkflow);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlWorkflowImpl.class.getName());
        EntityCacheUtil.clearCache(PmlWorkflowImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

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
        for (ModelListener<PmlWorkflow> listener : listeners) {
            listener.onBeforeRemove(pmlWorkflow);
        }

        pmlWorkflow = removeImpl(pmlWorkflow);

        for (ModelListener<PmlWorkflow> listener : listeners) {
            listener.onAfterRemove(pmlWorkflow);
        }

        return pmlWorkflow;
    }

    protected PmlWorkflow removeImpl(PmlWorkflow pmlWorkflow)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlWorkflow.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlWorkflowImpl.class,
                        pmlWorkflow.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlWorkflow);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowImpl.class, pmlWorkflow.getPrimaryKey());

        return pmlWorkflow;
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

        for (ModelListener<PmlWorkflow> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlWorkflow);
            } else {
                listener.onBeforeUpdate(pmlWorkflow);
            }
        }

        pmlWorkflow = updateImpl(pmlWorkflow, merge);

        for (ModelListener<PmlWorkflow> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlWorkflow);
            } else {
                listener.onAfterUpdate(pmlWorkflow);
            }
        }

        return pmlWorkflow;
    }

    public PmlWorkflow updateImpl(
        com.nss.portlet.onedoor.model.PmlWorkflow pmlWorkflow, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlWorkflow, merge);

            pmlWorkflow.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
            PmlWorkflowImpl.class, pmlWorkflow.getPrimaryKey(), pmlWorkflow);

        return pmlWorkflow;
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
        PmlWorkflow pmlWorkflow = (PmlWorkflow) EntityCacheUtil.getResult(PmlWorkflowModelImpl.ENTITY_CACHE_ENABLED,
                PmlWorkflowImpl.class, workflowId, this);

        if (pmlWorkflow == null) {
            Session session = null;

            try {
                session = openSession();

                pmlWorkflow = (PmlWorkflow) session.get(PmlWorkflowImpl.class,
                        new Long(workflowId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlWorkflow != null) {
                    cacheResult(pmlWorkflow);
                }

                closeSession(session);
            }
        }

        return pmlWorkflow;
    }

    public List<PmlWorkflow> findByFileTypeId(String fileTypeId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId };

        List<PmlWorkflow> list = (List<PmlWorkflow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlWorkflow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlWorkflow> findByFileTypeId(String fileTypeId, int start,
        int end) throws SystemException {
        return findByFileTypeId(fileTypeId, start, end, null);
    }

    public List<PmlWorkflow> findByFileTypeId(String fileTypeId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlWorkflow> list = (List<PmlWorkflow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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

                list = (List<PmlWorkflow>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlWorkflow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlWorkflow findByFileTypeId_First(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        List<PmlWorkflow> list = findByFileTypeId(fileTypeId, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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
        Object[] finderArgs = new Object[] { fileTypeId, startDate };

        List<PmlWorkflow> list = (List<PmlWorkflow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPEID_STARTDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlWorkflow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPEID_STARTDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlWorkflow> findByFileTypeId_StartDate(String fileTypeId,
        Date startDate, int start, int end) throws SystemException {
        return findByFileTypeId_StartDate(fileTypeId, startDate, start, end,
            null);
    }

    public List<PmlWorkflow> findByFileTypeId_StartDate(String fileTypeId,
        Date startDate, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                startDate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlWorkflow> list = (List<PmlWorkflow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID_STARTDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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

                list = (List<PmlWorkflow>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlWorkflow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID_STARTDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlWorkflow findByFileTypeId_StartDate_First(String fileTypeId,
        Date startDate, OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        List<PmlWorkflow> list = findByFileTypeId_StartDate(fileTypeId,
                startDate, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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
        Object[] finderArgs = new Object[] { workflow, new Integer(version_) };

        List<PmlWorkflow> list = (List<PmlWorkflow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_WORKFLOW_VERSION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlWorkflow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_WORKFLOW_VERSION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlWorkflow> findByWorkFlow_Version(String workflow,
        int version_, int start, int end) throws SystemException {
        return findByWorkFlow_Version(workflow, version_, start, end, null);
    }

    public List<PmlWorkflow> findByWorkFlow_Version(String workflow,
        int version_, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                workflow, new Integer(version_),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlWorkflow> list = (List<PmlWorkflow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_WORKFLOW_VERSION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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

                list = (List<PmlWorkflow>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlWorkflow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_WORKFLOW_VERSION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlWorkflow findByWorkFlow_Version_First(String workflow,
        int version_, OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        List<PmlWorkflow> list = findByWorkFlow_Version(workflow, version_, 0,
                1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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
        Object[] finderArgs = new Object[] { fileTypeId, new Integer(version_) };

        List<PmlWorkflow> list = (List<PmlWorkflow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPEID_VERSION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlWorkflow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPEID_VERSION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlWorkflow> findByFileTypeId_Version(String fileTypeId,
        int version_, int start, int end) throws SystemException {
        return findByFileTypeId_Version(fileTypeId, version_, start, end, null);
    }

    public List<PmlWorkflow> findByFileTypeId_Version(String fileTypeId,
        int version_, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId, new Integer(version_),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlWorkflow> list = (List<PmlWorkflow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID_VERSION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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

                list = (List<PmlWorkflow>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlWorkflow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID_VERSION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlWorkflow findByFileTypeId_Version_First(String fileTypeId,
        int version_, OrderByComparator obc)
        throws NoSuchPmlWorkflowException, SystemException {
        List<PmlWorkflow> list = findByFileTypeId_Version(fileTypeId, version_,
                0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlWorkflow> list = (List<PmlWorkflow>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.onedoor.model.PmlWorkflow ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("workflowId DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlWorkflow>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlWorkflow>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlWorkflow>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] { fileTypeId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILETYPEID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILETYPEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileTypeId_StartDate(String fileTypeId, Date startDate)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId, startDate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILETYPEID_STARTDATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILETYPEID_STARTDATE,
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
                    "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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

    public int countByFileTypeId_Version(String fileTypeId, int version_)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId, new Integer(version_) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILETYPEID_VERSION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWorkflow WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILETYPEID_VERSION,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlWorkflow");

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
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlWorkflow")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlWorkflow>> listenersList = new ArrayList<ModelListener<PmlWorkflow>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlWorkflow>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
