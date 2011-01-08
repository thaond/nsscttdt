package com.sgs.portlet.document.receipt.service.persistence;

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

import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordToException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordToImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordToModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlEdmDocumentRecordToPersistenceImpl extends BasePersistenceImpl
    implements PmlEdmDocumentRecordToPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmDocumentRecordToPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmDocumentRecordTo create(long documentRecordToId) {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = new PmlEdmDocumentRecordToImpl();

        pmlEdmDocumentRecordTo.setNew(true);
        pmlEdmDocumentRecordTo.setPrimaryKey(documentRecordToId);

        return pmlEdmDocumentRecordTo;
    }

    public PmlEdmDocumentRecordTo remove(long documentRecordToId)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = (PmlEdmDocumentRecordTo) session.get(PmlEdmDocumentRecordToImpl.class,
                    new Long(documentRecordToId));

            if (pmlEdmDocumentRecordTo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmDocumentRecordTo exists with the primary key " +
                        documentRecordToId);
                }

                throw new NoSuchPmlEdmDocumentRecordToException(
                    "No PmlEdmDocumentRecordTo exists with the primary key " +
                    documentRecordToId);
            }

            return remove(pmlEdmDocumentRecordTo);
        } catch (NoSuchPmlEdmDocumentRecordToException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentRecordTo remove(
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmDocumentRecordTo);
            }
        }

        pmlEdmDocumentRecordTo = removeImpl(pmlEdmDocumentRecordTo);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmDocumentRecordTo);
            }
        }

        return pmlEdmDocumentRecordTo;
    }

    protected PmlEdmDocumentRecordTo removeImpl(
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmDocumentRecordTo);

            session.flush();

            return pmlEdmDocumentRecordTo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentRecordTo.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo, boolean merge)</code>.
     */
    public PmlEdmDocumentRecordTo update(
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo) method. Use update(PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo, boolean merge) instead.");
        }

        return update(pmlEdmDocumentRecordTo, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentRecordTo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentRecordTo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmDocumentRecordTo update(
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmDocumentRecordTo.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmDocumentRecordTo);
                } else {
                    listener.onBeforeUpdate(pmlEdmDocumentRecordTo);
                }
            }
        }

        pmlEdmDocumentRecordTo = updateImpl(pmlEdmDocumentRecordTo, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmDocumentRecordTo);
                } else {
                    listener.onAfterUpdate(pmlEdmDocumentRecordTo);
                }
            }
        }

        return pmlEdmDocumentRecordTo;
    }

    public PmlEdmDocumentRecordTo updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmDocumentRecordTo);
            } else {
                if (pmlEdmDocumentRecordTo.isNew()) {
                    session.save(pmlEdmDocumentRecordTo);
                }
            }

            session.flush();

            pmlEdmDocumentRecordTo.setNew(false);

            return pmlEdmDocumentRecordTo;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentRecordTo.class.getName());
        }
    }

    public PmlEdmDocumentRecordTo findByPrimaryKey(long documentRecordToId)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = fetchByPrimaryKey(documentRecordToId);

        if (pmlEdmDocumentRecordTo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmDocumentRecordTo exists with the primary key " +
                    documentRecordToId);
            }

            throw new NoSuchPmlEdmDocumentRecordToException(
                "No PmlEdmDocumentRecordTo exists with the primary key " +
                documentRecordToId);
        }

        return pmlEdmDocumentRecordTo;
    }

    public PmlEdmDocumentRecordTo fetchByPrimaryKey(long documentRecordToId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmDocumentRecordTo) session.get(PmlEdmDocumentRecordToImpl.class,
                new Long(documentRecordToId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordTo> findByDateCreate(Date dateCreate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
        String finderMethodName = "findByDateCreate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateCreate };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                if (dateCreate == null) {
                    query.append("datecreate IS NULL");
                } else {
                    query.append("datecreate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreate != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreate));
                }

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmDocumentRecordTo> findByDateCreate(Date dateCreate,
        int start, int end) throws SystemException {
        return findByDateCreate(dateCreate, start, end, null);
    }

    public List<PmlEdmDocumentRecordTo> findByDateCreate(Date dateCreate,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
        String finderMethodName = "findByDateCreate";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                dateCreate,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                if (dateCreate == null) {
                    query.append("datecreate IS NULL");
                } else {
                    query.append("datecreate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreate != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreate));
                }

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public PmlEdmDocumentRecordTo findByDateCreate_First(Date dateCreate,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        List<PmlEdmDocumentRecordTo> list = findByDateCreate(dateCreate, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("dateCreate=" + dateCreate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo findByDateCreate_Last(Date dateCreate,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        int count = countByDateCreate(dateCreate);

        List<PmlEdmDocumentRecordTo> list = findByDateCreate(dateCreate,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("dateCreate=" + dateCreate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo[] findByDateCreate_PrevAndNext(
        long documentRecordToId, Date dateCreate, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByPrimaryKey(documentRecordToId);

        int count = countByDateCreate(dateCreate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

            if (dateCreate == null) {
                query.append("datecreate IS NULL");
            } else {
                query.append("datecreate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateCreate != null) {
                qPos.add(CalendarUtil.getTimestamp(dateCreate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRecordTo);

            PmlEdmDocumentRecordTo[] array = new PmlEdmDocumentRecordToImpl[3];

            array[0] = (PmlEdmDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordTo> findByCurrentRecord(long currentRecord)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                query.append("currentrecord = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(currentRecord);

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmDocumentRecordTo> findByCurrentRecord(
        long currentRecord, int start, int end) throws SystemException {
        return findByCurrentRecord(currentRecord, start, end, null);
    }

    public List<PmlEdmDocumentRecordTo> findByCurrentRecord(
        long currentRecord, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                query.append("currentrecord = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(currentRecord);

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public PmlEdmDocumentRecordTo findByCurrentRecord_First(
        long currentRecord, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        List<PmlEdmDocumentRecordTo> list = findByCurrentRecord(currentRecord,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("currentRecord=" + currentRecord);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo findByCurrentRecord_Last(long currentRecord,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        int count = countByCurrentRecord(currentRecord);

        List<PmlEdmDocumentRecordTo> list = findByCurrentRecord(currentRecord,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("currentRecord=" + currentRecord);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo[] findByCurrentRecord_PrevAndNext(
        long documentRecordToId, long currentRecord, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByPrimaryKey(documentRecordToId);

        int count = countByCurrentRecord(currentRecord);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

            query.append("currentrecord = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(currentRecord);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRecordTo);

            PmlEdmDocumentRecordTo[] array = new PmlEdmDocumentRecordToImpl[3];

            array[0] = (PmlEdmDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordTo> findByDepartmentsId(
        String departmentsId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmDocumentRecordTo> findByDepartmentsId(
        String departmentsId, int start, int end) throws SystemException {
        return findByDepartmentsId(departmentsId, start, end, null);
    }

    public List<PmlEdmDocumentRecordTo> findByDepartmentsId(
        String departmentsId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public PmlEdmDocumentRecordTo findByDepartmentsId_First(
        String departmentsId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        List<PmlEdmDocumentRecordTo> list = findByDepartmentsId(departmentsId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo findByDepartmentsId_Last(
        String departmentsId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        int count = countByDepartmentsId(departmentsId);

        List<PmlEdmDocumentRecordTo> list = findByDepartmentsId(departmentsId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo[] findByDepartmentsId_PrevAndNext(
        long documentRecordToId, String departmentsId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByPrimaryKey(documentRecordToId);

        int count = countByDepartmentsId(departmentsId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRecordTo);

            PmlEdmDocumentRecordTo[] array = new PmlEdmDocumentRecordToImpl[3];

            array[0] = (PmlEdmDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordTo> findByDocumentRecordTypeId(
        int documentRecordTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordTypeId);

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmDocumentRecordTo> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end) throws SystemException {
        return findByDocumentRecordTypeId(documentRecordTypeId, start, end, null);
    }

    public List<PmlEdmDocumentRecordTo> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordTypeId);

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public PmlEdmDocumentRecordTo findByDocumentRecordTypeId_First(
        int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        List<PmlEdmDocumentRecordTo> list = findByDocumentRecordTypeId(documentRecordTypeId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo findByDocumentRecordTypeId_Last(
        int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        int count = countByDocumentRecordTypeId(documentRecordTypeId);

        List<PmlEdmDocumentRecordTo> list = findByDocumentRecordTypeId(documentRecordTypeId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo[] findByDocumentRecordTypeId_PrevAndNext(
        long documentRecordToId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByPrimaryKey(documentRecordToId);

        int count = countByDocumentRecordTypeId(documentRecordTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

            query.append("documentrecordtypeid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentRecordTypeId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRecordTo);

            PmlEdmDocumentRecordTo[] array = new PmlEdmDocumentRecordToImpl[3];

            array[0] = (PmlEdmDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordTo> findByYearInUse(String yearInUse)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
        String finderMethodName = "findByYearInUse";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { yearInUse };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                if (yearInUse == null) {
                    query.append("yearinuse LIKE null");
                } else {
                    query.append("yearinuse LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmDocumentRecordTo> findByYearInUse(String yearInUse,
        int start, int end) throws SystemException {
        return findByYearInUse(yearInUse, start, end, null);
    }

    public List<PmlEdmDocumentRecordTo> findByYearInUse(String yearInUse,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
        String finderMethodName = "findByYearInUse";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                yearInUse,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                if (yearInUse == null) {
                    query.append("yearinuse LIKE null");
                } else {
                    query.append("yearinuse LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public PmlEdmDocumentRecordTo findByYearInUse_First(String yearInUse,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        List<PmlEdmDocumentRecordTo> list = findByYearInUse(yearInUse, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo findByYearInUse_Last(String yearInUse,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        int count = countByYearInUse(yearInUse);

        List<PmlEdmDocumentRecordTo> list = findByYearInUse(yearInUse,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo[] findByYearInUse_PrevAndNext(
        long documentRecordToId, String yearInUse, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByPrimaryKey(documentRecordToId);

        int count = countByYearInUse(yearInUse);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

            if (yearInUse == null) {
                query.append("yearinuse LIKE null");
            } else {
                query.append("yearinuse LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (yearInUse != null) {
                qPos.add(yearInUse);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRecordTo);

            PmlEdmDocumentRecordTo[] array = new PmlEdmDocumentRecordToImpl[3];

            array[0] = (PmlEdmDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordTo> findByAgencyId(String agencyId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmDocumentRecordTo> findByAgencyId(String agencyId,
        int start, int end) throws SystemException {
        return findByAgencyId(agencyId, start, end, null);
    }

    public List<PmlEdmDocumentRecordTo> findByAgencyId(String agencyId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public PmlEdmDocumentRecordTo findByAgencyId_First(String agencyId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        List<PmlEdmDocumentRecordTo> list = findByAgencyId(agencyId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo findByAgencyId_Last(String agencyId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        int count = countByAgencyId(agencyId);

        List<PmlEdmDocumentRecordTo> list = findByAgencyId(agencyId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo[] findByAgencyId_PrevAndNext(
        long documentRecordToId, String agencyId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByPrimaryKey(documentRecordToId);

        int count = countByAgencyId(agencyId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (agencyId != null) {
                qPos.add(agencyId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRecordTo);

            PmlEdmDocumentRecordTo[] array = new PmlEdmDocumentRecordToImpl[3];

            array[0] = (PmlEdmDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordTo> findByDepartDocYear(String yearInUse,
        String departmentsId, int documentRecordTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmDocumentRecordTo> findByDepartDocYear(String yearInUse,
        String departmentsId, int documentRecordTypeId, int start, int end)
        throws SystemException {
        return findByDepartDocYear(yearInUse, departmentsId,
            documentRecordTypeId, start, end, null);
    }

    public List<PmlEdmDocumentRecordTo> findByDepartDocYear(String yearInUse,
        String departmentsId, int documentRecordTypeId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(documentRecordTypeId);

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public PmlEdmDocumentRecordTo findByDepartDocYear_First(String yearInUse,
        String departmentsId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        List<PmlEdmDocumentRecordTo> list = findByDepartDocYear(yearInUse,
                departmentsId, documentRecordTypeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo findByDepartDocYear_Last(String yearInUse,
        String departmentsId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        int count = countByDepartDocYear(yearInUse, departmentsId,
                documentRecordTypeId);

        List<PmlEdmDocumentRecordTo> list = findByDepartDocYear(yearInUse,
                departmentsId, documentRecordTypeId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo[] findByDepartDocYear_PrevAndNext(
        long documentRecordToId, String yearInUse, String departmentsId,
        int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByPrimaryKey(documentRecordToId);

        int count = countByDepartDocYear(yearInUse, departmentsId,
                documentRecordTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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
                    pmlEdmDocumentRecordTo);

            PmlEdmDocumentRecordTo[] array = new PmlEdmDocumentRecordToImpl[3];

            array[0] = (PmlEdmDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordTo> findByDepartDocAgency(String agencyId,
        String departmentsId, int documentRecordTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmDocumentRecordTo> findByDepartDocAgency(String agencyId,
        String departmentsId, int documentRecordTypeId, int start, int end)
        throws SystemException {
        return findByDepartDocAgency(agencyId, departmentsId,
            documentRecordTypeId, start, end, null);
    }

    public List<PmlEdmDocumentRecordTo> findByDepartDocAgency(String agencyId,
        String departmentsId, int documentRecordTypeId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                qPos.add(documentRecordTypeId);

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public PmlEdmDocumentRecordTo findByDepartDocAgency_First(String agencyId,
        String departmentsId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        List<PmlEdmDocumentRecordTo> list = findByDepartDocAgency(agencyId,
                departmentsId, documentRecordTypeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo findByDepartDocAgency_Last(String agencyId,
        String departmentsId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        int count = countByDepartDocAgency(agencyId, departmentsId,
                documentRecordTypeId);

        List<PmlEdmDocumentRecordTo> list = findByDepartDocAgency(agencyId,
                departmentsId, documentRecordTypeId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo[] findByDepartDocAgency_PrevAndNext(
        long documentRecordToId, String agencyId, String departmentsId,
        int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByPrimaryKey(documentRecordToId);

        int count = countByDepartDocAgency(agencyId, departmentsId,
                documentRecordTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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
                    pmlEdmDocumentRecordTo);

            PmlEdmDocumentRecordTo[] array = new PmlEdmDocumentRecordToImpl[3];

            array[0] = (PmlEdmDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordTo> findByAgencyId_Year_DocumentRecordTo(
        String agencyId, String yearInUse, int documentRecordTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
        String finderMethodName = "findByAgencyId_Year_DocumentRecordTo";
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmDocumentRecordTo> findByAgencyId_Year_DocumentRecordTo(
        String agencyId, String yearInUse, int documentRecordTypeId, int start,
        int end) throws SystemException {
        return findByAgencyId_Year_DocumentRecordTo(agencyId, yearInUse,
            documentRecordTypeId, start, end, null);
    }

    public List<PmlEdmDocumentRecordTo> findByAgencyId_Year_DocumentRecordTo(
        String agencyId, String yearInUse, int documentRecordTypeId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
        String finderMethodName = "findByAgencyId_Year_DocumentRecordTo";
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                qPos.add(documentRecordTypeId);

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public PmlEdmDocumentRecordTo findByAgencyId_Year_DocumentRecordTo_First(
        String agencyId, String yearInUse, int documentRecordTypeId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        List<PmlEdmDocumentRecordTo> list = findByAgencyId_Year_DocumentRecordTo(agencyId,
                yearInUse, documentRecordTypeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(", ");
            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo findByAgencyId_Year_DocumentRecordTo_Last(
        String agencyId, String yearInUse, int documentRecordTypeId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        int count = countByAgencyId_Year_DocumentRecordTo(agencyId, yearInUse,
                documentRecordTypeId);

        List<PmlEdmDocumentRecordTo> list = findByAgencyId_Year_DocumentRecordTo(agencyId,
                yearInUse, documentRecordTypeId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(", ");
            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo[] findByAgencyId_Year_DocumentRecordTo_PrevAndNext(
        long documentRecordToId, String agencyId, String yearInUse,
        int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByPrimaryKey(documentRecordToId);

        int count = countByAgencyId_Year_DocumentRecordTo(agencyId, yearInUse,
                documentRecordTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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
                    pmlEdmDocumentRecordTo);

            PmlEdmDocumentRecordTo[] array = new PmlEdmDocumentRecordToImpl[3];

            array[0] = (PmlEdmDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordTo> findByAgency_DocumentType(
        String agencyId, int documentRecordTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
        String finderMethodName = "findByAgency_DocumentType";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                agencyId, new Integer(documentRecordTypeId)
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                if (agencyId == null) {
                    query.append("agencyid IS NULL");
                } else {
                    query.append("agencyid = ?");
                }

                query.append(" AND ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                qPos.add(documentRecordTypeId);

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmDocumentRecordTo> findByAgency_DocumentType(
        String agencyId, int documentRecordTypeId, int start, int end)
        throws SystemException {
        return findByAgency_DocumentType(agencyId, documentRecordTypeId, start,
            end, null);
    }

    public List<PmlEdmDocumentRecordTo> findByAgency_DocumentType(
        String agencyId, int documentRecordTypeId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
        String finderMethodName = "findByAgency_DocumentType";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                agencyId, new Integer(documentRecordTypeId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                if (agencyId == null) {
                    query.append("agencyid IS NULL");
                } else {
                    query.append("agencyid = ?");
                }

                query.append(" AND ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                qPos.add(documentRecordTypeId);

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public PmlEdmDocumentRecordTo findByAgency_DocumentType_First(
        String agencyId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        List<PmlEdmDocumentRecordTo> list = findByAgency_DocumentType(agencyId,
                documentRecordTypeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo findByAgency_DocumentType_Last(
        String agencyId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        int count = countByAgency_DocumentType(agencyId, documentRecordTypeId);

        List<PmlEdmDocumentRecordTo> list = findByAgency_DocumentType(agencyId,
                documentRecordTypeId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("agencyId=" + agencyId);

            msg.append(", ");
            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo[] findByAgency_DocumentType_PrevAndNext(
        long documentRecordToId, String agencyId, int documentRecordTypeId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByPrimaryKey(documentRecordToId);

        int count = countByAgency_DocumentType(agencyId, documentRecordTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

            if (agencyId == null) {
                query.append("agencyid IS NULL");
            } else {
                query.append("agencyid = ?");
            }

            query.append(" AND ");

            query.append("documentrecordtypeid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (agencyId != null) {
                qPos.add(agencyId);
            }

            qPos.add(documentRecordTypeId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRecordTo);

            PmlEdmDocumentRecordTo[] array = new PmlEdmDocumentRecordToImpl[3];

            array[0] = (PmlEdmDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentRecordTo findByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, String departmentsId)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = fetchByDocumentRecordTypeId_DepartmentsId(documentRecordTypeId,
                departmentsId);

        if (pmlEdmDocumentRecordTo == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        }

        return pmlEdmDocumentRecordTo;
    }

    public PmlEdmDocumentRecordTo fetchByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public PmlEdmDocumentRecordTo findByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, String agencyId)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = fetchByDocumentRecordTypeId_AgencyId(documentRecordTypeId,
                agencyId);

        if (pmlEdmDocumentRecordTo == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(", ");
            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        }

        return pmlEdmDocumentRecordTo;
    }

    public PmlEdmDocumentRecordTo fetchByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, String agencyId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public List<PmlEdmDocumentRecordTo> findByYearInUse_AgencyId(
        String yearInUse, String agencyId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmDocumentRecordTo> findByYearInUse_AgencyId(
        String yearInUse, String agencyId, int start, int end)
        throws SystemException {
        return findByYearInUse_AgencyId(yearInUse, agencyId, start, end, null);
    }

    public List<PmlEdmDocumentRecordTo> findByYearInUse_AgencyId(
        String yearInUse, String agencyId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                if (agencyId != null) {
                    qPos.add(agencyId);
                }

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public PmlEdmDocumentRecordTo findByYearInUse_AgencyId_First(
        String yearInUse, String agencyId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        List<PmlEdmDocumentRecordTo> list = findByYearInUse_AgencyId(yearInUse,
                agencyId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo findByYearInUse_AgencyId_Last(
        String yearInUse, String agencyId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        int count = countByYearInUse_AgencyId(yearInUse, agencyId);

        List<PmlEdmDocumentRecordTo> list = findByYearInUse_AgencyId(yearInUse,
                agencyId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("agencyId=" + agencyId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo[] findByYearInUse_AgencyId_PrevAndNext(
        long documentRecordToId, String yearInUse, String agencyId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByPrimaryKey(documentRecordToId);

        int count = countByYearInUse_AgencyId(yearInUse, agencyId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (yearInUse != null) {
                qPos.add(yearInUse);
            }

            if (agencyId != null) {
                qPos.add(agencyId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRecordTo);

            PmlEdmDocumentRecordTo[] array = new PmlEdmDocumentRecordToImpl[3];

            array[0] = (PmlEdmDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmDocumentRecordTo) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordTo> findByYearInUse_DepartmentsId(
        String yearInUse, String departmentsId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                List<PmlEdmDocumentRecordTo> list = q.list();

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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public List<PmlEdmDocumentRecordTo> findByYearInUse_DepartmentsId(
        String yearInUse, String departmentsId, int start, int end)
        throws SystemException {
        return findByYearInUse_DepartmentsId(yearInUse, departmentsId, start,
            end, null);
    }

    public List<PmlEdmDocumentRecordTo> findByYearInUse_DepartmentsId(
        String yearInUse, String departmentsId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (yearInUse != null) {
                    qPos.add(yearInUse);
                }

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public PmlEdmDocumentRecordTo findByYearInUse_DepartmentsId_First(
        String yearInUse, String departmentsId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        List<PmlEdmDocumentRecordTo> list = findByYearInUse_DepartmentsId(yearInUse,
                departmentsId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo findByYearInUse_DepartmentsId_Last(
        String yearInUse, String departmentsId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        int count = countByYearInUse_DepartmentsId(yearInUse, departmentsId);

        List<PmlEdmDocumentRecordTo> list = findByYearInUse_DepartmentsId(yearInUse,
                departmentsId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordTo exists with the key {");

            msg.append("yearInUse=" + yearInUse);

            msg.append(", ");
            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordToException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordTo[] findByYearInUse_DepartmentsId_PrevAndNext(
        long documentRecordToId, String yearInUse, String departmentsId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByPrimaryKey(documentRecordToId);

        int count = countByYearInUse_DepartmentsId(yearInUse, departmentsId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (yearInUse != null) {
                qPos.add(yearInUse);
            }

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRecordTo);

            PmlEdmDocumentRecordTo[] array = new PmlEdmDocumentRecordToImpl[3];

            array[0] = (PmlEdmDocumentRecordTo) objArray[0];
            array[1] = (PmlEdmDocumentRecordTo) objArray[1];
            array[2] = (PmlEdmDocumentRecordTo) objArray[2];

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

    public List<PmlEdmDocumentRecordTo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmDocumentRecordTo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmDocumentRecordTo> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmDocumentRecordTo> list = (List<PmlEdmDocumentRecordTo>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordTo>) result;
        }
    }

    public void removeByDateCreate(Date dateCreate) throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findByDateCreate(
                dateCreate)) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public void removeByCurrentRecord(long currentRecord)
        throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findByCurrentRecord(
                currentRecord)) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public void removeByDepartmentsId(String departmentsId)
        throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findByDepartmentsId(
                departmentsId)) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public void removeByDocumentRecordTypeId(int documentRecordTypeId)
        throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findByDocumentRecordTypeId(
                documentRecordTypeId)) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public void removeByYearInUse(String yearInUse) throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findByYearInUse(
                yearInUse)) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public void removeByAgencyId(String agencyId) throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findByAgencyId(
                agencyId)) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public void removeByDepartDocYear(String yearInUse, String departmentsId,
        int documentRecordTypeId) throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findByDepartDocYear(
                yearInUse, departmentsId, documentRecordTypeId)) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public void removeByDepartDocAgency(String agencyId, String departmentsId,
        int documentRecordTypeId) throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findByDepartDocAgency(
                agencyId, departmentsId, documentRecordTypeId)) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public void removeByAgencyId_Year_DocumentRecordTo(String agencyId,
        String yearInUse, int documentRecordTypeId) throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findByAgencyId_Year_DocumentRecordTo(
                agencyId, yearInUse, documentRecordTypeId)) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public void removeByAgency_DocumentType(String agencyId,
        int documentRecordTypeId) throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findByAgency_DocumentType(
                agencyId, documentRecordTypeId)) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public void removeByDocumentRecordTypeId_DepartmentsId(
        int documentRecordTypeId, String departmentsId)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByDocumentRecordTypeId_DepartmentsId(documentRecordTypeId,
                departmentsId);

        remove(pmlEdmDocumentRecordTo);
    }

    public void removeByDocumentRecordTypeId_AgencyId(
        int documentRecordTypeId, String agencyId)
        throws NoSuchPmlEdmDocumentRecordToException, SystemException {
        PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo = findByDocumentRecordTypeId_AgencyId(documentRecordTypeId,
                agencyId);

        remove(pmlEdmDocumentRecordTo);
    }

    public void removeByYearInUse_AgencyId(String yearInUse, String agencyId)
        throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findByYearInUse_AgencyId(
                yearInUse, agencyId)) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public void removeByYearInUse_DepartmentsId(String yearInUse,
        String departmentsId) throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findByYearInUse_DepartmentsId(
                yearInUse, departmentsId)) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmDocumentRecordTo pmlEdmDocumentRecordTo : findAll()) {
            remove(pmlEdmDocumentRecordTo);
        }
    }

    public int countByDateCreate(Date dateCreate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
        String finderMethodName = "countByDateCreate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateCreate };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                if (dateCreate == null) {
                    query.append("datecreate IS NULL");
                } else {
                    query.append("datecreate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreate != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreate));
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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

    public int countByYearInUse(String yearInUse) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
        String finderMethodName = "countByYearInUse";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { yearInUse };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                if (yearInUse == null) {
                    query.append("yearinuse LIKE null");
                } else {
                    query.append("yearinuse LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (yearInUse != null) {
                    qPos.add(yearInUse);
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

    public int countByAgencyId(String agencyId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

    public int countByAgencyId_Year_DocumentRecordTo(String agencyId,
        String yearInUse, int documentRecordTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
        String finderMethodName = "countByAgencyId_Year_DocumentRecordTo";
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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

    public int countByAgency_DocumentType(String agencyId,
        int documentRecordTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
        String finderMethodName = "countByAgency_DocumentType";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName()
            };
        Object[] finderArgs = new Object[] {
                agencyId, new Integer(documentRecordTypeId)
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

                if (agencyId == null) {
                    query.append("agencyid IS NULL");
                } else {
                    query.append("agencyid = ?");
                }

                query.append(" AND ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (agencyId != null) {
                    qPos.add(agencyId);
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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordToModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordTo.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo")));

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
