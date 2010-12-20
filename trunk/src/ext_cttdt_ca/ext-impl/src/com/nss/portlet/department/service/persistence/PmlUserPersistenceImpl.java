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

import com.nss.portlet.department.NoSuchPmlUserException;
import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.model.impl.PmlUserImpl;
import com.nss.portlet.department.model.impl.PmlUserModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlUserPersistenceImpl extends BasePersistenceImpl
    implements PmlUserPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlUserImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_DEPARTMENTSID = new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID = new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTSID = new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDepartmentsId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_POSITIONID = new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByPositionId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_POSITIONID = new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByPositionId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_POSITIONID = new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByPositionId", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DEPARTMENTSID_POSITIONID = new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsId_PositionId",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID_POSITIONID =
        new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsId_PositionId",
            new String[] {
                String.class.getName(), String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTSID_POSITIONID =
        new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDepartmentsId_PositionId",
            new String[] { String.class.getName(), String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_DEPARTMENTSID_ACTIVE = new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsId_Active",
            new String[] { String.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID_ACTIVE = new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByDepartmentsId_Active",
            new String[] {
                String.class.getName(), Boolean.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTSID_ACTIVE = new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByDepartmentsId_Active",
            new String[] { String.class.getName(), Boolean.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlUserPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.department.service.persistence.DepartmentPersistence.impl")
    protected com.nss.portlet.department.service.persistence.DepartmentPersistence departmentPersistence;
    @BeanReference(name = "com.nss.portlet.department.service.persistence.PmlUserPersistence.impl")
    protected com.nss.portlet.department.service.persistence.PmlUserPersistence pmlUserPersistence;
    @BeanReference(name = "com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPersistence.impl")
    protected com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPersistence pmlDepartmentsLeaderPersistence;

    public void cacheResult(PmlUser pmlUser) {
        EntityCacheUtil.putResult(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserImpl.class, pmlUser.getPrimaryKey(), pmlUser);
    }

    public void cacheResult(List<PmlUser> pmlUsers) {
        for (PmlUser pmlUser : pmlUsers) {
            if (EntityCacheUtil.getResult(
                        PmlUserModelImpl.ENTITY_CACHE_ENABLED,
                        PmlUserImpl.class, pmlUser.getPrimaryKey(), this) == null) {
                cacheResult(pmlUser);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlUserImpl.class.getName());
        EntityCacheUtil.clearCache(PmlUserImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlUser create(long userId) {
        PmlUser pmlUser = new PmlUserImpl();

        pmlUser.setNew(true);
        pmlUser.setPrimaryKey(userId);

        return pmlUser;
    }

    public PmlUser remove(long userId)
        throws NoSuchPmlUserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlUser pmlUser = (PmlUser) session.get(PmlUserImpl.class,
                    new Long(userId));

            if (pmlUser == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlUser exists with the primary key " +
                        userId);
                }

                throw new NoSuchPmlUserException(
                    "No PmlUser exists with the primary key " + userId);
            }

            return remove(pmlUser);
        } catch (NoSuchPmlUserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlUser remove(PmlUser pmlUser) throws SystemException {
        for (ModelListener<PmlUser> listener : listeners) {
            listener.onBeforeRemove(pmlUser);
        }

        pmlUser = removeImpl(pmlUser);

        for (ModelListener<PmlUser> listener : listeners) {
            listener.onAfterRemove(pmlUser);
        }

        return pmlUser;
    }

    protected PmlUser removeImpl(PmlUser pmlUser) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlUser.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlUserImpl.class,
                        pmlUser.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlUser);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserImpl.class, pmlUser.getPrimaryKey());

        return pmlUser;
    }

    /**
     * @deprecated Use <code>update(PmlUser pmlUser, boolean merge)</code>.
     */
    public PmlUser update(PmlUser pmlUser) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlUser pmlUser) method. Use update(PmlUser pmlUser, boolean merge) instead.");
        }

        return update(pmlUser, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlUser the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlUser is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlUser update(PmlUser pmlUser, boolean merge)
        throws SystemException {
        boolean isNew = pmlUser.isNew();

        for (ModelListener<PmlUser> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlUser);
            } else {
                listener.onBeforeUpdate(pmlUser);
            }
        }

        pmlUser = updateImpl(pmlUser, merge);

        for (ModelListener<PmlUser> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlUser);
            } else {
                listener.onAfterUpdate(pmlUser);
            }
        }

        return pmlUser;
    }

    public PmlUser updateImpl(
        com.nss.portlet.department.model.PmlUser pmlUser, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlUser, merge);

            pmlUser.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserImpl.class, pmlUser.getPrimaryKey(), pmlUser);

        return pmlUser;
    }

    public PmlUser findByPrimaryKey(long userId)
        throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = fetchByPrimaryKey(userId);

        if (pmlUser == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlUser exists with the primary key " + userId);
            }

            throw new NoSuchPmlUserException(
                "No PmlUser exists with the primary key " + userId);
        }

        return pmlUser;
    }

    public PmlUser fetchByPrimaryKey(long userId) throws SystemException {
        PmlUser pmlUser = (PmlUser) EntityCacheUtil.getResult(PmlUserModelImpl.ENTITY_CACHE_ENABLED,
                PmlUserImpl.class, userId, this);

        if (pmlUser == null) {
            Session session = null;

            try {
                session = openSession();

                pmlUser = (PmlUser) session.get(PmlUserImpl.class,
                        new Long(userId));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlUser != null) {
                    cacheResult(pmlUser);
                }

                closeSession(session);
            }
        }

        return pmlUser;
    }

    public List<PmlUser> findByDepartmentsId(String departmentsId)
        throws SystemException {
        Object[] finderArgs = new Object[] { departmentsId };

        List<PmlUser> list = (List<PmlUser>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DEPARTMENTSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
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
                    list = new ArrayList<PmlUser>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DEPARTMENTSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlUser> findByDepartmentsId(String departmentsId, int start,
        int end) throws SystemException {
        return findByDepartmentsId(departmentsId, start, end, null);
    }

    public List<PmlUser> findByDepartmentsId(String departmentsId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                departmentsId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlUser> list = (List<PmlUser>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
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

                list = (List<PmlUser>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlUser>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlUser findByDepartmentsId_First(String departmentsId,
        OrderByComparator obc) throws NoSuchPmlUserException, SystemException {
        List<PmlUser> list = findByDepartmentsId(departmentsId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser findByDepartmentsId_Last(String departmentsId,
        OrderByComparator obc) throws NoSuchPmlUserException, SystemException {
        int count = countByDepartmentsId(departmentsId);

        List<PmlUser> list = findByDepartmentsId(departmentsId, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser[] findByDepartmentsId_PrevAndNext(long userId,
        String departmentsId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = findByPrimaryKey(userId);

        int count = countByDepartmentsId(departmentsId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.nss.portlet.department.model.PmlUser WHERE ");

            if (departmentsId == null) {
                query.append("departmentsid LIKE null");
            } else {
                query.append("departmentsid LIKE ?");
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

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlUser);

            PmlUser[] array = new PmlUserImpl[3];

            array[0] = (PmlUser) objArray[0];
            array[1] = (PmlUser) objArray[1];
            array[2] = (PmlUser) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUser> findByPositionId(String positionId)
        throws SystemException {
        Object[] finderArgs = new Object[] { positionId };

        List<PmlUser> list = (List<PmlUser>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_POSITIONID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlUser WHERE ");

                if (positionId == null) {
                    query.append("positionid LIKE null");
                } else {
                    query.append("positionid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionId != null) {
                    qPos.add(positionId);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlUser>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_POSITIONID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlUser> findByPositionId(String positionId, int start, int end)
        throws SystemException {
        return findByPositionId(positionId, start, end, null);
    }

    public List<PmlUser> findByPositionId(String positionId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                positionId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlUser> list = (List<PmlUser>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_POSITIONID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlUser WHERE ");

                if (positionId == null) {
                    query.append("positionid LIKE null");
                } else {
                    query.append("positionid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionId != null) {
                    qPos.add(positionId);
                }

                list = (List<PmlUser>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlUser>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_POSITIONID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlUser findByPositionId_First(String positionId,
        OrderByComparator obc) throws NoSuchPmlUserException, SystemException {
        List<PmlUser> list = findByPositionId(positionId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("positionId=" + positionId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser findByPositionId_Last(String positionId,
        OrderByComparator obc) throws NoSuchPmlUserException, SystemException {
        int count = countByPositionId(positionId);

        List<PmlUser> list = findByPositionId(positionId, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("positionId=" + positionId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser[] findByPositionId_PrevAndNext(long userId,
        String positionId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = findByPrimaryKey(userId);

        int count = countByPositionId(positionId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.nss.portlet.department.model.PmlUser WHERE ");

            if (positionId == null) {
                query.append("positionid LIKE null");
            } else {
                query.append("positionid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (positionId != null) {
                qPos.add(positionId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlUser);

            PmlUser[] array = new PmlUserImpl[3];

            array[0] = (PmlUser) objArray[0];
            array[1] = (PmlUser) objArray[1];
            array[2] = (PmlUser) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUser> findByDepartmentsId_PositionId(String departmentsId,
        String positionId) throws SystemException {
        Object[] finderArgs = new Object[] { departmentsId, positionId };

        List<PmlUser> list = (List<PmlUser>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DEPARTMENTSID_POSITIONID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" AND ");

                if (positionId == null) {
                    query.append("positionid LIKE null");
                } else {
                    query.append("positionid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                if (positionId != null) {
                    qPos.add(positionId);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlUser>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DEPARTMENTSID_POSITIONID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlUser> findByDepartmentsId_PositionId(String departmentsId,
        String positionId, int start, int end) throws SystemException {
        return findByDepartmentsId_PositionId(departmentsId, positionId, start,
            end, null);
    }

    public List<PmlUser> findByDepartmentsId_PositionId(String departmentsId,
        String positionId, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                departmentsId,
                
                positionId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlUser> list = (List<PmlUser>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID_POSITIONID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" AND ");

                if (positionId == null) {
                    query.append("positionid LIKE null");
                } else {
                    query.append("positionid LIKE ?");
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

                if (positionId != null) {
                    qPos.add(positionId);
                }

                list = (List<PmlUser>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlUser>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID_POSITIONID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlUser findByDepartmentsId_PositionId_First(String departmentsId,
        String positionId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        List<PmlUser> list = findByDepartmentsId_PositionId(departmentsId,
                positionId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("positionId=" + positionId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser findByDepartmentsId_PositionId_Last(String departmentsId,
        String positionId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        int count = countByDepartmentsId_PositionId(departmentsId, positionId);

        List<PmlUser> list = findByDepartmentsId_PositionId(departmentsId,
                positionId, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("positionId=" + positionId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser[] findByDepartmentsId_PositionId_PrevAndNext(long userId,
        String departmentsId, String positionId, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = findByPrimaryKey(userId);

        int count = countByDepartmentsId_PositionId(departmentsId, positionId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.nss.portlet.department.model.PmlUser WHERE ");

            if (departmentsId == null) {
                query.append("departmentsid LIKE null");
            } else {
                query.append("departmentsid LIKE ?");
            }

            query.append(" AND ");

            if (positionId == null) {
                query.append("positionid LIKE null");
            } else {
                query.append("positionid LIKE ?");
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

            if (positionId != null) {
                qPos.add(positionId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlUser);

            PmlUser[] array = new PmlUserImpl[3];

            array[0] = (PmlUser) objArray[0];
            array[1] = (PmlUser) objArray[1];
            array[2] = (PmlUser) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUser> findByDepartmentsId_Active(String departmentsId,
        Boolean active) throws SystemException {
        Object[] finderArgs = new Object[] { departmentsId, active };

        List<PmlUser> list = (List<PmlUser>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_DEPARTMENTSID_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" AND ");

                if (active == null) {
                    query.append("active IS NULL");
                } else {
                    query.append("active = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                if (active != null) {
                    qPos.add(active.booleanValue());
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlUser>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_DEPARTMENTSID_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlUser> findByDepartmentsId_Active(String departmentsId,
        Boolean active, int start, int end) throws SystemException {
        return findByDepartmentsId_Active(departmentsId, active, start, end,
            null);
    }

    public List<PmlUser> findByDepartmentsId_Active(String departmentsId,
        Boolean active, int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                departmentsId,
                
                active,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlUser> list = (List<PmlUser>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID_ACTIVE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.department.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" AND ");

                if (active == null) {
                    query.append("active IS NULL");
                } else {
                    query.append("active = ?");
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

                if (active != null) {
                    qPos.add(active.booleanValue());
                }

                list = (List<PmlUser>) QueryUtil.list(q, getDialect(), start,
                        end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlUser>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_DEPARTMENTSID_ACTIVE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlUser findByDepartmentsId_Active_First(String departmentsId,
        Boolean active, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        List<PmlUser> list = findByDepartmentsId_Active(departmentsId, active,
                0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser findByDepartmentsId_Active_Last(String departmentsId,
        Boolean active, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        int count = countByDepartmentsId_Active(departmentsId, active);

        List<PmlUser> list = findByDepartmentsId_Active(departmentsId, active,
                count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUser exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUser[] findByDepartmentsId_Active_PrevAndNext(long userId,
        String departmentsId, Boolean active, OrderByComparator obc)
        throws NoSuchPmlUserException, SystemException {
        PmlUser pmlUser = findByPrimaryKey(userId);

        int count = countByDepartmentsId_Active(departmentsId, active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append("FROM com.nss.portlet.department.model.PmlUser WHERE ");

            if (departmentsId == null) {
                query.append("departmentsid LIKE null");
            } else {
                query.append("departmentsid LIKE ?");
            }

            query.append(" AND ");

            if (active == null) {
                query.append("active IS NULL");
            } else {
                query.append("active = ?");
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

            if (active != null) {
                qPos.add(active.booleanValue());
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, pmlUser);

            PmlUser[] array = new PmlUserImpl[3];

            array[0] = (PmlUser) objArray[0];
            array[1] = (PmlUser) objArray[1];
            array[2] = (PmlUser) objArray[2];

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

    public List<PmlUser> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlUser> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlUser> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlUser> list = (List<PmlUser>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("FROM com.nss.portlet.department.model.PmlUser ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlUser>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlUser>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlUser>();
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
        for (PmlUser pmlUser : findByDepartmentsId(departmentsId)) {
            remove(pmlUser);
        }
    }

    public void removeByPositionId(String positionId) throws SystemException {
        for (PmlUser pmlUser : findByPositionId(positionId)) {
            remove(pmlUser);
        }
    }

    public void removeByDepartmentsId_PositionId(String departmentsId,
        String positionId) throws SystemException {
        for (PmlUser pmlUser : findByDepartmentsId_PositionId(departmentsId,
                positionId)) {
            remove(pmlUser);
        }
    }

    public void removeByDepartmentsId_Active(String departmentsId,
        Boolean active) throws SystemException {
        for (PmlUser pmlUser : findByDepartmentsId_Active(departmentsId, active)) {
            remove(pmlUser);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlUser pmlUser : findAll()) {
            remove(pmlUser);
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
                    "FROM com.nss.portlet.department.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
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

    public int countByPositionId(String positionId) throws SystemException {
        Object[] finderArgs = new Object[] { positionId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_POSITIONID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.PmlUser WHERE ");

                if (positionId == null) {
                    query.append("positionid LIKE null");
                } else {
                    query.append("positionid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionId != null) {
                    qPos.add(positionId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_POSITIONID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDepartmentsId_PositionId(String departmentsId,
        String positionId) throws SystemException {
        Object[] finderArgs = new Object[] { departmentsId, positionId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTSID_POSITIONID,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" AND ");

                if (positionId == null) {
                    query.append("positionid LIKE null");
                } else {
                    query.append("positionid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                if (positionId != null) {
                    qPos.add(positionId);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTSID_POSITIONID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByDepartmentsId_Active(String departmentsId, Boolean active)
        throws SystemException {
        Object[] finderArgs = new Object[] { departmentsId, active };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_DEPARTMENTSID_ACTIVE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.department.model.PmlUser WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" AND ");

                if (active == null) {
                    query.append("active IS NULL");
                } else {
                    query.append("active = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                if (active != null) {
                    qPos.add(active.booleanValue());
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DEPARTMENTSID_ACTIVE,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.department.model.PmlUser");

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
                        "value.object.listener.com.nss.portlet.department.model.PmlUser")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlUser>> listenersList = new ArrayList<ModelListener<PmlUser>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlUser>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
