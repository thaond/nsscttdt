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

import com.sgs.portlet.document.NoSuchPmlStateProcessException;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.model.impl.PmlStateProcessImpl;
import com.sgs.portlet.document.model.impl.PmlStateProcessModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlStateProcessPersistenceImpl extends BasePersistenceImpl
    implements PmlStateProcessPersistence {
    private static Log _log = LogFactory.getLog(PmlStateProcessPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlStateProcess create(long stateProcessId) {
        PmlStateProcess pmlStateProcess = new PmlStateProcessImpl();

        pmlStateProcess.setNew(true);
        pmlStateProcess.setPrimaryKey(stateProcessId);

        return pmlStateProcess;
    }

    public PmlStateProcess remove(long stateProcessId)
        throws NoSuchPmlStateProcessException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlStateProcess pmlStateProcess = (PmlStateProcess) session.get(PmlStateProcessImpl.class,
                    new Long(stateProcessId));

            if (pmlStateProcess == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlStateProcess exists with the primary key " +
                        stateProcessId);
                }

                throw new NoSuchPmlStateProcessException(
                    "No PmlStateProcess exists with the primary key " +
                    stateProcessId);
            }

            return remove(pmlStateProcess);
        } catch (NoSuchPmlStateProcessException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlStateProcess remove(PmlStateProcess pmlStateProcess)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlStateProcess);
            }
        }

        pmlStateProcess = removeImpl(pmlStateProcess);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlStateProcess);
            }
        }

        return pmlStateProcess;
    }

    protected PmlStateProcess removeImpl(PmlStateProcess pmlStateProcess)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlStateProcess);

            session.flush();

            return pmlStateProcess;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlStateProcess.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlStateProcess pmlStateProcess, boolean merge)</code>.
     */
    public PmlStateProcess update(PmlStateProcess pmlStateProcess)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlStateProcess pmlStateProcess) method. Use update(PmlStateProcess pmlStateProcess, boolean merge) instead.");
        }

        return update(pmlStateProcess, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlStateProcess the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlStateProcess is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlStateProcess update(PmlStateProcess pmlStateProcess, boolean merge)
        throws SystemException {
        boolean isNew = pmlStateProcess.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlStateProcess);
                } else {
                    listener.onBeforeUpdate(pmlStateProcess);
                }
            }
        }

        pmlStateProcess = updateImpl(pmlStateProcess, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlStateProcess);
                } else {
                    listener.onAfterUpdate(pmlStateProcess);
                }
            }
        }

        return pmlStateProcess;
    }

    public PmlStateProcess updateImpl(
        com.sgs.portlet.document.model.PmlStateProcess pmlStateProcess,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlStateProcess);
            } else {
                if (pmlStateProcess.isNew()) {
                    session.save(pmlStateProcess);
                }
            }

            session.flush();

            pmlStateProcess.setNew(false);

            return pmlStateProcess;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlStateProcess.class.getName());
        }
    }

    public PmlStateProcess findByPrimaryKey(long stateProcessId)
        throws NoSuchPmlStateProcessException, SystemException {
        PmlStateProcess pmlStateProcess = fetchByPrimaryKey(stateProcessId);

        if (pmlStateProcess == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlStateProcess exists with the primary key " +
                    stateProcessId);
            }

            throw new NoSuchPmlStateProcessException(
                "No PmlStateProcess exists with the primary key " +
                stateProcessId);
        }

        return pmlStateProcess;
    }

    public PmlStateProcess fetchByPrimaryKey(long stateProcessId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlStateProcess) session.get(PmlStateProcessImpl.class,
                new Long(stateProcessId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateProcess> findByStateProcessCode(String stateProcessCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
        String finderMethodName = "findByStateProcessCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { stateProcessCode };

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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                if (stateProcessCode == null) {
                    query.append("stateprocesscode LIKE null");
                } else {
                    query.append("stateprocesscode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("stateprocessid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessCode != null) {
                    qPos.add(stateProcessCode);
                }

                List<PmlStateProcess> list = q.list();

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
            return (List<PmlStateProcess>) result;
        }
    }

    public List<PmlStateProcess> findByStateProcessCode(
        String stateProcessCode, int start, int end) throws SystemException {
        return findByStateProcessCode(stateProcessCode, start, end, null);
    }

    public List<PmlStateProcess> findByStateProcessCode(
        String stateProcessCode, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
        String finderMethodName = "findByStateProcessCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                stateProcessCode,
                
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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                if (stateProcessCode == null) {
                    query.append("stateprocesscode LIKE null");
                } else {
                    query.append("stateprocesscode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("stateprocessid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessCode != null) {
                    qPos.add(stateProcessCode);
                }

                List<PmlStateProcess> list = (List<PmlStateProcess>) QueryUtil.list(q,
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
            return (List<PmlStateProcess>) result;
        }
    }

    public PmlStateProcess findByStateProcessCode_First(
        String stateProcessCode, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        List<PmlStateProcess> list = findByStateProcessCode(stateProcessCode,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("stateProcessCode=" + stateProcessCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess findByStateProcessCode_Last(
        String stateProcessCode, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        int count = countByStateProcessCode(stateProcessCode);

        List<PmlStateProcess> list = findByStateProcessCode(stateProcessCode,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("stateProcessCode=" + stateProcessCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess[] findByStateProcessCode_PrevAndNext(
        long stateProcessId, String stateProcessCode, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        PmlStateProcess pmlStateProcess = findByPrimaryKey(stateProcessId);

        int count = countByStateProcessCode(stateProcessCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

            if (stateProcessCode == null) {
                query.append("stateprocesscode LIKE null");
            } else {
                query.append("stateprocesscode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("stateprocessid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (stateProcessCode != null) {
                qPos.add(stateProcessCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateProcess);

            PmlStateProcess[] array = new PmlStateProcessImpl[3];

            array[0] = (PmlStateProcess) objArray[0];
            array[1] = (PmlStateProcess) objArray[1];
            array[2] = (PmlStateProcess) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateProcess> findByStateProcessName(String stateProcessName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
        String finderMethodName = "findByStateProcessName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { stateProcessName };

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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                if (stateProcessName == null) {
                    query.append("stateprocessname LIKE null");
                } else {
                    query.append("stateprocessname LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("stateprocessid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessName != null) {
                    qPos.add(stateProcessName);
                }

                List<PmlStateProcess> list = q.list();

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
            return (List<PmlStateProcess>) result;
        }
    }

    public List<PmlStateProcess> findByStateProcessName(
        String stateProcessName, int start, int end) throws SystemException {
        return findByStateProcessName(stateProcessName, start, end, null);
    }

    public List<PmlStateProcess> findByStateProcessName(
        String stateProcessName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
        String finderMethodName = "findByStateProcessName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                stateProcessName,
                
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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                if (stateProcessName == null) {
                    query.append("stateprocessname LIKE null");
                } else {
                    query.append("stateprocessname LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("stateprocessid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessName != null) {
                    qPos.add(stateProcessName);
                }

                List<PmlStateProcess> list = (List<PmlStateProcess>) QueryUtil.list(q,
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
            return (List<PmlStateProcess>) result;
        }
    }

    public PmlStateProcess findByStateProcessName_First(
        String stateProcessName, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        List<PmlStateProcess> list = findByStateProcessName(stateProcessName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("stateProcessName=" + stateProcessName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess findByStateProcessName_Last(
        String stateProcessName, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        int count = countByStateProcessName(stateProcessName);

        List<PmlStateProcess> list = findByStateProcessName(stateProcessName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("stateProcessName=" + stateProcessName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess[] findByStateProcessName_PrevAndNext(
        long stateProcessId, String stateProcessName, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        PmlStateProcess pmlStateProcess = findByPrimaryKey(stateProcessId);

        int count = countByStateProcessName(stateProcessName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

            if (stateProcessName == null) {
                query.append("stateprocessname LIKE null");
            } else {
                query.append("stateprocessname LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("stateprocessid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (stateProcessName != null) {
                qPos.add(stateProcessName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateProcess);

            PmlStateProcess[] array = new PmlStateProcessImpl[3];

            array[0] = (PmlStateProcess) objArray[0];
            array[1] = (PmlStateProcess) objArray[1];
            array[2] = (PmlStateProcess) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateProcess> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("stateprocessid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<PmlStateProcess> list = q.list();

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
            return (List<PmlStateProcess>) result;
        }
    }

    public List<PmlStateProcess> findByDescription(String description,
        int start, int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<PmlStateProcess> findByDescription(String description,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

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

                    query.append("stateprocessid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<PmlStateProcess> list = (List<PmlStateProcess>) QueryUtil.list(q,
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
            return (List<PmlStateProcess>) result;
        }
    }

    public PmlStateProcess findByDescription_First(String description,
        OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        List<PmlStateProcess> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess findByDescription_Last(String description,
        OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        int count = countByDescription(description);

        List<PmlStateProcess> list = findByDescription(description, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess[] findByDescription_PrevAndNext(
        long stateProcessId, String description, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        PmlStateProcess pmlStateProcess = findByPrimaryKey(stateProcessId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

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

                query.append("stateprocessid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateProcess);

            PmlStateProcess[] array = new PmlStateProcessImpl[3];

            array[0] = (PmlStateProcess) objArray[0];
            array[1] = (PmlStateProcess) objArray[1];
            array[2] = (PmlStateProcess) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateProcess> findByFileStatusId(long fileStatusId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
        String finderMethodName = "findByFileStatusId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(fileStatusId) };

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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("stateprocessid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                List<PmlStateProcess> list = q.list();

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
            return (List<PmlStateProcess>) result;
        }
    }

    public List<PmlStateProcess> findByFileStatusId(long fileStatusId,
        int start, int end) throws SystemException {
        return findByFileStatusId(fileStatusId, start, end, null);
    }

    public List<PmlStateProcess> findByFileStatusId(long fileStatusId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
        String finderMethodName = "findByFileStatusId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(fileStatusId),
                
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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("stateprocessid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

                List<PmlStateProcess> list = (List<PmlStateProcess>) QueryUtil.list(q,
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
            return (List<PmlStateProcess>) result;
        }
    }

    public PmlStateProcess findByFileStatusId_First(long fileStatusId,
        OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        List<PmlStateProcess> list = findByFileStatusId(fileStatusId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("fileStatusId=" + fileStatusId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess findByFileStatusId_Last(long fileStatusId,
        OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        int count = countByFileStatusId(fileStatusId);

        List<PmlStateProcess> list = findByFileStatusId(fileStatusId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("fileStatusId=" + fileStatusId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess[] findByFileStatusId_PrevAndNext(
        long stateProcessId, long fileStatusId, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        PmlStateProcess pmlStateProcess = findByPrimaryKey(stateProcessId);

        int count = countByFileStatusId(fileStatusId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

            query.append("filestatusid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("stateprocessid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(fileStatusId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateProcess);

            PmlStateProcess[] array = new PmlStateProcessImpl[3];

            array[0] = (PmlStateProcess) objArray[0];
            array[1] = (PmlStateProcess) objArray[1];
            array[2] = (PmlStateProcess) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlStateProcess> findByStateProcessCode(
        String stateProcessCode, String stateProcessName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
        String finderMethodName = "findByStateProcessCode";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { stateProcessCode, stateProcessName };

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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                if (stateProcessCode == null) {
                    query.append("stateprocesscode IS NULL");
                } else {
                    query.append("stateprocesscode = ?");
                }

                query.append(" AND ");

                if (stateProcessName == null) {
                    query.append("stateprocessname IS NULL");
                } else {
                    query.append("stateprocessname = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("stateprocessid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessCode != null) {
                    qPos.add(stateProcessCode);
                }

                if (stateProcessName != null) {
                    qPos.add(stateProcessName);
                }

                List<PmlStateProcess> list = q.list();

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
            return (List<PmlStateProcess>) result;
        }
    }

    public List<PmlStateProcess> findByStateProcessCode(
        String stateProcessCode, String stateProcessName, int start, int end)
        throws SystemException {
        return findByStateProcessCode(stateProcessCode, stateProcessName,
            start, end, null);
    }

    public List<PmlStateProcess> findByStateProcessCode(
        String stateProcessCode, String stateProcessName, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
        String finderMethodName = "findByStateProcessCode";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                stateProcessCode,
                
                stateProcessName,
                
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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                if (stateProcessCode == null) {
                    query.append("stateprocesscode IS NULL");
                } else {
                    query.append("stateprocesscode = ?");
                }

                query.append(" AND ");

                if (stateProcessName == null) {
                    query.append("stateprocessname IS NULL");
                } else {
                    query.append("stateprocessname = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("stateprocessid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessCode != null) {
                    qPos.add(stateProcessCode);
                }

                if (stateProcessName != null) {
                    qPos.add(stateProcessName);
                }

                List<PmlStateProcess> list = (List<PmlStateProcess>) QueryUtil.list(q,
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
            return (List<PmlStateProcess>) result;
        }
    }

    public PmlStateProcess findByStateProcessCode_First(
        String stateProcessCode, String stateProcessName, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        List<PmlStateProcess> list = findByStateProcessCode(stateProcessCode,
                stateProcessName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("stateProcessCode=" + stateProcessCode);

            msg.append(", ");
            msg.append("stateProcessName=" + stateProcessName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess findByStateProcessCode_Last(
        String stateProcessCode, String stateProcessName, OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        int count = countByStateProcessCode(stateProcessCode, stateProcessName);

        List<PmlStateProcess> list = findByStateProcessCode(stateProcessCode,
                stateProcessName, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlStateProcess exists with the key {");

            msg.append("stateProcessCode=" + stateProcessCode);

            msg.append(", ");
            msg.append("stateProcessName=" + stateProcessName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlStateProcessException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlStateProcess[] findByStateProcessCode_PrevAndNext(
        long stateProcessId, String stateProcessCode, String stateProcessName,
        OrderByComparator obc)
        throws NoSuchPmlStateProcessException, SystemException {
        PmlStateProcess pmlStateProcess = findByPrimaryKey(stateProcessId);

        int count = countByStateProcessCode(stateProcessCode, stateProcessName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

            if (stateProcessCode == null) {
                query.append("stateprocesscode IS NULL");
            } else {
                query.append("stateprocesscode = ?");
            }

            query.append(" AND ");

            if (stateProcessName == null) {
                query.append("stateprocessname IS NULL");
            } else {
                query.append("stateprocessname = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("stateprocessid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (stateProcessCode != null) {
                qPos.add(stateProcessCode);
            }

            if (stateProcessName != null) {
                qPos.add(stateProcessName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlStateProcess);

            PmlStateProcess[] array = new PmlStateProcessImpl[3];

            array[0] = (PmlStateProcess) objArray[0];
            array[1] = (PmlStateProcess) objArray[1];
            array[2] = (PmlStateProcess) objArray[2];

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

    public List<PmlStateProcess> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlStateProcess> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlStateProcess> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("stateprocessid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlStateProcess> list = (List<PmlStateProcess>) QueryUtil.list(q,
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
            return (List<PmlStateProcess>) result;
        }
    }

    public void removeByStateProcessCode(String stateProcessCode)
        throws SystemException {
        for (PmlStateProcess pmlStateProcess : findByStateProcessCode(
                stateProcessCode)) {
            remove(pmlStateProcess);
        }
    }

    public void removeByStateProcessName(String stateProcessName)
        throws SystemException {
        for (PmlStateProcess pmlStateProcess : findByStateProcessName(
                stateProcessName)) {
            remove(pmlStateProcess);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (PmlStateProcess pmlStateProcess : findByDescription(description)) {
            remove(pmlStateProcess);
        }
    }

    public void removeByFileStatusId(long fileStatusId)
        throws SystemException {
        for (PmlStateProcess pmlStateProcess : findByFileStatusId(fileStatusId)) {
            remove(pmlStateProcess);
        }
    }

    public void removeByStateProcessCode(String stateProcessCode,
        String stateProcessName) throws SystemException {
        for (PmlStateProcess pmlStateProcess : findByStateProcessCode(
                stateProcessCode, stateProcessName)) {
            remove(pmlStateProcess);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlStateProcess pmlStateProcess : findAll()) {
            remove(pmlStateProcess);
        }
    }

    public int countByStateProcessCode(String stateProcessCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
        String finderMethodName = "countByStateProcessCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { stateProcessCode };

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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                if (stateProcessCode == null) {
                    query.append("stateprocesscode LIKE null");
                } else {
                    query.append("stateprocesscode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessCode != null) {
                    qPos.add(stateProcessCode);
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

    public int countByStateProcessName(String stateProcessName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
        String finderMethodName = "countByStateProcessName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { stateProcessName };

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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                if (stateProcessName == null) {
                    query.append("stateprocessname LIKE null");
                } else {
                    query.append("stateprocessname LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessName != null) {
                    qPos.add(stateProcessName);
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
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

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

    public int countByFileStatusId(long fileStatusId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
        String finderMethodName = "countByFileStatusId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(fileStatusId) };

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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                query.append("filestatusid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileStatusId);

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

    public int countByStateProcessCode(String stateProcessCode,
        String stateProcessName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
        String finderMethodName = "countByStateProcessCode";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { stateProcessCode, stateProcessName };

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
                    "FROM com.sgs.portlet.document.model.PmlStateProcess WHERE ");

                if (stateProcessCode == null) {
                    query.append("stateprocesscode IS NULL");
                } else {
                    query.append("stateprocesscode = ?");
                }

                query.append(" AND ");

                if (stateProcessName == null) {
                    query.append("stateprocessname IS NULL");
                } else {
                    query.append("stateprocessname = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (stateProcessCode != null) {
                    qPos.add(stateProcessCode);
                }

                if (stateProcessName != null) {
                    qPos.add(stateProcessName);
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
        boolean finderClassNameCacheEnabled = PmlStateProcessModelImpl.CACHE_ENABLED;
        String finderClassName = PmlStateProcess.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.model.PmlStateProcess");

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
                        "value.object.listener.com.sgs.portlet.document.model.PmlStateProcess")));

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
