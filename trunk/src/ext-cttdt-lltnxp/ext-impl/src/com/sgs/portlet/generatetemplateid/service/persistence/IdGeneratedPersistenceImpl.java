package com.sgs.portlet.generatetemplateid.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;
import com.sgs.portlet.generatetemplateid.model.IdGenerated;
import com.sgs.portlet.generatetemplateid.model.impl.IdGeneratedImpl;
import com.sgs.portlet.generatetemplateid.model.impl.IdGeneratedModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class IdGeneratedPersistenceImpl extends BasePersistenceImpl
    implements IdGeneratedPersistence {
    private static Log _log = LogFactory.getLog(IdGeneratedPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

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
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(idGenerated);
            }
        }

        idGenerated = removeImpl(idGenerated);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(idGenerated);
            }
        }

        return idGenerated;
    }

    protected IdGenerated removeImpl(IdGenerated idGenerated)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(idGenerated);

            session.flush();

            return idGenerated;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(IdGenerated.class.getName());
        }
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

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(idGenerated);
                } else {
                    listener.onBeforeUpdate(idGenerated);
                }
            }
        }

        idGenerated = updateImpl(idGenerated, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(idGenerated);
                } else {
                    listener.onAfterUpdate(idGenerated);
                }
            }
        }

        return idGenerated;
    }

    public IdGenerated updateImpl(
        com.sgs.portlet.generatetemplateid.model.IdGenerated idGenerated,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(idGenerated);
            } else {
                if (idGenerated.isNew()) {
                    session.save(idGenerated);
                }
            }

            session.flush();

            idGenerated.setNew(false);

            return idGenerated;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(IdGenerated.class.getName());
        }
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
        Session session = null;

        try {
            session = openSession();

            return (IdGenerated) session.get(IdGeneratedImpl.class, new Long(id));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<IdGenerated> findByAllLike(String year, long curValue)
        throws SystemException {
        boolean finderClassNameCacheEnabled = IdGeneratedModelImpl.CACHE_ENABLED;
        String finderClassName = IdGenerated.class.getName();
        String finderMethodName = "findByAllLike";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { year, new Long(curValue) };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated WHERE ");

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

                List<IdGenerated> list = q.list();

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                return list;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return (List<IdGenerated>) result;
        }
    }

    public List<IdGenerated> findByAllLike(String year, long curValue,
        int start, int end) throws SystemException {
        return findByAllLike(year, curValue, start, end, null);
    }

    public List<IdGenerated> findByAllLike(String year, long curValue,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = IdGeneratedModelImpl.CACHE_ENABLED;
        String finderClassName = IdGenerated.class.getName();
        String finderMethodName = "findByAllLike";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                year, new Long(curValue),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated WHERE ");

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

                List<IdGenerated> list = (List<IdGenerated>) QueryUtil.list(q,
                        getDialect(), start, end);

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                return list;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return (List<IdGenerated>) result;
        }
    }

    public IdGenerated findByAllLike_First(String year, long curValue,
        OrderByComparator obc)
        throws NoSuchIdGeneratedException, SystemException {
        List<IdGenerated> list = findByAllLike(year, curValue, 0, 1, obc);

        if (list.size() == 0) {
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

        if (list.size() == 0) {
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
                "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated WHERE ");

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
        boolean finderClassNameCacheEnabled = IdGeneratedModelImpl.CACHE_ENABLED;
        String finderClassName = IdGenerated.class.getName();
        String finderMethodName = "findByYear";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { year };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated WHERE ");

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

                List<IdGenerated> list = q.list();

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                return list;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return (List<IdGenerated>) result;
        }
    }

    public List<IdGenerated> findByYear(String year, int start, int end)
        throws SystemException {
        return findByYear(year, start, end, null);
    }

    public List<IdGenerated> findByYear(String year, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = IdGeneratedModelImpl.CACHE_ENABLED;
        String finderClassName = IdGenerated.class.getName();
        String finderMethodName = "findByYear";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                year,
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated WHERE ");

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

                List<IdGenerated> list = (List<IdGenerated>) QueryUtil.list(q,
                        getDialect(), start, end);

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                return list;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return (List<IdGenerated>) result;
        }
    }

    public IdGenerated findByYear_First(String year, OrderByComparator obc)
        throws NoSuchIdGeneratedException, SystemException {
        List<IdGenerated> list = findByYear(year, 0, 1, obc);

        if (list.size() == 0) {
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

        if (list.size() == 0) {
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
                "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated WHERE ");

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
        boolean finderClassNameCacheEnabled = IdGeneratedModelImpl.CACHE_ENABLED;
        String finderClassName = IdGenerated.class.getName();
        String finderMethodName = "findByCurValue";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(curValue) };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated WHERE ");

                query.append("curvalue LIKE ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(curValue);

                List<IdGenerated> list = q.list();

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                return list;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return (List<IdGenerated>) result;
        }
    }

    public List<IdGenerated> findByCurValue(long curValue, int start, int end)
        throws SystemException {
        return findByCurValue(curValue, start, end, null);
    }

    public List<IdGenerated> findByCurValue(long curValue, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = IdGeneratedModelImpl.CACHE_ENABLED;
        String finderClassName = IdGenerated.class.getName();
        String finderMethodName = "findByCurValue";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(curValue),
                
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated WHERE ");

                query.append("curvalue LIKE ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(curValue);

                List<IdGenerated> list = (List<IdGenerated>) QueryUtil.list(q,
                        getDialect(), start, end);

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                return list;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return (List<IdGenerated>) result;
        }
    }

    public IdGenerated findByCurValue_First(long curValue, OrderByComparator obc)
        throws NoSuchIdGeneratedException, SystemException {
        List<IdGenerated> list = findByCurValue(curValue, 0, 1, obc);

        if (list.size() == 0) {
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

        if (list.size() == 0) {
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
                "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated WHERE ");

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
        boolean finderClassNameCacheEnabled = IdGeneratedModelImpl.CACHE_ENABLED;
        String finderClassName = IdGenerated.class.getName();
        String finderMethodName = "findAll";
        String[] finderParams = new String[] {
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                String.valueOf(start), String.valueOf(end), String.valueOf(obc)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append(
                    "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<IdGenerated> list = (List<IdGenerated>) QueryUtil.list(q,
                        getDialect(), start, end);

                if (obc == null) {
                    Collections.sort(list);
                }

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                return list;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return (List<IdGenerated>) result;
        }
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
        boolean finderClassNameCacheEnabled = IdGeneratedModelImpl.CACHE_ENABLED;
        String finderClassName = IdGenerated.class.getName();
        String finderMethodName = "countByAllLike";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { year, new Long(curValue) };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated WHERE ");

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

                Long count = null;

                Iterator<Long> itr = q.list().iterator();

                if (itr.hasNext()) {
                    count = itr.next();
                }

                if (count == null) {
                    count = new Long(0);
                }

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, count);

                return count.intValue();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return ((Long) result).intValue();
        }
    }

    public int countByYear(String year) throws SystemException {
        boolean finderClassNameCacheEnabled = IdGeneratedModelImpl.CACHE_ENABLED;
        String finderClassName = IdGenerated.class.getName();
        String finderMethodName = "countByYear";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { year };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated WHERE ");

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

                Long count = null;

                Iterator<Long> itr = q.list().iterator();

                if (itr.hasNext()) {
                    count = itr.next();
                }

                if (count == null) {
                    count = new Long(0);
                }

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, count);

                return count.intValue();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return ((Long) result).intValue();
        }
    }

    public int countByCurValue(long curValue) throws SystemException {
        boolean finderClassNameCacheEnabled = IdGeneratedModelImpl.CACHE_ENABLED;
        String finderClassName = IdGenerated.class.getName();
        String finderMethodName = "countByCurValue";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(curValue) };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                StringBuilder query = new StringBuilder();

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.generatetemplateid.model.IdGenerated WHERE ");

                query.append("curvalue LIKE ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(curValue);

                Long count = null;

                Iterator<Long> itr = q.list().iterator();

                if (itr.hasNext()) {
                    count = itr.next();
                }

                if (count == null) {
                    count = new Long(0);
                }

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, count);

                return count.intValue();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return ((Long) result).intValue();
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = IdGeneratedModelImpl.CACHE_ENABLED;
        String finderClassName = IdGenerated.class.getName();
        String finderMethodName = "countAll";
        String[] finderParams = new String[] {  };
        Object[] finderArgs = new Object[] {  };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(
                        "SELECT COUNT(*) FROM com.sgs.portlet.generatetemplateid.model.IdGenerated");

                Long count = null;

                Iterator<Long> itr = q.list().iterator();

                if (itr.hasNext()) {
                    count = itr.next();
                }

                if (count == null) {
                    count = new Long(0);
                }

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, count);

                return count.intValue();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            return ((Long) result).intValue();
        }
    }

    public void registerListener(ModelListener listener) {
        List<ModelListener> listeners = ListUtil.fromArray(_listeners);

        listeners.add(listener);

        _listeners = listeners.toArray(new ModelListener[listeners.size()]);
    }

    public void unregisterListener(ModelListener listener) {
        List<ModelListener> listeners = ListUtil.fromArray(_listeners);

        listeners.remove(listener);

        _listeners = listeners.toArray(new ModelListener[listeners.size()]);
    }

    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.portal.util.PropsUtil.get(
                        "value.object.listener.com.sgs.portlet.generatetemplateid.model.IdGenerated")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener> listeners = new ArrayList<ModelListener>();

                for (String listenerClassName : listenerClassNames) {
                    listeners.add((ModelListener) Class.forName(
                            listenerClassName).newInstance());
                }

                _listeners = listeners.toArray(new ModelListener[listeners.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
