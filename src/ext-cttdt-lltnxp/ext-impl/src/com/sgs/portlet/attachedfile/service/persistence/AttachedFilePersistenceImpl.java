package com.sgs.portlet.attachedfile.service.persistence;

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

import com.sgs.portlet.attachedfile.NoSuchAttachedFileException;
import com.sgs.portlet.attachedfile.model.AttachedFile;
import com.sgs.portlet.attachedfile.model.impl.AttachedFileImpl;
import com.sgs.portlet.attachedfile.model.impl.AttachedFileModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class AttachedFilePersistenceImpl extends BasePersistenceImpl
    implements AttachedFilePersistence {
    private static Log _log = LogFactory.getLog(AttachedFilePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public AttachedFile create(String attachedFileId) {
        AttachedFile attachedFile = new AttachedFileImpl();

        attachedFile.setNew(true);
        attachedFile.setPrimaryKey(attachedFileId);

        return attachedFile;
    }

    public AttachedFile remove(String attachedFileId)
        throws NoSuchAttachedFileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            AttachedFile attachedFile = (AttachedFile) session.get(AttachedFileImpl.class,
                    attachedFileId);

            if (attachedFile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No AttachedFile exists with the primary key " +
                        attachedFileId);
                }

                throw new NoSuchAttachedFileException(
                    "No AttachedFile exists with the primary key " +
                    attachedFileId);
            }

            return remove(attachedFile);
        } catch (NoSuchAttachedFileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public AttachedFile remove(AttachedFile attachedFile)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(attachedFile);
            }
        }

        attachedFile = removeImpl(attachedFile);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(attachedFile);
            }
        }

        return attachedFile;
    }

    protected AttachedFile removeImpl(AttachedFile attachedFile)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(attachedFile);

            session.flush();

            return attachedFile;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(AttachedFile.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(AttachedFile attachedFile, boolean merge)</code>.
     */
    public AttachedFile update(AttachedFile attachedFile)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(AttachedFile attachedFile) method. Use update(AttachedFile attachedFile, boolean merge) instead.");
        }

        return update(attachedFile, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                attachedFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when attachedFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public AttachedFile update(AttachedFile attachedFile, boolean merge)
        throws SystemException {
        boolean isNew = attachedFile.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(attachedFile);
                } else {
                    listener.onBeforeUpdate(attachedFile);
                }
            }
        }

        attachedFile = updateImpl(attachedFile, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(attachedFile);
                } else {
                    listener.onAfterUpdate(attachedFile);
                }
            }
        }

        return attachedFile;
    }

    public AttachedFile updateImpl(
        com.sgs.portlet.attachedfile.model.AttachedFile attachedFile,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(attachedFile);
            } else {
                if (attachedFile.isNew()) {
                    session.save(attachedFile);
                }
            }

            session.flush();

            attachedFile.setNew(false);

            return attachedFile;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(AttachedFile.class.getName());
        }
    }

    public AttachedFile findByPrimaryKey(String attachedFileId)
        throws NoSuchAttachedFileException, SystemException {
        AttachedFile attachedFile = fetchByPrimaryKey(attachedFileId);

        if (attachedFile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No AttachedFile exists with the primary key " +
                    attachedFileId);
            }

            throw new NoSuchAttachedFileException(
                "No AttachedFile exists with the primary key " +
                attachedFileId);
        }

        return attachedFile;
    }

    public AttachedFile fetchByPrimaryKey(String attachedFileId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (AttachedFile) session.get(AttachedFileImpl.class,
                attachedFileId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<AttachedFile> findByAttachedFileCode(String attachedFileCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
        String finderMethodName = "findByAttachedFileCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { attachedFileCode };

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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileCode == null) {
                    query.append("attachedfilecode LIKE null");
                } else {
                    query.append("lower(attachedfilecode) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("attachedfileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileCode != null) {
                    qPos.add(attachedFileCode);
                }

                List<AttachedFile> list = q.list();

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
            return (List<AttachedFile>) result;
        }
    }

    public List<AttachedFile> findByAttachedFileCode(String attachedFileCode,
        int start, int end) throws SystemException {
        return findByAttachedFileCode(attachedFileCode, start, end, null);
    }

    public List<AttachedFile> findByAttachedFileCode(String attachedFileCode,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
        String finderMethodName = "findByAttachedFileCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                attachedFileCode,
                
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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileCode == null) {
                    query.append("attachedfilecode LIKE null");
                } else {
                    query.append("lower(attachedfilecode) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("attachedfileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileCode != null) {
                    qPos.add(attachedFileCode);
                }

                List<AttachedFile> list = (List<AttachedFile>) QueryUtil.list(q,
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
            return (List<AttachedFile>) result;
        }
    }

    public AttachedFile findByAttachedFileCode_First(String attachedFileCode,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<AttachedFile> list = findByAttachedFileCode(attachedFileCode, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("attachedFileCode=" + attachedFileCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile findByAttachedFileCode_Last(String attachedFileCode,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByAttachedFileCode(attachedFileCode);

        List<AttachedFile> list = findByAttachedFileCode(attachedFileCode,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("attachedFileCode=" + attachedFileCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile[] findByAttachedFileCode_PrevAndNext(
        String attachedFileId, String attachedFileCode, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        AttachedFile attachedFile = findByPrimaryKey(attachedFileId);

        int count = countByAttachedFileCode(attachedFileCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

            if (attachedFileCode == null) {
                query.append("attachedfilecode LIKE null");
            } else {
                query.append("lower(attachedfilecode) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("attachedfileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileCode != null) {
                qPos.add(attachedFileCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    attachedFile);

            AttachedFile[] array = new AttachedFileImpl[3];

            array[0] = (AttachedFile) objArray[0];
            array[1] = (AttachedFile) objArray[1];
            array[2] = (AttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<AttachedFile> findByAttachedFileName(String attachedFileName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("lower(attachedfilename) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("attachedfileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                List<AttachedFile> list = q.list();

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
            return (List<AttachedFile>) result;
        }
    }

    public List<AttachedFile> findByAttachedFileName(String attachedFileName,
        int start, int end) throws SystemException {
        return findByAttachedFileName(attachedFileName, start, end, null);
    }

    public List<AttachedFile> findByAttachedFileName(String attachedFileName,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("lower(attachedfilename) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("attachedfileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                List<AttachedFile> list = (List<AttachedFile>) QueryUtil.list(q,
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
            return (List<AttachedFile>) result;
        }
    }

    public AttachedFile findByAttachedFileName_First(String attachedFileName,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<AttachedFile> list = findByAttachedFileName(attachedFileName, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile findByAttachedFileName_Last(String attachedFileName,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByAttachedFileName(attachedFileName);

        List<AttachedFile> list = findByAttachedFileName(attachedFileName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("attachedFileName=" + attachedFileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile[] findByAttachedFileName_PrevAndNext(
        String attachedFileId, String attachedFileName, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        AttachedFile attachedFile = findByPrimaryKey(attachedFileId);

        int count = countByAttachedFileName(attachedFileName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

            if (attachedFileName == null) {
                query.append("attachedfilename LIKE null");
            } else {
                query.append("lower(attachedfilename) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("attachedfileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    attachedFile);

            AttachedFile[] array = new AttachedFileImpl[3];

            array[0] = (AttachedFile) objArray[0];
            array[1] = (AttachedFile) objArray[1];
            array[2] = (AttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<AttachedFile> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
        String finderMethodName = "findByDescription";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { description };

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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("lower(description) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("attachedfileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<AttachedFile> list = q.list();

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
            return (List<AttachedFile>) result;
        }
    }

    public List<AttachedFile> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<AttachedFile> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
        String finderMethodName = "findByDescription";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                description,
                
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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("lower(description) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("attachedfileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<AttachedFile> list = (List<AttachedFile>) QueryUtil.list(q,
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
            return (List<AttachedFile>) result;
        }
    }

    public AttachedFile findByDescription_First(String description,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<AttachedFile> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile findByDescription_Last(String description,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByDescription(description);

        List<AttachedFile> list = findByDescription(description, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile[] findByDescription_PrevAndNext(String attachedFileId,
        String description, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        AttachedFile attachedFile = findByPrimaryKey(attachedFileId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

            if (description == null) {
                query.append("description LIKE null");
            } else {
                query.append("lower(description) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("attachedfileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    attachedFile);

            AttachedFile[] array = new AttachedFileImpl[3];

            array[0] = (AttachedFile) objArray[0];
            array[1] = (AttachedFile) objArray[1];
            array[2] = (AttachedFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<AttachedFile> findByC_N_D(String attachedFileCode,
        String attachedFileName, String description) throws SystemException {
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                attachedFileCode,
                
                attachedFileName,
                
                description
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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileCode == null) {
                    query.append("attachedfilecode LIKE null");
                } else {
                    query.append("attachedfilecode LIKE ?");
                }

                query.append(" AND ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("attachedfilename LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("attachedfileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileCode != null) {
                    qPos.add(attachedFileCode);
                }

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<AttachedFile> list = q.list();

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
            return (List<AttachedFile>) result;
        }
    }

    public List<AttachedFile> findByC_N_D(String attachedFileCode,
        String attachedFileName, String description, int start, int end)
        throws SystemException {
        return findByC_N_D(attachedFileCode, attachedFileName, description,
            start, end, null);
    }

    public List<AttachedFile> findByC_N_D(String attachedFileCode,
        String attachedFileName, String description, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
        String finderMethodName = "findByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                attachedFileCode,
                
                attachedFileName,
                
                description,
                
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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileCode == null) {
                    query.append("attachedfilecode LIKE null");
                } else {
                    query.append("attachedfilecode LIKE ?");
                }

                query.append(" AND ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("attachedfilename LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("attachedfileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileCode != null) {
                    qPos.add(attachedFileCode);
                }

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                if (description != null) {
                    qPos.add(description);
                }

                List<AttachedFile> list = (List<AttachedFile>) QueryUtil.list(q,
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
            return (List<AttachedFile>) result;
        }
    }

    public AttachedFile findByC_N_D_First(String attachedFileCode,
        String attachedFileName, String description, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        List<AttachedFile> list = findByC_N_D(attachedFileCode,
                attachedFileName, description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("attachedFileCode=" + attachedFileCode);

            msg.append(", ");
            msg.append("attachedFileName=" + attachedFileName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile findByC_N_D_Last(String attachedFileCode,
        String attachedFileName, String description, OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        int count = countByC_N_D(attachedFileCode, attachedFileName, description);

        List<AttachedFile> list = findByC_N_D(attachedFileCode,
                attachedFileName, description, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No AttachedFile exists with the key {");

            msg.append("attachedFileCode=" + attachedFileCode);

            msg.append(", ");
            msg.append("attachedFileName=" + attachedFileName);

            msg.append(", ");
            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchAttachedFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public AttachedFile[] findByC_N_D_PrevAndNext(String attachedFileId,
        String attachedFileCode, String attachedFileName, String description,
        OrderByComparator obc)
        throws NoSuchAttachedFileException, SystemException {
        AttachedFile attachedFile = findByPrimaryKey(attachedFileId);

        int count = countByC_N_D(attachedFileCode, attachedFileName, description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

            if (attachedFileCode == null) {
                query.append("attachedfilecode LIKE null");
            } else {
                query.append("attachedfilecode LIKE ?");
            }

            query.append(" AND ");

            if (attachedFileName == null) {
                query.append("attachedfilename LIKE null");
            } else {
                query.append("attachedfilename LIKE ?");
            }

            query.append(" AND ");

            if (description == null) {
                query.append("description LIKE null");
            } else {
                query.append("description LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("attachedfileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (attachedFileCode != null) {
                qPos.add(attachedFileCode);
            }

            if (attachedFileName != null) {
                qPos.add(attachedFileName);
            }

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    attachedFile);

            AttachedFile[] array = new AttachedFileImpl[3];

            array[0] = (AttachedFile) objArray[0];
            array[1] = (AttachedFile) objArray[1];
            array[2] = (AttachedFile) objArray[2];

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

    public List<AttachedFile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<AttachedFile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<AttachedFile> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("attachedfileid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<AttachedFile> list = (List<AttachedFile>) QueryUtil.list(q,
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
            return (List<AttachedFile>) result;
        }
    }

    public void removeByAttachedFileCode(String attachedFileCode)
        throws SystemException {
        for (AttachedFile attachedFile : findByAttachedFileCode(
                attachedFileCode)) {
            remove(attachedFile);
        }
    }

    public void removeByAttachedFileName(String attachedFileName)
        throws SystemException {
        for (AttachedFile attachedFile : findByAttachedFileName(
                attachedFileName)) {
            remove(attachedFile);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (AttachedFile attachedFile : findByDescription(description)) {
            remove(attachedFile);
        }
    }

    public void removeByC_N_D(String attachedFileCode, String attachedFileName,
        String description) throws SystemException {
        for (AttachedFile attachedFile : findByC_N_D(attachedFileCode,
                attachedFileName, description)) {
            remove(attachedFile);
        }
    }

    public void removeAll() throws SystemException {
        for (AttachedFile attachedFile : findAll()) {
            remove(attachedFile);
        }
    }

    public int countByAttachedFileCode(String attachedFileCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
        String finderMethodName = "countByAttachedFileCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { attachedFileCode };

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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileCode == null) {
                    query.append("attachedfilecode LIKE null");
                } else {
                    query.append("lower(attachedfilecode) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileCode != null) {
                    qPos.add(attachedFileCode);
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
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("lower(attachedfilename) LIKE ?");
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

    public int countByDescription(String description) throws SystemException {
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
        String finderMethodName = "countByDescription";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { description };

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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("lower(description) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
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

    public int countByC_N_D(String attachedFileCode, String attachedFileName,
        String description) throws SystemException {
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
        String finderMethodName = "countByC_N_D";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                String.class.getName()
            };
        Object[] finderArgs = new Object[] {
                attachedFileCode,
                
                attachedFileName,
                
                description
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
                    "FROM com.sgs.portlet.attachedfile.model.AttachedFile WHERE ");

                if (attachedFileCode == null) {
                    query.append("attachedfilecode LIKE null");
                } else {
                    query.append("attachedfilecode LIKE ?");
                }

                query.append(" AND ");

                if (attachedFileName == null) {
                    query.append("attachedfilename LIKE null");
                } else {
                    query.append("attachedfilename LIKE ?");
                }

                query.append(" AND ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("description LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (attachedFileCode != null) {
                    qPos.add(attachedFileCode);
                }

                if (attachedFileName != null) {
                    qPos.add(attachedFileName);
                }

                if (description != null) {
                    qPos.add(description);
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
        boolean finderClassNameCacheEnabled = AttachedFileModelImpl.CACHE_ENABLED;
        String finderClassName = AttachedFile.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.attachedfile.model.AttachedFile");

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
                        "value.object.listener.com.sgs.portlet.attachedfile.model.AttachedFile")));

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
