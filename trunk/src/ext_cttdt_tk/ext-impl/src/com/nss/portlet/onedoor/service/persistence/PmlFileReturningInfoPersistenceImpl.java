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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.onedoor.NoSuchPmlFileReturningInfoException;
import com.nss.portlet.onedoor.model.PmlFileReturningInfo;
import com.nss.portlet.onedoor.model.impl.PmlFileReturningInfoImpl;
import com.nss.portlet.onedoor.model.impl.PmlFileReturningInfoModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class PmlFileReturningInfoPersistenceImpl extends BasePersistenceImpl
    implements PmlFileReturningInfoPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlFileReturningInfoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FILEID = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILEID = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILEID = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILESENDER = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileSender",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILESENDER = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileSender",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILESENDER = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileSender",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_LICENSENUMBER = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByLicenseNumber",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_LICENSENUMBER = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByLicenseNumber",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_LICENSENUMBER = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByLicenseNumber",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ISSUINGDATELICENSE = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByIssuingDateLicense",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ISSUINGDATELICENSE = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByIssuingDateLicense",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ISSUINGDATELICENSE = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByIssuingDateLicense",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_RECEIVELICENSEDATE = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByReceiveLicenseDate",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_RECEIVELICENSEDATE = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByReceiveLicenseDate",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_RECEIVELICENSEDATE = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByReceiveLicenseDate",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DOCUMENTNUMBER = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDocumentNumber",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DOCUMENTNUMBER = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDocumentNumber",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DOCUMENTNUMBER = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByDocumentNumber",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_BILLNUMBER = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByBillNumber",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_BILLNUMBER = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByBillNumber",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_BILLNUMBER = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByBillNumber",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_NUMBERMONEY = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByNumberMoney",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_NUMBERMONEY = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByNumberMoney",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_NUMBERMONEY = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByNumberMoney",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_NOTE = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByNote",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_NOTE = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByNote",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_NOTE = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByNote",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_CONCLUDE = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByConclude",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_CONCLUDE = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByConclude",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_CONCLUDE = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByConclude",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_FILERETURNINGINFOIDFILEID =
        new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_ENTITY, "fetchByFileReturningInfoIdFileId",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILERETURNINGINFOIDFILEID =
        new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileReturningInfoIdFileId",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlFileReturningInfoPersistenceImpl.class);
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

    public void cacheResult(PmlFileReturningInfo pmlFileReturningInfo) {
        EntityCacheUtil.putResult(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoImpl.class,
            pmlFileReturningInfo.getPrimaryKey(), pmlFileReturningInfo);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILERETURNINGINFOIDFILEID,
            new Object[] {
                pmlFileReturningInfo.getFileId(),
                new Long(pmlFileReturningInfo.getFileReturningInfoId())
            }, pmlFileReturningInfo);
    }

    public void cacheResult(List<PmlFileReturningInfo> pmlFileReturningInfos) {
        for (PmlFileReturningInfo pmlFileReturningInfo : pmlFileReturningInfos) {
            if (EntityCacheUtil.getResult(
                        PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
                        PmlFileReturningInfoImpl.class,
                        pmlFileReturningInfo.getPrimaryKey(), this) == null) {
                cacheResult(pmlFileReturningInfo);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlFileReturningInfoImpl.class.getName());
        EntityCacheUtil.clearCache(PmlFileReturningInfoImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlFileReturningInfo create(long fileReturningInfoId) {
        PmlFileReturningInfo pmlFileReturningInfo = new PmlFileReturningInfoImpl();

        pmlFileReturningInfo.setNew(true);
        pmlFileReturningInfo.setPrimaryKey(fileReturningInfoId);

        return pmlFileReturningInfo;
    }

    public PmlFileReturningInfo remove(long fileReturningInfoId)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileReturningInfo pmlFileReturningInfo = (PmlFileReturningInfo) session.get(PmlFileReturningInfoImpl.class,
                    new Long(fileReturningInfoId));

            if (pmlFileReturningInfo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlFileReturningInfo exists with the primary key " +
                        fileReturningInfoId);
                }

                throw new NoSuchPmlFileReturningInfoException(
                    "No PmlFileReturningInfo exists with the primary key " +
                    fileReturningInfoId);
            }

            return remove(pmlFileReturningInfo);
        } catch (NoSuchPmlFileReturningInfoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileReturningInfo remove(
        PmlFileReturningInfo pmlFileReturningInfo) throws SystemException {
        for (ModelListener<PmlFileReturningInfo> listener : listeners) {
            listener.onBeforeRemove(pmlFileReturningInfo);
        }

        pmlFileReturningInfo = removeImpl(pmlFileReturningInfo);

        for (ModelListener<PmlFileReturningInfo> listener : listeners) {
            listener.onAfterRemove(pmlFileReturningInfo);
        }

        return pmlFileReturningInfo;
    }

    protected PmlFileReturningInfo removeImpl(
        PmlFileReturningInfo pmlFileReturningInfo) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlFileReturningInfo.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlFileReturningInfoImpl.class,
                        pmlFileReturningInfo.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlFileReturningInfo);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        PmlFileReturningInfoModelImpl pmlFileReturningInfoModelImpl = (PmlFileReturningInfoModelImpl) pmlFileReturningInfo;

        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILERETURNINGINFOIDFILEID,
            new Object[] {
                pmlFileReturningInfoModelImpl.getOriginalFileId(),
                new Long(pmlFileReturningInfoModelImpl.getOriginalFileReturningInfoId())
            });

        EntityCacheUtil.removeResult(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoImpl.class, pmlFileReturningInfo.getPrimaryKey());

        return pmlFileReturningInfo;
    }

    /**
     * @deprecated Use <code>update(PmlFileReturningInfo pmlFileReturningInfo, boolean merge)</code>.
     */
    public PmlFileReturningInfo update(
        PmlFileReturningInfo pmlFileReturningInfo) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileReturningInfo pmlFileReturningInfo) method. Use update(PmlFileReturningInfo pmlFileReturningInfo, boolean merge) instead.");
        }

        return update(pmlFileReturningInfo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileReturningInfo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileReturningInfo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileReturningInfo update(
        PmlFileReturningInfo pmlFileReturningInfo, boolean merge)
        throws SystemException {
        boolean isNew = pmlFileReturningInfo.isNew();

        for (ModelListener<PmlFileReturningInfo> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlFileReturningInfo);
            } else {
                listener.onBeforeUpdate(pmlFileReturningInfo);
            }
        }

        pmlFileReturningInfo = updateImpl(pmlFileReturningInfo, merge);

        for (ModelListener<PmlFileReturningInfo> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlFileReturningInfo);
            } else {
                listener.onAfterUpdate(pmlFileReturningInfo);
            }
        }

        return pmlFileReturningInfo;
    }

    public PmlFileReturningInfo updateImpl(
        com.nss.portlet.onedoor.model.PmlFileReturningInfo pmlFileReturningInfo,
        boolean merge) throws SystemException {
        boolean isNew = pmlFileReturningInfo.isNew();

        PmlFileReturningInfoModelImpl pmlFileReturningInfoModelImpl = (PmlFileReturningInfoModelImpl) pmlFileReturningInfo;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlFileReturningInfo, merge);

            pmlFileReturningInfo.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileReturningInfoImpl.class,
            pmlFileReturningInfo.getPrimaryKey(), pmlFileReturningInfo);

        if (!isNew &&
                (!Validator.equals(pmlFileReturningInfo.getFileId(),
                    pmlFileReturningInfoModelImpl.getOriginalFileId()) ||
                (pmlFileReturningInfo.getFileReturningInfoId() != pmlFileReturningInfoModelImpl.getOriginalFileReturningInfoId()))) {
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_FILERETURNINGINFOIDFILEID,
                new Object[] {
                    pmlFileReturningInfoModelImpl.getOriginalFileId(),
                    new Long(pmlFileReturningInfoModelImpl.getOriginalFileReturningInfoId())
                });
        }

        if (isNew ||
                (!Validator.equals(pmlFileReturningInfo.getFileId(),
                    pmlFileReturningInfoModelImpl.getOriginalFileId()) ||
                (pmlFileReturningInfo.getFileReturningInfoId() != pmlFileReturningInfoModelImpl.getOriginalFileReturningInfoId()))) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILERETURNINGINFOIDFILEID,
                new Object[] {
                    pmlFileReturningInfo.getFileId(),
                    new Long(pmlFileReturningInfo.getFileReturningInfoId())
                }, pmlFileReturningInfo);
        }

        return pmlFileReturningInfo;
    }

    public PmlFileReturningInfo findByPrimaryKey(long fileReturningInfoId)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = fetchByPrimaryKey(fileReturningInfoId);

        if (pmlFileReturningInfo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlFileReturningInfo exists with the primary key " +
                    fileReturningInfoId);
            }

            throw new NoSuchPmlFileReturningInfoException(
                "No PmlFileReturningInfo exists with the primary key " +
                fileReturningInfoId);
        }

        return pmlFileReturningInfo;
    }

    public PmlFileReturningInfo fetchByPrimaryKey(long fileReturningInfoId)
        throws SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = (PmlFileReturningInfo) EntityCacheUtil.getResult(PmlFileReturningInfoModelImpl.ENTITY_CACHE_ENABLED,
                PmlFileReturningInfoImpl.class, fileReturningInfoId, this);

        if (pmlFileReturningInfo == null) {
            Session session = null;

            try {
                session = openSession();

                pmlFileReturningInfo = (PmlFileReturningInfo) session.get(PmlFileReturningInfoImpl.class,
                        new Long(fileReturningInfoId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlFileReturningInfo != null) {
                    cacheResult(pmlFileReturningInfo);
                }

                closeSession(session);
            }
        }

        return pmlFileReturningInfo;
    }

    public List<PmlFileReturningInfo> findByFileId(String fileId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileId };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

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
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileReturningInfo> findByFileId(String fileId, int start,
        int end) throws SystemException {
        return findByFileId(fileId, start, end, null);
    }

    public List<PmlFileReturningInfo> findByFileId(String fileId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

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

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileReturningInfo findByFileId_First(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByFileId(fileId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByFileId_Last(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByFileId(fileId);

        List<PmlFileReturningInfo> list = findByFileId(fileId, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByFileId_PrevAndNext(
        long fileReturningInfoId, String fileId, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByFileId(fileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

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

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByFileSender(String fileSender)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileSender };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILESENDER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (fileSender == null) {
                    query.append("filesender LIKE null");
                } else {
                    query.append("filesender LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileSender != null) {
                    qPos.add(fileSender);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILESENDER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileReturningInfo> findByFileSender(String fileSender,
        int start, int end) throws SystemException {
        return findByFileSender(fileSender, start, end, null);
    }

    public List<PmlFileReturningInfo> findByFileSender(String fileSender,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileSender,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILESENDER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (fileSender == null) {
                    query.append("filesender LIKE null");
                } else {
                    query.append("filesender LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileSender != null) {
                    qPos.add(fileSender);
                }

                list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILESENDER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileReturningInfo findByFileSender_First(String fileSender,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByFileSender(fileSender, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("fileSender=" + fileSender);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByFileSender_Last(String fileSender,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByFileSender(fileSender);

        List<PmlFileReturningInfo> list = findByFileSender(fileSender,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("fileSender=" + fileSender);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByFileSender_PrevAndNext(
        long fileReturningInfoId, String fileSender, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByFileSender(fileSender);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

            if (fileSender == null) {
                query.append("filesender LIKE null");
            } else {
                query.append("filesender LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileSender != null) {
                qPos.add(fileSender);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByLicenseNumber(String licenseNumber)
        throws SystemException {
        Object[] finderArgs = new Object[] { licenseNumber };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_LICENSENUMBER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (licenseNumber == null) {
                    query.append("licensenumber LIKE null");
                } else {
                    query.append("licensenumber LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (licenseNumber != null) {
                    qPos.add(licenseNumber);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_LICENSENUMBER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileReturningInfo> findByLicenseNumber(
        String licenseNumber, int start, int end) throws SystemException {
        return findByLicenseNumber(licenseNumber, start, end, null);
    }

    public List<PmlFileReturningInfo> findByLicenseNumber(
        String licenseNumber, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                licenseNumber,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_LICENSENUMBER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (licenseNumber == null) {
                    query.append("licensenumber LIKE null");
                } else {
                    query.append("licensenumber LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (licenseNumber != null) {
                    qPos.add(licenseNumber);
                }

                list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_LICENSENUMBER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileReturningInfo findByLicenseNumber_First(
        String licenseNumber, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByLicenseNumber(licenseNumber, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("licenseNumber=" + licenseNumber);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByLicenseNumber_Last(String licenseNumber,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByLicenseNumber(licenseNumber);

        List<PmlFileReturningInfo> list = findByLicenseNumber(licenseNumber,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("licenseNumber=" + licenseNumber);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByLicenseNumber_PrevAndNext(
        long fileReturningInfoId, String licenseNumber, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByLicenseNumber(licenseNumber);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

            if (licenseNumber == null) {
                query.append("licensenumber LIKE null");
            } else {
                query.append("licensenumber LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (licenseNumber != null) {
                qPos.add(licenseNumber);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByIssuingDateLicense(
        Date issuingDateLicense) throws SystemException {
        Object[] finderArgs = new Object[] { issuingDateLicense };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ISSUINGDATELICENSE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (issuingDateLicense == null) {
                    query.append("issuingdatelicense IS NULL");
                } else {
                    query.append("issuingdatelicense = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingDateLicense != null) {
                    qPos.add(CalendarUtil.getTimestamp(issuingDateLicense));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ISSUINGDATELICENSE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileReturningInfo> findByIssuingDateLicense(
        Date issuingDateLicense, int start, int end) throws SystemException {
        return findByIssuingDateLicense(issuingDateLicense, start, end, null);
    }

    public List<PmlFileReturningInfo> findByIssuingDateLicense(
        Date issuingDateLicense, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                issuingDateLicense,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ISSUINGDATELICENSE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (issuingDateLicense == null) {
                    query.append("issuingdatelicense IS NULL");
                } else {
                    query.append("issuingdatelicense = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingDateLicense != null) {
                    qPos.add(CalendarUtil.getTimestamp(issuingDateLicense));
                }

                list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ISSUINGDATELICENSE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileReturningInfo findByIssuingDateLicense_First(
        Date issuingDateLicense, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByIssuingDateLicense(issuingDateLicense,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("issuingDateLicense=" + issuingDateLicense);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByIssuingDateLicense_Last(
        Date issuingDateLicense, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByIssuingDateLicense(issuingDateLicense);

        List<PmlFileReturningInfo> list = findByIssuingDateLicense(issuingDateLicense,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("issuingDateLicense=" + issuingDateLicense);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByIssuingDateLicense_PrevAndNext(
        long fileReturningInfoId, Date issuingDateLicense, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByIssuingDateLicense(issuingDateLicense);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

            if (issuingDateLicense == null) {
                query.append("issuingdatelicense IS NULL");
            } else {
                query.append("issuingdatelicense = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (issuingDateLicense != null) {
                qPos.add(CalendarUtil.getTimestamp(issuingDateLicense));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByReceiveLicenseDate(
        Date receiveLicenseDate) throws SystemException {
        Object[] finderArgs = new Object[] { receiveLicenseDate };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_RECEIVELICENSEDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (receiveLicenseDate == null) {
                    query.append("receivelicensedate IS NULL");
                } else {
                    query.append("receivelicensedate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveLicenseDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveLicenseDate));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_RECEIVELICENSEDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileReturningInfo> findByReceiveLicenseDate(
        Date receiveLicenseDate, int start, int end) throws SystemException {
        return findByReceiveLicenseDate(receiveLicenseDate, start, end, null);
    }

    public List<PmlFileReturningInfo> findByReceiveLicenseDate(
        Date receiveLicenseDate, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                receiveLicenseDate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_RECEIVELICENSEDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (receiveLicenseDate == null) {
                    query.append("receivelicensedate IS NULL");
                } else {
                    query.append("receivelicensedate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveLicenseDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveLicenseDate));
                }

                list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_RECEIVELICENSEDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileReturningInfo findByReceiveLicenseDate_First(
        Date receiveLicenseDate, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByReceiveLicenseDate(receiveLicenseDate,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("receiveLicenseDate=" + receiveLicenseDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByReceiveLicenseDate_Last(
        Date receiveLicenseDate, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByReceiveLicenseDate(receiveLicenseDate);

        List<PmlFileReturningInfo> list = findByReceiveLicenseDate(receiveLicenseDate,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("receiveLicenseDate=" + receiveLicenseDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByReceiveLicenseDate_PrevAndNext(
        long fileReturningInfoId, Date receiveLicenseDate, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByReceiveLicenseDate(receiveLicenseDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

            if (receiveLicenseDate == null) {
                query.append("receivelicensedate IS NULL");
            } else {
                query.append("receivelicensedate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (receiveLicenseDate != null) {
                qPos.add(CalendarUtil.getTimestamp(receiveLicenseDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByDocumentNumber(
        String documentNumber) throws SystemException {
        Object[] finderArgs = new Object[] { documentNumber };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DOCUMENTNUMBER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (documentNumber == null) {
                    query.append("documentnumber LIKE null");
                } else {
                    query.append("documentnumber LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentNumber != null) {
                    qPos.add(documentNumber);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DOCUMENTNUMBER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileReturningInfo> findByDocumentNumber(
        String documentNumber, int start, int end) throws SystemException {
        return findByDocumentNumber(documentNumber, start, end, null);
    }

    public List<PmlFileReturningInfo> findByDocumentNumber(
        String documentNumber, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                documentNumber,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DOCUMENTNUMBER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (documentNumber == null) {
                    query.append("documentnumber LIKE null");
                } else {
                    query.append("documentnumber LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentNumber != null) {
                    qPos.add(documentNumber);
                }

                list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DOCUMENTNUMBER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileReturningInfo findByDocumentNumber_First(
        String documentNumber, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByDocumentNumber(documentNumber,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("documentNumber=" + documentNumber);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByDocumentNumber_Last(
        String documentNumber, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByDocumentNumber(documentNumber);

        List<PmlFileReturningInfo> list = findByDocumentNumber(documentNumber,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("documentNumber=" + documentNumber);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByDocumentNumber_PrevAndNext(
        long fileReturningInfoId, String documentNumber, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByDocumentNumber(documentNumber);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

            if (documentNumber == null) {
                query.append("documentnumber LIKE null");
            } else {
                query.append("documentnumber LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (documentNumber != null) {
                qPos.add(documentNumber);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByBillNumber(String billNumber)
        throws SystemException {
        Object[] finderArgs = new Object[] { billNumber };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_BILLNUMBER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (billNumber == null) {
                    query.append("billnumber LIKE null");
                } else {
                    query.append("billnumber LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (billNumber != null) {
                    qPos.add(billNumber);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_BILLNUMBER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileReturningInfo> findByBillNumber(String billNumber,
        int start, int end) throws SystemException {
        return findByBillNumber(billNumber, start, end, null);
    }

    public List<PmlFileReturningInfo> findByBillNumber(String billNumber,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                billNumber,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_BILLNUMBER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (billNumber == null) {
                    query.append("billnumber LIKE null");
                } else {
                    query.append("billnumber LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (billNumber != null) {
                    qPos.add(billNumber);
                }

                list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_BILLNUMBER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileReturningInfo findByBillNumber_First(String billNumber,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByBillNumber(billNumber, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("billNumber=" + billNumber);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByBillNumber_Last(String billNumber,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByBillNumber(billNumber);

        List<PmlFileReturningInfo> list = findByBillNumber(billNumber,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("billNumber=" + billNumber);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByBillNumber_PrevAndNext(
        long fileReturningInfoId, String billNumber, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByBillNumber(billNumber);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

            if (billNumber == null) {
                query.append("billnumber LIKE null");
            } else {
                query.append("billnumber LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (billNumber != null) {
                qPos.add(billNumber);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByNumberMoney(long numberMoney)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(numberMoney) };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NUMBERMONEY,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                query.append("numbermoney = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(numberMoney);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NUMBERMONEY,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileReturningInfo> findByNumberMoney(long numberMoney,
        int start, int end) throws SystemException {
        return findByNumberMoney(numberMoney, start, end, null);
    }

    public List<PmlFileReturningInfo> findByNumberMoney(long numberMoney,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(numberMoney),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NUMBERMONEY,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                query.append("numbermoney = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(numberMoney);

                list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NUMBERMONEY,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileReturningInfo findByNumberMoney_First(long numberMoney,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByNumberMoney(numberMoney, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("numberMoney=" + numberMoney);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByNumberMoney_Last(long numberMoney,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByNumberMoney(numberMoney);

        List<PmlFileReturningInfo> list = findByNumberMoney(numberMoney,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("numberMoney=" + numberMoney);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByNumberMoney_PrevAndNext(
        long fileReturningInfoId, long numberMoney, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByNumberMoney(numberMoney);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

            query.append("numbermoney = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(numberMoney);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByNote(String note)
        throws SystemException {
        Object[] finderArgs = new Object[] { note };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NOTE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("note LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NOTE, finderArgs,
                    list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileReturningInfo> findByNote(String note, int start, int end)
        throws SystemException {
        return findByNote(note, start, end, null);
    }

    public List<PmlFileReturningInfo> findByNote(String note, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                note,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NOTE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("note LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NOTE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileReturningInfo findByNote_First(String note,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByNote(note, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByNote_Last(String note,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByNote(note);

        List<PmlFileReturningInfo> list = findByNote(note, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByNote_PrevAndNext(
        long fileReturningInfoId, String note, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByNote(note);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

            if (note == null) {
                query.append("note LIKE null");
            } else {
                query.append("note LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (note != null) {
                qPos.add(note);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileReturningInfo> findByConclude(String conclude)
        throws SystemException {
        Object[] finderArgs = new Object[] { conclude };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CONCLUDE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (conclude == null) {
                    query.append("conclude LIKE null");
                } else {
                    query.append("conclude LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (conclude != null) {
                    qPos.add(conclude);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CONCLUDE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileReturningInfo> findByConclude(String conclude,
        int start, int end) throws SystemException {
        return findByConclude(conclude, start, end, null);
    }

    public List<PmlFileReturningInfo> findByConclude(String conclude,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                conclude,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CONCLUDE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (conclude == null) {
                    query.append("conclude LIKE null");
                } else {
                    query.append("conclude LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (conclude != null) {
                    qPos.add(conclude);
                }

                list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CONCLUDE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileReturningInfo findByConclude_First(String conclude,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        List<PmlFileReturningInfo> list = findByConclude(conclude, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("conclude=" + conclude);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo findByConclude_Last(String conclude,
        OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        int count = countByConclude(conclude);

        List<PmlFileReturningInfo> list = findByConclude(conclude, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("conclude=" + conclude);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileReturningInfo[] findByConclude_PrevAndNext(
        long fileReturningInfoId, String conclude, OrderByComparator obc)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByPrimaryKey(fileReturningInfoId);

        int count = countByConclude(conclude);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

            if (conclude == null) {
                query.append("conclude LIKE null");
            } else {
                query.append("conclude LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (conclude != null) {
                qPos.add(conclude);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileReturningInfo);

            PmlFileReturningInfo[] array = new PmlFileReturningInfoImpl[3];

            array[0] = (PmlFileReturningInfo) objArray[0];
            array[1] = (PmlFileReturningInfo) objArray[1];
            array[2] = (PmlFileReturningInfo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileReturningInfo findByFileReturningInfoIdFileId(String fileId,
        long fileReturningInfoId)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = fetchByFileReturningInfoIdFileId(fileId,
                fileReturningInfoId);

        if (pmlFileReturningInfo == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileReturningInfo exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("fileReturningInfoId=" + fileReturningInfoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPmlFileReturningInfoException(msg.toString());
        }

        return pmlFileReturningInfo;
    }

    public PmlFileReturningInfo fetchByFileReturningInfoIdFileId(
        String fileId, long fileReturningInfoId) throws SystemException {
        return fetchByFileReturningInfoIdFileId(fileId, fileReturningInfoId,
            true);
    }

    public PmlFileReturningInfo fetchByFileReturningInfoIdFileId(
        String fileId, long fileReturningInfoId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileId, new Long(fileReturningInfoId) };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_FILERETURNINGINFOIDFILEID,
                    finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("filereturninginfoid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filereturninginfoid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(fileReturningInfoId);

                List<PmlFileReturningInfo> list = q.list();

                result = list;

                PmlFileReturningInfo pmlFileReturningInfo = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILERETURNINGINFOIDFILEID,
                        finderArgs, list);
                } else {
                    pmlFileReturningInfo = list.get(0);

                    cacheResult(pmlFileReturningInfo);

                    if ((pmlFileReturningInfo.getFileId() == null) ||
                            !pmlFileReturningInfo.getFileId().equals(fileId) ||
                            (pmlFileReturningInfo.getFileReturningInfoId() != fileReturningInfoId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILERETURNINGINFOIDFILEID,
                            finderArgs, pmlFileReturningInfo);
                    }
                }

                return pmlFileReturningInfo;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_FILERETURNINGINFOIDFILEID,
                        finderArgs, new ArrayList<PmlFileReturningInfo>());
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List) {
                return null;
            } else {
                return (PmlFileReturningInfo) result;
            }
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

    public List<PmlFileReturningInfo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileReturningInfo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileReturningInfo> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileReturningInfo> list = (List<PmlFileReturningInfo>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filereturninginfoid DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlFileReturningInfo>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileReturningInfo>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByFileId(String fileId) throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByFileId(fileId)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByFileSender(String fileSender) throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByFileSender(
                fileSender)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByLicenseNumber(String licenseNumber)
        throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByLicenseNumber(
                licenseNumber)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByIssuingDateLicense(Date issuingDateLicense)
        throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByIssuingDateLicense(
                issuingDateLicense)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByReceiveLicenseDate(Date receiveLicenseDate)
        throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByReceiveLicenseDate(
                receiveLicenseDate)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByDocumentNumber(String documentNumber)
        throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByDocumentNumber(
                documentNumber)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByBillNumber(String billNumber) throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByBillNumber(
                billNumber)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByNumberMoney(long numberMoney) throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByNumberMoney(
                numberMoney)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByNote(String note) throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByNote(note)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByConclude(String conclude) throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findByConclude(
                conclude)) {
            remove(pmlFileReturningInfo);
        }
    }

    public void removeByFileReturningInfoIdFileId(String fileId,
        long fileReturningInfoId)
        throws NoSuchPmlFileReturningInfoException, SystemException {
        PmlFileReturningInfo pmlFileReturningInfo = findByFileReturningInfoIdFileId(fileId,
                fileReturningInfoId);

        remove(pmlFileReturningInfo);
    }

    public void removeAll() throws SystemException {
        for (PmlFileReturningInfo pmlFileReturningInfo : findAll()) {
            remove(pmlFileReturningInfo);
        }
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
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

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

    public int countByFileSender(String fileSender) throws SystemException {
        Object[] finderArgs = new Object[] { fileSender };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILESENDER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (fileSender == null) {
                    query.append("filesender LIKE null");
                } else {
                    query.append("filesender LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileSender != null) {
                    qPos.add(fileSender);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILESENDER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByLicenseNumber(String licenseNumber)
        throws SystemException {
        Object[] finderArgs = new Object[] { licenseNumber };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LICENSENUMBER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (licenseNumber == null) {
                    query.append("licensenumber LIKE null");
                } else {
                    query.append("licensenumber LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (licenseNumber != null) {
                    qPos.add(licenseNumber);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LICENSENUMBER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByIssuingDateLicense(Date issuingDateLicense)
        throws SystemException {
        Object[] finderArgs = new Object[] { issuingDateLicense };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISSUINGDATELICENSE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (issuingDateLicense == null) {
                    query.append("issuingdatelicense IS NULL");
                } else {
                    query.append("issuingdatelicense = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingDateLicense != null) {
                    qPos.add(CalendarUtil.getTimestamp(issuingDateLicense));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISSUINGDATELICENSE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByReceiveLicenseDate(Date receiveLicenseDate)
        throws SystemException {
        Object[] finderArgs = new Object[] { receiveLicenseDate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RECEIVELICENSEDATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (receiveLicenseDate == null) {
                    query.append("receivelicensedate IS NULL");
                } else {
                    query.append("receivelicensedate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveLicenseDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveLicenseDate));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIVELICENSEDATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDocumentNumber(String documentNumber)
        throws SystemException {
        Object[] finderArgs = new Object[] { documentNumber };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DOCUMENTNUMBER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (documentNumber == null) {
                    query.append("documentnumber LIKE null");
                } else {
                    query.append("documentnumber LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentNumber != null) {
                    qPos.add(documentNumber);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DOCUMENTNUMBER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByBillNumber(String billNumber) throws SystemException {
        Object[] finderArgs = new Object[] { billNumber };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BILLNUMBER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (billNumber == null) {
                    query.append("billnumber LIKE null");
                } else {
                    query.append("billnumber LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (billNumber != null) {
                    qPos.add(billNumber);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BILLNUMBER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByNumberMoney(long numberMoney) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(numberMoney) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NUMBERMONEY,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                query.append("numbermoney = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(numberMoney);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NUMBERMONEY,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByNote(String note) throws SystemException {
        Object[] finderArgs = new Object[] { note };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NOTE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("note LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOTE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByConclude(String conclude) throws SystemException {
        Object[] finderArgs = new Object[] { conclude };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONCLUDE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (conclude == null) {
                    query.append("conclude LIKE null");
                } else {
                    query.append("conclude LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (conclude != null) {
                    qPos.add(conclude);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONCLUDE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileReturningInfoIdFileId(String fileId,
        long fileReturningInfoId) throws SystemException {
        Object[] finderArgs = new Object[] { fileId, new Long(fileReturningInfoId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILERETURNINGINFOIDFILEID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("filereturninginfoid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(fileReturningInfoId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILERETURNINGINFOIDFILEID,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlFileReturningInfo");

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
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlFileReturningInfo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlFileReturningInfo>> listenersList = new ArrayList<ModelListener<PmlFileReturningInfo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlFileReturningInfo>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
