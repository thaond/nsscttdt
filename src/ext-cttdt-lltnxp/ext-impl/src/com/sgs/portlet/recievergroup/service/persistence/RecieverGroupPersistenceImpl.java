package com.sgs.portlet.recievergroup.service.persistence;

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

import com.sgs.portlet.recievergroup.NoSuchException;
import com.sgs.portlet.recievergroup.model.RecieverGroup;
import com.sgs.portlet.recievergroup.model.impl.RecieverGroupImpl;
import com.sgs.portlet.recievergroup.model.impl.RecieverGroupModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class RecieverGroupPersistenceImpl extends BasePersistenceImpl
    implements RecieverGroupPersistence {
    private static final String _SQL_GETRECIEVERS = "SELECT {pml_Reciever.*} FROM pml_Reciever INNER JOIN RecieverGroups_Recievers ON (RecieverGroups_Recievers.recieverId = pml_Reciever.recieverId) WHERE (RecieverGroups_Recievers.recieverGroupId = ?)";
    private static final String _SQL_GETRECIEVERSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM RecieverGroups_Recievers WHERE recieverGroupId = ?";
    private static final String _SQL_CONTAINSRECIEVER = "SELECT COUNT(*) AS COUNT_VALUE FROM RecieverGroups_Recievers WHERE recieverGroupId = ? AND recieverId = ?";
    private static Log _log = LogFactory.getLog(RecieverGroupPersistenceImpl.class);
    protected ContainsReciever containsReciever;
    protected AddReciever addReciever;
    protected ClearRecievers clearRecievers;
    protected RemoveReciever removeReciever;
    private ModelListener[] _listeners = new ModelListener[0];

    public RecieverGroup create(long recieverGroupId) {
        RecieverGroup recieverGroup = new RecieverGroupImpl();

        recieverGroup.setNew(true);
        recieverGroup.setPrimaryKey(recieverGroupId);

        return recieverGroup;
    }

    public RecieverGroup remove(long recieverGroupId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            RecieverGroup recieverGroup = (RecieverGroup) session.get(RecieverGroupImpl.class,
                    new Long(recieverGroupId));

            if (recieverGroup == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No RecieverGroup exists with the primary key " +
                        recieverGroupId);
                }

                throw new NoSuchException(
                    "No RecieverGroup exists with the primary key " +
                    recieverGroupId);
            }

            return remove(recieverGroup);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public RecieverGroup remove(RecieverGroup recieverGroup)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(recieverGroup);
            }
        }

        recieverGroup = removeImpl(recieverGroup);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(recieverGroup);
            }
        }

        return recieverGroup;
    }

    protected RecieverGroup removeImpl(RecieverGroup recieverGroup)
        throws SystemException {
        try {
            clearRecievers.clear(recieverGroup.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }

        Session session = null;

        try {
            session = openSession();

            session.delete(recieverGroup);

            session.flush();

            return recieverGroup;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(RecieverGroup.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(RecieverGroup recieverGroup, boolean merge)</code>.
     */
    public RecieverGroup update(RecieverGroup recieverGroup)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(RecieverGroup recieverGroup) method. Use update(RecieverGroup recieverGroup, boolean merge) instead.");
        }

        return update(recieverGroup, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                recieverGroup the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when recieverGroup is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public RecieverGroup update(RecieverGroup recieverGroup, boolean merge)
        throws SystemException {
        boolean isNew = recieverGroup.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(recieverGroup);
                } else {
                    listener.onBeforeUpdate(recieverGroup);
                }
            }
        }

        recieverGroup = updateImpl(recieverGroup, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(recieverGroup);
                } else {
                    listener.onAfterUpdate(recieverGroup);
                }
            }
        }

        return recieverGroup;
    }

    public RecieverGroup updateImpl(
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup,
        boolean merge) throws SystemException {
        FinderCacheUtil.clearCache("RecieverGroups_Recievers");

        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(recieverGroup);
            } else {
                if (recieverGroup.isNew()) {
                    session.save(recieverGroup);
                }
            }

            session.flush();

            recieverGroup.setNew(false);

            return recieverGroup;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(RecieverGroup.class.getName());
        }
    }

    public RecieverGroup findByPrimaryKey(long recieverGroupId)
        throws NoSuchException, SystemException {
        RecieverGroup recieverGroup = fetchByPrimaryKey(recieverGroupId);

        if (recieverGroup == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No RecieverGroup exists with the primary key " +
                    recieverGroupId);
            }

            throw new NoSuchException(
                "No RecieverGroup exists with the primary key " +
                recieverGroupId);
        }

        return recieverGroup;
    }

    public RecieverGroup fetchByPrimaryKey(long recieverGroupId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (RecieverGroup) session.get(RecieverGroupImpl.class,
                new Long(recieverGroupId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public RecieverGroup findByUID_Name(long userId, String recieverGroupName)
        throws NoSuchException, SystemException {
        RecieverGroup recieverGroup = fetchByUID_Name(userId, recieverGroupName);

        if (recieverGroup == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("recieverGroupName=" + recieverGroupName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchException(msg.toString());
        }

        return recieverGroup;
    }

    public RecieverGroup fetchByUID_Name(long userId, String recieverGroupName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
        String finderMethodName = "fetchByUID_Name";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(userId), recieverGroupName };

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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                if (recieverGroupName == null) {
                    query.append("recieverGroupName IS NULL");
                } else {
                    query.append("recieverGroupName = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("recieverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (recieverGroupName != null) {
                    qPos.add(recieverGroupName);
                }

                List<RecieverGroup> list = q.list();

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
            List<RecieverGroup> list = (List<RecieverGroup>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public List<RecieverGroup> findByUserId(long userId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

                query.append("userId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("recieverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<RecieverGroup> list = q.list();

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
            return (List<RecieverGroup>) result;
        }
    }

    public List<RecieverGroup> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    public List<RecieverGroup> findByUserId(long userId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

                query.append("userId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("recieverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<RecieverGroup> list = (List<RecieverGroup>) QueryUtil.list(q,
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
            return (List<RecieverGroup>) result;
        }
    }

    public RecieverGroup findByUserId_First(long userId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<RecieverGroup> list = findByUserId(userId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RecieverGroup findByUserId_Last(long userId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByUserId(userId);

        List<RecieverGroup> list = findByUserId(userId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RecieverGroup[] findByUserId_PrevAndNext(long recieverGroupId,
        long userId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        RecieverGroup recieverGroup = findByPrimaryKey(recieverGroupId);

        int count = countByUserId(userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

            query.append("userId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("recieverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    recieverGroup);

            RecieverGroup[] array = new RecieverGroupImpl[3];

            array[0] = (RecieverGroup) objArray[0];
            array[1] = (RecieverGroup) objArray[1];
            array[2] = (RecieverGroup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<RecieverGroup> findByUserId_Type(long userId, int type)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("recieverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(type);

                List<RecieverGroup> list = q.list();

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
            return (List<RecieverGroup>) result;
        }
    }

    public List<RecieverGroup> findByUserId_Type(long userId, int type,
        int start, int end) throws SystemException {
        return findByUserId_Type(userId, type, start, end, null);
    }

    public List<RecieverGroup> findByUserId_Type(long userId, int type,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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

                    query.append("recieverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(type);

                List<RecieverGroup> list = (List<RecieverGroup>) QueryUtil.list(q,
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
            return (List<RecieverGroup>) result;
        }
    }

    public RecieverGroup findByUserId_Type_First(long userId, int type,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<RecieverGroup> list = findByUserId_Type(userId, type, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RecieverGroup findByUserId_Type_Last(long userId, int type,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByUserId_Type(userId, type);

        List<RecieverGroup> list = findByUserId_Type(userId, type, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RecieverGroup[] findByUserId_Type_PrevAndNext(long recieverGroupId,
        long userId, int type, OrderByComparator obc)
        throws NoSuchException, SystemException {
        RecieverGroup recieverGroup = findByPrimaryKey(recieverGroupId);

        int count = countByUserId_Type(userId, type);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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

                query.append("recieverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            qPos.add(type);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    recieverGroup);

            RecieverGroup[] array = new RecieverGroupImpl[3];

            array[0] = (RecieverGroup) objArray[0];
            array[1] = (RecieverGroup) objArray[1];
            array[2] = (RecieverGroup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<RecieverGroup> findByUserId_Type_Active(long userId, int type,
        boolean active) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("recieverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(type);

                qPos.add(active);

                List<RecieverGroup> list = q.list();

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
            return (List<RecieverGroup>) result;
        }
    }

    public List<RecieverGroup> findByUserId_Type_Active(long userId, int type,
        boolean active, int start, int end) throws SystemException {
        return findByUserId_Type_Active(userId, type, active, start, end, null);
    }

    public List<RecieverGroup> findByUserId_Type_Active(long userId, int type,
        boolean active, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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

                    query.append("recieverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(type);

                qPos.add(active);

                List<RecieverGroup> list = (List<RecieverGroup>) QueryUtil.list(q,
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
            return (List<RecieverGroup>) result;
        }
    }

    public RecieverGroup findByUserId_Type_Active_First(long userId, int type,
        boolean active, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<RecieverGroup> list = findByUserId_Type_Active(userId, type,
                active, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

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

    public RecieverGroup findByUserId_Type_Active_Last(long userId, int type,
        boolean active, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByUserId_Type_Active(userId, type, active);

        List<RecieverGroup> list = findByUserId_Type_Active(userId, type,
                active, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

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

    public RecieverGroup[] findByUserId_Type_Active_PrevAndNext(
        long recieverGroupId, long userId, int type, boolean active,
        OrderByComparator obc) throws NoSuchException, SystemException {
        RecieverGroup recieverGroup = findByPrimaryKey(recieverGroupId);

        int count = countByUserId_Type_Active(userId, type, active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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

                query.append("recieverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            qPos.add(type);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    recieverGroup);

            RecieverGroup[] array = new RecieverGroupImpl[3];

            array[0] = (RecieverGroup) objArray[0];
            array[1] = (RecieverGroup) objArray[1];
            array[2] = (RecieverGroup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<RecieverGroup> findByUserId_Active(long userId, boolean active)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("recieverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(active);

                List<RecieverGroup> list = q.list();

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
            return (List<RecieverGroup>) result;
        }
    }

    public List<RecieverGroup> findByUserId_Active(long userId, boolean active,
        int start, int end) throws SystemException {
        return findByUserId_Active(userId, active, start, end, null);
    }

    public List<RecieverGroup> findByUserId_Active(long userId, boolean active,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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

                    query.append("recieverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(active);

                List<RecieverGroup> list = (List<RecieverGroup>) QueryUtil.list(q,
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
            return (List<RecieverGroup>) result;
        }
    }

    public RecieverGroup findByUserId_Active_First(long userId, boolean active,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<RecieverGroup> list = findByUserId_Active(userId, active, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RecieverGroup findByUserId_Active_Last(long userId, boolean active,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByUserId_Active(userId, active);

        List<RecieverGroup> list = findByUserId_Active(userId, active,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RecieverGroup[] findByUserId_Active_PrevAndNext(
        long recieverGroupId, long userId, boolean active, OrderByComparator obc)
        throws NoSuchException, SystemException {
        RecieverGroup recieverGroup = findByPrimaryKey(recieverGroupId);

        int count = countByUserId_Active(userId, active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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

                query.append("recieverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    recieverGroup);

            RecieverGroup[] array = new RecieverGroupImpl[3];

            array[0] = (RecieverGroup) objArray[0];
            array[1] = (RecieverGroup) objArray[1];
            array[2] = (RecieverGroup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<RecieverGroup> findByUserName(String userName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("recieverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                List<RecieverGroup> list = q.list();

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
            return (List<RecieverGroup>) result;
        }
    }

    public List<RecieverGroup> findByUserName(String userName, int start,
        int end) throws SystemException {
        return findByUserName(userName, start, end, null);
    }

    public List<RecieverGroup> findByUserName(String userName, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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

                    query.append("recieverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                List<RecieverGroup> list = (List<RecieverGroup>) QueryUtil.list(q,
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
            return (List<RecieverGroup>) result;
        }
    }

    public RecieverGroup findByUserName_First(String userName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<RecieverGroup> list = findByUserName(userName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userName=" + userName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RecieverGroup findByUserName_Last(String userName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByUserName(userName);

        List<RecieverGroup> list = findByUserName(userName, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userName=" + userName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RecieverGroup[] findByUserName_PrevAndNext(long recieverGroupId,
        String userName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        RecieverGroup recieverGroup = findByPrimaryKey(recieverGroupId);

        int count = countByUserName(userName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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

                query.append("recieverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (userName != null) {
                qPos.add(userName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    recieverGroup);

            RecieverGroup[] array = new RecieverGroupImpl[3];

            array[0] = (RecieverGroup) objArray[0];
            array[1] = (RecieverGroup) objArray[1];
            array[2] = (RecieverGroup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<RecieverGroup> findByUserName_Type(String userName, int type)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("type_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("recieverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(type);

                List<RecieverGroup> list = q.list();

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
            return (List<RecieverGroup>) result;
        }
    }

    public List<RecieverGroup> findByUserName_Type(String userName, int type,
        int start, int end) throws SystemException {
        return findByUserName_Type(userName, type, start, end, null);
    }

    public List<RecieverGroup> findByUserName_Type(String userName, int type,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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

                    query.append("recieverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(type);

                List<RecieverGroup> list = (List<RecieverGroup>) QueryUtil.list(q,
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
            return (List<RecieverGroup>) result;
        }
    }

    public RecieverGroup findByUserName_Type_First(String userName, int type,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<RecieverGroup> list = findByUserName_Type(userName, type, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RecieverGroup findByUserName_Type_Last(String userName, int type,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByUserName_Type(userName, type);

        List<RecieverGroup> list = findByUserName_Type(userName, type,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RecieverGroup[] findByUserName_Type_PrevAndNext(
        long recieverGroupId, String userName, int type, OrderByComparator obc)
        throws NoSuchException, SystemException {
        RecieverGroup recieverGroup = findByPrimaryKey(recieverGroupId);

        int count = countByUserName_Type(userName, type);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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

                query.append("recieverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (userName != null) {
                qPos.add(userName);
            }

            qPos.add(type);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    recieverGroup);

            RecieverGroup[] array = new RecieverGroupImpl[3];

            array[0] = (RecieverGroup) objArray[0];
            array[1] = (RecieverGroup) objArray[1];
            array[2] = (RecieverGroup) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<RecieverGroup> findByUserName_Active(String userName,
        boolean active) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("active_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("recieverGroupName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(active);

                List<RecieverGroup> list = q.list();

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
            return (List<RecieverGroup>) result;
        }
    }

    public List<RecieverGroup> findByUserName_Active(String userName,
        boolean active, int start, int end) throws SystemException {
        return findByUserName_Active(userName, active, start, end, null);
    }

    public List<RecieverGroup> findByUserName_Active(String userName,
        boolean active, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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

                    query.append("recieverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(active);

                List<RecieverGroup> list = (List<RecieverGroup>) QueryUtil.list(q,
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
            return (List<RecieverGroup>) result;
        }
    }

    public RecieverGroup findByUserName_Active_First(String userName,
        boolean active, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<RecieverGroup> list = findByUserName_Active(userName, active, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RecieverGroup findByUserName_Active_Last(String userName,
        boolean active, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByUserName_Active(userName, active);

        List<RecieverGroup> list = findByUserName_Active(userName, active,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RecieverGroup exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("active=" + active);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RecieverGroup[] findByUserName_Active_PrevAndNext(
        long recieverGroupId, String userName, boolean active,
        OrderByComparator obc) throws NoSuchException, SystemException {
        RecieverGroup recieverGroup = findByPrimaryKey(recieverGroupId);

        int count = countByUserName_Active(userName, active);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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

                query.append("recieverGroupName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (userName != null) {
                qPos.add(userName);
            }

            qPos.add(active);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    recieverGroup);

            RecieverGroup[] array = new RecieverGroupImpl[3];

            array[0] = (RecieverGroup) objArray[0];
            array[1] = (RecieverGroup) objArray[1];
            array[2] = (RecieverGroup) objArray[2];

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

    public List<RecieverGroup> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<RecieverGroup> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<RecieverGroup> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("recieverGroupName ASC");
                }

                Query q = session.createQuery(query.toString());

                List<RecieverGroup> list = (List<RecieverGroup>) QueryUtil.list(q,
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
            return (List<RecieverGroup>) result;
        }
    }

    public void removeByUID_Name(long userId, String recieverGroupName)
        throws NoSuchException, SystemException {
        RecieverGroup recieverGroup = findByUID_Name(userId, recieverGroupName);

        remove(recieverGroup);
    }

    public void removeByUserId(long userId) throws SystemException {
        for (RecieverGroup recieverGroup : findByUserId(userId)) {
            remove(recieverGroup);
        }
    }

    public void removeByUserId_Type(long userId, int type)
        throws SystemException {
        for (RecieverGroup recieverGroup : findByUserId_Type(userId, type)) {
            remove(recieverGroup);
        }
    }

    public void removeByUserId_Type_Active(long userId, int type, boolean active)
        throws SystemException {
        for (RecieverGroup recieverGroup : findByUserId_Type_Active(userId,
                type, active)) {
            remove(recieverGroup);
        }
    }

    public void removeByUserId_Active(long userId, boolean active)
        throws SystemException {
        for (RecieverGroup recieverGroup : findByUserId_Active(userId, active)) {
            remove(recieverGroup);
        }
    }

    public void removeByUserName(String userName) throws SystemException {
        for (RecieverGroup recieverGroup : findByUserName(userName)) {
            remove(recieverGroup);
        }
    }

    public void removeByUserName_Type(String userName, int type)
        throws SystemException {
        for (RecieverGroup recieverGroup : findByUserName_Type(userName, type)) {
            remove(recieverGroup);
        }
    }

    public void removeByUserName_Active(String userName, boolean active)
        throws SystemException {
        for (RecieverGroup recieverGroup : findByUserName_Active(userName,
                active)) {
            remove(recieverGroup);
        }
    }

    public void removeAll() throws SystemException {
        for (RecieverGroup recieverGroup : findAll()) {
            remove(recieverGroup);
        }
    }

    public int countByUID_Name(long userId, String recieverGroupName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
        String finderMethodName = "countByUID_Name";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(userId), recieverGroupName };

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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                if (recieverGroupName == null) {
                    query.append("recieverGroupName IS NULL");
                } else {
                    query.append("recieverGroupName = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (recieverGroupName != null) {
                    qPos.add(recieverGroupName);
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
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.RecieverGroup WHERE ");

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
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED;
        String finderClassName = RecieverGroup.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.recievergroup.model.RecieverGroup");

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

    public List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        long pk) throws SystemException {
        return getRecievers(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    public List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        long pk, int start, int end) throws SystemException {
        return getRecievers(pk, start, end, null);
    }

    public List<com.sgs.portlet.recievergroup.model.Reciever> getRecievers(
        long pk, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED_RECIEVERGROUPS_RECIEVERS;

        String finderClassName = "RecieverGroups_Recievers";

        String finderMethodName = "getRecievers";
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

                sb.append(_SQL_GETRECIEVERS);

                if (obc != null) {
                    sb.append("ORDER BY ");
                    sb.append(obc.getOrderBy());
                }

                String sql = sb.toString();

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("pml_Reciever",
                    com.sgs.portlet.recievergroup.model.impl.RecieverImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                List<com.sgs.portlet.recievergroup.model.Reciever> list = (List<com.sgs.portlet.recievergroup.model.Reciever>) QueryUtil.list(q,
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
            return (List<com.sgs.portlet.recievergroup.model.Reciever>) result;
        }
    }

    public int getRecieversSize(long pk) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED_RECIEVERGROUPS_RECIEVERS;

        String finderClassName = "RecieverGroups_Recievers";

        String finderMethodName = "getRecieversSize";
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

                SQLQuery q = session.createSQLQuery(_SQL_GETRECIEVERSSIZE);

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

    public boolean containsReciever(long pk, long recieverPK)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverGroupModelImpl.CACHE_ENABLED_RECIEVERGROUPS_RECIEVERS;

        String finderClassName = "RecieverGroups_Recievers";

        String finderMethodName = "containsRecievers";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(pk), new Long(recieverPK) };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            try {
                Boolean value = Boolean.valueOf(containsReciever.contains(pk,
                            recieverPK));

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

    public boolean containsRecievers(long pk) throws SystemException {
        if (getRecieversSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addReciever(long pk, long recieverPK) throws SystemException {
        try {
            addReciever.add(pk, recieverPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void addReciever(long pk,
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws SystemException {
        try {
            addReciever.add(pk, reciever.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void addRecievers(long pk, long[] recieverPKs)
        throws SystemException {
        try {
            for (long recieverPK : recieverPKs) {
                addReciever.add(pk, recieverPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void addRecievers(long pk,
        List<com.sgs.portlet.recievergroup.model.Reciever> recievers)
        throws SystemException {
        try {
            for (com.sgs.portlet.recievergroup.model.Reciever reciever : recievers) {
                addReciever.add(pk, reciever.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void clearRecievers(long pk) throws SystemException {
        try {
            clearRecievers.clear(pk);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void removeReciever(long pk, long recieverPK)
        throws SystemException {
        try {
            removeReciever.remove(pk, recieverPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void removeReciever(long pk,
        com.sgs.portlet.recievergroup.model.Reciever reciever)
        throws SystemException {
        try {
            removeReciever.remove(pk, reciever.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void removeRecievers(long pk, long[] recieverPKs)
        throws SystemException {
        try {
            for (long recieverPK : recieverPKs) {
                removeReciever.remove(pk, recieverPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void removeRecievers(long pk,
        List<com.sgs.portlet.recievergroup.model.Reciever> recievers)
        throws SystemException {
        try {
            for (com.sgs.portlet.recievergroup.model.Reciever reciever : recievers) {
                removeReciever.remove(pk, reciever.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void setRecievers(long pk, long[] recieverPKs)
        throws SystemException {
        try {
            clearRecievers.clear(pk);

            for (long recieverPK : recieverPKs) {
                addReciever.add(pk, recieverPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void setRecievers(long pk,
        List<com.sgs.portlet.recievergroup.model.Reciever> recievers)
        throws SystemException {
        try {
            clearRecievers.clear(pk);

            for (com.sgs.portlet.recievergroup.model.Reciever reciever : recievers) {
                addReciever.add(pk, reciever.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
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
                        "value.object.listener.com.sgs.portlet.recievergroup.model.RecieverGroup")));

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

        containsReciever = new ContainsReciever(this);

        addReciever = new AddReciever(this);
        clearRecievers = new ClearRecievers(this);
        removeReciever = new RemoveReciever(this);
    }

    protected class ContainsReciever {
        private MappingSqlQuery _mappingSqlQuery;

        protected ContainsReciever(RecieverGroupPersistenceImpl persistenceImpl) {
            super();

            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSRECIEVER,
                    new int[] { Types.BIGINT, Types.BIGINT }, RowMapper.COUNT);
        }

        protected boolean contains(long recieverGroupId, long recieverId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(recieverGroupId), new Long(recieverId)
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

    protected class AddReciever {
        private SqlUpdate _sqlUpdate;
        private RecieverGroupPersistenceImpl _persistenceImpl;

        protected AddReciever(RecieverGroupPersistenceImpl persistenceImpl) {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "INSERT INTO RecieverGroups_Recievers (recieverGroupId, recieverId) VALUES (?, ?)",
                    new int[] { Types.BIGINT, Types.BIGINT });
            _persistenceImpl = persistenceImpl;
        }

        protected void add(long recieverGroupId, long recieverId) {
            if (!_persistenceImpl.containsReciever.contains(recieverGroupId,
                        recieverId)) {
                _sqlUpdate.update(new Object[] {
                        new Long(recieverGroupId), new Long(recieverId)
                    });
            }
        }
    }

    protected class ClearRecievers {
        private SqlUpdate _sqlUpdate;

        protected ClearRecievers(RecieverGroupPersistenceImpl persistenceImpl) {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM RecieverGroups_Recievers WHERE recieverGroupId = ?",
                    new int[] { Types.BIGINT });
        }

        protected void clear(long recieverGroupId) {
            _sqlUpdate.update(new Object[] { new Long(recieverGroupId) });
        }
    }

    protected class RemoveReciever {
        private SqlUpdate _sqlUpdate;

        protected RemoveReciever(RecieverGroupPersistenceImpl persistenceImpl) {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM RecieverGroups_Recievers WHERE recieverGroupId = ? AND recieverId = ?",
                    new int[] { Types.BIGINT, Types.BIGINT });
        }

        protected void remove(long recieverGroupId, long recieverId) {
            _sqlUpdate.update(new Object[] {
                    new Long(recieverGroupId), new Long(recieverId)
                });
        }
    }
}
