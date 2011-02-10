package com.sgs.portlet.filetype.service.persistence;

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

import com.sgs.portlet.filetype.NoSuchPmlFileTypeException;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.model.impl.PmlFileTypeImpl;
import com.sgs.portlet.filetype.model.impl.PmlFileTypeModelImpl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class PmlFileTypePersistenceImpl extends BasePersistenceImpl
    implements PmlFileTypePersistence {
    private static Log _log = LogFactory.getLog(PmlFileTypePersistenceImpl.class);
    private ModelListener[] _listeners = new ModelListener[0];

    public PmlFileType create(String fileTypeId) {
        PmlFileType pmlFileType = new PmlFileTypeImpl();

        pmlFileType.setNew(true);
        pmlFileType.setPrimaryKey(fileTypeId);

        return pmlFileType;
    }

    public PmlFileType remove(String fileTypeId)
        throws NoSuchPmlFileTypeException, SystemException {
        Session session = null;

        try {
            session = openSession();

            PmlFileType pmlFileType = (PmlFileType) session.get(PmlFileTypeImpl.class,
                    fileTypeId);

            if (pmlFileType == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn("No PmlFileType exists with the primary key " +
                        fileTypeId);
                }

                throw new NoSuchPmlFileTypeException(
                    "No PmlFileType exists with the primary key " + fileTypeId);
            }

            return remove(pmlFileType);
        } catch (NoSuchPmlFileTypeException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public PmlFileType remove(PmlFileType pmlFileType)
        throws SystemException {
        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onBeforeRemove(pmlFileType);
            }
        }

        pmlFileType = removeImpl(pmlFileType);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                listener.onAfterRemove(pmlFileType);
            }
        }

        return pmlFileType;
    }

    protected PmlFileType removeImpl(PmlFileType pmlFileType)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            session.delete(pmlFileType);

            session.flush();

            return pmlFileType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileType.class.getName());
        }
    }

    /**
     * @deprecated Use <code>update(PmlFileType pmlFileType, boolean merge)</code>.
     */
    public PmlFileType update(PmlFileType pmlFileType)
        throws SystemException {
        if (_log.isWarnEnabled()) {
            _log.warn(
                "Using the deprecated update(PmlFileType pmlFileType) method. Use update(PmlFileType pmlFileType, boolean merge) instead.");
        }

        return update(pmlFileType, false);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public PmlFileType update(PmlFileType pmlFileType, boolean merge)
        throws SystemException {
        boolean isNew = pmlFileType.isNew();

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onBeforeCreate(pmlFileType);
                } else {
                    listener.onBeforeUpdate(pmlFileType);
                }
            }
        }

        pmlFileType = updateImpl(pmlFileType, merge);

        if (_listeners.length > 0) {
            for (ModelListener listener : _listeners) {
                if (isNew) {
                    listener.onAfterCreate(pmlFileType);
                } else {
                    listener.onAfterUpdate(pmlFileType);
                }
            }
        }

        return pmlFileType;
    }

    public PmlFileType updateImpl(
        com.sgs.portlet.filetype.model.PmlFileType pmlFileType, boolean merge)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            if (merge) {
                session.merge(pmlFileType);
            } else {
                if (pmlFileType.isNew()) {
                    session.save(pmlFileType);
                }
            }

            session.flush();

            pmlFileType.setNew(false);

            return pmlFileType;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);

            FinderCacheUtil.clearCache(PmlFileType.class.getName());
        }
    }

    public PmlFileType findByPrimaryKey(String fileTypeId)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = fetchByPrimaryKey(fileTypeId);

        if (pmlFileType == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("No PmlFileType exists with the primary key " +
                    fileTypeId);
            }

            throw new NoSuchPmlFileTypeException(
                "No PmlFileType exists with the primary key " + fileTypeId);
        }

        return pmlFileType;
    }

    public PmlFileType fetchByPrimaryKey(String fileTypeId)
        throws SystemException {
        Session session = null;

        try {
            session = openSession();

            return (PmlFileType) session.get(PmlFileTypeImpl.class, fileTypeId);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileType> findByFileTypeCode(String fileTypeCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "findByFileTypeCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileTypeCode };

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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeCode == null) {
                    query.append("fileTypeCode LIKE null");
                } else {
                    query.append("lower(fileTypeCode) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileTypeName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeCode != null) {
                    qPos.add(fileTypeCode);
                }

                List<PmlFileType> list = q.list();

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
            return (List<PmlFileType>) result;
        }
    }

    public List<PmlFileType> findByFileTypeCode(String fileTypeCode, int start,
        int end) throws SystemException {
        return findByFileTypeCode(fileTypeCode, start, end, null);
    }

    public List<PmlFileType> findByFileTypeCode(String fileTypeCode, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "findByFileTypeCode";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileTypeCode,
                
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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeCode == null) {
                    query.append("fileTypeCode LIKE null");
                } else {
                    query.append("lower(fileTypeCode) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeCode != null) {
                    qPos.add(fileTypeCode);
                }

                List<PmlFileType> list = (List<PmlFileType>) QueryUtil.list(q,
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
            return (List<PmlFileType>) result;
        }
    }

    public PmlFileType findByFileTypeCode_First(String fileTypeCode,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        List<PmlFileType> list = findByFileTypeCode(fileTypeCode, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fileTypeCode=" + fileTypeCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType findByFileTypeCode_Last(String fileTypeCode,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        int count = countByFileTypeCode(fileTypeCode);

        List<PmlFileType> list = findByFileTypeCode(fileTypeCode, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fileTypeCode=" + fileTypeCode);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType[] findByFileTypeCode_PrevAndNext(String fileTypeId,
        String fileTypeCode, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = findByPrimaryKey(fileTypeId);

        int count = countByFileTypeCode(fileTypeCode);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

            if (fileTypeCode == null) {
                query.append("fileTypeCode LIKE null");
            } else {
                query.append("lower(fileTypeCode) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileTypeName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeCode != null) {
                qPos.add(fileTypeCode);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileType);

            PmlFileType[] array = new PmlFileTypeImpl[3];

            array[0] = (PmlFileType) objArray[0];
            array[1] = (PmlFileType) objArray[1];
            array[2] = (PmlFileType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileType> findByFileTypeName(String fileTypeName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "findByFileTypeName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileTypeName };

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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeName == null) {
                    query.append("fileTypeName LIKE null");
                } else {
                    query.append("lower(fileTypeName) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileTypeName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeName != null) {
                    qPos.add(fileTypeName);
                }

                List<PmlFileType> list = q.list();

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
            return (List<PmlFileType>) result;
        }
    }

    public List<PmlFileType> findByFileTypeName(String fileTypeName, int start,
        int end) throws SystemException {
        return findByFileTypeName(fileTypeName, start, end, null);
    }

    public List<PmlFileType> findByFileTypeName(String fileTypeName, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "findByFileTypeName";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileTypeName,
                
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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeName == null) {
                    query.append("fileTypeName LIKE null");
                } else {
                    query.append("lower(fileTypeName) LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeName != null) {
                    qPos.add(fileTypeName);
                }

                List<PmlFileType> list = (List<PmlFileType>) QueryUtil.list(q,
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
            return (List<PmlFileType>) result;
        }
    }

    public PmlFileType findByFileTypeName_First(String fileTypeName,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        List<PmlFileType> list = findByFileTypeName(fileTypeName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fileTypeName=" + fileTypeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType findByFileTypeName_Last(String fileTypeName,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        int count = countByFileTypeName(fileTypeName);

        List<PmlFileType> list = findByFileTypeName(fileTypeName, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fileTypeName=" + fileTypeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType[] findByFileTypeName_PrevAndNext(String fileTypeId,
        String fileTypeName, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = findByPrimaryKey(fileTypeId);

        int count = countByFileTypeName(fileTypeName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

            if (fileTypeName == null) {
                query.append("fileTypeName LIKE null");
            } else {
                query.append("lower(fileTypeName) LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileTypeName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeName != null) {
                qPos.add(fileTypeName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileType);

            PmlFileType[] array = new PmlFileTypeImpl[3];

            array[0] = (PmlFileType) objArray[0];
            array[1] = (PmlFileType) objArray[1];
            array[2] = (PmlFileType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileType> findByDescription(String description)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (description == null) {
                    query.append("description LIKE null");
                } else {
                    query.append("lower(description) LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileTypeName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<PmlFileType> list = q.list();

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
            return (List<PmlFileType>) result;
        }
    }

    public List<PmlFileType> findByDescription(String description, int start,
        int end) throws SystemException {
        return findByDescription(description, start, end, null);
    }

    public List<PmlFileType> findByDescription(String description, int start,
        int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

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

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (description != null) {
                    qPos.add(description);
                }

                List<PmlFileType> list = (List<PmlFileType>) QueryUtil.list(q,
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
            return (List<PmlFileType>) result;
        }
    }

    public PmlFileType findByDescription_First(String description,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        List<PmlFileType> list = findByDescription(description, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType findByDescription_Last(String description,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        int count = countByDescription(description);

        List<PmlFileType> list = findByDescription(description, count - 1,
                count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("description=" + description);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType[] findByDescription_PrevAndNext(String fileTypeId,
        String description, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = findByPrimaryKey(fileTypeId);

        int count = countByDescription(description);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

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

                query.append("fileTypeName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (description != null) {
                qPos.add(description);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileType);

            PmlFileType[] array = new PmlFileTypeImpl[3];

            array[0] = (PmlFileType) objArray[0];
            array[1] = (PmlFileType) objArray[1];
            array[2] = (PmlFileType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileType> findByFieldId(String fieldId)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "findByFieldId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fieldId };

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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (fieldId == null) {
                    query.append("fieldId LIKE null");
                } else {
                    query.append("fieldId LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileTypeName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldId != null) {
                    qPos.add(fieldId);
                }

                List<PmlFileType> list = q.list();

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
            return (List<PmlFileType>) result;
        }
    }

    public List<PmlFileType> findByFieldId(String fieldId, int start, int end)
        throws SystemException {
        return findByFieldId(fieldId, start, end, null);
    }

    public List<PmlFileType> findByFieldId(String fieldId, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "findByFieldId";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fieldId,
                
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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (fieldId == null) {
                    query.append("fieldId LIKE null");
                } else {
                    query.append("fieldId LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldId != null) {
                    qPos.add(fieldId);
                }

                List<PmlFileType> list = (List<PmlFileType>) QueryUtil.list(q,
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
            return (List<PmlFileType>) result;
        }
    }

    public PmlFileType findByFieldId_First(String fieldId, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        List<PmlFileType> list = findByFieldId(fieldId, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fieldId=" + fieldId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType findByFieldId_Last(String fieldId, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        int count = countByFieldId(fieldId);

        List<PmlFileType> list = findByFieldId(fieldId, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fieldId=" + fieldId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType[] findByFieldId_PrevAndNext(String fileTypeId,
        String fieldId, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = findByPrimaryKey(fileTypeId);

        int count = countByFieldId(fieldId);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

            if (fieldId == null) {
                query.append("fieldId LIKE null");
            } else {
                query.append("fieldId LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileTypeName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fieldId != null) {
                qPos.add(fieldId);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileType);

            PmlFileType[] array = new PmlFileTypeImpl[3];

            array[0] = (PmlFileType) objArray[0];
            array[1] = (PmlFileType) objArray[1];
            array[2] = (PmlFileType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileType> findByReceiptTemplate(String receiptTemplate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "findByReceiptTemplate";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { receiptTemplate };

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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (receiptTemplate == null) {
                    query.append("receiptTemplate LIKE null");
                } else {
                    query.append("receiptTemplate LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileTypeName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiptTemplate != null) {
                    qPos.add(receiptTemplate);
                }

                List<PmlFileType> list = q.list();

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
            return (List<PmlFileType>) result;
        }
    }

    public List<PmlFileType> findByReceiptTemplate(String receiptTemplate,
        int start, int end) throws SystemException {
        return findByReceiptTemplate(receiptTemplate, start, end, null);
    }

    public List<PmlFileType> findByReceiptTemplate(String receiptTemplate,
        int start, int end, OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "findByReceiptTemplate";
        String[] finderParams = new String[] {
                String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                receiptTemplate,
                
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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (receiptTemplate == null) {
                    query.append("receiptTemplate LIKE null");
                } else {
                    query.append("receiptTemplate LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiptTemplate != null) {
                    qPos.add(receiptTemplate);
                }

                List<PmlFileType> list = (List<PmlFileType>) QueryUtil.list(q,
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
            return (List<PmlFileType>) result;
        }
    }

    public PmlFileType findByReceiptTemplate_First(String receiptTemplate,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        List<PmlFileType> list = findByReceiptTemplate(receiptTemplate, 0, 1,
                obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("receiptTemplate=" + receiptTemplate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType findByReceiptTemplate_Last(String receiptTemplate,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        int count = countByReceiptTemplate(receiptTemplate);

        List<PmlFileType> list = findByReceiptTemplate(receiptTemplate,
                count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("receiptTemplate=" + receiptTemplate);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType[] findByReceiptTemplate_PrevAndNext(String fileTypeId,
        String receiptTemplate, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = findByPrimaryKey(fileTypeId);

        int count = countByReceiptTemplate(receiptTemplate);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

            if (receiptTemplate == null) {
                query.append("receiptTemplate LIKE null");
            } else {
                query.append("receiptTemplate LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileTypeName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (receiptTemplate != null) {
                qPos.add(receiptTemplate);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileType);

            PmlFileType[] array = new PmlFileTypeImpl[3];

            array[0] = (PmlFileType) objArray[0];
            array[1] = (PmlFileType) objArray[1];
            array[2] = (PmlFileType) objArray[2];

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    public List<PmlFileType> findByFileTypeCode_FileTypeName(
        String fileTypeCode, String fileTypeName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "findByFileTypeCode_FileTypeName";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeCode, fileTypeName };

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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeCode == null) {
                    query.append("fileTypeCode LIKE null");
                } else {
                    query.append("fileTypeCode LIKE ?");
                }

                query.append(" AND ");

                if (fileTypeName == null) {
                    query.append("fileTypeName LIKE null");
                } else {
                    query.append("fileTypeName LIKE ?");
                }

                query.append(" ");

                query.append("ORDER BY ");

                query.append("fileTypeName ASC");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeCode != null) {
                    qPos.add(fileTypeCode);
                }

                if (fileTypeName != null) {
                    qPos.add(fileTypeName);
                }

                List<PmlFileType> list = q.list();

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
            return (List<PmlFileType>) result;
        }
    }

    public List<PmlFileType> findByFileTypeCode_FileTypeName(
        String fileTypeCode, String fileTypeName, int start, int end)
        throws SystemException {
        return findByFileTypeCode_FileTypeName(fileTypeCode, fileTypeName,
            start, end, null);
    }

    public List<PmlFileType> findByFileTypeCode_FileTypeName(
        String fileTypeCode, String fileTypeName, int start, int end,
        OrderByComparator obc) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "findByFileTypeCode_FileTypeName";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName(),
                
                "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };
        Object[] finderArgs = new Object[] {
                fileTypeCode,
                
                fileTypeName,
                
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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeCode == null) {
                    query.append("fileTypeCode LIKE null");
                } else {
                    query.append("fileTypeCode LIKE ?");
                }

                query.append(" AND ");

                if (fileTypeName == null) {
                    query.append("fileTypeName LIKE null");
                } else {
                    query.append("fileTypeName LIKE ?");
                }

                query.append(" ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeCode != null) {
                    qPos.add(fileTypeCode);
                }

                if (fileTypeName != null) {
                    qPos.add(fileTypeName);
                }

                List<PmlFileType> list = (List<PmlFileType>) QueryUtil.list(q,
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
            return (List<PmlFileType>) result;
        }
    }

    public PmlFileType findByFileTypeCode_FileTypeName_First(
        String fileTypeCode, String fileTypeName, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        List<PmlFileType> list = findByFileTypeCode_FileTypeName(fileTypeCode,
                fileTypeName, 0, 1, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fileTypeCode=" + fileTypeCode);

            msg.append(", ");
            msg.append("fileTypeName=" + fileTypeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType findByFileTypeCode_FileTypeName_Last(
        String fileTypeCode, String fileTypeName, OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        int count = countByFileTypeCode_FileTypeName(fileTypeCode, fileTypeName);

        List<PmlFileType> list = findByFileTypeCode_FileTypeName(fileTypeCode,
                fileTypeName, count - 1, count, obc);

        if (list.size() == 0) {
            StringBuilder msg = new StringBuilder();

            msg.append("No PmlFileType exists with the key {");

            msg.append("fileTypeCode=" + fileTypeCode);

            msg.append(", ");
            msg.append("fileTypeName=" + fileTypeName);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchPmlFileTypeException(msg.toString());
        } else {
            return list.get(0);
        }
    }

    public PmlFileType[] findByFileTypeCode_FileTypeName_PrevAndNext(
        String fileTypeId, String fileTypeCode, String fileTypeName,
        OrderByComparator obc)
        throws NoSuchPmlFileTypeException, SystemException {
        PmlFileType pmlFileType = findByPrimaryKey(fileTypeId);

        int count = countByFileTypeCode_FileTypeName(fileTypeCode, fileTypeName);

        Session session = null;

        try {
            session = openSession();

            StringBuilder query = new StringBuilder();

            query.append(
                "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

            if (fileTypeCode == null) {
                query.append("fileTypeCode LIKE null");
            } else {
                query.append("fileTypeCode LIKE ?");
            }

            query.append(" AND ");

            if (fileTypeName == null) {
                query.append("fileTypeName LIKE null");
            } else {
                query.append("fileTypeName LIKE ?");
            }

            query.append(" ");

            if (obc != null) {
                query.append("ORDER BY ");
                query.append(obc.getOrderBy());
            }
            else {
                query.append("ORDER BY ");

                query.append("fileTypeName ASC");
            }

            Query q = session.createQuery(query.toString());

            QueryPos qPos = QueryPos.getInstance(q);

            if (fileTypeCode != null) {
                qPos.add(fileTypeCode);
            }

            if (fileTypeName != null) {
                qPos.add(fileTypeName);
            }

            Object[] objArray = QueryUtil.getPrevAndNext(q, count, obc,
                    pmlFileType);

            PmlFileType[] array = new PmlFileTypeImpl[3];

            array[0] = (PmlFileType) objArray[0];
            array[1] = (PmlFileType) objArray[1];
            array[2] = (PmlFileType) objArray[2];

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

    public List<PmlFileType> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    public List<PmlFileType> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    public List<PmlFileType> findAll(int start, int end, OrderByComparator obc)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
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

                query.append("FROM com.sgs.portlet.filetype.model.PmlFileType ");

                if (obc != null) {
                    query.append("ORDER BY ");
                    query.append(obc.getOrderBy());
                }
                else {
                    query.append("ORDER BY ");

                    query.append("fileTypeName ASC");
                }

                Query q = session.createQuery(query.toString());

                List<PmlFileType> list = (List<PmlFileType>) QueryUtil.list(q,
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
            return (List<PmlFileType>) result;
        }
    }

    public void removeByFileTypeCode(String fileTypeCode)
        throws SystemException {
        for (PmlFileType pmlFileType : findByFileTypeCode(fileTypeCode)) {
            remove(pmlFileType);
        }
    }

    public void removeByFileTypeName(String fileTypeName)
        throws SystemException {
        for (PmlFileType pmlFileType : findByFileTypeName(fileTypeName)) {
            remove(pmlFileType);
        }
    }

    public void removeByDescription(String description)
        throws SystemException {
        for (PmlFileType pmlFileType : findByDescription(description)) {
            remove(pmlFileType);
        }
    }

    public void removeByFieldId(String fieldId) throws SystemException {
        for (PmlFileType pmlFileType : findByFieldId(fieldId)) {
            remove(pmlFileType);
        }
    }

    public void removeByReceiptTemplate(String receiptTemplate)
        throws SystemException {
        for (PmlFileType pmlFileType : findByReceiptTemplate(receiptTemplate)) {
            remove(pmlFileType);
        }
    }

    public void removeByFileTypeCode_FileTypeName(String fileTypeCode,
        String fileTypeName) throws SystemException {
        for (PmlFileType pmlFileType : findByFileTypeCode_FileTypeName(
                fileTypeCode, fileTypeName)) {
            remove(pmlFileType);
        }
    }

    public void removeAll() throws SystemException {
        for (PmlFileType pmlFileType : findAll()) {
            remove(pmlFileType);
        }
    }

    public int countByFileTypeCode(String fileTypeCode)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "countByFileTypeCode";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileTypeCode };

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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeCode == null) {
                    query.append("fileTypeCode LIKE null");
                } else {
                    query.append("lower(fileTypeCode) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeCode != null) {
                    qPos.add(fileTypeCode);
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

    public int countByFileTypeName(String fileTypeName)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "countByFileTypeName";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fileTypeName };

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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeName == null) {
                    query.append("fileTypeName LIKE null");
                } else {
                    query.append("lower(fileTypeName) LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeName != null) {
                    qPos.add(fileTypeName);
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
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

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

    public int countByFieldId(String fieldId) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "countByFieldId";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { fieldId };

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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (fieldId == null) {
                    query.append("fieldId LIKE null");
                } else {
                    query.append("fieldId LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fieldId != null) {
                    qPos.add(fieldId);
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

    public int countByReceiptTemplate(String receiptTemplate)
        throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "countByReceiptTemplate";
        String[] finderParams = new String[] { String.class.getName() };
        Object[] finderArgs = new Object[] { receiptTemplate };

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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (receiptTemplate == null) {
                    query.append("receiptTemplate LIKE null");
                } else {
                    query.append("receiptTemplate LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (receiptTemplate != null) {
                    qPos.add(receiptTemplate);
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

    public int countByFileTypeCode_FileTypeName(String fileTypeCode,
        String fileTypeName) throws SystemException {
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
        String finderMethodName = "countByFileTypeCode_FileTypeName";
        String[] finderParams = new String[] {
                String.class.getName(), String.class.getName()
            };
        Object[] finderArgs = new Object[] { fileTypeCode, fileTypeName };

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
                    "FROM com.sgs.portlet.filetype.model.PmlFileType WHERE ");

                if (fileTypeCode == null) {
                    query.append("fileTypeCode LIKE null");
                } else {
                    query.append("fileTypeCode LIKE ?");
                }

                query.append(" AND ");

                if (fileTypeName == null) {
                    query.append("fileTypeName LIKE null");
                } else {
                    query.append("fileTypeName LIKE ?");
                }

                query.append(" ");

                Query q = session.createQuery(query.toString());

                QueryPos qPos = QueryPos.getInstance(q);

                if (fileTypeCode != null) {
                    qPos.add(fileTypeCode);
                }

                if (fileTypeName != null) {
                    qPos.add(fileTypeName);
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
        boolean finderClassNameCacheEnabled = PmlFileTypeModelImpl.CACHE_ENABLED;
        String finderClassName = PmlFileType.class.getName();
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
                        "SELECT COUNT(*) FROM com.sgs.portlet.filetype.model.PmlFileType");

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
                        "value.object.listener.com.sgs.portlet.filetype.model.PmlFileType")));

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
