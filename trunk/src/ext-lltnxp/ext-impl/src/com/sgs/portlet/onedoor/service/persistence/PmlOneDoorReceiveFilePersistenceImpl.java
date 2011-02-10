package com.sgs.portlet.onedoor.service.persistence;

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

import com.sgs.portlet.onedoor.NoSuchPmlOneDoorReceiveFileException;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.model.impl.PmlOneDoorReceiveFileImpl;
import com.sgs.portlet.onedoor.model.impl.PmlOneDoorReceiveFileModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class PmlOneDoorReceiveFilePersistenceImpl extends BasePersistenceImpl
    implements PmlOneDoorReceiveFilePersistence {
    private static Log _log = LogFactory.getLog(PmlOneDoorReceiveFilePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlOneDoorReceiveFile create(String fileId) {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = new PmlOneDoorReceiveFileImpl();

        pmlOneDoorReceiveFile.setNew(true);
        pmlOneDoorReceiveFile.setPrimaryKey(fileId);

        return pmlOneDoorReceiveFile;
    }

    public PmlOneDoorReceiveFile remove(String fileId)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlOneDoorReceiveFile pmlOneDoorReceiveFile = (PmlOneDoorReceiveFile) session.get(PmlOneDoorReceiveFileImpl.class,
                    fileId);

            if (pmlOneDoorReceiveFile == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(
                        "No PmlOneDoorReceiveFile exists with the primary key " +
                        fileId);
                }

                throw new NoSuchPmlOneDoorReceiveFileException(
                    "No PmlOneDoorReceiveFile exists with the primary key " +
                    fileId);
            }

            return remove(pmlOneDoorReceiveFile);
        } catch (NoSuchPmlOneDoorReceiveFileException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlOneDoorReceiveFile remove(
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile) throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlOneDoorReceiveFile);
            }
        }

        pmlOneDoorReceiveFile = removeImpl(pmlOneDoorReceiveFile);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlOneDoorReceiveFile);
            }
        }

        return pmlOneDoorReceiveFile;
    }

    protected PmlOneDoorReceiveFile removeImpl(
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlOneDoorReceiveFile);

            session.flush();

            return pmlOneDoorReceiveFile;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlOneDoorReceiveFile.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlOneDoorReceiveFile pmlOneDoorReceiveFile, boolean merge)</code>.
     */
    public PmlOneDoorReceiveFile update(
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile) throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlOneDoorReceiveFile pmlOneDoorReceiveFile) method. Use update(PmlOneDoorReceiveFile pmlOneDoorReceiveFile, boolean merge) instead.");
        }

        return update(pmlOneDoorReceiveFile, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlOneDoorReceiveFile the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlOneDoorReceiveFile is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlOneDoorReceiveFile update(
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile, boolean merge)
        throws SystemException {
        boolean isNew = pmlOneDoorReceiveFile.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlOneDoorReceiveFile);
                } else {
                    listener.onBeforeUpdate(pmlOneDoorReceiveFile);
                }
            }
        }

        pmlOneDoorReceiveFile = updateImpl(pmlOneDoorReceiveFile, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlOneDoorReceiveFile);
                } else {
                    listener.onAfterUpdate(pmlOneDoorReceiveFile);
                }
            }
        }

        return pmlOneDoorReceiveFile;
    }

    public PmlOneDoorReceiveFile updateImpl(
        com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile pmlOneDoorReceiveFile,
        boolean merge) throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlOneDoorReceiveFile);
            } else {
                if (pmlOneDoorReceiveFile.isNew()) {
                    session.save(pmlOneDoorReceiveFile);
                }
            }

            session.flush();

            pmlOneDoorReceiveFile.setNew(false);

            return pmlOneDoorReceiveFile;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlOneDoorReceiveFile.class.getName());
        }
    }

    public PmlOneDoorReceiveFile findByPrimaryKey(String fileId)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = fetchByPrimaryKey(fileId);

        if (pmlOneDoorReceiveFile == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(
                    "No PmlOneDoorReceiveFile exists with the primary key " +
                    fileId);
            }

            throw new NoSuchPmlOneDoorReceiveFileException(
                "No PmlOneDoorReceiveFile exists with the primary key " +
                fileId);
        }

        return pmlOneDoorReceiveFile;
    }

    public PmlOneDoorReceiveFile fetchByPrimaryKey(String fileId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlOneDoorReceiveFile) session.get(PmlOneDoorReceiveFileImpl.class,
                fileId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId(String fileTypeId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlOneDoorReceiveFile> list = q.list();

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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId(String fileTypeId,
        int start, int end) throws SystemException {
        return findByFileTypeId(fileTypeId, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId(String fileTypeId,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

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

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public PmlOneDoorReceiveFile findByFileTypeId_First(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByFileTypeId(fileTypeId, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByFileTypeId_Last(String fileTypeId,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByFileTypeId(fileTypeId);

        List<PmlOneDoorReceiveFile> list = findByFileTypeId(fileTypeId,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByFileTypeId_PrevAndNext(String fileId,
        String fileTypeId, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByFileTypeId(fileTypeId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

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

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByApplicationDate(
        Date applicationDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByApplicationDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { applicationDate };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (applicationDate == null) {
                    query.append("applicationDate IS NULL");
                } else {
                    query.append("applicationDate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicationDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(applicationDate));
                }

                List<PmlOneDoorReceiveFile> list = q.list();

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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public List<PmlOneDoorReceiveFile> findByApplicationDate(
        Date applicationDate, int start, int end) throws SystemException {
        return findByApplicationDate(applicationDate, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByApplicationDate(
        Date applicationDate, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByApplicationDate";
        String[] finderParams = new String[] {
                Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                applicationDate,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (applicationDate == null) {
                    query.append("applicationDate IS NULL");
                } else {
                    query.append("applicationDate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicationDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(applicationDate));
                }

                List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public PmlOneDoorReceiveFile findByApplicationDate_First(
        Date applicationDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByApplicationDate(applicationDate,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("applicationDate=" + applicationDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByApplicationDate_Last(
        Date applicationDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByApplicationDate(applicationDate);

        List<PmlOneDoorReceiveFile> list = findByApplicationDate(applicationDate,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("applicationDate=" + applicationDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByApplicationDate_PrevAndNext(
        String fileId, Date applicationDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByApplicationDate(applicationDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (applicationDate == null) {
                query.append("applicationDate IS NULL");
            } else {
                query.append("applicationDate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (applicationDate != null) {
                qPos.add(CalendarUtil.getTimestamp(applicationDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByApplicantName(String applicantName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByApplicantName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { applicantName };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (applicantName == null) {
                    query.append("applicantName LIKE null");
                } else {
                    query.append("applicantName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicantName != null) {
                    qPos.add(applicantName);
                }

                List<PmlOneDoorReceiveFile> list = q.list();

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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public List<PmlOneDoorReceiveFile> findByApplicantName(
        String applicantName, int start, int end) throws SystemException {
        return findByApplicantName(applicantName, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByApplicantName(
        String applicantName, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByApplicantName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                applicantName,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (applicantName == null) {
                    query.append("applicantName LIKE null");
                } else {
                    query.append("applicantName LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicantName != null) {
                    qPos.add(applicantName);
                }

                List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public PmlOneDoorReceiveFile findByApplicantName_First(
        String applicantName, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByApplicantName(applicantName,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("applicantName=" + applicantName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByApplicantName_Last(
        String applicantName, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByApplicantName(applicantName);

        List<PmlOneDoorReceiveFile> list = findByApplicantName(applicantName,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("applicantName=" + applicantName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByApplicantName_PrevAndNext(
        String fileId, String applicantName, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByApplicantName(applicantName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (applicantName == null) {
                query.append("applicantName LIKE null");
            } else {
                query.append("applicantName LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (applicantName != null) {
                qPos.add(applicantName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByOrganization(String organization)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByOrganization";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { organization };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (organization == null) {
                    query.append("organization LIKE null");
                } else {
                    query.append("organization LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (organization != null) {
                    qPos.add(organization);
                }

                List<PmlOneDoorReceiveFile> list = q.list();

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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public List<PmlOneDoorReceiveFile> findByOrganization(String organization,
        int start, int end) throws SystemException {
        return findByOrganization(organization, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByOrganization(String organization,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByOrganization";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                organization,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (organization == null) {
                    query.append("organization LIKE null");
                } else {
                    query.append("organization LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (organization != null) {
                    qPos.add(organization);
                }

                List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public PmlOneDoorReceiveFile findByOrganization_First(String organization,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByOrganization(organization, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("organization=" + organization);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByOrganization_Last(String organization,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByOrganization(organization);

        List<PmlOneDoorReceiveFile> list = findByOrganization(organization,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("organization=" + organization);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByOrganization_PrevAndNext(
        String fileId, String organization, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByOrganization(organization);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (organization == null) {
                query.append("organization LIKE null");
            } else {
                query.append("organization LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (organization != null) {
                qPos.add(organization);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByPermanentAddress(
        String permanentAddress) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByPermanentAddress";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { permanentAddress };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (permanentAddress == null) {
                    query.append("permanentAddress LIKE null");
                } else {
                    query.append("permanentAddress LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (permanentAddress != null) {
                    qPos.add(permanentAddress);
                }

                List<PmlOneDoorReceiveFile> list = q.list();

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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public List<PmlOneDoorReceiveFile> findByPermanentAddress(
        String permanentAddress, int start, int end) throws SystemException {
        return findByPermanentAddress(permanentAddress, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByPermanentAddress(
        String permanentAddress, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByPermanentAddress";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                permanentAddress,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (permanentAddress == null) {
                    query.append("permanentAddress LIKE null");
                } else {
                    query.append("permanentAddress LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (permanentAddress != null) {
                    qPos.add(permanentAddress);
                }

                List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public PmlOneDoorReceiveFile findByPermanentAddress_First(
        String permanentAddress, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByPermanentAddress(permanentAddress,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("permanentAddress=" + permanentAddress);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByPermanentAddress_Last(
        String permanentAddress, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByPermanentAddress(permanentAddress);

        List<PmlOneDoorReceiveFile> list = findByPermanentAddress(permanentAddress,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("permanentAddress=" + permanentAddress);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByPermanentAddress_PrevAndNext(
        String fileId, String permanentAddress, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByPermanentAddress(permanentAddress);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (permanentAddress == null) {
                query.append("permanentAddress LIKE null");
            } else {
                query.append("permanentAddress LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (permanentAddress != null) {
                qPos.add(permanentAddress);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByAuthorisedLetter(
        String authorisedLetter) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByAuthorisedLetter";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { authorisedLetter };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (authorisedLetter == null) {
                    query.append("authorisedLetter LIKE null");
                } else {
                    query.append("authorisedLetter LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (authorisedLetter != null) {
                    qPos.add(authorisedLetter);
                }

                List<PmlOneDoorReceiveFile> list = q.list();

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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public List<PmlOneDoorReceiveFile> findByAuthorisedLetter(
        String authorisedLetter, int start, int end) throws SystemException {
        return findByAuthorisedLetter(authorisedLetter, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByAuthorisedLetter(
        String authorisedLetter, int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByAuthorisedLetter";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                authorisedLetter,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (authorisedLetter == null) {
                    query.append("authorisedLetter LIKE null");
                } else {
                    query.append("authorisedLetter LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (authorisedLetter != null) {
                    qPos.add(authorisedLetter);
                }

                List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public PmlOneDoorReceiveFile findByAuthorisedLetter_First(
        String authorisedLetter, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByAuthorisedLetter(authorisedLetter,
                0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("authorisedLetter=" + authorisedLetter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByAuthorisedLetter_Last(
        String authorisedLetter, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByAuthorisedLetter(authorisedLetter);

        List<PmlOneDoorReceiveFile> list = findByAuthorisedLetter(authorisedLetter,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("authorisedLetter=" + authorisedLetter);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByAuthorisedLetter_PrevAndNext(
        String fileId, String authorisedLetter, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByAuthorisedLetter(authorisedLetter);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (authorisedLetter == null) {
                query.append("authorisedLetter LIKE null");
            } else {
                query.append("authorisedLetter LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (authorisedLetter != null) {
                qPos.add(authorisedLetter);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByDateCreated(Date dateCreated)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (dateCreated == null) {
                    query.append("dateCreated IS NULL");
                } else {
                    query.append("dateCreated = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                List<PmlOneDoorReceiveFile> list = q.list();

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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public List<PmlOneDoorReceiveFile> findByDateCreated(Date dateCreated,
        int start, int end) throws SystemException {
        return findByDateCreated(dateCreated, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByDateCreated(Date dateCreated,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (dateCreated == null) {
                    query.append("dateCreated IS NULL");
                } else {
                    query.append("dateCreated = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (dateCreated != null) {
                    qPos.add(CalendarUtil.getTimestamp(dateCreated));
                }

                List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public PmlOneDoorReceiveFile findByDateCreated_First(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByDateCreated(dateCreated, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByDateCreated_Last(Date dateCreated,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByDateCreated(dateCreated);

        List<PmlOneDoorReceiveFile> list = findByDateCreated(dateCreated,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("dateCreated=" + dateCreated);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByDateCreated_PrevAndNext(
        String fileId, Date dateCreated, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByDateCreated(dateCreated);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (dateCreated == null) {
                query.append("dateCreated IS NULL");
            } else {
                query.append("dateCreated = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (dateCreated != null) {
                qPos.add(CalendarUtil.getTimestamp(dateCreated));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId_ApplicationDate(
        String fileTypeId, Date applicationDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByFileTypeId_ApplicationDate";
        String[] finderParams = new String[] {
                String.class.getName(), Date.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, applicationDate };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (applicationDate == null) {
                    query.append("applicationDate IS NULL");
                } else {
                    query.append("applicationDate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (applicationDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(applicationDate));
                }

                List<PmlOneDoorReceiveFile> list = q.list();

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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId_ApplicationDate(
        String fileTypeId, Date applicationDate, int start, int end)
        throws SystemException {
        return findByFileTypeId_ApplicationDate(fileTypeId, applicationDate,
            start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId_ApplicationDate(
        String fileTypeId, Date applicationDate, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByFileTypeId_ApplicationDate";
        String[] finderParams = new String[] {
                String.class.getName(), Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                applicationDate,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (applicationDate == null) {
                    query.append("applicationDate IS NULL");
                } else {
                    query.append("applicationDate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (applicationDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(applicationDate));
                }

                List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public PmlOneDoorReceiveFile findByFileTypeId_ApplicationDate_First(
        String fileTypeId, Date applicationDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByFileTypeId_ApplicationDate(fileTypeId,
                applicationDate, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("applicationDate=" + applicationDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByFileTypeId_ApplicationDate_Last(
        String fileTypeId, Date applicationDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByFileTypeId_ApplicationDate(fileTypeId,
                applicationDate);

        List<PmlOneDoorReceiveFile> list = findByFileTypeId_ApplicationDate(fileTypeId,
                applicationDate, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("applicationDate=" + applicationDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByFileTypeId_ApplicationDate_PrevAndNext(
        String fileId, String fileTypeId, Date applicationDate,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByFileTypeId_ApplicationDate(fileTypeId,
                applicationDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (fileTypeId == null) {
                query.append("fileTypeId LIKE null");
            } else {
                query.append("fileTypeId LIKE ?");
            }

            query.append(" AND ");

            if (applicationDate == null) {
                query.append("applicationDate IS NULL");
            } else {
                query.append("applicationDate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            if (applicationDate != null) {
                qPos.add(CalendarUtil.getTimestamp(applicationDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId_ExactReturningDate(
        String fileTypeId, Date exactReturningDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByFileTypeId_ExactReturningDate";
        String[] finderParams = new String[] {
                String.class.getName(), Date.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, exactReturningDate };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (exactReturningDate == null) {
                    query.append("exactReturningDate IS NULL");
                } else {
                    query.append("exactReturningDate = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (exactReturningDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(exactReturningDate));
                }

                List<PmlOneDoorReceiveFile> list = q.list();

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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId_ExactReturningDate(
        String fileTypeId, Date exactReturningDate, int start, int end)
        throws SystemException {
        return findByFileTypeId_ExactReturningDate(fileTypeId,
            exactReturningDate, start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findByFileTypeId_ExactReturningDate(
        String fileTypeId, Date exactReturningDate, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByFileTypeId_ExactReturningDate";
        String[] finderParams = new String[] {
                String.class.getName(), Date.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                exactReturningDate,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (exactReturningDate == null) {
                    query.append("exactReturningDate IS NULL");
                } else {
                    query.append("exactReturningDate = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (exactReturningDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(exactReturningDate));
                }

                List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public PmlOneDoorReceiveFile findByFileTypeId_ExactReturningDate_First(
        String fileTypeId, Date exactReturningDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByFileTypeId_ExactReturningDate(fileTypeId,
                exactReturningDate, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("exactReturningDate=" + exactReturningDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByFileTypeId_ExactReturningDate_Last(
        String fileTypeId, Date exactReturningDate, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByFileTypeId_ExactReturningDate(fileTypeId,
                exactReturningDate);

        List<PmlOneDoorReceiveFile> list = findByFileTypeId_ExactReturningDate(fileTypeId,
                exactReturningDate, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("exactReturningDate=" + exactReturningDate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByFileTypeId_ExactReturningDate_PrevAndNext(
        String fileId, String fileTypeId, Date exactReturningDate,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByFileTypeId_ExactReturningDate(fileTypeId,
                exactReturningDate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (fileTypeId == null) {
                query.append("fileTypeId LIKE null");
            } else {
                query.append("fileTypeId LIKE ?");
            }

            query.append(" AND ");

            if (exactReturningDate == null) {
                query.append("exactReturningDate IS NULL");
            } else {
                query.append("exactReturningDate = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            if (exactReturningDate != null) {
                qPos.add(CalendarUtil.getTimestamp(exactReturningDate));
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlOneDoorReceiveFile> findByFileType_NumberReceipt(
        String fileTypeId, String numberReceipt) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByFileType_NumberReceipt";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, numberReceipt };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (numberReceipt == null) {
                    query.append("numberReceipt LIKE null");
                } else {
                    query.append("numberReceipt LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("generalorderno DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (numberReceipt != null) {
                    qPos.add(numberReceipt);
                }

                List<PmlOneDoorReceiveFile> list = q.list();

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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public List<PmlOneDoorReceiveFile> findByFileType_NumberReceipt(
        String fileTypeId, String numberReceipt, int start, int end)
        throws SystemException {
        return findByFileType_NumberReceipt(fileTypeId, numberReceipt, start,
            end, null);
    }

    public List<PmlOneDoorReceiveFile> findByFileType_NumberReceipt(
        String fileTypeId, String numberReceipt, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "findByFileType_NumberReceipt";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileTypeId,
                
                numberReceipt,
                
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (numberReceipt == null) {
                    query.append("numberReceipt LIKE null");
                } else {
                    query.append("numberReceipt LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (numberReceipt != null) {
                    qPos.add(numberReceipt);
                }

                List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public PmlOneDoorReceiveFile findByFileType_NumberReceipt_First(
        String fileTypeId, String numberReceipt, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        List<PmlOneDoorReceiveFile> list = findByFileType_NumberReceipt(fileTypeId,
                numberReceipt, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("numberReceipt=" + numberReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile findByFileType_NumberReceipt_Last(
        String fileTypeId, String numberReceipt, OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        int count = countByFileType_NumberReceipt(fileTypeId, numberReceipt);

        List<PmlOneDoorReceiveFile> list = findByFileType_NumberReceipt(fileTypeId,
                numberReceipt, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlOneDoorReceiveFile exists with the key {");

            msg.append("fileTypeId=" + fileTypeId);

            msg.append(", ");
            msg.append("numberReceipt=" + numberReceipt);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlOneDoorReceiveFileException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlOneDoorReceiveFile[] findByFileType_NumberReceipt_PrevAndNext(
        String fileId, String fileTypeId, String numberReceipt,
        OrderByComparator obc)
        throws NoSuchPmlOneDoorReceiveFileException, SystemException {
        PmlOneDoorReceiveFile pmlOneDoorReceiveFile = findByPrimaryKey(fileId);

        int count = countByFileType_NumberReceipt(fileTypeId, numberReceipt);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

            if (fileTypeId == null) {
                query.append("fileTypeId LIKE null");
            } else {
                query.append("fileTypeId LIKE ?");
            }

            query.append(" AND ");

            if (numberReceipt == null) {
                query.append("numberReceipt LIKE null");
            } else {
                query.append("numberReceipt LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("generalorderno DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeId != null) {
                qPos.add(fileTypeId);
            }

            if (numberReceipt != null) {
                qPos.add(numberReceipt);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlOneDoorReceiveFile);

            PmlOneDoorReceiveFile[] array = new PmlOneDoorReceiveFileImpl[3];

            array[0] = (PmlOneDoorReceiveFile) objArray[0];
            array[1] = (PmlOneDoorReceiveFile) objArray[1];
            array[2] = (PmlOneDoorReceiveFile) objArray[2];

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

    public List<PmlOneDoorReceiveFile> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlOneDoorReceiveFile> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlOneDoorReceiveFile> findAll(int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("generalorderno DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlOneDoorReceiveFile> list = (List<PmlOneDoorReceiveFile>) QueryUtil.list(q,
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
            return (List<PmlOneDoorReceiveFile>) result;
        }
    }

    public void removeByFileTypeId(String fileTypeId) throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByFileTypeId(
                fileTypeId)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByApplicationDate(Date applicationDate)
        throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByApplicationDate(
                applicationDate)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByApplicantName(String applicantName)
        throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByApplicantName(
                applicantName)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByOrganization(String organization)
        throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByOrganization(
                organization)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByPermanentAddress(String permanentAddress)
        throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByPermanentAddress(
                permanentAddress)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByAuthorisedLetter(String authorisedLetter)
        throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByAuthorisedLetter(
                authorisedLetter)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByDateCreated(Date dateCreated) throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByDateCreated(
                dateCreated)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByFileTypeId_ApplicationDate(String fileTypeId,
        Date applicationDate) throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByFileTypeId_ApplicationDate(
                fileTypeId, applicationDate)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByFileTypeId_ExactReturningDate(String fileTypeId,
        Date exactReturningDate) throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByFileTypeId_ExactReturningDate(
                fileTypeId, exactReturningDate)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeByFileType_NumberReceipt(String fileTypeId,
        String numberReceipt) throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findByFileType_NumberReceipt(
                fileTypeId, numberReceipt)) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlOneDoorReceiveFile pmlOneDoorReceiveFile : findAll()) {
            remove(pmlOneDoorReceiveFile);
        }
    }

    public int countByFileTypeId(String fileTypeId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

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

    public int countByApplicationDate(Date applicationDate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "countByApplicationDate";
        String[] finderParams = new String[] { Date.class.getName() };
        Object[] finderArgs = new Object[] { applicationDate };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (applicationDate == null) {
                    query.append("applicationDate IS NULL");
                } else {
                    query.append("applicationDate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicationDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(applicationDate));
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

    public int countByApplicantName(String applicantName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "countByApplicantName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { applicantName };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (applicantName == null) {
                    query.append("applicantName LIKE null");
                } else {
                    query.append("applicantName LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicantName != null) {
                    qPos.add(applicantName);
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

    public int countByOrganization(String organization)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "countByOrganization";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { organization };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (organization == null) {
                    query.append("organization LIKE null");
                } else {
                    query.append("organization LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (organization != null) {
                    qPos.add(organization);
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

    public int countByPermanentAddress(String permanentAddress)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "countByPermanentAddress";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { permanentAddress };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (permanentAddress == null) {
                    query.append("permanentAddress LIKE null");
                } else {
                    query.append("permanentAddress LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (permanentAddress != null) {
                    qPos.add(permanentAddress);
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

    public int countByAuthorisedLetter(String authorisedLetter)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "countByAuthorisedLetter";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { authorisedLetter };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (authorisedLetter == null) {
                    query.append("authorisedLetter LIKE null");
                } else {
                    query.append("authorisedLetter LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (authorisedLetter != null) {
                    qPos.add(authorisedLetter);
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
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (dateCreated == null) {
                    query.append("dateCreated IS NULL");
                } else {
                    query.append("dateCreated = ?");
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

    public int countByFileTypeId_ApplicationDate(String fileTypeId,
        Date applicationDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "countByFileTypeId_ApplicationDate";
        String[] finderParams = new String[] {
                String.class.getName(), Date.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, applicationDate };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (applicationDate == null) {
                    query.append("applicationDate IS NULL");
                } else {
                    query.append("applicationDate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (applicationDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(applicationDate));
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

    public int countByFileTypeId_ExactReturningDate(String fileTypeId,
        Date exactReturningDate) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "countByFileTypeId_ExactReturningDate";
        String[] finderParams = new String[] {
                String.class.getName(), Date.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, exactReturningDate };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (exactReturningDate == null) {
                    query.append("exactReturningDate IS NULL");
                } else {
                    query.append("exactReturningDate = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (exactReturningDate != null) {
                    qPos.add(CalendarUtil.getTimestamp(exactReturningDate));
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

    public int countByFileType_NumberReceipt(String fileTypeId,
        String numberReceipt) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
        String finderMethodName = "countByFileType_NumberReceipt";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeId, numberReceipt };

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
                    "FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile WHERE ");

                if (fileTypeId == null) {
                    query.append("fileTypeId LIKE null");
                } else {
                    query.append("fileTypeId LIKE ?");
                }

                query.append(" AND ");

                if (numberReceipt == null) {
                    query.append("numberReceipt LIKE null");
                } else {
                    query.append("numberReceipt LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeId != null) {
                    qPos.add(fileTypeId);
                }

                if (numberReceipt != null) {
                    qPos.add(numberReceipt);
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
        boolean finderClassNameCacheEnabled = PmlOneDoorReceiveFileModelImpl.CACHE_ENABLED;
        String finderClassName = PmlOneDoorReceiveFile.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile");

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
                        "value.object.listener.com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile")));

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
