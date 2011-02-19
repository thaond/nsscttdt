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

import com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException;
import com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.model.impl.SoLoaiVanBanNoiBoImpl;
import com.sgs.portlet.sovanbannoibo.model.impl.SoLoaiVanBanNoiBoModelImpl;

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
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo,
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

    public List<SoLoaiVanBanNoiBo> findBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SoLoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoLoaiVanBanNoiBo.class.getName();
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo WHERE ");

                query.append("soVanBanNoiBoId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(soVanBanNoiBoId);

                List<SoLoaiVanBanNoiBo> list = q.list();

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

    public List<SoLoaiVanBanNoiBo> findBySoVanBanNoiBo(long soVanBanNoiBoId,
        int start, int end) throws SystemException {
        return findBySoVanBanNoiBo(soVanBanNoiBoId, start, end, null);
    }

    public List<SoLoaiVanBanNoiBo> findBySoVanBanNoiBo(long soVanBanNoiBoId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = SoLoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoLoaiVanBanNoiBo.class.getName();
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo WHERE ");

                query.append("soVanBanNoiBoId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(soVanBanNoiBoId);

                List<SoLoaiVanBanNoiBo> list = (List<SoLoaiVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<SoLoaiVanBanNoiBo>) result;
        }
    }

    public SoLoaiVanBanNoiBo findBySoVanBanNoiBo_First(long soVanBanNoiBoId,
        OrderByComparator obc)
        throws NoSuchSoLoaiVanBanNoiBoException, SystemException {
        List<SoLoaiVanBanNoiBo> list = findBySoVanBanNoiBo(soVanBanNoiBoId, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SoLoaiVanBanNoiBo exists with the key {");

            msg.append("soVanBanNoiBoId=" + soVanBanNoiBoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSoLoaiVanBanNoiBoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SoLoaiVanBanNoiBo findBySoVanBanNoiBo_Last(long soVanBanNoiBoId,
        OrderByComparator obc)
        throws NoSuchSoLoaiVanBanNoiBoException, SystemException {
        int count = countBySoVanBanNoiBo(soVanBanNoiBoId);

        List<SoLoaiVanBanNoiBo> list = findBySoVanBanNoiBo(soVanBanNoiBoId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SoLoaiVanBanNoiBo exists with the key {");

            msg.append("soVanBanNoiBoId=" + soVanBanNoiBoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSoLoaiVanBanNoiBoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SoLoaiVanBanNoiBo[] findBySoVanBanNoiBo_PrevAndNext(
        SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK, long soVanBanNoiBoId,
        OrderByComparator obc)
        throws NoSuchSoLoaiVanBanNoiBoException, SystemException {
        SoLoaiVanBanNoiBo soLoaiVanBanNoiBo = findByPrimaryKey(soLoaiVanBanNoiBoPK);

        int count = countBySoVanBanNoiBo(soVanBanNoiBoId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo WHERE ");

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
                    soLoaiVanBanNoiBo);

            SoLoaiVanBanNoiBo[] array = new SoLoaiVanBanNoiBoImpl[3];

            array[0] = (SoLoaiVanBanNoiBo) objArray[0];
            array[1] = (SoLoaiVanBanNoiBo) objArray[1];
            array[2] = (SoLoaiVanBanNoiBo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<SoLoaiVanBanNoiBo> findByLoaiVanBanNoiBo(long loaiVanBanNoiBoId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SoLoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoLoaiVanBanNoiBo.class.getName();
        String finderMethodName = "findByLoaiVanBanNoiBo";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(loaiVanBanNoiBoId) };

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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo WHERE ");

                query.append("loaiVanBanNoiBoId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(loaiVanBanNoiBoId);

                List<SoLoaiVanBanNoiBo> list = q.list();

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

    public List<SoLoaiVanBanNoiBo> findByLoaiVanBanNoiBo(
        long loaiVanBanNoiBoId, int start, int end) throws SystemException {
        return findByLoaiVanBanNoiBo(loaiVanBanNoiBoId, start, end, null);
    }

    public List<SoLoaiVanBanNoiBo> findByLoaiVanBanNoiBo(
        long loaiVanBanNoiBoId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SoLoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoLoaiVanBanNoiBo.class.getName();
        String finderMethodName = "findByLoaiVanBanNoiBo";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(loaiVanBanNoiBoId),
                
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo WHERE ");

                query.append("loaiVanBanNoiBoId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(loaiVanBanNoiBoId);

                List<SoLoaiVanBanNoiBo> list = (List<SoLoaiVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<SoLoaiVanBanNoiBo>) result;
        }
    }

    public SoLoaiVanBanNoiBo findByLoaiVanBanNoiBo_First(
        long loaiVanBanNoiBoId, OrderByComparator obc)
        throws NoSuchSoLoaiVanBanNoiBoException, SystemException {
        List<SoLoaiVanBanNoiBo> list = findByLoaiVanBanNoiBo(loaiVanBanNoiBoId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SoLoaiVanBanNoiBo exists with the key {");

            msg.append("loaiVanBanNoiBoId=" + loaiVanBanNoiBoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSoLoaiVanBanNoiBoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SoLoaiVanBanNoiBo findByLoaiVanBanNoiBo_Last(
        long loaiVanBanNoiBoId, OrderByComparator obc)
        throws NoSuchSoLoaiVanBanNoiBoException, SystemException {
        int count = countByLoaiVanBanNoiBo(loaiVanBanNoiBoId);

        List<SoLoaiVanBanNoiBo> list = findByLoaiVanBanNoiBo(loaiVanBanNoiBoId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SoLoaiVanBanNoiBo exists with the key {");

            msg.append("loaiVanBanNoiBoId=" + loaiVanBanNoiBoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSoLoaiVanBanNoiBoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SoLoaiVanBanNoiBo[] findByLoaiVanBanNoiBo_PrevAndNext(
        SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK, long loaiVanBanNoiBoId,
        OrderByComparator obc)
        throws NoSuchSoLoaiVanBanNoiBoException, SystemException {
        SoLoaiVanBanNoiBo soLoaiVanBanNoiBo = findByPrimaryKey(soLoaiVanBanNoiBoPK);

        int count = countByLoaiVanBanNoiBo(loaiVanBanNoiBoId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo WHERE ");

            query.append("loaiVanBanNoiBoId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(loaiVanBanNoiBoId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    soLoaiVanBanNoiBo);

            SoLoaiVanBanNoiBo[] array = new SoLoaiVanBanNoiBoImpl[3];

            array[0] = (SoLoaiVanBanNoiBo) objArray[0];
            array[1] = (SoLoaiVanBanNoiBo) objArray[1];
            array[2] = (SoLoaiVanBanNoiBo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<SoLoaiVanBanNoiBo> findBySoVanBanNoiBo_LoaiVanBanNoiBo(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId) throws SystemException {
        boolean finderClassNameCacheEnabled = SoLoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoLoaiVanBanNoiBo.class.getName();
        String finderMethodName = "findBySoVanBanNoiBo_LoaiVanBanNoiBo";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(soVanBanNoiBoId), new Long(loaiVanBanNoiBoId)
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo WHERE ");

                query.append("soVanBanNoiBoId = ?");

                query.append(" AND ");

                query.append("loaiVanBanNoiBoId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(soVanBanNoiBoId);

                qPos.add(loaiVanBanNoiBoId);

                List<SoLoaiVanBanNoiBo> list = q.list();

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

    public List<SoLoaiVanBanNoiBo> findBySoVanBanNoiBo_LoaiVanBanNoiBo(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId, int start, int end)
        throws SystemException {
        return findBySoVanBanNoiBo_LoaiVanBanNoiBo(soVanBanNoiBoId,
            loaiVanBanNoiBoId, start, end, null);
    }

    public List<SoLoaiVanBanNoiBo> findBySoVanBanNoiBo_LoaiVanBanNoiBo(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = SoLoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoLoaiVanBanNoiBo.class.getName();
        String finderMethodName = "findBySoVanBanNoiBo_LoaiVanBanNoiBo";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(soVanBanNoiBoId), new Long(loaiVanBanNoiBoId),
                
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo WHERE ");

                query.append("soVanBanNoiBoId = ?");

                query.append(" AND ");

                query.append("loaiVanBanNoiBoId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(soVanBanNoiBoId);

                qPos.add(loaiVanBanNoiBoId);

                List<SoLoaiVanBanNoiBo> list = (List<SoLoaiVanBanNoiBo>) QueryUtil.list(q,
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
            return (List<SoLoaiVanBanNoiBo>) result;
        }
    }

    public SoLoaiVanBanNoiBo findBySoVanBanNoiBo_LoaiVanBanNoiBo_First(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId, OrderByComparator obc)
        throws NoSuchSoLoaiVanBanNoiBoException, SystemException {
        List<SoLoaiVanBanNoiBo> list = findBySoVanBanNoiBo_LoaiVanBanNoiBo(soVanBanNoiBoId,
                loaiVanBanNoiBoId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SoLoaiVanBanNoiBo exists with the key {");

            msg.append("soVanBanNoiBoId=" + soVanBanNoiBoId);

            msg.append(", ");
            msg.append("loaiVanBanNoiBoId=" + loaiVanBanNoiBoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSoLoaiVanBanNoiBoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SoLoaiVanBanNoiBo findBySoVanBanNoiBo_LoaiVanBanNoiBo_Last(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId, OrderByComparator obc)
        throws NoSuchSoLoaiVanBanNoiBoException, SystemException {
        int count = countBySoVanBanNoiBo_LoaiVanBanNoiBo(soVanBanNoiBoId,
                loaiVanBanNoiBoId);

        List<SoLoaiVanBanNoiBo> list = findBySoVanBanNoiBo_LoaiVanBanNoiBo(soVanBanNoiBoId,
                loaiVanBanNoiBoId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SoLoaiVanBanNoiBo exists with the key {");

            msg.append("soVanBanNoiBoId=" + soVanBanNoiBoId);

            msg.append(", ");
            msg.append("loaiVanBanNoiBoId=" + loaiVanBanNoiBoId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSoLoaiVanBanNoiBoException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SoLoaiVanBanNoiBo[] findBySoVanBanNoiBo_LoaiVanBanNoiBo_PrevAndNext(
        SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK, long soVanBanNoiBoId,
        long loaiVanBanNoiBoId, OrderByComparator obc)
        throws NoSuchSoLoaiVanBanNoiBoException, SystemException {
        SoLoaiVanBanNoiBo soLoaiVanBanNoiBo = findByPrimaryKey(soLoaiVanBanNoiBoPK);

        int count = countBySoVanBanNoiBo_LoaiVanBanNoiBo(soVanBanNoiBoId,
                loaiVanBanNoiBoId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo WHERE ");

            query.append("soVanBanNoiBoId = ?");

            query.append(" AND ");

            query.append("loaiVanBanNoiBoId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(soVanBanNoiBoId);

            qPos.add(loaiVanBanNoiBoId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    soLoaiVanBanNoiBo);

            SoLoaiVanBanNoiBo[] array = new SoLoaiVanBanNoiBoImpl[3];

            array[0] = (SoLoaiVanBanNoiBo) objArray[0];
            array[1] = (SoLoaiVanBanNoiBo) objArray[1];
            array[2] = (SoLoaiVanBanNoiBo) objArray[2];

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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo ");

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

    public void removeBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws SystemException {
        for (SoLoaiVanBanNoiBo soLoaiVanBanNoiBo : findBySoVanBanNoiBo(
                soVanBanNoiBoId)) {
            remove(soLoaiVanBanNoiBo);
        }
    }

    public void removeByLoaiVanBanNoiBo(long loaiVanBanNoiBoId)
        throws SystemException {
        for (SoLoaiVanBanNoiBo soLoaiVanBanNoiBo : findByLoaiVanBanNoiBo(
                loaiVanBanNoiBoId)) {
            remove(soLoaiVanBanNoiBo);
        }
    }

    public void removeBySoVanBanNoiBo_LoaiVanBanNoiBo(long soVanBanNoiBoId,
        long loaiVanBanNoiBoId) throws SystemException {
        for (SoLoaiVanBanNoiBo soLoaiVanBanNoiBo : findBySoVanBanNoiBo_LoaiVanBanNoiBo(
                soVanBanNoiBoId, loaiVanBanNoiBoId)) {
            remove(soLoaiVanBanNoiBo);
        }
    }

    public void removeAll() throws SystemException {
        for (SoLoaiVanBanNoiBo soLoaiVanBanNoiBo : findAll()) {
            remove(soLoaiVanBanNoiBo);
        }
    }

    public int countBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SoLoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoLoaiVanBanNoiBo.class.getName();
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo WHERE ");

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

    public int countByLoaiVanBanNoiBo(long loaiVanBanNoiBoId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SoLoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoLoaiVanBanNoiBo.class.getName();
        String finderMethodName = "countByLoaiVanBanNoiBo";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(loaiVanBanNoiBoId) };

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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo WHERE ");

                query.append("loaiVanBanNoiBoId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(loaiVanBanNoiBoId);

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

    public int countBySoVanBanNoiBo_LoaiVanBanNoiBo(long soVanBanNoiBoId,
        long loaiVanBanNoiBoId) throws SystemException {
        boolean finderClassNameCacheEnabled = SoLoaiVanBanNoiBoModelImpl.CACHE_ENABLED;
        String finderClassName = SoLoaiVanBanNoiBo.class.getName();
        String finderMethodName = "countBySoVanBanNoiBo_LoaiVanBanNoiBo";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(soVanBanNoiBoId), new Long(loaiVanBanNoiBoId)
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
                    "FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo WHERE ");

                query.append("soVanBanNoiBoId = ?");

                query.append(" AND ");

                query.append("loaiVanBanNoiBoId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(soVanBanNoiBoId);

                qPos.add(loaiVanBanNoiBoId);

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
                        "SELECT COUNT(*) FROM com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo");

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
                        "value.object.listener.com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo")));

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
