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

import com.nss.portlet.onedoor.NoSuchPmlFilePCCCAttachedFileException;
import com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile;
import com.nss.portlet.onedoor.model.impl.PmlFilePCCCAttachedFileImpl;
import com.nss.portlet.onedoor.model.impl.PmlFilePCCCAttachedFileModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class PmlFilePCCCAttachedFilePersistenceImpl extends BasePersistenceImpl
    implements PmlFilePCCCAttachedFilePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlFilePCCCAttachedFileImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FILEPCCCID = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFilePcccId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILEPCCCID = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFilePcccId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILEPCCCID = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFilePcccId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBJECTTYPE = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByObjectType",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_OBJECTTYPE = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByObjectType",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_OBJECTTYPE = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByObjectType",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ATTACHEDFILENAME = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByAttachedFileName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ATTACHEDFILENAME = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByAttachedFileName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTACHEDFILENAME = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByAttachedFileName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_PATH = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByPath",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_PATH = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByPath",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_PATH = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByPath",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DATECREATED = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDateCreated",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DATECREATED = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDateCreated",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DATECREATED = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByDateCreated",
            new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPE = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileType",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPE = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileType",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPE = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileType",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILEPCCCID_OBJECTTYPE = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFilePcccId_ObjectType",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILEPCCCID_OBJECTTYPE =
        new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFilePcccId_ObjectType",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILEPCCCID_OBJECTTYPE = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFilePcccId_ObjectType",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlFilePCCCAttachedFilePersistenceImpl.class);
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

    public void cacheResult(PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile) {
        EntityCacheUtil.putResult(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileImpl.class,
            pmlFilePCCCAttachedFile.getPrimaryKey(), pmlFilePCCCAttachedFile);
    }

    public void cacheResult(
        List<PmlFilePCCCAttachedFile> pmlFilePCCCAttachedFiles) {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : pmlFilePCCCAttachedFiles) {
            if (EntityCacheUtil.getResult(
                        PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
                        PmlFilePCCCAttachedFileImpl.class,
                        pmlFilePCCCAttachedFile.getPrimaryKey(), this) == null) {
                cacheResult(pmlFilePCCCAttachedFile);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlFilePCCCAttachedFileImpl.class.getName());
        EntityCacheUtil.clearCache(PmlFilePCCCAttachedFileImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlFilePCCCAttachedFile create(long attachedFileId) {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = new PmlFilePCCCAttachedFileImpl();

        pmlFilePCCCAttachedFile.setNew(true);
        pmlFilePCCCAttachedFile.setPrimaryKey(attachedFileId);

        return pmlFilePCCCAttachedFile;
    }

    public PmlFilePCCCAttachedFile remove(long attachedFileId)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = (PmlFilePCCCAttachedFile) session.get(PmlFilePCCCAttachedFileImpl.class,
                    new Long(attachedFileId));

            if (pmlFilePCCCAttachedFile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlFilePCCCAttachedFile exists with the primary key " +
                        attachedFileId);
                }

                throw new NoSuchPmlFilePCCCAttachedFileException(
                    "No PmlFilePCCCAttachedFile exists with the primary key " +
                    attachedFileId);
            }

            return remove(pmlFilePCCCAttachedFile);
        } catch (NoSuchPmlFilePCCCAttachedFileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFilePCCCAttachedFile remove(
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws SystemException {
        for (ModelListener<PmlFilePCCCAttachedFile> listener : listeners) {
            listener.onBeforeRemove(pmlFilePCCCAttachedFile);
        }

        pmlFilePCCCAttachedFile = removeImpl(pmlFilePCCCAttachedFile);

        for (ModelListener<PmlFilePCCCAttachedFile> listener : listeners) {
            listener.onAfterRemove(pmlFilePCCCAttachedFile);
        }

        return pmlFilePCCCAttachedFile;
    }

    protected PmlFilePCCCAttachedFile removeImpl(
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlFilePCCCAttachedFile.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlFilePCCCAttachedFileImpl.class,
                        pmlFilePCCCAttachedFile.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlFilePCCCAttachedFile);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileImpl.class,
            pmlFilePCCCAttachedFile.getPrimaryKey());

        return pmlFilePCCCAttachedFile;
    }

    /**
     * @deprecated Use <code>update(PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile, boolean merge)</code>.
     */
    public PmlFilePCCCAttachedFile update(
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile) method. Use update(PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile, boolean merge) instead.");
        }

        return update(pmlFilePCCCAttachedFile, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFilePCCCAttachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFilePCCCAttachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFilePCCCAttachedFile update(
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile, boolean merge)
        throws SystemException {
        boolean isNew = pmlFilePCCCAttachedFile.isNew();

        for (ModelListener<PmlFilePCCCAttachedFile> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlFilePCCCAttachedFile);
            } else {
                listener.onBeforeUpdate(pmlFilePCCCAttachedFile);
            }
        }

        pmlFilePCCCAttachedFile = updateImpl(pmlFilePCCCAttachedFile, merge);

        for (ModelListener<PmlFilePCCCAttachedFile> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlFilePCCCAttachedFile);
            } else {
                listener.onAfterUpdate(pmlFilePCCCAttachedFile);
            }
        }

        return pmlFilePCCCAttachedFile;
    }

    public PmlFilePCCCAttachedFile updateImpl(
        com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlFilePCCCAttachedFile, merge);

            pmlFilePCCCAttachedFile.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFilePCCCAttachedFileImpl.class,
            pmlFilePCCCAttachedFile.getPrimaryKey(), pmlFilePCCCAttachedFile);

        return pmlFilePCCCAttachedFile;
    }

    public PmlFilePCCCAttachedFile findByPrimaryKey(long attachedFileId)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = fetchByPrimaryKey(attachedFileId);

        if (pmlFilePCCCAttachedFile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlFilePCCCAttachedFile exists with the primary key " +
                    attachedFileId);
            }

            throw new NoSuchPmlFilePCCCAttachedFileException(
                "No PmlFilePCCCAttachedFile exists with the primary key " +
                attachedFileId);
        }

        return pmlFilePCCCAttachedFile;
    }

    public PmlFilePCCCAttachedFile fetchByPrimaryKey(long attachedFileId)
        throws SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = (PmlFilePCCCAttachedFile) EntityCacheUtil.getResult(PmlFilePCCCAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
                PmlFilePCCCAttachedFileImpl.class, attachedFileId, this);

        if (pmlFilePCCCAttachedFile == null) {
            Session session = null;

            try {
                session = openSession();

                pmlFilePCCCAttachedFile = (PmlFilePCCCAttachedFile) session.get(PmlFilePCCCAttachedFileImpl.class,
                        new Long(attachedFileId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlFilePCCCAttachedFile != null) {
                    cacheResult(pmlFilePCCCAttachedFile);
                }

                closeSession(session);
            }
        }

        return pmlFilePCCCAttachedFile;
    }

    public List<PmlFilePCCCAttachedFile> findByFilePcccId(String filePcccId)
        throws SystemException {
        Object[] finderArgs = new Object[] { filePcccId };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILEPCCCID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (filePcccId == null) {
                    query.append("filepcccid LIKE null");
                } else {
                    query.append("filepcccid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (filePcccId != null) {
                    qPos.add(filePcccId);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILEPCCCID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFilePCCCAttachedFile> findByFilePcccId(String filePcccId,
        int start, int end) throws SystemException {
        return findByFilePcccId(filePcccId, start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findByFilePcccId(String filePcccId,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                filePcccId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILEPCCCID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (filePcccId == null) {
                    query.append("filepcccid LIKE null");
                } else {
                    query.append("filepcccid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (filePcccId != null) {
                    qPos.add(filePcccId);
                }

                list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILEPCCCID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFilePCCCAttachedFile findByFilePcccId_First(String filePcccId,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByFilePcccId(filePcccId, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("filePcccId=" + filePcccId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByFilePcccId_Last(String filePcccId,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        int count = countByFilePcccId(filePcccId);

        List<PmlFilePCCCAttachedFile> list = findByFilePcccId(filePcccId,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("filePcccId=" + filePcccId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByFilePcccId_PrevAndNext(
        long attachedFileId, String filePcccId, OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByFilePcccId(filePcccId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

            if (filePcccId == null) {
                query.append("filepcccid LIKE null");
            } else {
                query.append("filepcccid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (filePcccId != null) {
                qPos.add(filePcccId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByObjectType(String objectType)
        throws SystemException {
        Object[] finderArgs = new Object[] { objectType };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBJECTTYPE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (objectType == null) {
                    query.append("objecttype LIKE null");
                } else {
                    query.append("objecttype LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBJECTTYPE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFilePCCCAttachedFile> findByObjectType(String objectType,
        int start, int end) throws SystemException {
        return findByObjectType(objectType, start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findByObjectType(String objectType,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                objectType,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_OBJECTTYPE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (objectType == null) {
                    query.append("objecttype LIKE null");
                } else {
                    query.append("objecttype LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_OBJECTTYPE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFilePCCCAttachedFile findByObjectType_First(String objectType,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByObjectType(objectType, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByObjectType_Last(String objectType,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        int count = countByObjectType(objectType);

        List<PmlFilePCCCAttachedFile> list = findByObjectType(objectType,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByObjectType_PrevAndNext(
        long attachedFileId, String objectType, OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByObjectType(objectType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

            if (objectType == null) {
                query.append("objecttype LIKE null");
            } else {
                query.append("objecttype LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (objectType != null) {
                qPos.add(objectType);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByAttachedFileName(
        String attachedFileName) throws SystemException {
        Object[] finderArgs = new Object[] { attachedFileName };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ATTACHEDFILENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("attachedfilename LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ATTACHEDFILENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFilePCCCAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end) throws SystemException {
        return findByAttachedFileName(attachedFileName, start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("attachedfilename LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFilePCCCAttachedFile findByAttachedFileName_First(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByAttachedFileName(attachedFileName,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByAttachedFileName_Last(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        int count = countByAttachedFileName(attachedFileName);

        List<PmlFilePCCCAttachedFile> list = findByAttachedFileName(attachedFileName,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByAttachedFileName_PrevAndNext(
        long attachedFileId, String attachedFileName, OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByAttachedFileName(attachedFileName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

            if (attachedFileName == null) {
                query.append("attachedfilename LIKE null");
            } else {
                query.append("attachedfilename LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByPath(String path)
        throws SystemException {
        Object[] finderArgs = new Object[] { path };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PATH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (path == null) {
                    query.append("path LIKE null");
                } else {
                    query.append("path LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (path != null) {
                    qPos.add(path);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PATH, finderArgs,
                    list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFilePCCCAttachedFile> findByPath(String path, int start,
        int end) throws SystemException {
        return findByPath(path, start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findByPath(String path, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                path,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PATH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (path == null) {
                    query.append("path LIKE null");
                } else {
                    query.append("path LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (path != null) {
                    qPos.add(path);
                }

                list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PATH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFilePCCCAttachedFile findByPath_First(String path,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByPath(path, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("path=" + path);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByPath_Last(String path,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        int count = countByPath(path);

        List<PmlFilePCCCAttachedFile> list = findByPath(path, count - 1, count,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("path=" + path);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByPath_PrevAndNext(
        long attachedFileId, String path, OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByPath(path);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

            if (path == null) {
                query.append("path LIKE null");
            } else {
                query.append("path LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (path != null) {
                qPos.add(path);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByDateCreated(Date dateCreated)
        throws SystemException {
        Object[] finderArgs = new Object[] { dateCreated };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DATECREATED,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (dateCreated == null) {
                    query.append("datecreated IS NULL");
                } else {
                    query.append("datecreated = ?");
                }

                query.append(" ");

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
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DATECREATED,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFilePCCCAttachedFile> findByDateCreated(Date dateCreated,
        int start, int end) throws SystemException {
        return findByDateCreated(dateCreated, start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findByDateCreated(Date dateCreated,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                dateCreated,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DATECREATED,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (dateCreated == null) {
                    query.append("datecreated IS NULL");
                } else {
                    query.append("datecreated = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DATECREATED,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFilePCCCAttachedFile findByDateCreated_First(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByDateCreated(dateCreated, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByDateCreated_Last(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        int count = countByDateCreated(dateCreated);

        List<PmlFilePCCCAttachedFile> list = findByDateCreated(dateCreated,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByDateCreated_PrevAndNext(
        long attachedFileId, Date dateCreated, OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByDateCreated(dateCreated);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

            if (dateCreated == null) {
                query.append("datecreated IS NULL");
            } else {
                query.append("datecreated = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateCreated != null) {
                qPos.add(CalendarUtil.getTimestamp(dateCreated));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByFileType(String fileType)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileType };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (fileType == null) {
                    query.append("filetype LIKE null");
                } else {
                    query.append("filetype LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileType != null) {
                    qPos.add(fileType);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFilePCCCAttachedFile> findByFileType(String fileType,
        int start, int end) throws SystemException {
        return findByFileType(fileType, start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findByFileType(String fileType,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileType,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (fileType == null) {
                    query.append("filetype LIKE null");
                } else {
                    query.append("filetype LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileType != null) {
                    qPos.add(fileType);
                }

                list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFilePCCCAttachedFile findByFileType_First(String fileType,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByFileType(fileType, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("fileType=" + fileType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByFileType_Last(String fileType,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        int count = countByFileType(fileType);

        List<PmlFilePCCCAttachedFile> list = findByFileType(fileType,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("fileType=" + fileType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByFileType_PrevAndNext(
        long attachedFileId, String fileType, OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByFileType(fileType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

            if (fileType == null) {
                query.append("filetype LIKE null");
            } else {
                query.append("filetype LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileType != null) {
                qPos.add(fileType);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByFilePcccId_ObjectType(
        String filePcccId, String objectType) throws SystemException {
        Object[] finderArgs = new Object[] { filePcccId, objectType };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILEPCCCID_OBJECTTYPE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (filePcccId == null) {
                    query.append("filepcccid IS NULL");
                } else {
                    query.append("filepcccid = ?");
                }

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objecttype IS NULL");
                } else {
                    query.append("objecttype = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (filePcccId != null) {
                    qPos.add(filePcccId);
                }

                if (objectType != null) {
                    qPos.add(objectType);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILEPCCCID_OBJECTTYPE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFilePCCCAttachedFile> findByFilePcccId_ObjectType(
        String filePcccId, String objectType, int start, int end)
        throws SystemException {
        return findByFilePcccId_ObjectType(filePcccId, objectType, start, end,
            null);
    }

    public List<PmlFilePCCCAttachedFile> findByFilePcccId_ObjectType(
        String filePcccId, String objectType, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                filePcccId,
                
                objectType,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILEPCCCID_OBJECTTYPE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (filePcccId == null) {
                    query.append("filepcccid IS NULL");
                } else {
                    query.append("filepcccid = ?");
                }

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objecttype IS NULL");
                } else {
                    query.append("objecttype = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (filePcccId != null) {
                    qPos.add(filePcccId);
                }

                if (objectType != null) {
                    qPos.add(objectType);
                }

                list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILEPCCCID_OBJECTTYPE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFilePCCCAttachedFile findByFilePcccId_ObjectType_First(
        String filePcccId, String objectType, OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByFilePcccId_ObjectType(filePcccId,
                objectType, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("filePcccId=" + filePcccId);

            msg.append(", ");
            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByFilePcccId_ObjectType_Last(
        String filePcccId, String objectType, OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        int count = countByFilePcccId_ObjectType(filePcccId, objectType);

        List<PmlFilePCCCAttachedFile> list = findByFilePcccId_ObjectType(filePcccId,
                objectType, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("filePcccId=" + filePcccId);

            msg.append(", ");
            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFilePCCCAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByFilePcccId_ObjectType_PrevAndNext(
        long attachedFileId, String filePcccId, String objectType,
        OrderByComparator obc)
        throws NoSuchPmlFilePCCCAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByFilePcccId_ObjectType(filePcccId, objectType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

            if (filePcccId == null) {
                query.append("filepcccid IS NULL");
            } else {
                query.append("filepcccid = ?");
            }

            query.append(" AND ");

            if (objectType == null) {
                query.append("objecttype IS NULL");
            } else {
                query.append("objecttype = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (filePcccId != null) {
                qPos.add(filePcccId);
            }

            if (objectType != null) {
                qPos.add(objectType);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

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

    public List<PmlFilePCCCAttachedFile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFilePCCCAttachedFile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFilePCCCAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByFilePcccId(String filePcccId) throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByFilePcccId(
                filePcccId)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeByObjectType(String objectType) throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByObjectType(
                objectType)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeByAttachedFileName(String attachedFileName)
        throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByAttachedFileName(
                attachedFileName)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeByPath(String path) throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByPath(path)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeByDateCreated(Date dateCreated) throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByDateCreated(
                dateCreated)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeByFileType(String fileType) throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByFileType(
                fileType)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeByFilePcccId_ObjectType(String filePcccId,
        String objectType) throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByFilePcccId_ObjectType(
                filePcccId, objectType)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findAll()) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public int countByFilePcccId(String filePcccId) throws SystemException {
        Object[] finderArgs = new Object[] { filePcccId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILEPCCCID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (filePcccId == null) {
                    query.append("filepcccid LIKE null");
                } else {
                    query.append("filepcccid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (filePcccId != null) {
                    qPos.add(filePcccId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILEPCCCID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByObjectType(String objectType) throws SystemException {
        Object[] finderArgs = new Object[] { objectType };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_OBJECTTYPE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (objectType == null) {
                    query.append("objecttype LIKE null");
                } else {
                    query.append("objecttype LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_OBJECTTYPE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByAttachedFileName(String attachedFileName)
        throws SystemException {
        Object[] finderArgs = new Object[] { attachedFileName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ATTACHEDFILENAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("attachedfilename LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ATTACHEDFILENAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByPath(String path) throws SystemException {
        Object[] finderArgs = new Object[] { path };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PATH,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (path == null) {
                    query.append("path LIKE null");
                } else {
                    query.append("path LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (path != null) {
                    qPos.add(path);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PATH,
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
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (dateCreated == null) {
                    query.append("datecreated IS NULL");
                } else {
                    query.append("datecreated = ?");
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

    public int countByFileType(String fileType) throws SystemException {
        Object[] finderArgs = new Object[] { fileType };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILETYPE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (fileType == null) {
                    query.append("filetype LIKE null");
                } else {
                    query.append("filetype LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileType != null) {
                    qPos.add(fileType);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILETYPE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFilePcccId_ObjectType(String filePcccId, String objectType)
        throws SystemException {
        Object[] finderArgs = new Object[] { filePcccId, objectType };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILEPCCCID_OBJECTTYPE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile WHERE ");

                if (filePcccId == null) {
                    query.append("filepcccid IS NULL");
                } else {
                    query.append("filepcccid = ?");
                }

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objecttype IS NULL");
                } else {
                    query.append("objecttype = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (filePcccId != null) {
                    qPos.add(filePcccId);
                }

                if (objectType != null) {
                    qPos.add(objectType);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILEPCCCID_OBJECTTYPE,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile");

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
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlFilePCCCAttachedFile>> listenersList = new ArrayList<ModelListener<PmlFilePCCCAttachedFile>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlFilePCCCAttachedFile>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
