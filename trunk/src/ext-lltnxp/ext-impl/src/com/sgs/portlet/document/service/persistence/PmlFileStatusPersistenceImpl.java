package com.sgs.portlet.document.service.persistence;

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

import com.sgs.portlet.document.NoSuchPmlFileStatusException;
import com.sgs.portlet.document.model.PmlFileStatus;
import com.sgs.portlet.document.model.impl.PmlFileStatusImpl;
import com.sgs.portlet.document.model.impl.PmlFileStatusModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlFileStatusPersistenceImpl extends BasePersistenceImpl
    implements PmlFileStatusPersistence {
    private static Log _log = LogFactory.getLog(PmlFileStatusPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlFileStatus create(long fileStatusId) {
        PmlFileStatus pmlFileStatus = new PmlFileStatusImpl();

        pmlFileStatus.setNew(true);
        pmlFileStatus.setPrimaryKey(fileStatusId);

        return pmlFileStatus;
    }

    public PmlFileStatus remove(long fileStatusId)
        throws NoSuchPmlFileStatusException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileStatus pmlFileStatus = (PmlFileStatus) session.get(PmlFileStatusImpl.class,
                    new Long(fileStatusId));

            if (pmlFileStatus == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlFileStatus exists with the primary key " +
                        fileStatusId);
                }

                throw new NoSuchPmlFileStatusException(
                    "No PmlFileStatus exists with the primary key " +
                    fileStatusId);
            }

            return remove(pmlFileStatus);
        } catch (NoSuchPmlFileStatusException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileStatus remove(PmlFileStatus pmlFileStatus)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlFileStatus);
            }
        }

        pmlFileStatus = removeImpl(pmlFileStatus);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlFileStatus);
            }
        }

        return pmlFileStatus;
    }

    protected PmlFileStatus removeImpl(PmlFileStatus pmlFileStatus)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlFileStatus);

            session.flush();

            return pmlFileStatus;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileStatus.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlFileStatus pmlFileStatus, boolean merge)</code>.
     */
    public PmlFileStatus update(PmlFileStatus pmlFileStatus)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileStatus pmlFileStatus) method. Use update(PmlFileStatus pmlFileStatus, boolean merge) instead.");
        }

        return update(pmlFileStatus, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileStatus the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileStatus is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileStatus update(PmlFileStatus pmlFileStatus, boolean merge)
        throws SystemException {
        boolean isNew = pmlFileStatus.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlFileStatus);
                } else {
                    listener.onBeforeUpdate(pmlFileStatus);
                }
            }
        }

        pmlFileStatus = updateImpl(pmlFileStatus, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlFileStatus);
                } else {
                    listener.onAfterUpdate(pmlFileStatus);
                }
            }
        }

        return pmlFileStatus;
    }

    public PmlFileStatus updateImpl(
        com.sgs.portlet.document.model.PmlFileStatus pmlFileStatus,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlFileStatus);
            } else {
                if (pmlFileStatus.isNew()) {
                    session.save(pmlFileStatus);
                }
            }

            session.flush();

            pmlFileStatus.setNew(false);

            return pmlFileStatus;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileStatus.class.getName());
        }
    }

    public PmlFileStatus findByPrimaryKey(long fileStatusId)
        throws NoSuchPmlFileStatusException, SystemException {
        PmlFileStatus pmlFileStatus = fetchByPrimaryKey(fileStatusId);

        if (pmlFileStatus == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlFileStatus exists with the primary key " +
                    fileStatusId);
            }

            throw new NoSuchPmlFileStatusException(
                "No PmlFileStatus exists with the primary key " + fileStatusId);
        }

        return pmlFileStatus;
    }

    public PmlFileStatus fetchByPrimaryKey(long fileStatusId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlFileStatus) session.get(PmlFileStatusImpl.class,
                new Long(fileStatusId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileStatus> findByFileStatusCode(String fileStatusCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "findByFileStatusCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileStatusCode };

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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (fileStatusCode == null) {
                    query.append("filestatuscode LIKE null");
                } else {
                    query.append("filestatuscode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filestatusid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusCode != null) {
                    qPos.add(fileStatusCode);
                }

                List<PmlFileStatus> list = q.list();

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
            return (List<PmlFileStatus>) result;
        }
    }

    public List<PmlFileStatus> findByFileStatusCode(String fileStatusCode,
        int start, int end) throws SystemException {
        return findByFileStatusCode(fileStatusCode, start, end, null);
    }

    public List<PmlFileStatus> findByFileStatusCode(String fileStatusCode,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "findByFileStatusCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileStatusCode,
                
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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (fileStatusCode == null) {
                    query.append("filestatuscode LIKE null");
                } else {
                    query.append("filestatuscode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filestatusid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusCode != null) {
                    qPos.add(fileStatusCode);
                }

                List<PmlFileStatus> list = (List<PmlFileStatus>) QueryUtil.list(q,
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
            return (List<PmlFileStatus>) result;
        }
    }

    public PmlFileStatus findByFileStatusCode_First(String fileStatusCode,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        List<PmlFileStatus> list = findByFileStatusCode(fileStatusCode, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("fileStatusCode=" + fileStatusCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus findByFileStatusCode_Last(String fileStatusCode,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        int count = countByFileStatusCode(fileStatusCode);

        List<PmlFileStatus> list = findByFileStatusCode(fileStatusCode,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("fileStatusCode=" + fileStatusCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus[] findByFileStatusCode_PrevAndNext(long fileStatusId,
        String fileStatusCode, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        PmlFileStatus pmlFileStatus = findByPrimaryKey(fileStatusId);

        int count = countByFileStatusCode(fileStatusCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

            if (fileStatusCode == null) {
                query.append("filestatuscode LIKE null");
            } else {
                query.append("filestatuscode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filestatusid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileStatusCode != null) {
                qPos.add(fileStatusCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatus);

            PmlFileStatus[] array = new PmlFileStatusImpl[3];

            array[0] = (PmlFileStatus) objArray[0];
            array[1] = (PmlFileStatus) objArray[1];
            array[2] = (PmlFileStatus) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileStatus> findByFileStatusName(String fileStatusName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "findByFileStatusName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileStatusName };

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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (fileStatusName == null) {
                    query.append("filestatusname LIKE null");
                } else {
                    query.append("filestatusname LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filestatusid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusName != null) {
                    qPos.add(fileStatusName);
                }

                List<PmlFileStatus> list = q.list();

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
            return (List<PmlFileStatus>) result;
        }
    }

    public List<PmlFileStatus> findByFileStatusName(String fileStatusName,
        int start, int end) throws SystemException {
        return findByFileStatusName(fileStatusName, start, end, null);
    }

    public List<PmlFileStatus> findByFileStatusName(String fileStatusName,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "findByFileStatusName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileStatusName,
                
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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (fileStatusName == null) {
                    query.append("filestatusname LIKE null");
                } else {
                    query.append("filestatusname LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filestatusid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusName != null) {
                    qPos.add(fileStatusName);
                }

                List<PmlFileStatus> list = (List<PmlFileStatus>) QueryUtil.list(q,
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
            return (List<PmlFileStatus>) result;
        }
    }

    public PmlFileStatus findByFileStatusName_First(String fileStatusName,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        List<PmlFileStatus> list = findByFileStatusName(fileStatusName, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("fileStatusName=" + fileStatusName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus findByFileStatusName_Last(String fileStatusName,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        int count = countByFileStatusName(fileStatusName);

        List<PmlFileStatus> list = findByFileStatusName(fileStatusName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("fileStatusName=" + fileStatusName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus[] findByFileStatusName_PrevAndNext(long fileStatusId,
        String fileStatusName, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        PmlFileStatus pmlFileStatus = findByPrimaryKey(fileStatusId);

        int count = countByFileStatusName(fileStatusName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

            if (fileStatusName == null) {
                query.append("filestatusname LIKE null");
            } else {
                query.append("filestatusname LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filestatusid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileStatusName != null) {
                qPos.add(fileStatusName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatus);

            PmlFileStatus[] array = new PmlFileStatusImpl[3];

            array[0] = (PmlFileStatus) objArray[0];
            array[1] = (PmlFileStatus) objArray[1];
            array[2] = (PmlFileStatus) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileStatus> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "findByDescription";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { description };

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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filestatusid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<PmlFileStatus> list = q.list();

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
            return (List<PmlFileStatus>) result;
        }
    }

    public List<PmlFileStatus> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<PmlFileStatus> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "findByDescription";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                description,
                
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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filestatusid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<PmlFileStatus> list = (List<PmlFileStatus>) QueryUtil.list(q,
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
            return (List<PmlFileStatus>) result;
        }
    }

    public PmlFileStatus findByDescription_First(String description,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        List<PmlFileStatus> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus findByDescription_Last(String description,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        int count = countByDescription(description);

        List<PmlFileStatus> list = findByDescription(description, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus[] findByDescription_PrevAndNext(long fileStatusId,
        String description, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        PmlFileStatus pmlFileStatus = findByPrimaryKey(fileStatusId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

            if (description == null) {
                query.append("description LIKE null");
            } else {
                query.append("description LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filestatusid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatus);

            PmlFileStatus[] array = new PmlFileStatusImpl[3];

            array[0] = (PmlFileStatus) objArray[0];
            array[1] = (PmlFileStatus) objArray[1];
            array[2] = (PmlFileStatus) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileStatus> findByType(String type)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "findByType";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { type };

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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (type == null) {
                    query.append("type IS NULL");
                } else {
                    query.append("type = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filestatusid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (type != null) {
                    qPos.add(type);
                }

                List<PmlFileStatus> list = q.list();

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
            return (List<PmlFileStatus>) result;
        }
    }

    public List<PmlFileStatus> findByType(String type, int start, int end)
        throws SystemException {
        return findByType(type, start, end, null);
    }

    public List<PmlFileStatus> findByType(String type, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "findByType";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                type,
                
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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (type == null) {
                    query.append("type IS NULL");
                } else {
                    query.append("type = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filestatusid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (type != null) {
                    qPos.add(type);
                }

                List<PmlFileStatus> list = (List<PmlFileStatus>) QueryUtil.list(q,
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
            return (List<PmlFileStatus>) result;
        }
    }

    public PmlFileStatus findByType_First(String type, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        List<PmlFileStatus> list = findByType(type, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus findByType_Last(String type, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        int count = countByType(type);

        List<PmlFileStatus> list = findByType(type, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus[] findByType_PrevAndNext(long fileStatusId,
        String type, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        PmlFileStatus pmlFileStatus = findByPrimaryKey(fileStatusId);

        int count = countByType(type);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

            if (type == null) {
                query.append("type IS NULL");
            } else {
                query.append("type = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filestatusid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (type != null) {
                qPos.add(type);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatus);

            PmlFileStatus[] array = new PmlFileStatusImpl[3];

            array[0] = (PmlFileStatus) objArray[0];
            array[1] = (PmlFileStatus) objArray[1];
            array[2] = (PmlFileStatus) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileStatus> findByFileStatusCode_Type(
        String fileStatusCode, String type) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "findByFileStatusCode_Type";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { fileStatusCode, type };

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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (fileStatusCode == null) {
                    query.append("filestatuscode IS NULL");
                } else {
                    query.append("lower(filestatuscode) = ?");
                }

                query.append(" AND ");

                if (type == null) {
                    query.append("type IS NULL");
                } else {
                    query.append("type = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filestatusid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusCode != null) {
                    qPos.add(fileStatusCode);
                }

                if (type != null) {
                    qPos.add(type);
                }

                List<PmlFileStatus> list = q.list();

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
            return (List<PmlFileStatus>) result;
        }
    }

    public List<PmlFileStatus> findByFileStatusCode_Type(
        String fileStatusCode, String type, int start, int end)
        throws SystemException {
        return findByFileStatusCode_Type(fileStatusCode, type, start, end, null);
    }

    public List<PmlFileStatus> findByFileStatusCode_Type(
        String fileStatusCode, String type, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "findByFileStatusCode_Type";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileStatusCode,
                
                type,
                
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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (fileStatusCode == null) {
                    query.append("filestatuscode IS NULL");
                } else {
                    query.append("lower(filestatuscode) = ?");
                }

                query.append(" AND ");

                if (type == null) {
                    query.append("type IS NULL");
                } else {
                    query.append("type = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filestatusid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusCode != null) {
                    qPos.add(fileStatusCode);
                }

                if (type != null) {
                    qPos.add(type);
                }

                List<PmlFileStatus> list = (List<PmlFileStatus>) QueryUtil.list(q,
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
            return (List<PmlFileStatus>) result;
        }
    }

    public PmlFileStatus findByFileStatusCode_Type_First(
        String fileStatusCode, String type, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        List<PmlFileStatus> list = findByFileStatusCode_Type(fileStatusCode,
                type, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("fileStatusCode=" + fileStatusCode);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus findByFileStatusCode_Type_Last(String fileStatusCode,
        String type, OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        int count = countByFileStatusCode_Type(fileStatusCode, type);

        List<PmlFileStatus> list = findByFileStatusCode_Type(fileStatusCode,
                type, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileStatus exists with the key {");

            msg.append("fileStatusCode=" + fileStatusCode);

            msg.append(", ");
            msg.append("type=" + type);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileStatusException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileStatus[] findByFileStatusCode_Type_PrevAndNext(
        long fileStatusId, String fileStatusCode, String type,
        OrderByComparator obc)
        throws NoSuchPmlFileStatusException, SystemException {
        PmlFileStatus pmlFileStatus = findByPrimaryKey(fileStatusId);

        int count = countByFileStatusCode_Type(fileStatusCode, type);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

            if (fileStatusCode == null) {
                query.append("filestatuscode IS NULL");
            } else {
                query.append("lower(filestatuscode) = ?");
            }

            query.append(" AND ");

            if (type == null) {
                query.append("type IS NULL");
            } else {
                query.append("type = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filestatusid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileStatusCode != null) {
                qPos.add(fileStatusCode);
            }

            if (type != null) {
                qPos.add(type);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileStatus);

            PmlFileStatus[] array = new PmlFileStatusImpl[3];

            array[0] = (PmlFileStatus) objArray[0];
            array[1] = (PmlFileStatus) objArray[1];
            array[2] = (PmlFileStatus) objArray[2];

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

    public List<PmlFileStatus> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileStatus> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileStatus> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filestatusid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlFileStatus> list = (List<PmlFileStatus>) QueryUtil.list(q,
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
            return (List<PmlFileStatus>) result;
        }
    }

    public void removeByFileStatusCode(String fileStatusCode)
        throws SystemException {
        for (PmlFileStatus pmlFileStatus : findByFileStatusCode(fileStatusCode)) {
            remove(pmlFileStatus);
        }
    }

    public void removeByFileStatusName(String fileStatusName)
        throws SystemException {
        for (PmlFileStatus pmlFileStatus : findByFileStatusName(fileStatusName)) {
            remove(pmlFileStatus);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (PmlFileStatus pmlFileStatus : findByDescription(description)) {
            remove(pmlFileStatus);
        }
    }

    public void removeByType(String type) throws SystemException {
        for (PmlFileStatus pmlFileStatus : findByType(type)) {
            remove(pmlFileStatus);
        }
    }

    public void removeByFileStatusCode_Type(String fileStatusCode, String type)
        throws SystemException {
        for (PmlFileStatus pmlFileStatus : findByFileStatusCode_Type(
                fileStatusCode, type)) {
            remove(pmlFileStatus);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFileStatus pmlFileStatus : findAll()) {
            remove(pmlFileStatus);
        }
    }

    public int countByFileStatusCode(String fileStatusCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "countByFileStatusCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileStatusCode };

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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (fileStatusCode == null) {
                    query.append("filestatuscode LIKE null");
                } else {
                    query.append("filestatuscode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusCode != null) {
                    qPos.add(fileStatusCode);
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

    public int countByFileStatusName(String fileStatusName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "countByFileStatusName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileStatusName };

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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (fileStatusName == null) {
                    query.append("filestatusname LIKE null");
                } else {
                    query.append("filestatusname LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusName != null) {
                    qPos.add(fileStatusName);
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

    public int countByDescription(String description) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "countByDescription";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { description };

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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
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

    public int countByType(String type) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "countByType";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { type };

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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (type == null) {
                    query.append("type IS NULL");
                } else {
                    query.append("type = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (type != null) {
                    qPos.add(type);
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

    public int countByFileStatusCode_Type(String fileStatusCode, String type)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
        String finderMethodName = "countByFileStatusCode_Type";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { fileStatusCode, type };

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
                    "FROM com.sgs.portlet.document.model.PmlFileStatus WHERE ");

                if (fileStatusCode == null) {
                    query.append("filestatuscode IS NULL");
                } else {
                    query.append("lower(filestatuscode) = ?");
                }

                query.append(" AND ");

                if (type == null) {
                    query.append("type IS NULL");
                } else {
                    query.append("type = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileStatusCode != null) {
                    qPos.add(fileStatusCode);
                }

                if (type != null) {
                    qPos.add(type);
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
        boolean finderClassNameCacheEnabled = PmlFileStatusModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileStatus.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.model.PmlFileStatus");

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
                        "value.object.listener.com.sgs.portlet.document.model.PmlFileStatus")));

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
