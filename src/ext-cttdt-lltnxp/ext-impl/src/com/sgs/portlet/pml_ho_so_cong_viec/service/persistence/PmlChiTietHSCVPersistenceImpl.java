package com.sgs.portlet.pml_ho_so_cong_viec.service.persistence;

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

import com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV;
import com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlChiTietHSCVImpl;
import com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlChiTietHSCVModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlChiTietHSCVPersistenceImpl extends BasePersistenceImpl
    implements PmlChiTietHSCVPersistence {
    private static Log _log = LogFactory.getLog(PmlChiTietHSCVPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlChiTietHSCV create(long idChiTietHSCV) {
        PmlChiTietHSCV pmlChiTietHSCV = new PmlChiTietHSCVImpl();

        pmlChiTietHSCV.setNew(true);
        pmlChiTietHSCV.setPrimaryKey(idChiTietHSCV);

        return pmlChiTietHSCV;
    }

    public PmlChiTietHSCV remove(long idChiTietHSCV)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlChiTietHSCV pmlChiTietHSCV = (PmlChiTietHSCV) session.get(PmlChiTietHSCVImpl.class,
                    new Long(idChiTietHSCV));

            if (pmlChiTietHSCV == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlChiTietHSCV exists with the primary key " +
                        idChiTietHSCV);
                }

                throw new NoSuchPmlChiTietHSCVException(
                    "No PmlChiTietHSCV exists with the primary key " +
                    idChiTietHSCV);
            }

            return remove(pmlChiTietHSCV);
        } catch (NoSuchPmlChiTietHSCVException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlChiTietHSCV remove(PmlChiTietHSCV pmlChiTietHSCV)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlChiTietHSCV);
            }
        }

        pmlChiTietHSCV = removeImpl(pmlChiTietHSCV);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlChiTietHSCV);
            }
        }

        return pmlChiTietHSCV;
    }

    protected PmlChiTietHSCV removeImpl(PmlChiTietHSCV pmlChiTietHSCV)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlChiTietHSCV);

            session.flush();

            return pmlChiTietHSCV;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlChiTietHSCV.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlChiTietHSCV pmlChiTietHSCV, boolean merge)</code>.
     */
    public PmlChiTietHSCV update(PmlChiTietHSCV pmlChiTietHSCV)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlChiTietHSCV pmlChiTietHSCV) method. Use update(PmlChiTietHSCV pmlChiTietHSCV, boolean merge) instead.");
        }

        return update(pmlChiTietHSCV, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlChiTietHSCV the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlChiTietHSCV is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlChiTietHSCV update(PmlChiTietHSCV pmlChiTietHSCV, boolean merge)
        throws SystemException {
        boolean isNew = pmlChiTietHSCV.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlChiTietHSCV);
                } else {
                    listener.onBeforeUpdate(pmlChiTietHSCV);
                }
            }
        }

        pmlChiTietHSCV = updateImpl(pmlChiTietHSCV, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlChiTietHSCV);
                } else {
                    listener.onAfterUpdate(pmlChiTietHSCV);
                }
            }
        }

        return pmlChiTietHSCV;
    }

    public PmlChiTietHSCV updateImpl(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlChiTietHSCV);
            } else {
                if (pmlChiTietHSCV.isNew()) {
                    session.save(pmlChiTietHSCV);
                }
            }

            session.flush();

            pmlChiTietHSCV.setNew(false);

            return pmlChiTietHSCV;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlChiTietHSCV.class.getName());
        }
    }

    public PmlChiTietHSCV findByPrimaryKey(long idChiTietHSCV)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        PmlChiTietHSCV pmlChiTietHSCV = fetchByPrimaryKey(idChiTietHSCV);

        if (pmlChiTietHSCV == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlChiTietHSCV exists with the primary key " +
                    idChiTietHSCV);
            }

            throw new NoSuchPmlChiTietHSCVException(
                "No PmlChiTietHSCV exists with the primary key " +
                idChiTietHSCV);
        }

        return pmlChiTietHSCV;
    }

    public PmlChiTietHSCV fetchByPrimaryKey(long idChiTietHSCV)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlChiTietHSCV) session.get(PmlChiTietHSCVImpl.class,
                new Long(idChiTietHSCV));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlChiTietHSCV> findByIdHoSoCongViec(long idHoSoCongViec)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "findByIdHoSoCongViec";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idHoSoCongViec) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_ho_so_cong_viec = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("id_chi_tiet_hscv DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idHoSoCongViec);

                List<PmlChiTietHSCV> list = q.list();

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
            return (List<PmlChiTietHSCV>) result;
        }
    }

    public List<PmlChiTietHSCV> findByIdHoSoCongViec(long idHoSoCongViec,
        int start, int end) throws SystemException {
        return findByIdHoSoCongViec(idHoSoCongViec, start, end, null);
    }

    public List<PmlChiTietHSCV> findByIdHoSoCongViec(long idHoSoCongViec,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "findByIdHoSoCongViec";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(idHoSoCongViec),
                
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_ho_so_cong_viec = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("id_chi_tiet_hscv DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idHoSoCongViec);

                List<PmlChiTietHSCV> list = (List<PmlChiTietHSCV>) QueryUtil.list(q,
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
            return (List<PmlChiTietHSCV>) result;
        }
    }

    public PmlChiTietHSCV findByIdHoSoCongViec_First(long idHoSoCongViec,
        OrderByComparator obc)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        List<PmlChiTietHSCV> list = findByIdHoSoCongViec(idHoSoCongViec, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlChiTietHSCV exists with the key {");

            msg.append("idHoSoCongViec=" + idHoSoCongViec);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlChiTietHSCVException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlChiTietHSCV findByIdHoSoCongViec_Last(long idHoSoCongViec,
        OrderByComparator obc)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        int count = countByIdHoSoCongViec(idHoSoCongViec);

        List<PmlChiTietHSCV> list = findByIdHoSoCongViec(idHoSoCongViec,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlChiTietHSCV exists with the key {");

            msg.append("idHoSoCongViec=" + idHoSoCongViec);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlChiTietHSCVException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlChiTietHSCV[] findByIdHoSoCongViec_PrevAndNext(
        long idChiTietHSCV, long idHoSoCongViec, OrderByComparator obc)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        PmlChiTietHSCV pmlChiTietHSCV = findByPrimaryKey(idChiTietHSCV);

        int count = countByIdHoSoCongViec(idHoSoCongViec);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

            query.append("id_ho_so_cong_viec = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("id_chi_tiet_hscv DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(idHoSoCongViec);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlChiTietHSCV);

            PmlChiTietHSCV[] array = new PmlChiTietHSCVImpl[3];

            array[0] = (PmlChiTietHSCV) objArray[0];
            array[1] = (PmlChiTietHSCV) objArray[1];
            array[2] = (PmlChiTietHSCV) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlChiTietHSCV findByH_DEN(long idHoSoCongViec, long idCongVanDen)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        PmlChiTietHSCV pmlChiTietHSCV = fetchByH_DEN(idHoSoCongViec,
                idCongVanDen);

        if (pmlChiTietHSCV == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlChiTietHSCV exists with the key {");

            msg.append("idHoSoCongViec=" + idHoSoCongViec);

            msg.append(", ");
            msg.append("idCongVanDen=" + idCongVanDen);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPmlChiTietHSCVException(msg.toString());
        }

        return pmlChiTietHSCV;
    }

    public PmlChiTietHSCV fetchByH_DEN(long idHoSoCongViec, long idCongVanDen)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "fetchByH_DEN";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(idHoSoCongViec), new Long(idCongVanDen)
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_ho_so_cong_viec = ?");

                query.append(" AND ");

                query.append("id_cong_van_den = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("id_chi_tiet_hscv DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idHoSoCongViec);

                qPos.add(idCongVanDen);

                List<PmlChiTietHSCV> list = q.list();

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                if (list.size() == 0) {
                    return null;
                } else {
                    return list.get(0);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            List<PmlChiTietHSCV> list = (List<PmlChiTietHSCV>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public PmlChiTietHSCV findByH_DI(long idHoSoCongViec, long idCongVanDi)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        PmlChiTietHSCV pmlChiTietHSCV = fetchByH_DI(idHoSoCongViec, idCongVanDi);

        if (pmlChiTietHSCV == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlChiTietHSCV exists with the key {");

            msg.append("idHoSoCongViec=" + idHoSoCongViec);

            msg.append(", ");
            msg.append("idCongVanDi=" + idCongVanDi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPmlChiTietHSCVException(msg.toString());
        }

        return pmlChiTietHSCV;
    }

    public PmlChiTietHSCV fetchByH_DI(long idHoSoCongViec, long idCongVanDi)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "fetchByH_DI";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(idHoSoCongViec), new Long(idCongVanDi)
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_ho_so_cong_viec = ?");

                query.append(" AND ");

                query.append("id_cong_van_di = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("id_chi_tiet_hscv DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idHoSoCongViec);

                qPos.add(idCongVanDi);

                List<PmlChiTietHSCV> list = q.list();

                FinderCacheUtil.putResult(finderClassNameCacheEnabled,
                    finderClassName, finderMethodName, finderParams,
                    finderArgs, list);

                if (list.size() == 0) {
                    return null;
                } else {
                    return list.get(0);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                closeSession(session);
            }
        } else {
            List<PmlChiTietHSCV> list = (List<PmlChiTietHSCV>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public List<PmlChiTietHSCV> findByIdCongVanDen(long idCongVanDen)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "findByIdCongVanDen";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idCongVanDen) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_cong_van_den = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("id_chi_tiet_hscv DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idCongVanDen);

                List<PmlChiTietHSCV> list = q.list();

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
            return (List<PmlChiTietHSCV>) result;
        }
    }

    public List<PmlChiTietHSCV> findByIdCongVanDen(long idCongVanDen,
        int start, int end) throws SystemException {
        return findByIdCongVanDen(idCongVanDen, start, end, null);
    }

    public List<PmlChiTietHSCV> findByIdCongVanDen(long idCongVanDen,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "findByIdCongVanDen";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(idCongVanDen),
                
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_cong_van_den = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("id_chi_tiet_hscv DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idCongVanDen);

                List<PmlChiTietHSCV> list = (List<PmlChiTietHSCV>) QueryUtil.list(q,
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
            return (List<PmlChiTietHSCV>) result;
        }
    }

    public PmlChiTietHSCV findByIdCongVanDen_First(long idCongVanDen,
        OrderByComparator obc)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        List<PmlChiTietHSCV> list = findByIdCongVanDen(idCongVanDen, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlChiTietHSCV exists with the key {");

            msg.append("idCongVanDen=" + idCongVanDen);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlChiTietHSCVException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlChiTietHSCV findByIdCongVanDen_Last(long idCongVanDen,
        OrderByComparator obc)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        int count = countByIdCongVanDen(idCongVanDen);

        List<PmlChiTietHSCV> list = findByIdCongVanDen(idCongVanDen, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlChiTietHSCV exists with the key {");

            msg.append("idCongVanDen=" + idCongVanDen);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlChiTietHSCVException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlChiTietHSCV[] findByIdCongVanDen_PrevAndNext(long idChiTietHSCV,
        long idCongVanDen, OrderByComparator obc)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        PmlChiTietHSCV pmlChiTietHSCV = findByPrimaryKey(idChiTietHSCV);

        int count = countByIdCongVanDen(idCongVanDen);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

            query.append("id_cong_van_den = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("id_chi_tiet_hscv DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(idCongVanDen);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlChiTietHSCV);

            PmlChiTietHSCV[] array = new PmlChiTietHSCVImpl[3];

            array[0] = (PmlChiTietHSCV) objArray[0];
            array[1] = (PmlChiTietHSCV) objArray[1];
            array[2] = (PmlChiTietHSCV) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlChiTietHSCV> findByIdCongVanDi(long idCongVanDi)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "findByIdCongVanDi";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idCongVanDi) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_cong_van_di = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("id_chi_tiet_hscv DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idCongVanDi);

                List<PmlChiTietHSCV> list = q.list();

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
            return (List<PmlChiTietHSCV>) result;
        }
    }

    public List<PmlChiTietHSCV> findByIdCongVanDi(long idCongVanDi, int start,
        int end) throws SystemException {
        return findByIdCongVanDi(idCongVanDi, start, end, null);
    }

    public List<PmlChiTietHSCV> findByIdCongVanDi(long idCongVanDi, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "findByIdCongVanDi";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(idCongVanDi),
                
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_cong_van_di = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("id_chi_tiet_hscv DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idCongVanDi);

                List<PmlChiTietHSCV> list = (List<PmlChiTietHSCV>) QueryUtil.list(q,
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
            return (List<PmlChiTietHSCV>) result;
        }
    }

    public PmlChiTietHSCV findByIdCongVanDi_First(long idCongVanDi,
        OrderByComparator obc)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        List<PmlChiTietHSCV> list = findByIdCongVanDi(idCongVanDi, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlChiTietHSCV exists with the key {");

            msg.append("idCongVanDi=" + idCongVanDi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlChiTietHSCVException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlChiTietHSCV findByIdCongVanDi_Last(long idCongVanDi,
        OrderByComparator obc)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        int count = countByIdCongVanDi(idCongVanDi);

        List<PmlChiTietHSCV> list = findByIdCongVanDi(idCongVanDi, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlChiTietHSCV exists with the key {");

            msg.append("idCongVanDi=" + idCongVanDi);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlChiTietHSCVException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlChiTietHSCV[] findByIdCongVanDi_PrevAndNext(long idChiTietHSCV,
        long idCongVanDi, OrderByComparator obc)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        PmlChiTietHSCV pmlChiTietHSCV = findByPrimaryKey(idChiTietHSCV);

        int count = countByIdCongVanDi(idCongVanDi);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

            query.append("id_cong_van_di = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("id_chi_tiet_hscv DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(idCongVanDi);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlChiTietHSCV);

            PmlChiTietHSCV[] array = new PmlChiTietHSCVImpl[3];

            array[0] = (PmlChiTietHSCV) objArray[0];
            array[1] = (PmlChiTietHSCV) objArray[1];
            array[2] = (PmlChiTietHSCV) objArray[2];

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

    public List<PmlChiTietHSCV> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlChiTietHSCV> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlChiTietHSCV> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("id_chi_tiet_hscv DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlChiTietHSCV> list = (List<PmlChiTietHSCV>) QueryUtil.list(q,
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
            return (List<PmlChiTietHSCV>) result;
        }
    }

    public void removeByIdHoSoCongViec(long idHoSoCongViec)
        throws SystemException {
        for (PmlChiTietHSCV pmlChiTietHSCV : findByIdHoSoCongViec(
                idHoSoCongViec)) {
            remove(pmlChiTietHSCV);
        }
    }

    public void removeByH_DEN(long idHoSoCongViec, long idCongVanDen)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        PmlChiTietHSCV pmlChiTietHSCV = findByH_DEN(idHoSoCongViec, idCongVanDen);

        remove(pmlChiTietHSCV);
    }

    public void removeByH_DI(long idHoSoCongViec, long idCongVanDi)
        throws NoSuchPmlChiTietHSCVException, SystemException {
        PmlChiTietHSCV pmlChiTietHSCV = findByH_DI(idHoSoCongViec, idCongVanDi);

        remove(pmlChiTietHSCV);
    }

    public void removeByIdCongVanDen(long idCongVanDen)
        throws SystemException {
        for (PmlChiTietHSCV pmlChiTietHSCV : findByIdCongVanDen(idCongVanDen)) {
            remove(pmlChiTietHSCV);
        }
    }

    public void removeByIdCongVanDi(long idCongVanDi) throws SystemException {
        for (PmlChiTietHSCV pmlChiTietHSCV : findByIdCongVanDi(idCongVanDi)) {
            remove(pmlChiTietHSCV);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlChiTietHSCV pmlChiTietHSCV : findAll()) {
            remove(pmlChiTietHSCV);
        }
    }

    public int countByIdHoSoCongViec(long idHoSoCongViec)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "countByIdHoSoCongViec";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idHoSoCongViec) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_ho_so_cong_viec = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idHoSoCongViec);

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

    public int countByH_DEN(long idHoSoCongViec, long idCongVanDen)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "countByH_DEN";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(idHoSoCongViec), new Long(idCongVanDen)
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_ho_so_cong_viec = ?");

                query.append(" AND ");

                query.append("id_cong_van_den = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idHoSoCongViec);

                qPos.add(idCongVanDen);

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

    public int countByH_DI(long idHoSoCongViec, long idCongVanDi)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "countByH_DI";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(idHoSoCongViec), new Long(idCongVanDi)
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_ho_so_cong_viec = ?");

                query.append(" AND ");

                query.append("id_cong_van_di = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idHoSoCongViec);

                qPos.add(idCongVanDi);

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

    public int countByIdCongVanDen(long idCongVanDen) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "countByIdCongVanDen";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idCongVanDen) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_cong_van_den = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idCongVanDen);

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

    public int countByIdCongVanDi(long idCongVanDi) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
        String finderMethodName = "countByIdCongVanDi";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idCongVanDi) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV WHERE ");

                query.append("id_cong_van_di = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idCongVanDi);

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
        boolean finderClassNameCacheEnabled = PmlChiTietHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlChiTietHSCV.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV");

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
                        "value.object.listener.com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV")));

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
