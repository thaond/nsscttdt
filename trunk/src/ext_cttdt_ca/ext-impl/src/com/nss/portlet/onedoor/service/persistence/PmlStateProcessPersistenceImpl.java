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

import com.nss.portlet.onedoor.NoSuchPmlStateProcessException;
import com.nss.portlet.onedoor.model.PmlStateProcess;
import com.nss.portlet.onedoor.model.impl.PmlStateProcessImpl;
import com.nss.portlet.onedoor.model.impl.PmlStateProcessModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlStateProcessPersistenceImpl extends BasePersistenceImpl
    implements PmlStateProcessPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlStateProcessImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_STATEPROCESSCODE = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessCode",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATEPROCESSCODE = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessCode",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_STATEPROCESSCODE = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByStateProcessCode",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_STATEPROCESSNAME = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATEPROCESSNAME = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessName",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_STATEPROCESSNAME = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByStateProcessName",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DESCRIPTION = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDescription",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DESCRIPTION = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDescription",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DESCRIPTION = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByDescription",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILESTATUSID = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileStatusId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILESTATUSID = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileStatusId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILESTATUSID = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileStatusId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_STATEPROCESSCODE_NAME = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessCode_Name",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATEPROCESSCODE_NAME =
        new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByStateProcessCode_Name",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_STATEPROCESSCODE_NAME = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByStateProcessCode_Name",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlStateProcessPersistenceImpl.class);
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

    public void cacheResult(PmlStateProcess pmlStateProcess) {
        EntityCacheUtil.putResult(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessImpl.class, pmlStateProcess.getPrimaryKey(),
            pmlStateProcess);
    }

    public void cacheResult(List<PmlStateProcess> pmlStateProcesses) {
        for (PmlStateProcess pmlStateProcess : pmlStateProcesses) {
            if (EntityCacheUtil.getResult(
                        PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
                        PmlStateProcessImpl.class,
                        pmlStateProcess.getPrimaryKey(), this) == null) {
                cacheResult(pmlStateProcess);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlStateProcessImpl.class.getName());
        EntityCacheUtil.clearCache(PmlStateProcessImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlStateProcess create(long stateProcessId) {
        PmlStateProcess pmlStateProcess = new PmlStateProcessImpl();

        pmlStateProcess.setNew(true);
        pmlStateProcess.setPrimaryKey(stateProcessId);

        return pmlStateProcess;
    }

    public PmlStateProcess remove(long stateProcessId)
        throws NoSuchPmlStateProcessException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlStateProcess pmlStateProcess = (PmlStateProcess) session.get(PmlStateProcessImpl.class,
                    new Long(stateProcessId));

            if (pmlStateProcess == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlStateProcess exists with the primary key " +
                        stateProcessId);
                }

                throw new NoSuchPmlStateProcessException(
                    "No PmlStateProcess exists with the primary key " +
                    stateProcessId);
            }

            return remove(pmlStateProcess);
        } catch (NoSuchPmlStateProcessException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlStateProcess remove(PmlStateProcess pmlStateProcess)
        throws SystemException {
        for (ModelListener<PmlStateProcess> listener : listeners) {
            listener.onBeforeRemove(pmlStateProcess);
        }

        pmlStateProcess = removeImpl(pmlStateProcess);

        for (ModelListener<PmlStateProcess> listener : listeners) {
            listener.onAfterRemove(pmlStateProcess);
        }

        return pmlStateProcess;
    }

    protected PmlStateProcess removeImpl(PmlStateProcess pmlStateProcess)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlStateProcess.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlStateProcessImpl.class,
                        pmlStateProcess.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlStateProcess);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessImpl.class, pmlStateProcess.getPrimaryKey());

        return pmlStateProcess;
    }

    /**
     * @deprecated Use <code>update(PmlStateProcess pmlStateProcess, boolean merge)</code>.
     */
    public PmlStateProcess update(PmlStateProcess pmlStateProcess)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlStateProcess pmlStateProcess) method. Use update(PmlStateProcess pmlStateProcess, boolean merge) instead.");
        }

        return update(pmlStateProcess, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlStateProcess the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlStateProcess is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlStateProcess update(PmlStateProcess pmlStateProcess, boolean merge)
        throws SystemException {
        boolean isNew = pmlStateProcess.isNew();

        for (ModelListener<PmlStateProcess> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlStateProcess);
            } else {
                listener.onBeforeUpdate(pmlStateProcess);
            }
        }

        pmlStateProcess = updateImpl(pmlStateProcess, merge);

        for (ModelListener<PmlStateProcess> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlStateProcess);
            } else {
                listener.onAfterUpdate(pmlStateProcess);
            }
        }

        return pmlStateProcess;
    }

    public PmlStateProcess updateImpl(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlStateProcess, merge);

            pmlStateProcess.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlStateProcessImpl.class, pmlStateProcess.getPrimaryKey(),
            pmlStateProcess);

        return pmlStateProcess;
    }

    public PmlStateProcess findByPrimaryKey(long stateProcessId)
        throws NoSuchPmlStateProcessException, SystemException {
        PmlStateProcess pmlStateProcess = fetchByPrimaryKey(stateProcessId);

        if (pmlStateProcess == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlStateProcess exists with the primary key " +
                    stateProcessId);
            }

            throw new NoSuchPmlStateProcessException(
                "No PmlStateProcess exists with the primary key " +
                stateProcessId);
        }

        return pmlStateProcess;
    }

    public PmlStateProcess fetchByPrimaryKey(long stateProcessId)
        throws SystemException {
        PmlStateProcess pmlStateProcess = (PmlStateProcess) EntityCacheUtil.getResult(PmlStateProcessModelImpl.ENTITY_CACHE_ENABLED,
                PmlStateProcessImpl.class, stateProcessId, this);

        if (pmlStateProcess == null) {
            Session session = null;

            try {
                session = openSession();

                pmlStateProcess = (PmlStateProcess) session.get(PmlStateProcessImpl.class,
                        new Long(stateProcessId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlStateProcess != null) {
                    cacheResult(pmlStateProcess);
                }

                closeSession(session);
            }
        }

        return pmlStateProcess;
    }

    public List<PmlStateProcess> findByStateProcessCode(String stateProcessCode)
        throws SystemException {
        Object[] finderArgs = new Object[] { stateProcessCode };

        List<PmlStateProcess> list = (List<PmlStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATEPROCESSCODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                if (stateProcessCode == null) {
                    query.append("stateprocesscode LIKE null");
                } else {
                    query.append("stateprocesscode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("stateprocessid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessCode != null) {
                    qPos.add(stateProcessCode);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATEPROCESSCODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlStateProcess> findByStateProcessCode(
        String stateProcessCode, int start, int end) throws SystemException {
        return findByStateProcessCode(stateProcessCode, start, end, null);
    }

    public List<PmlStateProcess> findByStateProcessCode(
        String stateProcessCode, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                stateProcessCode,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlStateProcess> list = (List<PmlStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSCODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                if (stateProcessCode == null) {
                    query.append("stateprocesscode LIKE null");
                } else {
                    query.append("stateprocesscode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("stateprocessid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessCode != null) {
                    qPos.add(stateProcessCode);
                }

                list = (List<PmlStateProcess>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSCODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlStateProcess findByStateProcessCode_First(
        String stateProcessCode, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        List<PmlStateProcess> list = findByStateProcessCode(stateProcessCode,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("stateProcessCode=" + stateProcessCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess findByStateProcessCode_Last(
        String stateProcessCode, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        int count = countByStateProcessCode(stateProcessCode);

        List<PmlStateProcess> list = findByStateProcessCode(stateProcessCode,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("stateProcessCode=" + stateProcessCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess[] findByStateProcessCode_PrevAndNext(
        long stateProcessId, String stateProcessCode, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        PmlStateProcess pmlStateProcess = findByPrimaryKey(stateProcessId);

        int count = countByStateProcessCode(stateProcessCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

            if (stateProcessCode == null) {
                query.append("stateprocesscode LIKE null");
            } else {
                query.append("stateprocesscode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("stateprocessid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (stateProcessCode != null) {
                qPos.add(stateProcessCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateProcess);

            PmlStateProcess[] array = new PmlStateProcessImpl[3];

            array[0] = (PmlStateProcess) objArray[0];
            array[1] = (PmlStateProcess) objArray[1];
            array[2] = (PmlStateProcess) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateProcess> findByStateProcessName(String stateProcessName)
        throws SystemException {
        Object[] finderArgs = new Object[] { stateProcessName };

        List<PmlStateProcess> list = (List<PmlStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATEPROCESSNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                if (stateProcessName == null) {
                    query.append("stateprocessname LIKE null");
                } else {
                    query.append("stateprocessname LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("stateprocessid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessName != null) {
                    qPos.add(stateProcessName);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATEPROCESSNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlStateProcess> findByStateProcessName(
        String stateProcessName, int start, int end) throws SystemException {
        return findByStateProcessName(stateProcessName, start, end, null);
    }

    public List<PmlStateProcess> findByStateProcessName(
        String stateProcessName, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                stateProcessName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlStateProcess> list = (List<PmlStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSNAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                if (stateProcessName == null) {
                    query.append("stateprocessname LIKE null");
                } else {
                    query.append("stateprocessname LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("stateprocessid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessName != null) {
                    qPos.add(stateProcessName);
                }

                list = (List<PmlStateProcess>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSNAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlStateProcess findByStateProcessName_First(
        String stateProcessName, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        List<PmlStateProcess> list = findByStateProcessName(stateProcessName,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("stateProcessName=" + stateProcessName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess findByStateProcessName_Last(
        String stateProcessName, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        int count = countByStateProcessName(stateProcessName);

        List<PmlStateProcess> list = findByStateProcessName(stateProcessName,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("stateProcessName=" + stateProcessName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess[] findByStateProcessName_PrevAndNext(
        long stateProcessId, String stateProcessName, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        PmlStateProcess pmlStateProcess = findByPrimaryKey(stateProcessId);

        int count = countByStateProcessName(stateProcessName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

            if (stateProcessName == null) {
                query.append("stateprocessname LIKE null");
            } else {
                query.append("stateprocessname LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("stateprocessid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (stateProcessName != null) {
                qPos.add(stateProcessName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateProcess);

            PmlStateProcess[] array = new PmlStateProcessImpl[3];

            array[0] = (PmlStateProcess) objArray[0];
            array[1] = (PmlStateProcess) objArray[1];
            array[2] = (PmlStateProcess) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateProcess> findByDescription(String description)
        throws SystemException {
        Object[] finderArgs = new Object[] { description };

        List<PmlStateProcess> list = (List<PmlStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("stateprocessid DESC");

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
                    list = new ArrayList<PmlStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlStateProcess> findByDescription(String description,
        int start, int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<PmlStateProcess> findByDescription(String description,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                description,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlStateProcess> list = (List<PmlStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

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

                    query.append("stateprocessid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                list = (List<PmlStateProcess>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DESCRIPTION,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlStateProcess findByDescription_First(String description,
        OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        List<PmlStateProcess> list = findByDescription(description, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess findByDescription_Last(String description,
        OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        int count = countByDescription(description);

        List<PmlStateProcess> list = findByDescription(description, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess[] findByDescription_PrevAndNext(
        long stateProcessId, String description, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        PmlStateProcess pmlStateProcess = findByPrimaryKey(stateProcessId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

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

                query.append("stateprocessid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateProcess);

            PmlStateProcess[] array = new PmlStateProcessImpl[3];

            array[0] = (PmlStateProcess) objArray[0];
            array[1] = (PmlStateProcess) objArray[1];
            array[2] = (PmlStateProcess) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateProcess> findByFileStatusId(long fileStatusId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(fileStatusId) };

        List<PmlStateProcess> list = (List<PmlStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILESTATUSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("stateprocessid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILESTATUSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlStateProcess> findByFileStatusId(long fileStatusId,
        int start, int end) throws SystemException {
        return findByFileStatusId(fileStatusId, start, end, null);
    }

    public List<PmlStateProcess> findByFileStatusId(long fileStatusId,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(fileStatusId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlStateProcess> list = (List<PmlStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILESTATUSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("stateprocessid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                list = (List<PmlStateProcess>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILESTATUSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlStateProcess findByFileStatusId_First(long fileStatusId,
        OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        List<PmlStateProcess> list = findByFileStatusId(fileStatusId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("fileStatusId=" + fileStatusId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess findByFileStatusId_Last(long fileStatusId,
        OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        int count = countByFileStatusId(fileStatusId);

        List<PmlStateProcess> list = findByFileStatusId(fileStatusId,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("fileStatusId=" + fileStatusId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess[] findByFileStatusId_PrevAndNext(
        long stateProcessId, long fileStatusId, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        PmlStateProcess pmlStateProcess = findByPrimaryKey(stateProcessId);

        int count = countByFileStatusId(fileStatusId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

            query.append("filestatusid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("stateprocessid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(fileStatusId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateProcess);

            PmlStateProcess[] array = new PmlStateProcessImpl[3];

            array[0] = (PmlStateProcess) objArray[0];
            array[1] = (PmlStateProcess) objArray[1];
            array[2] = (PmlStateProcess) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateProcess> findByStateProcessCode_Name(
        String stateProcessCode, String stateProcessName)
        throws SystemException {
        Object[] finderArgs = new Object[] { stateProcessCode, stateProcessName };

        List<PmlStateProcess> list = (List<PmlStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATEPROCESSCODE_NAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                if (stateProcessCode == null) {
                    query.append("stateprocesscode IS NULL");
                } else {
                    query.append("stateprocesscode = ?");
                }

                query.append(" AND ");

                if (stateProcessName == null) {
                    query.append("stateprocessname IS NULL");
                } else {
                    query.append("stateprocessname = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("stateprocessid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessCode != null) {
                    qPos.add(stateProcessCode);
                }

                if (stateProcessName != null) {
                    qPos.add(stateProcessName);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATEPROCESSCODE_NAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlStateProcess> findByStateProcessCode_Name(
        String stateProcessCode, String stateProcessName, int start, int end)
        throws SystemException {
        return findByStateProcessCode_Name(stateProcessCode, stateProcessName,
            start, end, null);
    }

    public List<PmlStateProcess> findByStateProcessCode_Name(
        String stateProcessCode, String stateProcessName, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                stateProcessCode,
                
                stateProcessName,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlStateProcess> list = (List<PmlStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSCODE_NAME,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                if (stateProcessCode == null) {
                    query.append("stateprocesscode IS NULL");
                } else {
                    query.append("stateprocesscode = ?");
                }

                query.append(" AND ");

                if (stateProcessName == null) {
                    query.append("stateprocessname IS NULL");
                } else {
                    query.append("stateprocessname = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("stateprocessid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessCode != null) {
                    qPos.add(stateProcessCode);
                }

                if (stateProcessName != null) {
                    qPos.add(stateProcessName);
                }

                list = (List<PmlStateProcess>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATEPROCESSCODE_NAME,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlStateProcess findByStateProcessCode_Name_First(
        String stateProcessCode, String stateProcessName, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        List<PmlStateProcess> list = findByStateProcessCode_Name(stateProcessCode,
                stateProcessName, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("stateProcessCode=" + stateProcessCode);

            msg.append(", ");
            msg.append("stateProcessName=" + stateProcessName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess findByStateProcessCode_Name_Last(
        String stateProcessCode, String stateProcessName, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        int count = countByStateProcessCode_Name(stateProcessCode,
                stateProcessName);

        List<PmlStateProcess> list = findByStateProcessCode_Name(stateProcessCode,
                stateProcessName, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("stateProcessCode=" + stateProcessCode);

            msg.append(", ");
            msg.append("stateProcessName=" + stateProcessName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess[] findByStateProcessCode_Name_PrevAndNext(
        long stateProcessId, String stateProcessCode, String stateProcessName,
        OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        PmlStateProcess pmlStateProcess = findByPrimaryKey(stateProcessId);

        int count = countByStateProcessCode_Name(stateProcessCode,
                stateProcessName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

            if (stateProcessCode == null) {
                query.append("stateprocesscode IS NULL");
            } else {
                query.append("stateprocesscode = ?");
            }

            query.append(" AND ");

            if (stateProcessName == null) {
                query.append("stateprocessname IS NULL");
            } else {
                query.append("stateprocessname = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("stateprocessid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (stateProcessCode != null) {
                qPos.add(stateProcessCode);
            }

            if (stateProcessName != null) {
                qPos.add(stateProcessName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateProcess);

            PmlStateProcess[] array = new PmlStateProcessImpl[3];

            array[0] = (PmlStateProcess) objArray[0];
            array[1] = (PmlStateProcess) objArray[1];
            array[2] = (PmlStateProcess) objArray[2];

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

    public List<PmlStateProcess> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlStateProcess> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlStateProcess> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlStateProcess> list = (List<PmlStateProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("stateprocessid DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlStateProcess>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlStateProcess>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlStateProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByStateProcessCode(String stateProcessCode)
        throws SystemException {
        for (PmlStateProcess pmlStateProcess : findByStateProcessCode(
                stateProcessCode)) {
            remove(pmlStateProcess);
        }
    }

    public void removeByStateProcessName(String stateProcessName)
        throws SystemException {
        for (PmlStateProcess pmlStateProcess : findByStateProcessName(
                stateProcessName)) {
            remove(pmlStateProcess);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (PmlStateProcess pmlStateProcess : findByDescription(description)) {
            remove(pmlStateProcess);
        }
    }

    public void removeByFileStatusId(long fileStatusId)
        throws SystemException {
        for (PmlStateProcess pmlStateProcess : findByFileStatusId(fileStatusId)) {
            remove(pmlStateProcess);
        }
    }

    public void removeByStateProcessCode_Name(String stateProcessCode,
        String stateProcessName) throws SystemException {
        for (PmlStateProcess pmlStateProcess : findByStateProcessCode_Name(
                stateProcessCode, stateProcessName)) {
            remove(pmlStateProcess);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlStateProcess pmlStateProcess : findAll()) {
            remove(pmlStateProcess);
        }
    }

    public int countByStateProcessCode(String stateProcessCode)
        throws SystemException {
        Object[] finderArgs = new Object[] { stateProcessCode };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATEPROCESSCODE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                if (stateProcessCode == null) {
                    query.append("stateprocesscode LIKE null");
                } else {
                    query.append("stateprocesscode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessCode != null) {
                    qPos.add(stateProcessCode);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATEPROCESSCODE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByStateProcessName(String stateProcessName)
        throws SystemException {
        Object[] finderArgs = new Object[] { stateProcessName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATEPROCESSNAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                if (stateProcessName == null) {
                    query.append("stateprocessname LIKE null");
                } else {
                    query.append("stateprocessname LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessName != null) {
                    qPos.add(stateProcessName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATEPROCESSNAME,
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
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

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

    public int countByFileStatusId(long fileStatusId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(fileStatusId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILESTATUSID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILESTATUSID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByStateProcessCode_Name(String stateProcessCode,
        String stateProcessName) throws SystemException {
        Object[] finderArgs = new Object[] { stateProcessCode, stateProcessName };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATEPROCESSCODE_NAME,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlStateProcess WHERE ");

                if (stateProcessCode == null) {
                    query.append("stateprocesscode IS NULL");
                } else {
                    query.append("stateprocesscode = ?");
                }

                query.append(" AND ");

                if (stateProcessName == null) {
                    query.append("stateprocessname IS NULL");
                } else {
                    query.append("stateprocessname = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessCode != null) {
                    qPos.add(stateProcessCode);
                }

                if (stateProcessName != null) {
                    qPos.add(stateProcessName);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATEPROCESSCODE_NAME,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlStateProcess");

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
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlStateProcess")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlStateProcess>> listenersList = new ArrayList<ModelListener<PmlStateProcess>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlStateProcess>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
