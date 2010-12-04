package com.nss.portlet.department.service.persistence;

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

import com.nss.portlet.department.NoSuchPmlDepartmentsLeaderException;
import com.nss.portlet.department.model.PmlDepartmentsLeader;
import com.nss.portlet.department.model.impl.PmlDepartmentsLeaderImpl;
import com.nss.portlet.department.model.impl.PmlDepartmentsLeaderModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlDepartmentsLeaderPersistenceImpl extends BasePersistenceImpl
    implements PmlDepartmentsLeaderPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlDepartmentsLeaderImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_DEPARTMENTSID = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDepartmentsId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDepartmentsId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTSID = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByDepartmentsId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByUserId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByUserId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByUserId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DEPARTMENTSID_USERID = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDepartmentsId_UserId",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID_USERID = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDepartmentsId_UserId",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTSID_USERID = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByDepartmentsId_UserId",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DEPARTMENTSID_MAIN = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDepartmentsId_Main",
            new String[] { String.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID_MAIN = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByDepartmentsId_Main",
            new String[] {
                String.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTSID_MAIN = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByDepartmentsId_Main",
            new String[] { String.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_MAIN = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMain",
            new String[] { Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_MAIN = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByMain",
            new String[] {
                Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_MAIN = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByMain",
            new String[] { Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlDepartmentsLeaderPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.department.service.persistence.DepartmentPersistence.impl")
    protected com.nss.portlet.department.service.persistence.DepartmentPersistence departmentPersistence;
    @BeanReference(name = "com.nss.portlet.department.service.persistence.PmlUserPersistence.impl")
    protected com.nss.portlet.department.service.persistence.PmlUserPersistence pmlUserPersistence;
    @BeanReference(name = "com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPersistence.impl")
    protected com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPersistence pmlDepartmentsLeaderPersistence;

    public void cacheResult(PmlDepartmentsLeader pmlDepartmentsLeader) {
        EntityCacheUtil.putResult(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderImpl.class,
            pmlDepartmentsLeader.getPrimaryKey(), pmlDepartmentsLeader);
    }

    public void cacheResult(List<PmlDepartmentsLeader> pmlDepartmentsLeaders) {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : pmlDepartmentsLeaders) {
            if (EntityCacheUtil.getResult(
                        PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
                        PmlDepartmentsLeaderImpl.class,
                        pmlDepartmentsLeader.getPrimaryKey(), this) == null) {
                cacheResult(pmlDepartmentsLeader);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlDepartmentsLeaderImpl.class.getName());
        EntityCacheUtil.clearCache(PmlDepartmentsLeaderImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlDepartmentsLeader create(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK) {
        PmlDepartmentsLeader pmlDepartmentsLeader = new PmlDepartmentsLeaderImpl();

        pmlDepartmentsLeader.setNew(true);
        pmlDepartmentsLeader.setPrimaryKey(pmlDepartmentsLeaderPK);

        return pmlDepartmentsLeader;
    }

    public PmlDepartmentsLeader remove(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlDepartmentsLeader pmlDepartmentsLeader = (PmlDepartmentsLeader) session.get(PmlDepartmentsLeaderImpl.class,
                    pmlDepartmentsLeaderPK);

            if (pmlDepartmentsLeader == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlDepartmentsLeader exists with the primary key " +
                        pmlDepartmentsLeaderPK);
                }

                throw new NoSuchPmlDepartmentsLeaderException(
                    "No PmlDepartmentsLeader exists with the primary key " +
                    pmlDepartmentsLeaderPK);
            }

            return remove(pmlDepartmentsLeader);
        } catch (NoSuchPmlDepartmentsLeaderException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlDepartmentsLeader remove(
        PmlDepartmentsLeader pmlDepartmentsLeader) throws SystemException {
        for (ModelListener<PmlDepartmentsLeader> listener : listeners) {
            listener.onBeforeRemove(pmlDepartmentsLeader);
        }

        pmlDepartmentsLeader = removeImpl(pmlDepartmentsLeader);

        for (ModelListener<PmlDepartmentsLeader> listener : listeners) {
            listener.onAfterRemove(pmlDepartmentsLeader);
        }

        return pmlDepartmentsLeader;
    }

    protected PmlDepartmentsLeader removeImpl(
        PmlDepartmentsLeader pmlDepartmentsLeader) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlDepartmentsLeader.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlDepartmentsLeaderImpl.class,
                        pmlDepartmentsLeader.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlDepartmentsLeader);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderImpl.class, pmlDepartmentsLeader.getPrimaryKey());

        return pmlDepartmentsLeader;
    }

    /**
     * @deprecated Use <code>update(PmlDepartmentsLeader pmlDepartmentsLeader, boolean merge)</code>.
     */
    public PmlDepartmentsLeader update(
        PmlDepartmentsLeader pmlDepartmentsLeader) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlDepartmentsLeader pmlDepartmentsLeader) method. Use update(PmlDepartmentsLeader pmlDepartmentsLeader, boolean merge) instead.");
        }

        return update(pmlDepartmentsLeader, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDepartmentsLeader the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDepartmentsLeader is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlDepartmentsLeader update(
        PmlDepartmentsLeader pmlDepartmentsLeader, boolean merge)
        throws SystemException {
        boolean isNew = pmlDepartmentsLeader.isNew();

        for (ModelListener<PmlDepartmentsLeader> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlDepartmentsLeader);
            } else {
                listener.onBeforeUpdate(pmlDepartmentsLeader);
            }
        }

        pmlDepartmentsLeader = updateImpl(pmlDepartmentsLeader, merge);

        for (ModelListener<PmlDepartmentsLeader> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlDepartmentsLeader);
            } else {
                listener.onAfterUpdate(pmlDepartmentsLeader);
            }
        }

        return pmlDepartmentsLeader;
    }

    public PmlDepartmentsLeader updateImpl(
        com.nss.portlet.department.model.PmlDepartmentsLeader pmlDepartmentsLeader,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlDepartmentsLeader, merge);

            pmlDepartmentsLeader.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
            PmlDepartmentsLeaderImpl.class,
            pmlDepartmentsLeader.getPrimaryKey(), pmlDepartmentsLeader);

        return pmlDepartmentsLeader;
    }

    public PmlDepartmentsLeader findByPrimaryKey(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = fetchByPrimaryKey(pmlDepartmentsLeaderPK);

        if (pmlDepartmentsLeader == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlDepartmentsLeader exists with the primary key " +
                    pmlDepartmentsLeaderPK);
            }

            throw new NoSuchPmlDepartmentsLeaderException(
                "No PmlDepartmentsLeader exists with the primary key " +
                pmlDepartmentsLeaderPK);
        }

        return pmlDepartmentsLeader;
    }

    public PmlDepartmentsLeader fetchByPrimaryKey(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = (PmlDepartmentsLeader) EntityCacheUtil.getResult(PmlDepartmentsLeaderModelImpl.ENTITY_CACHE_ENABLED,
                PmlDepartmentsLeaderImpl.class, pmlDepartmentsLeaderPK, this);

        if (pmlDepartmentsLeader == null) {
            Session session = null;

            try {
                session = openSession();

                pmlDepartmentsLeader = (PmlDepartmentsLeader) session.get(PmlDepartmentsLeaderImpl.class,
                        pmlDepartmentsLeaderPK);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlDepartmentsLeader != null) {
                    cacheResult(pmlDepartmentsLeader);
                }

                closeSession(session);
            }
        }

        return pmlDepartmentsLeader;
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId(String departmentsId)
        throws SystemException {
        Object[] finderArgs = new Object[] { departmentsId };

        List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DEPARTMENTSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDepartmentsLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DEPARTMENTSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId(
        String departmentsId, int start, int end) throws SystemException {
        return findByDepartmentsId(departmentsId, start, end, null);
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId(
        String departmentsId, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                departmentsId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDepartmentsLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDepartmentsLeader findByDepartmentsId_First(
        String departmentsId, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        List<PmlDepartmentsLeader> list = findByDepartmentsId(departmentsId, 0,
                1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader findByDepartmentsId_Last(String departmentsId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        int count = countByDepartmentsId(departmentsId);

        List<PmlDepartmentsLeader> list = findByDepartmentsId(departmentsId,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader[] findByDepartmentsId_PrevAndNext(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK, String departmentsId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = findByPrimaryKey(pmlDepartmentsLeaderPK);

        int count = countByDepartmentsId(departmentsId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

            if (departmentsId == null) {
                query.append("departmentsId IS NULL");
            } else {
                query.append("departmentsId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDepartmentsLeader);

            PmlDepartmentsLeader[] array = new PmlDepartmentsLeaderImpl[3];

            array[0] = (PmlDepartmentsLeader) objArray[0];
            array[1] = (PmlDepartmentsLeader) objArray[1];
            array[2] = (PmlDepartmentsLeader) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDepartmentsLeader> findByUserId(long userId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(userId) };

        List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDepartmentsLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDepartmentsLeader> findByUserId(long userId, int start,
        int end) throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    public List<PmlDepartmentsLeader> findByUserId(long userId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(userId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                query.append("userId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDepartmentsLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDepartmentsLeader findByUserId_First(long userId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        List<PmlDepartmentsLeader> list = findByUserId(userId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader findByUserId_Last(long userId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        int count = countByUserId(userId);

        List<PmlDepartmentsLeader> list = findByUserId(userId, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader[] findByUserId_PrevAndNext(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK, long userId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = findByPrimaryKey(pmlDepartmentsLeaderPK);

        int count = countByUserId(userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

            query.append("userId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDepartmentsLeader);

            PmlDepartmentsLeader[] array = new PmlDepartmentsLeaderImpl[3];

            array[0] = (PmlDepartmentsLeader) objArray[0];
            array[1] = (PmlDepartmentsLeader) objArray[1];
            array[2] = (PmlDepartmentsLeader) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId_UserId(
        String departmentsId, long userId) throws SystemException {
        Object[] finderArgs = new Object[] { departmentsId, new Long(userId) };

        List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DEPARTMENTSID_USERID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" AND ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(userId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDepartmentsLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DEPARTMENTSID_USERID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId_UserId(
        String departmentsId, long userId, int start, int end)
        throws SystemException {
        return findByDepartmentsId_UserId(departmentsId, userId, start, end,
            null);
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId_UserId(
        String departmentsId, long userId, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                departmentsId, new Long(userId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID_USERID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" AND ");

                query.append("userId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(userId);

                list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDepartmentsLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID_USERID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDepartmentsLeader findByDepartmentsId_UserId_First(
        String departmentsId, long userId, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        List<PmlDepartmentsLeader> list = findByDepartmentsId_UserId(departmentsId,
                userId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader findByDepartmentsId_UserId_Last(
        String departmentsId, long userId, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        int count = countByDepartmentsId_UserId(departmentsId, userId);

        List<PmlDepartmentsLeader> list = findByDepartmentsId_UserId(departmentsId,
                userId, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader[] findByDepartmentsId_UserId_PrevAndNext(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK, String departmentsId,
        long userId, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = findByPrimaryKey(pmlDepartmentsLeaderPK);

        int count = countByDepartmentsId_UserId(departmentsId, userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

            if (departmentsId == null) {
                query.append("departmentsId IS NULL");
            } else {
                query.append("departmentsId = ?");
            }

            query.append(" AND ");

            query.append("userId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            qPos.add(userId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDepartmentsLeader);

            PmlDepartmentsLeader[] array = new PmlDepartmentsLeaderImpl[3];

            array[0] = (PmlDepartmentsLeader) objArray[0];
            array[1] = (PmlDepartmentsLeader) objArray[1];
            array[2] = (PmlDepartmentsLeader) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId_Main(
        String departmentsId, boolean main) throws SystemException {
        Object[] finderArgs = new Object[] { departmentsId, Boolean.valueOf(main) };

        List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DEPARTMENTSID_MAIN,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" AND ");

                query.append("main = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(main);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDepartmentsLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DEPARTMENTSID_MAIN,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId_Main(
        String departmentsId, boolean main, int start, int end)
        throws SystemException {
        return findByDepartmentsId_Main(departmentsId, main, start, end, null);
    }

    public List<PmlDepartmentsLeader> findByDepartmentsId_Main(
        String departmentsId, boolean main, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                departmentsId, Boolean.valueOf(main),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID_MAIN,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" AND ");

                query.append("main = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(main);

                list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDepartmentsLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID_MAIN,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDepartmentsLeader findByDepartmentsId_Main_First(
        String departmentsId, boolean main, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        List<PmlDepartmentsLeader> list = findByDepartmentsId_Main(departmentsId,
                main, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("main=" + main);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader findByDepartmentsId_Main_Last(
        String departmentsId, boolean main, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        int count = countByDepartmentsId_Main(departmentsId, main);

        List<PmlDepartmentsLeader> list = findByDepartmentsId_Main(departmentsId,
                main, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("main=" + main);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader[] findByDepartmentsId_Main_PrevAndNext(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK, String departmentsId,
        boolean main, OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = findByPrimaryKey(pmlDepartmentsLeaderPK);

        int count = countByDepartmentsId_Main(departmentsId, main);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

            if (departmentsId == null) {
                query.append("departmentsId IS NULL");
            } else {
                query.append("departmentsId = ?");
            }

            query.append(" AND ");

            query.append("main = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            qPos.add(main);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDepartmentsLeader);

            PmlDepartmentsLeader[] array = new PmlDepartmentsLeaderImpl[3];

            array[0] = (PmlDepartmentsLeader) objArray[0];
            array[1] = (PmlDepartmentsLeader) objArray[1];
            array[2] = (PmlDepartmentsLeader) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDepartmentsLeader> findByMain(boolean main)
        throws SystemException {
        Object[] finderArgs = new Object[] { Boolean.valueOf(main) };

        List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_MAIN,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                query.append("main = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(main);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDepartmentsLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_MAIN, finderArgs,
                    list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlDepartmentsLeader> findByMain(boolean main, int start,
        int end) throws SystemException {
        return findByMain(main, start, end, null);
    }

    public List<PmlDepartmentsLeader> findByMain(boolean main, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                Boolean.valueOf(main),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_MAIN,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                query.append("main = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(main);

                list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDepartmentsLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_MAIN,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlDepartmentsLeader findByMain_First(boolean main,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        List<PmlDepartmentsLeader> list = findByMain(main, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("main=" + main);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader findByMain_Last(boolean main,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        int count = countByMain(main);

        List<PmlDepartmentsLeader> list = findByMain(main, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentsLeader exists with the key {");

            msg.append("main=" + main);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentsLeaderException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentsLeader[] findByMain_PrevAndNext(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK, boolean main,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentsLeaderException, SystemException {
        PmlDepartmentsLeader pmlDepartmentsLeader = findByPrimaryKey(pmlDepartmentsLeaderPK);

        int count = countByMain(main);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

            query.append("main = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(main);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDepartmentsLeader);

            PmlDepartmentsLeader[] array = new PmlDepartmentsLeaderImpl[3];

            array[0] = (PmlDepartmentsLeader) objArray[0];
            array[1] = (PmlDepartmentsLeader) objArray[1];
            array[2] = (PmlDepartmentsLeader) objArray[2];

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

    public List<PmlDepartmentsLeader> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlDepartmentsLeader> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlDepartmentsLeader> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlDepartmentsLeader> list = (List<PmlDepartmentsLeader>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlDepartmentsLeader>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlDepartmentsLeader>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByDepartmentsId(String departmentsId)
        throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findByDepartmentsId(
                departmentsId)) {
            remove(pmlDepartmentsLeader);
        }
    }

    public void removeByUserId(long userId) throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findByUserId(userId)) {
            remove(pmlDepartmentsLeader);
        }
    }

    public void removeByDepartmentsId_UserId(String departmentsId, long userId)
        throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findByDepartmentsId_UserId(
                departmentsId, userId)) {
            remove(pmlDepartmentsLeader);
        }
    }

    public void removeByDepartmentsId_Main(String departmentsId, boolean main)
        throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findByDepartmentsId_Main(
                departmentsId, main)) {
            remove(pmlDepartmentsLeader);
        }
    }

    public void removeByMain(boolean main) throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findByMain(main)) {
            remove(pmlDepartmentsLeader);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlDepartmentsLeader pmlDepartmentsLeader : findAll()) {
            remove(pmlDepartmentsLeader);
        }
    }

    public int countByDepartmentsId(String departmentsId)
        throws SystemException {
        Object[] finderArgs = new Object[] { departmentsId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTSID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTSID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByUserId(long userId) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(userId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDepartmentsId_UserId(String departmentsId, long userId)
        throws SystemException {
        Object[] finderArgs = new Object[] { departmentsId, new Long(userId) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTSID_USERID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" AND ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(userId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTSID_USERID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDepartmentsId_Main(String departmentsId, boolean main)
        throws SystemException {
        Object[] finderArgs = new Object[] { departmentsId, Boolean.valueOf(main) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTSID_MAIN,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId IS NULL");
                } else {
                    query.append("departmentsId = ?");
                }

                query.append(" AND ");

                query.append("main = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(main);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTSID_MAIN,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByMain(boolean main) throws SystemException {
        Object[] finderArgs = new Object[] { Boolean.valueOf(main) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_MAIN,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.PmlDepartmentsLeader WHERE ");

                query.append("main = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(main);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_MAIN,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.department.model.PmlDepartmentsLeader");

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
                        "value.object.listener.com.nss.portlet.department.model.PmlDepartmentsLeader")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlDepartmentsLeader>> listenersList = new ArrayList<ModelListener<PmlDepartmentsLeader>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlDepartmentsLeader>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
