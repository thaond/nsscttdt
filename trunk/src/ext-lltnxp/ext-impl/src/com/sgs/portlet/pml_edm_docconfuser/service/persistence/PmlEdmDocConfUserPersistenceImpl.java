package com.sgs.portlet.pml_edm_docconfuser.service.persistence;

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

import com.sgs.portlet.pml_edm_docconfuser.NoSuchDocConfUserException;
import com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser;
import com.sgs.portlet.pml_edm_docconfuser.model.impl.PmlEdmDocConfUserImpl;
import com.sgs.portlet.pml_edm_docconfuser.model.impl.PmlEdmDocConfUserModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmDocConfUserPersistenceImpl extends BasePersistenceImpl
    implements PmlEdmDocConfUserPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmDocConfUserPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmDocConfUser create(long dcuId) {
        PmlEdmDocConfUser pmlEdmDocConfUser = new PmlEdmDocConfUserImpl();

        pmlEdmDocConfUser.setNew(true);
        pmlEdmDocConfUser.setPrimaryKey(dcuId);

        return pmlEdmDocConfUser;
    }

    public PmlEdmDocConfUser remove(long dcuId)
        throws NoSuchDocConfUserException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmDocConfUser pmlEdmDocConfUser = (PmlEdmDocConfUser) session.get(PmlEdmDocConfUserImpl.class,
                    new Long(dcuId));

            if (pmlEdmDocConfUser == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmDocConfUser exists with the primary key " +
                        dcuId);
                }

                throw new NoSuchDocConfUserException(
                    "No PmlEdmDocConfUser exists with the primary key " +
                    dcuId);
            }

            return remove(pmlEdmDocConfUser);
        } catch (NoSuchDocConfUserException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocConfUser remove(PmlEdmDocConfUser pmlEdmDocConfUser)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmDocConfUser);
            }
        }

        pmlEdmDocConfUser = removeImpl(pmlEdmDocConfUser);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmDocConfUser);
            }
        }

        return pmlEdmDocConfUser;
    }

    protected PmlEdmDocConfUser removeImpl(PmlEdmDocConfUser pmlEdmDocConfUser)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmDocConfUser);

            session.flush();

            return pmlEdmDocConfUser;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocConfUser.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocConfUser pmlEdmDocConfUser, boolean merge)</code>.
     */
    public PmlEdmDocConfUser update(PmlEdmDocConfUser pmlEdmDocConfUser)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmDocConfUser pmlEdmDocConfUser) method. Use update(PmlEdmDocConfUser pmlEdmDocConfUser, boolean merge) instead.");
        }

        return update(pmlEdmDocConfUser, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocConfUser the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocConfUser is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmDocConfUser update(PmlEdmDocConfUser pmlEdmDocConfUser,
        boolean merge) throws SystemException {
        boolean isNew = pmlEdmDocConfUser.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmDocConfUser);
                } else {
                    listener.onBeforeUpdate(pmlEdmDocConfUser);
                }
            }
        }

        pmlEdmDocConfUser = updateImpl(pmlEdmDocConfUser, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmDocConfUser);
                } else {
                    listener.onAfterUpdate(pmlEdmDocConfUser);
                }
            }
        }

        return pmlEdmDocConfUser;
    }

    public PmlEdmDocConfUser updateImpl(
        com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser pmlEdmDocConfUser,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmDocConfUser);
            } else {
                if (pmlEdmDocConfUser.isNew()) {
                    session.save(pmlEdmDocConfUser);
                }
            }

            session.flush();

            pmlEdmDocConfUser.setNew(false);

            return pmlEdmDocConfUser;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocConfUser.class.getName());
        }
    }

    public PmlEdmDocConfUser findByPrimaryKey(long dcuId)
        throws NoSuchDocConfUserException, SystemException {
        PmlEdmDocConfUser pmlEdmDocConfUser = fetchByPrimaryKey(dcuId);

        if (pmlEdmDocConfUser == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlEdmDocConfUser exists with the primary key " +
                    dcuId);
            }

            throw new NoSuchDocConfUserException(
                "No PmlEdmDocConfUser exists with the primary key " + dcuId);
        }

        return pmlEdmDocConfUser;
    }

    public PmlEdmDocConfUser fetchByPrimaryKey(long dcuId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmDocConfUser) session.get(PmlEdmDocConfUserImpl.class,
                new Long(dcuId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocConfUser findByUserId(long userId)
        throws NoSuchDocConfUserException, SystemException {
        PmlEdmDocConfUser pmlEdmDocConfUser = fetchByUserId(userId);

        if (pmlEdmDocConfUser == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocConfUser exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchDocConfUserException(msg.toString());
        }

        return pmlEdmDocConfUser;
    }

    public PmlEdmDocConfUser fetchByUserId(long userId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocConfUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocConfUser.class.getName();
        String finderMethodName = "fetchByUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(userId) };

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
                    "FROM com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser WHERE ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<PmlEdmDocConfUser> list = q.list();

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
            List<PmlEdmDocConfUser> list = (List<PmlEdmDocConfUser>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
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

    public List<PmlEdmDocConfUser> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmDocConfUser> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmDocConfUser> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocConfUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocConfUser.class.getName();
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
                    "FROM com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmDocConfUser> list = (List<PmlEdmDocConfUser>) QueryUtil.list(q,
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
            return (List<PmlEdmDocConfUser>) result;
        }
    }

    public void removeByUserId(long userId)
        throws NoSuchDocConfUserException, SystemException {
        PmlEdmDocConfUser pmlEdmDocConfUser = findByUserId(userId);

        remove(pmlEdmDocConfUser);
    }

    public void removeAll() throws SystemException {
        for (PmlEdmDocConfUser pmlEdmDocConfUser : findAll()) {
            remove(pmlEdmDocConfUser);
        }
    }

    public int countByUserId(long userId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocConfUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocConfUser.class.getName();
        String finderMethodName = "countByUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(userId) };

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
                    "FROM com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser WHERE ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

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
        boolean finderClassNameCacheEnabled = PmlEdmDocConfUserModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocConfUser.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser");

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
                        "value.object.listener.com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser")));

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
