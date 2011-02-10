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

import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentTypeException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentTypeImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentTypeModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmDocumentTypePersistenceImpl extends BasePersistenceImpl
    implements PmlEdmDocumentTypePersistence {
    private static Log _log = LogFactory.getLog(PmlEdmDocumentTypePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmDocumentType create(long documentTypeId) {
        PmlEdmDocumentType pmlEdmDocumentType = new PmlEdmDocumentTypeImpl();

        pmlEdmDocumentType.setNew(true);
        pmlEdmDocumentType.setPrimaryKey(documentTypeId);

        return pmlEdmDocumentType;
    }

    public PmlEdmDocumentType remove(long documentTypeId)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmDocumentType pmlEdmDocumentType = (PmlEdmDocumentType) session.get(PmlEdmDocumentTypeImpl.class,
                    new Long(documentTypeId));

            if (pmlEdmDocumentType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmDocumentType exists with the primary key " +
                        documentTypeId);
                }

                throw new NoSuchPmlEdmDocumentTypeException(
                    "No PmlEdmDocumentType exists with the primary key " +
                    documentTypeId);
            }

            return remove(pmlEdmDocumentType);
        } catch (NoSuchPmlEdmDocumentTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentType remove(PmlEdmDocumentType pmlEdmDocumentType)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmDocumentType);
            }
        }

        pmlEdmDocumentType = removeImpl(pmlEdmDocumentType);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmDocumentType);
            }
        }

        return pmlEdmDocumentType;
    }

    protected PmlEdmDocumentType removeImpl(
        PmlEdmDocumentType pmlEdmDocumentType) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmDocumentType);

            session.flush();

            return pmlEdmDocumentType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentType.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentType pmlEdmDocumentType, boolean merge)</code>.
     */
    public PmlEdmDocumentType update(PmlEdmDocumentType pmlEdmDocumentType)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmDocumentType pmlEdmDocumentType) method. Use update(PmlEdmDocumentType pmlEdmDocumentType, boolean merge) instead.");
        }

        return update(pmlEdmDocumentType, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmDocumentType update(PmlEdmDocumentType pmlEdmDocumentType,
        boolean merge) throws SystemException {
        boolean isNew = pmlEdmDocumentType.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmDocumentType);
                } else {
                    listener.onBeforeUpdate(pmlEdmDocumentType);
                }
            }
        }

        pmlEdmDocumentType = updateImpl(pmlEdmDocumentType, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmDocumentType);
                } else {
                    listener.onAfterUpdate(pmlEdmDocumentType);
                }
            }
        }

        return pmlEdmDocumentType;
    }

    public PmlEdmDocumentType updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentType pmlEdmDocumentType,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmDocumentType);
            } else {
                if (pmlEdmDocumentType.isNew()) {
                    session.save(pmlEdmDocumentType);
                }
            }

            session.flush();

            pmlEdmDocumentType.setNew(false);

            return pmlEdmDocumentType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentType.class.getName());
        }
    }

    public PmlEdmDocumentType findByPrimaryKey(long documentTypeId)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        PmlEdmDocumentType pmlEdmDocumentType = fetchByPrimaryKey(documentTypeId);

        if (pmlEdmDocumentType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlEdmDocumentType exists with the primary key " +
                    documentTypeId);
            }

            throw new NoSuchPmlEdmDocumentTypeException(
                "No PmlEdmDocumentType exists with the primary key " +
                documentTypeId);
        }

        return pmlEdmDocumentType;
    }

    public PmlEdmDocumentType fetchByPrimaryKey(long documentTypeId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmDocumentType) session.get(PmlEdmDocumentTypeImpl.class,
                new Long(documentTypeId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentType> findByDocumentTypeName(
        String documentTypeName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
        String finderMethodName = "findByDocumentTypeName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentTypeName };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                if (documentTypeName == null) {
                    query.append("documenttypename LIKE null");
                } else {
                    query.append("documenttypename LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documenttypename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentTypeName != null) {
                    qPos.add(documentTypeName);
                }

                List<PmlEdmDocumentType> list = q.list();

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
            return (List<PmlEdmDocumentType>) result;
        }
    }

    public List<PmlEdmDocumentType> findByDocumentTypeName(
        String documentTypeName, int start, int end) throws SystemException {
        return findByDocumentTypeName(documentTypeName, start, end, null);
    }

    public List<PmlEdmDocumentType> findByDocumentTypeName(
        String documentTypeName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
        String finderMethodName = "findByDocumentTypeName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                documentTypeName,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                if (documentTypeName == null) {
                    query.append("documenttypename LIKE null");
                } else {
                    query.append("documenttypename LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documenttypename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentTypeName != null) {
                    qPos.add(documentTypeName);
                }

                List<PmlEdmDocumentType> list = (List<PmlEdmDocumentType>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentType>) result;
        }
    }

    public PmlEdmDocumentType findByDocumentTypeName_First(
        String documentTypeName, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        List<PmlEdmDocumentType> list = findByDocumentTypeName(documentTypeName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentType exists with the key {");

            msg.append("documentTypeName=" + documentTypeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentType findByDocumentTypeName_Last(
        String documentTypeName, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        int count = countByDocumentTypeName(documentTypeName);

        List<PmlEdmDocumentType> list = findByDocumentTypeName(documentTypeName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentType exists with the key {");

            msg.append("documentTypeName=" + documentTypeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentType[] findByDocumentTypeName_PrevAndNext(
        long documentTypeId, String documentTypeName, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        PmlEdmDocumentType pmlEdmDocumentType = findByPrimaryKey(documentTypeId);

        int count = countByDocumentTypeName(documentTypeName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

            if (documentTypeName == null) {
                query.append("documenttypename LIKE null");
            } else {
                query.append("documenttypename LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documenttypename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (documentTypeName != null) {
                qPos.add(documentTypeName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentType);

            PmlEdmDocumentType[] array = new PmlEdmDocumentTypeImpl[3];

            array[0] = (PmlEdmDocumentType) objArray[0];
            array[1] = (PmlEdmDocumentType) objArray[1];
            array[2] = (PmlEdmDocumentType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentType> findByDocumentSymbol(String documentSymbol)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
        String finderMethodName = "findByDocumentSymbol";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentSymbol };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                if (documentSymbol == null) {
                    query.append("documentsymbol LIKE null");
                } else {
                    query.append("documentsymbol LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documenttypename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentSymbol != null) {
                    qPos.add(documentSymbol);
                }

                List<PmlEdmDocumentType> list = q.list();

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
            return (List<PmlEdmDocumentType>) result;
        }
    }

    public List<PmlEdmDocumentType> findByDocumentSymbol(
        String documentSymbol, int start, int end) throws SystemException {
        return findByDocumentSymbol(documentSymbol, start, end, null);
    }

    public List<PmlEdmDocumentType> findByDocumentSymbol(
        String documentSymbol, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
        String finderMethodName = "findByDocumentSymbol";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                documentSymbol,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                if (documentSymbol == null) {
                    query.append("documentsymbol LIKE null");
                } else {
                    query.append("documentsymbol LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documenttypename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentSymbol != null) {
                    qPos.add(documentSymbol);
                }

                List<PmlEdmDocumentType> list = (List<PmlEdmDocumentType>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentType>) result;
        }
    }

    public PmlEdmDocumentType findByDocumentSymbol_First(
        String documentSymbol, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        List<PmlEdmDocumentType> list = findByDocumentSymbol(documentSymbol, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentType exists with the key {");

            msg.append("documentSymbol=" + documentSymbol);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentType findByDocumentSymbol_Last(String documentSymbol,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        int count = countByDocumentSymbol(documentSymbol);

        List<PmlEdmDocumentType> list = findByDocumentSymbol(documentSymbol,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentType exists with the key {");

            msg.append("documentSymbol=" + documentSymbol);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentType[] findByDocumentSymbol_PrevAndNext(
        long documentTypeId, String documentSymbol, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        PmlEdmDocumentType pmlEdmDocumentType = findByPrimaryKey(documentTypeId);

        int count = countByDocumentSymbol(documentSymbol);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

            if (documentSymbol == null) {
                query.append("documentsymbol LIKE null");
            } else {
                query.append("documentsymbol LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documenttypename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (documentSymbol != null) {
                qPos.add(documentSymbol);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentType);

            PmlEdmDocumentType[] array = new PmlEdmDocumentTypeImpl[3];

            array[0] = (PmlEdmDocumentType) objArray[0];
            array[1] = (PmlEdmDocumentType) objArray[1];
            array[2] = (PmlEdmDocumentType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentType> findByDocumentRecordTypeId(
        int documentRecordTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documenttypename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordTypeId);

                List<PmlEdmDocumentType> list = q.list();

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
            return (List<PmlEdmDocumentType>) result;
        }
    }

    public List<PmlEdmDocumentType> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end) throws SystemException {
        return findByDocumentRecordTypeId(documentRecordTypeId, start, end, null);
    }

    public List<PmlEdmDocumentType> findByDocumentRecordTypeId(
        int documentRecordTypeId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                query.append("documentrecordtypeid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documenttypename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentRecordTypeId);

                List<PmlEdmDocumentType> list = (List<PmlEdmDocumentType>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentType>) result;
        }
    }

    public PmlEdmDocumentType findByDocumentRecordTypeId_First(
        int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        List<PmlEdmDocumentType> list = findByDocumentRecordTypeId(documentRecordTypeId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentType exists with the key {");

            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentType findByDocumentRecordTypeId_Last(
        int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        int count = countByDocumentRecordTypeId(documentRecordTypeId);

        List<PmlEdmDocumentType> list = findByDocumentRecordTypeId(documentRecordTypeId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentType exists with the key {");

            msg.append("documentRecordTypeId=" + documentRecordTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentType[] findByDocumentRecordTypeId_PrevAndNext(
        long documentTypeId, int documentRecordTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        PmlEdmDocumentType pmlEdmDocumentType = findByPrimaryKey(documentTypeId);

        int count = countByDocumentRecordTypeId(documentRecordTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

            query.append("documentrecordtypeid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documenttypename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentRecordTypeId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentType);

            PmlEdmDocumentType[] array = new PmlEdmDocumentTypeImpl[3];

            array[0] = (PmlEdmDocumentType) objArray[0];
            array[1] = (PmlEdmDocumentType) objArray[1];
            array[2] = (PmlEdmDocumentType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentType> findBySendReceiptDistinction(
        int sendReceiptDistinction) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
        String finderMethodName = "findBySendReceiptDistinction";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(sendReceiptDistinction) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                query.append("sendreceiptdistinction = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documenttypename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(sendReceiptDistinction);

                List<PmlEdmDocumentType> list = q.list();

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
            return (List<PmlEdmDocumentType>) result;
        }
    }

    public List<PmlEdmDocumentType> findBySendReceiptDistinction(
        int sendReceiptDistinction, int start, int end)
        throws SystemException {
        return findBySendReceiptDistinction(sendReceiptDistinction, start, end,
            null);
    }

    public List<PmlEdmDocumentType> findBySendReceiptDistinction(
        int sendReceiptDistinction, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
        String finderMethodName = "findBySendReceiptDistinction";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(sendReceiptDistinction),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                query.append("sendreceiptdistinction = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documenttypename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(sendReceiptDistinction);

                List<PmlEdmDocumentType> list = (List<PmlEdmDocumentType>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentType>) result;
        }
    }

    public PmlEdmDocumentType findBySendReceiptDistinction_First(
        int sendReceiptDistinction, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        List<PmlEdmDocumentType> list = findBySendReceiptDistinction(sendReceiptDistinction,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentType exists with the key {");

            msg.append("sendReceiptDistinction=" + sendReceiptDistinction);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentType findBySendReceiptDistinction_Last(
        int sendReceiptDistinction, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        int count = countBySendReceiptDistinction(sendReceiptDistinction);

        List<PmlEdmDocumentType> list = findBySendReceiptDistinction(sendReceiptDistinction,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentType exists with the key {");

            msg.append("sendReceiptDistinction=" + sendReceiptDistinction);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentType[] findBySendReceiptDistinction_PrevAndNext(
        long documentTypeId, int sendReceiptDistinction, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        PmlEdmDocumentType pmlEdmDocumentType = findByPrimaryKey(documentTypeId);

        int count = countBySendReceiptDistinction(sendReceiptDistinction);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

            query.append("sendreceiptdistinction = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documenttypename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(sendReceiptDistinction);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentType);

            PmlEdmDocumentType[] array = new PmlEdmDocumentTypeImpl[3];

            array[0] = (PmlEdmDocumentType) objArray[0];
            array[1] = (PmlEdmDocumentType) objArray[1];
            array[2] = (PmlEdmDocumentType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentType> findByHaveDepartExtends(
        boolean HaveDepartExtends) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
        String finderMethodName = "findByHaveDepartExtends";
        String[] finderParams = new String[] { Boolean.class.getName() };
        Object[] finderArgs = new Object[] { Boolean.valueOf(HaveDepartExtends) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                query.append("HaveDepartExtends = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("documenttypename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(HaveDepartExtends);

                List<PmlEdmDocumentType> list = q.list();

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
            return (List<PmlEdmDocumentType>) result;
        }
    }

    public List<PmlEdmDocumentType> findByHaveDepartExtends(
        boolean HaveDepartExtends, int start, int end)
        throws SystemException {
        return findByHaveDepartExtends(HaveDepartExtends, start, end, null);
    }

    public List<PmlEdmDocumentType> findByHaveDepartExtends(
        boolean HaveDepartExtends, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
        String finderMethodName = "findByHaveDepartExtends";
        String[] finderParams = new String[] {
                Boolean.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                Boolean.valueOf(HaveDepartExtends),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                query.append("HaveDepartExtends = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documenttypename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(HaveDepartExtends);

                List<PmlEdmDocumentType> list = (List<PmlEdmDocumentType>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentType>) result;
        }
    }

    public PmlEdmDocumentType findByHaveDepartExtends_First(
        boolean HaveDepartExtends, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        List<PmlEdmDocumentType> list = findByHaveDepartExtends(HaveDepartExtends,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentType exists with the key {");

            msg.append("HaveDepartExtends=" + HaveDepartExtends);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentType findByHaveDepartExtends_Last(
        boolean HaveDepartExtends, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        int count = countByHaveDepartExtends(HaveDepartExtends);

        List<PmlEdmDocumentType> list = findByHaveDepartExtends(HaveDepartExtends,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentType exists with the key {");

            msg.append("HaveDepartExtends=" + HaveDepartExtends);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentType[] findByHaveDepartExtends_PrevAndNext(
        long documentTypeId, boolean HaveDepartExtends, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentTypeException, SystemException {
        PmlEdmDocumentType pmlEdmDocumentType = findByPrimaryKey(documentTypeId);

        int count = countByHaveDepartExtends(HaveDepartExtends);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

            query.append("HaveDepartExtends = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("documenttypename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(HaveDepartExtends);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentType);

            PmlEdmDocumentType[] array = new PmlEdmDocumentTypeImpl[3];

            array[0] = (PmlEdmDocumentType) objArray[0];
            array[1] = (PmlEdmDocumentType) objArray[1];
            array[2] = (PmlEdmDocumentType) objArray[2];

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

    public List<PmlEdmDocumentType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmDocumentType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmDocumentType> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("documenttypename ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmDocumentType> list = (List<PmlEdmDocumentType>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentType>) result;
        }
    }

    public void removeByDocumentTypeName(String documentTypeName)
        throws SystemException {
        for (PmlEdmDocumentType pmlEdmDocumentType : findByDocumentTypeName(
                documentTypeName)) {
            remove(pmlEdmDocumentType);
        }
    }

    public void removeByDocumentSymbol(String documentSymbol)
        throws SystemException {
        for (PmlEdmDocumentType pmlEdmDocumentType : findByDocumentSymbol(
                documentSymbol)) {
            remove(pmlEdmDocumentType);
        }
    }

    public void removeByDocumentRecordTypeId(int documentRecordTypeId)
        throws SystemException {
        for (PmlEdmDocumentType pmlEdmDocumentType : findByDocumentRecordTypeId(
                documentRecordTypeId)) {
            remove(pmlEdmDocumentType);
        }
    }

    public void removeBySendReceiptDistinction(int sendReceiptDistinction)
        throws SystemException {
        for (PmlEdmDocumentType pmlEdmDocumentType : findBySendReceiptDistinction(
                sendReceiptDistinction)) {
            remove(pmlEdmDocumentType);
        }
    }

    public void removeByHaveDepartExtends(boolean HaveDepartExtends)
        throws SystemException {
        for (PmlEdmDocumentType pmlEdmDocumentType : findByHaveDepartExtends(
                HaveDepartExtends)) {
            remove(pmlEdmDocumentType);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmDocumentType pmlEdmDocumentType : findAll()) {
            remove(pmlEdmDocumentType);
        }
    }

    public int countByDocumentTypeName(String documentTypeName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
        String finderMethodName = "countByDocumentTypeName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentTypeName };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                if (documentTypeName == null) {
                    query.append("documenttypename LIKE null");
                } else {
                    query.append("documenttypename LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentTypeName != null) {
                    qPos.add(documentTypeName);
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

    public int countByDocumentSymbol(String documentSymbol)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
        String finderMethodName = "countByDocumentSymbol";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentSymbol };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                if (documentSymbol == null) {
                    query.append("documentsymbol LIKE null");
                } else {
                    query.append("documentsymbol LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentSymbol != null) {
                    qPos.add(documentSymbol);
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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

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

    public int countBySendReceiptDistinction(int sendReceiptDistinction)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
        String finderMethodName = "countBySendReceiptDistinction";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(sendReceiptDistinction) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                query.append("sendreceiptdistinction = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(sendReceiptDistinction);

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

    public int countByHaveDepartExtends(boolean HaveDepartExtends)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
        String finderMethodName = "countByHaveDepartExtends";
        String[] finderParams = new String[] { Boolean.class.getName() };
        Object[] finderArgs = new Object[] { Boolean.valueOf(HaveDepartExtends) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType WHERE ");

                query.append("HaveDepartExtends = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(HaveDepartExtends);

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentType.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentType");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmDocumentType")));

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
