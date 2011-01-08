package com.sgs.portlet.message_note.service.persistence;

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

import com.sgs.portlet.message_note.NoSuchPmlMessageException;
import com.sgs.portlet.message_note.model.PmlMessage;
import com.sgs.portlet.message_note.model.impl.PmlMessageImpl;
import com.sgs.portlet.message_note.model.impl.PmlMessageModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlMessagePersistenceImpl extends BasePersistenceImpl
    implements PmlMessagePersistence {
    private static Log _log = LogFactory.getLog(PmlMessagePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlMessage create(long messageId) {
        PmlMessage pmlMessage = new PmlMessageImpl();

        pmlMessage.setNew(true);
        pmlMessage.setPrimaryKey(messageId);

        return pmlMessage;
    }

    public PmlMessage remove(long messageId)
        throws NoSuchPmlMessageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlMessage pmlMessage = (PmlMessage) session.get(PmlMessageImpl.class,
                    new Long(messageId));

            if (pmlMessage == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlMessage exists with the primary key " +
                        messageId);
                }

                throw new NoSuchPmlMessageException(
                    "No PmlMessage exists with the primary key " + messageId);
            }

            return remove(pmlMessage);
        } catch (NoSuchPmlMessageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlMessage remove(PmlMessage pmlMessage) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlMessage);
            }
        }

        pmlMessage = removeImpl(pmlMessage);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlMessage);
            }
        }

        return pmlMessage;
    }

    protected PmlMessage removeImpl(PmlMessage pmlMessage)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlMessage);

            session.flush();

            return pmlMessage;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlMessage.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlMessage pmlMessage, boolean merge)</code>.
     */
    public PmlMessage update(PmlMessage pmlMessage) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlMessage pmlMessage) method. Use update(PmlMessage pmlMessage, boolean merge) instead.");
        }

        return update(pmlMessage, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlMessage the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlMessage is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlMessage update(PmlMessage pmlMessage, boolean merge)
        throws SystemException {
        boolean isNew = pmlMessage.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlMessage);
                } else {
                    listener.onBeforeUpdate(pmlMessage);
                }
            }
        }

        pmlMessage = updateImpl(pmlMessage, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlMessage);
                } else {
                    listener.onAfterUpdate(pmlMessage);
                }
            }
        }

        return pmlMessage;
    }

    public PmlMessage updateImpl(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlMessage);
            } else {
                if (pmlMessage.isNew()) {
                    session.save(pmlMessage);
                }
            }

            session.flush();

            pmlMessage.setNew(false);

            return pmlMessage;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlMessage.class.getName());
        }
    }

    public PmlMessage findByPrimaryKey(long messageId)
        throws NoSuchPmlMessageException, SystemException {
        PmlMessage pmlMessage = fetchByPrimaryKey(messageId);

        if (pmlMessage == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlMessage exists with the primary key " +
                    messageId);
            }

            throw new NoSuchPmlMessageException(
                "No PmlMessage exists with the primary key " + messageId);
        }

        return pmlMessage;
    }

    public PmlMessage fetchByPrimaryKey(long messageId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlMessage) session.get(PmlMessageImpl.class,
                new Long(messageId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlMessage> findByDocumentId(long documentId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "findByDocumentId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentId) };

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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("documentId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("createDate DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentId);

                List<PmlMessage> list = q.list();

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
            return (List<PmlMessage>) result;
        }
    }

    public List<PmlMessage> findByDocumentId(long documentId, int start, int end)
        throws SystemException {
        return findByDocumentId(documentId, start, end, null);
    }

    public List<PmlMessage> findByDocumentId(long documentId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "findByDocumentId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentId),
                
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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("documentId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("createDate DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentId);

                List<PmlMessage> list = (List<PmlMessage>) QueryUtil.list(q,
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
            return (List<PmlMessage>) result;
        }
    }

    public PmlMessage findByDocumentId_First(long documentId,
        OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        List<PmlMessage> list = findByDocumentId(documentId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMessage exists with the key {");

            msg.append("documentId=" + documentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMessageException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMessage findByDocumentId_Last(long documentId,
        OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        int count = countByDocumentId(documentId);

        List<PmlMessage> list = findByDocumentId(documentId, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMessage exists with the key {");

            msg.append("documentId=" + documentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMessageException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMessage[] findByDocumentId_PrevAndNext(long messageId,
        long documentId, OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        PmlMessage pmlMessage = findByPrimaryKey(messageId);

        int count = countByDocumentId(documentId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

            query.append("documentId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("createDate DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlMessage);

            PmlMessage[] array = new PmlMessageImpl[3];

            array[0] = (PmlMessage) objArray[0];
            array[1] = (PmlMessage) objArray[1];
            array[2] = (PmlMessage) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlMessage> findByCreateDate(Date createDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "findByCreateDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { createDate };

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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                if (createDate == null) {
                    query.append("createDate IS NULL");
                } else {
                    query.append("createDate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("createDate DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (createDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(createDate));
                }

                List<PmlMessage> list = q.list();

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
            return (List<PmlMessage>) result;
        }
    }

    public List<PmlMessage> findByCreateDate(Date createDate, int start, int end)
        throws SystemException {
        return findByCreateDate(createDate, start, end, null);
    }

    public List<PmlMessage> findByCreateDate(Date createDate, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "findByCreateDate";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                createDate,
                
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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                if (createDate == null) {
                    query.append("createDate IS NULL");
                } else {
                    query.append("createDate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("createDate DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (createDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(createDate));
                }

                List<PmlMessage> list = (List<PmlMessage>) QueryUtil.list(q,
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
            return (List<PmlMessage>) result;
        }
    }

    public PmlMessage findByCreateDate_First(Date createDate,
        OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        List<PmlMessage> list = findByCreateDate(createDate, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMessage exists with the key {");

            msg.append("createDate=" + createDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMessageException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMessage findByCreateDate_Last(Date createDate,
        OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        int count = countByCreateDate(createDate);

        List<PmlMessage> list = findByCreateDate(createDate, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMessage exists with the key {");

            msg.append("createDate=" + createDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMessageException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMessage[] findByCreateDate_PrevAndNext(long messageId,
        Date createDate, OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        PmlMessage pmlMessage = findByPrimaryKey(messageId);

        int count = countByCreateDate(createDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

            if (createDate == null) {
                query.append("createDate IS NULL");
            } else {
                query.append("createDate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("createDate DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (createDate != null) {
                qPos.add(CalendarUtil.getTimestamp(createDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlMessage);

            PmlMessage[] array = new PmlMessageImpl[3];

            array[0] = (PmlMessage) objArray[0];
            array[1] = (PmlMessage) objArray[1];
            array[2] = (PmlMessage) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlMessage> findByFromUserId(long fromUserId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "findByFromUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(fromUserId) };

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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("fromUserId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("createDate DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fromUserId);

                List<PmlMessage> list = q.list();

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
            return (List<PmlMessage>) result;
        }
    }

    public List<PmlMessage> findByFromUserId(long fromUserId, int start, int end)
        throws SystemException {
        return findByFromUserId(fromUserId, start, end, null);
    }

    public List<PmlMessage> findByFromUserId(long fromUserId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "findByFromUserId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(fromUserId),
                
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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("fromUserId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("createDate DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fromUserId);

                List<PmlMessage> list = (List<PmlMessage>) QueryUtil.list(q,
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
            return (List<PmlMessage>) result;
        }
    }

    public PmlMessage findByFromUserId_First(long fromUserId,
        OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        List<PmlMessage> list = findByFromUserId(fromUserId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMessage exists with the key {");

            msg.append("fromUserId=" + fromUserId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMessageException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMessage findByFromUserId_Last(long fromUserId,
        OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        int count = countByFromUserId(fromUserId);

        List<PmlMessage> list = findByFromUserId(fromUserId, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMessage exists with the key {");

            msg.append("fromUserId=" + fromUserId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMessageException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMessage[] findByFromUserId_PrevAndNext(long messageId,
        long fromUserId, OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        PmlMessage pmlMessage = findByPrimaryKey(messageId);

        int count = countByFromUserId(fromUserId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

            query.append("fromUserId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("createDate DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(fromUserId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlMessage);

            PmlMessage[] array = new PmlMessageImpl[3];

            array[0] = (PmlMessage) objArray[0];
            array[1] = (PmlMessage) objArray[1];
            array[2] = (PmlMessage) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlMessage> findByToUserId(long toUserId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "findByToUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(toUserId) };

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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("toUserId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("createDate DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(toUserId);

                List<PmlMessage> list = q.list();

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
            return (List<PmlMessage>) result;
        }
    }

    public List<PmlMessage> findByToUserId(long toUserId, int start, int end)
        throws SystemException {
        return findByToUserId(toUserId, start, end, null);
    }

    public List<PmlMessage> findByToUserId(long toUserId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "findByToUserId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(toUserId),
                
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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("toUserId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("createDate DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(toUserId);

                List<PmlMessage> list = (List<PmlMessage>) QueryUtil.list(q,
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
            return (List<PmlMessage>) result;
        }
    }

    public PmlMessage findByToUserId_First(long toUserId, OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        List<PmlMessage> list = findByToUserId(toUserId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMessage exists with the key {");

            msg.append("toUserId=" + toUserId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMessageException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMessage findByToUserId_Last(long toUserId, OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        int count = countByToUserId(toUserId);

        List<PmlMessage> list = findByToUserId(toUserId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMessage exists with the key {");

            msg.append("toUserId=" + toUserId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMessageException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMessage[] findByToUserId_PrevAndNext(long messageId,
        long toUserId, OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        PmlMessage pmlMessage = findByPrimaryKey(messageId);

        int count = countByToUserId(toUserId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

            query.append("toUserId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("createDate DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(toUserId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlMessage);

            PmlMessage[] array = new PmlMessageImpl[3];

            array[0] = (PmlMessage) objArray[0];
            array[1] = (PmlMessage) objArray[1];
            array[2] = (PmlMessage) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlMessage> findByDocumentId_FromUserId_ObjectType(
        long documentId, long fromUserId, String objectType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "findByDocumentId_FromUserId_ObjectType";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentId), new Long(fromUserId),
                
                objectType
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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("documentId = ?");

                query.append(" AND ");

                query.append("fromUserId = ?");

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objectType IS NULL");
                } else {
                    query.append("objectType = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("createDate DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentId);

                qPos.add(fromUserId);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                List<PmlMessage> list = q.list();

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
            return (List<PmlMessage>) result;
        }
    }

    public List<PmlMessage> findByDocumentId_FromUserId_ObjectType(
        long documentId, long fromUserId, String objectType, int start, int end)
        throws SystemException {
        return findByDocumentId_FromUserId_ObjectType(documentId, fromUserId,
            objectType, start, end, null);
    }

    public List<PmlMessage> findByDocumentId_FromUserId_ObjectType(
        long documentId, long fromUserId, String objectType, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "findByDocumentId_FromUserId_ObjectType";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentId), new Long(fromUserId),
                
                objectType,
                
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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("documentId = ?");

                query.append(" AND ");

                query.append("fromUserId = ?");

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objectType IS NULL");
                } else {
                    query.append("objectType = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("createDate DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentId);

                qPos.add(fromUserId);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                List<PmlMessage> list = (List<PmlMessage>) QueryUtil.list(q,
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
            return (List<PmlMessage>) result;
        }
    }

    public PmlMessage findByDocumentId_FromUserId_ObjectType_First(
        long documentId, long fromUserId, String objectType,
        OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        List<PmlMessage> list = findByDocumentId_FromUserId_ObjectType(documentId,
                fromUserId, objectType, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMessage exists with the key {");

            msg.append("documentId=" + documentId);

            msg.append(", ");
            msg.append("fromUserId=" + fromUserId);

            msg.append(", ");
            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMessageException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMessage findByDocumentId_FromUserId_ObjectType_Last(
        long documentId, long fromUserId, String objectType,
        OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        int count = countByDocumentId_FromUserId_ObjectType(documentId,
                fromUserId, objectType);

        List<PmlMessage> list = findByDocumentId_FromUserId_ObjectType(documentId,
                fromUserId, objectType, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMessage exists with the key {");

            msg.append("documentId=" + documentId);

            msg.append(", ");
            msg.append("fromUserId=" + fromUserId);

            msg.append(", ");
            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMessageException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMessage[] findByDocumentId_FromUserId_ObjectType_PrevAndNext(
        long messageId, long documentId, long fromUserId, String objectType,
        OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        PmlMessage pmlMessage = findByPrimaryKey(messageId);

        int count = countByDocumentId_FromUserId_ObjectType(documentId,
                fromUserId, objectType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

            query.append("documentId = ?");

            query.append(" AND ");

            query.append("fromUserId = ?");

            query.append(" AND ");

            if (objectType == null) {
                query.append("objectType IS NULL");
            } else {
                query.append("objectType = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("createDate DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentId);

            qPos.add(fromUserId);

            if (objectType != null) {
                qPos.add(objectType);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlMessage);

            PmlMessage[] array = new PmlMessageImpl[3];

            array[0] = (PmlMessage) objArray[0];
            array[1] = (PmlMessage) objArray[1];
            array[2] = (PmlMessage) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlMessage> findByFromUserId_DocumentId(long fromUserId,
        long documentId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "findByFromUserId_DocumentId";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(fromUserId), new Long(documentId)
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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("fromUserId = ?");

                query.append(" AND ");

                query.append("documentId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("createDate DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fromUserId);

                qPos.add(documentId);

                List<PmlMessage> list = q.list();

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
            return (List<PmlMessage>) result;
        }
    }

    public List<PmlMessage> findByFromUserId_DocumentId(long fromUserId,
        long documentId, int start, int end) throws SystemException {
        return findByFromUserId_DocumentId(fromUserId, documentId, start, end,
            null);
    }

    public List<PmlMessage> findByFromUserId_DocumentId(long fromUserId,
        long documentId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "findByFromUserId_DocumentId";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(fromUserId), new Long(documentId),
                
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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("fromUserId = ?");

                query.append(" AND ");

                query.append("documentId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("createDate DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fromUserId);

                qPos.add(documentId);

                List<PmlMessage> list = (List<PmlMessage>) QueryUtil.list(q,
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
            return (List<PmlMessage>) result;
        }
    }

    public PmlMessage findByFromUserId_DocumentId_First(long fromUserId,
        long documentId, OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        List<PmlMessage> list = findByFromUserId_DocumentId(fromUserId,
                documentId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMessage exists with the key {");

            msg.append("fromUserId=" + fromUserId);

            msg.append(", ");
            msg.append("documentId=" + documentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMessageException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMessage findByFromUserId_DocumentId_Last(long fromUserId,
        long documentId, OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        int count = countByFromUserId_DocumentId(fromUserId, documentId);

        List<PmlMessage> list = findByFromUserId_DocumentId(fromUserId,
                documentId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMessage exists with the key {");

            msg.append("fromUserId=" + fromUserId);

            msg.append(", ");
            msg.append("documentId=" + documentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMessageException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMessage[] findByFromUserId_DocumentId_PrevAndNext(
        long messageId, long fromUserId, long documentId, OrderByComparator obc)
        throws NoSuchPmlMessageException, SystemException {
        PmlMessage pmlMessage = findByPrimaryKey(messageId);

        int count = countByFromUserId_DocumentId(fromUserId, documentId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

            query.append("fromUserId = ?");

            query.append(" AND ");

            query.append("documentId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("createDate DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(fromUserId);

            qPos.add(documentId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlMessage);

            PmlMessage[] array = new PmlMessageImpl[3];

            array[0] = (PmlMessage) objArray[0];
            array[1] = (PmlMessage) objArray[1];
            array[2] = (PmlMessage) objArray[2];

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

    public List<PmlMessage> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlMessage> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlMessage> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("createDate DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlMessage> list = (List<PmlMessage>) QueryUtil.list(q,
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
            return (List<PmlMessage>) result;
        }
    }

    public void removeByDocumentId(long documentId) throws SystemException {
        for (PmlMessage pmlMessage : findByDocumentId(documentId)) {
            remove(pmlMessage);
        }
    }

    public void removeByCreateDate(Date createDate) throws SystemException {
        for (PmlMessage pmlMessage : findByCreateDate(createDate)) {
            remove(pmlMessage);
        }
    }

    public void removeByFromUserId(long fromUserId) throws SystemException {
        for (PmlMessage pmlMessage : findByFromUserId(fromUserId)) {
            remove(pmlMessage);
        }
    }

    public void removeByToUserId(long toUserId) throws SystemException {
        for (PmlMessage pmlMessage : findByToUserId(toUserId)) {
            remove(pmlMessage);
        }
    }

    public void removeByDocumentId_FromUserId_ObjectType(long documentId,
        long fromUserId, String objectType) throws SystemException {
        for (PmlMessage pmlMessage : findByDocumentId_FromUserId_ObjectType(
                documentId, fromUserId, objectType)) {
            remove(pmlMessage);
        }
    }

    public void removeByFromUserId_DocumentId(long fromUserId, long documentId)
        throws SystemException {
        for (PmlMessage pmlMessage : findByFromUserId_DocumentId(fromUserId,
                documentId)) {
            remove(pmlMessage);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlMessage pmlMessage : findAll()) {
            remove(pmlMessage);
        }
    }

    public int countByDocumentId(long documentId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "countByDocumentId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentId) };

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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("documentId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentId);

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

    public int countByCreateDate(Date createDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "countByCreateDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { createDate };

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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                if (createDate == null) {
                    query.append("createDate IS NULL");
                } else {
                    query.append("createDate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (createDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(createDate));
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

    public int countByFromUserId(long fromUserId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "countByFromUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(fromUserId) };

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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("fromUserId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fromUserId);

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

    public int countByToUserId(long toUserId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "countByToUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(toUserId) };

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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("toUserId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(toUserId);

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

    public int countByDocumentId_FromUserId_ObjectType(long documentId,
        long fromUserId, String objectType) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "countByDocumentId_FromUserId_ObjectType";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(documentId), new Long(fromUserId),
                
                objectType
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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("documentId = ?");

                query.append(" AND ");

                query.append("fromUserId = ?");

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objectType IS NULL");
                } else {
                    query.append("objectType = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentId);

                qPos.add(fromUserId);

                if (objectType != null) {
                    qPos.add(objectType);
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

    public int countByFromUserId_DocumentId(long fromUserId, long documentId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
        String finderMethodName = "countByFromUserId_DocumentId";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(fromUserId), new Long(documentId)
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
                    "FROM com.sgs.portlet.message_note.model.PmlMessage WHERE ");

                query.append("fromUserId = ?");

                query.append(" AND ");

                query.append("documentId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fromUserId);

                qPos.add(documentId);

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
        boolean finderClassNameCacheEnabled = PmlMessageModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMessage.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.message_note.model.PmlMessage");

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
                        "value.object.listener.com.sgs.portlet.message_note.model.PmlMessage")));

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
