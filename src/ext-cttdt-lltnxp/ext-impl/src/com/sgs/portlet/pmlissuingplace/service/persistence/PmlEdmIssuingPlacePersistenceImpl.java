package com.sgs.portlet.pmlissuingplace.service.persistence;

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

import com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.model.impl.PmlEdmIssuingPlaceImpl;
import com.sgs.portlet.pmlissuingplace.model.impl.PmlEdmIssuingPlaceModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmIssuingPlacePersistenceImpl extends BasePersistenceImpl
    implements PmlEdmIssuingPlacePersistence {
    private static Log _log = LogFactory.getLog(PmlEdmIssuingPlacePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmIssuingPlace create(String issuingPlaceId) {
        PmlEdmIssuingPlace pmlEdmIssuingPlace = new PmlEdmIssuingPlaceImpl();

        pmlEdmIssuingPlace.setNew(true);
        pmlEdmIssuingPlace.setPrimaryKey(issuingPlaceId);

        return pmlEdmIssuingPlace;
    }

    public PmlEdmIssuingPlace remove(String issuingPlaceId)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmIssuingPlace pmlEdmIssuingPlace = (PmlEdmIssuingPlace) session.get(PmlEdmIssuingPlaceImpl.class,
                    issuingPlaceId);

            if (pmlEdmIssuingPlace == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmIssuingPlace exists with the primary key " +
                        issuingPlaceId);
                }

                throw new NoSuchPmlEdmIssuingPlaceException(
                    "No PmlEdmIssuingPlace exists with the primary key " +
                    issuingPlaceId);
            }

            return remove(pmlEdmIssuingPlace);
        } catch (NoSuchPmlEdmIssuingPlaceException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmIssuingPlace remove(PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmIssuingPlace);
            }
        }

        pmlEdmIssuingPlace = removeImpl(pmlEdmIssuingPlace);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmIssuingPlace);
            }
        }

        return pmlEdmIssuingPlace;
    }

    protected PmlEdmIssuingPlace removeImpl(
        PmlEdmIssuingPlace pmlEdmIssuingPlace) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmIssuingPlace);

            session.flush();

            return pmlEdmIssuingPlace;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmIssuingPlace.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmIssuingPlace pmlEdmIssuingPlace, boolean merge)</code>.
     */
    public PmlEdmIssuingPlace update(PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmIssuingPlace pmlEdmIssuingPlace) method. Use update(PmlEdmIssuingPlace pmlEdmIssuingPlace, boolean merge) instead.");
        }

        return update(pmlEdmIssuingPlace, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmIssuingPlace the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmIssuingPlace is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmIssuingPlace update(PmlEdmIssuingPlace pmlEdmIssuingPlace,
        boolean merge) throws SystemException {
        boolean isNew = pmlEdmIssuingPlace.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmIssuingPlace);
                } else {
                    listener.onBeforeUpdate(pmlEdmIssuingPlace);
                }
            }
        }

        pmlEdmIssuingPlace = updateImpl(pmlEdmIssuingPlace, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmIssuingPlace);
                } else {
                    listener.onAfterUpdate(pmlEdmIssuingPlace);
                }
            }
        }

        return pmlEdmIssuingPlace;
    }

    public PmlEdmIssuingPlace updateImpl(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmIssuingPlace);
            } else {
                if (pmlEdmIssuingPlace.isNew()) {
                    session.save(pmlEdmIssuingPlace);
                }
            }

            session.flush();

            pmlEdmIssuingPlace.setNew(false);

            return pmlEdmIssuingPlace;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmIssuingPlace.class.getName());
        }
    }

    public PmlEdmIssuingPlace findByPrimaryKey(String issuingPlaceId)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        PmlEdmIssuingPlace pmlEdmIssuingPlace = fetchByPrimaryKey(issuingPlaceId);

        if (pmlEdmIssuingPlace == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlEdmIssuingPlace exists with the primary key " +
                    issuingPlaceId);
            }

            throw new NoSuchPmlEdmIssuingPlaceException(
                "No PmlEdmIssuingPlace exists with the primary key " +
                issuingPlaceId);
        }

        return pmlEdmIssuingPlace;
    }

    public PmlEdmIssuingPlace fetchByPrimaryKey(String issuingPlaceId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmIssuingPlace) session.get(PmlEdmIssuingPlaceImpl.class,
                issuingPlaceId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmIssuingPlace> findByIssuingPlaceCode(
        String issuingPlaceCode) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "findByIssuingPlaceCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { issuingPlaceCode };

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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (issuingPlaceCode == null) {
                    query.append("issuingplacecode LIKE null");
                } else {
                    query.append("issuingplacecode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("issuingplacename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceCode != null) {
                    qPos.add(issuingPlaceCode);
                }

                List<PmlEdmIssuingPlace> list = q.list();

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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public List<PmlEdmIssuingPlace> findByIssuingPlaceCode(
        String issuingPlaceCode, int start, int end) throws SystemException {
        return findByIssuingPlaceCode(issuingPlaceCode, start, end, null);
    }

    public List<PmlEdmIssuingPlace> findByIssuingPlaceCode(
        String issuingPlaceCode, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "findByIssuingPlaceCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                issuingPlaceCode,
                
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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (issuingPlaceCode == null) {
                    query.append("issuingplacecode LIKE null");
                } else {
                    query.append("issuingplacecode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("issuingplacename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceCode != null) {
                    qPos.add(issuingPlaceCode);
                }

                List<PmlEdmIssuingPlace> list = (List<PmlEdmIssuingPlace>) QueryUtil.list(q,
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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public PmlEdmIssuingPlace findByIssuingPlaceCode_First(
        String issuingPlaceCode, OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        List<PmlEdmIssuingPlace> list = findByIssuingPlaceCode(issuingPlaceCode,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmIssuingPlace exists with the key {");

            msg.append("issuingPlaceCode=" + issuingPlaceCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmIssuingPlaceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmIssuingPlace findByIssuingPlaceCode_Last(
        String issuingPlaceCode, OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        int count = countByIssuingPlaceCode(issuingPlaceCode);

        List<PmlEdmIssuingPlace> list = findByIssuingPlaceCode(issuingPlaceCode,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmIssuingPlace exists with the key {");

            msg.append("issuingPlaceCode=" + issuingPlaceCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmIssuingPlaceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmIssuingPlace[] findByIssuingPlaceCode_PrevAndNext(
        String issuingPlaceId, String issuingPlaceCode, OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        PmlEdmIssuingPlace pmlEdmIssuingPlace = findByPrimaryKey(issuingPlaceId);

        int count = countByIssuingPlaceCode(issuingPlaceCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

            if (issuingPlaceCode == null) {
                query.append("issuingplacecode LIKE null");
            } else {
                query.append("issuingplacecode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("issuingplacename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (issuingPlaceCode != null) {
                qPos.add(issuingPlaceCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmIssuingPlace);

            PmlEdmIssuingPlace[] array = new PmlEdmIssuingPlaceImpl[3];

            array[0] = (PmlEdmIssuingPlace) objArray[0];
            array[1] = (PmlEdmIssuingPlace) objArray[1];
            array[2] = (PmlEdmIssuingPlace) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmIssuingPlace> findByIssuingPlaceName(
        String issuingPlaceName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "findByIssuingPlaceName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { issuingPlaceName };

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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (issuingPlaceName == null) {
                    query.append("issuingplacename LIKE null");
                } else {
                    query.append("issuingplacename LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("issuingplacename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceName != null) {
                    qPos.add(issuingPlaceName);
                }

                List<PmlEdmIssuingPlace> list = q.list();

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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public List<PmlEdmIssuingPlace> findByIssuingPlaceName(
        String issuingPlaceName, int start, int end) throws SystemException {
        return findByIssuingPlaceName(issuingPlaceName, start, end, null);
    }

    public List<PmlEdmIssuingPlace> findByIssuingPlaceName(
        String issuingPlaceName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "findByIssuingPlaceName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                issuingPlaceName,
                
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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (issuingPlaceName == null) {
                    query.append("issuingplacename LIKE null");
                } else {
                    query.append("issuingplacename LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("issuingplacename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceName != null) {
                    qPos.add(issuingPlaceName);
                }

                List<PmlEdmIssuingPlace> list = (List<PmlEdmIssuingPlace>) QueryUtil.list(q,
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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public PmlEdmIssuingPlace findByIssuingPlaceName_First(
        String issuingPlaceName, OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        List<PmlEdmIssuingPlace> list = findByIssuingPlaceName(issuingPlaceName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmIssuingPlace exists with the key {");

            msg.append("issuingPlaceName=" + issuingPlaceName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmIssuingPlaceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmIssuingPlace findByIssuingPlaceName_Last(
        String issuingPlaceName, OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        int count = countByIssuingPlaceName(issuingPlaceName);

        List<PmlEdmIssuingPlace> list = findByIssuingPlaceName(issuingPlaceName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmIssuingPlace exists with the key {");

            msg.append("issuingPlaceName=" + issuingPlaceName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmIssuingPlaceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmIssuingPlace[] findByIssuingPlaceName_PrevAndNext(
        String issuingPlaceId, String issuingPlaceName, OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        PmlEdmIssuingPlace pmlEdmIssuingPlace = findByPrimaryKey(issuingPlaceId);

        int count = countByIssuingPlaceName(issuingPlaceName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

            if (issuingPlaceName == null) {
                query.append("issuingplacename LIKE null");
            } else {
                query.append("issuingplacename LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("issuingplacename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (issuingPlaceName != null) {
                qPos.add(issuingPlaceName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmIssuingPlace);

            PmlEdmIssuingPlace[] array = new PmlEdmIssuingPlaceImpl[3];

            array[0] = (PmlEdmIssuingPlace) objArray[0];
            array[1] = (PmlEdmIssuingPlace) objArray[1];
            array[2] = (PmlEdmIssuingPlace) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmIssuingPlace> findByTablePhone(String tablePhone)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "findByTablePhone";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { tablePhone };

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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (tablePhone == null) {
                    query.append("tablephone LIKE null");
                } else {
                    query.append("tablephone LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("issuingplacename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (tablePhone != null) {
                    qPos.add(tablePhone);
                }

                List<PmlEdmIssuingPlace> list = q.list();

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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public List<PmlEdmIssuingPlace> findByTablePhone(String tablePhone,
        int start, int end) throws SystemException {
        return findByTablePhone(tablePhone, start, end, null);
    }

    public List<PmlEdmIssuingPlace> findByTablePhone(String tablePhone,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "findByTablePhone";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                tablePhone,
                
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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (tablePhone == null) {
                    query.append("tablephone LIKE null");
                } else {
                    query.append("tablephone LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("issuingplacename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (tablePhone != null) {
                    qPos.add(tablePhone);
                }

                List<PmlEdmIssuingPlace> list = (List<PmlEdmIssuingPlace>) QueryUtil.list(q,
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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public PmlEdmIssuingPlace findByTablePhone_First(String tablePhone,
        OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        List<PmlEdmIssuingPlace> list = findByTablePhone(tablePhone, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmIssuingPlace exists with the key {");

            msg.append("tablePhone=" + tablePhone);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmIssuingPlaceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmIssuingPlace findByTablePhone_Last(String tablePhone,
        OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        int count = countByTablePhone(tablePhone);

        List<PmlEdmIssuingPlace> list = findByTablePhone(tablePhone, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmIssuingPlace exists with the key {");

            msg.append("tablePhone=" + tablePhone);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmIssuingPlaceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmIssuingPlace[] findByTablePhone_PrevAndNext(
        String issuingPlaceId, String tablePhone, OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        PmlEdmIssuingPlace pmlEdmIssuingPlace = findByPrimaryKey(issuingPlaceId);

        int count = countByTablePhone(tablePhone);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

            if (tablePhone == null) {
                query.append("tablephone LIKE null");
            } else {
                query.append("tablephone LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("issuingplacename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (tablePhone != null) {
                qPos.add(tablePhone);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmIssuingPlace);

            PmlEdmIssuingPlace[] array = new PmlEdmIssuingPlaceImpl[3];

            array[0] = (PmlEdmIssuingPlace) objArray[0];
            array[1] = (PmlEdmIssuingPlace) objArray[1];
            array[2] = (PmlEdmIssuingPlace) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmIssuingPlace> findByHandPhone(String handPhone)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "findByHandPhone";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { handPhone };

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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (handPhone == null) {
                    query.append("handphone LIKE null");
                } else {
                    query.append("handphone LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("issuingplacename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (handPhone != null) {
                    qPos.add(handPhone);
                }

                List<PmlEdmIssuingPlace> list = q.list();

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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public List<PmlEdmIssuingPlace> findByHandPhone(String handPhone,
        int start, int end) throws SystemException {
        return findByHandPhone(handPhone, start, end, null);
    }

    public List<PmlEdmIssuingPlace> findByHandPhone(String handPhone,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "findByHandPhone";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                handPhone,
                
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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (handPhone == null) {
                    query.append("handphone LIKE null");
                } else {
                    query.append("handphone LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("issuingplacename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (handPhone != null) {
                    qPos.add(handPhone);
                }

                List<PmlEdmIssuingPlace> list = (List<PmlEdmIssuingPlace>) QueryUtil.list(q,
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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public PmlEdmIssuingPlace findByHandPhone_First(String handPhone,
        OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        List<PmlEdmIssuingPlace> list = findByHandPhone(handPhone, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmIssuingPlace exists with the key {");

            msg.append("handPhone=" + handPhone);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmIssuingPlaceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmIssuingPlace findByHandPhone_Last(String handPhone,
        OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        int count = countByHandPhone(handPhone);

        List<PmlEdmIssuingPlace> list = findByHandPhone(handPhone, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmIssuingPlace exists with the key {");

            msg.append("handPhone=" + handPhone);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmIssuingPlaceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmIssuingPlace[] findByHandPhone_PrevAndNext(
        String issuingPlaceId, String handPhone, OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        PmlEdmIssuingPlace pmlEdmIssuingPlace = findByPrimaryKey(issuingPlaceId);

        int count = countByHandPhone(handPhone);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

            if (handPhone == null) {
                query.append("handphone LIKE null");
            } else {
                query.append("handphone LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("issuingplacename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (handPhone != null) {
                qPos.add(handPhone);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmIssuingPlace);

            PmlEdmIssuingPlace[] array = new PmlEdmIssuingPlaceImpl[3];

            array[0] = (PmlEdmIssuingPlace) objArray[0];
            array[1] = (PmlEdmIssuingPlace) objArray[1];
            array[2] = (PmlEdmIssuingPlace) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmIssuingPlace> findByAddress(String address)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "findByAddress";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { address };

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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (address == null) {
                    query.append("address LIKE null");
                } else {
                    query.append("address LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("issuingplacename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (address != null) {
                    qPos.add(address);
                }

                List<PmlEdmIssuingPlace> list = q.list();

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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public List<PmlEdmIssuingPlace> findByAddress(String address, int start,
        int end) throws SystemException {
        return findByAddress(address, start, end, null);
    }

    public List<PmlEdmIssuingPlace> findByAddress(String address, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "findByAddress";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                address,
                
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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (address == null) {
                    query.append("address LIKE null");
                } else {
                    query.append("address LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("issuingplacename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (address != null) {
                    qPos.add(address);
                }

                List<PmlEdmIssuingPlace> list = (List<PmlEdmIssuingPlace>) QueryUtil.list(q,
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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public PmlEdmIssuingPlace findByAddress_First(String address,
        OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        List<PmlEdmIssuingPlace> list = findByAddress(address, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmIssuingPlace exists with the key {");

            msg.append("address=" + address);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmIssuingPlaceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmIssuingPlace findByAddress_Last(String address,
        OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        int count = countByAddress(address);

        List<PmlEdmIssuingPlace> list = findByAddress(address, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmIssuingPlace exists with the key {");

            msg.append("address=" + address);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmIssuingPlaceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmIssuingPlace[] findByAddress_PrevAndNext(
        String issuingPlaceId, String address, OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        PmlEdmIssuingPlace pmlEdmIssuingPlace = findByPrimaryKey(issuingPlaceId);

        int count = countByAddress(address);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

            if (address == null) {
                query.append("address LIKE null");
            } else {
                query.append("address LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("issuingplacename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (address != null) {
                qPos.add(address);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmIssuingPlace);

            PmlEdmIssuingPlace[] array = new PmlEdmIssuingPlaceImpl[3];

            array[0] = (PmlEdmIssuingPlace) objArray[0];
            array[1] = (PmlEdmIssuingPlace) objArray[1];
            array[2] = (PmlEdmIssuingPlace) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmIssuingPlace> findByEmail(String email)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "findByEmail";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { email };

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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (email == null) {
                    query.append("email LIKE null");
                } else {
                    query.append("email LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("issuingplacename ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (email != null) {
                    qPos.add(email);
                }

                List<PmlEdmIssuingPlace> list = q.list();

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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public List<PmlEdmIssuingPlace> findByEmail(String email, int start, int end)
        throws SystemException {
        return findByEmail(email, start, end, null);
    }

    public List<PmlEdmIssuingPlace> findByEmail(String email, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "findByEmail";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                email,
                
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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (email == null) {
                    query.append("email LIKE null");
                } else {
                    query.append("email LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("issuingplacename ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (email != null) {
                    qPos.add(email);
                }

                List<PmlEdmIssuingPlace> list = (List<PmlEdmIssuingPlace>) QueryUtil.list(q,
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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public PmlEdmIssuingPlace findByEmail_First(String email,
        OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        List<PmlEdmIssuingPlace> list = findByEmail(email, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmIssuingPlace exists with the key {");

            msg.append("email=" + email);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmIssuingPlaceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmIssuingPlace findByEmail_Last(String email,
        OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        int count = countByEmail(email);

        List<PmlEdmIssuingPlace> list = findByEmail(email, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmIssuingPlace exists with the key {");

            msg.append("email=" + email);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmIssuingPlaceException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmIssuingPlace[] findByEmail_PrevAndNext(String issuingPlaceId,
        String email, OrderByComparator obc)
        throws NoSuchPmlEdmIssuingPlaceException, SystemException {
        PmlEdmIssuingPlace pmlEdmIssuingPlace = findByPrimaryKey(issuingPlaceId);

        int count = countByEmail(email);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

            if (email == null) {
                query.append("email LIKE null");
            } else {
                query.append("email LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("issuingplacename ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (email != null) {
                qPos.add(email);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmIssuingPlace);

            PmlEdmIssuingPlace[] array = new PmlEdmIssuingPlaceImpl[3];

            array[0] = (PmlEdmIssuingPlace) objArray[0];
            array[1] = (PmlEdmIssuingPlace) objArray[1];
            array[2] = (PmlEdmIssuingPlace) objArray[2];

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

    public List<PmlEdmIssuingPlace> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmIssuingPlace> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmIssuingPlace> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("issuingplacename ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmIssuingPlace> list = (List<PmlEdmIssuingPlace>) QueryUtil.list(q,
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
            return (List<PmlEdmIssuingPlace>) result;
        }
    }

    public void removeByIssuingPlaceCode(String issuingPlaceCode)
        throws SystemException {
        for (PmlEdmIssuingPlace pmlEdmIssuingPlace : findByIssuingPlaceCode(
                issuingPlaceCode)) {
            remove(pmlEdmIssuingPlace);
        }
    }

    public void removeByIssuingPlaceName(String issuingPlaceName)
        throws SystemException {
        for (PmlEdmIssuingPlace pmlEdmIssuingPlace : findByIssuingPlaceName(
                issuingPlaceName)) {
            remove(pmlEdmIssuingPlace);
        }
    }

    public void removeByTablePhone(String tablePhone) throws SystemException {
        for (PmlEdmIssuingPlace pmlEdmIssuingPlace : findByTablePhone(
                tablePhone)) {
            remove(pmlEdmIssuingPlace);
        }
    }

    public void removeByHandPhone(String handPhone) throws SystemException {
        for (PmlEdmIssuingPlace pmlEdmIssuingPlace : findByHandPhone(handPhone)) {
            remove(pmlEdmIssuingPlace);
        }
    }

    public void removeByAddress(String address) throws SystemException {
        for (PmlEdmIssuingPlace pmlEdmIssuingPlace : findByAddress(address)) {
            remove(pmlEdmIssuingPlace);
        }
    }

    public void removeByEmail(String email) throws SystemException {
        for (PmlEdmIssuingPlace pmlEdmIssuingPlace : findByEmail(email)) {
            remove(pmlEdmIssuingPlace);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmIssuingPlace pmlEdmIssuingPlace : findAll()) {
            remove(pmlEdmIssuingPlace);
        }
    }

    public int countByIssuingPlaceCode(String issuingPlaceCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "countByIssuingPlaceCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { issuingPlaceCode };

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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (issuingPlaceCode == null) {
                    query.append("issuingplacecode LIKE null");
                } else {
                    query.append("issuingplacecode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceCode != null) {
                    qPos.add(issuingPlaceCode);
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

    public int countByIssuingPlaceName(String issuingPlaceName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "countByIssuingPlaceName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { issuingPlaceName };

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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (issuingPlaceName == null) {
                    query.append("issuingplacename LIKE null");
                } else {
                    query.append("issuingplacename LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (issuingPlaceName != null) {
                    qPos.add(issuingPlaceName);
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

    public int countByTablePhone(String tablePhone) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "countByTablePhone";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { tablePhone };

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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (tablePhone == null) {
                    query.append("tablephone LIKE null");
                } else {
                    query.append("tablephone LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (tablePhone != null) {
                    qPos.add(tablePhone);
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

    public int countByHandPhone(String handPhone) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "countByHandPhone";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { handPhone };

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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (handPhone == null) {
                    query.append("handphone LIKE null");
                } else {
                    query.append("handphone LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (handPhone != null) {
                    qPos.add(handPhone);
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

    public int countByAddress(String address) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "countByAddress";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { address };

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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (address == null) {
                    query.append("address LIKE null");
                } else {
                    query.append("address LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (address != null) {
                    qPos.add(address);
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

    public int countByEmail(String email) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
        String finderMethodName = "countByEmail";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { email };

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
                    "FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace WHERE ");

                if (email == null) {
                    query.append("email LIKE null");
                } else {
                    query.append("email LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (email != null) {
                    qPos.add(email);
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
        boolean finderClassNameCacheEnabled = PmlEdmIssuingPlaceModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmIssuingPlace.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace");

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
                        "value.object.listener.com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace")));

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
