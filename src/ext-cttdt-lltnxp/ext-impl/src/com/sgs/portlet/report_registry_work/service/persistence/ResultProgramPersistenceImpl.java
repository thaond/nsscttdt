package com.sgs.portlet.report_registry_work.service.persistence;

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

import com.sgs.portlet.report_registry_work.NoSuchResultProgramException;
import com.sgs.portlet.report_registry_work.model.ResultProgram;
import com.sgs.portlet.report_registry_work.model.impl.ResultProgramImpl;
import com.sgs.portlet.report_registry_work.model.impl.ResultProgramModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class ResultProgramPersistenceImpl extends BasePersistenceImpl
    implements ResultProgramPersistence {
    private static Log _log = LogFactory.getLog(ResultProgramPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public ResultProgram create(long resultProgramId) {
        ResultProgram resultProgram = new ResultProgramImpl();

        resultProgram.setNew(true);
        resultProgram.setPrimaryKey(resultProgramId);

        return resultProgram;
    }

    public ResultProgram remove(long resultProgramId)
        throws NoSuchResultProgramException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ResultProgram resultProgram = (ResultProgram) session.get(ResultProgramImpl.class,
                    new Long(resultProgramId));

            if (resultProgram == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No ResultProgram exists with the primary key " +
                        resultProgramId);
                }

                throw new NoSuchResultProgramException(
                    "No ResultProgram exists with the primary key " +
                    resultProgramId);
            }

            return remove(resultProgram);
        } catch (NoSuchResultProgramException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public ResultProgram remove(ResultProgram resultProgram)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(resultProgram);
            }
        }

        resultProgram = removeImpl(resultProgram);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(resultProgram);
            }
        }

        return resultProgram;
    }

    protected ResultProgram removeImpl(ResultProgram resultProgram)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(resultProgram);

            session.flush();

            return resultProgram;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(ResultProgram.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(ResultProgram resultProgram, boolean merge)</code>.
     */
    public ResultProgram update(ResultProgram resultProgram)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(ResultProgram resultProgram) method. Use update(ResultProgram resultProgram, boolean merge) instead.");
        }

        return update(resultProgram, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                resultProgram the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when resultProgram is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public ResultProgram update(ResultProgram resultProgram, boolean merge)
        throws SystemException {
        boolean isNew = resultProgram.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(resultProgram);
                } else {
                    listener.onBeforeUpdate(resultProgram);
                }
            }
        }

        resultProgram = updateImpl(resultProgram, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(resultProgram);
                } else {
                    listener.onAfterUpdate(resultProgram);
                }
            }
        }

        return resultProgram;
    }

    public ResultProgram updateImpl(
        com.sgs.portlet.report_registry_work.model.ResultProgram resultProgram,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(resultProgram);
            } else {
                if (resultProgram.isNew()) {
                    session.save(resultProgram);
                }
            }

            session.flush();

            resultProgram.setNew(false);

            return resultProgram;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(ResultProgram.class.getName());
        }
    }

    public ResultProgram findByPrimaryKey(long resultProgramId)
        throws NoSuchResultProgramException, SystemException {
        ResultProgram resultProgram = fetchByPrimaryKey(resultProgramId);

        if (resultProgram == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No ResultProgram exists with the primary key " +
                    resultProgramId);
            }

            throw new NoSuchResultProgramException(
                "No ResultProgram exists with the primary key " +
                resultProgramId);
        }

        return resultProgram;
    }

    public ResultProgram fetchByPrimaryKey(long resultProgramId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (ResultProgram) session.get(ResultProgramImpl.class,
                new Long(resultProgramId));
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

    public List<ResultProgram> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<ResultProgram> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<ResultProgram> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ResultProgramModelImpl.CACHE_ENABLED;
        String finderClassName = ResultProgram.class.getName();
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
                    "FROM com.sgs.portlet.report_registry_work.model.ResultProgram ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<ResultProgram> list = (List<ResultProgram>) QueryUtil.list(q,
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
            return (List<ResultProgram>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (ResultProgram resultProgram : findAll()) {
            remove(resultProgram);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = ResultProgramModelImpl.CACHE_ENABLED;
        String finderClassName = ResultProgram.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.report_registry_work.model.ResultProgram");

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
                        "value.object.listener.com.sgs.portlet.report_registry_work.model.ResultProgram")));

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
