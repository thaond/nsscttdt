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

import com.sgs.portlet.loaivanbannoibo.NoSuchException;
import com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo;
import com.sgs.portlet.loaivanbannoibo.model.impl.LoaiVanBanNoiBoImpl;
import com.sgs.portlet.loaivanbannoibo.model.impl.LoaiVanBanNoiBoModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class LoaiVanBanNoiBoPersistenceImpl extends BasePersistenceImpl
    implements LoaiVanBanNoiBoPersistence {
    private static Log _log = LogFactory.getLog(LoaiVanBanNoiBoPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public LoaiVanBanNoiBo create(long loaiVanBanNoiBoId) {
        LoaiVanBanNoiBo loaiVanBanNoiBo = new LoaiVanBanNoiBoImpl();

        loaiVanBanNoiBo.setNew(true);
        loaiVanBanNoiBo.setPrimaryKey(loaiVanBanNoiBoId);

        return loaiVanBanNoiBo;
    }

    public LoaiVanBanNoiBo remove(long loaiVanBanNoiBoId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LoaiVanBanNoiBo loaiVanBanNoiBo = (LoaiVanBanNoiBo) session.get(LoaiVanBanNoiBoImpl.class,
                    new Long(loaiVanBanNoiBoId));

            if (loaiVanBanNoiBo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No LoaiVanBanNoiBo exists with the primary key " +
                        loaiVanBanNoiBoId);
                }

                throw new NoSuchException(
                    "No LoaiVanBanNoiBo exists with the primary key " +
                    loaiVanBanNoiBoId);
            }

            return remove(loaiVanBanNoiBo);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public LoaiVanBanNoiBo remove(LoaiVanBanNoiBo loaiVanBanNoiBo)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(loaiVanBanNoiBo);
            }
        }

        loaiVanBanNoiBo = removeImpl(loaiVanBanNoiBo);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(loaiVanBanNoiBo);
            }
        }

        return loaiVanBanNoiBo;
    }

    protected LoaiVanBanNoiBo removeImpl(LoaiVanBanNoiBo loaiVanBanNoiBo)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(loaiVanBanNoiBo);

            session.flush();

            return loaiVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(LoaiVanBanNoiBo.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(LoaiVanBanNoiBo loaiVanBanNoiBo, boolean merge)</code>.
     */
    public LoaiVanBanNoiBo update(LoaiVanBanNoiBo loaiVanBanNoiBo)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(LoaiVanBanNoiBo loaiVanBanNoiBo) method. Use update(LoaiVanBanNoiBo loaiVanBanNoiBo, boolean merge) instead.");
        }

        return update(loaiVanBanNoiBo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public LoaiVanBanNoiBo update(LoaiVanBanNoiBo loaiVanBanNoiBo, boolean merge)
        throws SystemException {
        boolean isNew = loaiVanBanNoiBo.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(loaiVanBanNoiBo);
                } else {
                    listener.onBeforeUpdate(loaiVanBanNoiBo);
                }
            }
        }

        loaiVanBanNoiBo = updateImpl(loaiVanBanNoiBo, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(loaiVanBanNoiBo);
                } else {
                    listener.onAfterUpdate(loaiVanBanNoiBo);
                }
            }
        }

        return loaiVanBanNoiBo;
    }

    public LoaiVanBanNoiBo updateImpl(
        com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo loaiVanBanNoiBo,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(loaiVanBanNoiBo);
            } else {
                if (loaiVanBanNoiBo.isNew()) {
                    session.save(loaiVanBanNoiBo);
                }
            }

            session.flush();

            loaiVanBanNoiBo.setNew(false);

            return loaiVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(LoaiVanBanNoiBo.class.getName());
        }
    }

    public LoaiVanBanNoiBo findByPrimaryKey(long loaiVanBanNoiBoId)
        throws NoSuchException, SystemException {
        LoaiVanBanNoiBo loaiVanBanNoiBo = fetchByPrimaryKey(loaiVanBanNoiBoId);

        if (loaiVanBanNoiBo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No LoaiVanBanNoiBo exists with the primary key " +
                    loaiVanBanNoiBoId);
            }

            throw new NoSuchException(
                "No LoaiVanBanNoiBo exists with the primary key " +
                loaiVanBanNoiBoId);
        }

        return loaiVanBanNoiBo;
    }

    public LoaiVanBanNoiBo fetchByPrimaryKey(long loaiVanBanNoiBoId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (LoaiVanBanNoiBo) session.get(LoaiVanBanNoiBoImpl.class,
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

    public List<LoaiVanBanNoiBo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<LoaiVanBanNoiBo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<LoaiVanBanNoiBo> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = LoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = LoaiVanBanNoiBo.class.getName();
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
                    "FROM com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<LoaiVanBanNoiBo> list = (List<LoaiVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<LoaiVanBanNoiBo>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (LoaiVanBanNoiBo loaiVanBanNoiBo : findAll()) {
            remove(loaiVanBanNoiBo);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = LoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = LoaiVanBanNoiBo.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo");

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
                        "value.object.listener.com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo")));

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
