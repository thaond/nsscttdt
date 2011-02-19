package com.sgs.portlet.sovanbannoibo.service.persistence;

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

import com.sgs.portlet.sovanbannoibo.NoSuchLoaiVanBanNoiBoCuaSoException;
import com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo;
import com.sgs.portlet.sovanbannoibo.model.impl.LoaiVanBanNoiBoCuaSoImpl;
import com.sgs.portlet.sovanbannoibo.model.impl.LoaiVanBanNoiBoCuaSoModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class LoaiVanBanNoiBoCuaSoPersistenceImpl extends BasePersistenceImpl
    implements LoaiVanBanNoiBoCuaSoPersistence {
    private static Log _log = LogFactory.getLog(LoaiVanBanNoiBoCuaSoPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public LoaiVanBanNoiBoCuaSo create(long loaiVanBanNoiBoId) {
        LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo = new LoaiVanBanNoiBoCuaSoImpl();

        loaiVanBanNoiBoCuaSo.setNew(true);
        loaiVanBanNoiBoCuaSo.setPrimaryKey(loaiVanBanNoiBoId);

        return loaiVanBanNoiBoCuaSo;
    }

    public LoaiVanBanNoiBoCuaSo remove(long loaiVanBanNoiBoId)
        throws NoSuchLoaiVanBanNoiBoCuaSoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo = (LoaiVanBanNoiBoCuaSo) session.get(LoaiVanBanNoiBoCuaSoImpl.class,
                    new Long(loaiVanBanNoiBoId));

            if (loaiVanBanNoiBoCuaSo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No LoaiVanBanNoiBoCuaSo exists with the primary key " +
                        loaiVanBanNoiBoId);
                }

                throw new NoSuchLoaiVanBanNoiBoCuaSoException(
                    "No LoaiVanBanNoiBoCuaSo exists with the primary key " +
                    loaiVanBanNoiBoId);
            }

            return remove(loaiVanBanNoiBoCuaSo);
        } catch (NoSuchLoaiVanBanNoiBoCuaSoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public LoaiVanBanNoiBoCuaSo remove(
        LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(loaiVanBanNoiBoCuaSo);
            }
        }

        loaiVanBanNoiBoCuaSo = removeImpl(loaiVanBanNoiBoCuaSo);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(loaiVanBanNoiBoCuaSo);
            }
        }

        return loaiVanBanNoiBoCuaSo;
    }

    protected LoaiVanBanNoiBoCuaSo removeImpl(
        LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(loaiVanBanNoiBoCuaSo);

            session.flush();

            return loaiVanBanNoiBoCuaSo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(LoaiVanBanNoiBoCuaSo.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo, boolean merge)</code>.
     */
    public LoaiVanBanNoiBoCuaSo update(
        LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo) method. Use update(LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo, boolean merge) instead.");
        }

        return update(loaiVanBanNoiBoCuaSo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiVanBanNoiBoCuaSo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiVanBanNoiBoCuaSo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public LoaiVanBanNoiBoCuaSo update(
        LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo, boolean merge)
        throws SystemException {
        boolean isNew = loaiVanBanNoiBoCuaSo.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(loaiVanBanNoiBoCuaSo);
                } else {
                    listener.onBeforeUpdate(loaiVanBanNoiBoCuaSo);
                }
            }
        }

        loaiVanBanNoiBoCuaSo = updateImpl(loaiVanBanNoiBoCuaSo, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(loaiVanBanNoiBoCuaSo);
                } else {
                    listener.onAfterUpdate(loaiVanBanNoiBoCuaSo);
                }
            }
        }

        return loaiVanBanNoiBoCuaSo;
    }

    public LoaiVanBanNoiBoCuaSo updateImpl(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(loaiVanBanNoiBoCuaSo);
            } else {
                if (loaiVanBanNoiBoCuaSo.isNew()) {
                    session.save(loaiVanBanNoiBoCuaSo);
                }
            }

            session.flush();

            loaiVanBanNoiBoCuaSo.setNew(false);

            return loaiVanBanNoiBoCuaSo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(LoaiVanBanNoiBoCuaSo.class.getName());
        }
    }

    public LoaiVanBanNoiBoCuaSo findByPrimaryKey(long loaiVanBanNoiBoId)
        throws NoSuchLoaiVanBanNoiBoCuaSoException, SystemException {
        LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo = fetchByPrimaryKey(loaiVanBanNoiBoId);

        if (loaiVanBanNoiBoCuaSo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No LoaiVanBanNoiBoCuaSo exists with the primary key " +
                    loaiVanBanNoiBoId);
            }

            throw new NoSuchLoaiVanBanNoiBoCuaSoException(
                "No LoaiVanBanNoiBoCuaSo exists with the primary key " +
                loaiVanBanNoiBoId);
        }

        return loaiVanBanNoiBoCuaSo;
    }

    public LoaiVanBanNoiBoCuaSo fetchByPrimaryKey(long loaiVanBanNoiBoId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (LoaiVanBanNoiBoCuaSo) session.get(LoaiVanBanNoiBoCuaSoImpl.class,
                new Long(loaiVanBanNoiBoId));
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

    public List<LoaiVanBanNoiBoCuaSo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<LoaiVanBanNoiBoCuaSo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<LoaiVanBanNoiBoCuaSo> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = LoaiVanBanNoiBoCuaSoModelImpl.CACHE_ENABLED;
        String finderClassName = LoaiVanBanNoiBoCuaSo.class.getName();
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<LoaiVanBanNoiBoCuaSo> list = (List<LoaiVanBanNoiBoCuaSo>) QueryUtil.list(q,
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
            return (List<LoaiVanBanNoiBoCuaSo>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo : findAll()) {
            remove(loaiVanBanNoiBoCuaSo);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = LoaiVanBanNoiBoCuaSoModelImpl.CACHE_ENABLED;
        String finderClassName = LoaiVanBanNoiBoCuaSo.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo");

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
                        "value.object.listener.com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo")));

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
