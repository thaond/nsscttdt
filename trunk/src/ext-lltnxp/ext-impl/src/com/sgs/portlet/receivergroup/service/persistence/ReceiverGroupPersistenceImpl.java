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

import com.sgs.portlet.receivergroup.NoSuchException;
import com.sgs.portlet.receivergroup.model.ReceiverGroup;
import com.sgs.portlet.receivergroup.model.impl.ReceiverGroupImpl;
import com.sgs.portlet.receivergroup.model.impl.ReceiverGroupModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class ReceiverGroupPersistenceImpl extends BasePersistenceImpl
    implements ReceiverGroupPersistence {
    private static final String _SQL_GETRECEIVERS = "SELECT {pml_Receiver.*} FROM pml_Receiver INNER JOIN ReceiverGroups_Receivers ON (ReceiverGroups_Receivers.receiverId = pml_Receiver.receiverId) WHERE (ReceiverGroups_Receivers.receiverGroupId = ?)";
    private static final String _SQL_GETRECEIVERSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM ReceiverGroups_Receivers WHERE receiverGroupId = ?";
    private static final String _SQL_CONTAINSRECEIVER = "SELECT COUNT(*) AS COUNT_VALUE FROM ReceiverGroups_Receivers WHERE receiverGroupId = ? AND receiverId = ?";
    private static Log _log = LogFactory.getLog(ReceiverGroupPersistenceImpl.class);
    protected ContainsReceiver containsReceiver;
    protected AddReceiver addReceiver;
    protected ClearReceivers clearReceivers;
    protected RemoveReceiver removeReceiver;
    private ModelListener[] _listeners = new ModelListener[0];

    public ReceiverGroup create(long receiverGroupId) {
        ReceiverGroup receiverGroup = new ReceiverGroupImpl();

        receiverGroup.setNew(true);
        receiverGroup.setPrimaryKey(receiverGroupId);

        return receiverGroup;
    }

    public ReceiverGroup remove(long receiverGroupId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ReceiverGroup receiverGroup = (ReceiverGroup) session.get(ReceiverGroupImpl.class,
                    new Long(receiverGroupId));

            if (receiverGroup == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No ReceiverGroup exists with the primary key " +
                        receiverGroupId);
                }

                throw new NoSuchException(
                    "No ReceiverGroup exists with the primary key " +
                    receiverGroupId);
            }

            return remove(receiverGroup);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public ReceiverGroup remove(ReceiverGroup receiverGroup)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(receiverGroup);
            }
        }

        receiverGroup = removeImpl(receiverGroup);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(receiverGroup);
            }
        }

        return receiverGroup;
    }

    protected ReceiverGroup removeImpl(ReceiverGroup receiverGroup)
        throws SystemException {
        try {
            clearReceivers.clear(receiverGroup.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }

        Session session = null;

        try {
            session = openSession();

            session.delete(receiverGroup);

            session.flush();

            return receiverGroup;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(ReceiverGroup.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(ReceiverGroup receiverGroup, boolean merge)</code>.
     */
    public ReceiverGroup update(ReceiverGroup receiverGroup)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(ReceiverGroup receiverGroup) method. Use update(ReceiverGroup receiverGroup, boolean merge) instead.");
        }

        return update(receiverGroup, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                receiverGroup the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when receiverGroup is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public ReceiverGroup update(ReceiverGroup receiverGroup, boolean merge)
        throws SystemException {
        boolean isNew = receiverGroup.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(receiverGroup);
                } else {
                    listener.onBeforeUpdate(receiverGroup);
                }
            }
        }

        receiverGroup = updateImpl(receiverGroup, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(receiverGroup);
                } else {
                    listener.onAfterUpdate(receiverGroup);
                }
            }
        }

        return receiverGroup;
    }

    public ReceiverGroup updateImpl(
        com.sgs.portlet.receivergroup.model.ReceiverGroup receiverGroup,
        boolean merge) throws SystemException {
        FinderCacheUtil.clearCache("ReceiverGroups_Receivers");

        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(receiverGroup);
            } else {
                if (receiverGroup.isNew()) {
                    session.save(receiverGroup);
                }
            }

            session.flush();

            receiverGroup.setNew(false);

            return receiverGroup;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(ReceiverGroup.class.getName());
        }
    }

    public ReceiverGroup findByPrimaryKey(long receiverGroupId)
        throws NoSuchException, SystemException {
        ReceiverGroup receiverGroup = fetchByPrimaryKey(receiverGroupId);

        if (receiverGroup == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No ReceiverGroup exists with the primary key " +
                    receiverGroupId);
            }

            throw new NoSuchException(
                "No ReceiverGroup exists with the primary key " +
                receiverGroupId);
        }

        return receiverGroup;
    }

    public ReceiverGroup fetchByPrimaryKey(long receiverGroupId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (ReceiverGroup) session.get(ReceiverGroupImpl.class,
                new Long(receiverGroupId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public ReceiverGroup findByUID_Name(long userId, String receiverGroupName)
        throws NoSuchException, SystemException {
        ReceiverGroup receiverGroup = fetchByUID_Name(userId, receiverGroupName);

        if (receiverGroup == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("receiverGroupName=" + receiverGroupName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchException(msg.toString());
        }

        return receiverGroup;
    }

    public ReceiverGroup fetchByUID_Name(long userId, String receiverGroupName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "fetchByUID_Name";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(userId), receiverGroupName };

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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                if (receiverGroupName == null) {
                    query.append("receiverGroupName IS NULL");
                } else {
                    query.append("receiverGroupName = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (receiverGroupName != null) {
                    qPos.add(receiverGroupName);
                }

                List<ReceiverGroup> list = q.list();

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
            List<ReceiverGroup> list = (List<ReceiverGroup>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public List<ReceiverGroup> findByUserId(long userId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<ReceiverGroup> list = q.list();

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
            return (List<ReceiverGroup>) result;
        }
    }

    public List<ReceiverGroup> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    public List<ReceiverGroup> findByUserId(long userId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("receiverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<ReceiverGroup> list = (List<ReceiverGroup>) QueryUtil.list(q,
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
            return (List<ReceiverGroup>) result;
        }
    }

    public ReceiverGroup findByUserId_First(long userId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<ReceiverGroup> list = findByUserId(userId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup findByUserId_Last(long userId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByUserId(userId);

        List<ReceiverGroup> list = findByUserId(userId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup[] findByUserId_PrevAndNext(long receiverGroupId,
        long userId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        ReceiverGroup receiverGroup = findByPrimaryKey(receiverGroupId);

        int count = countByUserId(userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

            query.append("userId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    receiverGroup);

            ReceiverGroup[] array = new ReceiverGroupImpl[3];

            array[0] = (ReceiverGroup) objArray[0];
            array[1] = (ReceiverGroup) objArray[1];
            array[2] = (ReceiverGroup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<ReceiverGroup> findByUserId_Type(long userId, int type)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "findByUserId_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(userId), new Integer(type) };

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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(type);

                List<ReceiverGroup> list = q.list();

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
            return (List<ReceiverGroup>) result;
        }
    }

    public List<ReceiverGroup> findByUserId_Type(long userId, int type,
        int start, int end) throws SystemException {
        return findByUserId_Type(userId, type, start, end, null);
    }

    public List<ReceiverGroup> findByUserId_Type(long userId, int type,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "findByUserId_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Integer(type),
                
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("receiverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(type);

                List<ReceiverGroup> list = (List<ReceiverGroup>) QueryUtil.list(q,
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
            return (List<ReceiverGroup>) result;
        }
    }

    public ReceiverGroup findByUserId_Type_First(long userId, int type,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<ReceiverGroup> list = findByUserId_Type(userId, type, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup findByUserId_Type_Last(long userId, int type,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByUserId_Type(userId, type);

        List<ReceiverGroup> list = findByUserId_Type(userId, type, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup[] findByUserId_Type_PrevAndNext(long receiverGroupId,
        long userId, int type, OrderByComparator obc)
        throws NoSuchException, SystemException {
        ReceiverGroup receiverGroup = findByPrimaryKey(receiverGroupId);

        int count = countByUserId_Type(userId, type);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

            query.append("userId = ?");

            query.append(" AND ");

            query.append("type_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            qPos.add(type);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    receiverGroup);

            ReceiverGroup[] array = new ReceiverGroupImpl[3];

            array[0] = (ReceiverGroup) objArray[0];
            array[1] = (ReceiverGroup) objArray[1];
            array[2] = (ReceiverGroup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<ReceiverGroup> findByUserId_Type_Active(long userId, int type,
        boolean active) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "findByUserId_Type_Active";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Integer(type), Boolean.valueOf(active)
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(type);

                qPos.add(active);

                List<ReceiverGroup> list = q.list();

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
            return (List<ReceiverGroup>) result;
        }
    }

    public List<ReceiverGroup> findByUserId_Type_Active(long userId, int type,
        boolean active, int start, int end) throws SystemException {
        return findByUserId_Type_Active(userId, type, active, start, end, null);
    }

    public List<ReceiverGroup> findByUserId_Type_Active(long userId, int type,
        boolean active, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "findByUserId_Type_Active";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                Boolean.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Integer(type), Boolean.valueOf(active),
                
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("receiverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(type);

                qPos.add(active);

                List<ReceiverGroup> list = (List<ReceiverGroup>) QueryUtil.list(q,
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
            return (List<ReceiverGroup>) result;
        }
    }

    public ReceiverGroup findByUserId_Type_Active_First(long userId, int type,
        boolean active, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<ReceiverGroup> list = findByUserId_Type_Active(userId, type,
                active, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup findByUserId_Type_Active_Last(long userId, int type,
        boolean active, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByUserId_Type_Active(userId, type, active);

        List<ReceiverGroup> list = findByUserId_Type_Active(userId, type,
                active, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup[] findByUserId_Type_Active_PrevAndNext(
        long receiverGroupId, long userId, int type, boolean active,
        OrderByComparator obc) throws NoSuchException, SystemException {
        ReceiverGroup receiverGroup = findByPrimaryKey(receiverGroupId);

        int count = countByUserId_Type_Active(userId, type, active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

            query.append("userId = ?");

            query.append(" AND ");

            query.append("type_ = ?");

            query.append(" AND ");

            query.append("active_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            qPos.add(type);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    receiverGroup);

            ReceiverGroup[] array = new ReceiverGroupImpl[3];

            array[0] = (ReceiverGroup) objArray[0];
            array[1] = (ReceiverGroup) objArray[1];
            array[2] = (ReceiverGroup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<ReceiverGroup> findByUserId_Active(long userId, boolean active)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "findByUserId_Active";
        String[] finderParams = new String[] {
                Long.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), Boolean.valueOf(active)
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(active);

                List<ReceiverGroup> list = q.list();

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
            return (List<ReceiverGroup>) result;
        }
    }

    public List<ReceiverGroup> findByUserId_Active(long userId, boolean active,
        int start, int end) throws SystemException {
        return findByUserId_Active(userId, active, start, end, null);
    }

    public List<ReceiverGroup> findByUserId_Active(long userId, boolean active,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "findByUserId_Active";
        String[] finderParams = new String[] {
                Long.class.getName(), Boolean.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), Boolean.valueOf(active),
                
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("receiverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(active);

                List<ReceiverGroup> list = (List<ReceiverGroup>) QueryUtil.list(q,
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
            return (List<ReceiverGroup>) result;
        }
    }

    public ReceiverGroup findByUserId_Active_First(long userId, boolean active,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<ReceiverGroup> list = findByUserId_Active(userId, active, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup findByUserId_Active_Last(long userId, boolean active,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByUserId_Active(userId, active);

        List<ReceiverGroup> list = findByUserId_Active(userId, active,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup[] findByUserId_Active_PrevAndNext(
        long receiverGroupId, long userId, boolean active, OrderByComparator obc)
        throws NoSuchException, SystemException {
        ReceiverGroup receiverGroup = findByPrimaryKey(receiverGroupId);

        int count = countByUserId_Active(userId, active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

            query.append("userId = ?");

            query.append(" AND ");

            query.append("active_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    receiverGroup);

            ReceiverGroup[] array = new ReceiverGroupImpl[3];

            array[0] = (ReceiverGroup) objArray[0];
            array[1] = (ReceiverGroup) objArray[1];
            array[2] = (ReceiverGroup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<ReceiverGroup> findByUserName(String userName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "findByUserName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { userName };

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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                List<ReceiverGroup> list = q.list();

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
            return (List<ReceiverGroup>) result;
        }
    }

    public List<ReceiverGroup> findByUserName(String userName, int start,
        int end) throws SystemException {
        return findByUserName(userName, start, end, null);
    }

    public List<ReceiverGroup> findByUserName(String userName, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "findByUserName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                userName,
                
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("receiverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                List<ReceiverGroup> list = (List<ReceiverGroup>) QueryUtil.list(q,
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
            return (List<ReceiverGroup>) result;
        }
    }

    public ReceiverGroup findByUserName_First(String userName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<ReceiverGroup> list = findByUserName(userName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userName=" + userName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup findByUserName_Last(String userName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByUserName(userName);

        List<ReceiverGroup> list = findByUserName(userName, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userName=" + userName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup[] findByUserName_PrevAndNext(long receiverGroupId,
        String userName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        ReceiverGroup receiverGroup = findByPrimaryKey(receiverGroupId);

        int count = countByUserName(userName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

            if (userName == null) {
                query.append("userName IS NULL");
            } else {
                query.append("userName = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (userName != null) {
                qPos.add(userName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    receiverGroup);

            ReceiverGroup[] array = new ReceiverGroupImpl[3];

            array[0] = (ReceiverGroup) objArray[0];
            array[1] = (ReceiverGroup) objArray[1];
            array[2] = (ReceiverGroup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<ReceiverGroup> findByUserName_Type(String userName, int type)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "findByUserName_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { userName, new Integer(type) };

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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(type);

                List<ReceiverGroup> list = q.list();

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
            return (List<ReceiverGroup>) result;
        }
    }

    public List<ReceiverGroup> findByUserName_Type(String userName, int type,
        int start, int end) throws SystemException {
        return findByUserName_Type(userName, type, start, end, null);
    }

    public List<ReceiverGroup> findByUserName_Type(String userName, int type,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "findByUserName_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                userName, new Integer(type),
                
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("receiverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(type);

                List<ReceiverGroup> list = (List<ReceiverGroup>) QueryUtil.list(q,
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
            return (List<ReceiverGroup>) result;
        }
    }

    public ReceiverGroup findByUserName_Type_First(String userName, int type,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<ReceiverGroup> list = findByUserName_Type(userName, type, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup findByUserName_Type_Last(String userName, int type,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByUserName_Type(userName, type);

        List<ReceiverGroup> list = findByUserName_Type(userName, type,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup[] findByUserName_Type_PrevAndNext(
        long receiverGroupId, String userName, int type, OrderByComparator obc)
        throws NoSuchException, SystemException {
        ReceiverGroup receiverGroup = findByPrimaryKey(receiverGroupId);

        int count = countByUserName_Type(userName, type);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

            if (userName == null) {
                query.append("userName IS NULL");
            } else {
                query.append("userName = ?");
            }

            query.append(" AND ");

            query.append("type_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (userName != null) {
                qPos.add(userName);
            }

            qPos.add(type);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    receiverGroup);

            ReceiverGroup[] array = new ReceiverGroupImpl[3];

            array[0] = (ReceiverGroup) objArray[0];
            array[1] = (ReceiverGroup) objArray[1];
            array[2] = (ReceiverGroup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<ReceiverGroup> findByUserName_Active(String userName,
        boolean active) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "findByUserName_Active";
        String[] finderParams = new String[] {
                String.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] { userName, Boolean.valueOf(active) };

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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(active);

                List<ReceiverGroup> list = q.list();

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
            return (List<ReceiverGroup>) result;
        }
    }

    public List<ReceiverGroup> findByUserName_Active(String userName,
        boolean active, int start, int end) throws SystemException {
        return findByUserName_Active(userName, active, start, end, null);
    }

    public List<ReceiverGroup> findByUserName_Active(String userName,
        boolean active, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "findByUserName_Active";
        String[] finderParams = new String[] {
                String.class.getName(), Boolean.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                userName, Boolean.valueOf(active),
                
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("receiverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(active);

                List<ReceiverGroup> list = (List<ReceiverGroup>) QueryUtil.list(q,
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
            return (List<ReceiverGroup>) result;
        }
    }

    public ReceiverGroup findByUserName_Active_First(String userName,
        boolean active, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<ReceiverGroup> list = findByUserName_Active(userName, active, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup findByUserName_Active_Last(String userName,
        boolean active, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByUserName_Active(userName, active);

        List<ReceiverGroup> list = findByUserName_Active(userName, active,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ReceiverGroup exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ReceiverGroup[] findByUserName_Active_PrevAndNext(
        long receiverGroupId, String userName, boolean active,
        OrderByComparator obc) throws NoSuchException, SystemException {
        ReceiverGroup receiverGroup = findByPrimaryKey(receiverGroupId);

        int count = countByUserName_Active(userName, active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

            if (userName == null) {
                query.append("userName IS NULL");
            } else {
                query.append("userName = ?");
            }

            query.append(" AND ");

            query.append("active_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("receiverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (userName != null) {
                qPos.add(userName);
            }

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    receiverGroup);

            ReceiverGroup[] array = new ReceiverGroupImpl[3];

            array[0] = (ReceiverGroup) objArray[0];
            array[1] = (ReceiverGroup) objArray[1];
            array[2] = (ReceiverGroup) objArray[2];

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

    public List<ReceiverGroup> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<ReceiverGroup> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<ReceiverGroup> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("receiverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                List<ReceiverGroup> list = (List<ReceiverGroup>) QueryUtil.list(q,
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
            return (List<ReceiverGroup>) result;
        }
    }

    public void removeByUID_Name(long userId, String receiverGroupName)
        throws NoSuchException, SystemException {
        ReceiverGroup receiverGroup = findByUID_Name(userId, receiverGroupName);

        remove(receiverGroup);
    }

    public void removeByUserId(long userId) throws SystemException {
        for (ReceiverGroup receiverGroup : findByUserId(userId)) {
            remove(receiverGroup);
        }
    }

    public void removeByUserId_Type(long userId, int type)
        throws SystemException {
        for (ReceiverGroup receiverGroup : findByUserId_Type(userId, type)) {
            remove(receiverGroup);
        }
    }

    public void removeByUserId_Type_Active(long userId, int type, boolean active)
        throws SystemException {
        for (ReceiverGroup receiverGroup : findByUserId_Type_Active(userId,
                type, active)) {
            remove(receiverGroup);
        }
    }

    public void removeByUserId_Active(long userId, boolean active)
        throws SystemException {
        for (ReceiverGroup receiverGroup : findByUserId_Active(userId, active)) {
            remove(receiverGroup);
        }
    }

    public void removeByUserName(String userName) throws SystemException {
        for (ReceiverGroup receiverGroup : findByUserName(userName)) {
            remove(receiverGroup);
        }
    }

    public void removeByUserName_Type(String userName, int type)
        throws SystemException {
        for (ReceiverGroup receiverGroup : findByUserName_Type(userName, type)) {
            remove(receiverGroup);
        }
    }

    public void removeByUserName_Active(String userName, boolean active)
        throws SystemException {
        for (ReceiverGroup receiverGroup : findByUserName_Active(userName,
                active)) {
            remove(receiverGroup);
        }
    }

    public void removeAll() throws SystemException {
        for (ReceiverGroup receiverGroup : findAll()) {
            remove(receiverGroup);
        }
    }

    public int countByUID_Name(long userId, String receiverGroupName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "countByUID_Name";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(userId), receiverGroupName };

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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                if (receiverGroupName == null) {
                    query.append("receiverGroupName IS NULL");
                } else {
                    query.append("receiverGroupName = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (receiverGroupName != null) {
                    qPos.add(receiverGroupName);
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
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

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

    public int countByUserId_Type(long userId, int type)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "countByUserId_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(userId), new Integer(type) };

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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(type);

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

    public int countByUserId_Type_Active(long userId, int type, boolean active)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "countByUserId_Type_Active";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Integer(type), Boolean.valueOf(active)
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(type);

                qPos.add(active);

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

    public int countByUserId_Active(long userId, boolean active)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "countByUserId_Active";
        String[] finderParams = new String[] {
                Long.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), Boolean.valueOf(active)
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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(active);

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

    public int countByUserName(String userName) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "countByUserName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { userName };

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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
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

    public int countByUserName_Type(String userName, int type)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "countByUserName_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { userName, new Integer(type) };

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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(type);

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

    public int countByUserName_Active(String userName, boolean active)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
        String finderMethodName = "countByUserName_Active";
        String[] finderParams = new String[] {
                String.class.getName(), Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] { userName, Boolean.valueOf(active) };

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
                    "FROM com.sgs.portlet.receivergroup.model.ReceiverGroup WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(active);

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
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = ReceiverGroup.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.receivergroup.model.ReceiverGroup");

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

    public List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        long pk) throws SystemException {
        return getReceivers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    public List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        long pk, int start, int end) throws SystemException {
        return getReceivers(pk, start, end, null);
    }

    public List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        long pk, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED_RECEIVERGROUPS_RECEIVERS;

        String finderClassName = "ReceiverGroups_Receivers";

        String finderMethodName = "getReceivers";
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

                sb.append(_SQL_GETRECEIVERS);

                if (obc != null) {
                    sb.append("ORDER BY ");
                    sb.append(obc.getOrderBy());
                }

                String sql = sb.toString();

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("pml_Receiver",
                    com.sgs.portlet.receivergroup.model.impl.ReceiverImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                List<com.sgs.portlet.receivergroup.model.Receiver> list = (List<com.sgs.portlet.receivergroup.model.Receiver>) QueryUtil.list(q,
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
            return (List<com.sgs.portlet.receivergroup.model.Receiver>) result;
        }
    }

    public int getReceiversSize(long pk) throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED_RECEIVERGROUPS_RECEIVERS;

        String finderClassName = "ReceiverGroups_Receivers";

        String finderMethodName = "getReceiversSize";
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

                SQLQuery q = session.createSQLQuery(_SQL_GETRECEIVERSSIZE);

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

    public boolean containsReceiver(long pk, long receiverPK)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ReceiverGroupModelImpl.CACHE_ENABLED_RECEIVERGROUPS_RECEIVERS;

        String finderClassName = "ReceiverGroups_Receivers";

        String finderMethodName = "containsReceivers";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(pk), new Long(receiverPK) };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            try {
                Boolean value = Boolean.valueOf(containsReceiver.contains(pk,
                            receiverPK));

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

    public boolean containsReceivers(long pk) throws SystemException {
        if (getReceiversSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addReceiver(long pk, long receiverPK) throws SystemException {
        try {
            addReceiver.add(pk, receiverPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void addReceiver(long pk,
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws SystemException {
        try {
            addReceiver.add(pk, receiver.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void addReceivers(long pk, long[] receiverPKs)
        throws SystemException {
        try {
            for (long receiverPK : receiverPKs) {
                addReceiver.add(pk, receiverPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void addReceivers(long pk,
        List<com.sgs.portlet.receivergroup.model.Receiver> receivers)
        throws SystemException {
        try {
            for (com.sgs.portlet.receivergroup.model.Receiver receiver : receivers) {
                addReceiver.add(pk, receiver.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void clearReceivers(long pk) throws SystemException {
        try {
            clearReceivers.clear(pk);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void removeReceiver(long pk, long receiverPK)
        throws SystemException {
        try {
            removeReceiver.remove(pk, receiverPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void removeReceiver(long pk,
        com.sgs.portlet.receivergroup.model.Receiver receiver)
        throws SystemException {
        try {
            removeReceiver.remove(pk, receiver.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void removeReceivers(long pk, long[] receiverPKs)
        throws SystemException {
        try {
            for (long receiverPK : receiverPKs) {
                removeReceiver.remove(pk, receiverPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void removeReceivers(long pk,
        List<com.sgs.portlet.receivergroup.model.Receiver> receivers)
        throws SystemException {
        try {
            for (com.sgs.portlet.receivergroup.model.Receiver receiver : receivers) {
                removeReceiver.remove(pk, receiver.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void setReceivers(long pk, long[] receiverPKs)
        throws SystemException {
        try {
            clearReceivers.clear(pk);

            for (long receiverPK : receiverPKs) {
                addReceiver.add(pk, receiverPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("ReceiverGroups_Receivers");
        }
    }

    public void setReceivers(long pk,
        List<com.sgs.portlet.receivergroup.model.Receiver> receivers)
        throws SystemException {
        try {
            clearReceivers.clear(pk);

            for (com.sgs.portlet.receivergroup.model.Receiver receiver : receivers) {
                addReceiver.add(pk, receiver.getPrimaryKey());
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
                        "value.object.listener.com.sgs.portlet.receivergroup.model.ReceiverGroup")));

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

        containsReceiver = new ContainsReceiver(this);

        addReceiver = new AddReceiver(this);
        clearReceivers = new ClearReceivers(this);
        removeReceiver = new RemoveReceiver(this);
    }

    protected class ContainsReceiver {
        private MappingSqlQuery _mappingSqlQuery;

        protected ContainsReceiver(ReceiverGroupPersistenceImpl persistenceImpl) {
            super();

            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSRECEIVER,
                    new int[] { Types.BIGINT, Types.BIGINT }, RowMapper.COUNT);
        }

        protected boolean contains(long receiverGroupId, long receiverId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(receiverGroupId), new Long(receiverId)
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

    protected class AddReceiver {
        private SqlUpdate _sqlUpdate;
        private ReceiverGroupPersistenceImpl _persistenceImpl;

        protected AddReceiver(ReceiverGroupPersistenceImpl persistenceImpl) {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "INSERT INTO ReceiverGroups_Receivers (receiverGroupId, receiverId) VALUES (?, ?)",
                    new int[] { Types.BIGINT, Types.BIGINT });
            _persistenceImpl = persistenceImpl;
        }

        protected void add(long receiverGroupId, long receiverId) {
            if (!_persistenceImpl.containsReceiver.contains(receiverGroupId,
                        receiverId)) {
                _sqlUpdate.update(new Object[] {
                        new Long(receiverGroupId), new Long(receiverId)
                    });
            }
        }
    }

    protected class ClearReceivers {
        private SqlUpdate _sqlUpdate;

        protected ClearReceivers(ReceiverGroupPersistenceImpl persistenceImpl) {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM ReceiverGroups_Receivers WHERE receiverGroupId = ?",
                    new int[] { Types.BIGINT });
        }

        protected void clear(long receiverGroupId) {
            _sqlUpdate.update(new Object[] { new Long(receiverGroupId) });
        }
    }

    protected class RemoveReceiver {
        private SqlUpdate _sqlUpdate;

        protected RemoveReceiver(ReceiverGroupPersistenceImpl persistenceImpl) {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM ReceiverGroups_Receivers WHERE receiverGroupId = ? AND receiverId = ?",
                    new int[] { Types.BIGINT, Types.BIGINT });
        }

        protected void remove(long receiverGroupId, long receiverId) {
            _sqlUpdate.update(new Object[] {
                    new Long(receiverGroupId), new Long(receiverId)
                });
        }
    }
}
