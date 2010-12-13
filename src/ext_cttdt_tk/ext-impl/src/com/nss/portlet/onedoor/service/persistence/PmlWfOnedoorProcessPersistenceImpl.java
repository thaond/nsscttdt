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

import com.nss.portlet.onedoor.NoSuchPmlWfOnedoorProcessException;
import com.nss.portlet.onedoor.model.PmlWfOnedoorProcess;
import com.nss.portlet.onedoor.model.impl.PmlWfOnedoorProcessImpl;
import com.nss.portlet.onedoor.model.impl.PmlWfOnedoorProcessModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlWfOnedoorProcessPersistenceImpl extends BasePersistenceImpl
    implements PmlWfOnedoorProcessPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlWfOnedoorProcessImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_PROCESSID = new FinderPath(PmlWfOnedoorProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlWfOnedoorProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByProcessId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_PROCESSID = new FinderPath(PmlWfOnedoorProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlWfOnedoorProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByProcessId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_PROCESSID = new FinderPath(PmlWfOnedoorProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlWfOnedoorProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByProcessId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlWfOnedoorProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlWfOnedoorProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlWfOnedoorProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlWfOnedoorProcessModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlWfOnedoorProcessPersistenceImpl.class);
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

    public void cacheResult(PmlWfOnedoorProcess pmlWfOnedoorProcess) {
        EntityCacheUtil.putResult(PmlWfOnedoorProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlWfOnedoorProcessImpl.class, pmlWfOnedoorProcess.getPrimaryKey(),
            pmlWfOnedoorProcess);
    }

    public void cacheResult(List<PmlWfOnedoorProcess> pmlWfOnedoorProcesses) {
        for (PmlWfOnedoorProcess pmlWfOnedoorProcess : pmlWfOnedoorProcesses) {
            if (EntityCacheUtil.getResult(
                        PmlWfOnedoorProcessModelImpl.ENTITY_CACHE_ENABLED,
                        PmlWfOnedoorProcessImpl.class,
                        pmlWfOnedoorProcess.getPrimaryKey(), this) == null) {
                cacheResult(pmlWfOnedoorProcess);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlWfOnedoorProcessImpl.class.getName());
        EntityCacheUtil.clearCache(PmlWfOnedoorProcessImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlWfOnedoorProcess create(String fileId) {
        PmlWfOnedoorProcess pmlWfOnedoorProcess = new PmlWfOnedoorProcessImpl();

        pmlWfOnedoorProcess.setNew(true);
        pmlWfOnedoorProcess.setPrimaryKey(fileId);

        return pmlWfOnedoorProcess;
    }

    public PmlWfOnedoorProcess remove(String fileId)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlWfOnedoorProcess pmlWfOnedoorProcess = (PmlWfOnedoorProcess) session.get(PmlWfOnedoorProcessImpl.class,
                    fileId);

            if (pmlWfOnedoorProcess == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlWfOnedoorProcess exists with the primary key " +
                        fileId);
                }

                throw new NoSuchPmlWfOnedoorProcessException(
                    "No PmlWfOnedoorProcess exists with the primary key " +
                    fileId);
            }

            return remove(pmlWfOnedoorProcess);
        } catch (NoSuchPmlWfOnedoorProcessException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlWfOnedoorProcess remove(PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws SystemException {
        for (ModelListener<PmlWfOnedoorProcess> listener : listeners) {
            listener.onBeforeRemove(pmlWfOnedoorProcess);
        }

        pmlWfOnedoorProcess = removeImpl(pmlWfOnedoorProcess);

        for (ModelListener<PmlWfOnedoorProcess> listener : listeners) {
            listener.onAfterRemove(pmlWfOnedoorProcess);
        }

        return pmlWfOnedoorProcess;
    }

    protected PmlWfOnedoorProcess removeImpl(
        PmlWfOnedoorProcess pmlWfOnedoorProcess) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlWfOnedoorProcess.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlWfOnedoorProcessImpl.class,
                        pmlWfOnedoorProcess.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlWfOnedoorProcess);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlWfOnedoorProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlWfOnedoorProcessImpl.class, pmlWfOnedoorProcess.getPrimaryKey());

        return pmlWfOnedoorProcess;
    }

    /**
     * @deprecated Use <code>update(PmlWfOnedoorProcess pmlWfOnedoorProcess, boolean merge)</code>.
     */
    public PmlWfOnedoorProcess update(PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlWfOnedoorProcess pmlWfOnedoorProcess) method. Use update(PmlWfOnedoorProcess pmlWfOnedoorProcess, boolean merge) instead.");
        }

        return update(pmlWfOnedoorProcess, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlWfOnedoorProcess the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlWfOnedoorProcess is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlWfOnedoorProcess update(PmlWfOnedoorProcess pmlWfOnedoorProcess,
        boolean merge) throws SystemException {
        boolean isNew = pmlWfOnedoorProcess.isNew();

        for (ModelListener<PmlWfOnedoorProcess> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlWfOnedoorProcess);
            } else {
                listener.onBeforeUpdate(pmlWfOnedoorProcess);
            }
        }

        pmlWfOnedoorProcess = updateImpl(pmlWfOnedoorProcess, merge);

        for (ModelListener<PmlWfOnedoorProcess> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlWfOnedoorProcess);
            } else {
                listener.onAfterUpdate(pmlWfOnedoorProcess);
            }
        }

        return pmlWfOnedoorProcess;
    }

    public PmlWfOnedoorProcess updateImpl(
        com.nss.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlWfOnedoorProcess, merge);

            pmlWfOnedoorProcess.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlWfOnedoorProcessModelImpl.ENTITY_CACHE_ENABLED,
            PmlWfOnedoorProcessImpl.class, pmlWfOnedoorProcess.getPrimaryKey(),
            pmlWfOnedoorProcess);

        return pmlWfOnedoorProcess;
    }

    public PmlWfOnedoorProcess findByPrimaryKey(String fileId)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        PmlWfOnedoorProcess pmlWfOnedoorProcess = fetchByPrimaryKey(fileId);

        if (pmlWfOnedoorProcess == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlWfOnedoorProcess exists with the primary key " +
                    fileId);
            }

            throw new NoSuchPmlWfOnedoorProcessException(
                "No PmlWfOnedoorProcess exists with the primary key " + fileId);
        }

        return pmlWfOnedoorProcess;
    }

    public PmlWfOnedoorProcess fetchByPrimaryKey(String fileId)
        throws SystemException {
        PmlWfOnedoorProcess pmlWfOnedoorProcess = (PmlWfOnedoorProcess) EntityCacheUtil.getResult(PmlWfOnedoorProcessModelImpl.ENTITY_CACHE_ENABLED,
                PmlWfOnedoorProcessImpl.class, fileId, this);

        if (pmlWfOnedoorProcess == null) {
            Session session = null;

            try {
                session = openSession();

                pmlWfOnedoorProcess = (PmlWfOnedoorProcess) session.get(PmlWfOnedoorProcessImpl.class,
                        fileId);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlWfOnedoorProcess != null) {
                    cacheResult(pmlWfOnedoorProcess);
                }

                closeSession(session);
            }
        }

        return pmlWfOnedoorProcess;
    }

    public List<PmlWfOnedoorProcess> findByProcessId(long processId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(processId) };

        List<PmlWfOnedoorProcess> list = (List<PmlWfOnedoorProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PROCESSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWfOnedoorProcess WHERE ");

                query.append("processId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlWfOnedoorProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PROCESSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlWfOnedoorProcess> findByProcessId(long processId, int start,
        int end) throws SystemException {
        return findByProcessId(processId, start, end, null);
    }

    public List<PmlWfOnedoorProcess> findByProcessId(long processId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(processId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlWfOnedoorProcess> list = (List<PmlWfOnedoorProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PROCESSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWfOnedoorProcess WHERE ");

                query.append("processId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId);

                list = (List<PmlWfOnedoorProcess>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlWfOnedoorProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PROCESSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlWfOnedoorProcess findByProcessId_First(long processId,
        OrderByComparator obc)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        List<PmlWfOnedoorProcess> list = findByProcessId(processId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWfOnedoorProcess exists with the key {");

            msg.append("processId=" + processId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWfOnedoorProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWfOnedoorProcess findByProcessId_Last(long processId,
        OrderByComparator obc)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        int count = countByProcessId(processId);

        List<PmlWfOnedoorProcess> list = findByProcessId(processId, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlWfOnedoorProcess exists with the key {");

            msg.append("processId=" + processId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlWfOnedoorProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlWfOnedoorProcess[] findByProcessId_PrevAndNext(String fileId,
        long processId, OrderByComparator obc)
        throws NoSuchPmlWfOnedoorProcessException, SystemException {
        PmlWfOnedoorProcess pmlWfOnedoorProcess = findByPrimaryKey(fileId);

        int count = countByProcessId(processId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.onedoor.model.PmlWfOnedoorProcess WHERE ");

            query.append("processId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlWfOnedoorProcess);

            PmlWfOnedoorProcess[] array = new PmlWfOnedoorProcessImpl[3];

            array[0] = (PmlWfOnedoorProcess) objArray[0];
            array[1] = (PmlWfOnedoorProcess) objArray[1];
            array[2] = (PmlWfOnedoorProcess) objArray[2];

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

    public List<PmlWfOnedoorProcess> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlWfOnedoorProcess> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlWfOnedoorProcess> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlWfOnedoorProcess> list = (List<PmlWfOnedoorProcess>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWfOnedoorProcess ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlWfOnedoorProcess>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlWfOnedoorProcess>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlWfOnedoorProcess>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByProcessId(long processId) throws SystemException {
        for (PmlWfOnedoorProcess pmlWfOnedoorProcess : findByProcessId(
                processId)) {
            remove(pmlWfOnedoorProcess);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlWfOnedoorProcess pmlWfOnedoorProcess : findAll()) {
            remove(pmlWfOnedoorProcess);
        }
    }

    public int countByProcessId(long processId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(processId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PROCESSID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.onedoor.model.PmlWfOnedoorProcess WHERE ");

                query.append("processId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PROCESSID,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.onedoor.model.PmlWfOnedoorProcess");

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
                        "value.object.listener.com.nss.portlet.onedoor.model.PmlWfOnedoorProcess")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlWfOnedoorProcess>> listenersList = new ArrayList<ModelListener<PmlWfOnedoorProcess>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlWfOnedoorProcess>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
