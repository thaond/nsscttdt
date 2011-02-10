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

import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptTempException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptTempImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmDocumentReceiptTempModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmDocumentReceiptTempPersistenceImpl
    extends BasePersistenceImpl implements PmlEdmDocumentReceiptTempPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmDocumentReceiptTempPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmDocumentReceiptTemp create(long documentReceiptId) {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = new PmlEdmDocumentReceiptTempImpl();

        pmlEdmDocumentReceiptTemp.setNew(true);
        pmlEdmDocumentReceiptTemp.setPrimaryKey(documentReceiptId);

        return pmlEdmDocumentReceiptTemp;
    }

    public PmlEdmDocumentReceiptTemp remove(long documentReceiptId)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = (PmlEdmDocumentReceiptTemp) session.get(PmlEdmDocumentReceiptTempImpl.class,
                    new Long(documentReceiptId));

            if (pmlEdmDocumentReceiptTemp == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmDocumentReceiptTemp exists with the primary key " +
                        documentReceiptId);
                }

                throw new NoSuchPmlEdmDocumentReceiptTempException(
                    "No PmlEdmDocumentReceiptTemp exists with the primary key " +
                    documentReceiptId);
            }

            return remove(pmlEdmDocumentReceiptTemp);
        } catch (NoSuchPmlEdmDocumentReceiptTempException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentReceiptTemp remove(
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmDocumentReceiptTemp);
            }
        }

        pmlEdmDocumentReceiptTemp = removeImpl(pmlEdmDocumentReceiptTemp);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmDocumentReceiptTemp);
            }
        }

        return pmlEdmDocumentReceiptTemp;
    }

    protected PmlEdmDocumentReceiptTemp removeImpl(
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmDocumentReceiptTemp);

            session.flush();

            return pmlEdmDocumentReceiptTemp;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentReceiptTemp.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp, boolean merge)</code>.
     */
    public PmlEdmDocumentReceiptTemp update(
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp) method. Use update(PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp, boolean merge) instead.");
        }

        return update(pmlEdmDocumentReceiptTemp, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentReceiptTemp the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentReceiptTemp is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmDocumentReceiptTemp update(
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmDocumentReceiptTemp.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmDocumentReceiptTemp);
                } else {
                    listener.onBeforeUpdate(pmlEdmDocumentReceiptTemp);
                }
            }
        }

        pmlEdmDocumentReceiptTemp = updateImpl(pmlEdmDocumentReceiptTemp, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmDocumentReceiptTemp);
                } else {
                    listener.onAfterUpdate(pmlEdmDocumentReceiptTemp);
                }
            }
        }

        return pmlEdmDocumentReceiptTemp;
    }

    public PmlEdmDocumentReceiptTemp updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmDocumentReceiptTemp);
            } else {
                if (pmlEdmDocumentReceiptTemp.isNew()) {
                    session.save(pmlEdmDocumentReceiptTemp);
                }
            }

            session.flush();

            pmlEdmDocumentReceiptTemp.setNew(false);

            return pmlEdmDocumentReceiptTemp;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmDocumentReceiptTemp.class.getName());
        }
    }

    public PmlEdmDocumentReceiptTemp findByPrimaryKey(long documentReceiptId)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = fetchByPrimaryKey(documentReceiptId);

        if (pmlEdmDocumentReceiptTemp == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmDocumentReceiptTemp exists with the primary key " +
                    documentReceiptId);
            }

            throw new NoSuchPmlEdmDocumentReceiptTempException(
                "No PmlEdmDocumentReceiptTemp exists with the primary key " +
                documentReceiptId);
        }

        return pmlEdmDocumentReceiptTemp;
    }

    public PmlEdmDocumentReceiptTemp fetchByPrimaryKey(long documentReceiptId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmDocumentReceiptTemp) session.get(PmlEdmDocumentReceiptTempImpl.class,
                new Long(documentReceiptId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByDocumentType(
        String documentType) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByDocumentType";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentType };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (documentType == null) {
                    query.append("documenttype IS NULL");
                } else {
                    query.append("documenttype = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentType != null) {
                    qPos.add(documentType);
                }

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByDocumentType(
        String documentType, int start, int end) throws SystemException {
        return findByDocumentType(documentType, start, end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findByDocumentType(
        String documentType, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByDocumentType";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                documentType,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (documentType == null) {
                    query.append("documenttype IS NULL");
                } else {
                    query.append("documenttype = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentType != null) {
                    qPos.add(documentType);
                }

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public PmlEdmDocumentReceiptTemp findByDocumentType_First(
        String documentType, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        List<PmlEdmDocumentReceiptTemp> list = findByDocumentType(documentType,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("documentType=" + documentType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp findByDocumentType_Last(
        String documentType, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        int count = countByDocumentType(documentType);

        List<PmlEdmDocumentReceiptTemp> list = findByDocumentType(documentType,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("documentType=" + documentType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp[] findByDocumentType_PrevAndNext(
        long documentReceiptId, String documentType, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findByPrimaryKey(documentReceiptId);

        int count = countByDocumentType(documentType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

            if (documentType == null) {
                query.append("documenttype IS NULL");
            } else {
                query.append("documenttype = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (documentType != null) {
                qPos.add(documentType);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptTemp);

            PmlEdmDocumentReceiptTemp[] array = new PmlEdmDocumentReceiptTempImpl[3];

            array[0] = (PmlEdmDocumentReceiptTemp) objArray[0];
            array[1] = (PmlEdmDocumentReceiptTemp) objArray[1];
            array[2] = (PmlEdmDocumentReceiptTemp) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByLevelSendId(int levelSendId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByLevelSendId";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(levelSendId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("levelsendid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(levelSendId);

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByLevelSendId(int levelSendId,
        int start, int end) throws SystemException {
        return findByLevelSendId(levelSendId, start, end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findByLevelSendId(int levelSendId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByLevelSendId";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(levelSendId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("levelsendid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(levelSendId);

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public PmlEdmDocumentReceiptTemp findByLevelSendId_First(int levelSendId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        List<PmlEdmDocumentReceiptTemp> list = findByLevelSendId(levelSendId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("levelSendId=" + levelSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp findByLevelSendId_Last(int levelSendId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        int count = countByLevelSendId(levelSendId);

        List<PmlEdmDocumentReceiptTemp> list = findByLevelSendId(levelSendId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("levelSendId=" + levelSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp[] findByLevelSendId_PrevAndNext(
        long documentReceiptId, int levelSendId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findByPrimaryKey(documentReceiptId);

        int count = countByLevelSendId(levelSendId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

            query.append("levelsendid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(levelSendId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptTemp);

            PmlEdmDocumentReceiptTemp[] array = new PmlEdmDocumentReceiptTempImpl[3];

            array[0] = (PmlEdmDocumentReceiptTemp) objArray[0];
            array[1] = (PmlEdmDocumentReceiptTemp) objArray[1];
            array[2] = (PmlEdmDocumentReceiptTemp) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByDocumentTypeId(
        long documentTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByDocumentTypeId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentTypeId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("documenttypeid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentTypeId);

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByDocumentTypeId(
        long documentTypeId, int start, int end) throws SystemException {
        return findByDocumentTypeId(documentTypeId, start, end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findByDocumentTypeId(
        long documentTypeId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByDocumentTypeId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentTypeId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("documenttypeid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentTypeId);

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public PmlEdmDocumentReceiptTemp findByDocumentTypeId_First(
        long documentTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        List<PmlEdmDocumentReceiptTemp> list = findByDocumentTypeId(documentTypeId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("documentTypeId=" + documentTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp findByDocumentTypeId_Last(
        long documentTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        int count = countByDocumentTypeId(documentTypeId);

        List<PmlEdmDocumentReceiptTemp> list = findByDocumentTypeId(documentTypeId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("documentTypeId=" + documentTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp[] findByDocumentTypeId_PrevAndNext(
        long documentReceiptId, long documentTypeId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findByPrimaryKey(documentReceiptId);

        int count = countByDocumentTypeId(documentTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

            query.append("documenttypeid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(documentTypeId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptTemp);

            PmlEdmDocumentReceiptTemp[] array = new PmlEdmDocumentReceiptTempImpl[3];

            array[0] = (PmlEdmDocumentReceiptTemp) objArray[0];
            array[1] = (PmlEdmDocumentReceiptTemp) objArray[1];
            array[2] = (PmlEdmDocumentReceiptTemp) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByIssuingPlaceId(
        String issuingPlaceId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByIssuingPlaceId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { issuingPlaceId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (issuingPlaceId == null) {
                    query.append("issuingplaceid LIKE null");
                } else {
                    query.append("issuingplaceid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceId != null) {
                    qPos.add(issuingPlaceId);
                }

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByIssuingPlaceId(
        String issuingPlaceId, int start, int end) throws SystemException {
        return findByIssuingPlaceId(issuingPlaceId, start, end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findByIssuingPlaceId(
        String issuingPlaceId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByIssuingPlaceId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                issuingPlaceId,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (issuingPlaceId == null) {
                    query.append("issuingplaceid LIKE null");
                } else {
                    query.append("issuingplaceid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceId != null) {
                    qPos.add(issuingPlaceId);
                }

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public PmlEdmDocumentReceiptTemp findByIssuingPlaceId_First(
        String issuingPlaceId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        List<PmlEdmDocumentReceiptTemp> list = findByIssuingPlaceId(issuingPlaceId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("issuingPlaceId=" + issuingPlaceId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp findByIssuingPlaceId_Last(
        String issuingPlaceId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        int count = countByIssuingPlaceId(issuingPlaceId);

        List<PmlEdmDocumentReceiptTemp> list = findByIssuingPlaceId(issuingPlaceId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("issuingPlaceId=" + issuingPlaceId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp[] findByIssuingPlaceId_PrevAndNext(
        long documentReceiptId, String issuingPlaceId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findByPrimaryKey(documentReceiptId);

        int count = countByIssuingPlaceId(issuingPlaceId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

            if (issuingPlaceId == null) {
                query.append("issuingplaceid LIKE null");
            } else {
                query.append("issuingplaceid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (issuingPlaceId != null) {
                qPos.add(issuingPlaceId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptTemp);

            PmlEdmDocumentReceiptTemp[] array = new PmlEdmDocumentReceiptTempImpl[3];

            array[0] = (PmlEdmDocumentReceiptTemp) objArray[0];
            array[1] = (PmlEdmDocumentReceiptTemp) objArray[1];
            array[2] = (PmlEdmDocumentReceiptTemp) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByPrivilegeLevelId(
        String privilegeLevelId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByPrivilegeLevelId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { privilegeLevelId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (privilegeLevelId == null) {
                    query.append("privilegelevelid LIKE null");
                } else {
                    query.append("privilegelevelid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (privilegeLevelId != null) {
                    qPos.add(privilegeLevelId);
                }

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByPrivilegeLevelId(
        String privilegeLevelId, int start, int end) throws SystemException {
        return findByPrivilegeLevelId(privilegeLevelId, start, end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findByPrivilegeLevelId(
        String privilegeLevelId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByPrivilegeLevelId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                privilegeLevelId,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (privilegeLevelId == null) {
                    query.append("privilegelevelid LIKE null");
                } else {
                    query.append("privilegelevelid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (privilegeLevelId != null) {
                    qPos.add(privilegeLevelId);
                }

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public PmlEdmDocumentReceiptTemp findByPrivilegeLevelId_First(
        String privilegeLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        List<PmlEdmDocumentReceiptTemp> list = findByPrivilegeLevelId(privilegeLevelId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("privilegeLevelId=" + privilegeLevelId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp findByPrivilegeLevelId_Last(
        String privilegeLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        int count = countByPrivilegeLevelId(privilegeLevelId);

        List<PmlEdmDocumentReceiptTemp> list = findByPrivilegeLevelId(privilegeLevelId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("privilegeLevelId=" + privilegeLevelId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp[] findByPrivilegeLevelId_PrevAndNext(
        long documentReceiptId, String privilegeLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findByPrimaryKey(documentReceiptId);

        int count = countByPrivilegeLevelId(privilegeLevelId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

            if (privilegeLevelId == null) {
                query.append("privilegelevelid LIKE null");
            } else {
                query.append("privilegelevelid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (privilegeLevelId != null) {
                qPos.add(privilegeLevelId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptTemp);

            PmlEdmDocumentReceiptTemp[] array = new PmlEdmDocumentReceiptTempImpl[3];

            array[0] = (PmlEdmDocumentReceiptTemp) objArray[0];
            array[1] = (PmlEdmDocumentReceiptTemp) objArray[1];
            array[2] = (PmlEdmDocumentReceiptTemp) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByConfidentialLevelId(
        String confidentialLevelId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByConfidentialLevelId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { confidentialLevelId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (confidentialLevelId == null) {
                    query.append("confidentiallevelid LIKE null");
                } else {
                    query.append("confidentiallevelid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (confidentialLevelId != null) {
                    qPos.add(confidentialLevelId);
                }

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByConfidentialLevelId(
        String confidentialLevelId, int start, int end)
        throws SystemException {
        return findByConfidentialLevelId(confidentialLevelId, start, end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findByConfidentialLevelId(
        String confidentialLevelId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByConfidentialLevelId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                confidentialLevelId,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (confidentialLevelId == null) {
                    query.append("confidentiallevelid LIKE null");
                } else {
                    query.append("confidentiallevelid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (confidentialLevelId != null) {
                    qPos.add(confidentialLevelId);
                }

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public PmlEdmDocumentReceiptTemp findByConfidentialLevelId_First(
        String confidentialLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        List<PmlEdmDocumentReceiptTemp> list = findByConfidentialLevelId(confidentialLevelId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("confidentialLevelId=" + confidentialLevelId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp findByConfidentialLevelId_Last(
        String confidentialLevelId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        int count = countByConfidentialLevelId(confidentialLevelId);

        List<PmlEdmDocumentReceiptTemp> list = findByConfidentialLevelId(confidentialLevelId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("confidentialLevelId=" + confidentialLevelId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp[] findByConfidentialLevelId_PrevAndNext(
        long documentReceiptId, String confidentialLevelId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findByPrimaryKey(documentReceiptId);

        int count = countByConfidentialLevelId(confidentialLevelId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

            if (confidentialLevelId == null) {
                query.append("confidentiallevelid LIKE null");
            } else {
                query.append("confidentiallevelid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (confidentialLevelId != null) {
                qPos.add(confidentialLevelId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptTemp);

            PmlEdmDocumentReceiptTemp[] array = new PmlEdmDocumentReceiptTempImpl[3];

            array[0] = (PmlEdmDocumentReceiptTemp) objArray[0];
            array[1] = (PmlEdmDocumentReceiptTemp) objArray[1];
            array[2] = (PmlEdmDocumentReceiptTemp) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByNumberLocalDocumentReceipt(
        String numberLocalDocumentReceipt) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByNumberLocalDocumentReceipt";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { numberLocalDocumentReceipt };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (numberLocalDocumentReceipt == null) {
                    query.append("numberlocaldocumentreceipt LIKE null");
                } else {
                    query.append("numberlocaldocumentreceipt LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberLocalDocumentReceipt != null) {
                    qPos.add(numberLocalDocumentReceipt);
                }

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByNumberLocalDocumentReceipt(
        String numberLocalDocumentReceipt, int start, int end)
        throws SystemException {
        return findByNumberLocalDocumentReceipt(numberLocalDocumentReceipt,
            start, end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findByNumberLocalDocumentReceipt(
        String numberLocalDocumentReceipt, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByNumberLocalDocumentReceipt";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                numberLocalDocumentReceipt,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (numberLocalDocumentReceipt == null) {
                    query.append("numberlocaldocumentreceipt LIKE null");
                } else {
                    query.append("numberlocaldocumentreceipt LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberLocalDocumentReceipt != null) {
                    qPos.add(numberLocalDocumentReceipt);
                }

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public PmlEdmDocumentReceiptTemp findByNumberLocalDocumentReceipt_First(
        String numberLocalDocumentReceipt, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        List<PmlEdmDocumentReceiptTemp> list = findByNumberLocalDocumentReceipt(numberLocalDocumentReceipt,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("numberLocalDocumentReceipt=" +
                numberLocalDocumentReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp findByNumberLocalDocumentReceipt_Last(
        String numberLocalDocumentReceipt, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        int count = countByNumberLocalDocumentReceipt(numberLocalDocumentReceipt);

        List<PmlEdmDocumentReceiptTemp> list = findByNumberLocalDocumentReceipt(numberLocalDocumentReceipt,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("numberLocalDocumentReceipt=" +
                numberLocalDocumentReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp[] findByNumberLocalDocumentReceipt_PrevAndNext(
        long documentReceiptId, String numberLocalDocumentReceipt,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findByPrimaryKey(documentReceiptId);

        int count = countByNumberLocalDocumentReceipt(numberLocalDocumentReceipt);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

            if (numberLocalDocumentReceipt == null) {
                query.append("numberlocaldocumentreceipt LIKE null");
            } else {
                query.append("numberlocaldocumentreceipt LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (numberLocalDocumentReceipt != null) {
                qPos.add(numberLocalDocumentReceipt);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptTemp);

            PmlEdmDocumentReceiptTemp[] array = new PmlEdmDocumentReceiptTempImpl[3];

            array[0] = (PmlEdmDocumentReceiptTemp) objArray[0];
            array[1] = (PmlEdmDocumentReceiptTemp) objArray[1];
            array[2] = (PmlEdmDocumentReceiptTemp) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByStatusId(long statusId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByStatusId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(statusId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("statusid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(statusId);

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByStatusId(long statusId,
        int start, int end) throws SystemException {
        return findByStatusId(statusId, start, end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findByStatusId(long statusId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByStatusId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(statusId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("statusid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(statusId);

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public PmlEdmDocumentReceiptTemp findByStatusId_First(long statusId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        List<PmlEdmDocumentReceiptTemp> list = findByStatusId(statusId, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("statusId=" + statusId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp findByStatusId_Last(long statusId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        int count = countByStatusId(statusId);

        List<PmlEdmDocumentReceiptTemp> list = findByStatusId(statusId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("statusId=" + statusId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp[] findByStatusId_PrevAndNext(
        long documentReceiptId, long statusId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findByPrimaryKey(documentReceiptId);

        int count = countByStatusId(statusId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

            query.append("statusid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(statusId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptTemp);

            PmlEdmDocumentReceiptTemp[] array = new PmlEdmDocumentReceiptTempImpl[3];

            array[0] = (PmlEdmDocumentReceiptTemp) objArray[0];
            array[1] = (PmlEdmDocumentReceiptTemp) objArray[1];
            array[2] = (PmlEdmDocumentReceiptTemp) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmDocumentReceiptTemp findBySoCongCanDiPhucDap(
        String socongvandiphucdap)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = fetchBySoCongCanDiPhucDap(socongvandiphucdap);

        if (pmlEdmDocumentReceiptTemp == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("socongvandiphucdap=" + socongvandiphucdap);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        }

        return pmlEdmDocumentReceiptTemp;
    }

    public PmlEdmDocumentReceiptTemp fetchBySoCongCanDiPhucDap(
        String socongvandiphucdap) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "fetchBySoCongCanDiPhucDap";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { socongvandiphucdap };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (socongvandiphucdap == null) {
                    query.append("socongvandiphucdap LIKE null");
                } else {
                    query.append("socongvandiphucdap LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (socongvandiphucdap != null) {
                    qPos.add(socongvandiphucdap);
                }

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByMainDepartmentProcessId(
        String mainDepartmentProcessId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByMainDepartmentProcessId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { mainDepartmentProcessId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (mainDepartmentProcessId == null) {
                    query.append("maindepartmentprocessid LIKE null");
                } else {
                    query.append("maindepartmentprocessid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (mainDepartmentProcessId != null) {
                    qPos.add(mainDepartmentProcessId);
                }

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByMainDepartmentProcessId(
        String mainDepartmentProcessId, int start, int end)
        throws SystemException {
        return findByMainDepartmentProcessId(mainDepartmentProcessId, start,
            end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findByMainDepartmentProcessId(
        String mainDepartmentProcessId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByMainDepartmentProcessId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                mainDepartmentProcessId,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (mainDepartmentProcessId == null) {
                    query.append("maindepartmentprocessid LIKE null");
                } else {
                    query.append("maindepartmentprocessid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (mainDepartmentProcessId != null) {
                    qPos.add(mainDepartmentProcessId);
                }

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public PmlEdmDocumentReceiptTemp findByMainDepartmentProcessId_First(
        String mainDepartmentProcessId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        List<PmlEdmDocumentReceiptTemp> list = findByMainDepartmentProcessId(mainDepartmentProcessId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("mainDepartmentProcessId=" + mainDepartmentProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp findByMainDepartmentProcessId_Last(
        String mainDepartmentProcessId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        int count = countByMainDepartmentProcessId(mainDepartmentProcessId);

        List<PmlEdmDocumentReceiptTemp> list = findByMainDepartmentProcessId(mainDepartmentProcessId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("mainDepartmentProcessId=" + mainDepartmentProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp[] findByMainDepartmentProcessId_PrevAndNext(
        long documentReceiptId, String mainDepartmentProcessId,
        OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findByPrimaryKey(documentReceiptId);

        int count = countByMainDepartmentProcessId(mainDepartmentProcessId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

            if (mainDepartmentProcessId == null) {
                query.append("maindepartmentprocessid LIKE null");
            } else {
                query.append("maindepartmentprocessid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (mainDepartmentProcessId != null) {
                qPos.add(mainDepartmentProcessId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptTemp);

            PmlEdmDocumentReceiptTemp[] array = new PmlEdmDocumentReceiptTempImpl[3];

            array[0] = (PmlEdmDocumentReceiptTemp) objArray[0];
            array[1] = (PmlEdmDocumentReceiptTemp) objArray[1];
            array[2] = (PmlEdmDocumentReceiptTemp) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByMainUserProcessId(
        long mainUserProcessId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByMainUserProcessId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(mainUserProcessId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("mainuserprocessid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mainUserProcessId);

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByMainUserProcessId(
        long mainUserProcessId, int start, int end) throws SystemException {
        return findByMainUserProcessId(mainUserProcessId, start, end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findByMainUserProcessId(
        long mainUserProcessId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByMainUserProcessId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(mainUserProcessId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("mainuserprocessid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mainUserProcessId);

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public PmlEdmDocumentReceiptTemp findByMainUserProcessId_First(
        long mainUserProcessId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        List<PmlEdmDocumentReceiptTemp> list = findByMainUserProcessId(mainUserProcessId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("mainUserProcessId=" + mainUserProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp findByMainUserProcessId_Last(
        long mainUserProcessId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        int count = countByMainUserProcessId(mainUserProcessId);

        List<PmlEdmDocumentReceiptTemp> list = findByMainUserProcessId(mainUserProcessId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("mainUserProcessId=" + mainUserProcessId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp[] findByMainUserProcessId_PrevAndNext(
        long documentReceiptId, long mainUserProcessId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findByPrimaryKey(documentReceiptId);

        int count = countByMainUserProcessId(mainUserProcessId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

            query.append("mainuserprocessid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(mainUserProcessId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptTemp);

            PmlEdmDocumentReceiptTemp[] array = new PmlEdmDocumentReceiptTempImpl[3];

            array[0] = (PmlEdmDocumentReceiptTemp) objArray[0];
            array[1] = (PmlEdmDocumentReceiptTemp) objArray[1];
            array[2] = (PmlEdmDocumentReceiptTemp) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByOrgExternalId(
        long orgExternalId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByOrgExternalId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(orgExternalId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("orgexternalid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgExternalId);

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByOrgExternalId(
        long orgExternalId, int start, int end) throws SystemException {
        return findByOrgExternalId(orgExternalId, start, end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findByOrgExternalId(
        long orgExternalId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByOrgExternalId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(orgExternalId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("orgexternalid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgExternalId);

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public PmlEdmDocumentReceiptTemp findByOrgExternalId_First(
        long orgExternalId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        List<PmlEdmDocumentReceiptTemp> list = findByOrgExternalId(orgExternalId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("orgExternalId=" + orgExternalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp findByOrgExternalId_Last(
        long orgExternalId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        int count = countByOrgExternalId(orgExternalId);

        List<PmlEdmDocumentReceiptTemp> list = findByOrgExternalId(orgExternalId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("orgExternalId=" + orgExternalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp[] findByOrgExternalId_PrevAndNext(
        long documentReceiptId, long orgExternalId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findByPrimaryKey(documentReceiptId);

        int count = countByOrgExternalId(orgExternalId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

            query.append("orgexternalid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(orgExternalId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptTemp);

            PmlEdmDocumentReceiptTemp[] array = new PmlEdmDocumentReceiptTempImpl[3];

            array[0] = (PmlEdmDocumentReceiptTemp) objArray[0];
            array[1] = (PmlEdmDocumentReceiptTemp) objArray[1];
            array[2] = (PmlEdmDocumentReceiptTemp) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByNumberDocumentReceipt_OrgExternalId(
        String numberDocumentReceipt, long orgExternalId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByNumberDocumentReceipt_OrgExternalId";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                numberDocumentReceipt, new Long(orgExternalId)
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (numberDocumentReceipt == null) {
                    query.append("numberdocumentreceipt LIKE null");
                } else {
                    query.append("numberdocumentreceipt LIKE ?");
                }

                query.append(" AND ");

                query.append("orgexternalid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberDocumentReceipt != null) {
                    qPos.add(numberDocumentReceipt);
                }

                qPos.add(orgExternalId);

                List<PmlEdmDocumentReceiptTemp> list = q.list();

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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public List<PmlEdmDocumentReceiptTemp> findByNumberDocumentReceipt_OrgExternalId(
        String numberDocumentReceipt, long orgExternalId, int start, int end)
        throws SystemException {
        return findByNumberDocumentReceipt_OrgExternalId(numberDocumentReceipt,
            orgExternalId, start, end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findByNumberDocumentReceipt_OrgExternalId(
        String numberDocumentReceipt, long orgExternalId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "findByNumberDocumentReceipt_OrgExternalId";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                numberDocumentReceipt, new Long(orgExternalId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (numberDocumentReceipt == null) {
                    query.append("numberdocumentreceipt LIKE null");
                } else {
                    query.append("numberdocumentreceipt LIKE ?");
                }

                query.append(" AND ");

                query.append("orgexternalid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberDocumentReceipt != null) {
                    qPos.add(numberDocumentReceipt);
                }

                qPos.add(orgExternalId);

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public PmlEdmDocumentReceiptTemp findByNumberDocumentReceipt_OrgExternalId_First(
        String numberDocumentReceipt, long orgExternalId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        List<PmlEdmDocumentReceiptTemp> list = findByNumberDocumentReceipt_OrgExternalId(numberDocumentReceipt,
                orgExternalId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("numberDocumentReceipt=" + numberDocumentReceipt);

            msg.append(", ");
            msg.append("orgExternalId=" + orgExternalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp findByNumberDocumentReceipt_OrgExternalId_Last(
        String numberDocumentReceipt, long orgExternalId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        int count = countByNumberDocumentReceipt_OrgExternalId(numberDocumentReceipt,
                orgExternalId);

        List<PmlEdmDocumentReceiptTemp> list = findByNumberDocumentReceipt_OrgExternalId(numberDocumentReceipt,
                orgExternalId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmDocumentReceiptTemp exists with the key {");

            msg.append("numberDocumentReceipt=" + numberDocumentReceipt);

            msg.append(", ");
            msg.append("orgExternalId=" + orgExternalId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmDocumentReceiptTempException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmDocumentReceiptTemp[] findByNumberDocumentReceipt_OrgExternalId_PrevAndNext(
        long documentReceiptId, String numberDocumentReceipt,
        long orgExternalId, OrderByComparator obc)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findByPrimaryKey(documentReceiptId);

        int count = countByNumberDocumentReceipt_OrgExternalId(numberDocumentReceipt,
                orgExternalId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

            if (numberDocumentReceipt == null) {
                query.append("numberdocumentreceipt LIKE null");
            } else {
                query.append("numberdocumentreceipt LIKE ?");
            }

            query.append(" AND ");

            query.append("orgexternalid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (numberDocumentReceipt != null) {
                qPos.add(numberDocumentReceipt);
            }

            qPos.add(orgExternalId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmDocumentReceiptTemp);

            PmlEdmDocumentReceiptTemp[] array = new PmlEdmDocumentReceiptTempImpl[3];

            array[0] = (PmlEdmDocumentReceiptTemp) objArray[0];
            array[1] = (PmlEdmDocumentReceiptTemp) objArray[1];
            array[2] = (PmlEdmDocumentReceiptTemp) objArray[2];

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

    public List<PmlEdmDocumentReceiptTemp> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmDocumentReceiptTemp> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmDocumentReceiptTemp> list = (List<PmlEdmDocumentReceiptTemp>) QueryUtil.list(q,
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
            return (List<PmlEdmDocumentReceiptTemp>) result;
        }
    }

    public void removeByDocumentType(String documentType)
        throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findByDocumentType(
                documentType)) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public void removeByLevelSendId(int levelSendId) throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findByLevelSendId(
                levelSendId)) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public void removeByDocumentTypeId(long documentTypeId)
        throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findByDocumentTypeId(
                documentTypeId)) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public void removeByIssuingPlaceId(String issuingPlaceId)
        throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findByIssuingPlaceId(
                issuingPlaceId)) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public void removeByPrivilegeLevelId(String privilegeLevelId)
        throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findByPrivilegeLevelId(
                privilegeLevelId)) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public void removeByConfidentialLevelId(String confidentialLevelId)
        throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findByConfidentialLevelId(
                confidentialLevelId)) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public void removeByNumberLocalDocumentReceipt(
        String numberLocalDocumentReceipt) throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findByNumberLocalDocumentReceipt(
                numberLocalDocumentReceipt)) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public void removeByStatusId(long statusId) throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findByStatusId(
                statusId)) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public void removeBySoCongCanDiPhucDap(String socongvandiphucdap)
        throws NoSuchPmlEdmDocumentReceiptTempException, SystemException {
        PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp = findBySoCongCanDiPhucDap(socongvandiphucdap);

        remove(pmlEdmDocumentReceiptTemp);
    }

    public void removeByMainDepartmentProcessId(String mainDepartmentProcessId)
        throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findByMainDepartmentProcessId(
                mainDepartmentProcessId)) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public void removeByMainUserProcessId(long mainUserProcessId)
        throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findByMainUserProcessId(
                mainUserProcessId)) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public void removeByOrgExternalId(long orgExternalId)
        throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findByOrgExternalId(
                orgExternalId)) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public void removeByNumberDocumentReceipt_OrgExternalId(
        String numberDocumentReceipt, long orgExternalId)
        throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findByNumberDocumentReceipt_OrgExternalId(
                numberDocumentReceipt, orgExternalId)) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmDocumentReceiptTemp pmlEdmDocumentReceiptTemp : findAll()) {
            remove(pmlEdmDocumentReceiptTemp);
        }
    }

    public int countByDocumentType(String documentType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countByDocumentType";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { documentType };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (documentType == null) {
                    query.append("documenttype IS NULL");
                } else {
                    query.append("documenttype = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (documentType != null) {
                    qPos.add(documentType);
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

    public int countByLevelSendId(int levelSendId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countByLevelSendId";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(levelSendId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("levelsendid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(levelSendId);

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

    public int countByDocumentTypeId(long documentTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countByDocumentTypeId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentTypeId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("documenttypeid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentTypeId);

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

    public int countByIssuingPlaceId(String issuingPlaceId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countByIssuingPlaceId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { issuingPlaceId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (issuingPlaceId == null) {
                    query.append("issuingplaceid LIKE null");
                } else {
                    query.append("issuingplaceid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceId != null) {
                    qPos.add(issuingPlaceId);
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

    public int countByPrivilegeLevelId(String privilegeLevelId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countByPrivilegeLevelId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { privilegeLevelId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (privilegeLevelId == null) {
                    query.append("privilegelevelid LIKE null");
                } else {
                    query.append("privilegelevelid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (privilegeLevelId != null) {
                    qPos.add(privilegeLevelId);
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

    public int countByConfidentialLevelId(String confidentialLevelId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countByConfidentialLevelId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { confidentialLevelId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (confidentialLevelId == null) {
                    query.append("confidentiallevelid LIKE null");
                } else {
                    query.append("confidentiallevelid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (confidentialLevelId != null) {
                    qPos.add(confidentialLevelId);
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

    public int countByNumberLocalDocumentReceipt(
        String numberLocalDocumentReceipt) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countByNumberLocalDocumentReceipt";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { numberLocalDocumentReceipt };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (numberLocalDocumentReceipt == null) {
                    query.append("numberlocaldocumentreceipt LIKE null");
                } else {
                    query.append("numberlocaldocumentreceipt LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberLocalDocumentReceipt != null) {
                    qPos.add(numberLocalDocumentReceipt);
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

    public int countByStatusId(long statusId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countByStatusId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(statusId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("statusid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(statusId);

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

    public int countBySoCongCanDiPhucDap(String socongvandiphucdap)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countBySoCongCanDiPhucDap";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { socongvandiphucdap };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (socongvandiphucdap == null) {
                    query.append("socongvandiphucdap LIKE null");
                } else {
                    query.append("socongvandiphucdap LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (socongvandiphucdap != null) {
                    qPos.add(socongvandiphucdap);
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

    public int countByMainDepartmentProcessId(String mainDepartmentProcessId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countByMainDepartmentProcessId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { mainDepartmentProcessId };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (mainDepartmentProcessId == null) {
                    query.append("maindepartmentprocessid LIKE null");
                } else {
                    query.append("maindepartmentprocessid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (mainDepartmentProcessId != null) {
                    qPos.add(mainDepartmentProcessId);
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

    public int countByMainUserProcessId(long mainUserProcessId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countByMainUserProcessId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(mainUserProcessId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("mainuserprocessid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(mainUserProcessId);

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

    public int countByOrgExternalId(long orgExternalId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countByOrgExternalId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(orgExternalId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                query.append("orgexternalid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(orgExternalId);

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

    public int countByNumberDocumentReceipt_OrgExternalId(
        String numberDocumentReceipt, long orgExternalId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
        String finderMethodName = "countByNumberDocumentReceipt_OrgExternalId";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] {
                numberDocumentReceipt, new Long(orgExternalId)
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp WHERE ");

                if (numberDocumentReceipt == null) {
                    query.append("numberdocumentreceipt LIKE null");
                } else {
                    query.append("numberdocumentreceipt LIKE ?");
                }

                query.append(" AND ");

                query.append("orgexternalid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (numberDocumentReceipt != null) {
                    qPos.add(numberDocumentReceipt);
                }

                qPos.add(orgExternalId);

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
        boolean finderClassNameCacheEnabled = PmlEdmDocumentReceiptTempModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmDocumentReceiptTemp.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptTemp")));

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
