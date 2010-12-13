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

import com.nss.portlet.onedoor.NoSuchPmlTransitionException;
import com.nss.portlet.onedoor.model.PmlTransition;
import com.nss.portlet.onedoor.model.impl.PmlTransitionImpl;
import com.nss.portlet.onedoor.model.impl.PmlTransitionModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlTransitionPersistenceImpl extends BasePersistenceImpl
    implements PmlTransitionPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlTransitionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPEID_VERSION = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId_Version",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPEID_VERSION = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId_Version",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPEID_VERSION = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileTypeId_Version",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_VERSION_ = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByVersion_",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_VERSION_ = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByVersion_",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_VERSION_ = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByVersion_",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_TRANSITIONNAME = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByTransitionName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_TRANSITIONNAME = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByTransitionName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_TRANSITIONNAME = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByTransitionName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPEID = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPEID = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPEID = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileTypeId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_NOTRANSITION = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByNoTransition",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_NOTRANSITION = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByNoTransition",
            new String[] {
                Integer.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_NOTRANSITION = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByNoTransition",
            new String[] { Integer.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_STATEPROCESSCURRENT = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessCurrent",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATEPROCESSCURRENT = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessCurrent",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_STATEPROCESSCURRENT = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByStateProcessCurrent",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_STATEPROCESSNEXT = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessNext",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATEPROCESSNEXT = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessNext",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_STATEPROCESSNEXT = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByStateProcessNext",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlTransitionPersistenceImpl.class);
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

    public void cacheResult(PmlTransition pmlTransition) {
        EntityCacheUtil.putResult(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionImpl.class, pmlTransition.getPrimaryKey(),
            pmlTransition);
    }

    public void cacheResult(List<PmlTransition> pmlTransitions) {
        for (PmlTransition pmlTransition : pmlTransitions) {
            if (EntityCacheUtil.getResult(
                        PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
                        PmlTransitionImpl.class, pmlTransition.getPrimaryKey(),
                        this) == null) {
                cacheResult(pmlTransition);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlTransitionImpl.class.getName());
        EntityCacheUtil.clearCache(PmlTransitionImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlTransition create(long transitionId) {
        PmlTransition pmlTransition = new PmlTransitionImpl();

        pmlTransition.setNew(true);
        pmlTransition.setPrimaryKey(transitionId);

        return pmlTransition;
    }

    public PmlTransition remove(long transitionId)
        throws NoSuchPmlTransitionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlTransition pmlTransition = (PmlTransition) session.get(PmlTransitionImpl.class,
                    new Long(transitionId));

            if (pmlTransition == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlTransition exists with the primary key " +
                        transitionId);
                }

                throw new NoSuchPmlTransitionException(
                    "No PmlTransition exists with the primary key " +
                    transitionId);
            }

            return remove(pmlTransition);
        } catch (NoSuchPmlTransitionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlTransition remove(PmlTransition pmlTransition)
        throws SystemException {
        for (ModelListener<PmlTransition> listener : listeners) {
            listener.onBeforeRemove(pmlTransition);
        }

        pmlTransition = removeImpl(pmlTransition);

        for (ModelListener<PmlTransition> listener : listeners) {
            listener.onAfterRemove(pmlTransition);
        }

        return pmlTransition;
    }

    protected PmlTransition removeImpl(PmlTransition pmlTransition)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlTransition.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlTransitionImpl.class,
                        pmlTransition.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlTransition);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionImpl.class, pmlTransition.getPrimaryKey());

        return pmlTransition;
    }

    /**
     * @deprecated Use <code>update(PmlTransition pmlTransition, boolean merge)</code>.
     */
    public PmlTransition update(PmlTransition pmlTransition)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlTransition pmlTransition) method. Use update(PmlTransition pmlTransition, boolean merge) instead.");
        }

        return update(pmlTransition, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTransition the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTransition is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlTransition update(PmlTransition pmlTransition, boolean merge)
        throws SystemException {
        boolean isNew = pmlTransition.isNew();

        for (ModelListener<PmlTransition> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlTransition);
            } else {
                listener.onBeforeUpdate(pmlTransition);
            }
        }

        pmlTransition = updateImpl(pmlTransition, merge);

        for (ModelListener<PmlTransition> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlTransition);
            } else {
                listener.onAfterUpdate(pmlTransition);
            }
        }

        return pmlTransition;
    }

    public PmlTransition updateImpl(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlTransition, merge);

            pmlTransition.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
            PmlTransitionImpl.class, pmlTransition.getPrimaryKey(),
            pmlTransition);

        return pmlTransition;
    }

    public PmlTransition findByPrimaryKey(long transitionId)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = fetchByPrimaryKey(transitionId);

        if (pmlTransition == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlTransition exists with the primary key " +
                    transitionId);
            }

            throw new NoSuchPmlTransitionException(
                "No PmlTransition exists with the primary key " + transitionId);
        }

        return pmlTransition;
    }

    public PmlTransition fetchByPrimaryKey(long transitionId)
        throws SystemException {
        PmlTransition pmlTransition = (PmlTransition) EntityCacheUtil.getResult(PmlTransitionModelImpl.ENTITY_CACHE_ENABLED,
                PmlTransitionImpl.class, transitionId, this);

        if (pmlTransition == null) {
            Session session = null;

            try {
                session = openSession();

                pmlTransition = (PmlTransition) session.get(PmlTransitionImpl.class,
                        new Long(transitionId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlTransition != null) {
                    cacheResult(pmlTransition);
                }

                closeSession(session);
            }
        }

        return pmlTransition;
    }

    public List<PmlTransition> findByFileTypeId_Version(String fileTypeId,
        String version_) throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId, version_ };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPEID_VERSION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" AND ");

                if (version_ == null) {
                    query.append("version_ IS NULL");
                } else {
                    query.append("version_ = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (version_ != null) {
                    qPos.add(version_);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPEID_VERSION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlTransition> findByFileTypeId_Version(String fileTypeId,
        String version_, int start, int end) throws SystemException {
        return findByFileTypeId_Version(fileTypeId, version_, start, end, null);
    }

    public List<PmlTransition> findByFileTypeId_Version(String fileTypeId,
        String version_, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                version_,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID_VERSION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" AND ");

                if (version_ == null) {
                    query.append("version_ IS NULL");
                } else {
                    query.append("version_ = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (version_ != null) {
                    qPos.add(version_);
                }

                list = (List<PmlTransition>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID_VERSION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlTransition findByFileTypeId_Version_First(String fileTypeId,
        String version_, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByFileTypeId_Version(fileTypeId,
                version_, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByFileTypeId_Version_Last(String fileTypeId,
        String version_, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByFileTypeId_Version(fileTypeId, version_);

        List<PmlTransition> list = findByFileTypeId_Version(fileTypeId,
                version_, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByFileTypeId_Version_PrevAndNext(
        long transitionId, String fileTypeId, String version_,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByFileTypeId_Version(fileTypeId, version_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

            if (fileTypeId == null) {
                query.append("filetypeid IS NULL");
            } else {
                query.append("filetypeid = ?");
            }

            query.append(" AND ");

            if (version_ == null) {
                query.append("version_ IS NULL");
            } else {
                query.append("version_ = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            if (version_ != null) {
                qPos.add(version_);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByVersion_(String version_)
        throws SystemException {
        Object[] finderArgs = new Object[] { version_ };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_VERSION_,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                if (version_ == null) {
                    query.append("version_ IS NULL");
                } else {
                    query.append("version_ = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (version_ != null) {
                    qPos.add(version_);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_VERSION_,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlTransition> findByVersion_(String version_, int start,
        int end) throws SystemException {
        return findByVersion_(version_, start, end, null);
    }

    public List<PmlTransition> findByVersion_(String version_, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                version_,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_VERSION_,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                if (version_ == null) {
                    query.append("version_ IS NULL");
                } else {
                    query.append("version_ = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (version_ != null) {
                    qPos.add(version_);
                }

                list = (List<PmlTransition>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_VERSION_,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlTransition findByVersion__First(String version_,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByVersion_(version_, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByVersion__Last(String version_,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByVersion_(version_);

        List<PmlTransition> list = findByVersion_(version_, count - 1, count,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByVersion__PrevAndNext(long transitionId,
        String version_, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByVersion_(version_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

            if (version_ == null) {
                query.append("version_ IS NULL");
            } else {
                query.append("version_ = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (version_ != null) {
                qPos.add(version_);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByTransitionName(String transitionName)
        throws SystemException {
        Object[] finderArgs = new Object[] { transitionName };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TRANSITIONNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                if (transitionName == null) {
                    query.append("transitionname IS NULL");
                } else {
                    query.append("transitionname = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (transitionName != null) {
                    qPos.add(transitionName);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TRANSITIONNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlTransition> findByTransitionName(String transitionName,
        int start, int end) throws SystemException {
        return findByTransitionName(transitionName, start, end, null);
    }

    public List<PmlTransition> findByTransitionName(String transitionName,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                transitionName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_TRANSITIONNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                if (transitionName == null) {
                    query.append("transitionname IS NULL");
                } else {
                    query.append("transitionname = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (transitionName != null) {
                    qPos.add(transitionName);
                }

                list = (List<PmlTransition>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_TRANSITIONNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlTransition findByTransitionName_First(String transitionName,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByTransitionName(transitionName, 0, 1,
                obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("transitionName=" + transitionName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByTransitionName_Last(String transitionName,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByTransitionName(transitionName);

        List<PmlTransition> list = findByTransitionName(transitionName,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("transitionName=" + transitionName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByTransitionName_PrevAndNext(long transitionId,
        String transitionName, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByTransitionName(transitionName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

            if (transitionName == null) {
                query.append("transitionname IS NULL");
            } else {
                query.append("transitionname = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (transitionName != null) {
                qPos.add(transitionName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByFileTypeId(String fileTypeId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

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
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlTransition> findByFileTypeId(String fileTypeId, int start,
        int end) throws SystemException {
        return findByFileTypeId(fileTypeId, start, end, null);
    }

    public List<PmlTransition> findByFileTypeId(String fileTypeId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                list = (List<PmlTransition>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlTransition findByFileTypeId_First(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByFileTypeId(fileTypeId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByFileTypeId_Last(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByFileTypeId(fileTypeId);

        List<PmlTransition> list = findByFileTypeId(fileTypeId, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByFileTypeId_PrevAndNext(long transitionId,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByFileTypeId(fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

            if (fileTypeId == null) {
                query.append("filetypeid IS NULL");
            } else {
                query.append("filetypeid = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByNoTransition(int noTransition)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(noTransition) };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_NOTRANSITION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                query.append("notransition = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(noTransition);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_NOTRANSITION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlTransition> findByNoTransition(int noTransition, int start,
        int end) throws SystemException {
        return findByNoTransition(noTransition, start, end, null);
    }

    public List<PmlTransition> findByNoTransition(int noTransition, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Integer(noTransition),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_NOTRANSITION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                query.append("notransition = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(noTransition);

                list = (List<PmlTransition>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_NOTRANSITION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlTransition findByNoTransition_First(int noTransition,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByNoTransition(noTransition, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("noTransition=" + noTransition);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByNoTransition_Last(int noTransition,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByNoTransition(noTransition);

        List<PmlTransition> list = findByNoTransition(noTransition, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("noTransition=" + noTransition);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByNoTransition_PrevAndNext(long transitionId,
        int noTransition, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByNoTransition(noTransition);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

            query.append("notransition = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(noTransition);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByStateProcessCurrent(
        long stateProcessCurrent) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(stateProcessCurrent) };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATEPROCESSCURRENT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                query.append("stateprocesscurrent = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessCurrent);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATEPROCESSCURRENT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlTransition> findByStateProcessCurrent(
        long stateProcessCurrent, int start, int end) throws SystemException {
        return findByStateProcessCurrent(stateProcessCurrent, start, end, null);
    }

    public List<PmlTransition> findByStateProcessCurrent(
        long stateProcessCurrent, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(stateProcessCurrent),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSCURRENT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                query.append("stateprocesscurrent = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessCurrent);

                list = (List<PmlTransition>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSCURRENT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlTransition findByStateProcessCurrent_First(
        long stateProcessCurrent, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByStateProcessCurrent(stateProcessCurrent,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("stateProcessCurrent=" + stateProcessCurrent);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByStateProcessCurrent_Last(
        long stateProcessCurrent, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByStateProcessCurrent(stateProcessCurrent);

        List<PmlTransition> list = findByStateProcessCurrent(stateProcessCurrent,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("stateProcessCurrent=" + stateProcessCurrent);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByStateProcessCurrent_PrevAndNext(
        long transitionId, long stateProcessCurrent, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByStateProcessCurrent(stateProcessCurrent);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

            query.append("stateprocesscurrent = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessCurrent);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByStateProcessNext(long stateProcessNext)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(stateProcessNext) };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATEPROCESSNEXT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                query.append("stateprocessnext = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessNext);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATEPROCESSNEXT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlTransition> findByStateProcessNext(long stateProcessNext,
        int start, int end) throws SystemException {
        return findByStateProcessNext(stateProcessNext, start, end, null);
    }

    public List<PmlTransition> findByStateProcessNext(long stateProcessNext,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(stateProcessNext),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSNEXT,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                query.append("stateprocessnext = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessNext);

                list = (List<PmlTransition>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSNEXT,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlTransition findByStateProcessNext_First(long stateProcessNext,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByStateProcessNext(stateProcessNext, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("stateProcessNext=" + stateProcessNext);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByStateProcessNext_Last(long stateProcessNext,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByStateProcessNext(stateProcessNext);

        List<PmlTransition> list = findByStateProcessNext(stateProcessNext,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("stateProcessNext=" + stateProcessNext);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByStateProcessNext_PrevAndNext(
        long transitionId, long stateProcessNext, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByStateProcessNext(stateProcessNext);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

            query.append("stateprocessnext = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessNext);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

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

    public List<PmlTransition> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlTransition> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlTransition> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlTransition> list = (List<PmlTransition>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlTransition>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlTransition>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlTransition>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByFileTypeId_Version(String fileTypeId, String version_)
        throws SystemException {
        for (PmlTransition pmlTransition : findByFileTypeId_Version(
                fileTypeId, version_)) {
            remove(pmlTransition);
        }
    }

    public void removeByVersion_(String version_) throws SystemException {
        for (PmlTransition pmlTransition : findByVersion_(version_)) {
            remove(pmlTransition);
        }
    }

    public void removeByTransitionName(String transitionName)
        throws SystemException {
        for (PmlTransition pmlTransition : findByTransitionName(transitionName)) {
            remove(pmlTransition);
        }
    }

    public void removeByFileTypeId(String fileTypeId) throws SystemException {
        for (PmlTransition pmlTransition : findByFileTypeId(fileTypeId)) {
            remove(pmlTransition);
        }
    }

    public void removeByNoTransition(int noTransition)
        throws SystemException {
        for (PmlTransition pmlTransition : findByNoTransition(noTransition)) {
            remove(pmlTransition);
        }
    }

    public void removeByStateProcessCurrent(long stateProcessCurrent)
        throws SystemException {
        for (PmlTransition pmlTransition : findByStateProcessCurrent(
                stateProcessCurrent)) {
            remove(pmlTransition);
        }
    }

    public void removeByStateProcessNext(long stateProcessNext)
        throws SystemException {
        for (PmlTransition pmlTransition : findByStateProcessNext(
                stateProcessNext)) {
            remove(pmlTransition);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlTransition pmlTransition : findAll()) {
            remove(pmlTransition);
        }
    }

    public int countByFileTypeId_Version(String fileTypeId, String version_)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId, version_ };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILETYPEID_VERSION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" AND ");

                if (version_ == null) {
                    query.append("version_ IS NULL");
                } else {
                    query.append("version_ = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (version_ != null) {
                    qPos.add(version_);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILETYPEID_VERSION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByVersion_(String version_) throws SystemException {
        Object[] finderArgs = new Object[] { version_ };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_VERSION_,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                if (version_ == null) {
                    query.append("version_ IS NULL");
                } else {
                    query.append("version_ = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (version_ != null) {
                    qPos.add(version_);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VERSION_,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByTransitionName(String transitionName)
        throws SystemException {
        Object[] finderArgs = new Object[] { transitionName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TRANSITIONNAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                if (transitionName == null) {
                    query.append("transitionname IS NULL");
                } else {
                    query.append("transitionname = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (transitionName != null) {
                    qPos.add(transitionName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TRANSITIONNAME,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
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
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
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

    public int countByNoTransition(int noTransition) throws SystemException {
        Object[] finderArgs = new Object[] { new Integer(noTransition) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NOTRANSITION,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                query.append("notransition = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(noTransition);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOTRANSITION,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByStateProcessCurrent(long stateProcessCurrent)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(stateProcessCurrent) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATEPROCESSCURRENT,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                query.append("stateprocesscurrent = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessCurrent);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATEPROCESSCURRENT,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByStateProcessNext(long stateProcessNext)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(stateProcessNext) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATEPROCESSNEXT,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlTransition WHERE ");

                query.append("stateprocessnext = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessNext);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATEPROCESSNEXT,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlTransition");

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
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlTransition")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlTransition>> listenersList = new ArrayList<ModelListener<PmlTransition>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlTransition>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
