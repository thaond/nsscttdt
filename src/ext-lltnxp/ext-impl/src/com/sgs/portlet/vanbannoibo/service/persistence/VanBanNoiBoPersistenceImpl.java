package com.sgs.portlet.vanbannoibo.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.vanbannoibo.NoSuchException;
import com.sgs.portlet.vanbannoibo.model.VanBanNoiBo;
import com.sgs.portlet.vanbannoibo.model.impl.VanBanNoiBoImpl;
import com.sgs.portlet.vanbannoibo.model.impl.VanBanNoiBoModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class VanBanNoiBoPersistenceImpl extends BasePersistenceImpl
    implements VanBanNoiBoPersistence {
    private static final String _SQL_GETFILEDINHKEMVANBANNOIBOS = "SELECT {pml_edm_file_dinh_kem_vanbannoibo.*} FROM pml_edm_file_dinh_kem_vanbannoibo INNER JOIN pml_edm_vanbannoibo ON (pml_edm_vanbannoibo.vanBanNoiBoId = pml_edm_file_dinh_kem_vanbannoibo.vanBanNoiBoId) WHERE (pml_edm_vanbannoibo.vanBanNoiBoId = ?)";
    private static final String _SQL_GETFILEDINHKEMVANBANNOIBOSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM pml_edm_file_dinh_kem_vanbannoibo WHERE vanBanNoiBoId = ?";
    private static final String _SQL_CONTAINSFILEDINHKEMVANBANNOIBO = "SELECT COUNT(*) AS COUNT_VALUE FROM pml_edm_file_dinh_kem_vanbannoibo WHERE vanBanNoiBoId = ? AND fileDinhKemVanBanNoiBoId = ?";
    private static Log _log = LogFactory.getLog(VanBanNoiBoPersistenceImpl.class);
    protected ContainsFileDinhKemVanBanNoiBo containsFileDinhKemVanBanNoiBo;
    private ModelListener[] _listeners = new ModelListener[0];

    public VanBanNoiBo create(long vanBanNoiBoId) {
        VanBanNoiBo vanBanNoiBo = new VanBanNoiBoImpl();

        vanBanNoiBo.setNew(true);
        vanBanNoiBo.setPrimaryKey(vanBanNoiBoId);

        return vanBanNoiBo;
    }

    public VanBanNoiBo remove(long vanBanNoiBoId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            VanBanNoiBo vanBanNoiBo = (VanBanNoiBo) session.get(VanBanNoiBoImpl.class,
                    new Long(vanBanNoiBoId));

            if (vanBanNoiBo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No VanBanNoiBo exists with the primary key " +
                        vanBanNoiBoId);
                }

                throw new NoSuchException(
                    "No VanBanNoiBo exists with the primary key " +
                    vanBanNoiBoId);
            }

            return remove(vanBanNoiBo);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public VanBanNoiBo remove(VanBanNoiBo vanBanNoiBo)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(vanBanNoiBo);
            }
        }

        vanBanNoiBo = removeImpl(vanBanNoiBo);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(vanBanNoiBo);
            }
        }

        return vanBanNoiBo;
    }

    protected VanBanNoiBo removeImpl(VanBanNoiBo vanBanNoiBo)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(vanBanNoiBo);

            session.flush();

            return vanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(VanBanNoiBo.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(VanBanNoiBo vanBanNoiBo, boolean merge)</code>.
     */
    public VanBanNoiBo update(VanBanNoiBo vanBanNoiBo)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(VanBanNoiBo vanBanNoiBo) method. Use update(VanBanNoiBo vanBanNoiBo, boolean merge) instead.");
        }

        return update(vanBanNoiBo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                vanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when vanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public VanBanNoiBo update(VanBanNoiBo vanBanNoiBo, boolean merge)
        throws SystemException {
        boolean isNew = vanBanNoiBo.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(vanBanNoiBo);
                } else {
                    listener.onBeforeUpdate(vanBanNoiBo);
                }
            }
        }

        vanBanNoiBo = updateImpl(vanBanNoiBo, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(vanBanNoiBo);
                } else {
                    listener.onAfterUpdate(vanBanNoiBo);
                }
            }
        }

        return vanBanNoiBo;
    }

    public VanBanNoiBo updateImpl(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(vanBanNoiBo);
            } else {
                if (vanBanNoiBo.isNew()) {
                    session.save(vanBanNoiBo);
                }
            }

            session.flush();

            vanBanNoiBo.setNew(false);

            return vanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(VanBanNoiBo.class.getName());
        }
    }

    public VanBanNoiBo findByPrimaryKey(long vanBanNoiBoId)
        throws NoSuchException, SystemException {
        VanBanNoiBo vanBanNoiBo = fetchByPrimaryKey(vanBanNoiBoId);

        if (vanBanNoiBo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No VanBanNoiBo exists with the primary key " +
                    vanBanNoiBoId);
            }

            throw new NoSuchException(
                "No VanBanNoiBo exists with the primary key " + vanBanNoiBoId);
        }

        return vanBanNoiBo;
    }

    public VanBanNoiBo fetchByPrimaryKey(long vanBanNoiBoId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (VanBanNoiBo) session.get(VanBanNoiBoImpl.class,
                new Long(vanBanNoiBoId));
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

    public List<VanBanNoiBo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<VanBanNoiBo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<VanBanNoiBo> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = VanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = VanBanNoiBo.class.getName();
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
                    "FROM com.sgs.portlet.vanbannoibo.model.VanBanNoiBo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<VanBanNoiBo> list = (List<VanBanNoiBo>) QueryUtil.list(q,
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
            return (List<VanBanNoiBo>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (VanBanNoiBo vanBanNoiBo : findAll()) {
            remove(vanBanNoiBo);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = VanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = VanBanNoiBo.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.vanbannoibo.model.VanBanNoiBo");

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

    public List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        long pk) throws SystemException {
        return getFileDinhKemVanBanNoiBos(pk, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS);
    }

    public List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        long pk, int start, int end) throws SystemException {
        return getFileDinhKemVanBanNoiBos(pk, start, end, null);
    }

    public List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        long pk, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.vanbannoibo.model.impl.FileDinhKemVanBanNoiBoModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo.class.getName();

        String finderMethodName = "getFileDinhKemVanBanNoiBos";
        String[] finderParams = new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(pk), String.valueOf(start), String.valueOf(end),
                String.valueOf(obc)
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

                StringBuilder sb = new StringBuilder();

                sb.append(_SQL_GETFILEDINHKEMVANBANNOIBOS);

                if (obc != null) {
                    sb.append("ORDER BY ");
                    sb.append(obc.getOrderBy());
                }

                String sql = sb.toString();

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("pml_edm_file_dinh_kem_vanbannoibo",
                    com.sgs.portlet.vanbannoibo.model.impl.FileDinhKemVanBanNoiBoImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> list =
                    (List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo>) result;
        }
    }

    public int getFileDinhKemVanBanNoiBosSize(long pk)
        throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.vanbannoibo.model.impl.FileDinhKemVanBanNoiBoModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo.class.getName();

        String finderMethodName = "getFileDinhKemVanBanNoiBosSize";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(pk) };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETFILEDINHKEMVANBANNOIBOSSIZE);

                q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

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

    public boolean containsFileDinhKemVanBanNoiBo(long pk,
        long fileDinhKemVanBanNoiBoPK) throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.vanbannoibo.model.impl.FileDinhKemVanBanNoiBoModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo.class.getName();

        String finderMethodName = "containsFileDinhKemVanBanNoiBos";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(pk),
                
                new Long(fileDinhKemVanBanNoiBoPK)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            try {
                Boolean value = Boolean.valueOf(containsFileDinhKemVanBanNoiBo.contains(
                            pk, fileDinhKemVanBanNoiBoPK));

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, value);

                return value.booleanValue();
            } catch (Exception e) {
                throw processException(e);
            }
        } else {
            return ((Boolean) result).booleanValue();
        }
    }

    public boolean containsFileDinhKemVanBanNoiBos(long pk)
        throws SystemException {
        if (getFileDinhKemVanBanNoiBosSize(pk) > 0) {
            return true;
        } else {
            return false;
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
                        "value.object.listener.com.sgs.portlet.vanbannoibo.model.VanBanNoiBo")));

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

        containsFileDinhKemVanBanNoiBo = new ContainsFileDinhKemVanBanNoiBo(this);
    }

    protected class ContainsFileDinhKemVanBanNoiBo {
        private MappingSqlQuery _mappingSqlQuery;

        protected ContainsFileDinhKemVanBanNoiBo(
            VanBanNoiBoPersistenceImpl persistenceImpl) {
            super();

            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSFILEDINHKEMVANBANNOIBO,
                    new int[] { Types.BIGINT, Types.BIGINT }, RowMapper.COUNT);
        }

        protected boolean contains(long vanBanNoiBoId,
            long fileDinhKemVanBanNoiBoId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(vanBanNoiBoId),
                        new Long(fileDinhKemVanBanNoiBoId)
                    });

            if (results.size() > 0) {
                Integer count = results.get(0);

                if (count.intValue() > 0) {
                    return true;
                }
            }

            return false;
        }
    }
}
