package com.ext.portlet.processtype.service.persistence;

import com.ext.portlet.processtype.NoSuchProcessTypeException;
import com.ext.portlet.processtype.model.ProcessType;
import com.ext.portlet.processtype.model.impl.ProcessTypeImpl;
import com.ext.portlet.processtype.model.impl.ProcessTypeModelImpl;

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


public class ProcessTypePersistenceImpl extends BasePersistenceImpl
    implements ProcessTypePersistence {
    private static Log _log = LogFactory.getLog(ProcessTypePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public ProcessType create(long processTypeId) {
        ProcessType processType = new ProcessTypeImpl();

        processType.setNew(true);
        processType.setPrimaryKey(processTypeId);

        return processType;
    }

    public ProcessType remove(long processTypeId)
        throws NoSuchProcessTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            ProcessType processType = (ProcessType) session.get(ProcessTypeImpl.class,
                    new Long(processTypeId));

            if (processType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No ProcessType exists with the primary key " +
                        processTypeId);
                }

                throw new NoSuchProcessTypeException(
                    "No ProcessType exists with the primary key " +
                    processTypeId);
            }

            return remove(processType);
        } catch (NoSuchProcessTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public ProcessType remove(ProcessType processType)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(processType);
            }
        }

        processType = removeImpl(processType);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(processType);
            }
        }

        return processType;
    }

    protected ProcessType removeImpl(ProcessType processType)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(processType);

            session.flush();

            return processType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(ProcessType.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(ProcessType processType, boolean merge)</code>.
     */
    public ProcessType update(ProcessType processType)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(ProcessType processType) method. Use update(ProcessType processType, boolean merge) instead.");
        }

        return update(processType, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                processType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when processType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public ProcessType update(ProcessType processType, boolean merge)
        throws SystemException {
        boolean isNew = processType.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(processType);
                } else {
                    listener.onBeforeUpdate(processType);
                }
            }
        }

        processType = updateImpl(processType, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(processType);
                } else {
                    listener.onAfterUpdate(processType);
                }
            }
        }

        return processType;
    }

    public ProcessType updateImpl(
        com.ext.portlet.processtype.model.ProcessType processType, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(processType);
            } else {
                if (processType.isNew()) {
                    session.save(processType);
                }
            }

            session.flush();

            processType.setNew(false);

            return processType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(ProcessType.class.getName());
        }
    }

    public ProcessType findByPrimaryKey(long processTypeId)
        throws NoSuchProcessTypeException, SystemException {
        ProcessType processType = fetchByPrimaryKey(processTypeId);

        if (processType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No ProcessType exists with the primary key " +
                    processTypeId);
            }

            throw new NoSuchProcessTypeException(
                "No ProcessType exists with the primary key " + processTypeId);
        }

        return processType;
    }

    public ProcessType fetchByPrimaryKey(long processTypeId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (ProcessType) session.get(ProcessTypeImpl.class,
                new Long(processTypeId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<ProcessType> findByName(String name) throws SystemException {
        boolean finderClassNameCacheEnabled = ProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = ProcessType.class.getName();
        String finderMethodName = "findByName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { name };

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
                    "FROM com.ext.portlet.processtype.model.ProcessType WHERE ");

                if (name == null) {
                    query.append("name LIKE null");
                } else {
                    query.append("lower(name) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("name ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (name != null) {
                    qPos.add(name);
                }

                List<ProcessType> list = q.list();

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
            return (List<ProcessType>) result;
        }
    }

    public List<ProcessType> findByName(String name, int start, int end)
        throws SystemException {
        return findByName(name, start, end, null);
    }

    public List<ProcessType> findByName(String name, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = ProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = ProcessType.class.getName();
        String finderMethodName = "findByName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                name,
                
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
                    "FROM com.ext.portlet.processtype.model.ProcessType WHERE ");

                if (name == null) {
                    query.append("name LIKE null");
                } else {
                    query.append("lower(name) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("name ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (name != null) {
                    qPos.add(name);
                }

                List<ProcessType> list = (List<ProcessType>) QueryUtil.list(q,
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
            return (List<ProcessType>) result;
        }
    }

    public ProcessType findByName_First(String name, OrderByComparator obc)
        throws NoSuchProcessTypeException, SystemException {
        List<ProcessType> list = findByName(name, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ProcessType exists with the key {");

            msg.append("name=" + name);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchProcessTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ProcessType findByName_Last(String name, OrderByComparator obc)
        throws NoSuchProcessTypeException, SystemException {
        int count = countByName(name);

        List<ProcessType> list = findByName(name, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ProcessType exists with the key {");

            msg.append("name=" + name);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchProcessTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ProcessType[] findByName_PrevAndNext(long processTypeId,
        String name, OrderByComparator obc)
        throws NoSuchProcessTypeException, SystemException {
        ProcessType processType = findByPrimaryKey(processTypeId);

        int count = countByName(name);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.ext.portlet.processtype.model.ProcessType WHERE ");

            if (name == null) {
                query.append("name LIKE null");
            } else {
                query.append("lower(name) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("name ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (name != null) {
                qPos.add(name);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    processType);

            ProcessType[] array = new ProcessTypeImpl[3];

            array[0] = (ProcessType) objArray[0];
            array[1] = (ProcessType) objArray[1];
            array[2] = (ProcessType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<ProcessType> findByFlagProcessType(int flagProcessType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = ProcessType.class.getName();
        String finderMethodName = "findByFlagProcessType";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(flagProcessType) };

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
                    "FROM com.ext.portlet.processtype.model.ProcessType WHERE ");

                query.append("flagprocesstype = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("name ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(flagProcessType);

                List<ProcessType> list = q.list();

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
            return (List<ProcessType>) result;
        }
    }

    public List<ProcessType> findByFlagProcessType(int flagProcessType,
        int start, int end) throws SystemException {
        return findByFlagProcessType(flagProcessType, start, end, null);
    }

    public List<ProcessType> findByFlagProcessType(int flagProcessType,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = ProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = ProcessType.class.getName();
        String finderMethodName = "findByFlagProcessType";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(flagProcessType),
                
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
                    "FROM com.ext.portlet.processtype.model.ProcessType WHERE ");

                query.append("flagprocesstype = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("name ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(flagProcessType);

                List<ProcessType> list = (List<ProcessType>) QueryUtil.list(q,
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
            return (List<ProcessType>) result;
        }
    }

    public ProcessType findByFlagProcessType_First(int flagProcessType,
        OrderByComparator obc)
        throws NoSuchProcessTypeException, SystemException {
        List<ProcessType> list = findByFlagProcessType(flagProcessType, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ProcessType exists with the key {");

            msg.append("flagProcessType=" + flagProcessType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchProcessTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ProcessType findByFlagProcessType_Last(int flagProcessType,
        OrderByComparator obc)
        throws NoSuchProcessTypeException, SystemException {
        int count = countByFlagProcessType(flagProcessType);

        List<ProcessType> list = findByFlagProcessType(flagProcessType,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No ProcessType exists with the key {");

            msg.append("flagProcessType=" + flagProcessType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchProcessTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public ProcessType[] findByFlagProcessType_PrevAndNext(long processTypeId,
        int flagProcessType, OrderByComparator obc)
        throws NoSuchProcessTypeException, SystemException {
        ProcessType processType = findByPrimaryKey(processTypeId);

        int count = countByFlagProcessType(flagProcessType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.ext.portlet.processtype.model.ProcessType WHERE ");

            query.append("flagprocesstype = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("name ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(flagProcessType);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    processType);

            ProcessType[] array = new ProcessTypeImpl[3];

            array[0] = (ProcessType) objArray[0];
            array[1] = (ProcessType) objArray[1];
            array[2] = (ProcessType) objArray[2];

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

    public List<ProcessType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<ProcessType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<ProcessType> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = ProcessType.class.getName();
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
                    "FROM com.ext.portlet.processtype.model.ProcessType ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("name ASC");
                }

                Query q = session.createQuery(query.toString());

                List<ProcessType> list = (List<ProcessType>) QueryUtil.list(q,
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
            return (List<ProcessType>) result;
        }
    }

    public void removeByName(String name) throws SystemException {
        for (ProcessType processType : findByName(name)) {
            remove(processType);
        }
    }

    public void removeByFlagProcessType(int flagProcessType)
        throws SystemException {
        for (ProcessType processType : findByFlagProcessType(flagProcessType)) {
            remove(processType);
        }
    }

    public void removeAll() throws SystemException {
        for (ProcessType processType : findAll()) {
            remove(processType);
        }
    }

    public int countByName(String name) throws SystemException {
        boolean finderClassNameCacheEnabled = ProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = ProcessType.class.getName();
        String finderMethodName = "countByName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { name };

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
                    "FROM com.ext.portlet.processtype.model.ProcessType WHERE ");

                if (name == null) {
                    query.append("name LIKE null");
                } else {
                    query.append("lower(name) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (name != null) {
                    qPos.add(name);
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

    public int countByFlagProcessType(int flagProcessType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = ProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = ProcessType.class.getName();
        String finderMethodName = "countByFlagProcessType";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(flagProcessType) };

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
                    "FROM com.ext.portlet.processtype.model.ProcessType WHERE ");

                query.append("flagprocesstype = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(flagProcessType);

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
        boolean finderClassNameCacheEnabled = ProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = ProcessType.class.getName();
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
                        "SELECT COUNT(*) FROM com.ext.portlet.processtype.model.ProcessType");

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
                        "value.object.listener.com.ext.portlet.processtype.model.ProcessType")));

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
