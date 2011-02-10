package com.sgs.portlet.document_manager.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.document_manager.NoSuchException;
import com.sgs.portlet.document_manager.model.DocumentManager;
import com.sgs.portlet.document_manager.model.impl.DocumentManagerImpl;
import com.sgs.portlet.document_manager.model.impl.DocumentManagerModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class DocumentManagerPersistenceImpl extends BasePersistenceImpl
    implements DocumentManagerPersistence {
    private static final String _SQL_GETATTACTFILEDOCUMENTS = "SELECT {attact_file_document.*} FROM attact_file_document INNER JOIN document_manager ON (document_manager.documentManagerId = attact_file_document.documentManagerId) WHERE (document_manager.documentManagerId = ?)";
    private static final String _SQL_GETATTACTFILEDOCUMENTSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM attact_file_document WHERE documentManagerId = ?";
    private static final String _SQL_CONTAINSATTACTFILEDOCUMENT = "SELECT COUNT(*) AS COUNT_VALUE FROM attact_file_document WHERE documentManagerId = ? AND attactFileDocumentId = ?";
    private static Log _log = LogFactory.getLog(DocumentManagerPersistenceImpl.class);
    protected ContainsAttactFileDocument containsAttactFileDocument;
    private ModelListener[] _listeners = new ModelListener[0];

    public DocumentManager create(long documentManagerId) {
        DocumentManager documentManager = new DocumentManagerImpl();

        documentManager.setNew(true);
        documentManager.setPrimaryKey(documentManagerId);

        return documentManager;
    }

    public DocumentManager remove(long documentManagerId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            DocumentManager documentManager = (DocumentManager) session.get(DocumentManagerImpl.class,
                    new Long(documentManagerId));

            if (documentManager == null) {
                if (_log.isWarnEnabled()) {
//                    _log.warn("No DocumentManager exists with the primary key " + documentManagerId);
                }

                throw new NoSuchException(
                    "No DocumentManager exists with the primary key " +
                    documentManagerId);
            }

            return remove(documentManager);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public DocumentManager remove(DocumentManager documentManager)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(documentManager);
            }
        }

        documentManager = removeImpl(documentManager);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(documentManager);
            }
        }

        return documentManager;
    }

    protected DocumentManager removeImpl(DocumentManager documentManager)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(documentManager);

            session.flush();

            return documentManager;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(DocumentManager.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(DocumentManager documentManager, boolean merge)</code>.
     */
    public DocumentManager update(DocumentManager documentManager)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(DocumentManager documentManager) method. Use update(DocumentManager documentManager, boolean merge) instead.");
        }

        return update(documentManager, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                documentManager the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when documentManager is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public DocumentManager update(DocumentManager documentManager, boolean merge)
        throws SystemException {
        boolean isNew = documentManager.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(documentManager);
                } else {
                    listener.onBeforeUpdate(documentManager);
                }
            }
        }

        documentManager = updateImpl(documentManager, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(documentManager);
                } else {
                    listener.onAfterUpdate(documentManager);
                }
            }
        }

        return documentManager;
    }

    public DocumentManager updateImpl(
        com.sgs.portlet.document_manager.model.DocumentManager documentManager,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(documentManager);
            } else {
                if (documentManager.isNew()) {
                    session.save(documentManager);
                }
            }

            session.flush();

            documentManager.setNew(false);

            return documentManager;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(DocumentManager.class.getName());
        }
    }

    public DocumentManager findByPrimaryKey(long documentManagerId)
        throws NoSuchException, SystemException {
        DocumentManager documentManager = fetchByPrimaryKey(documentManagerId);

        if (documentManager == null) {
            if (_log.isWarnEnabled()) {
//                _log.warn("No DocumentManager exists with the primary key " + documentManagerId);
            }

            throw new NoSuchException(
                "No DocumentManager exists with the primary key " +
                documentManagerId);
        }

        return documentManager;
    }

    public DocumentManager fetchByPrimaryKey(long documentManagerId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (DocumentManager) session.get(DocumentManagerImpl.class,
                new Long(documentManagerId));
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

    public List<DocumentManager> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<DocumentManager> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<DocumentManager> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = DocumentManagerModelImpl.CACHE_ENABLED;
        String finderClassName = DocumentManager.class.getName();
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
                    "FROM com.sgs.portlet.document_manager.model.DocumentManager ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<DocumentManager> list = (List<DocumentManager>) QueryUtil.list(q,
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
            return (List<DocumentManager>) result;
        }
    }

    public void removeAll() throws SystemException {
        for (DocumentManager documentManager : findAll()) {
            remove(documentManager);
        }
    }

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = DocumentManagerModelImpl.CACHE_ENABLED;
        String finderClassName = DocumentManager.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document_manager.model.DocumentManager");

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

    public List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        long pk) throws SystemException {
        return getAttactFileDocuments(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    }

    public List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        long pk, int start, int end) throws SystemException {
        return getAttactFileDocuments(pk, start, end, null);
    }

    public List<com.sgs.portlet.document_manager.model.AttactFileDocument> getAttactFileDocuments(
        long pk, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.document_manager.model.impl.AttactFileDocumentModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.document_manager.model.AttactFileDocument.class.getName();

        String finderMethodName = "getAttactFileDocuments";
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

                sb.append(_SQL_GETATTACTFILEDOCUMENTS);

                if (obc != null) {
                    sb.append("ORDER BY ");
                    sb.append(obc.getOrderBy());
                }

                String sql = sb.toString();

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("attact_file_document",
                    com.sgs.portlet.document_manager.model.impl.AttactFileDocumentImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                List<com.sgs.portlet.document_manager.model.AttactFileDocument> list =
                    (List<com.sgs.portlet.document_manager.model.AttactFileDocument>) QueryUtil.list(q,
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
            return (List<com.sgs.portlet.document_manager.model.AttactFileDocument>) result;
        }
    }

    public int getAttactFileDocumentsSize(long pk) throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.document_manager.model.impl.AttactFileDocumentModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.document_manager.model.AttactFileDocument.class.getName();

        String finderMethodName = "getAttactFileDocumentsSize";
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

                SQLQuery q = session.createSQLQuery(_SQL_GETATTACTFILEDOCUMENTSSIZE);

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

    public boolean containsAttactFileDocument(long pk, long attactFileDocumentPK)
        throws SystemException {
        boolean finderClassNameCacheEnabled = com.sgs.portlet.document_manager.model.impl.AttactFileDocumentModelImpl.CACHE_ENABLED;

        String finderClassName = com.sgs.portlet.document_manager.model.AttactFileDocument.class.getName();

        String finderMethodName = "containsAttactFileDocuments";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(pk),
                
                new Long(attactFileDocumentPK)
            };

        Object result = null;

        if (finderClassNameCacheEnabled) {
            result = FinderCacheUtil.getResult(finderClassName,
                    finderMethodName, finderParams, finderArgs, this);
        }

        if (result == null) {
            try {
                Boolean value = Boolean.valueOf(containsAttactFileDocument.contains(
                            pk, attactFileDocumentPK));

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

    public boolean containsAttactFileDocuments(long pk)
        throws SystemException {
        if (getAttactFileDocumentsSize(pk) > 0) {
            return true;
        } else {
            return false;
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
                        "value.object.listener.com.sgs.portlet.document_manager.model.DocumentManager")));

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

        containsAttactFileDocument = new ContainsAttactFileDocument(this);
    }

    protected class ContainsAttactFileDocument {
        private MappingSqlQuery _mappingSqlQuery;

        protected ContainsAttactFileDocument(
            DocumentManagerPersistenceImpl persistenceImpl) {
            super();

            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSATTACTFILEDOCUMENT,
                    new int[] { Types.BIGINT, Types.BIGINT }, RowMapper.COUNT);
        }

        protected boolean contains(long documentManagerId,
            long attactFileDocumentId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(documentManagerId),
                        new Long(attactFileDocumentId)
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
}
