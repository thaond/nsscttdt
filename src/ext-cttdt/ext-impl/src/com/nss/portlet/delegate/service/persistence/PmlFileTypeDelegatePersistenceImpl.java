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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.nss.portlet.delegate.NoSuchPmlFileTypeDelegateException;
import com.nss.portlet.delegate.model.PmlFileTypeDelegate;
import com.nss.portlet.delegate.model.impl.PmlFileTypeDelegateImpl;
import com.nss.portlet.delegate.model.impl.PmlFileTypeDelegateModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlFileTypeDelegatePersistenceImpl extends BasePersistenceImpl
    implements PmlFileTypeDelegatePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlFileTypeDelegateImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPEID_DELEGATEID = new FinderPath(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId_DelegateId",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPEID_DELEGATEID =
        new FinderPath(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId_DelegateId",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPEID_DELEGATEID = new FinderPath(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileTypeId_DelegateId",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPEID = new FinderPath(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPEID = new FinderPath(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPEID = new FinderPath(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileTypeId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DELEGATEID = new FinderPath(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDelegateId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DELEGATEID = new FinderPath(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDelegateId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DELEGATEID = new FinderPath(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByDelegateId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlFileTypeDelegatePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.delegate.service.persistence.PmlDelegatePersistence.impl")
    protected com.nss.portlet.delegate.service.persistence.PmlDelegatePersistence pmlDelegatePersistence;
    @BeanReference(name = "com.nss.portlet.delegate.service.persistence.PmlFileTypeDelegatePersistence.impl")
    protected com.nss.portlet.delegate.service.persistence.PmlFileTypeDelegatePersistence pmlFileTypeDelegatePersistence;

    public void cacheResult(PmlFileTypeDelegate pmlFileTypeDelegate) {
        EntityCacheUtil.putResult(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateImpl.class, pmlFileTypeDelegate.getPrimaryKey(),
            pmlFileTypeDelegate);
    }

    public void cacheResult(List<PmlFileTypeDelegate> pmlFileTypeDelegates) {
        for (PmlFileTypeDelegate pmlFileTypeDelegate : pmlFileTypeDelegates) {
            if (EntityCacheUtil.getResult(
                        PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
                        PmlFileTypeDelegateImpl.class,
                        pmlFileTypeDelegate.getPrimaryKey(), this) == null) {
                cacheResult(pmlFileTypeDelegate);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlFileTypeDelegateImpl.class.getName());
        EntityCacheUtil.clearCache(PmlFileTypeDelegateImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlFileTypeDelegate create(long fileTypeDelegateId) {
        PmlFileTypeDelegate pmlFileTypeDelegate = new PmlFileTypeDelegateImpl();

        pmlFileTypeDelegate.setNew(true);
        pmlFileTypeDelegate.setPrimaryKey(fileTypeDelegateId);

        return pmlFileTypeDelegate;
    }

    public PmlFileTypeDelegate remove(long fileTypeDelegateId)
        throws NoSuchPmlFileTypeDelegateException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileTypeDelegate pmlFileTypeDelegate = (PmlFileTypeDelegate) session.get(PmlFileTypeDelegateImpl.class,
                    new Long(fileTypeDelegateId));

            if (pmlFileTypeDelegate == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlFileTypeDelegate exists with the primary key " +
                        fileTypeDelegateId);
                }

                throw new NoSuchPmlFileTypeDelegateException(
                    "No PmlFileTypeDelegate exists with the primary key " +
                    fileTypeDelegateId);
            }

            return remove(pmlFileTypeDelegate);
        } catch (NoSuchPmlFileTypeDelegateException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileTypeDelegate remove(PmlFileTypeDelegate pmlFileTypeDelegate)
        throws SystemException {
        for (ModelListener<PmlFileTypeDelegate> listener : listeners) {
            listener.onBeforeRemove(pmlFileTypeDelegate);
        }

        pmlFileTypeDelegate = removeImpl(pmlFileTypeDelegate);

        for (ModelListener<PmlFileTypeDelegate> listener : listeners) {
            listener.onAfterRemove(pmlFileTypeDelegate);
        }

        return pmlFileTypeDelegate;
    }

    protected PmlFileTypeDelegate removeImpl(
        PmlFileTypeDelegate pmlFileTypeDelegate) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlFileTypeDelegate.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlFileTypeDelegateImpl.class,
                        pmlFileTypeDelegate.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlFileTypeDelegate);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateImpl.class, pmlFileTypeDelegate.getPrimaryKey());

        return pmlFileTypeDelegate;
    }

    /**
     * @deprecated Use <code>update(PmlFileTypeDelegate pmlFileTypeDelegate, boolean merge)</code>.
     */
    public PmlFileTypeDelegate update(PmlFileTypeDelegate pmlFileTypeDelegate)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileTypeDelegate pmlFileTypeDelegate) method. Use update(PmlFileTypeDelegate pmlFileTypeDelegate, boolean merge) instead.");
        }

        return update(pmlFileTypeDelegate, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileTypeDelegate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileTypeDelegate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileTypeDelegate update(PmlFileTypeDelegate pmlFileTypeDelegate,
        boolean merge) throws SystemException {
        boolean isNew = pmlFileTypeDelegate.isNew();

        for (ModelListener<PmlFileTypeDelegate> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlFileTypeDelegate);
            } else {
                listener.onBeforeUpdate(pmlFileTypeDelegate);
            }
        }

        pmlFileTypeDelegate = updateImpl(pmlFileTypeDelegate, merge);

        for (ModelListener<PmlFileTypeDelegate> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlFileTypeDelegate);
            } else {
                listener.onAfterUpdate(pmlFileTypeDelegate);
            }
        }

        return pmlFileTypeDelegate;
    }

    public PmlFileTypeDelegate updateImpl(
        com.nss.portlet.delegate.model.PmlFileTypeDelegate pmlFileTypeDelegate,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlFileTypeDelegate, merge);

            pmlFileTypeDelegate.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
            PmlFileTypeDelegateImpl.class, pmlFileTypeDelegate.getPrimaryKey(),
            pmlFileTypeDelegate);

        return pmlFileTypeDelegate;
    }

    public PmlFileTypeDelegate findByPrimaryKey(long fileTypeDelegateId)
        throws NoSuchPmlFileTypeDelegateException, SystemException {
        PmlFileTypeDelegate pmlFileTypeDelegate = fetchByPrimaryKey(fileTypeDelegateId);

        if (pmlFileTypeDelegate == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlFileTypeDelegate exists with the primary key " +
                    fileTypeDelegateId);
            }

            throw new NoSuchPmlFileTypeDelegateException(
                "No PmlFileTypeDelegate exists with the primary key " +
                fileTypeDelegateId);
        }

        return pmlFileTypeDelegate;
    }

    public PmlFileTypeDelegate fetchByPrimaryKey(long fileTypeDelegateId)
        throws SystemException {
        PmlFileTypeDelegate pmlFileTypeDelegate = (PmlFileTypeDelegate) EntityCacheUtil.getResult(PmlFileTypeDelegateModelImpl.ENTITY_CACHE_ENABLED,
                PmlFileTypeDelegateImpl.class, fileTypeDelegateId, this);

        if (pmlFileTypeDelegate == null) {
            Session session = null;

            try {
                session = openSession();

                pmlFileTypeDelegate = (PmlFileTypeDelegate) session.get(PmlFileTypeDelegateImpl.class,
                        new Long(fileTypeDelegateId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlFileTypeDelegate != null) {
                    cacheResult(pmlFileTypeDelegate);
                }

                closeSession(session);
            }
        }

        return pmlFileTypeDelegate;
    }

    public List<PmlFileTypeDelegate> findByFileTypeId_DelegateId(
        String fileTypeId, long delegateId) throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId, new Long(delegateId) };

        List<PmlFileTypeDelegate> list = (List<PmlFileTypeDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPEID_DELEGATEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" AND ");

                query.append("delegateid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypedelegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                qPos.add(delegateId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPEID_DELEGATEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeDelegate> findByFileTypeId_DelegateId(
        String fileTypeId, long delegateId, int start, int end)
        throws SystemException {
        return findByFileTypeId_DelegateId(fileTypeId, delegateId, start, end,
            null);
    }

    public List<PmlFileTypeDelegate> findByFileTypeId_DelegateId(
        String fileTypeId, long delegateId, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId, new Long(delegateId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeDelegate> list = (List<PmlFileTypeDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID_DELEGATEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" AND ");

                query.append("delegateid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypedelegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                qPos.add(delegateId);

                list = (List<PmlFileTypeDelegate>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID_DELEGATEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeDelegate findByFileTypeId_DelegateId_First(
        String fileTypeId, long delegateId, OrderByComparator obc)
        throws NoSuchPmlFileTypeDelegateException, SystemException {
        List<PmlFileTypeDelegate> list = findByFileTypeId_DelegateId(fileTypeId,
                delegateId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeDelegate exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("delegateId=" + delegateId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeDelegate findByFileTypeId_DelegateId_Last(
        String fileTypeId, long delegateId, OrderByComparator obc)
        throws NoSuchPmlFileTypeDelegateException, SystemException {
        int count = countByFileTypeId_DelegateId(fileTypeId, delegateId);

        List<PmlFileTypeDelegate> list = findByFileTypeId_DelegateId(fileTypeId,
                delegateId, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeDelegate exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("delegateId=" + delegateId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeDelegate[] findByFileTypeId_DelegateId_PrevAndNext(
        long fileTypeDelegateId, String fileTypeId, long delegateId,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeDelegateException, SystemException {
        PmlFileTypeDelegate pmlFileTypeDelegate = findByPrimaryKey(fileTypeDelegateId);

        int count = countByFileTypeId_DelegateId(fileTypeId, delegateId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate WHERE ");

            if (fileTypeId == null) {
                query.append("filetypeid IS NULL");
            } else {
                query.append("filetypeid = ?");
            }

            query.append(" AND ");

            query.append("delegateid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypedelegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            qPos.add(delegateId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeDelegate);

            PmlFileTypeDelegate[] array = new PmlFileTypeDelegateImpl[3];

            array[0] = (PmlFileTypeDelegate) objArray[0];
            array[1] = (PmlFileTypeDelegate) objArray[1];
            array[2] = (PmlFileTypeDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeDelegate> findByFileTypeId(String fileTypeId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId };

        List<PmlFileTypeDelegate> list = (List<PmlFileTypeDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypedelegateid DESC");

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
                    list = new ArrayList<PmlFileTypeDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeDelegate> findByFileTypeId(String fileTypeId,
        int start, int end) throws SystemException {
        return findByFileTypeId(fileTypeId, start, end, null);
    }

    public List<PmlFileTypeDelegate> findByFileTypeId(String fileTypeId,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeDelegate> list = (List<PmlFileTypeDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate WHERE ");

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

                    query.append("filetypedelegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                list = (List<PmlFileTypeDelegate>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeDelegate findByFileTypeId_First(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeDelegateException, SystemException {
        List<PmlFileTypeDelegate> list = findByFileTypeId(fileTypeId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeDelegate exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeDelegate findByFileTypeId_Last(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeDelegateException, SystemException {
        int count = countByFileTypeId(fileTypeId);

        List<PmlFileTypeDelegate> list = findByFileTypeId(fileTypeId,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeDelegate exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeDelegate[] findByFileTypeId_PrevAndNext(
        long fileTypeDelegateId, String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlFileTypeDelegateException, SystemException {
        PmlFileTypeDelegate pmlFileTypeDelegate = findByPrimaryKey(fileTypeDelegateId);

        int count = countByFileTypeId(fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate WHERE ");

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

                query.append("filetypedelegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeDelegate);

            PmlFileTypeDelegate[] array = new PmlFileTypeDelegateImpl[3];

            array[0] = (PmlFileTypeDelegate) objArray[0];
            array[1] = (PmlFileTypeDelegate) objArray[1];
            array[2] = (PmlFileTypeDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeDelegate> findByDelegateId(long delegateId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(delegateId) };

        List<PmlFileTypeDelegate> list = (List<PmlFileTypeDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DELEGATEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate WHERE ");

                query.append("delegateid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypedelegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(delegateId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DELEGATEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlFileTypeDelegate> findByDelegateId(long delegateId,
        int start, int end) throws SystemException {
        return findByDelegateId(delegateId, start, end, null);
    }

    public List<PmlFileTypeDelegate> findByDelegateId(long delegateId,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(delegateId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeDelegate> list = (List<PmlFileTypeDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DELEGATEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate WHERE ");

                query.append("delegateid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypedelegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(delegateId);

                list = (List<PmlFileTypeDelegate>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DELEGATEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlFileTypeDelegate findByDelegateId_First(long delegateId,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeDelegateException, SystemException {
        List<PmlFileTypeDelegate> list = findByDelegateId(delegateId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeDelegate exists with the key {");

            msg.append("delegateId=" + delegateId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeDelegate findByDelegateId_Last(long delegateId,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeDelegateException, SystemException {
        int count = countByDelegateId(delegateId);

        List<PmlFileTypeDelegate> list = findByDelegateId(delegateId,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeDelegate exists with the key {");

            msg.append("delegateId=" + delegateId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeDelegateException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeDelegate[] findByDelegateId_PrevAndNext(
        long fileTypeDelegateId, long delegateId, OrderByComparator obc)
        throws NoSuchPmlFileTypeDelegateException, SystemException {
        PmlFileTypeDelegate pmlFileTypeDelegate = findByPrimaryKey(fileTypeDelegateId);

        int count = countByDelegateId(delegateId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate WHERE ");

            query.append("delegateid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypedelegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(delegateId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeDelegate);

            PmlFileTypeDelegate[] array = new PmlFileTypeDelegateImpl[3];

            array[0] = (PmlFileTypeDelegate) objArray[0];
            array[1] = (PmlFileTypeDelegate) objArray[1];
            array[2] = (PmlFileTypeDelegate) objArray[2];

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

    public List<PmlFileTypeDelegate> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileTypeDelegate> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileTypeDelegate> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlFileTypeDelegate> list = (List<PmlFileTypeDelegate>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypedelegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlFileTypeDelegate>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlFileTypeDelegate>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlFileTypeDelegate>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByFileTypeId_DelegateId(String fileTypeId, long delegateId)
        throws SystemException {
        for (PmlFileTypeDelegate pmlFileTypeDelegate : findByFileTypeId_DelegateId(
                fileTypeId, delegateId)) {
            remove(pmlFileTypeDelegate);
        }
    }

    public void removeByFileTypeId(String fileTypeId) throws SystemException {
        for (PmlFileTypeDelegate pmlFileTypeDelegate : findByFileTypeId(
                fileTypeId)) {
            remove(pmlFileTypeDelegate);
        }
    }

    public void removeByDelegateId(long delegateId) throws SystemException {
        for (PmlFileTypeDelegate pmlFileTypeDelegate : findByDelegateId(
                delegateId)) {
            remove(pmlFileTypeDelegate);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFileTypeDelegate pmlFileTypeDelegate : findAll()) {
            remove(pmlFileTypeDelegate);
        }
    }

    public int countByFileTypeId_DelegateId(String fileTypeId, long delegateId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId, new Long(delegateId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_FILETYPEID_DELEGATEID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" AND ");

                query.append("delegateid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                qPos.add(delegateId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_FILETYPEID_DELEGATEID,
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
                    "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate WHERE ");

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

    public int countByDelegateId(long delegateId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(delegateId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DELEGATEID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate WHERE ");

                query.append("delegateid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(delegateId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DELEGATEID,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.delegate.model.PmlFileTypeDelegate");

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
                        "value.object.listener.com.nss.portlet.delegate.model.PmlFileTypeDelegate")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlFileTypeDelegate>> listenersList = new ArrayList<ModelListener<PmlFileTypeDelegate>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlFileTypeDelegate>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
