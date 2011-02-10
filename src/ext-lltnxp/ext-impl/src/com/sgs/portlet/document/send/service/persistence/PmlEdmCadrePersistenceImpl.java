package com.sgs.portlet.document.send.service.persistence;

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

import com.sgs.portlet.document.send.NoSuchPmlEdmCadreException;
import com.sgs.portlet.document.send.model.PmlEdmCadre;
import com.sgs.portlet.document.send.model.impl.PmlEdmCadreImpl;
import com.sgs.portlet.document.send.model.impl.PmlEdmCadreModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmCadrePersistenceImpl extends BasePersistenceImpl
    implements PmlEdmCadrePersistence {
    private static Log _log = LogFactory.getLog(PmlEdmCadrePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmCadre create(long userId) {
        PmlEdmCadre pmlEdmCadre = new PmlEdmCadreImpl();

        pmlEdmCadre.setNew(true);
        pmlEdmCadre.setPrimaryKey(userId);

        return pmlEdmCadre;
    }

    public PmlEdmCadre remove(long userId)
        throws NoSuchPmlEdmCadreException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmCadre pmlEdmCadre = (PmlEdmCadre) session.get(PmlEdmCadreImpl.class,
                    new Long(userId));

            if (pmlEdmCadre == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlEdmCadre exists with the primary key " +
                        userId);
                }

                throw new NoSuchPmlEdmCadreException(
                    "No PmlEdmCadre exists with the primary key " + userId);
            }

            return remove(pmlEdmCadre);
        } catch (NoSuchPmlEdmCadreException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmCadre remove(PmlEdmCadre pmlEdmCadre)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmCadre);
            }
        }

        pmlEdmCadre = removeImpl(pmlEdmCadre);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmCadre);
            }
        }

        return pmlEdmCadre;
    }

    protected PmlEdmCadre removeImpl(PmlEdmCadre pmlEdmCadre)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmCadre);

            session.flush();

            return pmlEdmCadre;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmCadre.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmCadre pmlEdmCadre, boolean merge)</code>.
     */
    public PmlEdmCadre update(PmlEdmCadre pmlEdmCadre)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmCadre pmlEdmCadre) method. Use update(PmlEdmCadre pmlEdmCadre, boolean merge) instead.");
        }

        return update(pmlEdmCadre, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmCadre the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmCadre is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmCadre update(PmlEdmCadre pmlEdmCadre, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmCadre.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmCadre);
                } else {
                    listener.onBeforeUpdate(pmlEdmCadre);
                }
            }
        }

        pmlEdmCadre = updateImpl(pmlEdmCadre, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmCadre);
                } else {
                    listener.onAfterUpdate(pmlEdmCadre);
                }
            }
        }

        return pmlEdmCadre;
    }

    public PmlEdmCadre updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmCadre);
            } else {
                if (pmlEdmCadre.isNew()) {
                    session.save(pmlEdmCadre);
                }
            }

            session.flush();

            pmlEdmCadre.setNew(false);

            return pmlEdmCadre;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmCadre.class.getName());
        }
    }

    public PmlEdmCadre findByPrimaryKey(long userId)
        throws NoSuchPmlEdmCadreException, SystemException {
        PmlEdmCadre pmlEdmCadre = fetchByPrimaryKey(userId);

        if (pmlEdmCadre == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlEdmCadre exists with the primary key " +
                    userId);
            }

            throw new NoSuchPmlEdmCadreException(
                "No PmlEdmCadre exists with the primary key " + userId);
        }

        return pmlEdmCadre;
    }

    public PmlEdmCadre fetchByPrimaryKey(long userId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmCadre) session.get(PmlEdmCadreImpl.class,
                new Long(userId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmCadre> findByPositionId(String positionId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmCadreModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmCadre.class.getName();
        String finderMethodName = "findByPositionId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { positionId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmCadre WHERE ");

                if (positionId == null) {
                    query.append("positionid LIKE null");
                } else {
                    query.append("positionid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("userid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionId != null) {
                    qPos.add(positionId);
                }

                List<PmlEdmCadre> list = q.list();

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
            return (List<PmlEdmCadre>) result;
        }
    }

    public List<PmlEdmCadre> findByPositionId(String positionId, int start,
        int end) throws SystemException {
        return findByPositionId(positionId, start, end, null);
    }

    public List<PmlEdmCadre> findByPositionId(String positionId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmCadreModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmCadre.class.getName();
        String finderMethodName = "findByPositionId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                positionId,
                
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmCadre WHERE ");

                if (positionId == null) {
                    query.append("positionid LIKE null");
                } else {
                    query.append("positionid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("userid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionId != null) {
                    qPos.add(positionId);
                }

                List<PmlEdmCadre> list = (List<PmlEdmCadre>) QueryUtil.list(q,
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
            return (List<PmlEdmCadre>) result;
        }
    }

    public PmlEdmCadre findByPositionId_First(String positionId,
        OrderByComparator obc)
        throws NoSuchPmlEdmCadreException, SystemException {
        List<PmlEdmCadre> list = findByPositionId(positionId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmCadre exists with the key {");

            msg.append("positionId=" + positionId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmCadreException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmCadre findByPositionId_Last(String positionId,
        OrderByComparator obc)
        throws NoSuchPmlEdmCadreException, SystemException {
        int count = countByPositionId(positionId);

        List<PmlEdmCadre> list = findByPositionId(positionId, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmCadre exists with the key {");

            msg.append("positionId=" + positionId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmCadreException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmCadre[] findByPositionId_PrevAndNext(long userId,
        String positionId, OrderByComparator obc)
        throws NoSuchPmlEdmCadreException, SystemException {
        PmlEdmCadre pmlEdmCadre = findByPrimaryKey(userId);

        int count = countByPositionId(positionId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmCadre WHERE ");

            if (positionId == null) {
                query.append("positionid LIKE null");
            } else {
                query.append("positionid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("userid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (positionId != null) {
                qPos.add(positionId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmCadre);

            PmlEdmCadre[] array = new PmlEdmCadreImpl[3];

            array[0] = (PmlEdmCadre) objArray[0];
            array[1] = (PmlEdmCadre) objArray[1];
            array[2] = (PmlEdmCadre) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmCadre> findByDepartmentsId(String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmCadreModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmCadre.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmCadre WHERE ");

                if (departmentsId == null) {
                    query.append("departmentsid LIKE null");
                } else {
                    query.append("departmentsid LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("userid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlEdmCadre> list = q.list();

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
            return (List<PmlEdmCadre>) result;
        }
    }

    public List<PmlEdmCadre> findByDepartmentsId(String departmentsId,
        int start, int end) throws SystemException {
        return findByDepartmentsId(departmentsId, start, end, null);
    }

    public List<PmlEdmCadre> findByDepartmentsId(String departmentsId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmCadreModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmCadre.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmCadre WHERE ");

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

                    query.append("userid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (departmentsId != null) {
                    qPos.add(departmentsId);
                }

                List<PmlEdmCadre> list = (List<PmlEdmCadre>) QueryUtil.list(q,
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
            return (List<PmlEdmCadre>) result;
        }
    }

    public PmlEdmCadre findByDepartmentsId_First(String departmentsId,
        OrderByComparator obc)
        throws NoSuchPmlEdmCadreException, SystemException {
        List<PmlEdmCadre> list = findByDepartmentsId(departmentsId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmCadre exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmCadreException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmCadre findByDepartmentsId_Last(String departmentsId,
        OrderByComparator obc)
        throws NoSuchPmlEdmCadreException, SystemException {
        int count = countByDepartmentsId(departmentsId);

        List<PmlEdmCadre> list = findByDepartmentsId(departmentsId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmCadre exists with the key {");

            msg.append("departmentsId=" + departmentsId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmCadreException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmCadre[] findByDepartmentsId_PrevAndNext(long userId,
        String departmentsId, OrderByComparator obc)
        throws NoSuchPmlEdmCadreException, SystemException {
        PmlEdmCadre pmlEdmCadre = findByPrimaryKey(userId);

        int count = countByDepartmentsId(departmentsId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmCadre WHERE ");

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

                query.append("userid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (departmentsId != null) {
                qPos.add(departmentsId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmCadre);

            PmlEdmCadre[] array = new PmlEdmCadreImpl[3];

            array[0] = (PmlEdmCadre) objArray[0];
            array[1] = (PmlEdmCadre) objArray[1];
            array[2] = (PmlEdmCadre) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmCadre> findByHandPhone(String handPhone)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmCadreModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmCadre.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmCadre WHERE ");

                if (handPhone == null) {
                    query.append("handphone LIKE null");
                } else {
                    query.append("handphone LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("userid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (handPhone != null) {
                    qPos.add(handPhone);
                }

                List<PmlEdmCadre> list = q.list();

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
            return (List<PmlEdmCadre>) result;
        }
    }

    public List<PmlEdmCadre> findByHandPhone(String handPhone, int start,
        int end) throws SystemException {
        return findByHandPhone(handPhone, start, end, null);
    }

    public List<PmlEdmCadre> findByHandPhone(String handPhone, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmCadreModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmCadre.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmCadre WHERE ");

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

                    query.append("userid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (handPhone != null) {
                    qPos.add(handPhone);
                }

                List<PmlEdmCadre> list = (List<PmlEdmCadre>) QueryUtil.list(q,
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
            return (List<PmlEdmCadre>) result;
        }
    }

    public PmlEdmCadre findByHandPhone_First(String handPhone,
        OrderByComparator obc)
        throws NoSuchPmlEdmCadreException, SystemException {
        List<PmlEdmCadre> list = findByHandPhone(handPhone, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmCadre exists with the key {");

            msg.append("handPhone=" + handPhone);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmCadreException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmCadre findByHandPhone_Last(String handPhone,
        OrderByComparator obc)
        throws NoSuchPmlEdmCadreException, SystemException {
        int count = countByHandPhone(handPhone);

        List<PmlEdmCadre> list = findByHandPhone(handPhone, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmCadre exists with the key {");

            msg.append("handPhone=" + handPhone);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmCadreException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmCadre[] findByHandPhone_PrevAndNext(long userId,
        String handPhone, OrderByComparator obc)
        throws NoSuchPmlEdmCadreException, SystemException {
        PmlEdmCadre pmlEdmCadre = findByPrimaryKey(userId);

        int count = countByHandPhone(handPhone);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.send.model.PmlEdmCadre WHERE ");

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

                query.append("userid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (handPhone != null) {
                qPos.add(handPhone);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmCadre);

            PmlEdmCadre[] array = new PmlEdmCadreImpl[3];

            array[0] = (PmlEdmCadre) objArray[0];
            array[1] = (PmlEdmCadre) objArray[1];
            array[2] = (PmlEdmCadre) objArray[2];

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

    public List<PmlEdmCadre> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmCadre> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmCadre> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmCadreModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmCadre.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmCadre ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("userid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmCadre> list = (List<PmlEdmCadre>) QueryUtil.list(q,
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
            return (List<PmlEdmCadre>) result;
        }
    }

    public void removeByPositionId(String positionId) throws SystemException {
        for (PmlEdmCadre pmlEdmCadre : findByPositionId(positionId)) {
            remove(pmlEdmCadre);
        }
    }

    public void removeByDepartmentsId(String departmentsId)
        throws SystemException {
        for (PmlEdmCadre pmlEdmCadre : findByDepartmentsId(departmentsId)) {
            remove(pmlEdmCadre);
        }
    }

    public void removeByHandPhone(String handPhone) throws SystemException {
        for (PmlEdmCadre pmlEdmCadre : findByHandPhone(handPhone)) {
            remove(pmlEdmCadre);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmCadre pmlEdmCadre : findAll()) {
            remove(pmlEdmCadre);
        }
    }

    public int countByPositionId(String positionId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmCadreModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmCadre.class.getName();
        String finderMethodName = "countByPositionId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { positionId };

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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmCadre WHERE ");

                if (positionId == null) {
                    query.append("positionid LIKE null");
                } else {
                    query.append("positionid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (positionId != null) {
                    qPos.add(positionId);
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

    public int countByDepartmentsId(String departmentsId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmCadreModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmCadre.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmCadre WHERE ");

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

    public int countByHandPhone(String handPhone) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmCadreModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmCadre.class.getName();
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
                    "FROM com.sgs.portlet.document.send.model.PmlEdmCadre WHERE ");

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

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmCadreModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmCadre.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.send.model.PmlEdmCadre");

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
                        "value.object.listener.com.sgs.portlet.document.send.model.PmlEdmCadre")));

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
