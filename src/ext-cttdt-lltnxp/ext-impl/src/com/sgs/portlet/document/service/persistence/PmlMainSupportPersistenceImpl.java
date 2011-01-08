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

import com.sgs.portlet.document.NoSuchPmlMainSupportException;
import com.sgs.portlet.document.model.PmlMainSupport;
import com.sgs.portlet.document.model.impl.PmlMainSupportImpl;
import com.sgs.portlet.document.model.impl.PmlMainSupportModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlMainSupportPersistenceImpl extends BasePersistenceImpl
    implements PmlMainSupportPersistence {
    private static Log _log = LogFactory.getLog(PmlMainSupportPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlMainSupport create(long processId) {
        PmlMainSupport pmlMainSupport = new PmlMainSupportImpl();

        pmlMainSupport.setNew(true);
        pmlMainSupport.setPrimaryKey(processId);

        return pmlMainSupport;
    }

    public PmlMainSupport remove(long processId)
        throws NoSuchPmlMainSupportException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlMainSupport pmlMainSupport = (PmlMainSupport) session.get(PmlMainSupportImpl.class,
                    new Long(processId));

            if (pmlMainSupport == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlMainSupport exists with the primary key " +
                        processId);
                }

                throw new NoSuchPmlMainSupportException(
                    "No PmlMainSupport exists with the primary key " +
                    processId);
            }

            return remove(pmlMainSupport);
        } catch (NoSuchPmlMainSupportException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlMainSupport remove(PmlMainSupport pmlMainSupport)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlMainSupport);
            }
        }

        pmlMainSupport = removeImpl(pmlMainSupport);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlMainSupport);
            }
        }

        return pmlMainSupport;
    }

    protected PmlMainSupport removeImpl(PmlMainSupport pmlMainSupport)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlMainSupport);

            session.flush();

            return pmlMainSupport;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlMainSupport.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlMainSupport pmlMainSupport, boolean merge)</code>.
     */
    public PmlMainSupport update(PmlMainSupport pmlMainSupport)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlMainSupport pmlMainSupport) method. Use update(PmlMainSupport pmlMainSupport, boolean merge) instead.");
        }

        return update(pmlMainSupport, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlMainSupport the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlMainSupport is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlMainSupport update(PmlMainSupport pmlMainSupport, boolean merge)
        throws SystemException {
        boolean isNew = pmlMainSupport.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlMainSupport);
                } else {
                    listener.onBeforeUpdate(pmlMainSupport);
                }
            }
        }

        pmlMainSupport = updateImpl(pmlMainSupport, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlMainSupport);
                } else {
                    listener.onAfterUpdate(pmlMainSupport);
                }
            }
        }

        return pmlMainSupport;
    }

    public PmlMainSupport updateImpl(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlMainSupport);
            } else {
                if (pmlMainSupport.isNew()) {
                    session.save(pmlMainSupport);
                }
            }

            session.flush();

            pmlMainSupport.setNew(false);

            return pmlMainSupport;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlMainSupport.class.getName());
        }
    }

    public PmlMainSupport findByPrimaryKey(long processId)
        throws NoSuchPmlMainSupportException, SystemException {
        PmlMainSupport pmlMainSupport = fetchByPrimaryKey(processId);

        if (pmlMainSupport == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlMainSupport exists with the primary key " +
                    processId);
            }

            throw new NoSuchPmlMainSupportException(
                "No PmlMainSupport exists with the primary key " + processId);
        }

        return pmlMainSupport;
    }

    public PmlMainSupport fetchByPrimaryKey(long processId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlMainSupport) session.get(PmlMainSupportImpl.class,
                new Long(processId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlMainSupport> findByProcessIdMain(long processId_Main)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
        String finderMethodName = "findByProcessIdMain";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(processId_Main) };

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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

                query.append("processid_main = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId_Main);

                List<PmlMainSupport> list = q.list();

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
            return (List<PmlMainSupport>) result;
        }
    }

    public List<PmlMainSupport> findByProcessIdMain(long processId_Main,
        int start, int end) throws SystemException {
        return findByProcessIdMain(processId_Main, start, end, null);
    }

    public List<PmlMainSupport> findByProcessIdMain(long processId_Main,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
        String finderMethodName = "findByProcessIdMain";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(processId_Main),
                
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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

                query.append("processid_main = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId_Main);

                List<PmlMainSupport> list = (List<PmlMainSupport>) QueryUtil.list(q,
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
            return (List<PmlMainSupport>) result;
        }
    }

    public PmlMainSupport findByProcessIdMain_First(long processId_Main,
        OrderByComparator obc)
        throws NoSuchPmlMainSupportException, SystemException {
        List<PmlMainSupport> list = findByProcessIdMain(processId_Main, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMainSupport exists with the key {");

            msg.append("processId_Main=" + processId_Main);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMainSupportException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMainSupport findByProcessIdMain_Last(long processId_Main,
        OrderByComparator obc)
        throws NoSuchPmlMainSupportException, SystemException {
        int count = countByProcessIdMain(processId_Main);

        List<PmlMainSupport> list = findByProcessIdMain(processId_Main,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMainSupport exists with the key {");

            msg.append("processId_Main=" + processId_Main);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMainSupportException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMainSupport[] findByProcessIdMain_PrevAndNext(long processId,
        long processId_Main, OrderByComparator obc)
        throws NoSuchPmlMainSupportException, SystemException {
        PmlMainSupport pmlMainSupport = findByPrimaryKey(processId);

        int count = countByProcessIdMain(processId_Main);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

            query.append("processid_main = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processId_Main);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlMainSupport);

            PmlMainSupport[] array = new PmlMainSupportImpl[3];

            array[0] = (PmlMainSupport) objArray[0];
            array[1] = (PmlMainSupport) objArray[1];
            array[2] = (PmlMainSupport) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlMainSupport> findByType(String type_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
        String finderMethodName = "findByType";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { type_ };

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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

                if (type_ == null) {
                    query.append("type_ IS NULL");
                } else {
                    query.append("type_ = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (type_ != null) {
                    qPos.add(type_);
                }

                List<PmlMainSupport> list = q.list();

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
            return (List<PmlMainSupport>) result;
        }
    }

    public List<PmlMainSupport> findByType(String type_, int start, int end)
        throws SystemException {
        return findByType(type_, start, end, null);
    }

    public List<PmlMainSupport> findByType(String type_, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
        String finderMethodName = "findByType";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                type_,
                
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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

                if (type_ == null) {
                    query.append("type_ IS NULL");
                } else {
                    query.append("type_ = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (type_ != null) {
                    qPos.add(type_);
                }

                List<PmlMainSupport> list = (List<PmlMainSupport>) QueryUtil.list(q,
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
            return (List<PmlMainSupport>) result;
        }
    }

    public PmlMainSupport findByType_First(String type_, OrderByComparator obc)
        throws NoSuchPmlMainSupportException, SystemException {
        List<PmlMainSupport> list = findByType(type_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMainSupport exists with the key {");

            msg.append("type_=" + type_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMainSupportException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMainSupport findByType_Last(String type_, OrderByComparator obc)
        throws NoSuchPmlMainSupportException, SystemException {
        int count = countByType(type_);

        List<PmlMainSupport> list = findByType(type_, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMainSupport exists with the key {");

            msg.append("type_=" + type_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMainSupportException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMainSupport[] findByType_PrevAndNext(long processId,
        String type_, OrderByComparator obc)
        throws NoSuchPmlMainSupportException, SystemException {
        PmlMainSupport pmlMainSupport = findByPrimaryKey(processId);

        int count = countByType(type_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

            if (type_ == null) {
                query.append("type_ IS NULL");
            } else {
                query.append("type_ = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (type_ != null) {
                qPos.add(type_);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlMainSupport);

            PmlMainSupport[] array = new PmlMainSupportImpl[3];

            array[0] = (PmlMainSupport) objArray[0];
            array[1] = (PmlMainSupport) objArray[1];
            array[2] = (PmlMainSupport) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlMainSupport> findBySupportInfomation(
        String supportInfomation) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
        String finderMethodName = "findBySupportInfomation";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { supportInfomation };

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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

                if (supportInfomation == null) {
                    query.append("supportinfomation LIKE null");
                } else {
                    query.append("supportinfomation LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (supportInfomation != null) {
                    qPos.add(supportInfomation);
                }

                List<PmlMainSupport> list = q.list();

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
            return (List<PmlMainSupport>) result;
        }
    }

    public List<PmlMainSupport> findBySupportInfomation(
        String supportInfomation, int start, int end) throws SystemException {
        return findBySupportInfomation(supportInfomation, start, end, null);
    }

    public List<PmlMainSupport> findBySupportInfomation(
        String supportInfomation, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
        String finderMethodName = "findBySupportInfomation";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                supportInfomation,
                
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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

                if (supportInfomation == null) {
                    query.append("supportinfomation LIKE null");
                } else {
                    query.append("supportinfomation LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (supportInfomation != null) {
                    qPos.add(supportInfomation);
                }

                List<PmlMainSupport> list = (List<PmlMainSupport>) QueryUtil.list(q,
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
            return (List<PmlMainSupport>) result;
        }
    }

    public PmlMainSupport findBySupportInfomation_First(
        String supportInfomation, OrderByComparator obc)
        throws NoSuchPmlMainSupportException, SystemException {
        List<PmlMainSupport> list = findBySupportInfomation(supportInfomation,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMainSupport exists with the key {");

            msg.append("supportInfomation=" + supportInfomation);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMainSupportException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMainSupport findBySupportInfomation_Last(
        String supportInfomation, OrderByComparator obc)
        throws NoSuchPmlMainSupportException, SystemException {
        int count = countBySupportInfomation(supportInfomation);

        List<PmlMainSupport> list = findBySupportInfomation(supportInfomation,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMainSupport exists with the key {");

            msg.append("supportInfomation=" + supportInfomation);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMainSupportException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMainSupport[] findBySupportInfomation_PrevAndNext(
        long processId, String supportInfomation, OrderByComparator obc)
        throws NoSuchPmlMainSupportException, SystemException {
        PmlMainSupport pmlMainSupport = findByPrimaryKey(processId);

        int count = countBySupportInfomation(supportInfomation);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

            if (supportInfomation == null) {
                query.append("supportinfomation LIKE null");
            } else {
                query.append("supportinfomation LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (supportInfomation != null) {
                qPos.add(supportInfomation);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlMainSupport);

            PmlMainSupport[] array = new PmlMainSupportImpl[3];

            array[0] = (PmlMainSupport) objArray[0];
            array[1] = (PmlMainSupport) objArray[1];
            array[2] = (PmlMainSupport) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlMainSupport> findByprocessIdMain_Type(long processId_Main,
        String type_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
        String finderMethodName = "findByprocessIdMain_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(processId_Main), type_ };

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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

                query.append("processid_main = ?");

                query.append(" AND ");

                if (type_ == null) {
                    query.append("type_ LIKE null");
                } else {
                    query.append("type_ LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId_Main);

                if (type_ != null) {
                    qPos.add(type_);
                }

                List<PmlMainSupport> list = q.list();

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
            return (List<PmlMainSupport>) result;
        }
    }

    public List<PmlMainSupport> findByprocessIdMain_Type(long processId_Main,
        String type_, int start, int end) throws SystemException {
        return findByprocessIdMain_Type(processId_Main, type_, start, end, null);
    }

    public List<PmlMainSupport> findByprocessIdMain_Type(long processId_Main,
        String type_, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
        String finderMethodName = "findByprocessIdMain_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(processId_Main),
                
                type_,
                
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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

                query.append("processid_main = ?");

                query.append(" AND ");

                if (type_ == null) {
                    query.append("type_ LIKE null");
                } else {
                    query.append("type_ LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId_Main);

                if (type_ != null) {
                    qPos.add(type_);
                }

                List<PmlMainSupport> list = (List<PmlMainSupport>) QueryUtil.list(q,
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
            return (List<PmlMainSupport>) result;
        }
    }

    public PmlMainSupport findByprocessIdMain_Type_First(long processId_Main,
        String type_, OrderByComparator obc)
        throws NoSuchPmlMainSupportException, SystemException {
        List<PmlMainSupport> list = findByprocessIdMain_Type(processId_Main,
                type_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMainSupport exists with the key {");

            msg.append("processId_Main=" + processId_Main);

            msg.append(", ");
            msg.append("type_=" + type_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMainSupportException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMainSupport findByprocessIdMain_Type_Last(long processId_Main,
        String type_, OrderByComparator obc)
        throws NoSuchPmlMainSupportException, SystemException {
        int count = countByprocessIdMain_Type(processId_Main, type_);

        List<PmlMainSupport> list = findByprocessIdMain_Type(processId_Main,
                type_, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlMainSupport exists with the key {");

            msg.append("processId_Main=" + processId_Main);

            msg.append(", ");
            msg.append("type_=" + type_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlMainSupportException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlMainSupport[] findByprocessIdMain_Type_PrevAndNext(
        long processId, long processId_Main, String type_, OrderByComparator obc)
        throws NoSuchPmlMainSupportException, SystemException {
        PmlMainSupport pmlMainSupport = findByPrimaryKey(processId);

        int count = countByprocessIdMain_Type(processId_Main, type_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

            query.append("processid_main = ?");

            query.append(" AND ");

            if (type_ == null) {
                query.append("type_ LIKE null");
            } else {
                query.append("type_ LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("processid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(processId_Main);

            if (type_ != null) {
                qPos.add(type_);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlMainSupport);

            PmlMainSupport[] array = new PmlMainSupportImpl[3];

            array[0] = (PmlMainSupport) objArray[0];
            array[1] = (PmlMainSupport) objArray[1];
            array[2] = (PmlMainSupport) objArray[2];

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

    public List<PmlMainSupport> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlMainSupport> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlMainSupport> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlMainSupport> list = (List<PmlMainSupport>) QueryUtil.list(q,
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
            return (List<PmlMainSupport>) result;
        }
    }

    public void removeByProcessIdMain(long processId_Main)
        throws SystemException {
        for (PmlMainSupport pmlMainSupport : findByProcessIdMain(processId_Main)) {
            remove(pmlMainSupport);
        }
    }

    public void removeByType(String type_) throws SystemException {
        for (PmlMainSupport pmlMainSupport : findByType(type_)) {
            remove(pmlMainSupport);
        }
    }

    public void removeBySupportInfomation(String supportInfomation)
        throws SystemException {
        for (PmlMainSupport pmlMainSupport : findBySupportInfomation(
                supportInfomation)) {
            remove(pmlMainSupport);
        }
    }

    public void removeByprocessIdMain_Type(long processId_Main, String type_)
        throws SystemException {
        for (PmlMainSupport pmlMainSupport : findByprocessIdMain_Type(
                processId_Main, type_)) {
            remove(pmlMainSupport);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlMainSupport pmlMainSupport : findAll()) {
            remove(pmlMainSupport);
        }
    }

    public int countByProcessIdMain(long processId_Main)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
        String finderMethodName = "countByProcessIdMain";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(processId_Main) };

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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

                query.append("processid_main = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId_Main);

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

    public int countByType(String type_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
        String finderMethodName = "countByType";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { type_ };

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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

                if (type_ == null) {
                    query.append("type_ IS NULL");
                } else {
                    query.append("type_ = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (type_ != null) {
                    qPos.add(type_);
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

    public int countBySupportInfomation(String supportInfomation)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
        String finderMethodName = "countBySupportInfomation";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { supportInfomation };

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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

                if (supportInfomation == null) {
                    query.append("supportinfomation LIKE null");
                } else {
                    query.append("supportinfomation LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (supportInfomation != null) {
                    qPos.add(supportInfomation);
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

    public int countByprocessIdMain_Type(long processId_Main, String type_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
        String finderMethodName = "countByprocessIdMain_Type";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(processId_Main), type_ };

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
                    "FROM com.sgs.portlet.document.model.PmlMainSupport WHERE ");

                query.append("processid_main = ?");

                query.append(" AND ");

                if (type_ == null) {
                    query.append("type_ LIKE null");
                } else {
                    query.append("type_ LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(processId_Main);

                if (type_ != null) {
                    qPos.add(type_);
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
        boolean finderClassNameCacheEnabled = PmlMainSupportModelImpl.CACHE_ENABLED;
        String finderClassName = PmlMainSupport.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.model.PmlMainSupport");

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
                        "value.object.listener.com.sgs.portlet.document.model.PmlMainSupport")));

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
