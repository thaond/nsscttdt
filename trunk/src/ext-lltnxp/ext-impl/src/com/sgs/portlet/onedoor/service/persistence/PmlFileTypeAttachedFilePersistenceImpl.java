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

import com.sgs.portlet.onedoor.NoSuchTypeAttachedFileException;
import com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile;
import com.sgs.portlet.onedoor.model.impl.PmlFileTypeAttachedFileImpl;
import com.sgs.portlet.onedoor.model.impl.PmlFileTypeAttachedFileModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlFileTypeAttachedFilePersistenceImpl extends BasePersistenceImpl
    implements PmlFileTypeAttachedFilePersistence {
    private static Log _log = LogFactory.getLog(PmlFileTypeAttachedFilePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlFileTypeAttachedFile create(String filetypeAttachedFileId) {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = new PmlFileTypeAttachedFileImpl();

        pmlFileTypeAttachedFile.setNew(true);
        pmlFileTypeAttachedFile.setPrimaryKey(filetypeAttachedFileId);

        return pmlFileTypeAttachedFile;
    }

    public PmlFileTypeAttachedFile remove(String filetypeAttachedFileId)
        throws NoSuchTypeAttachedFileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileTypeAttachedFile pmlFileTypeAttachedFile = (PmlFileTypeAttachedFile) session.get(PmlFileTypeAttachedFileImpl.class,
                    filetypeAttachedFileId);

            if (pmlFileTypeAttachedFile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlFileTypeAttachedFile exists with the primary key " +
                        filetypeAttachedFileId);
                }

                throw new NoSuchTypeAttachedFileException(
                    "No PmlFileTypeAttachedFile exists with the primary key " +
                    filetypeAttachedFileId);
            }

            return remove(pmlFileTypeAttachedFile);
        } catch (NoSuchTypeAttachedFileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileTypeAttachedFile remove(
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlFileTypeAttachedFile);
            }
        }

        pmlFileTypeAttachedFile = removeImpl(pmlFileTypeAttachedFile);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlFileTypeAttachedFile);
            }
        }

        return pmlFileTypeAttachedFile;
    }

    protected PmlFileTypeAttachedFile removeImpl(
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlFileTypeAttachedFile);

            session.flush();

            return pmlFileTypeAttachedFile;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileTypeAttachedFile.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlFileTypeAttachedFile pmlFileTypeAttachedFile, boolean merge)</code>.
     */
    public PmlFileTypeAttachedFile update(
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileTypeAttachedFile pmlFileTypeAttachedFile) method. Use update(PmlFileTypeAttachedFile pmlFileTypeAttachedFile, boolean merge) instead.");
        }

        return update(pmlFileTypeAttachedFile, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileTypeAttachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileTypeAttachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileTypeAttachedFile update(
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile, boolean merge)
        throws SystemException {
        boolean isNew = pmlFileTypeAttachedFile.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlFileTypeAttachedFile);
                } else {
                    listener.onBeforeUpdate(pmlFileTypeAttachedFile);
                }
            }
        }

        pmlFileTypeAttachedFile = updateImpl(pmlFileTypeAttachedFile, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlFileTypeAttachedFile);
                } else {
                    listener.onAfterUpdate(pmlFileTypeAttachedFile);
                }
            }
        }

        return pmlFileTypeAttachedFile;
    }

    public PmlFileTypeAttachedFile updateImpl(
        com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile pmlFileTypeAttachedFile,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlFileTypeAttachedFile);
            } else {
                if (pmlFileTypeAttachedFile.isNew()) {
                    session.save(pmlFileTypeAttachedFile);
                }
            }

            session.flush();

            pmlFileTypeAttachedFile.setNew(false);

            return pmlFileTypeAttachedFile;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileTypeAttachedFile.class.getName());
        }
    }

    public PmlFileTypeAttachedFile findByPrimaryKey(
        String filetypeAttachedFileId)
        throws NoSuchTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = fetchByPrimaryKey(filetypeAttachedFileId);

        if (pmlFileTypeAttachedFile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlFileTypeAttachedFile exists with the primary key " +
                    filetypeAttachedFileId);
            }

            throw new NoSuchTypeAttachedFileException(
                "No PmlFileTypeAttachedFile exists with the primary key " +
                filetypeAttachedFileId);
        }

        return pmlFileTypeAttachedFile;
    }

    public PmlFileTypeAttachedFile fetchByPrimaryKey(
        String filetypeAttachedFileId) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlFileTypeAttachedFile) session.get(PmlFileTypeAttachedFileImpl.class,
                filetypeAttachedFileId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByFileTypeId(String fileTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlFileTypeAttachedFile> list = q.list();

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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public List<PmlFileTypeAttachedFile> findByFileTypeId(String fileTypeId,
        int start, int end) throws SystemException {
        return findByFileTypeId(fileTypeId, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByFileTypeId(String fileTypeId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public PmlFileTypeAttachedFile findByFileTypeId_First(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByFileTypeId(fileTypeId, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByFileTypeId_Last(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        int count = countByFileTypeId(fileTypeId);

        List<PmlFileTypeAttachedFile> list = findByFileTypeId(fileTypeId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByFileTypeId_PrevAndNext(
        String filetypeAttachedFileId, String fileTypeId, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByFileTypeId(fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

            if (fileTypeId == null) {
                query.append("fileTypeId LIKE null");
            } else {
                query.append("fileTypeId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByAttachedFileId(
        String attachedFileId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileId == null) {
                    query.append("attachedFileId LIKE null");
                } else {
                    query.append("attachedFileId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileId != null) {
                    qPos.add(attachedFileId);
                }

                List<PmlFileTypeAttachedFile> list = q.list();

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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public List<PmlFileTypeAttachedFile> findByAttachedFileId(
        String attachedFileId, int start, int end) throws SystemException {
        return findByAttachedFileId(attachedFileId, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByAttachedFileId(
        String attachedFileId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

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

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileId != null) {
                    qPos.add(attachedFileId);
                }

                List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public PmlFileTypeAttachedFile findByAttachedFileId_First(
        String attachedFileId, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByAttachedFileId(attachedFileId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileId=" + attachedFileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByAttachedFileId_Last(
        String attachedFileId, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        int count = countByAttachedFileId(attachedFileId);

        List<PmlFileTypeAttachedFile> list = findByAttachedFileId(attachedFileId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileId=" + attachedFileId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByAttachedFileId_PrevAndNext(
        String filetypeAttachedFileId, String attachedFileId,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByAttachedFileId(attachedFileId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

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

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileId != null) {
                qPos.add(attachedFileId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByAttachedFileName(
        String attachedFileName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("attachedFileName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                List<PmlFileTypeAttachedFile> list = q.list();

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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public List<PmlFileTypeAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end) throws SystemException {
        return findByAttachedFileName(attachedFileName, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

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

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public PmlFileTypeAttachedFile findByAttachedFileName_First(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByAttachedFileName(attachedFileName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByAttachedFileName_Last(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        int count = countByAttachedFileName(attachedFileName);

        List<PmlFileTypeAttachedFile> list = findByAttachedFileName(attachedFileName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByAttachedFileName_PrevAndNext(
        String filetypeAttachedFileId, String attachedFileName,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByAttachedFileName(attachedFileName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

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

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByOriginal(int original)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByOriginal";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(original) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                query.append("original = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(original);

                List<PmlFileTypeAttachedFile> list = q.list();

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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public List<PmlFileTypeAttachedFile> findByOriginal(int original,
        int start, int end) throws SystemException {
        return findByOriginal(original, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByOriginal(int original,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByOriginal";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(original),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                query.append("original = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(original);

                List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public PmlFileTypeAttachedFile findByOriginal_First(int original,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByOriginal(original, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("original=" + original);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByOriginal_Last(int original,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        int count = countByOriginal(original);

        List<PmlFileTypeAttachedFile> list = findByOriginal(original,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("original=" + original);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByOriginal_PrevAndNext(
        String filetypeAttachedFileId, int original, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByOriginal(original);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

            query.append("original = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(original);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByOriginal_FT(int original,
        String fileTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByOriginal_FT";
        String[] finderParams = new String[] {
                Integer.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Integer(original), fileTypeId };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                query.append("original = ?");

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(original);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlFileTypeAttachedFile> list = q.list();

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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public List<PmlFileTypeAttachedFile> findByOriginal_FT(int original,
        String fileTypeId, int start, int end) throws SystemException {
        return findByOriginal_FT(original, fileTypeId, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByOriginal_FT(int original,
        String fileTypeId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByOriginal_FT";
        String[] finderParams = new String[] {
                Integer.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(original),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                query.append("original = ?");

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(original);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public PmlFileTypeAttachedFile findByOriginal_FT_First(int original,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByOriginal_FT(original,
                fileTypeId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("original=" + original);

            msg.append(", ");
            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByOriginal_FT_Last(int original,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        int count = countByOriginal_FT(original, fileTypeId);

        List<PmlFileTypeAttachedFile> list = findByOriginal_FT(original,
                fileTypeId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("original=" + original);

            msg.append(", ");
            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByOriginal_FT_PrevAndNext(
        String filetypeAttachedFileId, int original, String fileTypeId,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByOriginal_FT(original, fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

            query.append("original = ?");

            query.append(" AND ");

            if (fileTypeId == null) {
                query.append("fileTypeId IS NULL");
            } else {
                query.append("fileTypeId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(original);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByCopy_(int copy_)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByCopy_";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(copy_) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                query.append("copy_ = ?");

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(copy_);

                List<PmlFileTypeAttachedFile> list = q.list();

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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public List<PmlFileTypeAttachedFile> findByCopy_(int copy_, int start,
        int end) throws SystemException {
        return findByCopy_(copy_, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByCopy_(int copy_, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByCopy_";
        String[] finderParams = new String[] {
                Integer.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(copy_),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                query.append("copy_ = ?");

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(copy_);

                List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public PmlFileTypeAttachedFile findByCopy__First(int copy_,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByCopy_(copy_, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("copy_=" + copy_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByCopy__Last(int copy_,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        int count = countByCopy_(copy_);

        List<PmlFileTypeAttachedFile> list = findByCopy_(copy_, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("copy_=" + copy_);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByCopy__PrevAndNext(
        String filetypeAttachedFileId, int copy_, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByCopy_(copy_);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

            query.append("copy_ = ?");

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(copy_);

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByCopy_FT(int copy_,
        String fileTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByCopy_FT";
        String[] finderParams = new String[] {
                Integer.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Integer(copy_), fileTypeId };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                query.append("copy_ = ?");

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(copy_);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlFileTypeAttachedFile> list = q.list();

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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public List<PmlFileTypeAttachedFile> findByCopy_FT(int copy_,
        String fileTypeId, int start, int end) throws SystemException {
        return findByCopy_FT(copy_, fileTypeId, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByCopy_FT(int copy_,
        String fileTypeId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByCopy_FT";
        String[] finderParams = new String[] {
                Integer.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                new Integer(copy_),
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                query.append("copy_ = ?");

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(copy_);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public PmlFileTypeAttachedFile findByCopy_FT_First(int copy_,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByCopy_FT(copy_, fileTypeId,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("copy_=" + copy_);

            msg.append(", ");
            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByCopy_FT_Last(int copy_,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        int count = countByCopy_FT(copy_, fileTypeId);

        List<PmlFileTypeAttachedFile> list = findByCopy_FT(copy_, fileTypeId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("copy_=" + copy_);

            msg.append(", ");
            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByCopy_FT_PrevAndNext(
        String filetypeAttachedFileId, int copy_, String fileTypeId,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByCopy_FT(copy_, fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

            query.append("copy_ = ?");

            query.append(" AND ");

            if (fileTypeId == null) {
                query.append("fileTypeId IS NULL");
            } else {
                query.append("fileTypeId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            qPos.add(copy_);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByNote(String note)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByNote";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { note };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                List<PmlFileTypeAttachedFile> list = q.list();

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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public List<PmlFileTypeAttachedFile> findByNote(String note, int start,
        int end) throws SystemException {
        return findByNote(note, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByNote(String note, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByNote";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                note,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public PmlFileTypeAttachedFile findByNote_First(String note,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByNote(note, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByNote_Last(String note,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        int count = countByNote(note);

        List<PmlFileTypeAttachedFile> list = findByNote(note, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByNote_PrevAndNext(
        String filetypeAttachedFileId, String note, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByNote(note);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

            if (note == null) {
                query.append("note LIKE null");
            } else {
                query.append("lower(note) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (note != null) {
                qPos.add(note);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByNote_FT(String note,
        String fileTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByNote_FT";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { note, fileTypeId };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlFileTypeAttachedFile> list = q.list();

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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public List<PmlFileTypeAttachedFile> findByNote_FT(String note,
        String fileTypeId, int start, int end) throws SystemException {
        return findByNote_FT(note, fileTypeId, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByNote_FT(String note,
        String fileTypeId, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByNote_FT";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                note,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public PmlFileTypeAttachedFile findByNote_FT_First(String note,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByNote_FT(note, fileTypeId, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("note=" + note);

            msg.append(", ");
            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByNote_FT_Last(String note,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        int count = countByNote_FT(note, fileTypeId);

        List<PmlFileTypeAttachedFile> list = findByNote_FT(note, fileTypeId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("note=" + note);

            msg.append(", ");
            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByNote_FT_PrevAndNext(
        String filetypeAttachedFileId, String note, String fileTypeId,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByNote_FT(note, fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

            if (note == null) {
                query.append("note LIKE null");
            } else {
                query.append("lower(note) LIKE ?");
            }

            query.append(" AND ");

            if (fileTypeId == null) {
                query.append("fileTypeId IS NULL");
            } else {
                query.append("fileTypeId = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (note != null) {
                qPos.add(note);
            }

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByN_O_C_N(
        String attachedFileName, int original, int copy_, String note)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByN_O_C_N";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName(),
                Integer.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                attachedFileName, new Integer(original), new Integer(copy_),
                
                note
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("lower(attachedFileName) LIKE ?");
                }

                query.append(" AND ");

                query.append("original = ?");

                query.append(" AND ");

                query.append("copy_ = ?");

                query.append(" AND ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                qPos.add(original);

                qPos.add(copy_);

                if (note != null) {
                    qPos.add(note);
                }

                List<PmlFileTypeAttachedFile> list = q.list();

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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public List<PmlFileTypeAttachedFile> findByN_O_C_N(
        String attachedFileName, int original, int copy_, String note,
        int start, int end) throws SystemException {
        return findByN_O_C_N(attachedFileName, original, copy_, note, start,
            end, null);
    }

    public List<PmlFileTypeAttachedFile> findByN_O_C_N(
        String attachedFileName, int original, int copy_, String note,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByN_O_C_N";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName(),
                Integer.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                attachedFileName, new Integer(original), new Integer(copy_),
                
                note,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("lower(attachedFileName) LIKE ?");
                }

                query.append(" AND ");

                query.append("original = ?");

                query.append(" AND ");

                query.append("copy_ = ?");

                query.append(" AND ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                qPos.add(original);

                qPos.add(copy_);

                if (note != null) {
                    qPos.add(note);
                }

                List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public PmlFileTypeAttachedFile findByN_O_C_N_First(
        String attachedFileName, int original, int copy_, String note,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByN_O_C_N(attachedFileName,
                original, copy_, note, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(", ");
            msg.append("original=" + original);

            msg.append(", ");
            msg.append("copy_=" + copy_);

            msg.append(", ");
            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByN_O_C_N_Last(String attachedFileName,
        int original, int copy_, String note, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        int count = countByN_O_C_N(attachedFileName, original, copy_, note);

        List<PmlFileTypeAttachedFile> list = findByN_O_C_N(attachedFileName,
                original, copy_, note, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(", ");
            msg.append("original=" + original);

            msg.append(", ");
            msg.append("copy_=" + copy_);

            msg.append(", ");
            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByN_O_C_N_PrevAndNext(
        String filetypeAttachedFileId, String attachedFileName, int original,
        int copy_, String note, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByN_O_C_N(attachedFileName, original, copy_, note);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

            if (attachedFileName == null) {
                query.append("attachedFileName LIKE null");
            } else {
                query.append("lower(attachedFileName) LIKE ?");
            }

            query.append(" AND ");

            query.append("original = ?");

            query.append(" AND ");

            query.append("copy_ = ?");

            query.append(" AND ");

            if (note == null) {
                query.append("note LIKE null");
            } else {
                query.append("lower(note) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            qPos.add(original);

            qPos.add(copy_);

            if (note != null) {
                qPos.add(note);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileTypeAttachedFile> findByN_N(String attachedFileName,
        String note) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByN_N";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { attachedFileName, note };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("lower(attachedFileName) LIKE ?");
                }

                query.append(" AND ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                if (note != null) {
                    qPos.add(note);
                }

                List<PmlFileTypeAttachedFile> list = q.list();

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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public List<PmlFileTypeAttachedFile> findByN_N(String attachedFileName,
        String note, int start, int end) throws SystemException {
        return findByN_N(attachedFileName, note, start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findByN_N(String attachedFileName,
        String note, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "findByN_N";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                attachedFileName,
                
                note,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("lower(attachedFileName) LIKE ?");
                }

                query.append(" AND ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                if (note != null) {
                    qPos.add(note);
                }

                List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public PmlFileTypeAttachedFile findByN_N_First(String attachedFileName,
        String note, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        List<PmlFileTypeAttachedFile> list = findByN_N(attachedFileName, note,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(", ");
            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile findByN_N_Last(String attachedFileName,
        String note, OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        int count = countByN_N(attachedFileName, note);

        List<PmlFileTypeAttachedFile> list = findByN_N(attachedFileName, note,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileTypeAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(", ");
            msg.append("note=" + note);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchTypeAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileTypeAttachedFile[] findByN_N_PrevAndNext(
        String filetypeAttachedFileId, String attachedFileName, String note,
        OrderByComparator obc)
        throws NoSuchTypeAttachedFileException, SystemException {
        PmlFileTypeAttachedFile pmlFileTypeAttachedFile = findByPrimaryKey(filetypeAttachedFileId);

        int count = countByN_N(attachedFileName, note);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

            if (attachedFileName == null) {
                query.append("attachedFileName LIKE null");
            } else {
                query.append("lower(attachedFileName) LIKE ?");
            }

            query.append(" AND ");

            if (note == null) {
                query.append("note LIKE null");
            } else {
                query.append("lower(note) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("filetypeAttachedFileId DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            if (note != null) {
                qPos.add(note);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileTypeAttachedFile);

            PmlFileTypeAttachedFile[] array = new PmlFileTypeAttachedFileImpl[3];

            array[0] = (PmlFileTypeAttachedFile) objArray[0];
            array[1] = (PmlFileTypeAttachedFile) objArray[1];
            array[2] = (PmlFileTypeAttachedFile) objArray[2];

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

    public List<PmlFileTypeAttachedFile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileTypeAttachedFile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileTypeAttachedFile> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("filetypeAttachedFileId DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlFileTypeAttachedFile> list = (List<PmlFileTypeAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFileTypeAttachedFile>) result;
        }
    }

    public void removeByFileTypeId(String fileTypeId) throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByFileTypeId(
                fileTypeId)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByAttachedFileId(String attachedFileId)
        throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByAttachedFileId(
                attachedFileId)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByAttachedFileName(String attachedFileName)
        throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByAttachedFileName(
                attachedFileName)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByOriginal(int original) throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByOriginal(
                original)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByOriginal_FT(int original, String fileTypeId)
        throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByOriginal_FT(
                original, fileTypeId)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByCopy_(int copy_) throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByCopy_(
                copy_)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByCopy_FT(int copy_, String fileTypeId)
        throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByCopy_FT(
                copy_, fileTypeId)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByNote(String note) throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByNote(note)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByNote_FT(String note, String fileTypeId)
        throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByNote_FT(
                note, fileTypeId)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByN_O_C_N(String attachedFileName, int original,
        int copy_, String note) throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByN_O_C_N(
                attachedFileName, original, copy_, note)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeByN_N(String attachedFileName, String note)
        throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findByN_N(
                attachedFileName, note)) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFileTypeAttachedFile pmlFileTypeAttachedFile : findAll()) {
            remove(pmlFileTypeAttachedFile);
        }
    }

    public int countByFileTypeId(String fileTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
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

    public int countByAttachedFileId(String attachedFileId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

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

    public int countByOriginal(int original) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "countByOriginal";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(original) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                query.append("original = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(original);

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

    public int countByOriginal_FT(int original, String fileTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "countByOriginal_FT";
        String[] finderParams = new String[] {
                Integer.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Integer(original), fileTypeId };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                query.append("original = ?");

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(original);

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

    public int countByCopy_(int copy_) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "countByCopy_";
        String[] finderParams = new String[] { Integer.class.getName() };
        Object[] finderArgs = new Object[] { new Integer(copy_) };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                query.append("copy_ = ?");

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(copy_);

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

    public int countByCopy_FT(int copy_, String fileTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "countByCopy_FT";
        String[] finderParams = new String[] {
                Integer.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { new Integer(copy_), fileTypeId };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                query.append("copy_ = ?");

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(copy_);

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

    public int countByNote(String note) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "countByNote";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { note };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
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

    public int countByNote_FT(String note, String fileTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "countByNote_FT";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { note, fileTypeId };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" AND ");

                if (fileTypeId == null) {
                    query.append("fileTypeId IS NULL");
                } else {
                    query.append("fileTypeId = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (note != null) {
                    qPos.add(note);
                }

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

    public int countByN_O_C_N(String attachedFileName, int original, int copy_,
        String note) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "countByN_O_C_N";
        String[] finderParams = new String[] {
                String.class.getName(), Integer.class.getName(),
                Integer.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                attachedFileName, new Integer(original), new Integer(copy_),
                
                note
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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("lower(attachedFileName) LIKE ?");
                }

                query.append(" AND ");

                query.append("original = ?");

                query.append(" AND ");

                query.append("copy_ = ?");

                query.append(" AND ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                qPos.add(original);

                qPos.add(copy_);

                if (note != null) {
                    qPos.add(note);
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

    public int countByN_N(String attachedFileName, String note)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
        String finderMethodName = "countByN_N";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { attachedFileName, note };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedFileName LIKE null");
                } else {
                    query.append("lower(attachedFileName) LIKE ?");
                }

                query.append(" AND ");

                if (note == null) {
                    query.append("note LIKE null");
                } else {
                    query.append("lower(note) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                if (note != null) {
                    qPos.add(note);
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
        boolean finderClassNameCacheEnabled = PmlFileTypeAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileTypeAttachedFile.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile");

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
                        "value.object.listener.com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile")));

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
