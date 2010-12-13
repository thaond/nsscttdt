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

import com.nss.portlet.filetype.NoSuchPmlFileTypeException;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.model.impl.PmlFileTypeImpl;
import com.nss.portlet.filetype.model.impl.PmlFileTypeModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlFileTypePersistenceImpl extends BasePersistenceImpl
    implements PmlFileTypePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlFileTypeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPECODE = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileTypeCode", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPECODE = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileTypeCode",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPECODE = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFileTypeCode", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPENAME = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileTypeName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPENAME = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileTypeName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPENAME = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFileTypeName", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DESCRIPTION = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DESCRIPTION = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDescription",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDescription", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FIELDID = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFieldId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FIELDID = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFieldId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FIELDID = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFieldId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_RECEIPTTEMPLATE = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceiptTemplate", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_RECEIPTTEMPLATE = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceiptTemplate",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_RECEIPTTEMPLATE = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByReceiptTemplate", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPECODE_FILETYPENAME =
        new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileTypeCode_FileTypeName",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPECODE_FILETYPENAME =
        new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByFileTypeCode_FileTypeName",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPECODE_FILETYPENAME =
        new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByFileTypeCode_FileTypeName",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlFileTypePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileTypePersistence.impl")
    protected com.nss.portlet.filetype.service.persistence.PmlFileTypePersistence pmlFileTypePersistence;
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileTypeAttachedFilePersistence.impl")
    protected com.nss.portlet.filetype.service.persistence.PmlFileTypeAttachedFilePersistence pmlFileTypeAttachedFilePersistence;
    @BeanReference(name = "com.nss.portlet.filetype.service.persistence.PmlFileAttachedFilePersistence.impl")
    protected com.nss.portlet.filetype.service.persistence.PmlFileAttachedFilePersistence pmlFileAttachedFilePersistence;

    public void cacheResult(PmlFileType pmlFileType) {
        EntityCacheUtil.putResult(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeImpl.class, pmlFileType.getPrimaryKey(), pmlFileType);
    }

    public void cacheResult(List<PmlFileType> pmlFileTypes) {
        for (PmlFileType pmlFileType : pmlFileTypes) {
            if (EntityCacheUtil.getResult(
                        PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
                        PmlFileTypeImpl.class, pmlFileType.getPrimaryKey(), this) == null) {
                cacheResult(pmlFileType);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlFileTypeImpl.class.getName());
        EntityCacheUtil.clearCache(PmlFileTypeImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlFileType create(String fileTypeId) {
        PmlFileType pmlFileType = new PmlFileTypeImpl();

        pmlFileType.setNew(true);
        pmlFileType.setPrimaryKey(fileTypeId);

        return pmlFileType;
    }

    public PmlFileType remove(String fileTypeId)
        throws NoSuchPmlFileTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileType pmlFileType = (PmlFileType) session.get(PmlFileTypeImpl.class,
                    fileTypeId);

            if (pmlFileType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlFileType exists with the primary key " +
                        fileTypeId);
                }

                throw new NoSuchPmlFileTypeException(
                    "No PmlFileType exists with the primary key " + fileTypeId);
            }

            return remove(pmlFileType);
        } catch (NoSuchPmlFileTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileType remove(PmlFileType pmlFileType)
        throws SystemException {
        for (ModelListener<PmlFileType> listener : listeners) {
            listener.onBeforeRemove(pmlFileType);
        }

        pmlFileType = removeImpl(pmlFileType);

        for (ModelListener<PmlFileType> listener : listeners) {
            listener.onAfterRemove(pmlFileType);
        }

        return pmlFileType;
    }

    protected PmlFileType removeImpl(PmlFileType pmlFileType)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlFileType.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlFileTypeImpl.class,
                        pmlFileType.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlFileType);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeImpl.class, pmlFileType.getPrimaryKey());

        return pmlFileType;
    }

    /**
     * @deprecated Use <code>update(PmlFileType pmlFileType, boolean merge)</code>.
     */
    public PmlFileType update(PmlFileType pmlFileType)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileType pmlFileType) method. Use update(PmlFileType pmlFileType, boolean merge) instead.");
        }

        return update(pmlFileType, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileType update(PmlFileType pmlFileType, boolean merge)
        throws SystemException {
        boolean isNew = pmlFileType.isNew();

        for (ModelListener<PmlFileType> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlFileType);
            } else {
                listener.onBeforeUpdate(pmlFileType);
            }
        }

        pmlFileType = updateImpl(pmlFileType, merge);

        for (ModelListener<PmlFileType> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlFileType);
            } else {
                listener.onAfterUpdate(pmlFileType);
            }
        }

        return pmlFileType;
    }

    public PmlFileType updateImpl(
        com.nss.portlet.filetype.model.PmlFileType pmlFileType, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlFileType, merge);

            pmlFileType.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeImpl.class, pmlFileType.getPrimaryKey(), pmlFileType);

        return pmlFileType;
    }

    public PmlFileType findByPrimaryKey(String fileTypeId)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = fetchByPrimaryKey(fileTypeId);

        if (pmlFileType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlFileType exists with the primary key " +
                    fileTypeId);
            }

            throw new NoSuchPmlFileTypeException(
                "No PmlFileType exists with the primary key " + fileTypeId);
        }

        return pmlFileType;
    }

    public PmlFileType fetchByPrimaryKey(String fileTypeId)
        throws SystemException {
        PmlFileType pmlFileType = (PmlFileType) EntityCacheUtil.getResult(PmlFileTypeModelImpl.ENTITY_CACHE_ENABLED,
                PmlFileTypeImpl.class, fileTypeId, this);

        if (pmlFileType == null) {
            Session session = null;

            try {
                session = openSession();

                pmlFileType = (PmlFileType) session.get(PmlFileTypeImpl.class,
                        fileTypeId);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlFileType != null) {
                    cacheResult(pmlFileType);
                }

                closeSession(session);
            }
        }

        return pmlFileType;
    }

    public List<PmlFileType> findByFileTypeCode(String fileTypeCode)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeCode };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPECODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeCode == null) {
                    query.append("fileTypeCode LIKE null");
                } else {
                    query.append("lower(fileTypeCode) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileTypeName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeCode != null) {
                    qPos.add(fileTypeCode);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPECODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileType> findByFileTypeCode(String fileTypeCode, int start,
        int end) throws SystemException {
        return findByFileTypeCode(fileTypeCode, start, end, null);
    }

    public List<PmlFileType> findByFileTypeCode(String fileTypeCode, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeCode,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPECODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeCode == null) {
                    query.append("fileTypeCode LIKE null");
                } else {
                    query.append("lower(fileTypeCode) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeCode != null) {
                    qPos.add(fileTypeCode);
                }

                list = (List<PmlFileType>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPECODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileType findByFileTypeCode_First(String fileTypeCode,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        List<PmlFileType> list = findByFileTypeCode(fileTypeCode, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fileTypeCode=" + fileTypeCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType findByFileTypeCode_Last(String fileTypeCode,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        int count = countByFileTypeCode(fileTypeCode);

        List<PmlFileType> list = findByFileTypeCode(fileTypeCode, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fileTypeCode=" + fileTypeCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType[] findByFileTypeCode_PrevAndNext(String fileTypeId,
        String fileTypeCode, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = findByPrimaryKey(fileTypeId);

        int count = countByFileTypeCode(fileTypeCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

            if (fileTypeCode == null) {
                query.append("fileTypeCode LIKE null");
            } else {
                query.append("lower(fileTypeCode) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileTypeName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeCode != null) {
                qPos.add(fileTypeCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileType);

            PmlFileType[] array = new PmlFileTypeImpl[3];

            array[0] = (PmlFileType) objArray[0];
            array[1] = (PmlFileType) objArray[1];
            array[2] = (PmlFileType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileType> findByFileTypeName(String fileTypeName)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeName };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeName == null) {
                    query.append("fileTypeName LIKE null");
                } else {
                    query.append("lower(fileTypeName) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileTypeName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeName != null) {
                    qPos.add(fileTypeName);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileType> findByFileTypeName(String fileTypeName, int start,
        int end) throws SystemException {
        return findByFileTypeName(fileTypeName, start, end, null);
    }

    public List<PmlFileType> findByFileTypeName(String fileTypeName, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeName == null) {
                    query.append("fileTypeName LIKE null");
                } else {
                    query.append("lower(fileTypeName) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeName != null) {
                    qPos.add(fileTypeName);
                }

                list = (List<PmlFileType>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileType findByFileTypeName_First(String fileTypeName,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        List<PmlFileType> list = findByFileTypeName(fileTypeName, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fileTypeName=" + fileTypeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType findByFileTypeName_Last(String fileTypeName,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        int count = countByFileTypeName(fileTypeName);

        List<PmlFileType> list = findByFileTypeName(fileTypeName, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fileTypeName=" + fileTypeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType[] findByFileTypeName_PrevAndNext(String fileTypeId,
        String fileTypeName, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = findByPrimaryKey(fileTypeId);

        int count = countByFileTypeName(fileTypeName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

            if (fileTypeName == null) {
                query.append("fileTypeName LIKE null");
            } else {
                query.append("lower(fileTypeName) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileTypeName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeName != null) {
                qPos.add(fileTypeName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileType);

            PmlFileType[] array = new PmlFileTypeImpl[3];

            array[0] = (PmlFileType) objArray[0];
            array[1] = (PmlFileType) objArray[1];
            array[2] = (PmlFileType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileType> findByDescription(String description)
        throws SystemException {
        Object[] finderArgs = new Object[] { description };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("lower(description) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileTypeName ASC");

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
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileType> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<PmlFileType> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

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

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                list = (List<PmlFileType>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileType findByDescription_First(String description,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        List<PmlFileType> list = findByDescription(description, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType findByDescription_Last(String description,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        int count = countByDescription(description);

        List<PmlFileType> list = findByDescription(description, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType[] findByDescription_PrevAndNext(String fileTypeId,
        String description, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = findByPrimaryKey(fileTypeId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

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

                query.append("fileTypeName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileType);

            PmlFileType[] array = new PmlFileTypeImpl[3];

            array[0] = (PmlFileType) objArray[0];
            array[1] = (PmlFileType) objArray[1];
            array[2] = (PmlFileType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileType> findByFieldId(String fieldId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fieldId };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FIELDID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (fieldId == null) {
                    query.append("fieldId LIKE null");
                } else {
                    query.append("fieldId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileTypeName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldId != null) {
                    qPos.add(fieldId);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FIELDID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileType> findByFieldId(String fieldId, int start, int end)
        throws SystemException {
        return findByFieldId(fieldId, start, end, null);
    }

    public List<PmlFileType> findByFieldId(String fieldId, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fieldId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FIELDID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (fieldId == null) {
                    query.append("fieldId LIKE null");
                } else {
                    query.append("fieldId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldId != null) {
                    qPos.add(fieldId);
                }

                list = (List<PmlFileType>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FIELDID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileType findByFieldId_First(String fieldId, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        List<PmlFileType> list = findByFieldId(fieldId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fieldId=" + fieldId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType findByFieldId_Last(String fieldId, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        int count = countByFieldId(fieldId);

        List<PmlFileType> list = findByFieldId(fieldId, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fieldId=" + fieldId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType[] findByFieldId_PrevAndNext(String fileTypeId,
        String fieldId, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = findByPrimaryKey(fileTypeId);

        int count = countByFieldId(fieldId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

            if (fieldId == null) {
                query.append("fieldId LIKE null");
            } else {
                query.append("fieldId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileTypeName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fieldId != null) {
                qPos.add(fieldId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileType);

            PmlFileType[] array = new PmlFileTypeImpl[3];

            array[0] = (PmlFileType) objArray[0];
            array[1] = (PmlFileType) objArray[1];
            array[2] = (PmlFileType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileType> findByReceiptTemplate(String receiptTemplate)
        throws SystemException {
        Object[] finderArgs = new Object[] { receiptTemplate };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_RECEIPTTEMPLATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (receiptTemplate == null) {
                    query.append("receiptTemplate LIKE null");
                } else {
                    query.append("receiptTemplate LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileTypeName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiptTemplate != null) {
                    qPos.add(receiptTemplate);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_RECEIPTTEMPLATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileType> findByReceiptTemplate(String receiptTemplate,
        int start, int end) throws SystemException {
        return findByReceiptTemplate(receiptTemplate, start, end, null);
    }

    public List<PmlFileType> findByReceiptTemplate(String receiptTemplate,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                receiptTemplate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_RECEIPTTEMPLATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (receiptTemplate == null) {
                    query.append("receiptTemplate LIKE null");
                } else {
                    query.append("receiptTemplate LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiptTemplate != null) {
                    qPos.add(receiptTemplate);
                }

                list = (List<PmlFileType>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_RECEIPTTEMPLATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileType findByReceiptTemplate_First(String receiptTemplate,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        List<PmlFileType> list = findByReceiptTemplate(receiptTemplate, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("receiptTemplate=" + receiptTemplate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType findByReceiptTemplate_Last(String receiptTemplate,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        int count = countByReceiptTemplate(receiptTemplate);

        List<PmlFileType> list = findByReceiptTemplate(receiptTemplate,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("receiptTemplate=" + receiptTemplate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType[] findByReceiptTemplate_PrevAndNext(String fileTypeId,
        String receiptTemplate, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = findByPrimaryKey(fileTypeId);

        int count = countByReceiptTemplate(receiptTemplate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

            if (receiptTemplate == null) {
                query.append("receiptTemplate LIKE null");
            } else {
                query.append("receiptTemplate LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileTypeName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (receiptTemplate != null) {
                qPos.add(receiptTemplate);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileType);

            PmlFileType[] array = new PmlFileTypeImpl[3];

            array[0] = (PmlFileType) objArray[0];
            array[1] = (PmlFileType) objArray[1];
            array[2] = (PmlFileType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileType> findByFileTypeCode_FileTypeName(
        String fileTypeCode, String fileTypeName) throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeCode, fileTypeName };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPECODE_FILETYPENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeCode == null) {
                    query.append("fileTypeCode LIKE null");
                } else {
                    query.append("fileTypeCode LIKE ?");
                }

                query.append(" AND ");

                if (fileTypeName == null) {
                    query.append("fileTypeName LIKE null");
                } else {
                    query.append("fileTypeName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileTypeName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeCode != null) {
                    qPos.add(fileTypeCode);
                }

                if (fileTypeName != null) {
                    qPos.add(fileTypeName);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPECODE_FILETYPENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileType> findByFileTypeCode_FileTypeName(
        String fileTypeCode, String fileTypeName, int start, int end)
        throws SystemException {
        return findByFileTypeCode_FileTypeName(fileTypeCode, fileTypeName,
            start, end, null);
    }

    public List<PmlFileType> findByFileTypeCode_FileTypeName(
        String fileTypeCode, String fileTypeName, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeCode,
                
                fileTypeName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPECODE_FILETYPENAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeCode == null) {
                    query.append("fileTypeCode LIKE null");
                } else {
                    query.append("fileTypeCode LIKE ?");
                }

                query.append(" AND ");

                if (fileTypeName == null) {
                    query.append("fileTypeName LIKE null");
                } else {
                    query.append("fileTypeName LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeCode != null) {
                    qPos.add(fileTypeCode);
                }

                if (fileTypeName != null) {
                    qPos.add(fileTypeName);
                }

                list = (List<PmlFileType>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPECODE_FILETYPENAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileType findByFileTypeCode_FileTypeName_First(
        String fileTypeCode, String fileTypeName, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        List<PmlFileType> list = findByFileTypeCode_FileTypeName(fileTypeCode,
                fileTypeName, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fileTypeCode=" + fileTypeCode);

            msg.append(", ");
            msg.append("fileTypeName=" + fileTypeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType findByFileTypeCode_FileTypeName_Last(
        String fileTypeCode, String fileTypeName, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        int count = countByFileTypeCode_FileTypeName(fileTypeCode, fileTypeName);

        List<PmlFileType> list = findByFileTypeCode_FileTypeName(fileTypeCode,
                fileTypeName, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fileTypeCode=" + fileTypeCode);

            msg.append(", ");
            msg.append("fileTypeName=" + fileTypeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType[] findByFileTypeCode_FileTypeName_PrevAndNext(
        String fileTypeId, String fileTypeCode, String fileTypeName,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = findByPrimaryKey(fileTypeId);

        int count = countByFileTypeCode_FileTypeName(fileTypeCode, fileTypeName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

            if (fileTypeCode == null) {
                query.append("fileTypeCode LIKE null");
            } else {
                query.append("fileTypeCode LIKE ?");
            }

            query.append(" AND ");

            if (fileTypeName == null) {
                query.append("fileTypeName LIKE null");
            } else {
                query.append("fileTypeName LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileTypeName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeCode != null) {
                qPos.add(fileTypeCode);
            }

            if (fileTypeName != null) {
                qPos.add(fileTypeName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileType);

            PmlFileType[] array = new PmlFileTypeImpl[3];

            array[0] = (PmlFileType) objArray[0];
            array[1] = (PmlFileType) objArray[1];
            array[2] = (PmlFileType) objArray[2];

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

    public List<PmlFileType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileType> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileType> list = (List<PmlFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.filetype.model.PmlFileType ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlFileType>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlFileType>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByFileTypeCode(String fileTypeCode)
        throws SystemException {
        for (PmlFileType pmlFileType : findByFileTypeCode(fileTypeCode)) {
            remove(pmlFileType);
        }
    }

    public void removeByFileTypeName(String fileTypeName)
        throws SystemException {
        for (PmlFileType pmlFileType : findByFileTypeName(fileTypeName)) {
            remove(pmlFileType);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (PmlFileType pmlFileType : findByDescription(description)) {
            remove(pmlFileType);
        }
    }

    public void removeByFieldId(String fieldId) throws SystemException {
        for (PmlFileType pmlFileType : findByFieldId(fieldId)) {
            remove(pmlFileType);
        }
    }

    public void removeByReceiptTemplate(String receiptTemplate)
        throws SystemException {
        for (PmlFileType pmlFileType : findByReceiptTemplate(receiptTemplate)) {
            remove(pmlFileType);
        }
    }

    public void removeByFileTypeCode_FileTypeName(String fileTypeCode,
        String fileTypeName) throws SystemException {
        for (PmlFileType pmlFileType : findByFileTypeCode_FileTypeName(
                fileTypeCode, fileTypeName)) {
            remove(pmlFileType);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFileType pmlFileType : findAll()) {
            remove(pmlFileType);
        }
    }

    public int countByFileTypeCode(String fileTypeCode)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeCode };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILETYPECODE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeCode == null) {
                    query.append("fileTypeCode LIKE null");
                } else {
                    query.append("lower(fileTypeCode) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeCode != null) {
                    qPos.add(fileTypeCode);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILETYPECODE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileTypeName(String fileTypeName)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILETYPENAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeName == null) {
                    query.append("fileTypeName LIKE null");
                } else {
                    query.append("lower(fileTypeName) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeName != null) {
                    qPos.add(fileTypeName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILETYPENAME,
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
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

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

    public int countByFieldId(String fieldId) throws SystemException {
        Object[] finderArgs = new Object[] { fieldId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FIELDID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (fieldId == null) {
                    query.append("fieldId LIKE null");
                } else {
                    query.append("fieldId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldId != null) {
                    qPos.add(fieldId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FIELDID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByReceiptTemplate(String receiptTemplate)
        throws SystemException {
        Object[] finderArgs = new Object[] { receiptTemplate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RECEIPTTEMPLATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (receiptTemplate == null) {
                    query.append("receiptTemplate LIKE null");
                } else {
                    query.append("receiptTemplate LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiptTemplate != null) {
                    qPos.add(receiptTemplate);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIPTTEMPLATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileTypeCode_FileTypeName(String fileTypeCode,
        String fileTypeName) throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeCode, fileTypeName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILETYPECODE_FILETYPENAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeCode == null) {
                    query.append("fileTypeCode LIKE null");
                } else {
                    query.append("fileTypeCode LIKE ?");
                }

                query.append(" AND ");

                if (fileTypeName == null) {
                    query.append("fileTypeName LIKE null");
                } else {
                    query.append("fileTypeName LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeCode != null) {
                    qPos.add(fileTypeCode);
                }

                if (fileTypeName != null) {
                    qPos.add(fileTypeName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILETYPECODE_FILETYPENAME,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.filetype.model.PmlFileType");

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
                        "value.object.listener.com.nss.portlet.filetype.model.PmlFileType")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlFileType>> listenersList = new ArrayList<ModelListener<PmlFileType>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlFileType>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
