package com.sgs.portlet.document.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.document.NoSuchPmlProcessDisposeException;
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.model.impl.PmlProcessDisposeImpl;
import com.sgs.portlet.document.model.impl.PmlProcessDisposeModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlProcessDisposePersistenceImpl extends BasePersistenceImpl
    implements PmlProcessDisposePersistence {
    private static Log _log = LogFactory.getLog(PmlProcessDisposePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlProcessDispose create(long processDisposeId) {
        PmlProcessDispose pmlProcessDispose = new PmlProcessDisposeImpl();

        pmlProcessDispose.setNew(true);
        pmlProcessDispose.setPrimaryKey(processDisposeId);

        return pmlProcessDispose;
    }

    public PmlProcessDispose remove(long processDisposeId)
        throws NoSuchPmlProcessDisposeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlProcessDispose pmlProcessDispose = (PmlProcessDispose) session.get(PmlProcessDisposeImpl.class,
                    new Long(processDisposeId));

            if (pmlProcessDispose == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlProcessDispose exists with the primary key " +
                        processDisposeId);
                }

                throw new NoSuchPmlProcessDisposeException(
                    "No PmlProcessDispose exists with the primary key " +
                    processDisposeId);
            }

            return remove(pmlProcessDispose);
        } catch (NoSuchPmlProcessDisposeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlProcessDispose remove(PmlProcessDispose pmlProcessDispose)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlProcessDispose);
            }
        }

        pmlProcessDispose = removeImpl(pmlProcessDispose);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlProcessDispose);
            }
        }

        return pmlProcessDispose;
    }

    protected PmlProcessDispose removeImpl(PmlProcessDispose pmlProcessDispose)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlProcessDispose);

            session.flush();

            return pmlProcessDispose;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlProcessDispose.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlProcessDispose pmlProcessDispose, boolean merge)</code>.
     */
    public PmlProcessDispose update(PmlProcessDispose pmlProcessDispose)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlProcessDispose pmlProcessDispose) method. Use update(PmlProcessDispose pmlProcessDispose, boolean merge) instead.");
        }

        return update(pmlProcessDispose, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlProcessDispose the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlProcessDispose is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlProcessDispose update(PmlProcessDispose pmlProcessDispose,
        boolean merge) throws SystemException {
        boolean isNew = pmlProcessDispose.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlProcessDispose);
                } else {
                    listener.onBeforeUpdate(pmlProcessDispose);
                }
            }
        }

        pmlProcessDispose = updateImpl(pmlProcessDispose, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlProcessDispose);
                } else {
                    listener.onAfterUpdate(pmlProcessDispose);
                }
            }
        }

        return pmlProcessDispose;
    }

    public PmlProcessDispose updateImpl(
        com.sgs.portlet.document.model.PmlProcessDispose pmlProcessDispose,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlProcessDispose);
            } else {
                if (pmlProcessDispose.isNew()) {
                    session.save(pmlProcessDispose);
                }
            }

            session.flush();

            pmlProcessDispose.setNew(false);

            return pmlProcessDispose;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlProcessDispose.class.getName());
        }
    }

    public PmlProcessDispose findByPrimaryKey(long processDisposeId)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = fetchByPrimaryKey(processDisposeId);

        if (pmlProcessDispose == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlProcessDispose exists with the primary key " +
                    processDisposeId);
            }

            throw new NoSuchPmlProcessDisposeException(
                "No PmlProcessDispose exists with the primary key " +
                processDisposeId);
        }

        return pmlProcessDispose;
    }

    public PmlProcessDispose fetchByPrimaryKey(long processDisposeId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlProcessDispose) session.get(PmlProcessDisposeImpl.class,
                new Long(processDisposeId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findBySendDate(Date sendDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findBySendDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { sendDate };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (sendDate == null) {
                    query.append("senddate IS NULL");
                } else {
                    query.append("senddate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
                }

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findBySendDate(Date sendDate, int start,
        int end) throws SystemException {
        return findBySendDate(sendDate, start, end, null);
    }

    public List<PmlProcessDispose> findBySendDate(Date sendDate, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findBySendDate";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                sendDate,
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (sendDate == null) {
                    query.append("senddate IS NULL");
                } else {
                    query.append("senddate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
                }

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findBySendDate_First(Date sendDate,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findBySendDate(sendDate, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("sendDate=" + sendDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findBySendDate_Last(Date sendDate,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countBySendDate(sendDate);

        List<PmlProcessDispose> list = findBySendDate(sendDate, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("sendDate=" + sendDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findBySendDate_PrevAndNext(
        long processDisposeId, Date sendDate, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countBySendDate(sendDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            if (sendDate == null) {
                query.append("senddate IS NULL");
            } else {
                query.append("senddate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (sendDate != null) {
                qPos.add(CalendarUtil.getTimestamp(sendDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByTransition(int transition_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByTransition";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(transition_) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("transition_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(transition_);

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByTransition(int transition_, int start,
        int end) throws SystemException {
        return findByTransition(transition_, start, end, null);
    }

    public List<PmlProcessDispose> findByTransition(int transition_, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByTransition";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(transition_),
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("transition_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(transition_);

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByTransition_First(int transition_,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByTransition(transition_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByTransition_Last(int transition_,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByTransition(transition_);

        List<PmlProcessDispose> list = findByTransition(transition_, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByTransition_PrevAndNext(
        long processDisposeId, int transition_, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByTransition(transition_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            query.append("transition_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(transition_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByDelegateUser(long delegateUser)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByDelegateUser";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(delegateUser) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("delegateuser = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(delegateUser);

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByDelegateUser(long delegateUser,
        int start, int end) throws SystemException {
        return findByDelegateUser(delegateUser, start, end, null);
    }

    public List<PmlProcessDispose> findByDelegateUser(long delegateUser,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByDelegateUser";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(delegateUser),
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("delegateuser = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(delegateUser);

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByDelegateUser_First(long delegateUser,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByDelegateUser(delegateUser, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("delegateUser=" + delegateUser);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByDelegateUser_Last(long delegateUser,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByDelegateUser(delegateUser);

        List<PmlProcessDispose> list = findByDelegateUser(delegateUser,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("delegateUser=" + delegateUser);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByDelegateUser_PrevAndNext(
        long processDisposeId, long delegateUser, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByDelegateUser(delegateUser);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            query.append("delegateuser = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(delegateUser);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByExpiredDate(Date expiredDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByExpiredDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { expiredDate };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (expiredDate == null) {
                    query.append("expireddate IS NULL");
                } else {
                    query.append("expireddate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (expiredDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(expiredDate));
                }

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByExpiredDate(Date expiredDate,
        int start, int end) throws SystemException {
        return findByExpiredDate(expiredDate, start, end, null);
    }

    public List<PmlProcessDispose> findByExpiredDate(Date expiredDate,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByExpiredDate";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                expiredDate,
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (expiredDate == null) {
                    query.append("expireddate IS NULL");
                } else {
                    query.append("expireddate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (expiredDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(expiredDate));
                }

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByExpiredDate_First(Date expiredDate,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByExpiredDate(expiredDate, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("expiredDate=" + expiredDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByExpiredDate_Last(Date expiredDate,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByExpiredDate(expiredDate);

        List<PmlProcessDispose> list = findByExpiredDate(expiredDate,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("expiredDate=" + expiredDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByExpiredDate_PrevAndNext(
        long processDisposeId, Date expiredDate, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByExpiredDate(expiredDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            if (expiredDate == null) {
                query.append("expireddate IS NULL");
            } else {
                query.append("expireddate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (expiredDate != null) {
                qPos.add(CalendarUtil.getTimestamp(expiredDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByFileId_Transition(String fileId,
        int transition_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByFileId_Transition";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { fileId, new Integer(transition_) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("transition_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(transition_);

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByFileId_Transition(String fileId,
        int transition_, int start, int end) throws SystemException {
        return findByFileId_Transition(fileId, transition_, start, end, null);
    }

    public List<PmlProcessDispose> findByFileId_Transition(String fileId,
        int transition_, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByFileId_Transition";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileId, new Integer(transition_),
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("transition_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(transition_);

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByFileId_Transition_First(String fileId,
        int transition_, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByFileId_Transition(fileId,
                transition_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByFileId_Transition_Last(String fileId,
        int transition_, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByFileId_Transition(fileId, transition_);

        List<PmlProcessDispose> list = findByFileId_Transition(fileId,
                transition_, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("transition_=" + transition_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByFileId_Transition_PrevAndNext(
        long processDisposeId, String fileId, int transition_,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByFileId_Transition(fileId, transition_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            if (fileId == null) {
                query.append("fileid IS NULL");
            } else {
                query.append("fileid = ?");
            }

            query.append(" AND ");

            query.append("transition_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            qPos.add(transition_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByFileId_StateProcessIdBefore(
        String fileId, long stateProcessIdBefore) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByFileId_StateProcessIdBefore";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                fileId, new Long(stateProcessIdBefore)
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(stateProcessIdBefore);

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByFileId_StateProcessIdBefore(
        String fileId, long stateProcessIdBefore, int start, int end)
        throws SystemException {
        return findByFileId_StateProcessIdBefore(fileId, stateProcessIdBefore,
            start, end, null);
    }

    public List<PmlProcessDispose> findByFileId_StateProcessIdBefore(
        String fileId, long stateProcessIdBefore, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByFileId_StateProcessIdBefore";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileId, new Long(stateProcessIdBefore),
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(stateProcessIdBefore);

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByFileId_StateProcessIdBefore_First(
        String fileId, long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByFileId_StateProcessIdBefore(fileId,
                stateProcessIdBefore, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByFileId_StateProcessIdBefore_Last(
        String fileId, long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByFileId_StateProcessIdBefore(fileId,
                stateProcessIdBefore);

        List<PmlProcessDispose> list = findByFileId_StateProcessIdBefore(fileId,
                stateProcessIdBefore, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByFileId_StateProcessIdBefore_PrevAndNext(
        long processDisposeId, String fileId, long stateProcessIdBefore,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByFileId_StateProcessIdBefore(fileId,
                stateProcessIdBefore);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            if (fileId == null) {
                query.append("fileid IS NULL");
            } else {
                query.append("fileid = ?");
            }

            query.append(" AND ");

            query.append("stateprocessidbefore = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            qPos.add(stateProcessIdBefore);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByFileId_StateProcessIdAfter(
        String fileId, long stateProcessIdAfter) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByFileId_StateProcessIdAfter";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { fileId, new Long(stateProcessIdAfter) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(stateProcessIdAfter);

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByFileId_StateProcessIdAfter(
        String fileId, long stateProcessIdAfter, int start, int end)
        throws SystemException {
        return findByFileId_StateProcessIdAfter(fileId, stateProcessIdAfter,
            start, end, null);
    }

    public List<PmlProcessDispose> findByFileId_StateProcessIdAfter(
        String fileId, long stateProcessIdAfter, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByFileId_StateProcessIdAfter";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileId, new Long(stateProcessIdAfter),
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(stateProcessIdAfter);

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByFileId_StateProcessIdAfter_First(
        String fileId, long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByFileId_StateProcessIdAfter(fileId,
                stateProcessIdAfter, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByFileId_StateProcessIdAfter_Last(
        String fileId, long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByFileId_StateProcessIdAfter(fileId,
                stateProcessIdAfter);

        List<PmlProcessDispose> list = findByFileId_StateProcessIdAfter(fileId,
                stateProcessIdAfter, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(", ");
            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByFileId_StateProcessIdAfter_PrevAndNext(
        long processDisposeId, String fileId, long stateProcessIdAfter,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByFileId_StateProcessIdAfter(fileId,
                stateProcessIdAfter);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            if (fileId == null) {
                query.append("fileid IS NULL");
            } else {
                query.append("fileid = ?");
            }

            query.append(" AND ");

            query.append("stateprocessidafter = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            qPos.add(stateProcessIdAfter);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByProcesser(long processer)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByProcesser";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(processer) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("processer = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processer);

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByProcesser(long processer, int start,
        int end) throws SystemException {
        return findByProcesser(processer, start, end, null);
    }

    public List<PmlProcessDispose> findByProcesser(long processer, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByProcesser";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(processer),
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("processer = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processer);

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByProcesser_First(long processer,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByProcesser(processer, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByProcesser_Last(long processer,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByProcesser(processer);

        List<PmlProcessDispose> list = findByProcesser(processer, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("processer=" + processer);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByProcesser_PrevAndNext(
        long processDisposeId, long processer, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByProcesser(processer);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            query.append("processer = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processer);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByDateProcess(Date dateProcess)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByDateProcess";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateProcess };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByDateProcess(Date dateProcess,
        int start, int end) throws SystemException {
        return findByDateProcess(dateProcess, start, end, null);
    }

    public List<PmlProcessDispose> findByDateProcess(Date dateProcess,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByDateProcess";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                dateProcess,
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
                }

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByDateProcess_First(Date dateProcess,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByDateProcess(dateProcess, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByDateProcess_Last(Date dateProcess,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByDateProcess(dateProcess);

        List<PmlProcessDispose> list = findByDateProcess(dateProcess,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("dateProcess=" + dateProcess);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByDateProcess_PrevAndNext(
        long processDisposeId, Date dateProcess, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByDateProcess(dateProcess);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            if (dateProcess == null) {
                query.append("dateprocess IS NULL");
            } else {
                query.append("dateprocess = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateProcess != null) {
                qPos.add(CalendarUtil.getTimestamp(dateProcess));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByReceiver(long receiver)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByReceiver";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(receiver) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByReceiver(long receiver, int start,
        int end) throws SystemException {
        return findByReceiver(receiver, start, end, null);
    }

    public List<PmlProcessDispose> findByReceiver(long receiver, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByReceiver";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(receiver),
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByReceiver_First(long receiver,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByReceiver(receiver, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByReceiver_Last(long receiver,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByReceiver(receiver);

        List<PmlProcessDispose> list = findByReceiver(receiver, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("receiver=" + receiver);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByReceiver_PrevAndNext(
        long processDisposeId, long receiver, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByReceiver(receiver);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            query.append("receiver = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(receiver);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByReceiveDate(Date receiveDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByReceiveDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { receiveDate };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (receiveDate == null) {
                    query.append("receivedate IS NULL");
                } else {
                    query.append("receivedate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByReceiveDate(Date receiveDate,
        int start, int end) throws SystemException {
        return findByReceiveDate(receiveDate, start, end, null);
    }

    public List<PmlProcessDispose> findByReceiveDate(Date receiveDate,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByReceiveDate";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                receiveDate,
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (receiveDate == null) {
                    query.append("receivedate IS NULL");
                } else {
                    query.append("receivedate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
                }

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByReceiveDate_First(Date receiveDate,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByReceiveDate(receiveDate, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("receiveDate=" + receiveDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByReceiveDate_Last(Date receiveDate,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByReceiveDate(receiveDate);

        List<PmlProcessDispose> list = findByReceiveDate(receiveDate,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("receiveDate=" + receiveDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByReceiveDate_PrevAndNext(
        long processDisposeId, Date receiveDate, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByReceiveDate(receiveDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            if (receiveDate == null) {
                query.append("receivedate IS NULL");
            } else {
                query.append("receivedate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (receiveDate != null) {
                qPos.add(CalendarUtil.getTimestamp(receiveDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByStateProcessIdBefore(
        long stateProcessIdBefore) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByStateProcessIdBefore";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessIdBefore) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdBefore);

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end)
        throws SystemException {
        return findByStateProcessIdBefore(stateProcessIdBefore, start, end, null);
    }

    public List<PmlProcessDispose> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByStateProcessIdBefore";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(stateProcessIdBefore),
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdBefore);

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByStateProcessIdBefore_First(
        long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByStateProcessIdBefore(stateProcessIdBefore,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByStateProcessIdBefore_Last(
        long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByStateProcessIdBefore(stateProcessIdBefore);

        List<PmlProcessDispose> list = findByStateProcessIdBefore(stateProcessIdBefore,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("stateProcessIdBefore=" + stateProcessIdBefore);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByStateProcessIdBefore_PrevAndNext(
        long processDisposeId, long stateProcessIdBefore, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByStateProcessIdBefore(stateProcessIdBefore);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            query.append("stateprocessidbefore = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessIdBefore);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByStateProcessIdAfter(
        long stateProcessIdAfter) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByStateProcessIdAfter";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessIdAfter) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdAfter);

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end) throws SystemException {
        return findByStateProcessIdAfter(stateProcessIdAfter, start, end, null);
    }

    public List<PmlProcessDispose> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByStateProcessIdAfter";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(stateProcessIdAfter),
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdAfter);

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByStateProcessIdAfter_First(
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByStateProcessIdAfter(stateProcessIdAfter,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByStateProcessIdAfter_Last(
        long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByStateProcessIdAfter(stateProcessIdAfter);

        List<PmlProcessDispose> list = findByStateProcessIdAfter(stateProcessIdAfter,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("stateProcessIdAfter=" + stateProcessIdAfter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByStateProcessIdAfter_PrevAndNext(
        long processDisposeId, long stateProcessIdAfter, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByStateProcessIdAfter(stateProcessIdAfter);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            query.append("stateprocessidafter = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessIdAfter);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlProcessDispose> findByFileId(String fileId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByFileId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileId };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processdisposeid ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                List<PmlProcessDispose> list = q.list();

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
            return (List<PmlProcessDispose>) result;
        }
    }

    public List<PmlProcessDispose> findByFileId(String fileId, int start,
        int end) throws SystemException {
        return findByFileId(fileId, start, end, null);
    }

    public List<PmlProcessDispose> findByFileId(String fileId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "findByFileId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileId,
                
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public PmlProcessDispose findByFileId_First(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        List<PmlProcessDispose> list = findByFileId(fileId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose findByFileId_Last(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        int count = countByFileId(fileId);

        List<PmlProcessDispose> list = findByFileId(fileId, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlProcessDispose exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlProcessDisposeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlProcessDispose[] findByFileId_PrevAndNext(long processDisposeId,
        String fileId, OrderByComparator obc)
        throws NoSuchPmlProcessDisposeException, SystemException {
        PmlProcessDispose pmlProcessDispose = findByPrimaryKey(processDisposeId);

        int count = countByFileId(fileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

            if (fileId == null) {
                query.append("fileid LIKE null");
            } else {
                query.append("fileid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processdisposeid ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlProcessDispose);

            PmlProcessDispose[] array = new PmlProcessDisposeImpl[3];

            array[0] = (PmlProcessDispose) objArray[0];
            array[1] = (PmlProcessDispose) objArray[1];
            array[2] = (PmlProcessDispose) objArray[2];

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

    public List<PmlProcessDispose> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlProcessDispose> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlProcessDispose> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processdisposeid ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlProcessDispose> list = (List<PmlProcessDispose>) QueryUtil.list(q,
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
            return (List<PmlProcessDispose>) result;
        }
    }

    public void removeBySendDate(Date sendDate) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findBySendDate(sendDate)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByTransition(int transition_) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByTransition(transition_)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByDelegateUser(long delegateUser)
        throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByDelegateUser(
                delegateUser)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByExpiredDate(Date expiredDate) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByExpiredDate(
                expiredDate)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByFileId_Transition(String fileId, int transition_)
        throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByFileId_Transition(
                fileId, transition_)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByFileId_StateProcessIdBefore(String fileId,
        long stateProcessIdBefore) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByFileId_StateProcessIdBefore(
                fileId, stateProcessIdBefore)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByFileId_StateProcessIdAfter(String fileId,
        long stateProcessIdAfter) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByFileId_StateProcessIdAfter(
                fileId, stateProcessIdAfter)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByProcesser(long processer) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByProcesser(processer)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByDateProcess(Date dateProcess) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByDateProcess(
                dateProcess)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByReceiver(long receiver) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByReceiver(receiver)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByReceiveDate(Date receiveDate) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByReceiveDate(
                receiveDate)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByStateProcessIdBefore(long stateProcessIdBefore)
        throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByStateProcessIdBefore(
                stateProcessIdBefore)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByStateProcessIdAfter(long stateProcessIdAfter)
        throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByStateProcessIdAfter(
                stateProcessIdAfter)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeByFileId(String fileId) throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findByFileId(fileId)) {
            remove(pmlProcessDispose);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlProcessDispose pmlProcessDispose : findAll()) {
            remove(pmlProcessDispose);
        }
    }

    public int countBySendDate(Date sendDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countBySendDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { sendDate };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (sendDate == null) {
                    query.append("senddate IS NULL");
                } else {
                    query.append("senddate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (sendDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(sendDate));
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

    public int countByTransition(int transition_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByTransition";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(transition_) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("transition_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(transition_);

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

    public int countByDelegateUser(long delegateUser) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByDelegateUser";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(delegateUser) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("delegateuser = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(delegateUser);

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

    public int countByExpiredDate(Date expiredDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByExpiredDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { expiredDate };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (expiredDate == null) {
                    query.append("expireddate IS NULL");
                } else {
                    query.append("expireddate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (expiredDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(expiredDate));
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

    public int countByFileId_Transition(String fileId, int transition_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByFileId_Transition";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { fileId, new Integer(transition_) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("transition_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(transition_);

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

    public int countByFileId_StateProcessIdBefore(String fileId,
        long stateProcessIdBefore) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByFileId_StateProcessIdBefore";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                fileId, new Long(stateProcessIdBefore)
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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(stateProcessIdBefore);

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

    public int countByFileId_StateProcessIdAfter(String fileId,
        long stateProcessIdAfter) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByFileId_StateProcessIdAfter";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { fileId, new Long(stateProcessIdAfter) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid IS NULL");
                } else {
                    query.append("fileid = ?");
                }

                query.append(" AND ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                qPos.add(stateProcessIdAfter);

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

    public int countByProcesser(long processer) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByProcesser";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(processer) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("processer = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processer);

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

    public int countByDateProcess(Date dateProcess) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByDateProcess";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateProcess };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (dateProcess == null) {
                    query.append("dateprocess IS NULL");
                } else {
                    query.append("dateprocess = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateProcess != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateProcess));
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

    public int countByReceiver(long receiver) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByReceiver";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(receiver) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("receiver = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(receiver);

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

    public int countByReceiveDate(Date receiveDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByReceiveDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { receiveDate };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (receiveDate == null) {
                    query.append("receivedate IS NULL");
                } else {
                    query.append("receivedate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(receiveDate));
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

    public int countByStateProcessIdBefore(long stateProcessIdBefore)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByStateProcessIdBefore";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessIdBefore) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("stateprocessidbefore = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdBefore);

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

    public int countByStateProcessIdAfter(long stateProcessIdAfter)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByStateProcessIdAfter";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessIdAfter) };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                query.append("stateprocessidafter = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessIdAfter);

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

    public int countByFileId(String fileId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
        String finderMethodName = "countByFileId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileId };

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
                    "FROM com.sgs.portlet.document.model.PmlProcessDispose WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
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
        boolean finderClassNameCacheEnabled = PmlProcessDisposeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlProcessDispose.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.model.PmlProcessDispose");

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
                        "value.object.listener.com.sgs.portlet.document.model.PmlProcessDispose")));

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
