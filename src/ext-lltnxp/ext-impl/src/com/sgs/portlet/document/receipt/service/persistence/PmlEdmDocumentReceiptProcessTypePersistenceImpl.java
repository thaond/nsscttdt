package com.sgs.portlet.document.receipt.service.persistence;

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

import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptProcessTypeException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptProcessTypeImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptProcessTypeModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmDocumentReceiptProcessTypePersistenceImpl
    extends BasePersistenceImpl
    implements PmlEdmDocumentReceiptProcessTypePersistence {
    private static Log _log = LogFactory.getLog(PmlEdmDocumentReceiptProcessTypePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmDocumentReceiptProcessType create(long docReceiptProcessTypeId) {
        PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType = new PmlEdmDocumentReceiptProcessTypeImpl();

        pmlEdmDocumentReceiptProcessType.setNew(true);
        pmlEdmDocumentReceiptProcessType.setPrimaryKey(docReceiptProcessTypeId);

        return pmlEdmDocumentReceiptProcessType;
    }

    public PmlEdmDocumentReceiptProcessType remove(long docReceiptProcessTypeId)
        throws NoSuchPmlEdmDocumentReceiptProcessTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType = (PmlEdmDocumentReceiptProcessType) session.get(PmlEdmDocumentReceiptProcessTypeImpl.class,
                    new Long(docReceiptProcessTypeId));

            if (pmlEdmDocumentReceiptProcessType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmDocumentReceiptProcessType exists with the primary key " +
                        docReceiptProcessTypeId);
                }

                throw new NoSuchPmlEdmDocumentReceiptProcessTypeException(
                    "No PmlEdmDocumentReceiptProcessType exists with the primary key " +
                    docReceiptProcessTypeId);
            }

            return remove(pmlEdmDocumentReceiptProcessType);
        } catch (NoSuchPmlEdmDocumentReceiptProcessTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentReceiptProcessType remove(
        PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmDocumentReceiptProcessType);
            }
        }

        pmlEdmDocumentReceiptProcessType = removeImpl(pmlEdmDocumentReceiptProcessType);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmDocumentReceiptProcessType);
            }
        }

        return pmlEdmDocumentReceiptProcessType;
    }

    protected PmlEdmDocumentReceiptProcessType removeImpl(
        PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmDocumentReceiptProcessType);

            session.flush();

            return pmlEdmDocumentReceiptProcessType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentReceiptProcessType.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType, boolean merge)</code>.
     */
    public PmlEdmDocumentReceiptProcessType update(
        PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType) method. Use update(PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType, boolean merge) instead.");
        }

        return update(pmlEdmDocumentReceiptProcessType, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentReceiptProcessType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentReceiptProcessType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmDocumentReceiptProcessType update(
        PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType,
        boolean merge) throws SystemException {
        boolean isNew = pmlEdmDocumentReceiptProcessType.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmDocumentReceiptProcessType);
                } else {
                    listener.onBeforeUpdate(pmlEdmDocumentReceiptProcessType);
                }
            }
        }

        pmlEdmDocumentReceiptProcessType = updateImpl(pmlEdmDocumentReceiptProcessType,
                merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmDocumentReceiptProcessType);
                } else {
                    listener.onAfterUpdate(pmlEdmDocumentReceiptProcessType);
                }
            }
        }

        return pmlEdmDocumentReceiptProcessType;
    }

    public PmlEdmDocumentReceiptProcessType updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmDocumentReceiptProcessType);
            } else {
                if (pmlEdmDocumentReceiptProcessType.isNew()) {
                    session.save(pmlEdmDocumentReceiptProcessType);
                }
            }

            session.flush();

            pmlEdmDocumentReceiptProcessType.setNew(false);

            return pmlEdmDocumentReceiptProcessType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentReceiptProcessType.class.getName());
        }
    }

    public PmlEdmDocumentReceiptProcessType findByPrimaryKey(
        long docReceiptProcessTypeId)
        throws NoSuchPmlEdmDocumentReceiptProcessTypeException, SystemException {
        PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType = fetchByPrimaryKey(docReceiptProcessTypeId);

        if (pmlEdmDocumentReceiptProcessType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmDocumentReceiptProcessType exists with the primary key " +
                    docReceiptProcessTypeId);
            }

            throw new NoSuchPmlEdmDocumentReceiptProcessTypeException(
                "No PmlEdmDocumentReceiptProcessType exists with the primary key " +
                docReceiptProcessTypeId);
        }

        return pmlEdmDocumentReceiptProcessType;
    }

    public PmlEdmDocumentReceiptProcessType fetchByPrimaryKey(
        long docReceiptProcessTypeId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmDocumentReceiptProcessType) session.get(PmlEdmDocumentReceiptProcessTypeImpl.class,
                new Long(docReceiptProcessTypeId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptProcessType> findByDocumentReceiptId(
        long documentReceiptId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptProcessType.class.getName();
        String finderMethodName = "findByDocumentReceiptId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentReceiptId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType WHERE ");

                query.append("documentReceiptId = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processTypeOrderNo ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlEdmDocumentReceiptProcessType> list = q.list();

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
            return (List<PmlEdmDocumentReceiptProcessType>) result;
        }
    }

    public List<PmlEdmDocumentReceiptProcessType> findByDocumentReceiptId(
        long documentReceiptId, int start, int end) throws SystemException {
        return findByDocumentReceiptId(documentReceiptId, start, end, null);
    }

    public List<PmlEdmDocumentReceiptProcessType> findByDocumentReceiptId(
        long documentReceiptId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptProcessType.class.getName();
        String finderMethodName = "findByDocumentReceiptId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType WHERE ");

                query.append("documentReceiptId = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processTypeOrderNo ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlEdmDocumentReceiptProcessType> list = (List<PmlEdmDocumentReceiptProcessType>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptProcessType>) result;
        }
    }

    public PmlEdmDocumentReceiptProcessType findByDocumentReceiptId_First(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptProcessTypeException, SystemException {
        List<PmlEdmDocumentReceiptProcessType> list = findByDocumentReceiptId(documentReceiptId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append(
                "No PmlEdmDocumentReceiptProcessType exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptProcessTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptProcessType findByDocumentReceiptId_Last(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptProcessTypeException, SystemException {
        int count = countByDocumentReceiptId(documentReceiptId);

        List<PmlEdmDocumentReceiptProcessType> list = findByDocumentReceiptId(documentReceiptId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append(
                "No PmlEdmDocumentReceiptProcessType exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptProcessTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptProcessType[] findByDocumentReceiptId_PrevAndNext(
        long docReceiptProcessTypeId, long documentReceiptId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptProcessTypeException, SystemException {
        PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType = findByPrimaryKey(docReceiptProcessTypeId);

        int count = countByDocumentReceiptId(documentReceiptId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType WHERE ");

            query.append("documentReceiptId = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processTypeOrderNo ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentReceiptId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptProcessType);

            PmlEdmDocumentReceiptProcessType[] array = new PmlEdmDocumentReceiptProcessTypeImpl[3];

            array[0] = (PmlEdmDocumentReceiptProcessType) objArray[0];
            array[1] = (PmlEdmDocumentReceiptProcessType) objArray[1];
            array[2] = (PmlEdmDocumentReceiptProcessType) objArray[2];

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

    public List<PmlEdmDocumentReceiptProcessType> findAll()
        throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmDocumentReceiptProcessType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmDocumentReceiptProcessType> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptProcessType.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processTypeOrderNo ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmDocumentReceiptProcessType> list = (List<PmlEdmDocumentReceiptProcessType>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptProcessType>) result;
        }
    }

    public void removeByDocumentReceiptId(long documentReceiptId)
        throws SystemException {
        for (PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType : findByDocumentReceiptId(
                documentReceiptId)) {
            remove(pmlEdmDocumentReceiptProcessType);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmDocumentReceiptProcessType pmlEdmDocumentReceiptProcessType : findAll()) {
            remove(pmlEdmDocumentReceiptProcessType);
        }
    }

    public int countByDocumentReceiptId(long documentReceiptId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptProcessType.class.getName();
        String finderMethodName = "countByDocumentReceiptId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentReceiptId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType WHERE ");

                query.append("documentReceiptId = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptProcessTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptProcessType.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptProcessType")));

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
