package com.ext.portlet.meetingcalendar.service.persistence;

import com.ext.portlet.meetingcalendar.NoSuchCarResourceException;
import com.ext.portlet.meetingcalendar.model.CarResource;
import com.ext.portlet.meetingcalendar.model.impl.CarResourceImpl;
import com.ext.portlet.meetingcalendar.model.impl.CarResourceModelImpl;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class CarResourcePersistenceImpl extends BasePersistenceImpl
    implements CarResourcePersistence {
    private static Log _log = LogFactory.getLog(CarResourcePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public CarResource create(long carId) {
        CarResource carResource = new CarResourceImpl();

        carResource.setNew(true);
        carResource.setPrimaryKey(carId);

        return carResource;
    }

    public CarResource remove(long carId)
        throws NoSuchCarResourceException, SystemException {
        Session session = null;

        try {
            session = openSession();

            CarResource carResource = (CarResource) session.get(CarResourceImpl.class,
                    new Long(carId));

            if (carResource == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No CarResource exists with the primary key " +
                        carId);
                }

                throw new NoSuchCarResourceException(
                    "No CarResource exists with the primary key " + carId);
            }

            return remove(carResource);
        } catch (NoSuchCarResourceException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public CarResource remove(CarResource carResource)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(carResource);
            }
        }

        carResource = removeImpl(carResource);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(carResource);
            }
        }

        return carResource;
    }

    protected CarResource removeImpl(CarResource carResource)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(carResource);

            session.flush();

            return carResource;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(CarResource.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(CarResource carResource, boolean merge)</code>.
     */
    public CarResource update(CarResource carResource)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(CarResource carResource) method. Use update(CarResource carResource, boolean merge) instead.");
        }

        return update(carResource, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                carResource the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when carResource is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public CarResource update(CarResource carResource, boolean merge)
        throws SystemException {
        boolean isNew = carResource.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(carResource);
                } else {
                    listener.onBeforeUpdate(carResource);
                }
            }
        }

        carResource = updateImpl(carResource, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(carResource);
                } else {
                    listener.onAfterUpdate(carResource);
                }
            }
        }

        return carResource;
    }

    public CarResource updateImpl(
        com.ext.portlet.meetingcalendar.model.CarResource carResource,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(carResource);
            } else {
                if (carResource.isNew()) {
                    session.save(carResource);
                }
            }

            session.flush();

            carResource.setNew(false);

            return carResource;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(CarResource.class.getName());
        }
    }

    public CarResource findByPrimaryKey(long carId)
        throws NoSuchCarResourceException, SystemException {
        CarResource carResource = fetchByPrimaryKey(carId);

        if (carResource == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No CarResource exists with the primary key " +
                    carId);
            }

            throw new NoSuchCarResourceException(
                "No CarResource exists with the primary key " + carId);
        }

        return carResource;
    }

    public CarResource fetchByPrimaryKey(long carId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (CarResource) session.get(CarResourceImpl.class,
                new Long(carId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public CarResource findByC_C(String carCode, long companyId)
        throws NoSuchCarResourceException, SystemException {
        CarResource carResource = fetchByC_C(carCode, companyId);

        if (carResource == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CarResource exists with the key {");

            msg.append("carCode=" + carCode);

            msg.append(", ");
            msg.append("companyId=" + companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchCarResourceException(msg.toString());
        }

        return carResource;
    }

    public CarResource fetchByC_C(String carCode, long companyId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CarResourceModelImpl.CACHE_ENABLED;
        String finderClassName = CarResource.class.getName();
        String finderMethodName = "fetchByC_C";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { carCode, new Long(companyId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.CarResource WHERE ");

                if (carCode == null) {
                    query.append("carCode IS NULL");
                } else {
                    query.append("carCode = ?");
                }

                query.append(" AND ");

                query.append("companyId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("carName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (carCode != null) {
                    qPos.add(carCode);
                }

                qPos.add(companyId);

                List<CarResource> list = q.list();

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                if (list.size() == 0) {
                    return null;
                } else {
                    return list.get(0);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            List<CarResource> list = (List<CarResource>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public List<CarResource> findByCompanyId(long companyId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CarResourceModelImpl.CACHE_ENABLED;
        String finderClassName = CarResource.class.getName();
        String finderMethodName = "findByCompanyId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(companyId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.CarResource WHERE ");

                query.append("companyId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("carName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                List<CarResource> list = q.list();

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
            return (List<CarResource>) result;
        }
    }

    public List<CarResource> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    public List<CarResource> findByCompanyId(long companyId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = CarResourceModelImpl.CACHE_ENABLED;
        String finderClassName = CarResource.class.getName();
        String finderMethodName = "findByCompanyId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(companyId),
                
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
                    "FROM com.ext.portlet.meetingcalendar.model.CarResource WHERE ");

                query.append("companyId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("carName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                List<CarResource> list = (List<CarResource>) QueryUtil.list(q,
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
            return (List<CarResource>) result;
        }
    }

    public CarResource findByCompanyId_First(long companyId,
        OrderByComparator obc)
        throws NoSuchCarResourceException, SystemException {
        List<CarResource> list = findByCompanyId(companyId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CarResource exists with the key {");

            msg.append("companyId=" + companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCarResourceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public CarResource findByCompanyId_Last(long companyId,
        OrderByComparator obc)
        throws NoSuchCarResourceException, SystemException {
        int count = countByCompanyId(companyId);

        List<CarResource> list = findByCompanyId(companyId, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No CarResource exists with the key {");

            msg.append("companyId=" + companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchCarResourceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public CarResource[] findByCompanyId_PrevAndNext(long carId,
        long companyId, OrderByComparator obc)
        throws NoSuchCarResourceException, SystemException {
        CarResource carResource = findByPrimaryKey(carId);

        int count = countByCompanyId(companyId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.ext.portlet.meetingcalendar.model.CarResource WHERE ");

            query.append("companyId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("carName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(companyId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    carResource);

            CarResource[] array = new CarResourceImpl[3];

            array[0] = (CarResource) objArray[0];
            array[1] = (CarResource) objArray[1];
            array[2] = (CarResource) objArray[2];

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

    public List<CarResource> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<CarResource> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<CarResource> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CarResourceModelImpl.CACHE_ENABLED;
        String finderClassName = CarResource.class.getName();
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
                    "FROM com.ext.portlet.meetingcalendar.model.CarResource ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("carName ASC");
                }

                Query q = session.createQuery(query.toString());

                List<CarResource> list = (List<CarResource>) QueryUtil.list(q,
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
            return (List<CarResource>) result;
        }
    }

    public void removeByC_C(String carCode, long companyId)
        throws NoSuchCarResourceException, SystemException {
        CarResource carResource = findByC_C(carCode, companyId);

        remove(carResource);
    }

    public void removeByCompanyId(long companyId) throws SystemException {
        for (CarResource carResource : findByCompanyId(companyId)) {
            remove(carResource);
        }
    }

    public void removeAll() throws SystemException {
        for (CarResource carResource : findAll()) {
            remove(carResource);
        }
    }

    public int countByC_C(String carCode, long companyId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = CarResourceModelImpl.CACHE_ENABLED;
        String finderClassName = CarResource.class.getName();
        String finderMethodName = "countByC_C";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { carCode, new Long(companyId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.CarResource WHERE ");

                if (carCode == null) {
                    query.append("carCode IS NULL");
                } else {
                    query.append("carCode = ?");
                }

                query.append(" AND ");

                query.append("companyId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (carCode != null) {
                    qPos.add(carCode);
                }

                qPos.add(companyId);

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

    public int countByCompanyId(long companyId) throws SystemException {
        boolean finderClassNameCacheEnabled = CarResourceModelImpl.CACHE_ENABLED;
        String finderClassName = CarResource.class.getName();
        String finderMethodName = "countByCompanyId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(companyId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.CarResource WHERE ");

                query.append("companyId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

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
        boolean finderClassNameCacheEnabled = CarResourceModelImpl.CACHE_ENABLED;
        String finderClassName = CarResource.class.getName();
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
                        "SELECT COUNT(*) FROM com.ext.portlet.meetingcalendar.model.CarResource");

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
                        "value.object.listener.com.ext.portlet.meetingcalendar.model.CarResource")));

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
