package com.sgs.portlet.onedoorpccc.service.persistence;

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

import com.sgs.portlet.onedoorpccc.NoSuchPmlTransitionException;
import com.sgs.portlet.onedoorpccc.model.PmlTransition;
import com.sgs.portlet.onedoorpccc.model.impl.PmlTransitionImpl;
import com.sgs.portlet.onedoorpccc.model.impl.PmlTransitionModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlTransitionPersistenceImpl extends BasePersistenceImpl
    implements PmlTransitionPersistence {
    private static Log _log = LogFactory.getLog(PmlTransitionPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlTransition create(long transitionId) {
        PmlTransition pmlTransition = new PmlTransitionImpl();

        pmlTransition.setNew(true);
        pmlTransition.setPrimaryKey(transitionId);

        return pmlTransition;
    }

    public PmlTransition remove(long transitionId)
        throws NoSuchPmlTransitionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlTransition pmlTransition = (PmlTransition) session.get(PmlTransitionImpl.class,
                    new Long(transitionId));

            if (pmlTransition == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlTransition exists with the primary key " +
                        transitionId);
                }

                throw new NoSuchPmlTransitionException(
                    "No PmlTransition exists with the primary key " +
                    transitionId);
            }

            return remove(pmlTransition);
        } catch (NoSuchPmlTransitionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlTransition remove(PmlTransition pmlTransition)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlTransition);
            }
        }

        pmlTransition = removeImpl(pmlTransition);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlTransition);
            }
        }

        return pmlTransition;
    }

    protected PmlTransition removeImpl(PmlTransition pmlTransition)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlTransition);

            session.flush();

            return pmlTransition;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlTransition.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlTransition pmlTransition, boolean merge)</code>.
     */
    public PmlTransition update(PmlTransition pmlTransition)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlTransition pmlTransition) method. Use update(PmlTransition pmlTransition, boolean merge) instead.");
        }

        return update(pmlTransition, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTransition the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTransition is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlTransition update(PmlTransition pmlTransition, boolean merge)
        throws SystemException {
        boolean isNew = pmlTransition.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlTransition);
                } else {
                    listener.onBeforeUpdate(pmlTransition);
                }
            }
        }

        pmlTransition = updateImpl(pmlTransition, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlTransition);
                } else {
                    listener.onAfterUpdate(pmlTransition);
                }
            }
        }

        return pmlTransition;
    }

    public PmlTransition updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlTransition pmlTransition,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlTransition);
            } else {
                if (pmlTransition.isNew()) {
                    session.save(pmlTransition);
                }
            }

            session.flush();

            pmlTransition.setNew(false);

            return pmlTransition;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlTransition.class.getName());
        }
    }

    public PmlTransition findByPrimaryKey(long transitionId)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = fetchByPrimaryKey(transitionId);

        if (pmlTransition == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlTransition exists with the primary key " +
                    transitionId);
            }

            throw new NoSuchPmlTransitionException(
                "No PmlTransition exists with the primary key " + transitionId);
        }

        return pmlTransition;
    }

    public PmlTransition fetchByPrimaryKey(long transitionId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlTransition) session.get(PmlTransitionImpl.class,
                new Long(transitionId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByFileTypeId_Version(String fileTypeId,
        String version_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "findByFileTypeId_Version";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, version_ };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" AND ");

                if (version_ == null) {
                    query.append("version_ IS NULL");
                } else {
                    query.append("version_ = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (version_ != null) {
                    qPos.add(version_);
                }

                List<PmlTransition> list = q.list();

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
            return (List<PmlTransition>) result;
        }
    }

    public List<PmlTransition> findByFileTypeId_Version(String fileTypeId,
        String version_, int start, int end) throws SystemException {
        return findByFileTypeId_Version(fileTypeId, version_, start, end, null);
    }

    public List<PmlTransition> findByFileTypeId_Version(String fileTypeId,
        String version_, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "findByFileTypeId_Version";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                version_,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" AND ");

                if (version_ == null) {
                    query.append("version_ IS NULL");
                } else {
                    query.append("version_ = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (version_ != null) {
                    qPos.add(version_);
                }

                List<PmlTransition> list = (List<PmlTransition>) QueryUtil.list(q,
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
            return (List<PmlTransition>) result;
        }
    }

    public PmlTransition findByFileTypeId_Version_First(String fileTypeId,
        String version_, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByFileTypeId_Version(fileTypeId,
                version_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByFileTypeId_Version_Last(String fileTypeId,
        String version_, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByFileTypeId_Version(fileTypeId, version_);

        List<PmlTransition> list = findByFileTypeId_Version(fileTypeId,
                version_, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByFileTypeId_Version_PrevAndNext(
        long transitionId, String fileTypeId, String version_,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByFileTypeId_Version(fileTypeId, version_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

            if (fileTypeId == null) {
                query.append("filetypeid IS NULL");
            } else {
                query.append("filetypeid = ?");
            }

            query.append(" AND ");

            if (version_ == null) {
                query.append("version_ IS NULL");
            } else {
                query.append("version_ = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            if (version_ != null) {
                qPos.add(version_);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByVersion_(String version_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "findByVersion_";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { version_ };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                if (version_ == null) {
                    query.append("version_ IS NULL");
                } else {
                    query.append("version_ = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (version_ != null) {
                    qPos.add(version_);
                }

                List<PmlTransition> list = q.list();

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
            return (List<PmlTransition>) result;
        }
    }

    public List<PmlTransition> findByVersion_(String version_, int start,
        int end) throws SystemException {
        return findByVersion_(version_, start, end, null);
    }

    public List<PmlTransition> findByVersion_(String version_, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "findByVersion_";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                version_,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                if (version_ == null) {
                    query.append("version_ IS NULL");
                } else {
                    query.append("version_ = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (version_ != null) {
                    qPos.add(version_);
                }

                List<PmlTransition> list = (List<PmlTransition>) QueryUtil.list(q,
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
            return (List<PmlTransition>) result;
        }
    }

    public PmlTransition findByVersion__First(String version_,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByVersion_(version_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByVersion__Last(String version_,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByVersion_(version_);

        List<PmlTransition> list = findByVersion_(version_, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("version_=" + version_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByVersion__PrevAndNext(long transitionId,
        String version_, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByVersion_(version_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

            if (version_ == null) {
                query.append("version_ IS NULL");
            } else {
                query.append("version_ = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (version_ != null) {
                qPos.add(version_);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByTransitionName(String transitionName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "findByTransitionName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { transitionName };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                if (transitionName == null) {
                    query.append("transitionname IS NULL");
                } else {
                    query.append("transitionname = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (transitionName != null) {
                    qPos.add(transitionName);
                }

                List<PmlTransition> list = q.list();

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
            return (List<PmlTransition>) result;
        }
    }

    public List<PmlTransition> findByTransitionName(String transitionName,
        int start, int end) throws SystemException {
        return findByTransitionName(transitionName, start, end, null);
    }

    public List<PmlTransition> findByTransitionName(String transitionName,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "findByTransitionName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                transitionName,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                if (transitionName == null) {
                    query.append("transitionname IS NULL");
                } else {
                    query.append("transitionname = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (transitionName != null) {
                    qPos.add(transitionName);
                }

                List<PmlTransition> list = (List<PmlTransition>) QueryUtil.list(q,
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
            return (List<PmlTransition>) result;
        }
    }

    public PmlTransition findByTransitionName_First(String transitionName,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByTransitionName(transitionName, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("transitionName=" + transitionName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByTransitionName_Last(String transitionName,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByTransitionName(transitionName);

        List<PmlTransition> list = findByTransitionName(transitionName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("transitionName=" + transitionName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByTransitionName_PrevAndNext(long transitionId,
        String transitionName, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByTransitionName(transitionName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

            if (transitionName == null) {
                query.append("transitionname IS NULL");
            } else {
                query.append("transitionname = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (transitionName != null) {
                qPos.add(transitionName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByFileTypeId(String fileTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlTransition> list = q.list();

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
            return (List<PmlTransition>) result;
        }
    }

    public List<PmlTransition> findByFileTypeId(String fileTypeId, int start,
        int end) throws SystemException {
        return findByFileTypeId(fileTypeId, start, end, null);
    }

    public List<PmlTransition> findByFileTypeId(String fileTypeId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

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

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlTransition> list = (List<PmlTransition>) QueryUtil.list(q,
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
            return (List<PmlTransition>) result;
        }
    }

    public PmlTransition findByFileTypeId_First(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByFileTypeId(fileTypeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByFileTypeId_Last(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByFileTypeId(fileTypeId);

        List<PmlTransition> list = findByFileTypeId(fileTypeId, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByFileTypeId_PrevAndNext(long transitionId,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByFileTypeId(fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

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

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByNoTransition(int noTransition)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "findByNoTransition";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(noTransition) };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                query.append("notransition = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(noTransition);

                List<PmlTransition> list = q.list();

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
            return (List<PmlTransition>) result;
        }
    }

    public List<PmlTransition> findByNoTransition(int noTransition, int start,
        int end) throws SystemException {
        return findByNoTransition(noTransition, start, end, null);
    }

    public List<PmlTransition> findByNoTransition(int noTransition, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "findByNoTransition";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(noTransition),
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                query.append("notransition = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(noTransition);

                List<PmlTransition> list = (List<PmlTransition>) QueryUtil.list(q,
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
            return (List<PmlTransition>) result;
        }
    }

    public PmlTransition findByNoTransition_First(int noTransition,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByNoTransition(noTransition, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("noTransition=" + noTransition);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByNoTransition_Last(int noTransition,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByNoTransition(noTransition);

        List<PmlTransition> list = findByNoTransition(noTransition, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("noTransition=" + noTransition);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByNoTransition_PrevAndNext(long transitionId,
        int noTransition, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByNoTransition(noTransition);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

            query.append("notransition = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(noTransition);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByStateProcessCurrent(
        long stateProcessCurrent) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "findByStateProcessCurrent";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessCurrent) };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                query.append("stateprocesscurrent = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessCurrent);

                List<PmlTransition> list = q.list();

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
            return (List<PmlTransition>) result;
        }
    }

    public List<PmlTransition> findByStateProcessCurrent(
        long stateProcessCurrent, int start, int end) throws SystemException {
        return findByStateProcessCurrent(stateProcessCurrent, start, end, null);
    }

    public List<PmlTransition> findByStateProcessCurrent(
        long stateProcessCurrent, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "findByStateProcessCurrent";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(stateProcessCurrent),
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                query.append("stateprocesscurrent = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessCurrent);

                List<PmlTransition> list = (List<PmlTransition>) QueryUtil.list(q,
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
            return (List<PmlTransition>) result;
        }
    }

    public PmlTransition findByStateProcessCurrent_First(
        long stateProcessCurrent, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByStateProcessCurrent(stateProcessCurrent,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("stateProcessCurrent=" + stateProcessCurrent);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByStateProcessCurrent_Last(
        long stateProcessCurrent, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByStateProcessCurrent(stateProcessCurrent);

        List<PmlTransition> list = findByStateProcessCurrent(stateProcessCurrent,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("stateProcessCurrent=" + stateProcessCurrent);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByStateProcessCurrent_PrevAndNext(
        long transitionId, long stateProcessCurrent, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByStateProcessCurrent(stateProcessCurrent);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

            query.append("stateprocesscurrent = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessCurrent);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlTransition> findByStateProcessNext(long stateProcessNext)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "findByStateProcessNext";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessNext) };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                query.append("stateprocessnext = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("transitionid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessNext);

                List<PmlTransition> list = q.list();

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
            return (List<PmlTransition>) result;
        }
    }

    public List<PmlTransition> findByStateProcessNext(long stateProcessNext,
        int start, int end) throws SystemException {
        return findByStateProcessNext(stateProcessNext, start, end, null);
    }

    public List<PmlTransition> findByStateProcessNext(long stateProcessNext,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "findByStateProcessNext";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(stateProcessNext),
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                query.append("stateprocessnext = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessNext);

                List<PmlTransition> list = (List<PmlTransition>) QueryUtil.list(q,
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
            return (List<PmlTransition>) result;
        }
    }

    public PmlTransition findByStateProcessNext_First(long stateProcessNext,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        List<PmlTransition> list = findByStateProcessNext(stateProcessNext, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("stateProcessNext=" + stateProcessNext);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition findByStateProcessNext_Last(long stateProcessNext,
        OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        int count = countByStateProcessNext(stateProcessNext);

        List<PmlTransition> list = findByStateProcessNext(stateProcessNext,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlTransition exists with the key {");

            msg.append("stateProcessNext=" + stateProcessNext);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlTransitionException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlTransition[] findByStateProcessNext_PrevAndNext(
        long transitionId, long stateProcessNext, OrderByComparator obc)
        throws NoSuchPmlTransitionException, SystemException {
        PmlTransition pmlTransition = findByPrimaryKey(transitionId);

        int count = countByStateProcessNext(stateProcessNext);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

            query.append("stateprocessnext = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("transitionid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(stateProcessNext);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlTransition);

            PmlTransition[] array = new PmlTransitionImpl[3];

            array[0] = (PmlTransition) objArray[0];
            array[1] = (PmlTransition) objArray[1];
            array[2] = (PmlTransition) objArray[2];

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

    public List<PmlTransition> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlTransition> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlTransition> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("transitionid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlTransition> list = (List<PmlTransition>) QueryUtil.list(q,
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
            return (List<PmlTransition>) result;
        }
    }

    public void removeByFileTypeId_Version(String fileTypeId, String version_)
        throws SystemException {
        for (PmlTransition pmlTransition : findByFileTypeId_Version(
                fileTypeId, version_)) {
            remove(pmlTransition);
        }
    }

    public void removeByVersion_(String version_) throws SystemException {
        for (PmlTransition pmlTransition : findByVersion_(version_)) {
            remove(pmlTransition);
        }
    }

    public void removeByTransitionName(String transitionName)
        throws SystemException {
        for (PmlTransition pmlTransition : findByTransitionName(transitionName)) {
            remove(pmlTransition);
        }
    }

    public void removeByFileTypeId(String fileTypeId) throws SystemException {
        for (PmlTransition pmlTransition : findByFileTypeId(fileTypeId)) {
            remove(pmlTransition);
        }
    }

    public void removeByNoTransition(int noTransition)
        throws SystemException {
        for (PmlTransition pmlTransition : findByNoTransition(noTransition)) {
            remove(pmlTransition);
        }
    }

    public void removeByStateProcessCurrent(long stateProcessCurrent)
        throws SystemException {
        for (PmlTransition pmlTransition : findByStateProcessCurrent(
                stateProcessCurrent)) {
            remove(pmlTransition);
        }
    }

    public void removeByStateProcessNext(long stateProcessNext)
        throws SystemException {
        for (PmlTransition pmlTransition : findByStateProcessNext(
                stateProcessNext)) {
            remove(pmlTransition);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlTransition pmlTransition : findAll()) {
            remove(pmlTransition);
        }
    }

    public int countByFileTypeId_Version(String fileTypeId, String version_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "countByFileTypeId_Version";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, version_ };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                if (fileTypeId == null) {
                    query.append("filetypeid IS NULL");
                } else {
                    query.append("filetypeid = ?");
                }

                query.append(" AND ");

                if (version_ == null) {
                    query.append("version_ IS NULL");
                } else {
                    query.append("version_ = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (version_ != null) {
                    qPos.add(version_);
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

    public int countByVersion_(String version_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "countByVersion_";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { version_ };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                if (version_ == null) {
                    query.append("version_ IS NULL");
                } else {
                    query.append("version_ = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (version_ != null) {
                    qPos.add(version_);
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

    public int countByTransitionName(String transitionName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "countByTransitionName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { transitionName };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                if (transitionName == null) {
                    query.append("transitionname IS NULL");
                } else {
                    query.append("transitionname = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (transitionName != null) {
                    qPos.add(transitionName);
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

    public int countByFileTypeId(String fileTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

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

    public int countByNoTransition(int noTransition) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "countByNoTransition";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(noTransition) };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                query.append("notransition = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(noTransition);

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

    public int countByStateProcessCurrent(long stateProcessCurrent)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "countByStateProcessCurrent";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessCurrent) };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                query.append("stateprocesscurrent = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessCurrent);

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

    public int countByStateProcessNext(long stateProcessNext)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
        String finderMethodName = "countByStateProcessNext";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(stateProcessNext) };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlTransition WHERE ");

                query.append("stateprocessnext = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(stateProcessNext);

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
        boolean finderClassNameCacheEnabled = PmlTransitionModelImpl.CACHE_ENABLED;
        String finderClassName = PmlTransition.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoorpccc.model.PmlTransition");

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
                        "value.object.listener.com.sgs.portlet.onedoorpccc.model.PmlTransition")));

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
