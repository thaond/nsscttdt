package com.nss.portlet.journalworkflow.service.persistence;

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

import com.nss.portlet.journalworkflow.NoSuchInstanceBeanException;
import com.nss.portlet.journalworkflow.model.InstanceBean;
import com.nss.portlet.journalworkflow.model.impl.InstanceBeanImpl;
import com.nss.portlet.journalworkflow.model.impl.InstanceBeanModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class InstanceBeanPersistenceImpl extends BasePersistenceImpl
    implements InstanceBeanPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = InstanceBeanImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_STATUS = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByStatus", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATUS = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByStatus",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByStatus", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_STATUS_FINISH = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByStatus_Finish",
            new String[] { String.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_STATUS_FINISH = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByStatus_Finish",
            new String[] {
                String.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_STATUS_FINISH = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByStatus_Finish",
            new String[] { String.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_PREVIOUSNODE = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByPreviousNode",
            new String[] { String.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_PREVIOUSNODE = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByPreviousNode",
            new String[] {
                String.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_PREVIOUSNODE = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByPreviousNode",
            new String[] { String.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ARTICLEID = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByArticleId",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ARTICLEID = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByArticleId",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ARTICLEID = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByArticleId",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_CREATEUSERID = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCreateUserId",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_CREATEUSERID = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCreateUserId",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_CREATEUSERID = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByCreateUserId",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_BUSINESSPROCESSID = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByBusinessProcessId",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_BUSINESSPROCESSID = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByBusinessProcessId",
            new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_BUSINESSPROCESSID = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByBusinessProcessId",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(InstanceBeanPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.journalworkflow.service.persistence.JournalProcessDefinitionPersistence.impl")
    protected com.nss.portlet.journalworkflow.service.persistence.JournalProcessDefinitionPersistence journalProcessDefinitionPersistence;
    @BeanReference(name = "com.nss.portlet.journalworkflow.service.persistence.InstanceBeanPersistence.impl")
    protected com.nss.portlet.journalworkflow.service.persistence.InstanceBeanPersistence instanceBeanPersistence;

    public void cacheResult(InstanceBean instanceBean) {
        EntityCacheUtil.putResult(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanImpl.class, instanceBean.getPrimaryKey(), instanceBean);
    }

    public void cacheResult(List<InstanceBean> instanceBeans) {
        for (InstanceBean instanceBean : instanceBeans) {
            if (EntityCacheUtil.getResult(
                        InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
                        InstanceBeanImpl.class, instanceBean.getPrimaryKey(),
                        this) == null) {
                cacheResult(instanceBean);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(InstanceBeanImpl.class.getName());
        EntityCacheUtil.clearCache(InstanceBeanImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public InstanceBean create(long processInstanceId) {
        InstanceBean instanceBean = new InstanceBeanImpl();

        instanceBean.setNew(true);
        instanceBean.setPrimaryKey(processInstanceId);

        return instanceBean;
    }

    public InstanceBean remove(long processInstanceId)
        throws NoSuchInstanceBeanException, SystemException {
        Session session = null;

        try {
            session = openSession();

            InstanceBean instanceBean = (InstanceBean) session.get(InstanceBeanImpl.class,
                    new Long(processInstanceId));

            if (instanceBean == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No InstanceBean exists with the primary key " +
                        processInstanceId);
                }

                throw new NoSuchInstanceBeanException(
                    "No InstanceBean exists with the primary key " +
                    processInstanceId);
            }

            return remove(instanceBean);
        } catch (NoSuchInstanceBeanException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public InstanceBean remove(InstanceBean instanceBean)
        throws SystemException {
        for (ModelListener<InstanceBean> listener : listeners) {
            listener.onBeforeRemove(instanceBean);
        }

        instanceBean = removeImpl(instanceBean);

        for (ModelListener<InstanceBean> listener : listeners) {
            listener.onAfterRemove(instanceBean);
        }

        return instanceBean;
    }

    protected InstanceBean removeImpl(InstanceBean instanceBean)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (instanceBean.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(InstanceBeanImpl.class,
                        instanceBean.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(instanceBean);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanImpl.class, instanceBean.getPrimaryKey());

        return instanceBean;
    }

    /**
     * @deprecated Use <code>update(InstanceBean instanceBean, boolean merge)</code>.
     */
    public InstanceBean update(InstanceBean instanceBean)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(InstanceBean instanceBean) method. Use update(InstanceBean instanceBean, boolean merge) instead.");
        }

        return update(instanceBean, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                instanceBean the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when instanceBean is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public InstanceBean update(InstanceBean instanceBean, boolean merge)
        throws SystemException {
        boolean isNew = instanceBean.isNew();

        for (ModelListener<InstanceBean> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(instanceBean);
            } else {
                listener.onBeforeUpdate(instanceBean);
            }
        }

        instanceBean = updateImpl(instanceBean, merge);

        for (ModelListener<InstanceBean> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(instanceBean);
            } else {
                listener.onAfterUpdate(instanceBean);
            }
        }

        return instanceBean;
    }

    public InstanceBean updateImpl(
        com.nss.portlet.journalworkflow.model.InstanceBean instanceBean,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, instanceBean, merge);

            instanceBean.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
            InstanceBeanImpl.class, instanceBean.getPrimaryKey(), instanceBean);

        return instanceBean;
    }

    public InstanceBean findByPrimaryKey(long processInstanceId)
        throws NoSuchInstanceBeanException, SystemException {
        InstanceBean instanceBean = fetchByPrimaryKey(processInstanceId);

        if (instanceBean == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No InstanceBean exists with the primary key " +
                    processInstanceId);
            }

            throw new NoSuchInstanceBeanException(
                "No InstanceBean exists with the primary key " +
                processInstanceId);
        }

        return instanceBean;
    }

    public InstanceBean fetchByPrimaryKey(long processInstanceId)
        throws SystemException {
        InstanceBean instanceBean = (InstanceBean) EntityCacheUtil.getResult(InstanceBeanModelImpl.ENTITY_CACHE_ENABLED,
                InstanceBeanImpl.class, processInstanceId, this);

        if (instanceBean == null) {
            Session session = null;

            try {
                session = openSession();

                instanceBean = (InstanceBean) session.get(InstanceBeanImpl.class,
                        new Long(processInstanceId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (instanceBean != null) {
                    cacheResult(instanceBean);
                }

                closeSession(session);
            }
        }

        return instanceBean;
    }

    public List<InstanceBean> findByStatus(String status)
        throws SystemException {
        Object[] finderArgs = new Object[] { status };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATUS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                if (status == null) {
                    query.append("status IS NULL");
                } else {
                    query.append("status = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (status != null) {
                    qPos.add(status);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATUS,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<InstanceBean> findByStatus(String status, int start, int end)
        throws SystemException {
        return findByStatus(status, start, end, null);
    }

    public List<InstanceBean> findByStatus(String status, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                status,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATUS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                if (status == null) {
                    query.append("status IS NULL");
                } else {
                    query.append("status = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (status != null) {
                    qPos.add(status);
                }

                list = (List<InstanceBean>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATUS,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public InstanceBean findByStatus_First(String status, OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        List<InstanceBean> list = findByStatus(status, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No InstanceBean exists with the key {");

            msg.append("status=" + status);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchInstanceBeanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public InstanceBean findByStatus_Last(String status, OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        int count = countByStatus(status);

        List<InstanceBean> list = findByStatus(status, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No InstanceBean exists with the key {");

            msg.append("status=" + status);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchInstanceBeanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public InstanceBean[] findByStatus_PrevAndNext(long processInstanceId,
        String status, OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        InstanceBean instanceBean = findByPrimaryKey(processInstanceId);

        int count = countByStatus(status);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

            if (status == null) {
                query.append("status IS NULL");
            } else {
                query.append("status = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (status != null) {
                qPos.add(status);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    instanceBean);

            InstanceBean[] array = new InstanceBeanImpl[3];

            array[0] = (InstanceBean) objArray[0];
            array[1] = (InstanceBean) objArray[1];
            array[2] = (InstanceBean) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<InstanceBean> findByStatus_Finish(String status, boolean finish)
        throws SystemException {
        Object[] finderArgs = new Object[] { status, Boolean.valueOf(finish) };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_STATUS_FINISH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                if (status == null) {
                    query.append("status IS NULL");
                } else {
                    query.append("status = ?");
                }

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (status != null) {
                    qPos.add(status);
                }

                qPos.add(finish);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_STATUS_FINISH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<InstanceBean> findByStatus_Finish(String status,
        boolean finish, int start, int end) throws SystemException {
        return findByStatus_Finish(status, finish, start, end, null);
    }

    public List<InstanceBean> findByStatus_Finish(String status,
        boolean finish, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                status, Boolean.valueOf(finish),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_STATUS_FINISH,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                if (status == null) {
                    query.append("status IS NULL");
                } else {
                    query.append("status = ?");
                }

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (status != null) {
                    qPos.add(status);
                }

                qPos.add(finish);

                list = (List<InstanceBean>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_STATUS_FINISH,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public InstanceBean findByStatus_Finish_First(String status,
        boolean finish, OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        List<InstanceBean> list = findByStatus_Finish(status, finish, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No InstanceBean exists with the key {");

            msg.append("status=" + status);

            msg.append(", ");
            msg.append("finish=" + finish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchInstanceBeanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public InstanceBean findByStatus_Finish_Last(String status, boolean finish,
        OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        int count = countByStatus_Finish(status, finish);

        List<InstanceBean> list = findByStatus_Finish(status, finish,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No InstanceBean exists with the key {");

            msg.append("status=" + status);

            msg.append(", ");
            msg.append("finish=" + finish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchInstanceBeanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public InstanceBean[] findByStatus_Finish_PrevAndNext(
        long processInstanceId, String status, boolean finish,
        OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        InstanceBean instanceBean = findByPrimaryKey(processInstanceId);

        int count = countByStatus_Finish(status, finish);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

            if (status == null) {
                query.append("status IS NULL");
            } else {
                query.append("status = ?");
            }

            query.append(" AND ");

            query.append("finish = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (status != null) {
                qPos.add(status);
            }

            qPos.add(finish);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    instanceBean);

            InstanceBean[] array = new InstanceBeanImpl[3];

            array[0] = (InstanceBean) objArray[0];
            array[1] = (InstanceBean) objArray[1];
            array[2] = (InstanceBean) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<InstanceBean> findByPreviousNode(String previousNode,
        boolean finish) throws SystemException {
        Object[] finderArgs = new Object[] { previousNode, Boolean.valueOf(finish) };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_PREVIOUSNODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                if (previousNode == null) {
                    query.append("previousNode IS NULL");
                } else {
                    query.append("previousNode = ?");
                }

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (previousNode != null) {
                    qPos.add(previousNode);
                }

                qPos.add(finish);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_PREVIOUSNODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<InstanceBean> findByPreviousNode(String previousNode,
        boolean finish, int start, int end) throws SystemException {
        return findByPreviousNode(previousNode, finish, start, end, null);
    }

    public List<InstanceBean> findByPreviousNode(String previousNode,
        boolean finish, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                previousNode, Boolean.valueOf(finish),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_PREVIOUSNODE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                if (previousNode == null) {
                    query.append("previousNode IS NULL");
                } else {
                    query.append("previousNode = ?");
                }

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (previousNode != null) {
                    qPos.add(previousNode);
                }

                qPos.add(finish);

                list = (List<InstanceBean>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_PREVIOUSNODE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public InstanceBean findByPreviousNode_First(String previousNode,
        boolean finish, OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        List<InstanceBean> list = findByPreviousNode(previousNode, finish, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No InstanceBean exists with the key {");

            msg.append("previousNode=" + previousNode);

            msg.append(", ");
            msg.append("finish=" + finish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchInstanceBeanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public InstanceBean findByPreviousNode_Last(String previousNode,
        boolean finish, OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        int count = countByPreviousNode(previousNode, finish);

        List<InstanceBean> list = findByPreviousNode(previousNode, finish,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No InstanceBean exists with the key {");

            msg.append("previousNode=" + previousNode);

            msg.append(", ");
            msg.append("finish=" + finish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchInstanceBeanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public InstanceBean[] findByPreviousNode_PrevAndNext(
        long processInstanceId, String previousNode, boolean finish,
        OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        InstanceBean instanceBean = findByPrimaryKey(processInstanceId);

        int count = countByPreviousNode(previousNode, finish);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

            if (previousNode == null) {
                query.append("previousNode IS NULL");
            } else {
                query.append("previousNode = ?");
            }

            query.append(" AND ");

            query.append("finish = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (previousNode != null) {
                qPos.add(previousNode);
            }

            qPos.add(finish);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    instanceBean);

            InstanceBean[] array = new InstanceBeanImpl[3];

            array[0] = (InstanceBean) objArray[0];
            array[1] = (InstanceBean) objArray[1];
            array[2] = (InstanceBean) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<InstanceBean> findByArticleId(long articleId, boolean finish)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(articleId), Boolean.valueOf(finish)
            };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ARTICLEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                query.append("articleId = ?");

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(articleId);

                qPos.add(finish);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ARTICLEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<InstanceBean> findByArticleId(long articleId, boolean finish,
        int start, int end) throws SystemException {
        return findByArticleId(articleId, finish, start, end, null);
    }

    public List<InstanceBean> findByArticleId(long articleId, boolean finish,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(articleId), Boolean.valueOf(finish),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ARTICLEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                query.append("articleId = ?");

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(articleId);

                qPos.add(finish);

                list = (List<InstanceBean>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ARTICLEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public InstanceBean findByArticleId_First(long articleId, boolean finish,
        OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        List<InstanceBean> list = findByArticleId(articleId, finish, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No InstanceBean exists with the key {");

            msg.append("articleId=" + articleId);

            msg.append(", ");
            msg.append("finish=" + finish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchInstanceBeanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public InstanceBean findByArticleId_Last(long articleId, boolean finish,
        OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        int count = countByArticleId(articleId, finish);

        List<InstanceBean> list = findByArticleId(articleId, finish, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No InstanceBean exists with the key {");

            msg.append("articleId=" + articleId);

            msg.append(", ");
            msg.append("finish=" + finish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchInstanceBeanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public InstanceBean[] findByArticleId_PrevAndNext(long processInstanceId,
        long articleId, boolean finish, OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        InstanceBean instanceBean = findByPrimaryKey(processInstanceId);

        int count = countByArticleId(articleId, finish);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

            query.append("articleId = ?");

            query.append(" AND ");

            query.append("finish = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(articleId);

            qPos.add(finish);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    instanceBean);

            InstanceBean[] array = new InstanceBeanImpl[3];

            array[0] = (InstanceBean) objArray[0];
            array[1] = (InstanceBean) objArray[1];
            array[2] = (InstanceBean) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<InstanceBean> findByCreateUserId(long createUserId,
        boolean finish) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(createUserId), Boolean.valueOf(finish)
            };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CREATEUSERID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                query.append("createUserId = ?");

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(createUserId);

                qPos.add(finish);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CREATEUSERID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<InstanceBean> findByCreateUserId(long createUserId,
        boolean finish, int start, int end) throws SystemException {
        return findByCreateUserId(createUserId, finish, start, end, null);
    }

    public List<InstanceBean> findByCreateUserId(long createUserId,
        boolean finish, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(createUserId), Boolean.valueOf(finish),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CREATEUSERID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                query.append("createUserId = ?");

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(createUserId);

                qPos.add(finish);

                list = (List<InstanceBean>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CREATEUSERID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public InstanceBean findByCreateUserId_First(long createUserId,
        boolean finish, OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        List<InstanceBean> list = findByCreateUserId(createUserId, finish, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No InstanceBean exists with the key {");

            msg.append("createUserId=" + createUserId);

            msg.append(", ");
            msg.append("finish=" + finish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchInstanceBeanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public InstanceBean findByCreateUserId_Last(long createUserId,
        boolean finish, OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        int count = countByCreateUserId(createUserId, finish);

        List<InstanceBean> list = findByCreateUserId(createUserId, finish,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No InstanceBean exists with the key {");

            msg.append("createUserId=" + createUserId);

            msg.append(", ");
            msg.append("finish=" + finish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchInstanceBeanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public InstanceBean[] findByCreateUserId_PrevAndNext(
        long processInstanceId, long createUserId, boolean finish,
        OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        InstanceBean instanceBean = findByPrimaryKey(processInstanceId);

        int count = countByCreateUserId(createUserId, finish);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

            query.append("createUserId = ?");

            query.append(" AND ");

            query.append("finish = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(createUserId);

            qPos.add(finish);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    instanceBean);

            InstanceBean[] array = new InstanceBeanImpl[3];

            array[0] = (InstanceBean) objArray[0];
            array[1] = (InstanceBean) objArray[1];
            array[2] = (InstanceBean) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<InstanceBean> findByBusinessProcessId(long businessProcessId,
        boolean finish) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(businessProcessId), Boolean.valueOf(finish)
            };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_BUSINESSPROCESSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                query.append("businessProcessId = ?");

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(businessProcessId);

                qPos.add(finish);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_BUSINESSPROCESSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<InstanceBean> findByBusinessProcessId(long businessProcessId,
        boolean finish, int start, int end) throws SystemException {
        return findByBusinessProcessId(businessProcessId, finish, start, end,
            null);
    }

    public List<InstanceBean> findByBusinessProcessId(long businessProcessId,
        boolean finish, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(businessProcessId), Boolean.valueOf(finish),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_BUSINESSPROCESSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                query.append("businessProcessId = ?");

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(businessProcessId);

                qPos.add(finish);

                list = (List<InstanceBean>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_BUSINESSPROCESSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public InstanceBean findByBusinessProcessId_First(long businessProcessId,
        boolean finish, OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        List<InstanceBean> list = findByBusinessProcessId(businessProcessId,
                finish, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No InstanceBean exists with the key {");

            msg.append("businessProcessId=" + businessProcessId);

            msg.append(", ");
            msg.append("finish=" + finish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchInstanceBeanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public InstanceBean findByBusinessProcessId_Last(long businessProcessId,
        boolean finish, OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        int count = countByBusinessProcessId(businessProcessId, finish);

        List<InstanceBean> list = findByBusinessProcessId(businessProcessId,
                finish, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No InstanceBean exists with the key {");

            msg.append("businessProcessId=" + businessProcessId);

            msg.append(", ");
            msg.append("finish=" + finish);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchInstanceBeanException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public InstanceBean[] findByBusinessProcessId_PrevAndNext(
        long processInstanceId, long businessProcessId, boolean finish,
        OrderByComparator obc)
        throws NoSuchInstanceBeanException, SystemException {
        InstanceBean instanceBean = findByPrimaryKey(processInstanceId);

        int count = countByBusinessProcessId(businessProcessId, finish);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

            query.append("businessProcessId = ?");

            query.append(" AND ");

            query.append("finish = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(businessProcessId);

            qPos.add(finish);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    instanceBean);

            InstanceBean[] array = new InstanceBeanImpl[3];

            array[0] = (InstanceBean) objArray[0];
            array[1] = (InstanceBean) objArray[1];
            array[2] = (InstanceBean) objArray[2];

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

    public List<InstanceBean> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<InstanceBean> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<InstanceBean> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<InstanceBean> list = (List<InstanceBean>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<InstanceBean>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<InstanceBean>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<InstanceBean>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByStatus(String status) throws SystemException {
        for (InstanceBean instanceBean : findByStatus(status)) {
            remove(instanceBean);
        }
    }

    public void removeByStatus_Finish(String status, boolean finish)
        throws SystemException {
        for (InstanceBean instanceBean : findByStatus_Finish(status, finish)) {
            remove(instanceBean);
        }
    }

    public void removeByPreviousNode(String previousNode, boolean finish)
        throws SystemException {
        for (InstanceBean instanceBean : findByPreviousNode(previousNode, finish)) {
            remove(instanceBean);
        }
    }

    public void removeByArticleId(long articleId, boolean finish)
        throws SystemException {
        for (InstanceBean instanceBean : findByArticleId(articleId, finish)) {
            remove(instanceBean);
        }
    }

    public void removeByCreateUserId(long createUserId, boolean finish)
        throws SystemException {
        for (InstanceBean instanceBean : findByCreateUserId(createUserId, finish)) {
            remove(instanceBean);
        }
    }

    public void removeByBusinessProcessId(long businessProcessId, boolean finish)
        throws SystemException {
        for (InstanceBean instanceBean : findByBusinessProcessId(
                businessProcessId, finish)) {
            remove(instanceBean);
        }
    }

    public void removeAll() throws SystemException {
        for (InstanceBean instanceBean : findAll()) {
            remove(instanceBean);
        }
    }

    public int countByStatus(String status) throws SystemException {
        Object[] finderArgs = new Object[] { status };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                if (status == null) {
                    query.append("status IS NULL");
                } else {
                    query.append("status = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (status != null) {
                    qPos.add(status);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByStatus_Finish(String status, boolean finish)
        throws SystemException {
        Object[] finderArgs = new Object[] { status, Boolean.valueOf(finish) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS_FINISH,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                if (status == null) {
                    query.append("status IS NULL");
                } else {
                    query.append("status = ?");
                }

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (status != null) {
                    qPos.add(status);
                }

                qPos.add(finish);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS_FINISH,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByPreviousNode(String previousNode, boolean finish)
        throws SystemException {
        Object[] finderArgs = new Object[] { previousNode, Boolean.valueOf(finish) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PREVIOUSNODE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                if (previousNode == null) {
                    query.append("previousNode IS NULL");
                } else {
                    query.append("previousNode = ?");
                }

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (previousNode != null) {
                    qPos.add(previousNode);
                }

                qPos.add(finish);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PREVIOUSNODE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByArticleId(long articleId, boolean finish)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(articleId), Boolean.valueOf(finish)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ARTICLEID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                query.append("articleId = ?");

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(articleId);

                qPos.add(finish);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ARTICLEID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByCreateUserId(long createUserId, boolean finish)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(createUserId), Boolean.valueOf(finish)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATEUSERID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                query.append("createUserId = ?");

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(createUserId);

                qPos.add(finish);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREATEUSERID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByBusinessProcessId(long businessProcessId, boolean finish)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(businessProcessId), Boolean.valueOf(finish)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BUSINESSPROCESSID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.journalworkflow.model.InstanceBean WHERE ");

                query.append("businessProcessId = ?");

                query.append(" AND ");

                query.append("finish = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(businessProcessId);

                qPos.add(finish);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BUSINESSPROCESSID,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.journalworkflow.model.InstanceBean");

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
                        "value.object.listener.com.nss.portlet.journalworkflow.model.InstanceBean")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<InstanceBean>> listenersList = new ArrayList<ModelListener<InstanceBean>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<InstanceBean>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
