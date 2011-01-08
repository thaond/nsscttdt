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

import com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException;
import com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmLevelSendDetailImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmLevelSendDetailModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmLevelSendDetailPersistenceImpl extends BasePersistenceImpl
    implements PmlEdmLevelSendDetailPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmLevelSendDetailPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmLevelSendDetail create(
        PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK) {
        PmlEdmLevelSendDetail pmlEdmLevelSendDetail = new PmlEdmLevelSendDetailImpl();

        pmlEdmLevelSendDetail.setNew(true);
        pmlEdmLevelSendDetail.setPrimaryKey(pmlEdmLevelSendDetailPK);

        return pmlEdmLevelSendDetail;
    }

    public PmlEdmLevelSendDetail remove(
        PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws NoSuchPmlEdmLevelSendDetailException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmLevelSendDetail pmlEdmLevelSendDetail = (PmlEdmLevelSendDetail) session.get(PmlEdmLevelSendDetailImpl.class,
                    pmlEdmLevelSendDetailPK);

            if (pmlEdmLevelSendDetail == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmLevelSendDetail exists with the primary key " +
                        pmlEdmLevelSendDetailPK);
                }

                throw new NoSuchPmlEdmLevelSendDetailException(
                    "No PmlEdmLevelSendDetail exists with the primary key " +
                    pmlEdmLevelSendDetailPK);
            }

            return remove(pmlEdmLevelSendDetail);
        } catch (NoSuchPmlEdmLevelSendDetailException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmLevelSendDetail remove(
        PmlEdmLevelSendDetail pmlEdmLevelSendDetail) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmLevelSendDetail);
            }
        }

        pmlEdmLevelSendDetail = removeImpl(pmlEdmLevelSendDetail);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmLevelSendDetail);
            }
        }

        return pmlEdmLevelSendDetail;
    }

    protected PmlEdmLevelSendDetail removeImpl(
        PmlEdmLevelSendDetail pmlEdmLevelSendDetail) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmLevelSendDetail);

            session.flush();

            return pmlEdmLevelSendDetail;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmLevelSendDetail.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmLevelSendDetail pmlEdmLevelSendDetail, boolean merge)</code>.
     */
    public PmlEdmLevelSendDetail update(
        PmlEdmLevelSendDetail pmlEdmLevelSendDetail) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmLevelSendDetail pmlEdmLevelSendDetail) method. Use update(PmlEdmLevelSendDetail pmlEdmLevelSendDetail, boolean merge) instead.");
        }

        return update(pmlEdmLevelSendDetail, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmLevelSendDetail the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmLevelSendDetail is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmLevelSendDetail update(
        PmlEdmLevelSendDetail pmlEdmLevelSendDetail, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmLevelSendDetail.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmLevelSendDetail);
                } else {
                    listener.onBeforeUpdate(pmlEdmLevelSendDetail);
                }
            }
        }

        pmlEdmLevelSendDetail = updateImpl(pmlEdmLevelSendDetail, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmLevelSendDetail);
                } else {
                    listener.onAfterUpdate(pmlEdmLevelSendDetail);
                }
            }
        }

        return pmlEdmLevelSendDetail;
    }

    public PmlEdmLevelSendDetail updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmLevelSendDetail);
            } else {
                if (pmlEdmLevelSendDetail.isNew()) {
                    session.save(pmlEdmLevelSendDetail);
                }
            }

            session.flush();

            pmlEdmLevelSendDetail.setNew(false);

            return pmlEdmLevelSendDetail;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmLevelSendDetail.class.getName());
        }
    }

    public PmlEdmLevelSendDetail findByPrimaryKey(
        PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws NoSuchPmlEdmLevelSendDetailException, SystemException {
        PmlEdmLevelSendDetail pmlEdmLevelSendDetail = fetchByPrimaryKey(pmlEdmLevelSendDetailPK);

        if (pmlEdmLevelSendDetail == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlEdmLevelSendDetail exists with the primary key " +
                    pmlEdmLevelSendDetailPK);
            }

            throw new NoSuchPmlEdmLevelSendDetailException(
                "No PmlEdmLevelSendDetail exists with the primary key " +
                pmlEdmLevelSendDetailPK);
        }

        return pmlEdmLevelSendDetail;
    }

    public PmlEdmLevelSendDetail fetchByPrimaryKey(
        PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmLevelSendDetail) session.get(PmlEdmLevelSendDetailImpl.class,
                pmlEdmLevelSendDetailPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmLevelSendDetail> findByLevelSendId(int levelSendId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSendDetail.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail WHERE ");

                query.append("levelsendid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("levelsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(levelSendId);

                List<PmlEdmLevelSendDetail> list = q.list();

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
            return (List<PmlEdmLevelSendDetail>) result;
        }
    }

    public List<PmlEdmLevelSendDetail> findByLevelSendId(int levelSendId,
        int start, int end) throws SystemException {
        return findByLevelSendId(levelSendId, start, end, null);
    }

    public List<PmlEdmLevelSendDetail> findByLevelSendId(int levelSendId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSendDetail.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail WHERE ");

                query.append("levelsendid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("levelsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(levelSendId);

                List<PmlEdmLevelSendDetail> list = (List<PmlEdmLevelSendDetail>) QueryUtil.list(q,
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
            return (List<PmlEdmLevelSendDetail>) result;
        }
    }

    public PmlEdmLevelSendDetail findByLevelSendId_First(int levelSendId,
        OrderByComparator obc)
        throws NoSuchPmlEdmLevelSendDetailException, SystemException {
        List<PmlEdmLevelSendDetail> list = findByLevelSendId(levelSendId, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmLevelSendDetail exists with the key {");

            msg.append("levelSendId=" + levelSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmLevelSendDetailException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmLevelSendDetail findByLevelSendId_Last(int levelSendId,
        OrderByComparator obc)
        throws NoSuchPmlEdmLevelSendDetailException, SystemException {
        int count = countByLevelSendId(levelSendId);

        List<PmlEdmLevelSendDetail> list = findByLevelSendId(levelSendId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmLevelSendDetail exists with the key {");

            msg.append("levelSendId=" + levelSendId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmLevelSendDetailException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmLevelSendDetail[] findByLevelSendId_PrevAndNext(
        PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK, int levelSendId,
        OrderByComparator obc)
        throws NoSuchPmlEdmLevelSendDetailException, SystemException {
        PmlEdmLevelSendDetail pmlEdmLevelSendDetail = findByPrimaryKey(pmlEdmLevelSendDetailPK);

        int count = countByLevelSendId(levelSendId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail WHERE ");

            query.append("levelsendid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("levelsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(levelSendId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmLevelSendDetail);

            PmlEdmLevelSendDetail[] array = new PmlEdmLevelSendDetailImpl[3];

            array[0] = (PmlEdmLevelSendDetail) objArray[0];
            array[1] = (PmlEdmLevelSendDetail) objArray[1];
            array[2] = (PmlEdmLevelSendDetail) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmLevelSendDetail> findByIssuingPlaceId(
        String issuingPlaceId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSendDetail.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail WHERE ");

                if (issuingPlaceId == null) {
                    query.append("issuingPlaceId IS NULL");
                } else {
                    query.append("issuingPlaceId = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("levelsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceId != null) {
                    qPos.add(issuingPlaceId);
                }

                List<PmlEdmLevelSendDetail> list = q.list();

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
            return (List<PmlEdmLevelSendDetail>) result;
        }
    }

    public List<PmlEdmLevelSendDetail> findByIssuingPlaceId(
        String issuingPlaceId, int start, int end) throws SystemException {
        return findByIssuingPlaceId(issuingPlaceId, start, end, null);
    }

    public List<PmlEdmLevelSendDetail> findByIssuingPlaceId(
        String issuingPlaceId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSendDetail.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail WHERE ");

                if (issuingPlaceId == null) {
                    query.append("issuingPlaceId IS NULL");
                } else {
                    query.append("issuingPlaceId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("levelsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceId != null) {
                    qPos.add(issuingPlaceId);
                }

                List<PmlEdmLevelSendDetail> list = (List<PmlEdmLevelSendDetail>) QueryUtil.list(q,
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
            return (List<PmlEdmLevelSendDetail>) result;
        }
    }

    public PmlEdmLevelSendDetail findByIssuingPlaceId_First(
        String issuingPlaceId, OrderByComparator obc)
        throws NoSuchPmlEdmLevelSendDetailException, SystemException {
        List<PmlEdmLevelSendDetail> list = findByIssuingPlaceId(issuingPlaceId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmLevelSendDetail exists with the key {");

            msg.append("issuingPlaceId=" + issuingPlaceId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmLevelSendDetailException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmLevelSendDetail findByIssuingPlaceId_Last(
        String issuingPlaceId, OrderByComparator obc)
        throws NoSuchPmlEdmLevelSendDetailException, SystemException {
        int count = countByIssuingPlaceId(issuingPlaceId);

        List<PmlEdmLevelSendDetail> list = findByIssuingPlaceId(issuingPlaceId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmLevelSendDetail exists with the key {");

            msg.append("issuingPlaceId=" + issuingPlaceId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmLevelSendDetailException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmLevelSendDetail[] findByIssuingPlaceId_PrevAndNext(
        PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK, String issuingPlaceId,
        OrderByComparator obc)
        throws NoSuchPmlEdmLevelSendDetailException, SystemException {
        PmlEdmLevelSendDetail pmlEdmLevelSendDetail = findByPrimaryKey(pmlEdmLevelSendDetailPK);

        int count = countByIssuingPlaceId(issuingPlaceId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail WHERE ");

            if (issuingPlaceId == null) {
                query.append("issuingPlaceId IS NULL");
            } else {
                query.append("issuingPlaceId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("levelsendid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (issuingPlaceId != null) {
                qPos.add(issuingPlaceId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmLevelSendDetail);

            PmlEdmLevelSendDetail[] array = new PmlEdmLevelSendDetailImpl[3];

            array[0] = (PmlEdmLevelSendDetail) objArray[0];
            array[1] = (PmlEdmLevelSendDetail) objArray[1];
            array[2] = (PmlEdmLevelSendDetail) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmLevelSendDetail findByLevelSendId_IssuingPlaceId(
        int levelSendId, String issuingPlaceId)
        throws NoSuchPmlEdmLevelSendDetailException, SystemException {
        PmlEdmLevelSendDetail pmlEdmLevelSendDetail = fetchByLevelSendId_IssuingPlaceId(levelSendId,
                issuingPlaceId);

        if (pmlEdmLevelSendDetail == null) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmLevelSendDetail exists with the key {");

            msg.append("levelSendId=" + levelSendId);

            msg.append(", ");
            msg.append("issuingPlaceId=" + issuingPlaceId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchPmlEdmLevelSendDetailException(msg.toString());
        }

        return pmlEdmLevelSendDetail;
    }

    public PmlEdmLevelSendDetail fetchByLevelSendId_IssuingPlaceId(
        int levelSendId, String issuingPlaceId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSendDetail.class.getName();
        String finderMethodName = "fetchByLevelSendId_IssuingPlaceId";
        String[] finderParams = new String[] {
                Integer.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Integer(levelSendId),
                
                issuingPlaceId
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail WHERE ");

                query.append("levelsendid = ?");

                query.append(" AND ");

                if (issuingPlaceId == null) {
                    query.append("issuingPlaceId IS NULL");
                } else {
                    query.append("issuingPlaceId = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("levelsendid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(levelSendId);

                if (issuingPlaceId != null) {
                    qPos.add(issuingPlaceId);
                }

                List<PmlEdmLevelSendDetail> list = q.list();

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
            List<PmlEdmLevelSendDetail> list = (List<PmlEdmLevelSendDetail>) result;

            if (list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
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

    public List<PmlEdmLevelSendDetail> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmLevelSendDetail> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmLevelSendDetail> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSendDetail.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("levelsendid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmLevelSendDetail> list = (List<PmlEdmLevelSendDetail>) QueryUtil.list(q,
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
            return (List<PmlEdmLevelSendDetail>) result;
        }
    }

    public void removeByLevelSendId(int levelSendId) throws SystemException {
        for (PmlEdmLevelSendDetail pmlEdmLevelSendDetail : findByLevelSendId(
                levelSendId)) {
            remove(pmlEdmLevelSendDetail);
        }
    }

    public void removeByIssuingPlaceId(String issuingPlaceId)
        throws SystemException {
        for (PmlEdmLevelSendDetail pmlEdmLevelSendDetail : findByIssuingPlaceId(
                issuingPlaceId)) {
            remove(pmlEdmLevelSendDetail);
        }
    }

    public void removeByLevelSendId_IssuingPlaceId(int levelSendId,
        String issuingPlaceId)
        throws NoSuchPmlEdmLevelSendDetailException, SystemException {
        PmlEdmLevelSendDetail pmlEdmLevelSendDetail = findByLevelSendId_IssuingPlaceId(levelSendId,
                issuingPlaceId);

        remove(pmlEdmLevelSendDetail);
    }

    public void removeAll() throws SystemException {
        for (PmlEdmLevelSendDetail pmlEdmLevelSendDetail : findAll()) {
            remove(pmlEdmLevelSendDetail);
        }
    }

    public int countByLevelSendId(int levelSendId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSendDetail.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail WHERE ");

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

    public int countByIssuingPlaceId(String issuingPlaceId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSendDetail.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail WHERE ");

                if (issuingPlaceId == null) {
                    query.append("issuingPlaceId IS NULL");
                } else {
                    query.append("issuingPlaceId = ?");
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

    public int countByLevelSendId_IssuingPlaceId(int levelSendId,
        String issuingPlaceId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSendDetail.class.getName();
        String finderMethodName = "countByLevelSendId_IssuingPlaceId";
        String[] finderParams = new String[] {
                Integer.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Integer(levelSendId),
                
                issuingPlaceId
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail WHERE ");

                query.append("levelsendid = ?");

                query.append(" AND ");

                if (issuingPlaceId == null) {
                    query.append("issuingPlaceId IS NULL");
                } else {
                    query.append("issuingPlaceId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(levelSendId);

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

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendDetailModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSendDetail.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail")));

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
