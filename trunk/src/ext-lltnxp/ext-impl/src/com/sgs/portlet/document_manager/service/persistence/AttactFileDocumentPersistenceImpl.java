package com.sgs.portlet.document_manager.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.document_manager.NoSuchAttactFileDocumentException;
import com.sgs.portlet.document_manager.model.AttactFileDocument;
import com.sgs.portlet.document_manager.model.impl.AttactFileDocumentImpl;
import com.sgs.portlet.document_manager.model.impl.AttactFileDocumentModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class AttactFileDocumentPersistenceImpl extends BasePersistenceImpl
    implements AttactFileDocumentPersistence {
    private static Log _log = LogFactory.getLog(AttactFileDocumentPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public AttactFileDocument create(long attactFileDocumentId) {
        AttactFileDocument attactFileDocument = new AttactFileDocumentImpl();

        attactFileDocument.setNew(true);
        attactFileDocument.setPrimaryKey(attactFileDocumentId);

        return attactFileDocument;
    }

    public AttactFileDocument remove(long attactFileDocumentId)
        throws NoSuchAttactFileDocumentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AttactFileDocument attactFileDocument = (AttactFileDocument) session.get(AttactFileDocumentImpl.class,
                    new Long(attactFileDocumentId));

            if (attactFileDocument == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No AttactFileDocument exists with the primary key " +
                        attactFileDocumentId);
                }

                throw new NoSuchAttactFileDocumentException(
                    "No AttactFileDocument exists with the primary key " +
                    attactFileDocumentId);
            }

            return remove(attactFileDocument);
        } catch (NoSuchAttactFileDocumentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public AttactFileDocument remove(AttactFileDocument attactFileDocument)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(attactFileDocument);
            }
        }

        attactFileDocument = removeImpl(attactFileDocument);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(attactFileDocument);
            }
        }

        return attactFileDocument;
    }

    protected AttactFileDocument removeImpl(
        AttactFileDocument attactFileDocument) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(attactFileDocument);

            session.flush();

            return attactFileDocument;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(AttactFileDocument.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(AttactFileDocument attactFileDocument, boolean merge)</code>.
     */
    public AttactFileDocument update(AttactFileDocument attactFileDocument)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(AttactFileDocument attactFileDocument) method. Use update(AttactFileDocument attactFileDocument, boolean merge) instead.");
        }

        return update(attactFileDocument, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                attactFileDocument the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when attactFileDocument is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public AttactFileDocument update(AttactFileDocument attactFileDocument,
        boolean merge) throws SystemException {
        boolean isNew = attactFileDocument.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(attactFileDocument);
                } else {
                    listener.onBeforeUpdate(attactFileDocument);
                }
            }
        }

        attactFileDocument = updateImpl(attactFileDocument, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(attactFileDocument);
                } else {
                    listener.onAfterUpdate(attactFileDocument);
                }
            }
        }

        return attactFileDocument;
    }

    public AttactFileDocument updateImpl(
        com.sgs.portlet.document_manager.model.AttactFileDocument attactFileDocument,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(attactFileDocument);
            } else {
                if (attactFileDocument.isNew()) {
                    session.save(attactFileDocument);
                }
            }

            session.flush();

            attactFileDocument.setNew(false);

            return attactFileDocument;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(AttactFileDocument.class.getName());
        }
    }

    public AttactFileDocument findByPrimaryKey(long attactFileDocumentId)
        throws NoSuchAttactFileDocumentException, SystemException {
        AttactFileDocument attactFileDocument = fetchByPrimaryKey(attactFileDocumentId);

        if (attactFileDocument == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No AttactFileDocument exists with the primary key " +
                    attactFileDocumentId);
            }

            throw new NoSuchAttactFileDocumentException(
                "No AttactFileDocument exists with the primary key " +
                attactFileDocumentId);
        }

        return attactFileDocument;
    }

    public AttactFileDocument fetchByPrimaryKey(long attactFileDocumentId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (AttactFileDocument) session.get(AttactFileDocumentImpl.class,
                new Long(attactFileDocumentId));
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

    public List<AttactFileDocument> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<AttactFileDocument> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<AttactFileDocument> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = AttactFileDocumentModelImpl.CACHE_ENABLED;
        String finderClassName = AttactFileDocument.class.getName();
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
                    "FROM com.sgs.portlet.document_manager.model.AttactFileDocument ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<AttactFileDocument> list = (List<AttactFileDocument>) QueryUtil.list(q,
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
            return (List<AttactFileDocument>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (AttactFileDocument attactFileDocument : findAll()) {
            remove(attactFileDocument);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = AttactFileDocumentModelImpl.CACHE_ENABLED;
        String finderClassName = AttactFileDocument.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document_manager.model.AttactFileDocument");

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
                        "value.object.listener.com.sgs.portlet.document_manager.model.AttactFileDocument")));

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
