package com.sgs.portlet.vanbannoibo.service.persistence;

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

import com.sgs.portlet.vanbannoibo.NoSuchFileDinhKemVanBanNoiBoException;
import com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo;
import com.sgs.portlet.vanbannoibo.model.impl.FileDinhKemVanBanNoiBoImpl;
import com.sgs.portlet.vanbannoibo.model.impl.FileDinhKemVanBanNoiBoModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class FileDinhKemVanBanNoiBoPersistenceImpl extends BasePersistenceImpl
    implements FileDinhKemVanBanNoiBoPersistence {
    private static Log _log = LogFactory.getLog(FileDinhKemVanBanNoiBoPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public FileDinhKemVanBanNoiBo create(long fileDinhKemVanBanNoiBoId) {
        FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo = new FileDinhKemVanBanNoiBoImpl();

        fileDinhKemVanBanNoiBo.setNew(true);
        fileDinhKemVanBanNoiBo.setPrimaryKey(fileDinhKemVanBanNoiBoId);

        return fileDinhKemVanBanNoiBo;
    }

    public FileDinhKemVanBanNoiBo remove(long fileDinhKemVanBanNoiBoId)
        throws NoSuchFileDinhKemVanBanNoiBoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo = (FileDinhKemVanBanNoiBo) session.get(FileDinhKemVanBanNoiBoImpl.class,
                    new Long(fileDinhKemVanBanNoiBoId));

            if (fileDinhKemVanBanNoiBo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No FileDinhKemVanBanNoiBo exists with the primary key " +
                        fileDinhKemVanBanNoiBoId);
                }

                throw new NoSuchFileDinhKemVanBanNoiBoException(
                    "No FileDinhKemVanBanNoiBo exists with the primary key " +
                    fileDinhKemVanBanNoiBoId);
            }

            return remove(fileDinhKemVanBanNoiBo);
        } catch (NoSuchFileDinhKemVanBanNoiBoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public FileDinhKemVanBanNoiBo remove(
        FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(fileDinhKemVanBanNoiBo);
            }
        }

        fileDinhKemVanBanNoiBo = removeImpl(fileDinhKemVanBanNoiBo);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(fileDinhKemVanBanNoiBo);
            }
        }

        return fileDinhKemVanBanNoiBo;
    }

    protected FileDinhKemVanBanNoiBo removeImpl(
        FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(fileDinhKemVanBanNoiBo);

            session.flush();

            return fileDinhKemVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(FileDinhKemVanBanNoiBo.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo, boolean merge)</code>.
     */
    public FileDinhKemVanBanNoiBo update(
        FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo) method. Use update(FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo, boolean merge) instead.");
        }

        return update(fileDinhKemVanBanNoiBo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                fileDinhKemVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when fileDinhKemVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public FileDinhKemVanBanNoiBo update(
        FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo, boolean merge)
        throws SystemException {
        boolean isNew = fileDinhKemVanBanNoiBo.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(fileDinhKemVanBanNoiBo);
                } else {
                    listener.onBeforeUpdate(fileDinhKemVanBanNoiBo);
                }
            }
        }

        fileDinhKemVanBanNoiBo = updateImpl(fileDinhKemVanBanNoiBo, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(fileDinhKemVanBanNoiBo);
                } else {
                    listener.onAfterUpdate(fileDinhKemVanBanNoiBo);
                }
            }
        }

        return fileDinhKemVanBanNoiBo;
    }

    public FileDinhKemVanBanNoiBo updateImpl(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(fileDinhKemVanBanNoiBo);
            } else {
                if (fileDinhKemVanBanNoiBo.isNew()) {
                    session.save(fileDinhKemVanBanNoiBo);
                }
            }

            session.flush();

            fileDinhKemVanBanNoiBo.setNew(false);

            return fileDinhKemVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(FileDinhKemVanBanNoiBo.class.getName());
        }
    }

    public FileDinhKemVanBanNoiBo findByPrimaryKey(
        long fileDinhKemVanBanNoiBoId)
        throws NoSuchFileDinhKemVanBanNoiBoException, SystemException {
        FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo = fetchByPrimaryKey(fileDinhKemVanBanNoiBoId);

        if (fileDinhKemVanBanNoiBo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No FileDinhKemVanBanNoiBo exists with the primary key " +
                    fileDinhKemVanBanNoiBoId);
            }

            throw new NoSuchFileDinhKemVanBanNoiBoException(
                "No FileDinhKemVanBanNoiBo exists with the primary key " +
                fileDinhKemVanBanNoiBoId);
        }

        return fileDinhKemVanBanNoiBo;
    }

    public FileDinhKemVanBanNoiBo fetchByPrimaryKey(
        long fileDinhKemVanBanNoiBoId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (FileDinhKemVanBanNoiBo) session.get(FileDinhKemVanBanNoiBoImpl.class,
                new Long(fileDinhKemVanBanNoiBoId));
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

    public List<FileDinhKemVanBanNoiBo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<FileDinhKemVanBanNoiBo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<FileDinhKemVanBanNoiBo> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = FileDinhKemVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = FileDinhKemVanBanNoiBo.class.getName();
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
                    "FROM com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<FileDinhKemVanBanNoiBo> list = (List<FileDinhKemVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<FileDinhKemVanBanNoiBo>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo : findAll()) {
            remove(fileDinhKemVanBanNoiBo);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = FileDinhKemVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = FileDinhKemVanBanNoiBo.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo");

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
                        "value.object.listener.com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo")));

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
