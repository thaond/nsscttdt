package com.sgs.portlet.pmlstreet.service.persistence;

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

import com.sgs.portlet.pmlstreet.NoSuchException;
import com.sgs.portlet.pmlstreet.model.PmlStreet;
import com.sgs.portlet.pmlstreet.model.impl.PmlStreetImpl;
import com.sgs.portlet.pmlstreet.model.impl.PmlStreetModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlStreetPersistenceImpl extends BasePersistenceImpl
    implements PmlStreetPersistence {
    private static Log _log = LogFactory.getLog(PmlStreetPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlStreet create(String streetId) {
        PmlStreet pmlStreet = new PmlStreetImpl();

        pmlStreet.setNew(true);
        pmlStreet.setPrimaryKey(streetId);

        return pmlStreet;
    }

    public PmlStreet remove(String streetId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlStreet pmlStreet = (PmlStreet) session.get(PmlStreetImpl.class,
                    streetId);

            if (pmlStreet == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlStreet exists with the primary key " +
                        streetId);
                }

                throw new NoSuchException(
                    "No PmlStreet exists with the primary key " + streetId);
            }

            return remove(pmlStreet);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlStreet remove(PmlStreet pmlStreet) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlStreet);
            }
        }

        pmlStreet = removeImpl(pmlStreet);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlStreet);
            }
        }

        return pmlStreet;
    }

    protected PmlStreet removeImpl(PmlStreet pmlStreet)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlStreet);

            session.flush();

            return pmlStreet;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlStreet.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlStreet pmlStreet, boolean merge)</code>.
     */
    public PmlStreet update(PmlStreet pmlStreet) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlStreet pmlStreet) method. Use update(PmlStreet pmlStreet, boolean merge) instead.");
        }

        return update(pmlStreet, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlStreet the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlStreet is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlStreet update(PmlStreet pmlStreet, boolean merge)
        throws SystemException {
        boolean isNew = pmlStreet.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlStreet);
                } else {
                    listener.onBeforeUpdate(pmlStreet);
                }
            }
        }

        pmlStreet = updateImpl(pmlStreet, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlStreet);
                } else {
                    listener.onAfterUpdate(pmlStreet);
                }
            }
        }

        return pmlStreet;
    }

    public PmlStreet updateImpl(
        com.sgs.portlet.pmlstreet.model.PmlStreet pmlStreet, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlStreet);
            } else {
                if (pmlStreet.isNew()) {
                    session.save(pmlStreet);
                }
            }

            session.flush();

            pmlStreet.setNew(false);

            return pmlStreet;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlStreet.class.getName());
        }
    }

    public PmlStreet findByPrimaryKey(String streetId)
        throws NoSuchException, SystemException {
        PmlStreet pmlStreet = fetchByPrimaryKey(streetId);

        if (pmlStreet == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlStreet exists with the primary key " +
                    streetId);
            }

            throw new NoSuchException(
                "No PmlStreet exists with the primary key " + streetId);
        }

        return pmlStreet;
    }

    public PmlStreet fetchByPrimaryKey(String streetId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlStreet) session.get(PmlStreetImpl.class, streetId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStreet> findByStreetName(String streetName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStreetModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStreet.class.getName();
        String finderMethodName = "findByStreetName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { streetName };

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
                    "FROM com.sgs.portlet.pmlstreet.model.PmlStreet WHERE ");

                if (streetName == null) {
                    query.append("streetName LIKE null");
                } else {
                    query.append("streetName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("streetName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (streetName != null) {
                    qPos.add(streetName);
                }

                List<PmlStreet> list = q.list();

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
            return (List<PmlStreet>) result;
        }
    }

    public List<PmlStreet> findByStreetName(String streetName, int start,
        int end) throws SystemException {
        return findByStreetName(streetName, start, end, null);
    }

    public List<PmlStreet> findByStreetName(String streetName, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStreetModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStreet.class.getName();
        String finderMethodName = "findByStreetName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                streetName,
                
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
                    "FROM com.sgs.portlet.pmlstreet.model.PmlStreet WHERE ");

                if (streetName == null) {
                    query.append("streetName LIKE null");
                } else {
                    query.append("streetName LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("streetName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (streetName != null) {
                    qPos.add(streetName);
                }

                List<PmlStreet> list = (List<PmlStreet>) QueryUtil.list(q,
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
            return (List<PmlStreet>) result;
        }
    }

    public PmlStreet findByStreetName_First(String streetName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlStreet> list = findByStreetName(streetName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStreet exists with the key {");

            msg.append("streetName=" + streetName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStreet findByStreetName_Last(String streetName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByStreetName(streetName);

        List<PmlStreet> list = findByStreetName(streetName, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStreet exists with the key {");

            msg.append("streetName=" + streetName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStreet[] findByStreetName_PrevAndNext(String streetId,
        String streetName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlStreet pmlStreet = findByPrimaryKey(streetId);

        int count = countByStreetName(streetName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pmlstreet.model.PmlStreet WHERE ");

            if (streetName == null) {
                query.append("streetName LIKE null");
            } else {
                query.append("streetName LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("streetName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (streetName != null) {
                qPos.add(streetName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStreet);

            PmlStreet[] array = new PmlStreetImpl[3];

            array[0] = (PmlStreet) objArray[0];
            array[1] = (PmlStreet) objArray[1];
            array[2] = (PmlStreet) objArray[2];

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

    public List<PmlStreet> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlStreet> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlStreet> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStreetModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStreet.class.getName();
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

                query.append("FROM com.sgs.portlet.pmlstreet.model.PmlStreet ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("streetName ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlStreet> list = (List<PmlStreet>) QueryUtil.list(q,
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
            return (List<PmlStreet>) result;
        }
    }

    public void removeByStreetName(String streetName) throws SystemException {
        for (PmlStreet pmlStreet : findByStreetName(streetName)) {
            remove(pmlStreet);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlStreet pmlStreet : findAll()) {
            remove(pmlStreet);
        }
    }

    public int countByStreetName(String streetName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStreetModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStreet.class.getName();
        String finderMethodName = "countByStreetName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { streetName };

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
                    "FROM com.sgs.portlet.pmlstreet.model.PmlStreet WHERE ");

                if (streetName == null) {
                    query.append("streetName LIKE null");
                } else {
                    query.append("streetName LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (streetName != null) {
                    qPos.add(streetName);
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
        boolean finderClassNameCacheEnabled = PmlStreetModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStreet.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.pmlstreet.model.PmlStreet");

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
                        "value.object.listener.com.sgs.portlet.pmlstreet.model.PmlStreet")));

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
