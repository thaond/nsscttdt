package com.sgs.portlet.document.service.persistence;

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

import com.sgs.portlet.document.NoSuchPmlStateDepartmentException;
import com.sgs.portlet.document.model.PmlStateDepartment;
import com.sgs.portlet.document.model.impl.PmlStateDepartmentImpl;
import com.sgs.portlet.document.model.impl.PmlStateDepartmentModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlStateDepartmentPersistenceImpl extends BasePersistenceImpl
    implements PmlStateDepartmentPersistence {
    private static Log _log = LogFactory.getLog(PmlStateDepartmentPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlStateDepartment create(PmlStateDepartmentPK pmlStateDepartmentPK) {
        PmlStateDepartment pmlStateDepartment = new PmlStateDepartmentImpl();

        pmlStateDepartment.setNew(true);
        pmlStateDepartment.setPrimaryKey(pmlStateDepartmentPK);

        return pmlStateDepartment;
    }

    public PmlStateDepartment remove(PmlStateDepartmentPK pmlStateDepartmentPK)
        throws NoSuchPmlStateDepartmentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlStateDepartment pmlStateDepartment = (PmlStateDepartment) session.get(PmlStateDepartmentImpl.class,
                    pmlStateDepartmentPK);

            if (pmlStateDepartment == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlStateDepartment exists with the primary key " +
                        pmlStateDepartmentPK);
                }

                throw new NoSuchPmlStateDepartmentException(
                    "No PmlStateDepartment exists with the primary key " +
                    pmlStateDepartmentPK);
            }

            return remove(pmlStateDepartment);
        } catch (NoSuchPmlStateDepartmentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlStateDepartment remove(PmlStateDepartment pmlStateDepartment)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlStateDepartment);
            }
        }

        pmlStateDepartment = removeImpl(pmlStateDepartment);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlStateDepartment);
            }
        }

        return pmlStateDepartment;
    }

    protected PmlStateDepartment removeImpl(
        PmlStateDepartment pmlStateDepartment) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlStateDepartment);

            session.flush();

            return pmlStateDepartment;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlStateDepartment.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlStateDepartment pmlStateDepartment, boolean merge)</code>.
     */
    public PmlStateDepartment update(PmlStateDepartment pmlStateDepartment)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlStateDepartment pmlStateDepartment) method. Use update(PmlStateDepartment pmlStateDepartment, boolean merge) instead.");
        }

        return update(pmlStateDepartment, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlStateDepartment the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlStateDepartment is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlStateDepartment update(PmlStateDepartment pmlStateDepartment,
        boolean merge) throws SystemException {
        boolean isNew = pmlStateDepartment.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlStateDepartment);
                } else {
                    listener.onBeforeUpdate(pmlStateDepartment);
                }
            }
        }

        pmlStateDepartment = updateImpl(pmlStateDepartment, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlStateDepartment);
                } else {
                    listener.onAfterUpdate(pmlStateDepartment);
                }
            }
        }

        return pmlStateDepartment;
    }

    public PmlStateDepartment updateImpl(
        com.sgs.portlet.document.model.PmlStateDepartment pmlStateDepartment,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlStateDepartment);
            } else {
                if (pmlStateDepartment.isNew()) {
                    session.save(pmlStateDepartment);
                }
            }

            session.flush();

            pmlStateDepartment.setNew(false);

            return pmlStateDepartment;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlStateDepartment.class.getName());
        }
    }

    public PmlStateDepartment findByPrimaryKey(
        PmlStateDepartmentPK pmlStateDepartmentPK)
        throws NoSuchPmlStateDepartmentException, SystemException {
        PmlStateDepartment pmlStateDepartment = fetchByPrimaryKey(pmlStateDepartmentPK);

        if (pmlStateDepartment == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlStateDepartment exists with the primary key " +
                    pmlStateDepartmentPK);
            }

            throw new NoSuchPmlStateDepartmentException(
                "No PmlStateDepartment exists with the primary key " +
                pmlStateDepartmentPK);
        }

        return pmlStateDepartment;
    }

    public PmlStateDepartment fetchByPrimaryKey(
        PmlStateDepartmentPK pmlStateDepartmentPK) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlStateDepartment) session.get(PmlStateDepartmentImpl.class,
                pmlStateDepartmentPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateDepartment> findByDepartmentId(String departmentId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateDepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateDepartment.class.getName();
        String finderMethodName = "findByDepartmentId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentId };

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
                    "FROM com.sgs.portlet.document.model.PmlStateDepartment WHERE ");

                if (departmentId == null) {
                    query.append("departmentid IS NULL");
                } else {
                    query.append("departmentid = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentId != null) {
                    qPos.add(departmentId);
                }

                List<PmlStateDepartment> list = q.list();

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
            return (List<PmlStateDepartment>) result;
        }
    }

    public List<PmlStateDepartment> findByDepartmentId(String departmentId,
        int start, int end) throws SystemException {
        return findByDepartmentId(departmentId, start, end, null);
    }

    public List<PmlStateDepartment> findByDepartmentId(String departmentId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateDepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateDepartment.class.getName();
        String finderMethodName = "findByDepartmentId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentId,
                
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
                    "FROM com.sgs.portlet.document.model.PmlStateDepartment WHERE ");

                if (departmentId == null) {
                    query.append("departmentid IS NULL");
                } else {
                    query.append("departmentid = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentId != null) {
                    qPos.add(departmentId);
                }

                List<PmlStateDepartment> list = (List<PmlStateDepartment>) QueryUtil.list(q,
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
            return (List<PmlStateDepartment>) result;
        }
    }

    public PmlStateDepartment findByDepartmentId_First(String departmentId,
        OrderByComparator obc)
        throws NoSuchPmlStateDepartmentException, SystemException {
        List<PmlStateDepartment> list = findByDepartmentId(departmentId, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateDepartment exists with the key {");

            msg.append("departmentId=" + departmentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateDepartment findByDepartmentId_Last(String departmentId,
        OrderByComparator obc)
        throws NoSuchPmlStateDepartmentException, SystemException {
        int count = countByDepartmentId(departmentId);

        List<PmlStateDepartment> list = findByDepartmentId(departmentId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateDepartment exists with the key {");

            msg.append("departmentId=" + departmentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateDepartment[] findByDepartmentId_PrevAndNext(
        PmlStateDepartmentPK pmlStateDepartmentPK, String departmentId,
        OrderByComparator obc)
        throws NoSuchPmlStateDepartmentException, SystemException {
        PmlStateDepartment pmlStateDepartment = findByPrimaryKey(pmlStateDepartmentPK);

        int count = countByDepartmentId(departmentId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlStateDepartment WHERE ");

            if (departmentId == null) {
                query.append("departmentid IS NULL");
            } else {
                query.append("departmentid = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentId != null) {
                qPos.add(departmentId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateDepartment);

            PmlStateDepartment[] array = new PmlStateDepartmentImpl[3];

            array[0] = (PmlStateDepartment) objArray[0];
            array[1] = (PmlStateDepartment) objArray[1];
            array[2] = (PmlStateDepartment) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateDepartment> findByStateWfId(long stateWfId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateDepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateDepartment.class.getName();
        String finderMethodName = "findByStateWfId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateWfId) };

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
                    "FROM com.sgs.portlet.document.model.PmlStateDepartment WHERE ");

                query.append("statewfid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateWfId);

                List<PmlStateDepartment> list = q.list();

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
            return (List<PmlStateDepartment>) result;
        }
    }

    public List<PmlStateDepartment> findByStateWfId(long stateWfId, int start,
        int end) throws SystemException {
        return findByStateWfId(stateWfId, start, end, null);
    }

    public List<PmlStateDepartment> findByStateWfId(long stateWfId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateDepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateDepartment.class.getName();
        String finderMethodName = "findByStateWfId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(stateWfId),
                
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
                    "FROM com.sgs.portlet.document.model.PmlStateDepartment WHERE ");

                query.append("statewfid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateWfId);

                List<PmlStateDepartment> list = (List<PmlStateDepartment>) QueryUtil.list(q,
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
            return (List<PmlStateDepartment>) result;
        }
    }

    public PmlStateDepartment findByStateWfId_First(long stateWfId,
        OrderByComparator obc)
        throws NoSuchPmlStateDepartmentException, SystemException {
        List<PmlStateDepartment> list = findByStateWfId(stateWfId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateDepartment exists with the key {");

            msg.append("stateWfId=" + stateWfId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateDepartment findByStateWfId_Last(long stateWfId,
        OrderByComparator obc)
        throws NoSuchPmlStateDepartmentException, SystemException {
        int count = countByStateWfId(stateWfId);

        List<PmlStateDepartment> list = findByStateWfId(stateWfId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateDepartment exists with the key {");

            msg.append("stateWfId=" + stateWfId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateDepartmentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateDepartment[] findByStateWfId_PrevAndNext(
        PmlStateDepartmentPK pmlStateDepartmentPK, long stateWfId,
        OrderByComparator obc)
        throws NoSuchPmlStateDepartmentException, SystemException {
        PmlStateDepartment pmlStateDepartment = findByPrimaryKey(pmlStateDepartmentPK);

        int count = countByStateWfId(stateWfId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlStateDepartment WHERE ");

            query.append("statewfid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateWfId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateDepartment);

            PmlStateDepartment[] array = new PmlStateDepartmentImpl[3];

            array[0] = (PmlStateDepartment) objArray[0];
            array[1] = (PmlStateDepartment) objArray[1];
            array[2] = (PmlStateDepartment) objArray[2];

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

    public List<PmlStateDepartment> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlStateDepartment> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlStateDepartment> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateDepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateDepartment.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlStateDepartment ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlStateDepartment> list = (List<PmlStateDepartment>) QueryUtil.list(q,
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
            return (List<PmlStateDepartment>) result;
        }
    }

    public void removeByDepartmentId(String departmentId)
        throws SystemException {
        for (PmlStateDepartment pmlStateDepartment : findByDepartmentId(
                departmentId)) {
            remove(pmlStateDepartment);
        }
    }

    public void removeByStateWfId(long stateWfId) throws SystemException {
        for (PmlStateDepartment pmlStateDepartment : findByStateWfId(stateWfId)) {
            remove(pmlStateDepartment);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlStateDepartment pmlStateDepartment : findAll()) {
            remove(pmlStateDepartment);
        }
    }

    public int countByDepartmentId(String departmentId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateDepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateDepartment.class.getName();
        String finderMethodName = "countByDepartmentId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentId };

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
                    "FROM com.sgs.portlet.document.model.PmlStateDepartment WHERE ");

                if (departmentId == null) {
                    query.append("departmentid IS NULL");
                } else {
                    query.append("departmentid = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentId != null) {
                    qPos.add(departmentId);
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

    public int countByStateWfId(long stateWfId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateDepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateDepartment.class.getName();
        String finderMethodName = "countByStateWfId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateWfId) };

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
                    "FROM com.sgs.portlet.document.model.PmlStateDepartment WHERE ");

                query.append("statewfid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateWfId);

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
        boolean finderClassNameCacheEnabled = PmlStateDepartmentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateDepartment.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.model.PmlStateDepartment");

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
                        "value.object.listener.com.sgs.portlet.document.model.PmlStateDepartment")));

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
