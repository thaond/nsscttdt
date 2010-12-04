package com.nss.portlet.filetype.service.persistence;

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

import com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException;
import com.nss.portlet.filetype.model.PmlFileTypeAttachedFile;
import com.nss.portlet.filetype.model.impl.PmlFileTypeAttachedFileImpl;
import com.nss.portlet.filetype.model.impl.PmlFileTypeAttachedFileModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlFileTypeAttachedFilePersistenceImpl extends BasePersistenceImpl
    implements PmlFileTypeAttachedFilePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlFileTypeAttachedFileImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPEID = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPEID = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPEID = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileTypeId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ATTACHEDFILEID = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByAttachedFileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ATTACHEDFILEID = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByAttachedFileId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTACHEDFILEID = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByAttachedFileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ATTACHEDFILENAME = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByAttachedFileName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ATTACHEDFILENAME = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByAttachedFileName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTACHEDFILENAME = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByAttachedFileName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ORIGINAL = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByOriginal",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORIGINAL = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByOriginal",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ORIGINAL = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByOriginal",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ORIGINAL_FT = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByOriginal_FT",
            new String[] { Integer.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ORIGINAL_FT = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByOriginal_FT",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ORIGINAL_FT = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByOriginal_FT",
            new String[] { Integer.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_COPY_ = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByCopy_",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_COPY_ = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByCopy_",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_COPY_ = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByCopy_",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_COPY_FT = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByCopy_FT",
            new String[] { Integer.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_COPY_FT = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByCopy_FT",
            new String[] {
                Integer.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_COPY_FT = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByCopy_FT",
            new String[] { Integer.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_NOTE = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByNote",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_NOTE = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByNote",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_NOTE = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByNote",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_NOTE_FT = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByNote_FT",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_NOTE_FT = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByNote_FT",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_NOTE_FT = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByNote_FT",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_N_O_C_N = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByN_O_C_N",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                Integer.class.getName(), String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_N_O_C_N = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByN_O_C_N",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                Integer.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_N_O_C_N = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByN_O_C_N",
            new String[] {
                String.class.getName(), Integer.class.getName(),
                Integer.class.getName(), String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_N_N = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByN_N",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_N_N = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByN_N",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_N_N = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByN_N",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlFileTypeAttachedFilePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileTypePersistence.impl")
    protected com.nss.portlet.filetype.service.persistence.PmlFileTypePersistence pmlFileTypePersistence;
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileTypeAttachedFilePersistence.impl")
    protected com.nss.portlet.filetype.service.persistence.PmlFileTypeAttachedFilePersistence pmlFileTypeAttachedFilePersistence;
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileAttachedFilePersistence.impl")
    protected com.nss.portlet.filetype.service.persistence.PmlFileAttachedFilePersistence pmlFileAttachedFilePersistence;

    public void cacheResult(PmlFileTypeAttachedFile pmlFileTypeAttachedFile) {
        EntityCacheUtil.putResult(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileImpl.class,
            pmlFileTypeAttachedFile.getPrimaryKey(), pmlFileTypeAttachedFile);
    }

    public void cacheResult(
        List<PmlFileTypeAttachedFile> pmlFileTypeAttachedFiles) {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : pmlFileTypeAttachedFiles) {
            if (EntityCacheUtil.getResult(
                        PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
                        PmlFileTypeAttachedFileImpl.class,
                        pmlFileTypeAttachedFile.getPrimaryKey(), this) == null) {
                cacheResult(pmlFileTypeAttachedFile);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlFileTypeAttachedFileImpl.class.getName());
        EntityCacheUtil.clearCache(PmlFileTypeAttachedFileImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlFileTypeAttachedFile create(String filetypeAttachedFileId) {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = new PmlFileTypeAttachedFileImpl();

        pmlFileTypeAttachedFile.setNew(true);
        pmlFileTypeAttachedFile.setPrimaryKey(filetypeAttachedFileId);

        return pmlFileTypeAttachedFile;
    }

    public PmlFileTypeAttachedFile remove(String filetypeAttachedFileId)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileTypeAttachedFile pmlFileTypeAttachedFile = (PmlFileTypeAttachedFile) session.get(PmlFileTypeAttachedFileImpl.class,
                    filetypeAttachedFileId);

            if (pmlFileTypeAttachedFile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlFileTypeAttachedFile exists with the primary key " +
                        filetypeAttachedFileId);
                }

                throw new NoSuchPmlFileTypeAttachedFileException(
                    "No PmlFileTypeAttachedFile exists with the primary key " +
                    filetypeAttachedFileId);
            }

            return remove(pmlFileTypeAttachedFile);
        } catch (NoSuchPmlFileTypeAttachedFileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileTypeAttachedFile remove(
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws SystemException {
        for (ModelListener<PmlFileTypeAttachedFile> listener : listeners) {
            listener.onBeforeRemove(pmlFileTypeAttachedFile);
        }

        pmlFileTypeAttachedFile = removeImpl(pmlFileTypeAttachedFile);

        for (ModelListener<PmlFileTypeAttachedFile> listener : listeners) {
            listener.onAfterRemove(pmlFileTypeAttachedFile);
        }

        return pmlFileTypeAttachedFile;
    }

    protected PmlFileTypeAttachedFile removeImpl(
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlFileTypeAttachedFile.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlFileTypeAttachedFileImpl.class,
                        pmlFileTypeAttachedFile.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlFileTypeAttachedFile);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileImpl.class,
            pmlFileTypeAttachedFile.getPrimaryKey());

        return pmlFileTypeAttachedFile;
    }

    /**
     * @deprecated Use <code>update(PmlFileTypeAttachedFile pmlFileTypeAttachedFile, boolean merge)</code>.
     */
    public PmlFileTypeAttachedFile update(
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileTypeAttachedFile pmlFileTypeAttachedFile) method. Use update(PmlFileTypeAttachedFile pmlFileTypeAttachedFile, boolean merge) instead.");
        }

        return update(pmlFileTypeAttachedFile, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileTypeAttachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileTypeAttachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileTypeAttachedFile update(
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile, boolean merge)
        throws SystemException {
        boolean isNew = pmlFileTypeAttachedFile.isNew();

        for (ModelListener<PmlFileTypeAttachedFile> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlFileTypeAttachedFile);
            } else {
                listener.onBeforeUpdate(pmlFileTypeAttachedFile);
            }
        }

        pmlFileTypeAttachedFile = updateImpl(pmlFileTypeAttachedFile, merge);

        for (ModelListener<PmlFileTypeAttachedFile> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlFileTypeAttachedFile);
            } else {
                listener.onAfterUpdate(pmlFileTypeAttachedFile);
            }
        }

        return pmlFileTypeAttachedFile;
    }

    public PmlFileTypeAttachedFile updateImpl(
        com.nss.portlet.filetype.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlFileTypeAttachedFile, merge);

            pmlFileTypeAttachedFile.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeAttachedFileImpl.class,
            pmlFileTypeAttachedFile.getPrimaryKey(), pmlFileTypeAttachedFile);

        return pmlFileTypeAttachedFile;
    }

    public PmlFileTypeAttachedFile findByPrimaryKey(
        String filetypeAttachedFileId)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = fetchByPrimaryKey(filetypeAttachedFileId);

        if (pmlFileTypeAttachedFile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlFileTypeAttachedFile exists with the primary key " +
                    filetypeAttachedFileId);
            }

            throw new NoSuchPmlFileTypeAttachedFileException(
                "No PmlFileTypeAttachedFile exists with the primary key " +
                filetypeAttachedFileId);
        }

        return pmlFileTypeAttachedFile;
    }

    public PmlFileTypeAttachedFile fetchByPrimaryKey(
        String filetypeAttachedFileId) throws SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = (PmlFileTypeAttachedFile) EntityCacheUtil.getResult(PmlFileTypeAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
                PmlFileTypeAttachedFileImpl.class, filetypeAttachedFileId, this);

        if (pmlFileTypeAttachedFile == null) {
            Session session = null;

            try {
                session = openSession();

                pmlFileTypeAttachedFile = (PmlFileTypeAttachedFile) session.get(PmlFileTypeAttachedFileImpl.class,
                        filetypeAttachedFileId);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlFileTypeAttachedFile != null) {
                    cacheResult(pmlFileTypeAttachedFile);
                }

                closeSession(session);
            }
        }

        return pmlFileTypeAttachedFile;
    }

    public List<PmlFileTypeAttachedFile> findByFileTypeId(String fileTypeId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

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
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeAttachedFile> findByFileTypeId(String fileTypeId,
        int start, int end) throws SystemException {
        return findByFileTypeId(fileTypeId, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByFileTypeId(String fileTypeId,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

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

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeAttachedFile findByFileTypeId_First(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByFileTypeId(fileTypeId, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByFileTypeId_Last(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        int count = countByFileTypeId(fileTypeId);

        List<PmlFileTypeAttachedFile> list = findByFileTypeId(fileTypeId,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByFileTypeId_PrevAndNext(
        String filetypeAttachedFileId, String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByFileTypeId(fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

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

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByAttachedFileId(
        String attachedFileId) throws SystemException {
        Object[] finderArgs = new Object[] { attachedFileId };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ATTACHEDFILEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileId == null) {
                    query.append("attachedFileId LIKE null");
                } else {
                    query.append("attachedFileId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileId != null) {
                    qPos.add(attachedFileId);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ATTACHEDFILEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeAttachedFile> findByAttachedFileId(
        String attachedFileId, int start, int end) throws SystemException {
        return findByAttachedFileId(attachedFileId, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByAttachedFileId(
        String attachedFileId, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileId == null) {
                    query.append("attachedFileId LIKE null");
                } else {
                    query.append("attachedFileId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileId != null) {
                    qPos.add(attachedFileId);
                }

                list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeAttachedFile findByAttachedFileId_First(
        String attachedFileId, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByAttachedFileId(attachedFileId,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileId=" + attachedFileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByAttachedFileId_Last(
        String attachedFileId, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        int count = countByAttachedFileId(attachedFileId);

        List<PmlFileTypeAttachedFile> list = findByAttachedFileId(attachedFileId,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileId=" + attachedFileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByAttachedFileId_PrevAndNext(
        String filetypeAttachedFileId, String attachedFileId,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByAttachedFileId(attachedFileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

            if (attachedFileId == null) {
                query.append("attachedFileId LIKE null");
            } else {
                query.append("attachedFileId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileId != null) {
                qPos.add(attachedFileId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByAttachedFileName(
        String attachedFileName) throws SystemException {
        Object[] finderArgs = new Object[] { attachedFileName };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ATTACHEDFILENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("attachedFileName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

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
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ATTACHEDFILENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end) throws SystemException {
        return findByAttachedFileName(attachedFileName, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("attachedFileName LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeAttachedFile findByAttachedFileName_First(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByAttachedFileName(attachedFileName,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByAttachedFileName_Last(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        int count = countByAttachedFileName(attachedFileName);

        List<PmlFileTypeAttachedFile> list = findByAttachedFileName(attachedFileName,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByAttachedFileName_PrevAndNext(
        String filetypeAttachedFileId, String attachedFileName,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByAttachedFileName(attachedFileName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

            if (attachedFileName == null) {
                query.append("attachedFileName LIKE null");
            } else {
                query.append("attachedFileName LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByOriginal(int original)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(original) };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORIGINAL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                query.append("original = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(original);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORIGINAL,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeAttachedFile> findByOriginal(int original,
        int start, int end) throws SystemException {
        return findByOriginal(original, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByOriginal(int original,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(original),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORIGINAL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                query.append("original = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(original);

                list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORIGINAL,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeAttachedFile findByOriginal_First(int original,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByOriginal(original, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("original=" + original);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByOriginal_Last(int original,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        int count = countByOriginal(original);

        List<PmlFileTypeAttachedFile> list = findByOriginal(original,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("original=" + original);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByOriginal_PrevAndNext(
        String filetypeAttachedFileId, int original, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByOriginal(original);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

            query.append("original = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(original);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByOriginal_FT(int original,
        String fileTypeId) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(original), fileTypeId };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ORIGINAL_FT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                query.append("original = ?");

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(original);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ORIGINAL_FT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeAttachedFile> findByOriginal_FT(int original,
        String fileTypeId, int start, int end) throws SystemException {
        return findByOriginal_FT(original, fileTypeId, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByOriginal_FT(int original,
        String fileTypeId, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(original),
                
                fileTypeId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ORIGINAL_FT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                query.append("original = ?");

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(original);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ORIGINAL_FT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeAttachedFile findByOriginal_FT_First(int original,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByOriginal_FT(original,
                fileTypeId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("original=" + original);

            msg.append(", ");
            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByOriginal_FT_Last(int original,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        int count = countByOriginal_FT(original, fileTypeId);

        List<PmlFileTypeAttachedFile> list = findByOriginal_FT(original,
                fileTypeId, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("original=" + original);

            msg.append(", ");
            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByOriginal_FT_PrevAndNext(
        String filetypeAttachedFileId, int original, String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByOriginal_FT(original, fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

            query.append("original = ?");

            query.append(" AND ");

            if (fileTypeId == null) {
                query.append("fileTypeId IS NULL");
            } else {
                query.append("fileTypeId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(original);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByCopy_(int copy_)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(copy_) };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COPY_,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                query.append("copy_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(copy_);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COPY_,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeAttachedFile> findByCopy_(int copy_, int start,
        int end) throws SystemException {
        return findByCopy_(copy_, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByCopy_(int copy_, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(copy_),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_COPY_,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                query.append("copy_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(copy_);

                list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_COPY_,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeAttachedFile findByCopy__First(int copy_,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByCopy_(copy_, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("copy_=" + copy_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByCopy__Last(int copy_,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        int count = countByCopy_(copy_);

        List<PmlFileTypeAttachedFile> list = findByCopy_(copy_, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("copy_=" + copy_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByCopy__PrevAndNext(
        String filetypeAttachedFileId, int copy_, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByCopy_(copy_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

            query.append("copy_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(copy_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByCopy_FT(int copy_,
        String fileTypeId) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(copy_), fileTypeId };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COPY_FT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                query.append("copy_ = ?");

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(copy_);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COPY_FT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeAttachedFile> findByCopy_FT(int copy_,
        String fileTypeId, int start, int end) throws SystemException {
        return findByCopy_FT(copy_, fileTypeId, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByCopy_FT(int copy_,
        String fileTypeId, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(copy_),
                
                fileTypeId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_COPY_FT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                query.append("copy_ = ?");

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(copy_);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_COPY_FT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeAttachedFile findByCopy_FT_First(int copy_,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByCopy_FT(copy_, fileTypeId,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("copy_=" + copy_);

            msg.append(", ");
            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByCopy_FT_Last(int copy_,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        int count = countByCopy_FT(copy_, fileTypeId);

        List<PmlFileTypeAttachedFile> list = findByCopy_FT(copy_, fileTypeId,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("copy_=" + copy_);

            msg.append(", ");
            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByCopy_FT_PrevAndNext(
        String filetypeAttachedFileId, int copy_, String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByCopy_FT(copy_, fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

            query.append("copy_ = ?");

            query.append(" AND ");

            if (fileTypeId == null) {
                query.append("fileTypeId IS NULL");
            } else {
                query.append("fileTypeId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(copy_);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByNote(String note)
        throws SystemException {
        Object[] finderArgs = new Object[] { note };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NOTE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

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
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NOTE, finderArgs,
                    list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeAttachedFile> findByNote(String note, int start,
        int end) throws SystemException {
        return findByNote(note, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByNote(String note, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                note,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NOTE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NOTE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeAttachedFile findByNote_First(String note,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByNote(note, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByNote_Last(String note,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        int count = countByNote(note);

        List<PmlFileTypeAttachedFile> list = findByNote(note, count - 1, count,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByNote_PrevAndNext(
        String filetypeAttachedFileId, String note, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByNote(note);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

            if (note == null) {
                query.append("note LIKE null");
            } else {
                query.append("lower(note) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (note != null) {
                qPos.add(note);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByNote_FT(String note,
        String fileTypeId) throws SystemException {
        Object[] finderArgs = new Object[] { note, fileTypeId };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NOTE_FT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NOTE_FT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeAttachedFile> findByNote_FT(String note,
        String fileTypeId, int start, int end) throws SystemException {
        return findByNote_FT(note, fileTypeId, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByNote_FT(String note,
        String fileTypeId, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                note,
                
                fileTypeId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NOTE_FT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NOTE_FT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeAttachedFile findByNote_FT_First(String note,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByNote_FT(note, fileTypeId, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("note=" + note);

            msg.append(", ");
            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByNote_FT_Last(String note,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        int count = countByNote_FT(note, fileTypeId);

        List<PmlFileTypeAttachedFile> list = findByNote_FT(note, fileTypeId,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("note=" + note);

            msg.append(", ");
            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByNote_FT_PrevAndNext(
        String filetypeAttachedFileId, String note, String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByNote_FT(note, fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

            if (note == null) {
                query.append("note LIKE null");
            } else {
                query.append("lower(note) LIKE ?");
            }

            query.append(" AND ");

            if (fileTypeId == null) {
                query.append("fileTypeId IS NULL");
            } else {
                query.append("fileTypeId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (note != null) {
                qPos.add(note);
            }

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByN_O_C_N(
        String attachedFileName, int original, int copy_, String note)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileName, new Integer(original), new Integer(copy_),
                
                note
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_N_O_C_N,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("lower(attachedFileName) LIKE ?");
                }

                query.append(" AND ");

                query.append("original = ?");

                query.append(" AND ");

                query.append("copy_ = ?");

                query.append(" AND ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                qPos.add(original);

                qPos.add(copy_);

                if (note != null) {
                    qPos.add(note);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_N_O_C_N,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeAttachedFile> findByN_O_C_N(
        String attachedFileName, int original, int copy_, String note,
        int start, int end) throws SystemException {
        return findByN_O_C_N(attachedFileName, original, copy_, note, start,
            end, null);
    }

    public List<PmlFileTypeAttachedFile> findByN_O_C_N(
        String attachedFileName, int original, int copy_, String note,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileName, new Integer(original), new Integer(copy_),
                
                note,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_N_O_C_N,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("lower(attachedFileName) LIKE ?");
                }

                query.append(" AND ");

                query.append("original = ?");

                query.append(" AND ");

                query.append("copy_ = ?");

                query.append(" AND ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                qPos.add(original);

                qPos.add(copy_);

                if (note != null) {
                    qPos.add(note);
                }

                list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_N_O_C_N,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeAttachedFile findByN_O_C_N_First(
        String attachedFileName, int original, int copy_, String note,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByN_O_C_N(attachedFileName,
                original, copy_, note, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(", ");
            msg.append("original=" + original);

            msg.append(", ");
            msg.append("copy_=" + copy_);

            msg.append(", ");
            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByN_O_C_N_Last(String attachedFileName,
        int original, int copy_, String note, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        int count = countByN_O_C_N(attachedFileName, original, copy_, note);

        List<PmlFileTypeAttachedFile> list = findByN_O_C_N(attachedFileName,
                original, copy_, note, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(", ");
            msg.append("original=" + original);

            msg.append(", ");
            msg.append("copy_=" + copy_);

            msg.append(", ");
            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByN_O_C_N_PrevAndNext(
        String filetypeAttachedFileId, String attachedFileName, int original,
        int copy_, String note, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByN_O_C_N(attachedFileName, original, copy_, note);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

            if (attachedFileName == null) {
                query.append("attachedFileName LIKE null");
            } else {
                query.append("lower(attachedFileName) LIKE ?");
            }

            query.append(" AND ");

            query.append("original = ?");

            query.append(" AND ");

            query.append("copy_ = ?");

            query.append(" AND ");

            if (note == null) {
                query.append("note LIKE null");
            } else {
                query.append("lower(note) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            qPos.add(original);

            qPos.add(copy_);

            if (note != null) {
                qPos.add(note);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByN_N(String attachedFileName,
        String note) throws SystemException {
        Object[] finderArgs = new Object[] { attachedFileName, note };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_N_N,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("lower(attachedFileName) LIKE ?");
                }

                query.append(" AND ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                if (note != null) {
                    qPos.add(note);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_N_N, finderArgs,
                    list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeAttachedFile> findByN_N(String attachedFileName,
        String note, int start, int end) throws SystemException {
        return findByN_N(attachedFileName, note, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByN_N(String attachedFileName,
        String note, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileName,
                
                note,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_N_N,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("lower(attachedFileName) LIKE ?");
                }

                query.append(" AND ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                if (note != null) {
                    qPos.add(note);
                }

                list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_N_N,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeAttachedFile findByN_N_First(String attachedFileName,
        String note, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByN_N(attachedFileName, note,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(", ");
            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByN_N_Last(String attachedFileName,
        String note, OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        int count = countByN_N(attachedFileName, note);

        List<PmlFileTypeAttachedFile> list = findByN_N(attachedFileName, note,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(", ");
            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByN_N_PrevAndNext(
        String filetypeAttachedFileId, String attachedFileName, String note,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByN_N(attachedFileName, note);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

            if (attachedFileName == null) {
                query.append("attachedFileName LIKE null");
            } else {
                query.append("lower(attachedFileName) LIKE ?");
            }

            query.append(" AND ");

            if (note == null) {
                query.append("note LIKE null");
            } else {
                query.append("lower(note) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            if (note != null) {
                qPos.add(note);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

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

    public List<PmlFileTypeAttachedFile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileTypeAttachedFile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByFileTypeId(String fileTypeId) throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByFileTypeId(
                fileTypeId)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByAttachedFileId(String attachedFileId)
        throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByAttachedFileId(
                attachedFileId)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByAttachedFileName(String attachedFileName)
        throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByAttachedFileName(
                attachedFileName)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByOriginal(int original) throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByOriginal(
                original)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByOriginal_FT(int original, String fileTypeId)
        throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByOriginal_FT(
                original, fileTypeId)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByCopy_(int copy_) throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByCopy_(
                copy_)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByCopy_FT(int copy_, String fileTypeId)
        throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByCopy_FT(
                copy_, fileTypeId)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByNote(String note) throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByNote(note)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByNote_FT(String note, String fileTypeId)
        throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByNote_FT(
                note, fileTypeId)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByN_O_C_N(String attachedFileName, int original,
        int copy_, String note) throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByN_O_C_N(
                attachedFileName, original, copy_, note)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByN_N(String attachedFileName, String note)
        throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByN_N(
                attachedFileName, note)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findAll()) {
            remove(pmlFileTypeAttachedFile);
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
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

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

    public int countByAttachedFileId(String attachedFileId)
        throws SystemException {
        Object[] finderArgs = new Object[] { attachedFileId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ATTACHEDFILEID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileId == null) {
                    query.append("attachedFileId LIKE null");
                } else {
                    query.append("attachedFileId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileId != null) {
                    qPos.add(attachedFileId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ATTACHEDFILEID,
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
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("attachedFileName LIKE ?");
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

    public int countByOriginal(int original) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(original) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORIGINAL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                query.append("original = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(original);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORIGINAL,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByOriginal_FT(int original, String fileTypeId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(original), fileTypeId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ORIGINAL_FT,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                query.append("original = ?");

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(original);

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

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ORIGINAL_FT,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByCopy_(int copy_) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(copy_) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COPY_,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                query.append("copy_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(copy_);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COPY_,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByCopy_FT(int copy_, String fileTypeId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(copy_), fileTypeId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COPY_FT,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                query.append("copy_ = ?");

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(copy_);

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

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COPY_FT,
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
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
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

    public int countByNote_FT(String note, String fileTypeId)
        throws SystemException {
        Object[] finderArgs = new Object[] { note, fileTypeId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NOTE_FT,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

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

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOTE_FT,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByN_O_C_N(String attachedFileName, int original, int copy_,
        String note) throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileName, new Integer(original), new Integer(copy_),
                
                note
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_N_O_C_N,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("lower(attachedFileName) LIKE ?");
                }

                query.append(" AND ");

                query.append("original = ?");

                query.append(" AND ");

                query.append("copy_ = ?");

                query.append(" AND ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                qPos.add(original);

                qPos.add(copy_);

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

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_N_O_C_N,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByN_N(String attachedFileName, String note)
        throws SystemException {
        Object[] finderArgs = new Object[] { attachedFileName, note };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_N_N,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("lower(attachedFileName) LIKE ?");
                }

                query.append(" AND ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

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

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_N_N, finderArgs,
                    count);

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
                        "SELECT COUNT(*) FROM com.nss.portlet.filetype.model.PmlFileTypeAttachedFile");

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
                        "value.object.listener.com.nss.portlet.filetype.model.PmlFileTypeAttachedFile")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlFileTypeAttachedFile>> listenersList = new ArrayList<ModelListener<PmlFileTypeAttachedFile>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlFileTypeAttachedFile>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
