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

import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordTypeImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentRecordTypeModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmDocumentRecordTypePersistenceImpl extends BasePersistenceImpl
    implements PmlEdmDocumentRecordTypePersistence {
    private static Log _log = LogFactory.getLog(PmlEdmDocumentRecordTypePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmDocumentRecordType create(int documentRecordTypeId) {
        PmlEdmDocumentRecordType pmlEdmDocumentRecordType = new PmlEdmDocumentRecordTypeImpl();

        pmlEdmDocumentRecordType.setNew(true);
        pmlEdmDocumentRecordType.setPrimaryKey(documentRecordTypeId);

        return pmlEdmDocumentRecordType;
    }

    public PmlEdmDocumentRecordType remove(int documentRecordTypeId)
        throws NoSuchPmlEdmDocumentRecordTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmDocumentRecordType pmlEdmDocumentRecordType = (PmlEdmDocumentRecordType) session.get(PmlEdmDocumentRecordTypeImpl.class,
                    new Integer(documentRecordTypeId));

            if (pmlEdmDocumentRecordType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmDocumentRecordType exists with the primary key " +
                        documentRecordTypeId);
                }

                throw new NoSuchPmlEdmDocumentRecordTypeException(
                    "No PmlEdmDocumentRecordType exists with the primary key " +
                    documentRecordTypeId);
            }

            return remove(pmlEdmDocumentRecordType);
        } catch (NoSuchPmlEdmDocumentRecordTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentRecordType remove(
        PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmDocumentRecordType);
            }
        }

        pmlEdmDocumentRecordType = removeImpl(pmlEdmDocumentRecordType);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmDocumentRecordType);
            }
        }

        return pmlEdmDocumentRecordType;
    }

    protected PmlEdmDocumentRecordType removeImpl(
        PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmDocumentRecordType);

            session.flush();

            return pmlEdmDocumentRecordType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentRecordType.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentRecordType pmlEdmDocumentRecordType, boolean merge)</code>.
     */
    public PmlEdmDocumentRecordType update(
        PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmDocumentRecordType pmlEdmDocumentRecordType) method. Use update(PmlEdmDocumentRecordType pmlEdmDocumentRecordType, boolean merge) instead.");
        }

        return update(pmlEdmDocumentRecordType, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentRecordType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentRecordType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmDocumentRecordType update(
        PmlEdmDocumentRecordType pmlEdmDocumentRecordType, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmDocumentRecordType.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmDocumentRecordType);
                } else {
                    listener.onBeforeUpdate(pmlEdmDocumentRecordType);
                }
            }
        }

        pmlEdmDocumentRecordType = updateImpl(pmlEdmDocumentRecordType, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmDocumentRecordType);
                } else {
                    listener.onAfterUpdate(pmlEdmDocumentRecordType);
                }
            }
        }

        return pmlEdmDocumentRecordType;
    }

    public PmlEdmDocumentRecordType updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmDocumentRecordType);
            } else {
                if (pmlEdmDocumentRecordType.isNew()) {
                    session.save(pmlEdmDocumentRecordType);
                }
            }

            session.flush();

            pmlEdmDocumentRecordType.setNew(false);

            return pmlEdmDocumentRecordType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentRecordType.class.getName());
        }
    }

    public PmlEdmDocumentRecordType findByPrimaryKey(int documentRecordTypeId)
        throws NoSuchPmlEdmDocumentRecordTypeException, SystemException {
        PmlEdmDocumentRecordType pmlEdmDocumentRecordType = fetchByPrimaryKey(documentRecordTypeId);

        if (pmlEdmDocumentRecordType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmDocumentRecordType exists with the primary key " +
                    documentRecordTypeId);
            }

            throw new NoSuchPmlEdmDocumentRecordTypeException(
                "No PmlEdmDocumentRecordType exists with the primary key " +
                documentRecordTypeId);
        }

        return pmlEdmDocumentRecordType;
    }

    public PmlEdmDocumentRecordType fetchByPrimaryKey(int documentRecordTypeId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmDocumentRecordType) session.get(PmlEdmDocumentRecordTypeImpl.class,
                new Integer(documentRecordTypeId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        String documentRecordTypeCode) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordType.class.getName();
        String finderMethodName = "findByDocumentRecordTypeCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentRecordTypeCode };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType WHERE ");

                if (documentRecordTypeCode == null) {
                    query.append("documentrecordtypecode LIKE null");
                } else {
                    query.append("documentrecordtypecode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentrecordtypename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentRecordTypeCode != null) {
                    qPos.add(documentRecordTypeCode);
                }

                List<PmlEdmDocumentRecordType> list = q.list();

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
            return (List<PmlEdmDocumentRecordType>) result;
        }
    }

    public List<PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        String documentRecordTypeCode, int start, int end)
        throws SystemException {
        return findByDocumentRecordTypeCode(documentRecordTypeCode, start, end,
            null);
    }

    public List<PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        String documentRecordTypeCode, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordType.class.getName();
        String finderMethodName = "findByDocumentRecordTypeCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                documentRecordTypeCode,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType WHERE ");

                if (documentRecordTypeCode == null) {
                    query.append("documentrecordtypecode LIKE null");
                } else {
                    query.append("documentrecordtypecode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentrecordtypename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentRecordTypeCode != null) {
                    qPos.add(documentRecordTypeCode);
                }

                List<PmlEdmDocumentRecordType> list = (List<PmlEdmDocumentRecordType>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordType>) result;
        }
    }

    public PmlEdmDocumentRecordType findByDocumentRecordTypeCode_First(
        String documentRecordTypeCode, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordTypeException, SystemException {
        List<PmlEdmDocumentRecordType> list = findByDocumentRecordTypeCode(documentRecordTypeCode,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordType exists with the key {");

            msg.append("documentRecordTypeCode=" + documentRecordTypeCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordType findByDocumentRecordTypeCode_Last(
        String documentRecordTypeCode, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordTypeException, SystemException {
        int count = countByDocumentRecordTypeCode(documentRecordTypeCode);

        List<PmlEdmDocumentRecordType> list = findByDocumentRecordTypeCode(documentRecordTypeCode,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordType exists with the key {");

            msg.append("documentRecordTypeCode=" + documentRecordTypeCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordType[] findByDocumentRecordTypeCode_PrevAndNext(
        int documentRecordTypeId, String documentRecordTypeCode,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordTypeException, SystemException {
        PmlEdmDocumentRecordType pmlEdmDocumentRecordType = findByPrimaryKey(documentRecordTypeId);

        int count = countByDocumentRecordTypeCode(documentRecordTypeCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType WHERE ");

            if (documentRecordTypeCode == null) {
                query.append("documentrecordtypecode LIKE null");
            } else {
                query.append("documentrecordtypecode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentrecordtypename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (documentRecordTypeCode != null) {
                qPos.add(documentRecordTypeCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRecordType);

            PmlEdmDocumentRecordType[] array = new PmlEdmDocumentRecordTypeImpl[3];

            array[0] = (PmlEdmDocumentRecordType) objArray[0];
            array[1] = (PmlEdmDocumentRecordType) objArray[1];
            array[2] = (PmlEdmDocumentRecordType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentRecordType> findByDocumentRecordTypeName(
        String documentRecordTypeName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordType.class.getName();
        String finderMethodName = "findByDocumentRecordTypeName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentRecordTypeName };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType WHERE ");

                if (documentRecordTypeName == null) {
                    query.append("documentrecordtypename LIKE null");
                } else {
                    query.append("documentrecordtypename LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documentrecordtypename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentRecordTypeName != null) {
                    qPos.add(documentRecordTypeName);
                }

                List<PmlEdmDocumentRecordType> list = q.list();

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
            return (List<PmlEdmDocumentRecordType>) result;
        }
    }

    public List<PmlEdmDocumentRecordType> findByDocumentRecordTypeName(
        String documentRecordTypeName, int start, int end)
        throws SystemException {
        return findByDocumentRecordTypeName(documentRecordTypeName, start, end,
            null);
    }

    public List<PmlEdmDocumentRecordType> findByDocumentRecordTypeName(
        String documentRecordTypeName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordType.class.getName();
        String finderMethodName = "findByDocumentRecordTypeName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                documentRecordTypeName,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType WHERE ");

                if (documentRecordTypeName == null) {
                    query.append("documentrecordtypename LIKE null");
                } else {
                    query.append("documentrecordtypename LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentrecordtypename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentRecordTypeName != null) {
                    qPos.add(documentRecordTypeName);
                }

                List<PmlEdmDocumentRecordType> list = (List<PmlEdmDocumentRecordType>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordType>) result;
        }
    }

    public PmlEdmDocumentRecordType findByDocumentRecordTypeName_First(
        String documentRecordTypeName, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordTypeException, SystemException {
        List<PmlEdmDocumentRecordType> list = findByDocumentRecordTypeName(documentRecordTypeName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordType exists with the key {");

            msg.append("documentRecordTypeName=" + documentRecordTypeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordType findByDocumentRecordTypeName_Last(
        String documentRecordTypeName, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordTypeException, SystemException {
        int count = countByDocumentRecordTypeName(documentRecordTypeName);

        List<PmlEdmDocumentRecordType> list = findByDocumentRecordTypeName(documentRecordTypeName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentRecordType exists with the key {");

            msg.append("documentRecordTypeName=" + documentRecordTypeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentRecordTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentRecordType[] findByDocumentRecordTypeName_PrevAndNext(
        int documentRecordTypeId, String documentRecordTypeName,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentRecordTypeException, SystemException {
        PmlEdmDocumentRecordType pmlEdmDocumentRecordType = findByPrimaryKey(documentRecordTypeId);

        int count = countByDocumentRecordTypeName(documentRecordTypeName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType WHERE ");

            if (documentRecordTypeName == null) {
                query.append("documentrecordtypename LIKE null");
            } else {
                query.append("documentrecordtypename LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documentrecordtypename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (documentRecordTypeName != null) {
                qPos.add(documentRecordTypeName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentRecordType);

            PmlEdmDocumentRecordType[] array = new PmlEdmDocumentRecordTypeImpl[3];

            array[0] = (PmlEdmDocumentRecordType) objArray[0];
            array[1] = (PmlEdmDocumentRecordType) objArray[1];
            array[2] = (PmlEdmDocumentRecordType) objArray[2];

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

    public List<PmlEdmDocumentRecordType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmDocumentRecordType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmDocumentRecordType> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordType.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documentrecordtypename ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmDocumentRecordType> list = (List<PmlEdmDocumentRecordType>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentRecordType>) result;
        }
    }

    public void removeByDocumentRecordTypeCode(String documentRecordTypeCode)
        throws SystemException {
        for (PmlEdmDocumentRecordType pmlEdmDocumentRecordType : findByDocumentRecordTypeCode(
                documentRecordTypeCode)) {
            remove(pmlEdmDocumentRecordType);
        }
    }

    public void removeByDocumentRecordTypeName(String documentRecordTypeName)
        throws SystemException {
        for (PmlEdmDocumentRecordType pmlEdmDocumentRecordType : findByDocumentRecordTypeName(
                documentRecordTypeName)) {
            remove(pmlEdmDocumentRecordType);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmDocumentRecordType pmlEdmDocumentRecordType : findAll()) {
            remove(pmlEdmDocumentRecordType);
        }
    }

    public int countByDocumentRecordTypeCode(String documentRecordTypeCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordType.class.getName();
        String finderMethodName = "countByDocumentRecordTypeCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentRecordTypeCode };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType WHERE ");

                if (documentRecordTypeCode == null) {
                    query.append("documentrecordtypecode LIKE null");
                } else {
                    query.append("documentrecordtypecode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentRecordTypeCode != null) {
                    qPos.add(documentRecordTypeCode);
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

    public int countByDocumentRecordTypeName(String documentRecordTypeName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordType.class.getName();
        String finderMethodName = "countByDocumentRecordTypeName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentRecordTypeName };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType WHERE ");

                if (documentRecordTypeName == null) {
                    query.append("documentrecordtypename LIKE null");
                } else {
                    query.append("documentrecordtypename LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentRecordTypeName != null) {
                    qPos.add(documentRecordTypeName);
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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentRecordTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentRecordType.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType")));

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
