package com.sgs.portlet.onedoor.service.persistence;

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

import com.sgs.portlet.onedoor.NoSuchAttachedFileException;
import com.sgs.portlet.onedoor.model.PmlFileAttachedFile;
import com.sgs.portlet.onedoor.model.impl.PmlFileAttachedFileImpl;
import com.sgs.portlet.onedoor.model.impl.PmlFileAttachedFileModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlFileAttachedFilePersistenceImpl extends BasePersistenceImpl
    implements PmlFileAttachedFilePersistence {
    private static Log _log = LogFactory.getLog(PmlFileAttachedFilePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlFileAttachedFile create(String fileAttachedFileId) {
        PmlFileAttachedFile pmlFileAttachedFile = new PmlFileAttachedFileImpl();

        pmlFileAttachedFile.setNew(true);
        pmlFileAttachedFile.setPrimaryKey(fileAttachedFileId);

        return pmlFileAttachedFile;
    }

    public PmlFileAttachedFile remove(String fileAttachedFileId)
        throws NoSuchAttachedFileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileAttachedFile pmlFileAttachedFile = (PmlFileAttachedFile) session.get(PmlFileAttachedFileImpl.class,
                    fileAttachedFileId);

            if (pmlFileAttachedFile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlFileAttachedFile exists with the primary key " +
                        fileAttachedFileId);
                }

                throw new NoSuchAttachedFileException(
                    "No PmlFileAttachedFile exists with the primary key " +
                    fileAttachedFileId);
            }

            return remove(pmlFileAttachedFile);
        } catch (NoSuchAttachedFileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileAttachedFile remove(PmlFileAttachedFile pmlFileAttachedFile)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlFileAttachedFile);
            }
        }

        pmlFileAttachedFile = removeImpl(pmlFileAttachedFile);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlFileAttachedFile);
            }
        }

        return pmlFileAttachedFile;
    }

    protected PmlFileAttachedFile removeImpl(
        PmlFileAttachedFile pmlFileAttachedFile) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlFileAttachedFile);

            session.flush();

            return pmlFileAttachedFile;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileAttachedFile.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlFileAttachedFile pmlFileAttachedFile, boolean merge)</code>.
     */
    public PmlFileAttachedFile update(PmlFileAttachedFile pmlFileAttachedFile)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileAttachedFile pmlFileAttachedFile) method. Use update(PmlFileAttachedFile pmlFileAttachedFile, boolean merge) instead.");
        }

        return update(pmlFileAttachedFile, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileAttachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileAttachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileAttachedFile update(PmlFileAttachedFile pmlFileAttachedFile,
        boolean merge) throws SystemException {
        boolean isNew = pmlFileAttachedFile.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlFileAttachedFile);
                } else {
                    listener.onBeforeUpdate(pmlFileAttachedFile);
                }
            }
        }

        pmlFileAttachedFile = updateImpl(pmlFileAttachedFile, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlFileAttachedFile);
                } else {
                    listener.onAfterUpdate(pmlFileAttachedFile);
                }
            }
        }

        return pmlFileAttachedFile;
    }

    public PmlFileAttachedFile updateImpl(
        com.sgs.portlet.onedoor.model.PmlFileAttachedFile pmlFileAttachedFile,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlFileAttachedFile);
            } else {
                if (pmlFileAttachedFile.isNew()) {
                    session.save(pmlFileAttachedFile);
                }
            }

            session.flush();

            pmlFileAttachedFile.setNew(false);

            return pmlFileAttachedFile;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileAttachedFile.class.getName());
        }
    }

    public PmlFileAttachedFile findByPrimaryKey(String fileAttachedFileId)
        throws NoSuchAttachedFileException, SystemException {
        PmlFileAttachedFile pmlFileAttachedFile = fetchByPrimaryKey(fileAttachedFileId);

        if (pmlFileAttachedFile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlFileAttachedFile exists with the primary key " +
                    fileAttachedFileId);
            }

            throw new NoSuchAttachedFileException(
                "No PmlFileAttachedFile exists with the primary key " +
                fileAttachedFileId);
        }

        return pmlFileAttachedFile;
    }

    public PmlFileAttachedFile fetchByPrimaryKey(String fileAttachedFileId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlFileAttachedFile) session.get(PmlFileAttachedFileImpl.class,
                fileAttachedFileId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileAttachedFile> findByFileId(String fileId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileAttachedFile.class.getName();
        String finderMethodName = "findByFileId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileId };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile WHERE ");

                if (fileId == null) {
                    query.append("fileId LIKE null");
                } else {
                    query.append("fileId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                List<PmlFileAttachedFile> list = q.list();

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
            return (List<PmlFileAttachedFile>) result;
        }
    }

    public List<PmlFileAttachedFile> findByFileId(String fileId, int start,
        int end) throws SystemException {
        return findByFileId(fileId, start, end, null);
    }

    public List<PmlFileAttachedFile> findByFileId(String fileId, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileAttachedFile.class.getName();
        String finderMethodName = "findByFileId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileId,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile WHERE ");

                if (fileId == null) {
                    query.append("fileId LIKE null");
                } else {
                    query.append("fileId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
                }

                List<PmlFileAttachedFile> list = (List<PmlFileAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileAttachedFile>) result;
        }
    }

    public PmlFileAttachedFile findByFileId_First(String fileId,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<PmlFileAttachedFile> list = findByFileId(fileId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileAttachedFile exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileAttachedFile findByFileId_Last(String fileId,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByFileId(fileId);

        List<PmlFileAttachedFile> list = findByFileId(fileId, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileAttachedFile exists with the key {");

            msg.append("fileId=" + fileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileAttachedFile[] findByFileId_PrevAndNext(
        String fileAttachedFileId, String fileId, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        PmlFileAttachedFile pmlFileAttachedFile = findByPrimaryKey(fileAttachedFileId);

        int count = countByFileId(fileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile WHERE ");

            if (fileId == null) {
                query.append("fileId LIKE null");
            } else {
                query.append("fileId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileId != null) {
                qPos.add(fileId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileAttachedFile);

            PmlFileAttachedFile[] array = new PmlFileAttachedFileImpl[3];

            array[0] = (PmlFileAttachedFile) objArray[0];
            array[1] = (PmlFileAttachedFile) objArray[1];
            array[2] = (PmlFileAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileAttachedFile> findByAttachedFileId(String attachedFileId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileAttachedFile.class.getName();
        String finderMethodName = "findByAttachedFileId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { attachedFileId };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile WHERE ");

                if (attachedFileId == null) {
                    query.append("attachedFileId LIKE null");
                } else {
                    query.append("attachedFileId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileId != null) {
                    qPos.add(attachedFileId);
                }

                List<PmlFileAttachedFile> list = q.list();

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
            return (List<PmlFileAttachedFile>) result;
        }
    }

    public List<PmlFileAttachedFile> findByAttachedFileId(
        String attachedFileId, int start, int end) throws SystemException {
        return findByAttachedFileId(attachedFileId, start, end, null);
    }

    public List<PmlFileAttachedFile> findByAttachedFileId(
        String attachedFileId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileAttachedFile.class.getName();
        String finderMethodName = "findByAttachedFileId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                attachedFileId,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile WHERE ");

                if (attachedFileId == null) {
                    query.append("attachedFileId LIKE null");
                } else {
                    query.append("attachedFileId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileId != null) {
                    qPos.add(attachedFileId);
                }

                List<PmlFileAttachedFile> list = (List<PmlFileAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileAttachedFile>) result;
        }
    }

    public PmlFileAttachedFile findByAttachedFileId_First(
        String attachedFileId, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<PmlFileAttachedFile> list = findByAttachedFileId(attachedFileId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileAttachedFile exists with the key {");

            msg.append("attachedFileId=" + attachedFileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileAttachedFile findByAttachedFileId_Last(
        String attachedFileId, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByAttachedFileId(attachedFileId);

        List<PmlFileAttachedFile> list = findByAttachedFileId(attachedFileId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileAttachedFile exists with the key {");

            msg.append("attachedFileId=" + attachedFileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileAttachedFile[] findByAttachedFileId_PrevAndNext(
        String fileAttachedFileId, String attachedFileId, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        PmlFileAttachedFile pmlFileAttachedFile = findByPrimaryKey(fileAttachedFileId);

        int count = countByAttachedFileId(attachedFileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile WHERE ");

            if (attachedFileId == null) {
                query.append("attachedFileId LIKE null");
            } else {
                query.append("attachedFileId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileId != null) {
                qPos.add(attachedFileId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileAttachedFile);

            PmlFileAttachedFile[] array = new PmlFileAttachedFileImpl[3];

            array[0] = (PmlFileAttachedFile) objArray[0];
            array[1] = (PmlFileAttachedFile) objArray[1];
            array[2] = (PmlFileAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileAttachedFile> findByAttachedFileName(
        String attachedFileName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("attachedFileName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                List<PmlFileAttachedFile> list = q.list();

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
            return (List<PmlFileAttachedFile>) result;
        }
    }

    public List<PmlFileAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end) throws SystemException {
        return findByAttachedFileName(attachedFileName, start, end, null);
    }

    public List<PmlFileAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("attachedFileName LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                List<PmlFileAttachedFile> list = (List<PmlFileAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileAttachedFile>) result;
        }
    }

    public PmlFileAttachedFile findByAttachedFileName_First(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<PmlFileAttachedFile> list = findByAttachedFileName(attachedFileName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileAttachedFile findByAttachedFileName_Last(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByAttachedFileName(attachedFileName);

        List<PmlFileAttachedFile> list = findByAttachedFileName(attachedFileName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileAttachedFile[] findByAttachedFileName_PrevAndNext(
        String fileAttachedFileId, String attachedFileName,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        PmlFileAttachedFile pmlFileAttachedFile = findByPrimaryKey(fileAttachedFileId);

        int count = countByAttachedFileName(attachedFileName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile WHERE ");

            if (attachedFileName == null) {
                query.append("attachedFileName LIKE null");
            } else {
                query.append("attachedFileName LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileAttachedFile);

            PmlFileAttachedFile[] array = new PmlFileAttachedFileImpl[3];

            array[0] = (PmlFileAttachedFile) objArray[0];
            array[1] = (PmlFileAttachedFile) objArray[1];
            array[2] = (PmlFileAttachedFile) objArray[2];

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

    public List<PmlFileAttachedFile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileAttachedFile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileAttachedFile> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlFileAttachedFile> list = (List<PmlFileAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileAttachedFile>) result;
        }
    }

    public void removeByFileId(String fileId) throws SystemException {
        for (PmlFileAttachedFile pmlFileAttachedFile : findByFileId(fileId)) {
            remove(pmlFileAttachedFile);
        }
    }

    public void removeByAttachedFileId(String attachedFileId)
        throws SystemException {
        for (PmlFileAttachedFile pmlFileAttachedFile : findByAttachedFileId(
                attachedFileId)) {
            remove(pmlFileAttachedFile);
        }
    }

    public void removeByAttachedFileName(String attachedFileName)
        throws SystemException {
        for (PmlFileAttachedFile pmlFileAttachedFile : findByAttachedFileName(
                attachedFileName)) {
            remove(pmlFileAttachedFile);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFileAttachedFile pmlFileAttachedFile : findAll()) {
            remove(pmlFileAttachedFile);
        }
    }

    public int countByFileId(String fileId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileAttachedFile.class.getName();
        String finderMethodName = "countByFileId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileId };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile WHERE ");

                if (fileId == null) {
                    query.append("fileId LIKE null");
                } else {
                    query.append("fileId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileId != null) {
                    qPos.add(fileId);
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

    public int countByAttachedFileId(String attachedFileId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileAttachedFile.class.getName();
        String finderMethodName = "countByAttachedFileId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { attachedFileId };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile WHERE ");

                if (attachedFileId == null) {
                    query.append("attachedFileId LIKE null");
                } else {
                    query.append("attachedFileId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileId != null) {
                    qPos.add(attachedFileId);
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
        boolean finderClassNameCacheEnabled = PmlFileAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("attachedFileName LIKE ?");
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

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileAttachedFile.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoor.model.PmlFileAttachedFile");

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
                        "value.object.listener.com.sgs.portlet.onedoor.model.PmlFileAttachedFile")));

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
