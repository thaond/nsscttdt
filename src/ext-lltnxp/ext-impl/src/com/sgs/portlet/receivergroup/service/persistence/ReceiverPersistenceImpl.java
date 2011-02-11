package com.sgs.portlet.receivergroup.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.receivergroup.NoSuchReceiverException;
import com.sgs.portlet.receivergroup.model.Receiver;
import com.sgs.portlet.receivergroup.model.impl.ReceiverImpl;
import com.sgs.portlet.receivergroup.model.impl.ReceiverModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class ReceiverPersistenceImpl extends BasePersistenceImpl
    implements ReceiverPersistence {
    private static final String _SQL_GETRECEIVERGROUPS = "SELECT {pml_ReceiverGroup.*} FROM pml_ReceiverGroup INNER JOIN ReceiverGroups_Receivers ON (ReceiverGroups_Receivers.receiverGroupId = pml_ReceiverGroup.receiverGroupId) WHERE (ReceiverGroups_Receivers.receiverId = ?)";
    private static final String _SQL_GETRECEIVERGROUPSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM ReceiverGroups_Receivers WHERE receiverId = ?";
    private static final String _SQL_CONTAINSRECEIVERGROUP = "SELECT COUNT(*) AS COUNT_VALUE FROM ReceiverGroups_Receivers WHERE receiverId = ? AND receiverGroupId = ?";
    private static Log _log = LogFactory.getLog(ReceiverPersistenceImpl.class);
    protected ContainsReceiverGroup containsReceiverGroup;
    protected AddReceiverGroup addReceiverGroup;
    protected ClearReceiverGroups clearReceiverGroups;
    protected RemoveReceiverGroup removeReceiverGroup;
    private ModelListener[] _listeners = new ModelListener[0];

    public Receiver create(long receiverId) {
        Receiver receiver = new ReceiverImpl();

        receiver.setNew(true);
        receiver.setPrimaryKey(receiverId);

        return receiver;
    }

    public Receiver remove(long receiverId)
        throws NoSuchReceiverException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Receiver receiver = (Receiver) session.get(ReceiverImpl.class,
                    new Long(receiverId));

            if (receiver == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Receiver exists with the primary key " +
                        receiverId);
                }

                throw new NoSuchReceiverException(
                    "No Receiver exists with the primary key " + receiverId);
            }

            return remove(receiver);
        } catch (NoSuchReceiverException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Receiver remove(Receiver receiver) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(receiver);
            }
        }

        receiver = removeImpl(receiver);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(receiver);
            }
        }

        return receiver;
    }

    protected Receiver removeImpl(Receiver receiver) throws SystemException {
        try {
            clearReceiverGroups.clear(receiver.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }

        Session session = null;

        try {
            session = openSession();

            session.delete(receiver);

            session.flush();

            return receiver;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Receiver.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(Receiver receiver, boolean merge)</code>.
     */
    public Receiver update(Receiver receiver) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Receiver receiver) method. Use update(Receiver receiver, boolean merge) instead.");
        }

        return update(receiver, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                receiver the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when receiver is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Receiver update(Receiver receiver, boolean merge)
        throws SystemException {
        boolean isNew = receiver.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(receiver);
                } else {
                    listener.onBeforeUpdate(receiver);
                }
            }
        }

        receiver = updateImpl(receiver, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(receiver);
                } else {
                    listener.onAfterUpdate(receiver);
                }
            }
        }

        return receiver;
    }

    public Receiver updateImpl(
        com.sgs.portlet.receivergroup.model.Receiver receiver, boolean merge)
        throws SystemException {
        FinderCacheUtil.clearCache("ReceiverGroups_Receivers");

        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(receiver);
            } else {
                if (receiver.isNew()) {
                    session.save(receiver);
                }
            }

            session.flush();

            receiver.setNew(false);

            return receiver;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Receiver.class.getName());
        }
    }

    public Receiver findByPrimaryKey(long receiverId)
        throws NoSuchReceiverException, SystemException {
        Receiver receiver = fetchByPrimaryKey(receiverId);

        if (receiver == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Receiver exists with the primary key " +
                    receiverId);
            }

            throw new NoSuchReceiverException(
                "No Receiver exists with the primary key " + receiverId);
        }

        return receiver;
    }

    public Receiver fetchByPrimaryKey(long receiverId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (Receiver) session.get(ReceiverImpl.class,
                new Long(receiverId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Receiver> findByUID_Type(long userId, int receiverType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "findByUID_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Integer(receiverType)
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(receiverType);

                List<Receiver> list = q.list();

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
            return (List<Receiver>) result;
        }
    }

    public List<Receiver> findByUID_Type(long userId, int receiverType,
        int start, int end) throws SystemException {
        return findByUID_Type(userId, receiverType, start, end, null);
    }

    public List<Receiver> findByUID_Type(long userId, int receiverType,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "findByUID_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Integer(receiverType),
                
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(receiverType);

                List<Receiver> list = (List<Receiver>) QueryUtil.list(q,
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
            return (List<Receiver>) result;
        }
    }

    public Receiver findByUID_Type_First(long userId, int receiverType,
        OrderByComparator obc) throws NoSuchReceiverException, SystemException {
        List<Receiver> list = findByUID_Type(userId, receiverType, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Receiver exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("receiverType=" + receiverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiverException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Receiver findByUID_Type_Last(long userId, int receiverType,
        OrderByComparator obc) throws NoSuchReceiverException, SystemException {
        int count = countByUID_Type(userId, receiverType);

        List<Receiver> list = findByUID_Type(userId, receiverType, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Receiver exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("receiverType=" + receiverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiverException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Receiver[] findByUID_Type_PrevAndNext(long receiverId, long userId,
        int receiverType, OrderByComparator obc)
        throws NoSuchReceiverException, SystemException {
        Receiver receiver = findByPrimaryKey(receiverId);

        int count = countByUID_Type(userId, receiverType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

            query.append("userId = ?");

            query.append(" AND ");

            query.append("receiverType = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            qPos.add(receiverType);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, receiver);

            Receiver[] array = new ReceiverImpl[3];

            array[0] = (Receiver) objArray[0];
            array[1] = (Receiver) objArray[1];
            array[2] = (Receiver) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Receiver findByUID_RUID_Type(long userId, long receiverUserId,
        int receiverType) throws NoSuchReceiverException, SystemException {
        Receiver receiver = fetchByUID_RUID_Type(userId, receiverUserId,
                receiverType);

        if (receiver == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Receiver exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("receiverUserId=" + receiverUserId);

            msg.append(", ");
            msg.append("receiverType=" + receiverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchReceiverException(msg.toString());
        }

        return receiver;
    }

    public Receiver fetchByUID_RUID_Type(long userId, long receiverUserId,
        int receiverType) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "fetchByUID_RUID_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Long(receiverUserId),
                new Integer(receiverType)
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("receiverUserId = ?");

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(receiverUserId);

                qPos.add(receiverType);

                List<Receiver> list = q.list();

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
            List<Receiver> list = (List<Receiver>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public Receiver findByUID_RCN_Type(long userId, String receiverUserName,
        int receiverType) throws NoSuchReceiverException, SystemException {
        Receiver receiver = fetchByUID_RCN_Type(userId, receiverUserName,
                receiverType);

        if (receiver == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Receiver exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("receiverUserName=" + receiverUserName);

            msg.append(", ");
            msg.append("receiverType=" + receiverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchReceiverException(msg.toString());
        }

        return receiver;
    }

    public Receiver fetchByUID_RCN_Type(long userId, String receiverUserName,
        int receiverType) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "fetchByUID_RCN_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId),
                
                receiverUserName, new Integer(receiverType)
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                if (receiverUserName == null) {
                    query.append("receiverUserName IS NULL");
                } else {
                    query.append("receiverUserName = ?");
                }

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (receiverUserName != null) {
                    qPos.add(receiverUserName);
                }

                qPos.add(receiverType);

                List<Receiver> list = q.list();

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
            List<Receiver> list = (List<Receiver>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public List<Receiver> findByUCN_Type(String userName, int receiverType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "findByUCN_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { userName, new Integer(receiverType) };

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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(receiverType);

                List<Receiver> list = q.list();

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
            return (List<Receiver>) result;
        }
    }

    public List<Receiver> findByUCN_Type(String userName, int receiverType,
        int start, int end) throws SystemException {
        return findByUCN_Type(userName, receiverType, start, end, null);
    }

    public List<Receiver> findByUCN_Type(String userName, int receiverType,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "findByUCN_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                userName, new Integer(receiverType),
                
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(receiverType);

                List<Receiver> list = (List<Receiver>) QueryUtil.list(q,
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
            return (List<Receiver>) result;
        }
    }

    public Receiver findByUCN_Type_First(String userName, int receiverType,
        OrderByComparator obc) throws NoSuchReceiverException, SystemException {
        List<Receiver> list = findByUCN_Type(userName, receiverType, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Receiver exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("receiverType=" + receiverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiverException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Receiver findByUCN_Type_Last(String userName, int receiverType,
        OrderByComparator obc) throws NoSuchReceiverException, SystemException {
        int count = countByUCN_Type(userName, receiverType);

        List<Receiver> list = findByUCN_Type(userName, receiverType, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Receiver exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("receiverType=" + receiverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiverException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Receiver[] findByUCN_Type_PrevAndNext(long receiverId,
        String userName, int receiverType, OrderByComparator obc)
        throws NoSuchReceiverException, SystemException {
        Receiver receiver = findByPrimaryKey(receiverId);

        int count = countByUCN_Type(userName, receiverType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

            if (userName == null) {
                query.append("userName IS NULL");
            } else {
                query.append("userName = ?");
            }

            query.append(" AND ");

            query.append("receiverType = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (userName != null) {
                qPos.add(userName);
            }

            qPos.add(receiverType);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, receiver);

            Receiver[] array = new ReceiverImpl[3];

            array[0] = (Receiver) objArray[0];
            array[1] = (Receiver) objArray[1];
            array[2] = (Receiver) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Receiver findByUCN_RUID_Type(String userName, long receiverUserId,
        int receiverType) throws NoSuchReceiverException, SystemException {
        Receiver receiver = fetchByUCN_RUID_Type(userName, receiverUserId,
                receiverType);

        if (receiver == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Receiver exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("receiverUserId=" + receiverUserId);

            msg.append(", ");
            msg.append("receiverType=" + receiverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchReceiverException(msg.toString());
        }

        return receiver;
    }

    public Receiver fetchByUCN_RUID_Type(String userName, long receiverUserId,
        int receiverType) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "fetchByUCN_RUID_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                userName, new Long(receiverUserId), new Integer(receiverType)
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("receiverUserId = ?");

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(receiverUserId);

                qPos.add(receiverType);

                List<Receiver> list = q.list();

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
            List<Receiver> list = (List<Receiver>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public Receiver findByUCN_RCN_Type(String userName,
        String receiverUserName, int receiverType)
        throws NoSuchReceiverException, SystemException {
        Receiver receiver = fetchByUCN_RCN_Type(userName, receiverUserName,
                receiverType);

        if (receiver == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Receiver exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("receiverUserName=" + receiverUserName);

            msg.append(", ");
            msg.append("receiverType=" + receiverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchReceiverException(msg.toString());
        }

        return receiver;
    }

    public Receiver fetchByUCN_RCN_Type(String userName,
        String receiverUserName, int receiverType) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "fetchByUCN_RCN_Type";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                userName,
                
                receiverUserName, new Integer(receiverType)
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                if (receiverUserName == null) {
                    query.append("receiverUserName IS NULL");
                } else {
                    query.append("receiverUserName = ?");
                }

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                if (receiverUserName != null) {
                    qPos.add(receiverUserName);
                }

                qPos.add(receiverType);

                List<Receiver> list = q.list();

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
            List<Receiver> list = (List<Receiver>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
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

    public List<Receiver> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Receiver> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<Receiver> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<Receiver> list = (List<Receiver>) QueryUtil.list(q,
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
            return (List<Receiver>) result;
        }
    }

    public void removeByUID_Type(long userId, int receiverType)
        throws SystemException {
        for (Receiver receiver : findByUID_Type(userId, receiverType)) {
            remove(receiver);
        }
    }

    public void removeByUID_RUID_Type(long userId, long receiverUserId,
        int receiverType) throws NoSuchReceiverException, SystemException {
        Receiver receiver = findByUID_RUID_Type(userId, receiverUserId,
                receiverType);

        remove(receiver);
    }

    public void removeByUID_RCN_Type(long userId, String receiverUserName,
        int receiverType) throws NoSuchReceiverException, SystemException {
        Receiver receiver = findByUID_RCN_Type(userId, receiverUserName,
                receiverType);

        remove(receiver);
    }

    public void removeByUCN_Type(String userName, int receiverType)
        throws SystemException {
        for (Receiver receiver : findByUCN_Type(userName, receiverType)) {
            remove(receiver);
        }
    }

    public void removeByUCN_RUID_Type(String userName, long receiverUserId,
        int receiverType) throws NoSuchReceiverException, SystemException {
        Receiver receiver = findByUCN_RUID_Type(userName, receiverUserId,
                receiverType);

        remove(receiver);
    }

    public void removeByUCN_RCN_Type(String userName, String receiverUserName,
        int receiverType) throws NoSuchReceiverException, SystemException {
        Receiver receiver = findByUCN_RCN_Type(userName, receiverUserName,
                receiverType);

        remove(receiver);
    }

    public void removeAll() throws SystemException {
        for (Receiver receiver : findAll()) {
            remove(receiver);
        }
    }

    public int countByUID_Type(long userId, int receiverType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "countByUID_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Integer(receiverType)
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(receiverType);

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

    public int countByUID_RUID_Type(long userId, long receiverUserId,
        int receiverType) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "countByUID_RUID_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Long(receiverUserId),
                new Integer(receiverType)
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("receiverUserId = ?");

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(receiverUserId);

                qPos.add(receiverType);

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

    public int countByUID_RCN_Type(long userId, String receiverUserName,
        int receiverType) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "countByUID_RCN_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId),
                
                receiverUserName, new Integer(receiverType)
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                if (receiverUserName == null) {
                    query.append("receiverUserName IS NULL");
                } else {
                    query.append("receiverUserName = ?");
                }

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (receiverUserName != null) {
                    qPos.add(receiverUserName);
                }

                qPos.add(receiverType);

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

    public int countByUCN_Type(String userName, int receiverType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "countByUCN_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { userName, new Integer(receiverType) };

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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(receiverType);

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

    public int countByUCN_RUID_Type(String userName, long receiverUserId,
        int receiverType) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "countByUCN_RUID_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                userName, new Long(receiverUserId), new Integer(receiverType)
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("receiverUserId = ?");

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(receiverUserId);

                qPos.add(receiverType);

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

    public int countByUCN_RCN_Type(String userName, String receiverUserName,
        int receiverType) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
        String finderMethodName = "countByUCN_RCN_Type";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                userName,
                
                receiverUserName, new Integer(receiverType)
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
                    "FROM com.sgs.portlet.receivergroup.model.Receiver WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                if (receiverUserName == null) {
                    query.append("receiverUserName IS NULL");
                } else {
                    query.append("receiverUserName = ?");
                }

                query.append(" AND ");

                query.append("receiverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                if (receiverUserName != null) {
                    qPos.add(receiverUserName);
                }

                qPos.add(receiverType);

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
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED;
        String finderClassName = Receiver.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.receivergroup.model.Receiver");

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

    public List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        long pk) throws SystemException {
        return getReceiverGroups(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    public List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        long pk, int start, int end) throws SystemException {
        return getReceiverGroups(pk, start, end, null);
    }

    public List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        long pk, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED_RECEIVERGROUPS_RECEIVERS;

        String finderClassName = "ReceiverGroups_Receivers";

        String finderMethodName = "getReceiverGroups";
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

                sb.append(_SQL_GETRECEIVERGROUPS);

                if (obc != null) {
                    sb.append("ORDER BY ");
                    sb.append(obc.getOrderBy());
                }
                else {
                    sb.append("ORDER BY ");

                    sb.append("pml_ReceiverGroup.receiverGroupName ASC");
                }

                String sql = sb.toString();

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("pml_ReceiverGroup",
                    com.sgs.portlet.receivergroup.model.impl.ReceiverGroupImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                List<com.sgs.portlet.receivergroup.model.ReceiverGroup> list = (List<com.sgs.portlet.receivergroup.model.ReceiverGroup>) QueryUtil.list(q,
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
            return (List<com.sgs.portlet.receivergroup.model.ReceiverGroup>) result;
        }
    }

    public int getReceiverGroupsSize(long pk) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED_RECEIVERGROUPS_RECEIVERS;

        String finderClassName = "ReceiverGroups_Receivers";

        String finderMethodName = "getReceiverGroupsSize";
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

                SQLQuery q = session.createSQLQuery(_SQL_GETRECEIVERGROUPSSIZE);

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

    public boolean containsReceiverGroup(long pk, long receiverGroupPK)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverModelImpl.CACHE_ENABLED_RECEIVERGROUPS_RECEIVERS;

        String finderClassName = "ReceiverGroups_Receivers";

        String finderMethodName = "containsReceiverGroups";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(pk),
                
                new Long(receiverGroupPK)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            try {
                Boolean value = Boolean.valueOf(containsReceiverGroup.contains(
                            pk, receiverGroupPK));

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

    public boolean containsReceiverGroups(long pk) throws SystemException {
        if (getReceiverGroupsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addReceiverGroup(long pk, long receiverGroupPK)
        throws SystemException {
        try {
            addReceiverGroup.add(pk, receiverGroupPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void addReceiverGroup(long pk,
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws SystemException {
        try {
            addReceiverGroup.add(pk, receiverGroup.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void addReceiverGroups(long pk, long[] receiverGroupPKs)
        throws SystemException {
        try {
            for (long receiverGroupPK : receiverGroupPKs) {
                addReceiverGroup.add(pk, receiverGroupPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void addReceiverGroups(long pk,
        List<com.sgs.portlet.receivergroup.model.ReceiverGroup> receiverGroups)
        throws SystemException {
        try {
            for (com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup : receiverGroups) {
                addReceiverGroup.add(pk, receiverGroup.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void clearReceiverGroups(long pk) throws SystemException {
        try {
            clearReceiverGroups.clear(pk);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void removeReceiverGroup(long pk, long receiverGroupPK)
        throws SystemException {
        try {
            removeReceiverGroup.remove(pk, receiverGroupPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void removeReceiverGroup(long pk,
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup)
        throws SystemException {
        try {
            removeReceiverGroup.remove(pk, receiverGroup.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void removeReceiverGroups(long pk, long[] receiverGroupPKs)
        throws SystemException {
        try {
            for (long receiverGroupPK : receiverGroupPKs) {
                removeReceiverGroup.remove(pk, receiverGroupPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void removeReceiverGroups(long pk,
        List<com.sgs.portlet.receivergroup.model.ReceiverGroup> receiverGroups)
        throws SystemException {
        try {
            for (com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup : receiverGroups) {
                removeReceiverGroup.remove(pk, receiverGroup.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void setReceiverGroups(long pk, long[] receiverGroupPKs)
        throws SystemException {
        try {
            clearReceiverGroups.clear(pk);

            for (long receiverGroupPK : receiverGroupPKs) {
                addReceiverGroup.add(pk, receiverGroupPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void setReceiverGroups(long pk,
        List<com.sgs.portlet.receivergroup.model.ReceiverGroup> receiverGroups)
        throws SystemException {
        try {
            clearReceiverGroups.clear(pk);

            for (com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup : receiverGroups) {
                addReceiverGroup.add(pk, receiverGroup.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
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
                        "value.object.listener.com.sgs.portlet.receivergroup.model.Receiver")));

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

        containsReceiverGroup = new ContainsReceiverGroup(this);

        addReceiverGroup = new AddReceiverGroup(this);
        clearReceiverGroups = new ClearReceiverGroups(this);
        removeReceiverGroup = new RemoveReceiverGroup(this);
    }

    protected class ContainsReceiverGroup {
        private MappingSqlQuery _mappingSqlQuery;

        protected ContainsReceiverGroup(ReceiverPersistenceImpl persistenceImpl) {
            super();

            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSRECEIVERGROUP,
                    new int[] { Types.BIGINT, Types.BIGINT }, RowMapper.COUNT);
        }

        protected boolean contains(long receiverId, long receiverGroupId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(receiverId), new Long(receiverGroupId)
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

    protected class AddReceiverGroup {
        private SqlUpdate _sqlUpdate;
        private ReceiverPersistenceImpl _persistenceImpl;

        protected AddReceiverGroup(ReceiverPersistenceImpl persistenceImpl) {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "INSERT INTO ReceiverGroups_Receivers (receiverId, receiverGroupId) VALUES (?, ?)",
                    new int[] { Types.BIGINT, Types.BIGINT });
            _persistenceImpl = persistenceImpl;
        }

        protected void add(long receiverId, long receiverGroupId) {
            if (!_persistenceImpl.containsReceiverGroup.contains(receiverId,
                        receiverGroupId)) {
                _sqlUpdate.update(new Object[] {
                        new Long(receiverId), new Long(receiverGroupId)
                    });
            }
        }
    }

    protected class ClearReceiverGroups {
        private SqlUpdate _sqlUpdate;

        protected ClearReceiverGroups(ReceiverPersistenceImpl persistenceImpl) {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM ReceiverGroups_Receivers WHERE receiverId = ?",
                    new int[] { Types.BIGINT });
        }

        protected void clear(long receiverId) {
            _sqlUpdate.update(new Object[] { new Long(receiverId) });
        }
    }

    protected class RemoveReceiverGroup {
        private SqlUpdate _sqlUpdate;

        protected RemoveReceiverGroup(ReceiverPersistenceImpl persistenceImpl) {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM ReceiverGroups_Receivers WHERE receiverId = ? AND receiverGroupId = ?",
                    new int[] { Types.BIGINT, Types.BIGINT });
        }

        protected void remove(long receiverId, long receiverGroupId) {
            _sqlUpdate.update(new Object[] {
                    new Long(receiverId), new Long(receiverGroupId)
                });
        }
    }
}
