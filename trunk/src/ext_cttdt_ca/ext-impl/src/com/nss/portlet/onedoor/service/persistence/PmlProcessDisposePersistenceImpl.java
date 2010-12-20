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

import com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException;
import com.nss.portlet.onedoor.model.PmlProcessDispose;
import com.nss.portlet.onedoor.model.impl.PmlProcessDisposeImpl;
import com.nss.portlet.onedoor.model.impl.PmlProcessDisposeModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class PmlProcessDisposePersistenceImpl extends BasePersistenceImpl
    implements PmlProcessDisposePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlProcessDisposeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_SENDDATE = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findBySendDate",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_SENDDATE = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findBySendDate",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_SENDDATE = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countBySendDate",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_TRANSITION = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByTransition",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_TRANSITION = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByTransition",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_TRANSITION = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByTransition",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DELEGATEUSER = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDelegateUser",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DELEGATEUSER = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDelegateUser",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DELEGATEUSER = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByDelegateUser",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_EXPIREDDATE = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByExpiredDate",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_EXPIREDDATE = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByExpiredDate",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_EXPIREDDATE = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByExpiredDate",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILEID_TRANSITION = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId_Transition",
            new String[] { String.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILEID_TRANSITION = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId_Transition",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILEID_TRANSITION = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileId_Transition",
            new String[] { String.class.getName(), Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILEID_STATEPROCESSIDBEFORE =
        new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId_StateProcessIdBefore",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILEID_STATEPROCESSIDBEFORE =
        new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId_StateProcessIdBefore",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILEID_STATEPROCESSIDBEFORE =
        new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileId_StateProcessIdBefore",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILEID_STATEPROCESSIDAFTER =
        new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId_StateProcessIdAfter",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILEID_STATEPROCESSIDAFTER =
        new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId_StateProcessIdAfter",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILEID_STATEPROCESSIDAFTER =
        new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileId_StateProcessIdAfter",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_PROCESSER = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByProcesser",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_PROCESSER = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByProcesser",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSER = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByProcesser",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DATEPROCESS = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDateProcess",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DATEPROCESS = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDateProcess",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DATEPROCESS = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByDateProcess",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_RECEIVER = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByReceiver",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_RECEIVER = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByReceiver",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_RECEIVER = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByReceiver",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_RECEIVEDATE = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByReceiveDate",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_RECEIVEDATE = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByReceiveDate",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_RECEIVEDATE = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByReceiveDate",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_STATEPROCESSIDBEFORE = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessIdBefore",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATEPROCESSIDBEFORE = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessIdBefore",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_STATEPROCESSIDBEFORE = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByStateProcessIdBefore",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_STATEPROCESSIDAFTER = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessIdAfter",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATEPROCESSIDAFTER = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessIdAfter",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_STATEPROCESSIDAFTER = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByStateProcessIdAfter",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILEID = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILEID = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILEID = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlProcessDisposePersistenceImpl.class);
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

    public void cacheResult(PmlProcessDispose pmlProcessDispose) {
        EntityCacheUtil.putResult(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeImpl.class, pmlProcessDispose.getPrimaryKey(),
            pmlProcessDispose);
    }

    public void cacheResult(List<PmlProcessDispose> pmlProcessDisposes) {
        for (PmlProcessDispose pmlProcessDispose : pmlProcessDisposes) {
            if (EntityCacheUtil.getResult(
                        PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
                        PmlProcessDisposeImpl.class,
                        pmlProcessDispose.getPrimaryKey(), this) == null) {
                cacheResult(pmlProcessDispose);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlProcessDisposeImpl.class.getName());
        EntityCacheUtil.clearCache(PmlProcessDisposeImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlProcessDispose create(long processDisposeId) {
        PmlProcessDispose pmlProcessDispose = new PmlProcessDisposeImpl();

        pmlProcessDispose.setNew(true);
        pmlProcessDispose.setPrimaryKey(processDisposeId);

        return pmlProcessDispose;
    }

    public PmlProcessDispose remove(long processDisposeId)
        throws NoSuchPmlProcessDisposeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlProcessDispose pmlProcessDispose = (PmlProcessDispose) session.get(PmlProcessDisposeImpl.class,
                    new Long(processDisposeId));

            if (pmlProcessDispose == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlProcessDispose exists with the primary key " +
                        processDisposeId);
                }

                throw new NoSuchPmlProcessDisposeException(
                    "No PmlProcessDispose exists with the primary key " +
                    processDisposeId);
            }

            return remove(pmlProcessDispose);
        } catch (NoSuchPmlProcessDisposeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlProcessDispose remove(PmlProcessDispose pmlProcessDispose)
        throws SystemException {
        for (ModelListener<PmlProcessDispose> listener : listeners) {
            listener.onBeforeRemove(pmlProcessDispose);
        }

        pmlProcessDispose = removeImpl(pmlProcessDispose);

        for (ModelListener<PmlProcessDispose> listener : listeners) {
            listener.onAfterRemove(pmlProcessDispose);
        }

        return pmlProcessDispose;
    }

    protected PmlProcessDispose removeImpl(PmlProcessDispose pmlProcessDispose)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlProcessDispose.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlProcessDisposeImpl.class,
                        pmlProcessDispose.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlProcessDispose);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeImpl.class, pmlProcessDispose.getPrimaryKey());

        return pmlProcessDispose;
    }

    /**
     * @deprecated Use <code>update(PmlProcessDispose pmlProcessDispose, boolean merge)</code>.
     */
    public PmlProcessDispose update(PmlProcessDispose pmlProcessDispose)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlProcessDispose pmlProcessDispose) method. Use update(PmlProcessDispose pmlProcessDispose, boolean merge) instead.");
        }

        return update(pmlProcessDispose, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlProcessDispose the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlProcessDispose is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlProcessDispose update(PmlProcessDispose pmlProcessDispose,
        boolean merge) throws SystemException {
        boolean isNew = pmlProcessDispose.isNew();

        for (ModelListener<PmlProcessDispose> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlProcessDispose);
            } else {
                listener.onBeforeUpdate(pmlProcessDispose);
            }
        }

        pmlProcessDispose = updateImpl(pmlProcessDispose, merge);

        for (ModelListener<PmlProcessDispose> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlProcessDispose);
            } else {
                listener.onAfterUpdate(pmlProcessDispose);
            }
        }

        return pmlProcessDispose;
    }

    public PmlProcessDispose updateImpl(
        com.nss.portlet.onedoor.model.PmlProcessDispose pmlProcessDispose,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlProcessDispose, merge);

            pmlProcessDispose.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
            PmlProcessDisposeImpl.class, pmlProcessDispose.getPrimaryKey(),
            pmlProcessDispose);

        return pmlProcessDispose;
    }

    public PmlProcessDispose findByPrimaryKey(long processDisposeId)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = fetchByPrimaryKey(processDisposeId);

        if (pmlProcessDispose == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlProcessDispose exists with the primary key " +
                    processDisposeId);
            }

            throw new NoSuchPmlProcessDisposeException(
                "No PmlProcessDispose exists with the primary key " +
                processDisposeId);
        }

        return pmlProcessDispose;
    }

    public PmlProcessDispose fetchByPrimaryKey(long processDisposeId)
        throws SystemException {
        PmlProcessDispose pmlProcessDispose = (PmlProcessDispose) EntityCacheUtil.getResult(PmlProcessDisposeModelImpl.ENTITY_CACHE_ENABLED,
                PmlProcessDisposeImpl.class, processDisposeId, this);

        if (pmlProcessDispose == null) {
            Session session = null;

            try {
                session = openSession();

                pmlProcessDispose = (PmlProcessDispose) session.get(PmlProcessDisposeImpl.class,
                        new Long(processDisposeId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlProcessDispose != null) {
                    cacheResult(pmlProcessDispose);
                }

                closeSession(session);
            }
        }

        return pmlProcessDispose;
    }

    public List<PmlProcessDispose> findBySendDate(Date sendDate)
        throws SystemException {
        Object[] finderArgs = new Object[] { sendDate };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_SENDDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (sendDate == null) {
                    query.append("senddate IS NULL");
                } else {
                    query.append("senddate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_SENDDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findBySendDate(Date sendDate, int start,
        int end) throws SystemException {
        return findBySendDate(sendDate, start, end, null);
    }

    public List<PmlProcessDispose> findBySendDate(Date sendDate, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                sendDate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_SENDDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (sendDate == null) {
                    query.append("senddate IS NULL");
                } else {
                    query.append("senddate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
                }

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_SENDDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findBySendDate_First(Date sendDate,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findBySendDate(sendDate, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("sendDate=" + sendDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findBySendDate_Last(Date sendDate,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countBySendDate(sendDate);

        List<PmlProcessDispose> list = findBySendDate(sendDate, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("sendDate=" + sendDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findBySendDate_PrevAndNext(
        long processDisposeId, Date sendDate, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countBySendDate(sendDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

            if (sendDate == null) {
                query.append("senddate IS NULL");
            } else {
                query.append("senddate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (sendDate != null) {
                qPos.add(CalendarUtil.getTimestamp(sendDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByTransition(int transition_)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(transition_) };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TRANSITION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("transition_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(transition_);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TRANSITION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByTransition(int transition_, int start,
        int end) throws SystemException {
        return findByTransition(transition_, start, end, null);
    }

    public List<PmlProcessDispose> findByTransition(int transition_, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(transition_),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_TRANSITION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("transition_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(transition_);

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_TRANSITION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByTransition_First(int transition_,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByTransition(transition_, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByTransition_Last(int transition_,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByTransition(transition_);

        List<PmlProcessDispose> list = findByTransition(transition_, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByTransition_PrevAndNext(
        long processDisposeId, int transition_, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByTransition(transition_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

            query.append("transition_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(transition_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByDelegateUser(long delegateUser)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(delegateUser) };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DELEGATEUSER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("delegateuser = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(delegateUser);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DELEGATEUSER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByDelegateUser(long delegateUser,
        int start, int end) throws SystemException {
        return findByDelegateUser(delegateUser, start, end, null);
    }

    public List<PmlProcessDispose> findByDelegateUser(long delegateUser,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(delegateUser),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DELEGATEUSER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("delegateuser = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(delegateUser);

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DELEGATEUSER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByDelegateUser_First(long delegateUser,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByDelegateUser(delegateUser, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("delegateUser=" + delegateUser);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByDelegateUser_Last(long delegateUser,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByDelegateUser(delegateUser);

        List<PmlProcessDispose> list = findByDelegateUser(delegateUser,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("delegateUser=" + delegateUser);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByDelegateUser_PrevAndNext(
        long processDisposeId, long delegateUser, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByDelegateUser(delegateUser);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

            query.append("delegateuser = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(delegateUser);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByExpiredDate(Date expiredDate)
        throws SystemException {
        Object[] finderArgs = new Object[] { expiredDate };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_EXPIREDDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (expiredDate == null) {
                    query.append("expireddate IS NULL");
                } else {
                    query.append("expireddate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (expiredDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(expiredDate));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_EXPIREDDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByExpiredDate(Date expiredDate,
        int start, int end) throws SystemException {
        return findByExpiredDate(expiredDate, start, end, null);
    }

    public List<PmlProcessDispose> findByExpiredDate(Date expiredDate,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                expiredDate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_EXPIREDDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

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

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (expiredDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(expiredDate));
                }

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_EXPIREDDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByExpiredDate_First(Date expiredDate,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByExpiredDate(expiredDate, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("expiredDate=" + expiredDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByExpiredDate_Last(Date expiredDate,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByExpiredDate(expiredDate);

        List<PmlProcessDispose> list = findByExpiredDate(expiredDate,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("expiredDate=" + expiredDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByExpiredDate_PrevAndNext(
        long processDisposeId, Date expiredDate, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByExpiredDate(expiredDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

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

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (expiredDate != null) {
                qPos.add(CalendarUtil.getTimestamp(expiredDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByFileId_Transition(String fileId,
        int transition_) throws SystemException {
        Object[] finderArgs = new Object[] { fileId, new Integer(transition_) };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILEID_TRANSITION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("transition_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(transition_);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILEID_TRANSITION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByFileId_Transition(String fileId,
        int transition_, int start, int end) throws SystemException {
        return findByFileId_Transition(fileId, transition_, start, end, null);
    }

    public List<PmlProcessDispose> findByFileId_Transition(String fileId,
        int transition_, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                fileId, new Integer(transition_),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILEID_TRANSITION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("transition_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(transition_);

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILEID_TRANSITION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByFileId_Transition_First(String fileId,
        int transition_, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByFileId_Transition(fileId,
                transition_, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByFileId_Transition_Last(String fileId,
        int transition_, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByFileId_Transition(fileId, transition_);

        List<PmlProcessDispose> list = findByFileId_Transition(fileId,
                transition_, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByFileId_Transition_PrevAndNext(
        long processDisposeId, String fileId, int transition_,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByFileId_Transition(fileId, transition_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

            if (fileId == null) {
                query.append("fileid IS NULL");
            } else {
                query.append("fileid = ?");
            }

            query.append(" AND ");

            query.append("transition_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            qPos.add(transition_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByFileId_StateProcessIdBefore(
        String fileId, long stateProcessIdBefore) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileId, new Long(stateProcessIdBefore)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILEID_STATEPROCESSIDBEFORE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(stateProcessIdBefore);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILEID_STATEPROCESSIDBEFORE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByFileId_StateProcessIdBefore(
        String fileId, long stateProcessIdBefore, int start, int end)
        throws SystemException {
        return findByFileId_StateProcessIdBefore(fileId, stateProcessIdBefore,
            start, end, null);
    }

    public List<PmlProcessDispose> findByFileId_StateProcessIdBefore(
        String fileId, long stateProcessIdBefore, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileId, new Long(stateProcessIdBefore),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILEID_STATEPROCESSIDBEFORE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(stateProcessIdBefore);

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILEID_STATEPROCESSIDBEFORE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByFileId_StateProcessIdBefore_First(
        String fileId, long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByFileId_StateProcessIdBefore(fileId,
                stateProcessIdBefore, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByFileId_StateProcessIdBefore_Last(
        String fileId, long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByFileId_StateProcessIdBefore(fileId,
                stateProcessIdBefore);

        List<PmlProcessDispose> list = findByFileId_StateProcessIdBefore(fileId,
                stateProcessIdBefore, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByFileId_StateProcessIdBefore_PrevAndNext(
        long processDisposeId, String fileId, long stateProcessIdBefore,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByFileId_StateProcessIdBefore(fileId,
                stateProcessIdBefore);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

            if (fileId == null) {
                query.append("fileid IS NULL");
            } else {
                query.append("fileid = ?");
            }

            query.append(" AND ");

            query.append("stateprocessidbefore = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            qPos.add(stateProcessIdBefore);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByFileId_StateProcessIdAfter(
        String fileId, long stateProcessIdAfter) throws SystemException {
        Object[] finderArgs = new Object[] { fileId, new Long(stateProcessIdAfter) };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILEID_STATEPROCESSIDAFTER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(stateProcessIdAfter);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILEID_STATEPROCESSIDAFTER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByFileId_StateProcessIdAfter(
        String fileId, long stateProcessIdAfter, int start, int end)
        throws SystemException {
        return findByFileId_StateProcessIdAfter(fileId, stateProcessIdAfter,
            start, end, null);
    }

    public List<PmlProcessDispose> findByFileId_StateProcessIdAfter(
        String fileId, long stateProcessIdAfter, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileId, new Long(stateProcessIdAfter),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILEID_STATEPROCESSIDAFTER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
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

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(stateProcessIdAfter);

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILEID_STATEPROCESSIDAFTER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByFileId_StateProcessIdAfter_First(
        String fileId, long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByFileId_StateProcessIdAfter(fileId,
                stateProcessIdAfter, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByFileId_StateProcessIdAfter_Last(
        String fileId, long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByFileId_StateProcessIdAfter(fileId,
                stateProcessIdAfter);

        List<PmlProcessDispose> list = findByFileId_StateProcessIdAfter(fileId,
                stateProcessIdAfter, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByFileId_StateProcessIdAfter_PrevAndNext(
        long processDisposeId, String fileId, long stateProcessIdAfter,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByFileId_StateProcessIdAfter(fileId,
                stateProcessIdAfter);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

            if (fileId == null) {
                query.append("fileid IS NULL");
            } else {
                query.append("fileid = ?");
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

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            qPos.add(stateProcessIdAfter);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByProcesser(long processer)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(processer) };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PROCESSER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("processer = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processer);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PROCESSER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByProcesser(long processer, int start,
        int end) throws SystemException {
        return findByProcesser(processer, start, end, null);
    }

    public List<PmlProcessDispose> findByProcesser(long processer, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(processer),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PROCESSER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("processer = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processer);

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PROCESSER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByProcesser_First(long processer,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByProcesser(processer, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByProcesser_Last(long processer,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByProcesser(processer);

        List<PmlProcessDispose> list = findByProcesser(processer, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByProcesser_PrevAndNext(
        long processDisposeId, long processer, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByProcesser(processer);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

            query.append("processer = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processer);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByDateProcess(Date dateProcess)
        throws SystemException {
        Object[] finderArgs = new Object[] { dateProcess };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DATEPROCESS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DATEPROCESS,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByDateProcess(Date dateProcess,
        int start, int end) throws SystemException {
        return findByDateProcess(dateProcess, start, end, null);
    }

    public List<PmlProcessDispose> findByDateProcess(Date dateProcess,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                dateProcess,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DATEPROCESS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

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

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DATEPROCESS,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByDateProcess_First(Date dateProcess,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByDateProcess(dateProcess, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByDateProcess_Last(Date dateProcess,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByDateProcess(dateProcess);

        List<PmlProcessDispose> list = findByDateProcess(dateProcess,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByDateProcess_PrevAndNext(
        long processDisposeId, Date dateProcess, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByDateProcess(dateProcess);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

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

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateProcess != null) {
                qPos.add(CalendarUtil.getTimestamp(dateProcess));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByReceiver(long receiver)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(receiver) };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_RECEIVER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_RECEIVER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByReceiver(long receiver, int start,
        int end) throws SystemException {
        return findByReceiver(receiver, start, end, null);
    }

    public List<PmlProcessDispose> findByReceiver(long receiver, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_RECEIVER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_RECEIVER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByReceiver_First(long receiver,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByReceiver(receiver, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByReceiver_Last(long receiver,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByReceiver(receiver);

        List<PmlProcessDispose> list = findByReceiver(receiver, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByReceiver_PrevAndNext(
        long processDisposeId, long receiver, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByReceiver(receiver);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

            query.append("receiver = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(receiver);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByReceiveDate(Date receiveDate)
        throws SystemException {
        Object[] finderArgs = new Object[] { receiveDate };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_RECEIVEDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (receiveDate == null) {
                    query.append("receivedate IS NULL");
                } else {
                    query.append("receivedate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_RECEIVEDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByReceiveDate(Date receiveDate,
        int start, int end) throws SystemException {
        return findByReceiveDate(receiveDate, start, end, null);
    }

    public List<PmlProcessDispose> findByReceiveDate(Date receiveDate,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                receiveDate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_RECEIVEDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

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

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_RECEIVEDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByReceiveDate_First(Date receiveDate,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByReceiveDate(receiveDate, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("receiveDate=" + receiveDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByReceiveDate_Last(Date receiveDate,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByReceiveDate(receiveDate);

        List<PmlProcessDispose> list = findByReceiveDate(receiveDate,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("receiveDate=" + receiveDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByReceiveDate_PrevAndNext(
        long processDisposeId, Date receiveDate, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByReceiveDate(receiveDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

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

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (receiveDate != null) {
                qPos.add(CalendarUtil.getTimestamp(receiveDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByStateProcessIdBefore(
        long stateProcessIdBefore) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(stateProcessIdBefore) };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATEPROCESSIDBEFORE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdBefore);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATEPROCESSIDBEFORE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end)
        throws SystemException {
        return findByStateProcessIdBefore(stateProcessIdBefore, start, end, null);
    }

    public List<PmlProcessDispose> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(stateProcessIdBefore),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSIDBEFORE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdBefore);

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSIDBEFORE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByStateProcessIdBefore_First(
        long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByStateProcessIdBefore(stateProcessIdBefore,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByStateProcessIdBefore_Last(
        long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByStateProcessIdBefore(stateProcessIdBefore);

        List<PmlProcessDispose> list = findByStateProcessIdBefore(stateProcessIdBefore,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByStateProcessIdBefore_PrevAndNext(
        long processDisposeId, long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByStateProcessIdBefore(stateProcessIdBefore);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

            query.append("stateprocessidbefore = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessIdBefore);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByStateProcessIdAfter(
        long stateProcessIdAfter) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(stateProcessIdAfter) };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATEPROCESSIDAFTER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdAfter);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATEPROCESSIDAFTER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end) throws SystemException {
        return findByStateProcessIdAfter(stateProcessIdAfter, start, end, null);
    }

    public List<PmlProcessDispose> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(stateProcessIdAfter),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSIDAFTER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdAfter);

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSIDAFTER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByStateProcessIdAfter_First(
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByStateProcessIdAfter(stateProcessIdAfter,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByStateProcessIdAfter_Last(
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByStateProcessIdAfter(stateProcessIdAfter);

        List<PmlProcessDispose> list = findByStateProcessIdAfter(stateProcessIdAfter,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByStateProcessIdAfter_PrevAndNext(
        long processDisposeId, long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByStateProcessIdAfter(stateProcessIdAfter);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

            query.append("stateprocessidafter = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessIdAfter);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByFileId(String fileId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileId };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlProcessDispose> findByFileId(String fileId, int start,
        int end) throws SystemException {
        return findByFileId(fileId, start, end, null);
    }

    public List<PmlProcessDispose> findByFileId(String fileId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                list = (List<PmlProcessDispose>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlProcessDispose findByFileId_First(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByFileId(fileId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByFileId_Last(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByFileId(fileId);

        List<PmlProcessDispose> list = findByFileId(fileId, count - 1, count,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByFileId_PrevAndNext(long processDisposeId,
        String fileId, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByFileId(fileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

            if (fileId == null) {
                query.append("fileid LIKE null");
            } else {
                query.append("fileid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

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

    public List<PmlProcessDispose> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlProcessDispose> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlProcessDispose> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlProcessDispose> list = (List<PmlProcessDispose>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlProcessDispose>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlProcessDispose>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlProcessDispose>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeBySendDate(Date sendDate) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findBySendDate(sendDate)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByTransition(int transition_) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByTransition(transition_)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByDelegateUser(long delegateUser)
        throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByDelegateUser(
                delegateUser)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByExpiredDate(Date expiredDate) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByExpiredDate(
                expiredDate)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByFileId_Transition(String fileId, int transition_)
        throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByFileId_Transition(
                fileId, transition_)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByFileId_StateProcessIdBefore(String fileId,
        long stateProcessIdBefore) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByFileId_StateProcessIdBefore(
                fileId, stateProcessIdBefore)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByFileId_StateProcessIdAfter(String fileId,
        long stateProcessIdAfter) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByFileId_StateProcessIdAfter(
                fileId, stateProcessIdAfter)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByProcesser(long processer) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByProcesser(processer)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByDateProcess(Date dateProcess) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByDateProcess(
                dateProcess)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByReceiver(long receiver) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByReceiver(receiver)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByReceiveDate(Date receiveDate) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByReceiveDate(
                receiveDate)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByStateProcessIdBefore(long stateProcessIdBefore)
        throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByStateProcessIdBefore(
                stateProcessIdBefore)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByStateProcessIdAfter(long stateProcessIdAfter)
        throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByStateProcessIdAfter(
                stateProcessIdAfter)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByFileId(String fileId) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByFileId(fileId)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findAll()) {
            remove(pmlProcessDispose);
        }
    }

    public int countBySendDate(Date sendDate) throws SystemException {
        Object[] finderArgs = new Object[] { sendDate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SENDDATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (sendDate == null) {
                    query.append("senddate IS NULL");
                } else {
                    query.append("senddate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SENDDATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByTransition(int transition_) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(transition_) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANSITION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("transition_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(transition_);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANSITION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDelegateUser(long delegateUser) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(delegateUser) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DELEGATEUSER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("delegateuser = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(delegateUser);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DELEGATEUSER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByExpiredDate(Date expiredDate) throws SystemException {
        Object[] finderArgs = new Object[] { expiredDate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EXPIREDDATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EXPIREDDATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileId_Transition(String fileId, int transition_)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileId, new Integer(transition_) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILEID_TRANSITION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("transition_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(transition_);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILEID_TRANSITION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileId_StateProcessIdBefore(String fileId,
        long stateProcessIdBefore) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileId, new Long(stateProcessIdBefore)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILEID_STATEPROCESSIDBEFORE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(stateProcessIdBefore);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILEID_STATEPROCESSIDBEFORE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileId_StateProcessIdAfter(String fileId,
        long stateProcessIdAfter) throws SystemException {
        Object[] finderArgs = new Object[] { fileId, new Long(stateProcessIdAfter) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILEID_STATEPROCESSIDAFTER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(stateProcessIdAfter);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILEID_STATEPROCESSIDAFTER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByProcesser(long processer) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(processer) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROCESSER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("processer = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processer);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDateProcess(Date dateProcess) throws SystemException {
        Object[] finderArgs = new Object[] { dateProcess };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DATEPROCESS,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATEPROCESS,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByReceiver(long receiver) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(receiver) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RECEIVER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIVER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByReceiveDate(Date receiveDate) throws SystemException {
        Object[] finderArgs = new Object[] { receiveDate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RECEIVEDATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

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

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIVEDATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByStateProcessIdBefore(long stateProcessIdBefore)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(stateProcessIdBefore) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATEPROCESSIDBEFORE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdBefore);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATEPROCESSIDBEFORE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByStateProcessIdAfter(long stateProcessIdAfter)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(stateProcessIdAfter) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATEPROCESSIDAFTER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdAfter);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATEPROCESSIDAFTER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileId(String fileId) throws SystemException {
        Object[] finderArgs = new Object[] { fileId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILEID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILEID,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlProcessDispose");

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
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlProcessDispose")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlProcessDispose>> listenersList = new ArrayList<ModelListener<PmlProcessDispose>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlProcessDispose>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
