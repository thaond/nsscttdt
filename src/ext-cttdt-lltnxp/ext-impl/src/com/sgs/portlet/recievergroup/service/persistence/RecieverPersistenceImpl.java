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

import com.sgs.portlet.recievergroup.NoSuchRecieverException;
import com.sgs.portlet.recievergroup.model.Reciever;
import com.sgs.portlet.recievergroup.model.impl.RecieverImpl;
import com.sgs.portlet.recievergroup.model.impl.RecieverModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class RecieverPersistenceImpl extends BasePersistenceImpl
    implements RecieverPersistence {
    private static final String _SQL_GETRECIEVERGROUPS = "SELECT {pml_RecieverGroup.*} FROM pml_RecieverGroup INNER JOIN RecieverGroups_Recievers ON (RecieverGroups_Recievers.recieverGroupId = pml_RecieverGroup.recieverGroupId) WHERE (RecieverGroups_Recievers.recieverId = ?)";
    private static final String _SQL_GETRECIEVERGROUPSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM RecieverGroups_Recievers WHERE recieverId = ?";
    private static final String _SQL_CONTAINSRECIEVERGROUP = "SELECT COUNT(*) AS COUNT_VALUE FROM RecieverGroups_Recievers WHERE recieverId = ? AND recieverGroupId = ?";
    private static Log _log = LogFactory.getLog(RecieverPersistenceImpl.class);
    protected ContainsRecieverGroup containsRecieverGroup;
    protected AddRecieverGroup addRecieverGroup;
    protected ClearRecieverGroups clearRecieverGroups;
    protected RemoveRecieverGroup removeRecieverGroup;
    private ModelListener[] _listeners = new ModelListener[0];

    public Reciever create(long recieverId) {
        Reciever reciever = new RecieverImpl();

        reciever.setNew(true);
        reciever.setPrimaryKey(recieverId);

        return reciever;
    }

    public Reciever remove(long recieverId)
        throws NoSuchRecieverException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Reciever reciever = (Reciever) session.get(RecieverImpl.class,
                    new Long(recieverId));

            if (reciever == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No Reciever exists with the primary key " +
                        recieverId);
                }

                throw new NoSuchRecieverException(
                    "No Reciever exists with the primary key " + recieverId);
            }

            return remove(reciever);
        } catch (NoSuchRecieverException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Reciever remove(Reciever reciever) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(reciever);
            }
        }

        reciever = removeImpl(reciever);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(reciever);
            }
        }

        return reciever;
    }

    protected Reciever removeImpl(Reciever reciever) throws SystemException {
        try {
            clearRecieverGroups.clear(reciever.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }

        Session session = null;

        try {
            session = openSession();

            session.delete(reciever);

            session.flush();

            return reciever;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Reciever.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(Reciever reciever, boolean merge)</code>.
     */
    public Reciever update(Reciever reciever) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(Reciever reciever) method. Use update(Reciever reciever, boolean merge) instead.");
        }

        return update(reciever, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                reciever the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when reciever is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public Reciever update(Reciever reciever, boolean merge)
        throws SystemException {
        boolean isNew = reciever.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(reciever);
                } else {
                    listener.onBeforeUpdate(reciever);
                }
            }
        }

        reciever = updateImpl(reciever, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(reciever);
                } else {
                    listener.onAfterUpdate(reciever);
                }
            }
        }

        return reciever;
    }

    public Reciever updateImpl(
        com.sgs.portlet.recievergroup.model.Reciever reciever, boolean merge)
        throws SystemException {
        FinderCacheUtil.clearCache("RecieverGroups_Recievers");

        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(reciever);
            } else {
                if (reciever.isNew()) {
                    session.save(reciever);
                }
            }

            session.flush();

            reciever.setNew(false);

            return reciever;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(Reciever.class.getName());
        }
    }

    public Reciever findByPrimaryKey(long recieverId)
        throws NoSuchRecieverException, SystemException {
        Reciever reciever = fetchByPrimaryKey(recieverId);

        if (reciever == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No Reciever exists with the primary key " +
                    recieverId);
            }

            throw new NoSuchRecieverException(
                "No Reciever exists with the primary key " + recieverId);
        }

        return reciever;
    }

    public Reciever fetchByPrimaryKey(long recieverId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (Reciever) session.get(RecieverImpl.class,
                new Long(recieverId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<Reciever> findByUID_Type(long userId, int recieverType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "findByUID_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Integer(recieverType)
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(recieverType);

                List<Reciever> list = q.list();

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
            return (List<Reciever>) result;
        }
    }

    public List<Reciever> findByUID_Type(long userId, int recieverType,
        int start, int end) throws SystemException {
        return findByUID_Type(userId, recieverType, start, end, null);
    }

    public List<Reciever> findByUID_Type(long userId, int recieverType,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "findByUID_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Integer(recieverType),
                
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(recieverType);

                List<Reciever> list = (List<Reciever>) QueryUtil.list(q,
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
            return (List<Reciever>) result;
        }
    }

    public Reciever findByUID_Type_First(long userId, int recieverType,
        OrderByComparator obc) throws NoSuchRecieverException, SystemException {
        List<Reciever> list = findByUID_Type(userId, recieverType, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Reciever exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("recieverType=" + recieverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchRecieverException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Reciever findByUID_Type_Last(long userId, int recieverType,
        OrderByComparator obc) throws NoSuchRecieverException, SystemException {
        int count = countByUID_Type(userId, recieverType);

        List<Reciever> list = findByUID_Type(userId, recieverType, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Reciever exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("recieverType=" + recieverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchRecieverException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Reciever[] findByUID_Type_PrevAndNext(long recieverId, long userId,
        int recieverType, OrderByComparator obc)
        throws NoSuchRecieverException, SystemException {
        Reciever reciever = findByPrimaryKey(recieverId);

        int count = countByUID_Type(userId, recieverType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

            query.append("userId = ?");

            query.append(" AND ");

            query.append("recieverType = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(userId);

            qPos.add(recieverType);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, reciever);

            Reciever[] array = new RecieverImpl[3];

            array[0] = (Reciever) objArray[0];
            array[1] = (Reciever) objArray[1];
            array[2] = (Reciever) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Reciever findByUID_RUID_Type(long userId, long recieverUserId,
        int recieverType) throws NoSuchRecieverException, SystemException {
        Reciever reciever = fetchByUID_RUID_Type(userId, recieverUserId,
                recieverType);

        if (reciever == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Reciever exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("recieverUserId=" + recieverUserId);

            msg.append(", ");
            msg.append("recieverType=" + recieverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchRecieverException(msg.toString());
        }

        return reciever;
    }

    public Reciever fetchByUID_RUID_Type(long userId, long recieverUserId,
        int recieverType) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "fetchByUID_RUID_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Long(recieverUserId),
                new Integer(recieverType)
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("recieverUserId = ?");

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(recieverUserId);

                qPos.add(recieverType);

                List<Reciever> list = q.list();

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
            List<Reciever> list = (List<Reciever>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public Reciever findByUID_RCN_Type(long userId, String recieverUserName,
        int recieverType) throws NoSuchRecieverException, SystemException {
        Reciever reciever = fetchByUID_RCN_Type(userId, recieverUserName,
                recieverType);

        if (reciever == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Reciever exists with the key {");

            msg.append("userId=" + userId);

            msg.append(", ");
            msg.append("recieverUserName=" + recieverUserName);

            msg.append(", ");
            msg.append("recieverType=" + recieverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchRecieverException(msg.toString());
        }

        return reciever;
    }

    public Reciever fetchByUID_RCN_Type(long userId, String recieverUserName,
        int recieverType) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "fetchByUID_RCN_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId),
                
                recieverUserName, new Integer(recieverType)
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                if (recieverUserName == null) {
                    query.append("recieverUserName IS NULL");
                } else {
                    query.append("recieverUserName = ?");
                }

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (recieverUserName != null) {
                    qPos.add(recieverUserName);
                }

                qPos.add(recieverType);

                List<Reciever> list = q.list();

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
            List<Reciever> list = (List<Reciever>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public List<Reciever> findByUCN_Type(String userName, int recieverType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "findByUCN_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { userName, new Integer(recieverType) };

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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(recieverType);

                List<Reciever> list = q.list();

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
            return (List<Reciever>) result;
        }
    }

    public List<Reciever> findByUCN_Type(String userName, int recieverType,
        int start, int end) throws SystemException {
        return findByUCN_Type(userName, recieverType, start, end, null);
    }

    public List<Reciever> findByUCN_Type(String userName, int recieverType,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "findByUCN_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                userName, new Integer(recieverType),
                
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("recieverType = ?");

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

                qPos.add(recieverType);

                List<Reciever> list = (List<Reciever>) QueryUtil.list(q,
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
            return (List<Reciever>) result;
        }
    }

    public Reciever findByUCN_Type_First(String userName, int recieverType,
        OrderByComparator obc) throws NoSuchRecieverException, SystemException {
        List<Reciever> list = findByUCN_Type(userName, recieverType, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Reciever exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("recieverType=" + recieverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchRecieverException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Reciever findByUCN_Type_Last(String userName, int recieverType,
        OrderByComparator obc) throws NoSuchRecieverException, SystemException {
        int count = countByUCN_Type(userName, recieverType);

        List<Reciever> list = findByUCN_Type(userName, recieverType, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Reciever exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("recieverType=" + recieverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchRecieverException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public Reciever[] findByUCN_Type_PrevAndNext(long recieverId,
        String userName, int recieverType, OrderByComparator obc)
        throws NoSuchRecieverException, SystemException {
        Reciever reciever = findByPrimaryKey(recieverId);

        int count = countByUCN_Type(userName, recieverType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

            if (userName == null) {
                query.append("userName IS NULL");
            } else {
                query.append("userName = ?");
            }

            query.append(" AND ");

            query.append("recieverType = ?");

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

            qPos.add(recieverType);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc, reciever);

            Reciever[] array = new RecieverImpl[3];

            array[0] = (Reciever) objArray[0];
            array[1] = (Reciever) objArray[1];
            array[2] = (Reciever) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public Reciever findByUCN_RUID_Type(String userName, long recieverUserId,
        int recieverType) throws NoSuchRecieverException, SystemException {
        Reciever reciever = fetchByUCN_RUID_Type(userName, recieverUserId,
                recieverType);

        if (reciever == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Reciever exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("recieverUserId=" + recieverUserId);

            msg.append(", ");
            msg.append("recieverType=" + recieverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchRecieverException(msg.toString());
        }

        return reciever;
    }

    public Reciever fetchByUCN_RUID_Type(String userName, long recieverUserId,
        int recieverType) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "fetchByUCN_RUID_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                userName, new Long(recieverUserId), new Integer(recieverType)
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("recieverUserId = ?");

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(recieverUserId);

                qPos.add(recieverType);

                List<Reciever> list = q.list();

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
            List<Reciever> list = (List<Reciever>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public Reciever findByUCN_RCN_Type(String userName,
        String recieverUserName, int recieverType)
        throws NoSuchRecieverException, SystemException {
        Reciever reciever = fetchByUCN_RCN_Type(userName, recieverUserName,
                recieverType);

        if (reciever == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No Reciever exists with the key {");

            msg.append("userName=" + userName);

            msg.append(", ");
            msg.append("recieverUserName=" + recieverUserName);

            msg.append(", ");
            msg.append("recieverType=" + recieverType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchRecieverException(msg.toString());
        }

        return reciever;
    }

    public Reciever fetchByUCN_RCN_Type(String userName,
        String recieverUserName, int recieverType) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "fetchByUCN_RCN_Type";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                userName,
                
                recieverUserName, new Integer(recieverType)
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                if (recieverUserName == null) {
                    query.append("recieverUserName IS NULL");
                } else {
                    query.append("recieverUserName = ?");
                }

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                if (recieverUserName != null) {
                    qPos.add(recieverUserName);
                }

                qPos.add(recieverType);

                List<Reciever> list = q.list();

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
            List<Reciever> list = (List<Reciever>) result;

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

    public List<Reciever> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<Reciever> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    public List<Reciever> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<Reciever> list = (List<Reciever>) QueryUtil.list(q,
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
            return (List<Reciever>) result;
        }
    }

    public void removeByUID_Type(long userId, int recieverType)
        throws SystemException {
        for (Reciever reciever : findByUID_Type(userId, recieverType)) {
            remove(reciever);
        }
    }

    public void removeByUID_RUID_Type(long userId, long recieverUserId,
        int recieverType) throws NoSuchRecieverException, SystemException {
        Reciever reciever = findByUID_RUID_Type(userId, recieverUserId,
                recieverType);

        remove(reciever);
    }

    public void removeByUID_RCN_Type(long userId, String recieverUserName,
        int recieverType) throws NoSuchRecieverException, SystemException {
        Reciever reciever = findByUID_RCN_Type(userId, recieverUserName,
                recieverType);

        remove(reciever);
    }

    public void removeByUCN_Type(String userName, int recieverType)
        throws SystemException {
        for (Reciever reciever : findByUCN_Type(userName, recieverType)) {
            remove(reciever);
        }
    }

    public void removeByUCN_RUID_Type(String userName, long recieverUserId,
        int recieverType) throws NoSuchRecieverException, SystemException {
        Reciever reciever = findByUCN_RUID_Type(userName, recieverUserId,
                recieverType);

        remove(reciever);
    }

    public void removeByUCN_RCN_Type(String userName, String recieverUserName,
        int recieverType) throws NoSuchRecieverException, SystemException {
        Reciever reciever = findByUCN_RCN_Type(userName, recieverUserName,
                recieverType);

        remove(reciever);
    }

    public void removeAll() throws SystemException {
        for (Reciever reciever : findAll()) {
            remove(reciever);
        }
    }

    public int countByUID_Type(long userId, int recieverType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "countByUID_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Integer(recieverType)
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(recieverType);

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

    public int countByUID_RUID_Type(long userId, long recieverUserId,
        int recieverType) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "countByUID_RUID_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId), new Long(recieverUserId),
                new Integer(recieverType)
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                query.append("recieverUserId = ?");

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                qPos.add(recieverUserId);

                qPos.add(recieverType);

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

    public int countByUID_RCN_Type(long userId, String recieverUserName,
        int recieverType) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "countByUID_RCN_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(userId),
                
                recieverUserName, new Integer(recieverType)
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                query.append("userId = ?");

                query.append(" AND ");

                if (recieverUserName == null) {
                    query.append("recieverUserName IS NULL");
                } else {
                    query.append("recieverUserName = ?");
                }

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (recieverUserName != null) {
                    qPos.add(recieverUserName);
                }

                qPos.add(recieverType);

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

    public int countByUCN_Type(String userName, int recieverType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "countByUCN_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] { userName, new Integer(recieverType) };

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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(recieverType);

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

    public int countByUCN_RUID_Type(String userName, long recieverUserId,
        int recieverType) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "countByUCN_RUID_Type";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                userName, new Long(recieverUserId), new Integer(recieverType)
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                query.append("recieverUserId = ?");

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                qPos.add(recieverUserId);

                qPos.add(recieverType);

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

    public int countByUCN_RCN_Type(String userName, String recieverUserName,
        int recieverType) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
        String finderMethodName = "countByUCN_RCN_Type";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                userName,
                
                recieverUserName, new Integer(recieverType)
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
                    "FROM com.sgs.portlet.recievergroup.model.Reciever WHERE ");

                if (userName == null) {
                    query.append("userName IS NULL");
                } else {
                    query.append("userName = ?");
                }

                query.append(" AND ");

                if (recieverUserName == null) {
                    query.append("recieverUserName IS NULL");
                } else {
                    query.append("recieverUserName = ?");
                }

                query.append(" AND ");

                query.append("recieverType = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (userName != null) {
                    qPos.add(userName);
                }

                if (recieverUserName != null) {
                    qPos.add(recieverUserName);
                }

                qPos.add(recieverType);

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
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED;
        String finderClassName = Reciever.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.recievergroup.model.Reciever");

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

    public List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        long pk) throws SystemException {
        return getRecieverGroups(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    public List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        long pk, int start, int end) throws SystemException {
        return getRecieverGroups(pk, start, end, null);
    }

    public List<com.sgs.portlet.recievergroup.model.RecieverGroup> getRecieverGroups(
        long pk, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED_RECIEVERGROUPS_RECIEVERS;

        String finderClassName = "RecieverGroups_Recievers";

        String finderMethodName = "getRecieverGroups";
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

                sb.append(_SQL_GETRECIEVERGROUPS);

                if (obc != null) {
                    sb.append("ORDER BY ");
                    sb.append(obc.getOrderBy());
                }
                else {
                    sb.append("ORDER BY ");

                    sb.append("pml_RecieverGroup.recieverGroupName ASC");
                }

                String sql = sb.toString();

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("pml_RecieverGroup",
                    com.sgs.portlet.recievergroup.model.impl.RecieverGroupImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                List<com.sgs.portlet.recievergroup.model.RecieverGroup> list = (List<com.sgs.portlet.recievergroup.model.RecieverGroup>) QueryUtil.list(q,
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
            return (List<com.sgs.portlet.recievergroup.model.RecieverGroup>) result;
        }
    }

    public int getRecieverGroupsSize(long pk) throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED_RECIEVERGROUPS_RECIEVERS;

        String finderClassName = "RecieverGroups_Recievers";

        String finderMethodName = "getRecieverGroupsSize";
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

                SQLQuery q = session.createSQLQuery(_SQL_GETRECIEVERGROUPSSIZE);

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

    public boolean containsRecieverGroup(long pk, long recieverGroupPK)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RecieverModelImpl.CACHE_ENABLED_RECIEVERGROUPS_RECIEVERS;

        String finderClassName = "RecieverGroups_Recievers";

        String finderMethodName = "containsRecieverGroups";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(pk),
                
                new Long(recieverGroupPK)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            try {
                Boolean value = Boolean.valueOf(containsRecieverGroup.contains(
                            pk, recieverGroupPK));

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

    public boolean containsRecieverGroups(long pk) throws SystemException {
        if (getRecieverGroupsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addRecieverGroup(long pk, long recieverGroupPK)
        throws SystemException {
        try {
            addRecieverGroup.add(pk, recieverGroupPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void addRecieverGroup(long pk,
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws SystemException {
        try {
            addRecieverGroup.add(pk, recieverGroup.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void addRecieverGroups(long pk, long[] recieverGroupPKs)
        throws SystemException {
        try {
            for (long recieverGroupPK : recieverGroupPKs) {
                addRecieverGroup.add(pk, recieverGroupPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void addRecieverGroups(long pk,
        List<com.sgs.portlet.recievergroup.model.RecieverGroup> recieverGroups)
        throws SystemException {
        try {
            for (com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup : recieverGroups) {
                addRecieverGroup.add(pk, recieverGroup.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void clearRecieverGroups(long pk) throws SystemException {
        try {
            clearRecieverGroups.clear(pk);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void removeRecieverGroup(long pk, long recieverGroupPK)
        throws SystemException {
        try {
            removeRecieverGroup.remove(pk, recieverGroupPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void removeRecieverGroup(long pk,
        com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup)
        throws SystemException {
        try {
            removeRecieverGroup.remove(pk, recieverGroup.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void removeRecieverGroups(long pk, long[] recieverGroupPKs)
        throws SystemException {
        try {
            for (long recieverGroupPK : recieverGroupPKs) {
                removeRecieverGroup.remove(pk, recieverGroupPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void removeRecieverGroups(long pk,
        List<com.sgs.portlet.recievergroup.model.RecieverGroup> recieverGroups)
        throws SystemException {
        try {
            for (com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup : recieverGroups) {
                removeRecieverGroup.remove(pk, recieverGroup.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void setRecieverGroups(long pk, long[] recieverGroupPKs)
        throws SystemException {
        try {
            clearRecieverGroups.clear(pk);

            for (long recieverGroupPK : recieverGroupPKs) {
                addRecieverGroup.add(pk, recieverGroupPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache("RecieverGroups_Recievers");
        }
    }

    public void setRecieverGroups(long pk,
        List<com.sgs.portlet.recievergroup.model.RecieverGroup> recieverGroups)
        throws SystemException {
        try {
            clearRecieverGroups.clear(pk);

            for (com.sgs.portlet.recievergroup.model.RecieverGroup recieverGroup : recieverGroups) {
                addRecieverGroup.add(pk, recieverGroup.getPrimaryKey());
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
                        "value.object.listener.com.sgs.portlet.recievergroup.model.Reciever")));

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

        containsRecieverGroup = new ContainsRecieverGroup(this);

        addRecieverGroup = new AddRecieverGroup(this);
        clearRecieverGroups = new ClearRecieverGroups(this);
        removeRecieverGroup = new RemoveRecieverGroup(this);
    }

    protected class ContainsRecieverGroup {
        private MappingSqlQuery _mappingSqlQuery;

        protected ContainsRecieverGroup(RecieverPersistenceImpl persistenceImpl) {
            super();

            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSRECIEVERGROUP,
                    new int[] { Types.BIGINT, Types.BIGINT }, RowMapper.COUNT);
        }

        protected boolean contains(long recieverId, long recieverGroupId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(recieverId), new Long(recieverGroupId)
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

    protected class AddRecieverGroup {
        private SqlUpdate _sqlUpdate;
        private RecieverPersistenceImpl _persistenceImpl;

        protected AddRecieverGroup(RecieverPersistenceImpl persistenceImpl) {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "INSERT INTO RecieverGroups_Recievers (recieverId, recieverGroupId) VALUES (?, ?)",
                    new int[] { Types.BIGINT, Types.BIGINT });
            _persistenceImpl = persistenceImpl;
        }

        protected void add(long recieverId, long recieverGroupId) {
            if (!_persistenceImpl.containsRecieverGroup.contains(recieverId,
                        recieverGroupId)) {
                _sqlUpdate.update(new Object[] {
                        new Long(recieverId), new Long(recieverGroupId)
                    });
            }
        }
    }

    protected class ClearRecieverGroups {
        private SqlUpdate _sqlUpdate;

        protected ClearRecieverGroups(RecieverPersistenceImpl persistenceImpl) {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM RecieverGroups_Recievers WHERE recieverId = ?",
                    new int[] { Types.BIGINT });
        }

        protected void clear(long recieverId) {
            _sqlUpdate.update(new Object[] { new Long(recieverId) });
        }
    }

    protected class RemoveRecieverGroup {
        private SqlUpdate _sqlUpdate;

        protected RemoveRecieverGroup(RecieverPersistenceImpl persistenceImpl) {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM RecieverGroups_Recievers WHERE recieverId = ? AND recieverGroupId = ?",
                    new int[] { Types.BIGINT, Types.BIGINT });
        }

        protected void remove(long recieverId, long recieverGroupId) {
            _sqlUpdate.update(new Object[] {
                    new Long(recieverId), new Long(recieverGroupId)
                });
        }
    }
}
