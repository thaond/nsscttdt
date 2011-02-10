package com.sgs.portlet.onedoorpccc.service.persistence;

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

import com.sgs.portlet.onedoorpccc.NoSuchPmlPaintDocumentException;
import com.sgs.portlet.onedoorpccc.model.PmlPaintDocument;
import com.sgs.portlet.onedoorpccc.model.impl.PmlPaintDocumentImpl;
import com.sgs.portlet.onedoorpccc.model.impl.PmlPaintDocumentModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlPaintDocumentPersistenceImpl extends BasePersistenceImpl
    implements PmlPaintDocumentPersistence {
    private static Log _log = LogFactory.getLog(PmlPaintDocumentPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlPaintDocument create(long paintDocumentId) {
        PmlPaintDocument pmlPaintDocument = new PmlPaintDocumentImpl();

        pmlPaintDocument.setNew(true);
        pmlPaintDocument.setPrimaryKey(paintDocumentId);

        return pmlPaintDocument;
    }

    public PmlPaintDocument remove(long paintDocumentId)
        throws NoSuchPmlPaintDocumentException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlPaintDocument pmlPaintDocument = (PmlPaintDocument) session.get(PmlPaintDocumentImpl.class,
                    new Long(paintDocumentId));

            if (pmlPaintDocument == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlPaintDocument exists with the primary key " +
                        paintDocumentId);
                }

                throw new NoSuchPmlPaintDocumentException(
                    "No PmlPaintDocument exists with the primary key " +
                    paintDocumentId);
            }

            return remove(pmlPaintDocument);
        } catch (NoSuchPmlPaintDocumentException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlPaintDocument remove(PmlPaintDocument pmlPaintDocument)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlPaintDocument);
            }
        }

        pmlPaintDocument = removeImpl(pmlPaintDocument);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlPaintDocument);
            }
        }

        return pmlPaintDocument;
    }

    protected PmlPaintDocument removeImpl(PmlPaintDocument pmlPaintDocument)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlPaintDocument);

            session.flush();

            return pmlPaintDocument;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlPaintDocument.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlPaintDocument pmlPaintDocument, boolean merge)</code>.
     */
    public PmlPaintDocument update(PmlPaintDocument pmlPaintDocument)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlPaintDocument pmlPaintDocument) method. Use update(PmlPaintDocument pmlPaintDocument, boolean merge) instead.");
        }

        return update(pmlPaintDocument, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlPaintDocument the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlPaintDocument is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlPaintDocument update(PmlPaintDocument pmlPaintDocument,
        boolean merge) throws SystemException {
        boolean isNew = pmlPaintDocument.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlPaintDocument);
                } else {
                    listener.onBeforeUpdate(pmlPaintDocument);
                }
            }
        }

        pmlPaintDocument = updateImpl(pmlPaintDocument, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlPaintDocument);
                } else {
                    listener.onAfterUpdate(pmlPaintDocument);
                }
            }
        }

        return pmlPaintDocument;
    }

    public PmlPaintDocument updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlPaintDocument pmlPaintDocument,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlPaintDocument);
            } else {
                if (pmlPaintDocument.isNew()) {
                    session.save(pmlPaintDocument);
                }
            }

            session.flush();

            pmlPaintDocument.setNew(false);

            return pmlPaintDocument;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlPaintDocument.class.getName());
        }
    }

    public PmlPaintDocument findByPrimaryKey(long paintDocumentId)
        throws NoSuchPmlPaintDocumentException, SystemException {
        PmlPaintDocument pmlPaintDocument = fetchByPrimaryKey(paintDocumentId);

        if (pmlPaintDocument == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlPaintDocument exists with the primary key " +
                    paintDocumentId);
            }

            throw new NoSuchPmlPaintDocumentException(
                "No PmlPaintDocument exists with the primary key " +
                paintDocumentId);
        }

        return pmlPaintDocument;
    }

    public PmlPaintDocument fetchByPrimaryKey(long paintDocumentId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlPaintDocument) session.get(PmlPaintDocumentImpl.class,
                new Long(paintDocumentId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlPaintDocument> findByQuantity(int quantity)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlPaintDocumentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlPaintDocument.class.getName();
        String finderMethodName = "findByQuantity";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(quantity) };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlPaintDocument WHERE ");

                query.append("quantity = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("paintdocumentid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(quantity);

                List<PmlPaintDocument> list = q.list();

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
            return (List<PmlPaintDocument>) result;
        }
    }

    public List<PmlPaintDocument> findByQuantity(int quantity, int start,
        int end) throws SystemException {
        return findByQuantity(quantity, start, end, null);
    }

    public List<PmlPaintDocument> findByQuantity(int quantity, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlPaintDocumentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlPaintDocument.class.getName();
        String finderMethodName = "findByQuantity";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(quantity),
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlPaintDocument WHERE ");

                query.append("quantity = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("paintdocumentid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(quantity);

                List<PmlPaintDocument> list = (List<PmlPaintDocument>) QueryUtil.list(q,
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
            return (List<PmlPaintDocument>) result;
        }
    }

    public PmlPaintDocument findByQuantity_First(int quantity,
        OrderByComparator obc)
        throws NoSuchPmlPaintDocumentException, SystemException {
        List<PmlPaintDocument> list = findByQuantity(quantity, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlPaintDocument exists with the key {");

            msg.append("quantity=" + quantity);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlPaintDocumentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlPaintDocument findByQuantity_Last(int quantity,
        OrderByComparator obc)
        throws NoSuchPmlPaintDocumentException, SystemException {
        int count = countByQuantity(quantity);

        List<PmlPaintDocument> list = findByQuantity(quantity, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlPaintDocument exists with the key {");

            msg.append("quantity=" + quantity);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlPaintDocumentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlPaintDocument[] findByQuantity_PrevAndNext(long paintDocumentId,
        int quantity, OrderByComparator obc)
        throws NoSuchPmlPaintDocumentException, SystemException {
        PmlPaintDocument pmlPaintDocument = findByPrimaryKey(paintDocumentId);

        int count = countByQuantity(quantity);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlPaintDocument WHERE ");

            query.append("quantity = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("paintdocumentid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(quantity);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlPaintDocument);

            PmlPaintDocument[] array = new PmlPaintDocumentImpl[3];

            array[0] = (PmlPaintDocument) objArray[0];
            array[1] = (PmlPaintDocument) objArray[1];
            array[2] = (PmlPaintDocument) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlPaintDocument> findByFileId(String fileId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlPaintDocumentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlPaintDocument.class.getName();
        String finderMethodName = "findByFileId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileId };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlPaintDocument WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("paintdocumentid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                List<PmlPaintDocument> list = q.list();

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
            return (List<PmlPaintDocument>) result;
        }
    }

    public List<PmlPaintDocument> findByFileId(String fileId, int start, int end)
        throws SystemException {
        return findByFileId(fileId, start, end, null);
    }

    public List<PmlPaintDocument> findByFileId(String fileId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlPaintDocumentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlPaintDocument.class.getName();
        String finderMethodName = "findByFileId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileId,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlPaintDocument WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("paintdocumentid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                List<PmlPaintDocument> list = (List<PmlPaintDocument>) QueryUtil.list(q,
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
            return (List<PmlPaintDocument>) result;
        }
    }

    public PmlPaintDocument findByFileId_First(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlPaintDocumentException, SystemException {
        List<PmlPaintDocument> list = findByFileId(fileId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlPaintDocument exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlPaintDocumentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlPaintDocument findByFileId_Last(String fileId,
        OrderByComparator obc)
        throws NoSuchPmlPaintDocumentException, SystemException {
        int count = countByFileId(fileId);

        List<PmlPaintDocument> list = findByFileId(fileId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlPaintDocument exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlPaintDocumentException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlPaintDocument[] findByFileId_PrevAndNext(long paintDocumentId,
        String fileId, OrderByComparator obc)
        throws NoSuchPmlPaintDocumentException, SystemException {
        PmlPaintDocument pmlPaintDocument = findByPrimaryKey(paintDocumentId);

        int count = countByFileId(fileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlPaintDocument WHERE ");

            if (fileId == null) {
                query.append("fileid LIKE null");
            } else {
                query.append("fileid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("paintdocumentid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlPaintDocument);

            PmlPaintDocument[] array = new PmlPaintDocumentImpl[3];

            array[0] = (PmlPaintDocument) objArray[0];
            array[1] = (PmlPaintDocument) objArray[1];
            array[2] = (PmlPaintDocument) objArray[2];

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

    public List<PmlPaintDocument> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlPaintDocument> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlPaintDocument> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlPaintDocumentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlPaintDocument.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlPaintDocument ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("paintdocumentid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlPaintDocument> list = (List<PmlPaintDocument>) QueryUtil.list(q,
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
            return (List<PmlPaintDocument>) result;
        }
    }

    public void removeByQuantity(int quantity) throws SystemException {
        for (PmlPaintDocument pmlPaintDocument : findByQuantity(quantity)) {
            remove(pmlPaintDocument);
        }
    }

    public void removeByFileId(String fileId) throws SystemException {
        for (PmlPaintDocument pmlPaintDocument : findByFileId(fileId)) {
            remove(pmlPaintDocument);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlPaintDocument pmlPaintDocument : findAll()) {
            remove(pmlPaintDocument);
        }
    }

    public int countByQuantity(int quantity) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlPaintDocumentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlPaintDocument.class.getName();
        String finderMethodName = "countByQuantity";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(quantity) };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlPaintDocument WHERE ");

                query.append("quantity = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(quantity);

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

    public int countByFileId(String fileId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlPaintDocumentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlPaintDocument.class.getName();
        String finderMethodName = "countByFileId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileId };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlPaintDocument WHERE ");

                if (fileId == null) {
                    query.append("fileid LIKE null");
                } else {
                    query.append("fileid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
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
        boolean finderClassNameCacheEnabled = PmlPaintDocumentModelImpl.CACHE_ENABLED;
        String finderClassName = PmlPaintDocument.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoorpccc.model.PmlPaintDocument");

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
                        "value.object.listener.com.sgs.portlet.onedoorpccc.model.PmlPaintDocument")));

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
