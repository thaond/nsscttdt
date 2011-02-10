package com.ext.portlet.meetingcalendar.service.persistence;

import com.ext.portlet.meetingcalendar.NoSuchRoomResourceException;
import com.ext.portlet.meetingcalendar.model.RoomResource;
import com.ext.portlet.meetingcalendar.model.impl.RoomResourceImpl;
import com.ext.portlet.meetingcalendar.model.impl.RoomResourceModelImpl;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class RoomResourcePersistenceImpl extends BasePersistenceImpl
    implements RoomResourcePersistence {
    private static Log _log = LogFactory.getLog(RoomResourcePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public RoomResource create(long roomId) {
        RoomResource roomResource = new RoomResourceImpl();

        roomResource.setNew(true);
        roomResource.setPrimaryKey(roomId);

        return roomResource;
    }

    public RoomResource remove(long roomId)
        throws NoSuchRoomResourceException, SystemException {
        Session session = null;

        try {
            session = openSession();

            RoomResource roomResource = (RoomResource) session.get(RoomResourceImpl.class,
                    new Long(roomId));

            if (roomResource == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No RoomResource exists with the primary key " +
                        roomId);
                }

                throw new NoSuchRoomResourceException(
                    "No RoomResource exists with the primary key " + roomId);
            }

            return remove(roomResource);
        } catch (NoSuchRoomResourceException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public RoomResource remove(RoomResource roomResource)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(roomResource);
            }
        }

        roomResource = removeImpl(roomResource);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(roomResource);
            }
        }

        return roomResource;
    }

    protected RoomResource removeImpl(RoomResource roomResource)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(roomResource);

            session.flush();

            return roomResource;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(RoomResource.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(RoomResource roomResource, boolean merge)</code>.
     */
    public RoomResource update(RoomResource roomResource)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(RoomResource roomResource) method. Use update(RoomResource roomResource, boolean merge) instead.");
        }

        return update(roomResource, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                roomResource the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when roomResource is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public RoomResource update(RoomResource roomResource, boolean merge)
        throws SystemException {
        boolean isNew = roomResource.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(roomResource);
                } else {
                    listener.onBeforeUpdate(roomResource);
                }
            }
        }

        roomResource = updateImpl(roomResource, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(roomResource);
                } else {
                    listener.onAfterUpdate(roomResource);
                }
            }
        }

        return roomResource;
    }

    public RoomResource updateImpl(
        com.ext.portlet.meetingcalendar.model.RoomResource roomResource,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(roomResource);
            } else {
                if (roomResource.isNew()) {
                    session.save(roomResource);
                }
            }

            session.flush();

            roomResource.setNew(false);

            return roomResource;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(RoomResource.class.getName());
        }
    }

    public RoomResource findByPrimaryKey(long roomId)
        throws NoSuchRoomResourceException, SystemException {
        RoomResource roomResource = fetchByPrimaryKey(roomId);

        if (roomResource == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No RoomResource exists with the primary key " +
                    roomId);
            }

            throw new NoSuchRoomResourceException(
                "No RoomResource exists with the primary key " + roomId);
        }

        return roomResource;
    }

    public RoomResource fetchByPrimaryKey(long roomId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (RoomResource) session.get(RoomResourceImpl.class,
                new Long(roomId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public RoomResource findByN_C(String roomName, long companyId)
        throws NoSuchRoomResourceException, SystemException {
        RoomResource roomResource = fetchByN_C(roomName, companyId);

        if (roomResource == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RoomResource exists with the key {");

            msg.append("roomName=" + roomName);

            msg.append(", ");
            msg.append("companyId=" + companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchRoomResourceException(msg.toString());
        }

        return roomResource;
    }

    public RoomResource fetchByN_C(String roomName, long companyId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RoomResourceModelImpl.CACHE_ENABLED;
        String finderClassName = RoomResource.class.getName();
        String finderMethodName = "fetchByN_C";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { roomName, new Long(companyId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.RoomResource WHERE ");

                if (roomName == null) {
                    query.append("roomName IS NULL");
                } else {
                    query.append("roomName = ?");
                }

                query.append(" AND ");

                query.append("companyId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("roomName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roomName != null) {
                    qPos.add(roomName);
                }

                qPos.add(companyId);

                List<RoomResource> list = q.list();

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
            List<RoomResource> list = (List<RoomResource>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public List<RoomResource> findByCompanyId(long companyId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RoomResourceModelImpl.CACHE_ENABLED;
        String finderClassName = RoomResource.class.getName();
        String finderMethodName = "findByCompanyId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(companyId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.RoomResource WHERE ");

                query.append("companyId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("roomName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                List<RoomResource> list = q.list();

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
            return (List<RoomResource>) result;
        }
    }

    public List<RoomResource> findByCompanyId(long companyId, int start, int end)
        throws SystemException {
        return findByCompanyId(companyId, start, end, null);
    }

    public List<RoomResource> findByCompanyId(long companyId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = RoomResourceModelImpl.CACHE_ENABLED;
        String finderClassName = RoomResource.class.getName();
        String finderMethodName = "findByCompanyId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(companyId),
                
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
                    "FROM com.ext.portlet.meetingcalendar.model.RoomResource WHERE ");

                query.append("companyId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("roomName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                List<RoomResource> list = (List<RoomResource>) QueryUtil.list(q,
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
            return (List<RoomResource>) result;
        }
    }

    public RoomResource findByCompanyId_First(long companyId,
        OrderByComparator obc)
        throws NoSuchRoomResourceException, SystemException {
        List<RoomResource> list = findByCompanyId(companyId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RoomResource exists with the key {");

            msg.append("companyId=" + companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchRoomResourceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RoomResource findByCompanyId_Last(long companyId,
        OrderByComparator obc)
        throws NoSuchRoomResourceException, SystemException {
        int count = countByCompanyId(companyId);

        List<RoomResource> list = findByCompanyId(companyId, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No RoomResource exists with the key {");

            msg.append("companyId=" + companyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchRoomResourceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public RoomResource[] findByCompanyId_PrevAndNext(long roomId,
        long companyId, OrderByComparator obc)
        throws NoSuchRoomResourceException, SystemException {
        RoomResource roomResource = findByPrimaryKey(roomId);

        int count = countByCompanyId(companyId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.ext.portlet.meetingcalendar.model.RoomResource WHERE ");

            query.append("companyId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("roomName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(companyId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    roomResource);

            RoomResource[] array = new RoomResourceImpl[3];

            array[0] = (RoomResource) objArray[0];
            array[1] = (RoomResource) objArray[1];
            array[2] = (RoomResource) objArray[2];

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

    public List<RoomResource> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<RoomResource> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<RoomResource> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RoomResourceModelImpl.CACHE_ENABLED;
        String finderClassName = RoomResource.class.getName();
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
                    "FROM com.ext.portlet.meetingcalendar.model.RoomResource ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("roomName ASC");
                }

                Query q = session.createQuery(query.toString());

                List<RoomResource> list = (List<RoomResource>) QueryUtil.list(q,
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
            return (List<RoomResource>) result;
        }
    }

    public void removeByN_C(String roomName, long companyId)
        throws NoSuchRoomResourceException, SystemException {
        RoomResource roomResource = findByN_C(roomName, companyId);

        remove(roomResource);
    }

    public void removeByCompanyId(long companyId) throws SystemException {
        for (RoomResource roomResource : findByCompanyId(companyId)) {
            remove(roomResource);
        }
    }

    public void removeAll() throws SystemException {
        for (RoomResource roomResource : findAll()) {
            remove(roomResource);
        }
    }

    public int countByN_C(String roomName, long companyId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = RoomResourceModelImpl.CACHE_ENABLED;
        String finderClassName = RoomResource.class.getName();
        String finderMethodName = "countByN_C";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { roomName, new Long(companyId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.RoomResource WHERE ");

                if (roomName == null) {
                    query.append("roomName IS NULL");
                } else {
                    query.append("roomName = ?");
                }

                query.append(" AND ");

                query.append("companyId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (roomName != null) {
                    qPos.add(roomName);
                }

                qPos.add(companyId);

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

    public int countByCompanyId(long companyId) throws SystemException {
        boolean finderClassNameCacheEnabled = RoomResourceModelImpl.CACHE_ENABLED;
        String finderClassName = RoomResource.class.getName();
        String finderMethodName = "countByCompanyId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(companyId) };

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
                    "FROM com.ext.portlet.meetingcalendar.model.RoomResource WHERE ");

                query.append("companyId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

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
        boolean finderClassNameCacheEnabled = RoomResourceModelImpl.CACHE_ENABLED;
        String finderClassName = RoomResource.class.getName();
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
                        "SELECT COUNT(*) FROM com.ext.portlet.meetingcalendar.model.RoomResource");

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
                        "value.object.listener.com.ext.portlet.meetingcalendar.model.RoomResource")));

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
