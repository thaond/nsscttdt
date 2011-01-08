package com.sgs.portlet.pmllevelsend.service.persistence;

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

import com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.pmllevelsend.model.impl.PmlEdmLevelSendImpl;
import com.sgs.portlet.pmllevelsend.model.impl.PmlEdmLevelSendModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlEdmLevelSendPersistenceImpl extends BasePersistenceImpl
    implements PmlEdmLevelSendPersistence {
    private static Log _log = LogFactory.getLog(PmlEdmLevelSendPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmLevelSend create(int levelSendId) {
        PmlEdmLevelSend pmlEdmLevelSend = new PmlEdmLevelSendImpl();

        pmlEdmLevelSend.setNew(true);
        pmlEdmLevelSend.setPrimaryKey(levelSendId);

        return pmlEdmLevelSend;
    }

    public PmlEdmLevelSend remove(int levelSendId)
        throws NoSuchPmlEdmLevelSendException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmLevelSend pmlEdmLevelSend = (PmlEdmLevelSend) session.get(PmlEdmLevelSendImpl.class,
                    new Integer(levelSendId));

            if (pmlEdmLevelSend == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlEdmLevelSend exists with the primary key " +
                        levelSendId);
                }

                throw new NoSuchPmlEdmLevelSendException(
                    "No PmlEdmLevelSend exists with the primary key " +
                    levelSendId);
            }

            return remove(pmlEdmLevelSend);
        } catch (NoSuchPmlEdmLevelSendException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmLevelSend remove(PmlEdmLevelSend pmlEdmLevelSend)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmLevelSend);
            }
        }

        pmlEdmLevelSend = removeImpl(pmlEdmLevelSend);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmLevelSend);
            }
        }

        return pmlEdmLevelSend;
    }

    protected PmlEdmLevelSend removeImpl(PmlEdmLevelSend pmlEdmLevelSend)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmLevelSend);

            session.flush();

            return pmlEdmLevelSend;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmLevelSend.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmLevelSend pmlEdmLevelSend, boolean merge)</code>.
     */
    public PmlEdmLevelSend update(PmlEdmLevelSend pmlEdmLevelSend)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmLevelSend pmlEdmLevelSend) method. Use update(PmlEdmLevelSend pmlEdmLevelSend, boolean merge) instead.");
        }

        return update(pmlEdmLevelSend, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmLevelSend the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmLevelSend is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmLevelSend update(PmlEdmLevelSend pmlEdmLevelSend, boolean merge)
        throws SystemException {
        boolean isNew = pmlEdmLevelSend.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmLevelSend);
                } else {
                    listener.onBeforeUpdate(pmlEdmLevelSend);
                }
            }
        }

        pmlEdmLevelSend = updateImpl(pmlEdmLevelSend, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmLevelSend);
                } else {
                    listener.onAfterUpdate(pmlEdmLevelSend);
                }
            }
        }

        return pmlEdmLevelSend;
    }

    public PmlEdmLevelSend updateImpl(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmLevelSend);
            } else {
                if (pmlEdmLevelSend.isNew()) {
                    session.save(pmlEdmLevelSend);
                }
            }

            session.flush();

            pmlEdmLevelSend.setNew(false);

            return pmlEdmLevelSend;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmLevelSend.class.getName());
        }
    }

    public PmlEdmLevelSend findByPrimaryKey(int levelSendId)
        throws NoSuchPmlEdmLevelSendException, SystemException {
        PmlEdmLevelSend pmlEdmLevelSend = fetchByPrimaryKey(levelSendId);

        if (pmlEdmLevelSend == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlEdmLevelSend exists with the primary key " +
                    levelSendId);
            }

            throw new NoSuchPmlEdmLevelSendException(
                "No PmlEdmLevelSend exists with the primary key " +
                levelSendId);
        }

        return pmlEdmLevelSend;
    }

    public PmlEdmLevelSend fetchByPrimaryKey(int levelSendId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmLevelSend) session.get(PmlEdmLevelSendImpl.class,
                new Integer(levelSendId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmLevelSend> findByLevelSendCode(String levelSendCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSend.class.getName();
        String finderMethodName = "findByLevelSendCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { levelSendCode };

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
                    "FROM com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend WHERE ");

                if (levelSendCode == null) {
                    query.append("levelsendcode LIKE null");
                } else {
                    query.append("levelsendcode LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("levelsendname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (levelSendCode != null) {
                    qPos.add(levelSendCode);
                }

                List<PmlEdmLevelSend> list = q.list();

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
            return (List<PmlEdmLevelSend>) result;
        }
    }

    public List<PmlEdmLevelSend> findByLevelSendCode(String levelSendCode,
        int start, int end) throws SystemException {
        return findByLevelSendCode(levelSendCode, start, end, null);
    }

    public List<PmlEdmLevelSend> findByLevelSendCode(String levelSendCode,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSend.class.getName();
        String finderMethodName = "findByLevelSendCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                levelSendCode,
                
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
                    "FROM com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend WHERE ");

                if (levelSendCode == null) {
                    query.append("levelsendcode LIKE null");
                } else {
                    query.append("levelsendcode LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("levelsendname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (levelSendCode != null) {
                    qPos.add(levelSendCode);
                }

                List<PmlEdmLevelSend> list = (List<PmlEdmLevelSend>) QueryUtil.list(q,
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
            return (List<PmlEdmLevelSend>) result;
        }
    }

    public PmlEdmLevelSend findByLevelSendCode_First(String levelSendCode,
        OrderByComparator obc)
        throws NoSuchPmlEdmLevelSendException, SystemException {
        List<PmlEdmLevelSend> list = findByLevelSendCode(levelSendCode, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmLevelSend exists with the key {");

            msg.append("levelSendCode=" + levelSendCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmLevelSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmLevelSend findByLevelSendCode_Last(String levelSendCode,
        OrderByComparator obc)
        throws NoSuchPmlEdmLevelSendException, SystemException {
        int count = countByLevelSendCode(levelSendCode);

        List<PmlEdmLevelSend> list = findByLevelSendCode(levelSendCode,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmLevelSend exists with the key {");

            msg.append("levelSendCode=" + levelSendCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmLevelSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmLevelSend[] findByLevelSendCode_PrevAndNext(int levelSendId,
        String levelSendCode, OrderByComparator obc)
        throws NoSuchPmlEdmLevelSendException, SystemException {
        PmlEdmLevelSend pmlEdmLevelSend = findByPrimaryKey(levelSendId);

        int count = countByLevelSendCode(levelSendCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend WHERE ");

            if (levelSendCode == null) {
                query.append("levelsendcode LIKE null");
            } else {
                query.append("levelsendcode LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("levelsendname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (levelSendCode != null) {
                qPos.add(levelSendCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmLevelSend);

            PmlEdmLevelSend[] array = new PmlEdmLevelSendImpl[3];

            array[0] = (PmlEdmLevelSend) objArray[0];
            array[1] = (PmlEdmLevelSend) objArray[1];
            array[2] = (PmlEdmLevelSend) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmLevelSend> findByLevelSendName(String levelSendName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSend.class.getName();
        String finderMethodName = "findByLevelSendName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { levelSendName };

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
                    "FROM com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend WHERE ");

                if (levelSendName == null) {
                    query.append("levelsendname LIKE null");
                } else {
                    query.append("levelsendname LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("levelsendname ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (levelSendName != null) {
                    qPos.add(levelSendName);
                }

                List<PmlEdmLevelSend> list = q.list();

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
            return (List<PmlEdmLevelSend>) result;
        }
    }

    public List<PmlEdmLevelSend> findByLevelSendName(String levelSendName,
        int start, int end) throws SystemException {
        return findByLevelSendName(levelSendName, start, end, null);
    }

    public List<PmlEdmLevelSend> findByLevelSendName(String levelSendName,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSend.class.getName();
        String finderMethodName = "findByLevelSendName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                levelSendName,
                
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
                    "FROM com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend WHERE ");

                if (levelSendName == null) {
                    query.append("levelsendname LIKE null");
                } else {
                    query.append("levelsendname LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("levelsendname ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (levelSendName != null) {
                    qPos.add(levelSendName);
                }

                List<PmlEdmLevelSend> list = (List<PmlEdmLevelSend>) QueryUtil.list(q,
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
            return (List<PmlEdmLevelSend>) result;
        }
    }

    public PmlEdmLevelSend findByLevelSendName_First(String levelSendName,
        OrderByComparator obc)
        throws NoSuchPmlEdmLevelSendException, SystemException {
        List<PmlEdmLevelSend> list = findByLevelSendName(levelSendName, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmLevelSend exists with the key {");

            msg.append("levelSendName=" + levelSendName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmLevelSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmLevelSend findByLevelSendName_Last(String levelSendName,
        OrderByComparator obc)
        throws NoSuchPmlEdmLevelSendException, SystemException {
        int count = countByLevelSendName(levelSendName);

        List<PmlEdmLevelSend> list = findByLevelSendName(levelSendName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmLevelSend exists with the key {");

            msg.append("levelSendName=" + levelSendName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmLevelSendException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmLevelSend[] findByLevelSendName_PrevAndNext(int levelSendId,
        String levelSendName, OrderByComparator obc)
        throws NoSuchPmlEdmLevelSendException, SystemException {
        PmlEdmLevelSend pmlEdmLevelSend = findByPrimaryKey(levelSendId);

        int count = countByLevelSendName(levelSendName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend WHERE ");

            if (levelSendName == null) {
                query.append("levelsendname LIKE null");
            } else {
                query.append("levelsendname LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("levelsendname ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (levelSendName != null) {
                qPos.add(levelSendName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmLevelSend);

            PmlEdmLevelSend[] array = new PmlEdmLevelSendImpl[3];

            array[0] = (PmlEdmLevelSend) objArray[0];
            array[1] = (PmlEdmLevelSend) objArray[1];
            array[2] = (PmlEdmLevelSend) objArray[2];

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

    public List<PmlEdmLevelSend> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmLevelSend> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmLevelSend> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSend.class.getName();
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
                    "FROM com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("levelsendname ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmLevelSend> list = (List<PmlEdmLevelSend>) QueryUtil.list(q,
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
            return (List<PmlEdmLevelSend>) result;
        }
    }

    public void removeByLevelSendCode(String levelSendCode)
        throws SystemException {
        for (PmlEdmLevelSend pmlEdmLevelSend : findByLevelSendCode(
                levelSendCode)) {
            remove(pmlEdmLevelSend);
        }
    }

    public void removeByLevelSendName(String levelSendName)
        throws SystemException {
        for (PmlEdmLevelSend pmlEdmLevelSend : findByLevelSendName(
                levelSendName)) {
            remove(pmlEdmLevelSend);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmLevelSend pmlEdmLevelSend : findAll()) {
            remove(pmlEdmLevelSend);
        }
    }

    public int countByLevelSendCode(String levelSendCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSend.class.getName();
        String finderMethodName = "countByLevelSendCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { levelSendCode };

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
                    "FROM com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend WHERE ");

                if (levelSendCode == null) {
                    query.append("levelsendcode LIKE null");
                } else {
                    query.append("levelsendcode LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (levelSendCode != null) {
                    qPos.add(levelSendCode);
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

    public int countByLevelSendName(String levelSendName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSend.class.getName();
        String finderMethodName = "countByLevelSendName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { levelSendName };

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
                    "FROM com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend WHERE ");

                if (levelSendName == null) {
                    query.append("levelsendname LIKE null");
                } else {
                    query.append("levelsendname LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (levelSendName != null) {
                    qPos.add(levelSendName);
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
        boolean finderClassNameCacheEnabled = PmlEdmLevelSendModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmLevelSend.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend");

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
                        "value.object.listener.com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend")));

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
