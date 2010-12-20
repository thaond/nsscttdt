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

import com.nss.portlet.onedoor.NoSuchPmlPaintDocumentException;
import com.nss.portlet.onedoor.model.PmlPaintDocument;
import com.nss.portlet.onedoor.model.impl.PmlPaintDocumentImpl;
import com.nss.portlet.onedoor.model.impl.PmlPaintDocumentModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlPaintDocumentPersistenceImpl extends BasePersistenceImpl
    implements PmlPaintDocumentPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlPaintDocumentImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_QUANTITY = new FinderPath(PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
            PmlPaintDocumentModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByQuantity",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_QUANTITY = new FinderPath(PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
            PmlPaintDocumentModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByQuantity",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_QUANTITY = new FinderPath(PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
            PmlPaintDocumentModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByQuantity",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILEID = new FinderPath(PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
            PmlPaintDocumentModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILEID = new FinderPath(PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
            PmlPaintDocumentModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILEID = new FinderPath(PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
            PmlPaintDocumentModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
            PmlPaintDocumentModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
            PmlPaintDocumentModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlPaintDocumentPersistenceImpl.class);
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

    public void cacheResult(PmlPaintDocument pmlPaintDocument) {
        EntityCacheUtil.putResult(PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
            PmlPaintDocumentImpl.class, pmlPaintDocument.getPrimaryKey(),
            pmlPaintDocument);
    }

    public void cacheResult(List<PmlPaintDocument> pmlPaintDocuments) {
        for (PmlPaintDocument pmlPaintDocument : pmlPaintDocuments) {
            if (EntityCacheUtil.getResult(
                        PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
                        PmlPaintDocumentImpl.class,
                        pmlPaintDocument.getPrimaryKey(), this) == null) {
                cacheResult(pmlPaintDocument);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlPaintDocumentImpl.class.getName());
        EntityCacheUtil.clearCache(PmlPaintDocumentImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlPaintDocument create(long paintDocumentId) {
        PmlPaintDocument pmlPaintDocument = new PmlPaintDocumentImpl();

        pmlPaintDocument.setNew(true);
        pmlPaintDocument.setPrimaryKey(paintDocumentId);

        return pmlPaintDocument;
    }

    public PmlPaintDocument remove(long paintDocumentId)
        throws NoSuchPmlPaintDocumentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlPaintDocument pmlPaintDocument = (PmlPaintDocument) session.get(PmlPaintDocumentImpl.class,
                    new Long(paintDocumentId));

            if (pmlPaintDocument == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlPaintDocument exists with the primary key " +
                        paintDocumentId);
                }

                throw new NoSuchPmlPaintDocumentException(
                    "No PmlPaintDocument exists with the primary key " +
                    paintDocumentId);
            }

            return remove(pmlPaintDocument);
        } catch (NoSuchPmlPaintDocumentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlPaintDocument remove(PmlPaintDocument pmlPaintDocument)
        throws SystemException {
        for (ModelListener<PmlPaintDocument> listener : listeners) {
            listener.onBeforeRemove(pmlPaintDocument);
        }

        pmlPaintDocument = removeImpl(pmlPaintDocument);

        for (ModelListener<PmlPaintDocument> listener : listeners) {
            listener.onAfterRemove(pmlPaintDocument);
        }

        return pmlPaintDocument;
    }

    protected PmlPaintDocument removeImpl(PmlPaintDocument pmlPaintDocument)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlPaintDocument.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlPaintDocumentImpl.class,
                        pmlPaintDocument.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlPaintDocument);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
            PmlPaintDocumentImpl.class, pmlPaintDocument.getPrimaryKey());

        return pmlPaintDocument;
    }

    /**
     * @deprecated Use <code>update(PmlPaintDocument pmlPaintDocument, boolean merge)</code>.
     */
    public PmlPaintDocument update(PmlPaintDocument pmlPaintDocument)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlPaintDocument pmlPaintDocument) method. Use update(PmlPaintDocument pmlPaintDocument, boolean merge) instead.");
        }

        return update(pmlPaintDocument, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlPaintDocument the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlPaintDocument is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlPaintDocument update(PmlPaintDocument pmlPaintDocument,
        boolean merge) throws SystemException {
        boolean isNew = pmlPaintDocument.isNew();

        for (ModelListener<PmlPaintDocument> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlPaintDocument);
            } else {
                listener.onBeforeUpdate(pmlPaintDocument);
            }
        }

        pmlPaintDocument = updateImpl(pmlPaintDocument, merge);

        for (ModelListener<PmlPaintDocument> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlPaintDocument);
            } else {
                listener.onAfterUpdate(pmlPaintDocument);
            }
        }

        return pmlPaintDocument;
    }

    public PmlPaintDocument updateImpl(
        com.nss.portlet.onedoor.model.PmlPaintDocument pmlPaintDocument,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlPaintDocument, merge);

            pmlPaintDocument.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
            PmlPaintDocumentImpl.class, pmlPaintDocument.getPrimaryKey(),
            pmlPaintDocument);

        return pmlPaintDocument;
    }

    public PmlPaintDocument findByPrimaryKey(long paintDocumentId)
        throws NoSuchPmlPaintDocumentException, SystemException {
        PmlPaintDocument pmlPaintDocument = fetchByPrimaryKey(paintDocumentId);

        if (pmlPaintDocument == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlPaintDocument exists with the primary key " +
                    paintDocumentId);
            }

            throw new NoSuchPmlPaintDocumentException(
                "No PmlPaintDocument exists with the primary key " +
                paintDocumentId);
        }

        return pmlPaintDocument;
    }

    public PmlPaintDocument fetchByPrimaryKey(long paintDocumentId)
        throws SystemException {
        PmlPaintDocument pmlPaintDocument = (PmlPaintDocument) EntityCacheUtil.getResult(PmlPaintDocumentModelImpl.ENTITY_CACHE_ENABLED,
                PmlPaintDocumentImpl.class, paintDocumentId, this);

        if (pmlPaintDocument == null) {
            Session session = null;

            try {
                session = openSession();

                pmlPaintDocument = (PmlPaintDocument) session.get(PmlPaintDocumentImpl.class,
                        new Long(paintDocumentId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlPaintDocument != null) {
                    cacheResult(pmlPaintDocument);
                }

                closeSession(session);
            }
        }

        return pmlPaintDocument;
    }

    public List<PmlPaintDocument> findByQuantity(int quantity)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(quantity) };

        List<PmlPaintDocument> list = (List<PmlPaintDocument>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_QUANTITY,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlPaintDocument WHERE ");

                query.append("quantity = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("paintdocumentid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(quantity);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlPaintDocument>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_QUANTITY,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlPaintDocument> findByQuantity(int quantity, int start,
        int end) throws SystemException {
        return findByQuantity(quantity, start, end, null);
    }

    public List<PmlPaintDocument> findByQuantity(int quantity, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(quantity),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlPaintDocument> list = (List<PmlPaintDocument>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_QUANTITY,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlPaintDocument WHERE ");

                query.append("quantity = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("paintdocumentid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(quantity);

                list = (List<PmlPaintDocument>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlPaintDocument>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_QUANTITY,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlPaintDocument findByQuantity_First(int quantity,
        OrderByComparator obc)
        throws NoSuchPmlPaintDocumentException, SystemException {
        List<PmlPaintDocument> list = findByQuantity(quantity, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlPaintDocument exists with the key {");

            msg.append("quantity=" + quantity);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlPaintDocumentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlPaintDocument findByQuantity_Last(int quantity,
        OrderByComparator obc)
        throws NoSuchPmlPaintDocumentException, SystemException {
        int count = countByQuantity(quantity);

        List<PmlPaintDocument> list = findByQuantity(quantity, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlPaintDocument exists with the key {");

            msg.append("quantity=" + quantity);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlPaintDocumentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlPaintDocument[] findByQuantity_PrevAndNext(long paintDocumentId,
        int quantity, OrderByComparator obc)
        throws NoSuchPmlPaintDocumentException, SystemException {
        PmlPaintDocument pmlPaintDocument = findByPrimaryKey(paintDocumentId);

        int count = countByQuantity(quantity);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlPaintDocument WHERE ");

            query.append("quantity = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("paintdocumentid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(quantity);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlPaintDocument);

            PmlPaintDocument[] array = new PmlPaintDocumentImpl[3];

            array[0] = (PmlPaintDocument) objArray[0];
            array[1] = (PmlPaintDocument) objArray[1];
            array[2] = (PmlPaintDocument) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlPaintDocument> findByFileId(String fileId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileId };

        List<PmlPaintDocument> list = (List<PmlPaintDocument>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlPaintDocument WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("paintdocumentid DESC");

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
                    list = new ArrayList<PmlPaintDocument>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlPaintDocument> findByFileId(String fileId, int start, int end)
        throws SystemException {
        return findByFileId(fileId, start, end, null);
    }

    public List<PmlPaintDocument> findByFileId(String fileId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlPaintDocument> list = (List<PmlPaintDocument>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlPaintDocument WHERE ");

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

                    query.append("paintdocumentid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                list = (List<PmlPaintDocument>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlPaintDocument>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlPaintDocument findByFileId_First(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlPaintDocumentException, SystemException {
        List<PmlPaintDocument> list = findByFileId(fileId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlPaintDocument exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlPaintDocumentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlPaintDocument findByFileId_Last(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlPaintDocumentException, SystemException {
        int count = countByFileId(fileId);

        List<PmlPaintDocument> list = findByFileId(fileId, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlPaintDocument exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlPaintDocumentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlPaintDocument[] findByFileId_PrevAndNext(long paintDocumentId,
        String fileId, OrderByComparator obc)
        throws NoSuchPmlPaintDocumentException, SystemException {
        PmlPaintDocument pmlPaintDocument = findByPrimaryKey(paintDocumentId);

        int count = countByFileId(fileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlPaintDocument WHERE ");

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

                query.append("paintdocumentid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlPaintDocument);

            PmlPaintDocument[] array = new PmlPaintDocumentImpl[3];

            array[0] = (PmlPaintDocument) objArray[0];
            array[1] = (PmlPaintDocument) objArray[1];
            array[2] = (PmlPaintDocument) objArray[2];

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

    public List<PmlPaintDocument> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlPaintDocument> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlPaintDocument> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlPaintDocument> list = (List<PmlPaintDocument>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlPaintDocument ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("paintdocumentid DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlPaintDocument>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlPaintDocument>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlPaintDocument>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByQuantity(int quantity) throws SystemException {
        for (PmlPaintDocument pmlPaintDocument : findByQuantity(quantity)) {
            remove(pmlPaintDocument);
        }
    }

    public void removeByFileId(String fileId) throws SystemException {
        for (PmlPaintDocument pmlPaintDocument : findByFileId(fileId)) {
            remove(pmlPaintDocument);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlPaintDocument pmlPaintDocument : findAll()) {
            remove(pmlPaintDocument);
        }
    }

    public int countByQuantity(int quantity) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(quantity) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_QUANTITY,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlPaintDocument WHERE ");

                query.append("quantity = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(quantity);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_QUANTITY,
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
                    "FROM com.nss.portlet.onedoor.model.PmlPaintDocument WHERE ");

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
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlPaintDocument");

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
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlPaintDocument")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlPaintDocument>> listenersList = new ArrayList<ModelListener<PmlPaintDocument>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlPaintDocument>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
