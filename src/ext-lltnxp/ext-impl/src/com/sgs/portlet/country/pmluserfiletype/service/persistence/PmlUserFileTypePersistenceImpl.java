package com.sgs.portlet.country.pmluserfiletype.service.persistence;

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

import com.sgs.portlet.country.pmluserfiletype.NoSuchException;
import com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType;
import com.sgs.portlet.country.pmluserfiletype.model.impl.PmlUserFileTypeImpl;
import com.sgs.portlet.country.pmluserfiletype.model.impl.PmlUserFileTypeModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlUserFileTypePersistenceImpl extends BasePersistenceImpl
    implements PmlUserFileTypePersistence {
    private static Log _log = LogFactory.getLog(PmlUserFileTypePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlUserFileType create(PmlUserFileTypePK pmlUserFileTypePK) {
        PmlUserFileType pmlUserFileType = new PmlUserFileTypeImpl();

        pmlUserFileType.setNew(true);
        pmlUserFileType.setPrimaryKey(pmlUserFileTypePK);

        return pmlUserFileType;
    }

    public PmlUserFileType remove(PmlUserFileTypePK pmlUserFileTypePK)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlUserFileType pmlUserFileType = (PmlUserFileType) session.get(PmlUserFileTypeImpl.class,
                    pmlUserFileTypePK);

            if (pmlUserFileType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlUserFileType exists with the primary key " +
                        pmlUserFileTypePK);
                }

                throw new NoSuchException(
                    "No PmlUserFileType exists with the primary key " +
                    pmlUserFileTypePK);
            }

            return remove(pmlUserFileType);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlUserFileType remove(PmlUserFileType pmlUserFileType)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlUserFileType);
            }
        }

        pmlUserFileType = removeImpl(pmlUserFileType);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlUserFileType);
            }
        }

        return pmlUserFileType;
    }

    protected PmlUserFileType removeImpl(PmlUserFileType pmlUserFileType)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlUserFileType);

            session.flush();

            return pmlUserFileType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlUserFileType.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlUserFileType pmlUserFileType, boolean merge)</code>.
     */
    public PmlUserFileType update(PmlUserFileType pmlUserFileType)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlUserFileType pmlUserFileType) method. Use update(PmlUserFileType pmlUserFileType, boolean merge) instead.");
        }

        return update(pmlUserFileType, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlUserFileType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlUserFileType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlUserFileType update(PmlUserFileType pmlUserFileType, boolean merge)
        throws SystemException {
        boolean isNew = pmlUserFileType.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlUserFileType);
                } else {
                    listener.onBeforeUpdate(pmlUserFileType);
                }
            }
        }

        pmlUserFileType = updateImpl(pmlUserFileType, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlUserFileType);
                } else {
                    listener.onAfterUpdate(pmlUserFileType);
                }
            }
        }

        return pmlUserFileType;
    }

    public PmlUserFileType updateImpl(
        com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType pmlUserFileType,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlUserFileType);
            } else {
                if (pmlUserFileType.isNew()) {
                    session.save(pmlUserFileType);
                }
            }

            session.flush();

            pmlUserFileType.setNew(false);

            return pmlUserFileType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlUserFileType.class.getName());
        }
    }

    public PmlUserFileType findByPrimaryKey(PmlUserFileTypePK pmlUserFileTypePK)
        throws NoSuchException, SystemException {
        PmlUserFileType pmlUserFileType = fetchByPrimaryKey(pmlUserFileTypePK);

        if (pmlUserFileType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlUserFileType exists with the primary key " +
                    pmlUserFileTypePK);
            }

            throw new NoSuchException(
                "No PmlUserFileType exists with the primary key " +
                pmlUserFileTypePK);
        }

        return pmlUserFileType;
    }

    public PmlUserFileType fetchByPrimaryKey(
        PmlUserFileTypePK pmlUserFileTypePK) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlUserFileType) session.get(PmlUserFileTypeImpl.class,
                pmlUserFileTypePK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUserFileType> findByUserId(long userId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUserFileType.class.getName();
        String finderMethodName = "findByUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(userId) };

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
                    "FROM com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType WHERE ");

                query.append("userid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("userid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<PmlUserFileType> list = q.list();

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
            return (List<PmlUserFileType>) result;
        }
    }

    public List<PmlUserFileType> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
    }

    public List<PmlUserFileType> findByUserId(long userId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUserFileType.class.getName();
        String finderMethodName = "findByUserId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(userId),
                
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
                    "FROM com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType WHERE ");

                query.append("userid = ?");

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

                qPos.add(userId);

                List<PmlUserFileType> list = (List<PmlUserFileType>) QueryUtil.list(q,
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
            return (List<PmlUserFileType>) result;
        }
    }

    public PmlUserFileType findByUserId_First(long userId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<PmlUserFileType> list = findByUserId(userId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUserFileType exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUserFileType findByUserId_Last(long userId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByUserId(userId);

        List<PmlUserFileType> list = findByUserId(userId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUserFileType exists with the key {");

            msg.append("userId=" + userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUserFileType[] findByUserId_PrevAndNext(
        PmlUserFileTypePK pmlUserFileTypePK, long userId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlUserFileType pmlUserFileType = findByPrimaryKey(pmlUserFileTypePK);

        int count = countByUserId(userId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType WHERE ");

            query.append("userid = ?");

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

            qPos.add(userId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlUserFileType);

            PmlUserFileType[] array = new PmlUserFileTypeImpl[3];

            array[0] = (PmlUserFileType) objArray[0];
            array[1] = (PmlUserFileType) objArray[1];
            array[2] = (PmlUserFileType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlUserFileType> findByFileTypeId(String fileTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUserFileType.class.getName();
        String finderMethodName = "findByFileTypeId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileTypeId };

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
                    "FROM com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("userid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlUserFileType> list = q.list();

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
            return (List<PmlUserFileType>) result;
        }
    }

    public List<PmlUserFileType> findByFileTypeId(String fileTypeId, int start,
        int end) throws SystemException {
        return findByFileTypeId(fileTypeId, start, end, null);
    }

    public List<PmlUserFileType> findByFileTypeId(String fileTypeId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUserFileType.class.getName();
        String finderMethodName = "findByFileTypeId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
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
                    "FROM com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
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

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlUserFileType> list = (List<PmlUserFileType>) QueryUtil.list(q,
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
            return (List<PmlUserFileType>) result;
        }
    }

    public PmlUserFileType findByFileTypeId_First(String fileTypeId,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlUserFileType> list = findByFileTypeId(fileTypeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUserFileType exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUserFileType findByFileTypeId_Last(String fileTypeId,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByFileTypeId(fileTypeId);

        List<PmlUserFileType> list = findByFileTypeId(fileTypeId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlUserFileType exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlUserFileType[] findByFileTypeId_PrevAndNext(
        PmlUserFileTypePK pmlUserFileTypePK, String fileTypeId,
        OrderByComparator obc) throws NoSuchException, SystemException {
        PmlUserFileType pmlUserFileType = findByPrimaryKey(pmlUserFileTypePK);

        int count = countByFileTypeId(fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType WHERE ");

            if (fileTypeId == null) {
                query.append("filetypeid IS NULL");
            } else {
                query.append("filetypeid = ?");
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

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlUserFileType);

            PmlUserFileType[] array = new PmlUserFileTypeImpl[3];

            array[0] = (PmlUserFileType) objArray[0];
            array[1] = (PmlUserFileType) objArray[1];
            array[2] = (PmlUserFileType) objArray[2];

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

    public List<PmlUserFileType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlUserFileType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlUserFileType> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUserFileType.class.getName();
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
                    "FROM com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("userid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlUserFileType> list = (List<PmlUserFileType>) QueryUtil.list(q,
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
            return (List<PmlUserFileType>) result;
        }
    }

    public void removeByUserId(long userId) throws SystemException {
        for (PmlUserFileType pmlUserFileType : findByUserId(userId)) {
            remove(pmlUserFileType);
        }
    }

    public void removeByFileTypeId(String fileTypeId) throws SystemException {
        for (PmlUserFileType pmlUserFileType : findByFileTypeId(fileTypeId)) {
            remove(pmlUserFileType);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlUserFileType pmlUserFileType : findAll()) {
            remove(pmlUserFileType);
        }
    }

    public int countByUserId(long userId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUserFileType.class.getName();
        String finderMethodName = "countByUserId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(userId) };

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
                    "FROM com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType WHERE ");

                query.append("userid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

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

    public int countByFileTypeId(String fileTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlUserFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUserFileType.class.getName();
        String finderMethodName = "countByFileTypeId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileTypeId };

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
                    "FROM com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
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
        boolean finderClassNameCacheEnabled = PmlUserFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlUserFileType.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType");

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
                        "value.object.listener.com.sgs.portlet.country.pmluserfiletype.model.PmlUserFileType")));

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
