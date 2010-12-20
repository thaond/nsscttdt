package com.nss.portlet.generatetemplateid.service.persistence;

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

import com.nss.portlet.generatetemplateid.NoSuchIdGeneratedException;
import com.nss.portlet.generatetemplateid.model.IdGenerated;
import com.nss.portlet.generatetemplateid.model.impl.IdGeneratedImpl;
import com.nss.portlet.generatetemplateid.model.impl.IdGeneratedModelImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class IdGeneratedPersistenceImpl extends BasePersistenceImpl
    implements IdGeneratedPersistence {
    public static final String FINDER_CLASS_NAME_ENTITY = IdGeneratedImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
        ".List";
    public static final FinderPath FINDER_PATH_FIND_BY_ALLLIKE = new FinderPath(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAllLike",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_ALLLIKE = new FinderPath(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByAllLike",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_ALLLIKE = new FinderPath(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByAllLike",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_YEAR = new FinderPath(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByYear", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_YEAR = new FinderPath(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByYear",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_YEAR = new FinderPath(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByYear", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_CURVALUE = new FinderPath(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCurValue", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_BY_OBC_CURVALUE = new FinderPath(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findByCurValue",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_COUNT_BY_CURVALUE = new FinderPath(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countByCurValue", new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
            "countAll", new String[0]);
    private static Log _log = LogFactoryUtil.getLog(IdGeneratedPersistenceImpl.class);
    @BeanReference(name = "com.nss.portlet.generatetemplateid.service.persistence.IdTemplatePersistence.impl")
    protected com.nss.portlet.generatetemplateid.service.persistence.IdTemplatePersistence idTemplatePersistence;
    @BeanReference(name = "com.nss.portlet.generatetemplateid.service.persistence.IdGeneratedPersistence.impl")
    protected com.nss.portlet.generatetemplateid.service.persistence.IdGeneratedPersistence idGeneratedPersistence;

    public void cacheResult(IdGenerated idGenerated) {
        EntityCacheUtil.putResult(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedImpl.class, idGenerated.getPrimaryKey(), idGenerated);
    }

    public void cacheResult(List<IdGenerated> idGenerateds) {
        for (IdGenerated idGenerated : idGenerateds) {
            if (EntityCacheUtil.getResult(
                        IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
                        IdGeneratedImpl.class, idGenerated.getPrimaryKey(), this) == null) {
                cacheResult(idGenerated);
            }
        }
    }

    public void clearCache() {
        CacheRegistry.clear(IdGeneratedImpl.class.getName());
        EntityCacheUtil.clearCache(IdGeneratedImpl.class.getName());
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
    }

    public IdGenerated create(long id) {
        IdGenerated idGenerated = new IdGeneratedImpl();

        idGenerated.setNew(true);
        idGenerated.setPrimaryKey(id);

        return idGenerated;
    }

    public IdGenerated remove(long id)
        throws NoSuchIdGeneratedException, SystemException {
        Session session = null;

        try {
            session = openSession();

            IdGenerated idGenerated = (IdGenerated) session.get(IdGeneratedImpl.class,
                    new Long(id));

            if (idGenerated == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No IdGenerated exists with the primary key " +
                        id);
                }

                throw new NoSuchIdGeneratedException(
                    "No IdGenerated exists with the primary key " + id);
            }

            return remove(idGenerated);
        } catch (NoSuchIdGeneratedException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public IdGenerated remove(IdGenerated idGenerated)
        throws SystemException {
        for (ModelListener<IdGenerated> listener : listeners) {
            listener.onBeforeRemove(idGenerated);
        }

        idGenerated = removeImpl(idGenerated);

        for (ModelListener<IdGenerated> listener : listeners) {
            listener.onAfterRemove(idGenerated);
        }

        return idGenerated;
    }

    protected IdGenerated removeImpl(IdGenerated idGenerated)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (idGenerated.isCachedModel() || BatchSessionUtil.isEnabled()) {
                Object staleObject = session.get(IdGeneratedImpl.class,
                        idGenerated.getPrimaryKeyObj());

                if (staleObject != null) {
                    session.evict(staleObject);
                }
            }

            session.delete(idGenerated);

            session.flush();
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.removeResult(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedImpl.class, idGenerated.getPrimaryKey());

        return idGenerated;
    }

    /**
     * @deprecated Use <code>update(IdGenerated idGenerated, boolean merge)</code>.
     */
    public IdGenerated update(IdGenerated idGenerated)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(IdGenerated idGenerated) method. Use update(IdGenerated idGenerated, boolean merge) instead.");
        }

        return update(idGenerated, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                idGenerated the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when idGenerated is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public IdGenerated update(IdGenerated idGenerated, boolean merge)
        throws SystemException {
        boolean isNew = idGenerated.isNew();

        for (ModelListener<IdGenerated> listener : listeners) {
            if (isNew) {
                listener.onBeforeCreate(idGenerated);
            } else {
                listener.onBeforeUpdate(idGenerated);
            }
        }

        idGenerated = updateImpl(idGenerated, merge);

        for (ModelListener<IdGenerated> listener : listeners) {
            if (isNew) {
                listener.onAfterCreate(idGenerated);
            } else {
                listener.onAfterUpdate(idGenerated);
            }
        }

        return idGenerated;
    }

    public IdGenerated updateImpl(
        com.nss.portlet.generatetemplateid.model.IdGenerated idGenerated,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, idGenerated, merge);

            idGenerated.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

        EntityCacheUtil.putResult(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
            IdGeneratedImpl.class, idGenerated.getPrimaryKey(), idGenerated);

        return idGenerated;
    }

    public IdGenerated findByPrimaryKey(long id)
        throws NoSuchIdGeneratedException, SystemException {
        IdGenerated idGenerated = fetchByPrimaryKey(id);

        if (idGenerated == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No IdGenerated exists with the primary key " + id);
            }

            throw new NoSuchIdGeneratedException(
                "No IdGenerated exists with the primary key " + id);
        }

        return idGenerated;
    }

    public IdGenerated fetchByPrimaryKey(long id) throws SystemException {
        IdGenerated idGenerated = (IdGenerated) EntityCacheUtil.getResult(IdGeneratedModelImpl.ENTITY_CACHE_ENABLED,
                IdGeneratedImpl.class, id, this);

        if (idGenerated == null) {
            Session session = null;

            try {
                session = openSession();

                idGenerated = (IdGenerated) session.get(IdGeneratedImpl.class,
                        new Long(id));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (idGenerated != null) {
                    cacheResult(idGenerated);
                }

                closeSession(session);
            }
        }

        return idGenerated;
    }

    public List<IdGenerated> findByAllLike(String year, long curValue)
        throws SystemException {
        Object[] finderArgs = new Object[] { year, new Long(curValue) };

        List<IdGenerated> list = (List<IdGenerated>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ALLLIKE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdGenerated WHERE ");

                if (year == null) {
                    query.append("year LIKE null");
                } else {
                    query.append("year LIKE ?");
                }

                query.append(" AND ");

                query.append("curvalue LIKE ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (year != null) {
                    qPos.add(year);
                }

                qPos.add(curValue);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdGenerated>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ALLLIKE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<IdGenerated> findByAllLike(String year, long curValue,
        int start, int end) throws SystemException {
        return findByAllLike(year, curValue, start, end, null);
    }

    public List<IdGenerated> findByAllLike(String year, long curValue,
        int start, int end, OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                year, new Long(curValue),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<IdGenerated> list = (List<IdGenerated>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_ALLLIKE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdGenerated WHERE ");

                if (year == null) {
                    query.append("year LIKE null");
                } else {
                    query.append("year LIKE ?");
                }

                query.append(" AND ");

                query.append("curvalue LIKE ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (year != null) {
                    qPos.add(year);
                }

                qPos.add(curValue);

                list = (List<IdGenerated>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdGenerated>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_ALLLIKE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public IdGenerated findByAllLike_First(String year, long curValue,
        OrderByComparator obc)
        throws NoSuchIdGeneratedException, SystemException {
        List<IdGenerated> list = findByAllLike(year, curValue, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdGenerated exists with the key {");

            msg.append("year=" + year);

            msg.append(", ");
            msg.append("curValue=" + curValue);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdGeneratedException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdGenerated findByAllLike_Last(String year, long curValue,
        OrderByComparator obc)
        throws NoSuchIdGeneratedException, SystemException {
        int count = countByAllLike(year, curValue);

        List<IdGenerated> list = findByAllLike(year, curValue, count - 1,
                count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdGenerated exists with the key {");

            msg.append("year=" + year);

            msg.append(", ");
            msg.append("curValue=" + curValue);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdGeneratedException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdGenerated[] findByAllLike_PrevAndNext(long id, String year,
        long curValue, OrderByComparator obc)
        throws NoSuchIdGeneratedException, SystemException {
        IdGenerated idGenerated = findByPrimaryKey(id);

        int count = countByAllLike(year, curValue);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.generatetemplateid.model.IdGenerated WHERE ");

            if (year == null) {
                query.append("year LIKE null");
            } else {
                query.append("year LIKE ?");
            }

            query.append(" AND ");

            query.append("curvalue LIKE ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (year != null) {
                qPos.add(year);
            }

            qPos.add(curValue);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    idGenerated);

            IdGenerated[] array = new IdGeneratedImpl[3];

            array[0] = (IdGenerated) objArray[0];
            array[1] = (IdGenerated) objArray[1];
            array[2] = (IdGenerated) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<IdGenerated> findByYear(String year) throws SystemException {
        Object[] finderArgs = new Object[] { year };

        List<IdGenerated> list = (List<IdGenerated>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_YEAR,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdGenerated WHERE ");

                if (year == null) {
                    query.append("year LIKE null");
                } else {
                    query.append("year LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (year != null) {
                    qPos.add(year);
                }

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdGenerated>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_YEAR, finderArgs,
                    list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<IdGenerated> findByYear(String year, int start, int end)
        throws SystemException {
        return findByYear(year, start, end, null);
    }

    public List<IdGenerated> findByYear(String year, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                year,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<IdGenerated> list = (List<IdGenerated>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_YEAR,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdGenerated WHERE ");

                if (year == null) {
                    query.append("year LIKE null");
                } else {
                    query.append("year LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (year != null) {
                    qPos.add(year);
                }

                list = (List<IdGenerated>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdGenerated>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_YEAR,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public IdGenerated findByYear_First(String year, OrderByComparator obc)
        throws NoSuchIdGeneratedException, SystemException {
        List<IdGenerated> list = findByYear(year, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdGenerated exists with the key {");

            msg.append("year=" + year);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdGeneratedException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdGenerated findByYear_Last(String year, OrderByComparator obc)
        throws NoSuchIdGeneratedException, SystemException {
        int count = countByYear(year);

        List<IdGenerated> list = findByYear(year, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdGenerated exists with the key {");

            msg.append("year=" + year);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdGeneratedException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdGenerated[] findByYear_PrevAndNext(long id, String year,
        OrderByComparator obc)
        throws NoSuchIdGeneratedException, SystemException {
        IdGenerated idGenerated = findByPrimaryKey(id);

        int count = countByYear(year);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.generatetemplateid.model.IdGenerated WHERE ");

            if (year == null) {
                query.append("year LIKE null");
            } else {
                query.append("year LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (year != null) {
                qPos.add(year);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    idGenerated);

            IdGenerated[] array = new IdGeneratedImpl[3];

            array[0] = (IdGenerated) objArray[0];
            array[1] = (IdGenerated) objArray[1];
            array[2] = (IdGenerated) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<IdGenerated> findByCurValue(long curValue)
        throws SystemException {
        Object[] finderArgs = new Object[] { new Long(curValue) };

        List<IdGenerated> list = (List<IdGenerated>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_CURVALUE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdGenerated WHERE ");

                query.append("curvalue LIKE ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(curValue);

                list = q.list();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdGenerated>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_CURVALUE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public List<IdGenerated> findByCurValue(long curValue, int start, int end)
        throws SystemException {
        return findByCurValue(curValue, start, end, null);
    }

    public List<IdGenerated> findByCurValue(long curValue, int start, int end,
        OrderByComparator obc) throws SystemException {
        Object[] finderArgs = new Object[] {
                new Long(curValue),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<IdGenerated> list = (List<IdGenerated>) FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_OBC_CURVALUE,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdGenerated WHERE ");

                query.append("curvalue LIKE ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(curValue);

                list = (List<IdGenerated>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdGenerated>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_OBC_CURVALUE,
                    finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public IdGenerated findByCurValue_First(long curValue, OrderByComparator obc)
        throws NoSuchIdGeneratedException, SystemException {
        List<IdGenerated> list = findByCurValue(curValue, 0, 1, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdGenerated exists with the key {");

            msg.append("curValue=" + curValue);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdGeneratedException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdGenerated findByCurValue_Last(long curValue, OrderByComparator obc)
        throws NoSuchIdGeneratedException, SystemException {
        int count = countByCurValue(curValue);

        List<IdGenerated> list = findByCurValue(curValue, count - 1, count, obc);

        if (list.isEmpty()) {
            StringBuilder msg = new StringBuilder();

            msg.append("No IdGenerated exists with the key {");

            msg.append("curValue=" + curValue);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchIdGeneratedException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public IdGenerated[] findByCurValue_PrevAndNext(long id, long curValue,
        OrderByComparator obc)
        throws NoSuchIdGeneratedException, SystemException {
        IdGenerated idGenerated = findByPrimaryKey(id);

        int count = countByCurValue(curValue);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.nss.portlet.generatetemplateid.model.IdGenerated WHERE ");

            query.append("curvalue LIKE ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(curValue);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    idGenerated);

            IdGenerated[] array = new IdGeneratedImpl[3];

            array[0] = (IdGenerated) objArray[0];
            array[1] = (IdGenerated) objArray[1];
            array[2] = (IdGenerated) objArray[2];

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

    public List<IdGenerated> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<IdGenerated> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<IdGenerated> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        List<IdGenerated> list = (List<IdGenerated>) FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdGenerated ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                if (obc == null) {
                    list = (List<IdGenerated>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<IdGenerated>) QueryUtil.list(q, getDialect(),
                            start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    list = new ArrayList<IdGenerated>();
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

                closeSession(session);
            }
        }

        return list;
    }

    public void removeByAllLike(String year, long curValue)
        throws SystemException {
        for (IdGenerated idGenerated : findByAllLike(year, curValue)) {
            remove(idGenerated);
        }
    }

    public void removeByYear(String year) throws SystemException {
        for (IdGenerated idGenerated : findByYear(year)) {
            remove(idGenerated);
        }
    }

    public void removeByCurValue(long curValue) throws SystemException {
        for (IdGenerated idGenerated : findByCurValue(curValue)) {
            remove(idGenerated);
        }
    }

    public void removeAll() throws SystemException {
        for (IdGenerated idGenerated : findAll()) {
            remove(idGenerated);
        }
    }

    public int countByAllLike(String year, long curValue)
        throws SystemException {
        Object[] finderArgs = new Object[] { year, new Long(curValue) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ALLLIKE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdGenerated WHERE ");

                if (year == null) {
                    query.append("year LIKE null");
                } else {
                    query.append("year LIKE ?");
                }

                query.append(" AND ");

                query.append("curvalue LIKE ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (year != null) {
                    qPos.add(year);
                }

                qPos.add(curValue);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ALLLIKE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByYear(String year) throws SystemException {
        Object[] finderArgs = new Object[] { year };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_YEAR,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdGenerated WHERE ");

                if (year == null) {
                    query.append("year LIKE null");
                } else {
                    query.append("year LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (year != null) {
                    qPos.add(year);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_YEAR,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    public int countByCurValue(long curValue) throws SystemException {
        Object[] finderArgs = new Object[] { new Long(curValue) };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CURVALUE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.nss.portlet.generatetemplateid.model.IdGenerated WHERE ");

                query.append("curvalue LIKE ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(curValue);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CURVALUE,
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
                        "SELECT COUNT(*) FROM com.nss.portlet.generatetemplateid.model.IdGenerated");

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
                        "value.object.listener.com.nss.portlet.generatetemplateid.model.IdGenerated")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<IdGenerated>> listenersList = new ArrayList<ModelListener<IdGenerated>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<IdGenerated>) Class.forName(
                            listenerClassName).newInstance());
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
