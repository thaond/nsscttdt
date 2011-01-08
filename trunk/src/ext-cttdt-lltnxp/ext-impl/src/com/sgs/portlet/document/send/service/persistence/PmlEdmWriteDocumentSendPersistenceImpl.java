package com.sgs.portlet.document.send.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.document.send.NoSuchPmlEdmWriteDocumentSendException;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmWriteDocumentSendImpl;
import com.sgs.portlet.document.send.model.impl.PmlEdmWriteDocumentSendModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlEdmWriteDocumentSendPersistenceImpl extends BasePersistenceImpl
    implements PmlEdmWriteDocumentSendPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmWriteDocumentSendPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmWriteDocumentSend create(
        PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK) {
        PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend = new PmlEdmWriteDocumentSendImpl();

        pmlEdmWriteDocumentSend.setNew(true);
        pmlEdmWriteDocumentSend.setPrimaryKey(pmlEdmWriteDocumentSendPK);

        return pmlEdmWriteDocumentSend;
    }

    public PmlEdmWriteDocumentSend remove(
        PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws NoSuchPmlEdmWriteDocumentSendException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend = (PmlEdmWriteDocumentSend) session.get(PmlEdmWriteDocumentSendImpl.class,
                    pmlEdmWriteDocumentSendPK);

            if (pmlEdmWriteDocumentSend == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmWriteDocumentSend exists with the primary key " +
                        pmlEdmWriteDocumentSendPK);
                }

                throw new NoSuchPmlEdmWriteDocumentSendException(
                    "No PmlEdmWriteDocumentSend exists with the primary key " +
                    pmlEdmWriteDocumentSendPK);
            }

            return remove(pmlEdmWriteDocumentSend);
        } catch (NoSuchPmlEdmWriteDocumentSendException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmWriteDocumentSend remove(
        PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmWriteDocumentSend);
            }
        }

        pmlEdmWriteDocumentSend = removeImpl(pmlEdmWriteDocumentSend);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmWriteDocumentSend);
            }
        }

        return pmlEdmWriteDocumentSend;
    }

    protected PmlEdmWriteDocumentSend removeImpl(
        PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmWriteDocumentSend);

            session.flush();

            return pmlEdmWriteDocumentSend;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmWriteDocumentSend.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend, boolean merge)</code>.
     */
    public PmlEdmWriteDocumentSend update(
        PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend) method. Use update(PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend, boolean merge) instead.");
        }

        return update(pmlEdmWriteDocumentSend, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmWriteDocumentSend the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmWriteDocumentSend is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmWriteDocumentSend update(
        PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmWriteDocumentSend.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmWriteDocumentSend);
                } else {
                    listener.onBeforeUpdate(pmlEdmWriteDocumentSend);
                }
            }
        }

        pmlEdmWriteDocumentSend = updateImpl(pmlEdmWriteDocumentSend, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmWriteDocumentSend);
                } else {
                    listener.onAfterUpdate(pmlEdmWriteDocumentSend);
                }
            }
        }

        return pmlEdmWriteDocumentSend;
    }

    public PmlEdmWriteDocumentSend updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmWriteDocumentSend);
            } else {
                if (pmlEdmWriteDocumentSend.isNew()) {
                    session.save(pmlEdmWriteDocumentSend);
                }
            }

            session.flush();

            pmlEdmWriteDocumentSend.setNew(false);

            return pmlEdmWriteDocumentSend;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmWriteDocumentSend.class.getName());
        }
    }

    public PmlEdmWriteDocumentSend findByPrimaryKey(
        PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws NoSuchPmlEdmWriteDocumentSendException, SystemException {
        PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend = fetchByPrimaryKey(pmlEdmWriteDocumentSendPK);

        if (pmlEdmWriteDocumentSend == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmWriteDocumentSend exists with the primary key " +
                    pmlEdmWriteDocumentSendPK);
            }

            throw new NoSuchPmlEdmWriteDocumentSendException(
                "No PmlEdmWriteDocumentSend exists with the primary key " +
                pmlEdmWriteDocumentSendPK);
        }

        return pmlEdmWriteDocumentSend;
    }

    public PmlEdmWriteDocumentSend fetchByPrimaryKey(
        PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmWriteDocumentSend) session.get(PmlEdmWriteDocumentSendImpl.class,
                pmlEdmWriteDocumentSendPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmWriteDocumentSend> findByBookDocumentSendId(
        long bookDocumentSendId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmWriteDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmWriteDocumentSend.class.getName();
        String finderMethodName = "findByBookDocumentSendId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(bookDocumentSendId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend WHERE ");

                query.append("bookdocumentsendid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bookDocumentSendId);

                List<PmlEdmWriteDocumentSend> list = q.list();

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
            return (List<PmlEdmWriteDocumentSend>) result;
        }
    }

    public List<PmlEdmWriteDocumentSend> findByBookDocumentSendId(
        long bookDocumentSendId, int start, int end) throws SystemException {
        return findByBookDocumentSendId(bookDocumentSendId, start, end, null);
    }

    public List<PmlEdmWriteDocumentSend> findByBookDocumentSendId(
        long bookDocumentSendId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmWriteDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmWriteDocumentSend.class.getName();
        String finderMethodName = "findByBookDocumentSendId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(bookDocumentSendId),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend WHERE ");

                query.append("bookdocumentsendid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("bookdocumentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bookDocumentSendId);

                List<PmlEdmWriteDocumentSend> list = (List<PmlEdmWriteDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmWriteDocumentSend>) result;
        }
    }

    public PmlEdmWriteDocumentSend findByBookDocumentSendId_First(
        long bookDocumentSendId, OrderByComparator obc)
        throws NoSuchPmlEdmWriteDocumentSendException, SystemException {
        List<PmlEdmWriteDocumentSend> list = findByBookDocumentSendId(bookDocumentSendId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmWriteDocumentSend exists with the key {");

            msg.append("bookDocumentSendId=" + bookDocumentSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmWriteDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmWriteDocumentSend findByBookDocumentSendId_Last(
        long bookDocumentSendId, OrderByComparator obc)
        throws NoSuchPmlEdmWriteDocumentSendException, SystemException {
        int count = countByBookDocumentSendId(bookDocumentSendId);

        List<PmlEdmWriteDocumentSend> list = findByBookDocumentSendId(bookDocumentSendId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmWriteDocumentSend exists with the key {");

            msg.append("bookDocumentSendId=" + bookDocumentSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmWriteDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmWriteDocumentSend[] findByBookDocumentSendId_PrevAndNext(
        PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK,
        long bookDocumentSendId, OrderByComparator obc)
        throws NoSuchPmlEdmWriteDocumentSendException, SystemException {
        PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend = findByPrimaryKey(pmlEdmWriteDocumentSendPK);

        int count = countByBookDocumentSendId(bookDocumentSendId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend WHERE ");

            query.append("bookdocumentsendid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(bookDocumentSendId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmWriteDocumentSend);

            PmlEdmWriteDocumentSend[] array = new PmlEdmWriteDocumentSendImpl[3];

            array[0] = (PmlEdmWriteDocumentSend) objArray[0];
            array[1] = (PmlEdmWriteDocumentSend) objArray[1];
            array[2] = (PmlEdmWriteDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmWriteDocumentSend> findByDocumentSendId(
        long documentSendId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmWriteDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmWriteDocumentSend.class.getName();
        String finderMethodName = "findByDocumentSendId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentSendId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend WHERE ");

                query.append("documentsendid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                List<PmlEdmWriteDocumentSend> list = q.list();

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
            return (List<PmlEdmWriteDocumentSend>) result;
        }
    }

    public List<PmlEdmWriteDocumentSend> findByDocumentSendId(
        long documentSendId, int start, int end) throws SystemException {
        return findByDocumentSendId(documentSendId, start, end, null);
    }

    public List<PmlEdmWriteDocumentSend> findByDocumentSendId(
        long documentSendId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmWriteDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmWriteDocumentSend.class.getName();
        String finderMethodName = "findByDocumentSendId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentSendId),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend WHERE ");

                query.append("documentsendid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("bookdocumentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

                List<PmlEdmWriteDocumentSend> list = (List<PmlEdmWriteDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmWriteDocumentSend>) result;
        }
    }

    public PmlEdmWriteDocumentSend findByDocumentSendId_First(
        long documentSendId, OrderByComparator obc)
        throws NoSuchPmlEdmWriteDocumentSendException, SystemException {
        List<PmlEdmWriteDocumentSend> list = findByDocumentSendId(documentSendId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmWriteDocumentSend exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmWriteDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmWriteDocumentSend findByDocumentSendId_Last(
        long documentSendId, OrderByComparator obc)
        throws NoSuchPmlEdmWriteDocumentSendException, SystemException {
        int count = countByDocumentSendId(documentSendId);

        List<PmlEdmWriteDocumentSend> list = findByDocumentSendId(documentSendId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmWriteDocumentSend exists with the key {");

            msg.append("documentSendId=" + documentSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmWriteDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmWriteDocumentSend[] findByDocumentSendId_PrevAndNext(
        PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK,
        long documentSendId, OrderByComparator obc)
        throws NoSuchPmlEdmWriteDocumentSendException, SystemException {
        PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend = findByPrimaryKey(pmlEdmWriteDocumentSendPK);

        int count = countByDocumentSendId(documentSendId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend WHERE ");

            query.append("documentsendid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentSendId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmWriteDocumentSend);

            PmlEdmWriteDocumentSend[] array = new PmlEdmWriteDocumentSendImpl[3];

            array[0] = (PmlEdmWriteDocumentSend) objArray[0];
            array[1] = (PmlEdmWriteDocumentSend) objArray[1];
            array[2] = (PmlEdmWriteDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmWriteDocumentSend> findByDateCreated(Date dateCreated)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmWriteDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmWriteDocumentSend.class.getName();
        String finderMethodName = "findByDateCreated";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateCreated };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend WHERE ");

                if (dateCreated == null) {
                    query.append("datecreated IS NULL");
                } else {
                    query.append("datecreated = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                List<PmlEdmWriteDocumentSend> list = q.list();

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
            return (List<PmlEdmWriteDocumentSend>) result;
        }
    }

    public List<PmlEdmWriteDocumentSend> findByDateCreated(Date dateCreated,
        int start, int end) throws SystemException {
        return findByDateCreated(dateCreated, start, end, null);
    }

    public List<PmlEdmWriteDocumentSend> findByDateCreated(Date dateCreated,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmWriteDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmWriteDocumentSend.class.getName();
        String finderMethodName = "findByDateCreated";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                dateCreated,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend WHERE ");

                if (dateCreated == null) {
                    query.append("datecreated IS NULL");
                } else {
                    query.append("datecreated = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("bookdocumentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                List<PmlEdmWriteDocumentSend> list = (List<PmlEdmWriteDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmWriteDocumentSend>) result;
        }
    }

    public PmlEdmWriteDocumentSend findByDateCreated_First(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlEdmWriteDocumentSendException, SystemException {
        List<PmlEdmWriteDocumentSend> list = findByDateCreated(dateCreated, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmWriteDocumentSend exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmWriteDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmWriteDocumentSend findByDateCreated_Last(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlEdmWriteDocumentSendException, SystemException {
        int count = countByDateCreated(dateCreated);

        List<PmlEdmWriteDocumentSend> list = findByDateCreated(dateCreated,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmWriteDocumentSend exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmWriteDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmWriteDocumentSend[] findByDateCreated_PrevAndNext(
        PmlEdmWriteDocumentSendPK pmlEdmWriteDocumentSendPK, Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlEdmWriteDocumentSendException, SystemException {
        PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend = findByPrimaryKey(pmlEdmWriteDocumentSendPK);

        int count = countByDateCreated(dateCreated);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend WHERE ");

            if (dateCreated == null) {
                query.append("datecreated IS NULL");
            } else {
                query.append("datecreated = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateCreated != null) {
                qPos.add(CalendarUtil.getTimestamp(dateCreated));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmWriteDocumentSend);

            PmlEdmWriteDocumentSend[] array = new PmlEdmWriteDocumentSendImpl[3];

            array[0] = (PmlEdmWriteDocumentSend) objArray[0];
            array[1] = (PmlEdmWriteDocumentSend) objArray[1];
            array[2] = (PmlEdmWriteDocumentSend) objArray[2];

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

    public List<PmlEdmWriteDocumentSend> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmWriteDocumentSend> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmWriteDocumentSend> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmWriteDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmWriteDocumentSend.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("bookdocumentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmWriteDocumentSend> list = (List<PmlEdmWriteDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmWriteDocumentSend>) result;
        }
    }

    public void removeByBookDocumentSendId(long bookDocumentSendId)
        throws SystemException {
        for (PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend : findByBookDocumentSendId(
                bookDocumentSendId)) {
            remove(pmlEdmWriteDocumentSend);
        }
    }

    public void removeByDocumentSendId(long documentSendId)
        throws SystemException {
        for (PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend : findByDocumentSendId(
                documentSendId)) {
            remove(pmlEdmWriteDocumentSend);
        }
    }

    public void removeByDateCreated(Date dateCreated) throws SystemException {
        for (PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend : findByDateCreated(
                dateCreated)) {
            remove(pmlEdmWriteDocumentSend);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmWriteDocumentSend pmlEdmWriteDocumentSend : findAll()) {
            remove(pmlEdmWriteDocumentSend);
        }
    }

    public int countByBookDocumentSendId(long bookDocumentSendId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmWriteDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmWriteDocumentSend.class.getName();
        String finderMethodName = "countByBookDocumentSendId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(bookDocumentSendId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend WHERE ");

                query.append("bookdocumentsendid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(bookDocumentSendId);

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

    public int countByDocumentSendId(long documentSendId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmWriteDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmWriteDocumentSend.class.getName();
        String finderMethodName = "countByDocumentSendId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentSendId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend WHERE ");

                query.append("documentsendid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentSendId);

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

    public int countByDateCreated(Date dateCreated) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmWriteDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmWriteDocumentSend.class.getName();
        String finderMethodName = "countByDateCreated";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateCreated };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend WHERE ");

                if (dateCreated == null) {
                    query.append("datecreated IS NULL");
                } else {
                    query.append("datecreated = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
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
        boolean finderClassNameCacheEnabled = PmlEdmWriteDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmWriteDocumentSend.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend");

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
                        "value.object.listener.com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend")));

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
