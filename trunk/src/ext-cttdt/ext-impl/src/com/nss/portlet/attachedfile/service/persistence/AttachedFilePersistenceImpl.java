package com.nss.portlet.attachedfile.service.persistence;

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

import com.nss.portlet.attachedfile.NoSuchAttachedFileException;
import com.nss.portlet.attachedfile.model.AttachedFile;
import com.nss.portlet.attachedfile.model.impl.AttachedFileImpl;
import com.nss.portlet.attachedfile.model.impl.AttachedFileModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AttachedFilePersistenceImpl extends BasePersistenceImpl
    implements AttachedFilePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = AttachedFileImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ATTACHEDFILECODE = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAttachedFileCode", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ATTACHEDFILECODE = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAttachedFileCode",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTACHEDFILECODE = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByAttachedFileCode", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ATTACHEDFILENAME = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAttachedFileName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ATTACHEDFILENAME = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAttachedFileName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ATTACHEDFILENAME = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByAttachedFileName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DESCRIPTION = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DESCRIPTION = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_C_N_D = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByC_N_D",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_C_N_D = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByC_N_D",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_C_N_D = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByC_N_D",
            new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(AttachedFilePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.attachedfile.service.persistence.AttachedFilePersistence.impl")
    protected com.nss.portlet.attachedfile.service.persistence.AttachedFilePersistence attachedFilePersistence;

    public void cacheResult(AttachedFile attachedFile) {
        EntityCacheUtil.putResult(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileImpl.class, attachedFile.getPrimaryKey(), attachedFile);
    }

    public void cacheResult(List<AttachedFile> attachedFiles) {
        for (AttachedFile attachedFile : attachedFiles) {
            if (EntityCacheUtil.getResult(
                        AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
                        AttachedFileImpl.class, attachedFile.getPrimaryKey(),
                        this) == null) {
                cacheResult(attachedFile);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(AttachedFileImpl.class.getName());
        EntityCacheUtil.clearCache(AttachedFileImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public AttachedFile create(String attachedFileId) {
        AttachedFile attachedFile = new AttachedFileImpl();

        attachedFile.setNew(true);
        attachedFile.setPrimaryKey(attachedFileId);

        return attachedFile;
    }

    public AttachedFile remove(String attachedFileId)
        throws NoSuchAttachedFileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AttachedFile attachedFile = (AttachedFile) session.get(AttachedFileImpl.class,
                    attachedFileId);

            if (attachedFile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No AttachedFile exists with the primary key " +
                        attachedFileId);
                }

                throw new NoSuchAttachedFileException(
                    "No AttachedFile exists with the primary key " +
                    attachedFileId);
            }

            return remove(attachedFile);
        } catch (NoSuchAttachedFileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public AttachedFile remove(AttachedFile attachedFile)
        throws SystemException {
        for (ModelListener<AttachedFile> listener : listeners) {
            listener.onBeforeRemove(attachedFile);
        }

        attachedFile = removeImpl(attachedFile);

        for (ModelListener<AttachedFile> listener : listeners) {
            listener.onAfterRemove(attachedFile);
        }

        return attachedFile;
    }

    protected AttachedFile removeImpl(AttachedFile attachedFile)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (attachedFile.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(AttachedFileImpl.class,
                        attachedFile.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(attachedFile);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileImpl.class, attachedFile.getPrimaryKey());

        return attachedFile;
    }

    /**
     * @deprecated Use <code>update(AttachedFile attachedFile, boolean merge)</code>.
     */
    public AttachedFile update(AttachedFile attachedFile)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(AttachedFile attachedFile) method. Use update(AttachedFile attachedFile, boolean merge) instead.");
        }

        return update(attachedFile, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                attachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when attachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public AttachedFile update(AttachedFile attachedFile, boolean merge)
        throws SystemException {
        boolean isNew = attachedFile.isNew();

        for (ModelListener<AttachedFile> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(attachedFile);
            } else {
                listener.onBeforeUpdate(attachedFile);
            }
        }

        attachedFile = updateImpl(attachedFile, merge);

        for (ModelListener<AttachedFile> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(attachedFile);
            } else {
                listener.onAfterUpdate(attachedFile);
            }
        }

        return attachedFile;
    }

    public AttachedFile updateImpl(
        com.nss.portlet.attachedfile.model.AttachedFile attachedFile,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, attachedFile, merge);

            attachedFile.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
            AttachedFileImpl.class, attachedFile.getPrimaryKey(), attachedFile);

        return attachedFile;
    }

    public AttachedFile findByPrimaryKey(String attachedFileId)
        throws NoSuchAttachedFileException, SystemException {
        AttachedFile attachedFile = fetchByPrimaryKey(attachedFileId);

        if (attachedFile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No AttachedFile exists with the primary key " +
                    attachedFileId);
            }

            throw new NoSuchAttachedFileException(
                "No AttachedFile exists with the primary key " +
                attachedFileId);
        }

        return attachedFile;
    }

    public AttachedFile fetchByPrimaryKey(String attachedFileId)
        throws SystemException {
        AttachedFile attachedFile = (AttachedFile) EntityCacheUtil.getResult(AttachedFileModelImpl.ENTITY_CACHE_ENABLED,
                AttachedFileImpl.class, attachedFileId, this);

        if (attachedFile == null) {
            Session session = null;

            try {
                session = openSession();

                attachedFile = (AttachedFile) session.get(AttachedFileImpl.class,
                        attachedFileId);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (attachedFile != null) {
                    cacheResult(attachedFile);
                }

                closeSession(session);
            }
        }

        return attachedFile;
    }

    public List<AttachedFile> findByAttachedFileCode(String attachedFileCode)
        throws SystemException {
        Object[] finderArgs = new Object[] { attachedFileCode };

        List<AttachedFile> list = (List<AttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ATTACHEDFILECODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileCode == null) {
                    query.append("attachedfilecode LIKE null");
                } else {
                    query.append("lower(attachedfilecode) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("attachedfileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileCode != null) {
                    qPos.add(attachedFileCode);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<AttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ATTACHEDFILECODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<AttachedFile> findByAttachedFileCode(String attachedFileCode,
        int start, int end) throws SystemException {
        return findByAttachedFileCode(attachedFileCode, start, end, null);
    }

    public List<AttachedFile> findByAttachedFileCode(String attachedFileCode,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileCode,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<AttachedFile> list = (List<AttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILECODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileCode == null) {
                    query.append("attachedfilecode LIKE null");
                } else {
                    query.append("lower(attachedfilecode) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("attachedfileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileCode != null) {
                    qPos.add(attachedFileCode);
                }

                list = (List<AttachedFile>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<AttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILECODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public AttachedFile findByAttachedFileCode_First(String attachedFileCode,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<AttachedFile> list = findByAttachedFileCode(attachedFileCode, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("attachedFileCode=" + attachedFileCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile findByAttachedFileCode_Last(String attachedFileCode,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByAttachedFileCode(attachedFileCode);

        List<AttachedFile> list = findByAttachedFileCode(attachedFileCode,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("attachedFileCode=" + attachedFileCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile[] findByAttachedFileCode_PrevAndNext(
        String attachedFileId, String attachedFileCode, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        AttachedFile attachedFile = findByPrimaryKey(attachedFileId);

        int count = countByAttachedFileCode(attachedFileCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

            if (attachedFileCode == null) {
                query.append("attachedfilecode LIKE null");
            } else {
                query.append("lower(attachedfilecode) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("attachedfileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileCode != null) {
                qPos.add(attachedFileCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    attachedFile);

            AttachedFile[] array = new AttachedFileImpl[3];

            array[0] = (AttachedFile) objArray[0];
            array[1] = (AttachedFile) objArray[1];
            array[2] = (AttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<AttachedFile> findByAttachedFileName(String attachedFileName)
        throws SystemException {
        Object[] finderArgs = new Object[] { attachedFileName };

        List<AttachedFile> list = (List<AttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ATTACHEDFILENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("lower(attachedfilename) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("attachedfileid DESC");

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
                    list = new ArrayList<AttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ATTACHEDFILENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<AttachedFile> findByAttachedFileName(String attachedFileName,
        int start, int end) throws SystemException {
        return findByAttachedFileName(attachedFileName, start, end, null);
    }

    public List<AttachedFile> findByAttachedFileName(String attachedFileName,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<AttachedFile> list = (List<AttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("lower(attachedfilename) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("attachedfileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                list = (List<AttachedFile>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<AttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ATTACHEDFILENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public AttachedFile findByAttachedFileName_First(String attachedFileName,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<AttachedFile> list = findByAttachedFileName(attachedFileName, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile findByAttachedFileName_Last(String attachedFileName,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByAttachedFileName(attachedFileName);

        List<AttachedFile> list = findByAttachedFileName(attachedFileName,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile[] findByAttachedFileName_PrevAndNext(
        String attachedFileId, String attachedFileName, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        AttachedFile attachedFile = findByPrimaryKey(attachedFileId);

        int count = countByAttachedFileName(attachedFileName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

            if (attachedFileName == null) {
                query.append("attachedfilename LIKE null");
            } else {
                query.append("lower(attachedfilename) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("attachedfileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    attachedFile);

            AttachedFile[] array = new AttachedFileImpl[3];

            array[0] = (AttachedFile) objArray[0];
            array[1] = (AttachedFile) objArray[1];
            array[2] = (AttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<AttachedFile> findByDescription(String description)
        throws SystemException {
        Object[] finderArgs = new Object[] { description };

        List<AttachedFile> list = (List<AttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("lower(description) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("attachedfileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<AttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<AttachedFile> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<AttachedFile> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<AttachedFile> list = (List<AttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("lower(description) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("attachedfileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                list = (List<AttachedFile>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<AttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public AttachedFile findByDescription_First(String description,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<AttachedFile> list = findByDescription(description, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile findByDescription_Last(String description,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByDescription(description);

        List<AttachedFile> list = findByDescription(description, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile[] findByDescription_PrevAndNext(String attachedFileId,
        String description, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        AttachedFile attachedFile = findByPrimaryKey(attachedFileId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

            if (description == null) {
                query.append("description LIKE null");
            } else {
                query.append("lower(description) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("attachedfileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    attachedFile);

            AttachedFile[] array = new AttachedFileImpl[3];

            array[0] = (AttachedFile) objArray[0];
            array[1] = (AttachedFile) objArray[1];
            array[2] = (AttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<AttachedFile> findByC_N_D(String attachedFileCode,
        String attachedFileName, String description) throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileCode,
                
                attachedFileName,
                
                description
            };

        List<AttachedFile> list = (List<AttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_C_N_D,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileCode == null) {
                    query.append("attachedfilecode LIKE null");
                } else {
                    query.append("attachedfilecode LIKE ?");
                }

                query.append(" AND ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("attachedfilename LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("attachedfileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileCode != null) {
                    qPos.add(attachedFileCode);
                }

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<AttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_C_N_D,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<AttachedFile> findByC_N_D(String attachedFileCode,
        String attachedFileName, String description, int start, int end)
        throws SystemException {
        return findByC_N_D(attachedFileCode, attachedFileName, description,
            start, end, null);
    }

    public List<AttachedFile> findByC_N_D(String attachedFileCode,
        String attachedFileName, String description, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileCode,
                
                attachedFileName,
                
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<AttachedFile> list = (List<AttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_C_N_D,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileCode == null) {
                    query.append("attachedfilecode LIKE null");
                } else {
                    query.append("attachedfilecode LIKE ?");
                }

                query.append(" AND ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("attachedfilename LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("attachedfileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileCode != null) {
                    qPos.add(attachedFileCode);
                }

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                list = (List<AttachedFile>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<AttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_C_N_D,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public AttachedFile findByC_N_D_First(String attachedFileCode,
        String attachedFileName, String description, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<AttachedFile> list = findByC_N_D(attachedFileCode,
                attachedFileName, description, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("attachedFileCode=" + attachedFileCode);

            msg.append(", ");
            msg.append("attachedFileName=" + attachedFileName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile findByC_N_D_Last(String attachedFileCode,
        String attachedFileName, String description, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByC_N_D(attachedFileCode, attachedFileName, description);

        List<AttachedFile> list = findByC_N_D(attachedFileCode,
                attachedFileName, description, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("attachedFileCode=" + attachedFileCode);

            msg.append(", ");
            msg.append("attachedFileName=" + attachedFileName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile[] findByC_N_D_PrevAndNext(String attachedFileId,
        String attachedFileCode, String attachedFileName, String description,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        AttachedFile attachedFile = findByPrimaryKey(attachedFileId);

        int count = countByC_N_D(attachedFileCode, attachedFileName, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

            if (attachedFileCode == null) {
                query.append("attachedfilecode LIKE null");
            } else {
                query.append("attachedfilecode LIKE ?");
            }

            query.append(" AND ");

            if (attachedFileName == null) {
                query.append("attachedfilename LIKE null");
            } else {
                query.append("attachedfilename LIKE ?");
            }

            query.append(" AND ");

            if (description == null) {
                query.append("description LIKE null");
            } else {
                query.append("description LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("attachedfileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileCode != null) {
                qPos.add(attachedFileCode);
            }

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    attachedFile);

            AttachedFile[] array = new AttachedFileImpl[3];

            array[0] = (AttachedFile) objArray[0];
            array[1] = (AttachedFile) objArray[1];
            array[2] = (AttachedFile) objArray[2];

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

    public List<AttachedFile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<AttachedFile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<AttachedFile> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<AttachedFile> list = (List<AttachedFile>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("attachedfileid DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<AttachedFile>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<AttachedFile>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<AttachedFile>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByAttachedFileCode(String attachedFileCode)
        throws SystemException {
        for (AttachedFile attachedFile : findByAttachedFileCode(
                attachedFileCode)) {
            remove(attachedFile);
        }
    }

    public void removeByAttachedFileName(String attachedFileName)
        throws SystemException {
        for (AttachedFile attachedFile : findByAttachedFileName(
                attachedFileName)) {
            remove(attachedFile);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (AttachedFile attachedFile : findByDescription(description)) {
            remove(attachedFile);
        }
    }

    public void removeByC_N_D(String attachedFileCode, String attachedFileName,
        String description) throws SystemException {
        for (AttachedFile attachedFile : findByC_N_D(attachedFileCode,
                attachedFileName, description)) {
            remove(attachedFile);
        }
    }

    public void removeAll() throws SystemException {
        for (AttachedFile attachedFile : findAll()) {
            remove(attachedFile);
        }
    }

    public int countByAttachedFileCode(String attachedFileCode)
        throws SystemException {
        Object[] finderArgs = new Object[] { attachedFileCode };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ATTACHEDFILECODE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileCode == null) {
                    query.append("attachedfilecode LIKE null");
                } else {
                    query.append("lower(attachedfilecode) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileCode != null) {
                    qPos.add(attachedFileCode);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ATTACHEDFILECODE,
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
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("lower(attachedfilename) LIKE ?");
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

    public int countByDescription(String description) throws SystemException {
        Object[] finderArgs = new Object[] { description };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("lower(description) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DESCRIPTION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByC_N_D(String attachedFileCode, String attachedFileName,
        String description) throws SystemException {
        Object[] finderArgs = new Object[] {
                attachedFileCode,
                
                attachedFileName,
                
                description
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_N_D,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileCode == null) {
                    query.append("attachedfilecode LIKE null");
                } else {
                    query.append("attachedfilecode LIKE ?");
                }

                query.append(" AND ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("attachedfilename LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileCode != null) {
                    qPos.add(attachedFileCode);
                }

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_N_D,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.attachedfile.model.AttachedFile");

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
                        "value.object.listener.com.nss.portlet.attachedfile.model.AttachedFile")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<AttachedFile>> listenersList = new ArrayList<ModelListener<AttachedFile>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<AttachedFile>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
