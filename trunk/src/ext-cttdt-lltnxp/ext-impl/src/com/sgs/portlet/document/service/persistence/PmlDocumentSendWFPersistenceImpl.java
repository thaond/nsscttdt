package com.sgs.portlet.document.service.persistence;

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

import com.sgs.portlet.document.NoSuchSendWFException;
import com.sgs.portlet.document.model.PmlDocumentSendWF;
import com.sgs.portlet.document.model.impl.PmlDocumentSendWFImpl;
import com.sgs.portlet.document.model.impl.PmlDocumentSendWFModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlDocumentSendWFPersistenceImpl extends BasePersistenceImpl
    implements PmlDocumentSendWFPersistence {
    private static Log _log = LogFactory.getLog(PmlDocumentSendWFPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlDocumentSendWF create(long documentSendId) {
        PmlDocumentSendWF pmlDocumentSendWF = new PmlDocumentSendWFImpl();

        pmlDocumentSendWF.setNew(true);
        pmlDocumentSendWF.setPrimaryKey(documentSendId);

        return pmlDocumentSendWF;
    }

    public PmlDocumentSendWF remove(long documentSendId)
        throws NoSuchSendWFException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlDocumentSendWF pmlDocumentSendWF = (PmlDocumentSendWF) session.get(PmlDocumentSendWFImpl.class,
                    new Long(documentSendId));

            if (pmlDocumentSendWF == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlDocumentSendWF exists with the primary key " +
                        documentSendId);
                }

                throw new NoSuchSendWFException(
                    "No PmlDocumentSendWF exists with the primary key " +
                    documentSendId);
            }

            return remove(pmlDocumentSendWF);
        } catch (NoSuchSendWFException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlDocumentSendWF remove(PmlDocumentSendWF pmlDocumentSendWF)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlDocumentSendWF);
            }
        }

        pmlDocumentSendWF = removeImpl(pmlDocumentSendWF);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlDocumentSendWF);
            }
        }

        return pmlDocumentSendWF;
    }

    protected PmlDocumentSendWF removeImpl(PmlDocumentSendWF pmlDocumentSendWF)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlDocumentSendWF);

            session.flush();

            return pmlDocumentSendWF;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDocumentSendWF.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlDocumentSendWF pmlDocumentSendWF, boolean merge)</code>.
     */
    public PmlDocumentSendWF update(PmlDocumentSendWF pmlDocumentSendWF)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlDocumentSendWF pmlDocumentSendWF) method. Use update(PmlDocumentSendWF pmlDocumentSendWF, boolean merge) instead.");
        }

        return update(pmlDocumentSendWF, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentSendWF the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentSendWF is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlDocumentSendWF update(PmlDocumentSendWF pmlDocumentSendWF,
        boolean merge) throws SystemException {
        boolean isNew = pmlDocumentSendWF.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlDocumentSendWF);
                } else {
                    listener.onBeforeUpdate(pmlDocumentSendWF);
                }
            }
        }

        pmlDocumentSendWF = updateImpl(pmlDocumentSendWF, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlDocumentSendWF);
                } else {
                    listener.onAfterUpdate(pmlDocumentSendWF);
                }
            }
        }

        return pmlDocumentSendWF;
    }

    public PmlDocumentSendWF updateImpl(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlDocumentSendWF);
            } else {
                if (pmlDocumentSendWF.isNew()) {
                    session.save(pmlDocumentSendWF);
                }
            }

            session.flush();

            pmlDocumentSendWF.setNew(false);

            return pmlDocumentSendWF;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDocumentSendWF.class.getName());
        }
    }

    public PmlDocumentSendWF findByPrimaryKey(long documentSendId)
        throws NoSuchSendWFException, SystemException {
        PmlDocumentSendWF pmlDocumentSendWF = fetchByPrimaryKey(documentSendId);

        if (pmlDocumentSendWF == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlDocumentSendWF exists with the primary key " +
                    documentSendId);
            }

            throw new NoSuchSendWFException(
                "No PmlDocumentSendWF exists with the primary key " +
                documentSendId);
        }

        return pmlDocumentSendWF;
    }

    public PmlDocumentSendWF fetchByPrimaryKey(long documentSendId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlDocumentSendWF) session.get(PmlDocumentSendWFImpl.class,
                new Long(documentSendId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentSendWF> findByProcessId(long processId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendWF.class.getName();
        String finderMethodName = "findByProcessId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(processId) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendWF WHERE ");

                query.append("processid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId);

                List<PmlDocumentSendWF> list = q.list();

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
            return (List<PmlDocumentSendWF>) result;
        }
    }

    public List<PmlDocumentSendWF> findByProcessId(long processId, int start,
        int end) throws SystemException {
        return findByProcessId(processId, start, end, null);
    }

    public List<PmlDocumentSendWF> findByProcessId(long processId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendWF.class.getName();
        String finderMethodName = "findByProcessId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(processId),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendWF WHERE ");

                query.append("processid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId);

                List<PmlDocumentSendWF> list = (List<PmlDocumentSendWF>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendWF>) result;
        }
    }

    public PmlDocumentSendWF findByProcessId_First(long processId,
        OrderByComparator obc) throws NoSuchSendWFException, SystemException {
        List<PmlDocumentSendWF> list = findByProcessId(processId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendWF exists with the key {");

            msg.append("processId=" + processId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendWFException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendWF findByProcessId_Last(long processId,
        OrderByComparator obc) throws NoSuchSendWFException, SystemException {
        int count = countByProcessId(processId);

        List<PmlDocumentSendWF> list = findByProcessId(processId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentSendWF exists with the key {");

            msg.append("processId=" + processId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchSendWFException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentSendWF[] findByProcessId_PrevAndNext(
        long documentSendId, long processId, OrderByComparator obc)
        throws NoSuchSendWFException, SystemException {
        PmlDocumentSendWF pmlDocumentSendWF = findByPrimaryKey(documentSendId);

        int count = countByProcessId(processId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentSendWF WHERE ");

            query.append("processid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentSendWF);

            PmlDocumentSendWF[] array = new PmlDocumentSendWFImpl[3];

            array[0] = (PmlDocumentSendWF) objArray[0];
            array[1] = (PmlDocumentSendWF) objArray[1];
            array[2] = (PmlDocumentSendWF) objArray[2];

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

    public List<PmlDocumentSendWF> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlDocumentSendWF> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlDocumentSendWF> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendWF.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendWF ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlDocumentSendWF> list = (List<PmlDocumentSendWF>) QueryUtil.list(q,
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
            return (List<PmlDocumentSendWF>) result;
        }
    }

    public void removeByProcessId(long processId) throws SystemException {
        for (PmlDocumentSendWF pmlDocumentSendWF : findByProcessId(processId)) {
            remove(pmlDocumentSendWF);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlDocumentSendWF pmlDocumentSendWF : findAll()) {
            remove(pmlDocumentSendWF);
        }
    }

    public int countByProcessId(long processId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentSendWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendWF.class.getName();
        String finderMethodName = "countByProcessId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(processId) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentSendWF WHERE ");

                query.append("processid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId);

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
        boolean finderClassNameCacheEnabled = PmlDocumentSendWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentSendWF.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.model.PmlDocumentSendWF");

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
                        "value.object.listener.com.sgs.portlet.document.model.PmlDocumentSendWF")));

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
