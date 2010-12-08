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

import com.nss.portlet.onedoor.NoSuchPmlFileStatusException;
import com.nss.portlet.onedoor.model.PmlFileStatus;
import com.nss.portlet.onedoor.model.impl.PmlFileStatusImpl;
import com.nss.portlet.onedoor.model.impl.PmlFileStatusModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlFileStatusPersistenceImpl extends BasePersistenceImpl
    implements PmlFileStatusPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlFileStatusImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FILESTATUSCODE = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileStatusCode",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILESTATUSCODE = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileStatusCode",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILESTATUSCODE = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileStatusCode",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILESTATUSNAME = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileStatusName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILESTATUSNAME = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileStatusName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILESTATUSNAME = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileStatusName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DESCRIPTION = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDescription",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DESCRIPTION = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDescription",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByDescription",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_TYPE = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByType",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_TYPE = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByType",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByType",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILESTATUSCODE_TYPE = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileStatusCode_Type",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILESTATUSCODE_TYPE = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileStatusCode_Type",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILESTATUSCODE_TYPE = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileStatusCode_Type",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlFileStatusPersistenceImpl.class);
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

    public void cacheResult(PmlFileStatus pmlFileStatus) {
        EntityCacheUtil.putResult(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusImpl.class, pmlFileStatus.getPrimaryKey(),
            pmlFileStatus);
    }

    public void cacheResult(List<PmlFileStatus> pmlFileStatuses) {
        for (PmlFileStatus pmlFileStatus : pmlFileStatuses) {
            if (EntityCacheUtil.getResult(
                        PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
                        PmlFileStatusImpl.class, pmlFileStatus.getPrimaryKey(),
                        this) == null) {
                cacheResult(pmlFileStatus);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlFileStatusImpl.class.getName());
        EntityCacheUtil.clearCache(PmlFileStatusImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlFileStatus create(long fileStatusId) {
        PmlFileStatus pmlFileStatus = new PmlFileStatusImpl();

        pmlFileStatus.setNew(true);
        pmlFileStatus.setPrimaryKey(fileStatusId);

        return pmlFileStatus;
    }

    public PmlFileStatus remove(long fileStatusId)
        throws NoSuchPmlFileStatusException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileStatus pmlFileStatus = (PmlFileStatus) session.get(PmlFileStatusImpl.class,
                    new Long(fileStatusId));

            if (pmlFileStatus == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlFileStatus exists with the primary key " +
                        fileStatusId);
                }

                throw new NoSuchPmlFileStatusException(
                    "No PmlFileStatus exists with the primary key " +
                    fileStatusId);
            }

            return remove(pmlFileStatus);
        } catch (NoSuchPmlFileStatusException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileStatus remove(PmlFileStatus pmlFileStatus)
        throws SystemException {
        for (ModelListener<PmlFileStatus> listener : listeners) {
            listener.onBeforeRemove(pmlFileStatus);
        }

        pmlFileStatus = removeImpl(pmlFileStatus);

        for (ModelListener<PmlFileStatus> listener : listeners) {
            listener.onAfterRemove(pmlFileStatus);
        }

        return pmlFileStatus;
    }

    protected PmlFileStatus removeImpl(PmlFileStatus pmlFileStatus)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlFileStatus.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlFileStatusImpl.class,
                        pmlFileStatus.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlFileStatus);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusImpl.class, pmlFileStatus.getPrimaryKey());

        return pmlFileStatus;
    }

    /**
     * @deprecated Use <code>update(PmlFileStatus pmlFileStatus, boolean merge)</code>.
     */
    public PmlFileStatus update(PmlFileStatus pmlFileStatus)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileStatus pmlFileStatus) method. Use update(PmlFileStatus pmlFileStatus, boolean merge) instead.");
        }

        return update(pmlFileStatus, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileStatus the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileStatus is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileStatus update(PmlFileStatus pmlFileStatus, boolean merge)
        throws SystemException {
        boolean isNew = pmlFileStatus.isNew();

        for (ModelListener<PmlFileStatus> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlFileStatus);
            } else {
                listener.onBeforeUpdate(pmlFileStatus);
            }
        }

        pmlFileStatus = updateImpl(pmlFileStatus, merge);

        for (ModelListener<PmlFileStatus> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlFileStatus);
            } else {
                listener.onAfterUpdate(pmlFileStatus);
            }
        }

        return pmlFileStatus;
    }

    public PmlFileStatus updateImpl(
        com.nss.portlet.onedoor.model.PmlFileStatus pmlFileStatus, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlFileStatus, merge);

            pmlFileStatus.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileStatusImpl.class, pmlFileStatus.getPrimaryKey(),
            pmlFileStatus);

        return pmlFileStatus;
    }

    public PmlFileStatus findByPrimaryKey(long fileStatusId)
        throws NoSuchPmlFileStatusException, SystemException {
        PmlFileStatus pmlFileStatus = fetchByPrimaryKey(fileStatusId);

        if (pmlFileStatus == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlFileStatus exists with the primary key " +
                    fileStatusId);
            }

            throw new NoSuchPmlFileStatusException(
                "No PmlFileStatus exists with the primary key " + fileStatusId);
        }

        return pmlFileStatus;
    }

    public PmlFileStatus fetchByPrimaryKey(long fileStatusId)
        throws SystemException {
        PmlFileStatus pmlFileStatus = (PmlFileStatus) EntityCacheUtil.getResult(PmlFileStatusModelImpl.ENTITY_CACHE_ENABLED,
                PmlFileStatusImpl.class, fileStatusId, this);

        if (pmlFileStatus == null) {
            Session session = null;

            try {
                session = openSession();

                pmlFileStatus = (PmlFileStatus) session.get(PmlFileStatusImpl.class,
                        new Long(fileStatusId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlFileStatus != null) {
                    cacheResult(pmlFileStatus);
                }

                closeSession(session);
            }
        }

        return pmlFileStatus;
    }

    public List<PmlFileStatus> findByFileStatusCode(String fileStatusCode)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileStatusCode };

        List<PmlFileStatus> list = (List<PmlFileStatus>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILESTATUSCODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (fileStatusCode == null) {
                    query.append("filestatuscode LIKE null");
                } else {
                    query.append("filestatuscode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filestatusid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusCode != null) {
                    qPos.add(fileStatusCode);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatus>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILESTATUSCODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileStatus> findByFileStatusCode(String fileStatusCode,
        int start, int end) throws SystemException {
        return findByFileStatusCode(fileStatusCode, start, end, null);
    }

    public List<PmlFileStatus> findByFileStatusCode(String fileStatusCode,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileStatusCode,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileStatus> list = (List<PmlFileStatus>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILESTATUSCODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (fileStatusCode == null) {
                    query.append("filestatuscode LIKE null");
                } else {
                    query.append("filestatuscode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filestatusid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusCode != null) {
                    qPos.add(fileStatusCode);
                }

                list = (List<PmlFileStatus>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatus>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILESTATUSCODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileStatus findByFileStatusCode_First(String fileStatusCode,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        List<PmlFileStatus> list = findByFileStatusCode(fileStatusCode, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("fileStatusCode=" + fileStatusCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus findByFileStatusCode_Last(String fileStatusCode,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        int count = countByFileStatusCode(fileStatusCode);

        List<PmlFileStatus> list = findByFileStatusCode(fileStatusCode,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("fileStatusCode=" + fileStatusCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus[] findByFileStatusCode_PrevAndNext(long fileStatusId,
        String fileStatusCode, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        PmlFileStatus pmlFileStatus = findByPrimaryKey(fileStatusId);

        int count = countByFileStatusCode(fileStatusCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

            if (fileStatusCode == null) {
                query.append("filestatuscode LIKE null");
            } else {
                query.append("filestatuscode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filestatusid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileStatusCode != null) {
                qPos.add(fileStatusCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatus);

            PmlFileStatus[] array = new PmlFileStatusImpl[3];

            array[0] = (PmlFileStatus) objArray[0];
            array[1] = (PmlFileStatus) objArray[1];
            array[2] = (PmlFileStatus) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileStatus> findByFileStatusName(String fileStatusName)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileStatusName };

        List<PmlFileStatus> list = (List<PmlFileStatus>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILESTATUSNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (fileStatusName == null) {
                    query.append("filestatusname LIKE null");
                } else {
                    query.append("filestatusname LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filestatusid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusName != null) {
                    qPos.add(fileStatusName);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatus>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILESTATUSNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileStatus> findByFileStatusName(String fileStatusName,
        int start, int end) throws SystemException {
        return findByFileStatusName(fileStatusName, start, end, null);
    }

    public List<PmlFileStatus> findByFileStatusName(String fileStatusName,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileStatusName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileStatus> list = (List<PmlFileStatus>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILESTATUSNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (fileStatusName == null) {
                    query.append("filestatusname LIKE null");
                } else {
                    query.append("filestatusname LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filestatusid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusName != null) {
                    qPos.add(fileStatusName);
                }

                list = (List<PmlFileStatus>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatus>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILESTATUSNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileStatus findByFileStatusName_First(String fileStatusName,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        List<PmlFileStatus> list = findByFileStatusName(fileStatusName, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("fileStatusName=" + fileStatusName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus findByFileStatusName_Last(String fileStatusName,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        int count = countByFileStatusName(fileStatusName);

        List<PmlFileStatus> list = findByFileStatusName(fileStatusName,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("fileStatusName=" + fileStatusName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus[] findByFileStatusName_PrevAndNext(long fileStatusId,
        String fileStatusName, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        PmlFileStatus pmlFileStatus = findByPrimaryKey(fileStatusId);

        int count = countByFileStatusName(fileStatusName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

            if (fileStatusName == null) {
                query.append("filestatusname LIKE null");
            } else {
                query.append("filestatusname LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filestatusid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileStatusName != null) {
                qPos.add(fileStatusName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatus);

            PmlFileStatus[] array = new PmlFileStatusImpl[3];

            array[0] = (PmlFileStatus) objArray[0];
            array[1] = (PmlFileStatus) objArray[1];
            array[2] = (PmlFileStatus) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileStatus> findByDescription(String description)
        throws SystemException {
        Object[] finderArgs = new Object[] { description };

        List<PmlFileStatus> list = (List<PmlFileStatus>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filestatusid DESC");

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
                    list = new ArrayList<PmlFileStatus>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileStatus> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<PmlFileStatus> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileStatus> list = (List<PmlFileStatus>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

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

                    query.append("filestatusid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                list = (List<PmlFileStatus>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatus>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileStatus findByDescription_First(String description,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        List<PmlFileStatus> list = findByDescription(description, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus findByDescription_Last(String description,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        int count = countByDescription(description);

        List<PmlFileStatus> list = findByDescription(description, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus[] findByDescription_PrevAndNext(long fileStatusId,
        String description, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        PmlFileStatus pmlFileStatus = findByPrimaryKey(fileStatusId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

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

                query.append("filestatusid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatus);

            PmlFileStatus[] array = new PmlFileStatusImpl[3];

            array[0] = (PmlFileStatus) objArray[0];
            array[1] = (PmlFileStatus) objArray[1];
            array[2] = (PmlFileStatus) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileStatus> findByType(String type)
        throws SystemException {
        Object[] finderArgs = new Object[] { type };

        List<PmlFileStatus> list = (List<PmlFileStatus>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TYPE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (type == null) {
                    query.append("type IS NULL");
                } else {
                    query.append("type = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filestatusid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (type != null) {
                    qPos.add(type);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatus>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TYPE, finderArgs,
                    list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileStatus> findByType(String type, int start, int end)
        throws SystemException {
        return findByType(type, start, end, null);
    }

    public List<PmlFileStatus> findByType(String type, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                type,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileStatus> list = (List<PmlFileStatus>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_TYPE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (type == null) {
                    query.append("type IS NULL");
                } else {
                    query.append("type = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filestatusid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (type != null) {
                    qPos.add(type);
                }

                list = (List<PmlFileStatus>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatus>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_TYPE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileStatus findByType_First(String type, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        List<PmlFileStatus> list = findByType(type, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus findByType_Last(String type, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        int count = countByType(type);

        List<PmlFileStatus> list = findByType(type, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus[] findByType_PrevAndNext(long fileStatusId,
        String type, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        PmlFileStatus pmlFileStatus = findByPrimaryKey(fileStatusId);

        int count = countByType(type);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

            if (type == null) {
                query.append("type IS NULL");
            } else {
                query.append("type = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filestatusid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (type != null) {
                qPos.add(type);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatus);

            PmlFileStatus[] array = new PmlFileStatusImpl[3];

            array[0] = (PmlFileStatus) objArray[0];
            array[1] = (PmlFileStatus) objArray[1];
            array[2] = (PmlFileStatus) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileStatus> findByFileStatusCode_Type(
        String fileStatusCode, String type) throws SystemException {
        Object[] finderArgs = new Object[] { fileStatusCode, type };

        List<PmlFileStatus> list = (List<PmlFileStatus>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILESTATUSCODE_TYPE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (fileStatusCode == null) {
                    query.append("filestatuscode IS NULL");
                } else {
                    query.append("lower(filestatuscode) = ?");
                }

                query.append(" AND ");

                if (type == null) {
                    query.append("type IS NULL");
                } else {
                    query.append("type = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filestatusid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusCode != null) {
                    qPos.add(fileStatusCode);
                }

                if (type != null) {
                    qPos.add(type);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatus>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILESTATUSCODE_TYPE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileStatus> findByFileStatusCode_Type(
        String fileStatusCode, String type, int start, int end)
        throws SystemException {
        return findByFileStatusCode_Type(fileStatusCode, type, start, end, null);
    }

    public List<PmlFileStatus> findByFileStatusCode_Type(
        String fileStatusCode, String type, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileStatusCode,
                
                type,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileStatus> list = (List<PmlFileStatus>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILESTATUSCODE_TYPE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (fileStatusCode == null) {
                    query.append("filestatuscode IS NULL");
                } else {
                    query.append("lower(filestatuscode) = ?");
                }

                query.append(" AND ");

                if (type == null) {
                    query.append("type IS NULL");
                } else {
                    query.append("type = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filestatusid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusCode != null) {
                    qPos.add(fileStatusCode);
                }

                if (type != null) {
                    qPos.add(type);
                }

                list = (List<PmlFileStatus>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatus>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILESTATUSCODE_TYPE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileStatus findByFileStatusCode_Type_First(
        String fileStatusCode, String type, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        List<PmlFileStatus> list = findByFileStatusCode_Type(fileStatusCode,
                type, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("fileStatusCode=" + fileStatusCode);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus findByFileStatusCode_Type_Last(String fileStatusCode,
        String type, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        int count = countByFileStatusCode_Type(fileStatusCode, type);

        List<PmlFileStatus> list = findByFileStatusCode_Type(fileStatusCode,
                type, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("fileStatusCode=" + fileStatusCode);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus[] findByFileStatusCode_Type_PrevAndNext(
        long fileStatusId, String fileStatusCode, String type,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        PmlFileStatus pmlFileStatus = findByPrimaryKey(fileStatusId);

        int count = countByFileStatusCode_Type(fileStatusCode, type);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

            if (fileStatusCode == null) {
                query.append("filestatuscode IS NULL");
            } else {
                query.append("lower(filestatuscode) = ?");
            }

            query.append(" AND ");

            if (type == null) {
                query.append("type IS NULL");
            } else {
                query.append("type = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filestatusid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileStatusCode != null) {
                qPos.add(fileStatusCode);
            }

            if (type != null) {
                qPos.add(type);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatus);

            PmlFileStatus[] array = new PmlFileStatusImpl[3];

            array[0] = (PmlFileStatus) objArray[0];
            array[1] = (PmlFileStatus) objArray[1];
            array[2] = (PmlFileStatus) objArray[2];

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

    public List<PmlFileStatus> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileStatus> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileStatus> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileStatus> list = (List<PmlFileStatus>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filestatusid DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlFileStatus>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlFileStatus>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileStatus>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByFileStatusCode(String fileStatusCode)
        throws SystemException {
        for (PmlFileStatus pmlFileStatus : findByFileStatusCode(fileStatusCode)) {
            remove(pmlFileStatus);
        }
    }

    public void removeByFileStatusName(String fileStatusName)
        throws SystemException {
        for (PmlFileStatus pmlFileStatus : findByFileStatusName(fileStatusName)) {
            remove(pmlFileStatus);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (PmlFileStatus pmlFileStatus : findByDescription(description)) {
            remove(pmlFileStatus);
        }
    }

    public void removeByType(String type) throws SystemException {
        for (PmlFileStatus pmlFileStatus : findByType(type)) {
            remove(pmlFileStatus);
        }
    }

    public void removeByFileStatusCode_Type(String fileStatusCode, String type)
        throws SystemException {
        for (PmlFileStatus pmlFileStatus : findByFileStatusCode_Type(
                fileStatusCode, type)) {
            remove(pmlFileStatus);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFileStatus pmlFileStatus : findAll()) {
            remove(pmlFileStatus);
        }
    }

    public int countByFileStatusCode(String fileStatusCode)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileStatusCode };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILESTATUSCODE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (fileStatusCode == null) {
                    query.append("filestatuscode LIKE null");
                } else {
                    query.append("filestatuscode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusCode != null) {
                    qPos.add(fileStatusCode);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILESTATUSCODE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileStatusName(String fileStatusName)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileStatusName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILESTATUSNAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (fileStatusName == null) {
                    query.append("filestatusname LIKE null");
                } else {
                    query.append("filestatusname LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusName != null) {
                    qPos.add(fileStatusName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILESTATUSNAME,
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
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
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

    public int countByType(String type) throws SystemException {
        Object[] finderArgs = new Object[] { type };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TYPE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (type == null) {
                    query.append("type IS NULL");
                } else {
                    query.append("type = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (type != null) {
                    qPos.add(type);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TYPE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByFileStatusCode_Type(String fileStatusCode, String type)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileStatusCode, type };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILESTATUSCODE_TYPE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlFileStatus WHERE ");

                if (fileStatusCode == null) {
                    query.append("filestatuscode IS NULL");
                } else {
                    query.append("lower(filestatuscode) = ?");
                }

                query.append(" AND ");

                if (type == null) {
                    query.append("type IS NULL");
                } else {
                    query.append("type = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusCode != null) {
                    qPos.add(fileStatusCode);
                }

                if (type != null) {
                    qPos.add(type);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILESTATUSCODE_TYPE,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlFileStatus");

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
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlFileStatus")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlFileStatus>> listenersList = new ArrayList<ModelListener<PmlFileStatus>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlFileStatus>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
