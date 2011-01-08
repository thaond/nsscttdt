package com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.persistence;

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

import com.sgs.portlet.document.delegate.pmlfiletypedelegate.NoSuchException;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.impl.PmlFileTypeDelegateImpl;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.impl.PmlFileTypeDelegateModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlFileTypeDelegatePersistenceImpl extends BasePersistenceImpl
    implements PmlFileTypeDelegatePersistence {
    private static Log _log = LogFactory.getLog(PmlFileTypeDelegatePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlFileTypeDelegate create(long fileTypeDelegateId) {
        PmlFileTypeDelegate pmlFileTypeDelegate = new PmlFileTypeDelegateImpl();

        pmlFileTypeDelegate.setNew(true);
        pmlFileTypeDelegate.setPrimaryKey(fileTypeDelegateId);

        return pmlFileTypeDelegate;
    }

    public PmlFileTypeDelegate remove(long fileTypeDelegateId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileTypeDelegate pmlFileTypeDelegate = (PmlFileTypeDelegate) session.get(PmlFileTypeDelegateImpl.class,
                    new Long(fileTypeDelegateId));

            if (pmlFileTypeDelegate == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlFileTypeDelegate exists with the primary key " +
                        fileTypeDelegateId);
                }

                throw new NoSuchException(
                    "No PmlFileTypeDelegate exists with the primary key " +
                    fileTypeDelegateId);
            }

            return remove(pmlFileTypeDelegate);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileTypeDelegate remove(PmlFileTypeDelegate pmlFileTypeDelegate)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlFileTypeDelegate);
            }
        }

        pmlFileTypeDelegate = removeImpl(pmlFileTypeDelegate);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlFileTypeDelegate);
            }
        }

        return pmlFileTypeDelegate;
    }

    protected PmlFileTypeDelegate removeImpl(
        PmlFileTypeDelegate pmlFileTypeDelegate) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlFileTypeDelegate);

            session.flush();

            return pmlFileTypeDelegate;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileTypeDelegate.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlFileTypeDelegate pmlFileTypeDelegate, boolean merge)</code>.
     */
    public PmlFileTypeDelegate update(PmlFileTypeDelegate pmlFileTypeDelegate)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileTypeDelegate pmlFileTypeDelegate) method. Use update(PmlFileTypeDelegate pmlFileTypeDelegate, boolean merge) instead.");
        }

        return update(pmlFileTypeDelegate, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileTypeDelegate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileTypeDelegate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileTypeDelegate update(PmlFileTypeDelegate pmlFileTypeDelegate,
        boolean merge) throws SystemException {
        boolean isNew = pmlFileTypeDelegate.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlFileTypeDelegate);
                } else {
                    listener.onBeforeUpdate(pmlFileTypeDelegate);
                }
            }
        }

        pmlFileTypeDelegate = updateImpl(pmlFileTypeDelegate, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlFileTypeDelegate);
                } else {
                    listener.onAfterUpdate(pmlFileTypeDelegate);
                }
            }
        }

        return pmlFileTypeDelegate;
    }

    public PmlFileTypeDelegate updateImpl(
        com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate pmlFileTypeDelegate,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlFileTypeDelegate);
            } else {
                if (pmlFileTypeDelegate.isNew()) {
                    session.save(pmlFileTypeDelegate);
                }
            }

            session.flush();

            pmlFileTypeDelegate.setNew(false);

            return pmlFileTypeDelegate;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileTypeDelegate.class.getName());
        }
    }

    public PmlFileTypeDelegate findByPrimaryKey(long fileTypeDelegateId)
        throws NoSuchException, SystemException {
        PmlFileTypeDelegate pmlFileTypeDelegate = fetchByPrimaryKey(fileTypeDelegateId);

        if (pmlFileTypeDelegate == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlFileTypeDelegate exists with the primary key " +
                    fileTypeDelegateId);
            }

            throw new NoSuchException(
                "No PmlFileTypeDelegate exists with the primary key " +
                fileTypeDelegateId);
        }

        return pmlFileTypeDelegate;
    }

    public PmlFileTypeDelegate fetchByPrimaryKey(long fileTypeDelegateId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlFileTypeDelegate) session.get(PmlFileTypeDelegateImpl.class,
                new Long(fileTypeDelegateId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeDelegate> findByFileTypeId_DelegateId(
        String fileTypeId, long delegateId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeDelegate.class.getName();
        String finderMethodName = "findByFileTypeId_DelegateId";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, new Long(delegateId) };

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
                    "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" AND ");

                query.append("delegateid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypedelegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                qPos.add(delegateId);

                List<PmlFileTypeDelegate> list = q.list();

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
            return (List<PmlFileTypeDelegate>) result;
        }
    }

    public List<PmlFileTypeDelegate> findByFileTypeId_DelegateId(
        String fileTypeId, long delegateId, int start, int end)
        throws SystemException {
        return findByFileTypeId_DelegateId(fileTypeId, delegateId, start, end,
            null);
    }

    public List<PmlFileTypeDelegate> findByFileTypeId_DelegateId(
        String fileTypeId, long delegateId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeDelegate.class.getName();
        String finderMethodName = "findByFileTypeId_DelegateId";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileTypeId, new Long(delegateId),
                
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
                    "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" AND ");

                query.append("delegateid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypedelegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                qPos.add(delegateId);

                List<PmlFileTypeDelegate> list = (List<PmlFileTypeDelegate>) QueryUtil.list(q,
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
            return (List<PmlFileTypeDelegate>) result;
        }
    }

    public PmlFileTypeDelegate findByFileTypeId_DelegateId_First(
        String fileTypeId, long delegateId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        List<PmlFileTypeDelegate> list = findByFileTypeId_DelegateId(fileTypeId,
                delegateId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeDelegate exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("delegateId=" + delegateId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeDelegate findByFileTypeId_DelegateId_Last(
        String fileTypeId, long delegateId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        int count = countByFileTypeId_DelegateId(fileTypeId, delegateId);

        List<PmlFileTypeDelegate> list = findByFileTypeId_DelegateId(fileTypeId,
                delegateId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeDelegate exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("delegateId=" + delegateId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeDelegate[] findByFileTypeId_DelegateId_PrevAndNext(
        long fileTypeDelegateId, String fileTypeId, long delegateId,
        OrderByComparator obc) throws NoSuchException, SystemException {
        PmlFileTypeDelegate pmlFileTypeDelegate = findByPrimaryKey(fileTypeDelegateId);

        int count = countByFileTypeId_DelegateId(fileTypeId, delegateId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate WHERE ");

            if (fileTypeId == null) {
                query.append("filetypeid IS NULL");
            } else {
                query.append("filetypeid = ?");
            }

            query.append(" AND ");

            query.append("delegateid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypedelegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            qPos.add(delegateId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeDelegate);

            PmlFileTypeDelegate[] array = new PmlFileTypeDelegateImpl[3];

            array[0] = (PmlFileTypeDelegate) objArray[0];
            array[1] = (PmlFileTypeDelegate) objArray[1];
            array[2] = (PmlFileTypeDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeDelegate> findByFileTypeId(String fileTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeDelegate.class.getName();
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
                    "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypedelegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlFileTypeDelegate> list = q.list();

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
            return (List<PmlFileTypeDelegate>) result;
        }
    }

    public List<PmlFileTypeDelegate> findByFileTypeId(String fileTypeId,
        int start, int end) throws SystemException {
        return findByFileTypeId(fileTypeId, start, end, null);
    }

    public List<PmlFileTypeDelegate> findByFileTypeId(String fileTypeId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeDelegate.class.getName();
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
                    "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate WHERE ");

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

                    query.append("filetypedelegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlFileTypeDelegate> list = (List<PmlFileTypeDelegate>) QueryUtil.list(q,
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
            return (List<PmlFileTypeDelegate>) result;
        }
    }

    public PmlFileTypeDelegate findByFileTypeId_First(String fileTypeId,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlFileTypeDelegate> list = findByFileTypeId(fileTypeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeDelegate exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeDelegate findByFileTypeId_Last(String fileTypeId,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByFileTypeId(fileTypeId);

        List<PmlFileTypeDelegate> list = findByFileTypeId(fileTypeId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeDelegate exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeDelegate[] findByFileTypeId_PrevAndNext(
        long fileTypeDelegateId, String fileTypeId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlFileTypeDelegate pmlFileTypeDelegate = findByPrimaryKey(fileTypeDelegateId);

        int count = countByFileTypeId(fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate WHERE ");

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

                query.append("filetypedelegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeDelegate);

            PmlFileTypeDelegate[] array = new PmlFileTypeDelegateImpl[3];

            array[0] = (PmlFileTypeDelegate) objArray[0];
            array[1] = (PmlFileTypeDelegate) objArray[1];
            array[2] = (PmlFileTypeDelegate) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeDelegate> findByDelegateId(long delegateId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeDelegate.class.getName();
        String finderMethodName = "findByDelegateId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(delegateId) };

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
                    "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate WHERE ");

                query.append("delegateid = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypedelegateid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(delegateId);

                List<PmlFileTypeDelegate> list = q.list();

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
            return (List<PmlFileTypeDelegate>) result;
        }
    }

    public List<PmlFileTypeDelegate> findByDelegateId(long delegateId,
        int start, int end) throws SystemException {
        return findByDelegateId(delegateId, start, end, null);
    }

    public List<PmlFileTypeDelegate> findByDelegateId(long delegateId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeDelegate.class.getName();
        String finderMethodName = "findByDelegateId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(delegateId),
                
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
                    "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate WHERE ");

                query.append("delegateid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypedelegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(delegateId);

                List<PmlFileTypeDelegate> list = (List<PmlFileTypeDelegate>) QueryUtil.list(q,
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
            return (List<PmlFileTypeDelegate>) result;
        }
    }

    public PmlFileTypeDelegate findByDelegateId_First(long delegateId,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlFileTypeDelegate> list = findByDelegateId(delegateId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeDelegate exists with the key {");

            msg.append("delegateId=" + delegateId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeDelegate findByDelegateId_Last(long delegateId,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByDelegateId(delegateId);

        List<PmlFileTypeDelegate> list = findByDelegateId(delegateId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeDelegate exists with the key {");

            msg.append("delegateId=" + delegateId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeDelegate[] findByDelegateId_PrevAndNext(
        long fileTypeDelegateId, long delegateId, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlFileTypeDelegate pmlFileTypeDelegate = findByPrimaryKey(fileTypeDelegateId);

        int count = countByDelegateId(delegateId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate WHERE ");

            query.append("delegateid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypedelegateid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(delegateId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeDelegate);

            PmlFileTypeDelegate[] array = new PmlFileTypeDelegateImpl[3];

            array[0] = (PmlFileTypeDelegate) objArray[0];
            array[1] = (PmlFileTypeDelegate) objArray[1];
            array[2] = (PmlFileTypeDelegate) objArray[2];

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

    public List<PmlFileTypeDelegate> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileTypeDelegate> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileTypeDelegate> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeDelegate.class.getName();
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
                    "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypedelegateid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlFileTypeDelegate> list = (List<PmlFileTypeDelegate>) QueryUtil.list(q,
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
            return (List<PmlFileTypeDelegate>) result;
        }
    }

    public void removeByFileTypeId_DelegateId(String fileTypeId, long delegateId)
        throws SystemException {
        for (PmlFileTypeDelegate pmlFileTypeDelegate : findByFileTypeId_DelegateId(
                fileTypeId, delegateId)) {
            remove(pmlFileTypeDelegate);
        }
    }

    public void removeByFileTypeId(String fileTypeId) throws SystemException {
        for (PmlFileTypeDelegate pmlFileTypeDelegate : findByFileTypeId(
                fileTypeId)) {
            remove(pmlFileTypeDelegate);
        }
    }

    public void removeByDelegateId(long delegateId) throws SystemException {
        for (PmlFileTypeDelegate pmlFileTypeDelegate : findByDelegateId(
                delegateId)) {
            remove(pmlFileTypeDelegate);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFileTypeDelegate pmlFileTypeDelegate : findAll()) {
            remove(pmlFileTypeDelegate);
        }
    }

    public int countByFileTypeId_DelegateId(String fileTypeId, long delegateId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeDelegate.class.getName();
        String finderMethodName = "countByFileTypeId_DelegateId";
        String[] finderParams = new String[] {
                String.class.getName(), Long.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, new Long(delegateId) };

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
                    "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" AND ");

                query.append("delegateid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                qPos.add(delegateId);

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
        boolean finderClassNameCacheEnabled = PmlFileTypeDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeDelegate.class.getName();
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
                    "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate WHERE ");

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

    public int countByDelegateId(long delegateId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeDelegate.class.getName();
        String finderMethodName = "countByDelegateId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(delegateId) };

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
                    "FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate WHERE ");

                query.append("delegateid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(delegateId);

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
        boolean finderClassNameCacheEnabled = PmlFileTypeDelegateModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeDelegate.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate");

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
                        "value.object.listener.com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate")));

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
