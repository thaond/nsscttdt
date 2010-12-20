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

import com.nss.portlet.filetype.NoSuchPmlFileAttachedFileException;
import com.nss.portlet.filetype.model.PmlFileAttachedFile;
import com.nss.portlet.filetype.model.impl.PmlFileAttachedFileImpl;
import com.nss.portlet.filetype.model.impl.PmlFileAttachedFileModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlFileAttachedFilePersistenceImpl extends BasePersistenceImpl
    implements PmlFileAttachedFilePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlFileAttachedFileImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FILEID = new FinderPath(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILEID = new FinderPath(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILEID = new FinderPath(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ATTACHEDFILEID = new FinderPath(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByAttachedFileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ATTACHEDFILEID = new FinderPath(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByAttachedFileId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTACHEDFILEID = new FinderPath(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByAttachedFileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ATTACHEDFILENAME = new FinderPath(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByAttachedFileName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ATTACHEDFILENAME = new FinderPath(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByAttachedFileName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTACHEDFILENAME = new FinderPath(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByAttachedFileName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlFileAttachedFilePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileTypePersistence.impl")
    protected com.nss.portlet.filetype.service.persistence.PmlFileTypePersistence pmlFileTypePersistence;
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileTypeAttachedFilePersistence.impl")
    protected com.nss.portlet.filetype.service.persistence.PmlFileTypeAttachedFilePersistence pmlFileTypeAttachedFilePersistence;
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileAttachedFilePersistence.impl")
    protected com.nss.portlet.filetype.service.persistence.PmlFileAttachedFilePersistence pmlFileAttachedFilePersistence;

    public void cacheResult(PmlFileAttachedFile pmlFileAttachedFile) {
        EntityCacheUtil.putResult(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileImpl.class, pmlFileAttachedFile.getPrimaryKey(),
            pmlFileAttachedFile);
    }

    public void cacheResult(List<PmlFileAttachedFile> pmlFileAttachedFiles) {
        for (PmlFileAttachedFile pmlFileAttachedFile : pmlFileAttachedFiles) {
            if (EntityCacheUtil.getResult(
                        PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
                        PmlFileAttachedFileImpl.class,
                        pmlFileAttachedFile.getPrimaryKey(), this) == null) {
                cacheResult(pmlFileAttachedFile);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlFileAttachedFileImpl.class.getName());
        EntityCacheUtil.clearCache(PmlFileAttachedFileImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlFileAttachedFile create(String fileAttachedFileId) {
        PmlFileAttachedFile pmlFileAttachedFile = new PmlFileAttachedFileImpl();

        pmlFileAttachedFile.setNew(true);
        pmlFileAttachedFile.setPrimaryKey(fileAttachedFileId);

        return pmlFileAttachedFile;
    }

    public PmlFileAttachedFile remove(String fileAttachedFileId)
        throws NoSuchPmlFileAttachedFileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileAttachedFile pmlFileAttachedFile = (PmlFileAttachedFile) session.get(PmlFileAttachedFileImpl.class,
                    fileAttachedFileId);

            if (pmlFileAttachedFile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlFileAttachedFile exists with the primary key " +
                        fileAttachedFileId);
                }

                throw new NoSuchPmlFileAttachedFileException(
                    "No PmlFileAttachedFile exists with the primary key " +
                    fileAttachedFileId);
            }

            return remove(pmlFileAttachedFile);
        } catch (NoSuchPmlFileAttachedFileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileAttachedFile remove(PmlFileAttachedFile pmlFileAttachedFile)
        throws SystemException {
        for (ModelListener<PmlFileAttachedFile> listener : listeners) {
            listener.onBeforeRemove(pmlFileAttachedFile);
        }

        pmlFileAttachedFile = removeImpl(pmlFileAttachedFile);

        for (ModelListener<PmlFileAttachedFile> listener : listeners) {
            listener.onAfterRemove(pmlFileAttachedFile);
        }

        return pmlFileAttachedFile;
    }

    protected PmlFileAttachedFile removeImpl(
        PmlFileAttachedFile pmlFileAttachedFile) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlFileAttachedFile.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlFileAttachedFileImpl.class,
                        pmlFileAttachedFile.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlFileAttachedFile);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileImpl.class, pmlFileAttachedFile.getPrimaryKey());

        return pmlFileAttachedFile;
    }

    /**
     * @deprecated Use <code>update(PmlFileAttachedFile pmlFileAttachedFile, boolean merge)</code>.
     */
    public PmlFileAttachedFile update(PmlFileAttachedFile pmlFileAttachedFile)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileAttachedFile pmlFileAttachedFile) method. Use update(PmlFileAttachedFile pmlFileAttachedFile, boolean merge) instead.");
        }

        return update(pmlFileAttachedFile, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileAttachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileAttachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileAttachedFile update(PmlFileAttachedFile pmlFileAttachedFile,
        boolean merge) throws SystemException {
        boolean isNew = pmlFileAttachedFile.isNew();

        for (ModelListener<PmlFileAttachedFile> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlFileAttachedFile);
            } else {
                listener.onBeforeUpdate(pmlFileAttachedFile);
            }
        }

        pmlFileAttachedFile = updateImpl(pmlFileAttachedFile, merge);

        for (ModelListener<PmlFileAttachedFile> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlFileAttachedFile);
            } else {
                listener.onAfterUpdate(pmlFileAttachedFile);
            }
        }

        return pmlFileAttachedFile;
    }

    public PmlFileAttachedFile updateImpl(
        com.nss.portlet.filetype.model.PmlFileAttachedFile pmlFileAttachedFile,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlFileAttachedFile, merge);

            pmlFileAttachedFile.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileAttachedFileImpl.class, pmlFileAttachedFile.getPrimaryKey(),
            pmlFileAttachedFile);

        return pmlFileAttachedFile;
    }

    public PmlFileAttachedFile findByPrimaryKey(String fileAttachedFileId)
        throws NoSuchPmlFileAttachedFileException, SystemException {
        PmlFileAttachedFile pmlFileAttachedFile = fetchByPrimaryKey(fileAttachedFileId);

        if (pmlFileAttachedFile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlFileAttachedFile exists with the primary key " +
                    fileAttachedFileId);
            }

            throw new NoSuchPmlFileAttachedFileException(
                "No PmlFileAttachedFile exists with the primary key " +
                fileAttachedFileId);
        }

        return pmlFileAttachedFile;
    }

    public PmlFileAttachedFile fetchByPrimaryKey(String fileAttachedFileId)
        throws SystemException {
        PmlFileAttachedFile pmlFileAttachedFile = (PmlFileAttachedFile) EntityCacheUtil.getResult(PmlFileAttachedFileModelImpl.ENTITY_CACHE_ENABLED,
                PmlFileAttachedFileImpl.class, fileAttachedFileId, this);

        if (pmlFileAttachedFile == null) {
            Session session = null;

            try {
                session = openSession();

                pmlFileAttachedFile = (PmlFileAttachedFile) session.get(PmlFileAttachedFileImpl.class,
                        fileAttachedFileId);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlFileAttachedFile != null) {
                    cacheResult(pmlFileAttachedFile);
                }

                closeSession(session);
            }
        }

        return pmlFileAttachedFile;
    }

    public List<PmlFileAttachedFile> findByFileId(String fileId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileId };

        List<PmlFileAttachedFile> list = (List<PmlFileAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile WHERE ");

                if (fileId == null) {
                    query.append("fileId LIKE null");
                } else {
                    query.append("fileId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileAttachedFileId DESC");

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
                    list = new ArrayList<PmlFileAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileAttachedFile> findByFileId(String fileId, int start,
        int end) throws SystemException {
        return findByFileId(fileId, start, end, null);
    }

    public List<PmlFileAttachedFile> findByFileId(String fileId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileAttachedFile> list = (List<PmlFileAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile WHERE ");

                if (fileId == null) {
                    query.append("fileId LIKE null");
                } else {
                    query.append("fileId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                list = (List<PmlFileAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileAttachedFile findByFileId_First(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlFileAttachedFileException, SystemException {
        List<PmlFileAttachedFile> list = findByFileId(fileId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileAttachedFile exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileAttachedFile findByFileId_Last(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlFileAttachedFileException, SystemException {
        int count = countByFileId(fileId);

        List<PmlFileAttachedFile> list = findByFileId(fileId, count - 1, count,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileAttachedFile exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileAttachedFile[] findByFileId_PrevAndNext(
        String fileAttachedFileId, String fileId, OrderByComparator obc)
        throws NoSuchPmlFileAttachedFileException, SystemException {
        PmlFileAttachedFile pmlFileAttachedFile = findByPrimaryKey(fileAttachedFileId);

        int count = countByFileId(fileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile WHERE ");

            if (fileId == null) {
                query.append("fileId LIKE null");
            } else {
                query.append("fileId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileAttachedFile);

            PmlFileAttachedFile[] array = new PmlFileAttachedFileImpl[3];

            array[0] = (PmlFileAttachedFile) objArray[0];
            array[1] = (PmlFileAttachedFile) objArray[1];
            array[2] = (PmlFileAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileAttachedFile> findByAttachedFileId(String attachedFileId)
        throws SystemException {
        Object[] finderArgs = new Object[] { attachedFileId };

        List<PmlFileAttachedFile> list = (List<PmlFileAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ATTACHEDFILEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile WHERE ");

                if (attachedFileId == null) {
                    query.append("attachedFileId LIKE null");
                } else {
                    query.append("attachedFileId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileAttachedFileId DESC");

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
                    list = new ArrayList<PmlFileAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ATTACHEDFILEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileAttachedFile> findByAttachedFileId(
        String attachedFileId, int start, int end) throws SystemException {
        return findByAttachedFileId(attachedFileId, start, end, null);
    }

    public List<PmlFileAttachedFile> findByAttachedFileId(
        String attachedFileId, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileAttachedFile> list = (List<PmlFileAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile WHERE ");

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

                    query.append("fileAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileId != null) {
                    qPos.add(attachedFileId);
                }

                list = (List<PmlFileAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileAttachedFile findByAttachedFileId_First(
        String attachedFileId, OrderByComparator obc)
        throws NoSuchPmlFileAttachedFileException, SystemException {
        List<PmlFileAttachedFile> list = findByAttachedFileId(attachedFileId,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileAttachedFile exists with the key {");

            msg.append("attachedFileId=" + attachedFileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileAttachedFile findByAttachedFileId_Last(
        String attachedFileId, OrderByComparator obc)
        throws NoSuchPmlFileAttachedFileException, SystemException {
        int count = countByAttachedFileId(attachedFileId);

        List<PmlFileAttachedFile> list = findByAttachedFileId(attachedFileId,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileAttachedFile exists with the key {");

            msg.append("attachedFileId=" + attachedFileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileAttachedFile[] findByAttachedFileId_PrevAndNext(
        String fileAttachedFileId, String attachedFileId, OrderByComparator obc)
        throws NoSuchPmlFileAttachedFileException, SystemException {
        PmlFileAttachedFile pmlFileAttachedFile = findByPrimaryKey(fileAttachedFileId);

        int count = countByAttachedFileId(attachedFileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile WHERE ");

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

                query.append("fileAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileId != null) {
                qPos.add(attachedFileId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileAttachedFile);

            PmlFileAttachedFile[] array = new PmlFileAttachedFileImpl[3];

            array[0] = (PmlFileAttachedFile) objArray[0];
            array[1] = (PmlFileAttachedFile) objArray[1];
            array[2] = (PmlFileAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileAttachedFile> findByAttachedFileName(
        String attachedFileName) throws SystemException {
        Object[] finderArgs = new Object[] { attachedFileName };

        List<PmlFileAttachedFile> list = (List<PmlFileAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ATTACHEDFILENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("attachedFileName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileAttachedFileId DESC");

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
                    list = new ArrayList<PmlFileAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ATTACHEDFILENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end) throws SystemException {
        return findByAttachedFileName(attachedFileName, start, end, null);
    }

    public List<PmlFileAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileAttachedFile> list = (List<PmlFileAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile WHERE ");

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

                    query.append("fileAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                list = (List<PmlFileAttachedFile>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileAttachedFile findByAttachedFileName_First(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchPmlFileAttachedFileException, SystemException {
        List<PmlFileAttachedFile> list = findByAttachedFileName(attachedFileName,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileAttachedFile findByAttachedFileName_Last(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchPmlFileAttachedFileException, SystemException {
        int count = countByAttachedFileName(attachedFileName);

        List<PmlFileAttachedFile> list = findByAttachedFileName(attachedFileName,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileAttachedFile[] findByAttachedFileName_PrevAndNext(
        String fileAttachedFileId, String attachedFileName,
        OrderByComparator obc)
        throws NoSuchPmlFileAttachedFileException, SystemException {
        PmlFileAttachedFile pmlFileAttachedFile = findByPrimaryKey(fileAttachedFileId);

        int count = countByAttachedFileName(attachedFileName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile WHERE ");

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

                query.append("fileAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileAttachedFile);

            PmlFileAttachedFile[] array = new PmlFileAttachedFileImpl[3];

            array[0] = (PmlFileAttachedFile) objArray[0];
            array[1] = (PmlFileAttachedFile) objArray[1];
            array[2] = (PmlFileAttachedFile) objArray[2];

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

    public List<PmlFileAttachedFile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileAttachedFile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileAttachedFile> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileAttachedFile> list = (List<PmlFileAttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlFileAttachedFile>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlFileAttachedFile>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileAttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByFileId(String fileId) throws SystemException {
        for (PmlFileAttachedFile pmlFileAttachedFile : findByFileId(fileId)) {
            remove(pmlFileAttachedFile);
        }
    }

    public void removeByAttachedFileId(String attachedFileId)
        throws SystemException {
        for (PmlFileAttachedFile pmlFileAttachedFile : findByAttachedFileId(
                attachedFileId)) {
            remove(pmlFileAttachedFile);
        }
    }

    public void removeByAttachedFileName(String attachedFileName)
        throws SystemException {
        for (PmlFileAttachedFile pmlFileAttachedFile : findByAttachedFileName(
                attachedFileName)) {
            remove(pmlFileAttachedFile);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFileAttachedFile pmlFileAttachedFile : findAll()) {
            remove(pmlFileAttachedFile);
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
                    "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile WHERE ");

                if (fileId == null) {
                    query.append("fileId LIKE null");
                } else {
                    query.append("fileId LIKE ?");
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
                    "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile WHERE ");

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
                    "FROM com.nss.portlet.filetype.model.PmlFileAttachedFile WHERE ");

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

    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.nss.portlet.filetype.model.PmlFileAttachedFile");

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
                        "value.object.listener.com.nss.portlet.filetype.model.PmlFileAttachedFile")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlFileAttachedFile>> listenersList = new ArrayList<ModelListener<PmlFileAttachedFile>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlFileAttachedFile>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
