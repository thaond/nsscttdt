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

import com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlHoSoCongViecImpl;
import com.sgs.portlet.pml_ho_so_cong_viec.model.impl.PmlHoSoCongViecModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlHoSoCongViecPersistenceImpl extends BasePersistenceImpl
    implements PmlHoSoCongViecPersistence {
    private static Log _log = LogFactory.getLog(PmlHoSoCongViecPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlHoSoCongViec create(long idHoSoCongViec) {
        PmlHoSoCongViec pmlHoSoCongViec = new PmlHoSoCongViecImpl();

        pmlHoSoCongViec.setNew(true);
        pmlHoSoCongViec.setPrimaryKey(idHoSoCongViec);

        return pmlHoSoCongViec;
    }

    public PmlHoSoCongViec remove(long idHoSoCongViec)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlHoSoCongViec pmlHoSoCongViec = (PmlHoSoCongViec) session.get(PmlHoSoCongViecImpl.class,
                    new Long(idHoSoCongViec));

            if (pmlHoSoCongViec == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlHoSoCongViec exists with the primary key " +
                        idHoSoCongViec);
                }

                throw new NoSuchPmlHoSoCongViecException(
                    "No PmlHoSoCongViec exists with the primary key " +
                    idHoSoCongViec);
            }

            return remove(pmlHoSoCongViec);
        } catch (NoSuchPmlHoSoCongViecException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlHoSoCongViec remove(PmlHoSoCongViec pmlHoSoCongViec)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlHoSoCongViec);
            }
        }

        pmlHoSoCongViec = removeImpl(pmlHoSoCongViec);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlHoSoCongViec);
            }
        }

        return pmlHoSoCongViec;
    }

    protected PmlHoSoCongViec removeImpl(PmlHoSoCongViec pmlHoSoCongViec)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlHoSoCongViec);

            session.flush();

            return pmlHoSoCongViec;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlHoSoCongViec.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlHoSoCongViec pmlHoSoCongViec, boolean merge)</code>.
     */
    public PmlHoSoCongViec update(PmlHoSoCongViec pmlHoSoCongViec)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlHoSoCongViec pmlHoSoCongViec) method. Use update(PmlHoSoCongViec pmlHoSoCongViec, boolean merge) instead.");
        }

        return update(pmlHoSoCongViec, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlHoSoCongViec the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlHoSoCongViec is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlHoSoCongViec update(PmlHoSoCongViec pmlHoSoCongViec, boolean merge)
        throws SystemException {
        boolean isNew = pmlHoSoCongViec.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlHoSoCongViec);
                } else {
                    listener.onBeforeUpdate(pmlHoSoCongViec);
                }
            }
        }

        pmlHoSoCongViec = updateImpl(pmlHoSoCongViec, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlHoSoCongViec);
                } else {
                    listener.onAfterUpdate(pmlHoSoCongViec);
                }
            }
        }

        return pmlHoSoCongViec;
    }

    public PmlHoSoCongViec updateImpl(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlHoSoCongViec);
            } else {
                if (pmlHoSoCongViec.isNew()) {
                    session.save(pmlHoSoCongViec);
                }
            }

            session.flush();

            pmlHoSoCongViec.setNew(false);

            return pmlHoSoCongViec;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlHoSoCongViec.class.getName());
        }
    }

    public PmlHoSoCongViec findByPrimaryKey(long idHoSoCongViec)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        PmlHoSoCongViec pmlHoSoCongViec = fetchByPrimaryKey(idHoSoCongViec);

        if (pmlHoSoCongViec == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlHoSoCongViec exists with the primary key " +
                    idHoSoCongViec);
            }

            throw new NoSuchPmlHoSoCongViecException(
                "No PmlHoSoCongViec exists with the primary key " +
                idHoSoCongViec);
        }

        return pmlHoSoCongViec;
    }

    public PmlHoSoCongViec fetchByPrimaryKey(long idHoSoCongViec)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlHoSoCongViec) session.get(PmlHoSoCongViecImpl.class,
                new Long(idHoSoCongViec));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoSoCongViec> findByIdHSCVCha(long idHSCVCha)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByIdHSCVCha";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idHSCVCha) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("id_hscv_cha = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tieu_de ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idHSCVCha);

                List<PmlHoSoCongViec> list = q.list();

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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public List<PmlHoSoCongViec> findByIdHSCVCha(long idHSCVCha, int start,
        int end) throws SystemException {
        return findByIdHSCVCha(idHSCVCha, start, end, null);
    }

    public List<PmlHoSoCongViec> findByIdHSCVCha(long idHSCVCha, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByIdHSCVCha";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(idHSCVCha),
                
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("id_hscv_cha = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tieu_de ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idHSCVCha);

                List<PmlHoSoCongViec> list = (List<PmlHoSoCongViec>) QueryUtil.list(q,
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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public PmlHoSoCongViec findByIdHSCVCha_First(long idHSCVCha,
        OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        List<PmlHoSoCongViec> list = findByIdHSCVCha(idHSCVCha, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("idHSCVCha=" + idHSCVCha);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec findByIdHSCVCha_Last(long idHSCVCha,
        OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        int count = countByIdHSCVCha(idHSCVCha);

        List<PmlHoSoCongViec> list = findByIdHSCVCha(idHSCVCha, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("idHSCVCha=" + idHSCVCha);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec[] findByIdHSCVCha_PrevAndNext(long idHoSoCongViec,
        long idHSCVCha, OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        PmlHoSoCongViec pmlHoSoCongViec = findByPrimaryKey(idHoSoCongViec);

        int count = countByIdHSCVCha(idHSCVCha);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

            query.append("id_hscv_cha = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tieu_de ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(idHSCVCha);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoSoCongViec);

            PmlHoSoCongViec[] array = new PmlHoSoCongViecImpl[3];

            array[0] = (PmlHoSoCongViec) objArray[0];
            array[1] = (PmlHoSoCongViec) objArray[1];
            array[2] = (PmlHoSoCongViec) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoSoCongViec> findBySoHieuHSCV(String soHieuHSCV)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findBySoHieuHSCV";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { soHieuHSCV };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                if (soHieuHSCV == null) {
                    query.append("so_hieu_hscv IS NULL");
                } else {
                    query.append("so_hieu_hscv = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tieu_de ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (soHieuHSCV != null) {
                    qPos.add(soHieuHSCV);
                }

                List<PmlHoSoCongViec> list = q.list();

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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public List<PmlHoSoCongViec> findBySoHieuHSCV(String soHieuHSCV, int start,
        int end) throws SystemException {
        return findBySoHieuHSCV(soHieuHSCV, start, end, null);
    }

    public List<PmlHoSoCongViec> findBySoHieuHSCV(String soHieuHSCV, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findBySoHieuHSCV";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                soHieuHSCV,
                
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                if (soHieuHSCV == null) {
                    query.append("so_hieu_hscv IS NULL");
                } else {
                    query.append("so_hieu_hscv = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tieu_de ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (soHieuHSCV != null) {
                    qPos.add(soHieuHSCV);
                }

                List<PmlHoSoCongViec> list = (List<PmlHoSoCongViec>) QueryUtil.list(q,
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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public PmlHoSoCongViec findBySoHieuHSCV_First(String soHieuHSCV,
        OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        List<PmlHoSoCongViec> list = findBySoHieuHSCV(soHieuHSCV, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("soHieuHSCV=" + soHieuHSCV);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec findBySoHieuHSCV_Last(String soHieuHSCV,
        OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        int count = countBySoHieuHSCV(soHieuHSCV);

        List<PmlHoSoCongViec> list = findBySoHieuHSCV(soHieuHSCV, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("soHieuHSCV=" + soHieuHSCV);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec[] findBySoHieuHSCV_PrevAndNext(long idHoSoCongViec,
        String soHieuHSCV, OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        PmlHoSoCongViec pmlHoSoCongViec = findByPrimaryKey(idHoSoCongViec);

        int count = countBySoHieuHSCV(soHieuHSCV);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

            if (soHieuHSCV == null) {
                query.append("so_hieu_hscv IS NULL");
            } else {
                query.append("so_hieu_hscv = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tieu_de ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (soHieuHSCV != null) {
                qPos.add(soHieuHSCV);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoSoCongViec);

            PmlHoSoCongViec[] array = new PmlHoSoCongViecImpl[3];

            array[0] = (PmlHoSoCongViec) objArray[0];
            array[1] = (PmlHoSoCongViec) objArray[1];
            array[2] = (PmlHoSoCongViec) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoSoCongViec> findByIdDoQuanTrong(long idDoQuanTrong)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByIdDoQuanTrong";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idDoQuanTrong) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("id_do_quan_trong = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tieu_de ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idDoQuanTrong);

                List<PmlHoSoCongViec> list = q.list();

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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public List<PmlHoSoCongViec> findByIdDoQuanTrong(long idDoQuanTrong,
        int start, int end) throws SystemException {
        return findByIdDoQuanTrong(idDoQuanTrong, start, end, null);
    }

    public List<PmlHoSoCongViec> findByIdDoQuanTrong(long idDoQuanTrong,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByIdDoQuanTrong";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(idDoQuanTrong),
                
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("id_do_quan_trong = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tieu_de ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idDoQuanTrong);

                List<PmlHoSoCongViec> list = (List<PmlHoSoCongViec>) QueryUtil.list(q,
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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public PmlHoSoCongViec findByIdDoQuanTrong_First(long idDoQuanTrong,
        OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        List<PmlHoSoCongViec> list = findByIdDoQuanTrong(idDoQuanTrong, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("idDoQuanTrong=" + idDoQuanTrong);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec findByIdDoQuanTrong_Last(long idDoQuanTrong,
        OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        int count = countByIdDoQuanTrong(idDoQuanTrong);

        List<PmlHoSoCongViec> list = findByIdDoQuanTrong(idDoQuanTrong,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("idDoQuanTrong=" + idDoQuanTrong);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec[] findByIdDoQuanTrong_PrevAndNext(
        long idHoSoCongViec, long idDoQuanTrong, OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        PmlHoSoCongViec pmlHoSoCongViec = findByPrimaryKey(idHoSoCongViec);

        int count = countByIdDoQuanTrong(idDoQuanTrong);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

            query.append("id_do_quan_trong = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tieu_de ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(idDoQuanTrong);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoSoCongViec);

            PmlHoSoCongViec[] array = new PmlHoSoCongViecImpl[3];

            array[0] = (PmlHoSoCongViec) objArray[0];
            array[1] = (PmlHoSoCongViec) objArray[1];
            array[2] = (PmlHoSoCongViec) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoSoCongViec> findByIdTinhChat(long idTinhChat)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByIdTinhChat";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idTinhChat) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("id_tinh_chat = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tieu_de ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idTinhChat);

                List<PmlHoSoCongViec> list = q.list();

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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public List<PmlHoSoCongViec> findByIdTinhChat(long idTinhChat, int start,
        int end) throws SystemException {
        return findByIdTinhChat(idTinhChat, start, end, null);
    }

    public List<PmlHoSoCongViec> findByIdTinhChat(long idTinhChat, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByIdTinhChat";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(idTinhChat),
                
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("id_tinh_chat = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tieu_de ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idTinhChat);

                List<PmlHoSoCongViec> list = (List<PmlHoSoCongViec>) QueryUtil.list(q,
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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public PmlHoSoCongViec findByIdTinhChat_First(long idTinhChat,
        OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        List<PmlHoSoCongViec> list = findByIdTinhChat(idTinhChat, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("idTinhChat=" + idTinhChat);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec findByIdTinhChat_Last(long idTinhChat,
        OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        int count = countByIdTinhChat(idTinhChat);

        List<PmlHoSoCongViec> list = findByIdTinhChat(idTinhChat, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("idTinhChat=" + idTinhChat);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec[] findByIdTinhChat_PrevAndNext(long idHoSoCongViec,
        long idTinhChat, OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        PmlHoSoCongViec pmlHoSoCongViec = findByPrimaryKey(idHoSoCongViec);

        int count = countByIdTinhChat(idTinhChat);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

            query.append("id_tinh_chat = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tieu_de ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(idTinhChat);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoSoCongViec);

            PmlHoSoCongViec[] array = new PmlHoSoCongViecImpl[3];

            array[0] = (PmlHoSoCongViec) objArray[0];
            array[1] = (PmlHoSoCongViec) objArray[1];
            array[2] = (PmlHoSoCongViec) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoSoCongViec> findByIdTrangThaiHSCV(long idTrangThaiHSCV)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByIdTrangThaiHSCV";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idTrangThaiHSCV) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("id_trang_thai_hscv = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tieu_de ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idTrangThaiHSCV);

                List<PmlHoSoCongViec> list = q.list();

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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public List<PmlHoSoCongViec> findByIdTrangThaiHSCV(long idTrangThaiHSCV,
        int start, int end) throws SystemException {
        return findByIdTrangThaiHSCV(idTrangThaiHSCV, start, end, null);
    }

    public List<PmlHoSoCongViec> findByIdTrangThaiHSCV(long idTrangThaiHSCV,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByIdTrangThaiHSCV";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(idTrangThaiHSCV),
                
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("id_trang_thai_hscv = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tieu_de ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idTrangThaiHSCV);

                List<PmlHoSoCongViec> list = (List<PmlHoSoCongViec>) QueryUtil.list(q,
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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public PmlHoSoCongViec findByIdTrangThaiHSCV_First(long idTrangThaiHSCV,
        OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        List<PmlHoSoCongViec> list = findByIdTrangThaiHSCV(idTrangThaiHSCV, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("idTrangThaiHSCV=" + idTrangThaiHSCV);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec findByIdTrangThaiHSCV_Last(long idTrangThaiHSCV,
        OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        int count = countByIdTrangThaiHSCV(idTrangThaiHSCV);

        List<PmlHoSoCongViec> list = findByIdTrangThaiHSCV(idTrangThaiHSCV,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("idTrangThaiHSCV=" + idTrangThaiHSCV);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec[] findByIdTrangThaiHSCV_PrevAndNext(
        long idHoSoCongViec, long idTrangThaiHSCV, OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        PmlHoSoCongViec pmlHoSoCongViec = findByPrimaryKey(idHoSoCongViec);

        int count = countByIdTrangThaiHSCV(idTrangThaiHSCV);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

            query.append("id_trang_thai_hscv = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tieu_de ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(idTrangThaiHSCV);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoSoCongViec);

            PmlHoSoCongViec[] array = new PmlHoSoCongViecImpl[3];

            array[0] = (PmlHoSoCongViec) objArray[0];
            array[1] = (PmlHoSoCongViec) objArray[1];
            array[2] = (PmlHoSoCongViec) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoSoCongViec> findByIdLinhVuc(String idLinhVuc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByIdLinhVuc";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { idLinhVuc };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                if (idLinhVuc == null) {
                    query.append("id_linh_vuc IS NULL");
                } else {
                    query.append("id_linh_vuc = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tieu_de ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (idLinhVuc != null) {
                    qPos.add(idLinhVuc);
                }

                List<PmlHoSoCongViec> list = q.list();

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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public List<PmlHoSoCongViec> findByIdLinhVuc(String idLinhVuc, int start,
        int end) throws SystemException {
        return findByIdLinhVuc(idLinhVuc, start, end, null);
    }

    public List<PmlHoSoCongViec> findByIdLinhVuc(String idLinhVuc, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByIdLinhVuc";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                idLinhVuc,
                
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                if (idLinhVuc == null) {
                    query.append("id_linh_vuc IS NULL");
                } else {
                    query.append("id_linh_vuc = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tieu_de ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (idLinhVuc != null) {
                    qPos.add(idLinhVuc);
                }

                List<PmlHoSoCongViec> list = (List<PmlHoSoCongViec>) QueryUtil.list(q,
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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public PmlHoSoCongViec findByIdLinhVuc_First(String idLinhVuc,
        OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        List<PmlHoSoCongViec> list = findByIdLinhVuc(idLinhVuc, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("idLinhVuc=" + idLinhVuc);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec findByIdLinhVuc_Last(String idLinhVuc,
        OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        int count = countByIdLinhVuc(idLinhVuc);

        List<PmlHoSoCongViec> list = findByIdLinhVuc(idLinhVuc, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("idLinhVuc=" + idLinhVuc);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec[] findByIdLinhVuc_PrevAndNext(long idHoSoCongViec,
        String idLinhVuc, OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        PmlHoSoCongViec pmlHoSoCongViec = findByPrimaryKey(idHoSoCongViec);

        int count = countByIdLinhVuc(idLinhVuc);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

            if (idLinhVuc == null) {
                query.append("id_linh_vuc IS NULL");
            } else {
                query.append("id_linh_vuc = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tieu_de ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (idLinhVuc != null) {
                qPos.add(idLinhVuc);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoSoCongViec);

            PmlHoSoCongViec[] array = new PmlHoSoCongViecImpl[3];

            array[0] = (PmlHoSoCongViec) objArray[0];
            array[1] = (PmlHoSoCongViec) objArray[1];
            array[2] = (PmlHoSoCongViec) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoSoCongViec> findByUserId(long userId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(userId) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("userId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tieu_de ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<PmlHoSoCongViec> list = q.list();

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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public List<PmlHoSoCongViec> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    public List<PmlHoSoCongViec> findByUserId(long userId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByUserId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(userId),
                
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("userId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tieu_de ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<PmlHoSoCongViec> list = (List<PmlHoSoCongViec>) QueryUtil.list(q,
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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public PmlHoSoCongViec findByUserId_First(long userId, OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        List<PmlHoSoCongViec> list = findByUserId(userId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec findByUserId_Last(long userId, OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        int count = countByUserId(userId);

        List<PmlHoSoCongViec> list = findByUserId(userId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec[] findByUserId_PrevAndNext(long idHoSoCongViec,
        long userId, OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        PmlHoSoCongViec pmlHoSoCongViec = findByPrimaryKey(idHoSoCongViec);

        int count = countByUserId(userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

            query.append("userId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tieu_de ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoSoCongViec);

            PmlHoSoCongViec[] array = new PmlHoSoCongViecImpl[3];

            array[0] = (PmlHoSoCongViec) objArray[0];
            array[1] = (PmlHoSoCongViec) objArray[1];
            array[2] = (PmlHoSoCongViec) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlHoSoCongViec> findByUserId_HoatDong(long userId,
        String hoatDong) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByUserId_HoatDong";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(userId), hoatDong };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                if (hoatDong == null) {
                    query.append("hoat_dong IS NULL");
                } else {
                    query.append("hoat_dong = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("tieu_de ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (hoatDong != null) {
                    qPos.add(hoatDong);
                }

                List<PmlHoSoCongViec> list = q.list();

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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public List<PmlHoSoCongViec> findByUserId_HoatDong(long userId,
        String hoatDong, int start, int end) throws SystemException {
        return findByUserId_HoatDong(userId, hoatDong, start, end, null);
    }

    public List<PmlHoSoCongViec> findByUserId_HoatDong(long userId,
        String hoatDong, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "findByUserId_HoatDong";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(userId),
                
                hoatDong,
                
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                if (hoatDong == null) {
                    query.append("hoat_dong IS NULL");
                } else {
                    query.append("hoat_dong = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tieu_de ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (hoatDong != null) {
                    qPos.add(hoatDong);
                }

                List<PmlHoSoCongViec> list = (List<PmlHoSoCongViec>) QueryUtil.list(q,
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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public PmlHoSoCongViec findByUserId_HoatDong_First(long userId,
        String hoatDong, OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        List<PmlHoSoCongViec> list = findByUserId_HoatDong(userId, hoatDong, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("hoatDong=" + hoatDong);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec findByUserId_HoatDong_Last(long userId,
        String hoatDong, OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        int count = countByUserId_HoatDong(userId, hoatDong);

        List<PmlHoSoCongViec> list = findByUserId_HoatDong(userId, hoatDong,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlHoSoCongViec exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("hoatDong=" + hoatDong);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlHoSoCongViecException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlHoSoCongViec[] findByUserId_HoatDong_PrevAndNext(
        long idHoSoCongViec, long userId, String hoatDong, OrderByComparator obc)
        throws NoSuchPmlHoSoCongViecException, SystemException {
        PmlHoSoCongViec pmlHoSoCongViec = findByPrimaryKey(idHoSoCongViec);

        int count = countByUserId_HoatDong(userId, hoatDong);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

            query.append("userId = ?");

            query.append(" AND ");

            if (hoatDong == null) {
                query.append("hoat_dong IS NULL");
            } else {
                query.append("hoat_dong = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("tieu_de ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            if (hoatDong != null) {
                qPos.add(hoatDong);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlHoSoCongViec);

            PmlHoSoCongViec[] array = new PmlHoSoCongViecImpl[3];

            array[0] = (PmlHoSoCongViec) objArray[0];
            array[1] = (PmlHoSoCongViec) objArray[1];
            array[2] = (PmlHoSoCongViec) objArray[2];

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

    public List<PmlHoSoCongViec> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlHoSoCongViec> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlHoSoCongViec> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("tieu_de ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlHoSoCongViec> list = (List<PmlHoSoCongViec>) QueryUtil.list(q,
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
            return (List<PmlHoSoCongViec>) result;
        }
    }

    public void removeByIdHSCVCha(long idHSCVCha) throws SystemException {
        for (PmlHoSoCongViec pmlHoSoCongViec : findByIdHSCVCha(idHSCVCha)) {
            remove(pmlHoSoCongViec);
        }
    }

    public void removeBySoHieuHSCV(String soHieuHSCV) throws SystemException {
        for (PmlHoSoCongViec pmlHoSoCongViec : findBySoHieuHSCV(soHieuHSCV)) {
            remove(pmlHoSoCongViec);
        }
    }

    public void removeByIdDoQuanTrong(long idDoQuanTrong)
        throws SystemException {
        for (PmlHoSoCongViec pmlHoSoCongViec : findByIdDoQuanTrong(
                idDoQuanTrong)) {
            remove(pmlHoSoCongViec);
        }
    }

    public void removeByIdTinhChat(long idTinhChat) throws SystemException {
        for (PmlHoSoCongViec pmlHoSoCongViec : findByIdTinhChat(idTinhChat)) {
            remove(pmlHoSoCongViec);
        }
    }

    public void removeByIdTrangThaiHSCV(long idTrangThaiHSCV)
        throws SystemException {
        for (PmlHoSoCongViec pmlHoSoCongViec : findByIdTrangThaiHSCV(
                idTrangThaiHSCV)) {
            remove(pmlHoSoCongViec);
        }
    }

    public void removeByIdLinhVuc(String idLinhVuc) throws SystemException {
        for (PmlHoSoCongViec pmlHoSoCongViec : findByIdLinhVuc(idLinhVuc)) {
            remove(pmlHoSoCongViec);
        }
    }

    public void removeByUserId(long userId) throws SystemException {
        for (PmlHoSoCongViec pmlHoSoCongViec : findByUserId(userId)) {
            remove(pmlHoSoCongViec);
        }
    }

    public void removeByUserId_HoatDong(long userId, String hoatDong)
        throws SystemException {
        for (PmlHoSoCongViec pmlHoSoCongViec : findByUserId_HoatDong(userId,
                hoatDong)) {
            remove(pmlHoSoCongViec);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlHoSoCongViec pmlHoSoCongViec : findAll()) {
            remove(pmlHoSoCongViec);
        }
    }

    public int countByIdHSCVCha(long idHSCVCha) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "countByIdHSCVCha";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idHSCVCha) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("id_hscv_cha = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idHSCVCha);

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

    public int countBySoHieuHSCV(String soHieuHSCV) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "countBySoHieuHSCV";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { soHieuHSCV };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                if (soHieuHSCV == null) {
                    query.append("so_hieu_hscv IS NULL");
                } else {
                    query.append("so_hieu_hscv = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (soHieuHSCV != null) {
                    qPos.add(soHieuHSCV);
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

    public int countByIdDoQuanTrong(long idDoQuanTrong)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "countByIdDoQuanTrong";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idDoQuanTrong) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("id_do_quan_trong = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idDoQuanTrong);

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

    public int countByIdTinhChat(long idTinhChat) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "countByIdTinhChat";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idTinhChat) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("id_tinh_chat = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idTinhChat);

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

    public int countByIdTrangThaiHSCV(long idTrangThaiHSCV)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "countByIdTrangThaiHSCV";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(idTrangThaiHSCV) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("id_trang_thai_hscv = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(idTrangThaiHSCV);

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

    public int countByIdLinhVuc(String idLinhVuc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "countByIdLinhVuc";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { idLinhVuc };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                if (idLinhVuc == null) {
                    query.append("id_linh_vuc IS NULL");
                } else {
                    query.append("id_linh_vuc = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (idLinhVuc != null) {
                    qPos.add(idLinhVuc);
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

    public int countByUserId(long userId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "countByUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(userId) };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("userId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

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

    public int countByUserId_HoatDong(long userId, String hoatDong)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
        String finderMethodName = "countByUserId_HoatDong";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(userId), hoatDong };

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
                    "FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                if (hoatDong == null) {
                    query.append("hoat_dong IS NULL");
                } else {
                    query.append("hoat_dong = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (hoatDong != null) {
                    qPos.add(hoatDong);
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
        boolean finderClassNameCacheEnabled = PmlHoSoCongViecModelImpl.CACHE_ENABLED;
        String finderClassName = PmlHoSoCongViec.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec");

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
                        "value.object.listener.com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec")));

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
