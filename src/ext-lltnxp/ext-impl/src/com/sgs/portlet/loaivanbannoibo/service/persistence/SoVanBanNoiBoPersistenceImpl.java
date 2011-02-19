package com.sgs.portlet.loaivanbannoibo.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.loaivanbannoibo.NoSuchSoVanBanNoiBoException;
import com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo;
import com.sgs.portlet.loaivanbannoibo.model.impl.SoVanBanNoiBoImpl;
import com.sgs.portlet.loaivanbannoibo.model.impl.SoVanBanNoiBoModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class SoVanBanNoiBoPersistenceImpl extends BasePersistenceImpl
    implements SoVanBanNoiBoPersistence {
    private static Log _log = LogFactory.getLog(SoVanBanNoiBoPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public SoVanBanNoiBo create(long soVanBanNoiBoId) {
        SoVanBanNoiBo soVanBanNoiBo = new SoVanBanNoiBoImpl();

        soVanBanNoiBo.setNew(true);
        soVanBanNoiBo.setPrimaryKey(soVanBanNoiBoId);

        return soVanBanNoiBo;
    }

    public SoVanBanNoiBo remove(long soVanBanNoiBoId)
        throws NoSuchSoVanBanNoiBoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SoVanBanNoiBo soVanBanNoiBo = (SoVanBanNoiBo) session.get(SoVanBanNoiBoImpl.class,
                    new Long(soVanBanNoiBoId));

            if (soVanBanNoiBo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No SoVanBanNoiBo exists with the primary key " +
                        soVanBanNoiBoId);
                }

                throw new NoSuchSoVanBanNoiBoException(
                    "No SoVanBanNoiBo exists with the primary key " +
                    soVanBanNoiBoId);
            }

            return remove(soVanBanNoiBo);
        } catch (NoSuchSoVanBanNoiBoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public SoVanBanNoiBo remove(SoVanBanNoiBo soVanBanNoiBo)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(soVanBanNoiBo);
            }
        }

        soVanBanNoiBo = removeImpl(soVanBanNoiBo);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(soVanBanNoiBo);
            }
        }

        return soVanBanNoiBo;
    }

    protected SoVanBanNoiBo removeImpl(SoVanBanNoiBo soVanBanNoiBo)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(soVanBanNoiBo);

            session.flush();

            return soVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(SoVanBanNoiBo.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(SoVanBanNoiBo soVanBanNoiBo, boolean merge)</code>.
     */
    public SoVanBanNoiBo update(SoVanBanNoiBo soVanBanNoiBo)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(SoVanBanNoiBo soVanBanNoiBo) method. Use update(SoVanBanNoiBo soVanBanNoiBo, boolean merge) instead.");
        }

        return update(soVanBanNoiBo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                soVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when soVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public SoVanBanNoiBo update(SoVanBanNoiBo soVanBanNoiBo, boolean merge)
        throws SystemException {
        boolean isNew = soVanBanNoiBo.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(soVanBanNoiBo);
                } else {
                    listener.onBeforeUpdate(soVanBanNoiBo);
                }
            }
        }

        soVanBanNoiBo = updateImpl(soVanBanNoiBo, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(soVanBanNoiBo);
                } else {
                    listener.onAfterUpdate(soVanBanNoiBo);
                }
            }
        }

        return soVanBanNoiBo;
    }

    public SoVanBanNoiBo updateImpl(
        com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(soVanBanNoiBo);
            } else {
                if (soVanBanNoiBo.isNew()) {
                    session.save(soVanBanNoiBo);
                }
            }

            session.flush();

            soVanBanNoiBo.setNew(false);

            return soVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(SoVanBanNoiBo.class.getName());
        }
    }

    public SoVanBanNoiBo findByPrimaryKey(long soVanBanNoiBoId)
        throws NoSuchSoVanBanNoiBoException, SystemException {
        SoVanBanNoiBo soVanBanNoiBo = fetchByPrimaryKey(soVanBanNoiBoId);

        if (soVanBanNoiBo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No SoVanBanNoiBo exists with the primary key " +
                    soVanBanNoiBoId);
            }

            throw new NoSuchSoVanBanNoiBoException(
                "No SoVanBanNoiBo exists with the primary key " +
                soVanBanNoiBoId);
        }

        return soVanBanNoiBo;
    }

    public SoVanBanNoiBo fetchByPrimaryKey(long soVanBanNoiBoId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (SoVanBanNoiBo) session.get(SoVanBanNoiBoImpl.class,
                new Long(soVanBanNoiBoId));
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

    public List<SoVanBanNoiBo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<SoVanBanNoiBo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<SoVanBanNoiBo> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SoVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoVanBanNoiBo.class.getName();
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
                    "FROM com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<SoVanBanNoiBo> list = (List<SoVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<SoVanBanNoiBo>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (SoVanBanNoiBo soVanBanNoiBo : findAll()) {
            remove(soVanBanNoiBo);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = SoVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoVanBanNoiBo.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo");

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
                        "value.object.listener.com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo")));

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
