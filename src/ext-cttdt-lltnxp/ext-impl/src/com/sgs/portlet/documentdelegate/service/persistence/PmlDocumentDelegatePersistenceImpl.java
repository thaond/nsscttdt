package com.sgs.portlet.documentdelegate.service.persistence;

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

import com.sgs.portlet.documentdelegate.NoSuchException;
import com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate;
import com.sgs.portlet.documentdelegate.model.impl.PmlDocumentDelegateImpl;
import com.sgs.portlet.documentdelegate.model.impl.PmlDocumentDelegateModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlDocumentDelegatePersistenceImpl extends BasePersistenceImpl
    implements PmlDocumentDelegatePersistence {
    private static Log _log = LogFactory.getLog(PmlDocumentDelegatePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlDocumentDelegate create(long documentDelegateId) {
        PmlDocumentDelegate pmlDocumentDelegate = new PmlDocumentDelegateImpl();

        pmlDocumentDelegate.setNew(true);
        pmlDocumentDelegate.setPrimaryKey(documentDelegateId);

        return pmlDocumentDelegate;
    }

    public PmlDocumentDelegate remove(long documentDelegateId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlDocumentDelegate pmlDocumentDelegate = (PmlDocumentDelegate) session.get(PmlDocumentDelegateImpl.class,
                    new Long(documentDelegateId));

            if (pmlDocumentDelegate == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlDocumentDelegate exists with the primary key " +
                        documentDelegateId);
                }

                throw new NoSuchException(
                    "No PmlDocumentDelegate exists with the primary key " +
                    documentDelegateId);
            }

            return remove(pmlDocumentDelegate);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlDocumentDelegate remove(PmlDocumentDelegate pmlDocumentDelegate)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlDocumentDelegate);
            }
        }

        pmlDocumentDelegate = removeImpl(pmlDocumentDelegate);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlDocumentDelegate);
            }
        }

        return pmlDocumentDelegate;
    }

    protected PmlDocumentDelegate removeImpl(
        PmlDocumentDelegate pmlDocumentDelegate) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlDocumentDelegate);

            session.flush();

            return pmlDocumentDelegate;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDocumentDelegate.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlDocumentDelegate pmlDocumentDelegate, boolean merge)</code>.
     */
    public PmlDocumentDelegate update(PmlDocumentDelegate pmlDocumentDelegate)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlDocumentDelegate pmlDocumentDelegate) method. Use update(PmlDocumentDelegate pmlDocumentDelegate, boolean merge) instead.");
        }

        return update(pmlDocumentDelegate, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentDelegate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentDelegate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlDocumentDelegate update(PmlDocumentDelegate pmlDocumentDelegate,
        boolean merge) throws SystemException {
        boolean isNew = pmlDocumentDelegate.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlDocumentDelegate);
                } else {
                    listener.onBeforeUpdate(pmlDocumentDelegate);
                }
            }
        }

        pmlDocumentDelegate = updateImpl(pmlDocumentDelegate, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlDocumentDelegate);
                } else {
                    listener.onAfterUpdate(pmlDocumentDelegate);
                }
            }
        }

        return pmlDocumentDelegate;
    }

    public PmlDocumentDelegate updateImpl(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlDocumentDelegate);
            } else {
                if (pmlDocumentDelegate.isNew()) {
                    session.save(pmlDocumentDelegate);
                }
            }

            session.flush();

            pmlDocumentDelegate.setNew(false);

            return pmlDocumentDelegate;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDocumentDelegate.class.getName());
        }
    }

    public PmlDocumentDelegate findByPrimaryKey(long documentDelegateId)
        throws NoSuchException, SystemException {
        PmlDocumentDelegate pmlDocumentDelegate = fetchByPrimaryKey(documentDelegateId);

        if (pmlDocumentDelegate == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlDocumentDelegate exists with the primary key " +
                    documentDelegateId);
            }

            throw new NoSuchException(
                "No PmlDocumentDelegate exists with the primary key " +
                documentDelegateId);
        }

        return pmlDocumentDelegate;
    }

    public PmlDocumentDelegate fetchByPrimaryKey(long documentDelegateId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlDocumentDelegate) session.get(PmlDocumentDelegateImpl.class,
                new Long(documentDelegateId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentDelegate> findByUserIsDelegateId(
        long userIsDelegateId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentDelegate.class.getName();
        String finderMethodName = "findByUserIsDelegateId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(userIsDelegateId) };

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
                    "FROM com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate WHERE ");

                query.append("userIsDelegateId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userIsDelegateId);

                List<PmlDocumentDelegate> list = q.list();

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
            return (List<PmlDocumentDelegate>) result;
        }
    }

    public List<PmlDocumentDelegate> findByUserIsDelegateId(
        long userIsDelegateId, int start, int end) throws SystemException {
        return findByUserIsDelegateId(userIsDelegateId, start, end, null);
    }

    public List<PmlDocumentDelegate> findByUserIsDelegateId(
        long userIsDelegateId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentDelegate.class.getName();
        String finderMethodName = "findByUserIsDelegateId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(userIsDelegateId),
                
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
                    "FROM com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate WHERE ");

                query.append("userIsDelegateId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userIsDelegateId);

                List<PmlDocumentDelegate> list = (List<PmlDocumentDelegate>) QueryUtil.list(q,
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
            return (List<PmlDocumentDelegate>) result;
        }
    }

    public PmlDocumentDelegate findByUserIsDelegateId_First(
        long userIsDelegateId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<PmlDocumentDelegate> list = findByUserIsDelegateId(userIsDelegateId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentDelegate exists with the key {");

            msg.append("userIsDelegateId=" + userIsDelegateId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentDelegate findByUserIsDelegateId_Last(
        long userIsDelegateId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByUserIsDelegateId(userIsDelegateId);

        List<PmlDocumentDelegate> list = findByUserIsDelegateId(userIsDelegateId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentDelegate exists with the key {");

            msg.append("userIsDelegateId=" + userIsDelegateId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentDelegate[] findByUserIsDelegateId_PrevAndNext(
        long documentDelegateId, long userIsDelegateId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlDocumentDelegate pmlDocumentDelegate = findByPrimaryKey(documentDelegateId);

        int count = countByUserIsDelegateId(userIsDelegateId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate WHERE ");

            query.append("userIsDelegateId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userIsDelegateId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentDelegate);

            PmlDocumentDelegate[] array = new PmlDocumentDelegateImpl[3];

            array[0] = (PmlDocumentDelegate) objArray[0];
            array[1] = (PmlDocumentDelegate) objArray[1];
            array[2] = (PmlDocumentDelegate) objArray[2];

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

    public List<PmlDocumentDelegate> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlDocumentDelegate> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlDocumentDelegate> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentDelegate.class.getName();
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
                    "FROM com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlDocumentDelegate> list = (List<PmlDocumentDelegate>) QueryUtil.list(q,
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
            return (List<PmlDocumentDelegate>) result;
        }
    }

    public void removeByUserIsDelegateId(long userIsDelegateId)
        throws SystemException {
        for (PmlDocumentDelegate pmlDocumentDelegate : findByUserIsDelegateId(
                userIsDelegateId)) {
            remove(pmlDocumentDelegate);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlDocumentDelegate pmlDocumentDelegate : findAll()) {
            remove(pmlDocumentDelegate);
        }
    }

    public int countByUserIsDelegateId(long userIsDelegateId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentDelegate.class.getName();
        String finderMethodName = "countByUserIsDelegateId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(userIsDelegateId) };

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
                    "FROM com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate WHERE ");

                query.append("userIsDelegateId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userIsDelegateId);

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
        boolean finderClassNameCacheEnabled = PmlDocumentDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentDelegate.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate");

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
                        "value.object.listener.com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate")));

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
