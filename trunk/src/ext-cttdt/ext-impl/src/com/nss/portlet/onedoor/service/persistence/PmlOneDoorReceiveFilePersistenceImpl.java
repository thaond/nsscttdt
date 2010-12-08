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

import com.nss.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.model.impl.PmlOneDoorReceiveFileImpl;
import com.nss.portlet.onedoor.model.impl.PmlOneDoorReceiveFileModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class PmlOneDoorReceiveFilePersistenceImpl extends BasePersistenceImpl
    implements PmlOneDoorReceiveFilePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlOneDoorReceiveFileImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPEID = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPEID = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPEID = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileTypeId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_APPLICATIONDATE = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByApplicationDate",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPLICATIONDATE = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByApplicationDate",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_APPLICATIONDATE = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByApplicationDate",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_APPLICANTNAME = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByApplicantName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_APPLICANTNAME = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByApplicantName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_APPLICANTNAME = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByApplicantName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ORGANIZATION = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByOrganization",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORGANIZATION = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByOrganization",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ORGANIZATION = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByOrganization",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_PERMANENTADDRESS = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByPermanentAddress",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_PERMANENTADDRESS = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByPermanentAddress",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_PERMANENTADDRESS = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByPermanentAddress",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_AUTHORISEDLETTER = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByAuthorisedLetter",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_AUTHORISEDLETTER = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByAuthorisedLetter",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_AUTHORISEDLETTER = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByAuthorisedLetter",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DATECREATED = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDateCreated",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DATECREATED = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDateCreated",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DATECREATED = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByDateCreated",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPEID_APPLICATIONDATE =
        new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId_ApplicationDate",
            new String[] { String.class.getName(), Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPEID_APPLICATIONDATE =
        new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId_ApplicationDate",
            new String[] {
                String.class.getName(), Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPEID_APPLICATIONDATE =
        new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileTypeId_ApplicationDate",
            new String[] { String.class.getName(), Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPEID_EXACTRETURNINGDATE =
        new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId_ExactReturningDate",
            new String[] { String.class.getName(), Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPEID_EXACTRETURNINGDATE =
        new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId_ExactReturningDate",
            new String[] {
                String.class.getName(), Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPEID_EXACTRETURNINGDATE =
        new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileTypeId_ExactReturningDate",
            new String[] { String.class.getName(), Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPE_NUMBERRECEIPT = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileType_NumberReceipt",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPE_NUMBERRECEIPT =
        new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileType_NumberReceipt",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPE_NUMBERRECEIPT = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileType_NumberReceipt",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlOneDoorReceiveFilePersistenceImpl.class);
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

    public void cacheResult(PmlOneDoorReceiveFile pmlOneDoorReceiveFile) {
        EntityCacheUtil.putResult(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileImpl.class,
            pmlOneDoorReceiveFile.getPrimaryKey(), pmlOneDoorReceiveFile);
    }

    public void cacheResult(List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFiles) {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : pmlOneDoorReceiveFiles) {
            if (EntityCacheUtil.getResult(
                        PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
                        PmlOneDoorReceiveFileImpl.class,
                        pmlOneDoorReceiveFile.getPrimaryKey(), this) == null) {
                cacheResult(pmlOneDoorReceiveFile);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlOneDoorReceiveFileImpl.class.getName());
        EntityCacheUtil.clearCache(PmlOneDoorReceiveFileImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlOneDoorReceiveFile create(String fileId) {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = new PmlOneDoorReceiveFileImpl();

        pmlOneDoorReceiveFile.setNew(true);
        pmlOneDoorReceiveFile.setPrimaryKey(fileId);

        return pmlOneDoorReceiveFile;
    }

    public PmlOneDoorReceiveFile remove(String fileId)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlOneDoorReceiveFile pmlOneDoorReceiveFile = (PmlOneDoorReceiveFile) session.get(PmlOneDoorReceiveFileImpl.class,
                    fileId);

            if (pmlOneDoorReceiveFile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlOneDoorReceiveFile exists with the primary key " +
                        fileId);
                }

                throw new NoSuchPmlOneDoorReceiveFileException(
                    "No PmlOneDoorReceiveFile exists with the primary key " +
                    fileId);
            }

            return remove(pmlOneDoorReceiveFile);
        } catch (NoSuchPmlOneDoorReceiveFileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlOneDoorReceiveFile remove(
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile) throws SystemException {
        for (ModelListener<PmlOneDoorReceiveFile> listener : listeners) {
            listener.onBeforeRemove(pmlOneDoorReceiveFile);
        }

        pmlOneDoorReceiveFile = removeImpl(pmlOneDoorReceiveFile);

        for (ModelListener<PmlOneDoorReceiveFile> listener : listeners) {
            listener.onAfterRemove(pmlOneDoorReceiveFile);
        }

        return pmlOneDoorReceiveFile;
    }

    protected PmlOneDoorReceiveFile removeImpl(
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlOneDoorReceiveFile.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlOneDoorReceiveFileImpl.class,
                        pmlOneDoorReceiveFile.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlOneDoorReceiveFile);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileImpl.class,
            pmlOneDoorReceiveFile.getPrimaryKey());

        return pmlOneDoorReceiveFile;
    }

    /**
     * @deprecated Use <code>update(PmlOneDoorReceiveFile pmlOneDoorReceiveFile, boolean merge)</code>.
     */
    public PmlOneDoorReceiveFile update(
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlOneDoorReceiveFile pmlOneDoorReceiveFile) method. Use update(PmlOneDoorReceiveFile pmlOneDoorReceiveFile, boolean merge) instead.");
        }

        return update(pmlOneDoorReceiveFile, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlOneDoorReceiveFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlOneDoorReceiveFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlOneDoorReceiveFile update(
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile, boolean merge)
        throws SystemException {
        boolean isNew = pmlOneDoorReceiveFile.isNew();

        for (ModelListener<PmlOneDoorReceiveFile> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlOneDoorReceiveFile);
            } else {
                listener.onBeforeUpdate(pmlOneDoorReceiveFile);
            }
        }

        pmlOneDoorReceiveFile = updateImpl(pmlOneDoorReceiveFile, merge);

        for (ModelListener<PmlOneDoorReceiveFile> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlOneDoorReceiveFile);
            } else {
                listener.onAfterUpdate(pmlOneDoorReceiveFile);
            }
        }

        return pmlOneDoorReceiveFile;
    }

    public PmlOneDoorReceiveFile updateImpl(
        com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlOneDoorReceiveFile, merge);

            pmlOneDoorReceiveFile.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlOneDoorReceiveFileImpl.class,
            pmlOneDoorReceiveFile.getPrimaryKey(), pmlOneDoorReceiveFile);

        return pmlOneDoorReceiveFile;
    }

    public PmlOneDoorReceiveFile findByPrimaryKey(String fileId)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = fetchByPrimaryKey(fileId);

        if (pmlOneDoorReceiveFile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlOneDoorReceiveFile exists with the primary key " +
                    fileId);
            }

            throw new NoSuchPmlOneDoorReceiveFileException(
                "No PmlOneDoorReceiveFile exists with the primary key " +
                fileId);
        }

        return pmlOneDoorReceiveFile;
    }

    public PmlOneDoorReceiveFile fetchByPrimaryKey(String fileId)
        throws SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = (PmlOneDoorReceiveFile) EntityCacheUtil.getResult(PmlOneDoorReceiveFileModelImpl.ENTITY_CACHE_ENABLED,
                PmlOneDoorReceiveFileImpl.class, fileId, this);

        if (pmlOneDoorReceiveFile == null) {
            Session session = null;

            try {
                session = openSession();

                pmlOneDoorReceiveFile = (PmlOneDoorReceiveFile) session.get(PmlOneDoorReceiveFileImpl.class,
                        fileId);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlOneDoorReceiveFile != null) {
                    cacheResult(pmlOneDoorReceiveFile);
                }

                closeSession(session);
            }
        }

        return pmlOneDoorReceiveFile;
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId(String fileTypeId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

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
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId(String fileTypeId,
        int start, int end) throws SystemException {
        return findByFileTypeId(fileTypeId, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId(String fileTypeId,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

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

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlOneDoorReceiveFile findByFileTypeId_First(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByFileTypeId(fileTypeId, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByFileTypeId_Last(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByFileTypeId(fileTypeId);

        List<PmlOneDoorReceiveFile> list = findByFileTypeId(fileTypeId,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByFileTypeId_PrevAndNext(String fileId,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByFileTypeId(fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

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

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByApplicationDate(
        Date applicationDate) throws SystemException {
        Object[] finderArgs = new Object[] { applicationDate };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPLICATIONDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (applicationDate == null) {
                    query.append("applicationDate IS NULL");
                } else {
                    query.append("applicationDate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicationDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(applicationDate));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPLICATIONDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlOneDoorReceiveFile> findByApplicationDate(
        Date applicationDate, int start, int end) throws SystemException {
        return findByApplicationDate(applicationDate, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByApplicationDate(
        Date applicationDate, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                applicationDate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPLICATIONDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (applicationDate == null) {
                    query.append("applicationDate IS NULL");
                } else {
                    query.append("applicationDate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicationDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(applicationDate));
                }

                list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPLICATIONDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlOneDoorReceiveFile findByApplicationDate_First(
        Date applicationDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByApplicationDate(applicationDate,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("applicationDate=" + applicationDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByApplicationDate_Last(
        Date applicationDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByApplicationDate(applicationDate);

        List<PmlOneDoorReceiveFile> list = findByApplicationDate(applicationDate,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("applicationDate=" + applicationDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByApplicationDate_PrevAndNext(
        String fileId, Date applicationDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByApplicationDate(applicationDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (applicationDate == null) {
                query.append("applicationDate IS NULL");
            } else {
                query.append("applicationDate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (applicationDate != null) {
                qPos.add(CalendarUtil.getTimestamp(applicationDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByApplicantName(String applicantName)
        throws SystemException {
        Object[] finderArgs = new Object[] { applicantName };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_APPLICANTNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (applicantName == null) {
                    query.append("applicantName LIKE null");
                } else {
                    query.append("applicantName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicantName != null) {
                    qPos.add(applicantName);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_APPLICANTNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlOneDoorReceiveFile> findByApplicantName(
        String applicantName, int start, int end) throws SystemException {
        return findByApplicantName(applicantName, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByApplicantName(
        String applicantName, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                applicantName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_APPLICANTNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (applicantName == null) {
                    query.append("applicantName LIKE null");
                } else {
                    query.append("applicantName LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicantName != null) {
                    qPos.add(applicantName);
                }

                list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_APPLICANTNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlOneDoorReceiveFile findByApplicantName_First(
        String applicantName, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByApplicantName(applicantName,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("applicantName=" + applicantName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByApplicantName_Last(
        String applicantName, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByApplicantName(applicantName);

        List<PmlOneDoorReceiveFile> list = findByApplicantName(applicantName,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("applicantName=" + applicantName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByApplicantName_PrevAndNext(
        String fileId, String applicantName, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByApplicantName(applicantName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (applicantName == null) {
                query.append("applicantName LIKE null");
            } else {
                query.append("applicantName LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (applicantName != null) {
                qPos.add(applicantName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByOrganization(String organization)
        throws SystemException {
        Object[] finderArgs = new Object[] { organization };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORGANIZATION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (organization == null) {
                    query.append("organization LIKE null");
                } else {
                    query.append("organization LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (organization != null) {
                    qPos.add(organization);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORGANIZATION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlOneDoorReceiveFile> findByOrganization(String organization,
        int start, int end) throws SystemException {
        return findByOrganization(organization, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByOrganization(String organization,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                organization,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORGANIZATION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (organization == null) {
                    query.append("organization LIKE null");
                } else {
                    query.append("organization LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (organization != null) {
                    qPos.add(organization);
                }

                list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORGANIZATION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlOneDoorReceiveFile findByOrganization_First(String organization,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByOrganization(organization, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("organization=" + organization);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByOrganization_Last(String organization,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByOrganization(organization);

        List<PmlOneDoorReceiveFile> list = findByOrganization(organization,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("organization=" + organization);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByOrganization_PrevAndNext(
        String fileId, String organization, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByOrganization(organization);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (organization == null) {
                query.append("organization LIKE null");
            } else {
                query.append("organization LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (organization != null) {
                qPos.add(organization);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByPermanentAddress(
        String permanentAddress) throws SystemException {
        Object[] finderArgs = new Object[] { permanentAddress };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PERMANENTADDRESS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (permanentAddress == null) {
                    query.append("permanentAddress LIKE null");
                } else {
                    query.append("permanentAddress LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (permanentAddress != null) {
                    qPos.add(permanentAddress);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PERMANENTADDRESS,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlOneDoorReceiveFile> findByPermanentAddress(
        String permanentAddress, int start, int end) throws SystemException {
        return findByPermanentAddress(permanentAddress, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByPermanentAddress(
        String permanentAddress, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                permanentAddress,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PERMANENTADDRESS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (permanentAddress == null) {
                    query.append("permanentAddress LIKE null");
                } else {
                    query.append("permanentAddress LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (permanentAddress != null) {
                    qPos.add(permanentAddress);
                }

                list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PERMANENTADDRESS,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlOneDoorReceiveFile findByPermanentAddress_First(
        String permanentAddress, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByPermanentAddress(permanentAddress,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("permanentAddress=" + permanentAddress);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByPermanentAddress_Last(
        String permanentAddress, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByPermanentAddress(permanentAddress);

        List<PmlOneDoorReceiveFile> list = findByPermanentAddress(permanentAddress,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("permanentAddress=" + permanentAddress);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByPermanentAddress_PrevAndNext(
        String fileId, String permanentAddress, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByPermanentAddress(permanentAddress);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (permanentAddress == null) {
                query.append("permanentAddress LIKE null");
            } else {
                query.append("permanentAddress LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (permanentAddress != null) {
                qPos.add(permanentAddress);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByAuthorisedLetter(
        String authorisedLetter) throws SystemException {
        Object[] finderArgs = new Object[] { authorisedLetter };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_AUTHORISEDLETTER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (authorisedLetter == null) {
                    query.append("authorisedLetter LIKE null");
                } else {
                    query.append("authorisedLetter LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (authorisedLetter != null) {
                    qPos.add(authorisedLetter);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_AUTHORISEDLETTER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlOneDoorReceiveFile> findByAuthorisedLetter(
        String authorisedLetter, int start, int end) throws SystemException {
        return findByAuthorisedLetter(authorisedLetter, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByAuthorisedLetter(
        String authorisedLetter, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                authorisedLetter,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_AUTHORISEDLETTER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (authorisedLetter == null) {
                    query.append("authorisedLetter LIKE null");
                } else {
                    query.append("authorisedLetter LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (authorisedLetter != null) {
                    qPos.add(authorisedLetter);
                }

                list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_AUTHORISEDLETTER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlOneDoorReceiveFile findByAuthorisedLetter_First(
        String authorisedLetter, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByAuthorisedLetter(authorisedLetter,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("authorisedLetter=" + authorisedLetter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByAuthorisedLetter_Last(
        String authorisedLetter, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByAuthorisedLetter(authorisedLetter);

        List<PmlOneDoorReceiveFile> list = findByAuthorisedLetter(authorisedLetter,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("authorisedLetter=" + authorisedLetter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByAuthorisedLetter_PrevAndNext(
        String fileId, String authorisedLetter, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByAuthorisedLetter(authorisedLetter);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (authorisedLetter == null) {
                query.append("authorisedLetter LIKE null");
            } else {
                query.append("authorisedLetter LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (authorisedLetter != null) {
                qPos.add(authorisedLetter);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByDateCreated(Date dateCreated)
        throws SystemException {
        Object[] finderArgs = new Object[] { dateCreated };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DATECREATED,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (dateCreated == null) {
                    query.append("dateCreated IS NULL");
                } else {
                    query.append("dateCreated = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DATECREATED,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlOneDoorReceiveFile> findByDateCreated(Date dateCreated,
        int start, int end) throws SystemException {
        return findByDateCreated(dateCreated, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByDateCreated(Date dateCreated,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                dateCreated,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DATECREATED,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (dateCreated == null) {
                    query.append("dateCreated IS NULL");
                } else {
                    query.append("dateCreated = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DATECREATED,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlOneDoorReceiveFile findByDateCreated_First(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByDateCreated(dateCreated, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByDateCreated_Last(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByDateCreated(dateCreated);

        List<PmlOneDoorReceiveFile> list = findByDateCreated(dateCreated,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByDateCreated_PrevAndNext(
        String fileId, Date dateCreated, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByDateCreated(dateCreated);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (dateCreated == null) {
                query.append("dateCreated IS NULL");
            } else {
                query.append("dateCreated = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateCreated != null) {
                qPos.add(CalendarUtil.getTimestamp(dateCreated));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId_ApplicationDate(
        String fileTypeId, Date applicationDate) throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId, applicationDate };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPEID_APPLICATIONDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (applicationDate == null) {
                    query.append("applicationDate IS NULL");
                } else {
                    query.append("applicationDate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (applicationDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(applicationDate));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPEID_APPLICATIONDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId_ApplicationDate(
        String fileTypeId, Date applicationDate, int start, int end)
        throws SystemException {
        return findByFileTypeId_ApplicationDate(fileTypeId, applicationDate,
            start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId_ApplicationDate(
        String fileTypeId, Date applicationDate, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                applicationDate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID_APPLICATIONDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (applicationDate == null) {
                    query.append("applicationDate IS NULL");
                } else {
                    query.append("applicationDate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (applicationDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(applicationDate));
                }

                list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID_APPLICATIONDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlOneDoorReceiveFile findByFileTypeId_ApplicationDate_First(
        String fileTypeId, Date applicationDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByFileTypeId_ApplicationDate(fileTypeId,
                applicationDate, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("applicationDate=" + applicationDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByFileTypeId_ApplicationDate_Last(
        String fileTypeId, Date applicationDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByFileTypeId_ApplicationDate(fileTypeId,
                applicationDate);

        List<PmlOneDoorReceiveFile> list = findByFileTypeId_ApplicationDate(fileTypeId,
                applicationDate, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("applicationDate=" + applicationDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByFileTypeId_ApplicationDate_PrevAndNext(
        String fileId, String fileTypeId, Date applicationDate,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByFileTypeId_ApplicationDate(fileTypeId,
                applicationDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (fileTypeId == null) {
                query.append("fileTypeId LIKE null");
            } else {
                query.append("fileTypeId LIKE ?");
            }

            query.append(" AND ");

            if (applicationDate == null) {
                query.append("applicationDate IS NULL");
            } else {
                query.append("applicationDate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            if (applicationDate != null) {
                qPos.add(CalendarUtil.getTimestamp(applicationDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId_ExactReturningDate(
        String fileTypeId, Date exactReturningDate) throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId, exactReturningDate };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPEID_EXACTRETURNINGDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (exactReturningDate == null) {
                    query.append("exactReturningDate IS NULL");
                } else {
                    query.append("exactReturningDate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (exactReturningDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(exactReturningDate));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPEID_EXACTRETURNINGDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId_ExactReturningDate(
        String fileTypeId, Date exactReturningDate, int start, int end)
        throws SystemException {
        return findByFileTypeId_ExactReturningDate(fileTypeId,
            exactReturningDate, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId_ExactReturningDate(
        String fileTypeId, Date exactReturningDate, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                exactReturningDate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID_EXACTRETURNINGDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (exactReturningDate == null) {
                    query.append("exactReturningDate IS NULL");
                } else {
                    query.append("exactReturningDate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (exactReturningDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(exactReturningDate));
                }

                list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID_EXACTRETURNINGDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlOneDoorReceiveFile findByFileTypeId_ExactReturningDate_First(
        String fileTypeId, Date exactReturningDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByFileTypeId_ExactReturningDate(fileTypeId,
                exactReturningDate, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("exactReturningDate=" + exactReturningDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByFileTypeId_ExactReturningDate_Last(
        String fileTypeId, Date exactReturningDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByFileTypeId_ExactReturningDate(fileTypeId,
                exactReturningDate);

        List<PmlOneDoorReceiveFile> list = findByFileTypeId_ExactReturningDate(fileTypeId,
                exactReturningDate, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("exactReturningDate=" + exactReturningDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByFileTypeId_ExactReturningDate_PrevAndNext(
        String fileId, String fileTypeId, Date exactReturningDate,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByFileTypeId_ExactReturningDate(fileTypeId,
                exactReturningDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (fileTypeId == null) {
                query.append("fileTypeId LIKE null");
            } else {
                query.append("fileTypeId LIKE ?");
            }

            query.append(" AND ");

            if (exactReturningDate == null) {
                query.append("exactReturningDate IS NULL");
            } else {
                query.append("exactReturningDate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            if (exactReturningDate != null) {
                qPos.add(CalendarUtil.getTimestamp(exactReturningDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByFileType_NumberReceipt(
        String fileTypeId, String numberReceipt) throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId, numberReceipt };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPE_NUMBERRECEIPT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (numberReceipt == null) {
                    query.append("numberReceipt LIKE null");
                } else {
                    query.append("numberReceipt LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (numberReceipt != null) {
                    qPos.add(numberReceipt);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPE_NUMBERRECEIPT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlOneDoorReceiveFile> findByFileType_NumberReceipt(
        String fileTypeId, String numberReceipt, int start, int end)
        throws SystemException {
        return findByFileType_NumberReceipt(fileTypeId, numberReceipt, start,
            end, null);
    }

    public List<PmlOneDoorReceiveFile> findByFileType_NumberReceipt(
        String fileTypeId, String numberReceipt, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                numberReceipt,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPE_NUMBERRECEIPT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (numberReceipt == null) {
                    query.append("numberReceipt LIKE null");
                } else {
                    query.append("numberReceipt LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (numberReceipt != null) {
                    qPos.add(numberReceipt);
                }

                list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPE_NUMBERRECEIPT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlOneDoorReceiveFile findByFileType_NumberReceipt_First(
        String fileTypeId, String numberReceipt, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByFileType_NumberReceipt(fileTypeId,
                numberReceipt, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("numberReceipt=" + numberReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByFileType_NumberReceipt_Last(
        String fileTypeId, String numberReceipt, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByFileType_NumberReceipt(fileTypeId, numberReceipt);

        List<PmlOneDoorReceiveFile> list = findByFileType_NumberReceipt(fileTypeId,
                numberReceipt, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("numberReceipt=" + numberReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByFileType_NumberReceipt_PrevAndNext(
        String fileId, String fileTypeId, String numberReceipt,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByFileType_NumberReceipt(fileTypeId, numberReceipt);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (fileTypeId == null) {
                query.append("fileTypeId LIKE null");
            } else {
                query.append("fileTypeId LIKE ?");
            }

            query.append(" AND ");

            if (numberReceipt == null) {
                query.append("numberReceipt LIKE null");
            } else {
                query.append("numberReceipt LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            if (numberReceipt != null) {
                qPos.add(numberReceipt);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

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

    public List<PmlOneDoorReceiveFile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlOneDoorReceiveFile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlOneDoorReceiveFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByFileTypeId(String fileTypeId) throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByFileTypeId(
                fileTypeId)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByApplicationDate(Date applicationDate)
        throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByApplicationDate(
                applicationDate)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByApplicantName(String applicantName)
        throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByApplicantName(
                applicantName)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByOrganization(String organization)
        throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByOrganization(
                organization)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByPermanentAddress(String permanentAddress)
        throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByPermanentAddress(
                permanentAddress)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByAuthorisedLetter(String authorisedLetter)
        throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByAuthorisedLetter(
                authorisedLetter)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByDateCreated(Date dateCreated) throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByDateCreated(
                dateCreated)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByFileTypeId_ApplicationDate(String fileTypeId,
        Date applicationDate) throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByFileTypeId_ApplicationDate(
                fileTypeId, applicationDate)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByFileTypeId_ExactReturningDate(String fileTypeId,
        Date exactReturningDate) throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByFileTypeId_ExactReturningDate(
                fileTypeId, exactReturningDate)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByFileType_NumberReceipt(String fileTypeId,
        String numberReceipt) throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByFileType_NumberReceipt(
                fileTypeId, numberReceipt)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findAll()) {
            remove(pmlOneDoorReceiveFile);
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
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

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

    public int countByApplicationDate(Date applicationDate)
        throws SystemException {
        Object[] finderArgs = new Object[] { applicationDate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APPLICATIONDATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (applicationDate == null) {
                    query.append("applicationDate IS NULL");
                } else {
                    query.append("applicationDate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicationDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(applicationDate));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPLICATIONDATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByApplicantName(String applicantName)
        throws SystemException {
        Object[] finderArgs = new Object[] { applicantName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_APPLICANTNAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (applicantName == null) {
                    query.append("applicantName LIKE null");
                } else {
                    query.append("applicantName LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicantName != null) {
                    qPos.add(applicantName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_APPLICANTNAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByOrganization(String organization)
        throws SystemException {
        Object[] finderArgs = new Object[] { organization };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORGANIZATION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (organization == null) {
                    query.append("organization LIKE null");
                } else {
                    query.append("organization LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (organization != null) {
                    qPos.add(organization);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORGANIZATION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByPermanentAddress(String permanentAddress)
        throws SystemException {
        Object[] finderArgs = new Object[] { permanentAddress };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PERMANENTADDRESS,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (permanentAddress == null) {
                    query.append("permanentAddress LIKE null");
                } else {
                    query.append("permanentAddress LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (permanentAddress != null) {
                    qPos.add(permanentAddress);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PERMANENTADDRESS,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByAuthorisedLetter(String authorisedLetter)
        throws SystemException {
        Object[] finderArgs = new Object[] { authorisedLetter };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AUTHORISEDLETTER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (authorisedLetter == null) {
                    query.append("authorisedLetter LIKE null");
                } else {
                    query.append("authorisedLetter LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (authorisedLetter != null) {
                    qPos.add(authorisedLetter);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AUTHORISEDLETTER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDateCreated(Date dateCreated) throws SystemException {
        Object[] finderArgs = new Object[] { dateCreated };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DATECREATED,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (dateCreated == null) {
                    query.append("dateCreated IS NULL");
                } else {
                    query.append("dateCreated = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATECREATED,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileTypeId_ApplicationDate(String fileTypeId,
        Date applicationDate) throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId, applicationDate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILETYPEID_APPLICATIONDATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (applicationDate == null) {
                    query.append("applicationDate IS NULL");
                } else {
                    query.append("applicationDate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (applicationDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(applicationDate));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILETYPEID_APPLICATIONDATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileTypeId_ExactReturningDate(String fileTypeId,
        Date exactReturningDate) throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId, exactReturningDate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILETYPEID_EXACTRETURNINGDATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (exactReturningDate == null) {
                    query.append("exactReturningDate IS NULL");
                } else {
                    query.append("exactReturningDate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (exactReturningDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(exactReturningDate));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILETYPEID_EXACTRETURNINGDATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileType_NumberReceipt(String fileTypeId,
        String numberReceipt) throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId, numberReceipt };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILETYPE_NUMBERRECEIPT,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (numberReceipt == null) {
                    query.append("numberReceipt LIKE null");
                } else {
                    query.append("numberReceipt LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (numberReceipt != null) {
                    qPos.add(numberReceipt);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILETYPE_NUMBERRECEIPT,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile");

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
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlOneDoorReceiveFile>> listenersList = new ArrayList<ModelListener<PmlOneDoorReceiveFile>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlOneDoorReceiveFile>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
