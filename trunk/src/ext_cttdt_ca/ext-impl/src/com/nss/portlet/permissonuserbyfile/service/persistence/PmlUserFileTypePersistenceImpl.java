package com.nss.portlet.permissonuserbyfile.service.persistence;

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

import com.nss.portlet.permissonuserbyfile.NoSuchPmlUserFileTypeException;
import com.nss.portlet.permissonuserbyfile.model.PmlUserFileType;
import com.nss.portlet.permissonuserbyfile.model.impl.PmlUserFileTypeImpl;
import com.nss.portlet.permissonuserbyfile.model.impl.PmlUserFileTypeModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PmlUserFileTypePersistenceImpl extends BasePersistenceImpl
    implements PmlUserFileTypePersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = PmlUserFileTypeImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_USERID = new FinderPath(PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserFileTypeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByUserId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_USERID = new FinderPath(PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserFileTypeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByUserId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserFileTypeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByUserId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_FILETYPEID = new FinderPath(PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserFileTypeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_FILETYPEID = new FinderPath(PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserFileTypeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findByFileTypeId",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_FILETYPEID = new FinderPath(PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserFileTypeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countByFileTypeId",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserFileTypeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserFileTypeModelImpl.FINDER_CACHE_ENABLED,
            FINDER_CLASS_NAME_LIST, "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(PmlUserFileTypePersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePersistence.impl")
    protected com.nss.portlet.permissonuserbyfile.service.persistence.PmlUserFileTypePersistence pmlUserFileTypePersistence;

    public void cacheResult(PmlUserFileType pmlUserFileType) {
        EntityCacheUtil.putResult(PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserFileTypeImpl.class, pmlUserFileType.getPrimaryKey(),
            pmlUserFileType);
    }

    public void cacheResult(List<PmlUserFileType> pmlUserFileTypes) {
        for (PmlUserFileType pmlUserFileType : pmlUserFileTypes) {
            if (EntityCacheUtil.getResult(
                        PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
                        PmlUserFileTypeImpl.class,
                        pmlUserFileType.getPrimaryKey(), this) == null) {
                cacheResult(pmlUserFileType);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(PmlUserFileTypeImpl.class.getName());
        EntityCacheUtil.clearCache(PmlUserFileTypeImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public PmlUserFileType create(PmlUserFileTypePK pmlUserFileTypePK) {
        PmlUserFileType pmlUserFileType = new PmlUserFileTypeImpl();

        pmlUserFileType.setNew(true);
        pmlUserFileType.setPrimaryKey(pmlUserFileTypePK);

        return pmlUserFileType;
    }

    public PmlUserFileType remove(PmlUserFileTypePK pmlUserFileTypePK)
        throws NoSuchPmlUserFileTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlUserFileType pmlUserFileType = (PmlUserFileType) session.get(PmlUserFileTypeImpl.class,
                    pmlUserFileTypePK);

            if (pmlUserFileType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlUserFileType exists with the primary key " +
                        pmlUserFileTypePK);
                }

                throw new NoSuchPmlUserFileTypeException(
                    "No PmlUserFileType exists with the primary key " +
                    pmlUserFileTypePK);
            }

            return remove(pmlUserFileType);
        } catch (NoSuchPmlUserFileTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlUserFileType remove(PmlUserFileType pmlUserFileType)
        throws SystemException {
        for (ModelListener<PmlUserFileType> listener : listeners) {
            listener.onBeforeRemove(pmlUserFileType);
        }

        pmlUserFileType = removeImpl(pmlUserFileType);

        for (ModelListener<PmlUserFileType> listener : listeners) {
            listener.onAfterRemove(pmlUserFileType);
        }

        return pmlUserFileType;
    }

    protected PmlUserFileType removeImpl(PmlUserFileType pmlUserFileType)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (pmlUserFileType.isCachedModel() ||
                    BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(PmlUserFileTypeImpl.class,
                        pmlUserFileType.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(pmlUserFileType);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserFileTypeImpl.class, pmlUserFileType.getPrimaryKey());

        return pmlUserFileType;
    }

    /**
     * @deprecated Use <code>update(PmlUserFileType pmlUserFileType, boolean merge)</code>.
     */
    public PmlUserFileType update(PmlUserFileType pmlUserFileType)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlUserFileType pmlUserFileType) method. Use update(PmlUserFileType pmlUserFileType, boolean merge) instead.");
        }

        return update(pmlUserFileType, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlUserFileType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlUserFileType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlUserFileType update(PmlUserFileType pmlUserFileType, boolean merge)
        throws SystemException {
        boolean isNew = pmlUserFileType.isNew();

        for (ModelListener<PmlUserFileType> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(pmlUserFileType);
            } else {
                listener.onBeforeUpdate(pmlUserFileType);
            }
        }

        pmlUserFileType = updateImpl(pmlUserFileType, merge);

        for (ModelListener<PmlUserFileType> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(pmlUserFileType);
            } else {
                listener.onAfterUpdate(pmlUserFileType);
            }
        }

        return pmlUserFileType;
    }

    public PmlUserFileType updateImpl(
        com.nss.portlet.permissonuserbyfile.model.PmlUserFileType pmlUserFileType,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, pmlUserFileType, merge);

            pmlUserFileType.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
            PmlUserFileTypeImpl.class, pmlUserFileType.getPrimaryKey(),
            pmlUserFileType);

        return pmlUserFileType;
    }

    public PmlUserFileType findByPrimaryKey(PmlUserFileTypePK pmlUserFileTypePK)
        throws NoSuchPmlUserFileTypeException, SystemException {
        PmlUserFileType pmlUserFileType = fetchByPrimaryKey(pmlUserFileTypePK);

        if (pmlUserFileType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlUserFileType exists with the primary key " +
                    pmlUserFileTypePK);
            }

            throw new NoSuchPmlUserFileTypeException(
                "No PmlUserFileType exists with the primary key " +
                pmlUserFileTypePK);
        }

        return pmlUserFileType;
    }

    public PmlUserFileType fetchByPrimaryKey(
        PmlUserFileTypePK pmlUserFileTypePK) throws SystemException {
        PmlUserFileType pmlUserFileType = (PmlUserFileType) EntityCacheUtil.getResult(PmlUserFileTypeModelImpl.ENTITY_CACHE_ENABLED,
                PmlUserFileTypeImpl.class, pmlUserFileTypePK, this);

        if (pmlUserFileType == null) {
            Session session = null;

            try {
                session = openSession();

                pmlUserFileType = (PmlUserFileType) session.get(PmlUserFileTypeImpl.class,
                        pmlUserFileTypePK);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (pmlUserFileType != null) {
                    cacheResult(pmlUserFileType);
                }

                closeSession(session);
            }
        }

        return pmlUserFileType;
    }

    public List<PmlUserFileType> findByUserId(long userId)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(userId) };

        List<PmlUserFileType> list = (List<PmlUserFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_USERID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.permissonuserbyfile.model.PmlUserFileType WHERE ");

                query.append("userid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("userid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlUserFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_USERID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlUserFileType> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    public List<PmlUserFileType> findByUserId(long userId, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(userId),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlUserFileType> list = (List<PmlUserFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_USERID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.permissonuserbyfile.model.PmlUserFileType WHERE ");

                query.append("userid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("userid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                list = (List<PmlUserFileType>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlUserFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_USERID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlUserFileType findByUserId_First(long userId, OrderByComparator obc)
        throws NoSuchPmlUserFileTypeException, SystemException {
        List<PmlUserFileType> list = findByUserId(userId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUserFileType exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUserFileType findByUserId_Last(long userId, OrderByComparator obc)
        throws NoSuchPmlUserFileTypeException, SystemException {
        int count = countByUserId(userId);

        List<PmlUserFileType> list = findByUserId(userId, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUserFileType exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUserFileType[] findByUserId_PrevAndNext(
        PmlUserFileTypePK pmlUserFileTypePK, long userId, OrderByComparator obc)
        throws NoSuchPmlUserFileTypeException, SystemException {
        PmlUserFileType pmlUserFileType = findByPrimaryKey(pmlUserFileTypePK);

        int count = countByUserId(userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.permissonuserbyfile.model.PmlUserFileType WHERE ");

            query.append("userid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("userid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlUserFileType);

            PmlUserFileType[] array = new PmlUserFileTypeImpl[3];

            array[0] = (PmlUserFileType) objArray[0];
            array[1] = (PmlUserFileType) objArray[1];
            array[2] = (PmlUserFileType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUserFileType> findByFileTypeId(String fileTypeId)
        throws SystemException {
        Object[] finderArgs = new Object[] { fileTypeId };

        List<PmlUserFileType> list = (List<PmlUserFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_FILETYPEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.permissonuserbyfile.model.PmlUserFileType WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("userid DESC");

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
                    list = new ArrayList<PmlUserFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_FILETYPEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<PmlUserFileType> findByFileTypeId(String fileTypeId, int start,
        int end) throws SystemException {
        return findByFileTypeId(fileTypeId, start, end, null);
    }

    public List<PmlUserFileType> findByFileTypeId(String fileTypeId, int start,
        int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlUserFileType> list = (List<PmlUserFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.permissonuserbyfile.model.PmlUserFileType WHERE ");

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

                    query.append("userid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                list = (List<PmlUserFileType>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlUserFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_FILETYPEID,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public PmlUserFileType findByFileTypeId_First(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlUserFileTypeException, SystemException {
        List<PmlUserFileType> list = findByFileTypeId(fileTypeId, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUserFileType exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUserFileType findByFileTypeId_Last(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlUserFileTypeException, SystemException {
        int count = countByFileTypeId(fileTypeId);

        List<PmlUserFileType> list = findByFileTypeId(fileTypeId, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUserFileType exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlUserFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUserFileType[] findByFileTypeId_PrevAndNext(
        PmlUserFileTypePK pmlUserFileTypePK, String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlUserFileTypeException, SystemException {
        PmlUserFileType pmlUserFileType = findByPrimaryKey(pmlUserFileTypePK);

        int count = countByFileTypeId(fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.permissonuserbyfile.model.PmlUserFileType WHERE ");

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

                query.append("userid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlUserFileType);

            PmlUserFileType[] array = new PmlUserFileTypeImpl[3];

            array[0] = (PmlUserFileType) objArray[0];
            array[1] = (PmlUserFileType) objArray[1];
            array[2] = (PmlUserFileType) objArray[2];

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

    public List<PmlUserFileType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlUserFileType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlUserFileType> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<PmlUserFileType> list = (List<PmlUserFileType>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.permissonuserbyfile.model.PmlUserFileType ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("userid DESC");
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<PmlUserFileType>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<PmlUserFileType>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<PmlUserFileType>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByUserId(long userId) throws SystemException {
        for (PmlUserFileType pmlUserFileType : findByUserId(userId)) {
            remove(pmlUserFileType);
        }
    }

    public void removeByFileTypeId(String fileTypeId) throws SystemException {
        for (PmlUserFileType pmlUserFileType : findByFileTypeId(fileTypeId)) {
            remove(pmlUserFileType);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlUserFileType pmlUserFileType : findAll()) {
            remove(pmlUserFileType);
        }
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
                    "FROM com.nss.portlet.permissonuserbyfile.model.PmlUserFileType WHERE ");

                query.append("userid = ?");

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
                    "FROM com.nss.portlet.permissonuserbyfile.model.PmlUserFileType WHERE ");

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

    public int countAll() throws SystemException {
        Object[] finderArgs = new Object[0];

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.nss.portlet.permissonuserbyfile.model.PmlUserFileType");

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
                        "value.object.listener.com.nss.portlet.permissonuserbyfile.model.PmlUserFileType")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<PmlUserFileType>> listenersList = new ArrayList<ModelListener<PmlUserFileType>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<PmlUserFileType>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
