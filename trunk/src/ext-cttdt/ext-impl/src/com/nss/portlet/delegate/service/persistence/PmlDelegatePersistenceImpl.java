package com.nss.portlet.delegate.service.persistence;

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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.delegate.NoSuchPmlDelegateException;
import com.nss.portlet.delegate.model.PmlDelegate;
import com.nss.portlet.delegate.model.impl.PmlDelegateImpl;
import com.nss.portlet.delegate.model.impl.PmlDelegateModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class PmlDelegatePersistenceImpl extends BasePersistenceImpl
    implements PmlDelegatePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlDelegateImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_RECEIVE_STARTDATE_CANCELDATE_CANCELDELEGATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceive_StartDate_CancelDate_CancelDelegate",
            new String[] {
                Long.class.getName(), Date.class.getName(), Date.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_RECEIVE_STARTDATE_CANCELDATE_CANCELDELEGATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceive_StartDate_CancelDate_CancelDelegate",
            new String[] {
                Long.class.getName(), Date.class.getName(), Date.class.getName(),
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_RECEIVE_STARTDATE_CANCELDATE_CANCELDELEGATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByReceive_StartDate_CancelDate_CancelDelegate",
            new String[] {
                Long.class.getName(), Date.class.getName(), Date.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_RECEIVE_STARTDATE_ENDDATE_CANCELDELEGATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceive_StartDate_EndDate_CancelDelegate",
            new String[] {
                Long.class.getName(), Date.class.getName(), Date.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_RECEIVE_STARTDATE_ENDDATE_CANCELDELEGATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceive_StartDate_EndDate_CancelDelegate",
            new String[] {
                Long.class.getName(), Date.class.getName(), Date.class.getName(),
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_RECEIVE_STARTDATE_ENDDATE_CANCELDELEGATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByReceive_StartDate_EndDate_CancelDelegate",
            new String[] {
                Long.class.getName(), Date.class.getName(), Date.class.getName(),
                String.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_RECEIVE_STARTDATE_ENDDATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceive_StartDate_EndDate",
            new String[] {
                Long.class.getName(), Date.class.getName(), Date.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_RECEIVE_STARTDATE_ENDDATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceive_StartDate_EndDate",
            new String[] {
                Long.class.getName(), Date.class.getName(), Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_RECEIVE_STARTDATE_ENDDATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByReceive_StartDate_EndDate",
            new String[] {
                Long.class.getName(), Date.class.getName(), Date.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_DATECREATED = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDateCreated", new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DATECREATED = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDateCreated",
            new String[] {
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DATECREATED = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDateCreated", new String[] { Date.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_CANCELDELEGATE = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCancelDelegate", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_CANCELDELEGATE = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCancelDelegate",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_CANCELDELEGATE = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByCancelDelegate", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ASSIGNER_RECEIVER_STARTDATE_ENDDATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAssigner_Receiver_StartDate_EndDate",
            new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                Date.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ASSIGNER_RECEIVER_STARTDATE_ENDDATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAssigner_Receiver_StartDate_EndDate",
            new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                Date.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ASSIGNER_RECEIVER_STARTDATE_ENDDATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByAssigner_Receiver_StartDate_EndDate",
            new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                Date.class.getName()
            });
    public static final FinderPath FINDER_PATH_FIND_BY_ASSIGNER = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAssigner", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ASSIGNER = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAssigner",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ASSIGNER = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByAssigner", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_RECEIVER = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceiver", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_RECEIVER = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceiver",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_RECEIVER = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByReceiver", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_ASSIGNER_RECEIVER = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAssigner_Receiver",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ASSIGNER_RECEIVER = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAssigner_Receiver",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ASSIGNER_RECEIVER = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByAssigner_Receiver",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_RECEIVER_CANCELDELEGATE = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceiver_CancelDelegate",
            new String[] { Long.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_RECEIVER_CANCELDELEGATE =
        new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByReceiver_CancelDelegate",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_RECEIVER_CANCELDELEGATE = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByReceiver_CancelDelegate",
            new String[] { Long.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlDelegatePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.delegate.service.persistence.PmlDelegatePersistence.impl")
    protected com.nss.portlet.delegate.service.persistence.PmlDelegatePersistence pmlDelegatePersistence;
    @BeanReference(name = "com.nss.portlet.delegate.service.persistence.PmlFileTypeDelegatePersistence.impl")
    protected com.nss.portlet.delegate.service.persistence.PmlFileTypeDelegatePersistence pmlFileTypeDelegatePersistence;

    public void cacheResult(PmlDelegate pmlDelegate) {
        EntityCacheUtil.putResult(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateImpl.class, pmlDelegate.getPrimaryKey(), pmlDelegate);
    }

    public void cacheResult(List<PmlDelegate> pmlDelegates) {
        for (PmlDelegate pmlDelegate : pmlDelegates) {
            if (EntityCacheUtil.getResult(
                        PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
                        PmlDelegateImpl.class, pmlDelegate.getPrimaryKey(), this) == null) {
                cacheResult(pmlDelegate);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlDelegateImpl.class.getName());
        EntityCacheUtil.clearCache(PmlDelegateImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlDelegate create(long delegateId) {
        PmlDelegate pmlDelegate = new PmlDelegateImpl();

        pmlDelegate.setNew(true);
        pmlDelegate.setPrimaryKey(delegateId);

        return pmlDelegate;
    }

    public PmlDelegate remove(long delegateId)
        throws NoSuchPmlDelegateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlDelegate pmlDelegate = (PmlDelegate) session.get(PmlDelegateImpl.class,
                    new Long(delegateId));

            if (pmlDelegate == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlDelegate exists with the primary key " +
                        delegateId);
                }

                throw new NoSuchPmlDelegateException(
                    "No PmlDelegate exists with the primary key " + delegateId);
            }

            return remove(pmlDelegate);
        } catch (NoSuchPmlDelegateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlDelegate remove(PmlDelegate pmlDelegate)
        throws SystemException {
        for (ModelListener<PmlDelegate> listener : listeners) {
            listener.onBeforeRemove(pmlDelegate);
        }

        pmlDelegate = removeImpl(pmlDelegate);

        for (ModelListener<PmlDelegate> listener : listeners) {
            listener.onAfterRemove(pmlDelegate);
        }

        return pmlDelegate;
    }

    protected PmlDelegate removeImpl(PmlDelegate pmlDelegate)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlDelegate.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlDelegateImpl.class,
                        pmlDelegate.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlDelegate);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateImpl.class, pmlDelegate.getPrimaryKey());

        return pmlDelegate;
    }

    /**
     * @deprecated Use <code>update(PmlDelegate pmlDelegate, boolean merge)</code>.
     */
    public PmlDelegate update(PmlDelegate pmlDelegate)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlDelegate pmlDelegate) method. Use update(PmlDelegate pmlDelegate, boolean merge) instead.");
        }

        return update(pmlDelegate, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDelegate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDelegate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlDelegate update(PmlDelegate pmlDelegate, boolean merge)
        throws SystemException {
        boolean isNew = pmlDelegate.isNew();

        for (ModelListener<PmlDelegate> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlDelegate);
            } else {
                listener.onBeforeUpdate(pmlDelegate);
            }
        }

        pmlDelegate = updateImpl(pmlDelegate, merge);

        for (ModelListener<PmlDelegate> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlDelegate);
            } else {
                listener.onAfterUpdate(pmlDelegate);
            }
        }

        return pmlDelegate;
    }

    public PmlDelegate updateImpl(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlDelegate, merge);

            pmlDelegate.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlDelegateImpl.class, pmlDelegate.getPrimaryKey(), pmlDelegate);

        return pmlDelegate;
    }

    public PmlDelegate findByPrimaryKey(long delegateId)
        throws NoSuchPmlDelegateException, SystemException {
        PmlDelegate pmlDelegate = fetchByPrimaryKey(delegateId);

        if (pmlDelegate == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlDelegate exists with the primary key " +
                    delegateId);
            }

            throw new NoSuchPmlDelegateException(
                "No PmlDelegate exists with the primary key " + delegateId);
        }

        return pmlDelegate;
    }

    public PmlDelegate fetchByPrimaryKey(long delegateId)
        throws SystemException {
        PmlDelegate pmlDelegate = (PmlDelegate) EntityCacheUtil.getResult(PmlDelegateModelImpl.ENTITY_CACHE_ENABLED,
                PmlDelegateImpl.class, delegateId, this);

        if (pmlDelegate == null) {
            Session session = null;

            try {
                session = openSession();

                pmlDelegate = (PmlDelegate) session.get(PmlDelegateImpl.class,
                        new Long(delegateId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlDelegate != null) {
                    cacheResult(pmlDelegate);
                }

                closeSession(session);
            }
        }

        return pmlDelegate;
    }

    public List<PmlDelegate> findByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, Date startDate, Date cancelDate, String cancelDelegate)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
                startDate,
                
                cancelDate,
                
                cancelDelegate
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_RECEIVE_STARTDATE_CANCELDATE_CANCELDELEGATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startdate <= null");
                } else {
                    query.append("startdate <= ?");
                }

                query.append(" AND ");

                if (cancelDate == null) {
                    query.append("canceldate >= null");
                } else {
                    query.append("canceldate >= ?");
                }

                query.append(" AND ");

                if (cancelDelegate == null) {
                    query.append("canceldelegate IS NULL");
                } else {
                    query.append("canceldelegate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("delegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (cancelDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(cancelDate));
                }

                if (cancelDelegate != null) {
                    qPos.add(cancelDelegate);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_RECEIVE_STARTDATE_CANCELDATE_CANCELDELEGATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDelegate> findByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, Date startDate, Date cancelDate, String cancelDelegate,
        int start, int end) throws SystemException {
        return findByReceive_StartDate_CancelDate_CancelDelegate(receiver,
            startDate, cancelDate, cancelDelegate, start, end, null);
    }

    public List<PmlDelegate> findByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, Date startDate, Date cancelDate, String cancelDelegate,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
                startDate,
                
                cancelDate,
                
                cancelDelegate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_RECEIVE_STARTDATE_CANCELDATE_CANCELDELEGATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startdate <= null");
                } else {
                    query.append("startdate <= ?");
                }

                query.append(" AND ");

                if (cancelDate == null) {
                    query.append("canceldate >= null");
                } else {
                    query.append("canceldate >= ?");
                }

                query.append(" AND ");

                if (cancelDelegate == null) {
                    query.append("canceldelegate IS NULL");
                } else {
                    query.append("canceldelegate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("delegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (cancelDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(cancelDate));
                }

                if (cancelDelegate != null) {
                    qPos.add(cancelDelegate);
                }

                list = (List<PmlDelegate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_RECEIVE_STARTDATE_CANCELDATE_CANCELDELEGATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDelegate findByReceive_StartDate_CancelDate_CancelDelegate_First(
        long receiver, Date startDate, Date cancelDate, String cancelDelegate,
        OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        List<PmlDelegate> list = findByReceive_StartDate_CancelDate_CancelDelegate(receiver,
                startDate, cancelDate, cancelDelegate, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(", ");
            msg.append("startDate=" + startDate);

            msg.append(", ");
            msg.append("cancelDate=" + cancelDate);

            msg.append(", ");
            msg.append("cancelDelegate=" + cancelDelegate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate findByReceive_StartDate_CancelDate_CancelDelegate_Last(
        long receiver, Date startDate, Date cancelDate, String cancelDelegate,
        OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        int count = countByReceive_StartDate_CancelDate_CancelDelegate(receiver,
                startDate, cancelDate, cancelDelegate);

        List<PmlDelegate> list = findByReceive_StartDate_CancelDate_CancelDelegate(receiver,
                startDate, cancelDate, cancelDelegate, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(", ");
            msg.append("startDate=" + startDate);

            msg.append(", ");
            msg.append("cancelDate=" + cancelDate);

            msg.append(", ");
            msg.append("cancelDelegate=" + cancelDelegate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate[] findByReceive_StartDate_CancelDate_CancelDelegate_PrevAndNext(
        long delegateId, long receiver, Date startDate, Date cancelDate,
        String cancelDelegate, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        PmlDelegate pmlDelegate = findByPrimaryKey(delegateId);

        int count = countByReceive_StartDate_CancelDate_CancelDelegate(receiver,
                startDate, cancelDate, cancelDelegate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

            query.append("receiver = ?");

            query.append(" AND ");

            if (startDate == null) {
                query.append("startdate <= null");
            } else {
                query.append("startdate <= ?");
            }

            query.append(" AND ");

            if (cancelDate == null) {
                query.append("canceldate >= null");
            } else {
                query.append("canceldate >= ?");
            }

            query.append(" AND ");

            if (cancelDelegate == null) {
                query.append("canceldelegate IS NULL");
            } else {
                query.append("canceldelegate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("delegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(receiver);

            if (startDate != null) {
                qPos.add(CalendarUtil.getTimestamp(startDate));
            }

            if (cancelDate != null) {
                qPos.add(CalendarUtil.getTimestamp(cancelDate));
            }

            if (cancelDelegate != null) {
                qPos.add(cancelDelegate);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDelegate);

            PmlDelegate[] array = new PmlDelegateImpl[3];

            array[0] = (PmlDelegate) objArray[0];
            array[1] = (PmlDelegate) objArray[1];
            array[2] = (PmlDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDelegate> findByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, Date startDate, Date endDate, String cancelDelegate)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
                startDate,
                
                endDate,
                
                cancelDelegate
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_RECEIVE_STARTDATE_ENDDATE_CANCELDELEGATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startdate <= null");
                } else {
                    query.append("startdate <= ?");
                }

                query.append(" AND ");

                if (endDate == null) {
                    query.append("enddate >= null");
                } else {
                    query.append("enddate >= ?");
                }

                query.append(" AND ");

                if (cancelDelegate == null) {
                    query.append("canceldelegate IS NULL");
                } else {
                    query.append("canceldelegate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("delegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (endDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(endDate));
                }

                if (cancelDelegate != null) {
                    qPos.add(cancelDelegate);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_RECEIVE_STARTDATE_ENDDATE_CANCELDELEGATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDelegate> findByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, Date startDate, Date endDate, String cancelDelegate,
        int start, int end) throws SystemException {
        return findByReceive_StartDate_EndDate_CancelDelegate(receiver,
            startDate, endDate, cancelDelegate, start, end, null);
    }

    public List<PmlDelegate> findByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, Date startDate, Date endDate, String cancelDelegate,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
                startDate,
                
                endDate,
                
                cancelDelegate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_RECEIVE_STARTDATE_ENDDATE_CANCELDELEGATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startdate <= null");
                } else {
                    query.append("startdate <= ?");
                }

                query.append(" AND ");

                if (endDate == null) {
                    query.append("enddate >= null");
                } else {
                    query.append("enddate >= ?");
                }

                query.append(" AND ");

                if (cancelDelegate == null) {
                    query.append("canceldelegate IS NULL");
                } else {
                    query.append("canceldelegate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("delegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (endDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(endDate));
                }

                if (cancelDelegate != null) {
                    qPos.add(cancelDelegate);
                }

                list = (List<PmlDelegate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_RECEIVE_STARTDATE_ENDDATE_CANCELDELEGATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDelegate findByReceive_StartDate_EndDate_CancelDelegate_First(
        long receiver, Date startDate, Date endDate, String cancelDelegate,
        OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        List<PmlDelegate> list = findByReceive_StartDate_EndDate_CancelDelegate(receiver,
                startDate, endDate, cancelDelegate, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(", ");
            msg.append("startDate=" + startDate);

            msg.append(", ");
            msg.append("endDate=" + endDate);

            msg.append(", ");
            msg.append("cancelDelegate=" + cancelDelegate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate findByReceive_StartDate_EndDate_CancelDelegate_Last(
        long receiver, Date startDate, Date endDate, String cancelDelegate,
        OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        int count = countByReceive_StartDate_EndDate_CancelDelegate(receiver,
                startDate, endDate, cancelDelegate);

        List<PmlDelegate> list = findByReceive_StartDate_EndDate_CancelDelegate(receiver,
                startDate, endDate, cancelDelegate, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(", ");
            msg.append("startDate=" + startDate);

            msg.append(", ");
            msg.append("endDate=" + endDate);

            msg.append(", ");
            msg.append("cancelDelegate=" + cancelDelegate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate[] findByReceive_StartDate_EndDate_CancelDelegate_PrevAndNext(
        long delegateId, long receiver, Date startDate, Date endDate,
        String cancelDelegate, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        PmlDelegate pmlDelegate = findByPrimaryKey(delegateId);

        int count = countByReceive_StartDate_EndDate_CancelDelegate(receiver,
                startDate, endDate, cancelDelegate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

            query.append("receiver = ?");

            query.append(" AND ");

            if (startDate == null) {
                query.append("startdate <= null");
            } else {
                query.append("startdate <= ?");
            }

            query.append(" AND ");

            if (endDate == null) {
                query.append("enddate >= null");
            } else {
                query.append("enddate >= ?");
            }

            query.append(" AND ");

            if (cancelDelegate == null) {
                query.append("canceldelegate IS NULL");
            } else {
                query.append("canceldelegate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("delegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(receiver);

            if (startDate != null) {
                qPos.add(CalendarUtil.getTimestamp(startDate));
            }

            if (endDate != null) {
                qPos.add(CalendarUtil.getTimestamp(endDate));
            }

            if (cancelDelegate != null) {
                qPos.add(cancelDelegate);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDelegate);

            PmlDelegate[] array = new PmlDelegateImpl[3];

            array[0] = (PmlDelegate) objArray[0];
            array[1] = (PmlDelegate) objArray[1];
            array[2] = (PmlDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDelegate> findByReceive_StartDate_EndDate(long receiver,
        Date startDate, Date endDate) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
                startDate,
                
                endDate
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_RECEIVE_STARTDATE_ENDDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startdate <= null");
                } else {
                    query.append("startdate <= ?");
                }

                query.append(" AND ");

                if (endDate == null) {
                    query.append("enddate >= null");
                } else {
                    query.append("enddate >= ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("delegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (endDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(endDate));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_RECEIVE_STARTDATE_ENDDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDelegate> findByReceive_StartDate_EndDate(long receiver,
        Date startDate, Date endDate, int start, int end)
        throws SystemException {
        return findByReceive_StartDate_EndDate(receiver, startDate, endDate,
            start, end, null);
    }

    public List<PmlDelegate> findByReceive_StartDate_EndDate(long receiver,
        Date startDate, Date endDate, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
                startDate,
                
                endDate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_RECEIVE_STARTDATE_ENDDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startdate <= null");
                } else {
                    query.append("startdate <= ?");
                }

                query.append(" AND ");

                if (endDate == null) {
                    query.append("enddate >= null");
                } else {
                    query.append("enddate >= ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("delegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (endDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(endDate));
                }

                list = (List<PmlDelegate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_RECEIVE_STARTDATE_ENDDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDelegate findByReceive_StartDate_EndDate_First(long receiver,
        Date startDate, Date endDate, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        List<PmlDelegate> list = findByReceive_StartDate_EndDate(receiver,
                startDate, endDate, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(", ");
            msg.append("startDate=" + startDate);

            msg.append(", ");
            msg.append("endDate=" + endDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate findByReceive_StartDate_EndDate_Last(long receiver,
        Date startDate, Date endDate, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        int count = countByReceive_StartDate_EndDate(receiver, startDate,
                endDate);

        List<PmlDelegate> list = findByReceive_StartDate_EndDate(receiver,
                startDate, endDate, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(", ");
            msg.append("startDate=" + startDate);

            msg.append(", ");
            msg.append("endDate=" + endDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate[] findByReceive_StartDate_EndDate_PrevAndNext(
        long delegateId, long receiver, Date startDate, Date endDate,
        OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        PmlDelegate pmlDelegate = findByPrimaryKey(delegateId);

        int count = countByReceive_StartDate_EndDate(receiver, startDate,
                endDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

            query.append("receiver = ?");

            query.append(" AND ");

            if (startDate == null) {
                query.append("startdate <= null");
            } else {
                query.append("startdate <= ?");
            }

            query.append(" AND ");

            if (endDate == null) {
                query.append("enddate >= null");
            } else {
                query.append("enddate >= ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("delegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(receiver);

            if (startDate != null) {
                qPos.add(CalendarUtil.getTimestamp(startDate));
            }

            if (endDate != null) {
                qPos.add(CalendarUtil.getTimestamp(endDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDelegate);

            PmlDelegate[] array = new PmlDelegateImpl[3];

            array[0] = (PmlDelegate) objArray[0];
            array[1] = (PmlDelegate) objArray[1];
            array[2] = (PmlDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDelegate> findByDateCreated(Date dateCreated)
        throws SystemException {
        Object[] finderArgs = new Object[] { dateCreated };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DATECREATED,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                if (dateCreated == null) {
                    query.append("datecreated IS NULL");
                } else {
                    query.append("datecreated = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("delegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DATECREATED,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDelegate> findByDateCreated(Date dateCreated, int start,
        int end) throws SystemException {
        return findByDateCreated(dateCreated, start, end, null);
    }

    public List<PmlDelegate> findByDateCreated(Date dateCreated, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                dateCreated,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DATECREATED,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                if (dateCreated == null) {
                    query.append("datecreated IS NULL");
                } else {
                    query.append("datecreated = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("delegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                list = (List<PmlDelegate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DATECREATED,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDelegate findByDateCreated_First(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        List<PmlDelegate> list = findByDateCreated(dateCreated, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate findByDateCreated_Last(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        int count = countByDateCreated(dateCreated);

        List<PmlDelegate> list = findByDateCreated(dateCreated, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate[] findByDateCreated_PrevAndNext(long delegateId,
        Date dateCreated, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        PmlDelegate pmlDelegate = findByPrimaryKey(delegateId);

        int count = countByDateCreated(dateCreated);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

            if (dateCreated == null) {
                query.append("datecreated IS NULL");
            } else {
                query.append("datecreated = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("delegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateCreated != null) {
                qPos.add(CalendarUtil.getTimestamp(dateCreated));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDelegate);

            PmlDelegate[] array = new PmlDelegateImpl[3];

            array[0] = (PmlDelegate) objArray[0];
            array[1] = (PmlDelegate) objArray[1];
            array[2] = (PmlDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDelegate> findByCancelDelegate(String cancelDelegate)
        throws SystemException {
        Object[] finderArgs = new Object[] { cancelDelegate };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CANCELDELEGATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                if (cancelDelegate == null) {
                    query.append("canceldelegate IS NULL");
                } else {
                    query.append("canceldelegate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("delegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cancelDelegate != null) {
                    qPos.add(cancelDelegate);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CANCELDELEGATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDelegate> findByCancelDelegate(String cancelDelegate,
        int start, int end) throws SystemException {
        return findByCancelDelegate(cancelDelegate, start, end, null);
    }

    public List<PmlDelegate> findByCancelDelegate(String cancelDelegate,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                cancelDelegate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CANCELDELEGATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                if (cancelDelegate == null) {
                    query.append("canceldelegate IS NULL");
                } else {
                    query.append("canceldelegate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("delegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cancelDelegate != null) {
                    qPos.add(cancelDelegate);
                }

                list = (List<PmlDelegate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CANCELDELEGATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDelegate findByCancelDelegate_First(String cancelDelegate,
        OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        List<PmlDelegate> list = findByCancelDelegate(cancelDelegate, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("cancelDelegate=" + cancelDelegate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate findByCancelDelegate_Last(String cancelDelegate,
        OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        int count = countByCancelDelegate(cancelDelegate);

        List<PmlDelegate> list = findByCancelDelegate(cancelDelegate,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("cancelDelegate=" + cancelDelegate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate[] findByCancelDelegate_PrevAndNext(long delegateId,
        String cancelDelegate, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        PmlDelegate pmlDelegate = findByPrimaryKey(delegateId);

        int count = countByCancelDelegate(cancelDelegate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

            if (cancelDelegate == null) {
                query.append("canceldelegate IS NULL");
            } else {
                query.append("canceldelegate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("delegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (cancelDelegate != null) {
                qPos.add(cancelDelegate);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDelegate);

            PmlDelegate[] array = new PmlDelegateImpl[3];

            array[0] = (PmlDelegate) objArray[0];
            array[1] = (PmlDelegate) objArray[1];
            array[2] = (PmlDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDelegate> findByAssigner_Receiver_StartDate_EndDate(
        long assigner, long receiver, Date startDate, Date endDate)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(assigner), new Long(receiver),
                
                startDate,
                
                endDate
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ASSIGNER_RECEIVER_STARTDATE_ENDDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("assigner = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startdate IS NULL");
                } else {
                    query.append("startdate = ?");
                }

                query.append(" AND ");

                if (endDate == null) {
                    query.append("enddate IS NULL");
                } else {
                    query.append("enddate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("delegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(assigner);

                qPos.add(receiver);

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (endDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(endDate));
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ASSIGNER_RECEIVER_STARTDATE_ENDDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDelegate> findByAssigner_Receiver_StartDate_EndDate(
        long assigner, long receiver, Date startDate, Date endDate, int start,
        int end) throws SystemException {
        return findByAssigner_Receiver_StartDate_EndDate(assigner, receiver,
            startDate, endDate, start, end, null);
    }

    public List<PmlDelegate> findByAssigner_Receiver_StartDate_EndDate(
        long assigner, long receiver, Date startDate, Date endDate, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(assigner), new Long(receiver),
                
                startDate,
                
                endDate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ASSIGNER_RECEIVER_STARTDATE_ENDDATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("assigner = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startdate IS NULL");
                } else {
                    query.append("startdate = ?");
                }

                query.append(" AND ");

                if (endDate == null) {
                    query.append("enddate IS NULL");
                } else {
                    query.append("enddate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("delegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(assigner);

                qPos.add(receiver);

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (endDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(endDate));
                }

                list = (List<PmlDelegate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ASSIGNER_RECEIVER_STARTDATE_ENDDATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDelegate findByAssigner_Receiver_StartDate_EndDate_First(
        long assigner, long receiver, Date startDate, Date endDate,
        OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        List<PmlDelegate> list = findByAssigner_Receiver_StartDate_EndDate(assigner,
                receiver, startDate, endDate, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("assigner=" + assigner);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(", ");
            msg.append("startDate=" + startDate);

            msg.append(", ");
            msg.append("endDate=" + endDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate findByAssigner_Receiver_StartDate_EndDate_Last(
        long assigner, long receiver, Date startDate, Date endDate,
        OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        int count = countByAssigner_Receiver_StartDate_EndDate(assigner,
                receiver, startDate, endDate);

        List<PmlDelegate> list = findByAssigner_Receiver_StartDate_EndDate(assigner,
                receiver, startDate, endDate, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("assigner=" + assigner);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(", ");
            msg.append("startDate=" + startDate);

            msg.append(", ");
            msg.append("endDate=" + endDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate[] findByAssigner_Receiver_StartDate_EndDate_PrevAndNext(
        long delegateId, long assigner, long receiver, Date startDate,
        Date endDate, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        PmlDelegate pmlDelegate = findByPrimaryKey(delegateId);

        int count = countByAssigner_Receiver_StartDate_EndDate(assigner,
                receiver, startDate, endDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

            query.append("assigner = ?");

            query.append(" AND ");

            query.append("receiver = ?");

            query.append(" AND ");

            if (startDate == null) {
                query.append("startdate IS NULL");
            } else {
                query.append("startdate = ?");
            }

            query.append(" AND ");

            if (endDate == null) {
                query.append("enddate IS NULL");
            } else {
                query.append("enddate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("delegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(assigner);

            qPos.add(receiver);

            if (startDate != null) {
                qPos.add(CalendarUtil.getTimestamp(startDate));
            }

            if (endDate != null) {
                qPos.add(CalendarUtil.getTimestamp(endDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDelegate);

            PmlDelegate[] array = new PmlDelegateImpl[3];

            array[0] = (PmlDelegate) objArray[0];
            array[1] = (PmlDelegate) objArray[1];
            array[2] = (PmlDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDelegate> findByAssigner(long assigner)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(assigner) };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ASSIGNER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("assigner = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("delegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(assigner);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ASSIGNER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDelegate> findByAssigner(long assigner, int start, int end)
        throws SystemException {
        return findByAssigner(assigner, start, end, null);
    }

    public List<PmlDelegate> findByAssigner(long assigner, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(assigner),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ASSIGNER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("assigner = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("delegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(assigner);

                list = (List<PmlDelegate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ASSIGNER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDelegate findByAssigner_First(long assigner, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        List<PmlDelegate> list = findByAssigner(assigner, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("assigner=" + assigner);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate findByAssigner_Last(long assigner, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        int count = countByAssigner(assigner);

        List<PmlDelegate> list = findByAssigner(assigner, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("assigner=" + assigner);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate[] findByAssigner_PrevAndNext(long delegateId,
        long assigner, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        PmlDelegate pmlDelegate = findByPrimaryKey(delegateId);

        int count = countByAssigner(assigner);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

            query.append("assigner = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("delegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(assigner);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDelegate);

            PmlDelegate[] array = new PmlDelegateImpl[3];

            array[0] = (PmlDelegate) objArray[0];
            array[1] = (PmlDelegate) objArray[1];
            array[2] = (PmlDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDelegate> findByReceiver(long receiver)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(receiver) };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_RECEIVER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("delegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_RECEIVER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDelegate> findByReceiver(long receiver, int start, int end)
        throws SystemException {
        return findByReceiver(receiver, start, end, null);
    }

    public List<PmlDelegate> findByReceiver(long receiver, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_RECEIVER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("delegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                list = (List<PmlDelegate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_RECEIVER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDelegate findByReceiver_First(long receiver, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        List<PmlDelegate> list = findByReceiver(receiver, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate findByReceiver_Last(long receiver, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        int count = countByReceiver(receiver);

        List<PmlDelegate> list = findByReceiver(receiver, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate[] findByReceiver_PrevAndNext(long delegateId,
        long receiver, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        PmlDelegate pmlDelegate = findByPrimaryKey(delegateId);

        int count = countByReceiver(receiver);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

            query.append("receiver = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("delegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(receiver);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDelegate);

            PmlDelegate[] array = new PmlDelegateImpl[3];

            array[0] = (PmlDelegate) objArray[0];
            array[1] = (PmlDelegate) objArray[1];
            array[2] = (PmlDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDelegate> findByAssigner_Receiver(long assigner,
        long receiver) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(assigner), new Long(receiver)
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ASSIGNER_RECEIVER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("assigner = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("delegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(assigner);

                qPos.add(receiver);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ASSIGNER_RECEIVER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDelegate> findByAssigner_Receiver(long assigner,
        long receiver, int start, int end) throws SystemException {
        return findByAssigner_Receiver(assigner, receiver, start, end, null);
    }

    public List<PmlDelegate> findByAssigner_Receiver(long assigner,
        long receiver, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(assigner), new Long(receiver),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ASSIGNER_RECEIVER,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("assigner = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("delegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(assigner);

                qPos.add(receiver);

                list = (List<PmlDelegate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ASSIGNER_RECEIVER,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDelegate findByAssigner_Receiver_First(long assigner,
        long receiver, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        List<PmlDelegate> list = findByAssigner_Receiver(assigner, receiver, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("assigner=" + assigner);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate findByAssigner_Receiver_Last(long assigner,
        long receiver, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        int count = countByAssigner_Receiver(assigner, receiver);

        List<PmlDelegate> list = findByAssigner_Receiver(assigner, receiver,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("assigner=" + assigner);

            msg.append(", ");
            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate[] findByAssigner_Receiver_PrevAndNext(long delegateId,
        long assigner, long receiver, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        PmlDelegate pmlDelegate = findByPrimaryKey(delegateId);

        int count = countByAssigner_Receiver(assigner, receiver);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

            query.append("assigner = ?");

            query.append(" AND ");

            query.append("receiver = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("delegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(assigner);

            qPos.add(receiver);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDelegate);

            PmlDelegate[] array = new PmlDelegateImpl[3];

            array[0] = (PmlDelegate) objArray[0];
            array[1] = (PmlDelegate) objArray[1];
            array[2] = (PmlDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDelegate> findByReceiver_CancelDelegate(long receiver,
        String cancelDelegate) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(receiver), cancelDelegate };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_RECEIVER_CANCELDELEGATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (cancelDelegate == null) {
                    query.append("canceldelegate IS NULL");
                } else {
                    query.append("canceldelegate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("delegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                if (cancelDelegate != null) {
                    qPos.add(cancelDelegate);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_RECEIVER_CANCELDELEGATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDelegate> findByReceiver_CancelDelegate(long receiver,
        String cancelDelegate, int start, int end) throws SystemException {
        return findByReceiver_CancelDelegate(receiver, cancelDelegate, start,
            end, null);
    }

    public List<PmlDelegate> findByReceiver_CancelDelegate(long receiver,
        String cancelDelegate, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
                cancelDelegate,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_RECEIVER_CANCELDELEGATE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (cancelDelegate == null) {
                    query.append("canceldelegate IS NULL");
                } else {
                    query.append("canceldelegate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("delegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                if (cancelDelegate != null) {
                    qPos.add(cancelDelegate);
                }

                list = (List<PmlDelegate>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_RECEIVER_CANCELDELEGATE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDelegate findByReceiver_CancelDelegate_First(long receiver,
        String cancelDelegate, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        List<PmlDelegate> list = findByReceiver_CancelDelegate(receiver,
                cancelDelegate, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(", ");
            msg.append("cancelDelegate=" + cancelDelegate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate findByReceiver_CancelDelegate_Last(long receiver,
        String cancelDelegate, OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        int count = countByReceiver_CancelDelegate(receiver, cancelDelegate);

        List<PmlDelegate> list = findByReceiver_CancelDelegate(receiver,
                cancelDelegate, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDelegate exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(", ");
            msg.append("cancelDelegate=" + cancelDelegate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDelegate[] findByReceiver_CancelDelegate_PrevAndNext(
        long delegateId, long receiver, String cancelDelegate,
        OrderByComparator obc)
        throws NoSuchPmlDelegateException, SystemException {
        PmlDelegate pmlDelegate = findByPrimaryKey(delegateId);

        int count = countByReceiver_CancelDelegate(receiver, cancelDelegate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

            query.append("receiver = ?");

            query.append(" AND ");

            if (cancelDelegate == null) {
                query.append("canceldelegate IS NULL");
            } else {
                query.append("canceldelegate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("delegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(receiver);

            if (cancelDelegate != null) {
                qPos.add(cancelDelegate);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDelegate);

            PmlDelegate[] array = new PmlDelegateImpl[3];

            array[0] = (PmlDelegate) objArray[0];
            array[1] = (PmlDelegate) objArray[1];
            array[2] = (PmlDelegate) objArray[2];

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

    public List<PmlDelegate> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlDelegate> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlDelegate> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDelegate> list = (List<PmlDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.delegate.model.PmlDelegate ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("delegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlDelegate>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlDelegate>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, Date startDate, Date cancelDate, String cancelDelegate)
        throws SystemException {
        for (PmlDelegate pmlDelegate : findByReceive_StartDate_CancelDate_CancelDelegate(
                receiver, startDate, cancelDate, cancelDelegate)) {
            remove(pmlDelegate);
        }
    }

    public void removeByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, Date startDate, Date endDate, String cancelDelegate)
        throws SystemException {
        for (PmlDelegate pmlDelegate : findByReceive_StartDate_EndDate_CancelDelegate(
                receiver, startDate, endDate, cancelDelegate)) {
            remove(pmlDelegate);
        }
    }

    public void removeByReceive_StartDate_EndDate(long receiver,
        Date startDate, Date endDate) throws SystemException {
        for (PmlDelegate pmlDelegate : findByReceive_StartDate_EndDate(
                receiver, startDate, endDate)) {
            remove(pmlDelegate);
        }
    }

    public void removeByDateCreated(Date dateCreated) throws SystemException {
        for (PmlDelegate pmlDelegate : findByDateCreated(dateCreated)) {
            remove(pmlDelegate);
        }
    }

    public void removeByCancelDelegate(String cancelDelegate)
        throws SystemException {
        for (PmlDelegate pmlDelegate : findByCancelDelegate(cancelDelegate)) {
            remove(pmlDelegate);
        }
    }

    public void removeByAssigner_Receiver_StartDate_EndDate(long assigner,
        long receiver, Date startDate, Date endDate) throws SystemException {
        for (PmlDelegate pmlDelegate : findByAssigner_Receiver_StartDate_EndDate(
                assigner, receiver, startDate, endDate)) {
            remove(pmlDelegate);
        }
    }

    public void removeByAssigner(long assigner) throws SystemException {
        for (PmlDelegate pmlDelegate : findByAssigner(assigner)) {
            remove(pmlDelegate);
        }
    }

    public void removeByReceiver(long receiver) throws SystemException {
        for (PmlDelegate pmlDelegate : findByReceiver(receiver)) {
            remove(pmlDelegate);
        }
    }

    public void removeByAssigner_Receiver(long assigner, long receiver)
        throws SystemException {
        for (PmlDelegate pmlDelegate : findByAssigner_Receiver(assigner,
                receiver)) {
            remove(pmlDelegate);
        }
    }

    public void removeByReceiver_CancelDelegate(long receiver,
        String cancelDelegate) throws SystemException {
        for (PmlDelegate pmlDelegate : findByReceiver_CancelDelegate(receiver,
                cancelDelegate)) {
            remove(pmlDelegate);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlDelegate pmlDelegate : findAll()) {
            remove(pmlDelegate);
        }
    }

    public int countByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, Date startDate, Date cancelDate, String cancelDelegate)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
                startDate,
                
                cancelDate,
                
                cancelDelegate
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RECEIVE_STARTDATE_CANCELDATE_CANCELDELEGATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startdate <= null");
                } else {
                    query.append("startdate <= ?");
                }

                query.append(" AND ");

                if (cancelDate == null) {
                    query.append("canceldate >= null");
                } else {
                    query.append("canceldate >= ?");
                }

                query.append(" AND ");

                if (cancelDelegate == null) {
                    query.append("canceldelegate IS NULL");
                } else {
                    query.append("canceldelegate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (cancelDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(cancelDate));
                }

                if (cancelDelegate != null) {
                    qPos.add(cancelDelegate);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIVE_STARTDATE_CANCELDATE_CANCELDELEGATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByReceive_StartDate_EndDate_CancelDelegate(long receiver,
        Date startDate, Date endDate, String cancelDelegate)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
                startDate,
                
                endDate,
                
                cancelDelegate
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RECEIVE_STARTDATE_ENDDATE_CANCELDELEGATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startdate <= null");
                } else {
                    query.append("startdate <= ?");
                }

                query.append(" AND ");

                if (endDate == null) {
                    query.append("enddate >= null");
                } else {
                    query.append("enddate >= ?");
                }

                query.append(" AND ");

                if (cancelDelegate == null) {
                    query.append("canceldelegate IS NULL");
                } else {
                    query.append("canceldelegate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (endDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(endDate));
                }

                if (cancelDelegate != null) {
                    qPos.add(cancelDelegate);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIVE_STARTDATE_ENDDATE_CANCELDELEGATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByReceive_StartDate_EndDate(long receiver, Date startDate,
        Date endDate) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
                startDate,
                
                endDate
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RECEIVE_STARTDATE_ENDDATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startdate <= null");
                } else {
                    query.append("startdate <= ?");
                }

                query.append(" AND ");

                if (endDate == null) {
                    query.append("enddate >= null");
                } else {
                    query.append("enddate >= ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (endDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(endDate));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIVE_STARTDATE_ENDDATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDateCreated(Date dateCreated) throws SystemException {
        Object[] finderArgs = new Object[] { dateCreated };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DATECREATED,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                if (dateCreated == null) {
                    query.append("datecreated IS NULL");
                } else {
                    query.append("datecreated = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DATECREATED,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByCancelDelegate(String cancelDelegate)
        throws SystemException {
        Object[] finderArgs = new Object[] { cancelDelegate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CANCELDELEGATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                if (cancelDelegate == null) {
                    query.append("canceldelegate IS NULL");
                } else {
                    query.append("canceldelegate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (cancelDelegate != null) {
                    qPos.add(cancelDelegate);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CANCELDELEGATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByAssigner_Receiver_StartDate_EndDate(long assigner,
        long receiver, Date startDate, Date endDate) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(assigner), new Long(receiver),
                
                startDate,
                
                endDate
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ASSIGNER_RECEIVER_STARTDATE_ENDDATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("assigner = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (startDate == null) {
                    query.append("startdate IS NULL");
                } else {
                    query.append("startdate = ?");
                }

                query.append(" AND ");

                if (endDate == null) {
                    query.append("enddate IS NULL");
                } else {
                    query.append("enddate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(assigner);

                qPos.add(receiver);

                if (startDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (endDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(endDate));
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ASSIGNER_RECEIVER_STARTDATE_ENDDATE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByAssigner(long assigner) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(assigner) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ASSIGNER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("assigner = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(assigner);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ASSIGNER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByReceiver(long receiver) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(receiver) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RECEIVER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIVER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByAssigner_Receiver(long assigner, long receiver)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(assigner), new Long(receiver)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ASSIGNER_RECEIVER,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("assigner = ?");

                query.append(" AND ");

                query.append("receiver = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(assigner);

                qPos.add(receiver);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ASSIGNER_RECEIVER,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByReceiver_CancelDelegate(long receiver,
        String cancelDelegate) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(receiver), cancelDelegate };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_RECEIVER_CANCELDELEGATE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlDelegate WHERE ");

                query.append("receiver = ?");

                query.append(" AND ");

                if (cancelDelegate == null) {
                    query.append("canceldelegate IS NULL");
                } else {
                    query.append("canceldelegate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                if (cancelDelegate != null) {
                    qPos.add(cancelDelegate);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RECEIVER_CANCELDELEGATE,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.delegate.model.PmlDelegate");

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
                        "value.object.listener.com.nss.portlet.delegate.model.PmlDelegate")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlDelegate>> listenersList = new ArrayList<ModelListener<PmlDelegate>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlDelegate>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
