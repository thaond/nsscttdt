package com.sgs.portlet.department.service.persistence;

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

import com.sgs.portlet.department.NoSuchPmlDepartmentHSCVException;
import com.sgs.portlet.department.model.PmlDepartmentHSCV;
import com.sgs.portlet.department.model.impl.PmlDepartmentHSCVImpl;
import com.sgs.portlet.department.model.impl.PmlDepartmentHSCVModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlDepartmentHSCVPersistenceImpl extends BasePersistenceImpl
    implements PmlDepartmentHSCVPersistence {
    private static Log _log = LogFactory.getLog(PmlDepartmentHSCVPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlDepartmentHSCV create(long pmlDepartmentHSCVId) {
        PmlDepartmentHSCV pmlDepartmentHSCV = new PmlDepartmentHSCVImpl();

        pmlDepartmentHSCV.setNew(true);
        pmlDepartmentHSCV.setPrimaryKey(pmlDepartmentHSCVId);

        return pmlDepartmentHSCV;
    }

    public PmlDepartmentHSCV remove(long pmlDepartmentHSCVId)
        throws NoSuchPmlDepartmentHSCVException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlDepartmentHSCV pmlDepartmentHSCV = (PmlDepartmentHSCV) session.get(PmlDepartmentHSCVImpl.class,
                    new Long(pmlDepartmentHSCVId));

            if (pmlDepartmentHSCV == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlDepartmentHSCV exists with the primary key " +
                        pmlDepartmentHSCVId);
                }

                throw new NoSuchPmlDepartmentHSCVException(
                    "No PmlDepartmentHSCV exists with the primary key " +
                    pmlDepartmentHSCVId);
            }

            return remove(pmlDepartmentHSCV);
        } catch (NoSuchPmlDepartmentHSCVException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlDepartmentHSCV remove(PmlDepartmentHSCV pmlDepartmentHSCV)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlDepartmentHSCV);
            }
        }

        pmlDepartmentHSCV = removeImpl(pmlDepartmentHSCV);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlDepartmentHSCV);
            }
        }

        return pmlDepartmentHSCV;
    }

    protected PmlDepartmentHSCV removeImpl(PmlDepartmentHSCV pmlDepartmentHSCV)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlDepartmentHSCV);

            session.flush();

            return pmlDepartmentHSCV;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDepartmentHSCV.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlDepartmentHSCV pmlDepartmentHSCV, boolean merge)</code>.
     */
    public PmlDepartmentHSCV update(PmlDepartmentHSCV pmlDepartmentHSCV)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlDepartmentHSCV pmlDepartmentHSCV) method. Use update(PmlDepartmentHSCV pmlDepartmentHSCV, boolean merge) instead.");
        }

        return update(pmlDepartmentHSCV, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDepartmentHSCV the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDepartmentHSCV is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlDepartmentHSCV update(PmlDepartmentHSCV pmlDepartmentHSCV,
        boolean merge) throws SystemException {
        boolean isNew = pmlDepartmentHSCV.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlDepartmentHSCV);
                } else {
                    listener.onBeforeUpdate(pmlDepartmentHSCV);
                }
            }
        }

        pmlDepartmentHSCV = updateImpl(pmlDepartmentHSCV, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlDepartmentHSCV);
                } else {
                    listener.onAfterUpdate(pmlDepartmentHSCV);
                }
            }
        }

        return pmlDepartmentHSCV;
    }

    public PmlDepartmentHSCV updateImpl(
        com.sgs.portlet.department.model.PmlDepartmentHSCV pmlDepartmentHSCV,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlDepartmentHSCV);
            } else {
                if (pmlDepartmentHSCV.isNew()) {
                    session.save(pmlDepartmentHSCV);
                }
            }

            session.flush();

            pmlDepartmentHSCV.setNew(false);

            return pmlDepartmentHSCV;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDepartmentHSCV.class.getName());
        }
    }

    public PmlDepartmentHSCV findByPrimaryKey(long pmlDepartmentHSCVId)
        throws NoSuchPmlDepartmentHSCVException, SystemException {
        PmlDepartmentHSCV pmlDepartmentHSCV = fetchByPrimaryKey(pmlDepartmentHSCVId);

        if (pmlDepartmentHSCV == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlDepartmentHSCV exists with the primary key " +
                    pmlDepartmentHSCVId);
            }

            throw new NoSuchPmlDepartmentHSCVException(
                "No PmlDepartmentHSCV exists with the primary key " +
                pmlDepartmentHSCVId);
        }

        return pmlDepartmentHSCV;
    }

    public PmlDepartmentHSCV fetchByPrimaryKey(long pmlDepartmentHSCVId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlDepartmentHSCV) session.get(PmlDepartmentHSCVImpl.class,
                new Long(pmlDepartmentHSCVId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDepartmentHSCV> findByDepartmentsId(String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentHSCV.class.getName();
        String finderMethodName = "findByDepartmentsId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsId };

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
                    "FROM com.sgs.portlet.department.model.PmlDepartmentHSCV WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("pmlDepartmentHSCVId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlDepartmentHSCV> list = q.list();

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
            return (List<PmlDepartmentHSCV>) result;
        }
    }

    public List<PmlDepartmentHSCV> findByDepartmentsId(String departmentsId,
        int start, int end) throws SystemException {
        return findByDepartmentsId(departmentsId, start, end, null);
    }

    public List<PmlDepartmentHSCV> findByDepartmentsId(String departmentsId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentHSCV.class.getName();
        String finderMethodName = "findByDepartmentsId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentsId,
                
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
                    "FROM com.sgs.portlet.department.model.PmlDepartmentHSCV WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("pmlDepartmentHSCVId ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlDepartmentHSCV> list = (List<PmlDepartmentHSCV>) QueryUtil.list(q,
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
            return (List<PmlDepartmentHSCV>) result;
        }
    }

    public PmlDepartmentHSCV findByDepartmentsId_First(String departmentsId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentHSCVException, SystemException {
        List<PmlDepartmentHSCV> list = findByDepartmentsId(departmentsId, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentHSCV exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentHSCVException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentHSCV findByDepartmentsId_Last(String departmentsId,
        OrderByComparator obc)
        throws NoSuchPmlDepartmentHSCVException, SystemException {
        int count = countByDepartmentsId(departmentsId);

        List<PmlDepartmentHSCV> list = findByDepartmentsId(departmentsId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDepartmentHSCV exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlDepartmentHSCVException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDepartmentHSCV[] findByDepartmentsId_PrevAndNext(
        long pmlDepartmentHSCVId, String departmentsId, OrderByComparator obc)
        throws NoSuchPmlDepartmentHSCVException, SystemException {
        PmlDepartmentHSCV pmlDepartmentHSCV = findByPrimaryKey(pmlDepartmentHSCVId);

        int count = countByDepartmentsId(departmentsId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.department.model.PmlDepartmentHSCV WHERE ");

            if (departmentsId == null) {
                query.append("departmentsId LIKE null");
            } else {
                query.append("departmentsId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("pmlDepartmentHSCVId ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDepartmentHSCV);

            PmlDepartmentHSCV[] array = new PmlDepartmentHSCVImpl[3];

            array[0] = (PmlDepartmentHSCV) objArray[0];
            array[1] = (PmlDepartmentHSCV) objArray[1];
            array[2] = (PmlDepartmentHSCV) objArray[2];

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

    public List<PmlDepartmentHSCV> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlDepartmentHSCV> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlDepartmentHSCV> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentHSCV.class.getName();
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
                    "FROM com.sgs.portlet.department.model.PmlDepartmentHSCV ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("pmlDepartmentHSCVId ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlDepartmentHSCV> list = (List<PmlDepartmentHSCV>) QueryUtil.list(q,
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
            return (List<PmlDepartmentHSCV>) result;
        }
    }

    public void removeByDepartmentsId(String departmentsId)
        throws SystemException {
        for (PmlDepartmentHSCV pmlDepartmentHSCV : findByDepartmentsId(
                departmentsId)) {
            remove(pmlDepartmentHSCV);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlDepartmentHSCV pmlDepartmentHSCV : findAll()) {
            remove(pmlDepartmentHSCV);
        }
    }

    public int countByDepartmentsId(String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDepartmentHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentHSCV.class.getName();
        String finderMethodName = "countByDepartmentsId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsId };

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
                    "FROM com.sgs.portlet.department.model.PmlDepartmentHSCV WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsId LIKE null");
                } else {
                    query.append("departmentsId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
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
        boolean finderClassNameCacheEnabled = PmlDepartmentHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDepartmentHSCV.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.department.model.PmlDepartmentHSCV");

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
                        "value.object.listener.com.sgs.portlet.department.model.PmlDepartmentHSCV")));

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
