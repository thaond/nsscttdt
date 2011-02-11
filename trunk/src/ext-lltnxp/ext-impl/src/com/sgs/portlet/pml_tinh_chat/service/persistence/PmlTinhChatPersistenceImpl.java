package com.sgs.portlet.pml_tinh_chat.service.persistence;

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

import com.sgs.portlet.pml_tinh_chat.NoSuchPmlTinhChatException;
import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat;
import com.sgs.portlet.pml_tinh_chat.model.impl.PmlTinhChatImpl;
import com.sgs.portlet.pml_tinh_chat.model.impl.PmlTinhChatModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlTinhChatPersistenceImpl extends BasePersistenceImpl
    implements PmlTinhChatPersistence {
    private static Log _log = LogFactory.getLog(PmlTinhChatPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlTinhChat create(long idTinhChat) {
        PmlTinhChat pmlTinhChat = new PmlTinhChatImpl();

        pmlTinhChat.setNew(true);
        pmlTinhChat.setPrimaryKey(idTinhChat);

        return pmlTinhChat;
    }

    public PmlTinhChat remove(long idTinhChat)
        throws NoSuchPmlTinhChatException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlTinhChat pmlTinhChat = (PmlTinhChat) session.get(PmlTinhChatImpl.class,
                    new Long(idTinhChat));

            if (pmlTinhChat == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlTinhChat exists with the primary key " +
                        idTinhChat);
                }

                throw new NoSuchPmlTinhChatException(
                    "No PmlTinhChat exists with the primary key " + idTinhChat);
            }

            return remove(pmlTinhChat);
        } catch (NoSuchPmlTinhChatException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlTinhChat remove(PmlTinhChat pmlTinhChat)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlTinhChat);
            }
        }

        pmlTinhChat = removeImpl(pmlTinhChat);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlTinhChat);
            }
        }

        return pmlTinhChat;
    }

    protected PmlTinhChat removeImpl(PmlTinhChat pmlTinhChat)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlTinhChat);

            session.flush();

            return pmlTinhChat;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlTinhChat.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlTinhChat pmlTinhChat, boolean merge)</code>.
     */
    public PmlTinhChat update(PmlTinhChat pmlTinhChat)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlTinhChat pmlTinhChat) method. Use update(PmlTinhChat pmlTinhChat, boolean merge) instead.");
        }

        return update(pmlTinhChat, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTinhChat the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTinhChat is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlTinhChat update(PmlTinhChat pmlTinhChat, boolean merge)
        throws SystemException {
        boolean isNew = pmlTinhChat.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlTinhChat);
                } else {
                    listener.onBeforeUpdate(pmlTinhChat);
                }
            }
        }

        pmlTinhChat = updateImpl(pmlTinhChat, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlTinhChat);
                } else {
                    listener.onAfterUpdate(pmlTinhChat);
                }
            }
        }

        return pmlTinhChat;
    }

    public PmlTinhChat updateImpl(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlTinhChat);
            } else {
                if (pmlTinhChat.isNew()) {
                    session.save(pmlTinhChat);
                }
            }

            session.flush();

            pmlTinhChat.setNew(false);

            return pmlTinhChat;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlTinhChat.class.getName());
        }
    }

    public PmlTinhChat findByPrimaryKey(long idTinhChat)
        throws NoSuchPmlTinhChatException, SystemException {
        PmlTinhChat pmlTinhChat = fetchByPrimaryKey(idTinhChat);

        if (pmlTinhChat == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlTinhChat exists with the primary key " +
                    idTinhChat);
            }

            throw new NoSuchPmlTinhChatException(
                "No PmlTinhChat exists with the primary key " + idTinhChat);
        }

        return pmlTinhChat;
    }

    public PmlTinhChat fetchByPrimaryKey(long idTinhChat)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlTinhChat) session.get(PmlTinhChatImpl.class,
                new Long(idTinhChat));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTinhChat> findByTenTinhChat(String tenTinhChat)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTinhChatModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTinhChat.class.getName();
        String finderMethodName = "findByTenTinhChat";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { tenTinhChat };

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
                    "FROM com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat WHERE ");

                if (tenTinhChat == null) {
                    query.append("ten_tinh_chat LIKE null");
                } else {
                    query.append("ten_tinh_chat LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("ten_tinh_chat ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (tenTinhChat != null) {
                    qPos.add(tenTinhChat);
                }

                List<PmlTinhChat> list = q.list();

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
            return (List<PmlTinhChat>) result;
        }
    }

    public List<PmlTinhChat> findByTenTinhChat(String tenTinhChat, int start,
        int end) throws SystemException {
        return findByTenTinhChat(tenTinhChat, start, end, null);
    }

    public List<PmlTinhChat> findByTenTinhChat(String tenTinhChat, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTinhChatModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTinhChat.class.getName();
        String finderMethodName = "findByTenTinhChat";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                tenTinhChat,
                
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
                    "FROM com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat WHERE ");

                if (tenTinhChat == null) {
                    query.append("ten_tinh_chat LIKE null");
                } else {
                    query.append("ten_tinh_chat LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_tinh_chat ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (tenTinhChat != null) {
                    qPos.add(tenTinhChat);
                }

                List<PmlTinhChat> list = (List<PmlTinhChat>) QueryUtil.list(q,
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
            return (List<PmlTinhChat>) result;
        }
    }

    public PmlTinhChat findByTenTinhChat_First(String tenTinhChat,
        OrderByComparator obc)
        throws NoSuchPmlTinhChatException, SystemException {
        List<PmlTinhChat> list = findByTenTinhChat(tenTinhChat, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTinhChat exists with the key {");

            msg.append("tenTinhChat=" + tenTinhChat);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTinhChatException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTinhChat findByTenTinhChat_Last(String tenTinhChat,
        OrderByComparator obc)
        throws NoSuchPmlTinhChatException, SystemException {
        int count = countByTenTinhChat(tenTinhChat);

        List<PmlTinhChat> list = findByTenTinhChat(tenTinhChat, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTinhChat exists with the key {");

            msg.append("tenTinhChat=" + tenTinhChat);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTinhChatException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTinhChat[] findByTenTinhChat_PrevAndNext(long idTinhChat,
        String tenTinhChat, OrderByComparator obc)
        throws NoSuchPmlTinhChatException, SystemException {
        PmlTinhChat pmlTinhChat = findByPrimaryKey(idTinhChat);

        int count = countByTenTinhChat(tenTinhChat);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat WHERE ");

            if (tenTinhChat == null) {
                query.append("ten_tinh_chat LIKE null");
            } else {
                query.append("ten_tinh_chat LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("ten_tinh_chat ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (tenTinhChat != null) {
                qPos.add(tenTinhChat);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTinhChat);

            PmlTinhChat[] array = new PmlTinhChatImpl[3];

            array[0] = (PmlTinhChat) objArray[0];
            array[1] = (PmlTinhChat) objArray[1];
            array[2] = (PmlTinhChat) objArray[2];

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

    public List<PmlTinhChat> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlTinhChat> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlTinhChat> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTinhChatModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTinhChat.class.getName();
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
                    "FROM com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("ten_tinh_chat ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlTinhChat> list = (List<PmlTinhChat>) QueryUtil.list(q,
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
            return (List<PmlTinhChat>) result;
        }
    }

    public void removeByTenTinhChat(String tenTinhChat)
        throws SystemException {
        for (PmlTinhChat pmlTinhChat : findByTenTinhChat(tenTinhChat)) {
            remove(pmlTinhChat);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlTinhChat pmlTinhChat : findAll()) {
            remove(pmlTinhChat);
        }
    }

    public int countByTenTinhChat(String tenTinhChat) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTinhChatModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTinhChat.class.getName();
        String finderMethodName = "countByTenTinhChat";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { tenTinhChat };

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
                    "FROM com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat WHERE ");

                if (tenTinhChat == null) {
                    query.append("ten_tinh_chat LIKE null");
                } else {
                    query.append("ten_tinh_chat LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (tenTinhChat != null) {
                    qPos.add(tenTinhChat);
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
        boolean finderClassNameCacheEnabled = PmlTinhChatModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTinhChat.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat");

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
                        "value.object.listener.com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat")));

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
