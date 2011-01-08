package com.sgs.portlet.pml_do_quan_trong.service.persistence;

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

import com.sgs.portlet.pml_do_quan_trong.NoSuchPmlDoQuanTrongException;
import com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong;
import com.sgs.portlet.pml_do_quan_trong.model.impl.PmlDoQuanTrongImpl;
import com.sgs.portlet.pml_do_quan_trong.model.impl.PmlDoQuanTrongModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlDoQuanTrongPersistenceImpl extends BasePersistenceImpl
    implements PmlDoQuanTrongPersistence {
    private static Log _log = LogFactory.getLog(PmlDoQuanTrongPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlDoQuanTrong create(long idDoQuanTrong) {
        PmlDoQuanTrong pmlDoQuanTrong = new PmlDoQuanTrongImpl();

        pmlDoQuanTrong.setNew(true);
        pmlDoQuanTrong.setPrimaryKey(idDoQuanTrong);

        return pmlDoQuanTrong;
    }

    public PmlDoQuanTrong remove(long idDoQuanTrong)
        throws NoSuchPmlDoQuanTrongException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlDoQuanTrong pmlDoQuanTrong = (PmlDoQuanTrong) session.get(PmlDoQuanTrongImpl.class,
                    new Long(idDoQuanTrong));

            if (pmlDoQuanTrong == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlDoQuanTrong exists with the primary key " +
                        idDoQuanTrong);
                }

                throw new NoSuchPmlDoQuanTrongException(
                    "No PmlDoQuanTrong exists with the primary key " +
                    idDoQuanTrong);
            }

            return remove(pmlDoQuanTrong);
        } catch (NoSuchPmlDoQuanTrongException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlDoQuanTrong remove(PmlDoQuanTrong pmlDoQuanTrong)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlDoQuanTrong);
            }
        }

        pmlDoQuanTrong = removeImpl(pmlDoQuanTrong);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlDoQuanTrong);
            }
        }

        return pmlDoQuanTrong;
    }

    protected PmlDoQuanTrong removeImpl(PmlDoQuanTrong pmlDoQuanTrong)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlDoQuanTrong);

            session.flush();

            return pmlDoQuanTrong;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDoQuanTrong.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlDoQuanTrong pmlDoQuanTrong, boolean merge)</code>.
     */
    public PmlDoQuanTrong update(PmlDoQuanTrong pmlDoQuanTrong)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlDoQuanTrong pmlDoQuanTrong) method. Use update(PmlDoQuanTrong pmlDoQuanTrong, boolean merge) instead.");
        }

        return update(pmlDoQuanTrong, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDoQuanTrong the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDoQuanTrong is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlDoQuanTrong update(PmlDoQuanTrong pmlDoQuanTrong, boolean merge)
        throws SystemException {
        boolean isNew = pmlDoQuanTrong.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlDoQuanTrong);
                } else {
                    listener.onBeforeUpdate(pmlDoQuanTrong);
                }
            }
        }

        pmlDoQuanTrong = updateImpl(pmlDoQuanTrong, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlDoQuanTrong);
                } else {
                    listener.onAfterUpdate(pmlDoQuanTrong);
                }
            }
        }

        return pmlDoQuanTrong;
    }

    public PmlDoQuanTrong updateImpl(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlDoQuanTrong);
            } else {
                if (pmlDoQuanTrong.isNew()) {
                    session.save(pmlDoQuanTrong);
                }
            }

            session.flush();

            pmlDoQuanTrong.setNew(false);

            return pmlDoQuanTrong;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDoQuanTrong.class.getName());
        }
    }

    public PmlDoQuanTrong findByPrimaryKey(long idDoQuanTrong)
        throws NoSuchPmlDoQuanTrongException, SystemException {
        PmlDoQuanTrong pmlDoQuanTrong = fetchByPrimaryKey(idDoQuanTrong);

        if (pmlDoQuanTrong == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlDoQuanTrong exists with the primary key " +
                    idDoQuanTrong);
            }

            throw new NoSuchPmlDoQuanTrongException(
                "No PmlDoQuanTrong exists with the primary key " +
                idDoQuanTrong);
        }

        return pmlDoQuanTrong;
    }

    public PmlDoQuanTrong fetchByPrimaryKey(long idDoQuanTrong)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlDoQuanTrong) session.get(PmlDoQuanTrongImpl.class,
                new Long(idDoQuanTrong));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDoQuanTrong> findByTenDoQuanTrong(String tenDoQuanTrong)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDoQuanTrongModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDoQuanTrong.class.getName();
        String finderMethodName = "findByTenDoQuanTrong";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { tenDoQuanTrong };

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
                    "FROM com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong WHERE ");

                if (tenDoQuanTrong == null) {
                    query.append("ten_do_quan_trong LIKE null");
                } else {
                    query.append("ten_do_quan_trong LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ten_do_quan_trong ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (tenDoQuanTrong != null) {
                    qPos.add(tenDoQuanTrong);
                }

                List<PmlDoQuanTrong> list = q.list();

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
            return (List<PmlDoQuanTrong>) result;
        }
    }

    public List<PmlDoQuanTrong> findByTenDoQuanTrong(String tenDoQuanTrong,
        int start, int end) throws SystemException {
        return findByTenDoQuanTrong(tenDoQuanTrong, start, end, null);
    }

    public List<PmlDoQuanTrong> findByTenDoQuanTrong(String tenDoQuanTrong,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDoQuanTrongModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDoQuanTrong.class.getName();
        String finderMethodName = "findByTenDoQuanTrong";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                tenDoQuanTrong,
                
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
                    "FROM com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong WHERE ");

                if (tenDoQuanTrong == null) {
                    query.append("ten_do_quan_trong LIKE null");
                } else {
                    query.append("ten_do_quan_trong LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_do_quan_trong ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (tenDoQuanTrong != null) {
                    qPos.add(tenDoQuanTrong);
                }

                List<PmlDoQuanTrong> list = (List<PmlDoQuanTrong>) QueryUtil.list(q,
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
            return (List<PmlDoQuanTrong>) result;
        }
    }

    public PmlDoQuanTrong findByTenDoQuanTrong_First(String tenDoQuanTrong,
        OrderByComparator obc)
        throws NoSuchPmlDoQuanTrongException, SystemException {
        List<PmlDoQuanTrong> list = findByTenDoQuanTrong(tenDoQuanTrong, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDoQuanTrong exists with the key {");

            msg.append("tenDoQuanTrong=" + tenDoQuanTrong);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDoQuanTrongException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDoQuanTrong findByTenDoQuanTrong_Last(String tenDoQuanTrong,
        OrderByComparator obc)
        throws NoSuchPmlDoQuanTrongException, SystemException {
        int count = countByTenDoQuanTrong(tenDoQuanTrong);

        List<PmlDoQuanTrong> list = findByTenDoQuanTrong(tenDoQuanTrong,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDoQuanTrong exists with the key {");

            msg.append("tenDoQuanTrong=" + tenDoQuanTrong);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDoQuanTrongException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDoQuanTrong[] findByTenDoQuanTrong_PrevAndNext(
        long idDoQuanTrong, String tenDoQuanTrong, OrderByComparator obc)
        throws NoSuchPmlDoQuanTrongException, SystemException {
        PmlDoQuanTrong pmlDoQuanTrong = findByPrimaryKey(idDoQuanTrong);

        int count = countByTenDoQuanTrong(tenDoQuanTrong);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong WHERE ");

            if (tenDoQuanTrong == null) {
                query.append("ten_do_quan_trong LIKE null");
            } else {
                query.append("ten_do_quan_trong LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ten_do_quan_trong ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (tenDoQuanTrong != null) {
                qPos.add(tenDoQuanTrong);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDoQuanTrong);

            PmlDoQuanTrong[] array = new PmlDoQuanTrongImpl[3];

            array[0] = (PmlDoQuanTrong) objArray[0];
            array[1] = (PmlDoQuanTrong) objArray[1];
            array[2] = (PmlDoQuanTrong) objArray[2];

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

    public List<PmlDoQuanTrong> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlDoQuanTrong> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlDoQuanTrong> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDoQuanTrongModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDoQuanTrong.class.getName();
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
                    "FROM com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_do_quan_trong ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlDoQuanTrong> list = (List<PmlDoQuanTrong>) QueryUtil.list(q,
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
            return (List<PmlDoQuanTrong>) result;
        }
    }

    public void removeByTenDoQuanTrong(String tenDoQuanTrong)
        throws SystemException {
        for (PmlDoQuanTrong pmlDoQuanTrong : findByTenDoQuanTrong(
                tenDoQuanTrong)) {
            remove(pmlDoQuanTrong);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlDoQuanTrong pmlDoQuanTrong : findAll()) {
            remove(pmlDoQuanTrong);
        }
    }

    public int countByTenDoQuanTrong(String tenDoQuanTrong)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDoQuanTrongModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDoQuanTrong.class.getName();
        String finderMethodName = "countByTenDoQuanTrong";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { tenDoQuanTrong };

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
                    "FROM com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong WHERE ");

                if (tenDoQuanTrong == null) {
                    query.append("ten_do_quan_trong LIKE null");
                } else {
                    query.append("ten_do_quan_trong LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (tenDoQuanTrong != null) {
                    qPos.add(tenDoQuanTrong);
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

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDoQuanTrongModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDoQuanTrong.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong");

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
                        "value.object.listener.com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong")));

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
