package com.ext.portlet.saveprocesstype.service.persistence;

import com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException;
import com.ext.portlet.saveprocesstype.model.SaveProcessType;
import com.ext.portlet.saveprocesstype.model.impl.SaveProcessTypeImpl;
import com.ext.portlet.saveprocesstype.model.impl.SaveProcessTypeModelImpl;

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


public class SaveProcessTypePersistenceImpl extends BasePersistenceImpl
    implements SaveProcessTypePersistence {
    private static Log _log = LogFactory.getLog(SaveProcessTypePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public SaveProcessType create(long sptId) {
        SaveProcessType saveProcessType = new SaveProcessTypeImpl();

        saveProcessType.setNew(true);
        saveProcessType.setPrimaryKey(sptId);

        return saveProcessType;
    }

    public SaveProcessType remove(long sptId)
        throws NoSuchSaveProcessTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SaveProcessType saveProcessType = (SaveProcessType) session.get(SaveProcessTypeImpl.class,
                    new Long(sptId));

            if (saveProcessType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No SaveProcessType exists with the primary key " +
                        sptId);
                }

                throw new NoSuchSaveProcessTypeException(
                    "No SaveProcessType exists with the primary key " + sptId);
            }

            return remove(saveProcessType);
        } catch (NoSuchSaveProcessTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public SaveProcessType remove(SaveProcessType saveProcessType)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(saveProcessType);
            }
        }

        saveProcessType = removeImpl(saveProcessType);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(saveProcessType);
            }
        }

        return saveProcessType;
    }

    protected SaveProcessType removeImpl(SaveProcessType saveProcessType)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(saveProcessType);

            session.flush();

            return saveProcessType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(SaveProcessType.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(SaveProcessType saveProcessType, boolean merge)</code>.
     */
    public SaveProcessType update(SaveProcessType saveProcessType)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(SaveProcessType saveProcessType) method. Use update(SaveProcessType saveProcessType, boolean merge) instead.");
        }

        return update(saveProcessType, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                saveProcessType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when saveProcessType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public SaveProcessType update(SaveProcessType saveProcessType, boolean merge)
        throws SystemException {
        boolean isNew = saveProcessType.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(saveProcessType);
                } else {
                    listener.onBeforeUpdate(saveProcessType);
                }
            }
        }

        saveProcessType = updateImpl(saveProcessType, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(saveProcessType);
                } else {
                    listener.onAfterUpdate(saveProcessType);
                }
            }
        }

        return saveProcessType;
    }

    public SaveProcessType updateImpl(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(saveProcessType);
            } else {
                if (saveProcessType.isNew()) {
                    session.save(saveProcessType);
                }
            }

            session.flush();

            saveProcessType.setNew(false);

            return saveProcessType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(SaveProcessType.class.getName());
        }
    }

    public SaveProcessType findByPrimaryKey(long sptId)
        throws NoSuchSaveProcessTypeException, SystemException {
        SaveProcessType saveProcessType = fetchByPrimaryKey(sptId);

        if (saveProcessType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No SaveProcessType exists with the primary key " +
                    sptId);
            }

            throw new NoSuchSaveProcessTypeException(
                "No SaveProcessType exists with the primary key " + sptId);
        }

        return saveProcessType;
    }

    public SaveProcessType fetchByPrimaryKey(long sptId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (SaveProcessType) session.get(SaveProcessTypeImpl.class,
                new Long(sptId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<SaveProcessType> findByDocId(long docId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SaveProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = SaveProcessType.class.getName();
        String finderMethodName = "findByDocId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(docId) };

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
                    "FROM com.ext.portlet.saveprocesstype.model.SaveProcessType WHERE ");

                query.append("docId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("docId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docId);

                List<SaveProcessType> list = q.list();

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
            return (List<SaveProcessType>) result;
        }
    }

    public List<SaveProcessType> findByDocId(long docId, int start, int end)
        throws SystemException {
        return findByDocId(docId, start, end, null);
    }

    public List<SaveProcessType> findByDocId(long docId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = SaveProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = SaveProcessType.class.getName();
        String finderMethodName = "findByDocId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(docId),
                
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
                    "FROM com.ext.portlet.saveprocesstype.model.SaveProcessType WHERE ");

                query.append("docId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("docId ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docId);

                List<SaveProcessType> list = (List<SaveProcessType>) QueryUtil.list(q,
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
            return (List<SaveProcessType>) result;
        }
    }

    public SaveProcessType findByDocId_First(long docId, OrderByComparator obc)
        throws NoSuchSaveProcessTypeException, SystemException {
        List<SaveProcessType> list = findByDocId(docId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SaveProcessType exists with the key {");

            msg.append("docId=" + docId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSaveProcessTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SaveProcessType findByDocId_Last(long docId, OrderByComparator obc)
        throws NoSuchSaveProcessTypeException, SystemException {
        int count = countByDocId(docId);

        List<SaveProcessType> list = findByDocId(docId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SaveProcessType exists with the key {");

            msg.append("docId=" + docId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSaveProcessTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SaveProcessType[] findByDocId_PrevAndNext(long sptId, long docId,
        OrderByComparator obc)
        throws NoSuchSaveProcessTypeException, SystemException {
        SaveProcessType saveProcessType = findByPrimaryKey(sptId);

        int count = countByDocId(docId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.ext.portlet.saveprocesstype.model.SaveProcessType WHERE ");

            query.append("docId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("docId ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(docId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    saveProcessType);

            SaveProcessType[] array = new SaveProcessTypeImpl[3];

            array[0] = (SaveProcessType) objArray[0];
            array[1] = (SaveProcessType) objArray[1];
            array[2] = (SaveProcessType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<SaveProcessType> findByFlagProcessType(long flagProcessType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SaveProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = SaveProcessType.class.getName();
        String finderMethodName = "findByFlagProcessType";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(flagProcessType) };

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
                    "FROM com.ext.portlet.saveprocesstype.model.SaveProcessType WHERE ");

                query.append("flagprocesstype = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("docId ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(flagProcessType);

                List<SaveProcessType> list = q.list();

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
            return (List<SaveProcessType>) result;
        }
    }

    public List<SaveProcessType> findByFlagProcessType(long flagProcessType,
        int start, int end) throws SystemException {
        return findByFlagProcessType(flagProcessType, start, end, null);
    }

    public List<SaveProcessType> findByFlagProcessType(long flagProcessType,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = SaveProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = SaveProcessType.class.getName();
        String finderMethodName = "findByFlagProcessType";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(flagProcessType),
                
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
                    "FROM com.ext.portlet.saveprocesstype.model.SaveProcessType WHERE ");

                query.append("flagprocesstype = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("docId ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(flagProcessType);

                List<SaveProcessType> list = (List<SaveProcessType>) QueryUtil.list(q,
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
            return (List<SaveProcessType>) result;
        }
    }

    public SaveProcessType findByFlagProcessType_First(long flagProcessType,
        OrderByComparator obc)
        throws NoSuchSaveProcessTypeException, SystemException {
        List<SaveProcessType> list = findByFlagProcessType(flagProcessType, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SaveProcessType exists with the key {");

            msg.append("flagProcessType=" + flagProcessType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSaveProcessTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SaveProcessType findByFlagProcessType_Last(long flagProcessType,
        OrderByComparator obc)
        throws NoSuchSaveProcessTypeException, SystemException {
        int count = countByFlagProcessType(flagProcessType);

        List<SaveProcessType> list = findByFlagProcessType(flagProcessType,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No SaveProcessType exists with the key {");

            msg.append("flagProcessType=" + flagProcessType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSaveProcessTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public SaveProcessType[] findByFlagProcessType_PrevAndNext(long sptId,
        long flagProcessType, OrderByComparator obc)
        throws NoSuchSaveProcessTypeException, SystemException {
        SaveProcessType saveProcessType = findByPrimaryKey(sptId);

        int count = countByFlagProcessType(flagProcessType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.ext.portlet.saveprocesstype.model.SaveProcessType WHERE ");

            query.append("flagprocesstype = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("docId ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(flagProcessType);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    saveProcessType);

            SaveProcessType[] array = new SaveProcessTypeImpl[3];

            array[0] = (SaveProcessType) objArray[0];
            array[1] = (SaveProcessType) objArray[1];
            array[2] = (SaveProcessType) objArray[2];

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

    public List<SaveProcessType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<SaveProcessType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<SaveProcessType> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = SaveProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = SaveProcessType.class.getName();
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
                    "FROM com.ext.portlet.saveprocesstype.model.SaveProcessType ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("docId ASC");
                }

                Query q = session.createQuery(query.toString());

                List<SaveProcessType> list = (List<SaveProcessType>) QueryUtil.list(q,
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
            return (List<SaveProcessType>) result;
        }
    }

    public void removeByDocId(long docId) throws SystemException {
        for (SaveProcessType saveProcessType : findByDocId(docId)) {
            remove(saveProcessType);
        }
    }

    public void removeByFlagProcessType(long flagProcessType)
        throws SystemException {
        for (SaveProcessType saveProcessType : findByFlagProcessType(
                flagProcessType)) {
            remove(saveProcessType);
        }
    }

    public void removeAll() throws SystemException {
        for (SaveProcessType saveProcessType : findAll()) {
            remove(saveProcessType);
        }
    }

    public int countByDocId(long docId) throws SystemException {
        boolean finderClassNameCacheEnabled = SaveProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = SaveProcessType.class.getName();
        String finderMethodName = "countByDocId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(docId) };

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
                    "FROM com.ext.portlet.saveprocesstype.model.SaveProcessType WHERE ");

                query.append("docId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(docId);

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

    public int countByFlagProcessType(long flagProcessType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = SaveProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = SaveProcessType.class.getName();
        String finderMethodName = "countByFlagProcessType";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(flagProcessType) };

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
                    "FROM com.ext.portlet.saveprocesstype.model.SaveProcessType WHERE ");

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
        boolean finderClassNameCacheEnabled = SaveProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = SaveProcessType.class.getName();
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
                        "SELECT COUNT(*) FROM com.ext.portlet.saveprocesstype.model.SaveProcessType");

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
                        "value.object.listener.com.ext.portlet.saveprocesstype.model.SaveProcessType")));

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
