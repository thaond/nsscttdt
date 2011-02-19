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

import com.sgs.portlet.loaivanbannoibo.NoSuchLoaiPhongVanBanNoiBoException;
import com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo;
import com.sgs.portlet.loaivanbannoibo.model.impl.LoaiPhongVanBanNoiBoImpl;
import com.sgs.portlet.loaivanbannoibo.model.impl.LoaiPhongVanBanNoiBoModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class LoaiPhongVanBanNoiBoPersistenceImpl extends BasePersistenceImpl
    implements LoaiPhongVanBanNoiBoPersistence {
    private static Log _log = LogFactory.getLog(LoaiPhongVanBanNoiBoPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public LoaiPhongVanBanNoiBo create(
        LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK) {
        LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo = new LoaiPhongVanBanNoiBoImpl();

        loaiPhongVanBanNoiBo.setNew(true);
        loaiPhongVanBanNoiBo.setPrimaryKey(loaiPhongVanBanNoiBoPK);

        return loaiPhongVanBanNoiBo;
    }

    public LoaiPhongVanBanNoiBo remove(
        LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws NoSuchLoaiPhongVanBanNoiBoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo = (LoaiPhongVanBanNoiBo) session.get(LoaiPhongVanBanNoiBoImpl.class,
                    loaiPhongVanBanNoiBoPK);

            if (loaiPhongVanBanNoiBo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No LoaiPhongVanBanNoiBo exists with the primary key " +
                        loaiPhongVanBanNoiBoPK);
                }

                throw new NoSuchLoaiPhongVanBanNoiBoException(
                    "No LoaiPhongVanBanNoiBo exists with the primary key " +
                    loaiPhongVanBanNoiBoPK);
            }

            return remove(loaiPhongVanBanNoiBo);
        } catch (NoSuchLoaiPhongVanBanNoiBoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public LoaiPhongVanBanNoiBo remove(
        LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(loaiPhongVanBanNoiBo);
            }
        }

        loaiPhongVanBanNoiBo = removeImpl(loaiPhongVanBanNoiBo);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(loaiPhongVanBanNoiBo);
            }
        }

        return loaiPhongVanBanNoiBo;
    }

    protected LoaiPhongVanBanNoiBo removeImpl(
        LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(loaiPhongVanBanNoiBo);

            session.flush();

            return loaiPhongVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(LoaiPhongVanBanNoiBo.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo, boolean merge)</code>.
     */
    public LoaiPhongVanBanNoiBo update(
        LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo) method. Use update(LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo, boolean merge) instead.");
        }

        return update(loaiPhongVanBanNoiBo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiPhongVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiPhongVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public LoaiPhongVanBanNoiBo update(
        LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo, boolean merge)
        throws SystemException {
        boolean isNew = loaiPhongVanBanNoiBo.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(loaiPhongVanBanNoiBo);
                } else {
                    listener.onBeforeUpdate(loaiPhongVanBanNoiBo);
                }
            }
        }

        loaiPhongVanBanNoiBo = updateImpl(loaiPhongVanBanNoiBo, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(loaiPhongVanBanNoiBo);
                } else {
                    listener.onAfterUpdate(loaiPhongVanBanNoiBo);
                }
            }
        }

        return loaiPhongVanBanNoiBo;
    }

    public LoaiPhongVanBanNoiBo updateImpl(
        com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(loaiPhongVanBanNoiBo);
            } else {
                if (loaiPhongVanBanNoiBo.isNew()) {
                    session.save(loaiPhongVanBanNoiBo);
                }
            }

            session.flush();

            loaiPhongVanBanNoiBo.setNew(false);

            return loaiPhongVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(LoaiPhongVanBanNoiBo.class.getName());
        }
    }

    public LoaiPhongVanBanNoiBo findByPrimaryKey(
        LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws NoSuchLoaiPhongVanBanNoiBoException, SystemException {
        LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo = fetchByPrimaryKey(loaiPhongVanBanNoiBoPK);

        if (loaiPhongVanBanNoiBo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No LoaiPhongVanBanNoiBo exists with the primary key " +
                    loaiPhongVanBanNoiBoPK);
            }

            throw new NoSuchLoaiPhongVanBanNoiBoException(
                "No LoaiPhongVanBanNoiBo exists with the primary key " +
                loaiPhongVanBanNoiBoPK);
        }

        return loaiPhongVanBanNoiBo;
    }

    public LoaiPhongVanBanNoiBo fetchByPrimaryKey(
        LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (LoaiPhongVanBanNoiBo) session.get(LoaiPhongVanBanNoiBoImpl.class,
                loaiPhongVanBanNoiBoPK);
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

    public List<LoaiPhongVanBanNoiBo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<LoaiPhongVanBanNoiBo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<LoaiPhongVanBanNoiBo> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = LoaiPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = LoaiPhongVanBanNoiBo.class.getName();
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
                    "FROM com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<LoaiPhongVanBanNoiBo> list = (List<LoaiPhongVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<LoaiPhongVanBanNoiBo>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo : findAll()) {
            remove(loaiPhongVanBanNoiBo);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = LoaiPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = LoaiPhongVanBanNoiBo.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo");

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
                        "value.object.listener.com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo")));

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
