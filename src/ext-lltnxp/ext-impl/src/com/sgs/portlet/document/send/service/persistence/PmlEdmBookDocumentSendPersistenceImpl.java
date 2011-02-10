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

import com.sgs.portlet.document.send.NoSuchPmlEdmBookDocumentSendException;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.impl.PmlEdmBookDocumentSendImpl;
import com.sgs.portlet.document.send.model.impl.PmlEdmBookDocumentSendModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlEdmBookDocumentSendPersistenceImpl extends BasePersistenceImpl
    implements PmlEdmBookDocumentSendPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmBookDocumentSendPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmBookDocumentSend create(long bookDocumentSendId) {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = new PmlEdmBookDocumentSendImpl();

        pmlEdmBookDocumentSend.setNew(true);
        pmlEdmBookDocumentSend.setPrimaryKey(bookDocumentSendId);

        return pmlEdmBookDocumentSend;
    }

    public PmlEdmBookDocumentSend remove(long bookDocumentSendId)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmBookDocumentSend pmlEdmBookDocumentSend = (PmlEdmBookDocumentSend) session.get(PmlEdmBookDocumentSendImpl.class,
                    new Long(bookDocumentSendId));

            if (pmlEdmBookDocumentSend == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmBookDocumentSend exists with the primary key " +
                        bookDocumentSendId);
                }

                throw new NoSuchPmlEdmBookDocumentSendException(
                    "No PmlEdmBookDocumentSend exists with the primary key " +
                    bookDocumentSendId);
            }

            return remove(pmlEdmBookDocumentSend);
        } catch (NoSuchPmlEdmBookDocumentSendException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmBookDocumentSend remove(
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmBookDocumentSend);
            }
        }

        pmlEdmBookDocumentSend = removeImpl(pmlEdmBookDocumentSend);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmBookDocumentSend);
            }
        }

        return pmlEdmBookDocumentSend;
    }

    protected PmlEdmBookDocumentSend removeImpl(
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmBookDocumentSend);

            session.flush();

            return pmlEdmBookDocumentSend;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmBookDocumentSend.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmBookDocumentSend pmlEdmBookDocumentSend, boolean merge)</code>.
     */
    public PmlEdmBookDocumentSend update(
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmBookDocumentSend pmlEdmBookDocumentSend) method. Use update(PmlEdmBookDocumentSend pmlEdmBookDocumentSend, boolean merge) instead.");
        }

        return update(pmlEdmBookDocumentSend, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmBookDocumentSend the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmBookDocumentSend is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmBookDocumentSend update(
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmBookDocumentSend.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmBookDocumentSend);
                } else {
                    listener.onBeforeUpdate(pmlEdmBookDocumentSend);
                }
            }
        }

        pmlEdmBookDocumentSend = updateImpl(pmlEdmBookDocumentSend, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmBookDocumentSend);
                } else {
                    listener.onAfterUpdate(pmlEdmBookDocumentSend);
                }
            }
        }

        return pmlEdmBookDocumentSend;
    }

    public PmlEdmBookDocumentSend updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend pmlEdmBookDocumentSend,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmBookDocumentSend);
            } else {
                if (pmlEdmBookDocumentSend.isNew()) {
                    session.save(pmlEdmBookDocumentSend);
                }
            }

            session.flush();

            pmlEdmBookDocumentSend.setNew(false);

            return pmlEdmBookDocumentSend;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmBookDocumentSend.class.getName());
        }
    }

    public PmlEdmBookDocumentSend findByPrimaryKey(long bookDocumentSendId)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = fetchByPrimaryKey(bookDocumentSendId);

        if (pmlEdmBookDocumentSend == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmBookDocumentSend exists with the primary key " +
                    bookDocumentSendId);
            }

            throw new NoSuchPmlEdmBookDocumentSendException(
                "No PmlEdmBookDocumentSend exists with the primary key " +
                bookDocumentSendId);
        }

        return pmlEdmBookDocumentSend;
    }

    public PmlEdmBookDocumentSend fetchByPrimaryKey(long bookDocumentSendId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmBookDocumentSend) session.get(PmlEdmBookDocumentSendImpl.class,
                new Long(bookDocumentSendId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentSend> findByDateCreated(Date dateCreated)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

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

                List<PmlEdmBookDocumentSend> list = q.list();

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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public List<PmlEdmBookDocumentSend> findByDateCreated(Date dateCreated,
        int start, int end) throws SystemException {
        return findByDateCreated(dateCreated, start, end, null);
    }

    public List<PmlEdmBookDocumentSend> findByDateCreated(Date dateCreated,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

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

                List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public PmlEdmBookDocumentSend findByDateCreated_First(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        List<PmlEdmBookDocumentSend> list = findByDateCreated(dateCreated, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend findByDateCreated_Last(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        int count = countByDateCreated(dateCreated);

        List<PmlEdmBookDocumentSend> list = findByDateCreated(dateCreated,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend[] findByDateCreated_PrevAndNext(
        long bookDocumentSendId, Date dateCreated, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = findByPrimaryKey(bookDocumentSendId);

        int count = countByDateCreated(dateCreated);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

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
                    pmlEdmBookDocumentSend);

            PmlEdmBookDocumentSend[] array = new PmlEdmBookDocumentSendImpl[3];

            array[0] = (PmlEdmBookDocumentSend) objArray[0];
            array[1] = (PmlEdmBookDocumentSend) objArray[1];
            array[2] = (PmlEdmBookDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentSend> findByCurrentRecord(long currentRecord)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByCurrentRecord";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(currentRecord) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                query.append("currentrecord = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(currentRecord);

                List<PmlEdmBookDocumentSend> list = q.list();

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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public List<PmlEdmBookDocumentSend> findByCurrentRecord(
        long currentRecord, int start, int end) throws SystemException {
        return findByCurrentRecord(currentRecord, start, end, null);
    }

    public List<PmlEdmBookDocumentSend> findByCurrentRecord(
        long currentRecord, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByCurrentRecord";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(currentRecord),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                query.append("currentrecord = ?");

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

                qPos.add(currentRecord);

                List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public PmlEdmBookDocumentSend findByCurrentRecord_First(
        long currentRecord, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        List<PmlEdmBookDocumentSend> list = findByCurrentRecord(currentRecord,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("currentRecord=" + currentRecord);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend findByCurrentRecord_Last(long currentRecord,
        OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        int count = countByCurrentRecord(currentRecord);

        List<PmlEdmBookDocumentSend> list = findByCurrentRecord(currentRecord,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("currentRecord=" + currentRecord);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend[] findByCurrentRecord_PrevAndNext(
        long bookDocumentSendId, long currentRecord, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = findByPrimaryKey(bookDocumentSendId);

        int count = countByCurrentRecord(currentRecord);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

            query.append("currentrecord = ?");

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

            qPos.add(currentRecord);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentSend);

            PmlEdmBookDocumentSend[] array = new PmlEdmBookDocumentSendImpl[3];

            array[0] = (PmlEdmBookDocumentSend) objArray[0];
            array[1] = (PmlEdmBookDocumentSend) objArray[1];
            array[2] = (PmlEdmBookDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentSend> findByDepartmentsId(
        String departmentsId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByDepartmentsId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlEdmBookDocumentSend> list = q.list();

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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public List<PmlEdmBookDocumentSend> findByDepartmentsId(
        String departmentsId, int start, int end) throws SystemException {
        return findByDepartmentsId(departmentsId, start, end, null);
    }

    public List<PmlEdmBookDocumentSend> findByDepartmentsId(
        String departmentsId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByDepartmentsId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                departmentsId,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
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

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public PmlEdmBookDocumentSend findByDepartmentsId_First(
        String departmentsId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        List<PmlEdmBookDocumentSend> list = findByDepartmentsId(departmentsId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend findByDepartmentsId_Last(
        String departmentsId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        int count = countByDepartmentsId(departmentsId);

        List<PmlEdmBookDocumentSend> list = findByDepartmentsId(departmentsId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend[] findByDepartmentsId_PrevAndNext(
        long bookDocumentSendId, String departmentsId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = findByPrimaryKey(bookDocumentSendId);

        int count = countByDepartmentsId(departmentsId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

            if (departmentsId == null) {
                query.append("departmentsid LIKE null");
            } else {
                query.append("departmentsid LIKE ?");
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

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentSend);

            PmlEdmBookDocumentSend[] array = new PmlEdmBookDocumentSendImpl[3];

            array[0] = (PmlEdmBookDocumentSend) objArray[0];
            array[1] = (PmlEdmBookDocumentSend) objArray[1];
            array[2] = (PmlEdmBookDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentSend> findByDocumentRecordTypeId(
        int documentRecordTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByDocumentRecordTypeId";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(documentRecordTypeId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordTypeId);

                List<PmlEdmBookDocumentSend> list = q.list();

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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public List<PmlEdmBookDocumentSend> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end) throws SystemException {
        return findByDocumentRecordTypeId(documentRecordTypeId, start, end, null);
    }

    public List<PmlEdmBookDocumentSend> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByDocumentRecordTypeId";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(documentRecordTypeId),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                query.append("documentrecordtypeid = ?");

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

                qPos.add(documentRecordTypeId);

                List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public PmlEdmBookDocumentSend findByDocumentRecordTypeId_First(
        int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        List<PmlEdmBookDocumentSend> list = findByDocumentRecordTypeId(documentRecordTypeId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend findByDocumentRecordTypeId_Last(
        int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        int count = countByDocumentRecordTypeId(documentRecordTypeId);

        List<PmlEdmBookDocumentSend> list = findByDocumentRecordTypeId(documentRecordTypeId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend[] findByDocumentRecordTypeId_PrevAndNext(
        long bookDocumentSendId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = findByPrimaryKey(bookDocumentSendId);

        int count = countByDocumentRecordTypeId(documentRecordTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

            query.append("documentrecordtypeid = ?");

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

            qPos.add(documentRecordTypeId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentSend);

            PmlEdmBookDocumentSend[] array = new PmlEdmBookDocumentSendImpl[3];

            array[0] = (PmlEdmBookDocumentSend) objArray[0];
            array[1] = (PmlEdmBookDocumentSend) objArray[1];
            array[2] = (PmlEdmBookDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentSend> findByAgencyId(String agencyId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByAgencyId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { agencyId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (agencyId == null) {
                    query.append("agencyid LIKE null");
                } else {
                    query.append("agencyid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                List<PmlEdmBookDocumentSend> list = q.list();

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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public List<PmlEdmBookDocumentSend> findByAgencyId(String agencyId,
        int start, int end) throws SystemException {
        return findByAgencyId(agencyId, start, end, null);
    }

    public List<PmlEdmBookDocumentSend> findByAgencyId(String agencyId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByAgencyId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                agencyId,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (agencyId == null) {
                    query.append("agencyid LIKE null");
                } else {
                    query.append("agencyid LIKE ?");
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

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public PmlEdmBookDocumentSend findByAgencyId_First(String agencyId,
        OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        List<PmlEdmBookDocumentSend> list = findByAgencyId(agencyId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend findByAgencyId_Last(String agencyId,
        OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        int count = countByAgencyId(agencyId);

        List<PmlEdmBookDocumentSend> list = findByAgencyId(agencyId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend[] findByAgencyId_PrevAndNext(
        long bookDocumentSendId, String agencyId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = findByPrimaryKey(bookDocumentSendId);

        int count = countByAgencyId(agencyId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

            if (agencyId == null) {
                query.append("agencyid LIKE null");
            } else {
                query.append("agencyid LIKE ?");
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

            if (agencyId != null) {
                qPos.add(agencyId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentSend);

            PmlEdmBookDocumentSend[] array = new PmlEdmBookDocumentSendImpl[3];

            array[0] = (PmlEdmBookDocumentSend) objArray[0];
            array[1] = (PmlEdmBookDocumentSend) objArray[1];
            array[2] = (PmlEdmBookDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentSend> findByDepartDocYear(String yearInUse,
        String departmentsId, int documentRecordTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByDepartDocYear";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                yearInUse,
                
                departmentsId, new Integer(documentRecordTypeId)
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (yearInUse == null) {
                    query.append("yearinuse LIKE null");
                } else {
                    query.append("yearinuse LIKE ?");
                }

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" AND ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(documentRecordTypeId);

                List<PmlEdmBookDocumentSend> list = q.list();

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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public List<PmlEdmBookDocumentSend> findByDepartDocYear(String yearInUse,
        String departmentsId, int documentRecordTypeId, int start, int end)
        throws SystemException {
        return findByDepartDocYear(yearInUse, departmentsId,
            documentRecordTypeId, start, end, null);
    }

    public List<PmlEdmBookDocumentSend> findByDepartDocYear(String yearInUse,
        String departmentsId, int documentRecordTypeId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByDepartDocYear";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                yearInUse,
                
                departmentsId, new Integer(documentRecordTypeId),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (yearInUse == null) {
                    query.append("yearinuse LIKE null");
                } else {
                    query.append("yearinuse LIKE ?");
                }

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" AND ");

                query.append("documentrecordtypeid = ?");

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

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(documentRecordTypeId);

                List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public PmlEdmBookDocumentSend findByDepartDocYear_First(String yearInUse,
        String departmentsId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        List<PmlEdmBookDocumentSend> list = findByDepartDocYear(yearInUse,
                departmentsId, documentRecordTypeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend findByDepartDocYear_Last(String yearInUse,
        String departmentsId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        int count = countByDepartDocYear(yearInUse, departmentsId,
                documentRecordTypeId);

        List<PmlEdmBookDocumentSend> list = findByDepartDocYear(yearInUse,
                departmentsId, documentRecordTypeId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend[] findByDepartDocYear_PrevAndNext(
        long bookDocumentSendId, String yearInUse, String departmentsId,
        int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = findByPrimaryKey(bookDocumentSendId);

        int count = countByDepartDocYear(yearInUse, departmentsId,
                documentRecordTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

            if (yearInUse == null) {
                query.append("yearinuse LIKE null");
            } else {
                query.append("yearinuse LIKE ?");
            }

            query.append(" AND ");

            if (departmentsId == null) {
                query.append("departmentsid LIKE null");
            } else {
                query.append("departmentsid LIKE ?");
            }

            query.append(" AND ");

            query.append("documentrecordtypeid = ?");

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

            if (yearInUse != null) {
                qPos.add(yearInUse);
            }

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            qPos.add(documentRecordTypeId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentSend);

            PmlEdmBookDocumentSend[] array = new PmlEdmBookDocumentSendImpl[3];

            array[0] = (PmlEdmBookDocumentSend) objArray[0];
            array[1] = (PmlEdmBookDocumentSend) objArray[1];
            array[2] = (PmlEdmBookDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentSend> findByDepartDocAgency(String agencyId,
        String departmentsId, int documentRecordTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByDepartDocAgency";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                agencyId,
                
                departmentsId, new Integer(documentRecordTypeId)
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (agencyId == null) {
                    query.append("agencyid LIKE null");
                } else {
                    query.append("agencyid LIKE ?");
                }

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" AND ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(documentRecordTypeId);

                List<PmlEdmBookDocumentSend> list = q.list();

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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public List<PmlEdmBookDocumentSend> findByDepartDocAgency(String agencyId,
        String departmentsId, int documentRecordTypeId, int start, int end)
        throws SystemException {
        return findByDepartDocAgency(agencyId, departmentsId,
            documentRecordTypeId, start, end, null);
    }

    public List<PmlEdmBookDocumentSend> findByDepartDocAgency(String agencyId,
        String departmentsId, int documentRecordTypeId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByDepartDocAgency";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                agencyId,
                
                departmentsId, new Integer(documentRecordTypeId),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (agencyId == null) {
                    query.append("agencyid LIKE null");
                } else {
                    query.append("agencyid LIKE ?");
                }

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" AND ");

                query.append("documentrecordtypeid = ?");

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

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(documentRecordTypeId);

                List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public PmlEdmBookDocumentSend findByDepartDocAgency_First(String agencyId,
        String departmentsId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        List<PmlEdmBookDocumentSend> list = findByDepartDocAgency(agencyId,
                departmentsId, documentRecordTypeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend findByDepartDocAgency_Last(String agencyId,
        String departmentsId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        int count = countByDepartDocAgency(agencyId, departmentsId,
                documentRecordTypeId);

        List<PmlEdmBookDocumentSend> list = findByDepartDocAgency(agencyId,
                departmentsId, documentRecordTypeId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend[] findByDepartDocAgency_PrevAndNext(
        long bookDocumentSendId, String agencyId, String departmentsId,
        int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = findByPrimaryKey(bookDocumentSendId);

        int count = countByDepartDocAgency(agencyId, departmentsId,
                documentRecordTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

            if (agencyId == null) {
                query.append("agencyid LIKE null");
            } else {
                query.append("agencyid LIKE ?");
            }

            query.append(" AND ");

            if (departmentsId == null) {
                query.append("departmentsid LIKE null");
            } else {
                query.append("departmentsid LIKE ?");
            }

            query.append(" AND ");

            query.append("documentrecordtypeid = ?");

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

            if (agencyId != null) {
                qPos.add(agencyId);
            }

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            qPos.add(documentRecordTypeId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentSend);

            PmlEdmBookDocumentSend[] array = new PmlEdmBookDocumentSendImpl[3];

            array[0] = (PmlEdmBookDocumentSend) objArray[0];
            array[1] = (PmlEdmBookDocumentSend) objArray[1];
            array[2] = (PmlEdmBookDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentSend> findByAgencyId_YearInUse_DocumentRecordTypeId(
        String agencyId, String yearInUse, int documentRecordTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByAgencyId_YearInUse_DocumentRecordTypeId";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                agencyId,
                
                yearInUse, new Integer(documentRecordTypeId)
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (agencyId == null) {
                    query.append("agencyid IS NULL");
                } else {
                    query.append("agencyid = ?");
                }

                query.append(" AND ");

                if (yearInUse == null) {
                    query.append("yearinuse IS NULL");
                } else {
                    query.append("yearinuse = ?");
                }

                query.append(" AND ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                qPos.add(documentRecordTypeId);

                List<PmlEdmBookDocumentSend> list = q.list();

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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public List<PmlEdmBookDocumentSend> findByAgencyId_YearInUse_DocumentRecordTypeId(
        String agencyId, String yearInUse, int documentRecordTypeId, int start,
        int end) throws SystemException {
        return findByAgencyId_YearInUse_DocumentRecordTypeId(agencyId,
            yearInUse, documentRecordTypeId, start, end, null);
    }

    public List<PmlEdmBookDocumentSend> findByAgencyId_YearInUse_DocumentRecordTypeId(
        String agencyId, String yearInUse, int documentRecordTypeId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByAgencyId_YearInUse_DocumentRecordTypeId";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                agencyId,
                
                yearInUse, new Integer(documentRecordTypeId),
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (agencyId == null) {
                    query.append("agencyid IS NULL");
                } else {
                    query.append("agencyid = ?");
                }

                query.append(" AND ");

                if (yearInUse == null) {
                    query.append("yearinuse IS NULL");
                } else {
                    query.append("yearinuse = ?");
                }

                query.append(" AND ");

                query.append("documentrecordtypeid = ?");

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

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                qPos.add(documentRecordTypeId);

                List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public PmlEdmBookDocumentSend findByAgencyId_YearInUse_DocumentRecordTypeId_First(
        String agencyId, String yearInUse, int documentRecordTypeId,
        OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        List<PmlEdmBookDocumentSend> list = findByAgencyId_YearInUse_DocumentRecordTypeId(agencyId,
                yearInUse, documentRecordTypeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(", ");
            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend findByAgencyId_YearInUse_DocumentRecordTypeId_Last(
        String agencyId, String yearInUse, int documentRecordTypeId,
        OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        int count = countByAgencyId_YearInUse_DocumentRecordTypeId(agencyId,
                yearInUse, documentRecordTypeId);

        List<PmlEdmBookDocumentSend> list = findByAgencyId_YearInUse_DocumentRecordTypeId(agencyId,
                yearInUse, documentRecordTypeId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(", ");
            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend[] findByAgencyId_YearInUse_DocumentRecordTypeId_PrevAndNext(
        long bookDocumentSendId, String agencyId, String yearInUse,
        int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = findByPrimaryKey(bookDocumentSendId);

        int count = countByAgencyId_YearInUse_DocumentRecordTypeId(agencyId,
                yearInUse, documentRecordTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

            if (agencyId == null) {
                query.append("agencyid IS NULL");
            } else {
                query.append("agencyid = ?");
            }

            query.append(" AND ");

            if (yearInUse == null) {
                query.append("yearinuse IS NULL");
            } else {
                query.append("yearinuse = ?");
            }

            query.append(" AND ");

            query.append("documentrecordtypeid = ?");

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

            if (agencyId != null) {
                qPos.add(agencyId);
            }

            if (yearInUse != null) {
                qPos.add(yearInUse);
            }

            qPos.add(documentRecordTypeId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentSend);

            PmlEdmBookDocumentSend[] array = new PmlEdmBookDocumentSendImpl[3];

            array[0] = (PmlEdmBookDocumentSend) objArray[0];
            array[1] = (PmlEdmBookDocumentSend) objArray[1];
            array[2] = (PmlEdmBookDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmBookDocumentSend findByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, String departmentsId)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = fetchByDocumentRecordTypeId_DepartmentsId(documentRecordTypeId,
                departmentsId);

        if (pmlEdmBookDocumentSend == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        }

        return pmlEdmBookDocumentSend;
    }

    public PmlEdmBookDocumentSend fetchByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "fetchByDocumentRecordTypeId_DepartmentsId";
        String[] finderParams = new String[] {
                Integer.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Integer(documentRecordTypeId),
                
                departmentsId
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                query.append("documentrecordtypeid = ?");

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsid IS NULL");
                } else {
                    query.append("departmentsid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordTypeId);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlEdmBookDocumentSend> list = q.list();

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
            List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public PmlEdmBookDocumentSend findByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, String agencyId)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = fetchByDocumentRecordTypeId_AgencyId(documentRecordTypeId,
                agencyId);

        if (pmlEdmBookDocumentSend == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(", ");
            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        }

        return pmlEdmBookDocumentSend;
    }

    public PmlEdmBookDocumentSend fetchByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, String agencyId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "fetchByDocumentRecordTypeId_AgencyId";
        String[] finderParams = new String[] {
                Integer.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Integer(documentRecordTypeId),
                
                agencyId
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                query.append("documentrecordtypeid = ?");

                query.append(" AND ");

                if (agencyId == null) {
                    query.append("agencyid IS NULL");
                } else {
                    query.append("agencyid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordTypeId);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                List<PmlEdmBookDocumentSend> list = q.list();

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
            List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public List<PmlEdmBookDocumentSend> findByYearInUse_AgencyId(
        String yearInUse, String agencyId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByYearInUse_AgencyId";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { yearInUse, agencyId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (yearInUse == null) {
                    query.append("yearinuse IS NULL");
                } else {
                    query.append("yearinuse = ?");
                }

                query.append(" AND ");

                if (agencyId == null) {
                    query.append("agencyid IS NULL");
                } else {
                    query.append("agencyid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                List<PmlEdmBookDocumentSend> list = q.list();

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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public List<PmlEdmBookDocumentSend> findByYearInUse_AgencyId(
        String yearInUse, String agencyId, int start, int end)
        throws SystemException {
        return findByYearInUse_AgencyId(yearInUse, agencyId, start, end, null);
    }

    public List<PmlEdmBookDocumentSend> findByYearInUse_AgencyId(
        String yearInUse, String agencyId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByYearInUse_AgencyId";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                yearInUse,
                
                agencyId,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (yearInUse == null) {
                    query.append("yearinuse IS NULL");
                } else {
                    query.append("yearinuse = ?");
                }

                query.append(" AND ");

                if (agencyId == null) {
                    query.append("agencyid IS NULL");
                } else {
                    query.append("agencyid = ?");
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

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public PmlEdmBookDocumentSend findByYearInUse_AgencyId_First(
        String yearInUse, String agencyId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        List<PmlEdmBookDocumentSend> list = findByYearInUse_AgencyId(yearInUse,
                agencyId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend findByYearInUse_AgencyId_Last(
        String yearInUse, String agencyId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        int count = countByYearInUse_AgencyId(yearInUse, agencyId);

        List<PmlEdmBookDocumentSend> list = findByYearInUse_AgencyId(yearInUse,
                agencyId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend[] findByYearInUse_AgencyId_PrevAndNext(
        long bookDocumentSendId, String yearInUse, String agencyId,
        OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = findByPrimaryKey(bookDocumentSendId);

        int count = countByYearInUse_AgencyId(yearInUse, agencyId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

            if (yearInUse == null) {
                query.append("yearinuse IS NULL");
            } else {
                query.append("yearinuse = ?");
            }

            query.append(" AND ");

            if (agencyId == null) {
                query.append("agencyid IS NULL");
            } else {
                query.append("agencyid = ?");
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

            if (yearInUse != null) {
                qPos.add(yearInUse);
            }

            if (agencyId != null) {
                qPos.add(agencyId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentSend);

            PmlEdmBookDocumentSend[] array = new PmlEdmBookDocumentSendImpl[3];

            array[0] = (PmlEdmBookDocumentSend) objArray[0];
            array[1] = (PmlEdmBookDocumentSend) objArray[1];
            array[2] = (PmlEdmBookDocumentSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmBookDocumentSend> findByYearInUse_DepartmentsId(
        String yearInUse, String departmentsId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByYearInUse_DepartmentsId";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { yearInUse, departmentsId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (yearInUse == null) {
                    query.append("yearinuse IS NULL");
                } else {
                    query.append("yearinuse = ?");
                }

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsid IS NULL");
                } else {
                    query.append("departmentsid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("bookdocumentsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlEdmBookDocumentSend> list = q.list();

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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public List<PmlEdmBookDocumentSend> findByYearInUse_DepartmentsId(
        String yearInUse, String departmentsId, int start, int end)
        throws SystemException {
        return findByYearInUse_DepartmentsId(yearInUse, departmentsId, start,
            end, null);
    }

    public List<PmlEdmBookDocumentSend> findByYearInUse_DepartmentsId(
        String yearInUse, String departmentsId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "findByYearInUse_DepartmentsId";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                yearInUse,
                
                departmentsId,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (yearInUse == null) {
                    query.append("yearinuse IS NULL");
                } else {
                    query.append("yearinuse = ?");
                }

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsid IS NULL");
                } else {
                    query.append("departmentsid = ?");
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

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public PmlEdmBookDocumentSend findByYearInUse_DepartmentsId_First(
        String yearInUse, String departmentsId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        List<PmlEdmBookDocumentSend> list = findByYearInUse_DepartmentsId(yearInUse,
                departmentsId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend findByYearInUse_DepartmentsId_Last(
        String yearInUse, String departmentsId, OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        int count = countByYearInUse_DepartmentsId(yearInUse, departmentsId);

        List<PmlEdmBookDocumentSend> list = findByYearInUse_DepartmentsId(yearInUse,
                departmentsId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmBookDocumentSend exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmBookDocumentSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmBookDocumentSend[] findByYearInUse_DepartmentsId_PrevAndNext(
        long bookDocumentSendId, String yearInUse, String departmentsId,
        OrderByComparator obc)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = findByPrimaryKey(bookDocumentSendId);

        int count = countByYearInUse_DepartmentsId(yearInUse, departmentsId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

            if (yearInUse == null) {
                query.append("yearinuse IS NULL");
            } else {
                query.append("yearinuse = ?");
            }

            query.append(" AND ");

            if (departmentsId == null) {
                query.append("departmentsid IS NULL");
            } else {
                query.append("departmentsid = ?");
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

            if (yearInUse != null) {
                qPos.add(yearInUse);
            }

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmBookDocumentSend);

            PmlEdmBookDocumentSend[] array = new PmlEdmBookDocumentSendImpl[3];

            array[0] = (PmlEdmBookDocumentSend) objArray[0];
            array[1] = (PmlEdmBookDocumentSend) objArray[1];
            array[2] = (PmlEdmBookDocumentSend) objArray[2];

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

    public List<PmlEdmBookDocumentSend> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmBookDocumentSend> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmBookDocumentSend> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("bookdocumentsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmBookDocumentSend> list = (List<PmlEdmBookDocumentSend>) QueryUtil.list(q,
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
            return (List<PmlEdmBookDocumentSend>) result;
        }
    }

    public void removeByDateCreated(Date dateCreated) throws SystemException {
        for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : findByDateCreated(
                dateCreated)) {
            remove(pmlEdmBookDocumentSend);
        }
    }

    public void removeByCurrentRecord(long currentRecord)
        throws SystemException {
        for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : findByCurrentRecord(
                currentRecord)) {
            remove(pmlEdmBookDocumentSend);
        }
    }

    public void removeByDepartmentsId(String departmentsId)
        throws SystemException {
        for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : findByDepartmentsId(
                departmentsId)) {
            remove(pmlEdmBookDocumentSend);
        }
    }

    public void removeByDocumentRecordTypeId(int documentRecordTypeId)
        throws SystemException {
        for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : findByDocumentRecordTypeId(
                documentRecordTypeId)) {
            remove(pmlEdmBookDocumentSend);
        }
    }

    public void removeByAgencyId(String agencyId) throws SystemException {
        for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : findByAgencyId(
                agencyId)) {
            remove(pmlEdmBookDocumentSend);
        }
    }

    public void removeByDepartDocYear(String yearInUse, String departmentsId,
        int documentRecordTypeId) throws SystemException {
        for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : findByDepartDocYear(
                yearInUse, departmentsId, documentRecordTypeId)) {
            remove(pmlEdmBookDocumentSend);
        }
    }

    public void removeByDepartDocAgency(String agencyId, String departmentsId,
        int documentRecordTypeId) throws SystemException {
        for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : findByDepartDocAgency(
                agencyId, departmentsId, documentRecordTypeId)) {
            remove(pmlEdmBookDocumentSend);
        }
    }

    public void removeByAgencyId_YearInUse_DocumentRecordTypeId(
        String agencyId, String yearInUse, int documentRecordTypeId)
        throws SystemException {
        for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : findByAgencyId_YearInUse_DocumentRecordTypeId(
                agencyId, yearInUse, documentRecordTypeId)) {
            remove(pmlEdmBookDocumentSend);
        }
    }

    public void removeByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, String departmentsId)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = findByDocumentRecordTypeId_DepartmentsId(documentRecordTypeId,
                departmentsId);

        remove(pmlEdmBookDocumentSend);
    }

    public void removeByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, String agencyId)
        throws NoSuchPmlEdmBookDocumentSendException, SystemException {
        PmlEdmBookDocumentSend pmlEdmBookDocumentSend = findByDocumentRecordTypeId_AgencyId(documentRecordTypeId,
                agencyId);

        remove(pmlEdmBookDocumentSend);
    }

    public void removeByYearInUse_AgencyId(String yearInUse, String agencyId)
        throws SystemException {
        for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : findByYearInUse_AgencyId(
                yearInUse, agencyId)) {
            remove(pmlEdmBookDocumentSend);
        }
    }

    public void removeByYearInUse_DepartmentsId(String yearInUse,
        String departmentsId) throws SystemException {
        for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : findByYearInUse_DepartmentsId(
                yearInUse, departmentsId)) {
            remove(pmlEdmBookDocumentSend);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmBookDocumentSend pmlEdmBookDocumentSend : findAll()) {
            remove(pmlEdmBookDocumentSend);
        }
    }

    public int countByDateCreated(Date dateCreated) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

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

    public int countByCurrentRecord(long currentRecord)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "countByCurrentRecord";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(currentRecord) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                query.append("currentrecord = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(currentRecord);

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

    public int countByDepartmentsId(String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "countByDepartmentsId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { departmentsId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
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

    public int countByDocumentRecordTypeId(int documentRecordTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "countByDocumentRecordTypeId";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(documentRecordTypeId) };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordTypeId);

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

    public int countByAgencyId(String agencyId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "countByAgencyId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { agencyId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (agencyId == null) {
                    query.append("agencyid LIKE null");
                } else {
                    query.append("agencyid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
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

    public int countByDepartDocYear(String yearInUse, String departmentsId,
        int documentRecordTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "countByDepartDocYear";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                yearInUse,
                
                departmentsId, new Integer(documentRecordTypeId)
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

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (yearInUse == null) {
                    query.append("yearinuse LIKE null");
                } else {
                    query.append("yearinuse LIKE ?");
                }

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" AND ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(documentRecordTypeId);

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

    public int countByDepartDocAgency(String agencyId, String departmentsId,
        int documentRecordTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "countByDepartDocAgency";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                agencyId,
                
                departmentsId, new Integer(documentRecordTypeId)
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

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (agencyId == null) {
                    query.append("agencyid LIKE null");
                } else {
                    query.append("agencyid LIKE ?");
                }

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" AND ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(documentRecordTypeId);

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

    public int countByAgencyId_YearInUse_DocumentRecordTypeId(String agencyId,
        String yearInUse, int documentRecordTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "countByAgencyId_YearInUse_DocumentRecordTypeId";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                agencyId,
                
                yearInUse, new Integer(documentRecordTypeId)
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

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (agencyId == null) {
                    query.append("agencyid IS NULL");
                } else {
                    query.append("agencyid = ?");
                }

                query.append(" AND ");

                if (yearInUse == null) {
                    query.append("yearinuse IS NULL");
                } else {
                    query.append("yearinuse = ?");
                }

                query.append(" AND ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                qPos.add(documentRecordTypeId);

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

    public int countByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "countByDocumentRecordTypeId_DepartmentsId";
        String[] finderParams = new String[] {
                Integer.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Integer(documentRecordTypeId),
                
                departmentsId
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

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                query.append("documentrecordtypeid = ?");

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsid IS NULL");
                } else {
                    query.append("departmentsid = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordTypeId);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
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

    public int countByDocumentRecordTypeId_AgencyId(int documentRecordTypeId,
        String agencyId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "countByDocumentRecordTypeId_AgencyId";
        String[] finderParams = new String[] {
                Integer.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Integer(documentRecordTypeId),
                
                agencyId
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

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                query.append("documentrecordtypeid = ?");

                query.append(" AND ");

                if (agencyId == null) {
                    query.append("agencyid IS NULL");
                } else {
                    query.append("agencyid = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordTypeId);

                if (agencyId != null) {
                    qPos.add(agencyId);
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

    public int countByYearInUse_AgencyId(String yearInUse, String agencyId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "countByYearInUse_AgencyId";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { yearInUse, agencyId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (yearInUse == null) {
                    query.append("yearinuse IS NULL");
                } else {
                    query.append("yearinuse = ?");
                }

                query.append(" AND ");

                if (agencyId == null) {
                    query.append("agencyid IS NULL");
                } else {
                    query.append("agencyid = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                if (agencyId != null) {
                    qPos.add(agencyId);
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

    public int countByYearInUse_DepartmentsId(String yearInUse,
        String departmentsId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
        String finderMethodName = "countByYearInUse_DepartmentsId";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { yearInUse, departmentsId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend WHERE ");

                if (yearInUse == null) {
                    query.append("yearinuse IS NULL");
                } else {
                    query.append("yearinuse = ?");
                }

                query.append(" AND ");

                if (departmentsId == null) {
                    query.append("departmentsid IS NULL");
                } else {
                    query.append("departmentsid = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
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
        boolean finderClassNameCacheEnabled = PmlEdmBookDocumentSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmBookDocumentSend.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend");

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
                        "value.object.listener.com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend")));

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
