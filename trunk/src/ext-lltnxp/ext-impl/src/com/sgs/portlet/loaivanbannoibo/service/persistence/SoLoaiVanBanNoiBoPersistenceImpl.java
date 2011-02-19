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

import com.sgs.portlet.loaivanbannoibo.NoSuchSoLoaiVanBanNoiBoException;
import com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo;
import com.sgs.portlet.loaivanbannoibo.model.impl.SoLoaiVanBanNoiBoImpl;
import com.sgs.portlet.loaivanbannoibo.model.impl.SoLoaiVanBanNoiBoModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class SoLoaiVanBanNoiBoPersistenceImpl extends BasePersistenceImpl
    implements SoLoaiVanBanNoiBoPersistence {
    private static Log _log = LogFactory.getLog(SoLoaiVanBanNoiBoPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public SoLoaiVanBanNoiBo create(SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK) {
        SoLoaiVanBanNoiBo soLoaiVanBanNoiBo = new SoLoaiVanBanNoiBoImpl();

        soLoaiVanBanNoiBo.setNew(true);
        soLoaiVanBanNoiBo.setPrimaryKey(soLoaiVanBanNoiBoPK);

        return soLoaiVanBanNoiBo;
    }

    public SoLoaiVanBanNoiBo remove(SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws NoSuchSoLoaiVanBanNoiBoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SoLoaiVanBanNoiBo soLoaiVanBanNoiBo = (SoLoaiVanBanNoiBo) session.get(SoLoaiVanBanNoiBoImpl.class,
                    soLoaiVanBanNoiBoPK);

            if (soLoaiVanBanNoiBo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No SoLoaiVanBanNoiBo exists with the primary key " +
                        soLoaiVanBanNoiBoPK);
                }

                throw new NoSuchSoLoaiVanBanNoiBoException(
                    "No SoLoaiVanBanNoiBo exists with the primary key " +
                    soLoaiVanBanNoiBoPK);
            }

            return remove(soLoaiVanBanNoiBo);
        } catch (NoSuchSoLoaiVanBanNoiBoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public SoLoaiVanBanNoiBo remove(SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(soLoaiVanBanNoiBo);
            }
        }

        soLoaiVanBanNoiBo = removeImpl(soLoaiVanBanNoiBo);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(soLoaiVanBanNoiBo);
            }
        }

        return soLoaiVanBanNoiBo;
    }

    protected SoLoaiVanBanNoiBo removeImpl(SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(soLoaiVanBanNoiBo);

            session.flush();

            return soLoaiVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(SoLoaiVanBanNoiBo.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(SoLoaiVanBanNoiBo soLoaiVanBanNoiBo, boolean merge)</code>.
     */
    public SoLoaiVanBanNoiBo update(SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(SoLoaiVanBanNoiBo soLoaiVanBanNoiBo) method. Use update(SoLoaiVanBanNoiBo soLoaiVanBanNoiBo, boolean merge) instead.");
        }

        return update(soLoaiVanBanNoiBo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                soLoaiVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when soLoaiVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public SoLoaiVanBanNoiBo update(SoLoaiVanBanNoiBo soLoaiVanBanNoiBo,
        boolean merge) throws SystemException {
        boolean isNew = soLoaiVanBanNoiBo.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(soLoaiVanBanNoiBo);
                } else {
                    listener.onBeforeUpdate(soLoaiVanBanNoiBo);
                }
            }
        }

        soLoaiVanBanNoiBo = updateImpl(soLoaiVanBanNoiBo, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(soLoaiVanBanNoiBo);
                } else {
                    listener.onAfterUpdate(soLoaiVanBanNoiBo);
                }
            }
        }

        return soLoaiVanBanNoiBo;
    }

    public SoLoaiVanBanNoiBo updateImpl(
        com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(soLoaiVanBanNoiBo);
            } else {
                if (soLoaiVanBanNoiBo.isNew()) {
                    session.save(soLoaiVanBanNoiBo);
                }
            }

            session.flush();

            soLoaiVanBanNoiBo.setNew(false);

            return soLoaiVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(SoLoaiVanBanNoiBo.class.getName());
        }
    }

    public SoLoaiVanBanNoiBo findByPrimaryKey(
        SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws NoSuchSoLoaiVanBanNoiBoException, SystemException {
        SoLoaiVanBanNoiBo soLoaiVanBanNoiBo = fetchByPrimaryKey(soLoaiVanBanNoiBoPK);

        if (soLoaiVanBanNoiBo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No SoLoaiVanBanNoiBo exists with the primary key " +
                    soLoaiVanBanNoiBoPK);
            }

            throw new NoSuchSoLoaiVanBanNoiBoException(
                "No SoLoaiVanBanNoiBo exists with the primary key " +
                soLoaiVanBanNoiBoPK);
        }

        return soLoaiVanBanNoiBo;
    }

    public SoLoaiVanBanNoiBo fetchByPrimaryKey(
        SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (SoLoaiVanBanNoiBo) session.get(SoLoaiVanBanNoiBoImpl.class,
                soLoaiVanBanNoiBoPK);
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

    public List<SoLoaiVanBanNoiBo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<SoLoaiVanBanNoiBo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<SoLoaiVanBanNoiBo> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = SoLoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoLoaiVanBanNoiBo.class.getName();
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
                    "FROM com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<SoLoaiVanBanNoiBo> list = (List<SoLoaiVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<SoLoaiVanBanNoiBo>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (SoLoaiVanBanNoiBo soLoaiVanBanNoiBo : findAll()) {
            remove(soLoaiVanBanNoiBo);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = SoLoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoLoaiVanBanNoiBo.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo");

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
                        "value.object.listener.com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo")));

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
