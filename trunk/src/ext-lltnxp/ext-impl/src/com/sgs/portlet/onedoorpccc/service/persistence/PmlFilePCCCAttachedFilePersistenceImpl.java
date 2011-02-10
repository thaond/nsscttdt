package com.sgs.portlet.onedoorpccc.service.persistence;

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

import com.sgs.portlet.onedoorpccc.NoSuchAttachedFileException;
import com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile;
import com.sgs.portlet.onedoorpccc.model.impl.PmlFilePCCCAttachedFileImpl;
import com.sgs.portlet.onedoorpccc.model.impl.PmlFilePCCCAttachedFileModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlFilePCCCAttachedFilePersistenceImpl extends BasePersistenceImpl
    implements PmlFilePCCCAttachedFilePersistence {
    private static Log _log = LogFactory.getLog(PmlFilePCCCAttachedFilePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlFilePCCCAttachedFile create(long attachedFileId) {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = new PmlFilePCCCAttachedFileImpl();

        pmlFilePCCCAttachedFile.setNew(true);
        pmlFilePCCCAttachedFile.setPrimaryKey(attachedFileId);

        return pmlFilePCCCAttachedFile;
    }

    public PmlFilePCCCAttachedFile remove(long attachedFileId)
        throws NoSuchAttachedFileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = (PmlFilePCCCAttachedFile) session.get(PmlFilePCCCAttachedFileImpl.class,
                    new Long(attachedFileId));

            if (pmlFilePCCCAttachedFile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlFilePCCCAttachedFile exists with the primary key " +
                        attachedFileId);
                }

                throw new NoSuchAttachedFileException(
                    "No PmlFilePCCCAttachedFile exists with the primary key " +
                    attachedFileId);
            }

            return remove(pmlFilePCCCAttachedFile);
        } catch (NoSuchAttachedFileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFilePCCCAttachedFile remove(
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlFilePCCCAttachedFile);
            }
        }

        pmlFilePCCCAttachedFile = removeImpl(pmlFilePCCCAttachedFile);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlFilePCCCAttachedFile);
            }
        }

        return pmlFilePCCCAttachedFile;
    }

    protected PmlFilePCCCAttachedFile removeImpl(
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlFilePCCCAttachedFile);

            session.flush();

            return pmlFilePCCCAttachedFile;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFilePCCCAttachedFile.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile, boolean merge)</code>.
     */
    public PmlFilePCCCAttachedFile update(
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile) method. Use update(PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile, boolean merge) instead.");
        }

        return update(pmlFilePCCCAttachedFile, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFilePCCCAttachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFilePCCCAttachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFilePCCCAttachedFile update(
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile, boolean merge)
        throws SystemException {
        boolean isNew = pmlFilePCCCAttachedFile.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlFilePCCCAttachedFile);
                } else {
                    listener.onBeforeUpdate(pmlFilePCCCAttachedFile);
                }
            }
        }

        pmlFilePCCCAttachedFile = updateImpl(pmlFilePCCCAttachedFile, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlFilePCCCAttachedFile);
                } else {
                    listener.onAfterUpdate(pmlFilePCCCAttachedFile);
                }
            }
        }

        return pmlFilePCCCAttachedFile;
    }

    public PmlFilePCCCAttachedFile updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlFilePCCCAttachedFile);
            } else {
                if (pmlFilePCCCAttachedFile.isNew()) {
                    session.save(pmlFilePCCCAttachedFile);
                }
            }

            session.flush();

            pmlFilePCCCAttachedFile.setNew(false);

            return pmlFilePCCCAttachedFile;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFilePCCCAttachedFile.class.getName());
        }
    }

    public PmlFilePCCCAttachedFile findByPrimaryKey(long attachedFileId)
        throws NoSuchAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = fetchByPrimaryKey(attachedFileId);

        if (pmlFilePCCCAttachedFile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlFilePCCCAttachedFile exists with the primary key " +
                    attachedFileId);
            }

            throw new NoSuchAttachedFileException(
                "No PmlFilePCCCAttachedFile exists with the primary key " +
                attachedFileId);
        }

        return pmlFilePCCCAttachedFile;
    }

    public PmlFilePCCCAttachedFile fetchByPrimaryKey(long attachedFileId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlFilePCCCAttachedFile) session.get(PmlFilePCCCAttachedFileImpl.class,
                new Long(attachedFileId));
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByFilePcccId(String filePcccId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
        String finderMethodName = "findByFilePcccId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { filePcccId };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

                if (filePcccId == null) {
                    query.append("filepcccid LIKE null");
                } else {
                    query.append("filepcccid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (filePcccId != null) {
                    qPos.add(filePcccId);
                }

                List<PmlFilePCCCAttachedFile> list = q.list();

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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public List<PmlFilePCCCAttachedFile> findByFilePcccId(String filePcccId,
        int start, int end) throws SystemException {
        return findByFilePcccId(filePcccId, start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findByFilePcccId(String filePcccId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
        String finderMethodName = "findByFilePcccId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                filePcccId,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

                if (filePcccId == null) {
                    query.append("filepcccid LIKE null");
                } else {
                    query.append("filepcccid LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (filePcccId != null) {
                    qPos.add(filePcccId);
                }

                List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public PmlFilePCCCAttachedFile findByFilePcccId_First(String filePcccId,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByFilePcccId(filePcccId, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("filePcccId=" + filePcccId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByFilePcccId_Last(String filePcccId,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByFilePcccId(filePcccId);

        List<PmlFilePCCCAttachedFile> list = findByFilePcccId(filePcccId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("filePcccId=" + filePcccId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByFilePcccId_PrevAndNext(
        long attachedFileId, String filePcccId, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByFilePcccId(filePcccId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

            if (filePcccId == null) {
                query.append("filepcccid LIKE null");
            } else {
                query.append("filepcccid LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (filePcccId != null) {
                qPos.add(filePcccId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByObjectType(String objectType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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

                List<PmlFilePCCCAttachedFile> list = q.list();

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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public List<PmlFilePCCCAttachedFile> findByObjectType(String objectType,
        int start, int end) throws SystemException {
        return findByObjectType(objectType, start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findByObjectType(String objectType,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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

                List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public PmlFilePCCCAttachedFile findByObjectType_First(String objectType,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByObjectType(objectType, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByObjectType_Last(String objectType,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByObjectType(objectType);

        List<PmlFilePCCCAttachedFile> list = findByObjectType(objectType,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByObjectType_PrevAndNext(
        long attachedFileId, String objectType, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByObjectType(objectType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByAttachedFileName(
        String attachedFileName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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

                List<PmlFilePCCCAttachedFile> list = q.list();

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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public List<PmlFilePCCCAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end) throws SystemException {
        return findByAttachedFileName(attachedFileName, start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findByAttachedFileName(
        String attachedFileName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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

                List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public PmlFilePCCCAttachedFile findByAttachedFileName_First(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByAttachedFileName(attachedFileName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByAttachedFileName_Last(
        String attachedFileName, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByAttachedFileName(attachedFileName);

        List<PmlFilePCCCAttachedFile> list = findByAttachedFileName(attachedFileName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByAttachedFileName_PrevAndNext(
        long attachedFileId, String attachedFileName, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByAttachedFileName(attachedFileName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByPath(String path)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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

                List<PmlFilePCCCAttachedFile> list = q.list();

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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public List<PmlFilePCCCAttachedFile> findByPath(String path, int start,
        int end) throws SystemException {
        return findByPath(path, start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findByPath(String path, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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

                List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public PmlFilePCCCAttachedFile findByPath_First(String path,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByPath(path, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("path=" + path);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByPath_Last(String path,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByPath(path);

        List<PmlFilePCCCAttachedFile> list = findByPath(path, count - 1, count,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("path=" + path);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByPath_PrevAndNext(
        long attachedFileId, String path, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByPath(path);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByDateCreated(Date dateCreated)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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

                List<PmlFilePCCCAttachedFile> list = q.list();

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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public List<PmlFilePCCCAttachedFile> findByDateCreated(Date dateCreated,
        int start, int end) throws SystemException {
        return findByDateCreated(dateCreated, start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findByDateCreated(Date dateCreated,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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

                List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public PmlFilePCCCAttachedFile findByDateCreated_First(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByDateCreated(dateCreated, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByDateCreated_Last(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByDateCreated(dateCreated);

        List<PmlFilePCCCAttachedFile> list = findByDateCreated(dateCreated,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByDateCreated_PrevAndNext(
        long attachedFileId, Date dateCreated, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByDateCreated(dateCreated);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByFileType(String fileType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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

                List<PmlFilePCCCAttachedFile> list = q.list();

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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public List<PmlFilePCCCAttachedFile> findByFileType(String fileType,
        int start, int end) throws SystemException {
        return findByFileType(fileType, start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findByFileType(String fileType,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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

                List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public PmlFilePCCCAttachedFile findByFileType_First(String fileType,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByFileType(fileType, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("fileType=" + fileType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByFileType_Last(String fileType,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByFileType(fileType);

        List<PmlFilePCCCAttachedFile> list = findByFileType(fileType,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("fileType=" + fileType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByFileType_PrevAndNext(
        long attachedFileId, String fileType, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByFileType(fileType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCCAttachedFile> findByFilePcccId_ObjectType(
        String filePcccId, String objectType) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
        String finderMethodName = "findByFilePcccId_ObjectType";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { filePcccId, objectType };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

                if (filePcccId == null) {
                    query.append("filepcccid IS NULL");
                } else {
                    query.append("filepcccid = ?");
                }

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objecttype IS NULL");
                } else {
                    query.append("objecttype = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (filePcccId != null) {
                    qPos.add(filePcccId);
                }

                if (objectType != null) {
                    qPos.add(objectType);
                }

                List<PmlFilePCCCAttachedFile> list = q.list();

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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public List<PmlFilePCCCAttachedFile> findByFilePcccId_ObjectType(
        String filePcccId, String objectType, int start, int end)
        throws SystemException {
        return findByFilePcccId_ObjectType(filePcccId, objectType, start, end,
            null);
    }

    public List<PmlFilePCCCAttachedFile> findByFilePcccId_ObjectType(
        String filePcccId, String objectType, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
        String finderMethodName = "findByFilePcccId_ObjectType";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                filePcccId,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

                if (filePcccId == null) {
                    query.append("filepcccid IS NULL");
                } else {
                    query.append("filepcccid = ?");
                }

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

                if (filePcccId != null) {
                    qPos.add(filePcccId);
                }

                if (objectType != null) {
                    qPos.add(objectType);
                }

                List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public PmlFilePCCCAttachedFile findByFilePcccId_ObjectType_First(
        String filePcccId, String objectType, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<PmlFilePCCCAttachedFile> list = findByFilePcccId_ObjectType(filePcccId,
                objectType, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("filePcccId=" + filePcccId);

            msg.append(", ");
            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile findByFilePcccId_ObjectType_Last(
        String filePcccId, String objectType, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByFilePcccId_ObjectType(filePcccId, objectType);

        List<PmlFilePCCCAttachedFile> list = findByFilePcccId_ObjectType(filePcccId,
                objectType, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCCAttachedFile exists with the key {");

            msg.append("filePcccId=" + filePcccId);

            msg.append(", ");
            msg.append("objectType=" + objectType);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCCAttachedFile[] findByFilePcccId_ObjectType_PrevAndNext(
        long attachedFileId, String filePcccId, String objectType,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile = findByPrimaryKey(attachedFileId);

        int count = countByFilePcccId_ObjectType(filePcccId, objectType);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

            if (filePcccId == null) {
                query.append("filepcccid IS NULL");
            } else {
                query.append("filepcccid = ?");
            }

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

            if (filePcccId != null) {
                qPos.add(filePcccId);
            }

            if (objectType != null) {
                qPos.add(objectType);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCCAttachedFile);

            PmlFilePCCCAttachedFile[] array = new PmlFilePCCCAttachedFileImpl[3];

            array[0] = (PmlFilePCCCAttachedFile) objArray[0];
            array[1] = (PmlFilePCCCAttachedFile) objArray[1];
            array[2] = (PmlFilePCCCAttachedFile) objArray[2];

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

    public List<PmlFilePCCCAttachedFile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFilePCCCAttachedFile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFilePCCCAttachedFile> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }

                Query q = session.createQuery(query.toString());

                List<PmlFilePCCCAttachedFile> list = (List<PmlFilePCCCAttachedFile>) QueryUtil.list(q,
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
            return (List<PmlFilePCCCAttachedFile>) result;
        }
    }

    public void removeByFilePcccId(String filePcccId) throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByFilePcccId(
                filePcccId)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeByObjectType(String objectType) throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByObjectType(
                objectType)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeByAttachedFileName(String attachedFileName)
        throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByAttachedFileName(
                attachedFileName)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeByPath(String path) throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByPath(path)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeByDateCreated(Date dateCreated) throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByDateCreated(
                dateCreated)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeByFileType(String fileType) throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByFileType(
                fileType)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeByFilePcccId_ObjectType(String filePcccId,
        String objectType) throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findByFilePcccId_ObjectType(
                filePcccId, objectType)) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFilePCCCAttachedFile pmlFilePCCCAttachedFile : findAll()) {
            remove(pmlFilePCCCAttachedFile);
        }
    }

    public int countByFilePcccId(String filePcccId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
        String finderMethodName = "countByFilePcccId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { filePcccId };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

                if (filePcccId == null) {
                    query.append("filepcccid LIKE null");
                } else {
                    query.append("filepcccid LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (filePcccId != null) {
                    qPos.add(filePcccId);
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

    public int countByObjectType(String objectType) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

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

    public int countByFilePcccId_ObjectType(String filePcccId, String objectType)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
        String finderMethodName = "countByFilePcccId_ObjectType";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { filePcccId, objectType };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile WHERE ");

                if (filePcccId == null) {
                    query.append("filepcccid IS NULL");
                } else {
                    query.append("filepcccid = ?");
                }

                query.append(" AND ");

                if (objectType == null) {
                    query.append("objecttype IS NULL");
                } else {
                    query.append("objecttype = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (filePcccId != null) {
                    qPos.add(filePcccId);
                }

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

    public int countAll() throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCAttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCCAttachedFile.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile");

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
                        "value.object.listener.com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile")));

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
