package com.sgs.portlet.document.receipt.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sgs.portlet.document.receipt.NoSuchPmlEdmAttachedFileException;
import com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileImpl;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmAttachedFileModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlEdmAttachedFilePersistenceImpl extends BasePersistenceImpl
    implements PmlEdmAttachedFilePersistence {
    private static Log _log = LogFactory.getLog(PmlEdmAttachedFilePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlEdmAttachedFile create(long attachedFileId) {
        PmlEdmAttachedFile pmlEdmAttachedFile = new PmlEdmAttachedFileImpl();

        pmlEdmAttachedFile.setNew(true);
        pmlEdmAttachedFile.setPrimaryKey(attachedFileId);

        return pmlEdmAttachedFile;
    }

    public PmlEdmAttachedFile remove(long attachedFileId)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlEdmAttachedFile pmlEdmAttachedFile = (PmlEdmAttachedFile) session.get(PmlEdmAttachedFileImpl.class,
                    new Long(attachedFileId));

            if (pmlEdmAttachedFile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlEdmAttachedFile exists with the primary key " +
                        attachedFileId);
                }

                throw new NoSuchPmlEdmAttachedFileException(
                    "No PmlEdmAttachedFile exists with the primary key " +
                    attachedFileId);
            }

            return remove(pmlEdmAttachedFile);
        } catch (NoSuchPmlEdmAttachedFileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlEdmAttachedFile remove(PmlEdmAttachedFile pmlEdmAttachedFile)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlEdmAttachedFile);
            }
        }

        pmlEdmAttachedFile = removeImpl(pmlEdmAttachedFile);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlEdmAttachedFile);
            }
        }

        return pmlEdmAttachedFile;
    }

    protected PmlEdmAttachedFile removeImpl(
        PmlEdmAttachedFile pmlEdmAttachedFile) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlEdmAttachedFile);

            session.flush();

            return pmlEdmAttachedFile;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmAttachedFile.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlEdmAttachedFile pmlEdmAttachedFile, boolean merge)</code>.
     */
    public PmlEdmAttachedFile update(PmlEdmAttachedFile pmlEdmAttachedFile)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlEdmAttachedFile pmlEdmAttachedFile) method. Use update(PmlEdmAttachedFile pmlEdmAttachedFile, boolean merge) instead.");
        }

        return update(pmlEdmAttachedFile, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmAttachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmAttachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlEdmAttachedFile update(PmlEdmAttachedFile pmlEdmAttachedFile,
        boolean merge) throws SystemException {
        boolean isNew = pmlEdmAttachedFile.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlEdmAttachedFile);
                } else {
                    listener.onBeforeUpdate(pmlEdmAttachedFile);
                }
            }
        }

        pmlEdmAttachedFile = updateImpl(pmlEdmAttachedFile, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlEdmAttachedFile);
                } else {
                    listener.onAfterUpdate(pmlEdmAttachedFile);
                }
            }
        }

        return pmlEdmAttachedFile;
    }

    public PmlEdmAttachedFile updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile pmlEdmAttachedFile,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlEdmAttachedFile);
            } else {
                if (pmlEdmAttachedFile.isNew()) {
                    session.save(pmlEdmAttachedFile);
                }
            }

            session.flush();

            pmlEdmAttachedFile.setNew(false);

            return pmlEdmAttachedFile;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlEdmAttachedFile.class.getName());
        }
    }

    public PmlEdmAttachedFile findByPrimaryKey(long attachedFileId)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        PmlEdmAttachedFile pmlEdmAttachedFile = fetchByPrimaryKey(attachedFileId);

        if (pmlEdmAttachedFile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlEdmAttachedFile exists with the primary key " +
                    attachedFileId);
            }

            throw new NoSuchPmlEdmAttachedFileException(
                "No PmlEdmAttachedFile exists with the primary key " +
                attachedFileId);
        }

        return pmlEdmAttachedFile;
    }

    public PmlEdmAttachedFile fetchByPrimaryKey(long attachedFileId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlEdmAttachedFile) session.get(PmlEdmAttachedFileImpl.class,
                new Long(attachedFileId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmAttachedFile> findByObjectContentId(long objectContentId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByObjectContentId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(objectContentId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                query.append("objectcontentid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(objectContentId);

                List<PmlEdmAttachedFile> list = q.list();

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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public List<PmlEdmAttachedFile> findByObjectContentId(
        long objectContentId, int start, int end) throws SystemException {
        return findByObjectContentId(objectContentId, start, end, null);
    }

    public List<PmlEdmAttachedFile> findByObjectContentId(
        long objectContentId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByObjectContentId";
        String[] finderParams = new String[] {
                Long.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(objectContentId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                query.append("objectcontentid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(objectContentId);

                List<PmlEdmAttachedFile> list = (List<PmlEdmAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public PmlEdmAttachedFile findByObjectContentId_First(
        long objectContentId, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        List<PmlEdmAttachedFile> list = findByObjectContentId(objectContentId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("objectContentId=" + objectContentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile findByObjectContentId_Last(long objectContentId,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        int count = countByObjectContentId(objectContentId);

        List<PmlEdmAttachedFile> list = findByObjectContentId(objectContentId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("objectContentId=" + objectContentId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile[] findByObjectContentId_PrevAndNext(
        long attachedFileId, long objectContentId, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        PmlEdmAttachedFile pmlEdmAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByObjectContentId(objectContentId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

            query.append("objectcontentid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(objectContentId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmAttachedFile);

            PmlEdmAttachedFile[] array = new PmlEdmAttachedFileImpl[3];

            array[0] = (PmlEdmAttachedFile) objArray[0];
            array[1] = (PmlEdmAttachedFile) objArray[1];
            array[2] = (PmlEdmAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmAttachedFile> findByObjectType(String objectType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByObjectType";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { objectType };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (objectType == null) {
                    query.append("objecttype LIKE null");
                } else {
                    query.append("objecttype LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                List<PmlEdmAttachedFile> list = q.list();

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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public List<PmlEdmAttachedFile> findByObjectType(String objectType,
        int start, int end) throws SystemException {
        return findByObjectType(objectType, start, end, null);
    }

    public List<PmlEdmAttachedFile> findByObjectType(String objectType,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByObjectType";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                objectType,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (objectType == null) {
                    query.append("objecttype LIKE null");
                } else {
                    query.append("objecttype LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                List<PmlEdmAttachedFile> list = (List<PmlEdmAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public PmlEdmAttachedFile findByObjectType_First(String objectType,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        List<PmlEdmAttachedFile> list = findByObjectType(objectType, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile findByObjectType_Last(String objectType,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        int count = countByObjectType(objectType);

        List<PmlEdmAttachedFile> list = findByObjectType(objectType, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile[] findByObjectType_PrevAndNext(
        long attachedFileId, String objectType, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        PmlEdmAttachedFile pmlEdmAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByObjectType(objectType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

            if (objectType == null) {
                query.append("objecttype LIKE null");
            } else {
                query.append("objecttype LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (objectType != null) {
                qPos.add(objectType);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmAttachedFile);

            PmlEdmAttachedFile[] array = new PmlEdmAttachedFileImpl[3];

            array[0] = (PmlEdmAttachedFile) objArray[0];
            array[1] = (PmlEdmAttachedFile) objArray[1];
            array[2] = (PmlEdmAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmAttachedFile> findByAttachedFileName(
        String attachedFileName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByAttachedFileName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { attachedFileName };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("attachedfilename LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                List<PmlEdmAttachedFile> list = q.list();

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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public List<PmlEdmAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end) throws SystemException {
        return findByAttachedFileName(attachedFileName, start, end, null);
    }

    public List<PmlEdmAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByAttachedFileName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                attachedFileName,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("attachedfilename LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                List<PmlEdmAttachedFile> list = (List<PmlEdmAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public PmlEdmAttachedFile findByAttachedFileName_First(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        List<PmlEdmAttachedFile> list = findByAttachedFileName(attachedFileName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile findByAttachedFileName_Last(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        int count = countByAttachedFileName(attachedFileName);

        List<PmlEdmAttachedFile> list = findByAttachedFileName(attachedFileName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile[] findByAttachedFileName_PrevAndNext(
        long attachedFileId, String attachedFileName, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        PmlEdmAttachedFile pmlEdmAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByAttachedFileName(attachedFileName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

            if (attachedFileName == null) {
                query.append("attachedfilename LIKE null");
            } else {
                query.append("attachedfilename LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmAttachedFile);

            PmlEdmAttachedFile[] array = new PmlEdmAttachedFileImpl[3];

            array[0] = (PmlEdmAttachedFile) objArray[0];
            array[1] = (PmlEdmAttachedFile) objArray[1];
            array[2] = (PmlEdmAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmAttachedFile> findByPath(String path)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByPath";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { path };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (path == null) {
                    query.append("path LIKE null");
                } else {
                    query.append("path LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (path != null) {
                    qPos.add(path);
                }

                List<PmlEdmAttachedFile> list = q.list();

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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public List<PmlEdmAttachedFile> findByPath(String path, int start, int end)
        throws SystemException {
        return findByPath(path, start, end, null);
    }

    public List<PmlEdmAttachedFile> findByPath(String path, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByPath";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                path,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (path == null) {
                    query.append("path LIKE null");
                } else {
                    query.append("path LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (path != null) {
                    qPos.add(path);
                }

                List<PmlEdmAttachedFile> list = (List<PmlEdmAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public PmlEdmAttachedFile findByPath_First(String path,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        List<PmlEdmAttachedFile> list = findByPath(path, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("path=" + path);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile findByPath_Last(String path, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        int count = countByPath(path);

        List<PmlEdmAttachedFile> list = findByPath(path, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("path=" + path);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile[] findByPath_PrevAndNext(long attachedFileId,
        String path, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        PmlEdmAttachedFile pmlEdmAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByPath(path);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

            if (path == null) {
                query.append("path LIKE null");
            } else {
                query.append("path LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (path != null) {
                qPos.add(path);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmAttachedFile);

            PmlEdmAttachedFile[] array = new PmlEdmAttachedFileImpl[3];

            array[0] = (PmlEdmAttachedFile) objArray[0];
            array[1] = (PmlEdmAttachedFile) objArray[1];
            array[2] = (PmlEdmAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmAttachedFile> findByDateCreated(Date dateCreated)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByDateCreated";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateCreated };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (dateCreated == null) {
                    query.append("datecreated IS NULL");
                } else {
                    query.append("datecreated = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                List<PmlEdmAttachedFile> list = q.list();

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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public List<PmlEdmAttachedFile> findByDateCreated(Date dateCreated,
        int start, int end) throws SystemException {
        return findByDateCreated(dateCreated, start, end, null);
    }

    public List<PmlEdmAttachedFile> findByDateCreated(Date dateCreated,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByDateCreated";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                dateCreated,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (dateCreated == null) {
                    query.append("datecreated IS NULL");
                } else {
                    query.append("datecreated = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                List<PmlEdmAttachedFile> list = (List<PmlEdmAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public PmlEdmAttachedFile findByDateCreated_First(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        List<PmlEdmAttachedFile> list = findByDateCreated(dateCreated, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile findByDateCreated_Last(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        int count = countByDateCreated(dateCreated);

        List<PmlEdmAttachedFile> list = findByDateCreated(dateCreated,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile[] findByDateCreated_PrevAndNext(
        long attachedFileId, Date dateCreated, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        PmlEdmAttachedFile pmlEdmAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByDateCreated(dateCreated);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

            if (dateCreated == null) {
                query.append("datecreated IS NULL");
            } else {
                query.append("datecreated = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateCreated != null) {
                qPos.add(CalendarUtil.getTimestamp(dateCreated));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmAttachedFile);

            PmlEdmAttachedFile[] array = new PmlEdmAttachedFileImpl[3];

            array[0] = (PmlEdmAttachedFile) objArray[0];
            array[1] = (PmlEdmAttachedFile) objArray[1];
            array[2] = (PmlEdmAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmAttachedFile> findByFileType(String fileType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByFileType";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileType };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (fileType == null) {
                    query.append("filetype LIKE null");
                } else {
                    query.append("filetype LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileType != null) {
                    qPos.add(fileType);
                }

                List<PmlEdmAttachedFile> list = q.list();

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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public List<PmlEdmAttachedFile> findByFileType(String fileType, int start,
        int end) throws SystemException {
        return findByFileType(fileType, start, end, null);
    }

    public List<PmlEdmAttachedFile> findByFileType(String fileType, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByFileType";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileType,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (fileType == null) {
                    query.append("filetype LIKE null");
                } else {
                    query.append("filetype LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileType != null) {
                    qPos.add(fileType);
                }

                List<PmlEdmAttachedFile> list = (List<PmlEdmAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public PmlEdmAttachedFile findByFileType_First(String fileType,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        List<PmlEdmAttachedFile> list = findByFileType(fileType, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("fileType=" + fileType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile findByFileType_Last(String fileType,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        int count = countByFileType(fileType);

        List<PmlEdmAttachedFile> list = findByFileType(fileType, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("fileType=" + fileType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile[] findByFileType_PrevAndNext(
        long attachedFileId, String fileType, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        PmlEdmAttachedFile pmlEdmAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByFileType(fileType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

            if (fileType == null) {
                query.append("filetype LIKE null");
            } else {
                query.append("filetype LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileType != null) {
                qPos.add(fileType);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmAttachedFile);

            PmlEdmAttachedFile[] array = new PmlEdmAttachedFileImpl[3];

            array[0] = (PmlEdmAttachedFile) objArray[0];
            array[1] = (PmlEdmAttachedFile) objArray[1];
            array[2] = (PmlEdmAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmAttachedFile> findByFileId(int fileId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByFileId";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(fileId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                query.append("fileid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileId);

                List<PmlEdmAttachedFile> list = q.list();

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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public List<PmlEdmAttachedFile> findByFileId(int fileId, int start, int end)
        throws SystemException {
        return findByFileId(fileId, start, end, null);
    }

    public List<PmlEdmAttachedFile> findByFileId(int fileId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByFileId";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(fileId),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                query.append("fileid = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileId);

                List<PmlEdmAttachedFile> list = (List<PmlEdmAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public PmlEdmAttachedFile findByFileId_First(int fileId,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        List<PmlEdmAttachedFile> list = findByFileId(fileId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile findByFileId_Last(int fileId,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        int count = countByFileId(fileId);

        List<PmlEdmAttachedFile> list = findByFileId(fileId, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile[] findByFileId_PrevAndNext(long attachedFileId,
        int fileId, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        PmlEdmAttachedFile pmlEdmAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByFileId(fileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

            query.append("fileid = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(fileId);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmAttachedFile);

            PmlEdmAttachedFile[] array = new PmlEdmAttachedFileImpl[3];

            array[0] = (PmlEdmAttachedFile) objArray[0];
            array[1] = (PmlEdmAttachedFile) objArray[1];
            array[2] = (PmlEdmAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmAttachedFile> findByObjectContentId_ObjectType(
        long objectContentId, String objectType) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByObjectContentId_ObjectType";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(objectContentId), objectType };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                query.append("objectcontentid = ?");

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objecttype IS NULL");
                } else {
                    query.append("objecttype = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(objectContentId);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                List<PmlEdmAttachedFile> list = q.list();

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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public List<PmlEdmAttachedFile> findByObjectContentId_ObjectType(
        long objectContentId, String objectType, int start, int end)
        throws SystemException {
        return findByObjectContentId_ObjectType(objectContentId, objectType,
            start, end, null);
    }

    public List<PmlEdmAttachedFile> findByObjectContentId_ObjectType(
        long objectContentId, String objectType, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByObjectContentId_ObjectType";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(objectContentId),
                
                objectType,
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                query.append("objectcontentid = ?");

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objecttype IS NULL");
                } else {
                    query.append("objecttype = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(objectContentId);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                List<PmlEdmAttachedFile> list = (List<PmlEdmAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public PmlEdmAttachedFile findByObjectContentId_ObjectType_First(
        long objectContentId, String objectType, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        List<PmlEdmAttachedFile> list = findByObjectContentId_ObjectType(objectContentId,
                objectType, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("objectContentId=" + objectContentId);

            msg.append(", ");
            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile findByObjectContentId_ObjectType_Last(
        long objectContentId, String objectType, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        int count = countByObjectContentId_ObjectType(objectContentId,
                objectType);

        List<PmlEdmAttachedFile> list = findByObjectContentId_ObjectType(objectContentId,
                objectType, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("objectContentId=" + objectContentId);

            msg.append(", ");
            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile[] findByObjectContentId_ObjectType_PrevAndNext(
        long attachedFileId, long objectContentId, String objectType,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        PmlEdmAttachedFile pmlEdmAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByObjectContentId_ObjectType(objectContentId,
                objectType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

            query.append("objectcontentid = ?");

            query.append(" AND ");

            if (objectType == null) {
                query.append("objecttype IS NULL");
            } else {
                query.append("objecttype = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(objectContentId);

            if (objectType != null) {
                qPos.add(objectType);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmAttachedFile);

            PmlEdmAttachedFile[] array = new PmlEdmAttachedFileImpl[3];

            array[0] = (PmlEdmAttachedFile) objArray[0];
            array[1] = (PmlEdmAttachedFile) objArray[1];
            array[2] = (PmlEdmAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlEdmAttachedFile> findByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, String objectType, boolean displayOrHidden)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByObjectContentId_ObjectType_D_OR_H";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName(),
                Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(objectContentId),
                
                objectType, Boolean.valueOf(displayOrHidden)
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                query.append("objectcontentid = ?");

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objecttype IS NULL");
                } else {
                    query.append("objecttype = ?");
                }

                query.append(" AND ");

                query.append("displayorhidden = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(objectContentId);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                qPos.add(displayOrHidden);

                List<PmlEdmAttachedFile> list = q.list();

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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public List<PmlEdmAttachedFile> findByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, String objectType, boolean displayOrHidden,
        int start, int end) throws SystemException {
        return findByObjectContentId_ObjectType_D_OR_H(objectContentId,
            objectType, displayOrHidden, start, end, null);
    }

    public List<PmlEdmAttachedFile> findByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, String objectType, boolean displayOrHidden,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "findByObjectContentId_ObjectType_D_OR_H";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName(),
                Boolean.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Long(objectContentId),
                
                objectType, Boolean.valueOf(displayOrHidden),
                
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                query.append("objectcontentid = ?");

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objecttype IS NULL");
                } else {
                    query.append("objecttype = ?");
                }

                query.append(" AND ");

                query.append("displayorhidden = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(objectContentId);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                qPos.add(displayOrHidden);

                List<PmlEdmAttachedFile> list = (List<PmlEdmAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public PmlEdmAttachedFile findByObjectContentId_ObjectType_D_OR_H_First(
        long objectContentId, String objectType, boolean displayOrHidden,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        List<PmlEdmAttachedFile> list = findByObjectContentId_ObjectType_D_OR_H(objectContentId,
                objectType, displayOrHidden, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("objectContentId=" + objectContentId);

            msg.append(", ");
            msg.append("objectType=" + objectType);

            msg.append(", ");
            msg.append("displayOrHidden=" + displayOrHidden);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile findByObjectContentId_ObjectType_D_OR_H_Last(
        long objectContentId, String objectType, boolean displayOrHidden,
        OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        int count = countByObjectContentId_ObjectType_D_OR_H(objectContentId,
                objectType, displayOrHidden);

        List<PmlEdmAttachedFile> list = findByObjectContentId_ObjectType_D_OR_H(objectContentId,
                objectType, displayOrHidden, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlEdmAttachedFile exists with the key {");

            msg.append("objectContentId=" + objectContentId);

            msg.append(", ");
            msg.append("objectType=" + objectType);

            msg.append(", ");
            msg.append("displayOrHidden=" + displayOrHidden);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlEdmAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlEdmAttachedFile[] findByObjectContentId_ObjectType_D_OR_H_PrevAndNext(
        long attachedFileId, long objectContentId, String objectType,
        boolean displayOrHidden, OrderByComparator obc)
        throws NoSuchPmlEdmAttachedFileException, SystemException {
        PmlEdmAttachedFile pmlEdmAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByObjectContentId_ObjectType_D_OR_H(objectContentId,
                objectType, displayOrHidden);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

            query.append("objectcontentid = ?");

            query.append(" AND ");

            if (objectType == null) {
                query.append("objecttype IS NULL");
            } else {
                query.append("objecttype = ?");
            }

            query.append(" AND ");

            query.append("displayorhidden = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(objectContentId);

            if (objectType != null) {
                qPos.add(objectType);
            }

            qPos.add(displayOrHidden);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlEdmAttachedFile);

            PmlEdmAttachedFile[] array = new PmlEdmAttachedFileImpl[3];

            array[0] = (PmlEdmAttachedFile) objArray[0];
            array[1] = (PmlEdmAttachedFile) objArray[1];
            array[2] = (PmlEdmAttachedFile) objArray[2];

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

    public List<PmlEdmAttachedFile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlEdmAttachedFile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlEdmAttachedFile> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlEdmAttachedFile> list = (List<PmlEdmAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlEdmAttachedFile>) result;
        }
    }

    public void removeByObjectContentId(long objectContentId)
        throws SystemException {
        for (PmlEdmAttachedFile pmlEdmAttachedFile : findByObjectContentId(
                objectContentId)) {
            remove(pmlEdmAttachedFile);
        }
    }

    public void removeByObjectType(String objectType) throws SystemException {
        for (PmlEdmAttachedFile pmlEdmAttachedFile : findByObjectType(
                objectType)) {
            remove(pmlEdmAttachedFile);
        }
    }

    public void removeByAttachedFileName(String attachedFileName)
        throws SystemException {
        for (PmlEdmAttachedFile pmlEdmAttachedFile : findByAttachedFileName(
                attachedFileName)) {
            remove(pmlEdmAttachedFile);
        }
    }

    public void removeByPath(String path) throws SystemException {
        for (PmlEdmAttachedFile pmlEdmAttachedFile : findByPath(path)) {
            remove(pmlEdmAttachedFile);
        }
    }

    public void removeByDateCreated(Date dateCreated) throws SystemException {
        for (PmlEdmAttachedFile pmlEdmAttachedFile : findByDateCreated(
                dateCreated)) {
            remove(pmlEdmAttachedFile);
        }
    }

    public void removeByFileType(String fileType) throws SystemException {
        for (PmlEdmAttachedFile pmlEdmAttachedFile : findByFileType(fileType)) {
            remove(pmlEdmAttachedFile);
        }
    }

    public void removeByFileId(int fileId) throws SystemException {
        for (PmlEdmAttachedFile pmlEdmAttachedFile : findByFileId(fileId)) {
            remove(pmlEdmAttachedFile);
        }
    }

    public void removeByObjectContentId_ObjectType(long objectContentId,
        String objectType) throws SystemException {
        for (PmlEdmAttachedFile pmlEdmAttachedFile : findByObjectContentId_ObjectType(
                objectContentId, objectType)) {
            remove(pmlEdmAttachedFile);
        }
    }

    public void removeByObjectContentId_ObjectType_D_OR_H(
        long objectContentId, String objectType, boolean displayOrHidden)
        throws SystemException {
        for (PmlEdmAttachedFile pmlEdmAttachedFile : findByObjectContentId_ObjectType_D_OR_H(
                objectContentId, objectType, displayOrHidden)) {
            remove(pmlEdmAttachedFile);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlEdmAttachedFile pmlEdmAttachedFile : findAll()) {
            remove(pmlEdmAttachedFile);
        }
    }

    public int countByObjectContentId(long objectContentId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "countByObjectContentId";
        String[] finderParams = new String[] { Long.class.getName() };
        Object[] finderArgs = new Object[] { new Long(objectContentId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                query.append("objectcontentid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(objectContentId);

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

    public int countByObjectType(String objectType) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "countByObjectType";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { objectType };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (objectType == null) {
                    query.append("objecttype LIKE null");
                } else {
                    query.append("objecttype LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (objectType != null) {
                    qPos.add(objectType);
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

    public int countByAttachedFileName(String attachedFileName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "countByAttachedFileName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { attachedFileName };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("attachedfilename LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
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

    public int countByPath(String path) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "countByPath";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { path };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (path == null) {
                    query.append("path LIKE null");
                } else {
                    query.append("path LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (path != null) {
                    qPos.add(path);
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

    public int countByDateCreated(Date dateCreated) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "countByDateCreated";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { dateCreated };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (dateCreated == null) {
                    query.append("datecreated IS NULL");
                } else {
                    query.append("datecreated = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
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

    public int countByFileType(String fileType) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "countByFileType";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileType };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                if (fileType == null) {
                    query.append("filetype LIKE null");
                } else {
                    query.append("filetype LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileType != null) {
                    qPos.add(fileType);
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

    public int countByFileId(int fileId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "countByFileId";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(fileId) };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                query.append("fileid = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(fileId);

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

    public int countByObjectContentId_ObjectType(long objectContentId,
        String objectType) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "countByObjectContentId_ObjectType";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Long(objectContentId), objectType };

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
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                query.append("objectcontentid = ?");

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objecttype IS NULL");
                } else {
                    query.append("objecttype = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(objectContentId);

                if (objectType != null) {
                    qPos.add(objectType);
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

    public int countByObjectContentId_ObjectType_D_OR_H(long objectContentId,
        String objectType, boolean displayOrHidden) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
        String finderMethodName = "countByObjectContentId_ObjectType_D_OR_H";
        String[] finderParams = new String[] {
                Long.class.getName(), String.class.getName(),
                Boolean.class.getName()
            };
        Object[] finderArgs = new Object[] {
                new Long(objectContentId),
                
                objectType, Boolean.valueOf(displayOrHidden)
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

                query.append("SELECT COUNT(*) ");
                query.append(
                    "FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile WHERE ");

                query.append("objectcontentid = ?");

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objecttype IS NULL");
                } else {
                    query.append("objecttype = ?");
                }

                query.append(" AND ");

                query.append("displayorhidden = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(objectContentId);

                if (objectType != null) {
                    qPos.add(objectType);
                }

                qPos.add(displayOrHidden);

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
        boolean finderClassNameCacheEnabled = PmlEdmAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlEdmAttachedFile.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile");

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
                        "value.object.listener.com.sgs.portlet.document.receipt.model.PmlEdmAttachedFile")));

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
