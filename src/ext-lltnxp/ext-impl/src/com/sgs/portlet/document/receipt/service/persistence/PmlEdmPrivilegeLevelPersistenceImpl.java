package com.sgs.portlet.document.receipt.service.persistence;

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

import com.sgs.portlet.document.receipt.NoSuchPmlEdmPrivilegeLevelException;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmPrivilegeLevelImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmPrivilegeLevelModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmPrivilegeLevelPersistenceImpl extends BasePersistenceImpl
    implements PmlEdmPrivilegeLevelPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmPrivilegeLevelPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmPrivilegeLevel create(String privilegeLevelId) {
        PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel = new PmlEdmPrivilegeLevelImpl();

        pmlEdmPrivilegeLevel.setNew(true);
        pmlEdmPrivilegeLevel.setPrimaryKey(privilegeLevelId);

        return pmlEdmPrivilegeLevel;
    }

    public PmlEdmPrivilegeLevel remove(String privilegeLevelId)
        throws NoSuchPmlEdmPrivilegeLevelException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel = (PmlEdmPrivilegeLevel) session.get(PmlEdmPrivilegeLevelImpl.class,
                    privilegeLevelId);

            if (pmlEdmPrivilegeLevel == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmPrivilegeLevel exists with the primary key " +
                        privilegeLevelId);
                }

                throw new NoSuchPmlEdmPrivilegeLevelException(
                    "No PmlEdmPrivilegeLevel exists with the primary key " +
                    privilegeLevelId);
            }

            return remove(pmlEdmPrivilegeLevel);
        } catch (NoSuchPmlEdmPrivilegeLevelException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmPrivilegeLevel remove(
        PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmPrivilegeLevel);
            }
        }

        pmlEdmPrivilegeLevel = removeImpl(pmlEdmPrivilegeLevel);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmPrivilegeLevel);
            }
        }

        return pmlEdmPrivilegeLevel;
    }

    protected PmlEdmPrivilegeLevel removeImpl(
        PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmPrivilegeLevel);

            session.flush();

            return pmlEdmPrivilegeLevel;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmPrivilegeLevel.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel, boolean merge)</code>.
     */
    public PmlEdmPrivilegeLevel update(
        PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel) method. Use update(PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel, boolean merge) instead.");
        }

        return update(pmlEdmPrivilegeLevel, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmPrivilegeLevel the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmPrivilegeLevel is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmPrivilegeLevel update(
        PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmPrivilegeLevel.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmPrivilegeLevel);
                } else {
                    listener.onBeforeUpdate(pmlEdmPrivilegeLevel);
                }
            }
        }

        pmlEdmPrivilegeLevel = updateImpl(pmlEdmPrivilegeLevel, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmPrivilegeLevel);
                } else {
                    listener.onAfterUpdate(pmlEdmPrivilegeLevel);
                }
            }
        }

        return pmlEdmPrivilegeLevel;
    }

    public PmlEdmPrivilegeLevel updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmPrivilegeLevel);
            } else {
                if (pmlEdmPrivilegeLevel.isNew()) {
                    session.save(pmlEdmPrivilegeLevel);
                }
            }

            session.flush();

            pmlEdmPrivilegeLevel.setNew(false);

            return pmlEdmPrivilegeLevel;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmPrivilegeLevel.class.getName());
        }
    }

    public PmlEdmPrivilegeLevel findByPrimaryKey(String privilegeLevelId)
        throws NoSuchPmlEdmPrivilegeLevelException, SystemException {
        PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel = fetchByPrimaryKey(privilegeLevelId);

        if (pmlEdmPrivilegeLevel == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmPrivilegeLevel exists with the primary key " +
                    privilegeLevelId);
            }

            throw new NoSuchPmlEdmPrivilegeLevelException(
                "No PmlEdmPrivilegeLevel exists with the primary key " +
                privilegeLevelId);
        }

        return pmlEdmPrivilegeLevel;
    }

    public PmlEdmPrivilegeLevel fetchByPrimaryKey(String privilegeLevelId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmPrivilegeLevel) session.get(PmlEdmPrivilegeLevelImpl.class,
                privilegeLevelId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmPrivilegeLevel> findByPrivilegeLevelName(
        String privilegeLevelName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmPrivilegeLevelModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmPrivilegeLevel.class.getName();
        String finderMethodName = "findByPrivilegeLevelName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { privilegeLevelName };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel WHERE ");

                if (privilegeLevelName == null) {
                    query.append("privilegelevelname LIKE null");
                } else {
                    query.append("privilegelevelname LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("privilegelevelname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (privilegeLevelName != null) {
                    qPos.add(privilegeLevelName);
                }

                List<PmlEdmPrivilegeLevel> list = q.list();

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
            return (List<PmlEdmPrivilegeLevel>) result;
        }
    }

    public List<PmlEdmPrivilegeLevel> findByPrivilegeLevelName(
        String privilegeLevelName, int start, int end)
        throws SystemException {
        return findByPrivilegeLevelName(privilegeLevelName, start, end, null);
    }

    public List<PmlEdmPrivilegeLevel> findByPrivilegeLevelName(
        String privilegeLevelName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmPrivilegeLevelModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmPrivilegeLevel.class.getName();
        String finderMethodName = "findByPrivilegeLevelName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                privilegeLevelName,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel WHERE ");

                if (privilegeLevelName == null) {
                    query.append("privilegelevelname LIKE null");
                } else {
                    query.append("privilegelevelname LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("privilegelevelname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (privilegeLevelName != null) {
                    qPos.add(privilegeLevelName);
                }

                List<PmlEdmPrivilegeLevel> list = (List<PmlEdmPrivilegeLevel>) QueryUtil.list(q,
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
            return (List<PmlEdmPrivilegeLevel>) result;
        }
    }

    public PmlEdmPrivilegeLevel findByPrivilegeLevelName_First(
        String privilegeLevelName, OrderByComparator obc)
        throws NoSuchPmlEdmPrivilegeLevelException, SystemException {
        List<PmlEdmPrivilegeLevel> list = findByPrivilegeLevelName(privilegeLevelName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmPrivilegeLevel exists with the key {");

            msg.append("privilegeLevelName=" + privilegeLevelName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmPrivilegeLevelException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmPrivilegeLevel findByPrivilegeLevelName_Last(
        String privilegeLevelName, OrderByComparator obc)
        throws NoSuchPmlEdmPrivilegeLevelException, SystemException {
        int count = countByPrivilegeLevelName(privilegeLevelName);

        List<PmlEdmPrivilegeLevel> list = findByPrivilegeLevelName(privilegeLevelName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmPrivilegeLevel exists with the key {");

            msg.append("privilegeLevelName=" + privilegeLevelName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmPrivilegeLevelException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmPrivilegeLevel[] findByPrivilegeLevelName_PrevAndNext(
        String privilegeLevelId, String privilegeLevelName,
        OrderByComparator obc)
        throws NoSuchPmlEdmPrivilegeLevelException, SystemException {
        PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel = findByPrimaryKey(privilegeLevelId);

        int count = countByPrivilegeLevelName(privilegeLevelName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel WHERE ");

            if (privilegeLevelName == null) {
                query.append("privilegelevelname LIKE null");
            } else {
                query.append("privilegelevelname LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("privilegelevelname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (privilegeLevelName != null) {
                qPos.add(privilegeLevelName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmPrivilegeLevel);

            PmlEdmPrivilegeLevel[] array = new PmlEdmPrivilegeLevelImpl[3];

            array[0] = (PmlEdmPrivilegeLevel) objArray[0];
            array[1] = (PmlEdmPrivilegeLevel) objArray[1];
            array[2] = (PmlEdmPrivilegeLevel) objArray[2];

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

    public List<PmlEdmPrivilegeLevel> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmPrivilegeLevel> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmPrivilegeLevel> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmPrivilegeLevelModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmPrivilegeLevel.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("privilegelevelname ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmPrivilegeLevel> list = (List<PmlEdmPrivilegeLevel>) QueryUtil.list(q,
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
            return (List<PmlEdmPrivilegeLevel>) result;
        }
    }

    public void removeByPrivilegeLevelName(String privilegeLevelName)
        throws SystemException {
        for (PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel : findByPrivilegeLevelName(
                privilegeLevelName)) {
            remove(pmlEdmPrivilegeLevel);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel : findAll()) {
            remove(pmlEdmPrivilegeLevel);
        }
    }

    public int countByPrivilegeLevelName(String privilegeLevelName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmPrivilegeLevelModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmPrivilegeLevel.class.getName();
        String finderMethodName = "countByPrivilegeLevelName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { privilegeLevelName };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel WHERE ");

                if (privilegeLevelName == null) {
                    query.append("privilegelevelname LIKE null");
                } else {
                    query.append("privilegelevelname LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (privilegeLevelName != null) {
                    qPos.add(privilegeLevelName);
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
        boolean finderClassNameCacheEnabled = PmlEdmPrivilegeLevelModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmPrivilegeLevel.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel")));

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
