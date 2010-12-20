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

import com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException;
import com.nss.portlet.onedoor.model.PmlFileStatusStateProcess;
import com.nss.portlet.onedoor.model.impl.PmlFileStatusStateProcessImpl;
import com.nss.portlet.onedoor.model.impl.PmlFileStatusStateProcessModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlFileStatusStateProcessPersistenceImpl
    extends BasePersistenceImpl implements PmlFileStatusStateProcessPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlFileStatusStateProcessImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FILESTATUSID = new FinderPath(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileStatusId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILESTATUSID = new FinderPath(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileStatusId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILESTATUSID = new FinderPath(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileStatusId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_STATEPROCESSID = new FinderPath(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATEPROCESSID = new FinderPath(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_STATEPROCESSID = new FinderPath(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByStateProcessId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILESTATUS_STATEPROCESS = new FinderPath(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileStatus_StateProcess",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILESTATUS_STATEPROCESS =
        new FinderPath(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileStatus_StateProcess",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILESTATUS_STATEPROCESS = new FinderPath(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileStatus_StateProcess",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlFileStatusStateProcessPersistenceImpl.class);
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

    public void cacheResult(PmlFileStatusStateProcess pmlFileStatusStateProcess) {
        EntityCacheUtil.putResult(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessImpl.class,
            pmlFileStatusStateProcess.getPrimaryKey(), pmlFileStatusStateProcess);
    }

    public void cacheResult(
        List<PmlFileStatusStateProcess> pmlFileStatusStateProcesses) {
        for (PmlFileStatusStateProcess pmlFileStatusStateProcess : pmlFileStatusStateProcesses) {
            if (EntityCacheUtil.getResult(
                        PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
                        PmlFileStatusStateProcessImpl.class,
                        pmlFileStatusStateProcess.getPrimaryKey(), this) == null) {
                cacheResult(pmlFileStatusStateProcess);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlFileStatusStateProcessImpl.class.getName());
        EntityCacheUtil.clearCache(PmlFileStatusStateProcessImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

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
        for (ModelListener<PmlFileStatusStateProcess> listener : listeners) {
            listener.onBeforeRemove(pmlFileStatusStateProcess);
        }

        pmlFileStatusStateProcess = removeImpl(pmlFileStatusStateProcess);

        for (ModelListener<PmlFileStatusStateProcess> listener : listeners) {
            listener.onAfterRemove(pmlFileStatusStateProcess);
        }

        return pmlFileStatusStateProcess;
    }

    protected PmlFileStatusStateProcess removeImpl(
        PmlFileStatusStateProcess pmlFileStatusStateProcess)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlFileStatusStateProcess.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlFileStatusStateProcessImpl.class,
                        pmlFileStatusStateProcess.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlFileStatusStateProcess);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessImpl.class,
            pmlFileStatusStateProcess.getPrimaryKey());

        return pmlFileStatusStateProcess;
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

        for (ModelListener<PmlFileStatusStateProcess> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlFileStatusStateProcess);
            } else {
                listener.onBeforeUpdate(pmlFileStatusStateProcess);
            }
        }

        pmlFileStatusStateProcess = updateImpl(pmlFileStatusStateProcess, merge);

        for (ModelListener<PmlFileStatusStateProcess> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlFileStatusStateProcess);
            } else {
                listener.onAfterUpdate(pmlFileStatusStateProcess);
            }
        }

        return pmlFileStatusStateProcess;
    }

    public PmlFileStatusStateProcess updateImpl(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlFileStatusStateProcess, merge);

            pmlFileStatusStateProcess.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusStateProcessImpl.class,
            pmlFileStatusStateProcess.getPrimaryKey(), pmlFileStatusStateProcess);

        return pmlFileStatusStateProcess;
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
        PmlFileStatusStateProcess pmlFileStatusStateProcess = (PmlFileStatusStateProcess) EntityCacheUtil.getResult(PmlFileStatusStateProcessModelImpl.ENTITY_CACHE_ENABLED,
                PmlFileStatusStateProcessImpl.class, id, this);

        if (pmlFileStatusStateProcess == null) {
            Session session = null;

            try {
                session = openSession();

                pmlFileStatusStateProcess = (PmlFileStatusStateProcess) session.get(PmlFileStatusStateProcessImpl.class,
                        new Long(id));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlFileStatusStateProcess != null) {
                    cacheResult(pmlFileStatusStateProcess);
                }

                closeSession(session);
            }
        }

        return pmlFileStatusStateProcess;
    }

    public List<PmlFileStatusStateProcess> findByFileStatusId(long fileStatusId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(fileStatusId) };

        List<PmlFileStatusStateProcess> list = (List<PmlFileStatusStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILESTATUSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatusStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILESTATUSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end) throws SystemException {
        return findByFileStatusId(fileStatusId, start, end, null);
    }

    public List<PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(fileStatusId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileStatusStateProcess> list = (List<PmlFileStatusStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILESTATUSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                list = (List<PmlFileStatusStateProcess>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatusStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILESTATUSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileStatusStateProcess findByFileStatusId_First(
        long fileStatusId, OrderByComparator obc)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        List<PmlFileStatusStateProcess> list = findByFileStatusId(fileStatusId,
                0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess WHERE ");

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
        Object[] finderArgs = new Object[] { new Long(stateProcessId) };

        List<PmlFileStatusStateProcess> list = (List<PmlFileStatusStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATEPROCESSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess WHERE ");

                query.append("stateprocessid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatusStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATEPROCESSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId, int start, int end) throws SystemException {
        return findByStateProcessId(stateProcessId, start, end, null);
    }

    public List<PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(stateProcessId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileStatusStateProcess> list = (List<PmlFileStatusStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess WHERE ");

                query.append("stateprocessid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessId);

                list = (List<PmlFileStatusStateProcess>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatusStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileStatusStateProcess findByStateProcessId_First(
        long stateProcessId, OrderByComparator obc)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        List<PmlFileStatusStateProcess> list = findByStateProcessId(stateProcessId,
                0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess WHERE ");

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
        Object[] finderArgs = new Object[] {
                new Long(fileStatusId), new Long(stateProcessId)
            };

        List<PmlFileStatusStateProcess> list = (List<PmlFileStatusStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILESTATUS_STATEPROCESS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" AND ");

                query.append("stateprocessid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                qPos.add(stateProcessId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatusStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILESTATUS_STATEPROCESS,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] {
                new Long(fileStatusId), new Long(stateProcessId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileStatusStateProcess> list = (List<PmlFileStatusStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILESTATUS_STATEPROCESS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess WHERE ");

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

                list = (List<PmlFileStatusStateProcess>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatusStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILESTATUS_STATEPROCESS,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileStatusStateProcess findByFileStatus_StateProcess_First(
        long fileStatusId, long stateProcessId, OrderByComparator obc)
        throws NoSuchPmlFileStatusStateProcessException, SystemException {
        List<PmlFileStatusStateProcess> list = findByFileStatus_StateProcess(fileStatusId,
                stateProcessId, 0, 1, obc);

        if (list.isEmpty()) {
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

        if (list.isEmpty()) {
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
                "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess WHERE ");

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
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileStatusStateProcess> list = (List<PmlFileStatusStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlFileStatusStateProcess>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlFileStatusStateProcess>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatusStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
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
        Object[] finderArgs = new Object[] { new Long(fileStatusId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILESTATUSID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILESTATUSID,
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
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess WHERE ");

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

    public int countByFileStatus_StateProcess(long fileStatusId,
        long stateProcessId) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(fileStatusId), new Long(stateProcessId)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILESTATUS_STATEPROCESS,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" AND ");

                query.append("stateprocessid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                qPos.add(stateProcessId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILESTATUS_STATEPROCESS,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlFileStatusStateProcess");

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
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlFileStatusStateProcess")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlFileStatusStateProcess>> listenersList = new ArrayList<ModelListener<PmlFileStatusStateProcess>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlFileStatusStateProcess>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
