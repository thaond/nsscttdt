package com.sgs.portlet.pml_trang_thai_hscv.service.persistence;

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

import com.sgs.portlet.pml_trang_thai_hscv.NoSuchPmlTrangThaiHSCVException;
import com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV;
import com.sgs.portlet.pml_trang_thai_hscv.model.impl.PmlTrangThaiHSCVImpl;
import com.sgs.portlet.pml_trang_thai_hscv.model.impl.PmlTrangThaiHSCVModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlTrangThaiHSCVPersistenceImpl extends BasePersistenceImpl
    implements PmlTrangThaiHSCVPersistence {
    private static Log _log = LogFactory.getLog(PmlTrangThaiHSCVPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlTrangThaiHSCV create(long idTrangThaiHSCV) {
        PmlTrangThaiHSCV pmlTrangThaiHSCV = new PmlTrangThaiHSCVImpl();

        pmlTrangThaiHSCV.setNew(true);
        pmlTrangThaiHSCV.setPrimaryKey(idTrangThaiHSCV);

        return pmlTrangThaiHSCV;
    }

    public PmlTrangThaiHSCV remove(long idTrangThaiHSCV)
        throws NoSuchPmlTrangThaiHSCVException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlTrangThaiHSCV pmlTrangThaiHSCV = (PmlTrangThaiHSCV) session.get(PmlTrangThaiHSCVImpl.class,
                    new Long(idTrangThaiHSCV));

            if (pmlTrangThaiHSCV == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlTrangThaiHSCV exists with the primary key " +
                        idTrangThaiHSCV);
                }

                throw new NoSuchPmlTrangThaiHSCVException(
                    "No PmlTrangThaiHSCV exists with the primary key " +
                    idTrangThaiHSCV);
            }

            return remove(pmlTrangThaiHSCV);
        } catch (NoSuchPmlTrangThaiHSCVException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlTrangThaiHSCV remove(PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlTrangThaiHSCV);
            }
        }

        pmlTrangThaiHSCV = removeImpl(pmlTrangThaiHSCV);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlTrangThaiHSCV);
            }
        }

        return pmlTrangThaiHSCV;
    }

    protected PmlTrangThaiHSCV removeImpl(PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlTrangThaiHSCV);

            session.flush();

            return pmlTrangThaiHSCV;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlTrangThaiHSCV.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlTrangThaiHSCV pmlTrangThaiHSCV, boolean merge)</code>.
     */
    public PmlTrangThaiHSCV update(PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlTrangThaiHSCV pmlTrangThaiHSCV) method. Use update(PmlTrangThaiHSCV pmlTrangThaiHSCV, boolean merge) instead.");
        }

        return update(pmlTrangThaiHSCV, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTrangThaiHSCV the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTrangThaiHSCV is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlTrangThaiHSCV update(PmlTrangThaiHSCV pmlTrangThaiHSCV,
        boolean merge) throws SystemException {
        boolean isNew = pmlTrangThaiHSCV.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlTrangThaiHSCV);
                } else {
                    listener.onBeforeUpdate(pmlTrangThaiHSCV);
                }
            }
        }

        pmlTrangThaiHSCV = updateImpl(pmlTrangThaiHSCV, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlTrangThaiHSCV);
                } else {
                    listener.onAfterUpdate(pmlTrangThaiHSCV);
                }
            }
        }

        return pmlTrangThaiHSCV;
    }

    public PmlTrangThaiHSCV updateImpl(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlTrangThaiHSCV);
            } else {
                if (pmlTrangThaiHSCV.isNew()) {
                    session.save(pmlTrangThaiHSCV);
                }
            }

            session.flush();

            pmlTrangThaiHSCV.setNew(false);

            return pmlTrangThaiHSCV;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlTrangThaiHSCV.class.getName());
        }
    }

    public PmlTrangThaiHSCV findByPrimaryKey(long idTrangThaiHSCV)
        throws NoSuchPmlTrangThaiHSCVException, SystemException {
        PmlTrangThaiHSCV pmlTrangThaiHSCV = fetchByPrimaryKey(idTrangThaiHSCV);

        if (pmlTrangThaiHSCV == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlTrangThaiHSCV exists with the primary key " +
                    idTrangThaiHSCV);
            }

            throw new NoSuchPmlTrangThaiHSCVException(
                "No PmlTrangThaiHSCV exists with the primary key " +
                idTrangThaiHSCV);
        }

        return pmlTrangThaiHSCV;
    }

    public PmlTrangThaiHSCV fetchByPrimaryKey(long idTrangThaiHSCV)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlTrangThaiHSCV) session.get(PmlTrangThaiHSCVImpl.class,
                new Long(idTrangThaiHSCV));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTrangThaiHSCV> findByTenTrangThaiHSCV(
        String tenTrangThaiHSCV) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTrangThaiHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTrangThaiHSCV.class.getName();
        String finderMethodName = "findByTenTrangThaiHSCV";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { tenTrangThaiHSCV };

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
                    "FROM com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV WHERE ");

                if (tenTrangThaiHSCV == null) {
                    query.append("ten_trang_thai_hscv LIKE null");
                } else {
                    query.append("ten_trang_thai_hscv LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ten_trang_thai_hscv ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (tenTrangThaiHSCV != null) {
                    qPos.add(tenTrangThaiHSCV);
                }

                List<PmlTrangThaiHSCV> list = q.list();

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
            return (List<PmlTrangThaiHSCV>) result;
        }
    }

    public List<PmlTrangThaiHSCV> findByTenTrangThaiHSCV(
        String tenTrangThaiHSCV, int start, int end) throws SystemException {
        return findByTenTrangThaiHSCV(tenTrangThaiHSCV, start, end, null);
    }

    public List<PmlTrangThaiHSCV> findByTenTrangThaiHSCV(
        String tenTrangThaiHSCV, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTrangThaiHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTrangThaiHSCV.class.getName();
        String finderMethodName = "findByTenTrangThaiHSCV";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                tenTrangThaiHSCV,
                
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
                    "FROM com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV WHERE ");

                if (tenTrangThaiHSCV == null) {
                    query.append("ten_trang_thai_hscv LIKE null");
                } else {
                    query.append("ten_trang_thai_hscv LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_trang_thai_hscv ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (tenTrangThaiHSCV != null) {
                    qPos.add(tenTrangThaiHSCV);
                }

                List<PmlTrangThaiHSCV> list = (List<PmlTrangThaiHSCV>) QueryUtil.list(q,
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
            return (List<PmlTrangThaiHSCV>) result;
        }
    }

    public PmlTrangThaiHSCV findByTenTrangThaiHSCV_First(
        String tenTrangThaiHSCV, OrderByComparator obc)
        throws NoSuchPmlTrangThaiHSCVException, SystemException {
        List<PmlTrangThaiHSCV> list = findByTenTrangThaiHSCV(tenTrangThaiHSCV,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTrangThaiHSCV exists with the key {");

            msg.append("tenTrangThaiHSCV=" + tenTrangThaiHSCV);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTrangThaiHSCVException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTrangThaiHSCV findByTenTrangThaiHSCV_Last(
        String tenTrangThaiHSCV, OrderByComparator obc)
        throws NoSuchPmlTrangThaiHSCVException, SystemException {
        int count = countByTenTrangThaiHSCV(tenTrangThaiHSCV);

        List<PmlTrangThaiHSCV> list = findByTenTrangThaiHSCV(tenTrangThaiHSCV,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTrangThaiHSCV exists with the key {");

            msg.append("tenTrangThaiHSCV=" + tenTrangThaiHSCV);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTrangThaiHSCVException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTrangThaiHSCV[] findByTenTrangThaiHSCV_PrevAndNext(
        long idTrangThaiHSCV, String tenTrangThaiHSCV, OrderByComparator obc)
        throws NoSuchPmlTrangThaiHSCVException, SystemException {
        PmlTrangThaiHSCV pmlTrangThaiHSCV = findByPrimaryKey(idTrangThaiHSCV);

        int count = countByTenTrangThaiHSCV(tenTrangThaiHSCV);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV WHERE ");

            if (tenTrangThaiHSCV == null) {
                query.append("ten_trang_thai_hscv LIKE null");
            } else {
                query.append("ten_trang_thai_hscv LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ten_trang_thai_hscv ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (tenTrangThaiHSCV != null) {
                qPos.add(tenTrangThaiHSCV);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTrangThaiHSCV);

            PmlTrangThaiHSCV[] array = new PmlTrangThaiHSCVImpl[3];

            array[0] = (PmlTrangThaiHSCV) objArray[0];
            array[1] = (PmlTrangThaiHSCV) objArray[1];
            array[2] = (PmlTrangThaiHSCV) objArray[2];

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

    public List<PmlTrangThaiHSCV> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlTrangThaiHSCV> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlTrangThaiHSCV> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTrangThaiHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTrangThaiHSCV.class.getName();
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
                    "FROM com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_trang_thai_hscv ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlTrangThaiHSCV> list = (List<PmlTrangThaiHSCV>) QueryUtil.list(q,
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
            return (List<PmlTrangThaiHSCV>) result;
        }
    }

    public void removeByTenTrangThaiHSCV(String tenTrangThaiHSCV)
        throws SystemException {
        for (PmlTrangThaiHSCV pmlTrangThaiHSCV : findByTenTrangThaiHSCV(
                tenTrangThaiHSCV)) {
            remove(pmlTrangThaiHSCV);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlTrangThaiHSCV pmlTrangThaiHSCV : findAll()) {
            remove(pmlTrangThaiHSCV);
        }
    }

    public int countByTenTrangThaiHSCV(String tenTrangThaiHSCV)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTrangThaiHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTrangThaiHSCV.class.getName();
        String finderMethodName = "countByTenTrangThaiHSCV";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { tenTrangThaiHSCV };

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
                    "FROM com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV WHERE ");

                if (tenTrangThaiHSCV == null) {
                    query.append("ten_trang_thai_hscv LIKE null");
                } else {
                    query.append("ten_trang_thai_hscv LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (tenTrangThaiHSCV != null) {
                    qPos.add(tenTrangThaiHSCV);
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
        boolean finderClassNameCacheEnabled = PmlTrangThaiHSCVModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTrangThaiHSCV.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV");

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
                        "value.object.listener.com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV")));

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
