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

import com.sgs.portlet.document.NoSuchReceiptWFException;
import com.sgs.portlet.document.model.PmlDocumentReceiptWF;
import com.sgs.portlet.document.model.impl.PmlDocumentReceiptWFImpl;
import com.sgs.portlet.document.model.impl.PmlDocumentReceiptWFModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlDocumentReceiptWFPersistenceImpl extends BasePersistenceImpl
    implements PmlDocumentReceiptWFPersistence {
    private static Log _log = LogFactory.getLog(PmlDocumentReceiptWFPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlDocumentReceiptWF create(long processId) {
        PmlDocumentReceiptWF pmlDocumentReceiptWF = new PmlDocumentReceiptWFImpl();

        pmlDocumentReceiptWF.setNew(true);
        pmlDocumentReceiptWF.setPrimaryKey(processId);

        return pmlDocumentReceiptWF;
    }

    public PmlDocumentReceiptWF remove(long processId)
        throws NoSuchReceiptWFException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlDocumentReceiptWF pmlDocumentReceiptWF = (PmlDocumentReceiptWF) session.get(PmlDocumentReceiptWFImpl.class,
                    new Long(processId));

            if (pmlDocumentReceiptWF == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlDocumentReceiptWF exists with the primary key " +
                        processId);
                }

                throw new NoSuchReceiptWFException(
                    "No PmlDocumentReceiptWF exists with the primary key " +
                    processId);
            }

            return remove(pmlDocumentReceiptWF);
        } catch (NoSuchReceiptWFException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlDocumentReceiptWF remove(
        PmlDocumentReceiptWF pmlDocumentReceiptWF) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlDocumentReceiptWF);
            }
        }

        pmlDocumentReceiptWF = removeImpl(pmlDocumentReceiptWF);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlDocumentReceiptWF);
            }
        }

        return pmlDocumentReceiptWF;
    }

    protected PmlDocumentReceiptWF removeImpl(
        PmlDocumentReceiptWF pmlDocumentReceiptWF) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlDocumentReceiptWF);

            session.flush();

            return pmlDocumentReceiptWF;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDocumentReceiptWF.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlDocumentReceiptWF pmlDocumentReceiptWF, boolean merge)</code>.
     */
    public PmlDocumentReceiptWF update(
        PmlDocumentReceiptWF pmlDocumentReceiptWF) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlDocumentReceiptWF pmlDocumentReceiptWF) method. Use update(PmlDocumentReceiptWF pmlDocumentReceiptWF, boolean merge) instead.");
        }

        return update(pmlDocumentReceiptWF, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentReceiptWF the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentReceiptWF is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlDocumentReceiptWF update(
        PmlDocumentReceiptWF pmlDocumentReceiptWF, boolean merge)
        throws SystemException {
        boolean isNew = pmlDocumentReceiptWF.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlDocumentReceiptWF);
                } else {
                    listener.onBeforeUpdate(pmlDocumentReceiptWF);
                }
            }
        }

        pmlDocumentReceiptWF = updateImpl(pmlDocumentReceiptWF, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlDocumentReceiptWF);
                } else {
                    listener.onAfterUpdate(pmlDocumentReceiptWF);
                }
            }
        }

        return pmlDocumentReceiptWF;
    }

    public PmlDocumentReceiptWF updateImpl(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlDocumentReceiptWF);
            } else {
                if (pmlDocumentReceiptWF.isNew()) {
                    session.save(pmlDocumentReceiptWF);
                }
            }

            session.flush();

            pmlDocumentReceiptWF.setNew(false);

            return pmlDocumentReceiptWF;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlDocumentReceiptWF.class.getName());
        }
    }

    public PmlDocumentReceiptWF findByPrimaryKey(long processId)
        throws NoSuchReceiptWFException, SystemException {
        PmlDocumentReceiptWF pmlDocumentReceiptWF = fetchByPrimaryKey(processId);

        if (pmlDocumentReceiptWF == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlDocumentReceiptWF exists with the primary key " +
                    processId);
            }

            throw new NoSuchReceiptWFException(
                "No PmlDocumentReceiptWF exists with the primary key " +
                processId);
        }

        return pmlDocumentReceiptWF;
    }

    public PmlDocumentReceiptWF fetchByPrimaryKey(long processId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlDocumentReceiptWF) session.get(PmlDocumentReceiptWFImpl.class,
                new Long(processId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptWF> findByDocumentReceiptId(
        long documentReceiptId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptWF.class.getName();
        String finderMethodName = "findByDocumentReceiptId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentReceiptId) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptWF WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                List<PmlDocumentReceiptWF> list = q.list();

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
            return (List<PmlDocumentReceiptWF>) result;
        }
    }

    public List<PmlDocumentReceiptWF> findByDocumentReceiptId(
        long documentReceiptId, int start, int end) throws SystemException {
        return findByDocumentReceiptId(documentReceiptId, start, end, null);
    }

    public List<PmlDocumentReceiptWF> findByDocumentReceiptId(
        long documentReceiptId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptWF.class.getName();
        String finderMethodName = "findByDocumentReceiptId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId),
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptWF WHERE ");

                query.append("documentreceiptid = ?");

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

                qPos.add(documentReceiptId);

                List<PmlDocumentReceiptWF> list = (List<PmlDocumentReceiptWF>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptWF>) result;
        }
    }

    public PmlDocumentReceiptWF findByDocumentReceiptId_First(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchReceiptWFException, SystemException {
        List<PmlDocumentReceiptWF> list = findByDocumentReceiptId(documentReceiptId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptWF exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptWFException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptWF findByDocumentReceiptId_Last(
        long documentReceiptId, OrderByComparator obc)
        throws NoSuchReceiptWFException, SystemException {
        int count = countByDocumentReceiptId(documentReceiptId);

        List<PmlDocumentReceiptWF> list = findByDocumentReceiptId(documentReceiptId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptWF exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptWFException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptWF[] findByDocumentReceiptId_PrevAndNext(
        long processId, long documentReceiptId, OrderByComparator obc)
        throws NoSuchReceiptWFException, SystemException {
        PmlDocumentReceiptWF pmlDocumentReceiptWF = findByPrimaryKey(processId);

        int count = countByDocumentReceiptId(documentReceiptId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptWF WHERE ");

            query.append("documentreceiptid = ?");

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

            qPos.add(documentReceiptId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptWF);

            PmlDocumentReceiptWF[] array = new PmlDocumentReceiptWFImpl[3];

            array[0] = (PmlDocumentReceiptWF) objArray[0];
            array[1] = (PmlDocumentReceiptWF) objArray[1];
            array[2] = (PmlDocumentReceiptWF) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlDocumentReceiptWF> findByDocumentReceiptIdIsMain(
        long documentReceiptId, String isMain) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptWF.class.getName();
        String finderMethodName = "findByDocumentReceiptIdIsMain";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(documentReceiptId), isMain };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptWF WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                if (isMain == null) {
                    query.append("ismain IS NULL");
                } else {
                    query.append("ismain = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("processid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                if (isMain != null) {
                    qPos.add(isMain);
                }

                List<PmlDocumentReceiptWF> list = q.list();

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
            return (List<PmlDocumentReceiptWF>) result;
        }
    }

    public List<PmlDocumentReceiptWF> findByDocumentReceiptIdIsMain(
        long documentReceiptId, String isMain, int start, int end)
        throws SystemException {
        return findByDocumentReceiptIdIsMain(documentReceiptId, isMain, start,
            end, null);
    }

    public List<PmlDocumentReceiptWF> findByDocumentReceiptIdIsMain(
        long documentReceiptId, String isMain, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptWF.class.getName();
        String finderMethodName = "findByDocumentReceiptIdIsMain";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(documentReceiptId),
                
                isMain,
                
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptWF WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                if (isMain == null) {
                    query.append("ismain IS NULL");
                } else {
                    query.append("ismain = ?");
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

                qPos.add(documentReceiptId);

                if (isMain != null) {
                    qPos.add(isMain);
                }

                List<PmlDocumentReceiptWF> list = (List<PmlDocumentReceiptWF>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptWF>) result;
        }
    }

    public PmlDocumentReceiptWF findByDocumentReceiptIdIsMain_First(
        long documentReceiptId, String isMain, OrderByComparator obc)
        throws NoSuchReceiptWFException, SystemException {
        List<PmlDocumentReceiptWF> list = findByDocumentReceiptIdIsMain(documentReceiptId,
                isMain, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptWF exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("isMain=" + isMain);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptWFException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptWF findByDocumentReceiptIdIsMain_Last(
        long documentReceiptId, String isMain, OrderByComparator obc)
        throws NoSuchReceiptWFException, SystemException {
        int count = countByDocumentReceiptIdIsMain(documentReceiptId, isMain);

        List<PmlDocumentReceiptWF> list = findByDocumentReceiptIdIsMain(documentReceiptId,
                isMain, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlDocumentReceiptWF exists with the key {");

            msg.append("documentReceiptId=" + documentReceiptId);

            msg.append(", ");
            msg.append("isMain=" + isMain);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchReceiptWFException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlDocumentReceiptWF[] findByDocumentReceiptIdIsMain_PrevAndNext(
        long processId, long documentReceiptId, String isMain,
        OrderByComparator obc) throws NoSuchReceiptWFException, SystemException {
        PmlDocumentReceiptWF pmlDocumentReceiptWF = findByPrimaryKey(processId);

        int count = countByDocumentReceiptIdIsMain(documentReceiptId, isMain);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.model.PmlDocumentReceiptWF WHERE ");

            query.append("documentreceiptid = ?");

            query.append(" AND ");

            if (isMain == null) {
                query.append("ismain IS NULL");
            } else {
                query.append("ismain = ?");
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

            qPos.add(documentReceiptId);

            if (isMain != null) {
                qPos.add(isMain);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlDocumentReceiptWF);

            PmlDocumentReceiptWF[] array = new PmlDocumentReceiptWFImpl[3];

            array[0] = (PmlDocumentReceiptWF) objArray[0];
            array[1] = (PmlDocumentReceiptWF) objArray[1];
            array[2] = (PmlDocumentReceiptWF) objArray[2];

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

    public List<PmlDocumentReceiptWF> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlDocumentReceiptWF> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlDocumentReceiptWF> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptWF.class.getName();
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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptWF ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("processid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlDocumentReceiptWF> list = (List<PmlDocumentReceiptWF>) QueryUtil.list(q,
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
            return (List<PmlDocumentReceiptWF>) result;
        }
    }

    public void removeByDocumentReceiptId(long documentReceiptId)
        throws SystemException {
        for (PmlDocumentReceiptWF pmlDocumentReceiptWF : findByDocumentReceiptId(
                documentReceiptId)) {
            remove(pmlDocumentReceiptWF);
        }
    }

    public void removeByDocumentReceiptIdIsMain(long documentReceiptId,
        String isMain) throws SystemException {
        for (PmlDocumentReceiptWF pmlDocumentReceiptWF : findByDocumentReceiptIdIsMain(
                documentReceiptId, isMain)) {
            remove(pmlDocumentReceiptWF);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlDocumentReceiptWF pmlDocumentReceiptWF : findAll()) {
            remove(pmlDocumentReceiptWF);
        }
    }

    public int countByDocumentReceiptId(long documentReceiptId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptWF.class.getName();
        String finderMethodName = "countByDocumentReceiptId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(documentReceiptId) };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptWF WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

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

    public int countByDocumentReceiptIdIsMain(long documentReceiptId,
        String isMain) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptWF.class.getName();
        String finderMethodName = "countByDocumentReceiptIdIsMain";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(documentReceiptId), isMain };

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
                    "FROM com.sgs.portlet.document.model.PmlDocumentReceiptWF WHERE ");

                query.append("documentreceiptid = ?");

                query.append(" AND ");

                if (isMain == null) {
                    query.append("ismain IS NULL");
                } else {
                    query.append("ismain = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(documentReceiptId);

                if (isMain != null) {
                    qPos.add(isMain);
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
        boolean finderClassNameCacheEnabled = PmlDocumentReceiptWFModelImpl.CACHE_ENABLED;
        String finderClassName = PmlDocumentReceiptWF.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.model.PmlDocumentReceiptWF");

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
                        "value.object.listener.com.sgs.portlet.document.model.PmlDocumentReceiptWF")));

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
