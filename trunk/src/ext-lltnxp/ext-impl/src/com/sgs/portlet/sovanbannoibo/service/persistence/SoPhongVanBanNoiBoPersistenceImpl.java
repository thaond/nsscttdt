package com.sgs.portlet.sovanbannoibo.service.persistence;

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

import com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException;
import com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.model.impl.SoPhongVanBanNoiBoImpl;
import com.sgs.portlet.sovanbannoibo.model.impl.SoPhongVanBanNoiBoModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class SoPhongVanBanNoiBoPersistenceImpl extends BasePersistenceImpl
    implements SoPhongVanBanNoiBoPersistence {
    private static Log _log = LogFactory.getLog(SoPhongVanBanNoiBoPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public SoPhongVanBanNoiBo create(SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK) {
        SoPhongVanBanNoiBo soPhongVanBanNoiBo = new SoPhongVanBanNoiBoImpl();

        soPhongVanBanNoiBo.setNew(true);
        soPhongVanBanNoiBo.setPrimaryKey(soPhongVanBanNoiBoPK);

        return soPhongVanBanNoiBo;
    }

    public SoPhongVanBanNoiBo remove(SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws NoSuchSoPhongVanBanNoiBoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SoPhongVanBanNoiBo soPhongVanBanNoiBo = (SoPhongVanBanNoiBo) session.get(SoPhongVanBanNoiBoImpl.class,
                    soPhongVanBanNoiBoPK);

            if (soPhongVanBanNoiBo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No SoPhongVanBanNoiBo exists with the primary key " +
                        soPhongVanBanNoiBoPK);
                }

                throw new NoSuchSoPhongVanBanNoiBoException(
                    "No SoPhongVanBanNoiBo exists with the primary key " +
                    soPhongVanBanNoiBoPK);
            }

            return remove(soPhongVanBanNoiBo);
        } catch (NoSuchSoPhongVanBanNoiBoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public SoPhongVanBanNoiBo remove(SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(soPhongVanBanNoiBo);
            }
        }

        soPhongVanBanNoiBo = removeImpl(soPhongVanBanNoiBo);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(soPhongVanBanNoiBo);
            }
        }

        return soPhongVanBanNoiBo;
    }

    protected SoPhongVanBanNoiBo removeImpl(
        SoPhongVanBanNoiBo soPhongVanBanNoiBo) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(soPhongVanBanNoiBo);

            session.flush();

            return soPhongVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(SoPhongVanBanNoiBo.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(SoPhongVanBanNoiBo soPhongVanBanNoiBo, boolean merge)</code>.
     */
    public SoPhongVanBanNoiBo update(SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(SoPhongVanBanNoiBo soPhongVanBanNoiBo) method. Use update(SoPhongVanBanNoiBo soPhongVanBanNoiBo, boolean merge) instead.");
        }

        return update(soPhongVanBanNoiBo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                soPhongVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when soPhongVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public SoPhongVanBanNoiBo update(SoPhongVanBanNoiBo soPhongVanBanNoiBo,
        boolean merge) throws SystemException {
        boolean isNew = soPhongVanBanNoiBo.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(soPhongVanBanNoiBo);
                } else {
                    listener.onBeforeUpdate(soPhongVanBanNoiBo);
                }
            }
        }

        soPhongVanBanNoiBo = updateImpl(soPhongVanBanNoiBo, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(soPhongVanBanNoiBo);
                } else {
                    listener.onAfterUpdate(soPhongVanBanNoiBo);
                }
            }
        }

        return soPhongVanBanNoiBo;
    }

    public SoPhongVanBanNoiBo updateImpl(
        com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(soPhongVanBanNoiBo);
            } else {
                if (soPhongVanBanNoiBo.isNew()) {
                    session.save(soPhongVanBanNoiBo);
                }
            }

            session.flush();

            soPhongVanBanNoiBo.setNew(false);

            return soPhongVanBanNoiBo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(SoPhongVanBanNoiBo.class.getName());
        }
    }

    public SoPhongVanBanNoiBo findByPrimaryKey(
        SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws NoSuchSoPhongVanBanNoiBoException, SystemException {
        SoPhongVanBanNoiBo soPhongVanBanNoiBo = fetchByPrimaryKey(soPhongVanBanNoiBoPK);

        if (soPhongVanBanNoiBo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No SoPhongVanBanNoiBo exists with the primary key " +
                    soPhongVanBanNoiBoPK);
            }

            throw new NoSuchSoPhongVanBanNoiBoException(
                "No SoPhongVanBanNoiBo exists with the primary key " +
                soPhongVanBanNoiBoPK);
        }

        return soPhongVanBanNoiBo;
    }

    public SoPhongVanBanNoiBo fetchByPrimaryKey(
        SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (SoPhongVanBanNoiBo) session.get(SoPhongVanBanNoiBoImpl.class,
                soPhongVanBanNoiBoPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<SoPhongVanBanNoiBo> findBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SoPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoPhongVanBanNoiBo.class.getName();
        String finderMethodName = "findBySoVanBanNoiBo";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(soVanBanNoiBoId) };

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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo WHERE ");

                query.append("soVanBanNoiBoId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(soVanBanNoiBoId);

                List<SoPhongVanBanNoiBo> list = q.list();

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
            return (List<SoPhongVanBanNoiBo>) result;
        }
    }

    public List<SoPhongVanBanNoiBo> findBySoVanBanNoiBo(long soVanBanNoiBoId,
        int start, int end) throws SystemException {
        return findBySoVanBanNoiBo(soVanBanNoiBoId, start, end, null);
    }

    public List<SoPhongVanBanNoiBo> findBySoVanBanNoiBo(long soVanBanNoiBoId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = SoPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoPhongVanBanNoiBo.class.getName();
        String finderMethodName = "findBySoVanBanNoiBo";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(soVanBanNoiBoId),
                
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo WHERE ");

                query.append("soVanBanNoiBoId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(soVanBanNoiBoId);

                List<SoPhongVanBanNoiBo> list = (List<SoPhongVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<SoPhongVanBanNoiBo>) result;
        }
    }

    public SoPhongVanBanNoiBo findBySoVanBanNoiBo_First(long soVanBanNoiBoId,
        OrderByComparator obc)
        throws NoSuchSoPhongVanBanNoiBoException, SystemException {
        List<SoPhongVanBanNoiBo> list = findBySoVanBanNoiBo(soVanBanNoiBoId, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SoPhongVanBanNoiBo exists with the key {");

            msg.append("soVanBanNoiBoId=" + soVanBanNoiBoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSoPhongVanBanNoiBoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SoPhongVanBanNoiBo findBySoVanBanNoiBo_Last(long soVanBanNoiBoId,
        OrderByComparator obc)
        throws NoSuchSoPhongVanBanNoiBoException, SystemException {
        int count = countBySoVanBanNoiBo(soVanBanNoiBoId);

        List<SoPhongVanBanNoiBo> list = findBySoVanBanNoiBo(soVanBanNoiBoId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SoPhongVanBanNoiBo exists with the key {");

            msg.append("soVanBanNoiBoId=" + soVanBanNoiBoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSoPhongVanBanNoiBoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SoPhongVanBanNoiBo[] findBySoVanBanNoiBo_PrevAndNext(
        SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK, long soVanBanNoiBoId,
        OrderByComparator obc)
        throws NoSuchSoPhongVanBanNoiBoException, SystemException {
        SoPhongVanBanNoiBo soPhongVanBanNoiBo = findByPrimaryKey(soPhongVanBanNoiBoPK);

        int count = countBySoVanBanNoiBo(soVanBanNoiBoId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo WHERE ");

            query.append("soVanBanNoiBoId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(soVanBanNoiBoId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    soPhongVanBanNoiBo);

            SoPhongVanBanNoiBo[] array = new SoPhongVanBanNoiBoImpl[3];

            array[0] = (SoPhongVanBanNoiBo) objArray[0];
            array[1] = (SoPhongVanBanNoiBo) objArray[1];
            array[2] = (SoPhongVanBanNoiBo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<SoPhongVanBanNoiBo> findByPhongVanBanNoiBo(
        String phongVanBanNoiBoId) throws SystemException {
        boolean finderClassNameCacheEnabled = SoPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoPhongVanBanNoiBo.class.getName();
        String finderMethodName = "findByPhongVanBanNoiBo";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { phongVanBanNoiBoId };

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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo WHERE ");

                if (phongVanBanNoiBoId == null) {
                    query.append("phongVanBanNoiBoId IS NULL");
                } else {
                    query.append("phongVanBanNoiBoId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (phongVanBanNoiBoId != null) {
                    qPos.add(phongVanBanNoiBoId);
                }

                List<SoPhongVanBanNoiBo> list = q.list();

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
            return (List<SoPhongVanBanNoiBo>) result;
        }
    }

    public List<SoPhongVanBanNoiBo> findByPhongVanBanNoiBo(
        String phongVanBanNoiBoId, int start, int end)
        throws SystemException {
        return findByPhongVanBanNoiBo(phongVanBanNoiBoId, start, end, null);
    }

    public List<SoPhongVanBanNoiBo> findByPhongVanBanNoiBo(
        String phongVanBanNoiBoId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SoPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoPhongVanBanNoiBo.class.getName();
        String finderMethodName = "findByPhongVanBanNoiBo";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                phongVanBanNoiBoId,
                
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo WHERE ");

                if (phongVanBanNoiBoId == null) {
                    query.append("phongVanBanNoiBoId IS NULL");
                } else {
                    query.append("phongVanBanNoiBoId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (phongVanBanNoiBoId != null) {
                    qPos.add(phongVanBanNoiBoId);
                }

                List<SoPhongVanBanNoiBo> list = (List<SoPhongVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<SoPhongVanBanNoiBo>) result;
        }
    }

    public SoPhongVanBanNoiBo findByPhongVanBanNoiBo_First(
        String phongVanBanNoiBoId, OrderByComparator obc)
        throws NoSuchSoPhongVanBanNoiBoException, SystemException {
        List<SoPhongVanBanNoiBo> list = findByPhongVanBanNoiBo(phongVanBanNoiBoId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SoPhongVanBanNoiBo exists with the key {");

            msg.append("phongVanBanNoiBoId=" + phongVanBanNoiBoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSoPhongVanBanNoiBoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SoPhongVanBanNoiBo findByPhongVanBanNoiBo_Last(
        String phongVanBanNoiBoId, OrderByComparator obc)
        throws NoSuchSoPhongVanBanNoiBoException, SystemException {
        int count = countByPhongVanBanNoiBo(phongVanBanNoiBoId);

        List<SoPhongVanBanNoiBo> list = findByPhongVanBanNoiBo(phongVanBanNoiBoId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SoPhongVanBanNoiBo exists with the key {");

            msg.append("phongVanBanNoiBoId=" + phongVanBanNoiBoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSoPhongVanBanNoiBoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SoPhongVanBanNoiBo[] findByPhongVanBanNoiBo_PrevAndNext(
        SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK, String phongVanBanNoiBoId,
        OrderByComparator obc)
        throws NoSuchSoPhongVanBanNoiBoException, SystemException {
        SoPhongVanBanNoiBo soPhongVanBanNoiBo = findByPrimaryKey(soPhongVanBanNoiBoPK);

        int count = countByPhongVanBanNoiBo(phongVanBanNoiBoId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo WHERE ");

            if (phongVanBanNoiBoId == null) {
                query.append("phongVanBanNoiBoId IS NULL");
            } else {
                query.append("phongVanBanNoiBoId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (phongVanBanNoiBoId != null) {
                qPos.add(phongVanBanNoiBoId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    soPhongVanBanNoiBo);

            SoPhongVanBanNoiBo[] array = new SoPhongVanBanNoiBoImpl[3];

            array[0] = (SoPhongVanBanNoiBo) objArray[0];
            array[1] = (SoPhongVanBanNoiBo) objArray[1];
            array[2] = (SoPhongVanBanNoiBo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<SoPhongVanBanNoiBo> findBySoVanBanNoiBo_PhongVanBanNoiBo(
        long soVanBanNoiBoId, String phongVanBanNoiBoId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SoPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoPhongVanBanNoiBo.class.getName();
        String finderMethodName = "findBySoVanBanNoiBo_PhongVanBanNoiBo";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(soVanBanNoiBoId),
                
                phongVanBanNoiBoId
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo WHERE ");

                query.append("soVanBanNoiBoId = ?");

                query.append(" AND ");

                if (phongVanBanNoiBoId == null) {
                    query.append("phongVanBanNoiBoId IS NULL");
                } else {
                    query.append("phongVanBanNoiBoId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(soVanBanNoiBoId);

                if (phongVanBanNoiBoId != null) {
                    qPos.add(phongVanBanNoiBoId);
                }

                List<SoPhongVanBanNoiBo> list = q.list();

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
            return (List<SoPhongVanBanNoiBo>) result;
        }
    }

    public List<SoPhongVanBanNoiBo> findBySoVanBanNoiBo_PhongVanBanNoiBo(
        long soVanBanNoiBoId, String phongVanBanNoiBoId, int start, int end)
        throws SystemException {
        return findBySoVanBanNoiBo_PhongVanBanNoiBo(soVanBanNoiBoId,
            phongVanBanNoiBoId, start, end, null);
    }

    public List<SoPhongVanBanNoiBo> findBySoVanBanNoiBo_PhongVanBanNoiBo(
        long soVanBanNoiBoId, String phongVanBanNoiBoId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = SoPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoPhongVanBanNoiBo.class.getName();
        String finderMethodName = "findBySoVanBanNoiBo_PhongVanBanNoiBo";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(soVanBanNoiBoId),
                
                phongVanBanNoiBoId,
                
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo WHERE ");

                query.append("soVanBanNoiBoId = ?");

                query.append(" AND ");

                if (phongVanBanNoiBoId == null) {
                    query.append("phongVanBanNoiBoId IS NULL");
                } else {
                    query.append("phongVanBanNoiBoId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(soVanBanNoiBoId);

                if (phongVanBanNoiBoId != null) {
                    qPos.add(phongVanBanNoiBoId);
                }

                List<SoPhongVanBanNoiBo> list = (List<SoPhongVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<SoPhongVanBanNoiBo>) result;
        }
    }

    public SoPhongVanBanNoiBo findBySoVanBanNoiBo_PhongVanBanNoiBo_First(
        long soVanBanNoiBoId, String phongVanBanNoiBoId, OrderByComparator obc)
        throws NoSuchSoPhongVanBanNoiBoException, SystemException {
        List<SoPhongVanBanNoiBo> list = findBySoVanBanNoiBo_PhongVanBanNoiBo(soVanBanNoiBoId,
                phongVanBanNoiBoId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SoPhongVanBanNoiBo exists with the key {");

            msg.append("soVanBanNoiBoId=" + soVanBanNoiBoId);

            msg.append(", ");
            msg.append("phongVanBanNoiBoId=" + phongVanBanNoiBoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSoPhongVanBanNoiBoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SoPhongVanBanNoiBo findBySoVanBanNoiBo_PhongVanBanNoiBo_Last(
        long soVanBanNoiBoId, String phongVanBanNoiBoId, OrderByComparator obc)
        throws NoSuchSoPhongVanBanNoiBoException, SystemException {
        int count = countBySoVanBanNoiBo_PhongVanBanNoiBo(soVanBanNoiBoId,
                phongVanBanNoiBoId);

        List<SoPhongVanBanNoiBo> list = findBySoVanBanNoiBo_PhongVanBanNoiBo(soVanBanNoiBoId,
                phongVanBanNoiBoId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SoPhongVanBanNoiBo exists with the key {");

            msg.append("soVanBanNoiBoId=" + soVanBanNoiBoId);

            msg.append(", ");
            msg.append("phongVanBanNoiBoId=" + phongVanBanNoiBoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSoPhongVanBanNoiBoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SoPhongVanBanNoiBo[] findBySoVanBanNoiBo_PhongVanBanNoiBo_PrevAndNext(
        SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK, long soVanBanNoiBoId,
        String phongVanBanNoiBoId, OrderByComparator obc)
        throws NoSuchSoPhongVanBanNoiBoException, SystemException {
        SoPhongVanBanNoiBo soPhongVanBanNoiBo = findByPrimaryKey(soPhongVanBanNoiBoPK);

        int count = countBySoVanBanNoiBo_PhongVanBanNoiBo(soVanBanNoiBoId,
                phongVanBanNoiBoId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo WHERE ");

            query.append("soVanBanNoiBoId = ?");

            query.append(" AND ");

            if (phongVanBanNoiBoId == null) {
                query.append("phongVanBanNoiBoId IS NULL");
            } else {
                query.append("phongVanBanNoiBoId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(soVanBanNoiBoId);

            if (phongVanBanNoiBoId != null) {
                qPos.add(phongVanBanNoiBoId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    soPhongVanBanNoiBo);

            SoPhongVanBanNoiBo[] array = new SoPhongVanBanNoiBoImpl[3];

            array[0] = (SoPhongVanBanNoiBo) objArray[0];
            array[1] = (SoPhongVanBanNoiBo) objArray[1];
            array[2] = (SoPhongVanBanNoiBo) objArray[2];

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

    public List<SoPhongVanBanNoiBo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<SoPhongVanBanNoiBo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<SoPhongVanBanNoiBo> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = SoPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoPhongVanBanNoiBo.class.getName();
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<SoPhongVanBanNoiBo> list = (List<SoPhongVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<SoPhongVanBanNoiBo>) result;
        }
    }

    public void removeBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws SystemException {
        for (SoPhongVanBanNoiBo soPhongVanBanNoiBo : findBySoVanBanNoiBo(
                soVanBanNoiBoId)) {
            remove(soPhongVanBanNoiBo);
        }
    }

    public void removeByPhongVanBanNoiBo(String phongVanBanNoiBoId)
        throws SystemException {
        for (SoPhongVanBanNoiBo soPhongVanBanNoiBo : findByPhongVanBanNoiBo(
                phongVanBanNoiBoId)) {
            remove(soPhongVanBanNoiBo);
        }
    }

    public void removeBySoVanBanNoiBo_PhongVanBanNoiBo(long soVanBanNoiBoId,
        String phongVanBanNoiBoId) throws SystemException {
        for (SoPhongVanBanNoiBo soPhongVanBanNoiBo : findBySoVanBanNoiBo_PhongVanBanNoiBo(
                soVanBanNoiBoId, phongVanBanNoiBoId)) {
            remove(soPhongVanBanNoiBo);
        }
    }

    public void removeAll() throws SystemException {
        for (SoPhongVanBanNoiBo soPhongVanBanNoiBo : findAll()) {
            remove(soPhongVanBanNoiBo);
        }
    }

    public int countBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SoPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoPhongVanBanNoiBo.class.getName();
        String finderMethodName = "countBySoVanBanNoiBo";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(soVanBanNoiBoId) };

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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo WHERE ");

                query.append("soVanBanNoiBoId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(soVanBanNoiBoId);

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

    public int countByPhongVanBanNoiBo(String phongVanBanNoiBoId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SoPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoPhongVanBanNoiBo.class.getName();
        String finderMethodName = "countByPhongVanBanNoiBo";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { phongVanBanNoiBoId };

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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo WHERE ");

                if (phongVanBanNoiBoId == null) {
                    query.append("phongVanBanNoiBoId IS NULL");
                } else {
                    query.append("phongVanBanNoiBoId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (phongVanBanNoiBoId != null) {
                    qPos.add(phongVanBanNoiBoId);
                }

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

    public int countBySoVanBanNoiBo_PhongVanBanNoiBo(long soVanBanNoiBoId,
        String phongVanBanNoiBoId) throws SystemException {
        boolean finderClassNameCacheEnabled = SoPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoPhongVanBanNoiBo.class.getName();
        String finderMethodName = "countBySoVanBanNoiBo_PhongVanBanNoiBo";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(soVanBanNoiBoId),
                
                phongVanBanNoiBoId
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

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo WHERE ");

                query.append("soVanBanNoiBoId = ?");

                query.append(" AND ");

                if (phongVanBanNoiBoId == null) {
                    query.append("phongVanBanNoiBoId IS NULL");
                } else {
                    query.append("phongVanBanNoiBoId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(soVanBanNoiBoId);

                if (phongVanBanNoiBoId != null) {
                    qPos.add(phongVanBanNoiBoId);
                }

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
        boolean finderClassNameCacheEnabled = SoPhongVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoPhongVanBanNoiBo.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo");

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
                        "value.object.listener.com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo")));

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
