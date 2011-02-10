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

import com.sgs.portlet.document.receipt.NoSuchPmlEdmConfidentialLevelException;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmConfidentialLevelImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmConfidentialLevelModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmConfidentialLevelPersistenceImpl extends BasePersistenceImpl
    implements PmlEdmConfidentialLevelPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmConfidentialLevelPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmConfidentialLevel create(String confidentialLevelId) {
        PmlEdmConfidentialLevel pmlEdmConfidentialLevel = new PmlEdmConfidentialLevelImpl();

        pmlEdmConfidentialLevel.setNew(true);
        pmlEdmConfidentialLevel.setPrimaryKey(confidentialLevelId);

        return pmlEdmConfidentialLevel;
    }

    public PmlEdmConfidentialLevel remove(String confidentialLevelId)
        throws NoSuchPmlEdmConfidentialLevelException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmConfidentialLevel pmlEdmConfidentialLevel = (PmlEdmConfidentialLevel) session.get(PmlEdmConfidentialLevelImpl.class,
                    confidentialLevelId);

            if (pmlEdmConfidentialLevel == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmConfidentialLevel exists with the primary key " +
                        confidentialLevelId);
                }

                throw new NoSuchPmlEdmConfidentialLevelException(
                    "No PmlEdmConfidentialLevel exists with the primary key " +
                    confidentialLevelId);
            }

            return remove(pmlEdmConfidentialLevel);
        } catch (NoSuchPmlEdmConfidentialLevelException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmConfidentialLevel remove(
        PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmConfidentialLevel);
            }
        }

        pmlEdmConfidentialLevel = removeImpl(pmlEdmConfidentialLevel);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmConfidentialLevel);
            }
        }

        return pmlEdmConfidentialLevel;
    }

    protected PmlEdmConfidentialLevel removeImpl(
        PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmConfidentialLevel);

            session.flush();

            return pmlEdmConfidentialLevel;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmConfidentialLevel.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmConfidentialLevel pmlEdmConfidentialLevel, boolean merge)</code>.
     */
    public PmlEdmConfidentialLevel update(
        PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmConfidentialLevel pmlEdmConfidentialLevel) method. Use update(PmlEdmConfidentialLevel pmlEdmConfidentialLevel, boolean merge) instead.");
        }

        return update(pmlEdmConfidentialLevel, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmConfidentialLevel the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmConfidentialLevel is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmConfidentialLevel update(
        PmlEdmConfidentialLevel pmlEdmConfidentialLevel, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmConfidentialLevel.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmConfidentialLevel);
                } else {
                    listener.onBeforeUpdate(pmlEdmConfidentialLevel);
                }
            }
        }

        pmlEdmConfidentialLevel = updateImpl(pmlEdmConfidentialLevel, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmConfidentialLevel);
                } else {
                    listener.onAfterUpdate(pmlEdmConfidentialLevel);
                }
            }
        }

        return pmlEdmConfidentialLevel;
    }

    public PmlEdmConfidentialLevel updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmConfidentialLevel);
            } else {
                if (pmlEdmConfidentialLevel.isNew()) {
                    session.save(pmlEdmConfidentialLevel);
                }
            }

            session.flush();

            pmlEdmConfidentialLevel.setNew(false);

            return pmlEdmConfidentialLevel;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmConfidentialLevel.class.getName());
        }
    }

    public PmlEdmConfidentialLevel findByPrimaryKey(String confidentialLevelId)
        throws NoSuchPmlEdmConfidentialLevelException, SystemException {
        PmlEdmConfidentialLevel pmlEdmConfidentialLevel = fetchByPrimaryKey(confidentialLevelId);

        if (pmlEdmConfidentialLevel == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmConfidentialLevel exists with the primary key " +
                    confidentialLevelId);
            }

            throw new NoSuchPmlEdmConfidentialLevelException(
                "No PmlEdmConfidentialLevel exists with the primary key " +
                confidentialLevelId);
        }

        return pmlEdmConfidentialLevel;
    }

    public PmlEdmConfidentialLevel fetchByPrimaryKey(String confidentialLevelId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmConfidentialLevel) session.get(PmlEdmConfidentialLevelImpl.class,
                confidentialLevelId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmConfidentialLevel> findByConfidentialLevelName(
        String confidentialLevelName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmConfidentialLevelModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmConfidentialLevel.class.getName();
        String finderMethodName = "findByConfidentialLevelName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { confidentialLevelName };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel WHERE ");

                if (confidentialLevelName == null) {
                    query.append("confidentiallevelname LIKE null");
                } else {
                    query.append("confidentiallevelname LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("confidentiallevelname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (confidentialLevelName != null) {
                    qPos.add(confidentialLevelName);
                }

                List<PmlEdmConfidentialLevel> list = q.list();

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
            return (List<PmlEdmConfidentialLevel>) result;
        }
    }

    public List<PmlEdmConfidentialLevel> findByConfidentialLevelName(
        String confidentialLevelName, int start, int end)
        throws SystemException {
        return findByConfidentialLevelName(confidentialLevelName, start, end,
            null);
    }

    public List<PmlEdmConfidentialLevel> findByConfidentialLevelName(
        String confidentialLevelName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmConfidentialLevelModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmConfidentialLevel.class.getName();
        String finderMethodName = "findByConfidentialLevelName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                confidentialLevelName,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel WHERE ");

                if (confidentialLevelName == null) {
                    query.append("confidentiallevelname LIKE null");
                } else {
                    query.append("confidentiallevelname LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("confidentiallevelname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (confidentialLevelName != null) {
                    qPos.add(confidentialLevelName);
                }

                List<PmlEdmConfidentialLevel> list = (List<PmlEdmConfidentialLevel>) QueryUtil.list(q,
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
            return (List<PmlEdmConfidentialLevel>) result;
        }
    }

    public PmlEdmConfidentialLevel findByConfidentialLevelName_First(
        String confidentialLevelName, OrderByComparator obc)
        throws NoSuchPmlEdmConfidentialLevelException, SystemException {
        List<PmlEdmConfidentialLevel> list = findByConfidentialLevelName(confidentialLevelName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmConfidentialLevel exists with the key {");

            msg.append("confidentialLevelName=" + confidentialLevelName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmConfidentialLevelException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmConfidentialLevel findByConfidentialLevelName_Last(
        String confidentialLevelName, OrderByComparator obc)
        throws NoSuchPmlEdmConfidentialLevelException, SystemException {
        int count = countByConfidentialLevelName(confidentialLevelName);

        List<PmlEdmConfidentialLevel> list = findByConfidentialLevelName(confidentialLevelName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmConfidentialLevel exists with the key {");

            msg.append("confidentialLevelName=" + confidentialLevelName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmConfidentialLevelException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmConfidentialLevel[] findByConfidentialLevelName_PrevAndNext(
        String confidentialLevelId, String confidentialLevelName,
        OrderByComparator obc)
        throws NoSuchPmlEdmConfidentialLevelException, SystemException {
        PmlEdmConfidentialLevel pmlEdmConfidentialLevel = findByPrimaryKey(confidentialLevelId);

        int count = countByConfidentialLevelName(confidentialLevelName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel WHERE ");

            if (confidentialLevelName == null) {
                query.append("confidentiallevelname LIKE null");
            } else {
                query.append("confidentiallevelname LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("confidentiallevelname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (confidentialLevelName != null) {
                qPos.add(confidentialLevelName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmConfidentialLevel);

            PmlEdmConfidentialLevel[] array = new PmlEdmConfidentialLevelImpl[3];

            array[0] = (PmlEdmConfidentialLevel) objArray[0];
            array[1] = (PmlEdmConfidentialLevel) objArray[1];
            array[2] = (PmlEdmConfidentialLevel) objArray[2];

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

    public List<PmlEdmConfidentialLevel> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmConfidentialLevel> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmConfidentialLevel> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmConfidentialLevelModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmConfidentialLevel.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("confidentiallevelname ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmConfidentialLevel> list = (List<PmlEdmConfidentialLevel>) QueryUtil.list(q,
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
            return (List<PmlEdmConfidentialLevel>) result;
        }
    }

    public void removeByConfidentialLevelName(String confidentialLevelName)
        throws SystemException {
        for (PmlEdmConfidentialLevel pmlEdmConfidentialLevel : findByConfidentialLevelName(
                confidentialLevelName)) {
            remove(pmlEdmConfidentialLevel);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmConfidentialLevel pmlEdmConfidentialLevel : findAll()) {
            remove(pmlEdmConfidentialLevel);
        }
    }

    public int countByConfidentialLevelName(String confidentialLevelName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmConfidentialLevelModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmConfidentialLevel.class.getName();
        String finderMethodName = "countByConfidentialLevelName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { confidentialLevelName };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel WHERE ");

                if (confidentialLevelName == null) {
                    query.append("confidentiallevelname LIKE null");
                } else {
                    query.append("confidentiallevelname LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (confidentialLevelName != null) {
                    qPos.add(confidentialLevelName);
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
        boolean finderClassNameCacheEnabled = PmlEdmConfidentialLevelModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmConfidentialLevel.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel")));

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
