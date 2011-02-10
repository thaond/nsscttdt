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

import com.sgs.portlet.onedoorpccc.NoSuchException;
import com.sgs.portlet.onedoorpccc.model.PmlFilePCCC;
import com.sgs.portlet.onedoorpccc.model.impl.PmlFilePCCCImpl;
import com.sgs.portlet.onedoorpccc.model.impl.PmlFilePCCCModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlFilePCCCPersistenceImpl extends BasePersistenceImpl
    implements PmlFilePCCCPersistence {
    private static Log _log = LogFactory.getLog(PmlFilePCCCPersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlFilePCCC create(String fileId) {
        PmlFilePCCC pmlFilePCCC = new PmlFilePCCCImpl();

        pmlFilePCCC.setNew(true);
        pmlFilePCCC.setPrimaryKey(fileId);

        return pmlFilePCCC;
    }

    public PmlFilePCCC remove(String fileId)
        throws NoSuchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFilePCCC pmlFilePCCC = (PmlFilePCCC) session.get(PmlFilePCCCImpl.class,
                    fileId);

            if (pmlFilePCCC == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlFilePCCC exists with the primary key " +
                        fileId);
                }

                throw new NoSuchException(
                    "No PmlFilePCCC exists with the primary key " + fileId);
            }

            return remove(pmlFilePCCC);
        } catch (NoSuchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFilePCCC remove(PmlFilePCCC pmlFilePCCC)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlFilePCCC);
            }
        }

        pmlFilePCCC = removeImpl(pmlFilePCCC);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlFilePCCC);
            }
        }

        return pmlFilePCCC;
    }

    protected PmlFilePCCC removeImpl(PmlFilePCCC pmlFilePCCC)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlFilePCCC);

            session.flush();

            return pmlFilePCCC;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFilePCCC.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlFilePCCC pmlFilePCCC, boolean merge)</code>.
     */
    public PmlFilePCCC update(PmlFilePCCC pmlFilePCCC)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFilePCCC pmlFilePCCC) method. Use update(PmlFilePCCC pmlFilePCCC, boolean merge) instead.");
        }

        return update(pmlFilePCCC, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFilePCCC the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFilePCCC is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFilePCCC update(PmlFilePCCC pmlFilePCCC, boolean merge)
        throws SystemException {
        boolean isNew = pmlFilePCCC.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlFilePCCC);
                } else {
                    listener.onBeforeUpdate(pmlFilePCCC);
                }
            }
        }

        pmlFilePCCC = updateImpl(pmlFilePCCC, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlFilePCCC);
                } else {
                    listener.onAfterUpdate(pmlFilePCCC);
                }
            }
        }

        return pmlFilePCCC;
    }

    public PmlFilePCCC updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlFilePCCC pmlFilePCCC, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlFilePCCC);
            } else {
                if (pmlFilePCCC.isNew()) {
                    session.save(pmlFilePCCC);
                }
            }

            session.flush();

            pmlFilePCCC.setNew(false);

            return pmlFilePCCC;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFilePCCC.class.getName());
        }
    }

    public PmlFilePCCC findByPrimaryKey(String fileId)
        throws NoSuchException, SystemException {
        PmlFilePCCC pmlFilePCCC = fetchByPrimaryKey(fileId);

        if (pmlFilePCCC == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlFilePCCC exists with the primary key " +
                    fileId);
            }

            throw new NoSuchException(
                "No PmlFilePCCC exists with the primary key " + fileId);
        }

        return pmlFilePCCC;
    }

    public PmlFilePCCC fetchByPrimaryKey(String fileId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlFilePCCC) session.get(PmlFilePCCCImpl.class, fileId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCC> findByFileName(String fileName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
        String finderMethodName = "findByFileName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileName };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

                if (fileName == null) {
                    query.append("fileName IS NULL");
                } else {
                    query.append("fileName = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileName != null) {
                    qPos.add(fileName);
                }

                List<PmlFilePCCC> list = q.list();

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
            return (List<PmlFilePCCC>) result;
        }
    }

    public List<PmlFilePCCC> findByFileName(String fileName, int start, int end)
        throws SystemException {
        return findByFileName(fileName, start, end, null);
    }

    public List<PmlFilePCCC> findByFileName(String fileName, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
        String finderMethodName = "findByFileName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileName,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

                if (fileName == null) {
                    query.append("fileName IS NULL");
                } else {
                    query.append("fileName = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileName != null) {
                    qPos.add(fileName);
                }

                List<PmlFilePCCC> list = (List<PmlFilePCCC>) QueryUtil.list(q,
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
            return (List<PmlFilePCCC>) result;
        }
    }

    public PmlFilePCCC findByFileName_First(String fileName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlFilePCCC> list = findByFileName(fileName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("fileName=" + fileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC findByFileName_Last(String fileName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByFileName(fileName);

        List<PmlFilePCCC> list = findByFileName(fileName, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("fileName=" + fileName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC[] findByFileName_PrevAndNext(String fileId,
        String fileName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlFilePCCC pmlFilePCCC = findByPrimaryKey(fileId);

        int count = countByFileName(fileName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

            if (fileName == null) {
                query.append("fileName IS NULL");
            } else {
                query.append("fileName = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileName != null) {
                qPos.add(fileName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCC);

            PmlFilePCCC[] array = new PmlFilePCCCImpl[3];

            array[0] = (PmlFilePCCC) objArray[0];
            array[1] = (PmlFilePCCC) objArray[1];
            array[2] = (PmlFilePCCC) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCC> findByProjectName(String projectName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
        String finderMethodName = "findByProjectName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { projectName };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

                if (projectName == null) {
                    query.append("projectname IS NULL");
                } else {
                    query.append("projectname = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (projectName != null) {
                    qPos.add(projectName);
                }

                List<PmlFilePCCC> list = q.list();

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
            return (List<PmlFilePCCC>) result;
        }
    }

    public List<PmlFilePCCC> findByProjectName(String projectName, int start,
        int end) throws SystemException {
        return findByProjectName(projectName, start, end, null);
    }

    public List<PmlFilePCCC> findByProjectName(String projectName, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
        String finderMethodName = "findByProjectName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                projectName,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

                if (projectName == null) {
                    query.append("projectname IS NULL");
                } else {
                    query.append("projectname = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (projectName != null) {
                    qPos.add(projectName);
                }

                List<PmlFilePCCC> list = (List<PmlFilePCCC>) QueryUtil.list(q,
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
            return (List<PmlFilePCCC>) result;
        }
    }

    public PmlFilePCCC findByProjectName_First(String projectName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlFilePCCC> list = findByProjectName(projectName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("projectName=" + projectName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC findByProjectName_Last(String projectName,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByProjectName(projectName);

        List<PmlFilePCCC> list = findByProjectName(projectName, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("projectName=" + projectName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC[] findByProjectName_PrevAndNext(String fileId,
        String projectName, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlFilePCCC pmlFilePCCC = findByPrimaryKey(fileId);

        int count = countByProjectName(projectName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

            if (projectName == null) {
                query.append("projectname IS NULL");
            } else {
                query.append("projectname = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (projectName != null) {
                qPos.add(projectName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCC);

            PmlFilePCCC[] array = new PmlFilePCCCImpl[3];

            array[0] = (PmlFilePCCC) objArray[0];
            array[1] = (PmlFilePCCC) objArray[1];
            array[2] = (PmlFilePCCC) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCC> findByApplicantCategory(String applicantCategory)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
        String finderMethodName = "findByApplicantCategory";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { applicantCategory };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

                if (applicantCategory == null) {
                    query.append("applicantcategory IS NULL");
                } else {
                    query.append("applicantcategory = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicantCategory != null) {
                    qPos.add(applicantCategory);
                }

                List<PmlFilePCCC> list = q.list();

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
            return (List<PmlFilePCCC>) result;
        }
    }

    public List<PmlFilePCCC> findByApplicantCategory(String applicantCategory,
        int start, int end) throws SystemException {
        return findByApplicantCategory(applicantCategory, start, end, null);
    }

    public List<PmlFilePCCC> findByApplicantCategory(String applicantCategory,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
        String finderMethodName = "findByApplicantCategory";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                applicantCategory,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

                if (applicantCategory == null) {
                    query.append("applicantcategory IS NULL");
                } else {
                    query.append("applicantcategory = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicantCategory != null) {
                    qPos.add(applicantCategory);
                }

                List<PmlFilePCCC> list = (List<PmlFilePCCC>) QueryUtil.list(q,
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
            return (List<PmlFilePCCC>) result;
        }
    }

    public PmlFilePCCC findByApplicantCategory_First(String applicantCategory,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlFilePCCC> list = findByApplicantCategory(applicantCategory, 0,
                1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("applicantCategory=" + applicantCategory);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC findByApplicantCategory_Last(String applicantCategory,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByApplicantCategory(applicantCategory);

        List<PmlFilePCCC> list = findByApplicantCategory(applicantCategory,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("applicantCategory=" + applicantCategory);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC[] findByApplicantCategory_PrevAndNext(String fileId,
        String applicantCategory, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlFilePCCC pmlFilePCCC = findByPrimaryKey(fileId);

        int count = countByApplicantCategory(applicantCategory);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

            if (applicantCategory == null) {
                query.append("applicantcategory IS NULL");
            } else {
                query.append("applicantcategory = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (applicantCategory != null) {
                qPos.add(applicantCategory);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCC);

            PmlFilePCCC[] array = new PmlFilePCCCImpl[3];

            array[0] = (PmlFilePCCC) objArray[0];
            array[1] = (PmlFilePCCC) objArray[1];
            array[2] = (PmlFilePCCC) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFilePCCC> findByReceiveOfUnit(String receiveOfUnit)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
        String finderMethodName = "findByReceiveOfUnit";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { receiveOfUnit };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

                if (receiveOfUnit == null) {
                    query.append("receiveofunit IS NULL");
                } else {
                    query.append("receiveofunit = ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileid DESC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveOfUnit != null) {
                    qPos.add(receiveOfUnit);
                }

                List<PmlFilePCCC> list = q.list();

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
            return (List<PmlFilePCCC>) result;
        }
    }

    public List<PmlFilePCCC> findByReceiveOfUnit(String receiveOfUnit,
        int start, int end) throws SystemException {
        return findByReceiveOfUnit(receiveOfUnit, start, end, null);
    }

    public List<PmlFilePCCC> findByReceiveOfUnit(String receiveOfUnit,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
        String finderMethodName = "findByReceiveOfUnit";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                receiveOfUnit,
                
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

                if (receiveOfUnit == null) {
                    query.append("receiveofunit IS NULL");
                } else {
                    query.append("receiveofunit = ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileid DESC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveOfUnit != null) {
                    qPos.add(receiveOfUnit);
                }

                List<PmlFilePCCC> list = (List<PmlFilePCCC>) QueryUtil.list(q,
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
            return (List<PmlFilePCCC>) result;
        }
    }

    public PmlFilePCCC findByReceiveOfUnit_First(String receiveOfUnit,
        OrderByComparator obc) throws NoSuchException, SystemException {
        List<PmlFilePCCC> list = findByReceiveOfUnit(receiveOfUnit, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("receiveOfUnit=" + receiveOfUnit);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC findByReceiveOfUnit_Last(String receiveOfUnit,
        OrderByComparator obc) throws NoSuchException, SystemException {
        int count = countByReceiveOfUnit(receiveOfUnit);

        List<PmlFilePCCC> list = findByReceiveOfUnit(receiveOfUnit, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFilePCCC exists with the key {");

            msg.append("receiveOfUnit=" + receiveOfUnit);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFilePCCC[] findByReceiveOfUnit_PrevAndNext(String fileId,
        String receiveOfUnit, OrderByComparator obc)
        throws NoSuchException, SystemException {
        PmlFilePCCC pmlFilePCCC = findByPrimaryKey(fileId);

        int count = countByReceiveOfUnit(receiveOfUnit);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

            if (receiveOfUnit == null) {
                query.append("receiveofunit IS NULL");
            } else {
                query.append("receiveofunit = ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileid DESC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (receiveOfUnit != null) {
                qPos.add(receiveOfUnit);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFilePCCC);

            PmlFilePCCC[] array = new PmlFilePCCCImpl[3];

            array[0] = (PmlFilePCCC) objArray[0];
            array[1] = (PmlFilePCCC) objArray[1];
            array[2] = (PmlFilePCCC) objArray[2];

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

    public List<PmlFilePCCC> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFilePCCC> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFilePCCC> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileid DESC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlFilePCCC> list = (List<PmlFilePCCC>) QueryUtil.list(q,
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
            return (List<PmlFilePCCC>) result;
        }
    }

    public void removeByFileName(String fileName) throws SystemException {
        for (PmlFilePCCC pmlFilePCCC : findByFileName(fileName)) {
            remove(pmlFilePCCC);
        }
    }

    public void removeByProjectName(String projectName)
        throws SystemException {
        for (PmlFilePCCC pmlFilePCCC : findByProjectName(projectName)) {
            remove(pmlFilePCCC);
        }
    }

    public void removeByApplicantCategory(String applicantCategory)
        throws SystemException {
        for (PmlFilePCCC pmlFilePCCC : findByApplicantCategory(
                applicantCategory)) {
            remove(pmlFilePCCC);
        }
    }

    public void removeByReceiveOfUnit(String receiveOfUnit)
        throws SystemException {
        for (PmlFilePCCC pmlFilePCCC : findByReceiveOfUnit(receiveOfUnit)) {
            remove(pmlFilePCCC);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFilePCCC pmlFilePCCC : findAll()) {
            remove(pmlFilePCCC);
        }
    }

    public int countByFileName(String fileName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
        String finderMethodName = "countByFileName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileName };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

                if (fileName == null) {
                    query.append("fileName IS NULL");
                } else {
                    query.append("fileName = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileName != null) {
                    qPos.add(fileName);
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

    public int countByProjectName(String projectName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
        String finderMethodName = "countByProjectName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { projectName };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

                if (projectName == null) {
                    query.append("projectname IS NULL");
                } else {
                    query.append("projectname = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (projectName != null) {
                    qPos.add(projectName);
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

    public int countByApplicantCategory(String applicantCategory)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
        String finderMethodName = "countByApplicantCategory";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { applicantCategory };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

                if (applicantCategory == null) {
                    query.append("applicantcategory IS NULL");
                } else {
                    query.append("applicantcategory = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (applicantCategory != null) {
                    qPos.add(applicantCategory);
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

    public int countByReceiveOfUnit(String receiveOfUnit)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
        String finderMethodName = "countByReceiveOfUnit";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { receiveOfUnit };

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
                    "FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC WHERE ");

                if (receiveOfUnit == null) {
                    query.append("receiveofunit IS NULL");
                } else {
                    query.append("receiveofunit = ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiveOfUnit != null) {
                    qPos.add(receiveOfUnit);
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
        boolean finderClassNameCacheEnabled = PmlFilePCCCModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFilePCCC.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.onedoorpccc.model.PmlFilePCCC");

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
                        "value.object.listener.com.sgs.portlet.onedoorpccc.model.PmlFilePCCC")));

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
